// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import com.fotoable.comlib.util.ImageCache;
import java.lang.ref.SoftReference;
import java.util.Set;

public class zq extends LruCache
{

    final ImageCache a;

    public zq(ImageCache imagecache, int i)
    {
        a = imagecache;
        super(i);
    }

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
        if (!zz.isInstance(bitmapdrawable)) goto _L2; else goto _L1
_L1:
        ((zz)bitmapdrawable).b(false);
_L4:
        return;
_L2:
        if (!aaj.c() || !zy.isInstance(bitmapdrawable)) goto _L4; else goto _L3
_L3:
        ((zy)bitmapdrawable).b(false);
        if (!((zy)bitmapdrawable).a()) goto _L4; else goto _L5
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
}
