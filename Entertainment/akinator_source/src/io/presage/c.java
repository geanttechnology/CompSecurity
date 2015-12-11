// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.view.View;
import android.view.WindowManager;

// Referenced classes of package io.presage:
//            Presage

final class c
    implements Runnable
{

    final View a;
    final WindowManager b;
    final Presage c;

    c(Presage presage, View view, WindowManager windowmanager)
    {
        c = presage;
        a = view;
        b = windowmanager;
        super();
    }

    public final void run()
    {
        if (a.getWindowToken() != null)
        {
            b.removeView(a);
        }
    }
}
