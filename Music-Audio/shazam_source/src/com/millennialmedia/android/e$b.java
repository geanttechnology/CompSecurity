// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.view.animation.Animation;
import android.widget.Button;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            e, al

private static final class t>
    implements android.view.animation.ation.AnimationListener
{

    private WeakReference a;

    public final void onAnimationEnd(Animation animation)
    {
        animation = (e)a.get();
        if (animation != null)
        {
            animation = (Activity)animation.getContext();
            al.b();
            animation.finish();
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        animation = (e)a.get();
        if (animation != null && e.b(animation) != null)
        {
            e.b(animation).setVisibility(8);
        }
    }

    public (e e1)
    {
        a = new WeakReference(e1);
    }
}
