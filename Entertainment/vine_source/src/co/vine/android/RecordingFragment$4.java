// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements android.view.
{

    final RecordingFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        RecordingFragment.access$500(RecordingFragment.this).setAnimationListener(RecordingFragment.access$400(RecordingFragment.this));
        RecordingFragment.access$200(RecordingFragment.this).startAnimation(RecordingFragment.access$500(RecordingFragment.this));
        RecordingFragment.access$100(RecordingFragment.this).setAlpha(0.35F);
        return true;
    }

    ()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
