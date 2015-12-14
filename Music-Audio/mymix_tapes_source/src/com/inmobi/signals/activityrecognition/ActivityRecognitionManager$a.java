// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.activityrecognition;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.signals.activityrecognition:
//            ActivityRecognitionManager

private static class <init>
    implements InvocationHandler
{

    public void a(int i)
    {
    }

    public void a(Bundle bundle)
    {
        bundle = new Intent(com.inmobi.commons.a.a.b(), com/inmobi/signals/activityrecognition/ActivityRecognitionManager);
        bundle = PendingIntent.getService(com.inmobi.commons.a.a.b(), 0, bundle, 0x8000000);
        try
        {
            Field field = Class.forName("com.google.android.gms.location.ActivityRecognition").getDeclaredField("ActivityRecognitionApi");
            Class class1 = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
            Class.forName("com.google.android.gms.location.ActivityRecognitionApi").getMethod("requestActivityUpdates", new Class[] {
                class1, Long.TYPE, android/app/PendingIntent
            }).invoke(field.get(null), new Object[] {
                ActivityRecognitionManager.d(), Integer.valueOf(1000), bundle
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.NAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.NAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.NAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.NAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.a(com.inmobi.commons.core.utilities.NAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
        }
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

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
