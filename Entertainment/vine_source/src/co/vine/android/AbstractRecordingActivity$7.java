// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.animation.Animation;
import co.vine.android.animation.SimpleAnimationListener;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class tener extends SimpleAnimationListener
{

    final AbstractRecordingActivity this$0;
    final boolean val$animate;

    public void onAnimationEnd(Animation animation)
    {
        AbstractRecordingActivity.access$700(AbstractRecordingActivity.this);
    }

    public void onAnimationStart(Animation animation)
    {
        if (val$animate)
        {
            AbstractRecordingActivity.access$500(AbstractRecordingActivity.this).setVisibility(0);
            return;
        } else
        {
            AbstractRecordingActivity.access$500(AbstractRecordingActivity.this).setVisibility(8);
            AbstractRecordingActivity.access$600(AbstractRecordingActivity.this).setVisibility(8);
            return;
        }
    }

    tener()
    {
        this$0 = final_abstractrecordingactivity;
        val$animate = Z.this;
        super();
    }
}
