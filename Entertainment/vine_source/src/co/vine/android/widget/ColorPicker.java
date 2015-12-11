// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import co.vine.android.Settings;

// Referenced classes of package co.vine.android.widget:
//            ColorPickerCircle

public class ColorPicker extends ViewGroup
    implements android.view.View.OnClickListener
{
    public static interface ColorClickListener
    {

        public abstract void onColorClick(int i);
    }


    private int mCircleWidth;
    private ColorClickListener mColorClickListener;
    private int mLineCount;
    private int mMinPadding;
    private ColorPickerCircle mSelected;

    public ColorPicker(Context context)
    {
        this(context, null);
    }

    public ColorPicker(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ColorPicker(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMinPadding = context.getResources().getDimensionPixelOffset(0x7f0b001f);
    }

    public void onClick(View view)
    {
        view = (ColorPickerCircle)view;
        if (mSelected != null)
        {
            mSelected.setSelected(false);
        }
        mSelected = view;
        mSelected.setSelected(true);
        if (mColorClickListener == null)
        {
            return;
        } else
        {
            mColorClickListener.onColorClick(view.getIndex());
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, final int index, int k)
    {
        k = mMinPadding * 2;
        j = (getMeasuredWidth() - mLineCount * (mCircleWidth + mMinPadding)) / 2;
        i = j;
        boolean flag1 = false;
        for (index = 0; index < getChildCount();)
        {
            final ColorPickerCircle circle = (ColorPickerCircle)getChildAt(index);
            circle.layout(i, k, mCircleWidth + i, mCircleWidth + k);
            circle.post(new Runnable() {

                final ColorPicker this$0;
                final ColorPickerCircle val$circle;
                final int val$index;

                public void run()
                {
                    circle.setIndex(index);
                }

            
            {
                this$0 = ColorPicker.this;
                circle = colorpickercircle;
                index = i;
                super();
            }
            });
            circle.setOnClickListener(this);
            int i1 = i + (mCircleWidth + mMinPadding);
            i = i1;
            boolean flag2 = flag1;
            int l = k;
            if (index >= mLineCount - 1)
            {
                i = i1;
                flag2 = flag1;
                l = k;
                if (!flag1)
                {
                    l = k + (mCircleWidth + mMinPadding);
                    i = j;
                    flag2 = true;
                }
            }
            index++;
            flag1 = flag2;
            k = l;
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = Settings.PROFILE_BACKGROUND_COLORS.length / 2;
        mLineCount = i;
        j = getMeasuredWidth();
        int k = j / i - mMinPadding * 2;
        int l = mMinPadding;
        for (i = 0; i < getChildCount(); i++)
        {
            measureChild(getChildAt(i), android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000));
        }

        mCircleWidth = k;
        setMeasuredDimension(j, k * 2 + l * 4);
    }

    public void setColorIndex(int i)
    {
        if (i >= 0 && i < getChildCount())
        {
            int j = 0;
            while (j < getChildCount()) 
            {
                if (i == j)
                {
                    View view = getChildAt(i);
                    view.setSelected(true);
                    mSelected = (ColorPickerCircle)view;
                } else
                {
                    getChildAt(j).setSelected(false);
                }
                j++;
            }
        }
    }

    public void setOnColorClickListener(ColorClickListener colorclicklistener)
    {
        mColorClickListener = colorclicklistener;
    }
}
