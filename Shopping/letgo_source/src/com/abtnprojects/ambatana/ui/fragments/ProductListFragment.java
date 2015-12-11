// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.ed;
import android.support.v7.ee;
import android.support.v7.em;
import android.support.v7.fh;
import android.support.v7.gf;
import android.support.v7.gh;
import android.support.v7.gr;
import android.support.v7.hx;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.SearchParameters;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.ui.activities.e;
import com.abtnprojects.ambatana.ui.widgets.NoNetworkView;
import com.abtnprojects.ambatana.ui.widgets.RecyclerViewWithEmpty;
import com.abtnprojects.ambatana.ui.widgets.SellButtonLayout;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseUser;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            h

public class ProductListFragment extends h
{
    public class a
    {

        final int a;
        final int b;
        final ProductListFragment c;

        public a(int i, int j)
        {
            c = ProductListFragment.this;
            super();
            a = i;
            b = j;
        }
    }


    protected SearchParameters al;
    protected e am;
    private fh an;
    private String ao;
    private a ap;
    RelativeLayout distanceBubbleLayout;
    TextView distanceBubbleTv;
    NoNetworkView emptyViewWhenNoNetwork;
    RelativeLayout searchParamsLayout;

    public ProductListFragment()
    {
        ao = null;
    }

    public static ProductListFragment Y()
    {
        return new ProductListFragment();
    }

    static void a(ProductListFragment productlistfragment)
    {
        productlistfragment.aa();
    }

    private void a(String s)
    {
        distanceBubbleTv.setText(s);
        if (distanceBubbleLayout.getVisibility() != 0)
        {
            distanceBubbleLayout.setVisibility(0);
        }
    }

    private void aa()
    {
        a a1 = ab();
        if (a1 == null)
        {
            ap = null;
            ac();
            return;
        }
        String s;
        int i;
        if (ap == null)
        {
            i = a1.a;
        } else
        if (a1.b == ap.b)
        {
            i = ap.a;
        } else
        if (a1.b > ap.b)
        {
            i = Math.max(a1.a, ap.a);
        } else
        {
            i = Math.min(a1.a, ap.a);
        }
        if (i == 0)
        {
            s = "";
            ap = null;
        } else
        if (i < 20)
        {
            s = String.format(a(0x7f090096), new Object[] {
                (new StringBuilder()).append(i).append(" ").append(d).toString()
            });
            ap = new a(i, a1.b);
        } else
        {
            s = b(20);
            ap = new a(i, a1.b);
        }
        if (!TextUtils.isEmpty(s))
        {
            a(s);
            return;
        } else
        {
            ac();
            return;
        }
    }

    private a ab()
    {
        Object obj1 = null;
        a a1 = obj1;
        if (f != null)
        {
            a1 = obj1;
            if (f.a() > 0)
            {
                Object obj;
                int i;
                try
                {
                    obj = this.i.findFirstVisibleItemPositions(null);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    obj = null;
                }
                if (obj == null || obj.length == 0)
                {
                    i = -1;
                } else
                {
                    i = obj[0];
                }
                a1 = obj1;
                if (i >= 0)
                {
                    try
                    {
                        obj = f.a(i);
                    }
                    catch (IllegalArgumentException illegalargumentexception)
                    {
                        illegalargumentexception = null;
                    }
                    a1 = obj1;
                    if (obj != null)
                    {
                        a1 = new a(((Product) (obj)).getDistanceRange(), i);
                    }
                }
            }
        }
        return a1;
    }

    private void ac()
    {
        distanceBubbleLayout.setVisibility(8);
    }

    private String b(int i)
    {
        if (ao != null)
        {
            return ao;
        }
        String s = a(d, i);
        if (s == null)
        {
            return null;
        } else
        {
            ao = String.format(a(0x7f090097), new Object[] {
                s
            });
            return ao;
        }
    }

    protected CharSequence Q()
    {
        if (am != null)
        {
            LatitudeLongitude latitudelongitude = (new dw(am, new AddressMapper())).c();
            if (latitudelongitude == null || !latitudelongitude.isValid())
            {
                V();
                return k().getString(0x7f0901c9);
            }
            if (al != null && !TextUtils.isEmpty(al.getQuery()))
            {
                return Html.fromHtml(String.format(k().getString(0x7f090149), new Object[] {
                    al.getQuery()
                }));
            }
            if (al != null && al.areCustomParamsAvailable())
            {
                return k().getString(0x7f090147);
            } else
            {
                return k().getString(0x7f090142);
            }
        } else
        {
            return k().getString(0x7f090142);
        }
    }

    protected void S()
    {
        if (!iv.b(j()))
        {
            ak.setVisibility(4);
            e.setEmptyView(emptyViewWhenNoNetwork);
        } else
        {
            super.S();
        }
        ac();
    }

    protected void T()
    {
        super.T();
        e.addOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

            final ProductListFragment a;

            public void onScrollStateChanged(RecyclerView recyclerview, int i)
            {
                super.onScrollStateChanged(recyclerview, i);
            }

            public void onScrolled(RecyclerView recyclerview, int i, int j)
            {
                super.onScrolled(recyclerview, i, j);
                ProductListFragment.a(a);
            }

            
            {
                a = ProductListFragment.this;
                super();
            }
        });
    }

    protected void V()
    {
        super.V();
        ac();
    }

    protected void W()
    {
        super.W();
    }

    public void X()
    {
        e.setEmptyView(a);
        searchParamsLayout.setVisibility(8);
        R();
        al = am.C();
        a(is.g(j()));
        ap = null;
        a(c, g);
    }

    protected void Z()
    {
        if (am != null)
        {
            am.v();
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.a(layoutinflater, viewgroup, bundle);
        ButterKnife.bind(this, layoutinflater);
        b = k().getConfiguration().locale.getLanguage();
        al = am.C();
        if (g != null && g.isValid())
        {
            a(c, g);
        }
        return layoutinflater;
    }

    public String a(String s, int i)
    {
        if (i != 0 && s != null)
        {
            return (new StringBuilder()).append(i).append(" ").append(s).toString();
        } else
        {
            return null;
        }
    }

    public void a(int i, LatitudeLongitude latitudelongitude)
    {
        Void avoid[];
label0:
        {
            if (h == null)
            {
                h = iv.a(j());
            }
            if (am != null && an == null)
            {
                V();
                an = new fh(am, i, d, b, al, this, latitudelongitude, h);
                latitudelongitude = an;
                avoid = new Void[0];
                if (latitudelongitude instanceof AsyncTask)
                {
                    break label0;
                }
                latitudelongitude.execute(avoid);
            }
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)latitudelongitude, avoid);
    }

    public void a(Activity activity)
    {
        super.a(activity);
        try
        {
            am = (e)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException("The parent activity must extend PublicBaseActivity");
        }
    }

    public void a(AsyncTask asynctask)
    {
        if (asynctask != null && asynctask.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            asynctask.cancel(false);
        }
    }

    public void a(gf gf1)
    {
        an = null;
        if (al != null && gf1 != null)
        {
            a(ParseUser.getCurrentUser(), al.getCategoryIds(), gf1.a(), al.getQuery(), 20);
        }
        W();
        if (al.areCustomParamsAvailable())
        {
            searchParamsLayout.setVisibility(0);
            t().findViewById(0x7f100107).setOnClickListener(new android.view.View.OnClickListener() {

                final ProductListFragment a;

                public void onClick(View view)
                {
                    is.b(a.j());
                    a.X();
                }

            
            {
                a = ProductListFragment.this;
                super();
            }
            });
        } else
        {
            searchParamsLayout.setVisibility(8);
        }
        super.a(gf1);
        aa();
    }

    public void a(ParseUser parseuser, List list, int i, String s, int j)
    {
        gr gr1 = new gr(new gh(), new iu(), j);
        if (parseuser != null && am != null)
        {
            gr1.a(am, parseuser, list, i, s);
        }
    }

    public void d()
    {
        super.d();
        am = null;
    }

    public void f()
    {
        super.f();
        a(an);
    }

    public void on(ee ee1)
    {
        if (g == null || !g.isValid())
        {
            ee1 = ee1.a;
            if (ee1 != null)
            {
                g = new LatitudeLongitude(ee1.getLatitude(), ee1.getLongitude());
                X();
            }
        }
    }

    public void onEvent(ed ed)
    {
        if (am != null && LetgoApplication.h())
        {
            Z();
        }
    }

    public void onReloadData(em em)
    {
        X();
    }

    public void u()
    {
        super.u();
        iv.a(this);
    }

    public void v()
    {
        super.v();
        an = null;
        W();
        iv.b(this);
    }

    public void w()
    {
        a(an);
        super.w();
    }
}
