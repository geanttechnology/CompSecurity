// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.ui.TimeBar;
import java.util.concurrent.TimeUnit;

public final class adg extends cva
    implements cuy, sh
{

    public final ViewGroup a = (ViewGroup)findViewById(0x7f100132);
    public final View b = findViewById(0x7f1000de);
    private final TextView c = (TextView)findViewById(0x7f1000dd);
    private final TextView d;
    private final ImageView e;
    private final TextView f;
    private final TimeBar g = (TimeBar)findViewById(0x7f100133);
    private si h;
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;
    private int n;
    private final ImageView o;
    private final DisplayMetrics p = getResources().getDisplayMetrics();
    private final View q = findViewById(0x7f1000dc);

    public adg(Context context, int i1)
    {
        super(context);
        LayoutInflater.from(context).inflate(0x7f04003a, this);
        d = (TextView)b.findViewById(0x7f1000df);
        o = (ImageView)b.findViewById(0x7f1000e0);
        e = (ImageView)q.findViewById(0x7f10008a);
        f = (TextView)q.findViewById(0x7f100072);
        g.a(2);
        g.a(false);
        context = g;
        context.c = false;
        context.requestLayout();
        context = (android.widget.RelativeLayout.LayoutParams)b.getLayoutParams();
        context.bottomMargin = ((android.widget.RelativeLayout.LayoutParams) (context)).bottomMargin;
        context = new adh(this);
        b.setOnClickListener(context);
        b.setOnTouchListener(new adi(this));
        context = new adj(this);
        f.setOnClickListener(context);
        e.setOnClickListener(context);
        a();
    }

    static void a(adg adg1)
    {
        if (adg1.n == 3)
        {
            adg1.h.a(adg1.l, adg1.m);
        }
    }

    static void a(adg adg1, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            adg1.l = (int)motionevent.getRawX();
            adg1.m = (int)motionevent.getRawY();
        }
    }

    static si b(adg adg1)
    {
        return adg1.h;
    }

    private void b()
    {
        if (TextUtils.isEmpty(j))
        {
            c.setText(getResources().getString(0x7f0b012b, new Object[] {
                "", ""
            }));
            return;
        } else
        {
            c.setText(getResources().getString(0x7f0b012b, new Object[] {
                " \267 ", j
            }));
            return;
        }
    }

    private void c()
    {
        int i1 = getResources().getDimensionPixelSize(0x7f0a010a);
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)d.getLayoutParams();
        if (n == 1)
        {
            b.setVisibility(8);
            return;
        }
        if (n == 2)
        {
            if (k <= 0)
            {
                n = 3;
                d.setText(getResources().getString(0x7f0b012f));
                marginlayoutparams.setMargins(i1, 0, 0, 0);
                o.setVisibility(0);
                if (h != null)
                {
                    h.a();
                }
            } else
            {
                d.setText(getResources().getString(0x7f0b012e, new Object[] {
                    Integer.valueOf(k)
                }));
                marginlayoutparams.setMargins(i1, 0, i1, 0);
                o.setVisibility(8);
            }
        }
        b.setVisibility(0);
    }

    public final void a()
    {
        i = null;
        setVisibility(8);
        e.setImageDrawable(null);
        e.setVisibility(4);
        f.setText(null);
        o.setVisibility(8);
    }

    public final void a(int i1, int j1)
    {
        g.a(i1, j1, i1);
        j = a.a((int)TimeUnit.MILLISECONDS.toSeconds(j1 - i1), 3);
        k = 4 - (int)TimeUnit.MILLISECONDS.toSeconds(i1);
        c();
        b();
    }

    public final void a(Bitmap bitmap)
    {
        e.setImageBitmap(bitmap);
        ImageView imageview = e;
        int i1;
        if (bitmap != null)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        imageview.setVisibility(i1);
    }

    public final void a(String s)
    {
        i = s;
        f.setText(s);
    }

    public final void a(si si1)
    {
        h = si1;
    }

    public final void a(boolean flag)
    {
        j = null;
        l = -1;
        m = -1;
        if (flag)
        {
            k = 4;
            o.setVisibility(8);
            n = 2;
        } else
        {
            n = 1;
        }
        b();
        c();
        setVisibility(0);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1, true);
    }

    public final void l(boolean flag)
    {
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        i1 = 0;
        q.setVisibility(0);
        TextView textview = f;
        if (TextUtils.isEmpty(i) || getWidth() < (int)TypedValue.applyDimension(1, 500F, p))
        {
            i1 = 8;
        }
        textview.setVisibility(i1);
    }
}
