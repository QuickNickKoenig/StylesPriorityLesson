package ru.sberbank;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import ru.sberbank.learning.materialdesignsample.R;

/**
 * Created by Тичер on 22.06.2017.
 */
public class SampleView extends View {

    private final Paint mBorderPaint;
    private final Paint mInnerPaint;

    private int mMinWidth;
    private int mMinHeight;

    public SampleView(Context context) {
        this(context, null);
    }

    public SampleView(Context context,
                      @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.sampleViewStyle);
    }

    public SampleView(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.Widget_SampleView);
    }

    public SampleView(Context context,
                      @Nullable AttributeSet attrs,
                      int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        TypedArray styledAttrs = context.obtainStyledAttributes(
                attrs, R.styleable.SampleView, defStyleAttr, defStyleRes
        );
        try {
            mBorderPaint = createBorderPaint(styledAttrs);
            mInnerPaint = createInnerPaint(styledAttrs);

            mMinWidth = styledAttrs.getDimensionPixelSize(R.styleable.SampleView_android_minWidth, 0);
            mMinHeight = styledAttrs.getDimensionPixelSize(R.styleable.SampleView_android_minHeight, 0);
        } finally {
            styledAttrs.recycle();
        }
    }

    private static Paint createBorderPaint(TypedArray styledAttrs) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(styledAttrs.getColor(R.styleable.SampleView_borderColor, Color.WHITE));
        paint.setStrokeWidth(styledAttrs.getDimension(R.styleable.SampleView_sampleBorderWidth, 0));
        return paint;
    }

    private static Paint createInnerPaint(TypedArray styledAttrs) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(styledAttrs.getColor(R.styleable.SampleView_innerColor, Color.WHITE));
        return paint;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = mMinWidth + getPaddingLeft() + getPaddingRight();
        int desiredHeight = mMinHeight + getPaddingTop() + getPaddingBottom();

        final int measuredWidth = resolveSizeAndState(desiredWidth, widthMeasureSpec, 0);
        final int measuredHeight = resolveSizeAndState(desiredHeight, heightMeasureSpec, 0);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        canvas.translate(getPaddingLeft(), getPaddingTop());
        float left = 0;
        float top = 0;
        float right = getWidth() - getPaddingLeft() - getPaddingRight();
        float bottom = getHeight() - getPaddingTop() - getPaddingBottom();
//        canvas.clipRect(left, top, right, bottom);
        canvas.drawRect(left, top, right, bottom, mInnerPaint);
        canvas.drawRect(left, top, right, bottom, mBorderPaint);

        canvas.restore();
    }
}
