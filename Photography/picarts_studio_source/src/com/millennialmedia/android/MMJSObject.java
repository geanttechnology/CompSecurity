// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, MMJSResponse, MMLog, MMWebView, 
//            MMActivity, AdViewOverlayActivity

abstract class MMJSObject
{

    private static final String a = com/millennialmedia/android/MMJSObject.getName();
    protected WeakReference b;
    protected WeakReference c;

    MMJSObject()
    {
    }

    static long a(String s)
    {
        if (s != null)
        {
            return (long)Float.parseFloat(s);
        } else
        {
            return -4L;
        }
    }

    static MMJSResponse a(Callable callable)
    {
        callable = new FutureTask(callable);
        MMSDK.a(callable);
        callable = (MMJSResponse)callable.get();
        return callable;
        callable;
        MMLog.a(a, "Future interrupted", callable);
_L2:
        return null;
        callable;
        MMLog.a(a, "Future execution problem: ", callable);
        if (true) goto _L2; else goto _L1
_L1:
    }

    abstract MMJSResponse a(String s, Map map);

    final void a(MMWebView mmwebview)
    {
        c = new WeakReference(mmwebview);
    }

    final AdViewOverlayActivity b()
    {
        Object obj = (MMWebView)c.get();
        if (obj != null)
        {
            obj = ((MMWebView) (obj)).h();
            if (obj instanceof MMActivity)
            {
                obj = ((MMActivity)obj).a;
                if (obj instanceof AdViewOverlayActivity)
                {
                    return (AdViewOverlayActivity)obj;
                }
            }
        }
        return null;
    }

    final void b(Context context)
    {
        b = new WeakReference(context);
    }

}
