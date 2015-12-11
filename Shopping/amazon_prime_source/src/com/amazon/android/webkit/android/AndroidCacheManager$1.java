// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.util.Log;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidCacheManager, Reflect

class val.webCoreMaxCacheSize
    implements Runnable
{

    final AndroidCacheManager this$0;
    final int val$webCoreMaxCacheSize;

    public void run()
    {
        if (AndroidCacheManager.access$000() != null)
        {
            Object obj = Reflect.getRequiredClass("android.webkit.BrowserFrame");
            obj = Reflect.readField(Reflect.getRequiredPrivateField(((Class) (obj)), "sJavaBridge"), obj);
            Reflect.invokeMethod(Reflect.getRequiredMethod(Reflect.getRequiredClass("android.webkit.JWebCoreJavaBridge"), "setCacheSize", new Class[] {
                Integer.TYPE
            }), obj, new Object[] {
                Integer.valueOf(val$webCoreMaxCacheSize)
            });
            Log.i(AndroidCacheManager.access$000().getName(), "Resized WebCore resource cache");
        }
    }

    ()
    {
        this$0 = final_androidcachemanager;
        val$webCoreMaxCacheSize = I.this;
        super();
    }
}
