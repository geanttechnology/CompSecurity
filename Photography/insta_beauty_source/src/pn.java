// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pn
{

    private static pn b;
    private LruCache a;
    private ExecutorService c;
    private pr d;
    private ps e;

    private pn()
    {
        c = Executors.newFixedThreadPool(1);
        e = new ps(this);
        a = new po(this, (int)Runtime.getRuntime().maxMemory() / 10);
    }

    private Bitmap a(String s)
    {
        return (Bitmap)a.get(s);
    }

    public static pn a()
    {
        if (b == null)
        {
            b = new pn();
        }
        return b;
    }

    static pr a(pn pn1)
    {
        return pn1.d;
    }

    private void a(String s, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            a.put(s, bitmap);
        }
    }

    static void a(pn pn1, String s, Bitmap bitmap)
    {
        pn1.a(s, bitmap);
    }

    public void a(Context context, String s, String s1, ImageView imageview, aqe aqe, pr pr1)
    {
        d = pr1;
        pr1 = (new StringBuilder()).append(s).append(s1).toString();
        Bitmap bitmap = a(((String) (pr1)));
        if (bitmap == null)
        {
            Log.e("ImageLoader", (new StringBuilder()).append("bitmap path:").append(s1).append(",position:").append(s).toString());
            c.execute(new pp(this, s1, aqe, pr1, context, imageview));
        } else
        if (d != null)
        {
            d.a(bitmap, imageview);
            return;
        }
    }

    public void b()
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                a.evictAll();
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
