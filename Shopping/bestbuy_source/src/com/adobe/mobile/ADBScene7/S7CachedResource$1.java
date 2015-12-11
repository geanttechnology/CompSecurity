// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;

import android.graphics.Bitmap;

// Referenced classes of package com.adobe.mobile.ADBScene7:
//            S7CachedResource

class Callback
    implements Callback
{

    final S7CachedResource this$0;
    final Callback val$callback;

    public void call(Bitmap bitmap)
    {
        if (val$callback != null)
        {
            val$callback.call(bitmap);
        }
    }

    public volatile void call(Object obj)
    {
        call((Bitmap)obj);
    }

    Callback()
    {
        this$0 = final_s7cachedresource;
        val$callback = Callback.this;
        super();
    }
}
