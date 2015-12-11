// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.flurry.android:
//            dh, FlurryAds, p, FlurryAdSize, 
//            ak

final class v extends RelativeLayout
{

    private static String p = "FlurryAgent";
    private final Context Q;
    private final FlurryAds ae;
    private final String af;
    private final ViewGroup ag;
    private long ah;
    private final ScheduledExecutorService ai;
    private final Runnable aj = new dh(this);
    private ScheduledFuture ak;

    public v(FlurryAds flurryads, Context context, String s, ViewGroup viewgroup, ScheduledExecutorService scheduledexecutorservice)
    {
        super(context);
        ae = flurryads;
        Q = context;
        af = s;
        ag = viewgroup;
        ai = scheduledexecutorservice;
    }

    static boolean a(v v1)
    {
        if (!FlurryAds.n(v1.Q)) goto _L2; else goto _L1
_L1:
        (new StringBuilder()).append("Device is locked: banner will NOT rotate for adSpace: ").append(v1.af).toString();
_L4:
        return false;
_L2:
        if (!v1.ae.bg())
        {
            break; /* Loop/switch isn't completed */
        }
        (new StringBuilder()).append("Ad fullscreen panel is opened: banner will NOT rotate for adSpace: ").append(v1.af).toString();
        if (true) goto _L4; else goto _L3
_L3:
        v1 = v1.l();
        if (v1 != null && v1.shouldRotate())
        {
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    static Runnable b(v v1)
    {
        return v1.aj;
    }

    static void c(v v1)
    {
        (new StringBuilder()).append("Rotating banner for adSpace: ").append(v1.af).toString();
        v1.ae.a(v1.Q, v1.af, FlurryAdSize.BANNER_BOTTOM, v1.ag, 1L);
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        k();
        ah = 0L;
        removeCallbacks(aj);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void k()
    {
        if (ak != null)
        {
            (new StringBuilder()).append("cancel banner rotation for adSpace = ").append(af).append(" with fixed rate in milliseconds = ").append(ah).toString();
            ak.cancel(true);
            ak = null;
        }
    }

    private p l()
    {
        if (getChildCount() < 1)
        {
            return null;
        }
        Object obj = getChildAt(0);
        try
        {
            obj = (p)obj;
        }
        catch (ClassCastException classcastexception)
        {
            return null;
        }
        return ((p) (obj));
    }

    public final void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ah != l1)
        {
            k();
            ah = l1;
            if (ai != null && ak == null && 0L != ah)
            {
                (new StringBuilder()).append("schedule banner rotation for adSpace = ").append(af).append(" with fixed rate in milliseconds = ").append(ah).toString();
                ak = ai.scheduleAtFixedRate(new ak(this), ah, ah, TimeUnit.MILLISECONDS);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final ViewGroup h()
    {
        return ag;
    }

    public final String i()
    {
        return af;
    }

    public final void stop()
    {
        j();
        p p1 = l();
        if (p1 != null)
        {
            p1.stop();
        }
    }

}
