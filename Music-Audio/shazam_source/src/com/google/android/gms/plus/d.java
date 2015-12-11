// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.iq;
import com.google.android.gms.d.jo;
import com.google.android.gms.d.jp;
import com.google.android.gms.d.jq;
import com.google.android.gms.d.jr;
import com.google.android.gms.d.js;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            b, c, a, f, 
//            e

public final class d
{
    public static final class a
    {

        final String a;
        final Set b;

        private a()
        {
            a = null;
            b = new HashSet();
        }

        a(byte byte0)
        {
            this();
        }

        private a(a a1)
        {
            a = a1.a;
            b = a1.b;
        }

        public a(a a1, byte byte0)
        {
            this(a1);
        }
    }

    public static final class a.a
    {

        String a;
        public final Set b = new HashSet();

        public a.a()
        {
        }
    }

    public static abstract class b extends com.google.android.gms.common.api.k.a
    {

        public b(c c1)
        {
            super(com.google.android.gms.plus.d.a, c1);
        }
    }


    public static final com.google.android.gms.common.api.a.c a;
    static final com.google.android.gms.common.api.a.a b;
    public static final com.google.android.gms.common.api.a c;
    public static final Scope d = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope e = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final com.google.android.gms.plus.b f = new jr();
    public static final com.google.android.gms.plus.c g = new js();
    public static final com.google.android.gms.plus.a h = new jo();
    public static final f i = new jq();
    public static final e j = new jp();

    public static com.google.android.gms.plus.internal.d a(c c1, boolean flag)
    {
        boolean flag1;
        if (c1 != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w.b(flag1, "GoogleApiClient parameter is required.");
        w.a(c1.d(), "GoogleApiClient must be connected.");
        w.a(c1.a(c), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        flag1 = c1.b(c);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (flag1)
        {
            return (com.google.android.gms.plus.internal.d)c1.a(a);
        } else
        {
            return null;
        }
    }

    static 
    {
        a = new com.google.android.gms.common.api.a.c();
        b = new com.google.android.gms.common.api.a.a() {

            public final int a()
            {
                return 2;
            }

            public final com.google.android.gms.common.api.a.b a(Context context, Looper looper, h h1, Object obj, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
            {
                Object obj1 = (a)obj;
                obj = obj1;
                if (obj1 == null)
                {
                    obj = new a((byte)0);
                }
                obj1 = h1.a().name;
                String as[] = iq.a(h1.c);
                obj = (String[])((a) (obj)).b.toArray(new String[0]);
                String s = context.getPackageName();
                String s1 = context.getPackageName();
                PlusCommonExtras pluscommonextras = new PlusCommonExtras();
                return new com.google.android.gms.plus.internal.d(context, looper, h1, new PlusSession(((String) (obj1)), as, ((String []) (obj)), new String[0], s, s1, pluscommonextras), b1, c1);
            }

        };
        c = new com.google.android.gms.common.api.a("Plus.API", b, a);
    }
}
