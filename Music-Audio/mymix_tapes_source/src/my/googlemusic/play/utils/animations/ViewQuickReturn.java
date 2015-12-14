// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.animations;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

public class ViewQuickReturn
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    static final boolean $assertionsDisabled;
    private boolean mHidden;
    private int mMaxTranslation;
    private float mOldY;
    private ScrollSettleHandler mScrollSettleHandler;
    private View mViewContainer;
    private View mViewTranslation;

    public ViewQuickReturn(View view, View view1)
    {
    /* block-local class not found */
    class ScrollSettleHandler {}

        mScrollSettleHandler = new ScrollSettleHandler();
        mViewContainer = view;
        mViewTranslation = view1;
        view = mViewTranslation.getViewTreeObserver();
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        } else
        {
            view.addOnGlobalLayoutListener(this);
            return;
        }
    }

    public void onDownMotionEvent(MotionEvent motionevent)
    {
        mOldY = motionevent.getY();
    }

    public void onGlobalLayout()
    {
        ViewTreeObserver viewtreeobserver = mViewTranslation.getViewTreeObserver();
        if (viewtreeobserver != null)
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                viewtreeobserver.removeGlobalOnLayoutListener(this);
            } else
            {
                viewtreeobserver.removeOnGlobalLayoutListener(this);
            }
        }
        mMaxTranslation = mViewTranslation.getHeight();
    }

    public void onMoveMotionEvent(MotionEvent motionevent)
    {
        float f = motionevent.getY();
        if (f - mOldY <= 0.0F || !mHidden) goto _L2; else goto _L1
_L1:
        mHidden = false;
        mScrollSettleHandler.onScroll();
_L4:
        mOldY = f;
        return;
_L2:
        if (f - mOldY < 0.0F && !mHidden)
        {
            mHidden = true;
            mScrollSettleHandler.onScroll();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/utils/animations/ViewQuickReturn.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



}
