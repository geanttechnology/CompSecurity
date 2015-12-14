// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import xg;
import xh;
import xi;
import xj;

public class ArcMenu extends ViewGroup
    implements android.view.View.OnClickListener
{

    private static final int POS_BOTTOM_CENTER = 4;
    private static final int POS_LEFT_BOTTOM = 1;
    private static final int POS_LEFT_TOP = 0;
    private static final int POS_RIGHT_BOTTOM = 3;
    private static final int POS_RIGHT_TOP = 2;
    private final String TAG;
    private int mBottomMargin;
    private int mCBtnTop;
    private int mCBtnleft;
    private View mCButton;
    private Status mCurrentStatus;
    private int mLeftMargin;
    private xj mMenuItemClickListener;
    private Position mPosition;
    private int mRadius;

    public ArcMenu(Context context)
    {
        this(context, null);
    }

    public ArcMenu(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ArcMenu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = "20150629";
        mPosition = Position.BOTTOM_CENTER;
        mCurrentStatus = Status.CLOSE;
        mRadius = (int)TypedValue.applyDimension(1, 100F, getResources().getDisplayMetrics());
        context = context.getTheme().obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.ArcMenu, i, 0);
        context.getInt(0, 3);
        JVM INSTR tableswitch 0 4: default 100
    //                   0 151
    //                   1 161
    //                   2 171
    //                   3 181
    //                   4 191;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        mRadius = (int)context.getDimension(3, TypedValue.applyDimension(1, 100F, getResources().getDisplayMetrics()));
        mBottomMargin = (int)context.getDimension(2, TypedValue.applyDimension(1, 100F, getResources().getDisplayMetrics()));
        context.recycle();
        return;
_L2:
        mPosition = Position.LEFT_TOP;
        continue; /* Loop/switch isn't completed */
_L3:
        mPosition = Position.LEFT_BOTTOM;
        continue; /* Loop/switch isn't completed */
_L4:
        mPosition = Position.RIGHT_TOP;
        continue; /* Loop/switch isn't completed */
_L5:
        mPosition = Position.RIGHT_BOTTOM;
        continue; /* Loop/switch isn't completed */
_L6:
        mPosition = Position.BOTTOM_CENTER;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void changeStatus()
    {
        Status status;
        if (mCurrentStatus == Status.CLOSE)
        {
            status = Status.OPEN;
        } else
        {
            status = Status.CLOSE;
        }
        mCurrentStatus = status;
    }

    private void layoutCButton()
    {
        int j;
        int k;
        int l;
        j = 0;
        mCButton = getChildAt(0);
        mCButton.setOnClickListener(this);
        k = mCButton.getMeasuredWidth();
        l = mCButton.getMeasuredHeight();
        mLeftMargin = (getMeasuredWidth() / 4 - k) / 2;
        Log.e("TAG", (new StringBuilder()).append("mLeftMargin = ").append(mLeftMargin).append(" , mBottomMargin =  ").append(mBottomMargin).toString());
        Log.e("20150629", (new StringBuilder()).append("width=").append(k).append(", height=").append(l).toString());
        xi.a[mPosition.ordinal()];
        JVM INSTR tableswitch 1 5: default 172
    //                   1 200
    //                   2 205
    //                   3 220
    //                   4 230
    //                   5 248;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int i = 0;
_L8:
        mCButton.layout(i, j, i + k, k + j);
        mCBtnleft = i;
        mCBtnTop = j;
        return;
_L2:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        j = getMeasuredHeight();
        i = 0;
        j -= l;
        continue; /* Loop/switch isn't completed */
_L4:
        i = getMeasuredWidth() - k;
        continue; /* Loop/switch isn't completed */
_L5:
        i = getMeasuredWidth() - k;
        j = getMeasuredHeight() - l;
        continue; /* Loop/switch isn't completed */
_L6:
        i = getMeasuredWidth() / 2;
        i = mLeftMargin + i;
        j = getMeasuredHeight() - mBottomMargin - l;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void menuItemAnim(int i)
    {
        int j = 0;
        while (j < getChildCount() - 1) 
        {
            View view = getChildAt(j + 1);
            if (j == i)
            {
                view.startAnimation(scaleBigAnim(300));
            } else
            {
                view.startAnimation(scaleSmallAnim(300));
            }
            view.setClickable(false);
            view.setFocusable(false);
            j++;
        }
    }

    private void rotateCButton(View view, float f, float f1, int i)
    {
        RotateAnimation rotateanimation = new RotateAnimation(f, f1, 1, 0.5F, 1, 0.5F);
        rotateanimation.setDuration(i);
        rotateanimation.setFillAfter(true);
        view.startAnimation(rotateanimation);
    }

    private Animation scaleBigAnim(int i)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 4F, 1.0F, 4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        animationset.setDuration(i);
        animationset.setFillAfter(true);
        return animationset;
    }

    private Animation scaleSmallAnim(int i)
    {
        AnimationSet animationset = new AnimationSet(true);
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(alphaanimation);
        animationset.setDuration(i);
        animationset.setFillAfter(true);
        return animationset;
    }

    public boolean isOpen()
    {
        return mCurrentStatus == Status.OPEN;
    }

    public void onClick(View view)
    {
        toggleMenu(300);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (flag)
        {
            layoutCButton();
            l = getChildCount();
            for (i = 0; i < l - 1; i++)
            {
                View view = getChildAt(i + 1);
                view.setVisibility(8);
                double d = (3.1415926535897931D - 2.3561944901923448D) / 2D + (2.3561944901923448D * (double)i) / (double)(l - 2);
                k = 0;
                j = 0;
                int l1 = (int)((double)mRadius * Math.cos(d));
                double d1 = mRadius;
                int k1 = (int)(Math.sin(d) * d1);
                int i1 = view.getMeasuredWidth();
                int j1 = view.getMeasuredHeight();
                if (mPosition == Position.BOTTOM_CENTER)
                {
                    k = mCBtnleft + l1;
                    j = mCBtnTop - k1;
                }
                view.layout(k, j, k + i1, j + j1);
            }

        }
    }

    protected void onMeasure(int i, int j)
    {
        int l = getChildCount();
        for (int k = 0; k < l; k++)
        {
            measureChild(getChildAt(k), i, j);
        }

        super.onMeasure(i, j);
    }

    public void setOnMenuItemClickListener(xj xj)
    {
        mMenuItemClickListener = xj;
    }

    public void toggleMenu(int i)
    {
        int i1 = getChildCount();
        int j = 0;
        while (j < i1 - 1) 
        {
            View view = getChildAt(j + 1);
            view.setVisibility(0);
            double d = (3.1415926535897931D - 2.0943951023931953D) / 2D + (2.0943951023931953D * (double)j) / (double)(i1 - 2);
            int l = 0;
            int k = 0;
            int j1 = (int)((double)mRadius * Math.cos(d));
            double d1 = mRadius;
            int k1 = (int)(Math.sin(d) * d1);
            if (mPosition == Position.BOTTOM_CENTER)
            {
                l = mCBtnleft + j1;
                k = mCBtnTop - k1;
            }
            AnimationSet animationset = new AnimationSet(true);
            TranslateAnimation translateanimation;
            RotateAnimation rotateanimation;
            if (mCurrentStatus == Status.CLOSE)
            {
                translateanimation = new TranslateAnimation(-j1, 0.0F, k1, 0.0F);
                view.setClickable(true);
                view.setFocusable(true);
            } else
            {
                translateanimation = new TranslateAnimation(0.0F, -j1, 0.0F, k1);
                view.setClickable(false);
                view.setFocusable(false);
            }
            Log.e("20150629", (new StringBuilder()).append("toggleMenu, cl=").append(l).append(", ct=").append(k).toString());
            translateanimation.setFillAfter(true);
            translateanimation.setDuration(i);
            translateanimation.setStartOffset((j * 100) / i1);
            translateanimation.setAnimationListener(new xg(this, view));
            rotateanimation = new RotateAnimation(0.0F, 720F, 1, 0.5F, 1, 0.5F);
            rotateanimation.setDuration(i);
            rotateanimation.setFillAfter(true);
            animationset.addAnimation(rotateanimation);
            animationset.addAnimation(translateanimation);
            view.startAnimation(animationset);
            view.setOnClickListener(new xh(this, view, j + 1));
            j++;
        }
        changeStatus();
    }





    private class Position extends Enum
    {

        private static final Position $VALUES[];
        public static final Position BOTTOM_CENTER;
        public static final Position LEFT_BOTTOM;
        public static final Position LEFT_TOP;
        public static final Position RIGHT_BOTTOM;
        public static final Position RIGHT_TOP;

        public static Position valueOf(String s)
        {
            return (Position)Enum.valueOf(com/fotoable/beautyui/other/ArcMenu$Position, s);
        }

        public static Position[] values()
        {
            return (Position[])$VALUES.clone();
        }

        static 
        {
            LEFT_TOP = new Position("LEFT_TOP", 0);
            LEFT_BOTTOM = new Position("LEFT_BOTTOM", 1);
            RIGHT_TOP = new Position("RIGHT_TOP", 2);
            RIGHT_BOTTOM = new Position("RIGHT_BOTTOM", 3);
            BOTTOM_CENTER = new Position("BOTTOM_CENTER", 4);
            $VALUES = (new Position[] {
                LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM, BOTTOM_CENTER
            });
        }

        private Position(String s, int i)
        {
            super(s, i);
        }
    }


    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status CLOSE;
        public static final Status OPEN;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/fotoable/beautyui/other/ArcMenu$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            OPEN = new Status("OPEN", 0);
            CLOSE = new Status("CLOSE", 1);
            $VALUES = (new Status[] {
                OPEN, CLOSE
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }

}
