// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class qf
{

    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private ListView l;
    private SectionIndexer m;
    private String n[];
    private RectF o;
    private Handler p;

    public qf(Context context, ListView listview)
    {
        g = 0;
        j = -1;
        k = false;
        l = null;
        m = null;
        n = null;
        p = new Handler() {

            final qf a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (qf.a(a))
                {
                default:
                    return;

                case 1: // '\001'
                    qf.a(a, (float)((double)qf.b(a) + (double)(1.0F - qf.b(a)) * 0.20000000000000001D));
                    if ((double)qf.b(a) > 0.90000000000000002D)
                    {
                        qf.a(a, 1.0F);
                        qf.a(a, 2);
                    }
                    qf.c(a).invalidate();
                    qf.a(a, 10L);
                    return;

                case 2: // '\002'
                    qf.a(a, 3);
                    return;

                case 3: // '\003'
                    qf.a(a, (float)((double)qf.b(a) - (double)qf.b(a) * 0.20000000000000001D));
                    break;
                }
                if ((double)qf.b(a) < 0.10000000000000001D)
                {
                    qf.a(a, 0.0F);
                    qf.a(a, 0);
                }
                qf.c(a).invalidate();
                qf.a(a, 10L);
            }

            
            {
                a = qf.this;
                super();
            }
        };
        d = context.getResources().getDisplayMetrics().density;
        e = context.getResources().getDisplayMetrics().scaledDensity;
        l = listview;
        a(l.getAdapter());
        a = 20F * d;
        b = 10F * d;
        c = 5F * d;
    }

    static float a(qf qf1, float f1)
    {
        qf1.f = f1;
        return f1;
    }

    static int a(qf qf1)
    {
        return qf1.g;
    }

    private void a(int i1)
    {
        if (i1 < 0 || i1 > 3)
        {
            return;
        }
        g = i1;
        switch (g)
        {
        default:
            return;

        case 0: // '\0'
            p.removeMessages(0);
            return;

        case 1: // '\001'
            f = 0.0F;
            a(0L);
            return;

        case 2: // '\002'
            p.removeMessages(0);
            return;

        case 3: // '\003'
            f = 1.0F;
            break;
        }
        a(3000L);
    }

    private void a(long l1)
    {
        p.removeMessages(0);
        p.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + l1);
    }

    static void a(qf qf1, int i1)
    {
        qf1.a(i1);
    }

    static void a(qf qf1, long l1)
    {
        qf1.a(l1);
    }

    static float b(qf qf1)
    {
        return qf1.f;
    }

    static ListView c(qf qf1)
    {
        return qf1.l;
    }

    public void a()
    {
        if (g == 2)
        {
            a(3);
        }
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        h = i1;
        i = j1;
        o = new RectF((float)i1 - b - a, b, (float)i1 - b, (float)j1 - b);
    }

    public void a(Canvas canvas)
    {
        int i1 = 0;
        if (g != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Paint paint = new Paint();
        paint.setColor(0xff000000);
        paint.setAlpha((int)(64F * f));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(o, d * 5F, d * 5F, paint);
        if (n != null && n.length > 0)
        {
            if (j >= 0)
            {
                Object obj = new Paint();
                ((Paint) (obj)).setColor(0xff000000);
                ((Paint) (obj)).setAlpha(96);
                ((Paint) (obj)).setAntiAlias(true);
                ((Paint) (obj)).setShadowLayer(3F, 0.0F, 0.0F, Color.argb(64, 0, 0, 0));
                Paint paint1 = new Paint();
                paint1.setColor(-1);
                paint1.setAntiAlias(true);
                paint1.setTextSize(50F * e);
                float f1 = paint1.measureText(n[j]);
                float f3 = (c * 2.0F + paint1.descent()) - paint1.ascent();
                RectF rectf = new RectF(((float)h - f3) / 2.0F, ((float)i - f3) / 2.0F, ((float)h - f3) / 2.0F + f3, ((float)i - f3) / 2.0F + f3);
                canvas.drawRoundRect(rectf, d * 5F, d * 5F, ((Paint) (obj)));
                obj = n[j];
                float f5 = rectf.left;
                canvas.drawText(((String) (obj)), ((f3 - f1) / 2.0F + f5) - 1.0F, ((rectf.top + c) - paint1.ascent()) + 1.0F, paint1);
            }
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAlpha((int)(255F * f));
            paint2.setAntiAlias(true);
            paint2.setTextSize(12F * e);
            float f2 = (o.height() - b * 2.0F) / (float)n.length;
            float f4 = (f2 - (paint2.descent() - paint2.ascent())) / 2.0F;
            while (i1 < n.length) 
            {
                float f6 = (a - paint2.measureText(n[i1])) / 2.0F;
                canvas.drawText(n[i1], f6 + o.left, (o.top + b + (float)i1 * f2 + f4) - paint2.ascent(), paint2);
                i1++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void a(Adapter adapter)
    {
        if (adapter instanceof SectionIndexer)
        {
            m = (SectionIndexer)adapter;
            n = (String[])(String[])m.getSections();
        }
    }

    public void b()
    {
        android.widget.ListAdapter listadapter = l.getAdapter();
        if (listadapter instanceof SectionIndexer)
        {
            m = (SectionIndexer)listadapter;
            n = (String[])(String[])m.getSections();
        }
    }
}
