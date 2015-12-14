// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;

// Referenced classes of package com.bumptech.glide.load.model:
//            ModelCache

class this._cls0 extends LruCache
{

    final ModelCache this$0;

    protected void onItemEvicted(delKey delkey, Object obj)
    {
        delkey.release();
    }

    protected volatile void onItemEvicted(Object obj, Object obj1)
    {
        onItemEvicted((delKey)obj, obj1);
    }

    delKey(int i)
    {
        this$0 = ModelCache.this;
        super(i);
    }
}
