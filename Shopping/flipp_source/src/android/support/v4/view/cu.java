// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package android.support.v4.view:
//            cv, cw

final class cu
{

    public static void a(View view, cw cw)
    {
        if (cw != null)
        {
            view.animate().setListener(new cv(cw, view));
            return;
        } else
        {
            view.animate().setListener(null);
            return;
        }
    }
}
