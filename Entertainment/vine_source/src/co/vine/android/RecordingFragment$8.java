// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements android.view.
{

    final RecordingFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view.getVisibility() == 0)
        {
            view = AnimationUtils.loadAnimation(getActivity(), 0x7f04000f);
            view.setAnimationListener(RecordingFragment.access$1100(RecordingFragment.this));
            RecordingFragment.access$300(RecordingFragment.this).startAnimation(view);
        }
        return false;
    }

    s()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
