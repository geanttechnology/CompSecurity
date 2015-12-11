// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            IMaterial

public class MaterialStyle
{

    public static final int TYPE_HEADBAR_BACK_BTN = 1;
    public static final int TYPE_HEADBAR_RIGHT_BTN = 2;
    public static final int TYPE_HEADER_CENTER_BTN = 3;
    public static final int TYPE_NORMAL_BTN = 0;
    private int ANIM_FAST_TIME;
    private final int ANIM_SLEEP_TIME = 10;
    private final int ANIM_SLOW_TIME = 200;
    private final int SHAPE_MODE_EQUAL = 0;
    private final int SHAPE_MODE_HEIGHT = 2;
    private final int SHAPE_MODE_WIDTH = 1;
    private final int STATUS_ANIM_FAST = 1;
    private final int STATUS_ANIM_SLOWLY = 2;
    private final int STATUS_NORMAL = 0;
    private final int STATUS_PRESSED = 3;
    private final int STATUS_TO_NORMAL = 4;
    private float actionDownX;
    private float actionDownY;
    private int animFastTimes;
    private int animSlowTimes;
    private PaintFlagsDrawFilter drawFilter;
    private boolean hasClick;
    private Paint mAnimBottomPaint;
    private int mAnimColorAlpha;
    private int mAnimColorAlphaFastSpeed;
    private int mAnimColorAlphaMax;
    private int mAnimColorAlphaSlowSpeed;
    private int mAnimColorAlphaToNormalSpeed;
    private int mAnimFullColor;
    private int mAnimMode;
    private int mBackgroundColor;
    private Drawable mBackgroundDrawable;
    private int mBackgroundHeight;
    private int mBackgroundWidth;
    private IMaterial mCallBack;
    private float mCirRSpeedFast;
    private float mCirRSpeedSlow;
    private Paint mCirclePaint;
    private float mCircleRadius;
    private float mCircleRadiusMax;
    private View mDependView;
    private boolean mNeedDelayClick;
    private Path mPath;
    private int status;
    private int type;

    public MaterialStyle(View view, AttributeSet attributeset)
    {
        status = 0;
        mAnimMode = 0;
        ANIM_FAST_TIME = 125;
        mBackgroundColor = 0;
        mAnimColorAlpha = 0;
        mAnimColorAlphaMax = 15;
        mPath = new Path();
        mAnimBottomPaint = new Paint();
        mCirclePaint = new Paint();
        mAnimFullColor = -1;
        drawFilter = new PaintFlagsDrawFilter(0, 3);
        type = 0;
        mNeedDelayClick = true;
        hasClick = false;
        mCallBack = (IMaterial)view;
        mDependView = view;
        view.setClickable(true);
        setBackgroundColor(0);
        animSlowTimes = 20;
        animFastTimes = ANIM_FAST_TIME / 10;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            view.setLayerType(1, null);
        }
        view.setWillNotDraw(false);
        if (attributeset != null)
        {
            view = view.getContext().obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.LButtonStyle);
            mNeedDelayClick = view.getBoolean(2, true);
            mAnimFullColor = view.getInt(0, -1);
            mBackgroundDrawable = view.getDrawable(1);
            if (mBackgroundDrawable != null)
            {
                mBackgroundWidth = mBackgroundDrawable.getIntrinsicWidth();
                mBackgroundHeight = mBackgroundDrawable.getIntrinsicHeight();
            }
            type = view.getInt(3, 0);
            view.recycle();
        }
    }

    private int getHeight()
    {
        if (mDependView == null)
        {
            return 0;
        } else
        {
            return mDependView.getHeight();
        }
    }

    private int getWidth()
    {
        if (mDependView == null)
        {
            return 0;
        } else
        {
            return mDependView.getWidth();
        }
    }

    private void init()
    {
        float f;
        float f1;
        f = mDependView.getWidth();
        f1 = mDependView.getHeight();
        if (f <= 0.0F || f1 <= 0.0F)
        {
            return;
        }
        boolean flag;
        if (Math.min(f, f1) / Math.max(f, f1) > 0.8F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mAnimMode = 0;
        } else
        if (f > f1)
        {
            mAnimMode = 1;
        } else
        {
            mAnimMode = 2;
        }
        type;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 191
    //                   1 162
    //                   2 162
    //                   3 252;
           goto _L1 _L2 _L3 _L3 _L4
_L1:
        mCirRSpeedSlow = (mCircleRadiusMax - mCircleRadius) / (float)animSlowTimes;
        mCirRSpeedFast = (mCircleRadiusMax - mCircleRadius) / (float)animFastTimes;
        initColorInfo();
        return;
_L3:
        mCircleRadius = f1 / 2.0F;
        mCircleRadiusMax = f;
        if (mAnimFullColor == -1)
        {
            mAnimFullColor = 0x30ffffff;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        mCircleRadius = Math.min(f, f1) / 4F;
        if (mAnimMode == 0)
        {
            mCircleRadiusMax = Math.min(f, f1) / 2.0F;
        } else
        {
            mCircleRadiusMax = Math.max(f, f1) / 2.0F;
        }
        if (mAnimFullColor == -1)
        {
            mAnimFullColor = 0x30000000;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        mCircleRadius = Math.min(f, f1) / 4F;
        mCircleRadiusMax = Math.max(f, f1) / 2.0F;
        if (mAnimFullColor == -1)
        {
            mAnimFullColor = 0x30ffffff;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void initColorInfo()
    {
        mAnimBottomPaint.setColor(Color.rgb(Color.red(mAnimFullColor), Color.green(mAnimFullColor), Color.blue(mAnimFullColor)));
        mAnimColorAlphaMax = Color.alpha(mAnimFullColor);
        mCirclePaint.setColor(Color.rgb(Color.red(mAnimFullColor), Color.green(mAnimFullColor), Color.blue(mAnimFullColor)));
        mCirclePaint.setAlpha(mAnimColorAlphaMax);
        mAnimBottomPaint.setAlpha(0);
        mAnimColorAlphaSlowSpeed = mAnimColorAlphaMax / animSlowTimes;
        mAnimColorAlphaFastSpeed = mAnimColorAlphaMax / animFastTimes;
        if (mAnimColorAlphaSlowSpeed < 1)
        {
            mAnimColorAlphaSlowSpeed = 1;
        }
        if (mAnimColorAlphaFastSpeed < 1)
        {
            mAnimColorAlphaFastSpeed = 1;
        }
        mAnimColorAlphaToNormalSpeed = mAnimColorAlphaFastSpeed;
    }

    private void move()
    {
        if (status == 0 || status == 3)
        {
            return;
        }
        if (status != 2) goto _L2; else goto _L1
_L1:
        mAnimColorAlpha = mAnimColorAlpha + mAnimColorAlphaSlowSpeed;
        mCircleRadius = mCircleRadius + mCirRSpeedSlow;
_L4:
        if (mAnimColorAlpha >= mAnimColorAlphaMax)
        {
            mAnimColorAlpha = mAnimColorAlphaMax;
        }
        if (mAnimColorAlpha < 0)
        {
            mAnimColorAlpha = 0;
        }
        mAnimBottomPaint.setAlpha(mAnimColorAlpha);
        if (mCircleRadius > mCircleRadiusMax)
        {
            mCircleRadius = mCircleRadiusMax;
        }
        if (mAnimColorAlpha <= 0 || mAnimColorAlpha >= mAnimColorAlphaMax)
        {
            reset();
        }
        mDependView.invalidate();
        return;
_L2:
        if (status == 1)
        {
            mAnimColorAlpha = mAnimColorAlpha + mAnimColorAlphaFastSpeed;
            mCircleRadius = mCircleRadius + mCirRSpeedFast;
        } else
        if (status == 4)
        {
            mAnimColorAlpha = mAnimColorAlpha - mAnimColorAlphaToNormalSpeed;
            mCircleRadius = mCircleRadiusMax;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void reset()
    {
        status;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 44
    //                   2 60
    //                   3 44
    //                   4 93;
           goto _L1 _L2 _L3 _L2 _L4
_L1:
        mDependView.invalidate();
        return;
_L2:
        mCircleRadius = mCircleRadiusMax;
        status = 4;
        continue; /* Loop/switch isn't completed */
_L3:
        status = 3;
        if (type == 1 || type == 2)
        {
            mCircleRadius = getWidth();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mNeedDelayClick && hasClick)
        {
            if (mCallBack != null)
            {
                mCallBack.perfirmSuperClick();
            }
            hasClick = false;
        }
        resetStatus();
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void dispatchKeyEvent()
    {
    }

    public void doDraw(Canvas canvas)
    {
        if (mCircleRadius == 0.0F || mCircleRadiusMax == 0.0F)
        {
            init();
        }
        canvas.setDrawFilter(drawFilter);
        canvas.save();
        if (mBackgroundDrawable == null) goto _L2; else goto _L1
_L1:
        mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
        mBackgroundDrawable.draw(canvas);
_L12:
        status;
        JVM INSTR tableswitch 0 4: default 104
    //                   0 104
    //                   1 315
    //                   2 315
    //                   3 131
    //                   4 699;
           goto _L3 _L3 _L4 _L4 _L5 _L6
_L8:
        canvas.restore();
        move();
        return;
_L2:
        if (mBackgroundColor != 0)
        {
            canvas.drawColor(mBackgroundColor);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        switch (type)
        {
        case 0: // '\0'
            if (mAnimMode == 0)
            {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2, mAnimBottomPaint);
            } else
            {
                canvas.drawPaint(mAnimBottomPaint);
            }
            break;

        case 1: // '\001'
            canvas.drawCircle(0.0F, getHeight() / 2, getWidth(), mAnimBottomPaint);
            break;

        case 2: // '\002'
            canvas.drawCircle(getWidth(), getHeight() / 2, getWidth(), mAnimBottomPaint);
            break;

        case 3: // '\003'
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, mAnimBottomPaint);
            break;
        }
_L3:
        if (true) goto _L8; else goto _L7
_L7:
_L4:
        switch (type)
        {
        case 0: // '\0'
            mPath.reset();
            mPath.addCircle(actionDownX, actionDownY, mCircleRadius, android.graphics.Path.Direction.CCW);
            canvas.drawPath(mPath, mCirclePaint);
            canvas.clipPath(mPath, android.graphics.Region.Op.XOR);
            if (mAnimMode == 0)
            {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCircleRadiusMax, mAnimBottomPaint);
            } else
            {
                canvas.drawPaint(mAnimBottomPaint);
            }
            break;

        case 1: // '\001'
            mPath.reset();
            mPath.addCircle(0.0F, getHeight() / 2, mCircleRadius, android.graphics.Path.Direction.CCW);
            canvas.drawPath(mPath, mCirclePaint);
            canvas.clipPath(mPath, android.graphics.Region.Op.XOR);
            canvas.drawCircle(0.0F, getHeight() / 2, mCircleRadiusMax, mAnimBottomPaint);
            break;

        case 2: // '\002'
            mPath.reset();
            mPath.addCircle(getWidth(), getHeight() / 2, mCircleRadius, android.graphics.Path.Direction.CCW);
            canvas.drawPath(mPath, mCirclePaint);
            canvas.clipPath(mPath, android.graphics.Region.Op.XOR);
            canvas.drawCircle(getWidth(), getHeight() / 2, mCircleRadiusMax, mAnimBottomPaint);
            break;

        case 3: // '\003'
            mPath.reset();
            mPath.addCircle(getWidth() / 2, getHeight() / 2, mCircleRadius, android.graphics.Path.Direction.CCW);
            canvas.drawPath(mPath, mCirclePaint);
            canvas.clipPath(mPath, android.graphics.Region.Op.XOR);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCircleRadiusMax, mAnimBottomPaint);
            break;
        }
        if (true) goto _L8; else goto _L9
_L9:
_L6:
        switch (type)
        {
        case 0: // '\0'
            if (mAnimMode == 0)
            {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCircleRadius, mAnimBottomPaint);
            } else
            {
                canvas.drawPaint(mAnimBottomPaint);
            }
            break;

        case 1: // '\001'
            canvas.drawCircle(0.0F, getHeight() / 2, mCircleRadius, mAnimBottomPaint);
            break;

        case 2: // '\002'
            canvas.drawCircle(getWidth(), getHeight() / 2, mCircleRadius, mAnimBottomPaint);
            break;

        case 3: // '\003'
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCircleRadius, mAnimBottomPaint);
            break;
        }
        if (true) goto _L8; else goto _L10
_L10:
        if (true) goto _L12; else goto _L11
_L11:
    }

    public int[] getMeasureSize(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        int k = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        if (l != 0x40000000)
        {
            if (l == 0x80000000)
            {
                i = Math.min(mBackgroundWidth, i);
            } else
            {
                i = mBackgroundWidth;
            }
        }
        if (k != 0x40000000)
        {
            if (k == 0x80000000)
            {
                j = Math.min(mBackgroundHeight, j);
            } else
            {
                j = mBackgroundHeight;
            }
        }
        return (new int[] {
            i, j
        });
    }

    public boolean needBackgroundMeasure()
    {
        return mBackgroundWidth > 0 && mBackgroundHeight > 0;
    }

    public void onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 4: default 40
    //                   0 48
    //                   1 178
    //                   2 40
    //                   3 165
    //                   4 165;
           goto _L1 _L2 _L3 _L1 _L4 _L4
_L1:
        mDependView.invalidate();
        return;
_L2:
        if (status != 0)
        {
            resetStatus();
        }
        actionDownX = motionevent.getX();
        actionDownY = motionevent.getY();
        mAnimMode;
        JVM INSTR tableswitch 0 2: default 104
    //                   0 112
    //                   1 137
    //                   2 151;
           goto _L5 _L6 _L7 _L8
_L5:
        status = 2;
        continue; /* Loop/switch isn't completed */
_L6:
        actionDownX = getWidth() / 2;
        actionDownY = getHeight() / 2;
          goto _L5
_L7:
        actionDownY = getHeight() / 2;
          goto _L5
_L8:
        actionDownX = getWidth() / 2;
          goto _L5
_L4:
        if (status == 2)
        {
            status = 1;
        }
_L3:
        if (status == 3)
        {
            reset();
        } else
        if (status == 2)
        {
            status = 1;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onVisibilityChanged(View view, int i)
    {
        if (i != 0)
        {
            resetStatus();
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (!flag)
        {
            resetStatus();
        }
    }

    public void performClick()
    {
        if (status != 4)
        {
            status = 1;
        }
        if (!mNeedDelayClick)
        {
            if (mCallBack != null)
            {
                mCallBack.perfirmSuperClick();
            }
        } else
        if (status == 3)
        {
            if (mCallBack != null)
            {
                mCallBack.perfirmSuperClick();
                return;
            }
        } else
        {
            hasClick = true;
            return;
        }
    }

    public void resetStatus()
    {
        status = 0;
        hasClick = false;
        mCircleRadius = getHeight() / 4;
        mAnimColorAlpha = 0;
    }

    public void setBackground(Drawable drawable)
    {
        mBackgroundDrawable = drawable;
        mBackgroundColor = 0;
        if (mBackgroundDrawable != null)
        {
            mBackgroundWidth = mBackgroundDrawable.getIntrinsicWidth();
            mBackgroundHeight = mBackgroundDrawable.getIntrinsicHeight();
        }
        mDependView.requestLayout();
        mDependView.invalidate();
    }

    public void setBackgroundColor(int i)
    {
        mBackgroundDrawable = null;
        mBackgroundColor = i;
    }

    public void setColor(int i)
    {
        mAnimFullColor = i;
        initColorInfo();
    }

    public void setDelayClick(boolean flag)
    {
        mNeedDelayClick = flag;
    }

    public void setType(int i)
    {
        type = i;
        init();
    }
}
