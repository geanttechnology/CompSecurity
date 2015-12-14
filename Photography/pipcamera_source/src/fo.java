// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.fotoable.comlib.util.ImageCache;
import java.io.File;

public class fo
{

    public int a;
    public int b;
    public File c;
    public android.graphics.Bitmap.CompressFormat d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public fo(Context context, String s)
    {
        a = 5120;
        b = 0xa00000;
        d = ImageCache.a;
        e = 70;
        f = true;
        g = true;
        h = false;
        c = ImageCache.a(context, s);
    }

    public void a(float f1)
    {
        if (f1 < 0.01F || f1 > 0.8F)
        {
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
        } else
        {
            a = Math.round(((float)Runtime.getRuntime().maxMemory() * f1) / 1024F);
            return;
        }
    }
}
