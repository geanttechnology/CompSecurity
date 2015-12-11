// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

// Referenced classes of package android.support.v7:
//            rs, pw, te, kr, 
//            pp, pz, ps, nt, 
//            ul

public class rx extends rs
{

    protected pw a;
    private pz i;
    private pp j;
    private ps k;
    private final nt l;

    rx(Context context, te.a a1, ul ul, pz pz, ru.a a2, nt nt)
    {
        super(context, a1, ul, a2);
        i = pz;
        k = a1.c;
        l = nt;
    }

    protected te a(int i1)
    {
        AdRequestInfoParcel adrequestinfoparcel = g.a;
        com.google.android.gms.ads.internal.client.AdRequestParcel adrequestparcel = adrequestinfoparcel.zzDy;
        ul ul = d;
        java.util.List list = h.zzyw;
        java.util.List list1 = h.zzyx;
        java.util.List list2 = h.zzDZ;
        int j1 = h.orientation;
        long l1 = h.zzyA;
        String s1 = adrequestinfoparcel.zzDB;
        boolean flag = h.zzDX;
        pq pq;
        qa qa;
        String s;
        pu pu;
        ps ps;
        if (a != null)
        {
            pq = a.b;
        } else
        {
            pq = null;
        }
        if (a != null)
        {
            qa = a.c;
        } else
        {
            qa = null;
        }
        if (a != null)
        {
            s = a.d;
        } else
        {
            s = android/support/v7/kr.getName();
        }
        ps = k;
        if (a != null)
        {
            pu = a.e;
        } else
        {
            pu = null;
        }
        return new te(adrequestparcel, ul, list, i1, list1, list2, j1, l1, s1, flag, pq, qa, s, ps, pu, h.zzDY, g.d, h.zzDW, g.f, h.zzEb, h.zzEc, g.h, null, adrequestinfoparcel.zzDO);
    }

    protected void b(long l1)
        throws rs.a
    {
        synchronized (f)
        {
            j = new pp(c, g.a, i, k, h.zzsJ);
        }
        a = j.a(l1, 60000L, l);
        switch (a.a)
        {
        default:
            throw new rs.a((new StringBuilder()).append("Unexpected mediation result: ").append(a.a).toString(), 0);

        case 1: // '\001'
            throw new rs.a("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onStop()
    {
        synchronized (f)
        {
            super.onStop();
            if (j != null)
            {
                j.a();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
