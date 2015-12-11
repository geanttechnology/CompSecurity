// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile.ADBScene7;

import android.graphics.Bitmap;

// Referenced classes of package com.adobe.mobile.ADBScene7:
//            Scene7Image

final class val.callback
    implements ce.S7Callback
{

    final ce.S7Callback val$callback;

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

    ce.S7Callback()
    {
        val$callback = s7callback;
        super();
    }
}
