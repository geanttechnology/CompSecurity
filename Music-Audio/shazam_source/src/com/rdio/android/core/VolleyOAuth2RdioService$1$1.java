// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import android.graphics.Bitmap;
import android.support.v4.f.e;

// Referenced classes of package com.rdio.android.core:
//            VolleyOAuth2RdioService

class this._cls1 extends e
{

    final sizeOf this$1;

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf((String)obj, (Bitmap)obj1);
    }

    protected int sizeOf(String s, Bitmap bitmap)
    {
        return bitmap.getByteCount();
    }

    l.cacheSize(int i)
    {
        this$1 = this._cls1.this;
        super(i);
    }

    // Unreferenced inner class com/rdio/android/core/VolleyOAuth2RdioService$1

/* anonymous class */
    class VolleyOAuth2RdioService._cls1
        implements com.a.a.a.h.a
    {

        private final e cache;
        final VolleyOAuth2RdioService this$0;
        final int val$cacheSize;

        public Bitmap getBitmap(String s)
        {
            return (Bitmap)cache.get(s);
        }

        public void putBitmap(String s, Bitmap bitmap)
        {
            cache.put(s, bitmap);
        }

            
            {
                this$0 = final_volleyoauth2rdioservice;
                cacheSize = I.this;
                super();
                cache = new VolleyOAuth2RdioService._cls1._cls1(cacheSize);
            }
    }

}
