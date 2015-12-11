// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.f.a;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.util.q;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, e, m, b, 
//            c, d, h, i, 
//            j, k, l, q, 
//            s, t, u, n, 
//            p

public class g
{

    private static final String SCHEME = "target";
    public static final String TAG = com/target/ui/util/deep_link/g.getSimpleName();

    public g()
    {
    }

    public static Uri a()
    {
        return Uri.parse("market://details?id=com.target.socsav");
    }

    public static Uri a(Uri uri)
    {
        Uri uri1;
        if (uri == null)
        {
            uri1 = null;
        } else
        {
            uri1 = uri;
            if (uri.getScheme().equals("x-target-cartwheel"))
            {
                uri = uri.toString();
                if (uri.equals("x-target-cartwheel"))
                {
                    uri = "https://cartwheel-secure.target.com/mycartwheel";
                } else
                if (uri.contains("secure"))
                {
                    uri = uri.replace("x-target-cartwheel", "https");
                } else
                {
                    uri = uri.replace("x-target-cartwheel", "http");
                }
                return Uri.parse(uri);
            }
        }
        return uri1;
    }

    public static f a(Uri uri, Store store)
    {
        String s1;
        byte byte0;
        if (uri == null)
        {
            q.a(TAG, "Null deep link");
            return new f(null);
        }
        if (uri.getHost() == null)
        {
            q.a(TAG, (new StringBuilder()).append("Deep link with null host : ").append(uri.toString()).toString());
            return new f(uri);
        }
        s1 = uri.getScheme();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 112
    //                   -880905839: 184
    //                   3213448: 156
    //                   99617003: 170;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_184;
_L5:
        switch (byte0)
        {
        default:
            store = new f(uri);
            a(uri, ((f) (store)));
            return store;

        case 0: // '\0'
        case 1: // '\001'
            store = c(uri, store);
            b(uri, store);
            return store;

        case 2: // '\002'
            store = b(uri, store);
            break;
        }
        break MISSING_BLOCK_LABEL_217;
_L3:
        if (s1.equals("http"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s1.equals("https"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s1.equals("target"))
        {
            byte0 = 2;
        }
          goto _L5
        a(uri, ((f) (store)));
        return store;
    }

    public static transient Map a(Uri uri, String as[])
    {
        a a1 = new a();
        Object obj = new HashSet();
        ((Set) (obj)).addAll(uri.getQueryParameterNames());
        if (as != null)
        {
            ((Set) (obj)).removeAll(Arrays.asList(as));
        }
        for (as = ((Set) (obj)).iterator(); as.hasNext(); a1.put(obj, uri.getQueryParameter(((String) (obj)))))
        {
            obj = (String)as.next();
        }

        return a1;
    }

    private static void a(Uri uri, f f1)
    {
        f1.b().a(uri.getQueryParameter("source"));
        f1.b().b(uri.getQueryParameter("trackingId"));
        f1.b().a().c(uri.getQueryParameter("cpng"));
        f1.b().a().e(uri.getQueryParameter("adgroup"));
        f1.b().a().b(uri.getQueryParameter("afid"));
        f1.b().a().d(uri.getQueryParameter("lnm"));
        f1.b().a().a(uri.getQueryParameter("ref"));
    }

    public static boolean a(Context context)
    {
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo("com.target.socsav", 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    private static f b(Uri uri, Store store)
    {
        String s1;
        byte byte0;
        s1 = uri.getHost();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 12: default 116
    //                   -874940727: 361
    //                   -621711260: 376
    //                   -309474065: 331
    //                   -290659282: 259
    //                   -52151785: 287
    //                   50511102: 217
    //                   95457671: 245
    //                   102982549: 301
    //                   165584954: 273
    //                   957885709: 231
    //                   994220080: 346
    //                   1901043637: 316;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_376;
_L14:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown deep link : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return com.target.ui.util.deep_link.b.a(uri, store);

        case 1: // '\001'
            return com.target.ui.util.deep_link.c.a(uri, store);

        case 2: // '\002'
            return com.target.ui.util.deep_link.d.a(uri, store);

        case 3: // '\003'
            return com.target.ui.util.deep_link.h.a(uri, store);

        case 4: // '\004'
            return com.target.ui.util.deep_link.i.a(uri, store);

        case 5: // '\005'
            return com.target.ui.util.deep_link.j.a(uri, store);

        case 6: // '\006'
            return com.target.ui.util.deep_link.k.a(uri, store);

        case 7: // '\007'
            return com.target.ui.util.deep_link.l.a(uri, store);

        case 8: // '\b'
            return com.target.ui.util.deep_link.q.a(uri, store);

        case 9: // '\t'
            return com.target.ui.util.deep_link.s.a(uri, store);

        case 10: // '\n'
            return com.target.ui.util.deep_link.t.a(uri, store);

        case 11: // '\013'
            return com.target.ui.util.deep_link.u.a(uri, store);
        }
_L7:
        if (s1.equals("category"))
        {
            byte0 = 0;
        }
          goto _L14
_L11:
        if (s1.equals("coupons"))
        {
            byte0 = 1;
        }
          goto _L14
_L8:
        if (s1.equals("deals"))
        {
            byte0 = 2;
        }
          goto _L14
_L5:
        if (s1.equals("featured"))
        {
            byte0 = 3;
        }
          goto _L14
_L10:
        if (s1.equals("gift-registry"))
        {
            byte0 = 4;
        }
          goto _L14
_L6:
        if (s1.equals("landing"))
        {
            byte0 = 5;
        }
          goto _L14
_L9:
        if (s1.equals("lists"))
        {
            byte0 = 6;
        }
          goto _L14
_L13:
        if (s1.equals("location"))
        {
            byte0 = 7;
        }
          goto _L14
_L4:
        if (s1.equals("product"))
        {
            byte0 = 8;
        }
          goto _L14
_L12:
        if (s1.equals("promotions"))
        {
            byte0 = 9;
        }
          goto _L14
_L2:
        if (s1.equals("thanks"))
        {
            byte0 = 10;
        }
          goto _L14
        if (s1.equals("weeklyad"))
        {
            byte0 = 11;
        }
          goto _L14
    }

    public static String b()
    {
        return "com.target.socsav";
    }

    private static void b(Uri uri, f f1)
    {
        a(uri, f1);
        f1.b().a("interceptURL");
    }

    public static boolean b(Uri uri)
    {
        if (uri != null)
        {
            String s1 = uri.getScheme();
            uri = uri.getHost();
            if (s1 != null)
            {
                return s1.equalsIgnoreCase("x-target-cartwheel");
            }
            if (uri != null)
            {
                return uri.equalsIgnoreCase("cartwheel.target.com");
            }
        }
        return false;
    }

    private static f c(Uri uri, Store store)
    {
        String s1;
        byte byte0;
        s1 = uri.getHost();
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 52
    //                   485469092: 121
    //                   615199685: 136
    //                   678035565: 166
    //                   741667694: 151;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_166;
_L6:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown deep link : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
        case 1: // '\001'
            return com.target.ui.util.deep_link.n.a(uri, store);

        case 2: // '\002'
        case 3: // '\003'
            return com.target.ui.util.deep_link.p.a(uri, store);
        }
_L2:
        if (s1.equals("target.com"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s1.equals("m.target.com"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (s1.equals("weeklyad.target.com"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s1.equals("m.weeklyad.target.com"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public static boolean c(Uri uri)
    {
        if (uri != null)
        {
            if ((uri = uri.getScheme()) != null && uri.equals("target"))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Uri uri)
    {
        return uri != null && uri.getHost().equals("product") && com.target.ui.util.deep_link.q.a(uri);
    }

}
