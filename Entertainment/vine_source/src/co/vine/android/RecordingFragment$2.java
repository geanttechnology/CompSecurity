// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.ViewGroup;
import android.view.animation.Animation;

// Referenced classes of package co.vine.android:
//            RecordingFragment

class this._cls0
    implements android.view.animation.istener
{

    final RecordingFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        RecordingFragment.access$300(RecordingFragment.this).setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    mationListener()
    {
        this$0 = RecordingFragment.this;
        super();
    }
}
