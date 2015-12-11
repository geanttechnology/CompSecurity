// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ao, ad

private static final class >
    implements android.view.OnTouchListener
{

    WeakReference a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        view = (ao)a.get();
        boolean flag;
        if (motionevent.getAction() == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (view != null)
        {
            return flag && (view.getParent() instanceof ad);
        } else
        {
            return flag;
        }
    }

    (ao ao1)
    {
        a = new WeakReference(ao1);
    }
}
