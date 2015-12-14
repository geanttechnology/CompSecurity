// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.intercept;

import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.lang.reflect.Field;

public class LocalyticsInterceptor
{

    private static final String TAG = com/amazon/gallery/framework/network/intercept/LocalyticsInterceptor.getName();

    public LocalyticsInterceptor()
    {
    }

    private void handleException(Exception exception)
    {
        if (BuildFlavors.isDebug())
        {
            throw new RuntimeException(exception);
        } else
        {
            GLogger.ex(TAG, "Exception happens", exception);
            return;
        }
    }

    public void initialize()
    {
        try
        {
            Object obj = Class.forName("com.localytics.android.Constants");
            Field field = ((Class) (obj)).getDeclaredField("ANALYTICS_URL");
            field.setAccessible(true);
            field.set(null, "fakeAnalyticsUrl");
            obj = ((Class) (obj)).getDeclaredField("PROFILES_URL");
            ((Field) (obj)).setAccessible(true);
            ((Field) (obj)).set(null, "fakeProfileUrl");
            GLogger.i(TAG, "Interception is successful", new Object[0]);
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            handleException(nosuchfieldexception);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            handleException(classnotfoundexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            handleException(illegalaccessexception);
        }
    }

}
