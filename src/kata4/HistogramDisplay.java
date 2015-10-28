package kata4;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram <String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    private ChartPanel createPanel(){
        ChartPanel chartPanel= new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 450));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                null,
                "DOMINIOS",
                "Nº Emails", 
                dataset, 
                PlotOrientation.VERTICAL,
                false, false, false);
        return chart;
    }
    
    
    private DefaultCategoryDataset createDataSet(){
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (Object key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key.toString());
        }
         return dataSet;
    }
    
     public void execute(){
        setVisible(true);
    }
    
}
