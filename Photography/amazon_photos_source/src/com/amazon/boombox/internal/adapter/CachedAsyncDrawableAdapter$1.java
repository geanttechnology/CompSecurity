// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            CachedAsyncDrawableAdapter

class 
    implements 
{

    final CachedAsyncDrawableAdapter this$0;
    final int val$height;
    final  val$listener;
    final int val$width;

    public void onCountReady(int i)
    {
        val$listener.onCountReady(i);
    }

    public void onDrawableReady(int i, Drawable drawable)
    {
        CachedAsyncDrawableAdapter.access$100(CachedAsyncDrawableAdapter.this).put(CachedAsyncDrawableAdapter.access$000(CachedAsyncDrawableAdapter.this, i, val$width, val$height), drawable);
        val$listener.onDrawableReady(i, drawable);
    }

    ()
    {
        this$0 = final_cachedasyncdrawableadapter;
        val$width = i;
        val$height = j;
        val$listener = .this;
        super();
    }
}
