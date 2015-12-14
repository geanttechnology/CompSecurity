// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.utility.image.BinaryBitmapCache;
import java.util.HashMap;
import java.util.Map;

public class yg
{

    private static yg e;
    private final Map a = new HashMap();
    private BinaryBitmapCache b;
    private BinaryBitmapCache c;
    private yi d;

    private yg()
    {
        d = yi.a(PIPCameraApplication.a);
        b = new BinaryBitmapCache(d);
        b.a(com.wantu.utility.image.BinaryBitmapCache.CacheStratigy.SYNC_IO);
        c = new BinaryBitmapCache(d);
        c.a(com.wantu.utility.image.BinaryBitmapCache.CacheStratigy.IN_MEMORY);
    }

    public static yg a()
    {
        if (e == null)
        {
            e = new yg();
        }
        return e;
    }

    public Bitmap a(String s)
    {
        Bitmap bitmap1 = c.a(s);
        Bitmap bitmap = bitmap1;
        if (bitmap1 == null)
        {
            bitmap = b.a(s);
        }
        return bitmap;
    }

    public void a(String s, Bitmap bitmap)
    {
        if (a.containsKey(s))
        {
            a.remove(s);
        }
        b.a(s, bitmap);
    }

    public void b()
    {
        a.clear();
        b.a();
        c.a();
    }
}
