// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.aio.downloader.views:
//            IMaterial, MaterialStyle

public class LImageButton extends ImageView
    implements IMaterial
{

    public int mImageResId;
    private MaterialStyle mMaterialStyle;

    public LImageButton(Context context)
    {
        this(context, null);
    }

    public LImageButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMaterialStyle = new MaterialStyle(this, attributeset);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled())
        {
            return false;
        } else
        {
            return super.dispatchTouchEvent(motionevent);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (!isEnabled())
        {
            super.onDraw(canvas);
            return;
        } else
        {
            mMaterialStyle.doDraw(canvas);
            super.onDraw(canvas);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        if (mMaterialStyle != null)
        {
            if (mMaterialStyle.needBackgroundMeasure())
            {
                int ai[] = mMaterialStyle.getMeasureSize(i, j);
                setMeasuredDimension(ai[0], ai[1]);
                return;
            } else
            {
                super.onMeasure(i, j);
                return;
            }
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mMaterialStyle != null)
        {
            mMaterialStyle.onTouchEvent(motionevent);
        }
        return super.onTouchEvent(motionevent);
    }

    protected void onVisibilityChanged(View view, int i)
    {
        super.onVisibilityChanged(view, i);
        if (mMaterialStyle != null)
        {
            mMaterialStyle.onVisibilityChanged(view, i);
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (mMaterialStyle != null)
        {
            mMaterialStyle.onWindowFocusChanged(flag);
        }
    }

    public void perfirmSuperClick()
    {
        super.performClick();
    }

    public boolean performClick()
    {
        if (mMaterialStyle != null)
        {
            mMaterialStyle.performClick();
            return true;
        } else
        {
            return super.performClick();
        }
    }

    public void setBackground(Drawable drawable)
    {
        if (mMaterialStyle != null)
        {
            mMaterialStyle.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i)
    {
        if (mMaterialStyle != null)
        {
            mMaterialStyle.setBackgroundColor(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        setBackground(drawable);
    }

    public void setBackgroundResource(int i)
    {
        setBackground(getResources().getDrawable(i));
    }

    public void setColor(int i)
    {
        mMaterialStyle.setColor(i);
    }

    public void setDelayClick(boolean flag)
    {
        mMaterialStyle.setDelayClick(flag);
    }

    public void setImageResource(int i)
    {
        super.setImageResource(i);
        mImageResId = i;
    }

    public void setType(int i)
    {
        mMaterialStyle.setType(i);
    }
}
