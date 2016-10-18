package com.bizideal.test.View;

/**
 * Created by mengweikang on 2016/8/16.
 */
public class BarCharts {
    /*private String[] color = {"#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD","#C4FF8E","#FFF88D","#FFD38C","#8CEBFF","#FF8F9D","#6BF3AD"};

    public void showBarChart(BarChart barChart, BarData barData) {
        // 数据描述
        barChart.setDescription("");
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView
        barChart.setNoDataTextDescription("You need to provide data for the chart.");
        // 是否显示表格颜色
        barChart.setDrawGridBackground(false);
        // 设置是否可以触摸
        barChart.setTouchEnabled(true);
        // 是否可以拖拽
        barChart.setDragEnabled(false);
        // 是否可以缩放
        barChart.setScaleEnabled(false);
        // 集双指缩放
        barChart.setPinchZoom(false);
        // 设置背景
        barChart.setBackgroundColor(Color.parseColor("#01000000"));
        // 如果打开，背景矩形将出现在已经画好的绘图区域的后边。
        barChart.setDrawGridBackground(false);
        // 集拉杆阴影
        barChart.setDrawBarShadow(false);
        // 图例
        barChart.getLegend().setEnabled(false);
        // 设置数据
        barChart.setData(barData);

        // 隐藏右边的坐标轴 (就是右边的0 - 100 - 200 - 300 ... 和图表中横线)
        barChart.getAxisRight().setEnabled(false);
        // 隐藏左边的左边轴 (同上)
//        barChart.getAxisLeft().setEnabled(false);

        // 网格背景颜色
        barChart.setGridBackgroundColor(Color.parseColor("#00000000"));
        // 是否显示表格颜色
        barChart.setDrawGridBackground(false);
        // 设置边框颜色
        barChart.setBorderColor(Color.parseColor("#00000000"));
        // 说明颜色
        barChart.setDescriptionColor(Color.parseColor("#00000000"));
        // 拉杆阴影
        barChart.setDrawBarShadow(false);
        // 打开或关闭绘制的图表边框。（环绕图表的线）
        barChart.setDrawBorders(false);


        Legend mLegend = barChart.getLegend(); // 设置比例图标示
        // 设置窗体样式
        mLegend.setForm(LegendForm.CIRCLE);
        // 字体
        mLegend.setFormSize(4f);
        // 字体颜色
        mLegend.setTextColor(Color.parseColor("#00000000"));


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(2);


        barChart.animateY(1000); // 立即执行的动画,Y轴
    }
    public BarData getBarData(int count, float range) {
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xValues.add(""+(i+1)+"周");// 设置每个壮图的文字描述
        }
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range*//*100以内的随机数*//*) + 3;
            yValues.add(new BarEntry(value, i));
        }
        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "测试饼状图");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for(int i = 0;i < count ;i++){
            colors.add(Color.parseColor(color[i]));
        }
        barDataSet.setColors(colors);
        // 设置栏阴影颜色
        barDataSet.setBarShadowColor(Color.parseColor("#01000000"));
        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();
        barDataSets.add(barDataSet);
        barDataSet.setValueTextColor(Color.parseColor("#FF8F9D"));
        // 绘制值
        barDataSet.setDrawValues(true);
        BarData barData = new BarData(xValues, barDataSets);
        return barData;
    }*/
}

