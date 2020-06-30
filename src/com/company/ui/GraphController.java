package com.company.ui;

import com.company.core.Dot;
import com.company.core.DotsGenerator;
import com.company.core.Function;
import com.company.core.Handler;
import com.company.core.approximation.ApproximationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {
    @FXML
    private LineChart<Double, Double> chart;
    private Graph graph;
    @FXML
    private ChoiceBox<ApproximationType> approximationType;
    @FXML
    private TextField numberOfDots;
    @FXML
    private TextField x;
    @FXML
    private TextField y;
    @FXML
    private Label error;
    @FXML
    private Label coef1;
    @FXML
    private Label coef2;


    Handler handler = Handler.getHandler();

    public void clear(){
        handler.clearDotsList();
        graph.clear();
    }

    public double getX(){
        try {
            return Double.parseDouble(x.getText());
        }catch (NumberFormatException e){
            setErrorLine("неверное значение для x");
            throw new NumberFormatException();
        }
    }
    public double getY(){
        try {
            return Double.parseDouble(y.getText());
        }catch (NumberFormatException e){
            setErrorLine("неверное значение для y");
            throw new NumberFormatException();
        }
    }
    public int getNumberOfDots(){
        try {
            return Integer.parseInt(numberOfDots.getText());
        }catch (NumberFormatException e){
            setErrorLine("неверное значение для n");
            throw new NumberFormatException();
        }
    }
    public void addDot(){
        setErrorLine("");
        Dot dot = new Dot(getX(), getY());
        drawDot(dot, true);
        handler.addDot(dot);
    }
    public void generateDots() {
        setErrorLine("");
        handler.clearDotsList();
        DotsGenerator generator = new DotsGenerator(approximationType.getValue());
        for(int i=0; i<getNumberOfDots(); i++){
            Dot dot = generator.generateDot();
            drawDot(dot, true);
            handler.addDot(dot);
        }

    }

    public void drawGraph() {
        Function f1 = handler.getFunction(approximationType.getValue());
        graph.drawGraph(f1);
        setCoef1(f1.coef(), coef1);
        Dot dot = handler.deleteExtra(handler.getFunction(approximationType.getValue()));
        drawDot(dot, false);
        Function f2 = handler.getFunction(approximationType.getValue());
        graph.drawGraph(f2);
        setCoef1(f1.coef(), coef2);
    }
    private void drawDot(Dot dot, boolean isCount){
        final XYChart.Series<Double, Double> series = new XYChart.Series<>();
        graph.drawDot(dot.getX(), dot.getY(), series, isCount);
    }

    private void setErrorLine(String str){
        error.setText(str);
    }

    private void setCoef1(String function, Label coef){
        coef.setText(function);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<ApproximationType> typeList
                = FXCollections.observableArrayList(
                ApproximationType.LINEAR,
                ApproximationType.QUADRATIC,
                ApproximationType.EXPONENTIAL
        );
        approximationType.setItems(typeList);
        approximationType.setValue(ApproximationType.LINEAR);

        graph = new Graph(chart);
    }
}
