// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.jumio.mrz.impl.smartEngines.swig.MrzRect;
import com.jumio.mrz.impl.smartEngines.swig.MrzRectVector;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            cs

public class mr extends View
{

    public Paint a;
    public Paint b;
    public Paint c;
    protected double d;
    protected double e;
    private int f;
    private int g;
    private float h;
    private float i;
    private ArrayList j;
    private RectF k;
    private Rect l;

    public mr(Context context)
    {
        super(context);
        d = 1.0D;
        e = 1.0D;
        f = 0;
        g = 0;
        h = -1F;
        i = -1F;
        j = null;
        k = null;
        l = null;
        a = new Paint();
        a.setColor(0xff00ff00);
        a.setStyle(android.graphics.Paint.Style.STROKE);
        c = new Paint();
        c.setColor(0xff00ff00);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setTextSize(40F);
        b = new Paint();
        b.setColor(0xffff0000);
        b.setStyle(android.graphics.Paint.Style.STROKE);
        j = new ArrayList();
        setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    public void a()
    {
        l = null;
        k = null;
        j.clear();
        invalidate();
    }

    public void a(double d1, double d2)
    {
        if (d1 > 0.0D)
        {
            d = d1;
        }
        if (d2 > 0.0D)
        {
            e = d2;
        }
    }

    public void a(float f1, float f2)
    {
        h = f1;
        i = f2;
        postInvalidate();
    }

    public void onDraw(Canvas canvas)
    {
        ArrayList arraylist = (ArrayList)j.clone();
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            canvas.drawRect((Rect)arraylist.get(i1), a);
        }

        if (k != null)
        {
            canvas.drawRect(k, a);
        }
        if (l != null)
        {
            canvas.drawRect(l, b);
        }
        if (cs.a())
        {
            String s;
            Object obj;
            if (h > 0.0F)
            {
                s = String.valueOf(h);
            } else
            {
                s = "-";
            }
            if (i > 0.0F)
            {
                obj = String.valueOf(i);
            } else
            {
                obj = "-";
            }
            s = String.format("focus value: %s/%s", new Object[] {
                s, obj
            });
            obj = new Rect();
            c.getTextBounds(s, 0, s.length(), ((Rect) (obj)));
            canvas.drawText(s, (float)getWidth() / 2.0F - (float)((Rect) (obj)).width() / 2.0F, (float)getHeight() * 0.9F, c);
        }
    }

    public void setBorderColor(int i1)
    {
        a.setColor(i1);
    }

    public void setFaceRect(RectF rectf)
    {
        k = rectf;
    }

    public void setMrzDigits(MrzRectVector amrzrectvector[])
    {
        j.clear();
        if (amrzrectvector != null && amrzrectvector.length != 0)
        {
            int k1 = amrzrectvector.length;
            int i1 = 0;
            while (i1 < k1) 
            {
                MrzRectVector mrzrectvector = amrzrectvector[i1];
                for (int j1 = 0; (long)j1 < mrzrectvector.size(); j1++)
                {
                    int l1 = (int)((double)mrzrectvector.get(j1).getX() * d) + g;
                    int i2 = (int)((double)mrzrectvector.get(j1).getY() * e) + f;
                    int j2 = (int)((double)mrzrectvector.get(j1).getWidth() * d);
                    int k2 = (int)((double)mrzrectvector.get(j1).getHeight() * e);
                    j.add(new Rect(l1, i2, j2 + l1, k2 + i2));
                }

                i1++;
            }
        }
    }

    public void setROIRect(Rect rect)
    {
        l = rect;
    }

    public void setROIXOffset(int i1)
    {
        g = i1;
    }

    public void setROIYOffset(int i1)
    {
        f = i1;
    }
}
