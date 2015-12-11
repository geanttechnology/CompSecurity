// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.i;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package android.support.v7:
//            li, lm

public abstract class lj
{
    private static interface a
    {

        public abstract int a();

        public abstract void a(li li1);
    }


    private li a;
    private Bundle b;
    private LinkedList c;
    private final lm d = new lm() {

        final lj a;

        public void a(li li1)
        {
            lj.a(a, li1);
            for (li1 = lj.a(a).iterator(); li1.hasNext(); ((a)li1.next()).a(lj.b(a))) { }
            lj.a(a).clear();
            lj.a(a, null);
        }

            
            {
                a = lj.this;
                super();
            }
    };

    public lj()
    {
    }

    static Bundle a(lj lj1, Bundle bundle)
    {
        lj1.b = bundle;
        return bundle;
    }

    static li a(lj lj1, li li1)
    {
        lj1.a = li1;
        return li1;
    }

    static LinkedList a(lj lj1)
    {
        return lj1.c;
    }

    private void a(int j)
    {
        for (; !c.isEmpty() && ((a)c.getLast()).a() >= j; c.removeLast()) { }
    }

    private void a(Bundle bundle, a a1)
    {
        if (a != null)
        {
            a1.a(a);
            return;
        }
        if (c == null)
        {
            c = new LinkedList();
        }
        c.add(a1);
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

    static li b(lj lj1)
    {
        return lj1.a;
    }

    public static void b(FrameLayout framelayout)
    {
        Context context = framelayout.getContext();
        int j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String s1 = i.a(context, j, GooglePlayServicesUtil.zzaf(context));
        String s = i.b(context, j);
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
            framelayout.setOnClickListener(new android.view.View.OnClickListener(context, j) {

                final Context a;
                final int b;

                public void onClick(View view)
                {
                    a.startActivity(GooglePlayServicesUtil.zzbc(b));
                }

            
            {
                a = context;
                b = j;
                super();
            }
            });
        }
    }

    public li a()
    {
        return a;
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        FrameLayout framelayout = new FrameLayout(layoutinflater.getContext());
        a(bundle, new a(framelayout, layoutinflater, viewgroup, bundle) {

            final FrameLayout a;
            final LayoutInflater b;
            final ViewGroup c;
            final Bundle d;
            final lj e;

            public int a()
            {
                return 2;
            }

            public void a(li li1)
            {
                a.removeAllViews();
                a.addView(lj.b(e).a(b, c, d));
            }

            
            {
                e = lj.this;
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

    public void a(Activity activity, Bundle bundle, Bundle bundle1)
    {
        a(bundle1, new a(activity, bundle, bundle1) {

            final Activity a;
            final Bundle b;
            final Bundle c;
            final lj d;

            public int a()
            {
                return 0;
            }

            public void a(li li1)
            {
                lj.b(d).a(a, b, c);
            }

            
            {
                d = lj.this;
                a = activity;
                b = bundle;
                c = bundle1;
                super();
            }
        });
    }

    public void a(Bundle bundle)
    {
        a(bundle, new a(bundle) {

            final Bundle a;
            final lj b;

            public int a()
            {
                return 1;
            }

            public void a(li li1)
            {
                lj.b(b).a(a);
            }

            
            {
                b = lj.this;
                a = bundle;
                super();
            }
        });
    }

    protected abstract void a(lm lm);

    protected void a(FrameLayout framelayout)
    {
        b(framelayout);
    }

    public void b()
    {
        a(((Bundle) (null)), new a() {

            final lj a;

            public int a()
            {
                return 5;
            }

            public void a(li li1)
            {
                lj.b(a).a();
            }

            
            {
                a = lj.this;
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
        if (a != null)
        {
            a.b();
            return;
        } else
        {
            a(5);
            return;
        }
    }

    public void d()
    {
        if (a != null)
        {
            a.c();
            return;
        } else
        {
            a(2);
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
            a(1);
            return;
        }
    }

    public void f()
    {
        if (a != null)
        {
            a.e();
        }
    }
}
