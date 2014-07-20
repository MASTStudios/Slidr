package display;

import skeleton.Grid;
import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback{

	private Grid grid;
	private int screenwidth,screenheight;

	public Game(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}


	public void draw(){
		Canvas canvas = getHolder().lockCanvas();
		grid.draw(canvas);
		getHolder().unlockCanvasAndPost(canvas);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		//System.out.println("onmeasure called");
		screenwidth = MeasureSpec.getSize(widthMeasureSpec);
		screenheight = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(screenwidth, screenheight);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
