// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import com.wantu.imagelib.decorator.sprite.GifTransformPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bkh
    implements bkg
{

    private bke a;
    private List b;
    private GifTransformPanel c;
    private bkt d;

    public bkh()
    {
        b = new LinkedList();
    }

    private Bitmap c(int i)
    {
        int j = a.e();
        int k = a.f();
        float f = (float)j / (float)a.c();
        float f1 = (float)k / (float)a.d();
        Bitmap bitmap = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        a(i);
        Canvas canvas = new Canvas(bitmap);
        canvas.scale(f, f1);
        a(canvas);
        return bitmap;
    }

    public int a()
    {
        return b.size();
    }

    public bki a(float f, float f1)
    {
        Iterator iterator = b.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            bki bki1 = (bki)iterator.next();
            if (!bki1.d || !bki1.a(f, f1))
            {
                continue;
            }
            if (i != 0)
            {
                Collections.swap(b, 0, i);
            }
            if (d != null)
            {
                return bki1;
            }
        }

        return null;
    }

    public void a(int i)
    {
        a.a(i);
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((bki)iterator.next()).b(i)) { }
    }

    public void a(int i, int j)
    {
        a.b(i);
        a.c(j);
    }

    public void a(Canvas canvas)
    {
        if (a != null)
        {
            a.a(canvas);
        }
        List list = b;
        list;
        JVM INSTR monitorenter ;
        if (b == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= b.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((bki)b.get(i)).a(canvas);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        list;
        JVM INSTR monitorexit ;
        if (c != null)
        {
            c.a(canvas);
        }
        return;
        canvas;
        list;
        JVM INSTR monitorexit ;
        throw canvas;
    }

    public void a(bke bke1)
    {
        a = bke1;
    }

    public void a(bki bki1)
    {
        synchronized (b)
        {
            bki1.a(a.a());
            ((LinkedList)b).addFirst(bki1);
        }
        return;
        bki1;
        list;
        JVM INSTR monitorexit ;
        throw bki1;
    }

    public void a(bkt bkt)
    {
        d = bkt;
    }

    public void a(GifTransformPanel giftransformpanel)
    {
        c = giftransformpanel;
    }

    public void a(boolean flag)
    {
        bki bki1 = c.a();
        if (bki1 != null)
        {
            bki1.a(Boolean.valueOf(flag));
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            bki bki1 = a(motionevent.getX(), motionevent.getY());
            if (bki1 != null)
            {
                c.a(bki1);
            }
        }
        return c.a(motionevent);
    }

    public List b(int i)
    {
        c.d = false;
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < a.b(); j++)
        {
            Bitmap bitmap = c(j);
            String s = String.format("%dsrc%d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
            bos.a().a(s, bitmap);
            bitmap.recycle();
            arraylist.add(s);
        }

        return arraylist;
    }

    public void b()
    {
        bki bki1 = c.a();
        if (bki1 != null)
        {
            b.remove(bki1);
            c.a(null);
        }
    }

    public void c()
    {
        bki bki1 = c.a();
        if (bki1 != null)
        {
            bki1.c(a.a());
        }
    }

    public void d()
    {
        bki bki2 = c.a();
        if (bki2 == null) goto _L2; else goto _L1
_L1:
        bki bki1 = null;
        bki2 = bki2.a();
        bki1 = bki2;
_L4:
        a(bki1);
        c.a(bki1);
_L2:
        return;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        clonenotsupportedexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List e()
    {
        c.d = false;
        ArrayList arraylist = new ArrayList();
        int j = a.a();
        for (int i = 0; i < a.b(); i++)
        {
            Bitmap bitmap = c(i);
            String s = String.format("preview%d", new Object[] {
                Integer.valueOf(i)
            });
            bos.a().a(s, bitmap);
            bitmap.recycle();
            arraylist.add(s);
        }

        a(j);
        c.d = true;
        return arraylist;
    }
}
