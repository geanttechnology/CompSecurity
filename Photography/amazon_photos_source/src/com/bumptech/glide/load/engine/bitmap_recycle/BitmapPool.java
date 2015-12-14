// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public interface BitmapPool
{

    public abstract void clearMemory();

    public abstract Bitmap get(int i, int j, android.graphics.Bitmap.Config config);

    public abstract Bitmap getDirty(int i, int j, android.graphics.Bitmap.Config config);

    public abstract boolean put(Bitmap bitmap);

    public abstract void trimMemory(int i);
}
