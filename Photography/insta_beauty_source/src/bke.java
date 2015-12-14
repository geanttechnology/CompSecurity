// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import java.util.List;

public class bke
{

    private List a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public bke(List list)
    {
        b = 0;
        a = list;
    }

    public int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i = b;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        b = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Canvas canvas)
    {
        Bitmap bitmap;
label0:
        {
            if (c > 0 && d > 0)
            {
                bitmap = bos.a().a((String)a.get(b));
                if (bitmap != null)
                {
                    break label0;
                }
                Log.e("Background", "background is null");
            }
            return;
        }
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        f = bitmap.getHeight();
        e = bitmap.getWidth();
        canvas.drawBitmap(bitmap, rect, new Rect(0, 0, c, d), null);
    }

    public int b()
    {
        return a.size();
    }

    public void b(int i)
    {
        c = i;
    }

    public int c()
    {
        return c;
    }

    public void c(int i)
    {
        d = i;
    }

    public int d()
    {
        return d;
    }

    public int e()
    {
        return e;
    }

    public int f()
    {
        return f;
    }
}
