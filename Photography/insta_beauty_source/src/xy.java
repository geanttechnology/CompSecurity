// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;

class xy
    implements Runnable
{

    final xu a;
    private final ye b;
    private int c;
    private int d;

    public xy(xu xu1, Context context)
    {
        a = xu1;
        super();
        b = ye.a(context);
    }

    public void a()
    {
        if (xu.a)
        {
            Log.d("PhotoViewAttacher", "Cancel Fling");
        }
        b.a(true);
    }

    public void a(int i, int j, int k, int l)
    {
        RectF rectf = a.c();
        if (rectf != null)
        {
            int i1 = Math.round(-rectf.left);
            int j1;
            int k1;
            int l1;
            if ((float)i < rectf.width())
            {
                j1 = Math.round(rectf.width() - (float)i);
                i = 0;
            } else
            {
                j1 = i1;
                i = i1;
            }
            k1 = Math.round(-rectf.top);
            if ((float)j < rectf.height())
            {
                l1 = Math.round(rectf.height() - (float)j);
                j = 0;
            } else
            {
                l1 = k1;
                j = k1;
            }
            c = i1;
            d = k1;
            if (xu.a)
            {
                Log.d("PhotoViewAttacher", (new StringBuilder()).append("fling. StartX:").append(i1).append(" StartY:").append(k1).append(" MaxX:").append(j1).append(" MaxY:").append(l1).toString());
            }
            if (i1 != j1 || k1 != l1)
            {
                b.a(i1, k1, k, l, i, j1, j, l1, 0, 0);
                return;
            }
        }
    }

    public void run()
    {
        android.widget.ImageView imageview = a.d();
        if (imageview != null && b.a())
        {
            int i = b.b();
            int j = b.c();
            if (xu.a)
            {
                Log.d("PhotoViewAttacher", (new StringBuilder()).append("fling run(). CurrentX:").append(c).append(" CurrentY:").append(d).append(" NewX:").append(i).append(" NewY:").append(j).toString());
            }
            xu.c(a).postTranslate(c - i, d - j);
            a.a(a.k());
            c = i;
            d = j;
            xt.a(imageview, this);
        }
    }
}
