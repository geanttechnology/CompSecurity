// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonCacheManager;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect

public class AndroidCacheManager extends AmazonCacheManager
{

    private static final Class CACHE_MANAGER_CLASS = Reflect.getOptionalClass("android.webkit.CacheManager");

    public AndroidCacheManager()
    {
    }

    public void clearCache(Context context, boolean flag)
    {
        Object obj = null;
        context = new WebView(context);
        context.clearCache(flag);
        if (context != null)
        {
            context.destroy();
        }
        return;
        Exception exception;
        exception;
        context = obj;
_L2:
        if (context != null)
        {
            context.destroy();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setCacheMaxSize(long l)
    {
        if (CACHE_MANAGER_CLASS != null)
        {
            Reflect.writeField(Reflect.getRequiredPrivateField(CACHE_MANAGER_CLASS, "CACHE_MAX_SIZE"), CACHE_MANAGER_CLASS, Long.valueOf(l));
        }
    }

    public void setCacheThreshold(long l)
    {
        if (CACHE_MANAGER_CLASS != null)
        {
            Reflect.writeField(Reflect.getRequiredPrivateField(CACHE_MANAGER_CLASS, "CACHE_THRESHOLD"), CACHE_MANAGER_CLASS, Long.valueOf(l));
        }
    }

    public void setWebCoreCache(final int webCoreMaxCacheSize)
    {
        Class class1 = Reflect.getRequiredClass("android.webkit.WebViewCore");
        ((Handler)Reflect.readField(Reflect.getRequiredPrivateField(class1, "sWebCoreHandler"), class1)).post(new Runnable() {

            final AndroidCacheManager this$0;
            final int val$webCoreMaxCacheSize;

            public void run()
            {
                if (AndroidCacheManager.CACHE_MANAGER_CLASS != null)
                {
                    Object obj = Reflect.getRequiredClass("android.webkit.BrowserFrame");
                    obj = Reflect.readField(Reflect.getRequiredPrivateField(((Class) (obj)), "sJavaBridge"), obj);
                    Reflect.invokeMethod(Reflect.getRequiredMethod(Reflect.getRequiredClass("android.webkit.JWebCoreJavaBridge"), "setCacheSize", new Class[] {
                        Integer.TYPE
                    }), obj, new Object[] {
                        Integer.valueOf(webCoreMaxCacheSize)
                    });
                    Log.i(AndroidCacheManager.CACHE_MANAGER_CLASS.getName(), "Resized WebCore resource cache");
                }
            }

            
            {
                this$0 = AndroidCacheManager.this;
                webCoreMaxCacheSize = i;
                super();
            }
        });
    }

    public void updateAppCache(String s, String s1, com.amazon.android.webkit.AmazonCacheManager.UpdateAppCacheCallback updateappcachecallback)
    {
        throw new UnsupportedOperationException();
    }


}
