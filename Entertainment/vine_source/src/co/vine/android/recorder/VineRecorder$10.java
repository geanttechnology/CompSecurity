// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements Runnable
{

    final VineRecorder this$0;

    public void run()
    {
        if (VineRecorder.access$1700(VineRecorder.this) != null)
        {
            VineRecorder.access$1700(VineRecorder.this).setAlpha(0.0F);
            VineRecorder.access$1700(VineRecorder.this).setVisibility(0);
            VineRecorder.access$1700(VineRecorder.this).animate().alpha(1.0F).setDuration(250L).start();
        }
        if (VineRecorder.access$1800(VineRecorder.this) != null)
        {
            int i = VineRecorder.access$1800(VineRecorder.this).getHeight();
            VineRecorder.access$1800(VineRecorder.this).setTranslationY(-i / 2);
            VineRecorder.access$1800(VineRecorder.this).setScaleY(0.0F);
            VineRecorder.access$1800(VineRecorder.this).setVisibility(0);
            VineRecorder.access$1800(VineRecorder.this).animate().scaleY(1.0F).translationY(0.0F).setDuration(250L).start();
        }
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
