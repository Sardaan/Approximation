package com.company.ui;

import com.company.core.Function;
import com.company.core.Handler;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;

import java.awt.*;


public class Graph {
    private XYChart<Double, Double> graph;

    public Graph(final XYChart<Double, Double> graph) {
        this.graph = graph;
    }

    public void clear(){
        graph.getData().clear();
    }
    Handler handler = Handler.getHandler();

    public void drawDot(double x, double y, XYChart.Series<Double, Double> series, boolean isCount){
        series.getData().add(new XYChart.Data<>(x,y));
        graph.getData().add(series);
        XYChart.Data dataPoint = series.getData().get(0);
        Node lineSymbol = dataPoint.getNode().lookup(".chart-line-symbol");
        if (isCount) {
            lineSymbol.setStyle("-fx-background-color: cornflowerblue;");
        } else {
            lineSymbol.setStyle("-fx-background-color: salmon;");
        }

    }
    public void drawLine(double x, double y,  XYChart.Series<Double, Double> series){
        series.getData().add(new XYChart.Data<>(x,y));
    }
    public void drawGraph(Function function){
        final XYChart.Series<Double, Double> series = new XYChart.Series<>();
        for (double x = -25; x <= 55; x += 0.1) {
            drawLine(x, function.get(x), series);
        }
        graph.getData().add(series);

        for(int i = 0; i<series.getData().size(); i++){
            XYChart.Data dataPoint = series.getData().get(i);
            Node lineSymbol = dataPoint.getNode().lookup(".chart-line-symbol");
            lineSymbol.setStyle("-fx-background-radius: 0;-fx-padding: 0px;");

        }


    }
}
