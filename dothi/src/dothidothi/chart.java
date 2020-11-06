package dothidothi;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demo showing the use of log axes.
 *
 */
public class chart extends ApplicationFrame {

	public List<Obj> listObj=new ArrayList<Obj>();
	public List<Integer> listMedoid=new ArrayList<Integer>();
	private List<XYSeries> lstS=new ArrayList<XYSeries>();
	private int k;
	Map<Integer, Paint> colorMap=new HashMap();
	
    public chart(List<Obj> listObj, List<Integer> listMedoid) {

        super("K-Medoids");
        colorMap.put(0, Color.red);
    	colorMap.put(1, Color.green);
    	colorMap.put(2, Color.yellow);
    	colorMap.put(3,Color.cyan);
    	this.listObj=listObj;
    	this.listMedoid=listMedoid;
    	for(int i: listMedoid) {
    		XYSeries s=new XYSeries("C"+listMedoid.indexOf(i)+"("+listObj.get(i).getxValue()+";"+listObj.get(i).getyValue()+")");
    		for(Obj obj:listObj) {
            	if(obj.getMedoid().equals(listObj.get(i)))
            	{
                    s.add(obj.getxValue(), obj.getyValue());
            	}
            }
    		lstS.add(s);
    	}

        final XYSeriesCollection dataset = new XYSeriesCollection();
        for(XYSeries s:lstS) {
        	dataset.addSeries(s);
        }
//        dataset.addSeries(s3);

        final JFreeChart chart = ChartFactory.createXYLineChart(
            "K-Medoids",          // chart title
            "X",               // domain axis label
            "Y",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,
            true
        );

        final XYPlot plot = chart.getXYPlot();
        chart.setBackgroundPaint(Color.white);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(false,true);
        // SetColor
//        for(int i=0;i<lstS.size();i++) {
//        	renderer.setSeriesPaint(i, colorMap.get(i));
//            	
//        }
        renderer.setSeriesStroke(0, new BasicStroke(0), true);
        renderer.setSeriesStroke(1, new BasicStroke(0.0f));
       
        plot.setRenderer(renderer);
        
        plot.setOutlinePaint(Color.black);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(700	, 700));
        setContentPane(chartPanel);
        pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
//     */
//    public static void main(final String[] args) {
//
//        final chart demo = new chart();
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }

}