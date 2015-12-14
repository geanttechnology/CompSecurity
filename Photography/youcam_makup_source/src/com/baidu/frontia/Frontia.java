// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia;

import android.content.Context;
import android.util.Log;
import com.baidu.frontia.api.FrontiaPush;
import com.baidu.frontia.base.impl.FrontiaImpl;

// Referenced classes of package com.baidu.frontia:
//            a

public class Frontia
{

    private static final String a = "Frontia";
    private static FrontiaImpl b;
    private static final String c = "1";

    public Frontia()
    {
    }

    public static String getApiKey()
    {
        return b.getAppKey();
    }

    public static String getFrontiaVersion()
    {
        return "1";
    }

    public static FrontiaPush getPush()
    {
        if (b.getAppKey() != null && b.getAppContext() != null)
        {
            FrontiaPush frontiapush = FrontiaPush.newInstance(b.getAppContext());
            frontiapush.init(b.getAppKey());
            return frontiapush;
        } else
        {
            Log.i("Frontia", "Frontia is not initialized, need to call Frontia.init to initialize Frontia first");
            return null;
        }
    }

    public static boolean init(Context context, String s)
    {
        if (context != null && s != null)
        {
            b = FrontiaImpl.get();
            if (b != null)
            {
                b.setAppContext(context.getApplicationContext());
                b.setAppKey(s);
                b.start();
                Log.d("frontia", "frontia init");
                com.baidu.frontia.a.a(context, s);
                return true;
            }
        }
        return false;
    }

    public static void setSlientUpdateEnabled(boolean flag)
    {
        b.setCheckForUpdatesEnabled(flag);
    }
}
