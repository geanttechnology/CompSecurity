// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ToggleButton;
import co.vine.android.animation.SimpleAnimationListener;
import co.vine.android.recorder.VineRecorder;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class ationListener extends SimpleAnimationListener
{

    final RecordingFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        if (RecordingFragment.access$800(RecordingFragment.this) != null)
        {
            RecordingFragment.access$800(RecordingFragment.this).setGridOn(true);
        }
        RecordingFragment.access$1000(RecordingFragment.this).setVisibility(0);
    }

    public void onAnimationStart(Animation animation)
    {
        RecordingFragment.access$1000(RecordingFragment.this).setVisibility(0);
        RecordingFragment.access$600(RecordingFragment.this).setChecked(true);
    }

    r()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
