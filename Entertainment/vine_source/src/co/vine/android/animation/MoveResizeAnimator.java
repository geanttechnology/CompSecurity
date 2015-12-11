// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.animation;

import android.view.View;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.animation:
//            SmoothAnimator

public class MoveResizeAnimator extends SmoothAnimator
{

    private final int mDeltaHeight;
    private final int mDeltaWidth;
    private final float mDeltaX;
    private final float mDeltaY;
    private int mId;
    private SmoothAnimator.AnimationListener mListener;
    private final int mOriginalHeight;
    private final int mOriginalWidth;
    private final int mOriginalX;
    private final int mOriginalY;
    private final android.widget.RelativeLayout.LayoutParams mParam;
    private Object mTag;
    private final View mTarget;
    private final int mTargetHeight;
    private final int mTargetWidth;

    public MoveResizeAnimator(int i, View view, int j, double d, double d1, 
            int k, SmoothAnimator.AnimationListener animationlistener, Object obj)
    {
        this(i, view, view, 0, j, d, d1, k, animationlistener, obj);
    }

    public MoveResizeAnimator(int i, View view, View view1, int j, int k, double d, 
            double d1, int l, SmoothAnimator.AnimationListener animationlistener, Object obj)
    {
        super(view, 0.05F, l);
        mTarget = view;
        mParam = (android.widget.RelativeLayout.LayoutParams)view.getLayoutParams();
        mDeltaX = mParam.leftMargin - j;
        mDeltaY = mParam.topMargin - k;
        mOriginalX = mParam.leftMargin;
        mOriginalY = mParam.topMargin;
        if (mParam.width < 3)
        {
            mParam.width = view1.getMeasuredWidth();
        }
        if (mParam.height < 3)
        {
            mParam.height = view1.getMeasuredHeight();
        }
        mTargetWidth = (int)((double)mParam.width * d);
        mTargetHeight = (int)((double)mParam.height * d1);
        mOriginalWidth = mParam.width;
        mOriginalHeight = mParam.height;
        mDeltaWidth = mTargetWidth - mParam.width;
        mDeltaHeight = mTargetHeight - mParam.height;
        mListener = animationlistener;
        mTag = obj;
        mId = i;
    }

    public void onStop()
    {
        if (mListener != null)
        {
            mListener.onAnimationFinish(mId, mTag);
        }
    }

    public void onUpdate(float f, float f1)
    {
        mParam.leftMargin = mOriginalX - (int)(mDeltaX * f1);
        mParam.topMargin = mOriginalY - (int)(mDeltaY * f1);
        if (mTargetWidth != mParam.width)
        {
            mParam.width = (int)((float)mOriginalWidth + (float)mDeltaWidth * f1);
        }
        if (mTargetHeight != mParam.height)
        {
            mParam.height = (int)((float)mOriginalHeight + (float)mDeltaHeight * f1);
        }
        SLog.d("Modifying {}: {} {} {} {}", new Object[] {
            mTarget, Integer.valueOf(mParam.leftMargin), Integer.valueOf(mParam.topMargin), Integer.valueOf(mParam.width), Integer.valueOf(mParam.height)
        });
        mTarget.setLayoutParams(mParam);
    }
}
