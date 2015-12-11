// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            da, di, cx, dk

class dd extends da
{

    dd()
    {
    }

    public final void a(cx cx, View view, dk dk)
    {
        if (dk != null)
        {
            view.animate().setListener(new di(dk, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }
}
