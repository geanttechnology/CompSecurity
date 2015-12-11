// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.apps.youtube.core.player.overlay.DefaultOverflowOverlay;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.TimeBar;
import com.google.android.libraries.youtube.common.ui.TouchImageView;

public final class act extends cva
    implements android.view.View.OnClickListener
{

    private acd A;
    final sv a;
    final TimeBar b = (TimeBar)findViewById(0x7f1000d3);
    public final TextView c = (TextView)findViewById(0x7f1000cb);
    public boolean d;
    boolean e;
    public boolean f;
    public ada g;
    ss h;
    public CountDownTimer i;
    public boolean j;
    private final acw k = new acw(this);
    private final View l = findViewById(0x7f1000cd);
    private final View m = findViewById(0x7f1000d1);
    private final View n = findViewById(0x7f1000d2);
    private final View o = findViewById(0x7f1000ce);
    private final ViewGroup p = (ViewGroup)findViewById(0x7f1000d0);
    private final TouchImageView q = (TouchImageView)findViewById(0x7f1000cf);
    private final View r = findViewById(0x7f1001bf);
    private final TextView s;
    private final TextView t;
    private View u;
    private View v;
    private boolean w;
    private boolean x;
    private cuv y;
    private final acz z = new acz(this);

    public act(Context context)
    {
        super(context);
        w = false;
        x = false;
        f = false;
        y = cuv.a;
        LayoutInflater.from(context).inflate(0x7f040026, this);
        LayoutInflater.from(context).inflate(0x7f040068, this);
        s = (TextView)r.findViewById(0x7f1001c0);
        t = (TextView)r.findViewById(0x7f1001c2);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        b.a = new adb(this);
        q.setOnClickListener(this);
        h = new su();
        h.a(z);
        h.a(cux.a);
        a = new sv(context);
        i = new acu(this, 3200L, 1000L);
        j = false;
        A = ((KidsApplication)getContext().getApplicationContext()).h().R();
    }

    static boolean a(act act1)
    {
        return act1.d;
    }

    static cuv b(act act1)
    {
        return act1.y;
    }

    static ada c(act act1)
    {
        return act1.g;
    }

    static TextView d(act act1)
    {
        return act1.t;
    }

    private void e()
    {
        int i1;
        if (e)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (u != null)
        {
            u.setVisibility(i1);
        }
        if (v != null)
        {
            v.setVisibility(i1);
        }
    }

    static void e(act act1)
    {
        act1.a();
    }

    static TimeBar f(act act1)
    {
        return act1.b;
    }

    public void a()
    {
        j = false;
        r.setVisibility(8);
        g.g();
    }

    public final void a(cuv cuv1)
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                if (y == cuv1)
                {
                    break label0;
                }
                x = w;
                View view;
                int i1;
                boolean flag;
                if (y == cuv.b && cuv1 == cuv.d && !d && !k.hasMessages(1))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                w = flag;
                y = cuv1;
                if (cuv1 == cuv.d)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(flag);
                if (cuv1 == cuv.g)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                view = o;
                if (i1 != 0)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                view.setVisibility(i1);
                if (cuv1 == cuv.d)
                {
                    break label0;
                }
                if (cuv1 != cuv.c)
                {
                    flag = flag1;
                    if (cuv1 != cuv.g)
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            b(flag);
        }
        if (y == cuv.b && !d && !x && !k.hasMessages(1))
        {
            k.sendEmptyMessageDelayed(1, 5000L);
        }
    }

    public final void a(String s1)
    {
        g.c();
        r.setVisibility(0);
        s.setText(s1);
        j = true;
        i.start();
    }

    public final void a(boolean flag)
    {
        View view = l;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

    public void b()
    {
        p.setVisibility(8);
    }

    public final void b(boolean flag)
    {
        byte byte0 = 8;
        View view = m;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = n;
        if (flag)
        {
            i1 = byte0;
        } else
        {
            i1 = 0;
        }
        view.setVisibility(i1);
    }

    public void c()
    {
        if (!f)
        {
            p.setVisibility(0);
        }
    }

    public final void c(boolean flag)
    {
        if (e != flag)
        {
            e = flag;
            e();
        }
    }

    public final void d()
    {
        k.removeMessages(1);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1);
    }

    public final View getView()
    {
        return this;
    }

    public final void onClick(View view)
    {
        d();
        if (g != null)
        {
            if (view == o)
            {
                g.d();
            } else
            {
                if (view == m)
                {
                    A.b(0x7f080017);
                    g.b();
                    return;
                }
                if (view == n)
                {
                    A.b(0x7f080016);
                    g.c();
                    return;
                }
                if (view == q)
                {
                    if (h instanceof su)
                    {
                        LayoutInflater.from(getContext()).inflate(0x7f04002c, this);
                        view = (DefaultOverflowOverlay)findViewById(0x7f100103);
                        ((su)h).a(view);
                        View view1 = view.findViewById(0x7f100109);
                        if (view1 != null)
                        {
                            view1.setVisibility(8);
                        }
                        view1 = view.findViewById(0x7f10010a);
                        if (view1 != null)
                        {
                            view1.setVisibility(8);
                        }
                        u = view.findViewById(0x7f10010b);
                        v = view.findViewById(0x7f10010c);
                        e();
                        h = view;
                    }
                    h.a();
                    return;
                }
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        while (super.onTouchEvent(motionevent) || motionevent.getAction() != 1) 
        {
            return true;
        }
        motionevent = g;
        boolean flag;
        if (!d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        motionevent.a(flag);
        return true;
    }
}
