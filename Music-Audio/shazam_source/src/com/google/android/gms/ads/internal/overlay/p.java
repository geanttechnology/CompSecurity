// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.bd;
import com.google.android.gms.d.be;
import com.google.android.gms.d.gp;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            i

public final class p
{

    final Context a;
    final String b;
    final bd c;
    final be d;
    final VersionInfoParcel e;
    final gp f = new gp((new com.google.android.gms.d.gp.b()).a("min_1", 4.9406564584124654E-324D, 1.0D).a("1_5", 1.0D, 5D).a("5_10", 5D, 10D).a("10_20", 10D, 20D).a("20_30", 20D, 30D).a("30_max", 30D, 1.7976931348623157E+308D), (byte)0);
    final long g[];
    final String h[];
    bd i;
    bd j;
    bd k;
    bd l;
    boolean m;
    i n;
    boolean o;
    boolean p;
    long q;

    public p(Context context, VersionInfoParcel versioninfoparcel, String s, be be, bd bd)
    {
        q = -1L;
        a = context;
        e = versioninfoparcel;
        b = s;
        d = be;
        c = bd;
        context = ay.v;
        context = (String)com.google.android.gms.ads.internal.p.n().a(context);
        if (context == null)
        {
            h = new String[0];
            g = new long[0];
        } else
        {
            context = TextUtils.split(context, ",");
            h = new String[context.length];
            g = new long[context.length];
            int i1 = 0;
            while (i1 < context.length) 
            {
                try
                {
                    g[i1] = Long.parseLong(context[i1]);
                }
                // Misplaced declaration of an exception variable
                catch (VersionInfoParcel versioninfoparcel)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(5);
                    g[i1] = -1L;
                }
                i1++;
            }
        }
    }
}
