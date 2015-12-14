// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

class aah extends aad
{

    private final acy a = new act();
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

    public aah(Future future, Collection collection)
    {
        j = future;
        k = collection;
    }

    private adk a(adu adu1, Collection collection)
    {
        Object obj = getContext();
        String s = (new aau()).a(((Context) (obj)));
        obj = CommonUtils.a(new String[] {
            CommonUtils.m(((Context) (obj)))
        });
        int l = DeliveryMechanism.determineFrom(g).getId();
        return new adk(s, getIdManager().c(), f, e, ((String) (obj)), h, l, i, "0", adu1, collection);
    }

    private boolean a(adl adl1, adu adu1, Collection collection)
    {
        adu1 = a(adu1, collection);
        return (new aeg(this, b(), adl1.c, a)).a(adu1);
    }

    private boolean a(String s, adl adl1, Collection collection)
    {
        boolean flag = true;
        if (!"new".equals(adl1.b)) goto _L2; else goto _L1
_L1:
        if (!b(s, adl1, collection)) goto _L4; else goto _L3
_L3:
        flag = adx.a().d();
_L6:
        return flag;
_L4:
        zw.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
        return false;
_L2:
        if ("configured".equals(adl1.b))
        {
            return adx.a().d();
        }
        if (adl1.e)
        {
            zw.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(s, adl1, collection);
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean b(String s, adl adl1, Collection collection)
    {
        s = a(adu.a(getContext(), s), collection);
        return (new ado(this, b(), adl1.c, a)).a(s);
    }

    private aeb c()
    {
        aeb aeb1;
        try
        {
            adx.a().a(this, idManager, a, e, f, b()).c();
            aeb1 = adx.a().b();
        }
        catch (Exception exception)
        {
            zw.h().e("Fabric", "Error dealing with settings", exception);
            return null;
        }
        return aeb1;
    }

    private boolean c(String s, adl adl1, Collection collection)
    {
        return a(adl1, adu.a(getContext(), s), collection);
    }

    protected Boolean a()
    {
        String s;
        aeb aeb1;
        s = CommonUtils.k(getContext());
        aeb1 = c();
        if (aeb1 == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (j == null) goto _L2; else goto _L1
_L1:
        Object obj = (Map)j.get();
_L3:
        boolean flag;
        obj = a(((Map) (obj)), k);
        flag = a(s, aeb1.a, ((Map) (obj)).values());
_L4:
        return Boolean.valueOf(flag);
_L2:
        obj = new HashMap();
          goto _L3
        Exception exception;
        exception;
        zw.h().e("Fabric", "Error performing auto configuration.", exception);
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
            aad aad1 = (aad)collection.next();
            if (!map.containsKey(aad1.getIdentifier()))
            {
                map.put(aad1.getIdentifier(), new aaf(aad1.getIdentifier(), aad1.getVersion(), "binary"));
            }
        } while (true);
        return map;
    }

    String b()
    {
        return CommonUtils.b(getContext(), "com.crashlytics.ApiEndpoint");
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
            zw.h().e("Fabric", "Failed init", namenotfoundexception);
            return false;
        }
        return true;
        s = d.versionName;
          goto _L1
    }
}
