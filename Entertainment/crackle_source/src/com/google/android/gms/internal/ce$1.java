// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            ce, x, bz, cw, 
//            cg, cx, am, ct

static final class hI
    implements Runnable
{

    final Context hF;
    final bz hG;
    final cg hH;
    final String hI;

    public void run()
    {
        cw cw1 = cw.a(hF, new x(), false, false, null, hG.ej);
        cw1.setWillNotDraw(true);
        hH.b(cw1);
        cx cx1 = cw1.aC();
        cx1.a("/invalidRequest", hH.hM);
        cx1.a("/loadAdURL", hH.hN);
        cx1.a("/log", am.fs);
        ct.r("Getting the ad request URL.");
        cw1.loadDataWithBaseURL("http://googleads.g.doubleclick.net", (new StringBuilder()).append("<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(").append(hI).append(");</script></head><body></body></html>").toString(), "text/html", "UTF-8", null);
    }

    (Context context, bz bz1, cg cg1, String s)
    {
        hF = context;
        hG = bz1;
        hH = cg1;
        hI = s;
        super();
    }
}
