// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

class po extends LruCache
{

    final pn a;

    po(pn pn, int i)
    {
        a = pn;
        super(i);
    }

    protected int a(String s, Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return a((String)obj, (Bitmap)obj1);
    }
}
