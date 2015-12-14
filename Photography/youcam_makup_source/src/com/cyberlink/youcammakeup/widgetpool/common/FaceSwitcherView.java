// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceSwitcherView extends View
{

    private Paint a;
    private List b;
    private Bitmap c;
    private NinePatch d;
    private NinePatch e;
    private Rect f;
    private Canvas g;
    private int h;
    private int i;
    private int j;
    private int k;

    public FaceSwitcherView(Context context)
    {
        super(context);
        a();
    }

    public FaceSwitcherView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public FaceSwitcherView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        a();
    }

    private void a()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            a = new Paint();
            a.setColor(-1);
            i = Color.parseColor("#CC000000");
            k = -1;
            j = -1;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0x7f02067f);
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), 0x7f020680);
            d = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
            e = new NinePatch(bitmap1, bitmap1.getNinePatchChunk(), null);
            h = (int)((float)bitmap1.getWidth() * 0.325F);
            f = new Rect();
            return;
        }
    }

    public int a(float f1, float f2)
    {
        Iterator iterator = b.iterator();
        int l = -1;
        while (iterator.hasNext()) 
        {
            RectF rectf = (RectF)iterator.next();
            int i1 = l + 1;
            l = i1;
            if (rectf.contains(f1, f2))
            {
                return i1;
            }
        }
        return -1;
    }

    public void a(List list, int l)
    {
        ArrayList arraylist = new ArrayList();
        RectF rectf;
        for (list = list.iterator(); list.hasNext(); arraylist.add(new RectF(rectf.left - (float)h, rectf.top - (float)h, rectf.right + (float)h, rectf.bottom + (float)h)))
        {
            rectf = (RectF)list.next();
        }

        b = arraylist;
        j = l;
        invalidate();
    }

    public int getHoveredFacePosition()
    {
        return k;
    }

    protected void onDraw(Canvas canvas)
    {
        if (b == null || b.size() == 0)
        {
            return;
        }
        if (c == null || c.getWidth() != getWidth() || c.getHeight() != getHeight())
        {
            if (c != null)
            {
                c.recycle();
                c = null;
            }
            c = Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            g = new Canvas(c);
            g.drawColor(0);
            RectF rectf;
            for (Iterator iterator = b.iterator(); iterator.hasNext(); g.drawRect(rectf, a))
            {
                rectf = (RectF)iterator.next();
            }

            g.drawColor(i, android.graphics.PorterDuff.Mode.SRC_OUT);
        }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); d.draw(g, f))
        {
            ((RectF)iterator1.next()).roundOut(f);
        }

        if (k < 0);
        if (j >= 0)
        {
            ((RectF)b.get(j)).roundOut(f);
            e.draw(g, f);
        }
        canvas.drawBitmap(c, 0.0F, 0.0F, null);
    }

    public void setHoveredFacePosition(int l)
    {
        k = l;
    }

    public void setSeletectFacePosition(int l)
    {
        j = l;
        k = -1;
        if (l >= 0)
        {
            invalidate();
        }
    }
}
