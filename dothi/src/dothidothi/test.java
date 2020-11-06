package dothidothi;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test extends JFrame {
	public List<Obj> listObj=new ArrayList<Obj>();
	public List<Integer> listMedoid=new ArrayList<Integer>();
	private int k;
	Map<Integer, Paint> colorMap=new HashMap();
	

    public test(List<Obj> listObj, List<Integer> listMedoid) {
    	colorMap.put(0, Color.red);
    	colorMap.put(1, Color.green);
    	colorMap.put(2, Color.yellow);
    	colorMap.put(3,Color.cyan);
    	this.listObj=listObj;
    	this.listMedoid=listMedoid;
        initUI();
    }

    private void initUI() {
    	XYPlot plot=new XYPlot();
    	JFrame f=new JFrame();
    	//JFreeChart chart;
    	//ChartFrame frame;
		for (int i : listMedoid) {

			XYDataset dataset = createDataset(i);
			JFreeChart chart = ChartFactory.createXYLineChart(
	                "ABC",
	                "x",
	                "y",
	                dataset,
	                PlotOrientation.VERTICAL,
	                true,
	                true,
	                false
	        );
	        plot = chart.getXYPlot();
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        plot.setDataset(
                    listMedoid.indexOf(i), dataset
                );
	        
	        plot.setRenderer(listMedoid.indexOf(i), new  XYLineAndShapeRenderer());
			//chart = createChart(dataset, colorMap.get(listMedoid.indexOf(i)));
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
			chartPanel.setBackground(Color.white);
			add(chartPanel);

			pack();
		}
    	//pack();
        setTitle("K-Medoids A");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(int i) {

        XYSeries series = new XYSeries("Cụm "+listMedoid.indexOf(i));
        for(Obj obj:listObj) {
        	if(obj.getMedoid().equals(listObj.get(i)))
        	{
                series.add(obj.getxValue(), obj.getyValue());
        	}
        }
//        series.add(7, 4);
//        series.add(6, 2);
//        series.add(7, 3);
//        series.add(7, 4);
//        series.add(8, 5);
//        series.add(7, 6);
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset, Paint color) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "ABC",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, color);
        renderer.setSeriesStroke(0, new BasicStroke(0), true);

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("TỌA ĐỘ",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(() -> {
//
//            test ex = new test();
//            ex.setVisible(true);
//        });
//    }
}