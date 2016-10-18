package com.bizideal.test.View;

import android.view.MotionEvent;
import android.widget.ListView;


public class MyListView extends ListView   
{   
    public MyListView(android.content.Context context,   
            android.util.AttributeSet attrs)   
    {   
        super(context, attrs);   
    }   
  
    /**  
     * 设置不滚动  
     */  
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)   
    {   
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,   
                MeasureSpec.AT_MOST);   
        super.onMeasure(widthMeasureSpec, expandSpec);   
  
    }   
  
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	 if (event.getAction() == MotionEvent.ACTION_MOVE) {
    		 return false;
    	 }
    	 return super.onTouchEvent(event);
    }
}  
