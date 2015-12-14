// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.utility.image.BinaryBitmapCache;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class bos
{

    private static bos e;
    private final Map a = new HashMap();
    private BinaryBitmapCache b;
    private BinaryBitmapCache c;
    private bou d;

    private bos()
    {
        d = bou.a(InstaBeautyApplication.a().getApplicationContext());
        b = new BinaryBitmapCache(d);
        b.a(com.wantu.utility.image.BinaryBitmapCache.CacheStratigy.SYNC_IO);
        c = new BinaryBitmapCache(d);
        c.a(com.wantu.utility.image.BinaryBitmapCache.CacheStratigy.IN_MEMORY);
    }

    public static bos a()
    {
        if (e == null)
        {
            e = new bos();
        }
        return e;
    }

    public Bitmap a(String s)
    {
        if (s != null && (s == null || s.length() != 0)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = null;
_L4:
        return bitmap;
_L2:
        Object obj;
        obj = (SoftReference)a.get(s);
        if (obj != null)
        {
            obj = (Bitmap)((SoftReference) (obj)).get();
        } else
        {
            obj = null;
        }
        bitmap = ((Bitmap) (obj));
        if (obj != null) goto _L4; else goto _L3
_L3:
        Log.v("BitmapCacheManager", s);
        Log.v("BitmapCacheManager", "Not in memery");
        try
        {
            bitmap = c.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Log.e("BitmapCacheManager", s.getMessage());
            return null;
        }
        obj = bitmap;
        if (bitmap != null) goto _L6; else goto _L5
_L5:
        obj = b.a(s);
          goto _L6
_L8:
        a.put(s, new SoftReference(obj));
        Log.v("BitmapCacheManager", "Load finished");
        return ((Bitmap) (obj));
_L6:
        if (obj == null)
        {
            return null;
        }
        if (true) goto _L8; else goto _L7
_L7:
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
