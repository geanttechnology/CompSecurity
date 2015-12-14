// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.lang.ref.SoftReference;

public class bnw extends Thread
{

    public int a;
    public String b;
    public bnw c;
    private int d;
    private int e;
    private SoftReference f;
    private String g;
    private boolean h;
    private Bitmap i;

    public bnw(Bitmap bitmap, int j)
    {
        h = false;
        b = null;
        c = null;
        d = bitmap.getWidth();
        e = bitmap.getHeight();
        i = bitmap;
        a = j;
    }

    public bnw(Bitmap bitmap, String s, int j)
    {
        h = false;
        b = null;
        c = null;
        d = bitmap.getWidth();
        e = bitmap.getHeight();
        i = bitmap;
        g = s;
        a = j;
        if (boz.a(bitmap, s))
        {
            h = true;
            g = s;
            return;
        } else
        {
            i = bitmap;
            return;
        }
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (boz.a(i, g))
        {
            f = new SoftReference(i);
            h = true;
            i = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap a()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap;
        if (h)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        if (i == null)
        {
            Log.d("lb", "gif decoder image is null");
        }
        bitmap = i;
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        bitmap = null;
        if (f != null)
        {
            bitmap = (Bitmap)f.get();
        }
        Bitmap bitmap1;
        bitmap1 = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_4444;
        bitmap1 = BitmapFactory.decodeFile(g, options);
        f = new SoftReference(bitmap1);
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        Log.d("lb", "gif decoder image is null");
        this;
        JVM INSTR monitorexit ;
        return bitmap1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Bitmap bitmap)
    {
        if (!h)
        {
            i = bitmap;
        } else
        if (bitmap != null)
        {
            if (boz.a(bitmap, g))
            {
                f = new SoftReference(bitmap);
                return;
            } else
            {
                h = false;
                i = bitmap;
                return;
            }
        }
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap;
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        bitmap = (Bitmap)f.get();
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        f = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
        c();
    }
}
