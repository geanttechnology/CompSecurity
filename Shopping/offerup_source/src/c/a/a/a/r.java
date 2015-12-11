// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import c.a.a.a.a.b.j;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.s;
import c.a.a.a.a.b.x;
import c.a.a.a.a.e.a;
import c.a.a.a.a.g.d;
import c.a.a.a.a.g.e;
import c.a.a.a.a.g.h;
import c.a.a.a.a.g.k;
import c.a.a.a.a.g.n;
import c.a.a.a.a.g.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

// Referenced classes of package c.a.a.a:
//            n, e, q, p

final class r extends c.a.a.a.n
{

    private final a a = new a();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private final Future j;
    private final Collection k;

    public r(Future future, Collection collection)
    {
        j = future;
        k = collection;
    }

    private d a(k k1, Collection collection)
    {
        Object obj = getContext();
        String s1 = (new j()).a(((Context) (obj)));
        obj = l.a(new String[] {
            l.k(((Context) (obj)))
        });
        int i1 = s.a(g).a();
        return new d(s1, getIdManager().c(), f, e, ((String) (obj)), h, i1, i, "0", k1, collection);
    }

    private Boolean a()
    {
        Object obj1;
        Object obj2;
        boolean flag;
        boolean flag1;
        flag1 = false;
        obj1 = l.i(getContext());
        obj2 = b();
        flag = flag1;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        if (j == null) goto _L4; else goto _L3
_L3:
        Object obj = (Map)j.get();
_L9:
        Map map = a(((Map) (obj)), k);
        obj = ((c.a.a.a.a.g.s) (obj2)).a;
        obj2 = map.values();
        boolean flag2 = true;
        if (!"new".equals(((e) (obj)).a)) goto _L6; else goto _L5
_L5:
        obj1 = a(c.a.a.a.a.g.k.a(getContext(), ((String) (obj1))), ((Collection) (obj2)));
        if (!(new h(this, c(), ((e) (obj)).b, a)).a(((d) (obj1)))) goto _L8; else goto _L7
_L7:
        flag = n.a().d();
_L2:
        return Boolean.valueOf(flag);
_L4:
        obj = new HashMap();
          goto _L9
_L8:
        c.a.a.a.e.d().c("Fabric", "Failed to create app with Crashlytics service.", null);
        flag = false;
          goto _L2
_L6:
        try
        {
label0:
            {
                if (!"configured".equals(((e) (obj)).a))
                {
                    break label0;
                }
                flag = n.a().d();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            c.a.a.a.e.d().c("Fabric", "Error performing auto configuration.", ((Throwable) (obj)));
            flag = flag1;
        }
          goto _L2
        flag = flag2;
        if (!((e) (obj)).d) goto _L2; else goto _L10
_L10:
        c.a.a.a.e.d().a("Fabric", "Server says an update is required - forcing a full App update.");
        obj1 = a(c.a.a.a.a.g.k.a(getContext(), ((String) (obj1))), ((Collection) (obj2)));
        (new w(this, c(), ((e) (obj)).b, a)).a(((d) (obj1)));
        flag = flag2;
          goto _L2
    }

    private static Map a(Map map, Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            c.a.a.a.n n1 = (c.a.a.a.n)collection.next();
            if (!map.containsKey(n1.getIdentifier()))
            {
                map.put(n1.getIdentifier(), new p(n1.getIdentifier(), n1.getVersion(), "binary"));
            }
        } while (true);
        return map;
    }

    private c.a.a.a.a.g.s b()
    {
        c.a.a.a.a.g.s s1;
        try
        {
            n.a().a(this, idManager, a, e, f, c()).c();
            s1 = n.a().b();
        }
        catch (Exception exception)
        {
            c.a.a.a.e.d().c("Fabric", "Error dealing with settings", exception);
            return null;
        }
        return s1;
    }

    private String c()
    {
        return l.c(getContext(), "com.crashlytics.ApiEndpoint");
    }

    protected final Object doInBackground()
    {
        return a();
    }

    public final String getIdentifier()
    {
        return "io.fabric.sdk.android:fabric";
    }

    public final String getVersion()
    {
        return "1.3.6.79";
    }

    protected final boolean onPreExecute()
    {
        g = getIdManager().h();
        b = getContext().getPackageManager();
        c = getContext().getPackageName();
        d = b.getPackageInfo(c, 0);
        e = Integer.toString(d.versionCode);
        if (d.versionName != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        String s1 = "0.0";
_L1:
        try
        {
            f = s1;
            h = b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            c.a.a.a.e.d().c("Fabric", "Failed init", namenotfoundexception);
            return false;
        }
        return true;
        s1 = d.versionName;
          goto _L1
    }
}
