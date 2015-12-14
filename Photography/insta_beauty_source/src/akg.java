// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

class akg extends LruCache
{

    final akf a;

    akg(akf akf, int i)
    {
        a = akf;
        super(i);
    }

    protected int a(Integer integer, Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return a((Integer)obj, (Bitmap)obj1);
    }
}
