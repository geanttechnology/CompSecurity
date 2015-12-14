// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.tracking;

import android.content.Context;
import com.aviary.android.feather.common.utils.ReflectionException;
import com.aviary.android.feather.common.utils.ReflectionUtils;
import com.aviary.android.feather.common.utils.SDKUtils;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.common.tracking:
//            AbstractTracker

public class AviaryTracker
{

    public static final String EXTRAS_AB_GROUP = "ab-group";
    public static final String EXTRAS_APP_NAME = "appId";
    private static final String TRACKER_CLASS = "com.aviary.android.feather.library.external.tracking.TrackerFactory";
    private static AviaryTracker instance;
    private AbstractTracker mInstance;

    AviaryTracker(Context context)
    {
        String s = context.getPackageName();
        String s1 = SDKUtils.getApiKey(context);
        if (s1 == null)
        {
            throw new IllegalStateException("API-KEY is missing. Did you forget to add the <meta-data android:name='com.aviary.android.feather.v1.API_KEY' android:value='your-api-key' /> inside the <application /> tag of your AndroidManifest.xml file?");
        }
        try
        {
            mInstance = (AbstractTracker)ReflectionUtils.invokeStaticMethod("com.aviary.android.feather.library.external.tracking.TrackerFactory", "create", new Class[] {
                android/content/Context, java/lang/String, java/lang/String, java/lang/String
            }, new Object[] {
                context, s, s1, "3.6.2"
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static AviaryTracker getInstance(Context context)
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/aviary/android/feather/common/tracking/AviaryTracker;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new AviaryTracker(context);
        }
        com/aviary/android/feather/common/tracking/AviaryTracker;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        context;
        com/aviary/android/feather/common/tracking/AviaryTracker;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void close()
    {
        if (mInstance != null)
        {
            mInstance.close();
        }
    }

    public void open()
    {
        if (mInstance != null)
        {
            mInstance.open();
        }
    }

    public void putCustomAttribute(String s, String s1)
    {
        if (mInstance != null)
        {
            mInstance.putCustomAttribute(s, s1);
        }
    }

    public void tagEvent(String s)
    {
        tagEventAttributes(s, null);
    }

    public transient void tagEvent(String s, String as[])
    {
        if (mInstance == null)
        {
            return;
        }
        if (as != null && as.length > 0)
        {
            if (as.length % 2 != 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("attributes array must be even. Found ").append(as.length).toString());
            }
            HashMap hashmap = new HashMap();
            for (int i = 0; i < as.length; i += 2)
            {
                hashmap.put(as[i], as[i + 1]);
            }

            tagEventAttributes(s, hashmap);
            return;
        } else
        {
            tagEventAttributes(s, null);
            return;
        }
    }

    public void tagEventAttributes(String s, HashMap hashmap)
    {
        if (mInstance != null)
        {
            mInstance.recordTag(s, hashmap);
        }
    }

    public void trackBeginPurchaseFlow(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("pack", s);
        hashmap.put("from", s1);
        tagEvent((new StringBuilder()).append(s1).append(": purchase_initiated").toString());
    }

    public void trackBeginPurchaseSubscriptionFlow(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("pack", s);
        hashmap.put("from", s1);
        tagEvent("content: subscriber_installed");
    }

    public void trackContentInstalled(String s, String s1)
    {
        tagEvent("content: installed", new String[] {
            "pack", s, "from", s1
        });
    }

    public void trackContentRestored(String s, String s1)
    {
        tagEvent("content: restored", new String[] {
            "pack", s, "from", s1
        });
    }

    public void trackEndPurchaseFlow(String s, String s1, boolean flag)
    {
        trackEndPurchaseFlow(s, s1, flag, -1);
    }

    public void trackEndPurchaseFlow(String s, String s1, boolean flag, int i)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("pack", s);
        hashmap.put("from", s1);
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        hashmap.put("success", s);
        if (i != -1)
        {
            hashmap.put("position", String.valueOf(i));
        }
        tagEventAttributes("content: purchased", hashmap);
    }

    public void upload()
    {
        if (mInstance != null)
        {
            mInstance.upload();
        }
    }
}
