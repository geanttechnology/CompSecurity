// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.mopub.common.d.d;
import com.mopub.common.f;
import com.mopub.common.m;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class com.mopub.common.a.a
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a f[];
        final int e;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/mopub/common/a/a$a, s1);
        }

        public static a[] values()
        {
            return (a[])f.clone();
        }

        static 
        {
            a = new a("NONE", 0, 0);
            b = new a("IOS", 1, 1);
            c = new a("ANDROID", 2, 2);
            d = new a("MOBILE_WEB", 3, 3);
            f = (new a[] {
                a, b, c, d
            });
        }

        private a(String s1, int i1, int j1)
        {
            super(s1, i1);
            e = j1;
        }
    }

    public static abstract class b
    {

        f a;
        d b;
        c c;
        g d;
        public String e;
        public String f;
        public String g;
        public String h;
        public Double i;
        public Double j;
        public Double k;
        public Double l;
        public Double m;
        public Double n;
        public String o;
        public Integer p;
        public String q;
        Integer r;
        double s;

        public abstract com.mopub.common.a.a a();

        public b(f f1, d d1, c c1, double d2)
        {
            com.mopub.common.m.a(f1);
            com.mopub.common.m.a(d1);
            com.mopub.common.m.a(c1);
            boolean flag;
            if (d2 >= 0.0D && d2 <= 1.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.mopub.common.m.a(flag);
            a = f1;
            b = d1;
            c = c1;
            s = d2;
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        private static final c c[];
        final String b;

        public static c valueOf(String s1)
        {
            return (c)Enum.valueOf(com/mopub/common/a/a$c, s1);
        }

        public static c[] values()
        {
            return (c[])c.clone();
        }

        static 
        {
            a = new c("REQUESTS", "requests");
            c = (new c[] {
                a
            });
        }

        private c(String s1, String s2)
        {
            super(s1, 0);
            b = s2;
        }
    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        private static final d e[];
        final String d;

        public static d valueOf(String s1)
        {
            return (d)Enum.valueOf(com/mopub/common/a/a$d, s1);
        }

        public static d[] values()
        {
            return (d[])e.clone();
        }

        static 
        {
            a = new d("AD_REQUEST", 0, "ad_request");
            b = new d("IMPRESSION_REQUEST", 1, "impression_request");
            c = new d("CLICK_REQUEST", 2, "click_request");
            e = (new d[] {
                a, b, c
            });
        }

        private d(String s1, int i1, String s2)
        {
            super(s1, i1);
            d = s2;
        }
    }

    public static final class e extends Enum
    {

        public static final e a;
        private static final e c[];
        public final double b = 0.10000000000000001D;

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(com/mopub/common/a/a$e, s1);
        }

        public static e[] values()
        {
            return (e[])c.clone();
        }

        static 
        {
            a = new e("AD_REQUEST");
            c = (new e[] {
                a
            });
        }

        private e(String s1)
        {
            super(s1, 0);
        }
    }

    public static final class f extends Enum
    {

        public static final f a;
        public static final f b;
        private static final f d[];
        final String c;

        public static f valueOf(String s1)
        {
            return (f)Enum.valueOf(com/mopub/common/a/a$f, s1);
        }

        public static f[] values()
        {
            return (f[])d.clone();
        }

        static 
        {
            a = new f("EXCHANGE_CLIENT_EVENT", 0, "exchange_client_event");
            b = new f("EXCHANGE_CLIENT_ERROR", 1, "exchange_client_error");
            d = (new f[] {
                a, b
            });
        }

        private f(String s1, int i1, String s2)
        {
            super(s1, i1);
            c = s2;
        }
    }

    public static final class g extends Enum
    {

        public static final g a;
        public static final g b;
        public static final g c;
        private static final g e[];
        final int d;

        public static g valueOf(String s1)
        {
            return (g)Enum.valueOf(com/mopub/common/a/a$g, s1);
        }

        public static g[] values()
        {
            return (g[])e.clone();
        }

        static 
        {
            a = new g("NONE", 0, 0);
            b = new g("WEB_VIEW", 1, 1);
            c = new g("NATIVE", 2, 2);
            e = (new g[] {
                a, b, c
            });
        }

        private g(String s1, int i1, int j1)
        {
            super(s1, i1);
            d = j1;
        }
    }


    final Integer A;
    final long B = System.currentTimeMillis();
    com.mopub.common.f C;
    final double D;
    final f a;
    final d b;
    final c c;
    final g d;
    final String e;
    final String f;
    final String g;
    final String h;
    final Double i;
    final Double j;
    final Integer k;
    final Integer l;
    final Double m;
    final Double n;
    final Double o;
    final com.mopub.common.f.a p;
    final String q;
    final String r;
    final String s;
    final String t;
    final String u;
    final String v;
    final Double w;
    final String x;
    final Integer y;
    final String z;

    public com.mopub.common.a.a(b b1)
    {
        com.mopub.common.m.a(b1);
        a = b1.a;
        b = b1.b;
        c = b1.c;
        d = b1.d;
        e = b1.e;
        f = b1.f;
        g = b1.g;
        h = b1.h;
        i = b1.i;
        j = b1.j;
        m = b1.k;
        n = b1.l;
        o = b1.m;
        w = b1.n;
        x = b1.o;
        y = b1.p;
        z = b1.q;
        A = b1.r;
        D = b1.s;
        C = com.mopub.common.f.a();
        if (C != null)
        {
            b1 = C.p;
            com.mopub.common.m.a(b1);
            k = Integer.valueOf(com.mopub.common.d.d.a(b1.getResources().getDisplayMetrics().widthPixels, b1));
            b1 = C.p;
            com.mopub.common.m.a(b1);
            l = Integer.valueOf(com.mopub.common.d.d.a(b1.getResources().getDisplayMetrics().heightPixels, b1));
            p = C.b();
            q = C.b;
            r = C.f;
            s = C.d;
            t = C.c;
            u = C.g;
            v = C.e;
            return;
        } else
        {
            k = null;
            l = null;
            p = null;
            q = null;
            r = null;
            s = null;
            t = null;
            u = null;
            v = null;
            return;
        }
    }

    public final String a()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.l;
        }
    }

    public final String b()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.o;
        }
    }

    public final String c()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.n;
        }
    }

    public final String d()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.m;
        }
    }

    public final String e()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.h;
        }
    }

    public final String f()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.i;
        }
    }

    public final String g()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.j;
        }
    }

    public final String h()
    {
        if (C == null)
        {
            return null;
        } else
        {
            return C.k;
        }
    }

    public String toString()
    {
        return (new StringBuilder("BaseEvent\nScribeCategory: ")).append(a).append("\nName: ").append(b).append("\nCategory: ").append(c).append("\nSdkProduct: ").append(d).append("\nSdkVersion: ").append(a()).append("\nAdUnitId: ").append(e).append("\nAdCreativeId: ").append(f).append("\nAdType: ").append(g).append("\nAdNetworkType: ").append(h).append("\nAdWidthPx: ").append(i).append("\nAdHeightPx: ").append(j).append("\nAppPlatform: ").append(a.c).append("\nAppName: ").append(b()).append("\nAppPackageName: ").append(c()).append("\nAppVersion: ").append(d()).append("\nDeviceManufacturer: ").append(e()).append("\nDeviceModel: ").append(f()).append("\nDeviceProduct: ").append(g()).append("\nDeviceOsVersion: ").append(h()).append("\nDeviceScreenWidth: ").append(k).append("\nDeviceScreenHeight: ").append(l).append("\nGeoLat: ").append(m).append("\nGeoLon: ").append(n).append("\nGeoAccuracy: ").append(o).append("\nPerformanceDurationMs: ").append(w).append("\nNetworkType: ").append(p).append("\nNetworkOperatorCode: ").append(q).append("\nNetworkOperatorName: ").append(r).append("\nNetworkIsoCountryCode: ").append(s).append("\nNetworkSimCode: ").append(t).append("\nNetworkSimOperatorName: ").append(u).append("\nNetworkSimIsoCountryCode: ").append(v).append("\nRequestId: ").append(x).append("\nRequestStatusCode: ").append(y).append("\nRequestUri: ").append(z).append("\nRequestRetries: ").append(A).append("\nSamplingRate: ").append(D).append("\nTimestampUtcMs: ").append((new SimpleDateFormat()).format(new Date(Long.valueOf(B).longValue()))).append("\n").toString();
    }
}
