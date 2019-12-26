
package org.cliffordattractor.clifford.attractor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.cliffordattractor.clifford.attractor.ParamUtil.*;

/**
 *
 * @author ador
 */
public class CliffordServlet extends HttpServlet {

	private ICliffordRenderer cliffordRenderer;
	
	public CliffordServlet(ICliffordRenderer cliffordRenderer) {
		this.cliffordRenderer = cliffordRenderer;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HashMap<String, Object> properties = new HashMap<>();
		
		convertInt(properties, ICliffordRenderer.PARAM_ITERATION, req.getParameter(ICliffordRenderer.PARAM_ITERATION));
		convertInt(properties, ICliffordRenderer.PARAM_WIDTH, req.getParameter(ICliffordRenderer.PARAM_WIDTH));
		convertInt(properties, ICliffordRenderer.PARAM_HEIGHT, req.getParameter(ICliffordRenderer.PARAM_HEIGHT));
		
		convertDouble(properties, ICliffordRenderer.PARAM_A, req.getParameter(ICliffordRenderer.PARAM_A));
		convertDouble(properties, ICliffordRenderer.PARAM_B, req.getParameter(ICliffordRenderer.PARAM_B));
		convertDouble(properties, ICliffordRenderer.PARAM_C, req.getParameter(ICliffordRenderer.PARAM_C));
		convertDouble(properties, ICliffordRenderer.PARAM_D, req.getParameter(ICliffordRenderer.PARAM_D));
		
		convertColor(properties, ICliffordRenderer.PARAM_BGCOLOR, req.getParameter(ICliffordRenderer.PARAM_BGCOLOR));
		convertColor(properties, ICliffordRenderer.PARAM_COLOR_FROM, req.getParameter(ICliffordRenderer.PARAM_COLOR_FROM));
		convertColor(properties, ICliffordRenderer.PARAM_COLOR_TO, req.getParameter(ICliffordRenderer.PARAM_COLOR_TO));
		
		BufferedImage bufferedImage = cliffordRenderer.render(properties);
		resp.setContentType("image/png");
		
		ImageIO.write(bufferedImage, "PNG", resp.getOutputStream());
	}
	
}
