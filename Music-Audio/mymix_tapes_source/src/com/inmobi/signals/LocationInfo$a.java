// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import android.os.Bundle;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.signals:
//            LocationInfo

private static class <init>
    implements InvocationHandler
{

    public void a(int i)
    {
        LocationInfo.b(false);
        Logger.a(com.inmobi.commons.core.utilities.LogLevel.INTERNAL, LocationInfo.f(), "Google API client connection suspended");
    }

    public void a(Bundle bundle)
    {
        Logger.a(com.inmobi.commons.core.utilities.LogLevel.INTERNAL, LocationInfo.f(), "Successfully connected to Google API client.");
        LocationInfo.b(true);
    }

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        if (aobj != null)
        {
            if (method.getName().equals("onConnected"))
            {
                a((Bundle)aobj[0]);
                return null;
            }
            if (method.getName().equals("onConnectionSuspended"))
            {
                a(((Integer)aobj[0]).intValue());
                return null;
            }
        }
        return method.invoke(this, aobj);
    }

    private Logger()
    {
    }

    Logger(Logger logger)
    {
        this();
    }
}
