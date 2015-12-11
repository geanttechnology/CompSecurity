// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.flurry.sdk:
//            hn, gd, el, ep, 
//            dy

class dv extends MediaController
{

    private static final String a = com/flurry/sdk/dv.getSimpleName();
    private static final int b = hn.b(16);
    private static final int c = hn.b(5);
    private static final int d = hn.b(35);
    private RelativeLayout e;
    private PopupWindow f;
    private dy g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private ImageButton k;
    private ImageButton l;
    private ImageButton m;
    private ep n;
    private int o;
    private int p;
    private AtomicBoolean q;

    public dv(Context context, dy dy)
    {
        super(context);
        o = 0;
        p = 0;
        q = new AtomicBoolean(false);
        a(context, dy);
    }

    static dy a(dv dv1)
    {
        return dv1.g;
    }

    private void a(Context context)
    {
        gd.a(3, a, (new StringBuilder()).append("Update initLayout Video: ").append(context.toString()).toString());
        f = new PopupWindow(context);
        q.set(false);
        e = new RelativeLayout(context);
        e.setBackgroundColor(0);
        f.setBackgroundDrawable(null);
        f.setFocusable(true);
        f.setContentView(e);
        f.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {

            final dv a;

            public void onDismiss()
            {
                dv.b(a).set(true);
            }

            
            {
                a = dv.this;
                super();
            }
        });
    }

    private void a(Context context, dy dy)
    {
        if (context == null)
        {
            return;
        } else
        {
            g = dy;
            c();
            a(context);
            b(context);
            c(context);
            d(context);
            e(context);
            e.setFocusableInTouchMode(true);
            e.setOnKeyListener(new android.view.View.OnKeyListener() {

                final dv a;

                public boolean onKey(View view, int i1, KeyEvent keyevent)
                {
                    if (keyevent.getKeyCode() == 4 && keyevent.getAction() == 1)
                    {
                        if (dv.a(a) != null && a.b())
                        {
                            dv.a(a).g();
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                a = dv.this;
                super();
            }
            });
            return;
        }
    }

    static AtomicBoolean b(dv dv1)
    {
        return dv1.q;
    }

    private void b(int i1)
    {
        if ((i1 & 1) > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            l.setVisibility(0);
            return;
        } else
        {
            l.setVisibility(4);
            return;
        }
    }

    private void b(Context context)
    {
        l = new ImageButton(context);
        l.setPadding(0, 0, 0, 0);
        l.setImageBitmap(h);
        context = new GradientDrawable();
        context.setColor(0xff000000);
        context.setShape(1);
        context.setAlpha(178);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            l.setBackground(context);
        } else
        {
            l.setBackgroundDrawable(context);
        }
        l.setVisibility(4);
        l.setOnClickListener(new android.view.View.OnClickListener() {

            final dv a;

            public void onClick(View view)
            {
                if (dv.a(a) != null)
                {
                    dv.a(a).g();
                }
            }

            
            {
                a = dv.this;
                super();
            }
        });
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(11);
        context.addRule(10);
        context.setMargins(c, c, c, c);
        e.addView(l, context);
    }

    static ImageButton c(dv dv1)
    {
        return dv1.k;
    }

    private void c()
    {
        el el1 = new el();
        el1.h();
        h = el1.e();
        j = el1.g();
        i = el1.f();
    }

    private void c(int i1)
    {
        if ((i1 & 2) > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            n.a().setVisibility(0);
            return;
        } else
        {
            n.a().setVisibility(4);
            return;
        }
    }

    private void c(Context context)
    {
        n = new ep(context, d, d);
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(12);
        context.addRule(9);
        context.setMargins(b, b, b, b);
        n.a().setVisibility(0);
        e.addView(n.a(), context);
    }

    private int d()
    {
        return hn.c().widthPixels;
    }

    private void d(int i1)
    {
        if ((i1 & 4) > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            m.setVisibility(0);
            return;
        } else
        {
            m.setVisibility(4);
            return;
        }
    }

    private void d(Context context)
    {
        m = new ImageButton(context);
        m.setPadding(0, 0, 0, 0);
        m.setBackgroundColor(0);
        m.setImageBitmap(j);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final dv a;

            public void onClick(View view)
            {
                if (dv.a(a) != null)
                {
                    dv.a(a).h();
                }
            }

            
            {
                a = dv.this;
                super();
            }
        });
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(11);
        context.addRule(12);
        context.setMargins(b, b, b, b);
        m.setVisibility(0);
        e.addView(m, context);
    }

    private int e()
    {
        return hn.c().heightPixels;
    }

    private void e(int i1)
    {
        if ((i1 & 8) > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            k.setVisibility(0);
            return;
        } else
        {
            k.setVisibility(4);
            return;
        }
    }

    private void e(Context context)
    {
        k = new ImageButton(context);
        k.setPadding(0, 0, 0, 0);
        k.setBackgroundColor(0);
        k.setImageBitmap(i);
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final dv a;

            public void onClick(View view)
            {
                if (dv.a(a) != null)
                {
                    dv.c(a).setVisibility(4);
                    dv.a(a).i();
                }
            }

            
            {
                a = dv.this;
                super();
            }
        });
        context = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        context.addRule(13);
        context.setMargins(b, b, b, b);
        k.setVisibility(0);
        e.addView(k, context);
    }

    public void a()
    {
        if (f != null)
        {
            gd.a(3, a, "Reset video view: ");
            if (f.isShowing() && !q.get())
            {
                a(0);
                f.setFocusable(false);
                f.dismiss();
            }
            f = null;
        }
    }

    public void a(float f1, float f2)
    {
        if (n != null)
        {
            o = (int)f2 / 1000;
            int i1 = (int)f1 / 1000;
            int j1 = o;
            n.b((int)f1);
            n.a(i1 - j1);
        }
    }

    public void a(int i1)
    {
        if (!q.get())
        {
            if (p == i1 && o > 3)
            {
                gd.a(3, a, (new StringBuilder()).append("No change in visible flag.").append(o).toString());
                return;
            }
            gd.a(3, a, (new StringBuilder()).append("Update UI with visible flag: ").append(i1).toString());
            p = i1;
            if (f != null)
            {
                if (!f.isShowing())
                {
                    f.update(0, 0, d(), e());
                    f.showAtLocation(e, 17, 0, 0);
                }
                b(i1);
                c(i1);
                e(i1);
                d(i1);
                return;
            }
        }
    }

    public void a(int i1, int j1)
    {
        while (q.get() || f == null) 
        {
            return;
        }
        gd.a(3, a, (new StringBuilder()).append("Update screenSizeChanged: ").append(d()).append("*").append(e()).toString());
        f.update(0, 0, d(), e());
        f.showAtLocation(e, 17, 0, 0);
        b(p);
        c(p);
        e(p);
        d(p);
    }

    public boolean b()
    {
        return l.isShown();
    }

}
