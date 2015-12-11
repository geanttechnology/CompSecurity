// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            co, cu, bc, dn, 
//            cm, dr, ck, ao, 
//            ds, cz, cn, cl, 
//            cw, dy, bg, du, 
//            dc, dq

class ba
{
    public static final class a
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h[];
        final String i;
        final String j;
        final Class k;
        final String l;
        final boolean m;

        static 
        {
            a = new a("config-aaxHostname", java/lang/String, "aaxHostname", "debug.aaxHostname");
            b = new a("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
            c = new a("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
            d = new a("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
            e = new a("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
            f = new a("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
            g = new a("config-truncateLatLon", java/lang/Boolean, "truncateLatLon", "debug.truncateLatLon");
            h = (new a[] {
                a, b, c, d, e, f, g
            });
        }

        private a(String s1, Class class1, String s2, String s3)
        {
            this(s1, class1, s2, s3, false);
        }

        private a(String s1, Class class1, String s2, String s3, boolean flag)
        {
            i = s1;
            j = s2;
            k = class1;
            l = s3;
            m = flag;
        }
    }

    static interface b
    {

        public abstract void c();

        public abstract void d();
    }

