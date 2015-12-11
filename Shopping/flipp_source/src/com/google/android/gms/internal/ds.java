// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            x, bz, ew, dw, 
//            ez, w, et

final class ds
    implements Runnable
{

    final Context a;
    final bz b;
    final dw c;
    final String d;

    ds(Context context, bz bz1, dw dw1, String s)
    {
        a = context;
        b = bz1;
        c = dw1;
        d = s;
        super();
    }

    public final void run()
    {
        ew ew1 = ew.a(a, new x(), false, false, null, b.k);
        ew1.setWillNotDraw(true);
        dw dw1 = c;
        synchronized (dw1.a)
        {
            dw1.b = ew1;
        }
        obj = ew1.a;
        ((ez) (obj)).a("/invalidRequest", c.f);
        ((ez) (obj)).a("/loadAdURL", c.g);
        ((ez) (obj)).a("/log", w.f);
        et.a("Getting the ad request URL.");
        ew1.loadDataWithBaseURL("http://googleads.g.doubleclick.net", (new StringBuilder("<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(")).append(d).append(");</script></head><body></body></html>").toString(), "text/html", "UTF-8", null);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
