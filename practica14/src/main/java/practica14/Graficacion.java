package practica14;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.SwingWrapper;
import practica14.LectorCSV;
import java.util.List;
import java.io.IOException;

public class Graficacion {

    public static void main(String[] args) {
        XYChart chart = new XYChartBuilder()
                            .title("Regresión lineal")
                            .width(800)
                            .height(600)
                            .xAxisTitle("X")
                            .yAxisTitle("Y")
                            .theme(ChartTheme.Matlab)
                            .build();

        chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY));
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
        chart.getStyler().setPlotGridLinesVisible(false);
        chart.getStyler().setMarkerSize(6);

        /*double[] xData = {
            18.9, 19.0, 19.1, 19.200000000000003, 19.3, 19.4, 19.5, 19.6, 19.700000000000003, 19.8,
            19.9, 20.0, 20.1, 20.200000000000003, 20.3, 20.4, 20.5, 20.6, 20.700000000000003, 20.8,
            20.9};
        double[] yData = {
            86.40610837642784, 83.37448897179846, 86.56154350293059, 87.65809329579216,
            86.02472987061864, 86.001793060768, 88.11165222325307, 87.17772191929602,
            86.9516860927733, 86.38851266393492, 87.78827482434914, 88.09415959933646,
            88.52744410606394, 88.70236347227599, 90.8435430169986, 89.64180808163006,
            89.17187870717119, 93.38116658661869, 91.44624618688697, 91.97093296325215,
            92.54215624918812};*/

            List<String[]> lector = null;
            double[] xData = null;
            double[] yData = null;
      try {
         lector = LectorCSV.leer("src/main/resources/317150700.csv");
         xData = new double[lector.size()];
         yData = new double[lector.size()];
          int n = 0;
          for (String[] i : lector) {
              xData[n] = Double.parseDouble(i[0]);
              yData[n] = Double.parseDouble(i[1]);
              n++;
           }
        } catch(IOException e){
           e.printStackTrace();
        }

        double m = 4;
        double b = 9;

        XYSeries sampleSeries = chart.addSeries("Observaciones", xData, yData);
        sampleSeries.setXYSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
        sampleSeries.setMarkerColor(XChartSeriesColors.RED);

        XYSeries lineSeries = chart.addSeries(
            "Línea", new double[]{xData[0], yData[0]}, new double[]{xData[lector.size()], yData[lector.size()]});
        lineSeries.setXYSeriesRenderStyle(XYSeriesRenderStyle.Line);
        lineSeries.setLineColor(XChartSeriesColors.BLUE);
        lineSeries.setLineWidth(3);

        new SwingWrapper<XYChart>(chart).displayChart();
    }

}
