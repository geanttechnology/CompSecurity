// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.aviary.android.feather.common.log.LoggerFactory;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class AviaryImageViewUndoRedo extends ImageViewTouch
{
    public static interface OnHistoryListener
    {

        public abstract void onRedo();

        public abstract void onUndo();
    }


    private static final float MAX_BOUND = 1.1F;
    private static final float MIN_BOUND = 0.9F;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("AviaryImageViewUndoRedo");
    private OnHistoryListener mHistoryListener;
    private int mMaxFling;
    private int mMinFling;
    private int mUndoMinFling;

    public AviaryImageViewUndoRedo(Context context)
    {
        this(context, null);
    }

    public AviaryImageViewUndoRedo(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AviaryImageViewUndoRedo(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mUndoMinFling = 500;
    }

    private boolean isValidScale()
    {
        float f = getScale();
        return f > 0.9F && f < 1.1F;
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
        mMinFling = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        mMaxFling = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        mUndoMinFling = (int)((double)mMinFling * 2D);
        logger.verbose("minFling: %d, maxFling: %d, undoFling: %d", new Object[] {
            Integer.valueOf(mMinFling), Integer.valueOf(mMaxFling), Integer.valueOf(mUndoMinFling)
        });
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (getDrawable() == null || !isShown()) 
        {
            return false;
        }
        logger.info("onFling: %f", new Object[] {
            Float.valueOf(f)
        });
        if (mHistoryListener != null && isValidScale() && Math.abs(f) > (float)mUndoMinFling && Math.abs(f) > Math.abs(f1))
        {
            if (f < 0.0F)
            {
                mHistoryListener.onRedo();
            } else
            {
                mHistoryListener.onUndo();
            }
            return true;
        } else
        {
            return super.onFling(motionevent, motionevent1, f, f1);
        }
    }

    public void setOnHistoryListener(OnHistoryListener onhistorylistener)
    {
        mHistoryListener = onhistorylistener;
    }

}
