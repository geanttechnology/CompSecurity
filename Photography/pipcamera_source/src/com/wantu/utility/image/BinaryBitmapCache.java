// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.utility.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import yi;

public class BinaryBitmapCache
{

    private final Map a = new HashMap();
    private CacheStratigy b;
    private yi c;

    public BinaryBitmapCache(yi yi1)
    {
        c = yi1;
    }

    public Bitmap a(String s)
    {
        Object obj1 = null;
        Object obj;
        if (a.containsKey(s))
        {
            s = (byte[])a.get(s);
            obj = new android.graphics.BitmapFactory.Options();
            obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            obj = BitmapFactory.decodeByteArray(s, 0, s.length, ((android.graphics.BitmapFactory.Options) (obj)));
        } else
        {
            obj = obj1;
            if (b != CacheStratigy.IN_MEMORY)
            {
                obj = obj1;
                if (b == CacheStratigy.SYNC_IO)
                {
                    s = c.a(s);
                    obj = obj1;
                    if (s != null)
                    {
                        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                        return BitmapFactory.decodeByteArray(s, 0, s.length, options);
                    }
                }
            }
        }
        return ((Bitmap) (obj));
    }

    public void a()
    {
        if (b == CacheStratigy.SYNC_IO)
        {
            c.b();
        } else
        if (b == CacheStratigy.IN_MEMORY)
        {
            a.clear();
            return;
        }
    }

    public void a(CacheStratigy cachestratigy)
    {
        b = cachestratigy;
    }

    public void a(String s, Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        if (b != CacheStratigy.IN_MEMORY) goto _L2; else goto _L1
_L1:
        a.put(s, bytearrayoutputstream.toByteArray());
_L4:
        bytearrayoutputstream.close();
        return;
_L2:
        if (b == CacheStratigy.SYNC_IO)
        {
            c.a(s, bytearrayoutputstream.toByteArray());
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        s.printStackTrace();
        Crashlytics.logException(s);
        return;
    }

    private class CacheStratigy extends Enum
    {

        private static final CacheStratigy $VALUES[];
        public static final CacheStratigy IN_MEMORY;
        public static final CacheStratigy SYNC_IO;

        public static CacheStratigy valueOf(String s)
        {
            return (CacheStratigy)Enum.valueOf(com/wantu/utility/image/BinaryBitmapCache$CacheStratigy, s);
        }

        public static CacheStratigy[] values()
        {
            return (CacheStratigy[])$VALUES.clone();
        }

        static 
        {
            SYNC_IO = new CacheStratigy("SYNC_IO", 0);
            IN_MEMORY = new CacheStratigy("IN_MEMORY", 1);
            $VALUES = (new CacheStratigy[] {
                SYNC_IO, IN_MEMORY
            });
        }

        private CacheStratigy(String s, int i)
        {
            super(s, i);
        }
    }

}
