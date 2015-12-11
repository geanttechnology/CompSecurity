// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.he;

// Referenced classes of package com.google.android.gms.ads.internal:
//            p

public final class e
{
    public static interface a
    {

        public abstract void a(String s);
    }

    public static final class b
        implements a
    {

        private final com.google.android.gms.d.gb.a a;
        private final he b;

        public final void a(String s)
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            android.net.Uri.Builder builder = new android.net.Uri.Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(s))
            {
                builder.appendQueryParameter("navigationURL", s);
            }
            if (a != null && a.b != null && !TextUtils.isEmpty(a.b.o))
            {
                builder.appendQueryParameter("debugDialog", a.b.o);
            }
            p.e();
            gm.a(b.getContext(), b.l().b, builder.toString());
        }

        public b(com.google.android.gms.d.gb.a a1, he he1)
        {
            a = a1;
            b = he1;
        }
    }


    a a;
    boolean b;
    private boolean c;

    public e()
    {
        com.google.android.gms.d.au au = ay.i;
        c = ((Boolean)p.n().a(au)).booleanValue();
    }

    public e(byte byte0)
    {
        c = false;
    }

    public final void a(String s)
    {
        com.google.android.gms.ads.internal.util.client.b.a(3);
        if (a != null)
        {
            a.a(s);
        }
    }

    public final boolean a()
    {
        return !c || b;
    }
}
