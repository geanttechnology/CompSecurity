// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.util.a;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads:
//            h, e

class j
    implements MediationBannerListener
{

    private final h a;
    private boolean b;

    public j(h h1)
    {
        a = h1;
    }

    public void onClick(MediationBannerAdapter mediationbanneradapter)
    {
        synchronized (a)
        {
            com.google.ads.util.a.a(a.c());
            a.j().a(a, b);
        }
        return;
        exception;
        mediationbanneradapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDismissScreen(MediationBannerAdapter mediationbanneradapter)
    {
        synchronized (a)
        {
            a.j().b(a);
        }
        return;
        exception;
        mediationbanneradapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onFailedToReceiveAd(MediationBannerAdapter mediationbanneradapter, AdRequest.ErrorCode errorcode)
    {
        h h1 = a;
        h1;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(mediationbanneradapter, a.i());
        com.google.ads.util.b.a((new StringBuilder()).append("Mediation adapter ").append(mediationbanneradapter.getClass().getName()).append(" failed to receive ad with error code: ").append(errorcode).toString());
        if (a.c()) goto _L2; else goto _L1
_L1:
        h h2;
        h2 = a;
        if (errorcode != AdRequest.ErrorCode.NO_FILL)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        mediationbanneradapter = com.google.ads.g.a.b;
_L4:
        h2.a(false, mediationbanneradapter);
_L2:
        return;
        mediationbanneradapter = g.a.c;
        if (true) goto _L4; else goto _L3
_L3:
        mediationbanneradapter;
        h1;
        JVM INSTR monitorexit ;
        throw mediationbanneradapter;
    }

    public void onLeaveApplication(MediationBannerAdapter mediationbanneradapter)
    {
        synchronized (a)
        {
            a.j().c(a);
        }
        return;
        exception;
        mediationbanneradapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onPresentScreen(MediationBannerAdapter mediationbanneradapter)
    {
        synchronized (a)
        {
            a.j().a(a);
        }
        return;
        exception;
        mediationbanneradapter;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onReceivedAd(MediationBannerAdapter mediationbanneradapter)
    {
        h h1 = a;
        h1;
        JVM INSTR monitorenter ;
        com.google.ads.util.a.a(mediationbanneradapter, a.i());
        a.a(mediationbanneradapter.getBannerView());
        if (a.c())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        b = false;
        a.a(true, com.google.ads.g.a.a);
        return;
        mediationbanneradapter;
        com.google.ads.util.b.b((new StringBuilder()).append("Error while getting banner View from adapter (").append(a.h()).append("): ").toString(), mediationbanneradapter);
        if (!a.c())
        {
            a.a(false, g.a.f);
        }
        h1;
        JVM INSTR monitorexit ;
        return;
        mediationbanneradapter;
        h1;
        JVM INSTR monitorexit ;
        throw mediationbanneradapter;
        b = true;
        a.j().a(a, a.f());
        h1;
        JVM INSTR monitorexit ;
    }
}
