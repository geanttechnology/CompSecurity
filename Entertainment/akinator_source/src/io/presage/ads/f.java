// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import io.presage.utils.e;

// Referenced classes of package io.presage.ads:
//            NewAdController, NewAd, NewAdViewer

final class f
    implements Runnable
{

    final NewAdController a;

    f(NewAdController newadcontroller)
    {
        a = newadcontroller;
        super();
    }

    public final void run()
    {
        e.b(new String[] {
            "Hidding the ad", a.b.getId()
        });
        a.d.hide();
        a.d = null;
    }
}
