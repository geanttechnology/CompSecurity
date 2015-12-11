// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.f;
import com.google.android.gms.ads.internal.client.g;
import com.google.android.gms.ads.internal.client.j;
import com.google.android.gms.ads.internal.client.q;
import com.google.android.gms.ads.internal.client.r;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.d.bx;
import com.google.android.gms.d.by;
import com.google.android.gms.d.df;

// Referenced classes of package com.google.android.gms.ads:
//            a

public class b
{
    public static final class a
    {

        private final Context a;
        private final r b;

        public final a a(com.google.android.gms.ads.a a1)
        {
            try
            {
                b.a(new f(a1));
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.ads.a a1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return this;
            }
            return this;
        }

        public final a a(com.google.android.gms.ads.b.b b1)
        {
            try
            {
                b.a(new NativeAdOptionsParcel(b1));
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.ads.b.b b1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return this;
            }
            return this;
        }

        public final a a(com.google.android.gms.ads.b.d.a a1)
        {
            try
            {
                b.a(new bx(a1));
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.ads.b.d.a a1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return this;
            }
            return this;
        }

        public final a a(com.google.android.gms.ads.b.e.a a1)
        {
            try
            {
                b.a(new by(a1));
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.ads.b.e.a a1)
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
                return this;
            }
            return this;
        }

        public final b a()
        {
            b b1;
            try
            {
                b1 = new b(a, b.a());
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.ads.internal.util.client.b.a("Failed to build AdLoader.", remoteexception);
                return null;
            }
            return b1;
        }

        private a(Context context, r r1)
        {
            a = context;
            b = r1;
        }

        public a(Context context, String s)
        {
            this(context, g.a(context, s, new df()));
        }
    }


    public final Context a;
    public final q b;
    private final j c;

    b(Context context, q q)
    {
        this(context, q, j.a());
    }

    private b(Context context, q q, j j1)
    {
        a = context;
        b = q;
        c = j1;
    }
}
