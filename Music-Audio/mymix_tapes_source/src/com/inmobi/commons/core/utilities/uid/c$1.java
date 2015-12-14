// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.core.utilities.uid:
//            c, a, b

class a
    implements Runnable
{

    final b a;
    final c b;

    public void run()
    {
        try
        {
            Object obj1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            obj1 = ((Class) (obj1)).getDeclaredMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                com.inmobi.commons.a.a.b()
            });
            String s = (String)((Class) (obj)).getDeclaredMethod("getId", (Class[])null).invoke(obj1, (Object[])null);
            c.o().a(s);
            a.a(s);
            obj = (Boolean)((Class) (obj)).getDeclaredMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(obj1, (Object[])null);
            c.o().a(((Boolean) (obj)).booleanValue());
            a.a(((Boolean) (obj)).booleanValue());
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", nosuchmethodexception);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", invocationtargetexception);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", classnotfoundexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", illegalaccessexception);
        }
    }

    n(c c1, b b1)
    {
        b = c1;
        a = b1;
        super();
    }
}
