// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            CropImageView, HighlightView

class this._cls0 extends android.view.tener
{

    final CropImageView this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (CropImageView.access$800(CropImageView.this))
        {
            CropImageView.access$102(CropImageView.this, null);
            float f = getScale();
            f = CropImageView.access$900(CropImageView.this, f, getMaxScale(), getMinScale());
            f = Math.min(getMaxScale(), Math.max(f, 1.0F));
            CropImageView.access$1000(CropImageView.this, f, motionevent.getX(), motionevent.getY(), 200L);
            invalidate();
        }
        return super.onDoubleTap(motionevent);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        CropImageView.access$102(CropImageView.this, null);
        Object obj = CropImageView.access$000(CropImageView.this);
        if (obj != null)
        {
            int i = ((HighlightView) (obj)).getHit(motionevent.getX(), motionevent.getY());
            if (i != 1)
            {
                CropImageView.access$202(CropImageView.this, i);
                CropImageView.access$102(CropImageView.this, ((HighlightView) (obj)));
                HighlightView highlightview = CropImageView.access$100(CropImageView.this);
                if (i == 32)
                {
                    obj = this._fld0;
                } else
                {
                    obj = this._fld0;
                }
                highlightview.setMode(((this._cls0) (obj)), i);
                postInvalidate();
            }
        }
        return super.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || CropImageView.access$700(CropImageView.this).isInProgress() || CropImageView.access$100(CropImageView.this) != null) 
        {
            return false;
        }
        return super.onFling(motionevent, motionevent1, f, f1);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || CropImageView.access$400(CropImageView.this).isInProgress()) 
        {
            return false;
        }
        CropImageView.access$502(CropImageView.this, true);
        if (CropImageView.access$100(CropImageView.this) != null && CropImageView.access$200(CropImageView.this) != 1)
        {
            CropImageView.access$100(CropImageView.this).handleMotion(CropImageView.access$200(CropImageView.this), -f, -f1);
            if (CropImageView.access$200(CropImageView.this) == 32)
            {
                invalidate(CropImageView.access$100(CropImageView.this).getInvalidateRect());
            } else
            {
                postInvalidate();
            }
            CropImageView.access$600(CropImageView.this, CropImageView.access$100(CropImageView.this));
            return true;
        } else
        {
            scrollBy(-f, -f1);
            invalidate();
            return true;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        CropImageView.access$102(CropImageView.this, null);
        return super.onSingleTapConfirmed(motionevent);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        CropImageView.access$102(CropImageView.this, null);
        if (CropImageView.access$000(CropImageView.this) != null && CropImageView.access$200(CropImageView.this) == 32 && CropImageView.access$300(CropImageView.this) != null)
        {
            CropImageView.access$300(CropImageView.this).onSingleTapUpConfirmed();
        }
        return super.onSingleTapUp(motionevent);
    }

    UpConfirmedListener()
    {
        this$0 = CropImageView.this;
        super();
    }
}
