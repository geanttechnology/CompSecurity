// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitFactory

public class AmazonWebKitFactories
{
    private static class Implementation
    {

        static AmazonWebKitFactory FACTORY;

        private static boolean createWebKitFactoryByName(String s)
        {
            try
            {
                FACTORY = (AmazonWebKitFactory)Class.forName(s).newInstance();
                Log.i(AmazonWebKitFactories.TAG, (new StringBuilder()).append("Successfully create WebKitFactory by name: ").append(s).toString());
            }
            catch (Exception exception)
            {
                Log.w(AmazonWebKitFactories.TAG, (new StringBuilder()).append("Create WebKitFactoryByName failed: ").append(s).toString());
                return false;
            }
            return true;
        }

        static 
        {
            String s1;
            String s;
            String as[];
            int i;
            int k;
            boolean flag;
            try
            {
                s1 = AmazonWebKitFactories.getExternalFactoryName();
            }
            catch (Exception exception)
            {
                throw new RuntimeException("Unable to initialize webkit factory", exception);
            }
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_17;
            }
            s = s1;
            if (s1.length() != 0)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            s = AmazonWebKitFactories.defaultFactory;
            if (s == null) goto _L2; else goto _L1
_L1:
            if (s.length() == 0) goto _L2; else goto _L3
_L3:
            s1 = s;
            if (createWebKitFactoryByName(s)) goto _L4; else goto _L2
_L2:
            as = new String[2];
            as[0] = "com.amazon.android.webkit.embedded.EmbeddedWebKitFactory";
            as[1] = "com.amazon.android.webkit.android.AndroidWebKitFactory";
            k = as.length;
            i = 0;
_L8:
            s1 = s;
            if (i >= k) goto _L4; else goto _L5
_L5:
            s1 = as[i];
            flag = createWebKitFactoryByName(s1);
            if (!flag) goto _L6; else goto _L4
_L4:
            if (FACTORY == null)
            {
                throw new RuntimeException("Unable to initialize webkit factory");
            }
            break; /* Loop/switch isn't completed */
_L6:
            i++;
            if (true) goto _L8; else goto _L7
_L7:
            int j = AmazonWebKitFactories.detectApiLevelForFactory(s1);
            Log.i(AmazonWebKitFactories.TAG, (new StringBuilder()).append("Client API Level:4 Factory API Level:").append(j).toString());
            if (j == -1)
            {
                throw new RuntimeException("Unable to detect factory api level");
            }
            AmazonWebKitFactories.defaultFactoryApiLevelCache = j;
            if (AmazonWebKitFactories.defaultFactoryApiLevelCache > 1)
            {
                FACTORY.setTargetApiLevel(Math.min(AmazonWebKitFactories.defaultFactoryApiLevelCache, 4));
            }
        }

        private Implementation()
        {
        }
    }


    private static final String TAG = com/amazon/android/webkit/AmazonWebKitFactories.getName();
    private static String defaultFactory = null;
    private static int defaultFactoryApiLevelCache = -1;
    private static boolean factoryCreated = false;

    public AmazonWebKitFactories()
    {
    }

    private static boolean AWVIsLevel1()
    {
        boolean flag1 = false;
        Object obj;
        NumberFormatException numberformatexception;
        String as[];
        Integer integer;
        int i;
        boolean flag;
        try
        {
            as = getApplicationContext().getPackageManager().getPackageInfo("com.amazon.webview", 128).versionName.split("\\.", 4);
        }
        catch (Exception exception)
        {
            Log.e(TAG, "exception in AWVIsLevel1().", exception);
            return false;
        }
        flag = flag1;
        if (as.length < 4)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj = as[3].substring(0, as[3].indexOf("_"));
        integer = Integer.decode(as[0]);
        obj = Integer.decode(((String) (obj)));
        flag = flag1;
        if (integer.intValue() != 25)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        i = ((Integer) (obj)).intValue();
        flag = flag1;
        if (i == 0)
        {
            flag = true;
        }
        return flag;
        numberformatexception;
        Log.e(TAG, "exception getting package api level.", numberformatexception);
        return false;
    }

    private static int detectApiLevelForFactory(String s)
    {
        byte byte0 = -1;
        int i = ((Integer)Class.forName(s).getMethod("getMaxApiLevelSupportedStatic", new Class[0]).invoke(null, new Object[0])).intValue();
_L2:
        if (i != -1)
        {
            Log.i(TAG, (new StringBuilder()).append("Successfully found API level for factory:").append(s).append(" level:").append(i).toString());
        }
        return i;
        Object obj;
        obj;
        i = byte0;
        if ("com.amazon.android.webkit.embedded.EmbeddedWebKitFactory".equals(s))
        {
            i = byte0;
            if (AWVIsLevel1())
            {
                i = 1;
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        Log.e(TAG, "exception in detectApiLevelForFactory ", ((Throwable) (obj)));
        i = byte0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Context getApplicationContext()
    {
        Context context;
        try
        {
            context = (Context)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
        }
        catch (Exception exception)
        {
            Log.e(TAG, "exception getting application context");
            return null;
        }
        return context;
    }

    public static AmazonWebKitFactory getDefaultFactory()
    {
        factoryCreated = true;
        return Implementation.FACTORY;
    }

    private static String getExternalFactoryName()
    {
        Object obj;
        Object obj1;
        Method method;
        Context context;
        obj1 = null;
        method = null;
        context = getApplicationContext();
        obj = method;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj = context.getPackageManager();
        obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(context.getPackageName(), 128));
        int i;
        if (obj != null)
        {
            try
            {
                obj = obj.toString();
            }
            catch (Exception exception)
            {
                Log.e(TAG, "exception when getting application name.", exception);
                exception = method;
            }
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        try
        {
            method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] {
                java/lang/String, java/lang/String
            });
            i = Class.forName("android.os.SystemProperties").getField("PROP_NAME_MAX").getInt(null);
        }
        catch (Exception exception1)
        {
            throw new RuntimeException("Unable to get External Factory Name", exception1);
        }
        obj1 = obj;
        if (((String) (obj)).length() > i - ".wv".length())
        {
            obj1 = ((String) (obj)).substring(0, i - ".wv".length());
        }
        obj1 = (String)method.invoke(null, new Object[] {
            (new StringBuilder()).append(((String) (obj1))).append(".wv").toString(), null
        });
        return ((String) (obj1));
    }








/*
    static int access$402(int i)
    {
        defaultFactoryApiLevelCache = i;
        return i;
    }

*/
}
