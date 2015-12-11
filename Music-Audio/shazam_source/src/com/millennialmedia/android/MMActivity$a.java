// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMActivity, ac

private static final class a extends android.view.or.SimpleOnGestureListener
{

    WeakReference a;

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        motionevent = (MMActivity)a.get();
        if (motionevent != null)
        {
            a(ac.a(((MMActivity) (motionevent)).b));
        }
        return false;
    }

    public ureListener(MMActivity mmactivity)
    {
        a = new WeakReference(mmactivity);
    }
}
