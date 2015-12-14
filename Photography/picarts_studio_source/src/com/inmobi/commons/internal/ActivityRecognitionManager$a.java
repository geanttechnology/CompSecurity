// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.internal:
//            InternalSDKUtil, ActivityRecognitionManager, Log

class <init>
    implements InvocationHandler
{

    public void a(Bundle bundle)
    {
        int i;
        bundle = new Intent(InternalSDKUtil.getContext().getApplicationContext(), com/inmobi/commons/internal/ActivityRecognitionManager);
        bundle = PendingIntent.getService(InternalSDKUtil.getContext().getApplicationContext(), 0, bundle, 0x8000000);
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
        if (i == 0)
        {
            try
            {
                Class.forName("com.google.android.gms.location.ActivityRecognitionClient").getMethod("requestActivityUpdates", new Class[] {
                    java/lang/Integer, android/app/PendingIntent
                }).invoke(ActivityRecognitionManager.b, new Object[] {
                    Integer.valueOf(1000), bundle
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            try
            {
                Log.internal("[InMobi]-4.5.2", "Unable to request activity updates from ActivityRecognition client");
                Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.internal("[InMobi]-4.5.2", "Unable to request activity updates from ActivityRecognition client");
            }
            return;
        }
        Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
        return;
    }

    public Object invoke(Object obj, Method method, Object aobj[])
    {
        if (aobj != null)
        {
            try
            {
                if (method.getName().equals("onConnected"))
                {
                    a((Bundle)aobj[0]);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.internal("[InMobi]-4.5.2", "Unable to invoke method", ((Throwable) (obj)));
            }
        }
        return null;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
