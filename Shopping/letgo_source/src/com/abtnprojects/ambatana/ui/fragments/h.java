// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.ge;
import android.support.v7.gf;
import android.support.v7.hx;
import android.support.v7.hz;
import android.support.v7.ia;
import android.support.v7.is;
import android.support.v7.iv;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.ui.activities.ProductActivity;
import com.abtnprojects.ambatana.ui.activities.ProductListingActivity;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.abtnprojects.ambatana.ui.widgets.AmbatanaSwipeToRefreshLayout;
import com.abtnprojects.ambatana.ui.widgets.RecyclerViewWithEmpty;
import com.abtnprojects.ambatana.ui.widgets.SellButtonLayout;
import com.abtnprojects.ambatana.ui.widgets.a;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class h extends Fragment
    implements TraceFieldInterface
{

    private static long al = -1L;
    protected TextView a;
    Handler aj;
    SellButtonLayout ak;
    private boolean am;
    private List an;
    private int ao;
    private AmbatanaSwipeToRefreshLayout ap;
    private com.abtnprojects.ambatana.ui.widgets.SellButtonLayout.a aq;
    private boolean ar;
    protected String b;
    protected volatile int c;
    protected String d;
    protected RecyclerViewWithEmpty e;
    hx f;
    protected LatitudeLongitude g;
    protected CountryCurrencyInfo h;
    StaggeredGridLayoutManager i;

    public h()
    {
        c = 0;
        e = null;
        an = new ArrayList();
        ao = 2;
        aj = new Handler();
        ar = true;
    }

    private void Y()
    {
        if (ak != null)
        {
            ak.setTapHandler(aq);
        }
    }

    private void Z()
    {
        if (ap != null)
        {
            int j = k().getDimensionPixelSize(0x7f0a00af);
            int k = k().getDimensionPixelSize(0x7f0a00ae);
            int l = (int)TypedValue.applyDimension(1, 2.0F, k().getDisplayMetrics());
            ap.a(false, j + l, k + l);
        }
    }

    private void a(View view)
    {
        ap = (AmbatanaSwipeToRefreshLayout)view.findViewById(0x7f100108);
        if (ap != null)
        {
            ap.setColorSchemeColors(new int[] {
                0x7f0f0065
            });
            ap.setEnabled(false);
            ap.setOnChildScrollUpListener(new com.abtnprojects.ambatana.ui.widgets.AmbatanaSwipeToRefreshLayout.a() {

                final h a;

                public boolean a()
                {
                    boolean flag1 = false;
                    boolean flag = flag1;
                    if (a.e != null)
                    {
                        flag = flag1;
                        if (a.e.getChildAt(0) != null)
                        {
                            flag = flag1;
                            if (a.e.getChildAt(0).getTop() < 0)
                            {
                                flag = true;
                            }
                        }
                    }
                    return flag;
                }

            
            {
                a = h.this;
                super();
            }
            });
            ap.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.a() {

                final h a;

                public void a()
                {
                    a.a();
                }

            
            {
                a = h.this;
                super();
            }
            });
        }
    }

    public static boolean b()
    {
        long l;
        if (al == -1L)
        {
            l = 0L;
        } else
        {
            l = System.currentTimeMillis() - al;
        }
        al = -1L;
        return l > 0x66ff300L;
    }

    protected abstract CharSequence Q();

    protected void R()
    {
        aqo.a("ResetData begin", new Object[0]);
        ap.setEnabled(false);
        a.setText("");
        int j;
        if (an == null)
        {
            j = 0;
        } else
        {
            j = an.size();
        }
        if (j > 0)
        {
            an.clear();
            f.notifyItemRangeRemoved(0, j);
        }
        c = 0;
        ap.setEnabled(true);
        aqo.a("ResetData finished", new Object[0]);
    }

    protected void S()
    {
        e.setEmptyView(a);
        CharSequence charsequence = Q();
        a.setText(charsequence);
    }

    protected void T()
    {
        e.addOnItemTouchListener(new ia(new android.support.v7.ia.a() {

            final h a;

            public void a(View view, int j)
            {
                view = a.j();
                if (view == null || a.f == null)
                {
                    break MISSING_BLOCK_LABEL_130;
                }
                Intent intent = new Intent(view, com/abtnprojects/ambatana/ui/activities/ProductActivity);
                if (!(view instanceof ProductListingActivity)) goto _L2; else goto _L1
_L1:
                intent.putExtra("referral", "product_list_referral");
_L4:
                intent.putExtra("product", a.f.a(j));
                if (!iv.a(21));
                a.a(intent);
                return;
_L2:
                if (view instanceof UserProfileActivity)
                {
                    intent.putExtra("referral", "user_profile_referral");
                }
                if (true) goto _L4; else goto _L3
_L3:
                view;
                aqo.d((new StringBuilder()).append("Invalid item : in position : ").append(j).toString(), new Object[0]);
            }

            
            {
                a = h.this;
                super();
            }
        }, j()));
        e.clearOnScrollListeners();
        e.addOnScrollListener(new hz() {

            final h a;

            public void a(int j, int k)
            {
                a.U();
            }

            
            {
                a = h.this;
                super();
            }
        });
    }

    protected void U()
    {
        if (ar)
        {
            a(c, g);
        }
    }

    protected void V()
    {
        if (ap != null)
        {
            ap.setVisibility(0);
            ap.setEnabled(true);
            ap.setRefreshing(true);
        }
    }

    protected void W()
    {
        if (ap != null)
        {
            ap.setRefreshing(false);
        }
    }

    abstract void X();

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04003d, null, false);
        a = (TextView)layoutinflater.findViewById(0x7f10010a);
        ao = j().getResources().getInteger(0x7f0d0000);
        d = is.a(j(), Locale.getDefault());
        e = (RecyclerViewWithEmpty)layoutinflater.findViewById(0x7f100109);
        e.setHasFixedSize(false);
        e.addItemDecoration(new a(j()));
        i = new StaggeredGridLayoutManager(ao, 1);
        i.setGapStrategy(2);
        e.setLayoutManager(i);
        e.setEmptyView(a);
        a(((View) (layoutinflater)));
        Z();
        an.clear();
        h = iv.a(j());
        f = new hx(j(), an);
        e.setAdapter(f);
        ak = (SellButtonLayout)layoutinflater.findViewById(0x7f10007c);
        Y();
        am = true;
        a(is.g(j()));
        return layoutinflater;
    }

    protected void a()
    {
        if (j() != null)
        {
            ap.setEnabled(false);
            R();
            a(is.g(j()));
            a(c, g);
        }
    }

    abstract void a(int j, LatitudeLongitude latitudelongitude);

    public void a(Activity activity)
    {
        super.a(activity);
        try
        {
            aq = (com.abtnprojects.ambatana.ui.widgets.SellButtonLayout.a)activity;
            Y();
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.getClass().getSimpleName()).append(" must implement ").append("HandleSellTap").toString());
        }
        if (ap != null)
        {
            ap.setAcceptEvents(true);
        }
    }

    public void a(AsyncTask asynctask)
    {
        if (asynctask != null && asynctask.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            asynctask.cancel(false);
        }
    }

    public void a(gf gf)
    {
        int j;
        int k;
        boolean flag;
        aqo.a("updateUI start", new Object[0]);
        ap.setEnabled(false);
        if (an == null)
        {
            j = 0;
        } else
        {
            j = an.size();
        }
        if (!(gf instanceof ge)) goto _L2; else goto _L1
_L1:
        if (an == null)
        {
            an = new ArrayList();
        }
        gf = (ge)gf;
        boolean flag1;
        if (!gf.b())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ar = flag1;
        if (gf == null)
        {
            gf = null;
        } else
        {
            gf = gf.c();
        }
        if (gf != null && gf.size() != 0)
        {
            an.addAll(gf);
            k = c;
            c = gf.size() + k;
        }
        if (an == null)
        {
            k = 0;
        } else
        {
            k = an.size();
        }
        T();
        if (j == 0 && k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f != null) goto _L4; else goto _L3
_L3:
        aqo.a("updateUI : Adapter was null", new Object[0]);
        f = new hx(j(), an);
        e.setAdapter(f);
_L2:
        if (an == null || an.size() == 0)
        {
            S();
        }
        if (iv.b(j()) && ak.getVisibility() != 0)
        {
            ak.setVisibility(0);
        }
        ap.setRefreshing(false);
        ap.setEnabled(true);
        aqo.a("updateUI finished", new Object[0]);
        return;
_L4:
        if (flag)
        {
            aqo.a("updateUI shouldResetCurrentPosition", new Object[0]);
            f.notifyDataSetChanged();
            aj.post(new Runnable() {

                final h a;

                public void run()
                {
                    aqo.a("updateUI before scrollToPosition", new Object[0]);
                    a.e.scrollToPosition(0);
                    aqo.a("updateUI after scrollToPosition", new Object[0]);
                }

            
            {
                a = h.this;
                super();
            }
            });
        } else
        if (j < k)
        {
            aqo.a("updateUI before notifyItemRangeInserted", new Object[0]);
            f.notifyItemRangeInserted(c, k - j);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void a(boolean flag)
    {
        Object obj;
        if (flag)
        {
            g = (new dw(j(), new AddressMapper())).a().getPoint();
        } else
        {
            obj = LetgoApplication.i();
            if (obj != null)
            {
                g = ((CurrentUserLocation) (obj)).getLatitudeLongitude();
            } else
            {
                g = (new dw(j(), new AddressMapper())).c();
            }
        }
        if (g == null)
        {
            obj = null;
        } else
        {
            obj = g.toString();
        }
        aqo.a(((String) (obj)), new Object[0]);
    }

    public void c()
    {
        if (ap != null)
        {
            ap.setAcceptEvents(false);
        }
    }

    public void d()
    {
        super.d();
        aq = null;
        Y();
        c();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void u()
    {
        boolean flag1 = false;
        super.u();
        if (am)
        {
            am = false;
        } else
        {
            String s = is.a(j(), Locale.getDefault());
            boolean flag;
            if (!d.equalsIgnoreCase(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d = s;
            if (an == null || an.isEmpty())
            {
                flag1 = true;
            }
            if (flag || b() || flag1)
            {
                X();
                return;
            }
        }
    }

    public void v()
    {
        super.v();
        al = System.currentTimeMillis();
    }

    public void w()
    {
        c();
        super.w();
    }

}
