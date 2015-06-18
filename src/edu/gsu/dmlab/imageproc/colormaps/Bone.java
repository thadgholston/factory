package edu.gsu.dmlab.imageproc.colormaps;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;

import edu.gsu.dmlab.exceptions.InvalidConfigException;
import edu.gsu.dmlab.imageproc.ColorMap;

public class Bone extends ColorMap {

	public Bone() throws InvalidConfigException {
		super();
		this.init(256);
	}

	public Bone(int n) throws InvalidConfigException {
		super();
		this.init(n);
	}

	protected void init(int n) throws InvalidConfigException {
		double r[] = { 0, 0.01388888888888889, 0.02777777777777778,
				0.04166666666666666, 0.05555555555555555, 0.06944444444444445,
				0.08333333333333333, 0.09722222222222221, 0.1111111111111111,
				0.125, 0.1388888888888889, 0.1527777777777778,
				0.1666666666666667, 0.1805555555555556, 0.1944444444444444,
				0.2083333333333333, 0.2222222222222222, 0.2361111111111111,
				0.25, 0.2638888888888889, 0.2777777777777778,
				0.2916666666666666, 0.3055555555555555, 0.3194444444444444,
				0.3333333333333333, 0.3472222222222222, 0.3611111111111111,
				0.375, 0.3888888888888888, 0.4027777777777777,
				0.4166666666666666, 0.4305555555555555, 0.4444444444444444,
				0.4583333333333333, 0.4722222222222222, 0.4861111111111112,
				0.5, 0.5138888888888888, 0.5277777777777778,
				0.5416666666666667, 0.5555555555555556, 0.5694444444444444,
				0.5833333333333333, 0.5972222222222222, 0.611111111111111,
				0.6249999999999999, 0.6388888888888888, 0.6527777777777778,
				0.6726190476190474, 0.6944444444444442, 0.7162698412698412,
				0.7380952380952381, 0.7599206349206349, 0.7817460317460316,
				0.8035714285714286, 0.8253968253968254, 0.8472222222222221,
				0.8690476190476188, 0.8908730158730158, 0.9126984126984128,
				0.9345238095238095, 0.9563492063492063, 0.978174603174603, 1 };

		double g[] = { 0, 0.01388888888888889, 0.02777777777777778,
				0.04166666666666666, 0.05555555555555555, 0.06944444444444445,
				0.08333333333333333, 0.09722222222222221, 0.1111111111111111,
				0.125, 0.1388888888888889, 0.1527777777777778,
				0.1666666666666667, 0.1805555555555556, 0.1944444444444444,
				0.2083333333333333, 0.2222222222222222, 0.2361111111111111,
				0.25, 0.2638888888888889, 0.2777777777777778,
				0.2916666666666666, 0.3055555555555555, 0.3194444444444444,
				0.3353174603174602, 0.3544973544973544, 0.3736772486772486,
				0.3928571428571428, 0.412037037037037, 0.4312169312169312,
				0.4503968253968254, 0.4695767195767195, 0.4887566137566137,
				0.5079365079365078, 0.5271164021164021, 0.5462962962962963,
				0.5654761904761904, 0.5846560846560845, 0.6038359788359787,
				0.623015873015873, 0.6421957671957671, 0.6613756613756612,
				0.6805555555555555, 0.6997354497354497, 0.7189153439153438,
				0.7380952380952379, 0.7572751322751322, 0.7764550264550264,
				0.7916666666666666, 0.8055555555555555, 0.8194444444444444,
				0.8333333333333334, 0.8472222222222222, 0.861111111111111,
				0.875, 0.8888888888888888, 0.9027777777777777,
				0.9166666666666665, 0.9305555555555555, 0.9444444444444444,
				0.9583333333333333, 0.9722222222222221, 0.986111111111111, 1 };
		
		double b[] = { 0, 0.01917989417989418, 0.03835978835978836,
				0.05753968253968253, 0.07671957671957672, 0.09589947089947089,
				0.1150793650793651, 0.1342592592592592, 0.1534391534391534,
				0.1726190476190476, 0.1917989417989418, 0.210978835978836,
				0.2301587301587301, 0.2493386243386243, 0.2685185185185185,
				0.2876984126984127, 0.3068783068783069, 0.326058201058201,
				0.3452380952380952, 0.3644179894179894, 0.3835978835978835,
				0.4027777777777777, 0.4219576719576719, 0.4411375661375661,
				0.4583333333333333, 0.4722222222222222, 0.4861111111111111,
				0.5, 0.5138888888888888, 0.5277777777777777,
				0.5416666666666666, 0.5555555555555556, 0.5694444444444444,
				0.5833333333333333, 0.5972222222222222, 0.6111111111111112,
				0.625, 0.6388888888888888, 0.6527777777777778,
				0.6666666666666667, 0.6805555555555556, 0.6944444444444444,
				0.7083333333333333, 0.7222222222222222, 0.736111111111111,
				0.7499999999999999, 0.7638888888888888, 0.7777777777777778,
				0.7916666666666666, 0.8055555555555555, 0.8194444444444444,
				0.8333333333333334, 0.8472222222222222, 0.861111111111111,
				0.875, 0.8888888888888888, 0.9027777777777777,
				0.9166666666666665, 0.9305555555555555, 0.9444444444444444,
				0.9583333333333333, 0.9722222222222221, 0.986111111111111, 1 };
		
		Mat X = ColorMap.linspace(0, 1, 64);
		Mat rMat = new MatOfDouble(r);
		Mat rMatF = new Mat();
		rMat.convertTo(rMatF, CvType.CV_32FC1);

		Mat gMat = new MatOfDouble(g);
		Mat gMatF = new Mat();
		gMat.convertTo(gMatF, CvType.CV_32FC1);

		Mat bMat = new MatOfDouble(b);
		Mat bMatF = new Mat();
		bMat.convertTo(bMatF, CvType.CV_32FC1);

		this._lut = ColorMap.linear_colormap(X, rMatF.clone(), // red
				gMatF.clone(), // green
				bMatF.clone(), // blue
				n); // number of sample points
	}
}
