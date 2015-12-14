// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.a.c;
import com.pf.common.a.d;
import com.pf.common.utility.Bitmaps;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;

public final class ImageCacheChannel extends Enum
{

    public static final ImageCacheChannel a;
    private static final File b;
    private static final c c;
    private static final Map d = new EnumMap(com/cyberlink/youcammakeup/utility/ImageCacheChannel);
    private static final ImageCacheChannel e[];

    private ImageCacheChannel(String s, int i)
    {
        super(s, i);
    }

    public static Bitmap a(ImageCacheChannel imagecachechannel)
    {
        imagecachechannel = (d)d.get(imagecachechannel);
        if (imagecachechannel == null)
        {
            return null;
        } else
        {
            return imagecachechannel.a();
        }
    }

    public static void a(ImageCacheChannel imagecachechannel, Bitmap bitmap)
    {
        a(imagecachechannel, bitmap, imagecachechannel.toString());
    }

    public static void a(ImageCacheChannel imagecachechannel, Bitmap bitmap, String s)
    {
        b(imagecachechannel);
        if (Bitmaps.a(bitmap))
        {
            d.put(imagecachechannel, c.a(bitmap, s));
        }
    }

    public static void b(ImageCacheChannel imagecachechannel)
    {
        d.remove(imagecachechannel);
    }

    public static ImageCacheChannel valueOf(String s)
    {
        return (ImageCacheChannel)Enum.valueOf(com/cyberlink/youcammakeup/utility/ImageCacheChannel, s);
    }

    public static ImageCacheChannel[] values()
    {
        return (ImageCacheChannel[])e.clone();
    }

    static 
    {
        a = new ImageCacheChannel("LOOKS_ORIGINAL_THUMB", 0);
        e = (new ImageCacheChannel[] {
            a
        });
        b = new File(Globals.d().getCacheDir(), "ImageCacheChannelSwap");
        c = new c(b, 16384);
    }
}
