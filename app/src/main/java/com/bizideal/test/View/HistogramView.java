package com.bizideal.test.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class HistogramView extends View {

	int[] COLORS = new int[] { Color.parseColor("#FED35A"), Color.parseColor("#029FEA")};
	
	public Paint xLinePaint;// 坐标轴 轴线 画笔：
	public Paint hLinePaint;// 坐标轴水平内部 虚线画笔
	public Paint titlePaint;// 绘制文本的画笔
	public Paint paint;// 矩形画笔 柱状图的样式信息
	public int[] progress;
	public int[] aniProgress;// 实现动画的值

	// 坐标轴左侧的数标
	public String[] ySteps;
	// 坐标轴底部的星期数
	public String[] xWeeks;

/*	public HistogramAnimation ani;*/

	public int width;
	public int height;
	public int leftHeight;
	public int hPerHeight;
	
	public int offx=0;//偏移量
	final static int step =200;//间隔
	final static int start_x=150;//起始点
	
	public int[] Rect_left;//柱状图的left
	public int[] Rect_right;//柱状图的right
	public int[] Rect_top;//柱状图的top
	public int[] Rect_bottom;//柱状图的Rect_bottom
	
	public int[] data_draw_x;//柱状图上的数字的X坐标
	public int[] data_draw_y;//柱状图上的数字的Y坐标
	
	public HistogramView(Context context) {
		super(context);
		init(context, null);
	}

	public HistogramView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		width =400;
		height = 500 - 200;
		
		leftHeight = height-20;// 左侧外周的 需要划分的高度：
        hPerHeight = leftHeight / 4;// 分成四部分
		
		ySteps = new String[] { "1000", "800", "600", "400", "200" ,"0"};
		xWeeks = new String[] { "酒店签到人数", "会议签到人数"	
		};

		aniProgress = new int[] { 800, 300};
	
		Rect_left=new  int[aniProgress.length];//柱状图的left
		Rect_right=new  int[aniProgress.length];//柱状图的right
		Rect_top=new  int[aniProgress.length];//柱状图的top
		Rect_bottom=new  int[aniProgress.length];//柱状图的Rect_bottom
		data_draw_x=new  int[aniProgress.length];//柱状图上的数字的X坐标
		data_draw_y=new  int[aniProgress.length];//柱状图上的数字的Y坐标
			

		
		/*
		ani = new HistogramAnimation();
		ani.setDuration(2000);*/

		xLinePaint = new Paint();
		hLinePaint = new Paint();
		titlePaint = new Paint();
		
		paint = new Paint();

		xLinePaint.setColor(Color.parseColor("#646464"));
		hLinePaint.setColor(Color.parseColor("#646464"));
		titlePaint.setColor(Color.parseColor("#646464"));
	}

	public void addOffx() {

		this.offx++;
		if(offx>0)offx=0;
		Log.i("custom","addOffx this.offx="+this.offx);
		this.postInvalidate();// 可以子线程 更新视图的方法调用。
	}
	public void reduceOffx() {

		this.offx--;
		
		int max_x=Math.abs((((xWeeks.length-1)*step)+start_x)/(width/2))-1;
		Log.i("custom","max_x="+max_x);
		
		if(offx<-max_x)offx=-max_x;
		Log.i("custom","reduceOffx this.offx="+this.offx);
		this.postInvalidate();// 可以子线程 更新视图的方法调用。
	}

	public void setProgress(int[] progress) {
		this.progress = progress;
		// this.invalidate(); //失效的意思。
		 this.postInvalidate(); // 可以子线程 更新视图的方法调用。
		/*this.startAnimation(ani);*/
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
	
		return super.onTouchEvent(event);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
	
		super.onDraw(canvas);
		
		canvas.drawLine(80, 0, 80, height, xLinePaint);//Y轴线

		canvas.drawLine(80, height, width, height, xLinePaint);//X轴线

		// 2 绘制坐标内部的水平线
		hLinePaint.setTextAlign(Align.CENTER);
		for (int i = 0; i < 4; i++) {
			canvas.drawLine(50, 20 + i * hPerHeight, width - 10, 20 + i* hPerHeight, hLinePaint);
		}

		// 3 绘制 Y 周坐标

		titlePaint.setTextAlign(Align.CENTER);
		titlePaint.setTextSize(25);
		titlePaint.setAntiAlias(true);
		titlePaint.setStyle(Paint.Style.FILL);
		for (int i = 0; i < ySteps.length; i++) {
			canvas.drawText(ySteps[i], 40, 20 + i * hPerHeight, titlePaint);
		}

		
        //设置canvas的偏移量
		canvas.translate(offx*(width/2), 0);
		
		// 4 绘制 X 周 做坐标
		int columCount = xWeeks.length + 1;
		
		
		for (int i = 0; i < columCount - 1; i++) {
			// text, baseX, baseY, textPaint
			int x=start_x+step * (i);
			int y= height+30;
			
			Log.i("custom","i="+i);
			Log.i("custom","x="+x);
			//不在屏幕范围内不显示
			if(x<start_x+(Math.abs(offx*(width/2))))continue;
			//X轴标题名字
			canvas.drawText(xWeeks[i], x, y, titlePaint);
		}

		// 5 绘制矩形

		if (aniProgress != null && aniProgress.length > 0) {
			for (int i = 0; i < aniProgress.length; i++) {// 循环遍历将7条柱状图形画出来
				int value = aniProgress[i];
				paint.setAntiAlias(true);// 抗锯齿效果
				paint.setStyle(Paint.Style.FILL);
				paint.setTextSize(25);// 字体大小
				paint.setColor(Color.parseColor("#6DCAEC"));// 字体颜色
				Rect rect = new Rect();// 柱状图的形状
				
				//计算柱状图的坐标
                Rect_left[i] = start_x + step * (i) - 50;
				Rect_right[i] = start_x + step * (i) + 50;
				int rh = (int) (leftHeight - leftHeight * (value / 1000.0));
		
				Rect_top[i] = rh + 20;
				Rect_bottom[i] = height;
				
				data_draw_x[i]=start_x + step * (i) - 30;
				data_draw_y[i]= rh + 10;
		        
				Log.i("custom","Rect_left["+i+"]="+Rect_left[i]);
				Log.i("custom","Rect_right["+i+"]="+Rect_right[i]);
				Log.i("custom","Rect_top["+i+"]="+Rect_top[i]);
				Log.i("custom","Rect_bottom["+i+"]="+Rect_bottom[i]);
				
				Log.i("custom","data_draw_x["+i+"]="+data_draw_x[i]);
				Log.i("custom","data_draw_y["+i+"]="+data_draw_y[i]);

				rect.left = Rect_left[i];
				rect.right = Rect_right[i];
				rect.top = Rect_top[i];
				rect.bottom =  Rect_bottom[i];


				
				//不在屏幕范围内不显示
				if(rect.left<start_x+(Math.abs(offx*(width/2)))-50)continue;

				if (i < COLORS.length) {
					paint.setColor(COLORS[i]);//柱子的颜色
	            } else {
					paint.setColor(COLORS[i%COLORS.length]);//柱子的颜色
				}
				//画柱子
//				Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.column);
//                canvas.drawBitmap(bitmap, null, rect, paint);
				 canvas.drawRect(rect, paint);
			
				//画数字值
			//	canvas.drawText(value + "",data_draw_x[i],data_draw_y[i], paint);
				

			}
		}

	}

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 集成animation的一个动画类
	 * 
	 *
	 */
	/*private class HistogramAnimation extends Animation {
		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation t) {
			super.applyTransformation(interpolatedTime, t);
			if (interpolatedTime < 1.0f) {
				for (int i = 0; i < aniProgress.length; i++) {
					aniProgress[i] = (int) (progress[i] * interpolatedTime);
				}
			} else {
				for (int i = 0; i < aniProgress.length; i++) {
					aniProgress[i] = progress[i];
				}
			}
			postInvalidate();
		}
	}*/

}