// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, ProgressView

class this._cls0
    implements Runnable
{

    final VineRecorder this$0;

    public void run()
    {
        if (VineRecorder.access$1500(VineRecorder.this) != null)
        {
            VineRecorder.access$1500(VineRecorder.this).setAlpha(0.0F);
            VineRecorder.access$1500(VineRecorder.this).setVisibility(0);
            VineRecorder.access$1500(VineRecorder.this).animate().alpha(1.0F).setDuration(250L).start();
        }
        if (mTopMaskView != null)
        {
            mTopMaskView.setAlpha(0.0F);
            mTopMaskView.setVisibility(0);
            mTopMaskView.animate().alpha(1.0F).setDuration(250L).start();
        }
        if (mProgressView != null)
        {
            mProgressView.setTranslationY(VineRecorder.access$1600(VineRecorder.this));
            mProgressView.setScaleY(0.0F);
            mProgressView.setVisibility(0);
            mProgressView.animate().scaleY(1.0F).translationY(0.0F).setDuration(250L).start();
        }
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
