// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tapjoy.internal:
//            gw, gx, hh, gz, 
//            gv, ai

public final class hj extends RelativeLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(gv gv1);

        public abstract void b();
    }


    private boolean a;
    private float b;
    private View c;
    private View d;
    private FrameLayout e;
    private ImageView f;
    private hh g;
    private gw h;
    private a i;

    public hj(Context context, gw gw1, a a1)
    {
        super(context);
        b = 1.0F;
        h = gw1;
        i = a1;
        context = getContext();
        c = new View(context);
        c.setId(1);
        a1 = new android.widget.RelativeLayout.LayoutParams(0, 0);
        a1.addRule(13);
        addView(c, a1);
        d = new View(context);
        a1 = new android.widget.RelativeLayout.LayoutParams(0, 0);
        a1.addRule(13);
        addView(d, a1);
        e = new FrameLayout(context);
        a1 = new android.widget.RelativeLayout.LayoutParams(0, 0);
        a1.addRule(13);
        addView(e, a1);
        f = new ImageView(context);
        f.setOnClickListener(this);
        a1 = new android.widget.RelativeLayout.LayoutParams(0, 0);
        a1.addRule(7, c.getId());
        a1.addRule(6, c.getId());
        addView(f, a1);
        if (h.m != null && h.m.a())
        {
            g = new hh(context);
            g.setOnClickListener(this);
            context = new android.widget.RelativeLayout.LayoutParams(0, 0);
            context.addRule(5, d.getId());
            context.addRule(8, d.getId());
            addView(g, context);
        }
        f.setImageBitmap(gw1.c.a());
        if (g != null && gw1.m != null && gw1.m.a != null)
        {
            g.setImageBitmap(gw1.m.a.a());
        }
    }

    private int a(int j)
    {
        return (int)((float)j * b);
    }

    public final void onClick(View view)
    {
        if (view == f)
        {
            i.a();
        } else
        {
            if (view != null && view == g)
            {
                view = g;
                boolean flag;
                if (!((hh) (view)).a)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.a = flag;
                view.a();
                view.invalidate();
                i.b();
                return;
            }
            if (view.getTag() instanceof gv)
            {
                i.a((gv)view.getTag());
                return;
            }
        }
    }

    protected final void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        super.onLayout(flag, j, k, l, i1);
    }

    protected final void onMeasure(int j, int k)
    {
        int j1;
        int k1;
        int j2;
        k1 = 15;
        j1 = 0;
        int l = android.view.View.MeasureSpec.getSize(j);
        int l1 = android.view.View.MeasureSpec.getSize(k);
        Object obj;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (a)
        {
            b = Math.min((float)l / 480F, (float)l1 / 320F);
        } else
        {
            b = Math.min((float)l / 320F, (float)l1 / 480F);
        }
        obj = (android.widget.RelativeLayout.LayoutParams)c.getLayoutParams();
        if (a)
        {
            l = 480;
        } else
        {
            l = 320;
        }
        obj.width = a(l);
        if (a)
        {
            l = 320;
        } else
        {
            l = 480;
        }
        obj.height = a(l);
        obj = (android.widget.RelativeLayout.LayoutParams)d.getLayoutParams();
        if (a)
        {
            l = 448;
        } else
        {
            l = 290;
        }
        obj.width = a(l);
        if (a)
        {
            l = 290;
        } else
        {
            l = 448;
        }
        obj.height = a(l);
        layoutparams = (android.widget.RelativeLayout.LayoutParams)e.getLayoutParams();
        layoutparams.width = ((android.widget.RelativeLayout.LayoutParams) (obj)).width;
        layoutparams.height = ((android.widget.RelativeLayout.LayoutParams) (obj)).height;
        for (obj = (new aj._cls1(new aj.a(e))).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Object obj1 = (View)((Iterator) (obj)).next();
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)((View) (obj1)).getLayoutParams();
            obj1 = ((gv)((View) (obj1)).getTag()).a;
            layoutparams1.width = a(((Rect) (obj1)).width());
            layoutparams1.height = a(((Rect) (obj1)).height());
            layoutparams1.leftMargin = a(((Rect) (obj1)).left);
            layoutparams1.topMargin = a(((Rect) (obj1)).top);
        }

        j2 = a(0);
        f.setPadding(j2, j2, j2, j2);
        obj = (android.widget.RelativeLayout.LayoutParams)f.getLayoutParams();
        obj.width = a(30);
        obj.height = ((android.widget.RelativeLayout.LayoutParams) (obj)).width;
        obj.rightMargin = -j2 + a(h.d.x);
        obj.topMargin = -j2 + a(h.d.y);
        if (g == null) goto _L2; else goto _L1
_L1:
        Point point;
        int i1;
        android.widget.RelativeLayout.LayoutParams layoutparams2;
        int i2;
        if (a)
        {
            i1 = 16;
        } else
        {
            i1 = 15;
        }
        i2 = a(i1);
        if (a)
        {
            i1 = k1;
        } else
        {
            i1 = 16;
        }
        k1 = a(i1);
        g.setPadding(j2, j2, j2, j2);
        layoutparams2 = (android.widget.RelativeLayout.LayoutParams)g.getLayoutParams();
        layoutparams2.width = a(26);
        layoutparams2.height = layoutparams2.width;
        if (h.m == null) goto _L4; else goto _L3
_L3:
        if (a)
        {
            point = h.m.b();
        } else
        {
            point = h.m.c();
        }
        if (point == null) goto _L4; else goto _L5
_L5:
        j1 = point.x;
        i1 = point.y;
_L7:
        layoutparams2.leftMargin = a(j1) + i2;
        layoutparams2.topMargin = a(i1) + k1;
_L2:
        super.onMeasure(j, k);
        return;
_L4:
        i1 = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void setLandscape(boolean flag)
    {
        a = flag;
        Object obj;
        Object obj1;
        Object obj2;
        if (flag)
        {
            obj2 = h.b.a();
            obj1 = h.f.a();
            obj = h.j;
        } else
        {
            obj2 = h.a.a();
            obj1 = h.e.a();
            obj = h.i;
        }
        ai.a(c, new BitmapDrawable(null, ((android.graphics.Bitmap) (obj2))));
        ai.a(d, new BitmapDrawable(null, ((android.graphics.Bitmap) (obj1))));
        if (e.getChildCount() > 0)
        {
            e.removeAllViews();
        }
        obj1 = getContext();
        Object obj3;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); e.addView(((View) (obj2)), ((android.view.ViewGroup.LayoutParams) (obj3))))
        {
            obj3 = (gv)((Iterator) (obj)).next();
            obj2 = new View(((Context) (obj1)));
            ((View) (obj2)).setTag(obj3);
            ((View) (obj2)).setOnClickListener(this);
            obj3 = new android.widget.FrameLayout.LayoutParams(0, 0, 51);
        }

    }
}
