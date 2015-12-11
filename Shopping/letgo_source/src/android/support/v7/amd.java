// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

// Referenced classes of package android.support.v7:
//            alz, aoi, amo, amq, 
//            amt, aox, amw, aps, 
//            aoy, apk, alt, amc, 
//            aph, apb, apn, amb, 
//            aol

class amd extends alz
{

    private final aol a = new aoi();
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

    public amd(Future future, Collection collection)
    {
        j = future;
        k = collection;
    }

    private aox a(aph aph1, Collection collection)
    {
        Object obj = getContext();
        String s = (new amo()).a(((Context) (obj)));
        obj = amq.a(new String[] {
            amq.m(((Context) (obj)))
        });
        int l = amt.a(g).a();
        return new aox(s, getIdManager().c(), f, e, ((String) (obj)), h, l, i, "0", aph1, collection);
    }

    private boolean a(aoy aoy1, aph aph1, Collection collection)
    {
        aph1 = a(aph1, collection);
        return (new aps(this, b(), aoy1.c, a)).a(aph1);
    }

    private boolean a(String s, aoy aoy1, Collection collection)
    {
        boolean flag = true;
        if (!"new".equals(aoy1.b)) goto _L2; else goto _L1
_L1:
        if (!b(s, aoy1, collection)) goto _L4; else goto _L3
_L3:
        flag = apk.a().d();
_L6:
        return flag;
_L4:
        alt.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
        return false;
_L2:
        if ("configured".equals(aoy1.b))
        {
            return apk.a().d();
        }
        if (aoy1.e)
        {
            alt.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(s, aoy1, collection);
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean b(String s, aoy aoy1, Collection collection)
    {
        s = a(aph.a(getContext(), s), collection);
        return (new apb(this, b(), aoy1.c, a)).a(s);
    }

    private apn c()
    {
        apn apn1;
        try
        {
            apk.a().a(this, idManager, a, e, f, b()).c();
            apn1 = apk.a().b();
        }
        catch (Exception exception)
        {
            alt.h().e("Fabric", "Error dealing with settings", exception);
            return null;
        }
        return apn1;
    }

    private boolean c(String s, aoy aoy1, Collection collection)
    {
        return a(aoy1, aph.a(getContext(), s), collection);
    }

    protected Boolean a()
    {
        String s;
        apn apn1;
        s = amq.k(getContext());
        apn1 = c();
        if (apn1 == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (j == null) goto _L2; else goto _L1
_L1:
        Object obj = (Map)j.get();
_L3:
        boolean flag;
        obj = a(((Map) (obj)), k);
        flag = a(s, apn1.a, ((Map) (obj)).values());
_L4:
        return Boolean.valueOf(flag);
_L2:
        obj = new HashMap();
          goto _L3
        Exception exception;
        exception;
        alt.h().e("Fabric", "Error performing auto configuration.", exception);
        flag = false;
          goto _L4
    }

    Map a(Map map, Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            alz alz1 = (alz)collection.next();
            if (!map.containsKey(alz1.getIdentifier()))
            {
                map.put(alz1.getIdentifier(), new amb(alz1.getIdentifier(), alz1.getVersion(), "binary"));
            }
        } while (true);
        return map;
    }

    String b()
    {
        return amq.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    protected Object doInBackground()
    {
        return a();
    }

    public String getIdentifier()
    {
        return "io.fabric.sdk.android:fabric";
    }

    public String getVersion()
    {
        return "1.3.6.79";
    }

    protected boolean onPreExecute()
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
        String s = "0.0";
_L1:
        try
        {
            f = s;
            h = b.getApplicationLabel(getContext().getApplicationInfo()).toString();
            i = Integer.toString(getContext().getApplicationInfo().targetSdkVersion);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            alt.h().e("Fabric", "Failed init", namenotfoundexception);
            return false;
        }
        return true;
        s = d.versionName;
          goto _L1
    }
}
