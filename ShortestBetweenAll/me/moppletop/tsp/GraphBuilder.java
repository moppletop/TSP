package me.moppletop.tsp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphBuilder extends JPanel {

	/*
	 * This class handles the creation of the graph that is displayed to the
	 * user after the locations has been sorted.
	 */

	// Setup all the constants.
	private static final int MAX_SCORE = 100;
	private static final int PREF_W = 800;
	private static final int PREF_H = 650;
	private static final int BORDER_GAP = 30;
	private static final Color GRAPH_COLOR = Color.green;
	private static final Color GRAPH_POINT_COLOR = Color.red;
	private static final Stroke GRAPH_STROKE = new BasicStroke(2F);
	private static final int GRAPH_POINT_WIDTH = 12;

	private List<Location> locs;

	// Parse in the locations
	public GraphBuilder(List<Location> locs) {
		this.locs = locs;
	}

	// Override the paintComponent method inside JPanel, so that we can replace
	// its code with ours.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		double scale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < locs.size(); i++) {
			int x1 = (int) ((MAX_SCORE - locs.get(i).getX()) * scale + BORDER_GAP);
			int y1 = (int) ((MAX_SCORE - locs.get(i).getY()) * scale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		// Setup and axis
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

		Stroke oldStroke = g2.getStroke();
		g2.setColor(GRAPH_COLOR);
		g2.setStroke(GRAPH_STROKE);
		
		// Build the lines between all the points.
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(Color.orange);
		// Place all the points on the graph and colour them.
		// Orange is used to show the starting location.
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
			g2.setColor(GRAPH_POINT_COLOR);
		}
	}

	// Sets our dimensions.
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	// Calling this will create the graph and display it.
	public static void createAndShowGui(List<Location> locs) {
		GraphBuilder mainPanel = new GraphBuilder(locs);

		JFrame frame = new JFrame("GraphBuilder - TSP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}