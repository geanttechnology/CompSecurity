// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;

// Referenced classes of package com.tapjoy:
//            TapjoyLog

public class TapjoyAdIdClient
{

    private Context a;
    private String b;
    private boolean c;

    public TapjoyAdIdClient(Context context)
    {
        a = context;
    }

    public String getAdvertisingId()
    {
        return b;
    }

    public boolean isAdTrackingEnabled()
    {
        return c;
    }

    public boolean setupAdIdInfo()
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
        info = AdvertisingIdClient.getAdvertisingIdInfo(a);
        b = info.getId();
        boolean flag;
        if (!info.isLimitAdTrackingEnabled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            c = flag;
        }
        catch (Exception exception)
        {
            return false;
        }
        catch (Error error)
        {
            return false;
        }
        return true;
    }

    public boolean setupAdIdInfoReflection()
    {
        Object obj;
        Method method;
        Method method1;
        obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        method = ((Class) (obj)).getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        TapjoyLog.i("TapjoyAdIdClient", (new StringBuilder("Found method: ")).append(method).toString());
        obj = method.invoke(obj, new Object[] {
            a
        });
        method = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        method1 = obj.getClass().getMethod("getId", new Class[0]);
        boolean flag;
        if (!((Boolean)method.invoke(obj, new Object[0])).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            c = flag;
            b = (String)method1.invoke(obj, new Object[0]);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }
}
