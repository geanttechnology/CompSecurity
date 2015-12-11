// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class rs
{

    private rr a;
    private Bundle b;
    private LinkedList c;
    private final sc d = new sc() {

        final rs a;

        public void a(rr rr1)
        {
            rs.a(a, rr1);
            for (rr1 = rs.a(a).iterator(); rr1.hasNext(); ((rt)rr1.next()).a(rs.b(a))) { }
            rs.a(a).clear();
            rs.a(a, null);
        }

            
            {
                a = rs.this;
                super();
            }
    };

    public rs()
    {
    }

    static Bundle a(rs rs1, Bundle bundle)
    {
        rs1.b = bundle;
        return bundle;
    }

    static LinkedList a(rs rs1)
    {
        return rs1.c;
    }

    static rr a(rs rs1, rr rr1)
    {
        rs1.a = rr1;
        return rr1;
    }

    private void a(int i)
    {
        for (; !c.isEmpty() && ((rt)c.getLast()).a() >= i; c.removeLast()) { }
    }

    private void a(Bundle bundle, rt rt1)
    {
        if (a != null)
        {
            rt1.a(a);
            return;
        }
        if (c == null)
        {
            c = new LinkedList();
        }
        c.add(rt1);
        if (bundle != null)
        {
            if (b == null)
            {
                b = (Bundle)bundle.clone();
            } else
            {
                b.putAll(bundle);
            }
        }
        a(d);
    }

    static rr b(rs rs1)
    {
        return rs1.a;
    }

    public static void b(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int i = pu.a(context);
        String s1 = pu.a(context, i);
        String s = pu.b(context, i);
        LinearLayout linearlayout = new LinearLayout(framelayout.getContext());
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.addView(linearlayout);
        framelayout = new TextView(framelayout.getContext());
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        framelayout.setText(s1);
        linearlayout.addView(framelayout);
        if (s != null)
        {
            framelayout = new Button(context);
            framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            framelayout.setText(s);
            linearlayout.addView(framelayout);
            framelayout.setOnClickListener(new android.view.View.OnClickListener(context, i) {

                final Context a;
                final int b;

                public void onClick(View view)
                {
                    a.startActivity(pu.b(b));
                }

            
            {
                a = context;
                b = i;
                super();
            }
            });
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        a(bundle, new rt(framelayout, layoutinflater, viewgroup, bundle) {

            final FrameLayout a;
            final LayoutInflater b;
            final ViewGroup c;
            final Bundle d;
            final rs e;

            public int a()
            {
                return 2;
            }

            public void a(rr rr1)
            {
                a.removeAllViews();
                a.addView(rs.b(e).a(b, c, d));
            }

            
            {
                e = rs.this;
                a = framelayout;
                b = layoutinflater;
                c = viewgroup;
                d = bundle;
                super();
            }
        });
        if (a == null)
        {
            a(framelayout);
        }
        return framelayout;
    }

    public rr a()
    {
        return a;
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle1)
    {
        a(bundle1, new rt(activity, bundle, bundle1) {

            final Activity a;
            final Bundle b;
            final Bundle c;
            final rs d;

            public int a()
            {
                return 0;
            }

            public void a(rr rr1)
            {
                rs.b(d).a(a, b, c);
            }

            
            {
                d = rs.this;
                a = activity;
                b = bundle;
                c = bundle1;
                super();
            }
        });
    }

    public void a(Bundle bundle)
    {
        a(bundle, new rt(bundle) {

            final Bundle a;
            final rs b;

            public int a()
            {
                return 1;
            }

            public void a(rr rr1)
            {
                rs.b(b).a(a);
            }

            
            {
                b = rs.this;
                a = bundle;
                super();
            }
        });
    }

    protected void a(FrameLayout framelayout)
    {
        b(framelayout);
    }

    protected abstract void a(sc sc);

    public void b()
    {
        a(((Bundle) (null)), new rt() {

            final rs a;

            public int a()
            {
                return 4;
            }

            public void a(rr rr1)
            {
                rs.b(a).a();
            }

            
            {
                a = rs.this;
                super();
            }
        });
    }

    public void b(Bundle bundle)
    {
        if (a != null)
        {
            a.b(bundle);
        } else
        if (b != null)
        {
            bundle.putAll(b);
            return;
        }
    }

    public void c()
    {
        a(((Bundle) (null)), new rt() {

            final rs a;

            public int a()
            {
                return 5;
            }

            public void a(rr rr1)
            {
                rs.b(a).b();
            }

            
            {
                a = rs.this;
                super();
            }
        });
    }

    public void d()
    {
        if (a != null)
        {
            a.c();
            return;
        } else
        {
            a(5);
            return;
        }
    }

    public void e()
    {
        if (a != null)
        {
            a.d();
            return;
        } else
        {
            a(4);
            return;
        }
    }

    public void f()
    {
        if (a != null)
        {
            a.e();
            return;
        } else
        {
            a(2);
            return;
        }
    }

    public void g()
    {
        if (a != null)
        {
            a.f();
            return;
        } else
        {
            a(1);
            return;
        }
    }

    public void h()
    {
        if (a != null)
        {
            a.g();
        }
    }
}
