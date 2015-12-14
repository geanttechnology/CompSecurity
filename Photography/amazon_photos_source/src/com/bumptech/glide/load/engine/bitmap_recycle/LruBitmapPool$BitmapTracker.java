// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            LruBitmapPool

private static interface 
{

    public abstract void add(Bitmap bitmap);

    public abstract void remove(Bitmap bitmap);
}
