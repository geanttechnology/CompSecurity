// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class ge extends Dialog
{

    private final ir a;
    private final gi b;
    private final iz c;
    private Drawable d;
    private Drawable e;
    private Drawable f;
    private boolean g;
    private LinearLayout h;
    private SeekBar i;
    private boolean j;
    private View k;
    private Button l;

    public ge(Context context)
    {
        this(context, 0);
    }

    public ge(Context context, int i1)
    {
        super(a.a(context, true), i1);
        g = true;
        a = ir.a(getContext());
        b = new gi(this);
        context = a;
        c = ir.c();
    }

    private boolean a()
    {
        if (!c.a() || c.b())
        {
            dismiss();
            return false;
        }
        setTitle(c.c);
        b();
        Drawable drawable;
        if (c.f)
        {
            if (d == null)
            {
                d = a.b(getContext(), 0x7f01007d);
            }
            drawable = d;
        } else
        {
            if (e == null)
            {
                e = a.b(getContext(), 0x7f01007e);
            }
            drawable = e;
        }
        if (drawable != f)
        {
            f = drawable;
            drawable.setVisible(false, true);
            getWindow().setFeatureDrawable(3, drawable);
        }
        return true;
    }

    static boolean a(ge ge1)
    {
        return ge1.j;
    }

    static boolean a(ge ge1, boolean flag)
    {
        ge1.j = flag;
        return flag;
    }

    private void b()
    {
label0:
        {
            boolean flag = true;
            if (!j)
            {
                if (!g || c.j != 1)
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                h.setVisibility(0);
                i.setMax(c.l);
                i.setProgress(c.k);
            }
            return;
        }
        h.setVisibility(8);
    }

    static void b(ge ge1)
    {
        ge1.b();
    }

    static SeekBar c(ge ge1)
    {
        return ge1.i;
    }

    static iz d(ge ge1)
    {
        return ge1.c;
    }

    static ir e(ge ge1)
    {
        return ge1.a;
    }

    static boolean f(ge ge1)
    {
        return ge1.a();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        a.a(ip.c, b, 2);
        a();
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            getWindow().requestFeature(3);
            setContentView(0x7f040045);
            h = (LinearLayout)findViewById(0x7f10014f);
            i = (SeekBar)findViewById(0x7f100150);
            i.setOnSeekBarChangeListener(new gf(this));
            l = (Button)findViewById(0x7f100152);
            l.setOnClickListener(new gh(this));
            if (a())
            {
                k = null;
                bundle = (FrameLayout)findViewById(0x7f100151);
                if (k == null)
                {
                    break label0;
                }
                bundle.addView(k);
                bundle.setVisibility(0);
            }
            return;
        }
        bundle.setVisibility(8);
    }

    public void onDetachedFromWindow()
    {
        a.a(b);
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 25 || i1 == 24)
        {
            keyevent = c;
            if (i1 == 25)
            {
                i1 = -1;
            } else
            {
                i1 = 1;
            }
            keyevent.b(i1);
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 25 || i1 == 24)
        {
            return true;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }
}
