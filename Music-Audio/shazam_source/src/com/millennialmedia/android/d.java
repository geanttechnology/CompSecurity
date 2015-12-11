// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ae, MMActivity, e, ab, 
//            ac, q, ao, y, 
//            OverlaySettings, al, ak, an

class d extends ae
{

    OverlaySettings a;
    boolean b;
    boolean c;
    private e e;

    d()
    {
    }

    private void h()
    {
        if (d.getRequestedOrientation() == 0)
        {
            a(0);
            return;
        }
        if (d.getRequestedOrientation() == 8)
        {
            a(8);
            return;
        }
        if (d.getRequestedOrientation() == 9)
        {
            a(9);
            return;
        } else
        {
            a(1);
            return;
        }
    }

    public final void a()
    {
        if (e != null)
        {
            e e1 = e;
            android.view.ViewParent viewparent;
            boolean flag;
            if (e1.h != null && e1.h.o != 0L && ac.b(e1.h))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                e1 = e;
                q.a();
                if (e1.h != null && e1.h.l != null && e1.h.l.b != null)
                {
                    e1.h.l.b.clearFocus();
                    e1.h.l.b.m();
                    if (e1.h.f == "i")
                    {
                        e1.h.l.b.l();
                    }
                    e1.h.l.b.i();
                }
            }
            e1 = e;
            e1.removeAllViews();
            viewparent = e1.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(e1);
            }
        }
        e = null;
        super.a();
    }

    public final void a(Configuration configuration)
    {
        if (e != null)
        {
            e e1 = e;
            if (e1.l != null && e1.k != null)
            {
                e1.k.setLayoutParams(e1.l.a());
                e1.c();
            }
        }
        super.a(configuration);
    }

    protected final void a(Bundle bundle)
    {
        b(0x1030010);
        super.a(bundle);
        g();
        super.d.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        super.d.getWindow().clearFlags(1024);
        super.d.getWindow().addFlags(2048);
        super.d.getWindow().addFlags(0x1000000);
        bundle = super.d.getIntent();
        a = (OverlaySettings)bundle.getParcelableExtra("settings");
        if (a == null)
        {
            a = new OverlaySettings();
        }
        a.toString();
        al.a();
        if (a.g != null)
        {
            Object obj = a.g;
            if ("landscape".equalsIgnoreCase(((String) (obj))))
            {
                a(0);
            } else
            if ("portrait".equalsIgnoreCase(((String) (obj))))
            {
                a(1);
            }
        }
        if (a.l)
        {
            a(-1);
        } else
        {
            h();
        }
        if (bundle != null)
        {
            bundle = bundle.getData();
            if (bundle != null)
            {
                String.format("Path: %s", new Object[] {
                    bundle.getLastPathSegment()
                });
                al.a();
            }
        }
        bundle = new RelativeLayout(d);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        bundle.setId(0x34c60db9);
        bundle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        e = new e(this, a);
        bundle.addView(e);
        a(((android.view.View) (bundle)));
        if (super.d.getLastNonConfigurationInstance() == null)
        {
            if (a.a())
            {
                if (e.h != null && e.h.l != null && e.h.l.b != null)
                {
                    e.h.l.b.o();
                }
                if (a.b())
                {
                    (new e.e(e, a.h)).execute(new Void[0]);
                }
            } else
            if (!a.a())
            {
                Object obj1 = e;
                bundle = a.m;
                String s = a.n;
                if (an.a(((ak) (obj1)).getContext()))
                {
                    if (((ak) (obj1)).h.l != null)
                    {
                        obj1 = ((ak) (obj1)).h.l;
                        ab ab1 = (ab)((ac) (obj1)).c.get();
                        if (ab1 != null && ((ac) (obj1)).b != null)
                        {
                            ((ac) (obj1)).b.a(bundle, s, ab1);
                        }
                    }
                } else
                {
                    al.a("MMLayout", "No network available, can't load overlay.");
                }
            }
        }
        a.g = null;
    }

    final void a(boolean flag)
    {
        a.l = flag;
        if (flag)
        {
            a(-1);
            return;
        } else
        {
            h();
            return;
        }
    }

    public final boolean a(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0 && e != null)
        {
            e.b();
            return true;
        } else
        {
            return super.a(i, keyevent);
        }
    }

    protected final void b()
    {
        c = false;
        al.b();
        if (e != null)
        {
            e e1 = e;
            if (((ak) (e1)).l != null)
            {
                ((ak) (e1)).l.b();
            }
            if (e.h != null && e.h.l != null && e.h.l.b != null)
            {
                e.h.l.b.j();
            }
        }
        super.b();
    }

    protected final void b(Bundle bundle)
    {
        if (e != null)
        {
            bundle.putInt("adViewId", e.getId());
        }
        super.b(bundle);
    }

    public final void b(boolean flag)
    {
        super.b(flag);
        b = flag;
    }

    protected final void c()
    {
        o.a a1;
        c = true;
        (new StringBuilder("Overlay onPause: ")).append(e);
        al.b();
        a1 = o.a.a(d);
        if (a1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        a1.b();
        this;
        JVM INSTR monitorexit ;
_L2:
        if (e != null)
        {
            Object obj = e;
            if (((ak) (obj)).l != null)
            {
                obj = ((ak) (obj)).l;
                ((y) (obj)).a.o = ((y) (obj)).getCurrentPosition();
                ((y) (obj)).c();
            }
            if (e.h != null && e.h.l != null && e.h.l.b != null)
            {
                e.h.l.b.i();
            }
        }
        super.d.setResult(0);
        super.c();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected final void c(Bundle bundle)
    {
        super.c(bundle);
    }

    protected final void d()
    {
        super.d();
        al.b();
    }

    protected final void e()
    {
        super.e();
    }

    public final Object f()
    {
        if (e != null)
        {
            e e1 = e;
            e.f f1 = new e.f((byte)0);
            if (e1.h != null)
            {
                (new StringBuilder("Saving getNonConfigurationInstance for ")).append(e1.h);
                al.b();
                if (e1.h.l != null && e1.h.l.b != null)
                {
                    e1.h.l.b.p();
                }
                f1.b = e1.h.l;
            }
            f1.a = e1.a;
            f1.c = e1.b;
            return f1;
        } else
        {
            return null;
        }
    }
}
