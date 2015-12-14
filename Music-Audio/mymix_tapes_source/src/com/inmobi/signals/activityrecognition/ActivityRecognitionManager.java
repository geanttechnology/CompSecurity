// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.activityrecognition;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.signals.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActivityRecognitionManager extends IntentService
{
    private static class a
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
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", bundle);
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

        private a()
        {
        }

    }


    private static final String a = com/inmobi/signals/activityrecognition/ActivityRecognitionManager.getSimpleName();
    private static Object b = null;
    private static Object c = null;

    public ActivityRecognitionManager()
    {
        super("Activity service");
    }

    static void a()
    {
        if (h.a() && c == null)
        {
            a(com.inmobi.commons.a.a.b());
        }
    }

    private static void a(Context context)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Connecting activity recognition manager.");
        c = h.a(context, new a(), new a(), "com.google.android.gms.location.ActivityRecognition");
        h.a(c);
    }

    private static void a(Intent intent)
    {
        try
        {
            Class class1 = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
            if (((Boolean)class1.getMethod("hasResult", new Class[] {
    android/content/Intent
}).invoke(null, new Object[] {
    intent
})).booleanValue())
            {
                intent = ((Intent) (class1.getMethod("extractResult", new Class[] {
                    android/content/Intent
                }).invoke(null, new Object[] {
                    intent
                })));
                b = class1.getMethod("getMostProbableActivity", (Class[])null).invoke(intent, (Object[])null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", intent);
        }
    }

    static void b()
    {
        if (h.a() && c != null)
        {
            f();
        }
    }

    public static int c()
    {
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        int i = ((Integer)Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", (Class[])null).invoke(b, (Object[])null)).intValue();
        b = null;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Getting detected activity:").append(i).toString());
        return i;
        Object obj;
        obj;
        i = -1;
_L8:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", ((Throwable) (obj)));
        return i;
        obj;
        i = -1;
_L6:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", ((Throwable) (obj)));
        return i;
        obj;
        i = -1;
_L4:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", ((Throwable) (obj)));
        return i;
        obj;
        i = -1;
_L2:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", ((Throwable) (obj)));
        return i;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (true) goto _L8; else goto _L7
_L7:
        return -1;
    }

    static Object d()
    {
        return c;
    }

    static String e()
    {
        return a;
    }

    private static void f()
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Disconnecting activity recognition manager.");
        h.b(c);
        b = null;
        c = null;
    }

    protected void onHandleIntent(Intent intent)
    {
        if (c != null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Got activity recognition intent.");
            a(intent);
        }
    }

}
