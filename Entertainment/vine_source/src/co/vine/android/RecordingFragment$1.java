// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements android.view.animation.istener
{

    final RecordingFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        RecordingFragment.access$100(RecordingFragment.this).setAlpha(0.35F);
        RecordingFragment.access$200(RecordingFragment.this).setVisibility(8);
        RecordingFragment.access$200(RecordingFragment.this).setOnTouchListener(null);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        RecordingFragment.access$000(RecordingFragment.this).setVisibility(8);
    }

    mationListener()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
