// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.parse:
//            ProxyService

class PPNSUtil
{

    static String CLASS_PPNS_SERVICE = "com.parse.PPNSService";

    PPNSUtil()
    {
    }

    public static boolean isPPNSAvailable()
    {
        try
        {
            Class.forName(CLASS_PPNS_SERVICE);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public static ProxyService newPPNSService(Service service)
    {
        try
        {
            service = (ProxyService)Class.forName(CLASS_PPNS_SERVICE).getDeclaredConstructor(new Class[] {
                android/app/Service
            }).newInstance(new Object[] {
                service
            });
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            throw new RuntimeException(service);
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            throw new RuntimeException(service);
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            throw new RuntimeException(service);
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            throw new RuntimeException(service);
        }
        // Misplaced declaration of an exception variable
        catch (Service service)
        {
            throw new RuntimeException(service);
        }
        return service;
    }

}
