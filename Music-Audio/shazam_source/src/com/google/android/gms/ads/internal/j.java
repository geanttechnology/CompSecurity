// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.p;
import com.google.android.gms.ads.internal.client.q;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.d.bs;
import com.google.android.gms.d.bt;
import com.google.android.gms.d.bu;
import com.google.android.gms.d.bv;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.id;

// Referenced classes of package com.google.android.gms.ads.internal:
//            i

public final class j extends com.google.android.gms.ads.internal.client.r.a
{

    private p a;
    private bs b;
    private bt c;
    private id d;
    private id e;
    private NativeAdOptionsParcel f;
    private final Context g;
    private final dg h;
    private final String i;
    private final VersionInfoParcel j;

    public j(Context context, String s, dg dg, VersionInfoParcel versioninfoparcel)
    {
        g = context;
        i = s;
        h = dg;
        j = versioninfoparcel;
        e = new id();
        d = new id();
    }

    public final q a()
    {
        return new i(g, i, h, j, a, b, c, e, d, f);
    }

    public final void a(p p)
    {
        a = p;
    }

    public final void a(NativeAdOptionsParcel nativeadoptionsparcel)
    {
        f = nativeadoptionsparcel;
    }

    public final void a(bs bs)
    {
        b = bs;
    }

    public final void a(bt bt)
    {
        c = bt;
    }

    public final void a(String s, bv bv, bu bu)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        } else
        {
            e.put(s, bv);
            d.put(s, bu);
            return;
        }
    }
}
