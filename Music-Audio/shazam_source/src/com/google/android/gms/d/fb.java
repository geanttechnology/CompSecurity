// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.n;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            fe, gi, ff, ac, 
//            ey, ay, ax, io, 
//            he, fd, fc, o, 
//            dg, be, gb

public final class fb
{
    public static interface a
    {

        public abstract void b(gb gb);
    }


    public fb()
    {
    }

    public static gi a(Context context, com.google.android.gms.ads.internal.a a1, gb.a a2, o o, he he1, dg dg, a a3, be be)
    {
        AdResponseParcel adresponseparcel = a2.b;
        if (adresponseparcel.h)
        {
            context = new fe(context, a2, he1, dg, a3, be);
        } else
        if (adresponseparcel.t)
        {
            if (a1 instanceof n)
            {
                context = new ff(context, (n)a1, new ac(), a2, o, a3);
            } else
            {
                a2 = new StringBuilder("Invalid NativeAdManager type. Found: ");
                if (a1 != null)
                {
                    context = a1.getClass().getName();
                } else
                {
                    context = "null";
                }
                throw new IllegalArgumentException(a2.append(context).append("; Required: NativeAdManager.").toString());
            }
        } else
        if (adresponseparcel.p)
        {
            context = new ey(context, a2, he1, a3);
        } else
        {
            a1 = ay.R;
            if (((Boolean)p.n().a(a1)).booleanValue() && com.google.android.gms.d.io.a(19) && !com.google.android.gms.d.io.a(21) && he1.h().e)
            {
                context = new fd(context, a2, he1, a3);
            } else
            {
                context = new fc(context, a2, he1, a3);
            }
        }
        (new StringBuilder("AdRenderer: ")).append(context.getClass().getName());
        b.a(3);
        context.e();
        return context;
    }
}
