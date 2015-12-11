// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;

// Referenced classes of package com.flurry.sdk:
//            dy, dz, dw, dv, 
//            fp, dx, hq

public class du
    implements dy, dz
{

    private dx a;
    private dw b;
    private dv c;
    private RelativeLayout d;

    public du(Context context)
    {
        a(context);
    }

    static dv a(du du1)
    {
        return du1.c;
    }

    private void a(Context context)
    {
        if (context == null)
        {
            return;
        } else
        {
            d = new RelativeLayout(context);
            b = new dw(context, this);
            c = new dv(context, this);
            context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            context.addRule(13);
            d.addView(b, context);
            return;
        }
    }

    public void a(int k)
    {
        if (b != null)
        {
            b.a(k);
        }
    }

    public void a(int k, int l)
    {
        fp.a().a(new hq(k, l) {

            final int a;
            final int b;
            final du c;

            public void safeRun()
            {
                if (du.a(c) != null)
                {
                    du.a(c).a(a, b);
                }
            }

            
            {
                c = du.this;
                a = k;
                b = l;
                super();
            }
        });
    }

    public void a(Uri uri, int k)
    {
        if (uri != null && b != null)
        {
            b.a(uri, k);
        }
    }

    public void a(dx dx1)
    {
        a = dx1;
    }

    public void a(String s)
    {
        if (a != null)
        {
            a.b(s);
        }
        if (c != null && b != null)
        {
            c.setMediaPlayer(b);
        }
    }

    public void a(String s, float f1, float f2)
    {
        if (a != null)
        {
            a.a(s, f1, f2);
        }
        fp.a().a(new hq(f1, f2) {

            final float a;
            final float b;
            final du c;

            public void safeRun()
            {
                if (du.a(c) != null)
                {
                    du.a(c).a(a, b);
                }
            }

            
            {
                c = du.this;
                a = f1;
                b = f2;
                super();
            }
        });
    }

    public void a(String s, int k, int l, int i1)
    {
        if (a != null)
        {
            a.a(s, k, l, i1);
        }
    }

    public boolean a()
    {
        if (b != null)
        {
            return b.a();
        } else
        {
            return false;
        }
    }

    public void b()
    {
        if (b != null)
        {
            b.b();
        }
    }

    public void b(int k)
    {
        fp.a().a(new hq(k) {

            final int a;
            final du b;

            public void safeRun()
            {
                if (du.a(b) != null)
                {
                    du.a(b).a(a);
                }
            }

            
            {
                b = du.this;
                a = k;
                super();
            }
        });
    }

    public void b(String s)
    {
        if (a != null)
        {
            a.a(s);
        }
        if (c != null)
        {
            c.a();
        }
        if (b != null)
        {
            b.e();
        }
    }

    public int c()
    {
        if (b != null)
        {
            return b.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public void d()
    {
        if (c != null)
        {
            c.a();
        }
        if (b != null && b.isPlaying())
        {
            b.c();
        }
    }

    public View e()
    {
        return d;
    }

    public int f()
    {
        if (b != null)
        {
            return b.d();
        } else
        {
            return 0;
        }
    }

    public void g()
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void h()
    {
        if (a != null)
        {
            a.e();
        }
    }

    public void i()
    {
        if (a != null)
        {
            a.b();
        }
    }

    public void j()
    {
        if (c != null)
        {
            c.a();
            c = null;
        }
        if (b != null)
        {
            b.e();
            b = null;
        }
    }
}
