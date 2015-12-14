// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import fv;
import fw;
import gb;
import java.lang.ref.SoftReference;
import java.util.Set;

// Referenced classes of package com.fotoable.comlib.util:
//            ImageCache

class > extends LruCache
{

    final ImageCache a;

    protected int a(String s, BitmapDrawable bitmapdrawable)
    {
        int j = ImageCache.a(bitmapdrawable) / 1024;
        int i = j;
        if (j == 0)
        {
            i = 1;
        }
        return i;
    }

    protected void a(boolean flag, String s, BitmapDrawable bitmapdrawable, BitmapDrawable bitmapdrawable1)
    {
        if (!fw.isInstance(bitmapdrawable)) goto _L2; else goto _L1
_L1:
        ((fw)bitmapdrawable).b(false);
_L4:
        return;
_L2:
        if (!gb.c() || !fv.isInstance(bitmapdrawable)) goto _L4; else goto _L3
_L3:
        ((fv)bitmapdrawable).b(false);
        if (!((fv)bitmapdrawable).a()) goto _L4; else goto _L5
_L5:
        synchronized (ImageCache.a(a))
        {
            ImageCache.a(a).add(new SoftReference(bitmapdrawable.getBitmap()));
        }
        return;
        bitmapdrawable;
        s;
        JVM INSTR monitorexit ;
        throw bitmapdrawable;
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        a(flag, (String)obj, (BitmapDrawable)obj1, (BitmapDrawable)obj2);
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return a((String)obj, (BitmapDrawable)obj1);
    }

    le(ImageCache imagecache, int i)
    {
        a = imagecache;
        super(i);
    }
}
