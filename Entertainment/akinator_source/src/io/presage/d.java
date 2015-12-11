// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.view.View;
import android.view.WindowManager;
import io.presage.utils.IADHandler;

// Referenced classes of package io.presage:
//            Presage

final class d
    implements IADHandler
{

    final View a;
    final WindowManager b;
    final Presage c;

    d(Presage presage, View view, WindowManager windowmanager)
    {
        c = presage;
        a = view;
        b = windowmanager;
        super();
    }

    public final void onAdClosed()
    {
        if (a.getWindowToken() != null)
        {
            b.removeView(a);
        }
    }

    public final void onAdFound()
    {
    }

    public final void onAdNotFound()
    {
        if (a.getWindowToken() != null)
        {
            b.removeView(a);
        }
    }
}
