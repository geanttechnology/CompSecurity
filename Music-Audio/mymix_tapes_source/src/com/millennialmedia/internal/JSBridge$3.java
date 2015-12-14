// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class this._cls0
    implements Runnable
{

    final JSBridge this$0;

    public void run()
    {
        long l = 0L;
_L3:
        Thread.sleep(100L);
        Object obj = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (obj != null) goto _L2; else goto _L1
_L1:
        JSBridge.access$800(JSBridge.this).set(false);
        return;
        obj;
        if (true) goto _L1; else goto _L2
_L2:
        long l1 = l;
        if (JSBridge.access$700(JSBridge.this) > l)
        {
            l1 = JSBridge.access$700(JSBridge.this);
            setCurrentPosition(((MMWebView) (obj)));
        }
        l = l1;
        if (System.currentTimeMillis() < JSBridge.access$700(JSBridge.this)) goto _L3; else goto _L1
    }

    n()
    {
        this$0 = JSBridge.this;
        super();
    }
}
