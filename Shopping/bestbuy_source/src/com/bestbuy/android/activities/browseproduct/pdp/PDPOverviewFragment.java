// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bestbuy.android.api.lib.models.pdp.Feature;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.Specification;
import com.bestbuy.android.api.lib.models.pdp.SubSection;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Descriptions;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;
import ek;
import ib;
import ic;
import ie;
import if;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPOverviewDetailListFragment, PDPFragment, PDPFragmentContainer

public class PDPOverviewFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private static final String a = com/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment.getSimpleName();
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private OverviewResponse b;
    private View c;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private BBYTextView t;
    private LinearLayout u;
    private PDPOverviewDetailListFragment v;
    private ArrayList w;
    private boolean x;
    private boolean y;
    private boolean z;

    public PDPOverviewFragment()
    {
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
    }

    public PDPOverviewFragment(OverviewResponse overviewresponse)
    {
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        b = overviewresponse;
        overviewresponse = new Bundle();
        overviewresponse.putSerializable("product", b);
        setArguments(overviewresponse);
    }

    private void a(int i1)
    {
        Object obj = getResources();
        int j1 = w.size();
        obj = ((Resources) (obj)).getString(i1);
        i1 = 0;
        do
        {
label0:
            {
                if (i1 < j1)
                {
                    if (!((String)w.get(i1)).equals(obj))
                    {
                        break label0;
                    }
                    v = new PDPOverviewDetailListFragment(i1, b, w);
                }
                return;
            }
            i1++;
        } while (true);
    }

    private void g()
    {
        List list = b.getFeatures();
        LinearLayout linearlayout = (LinearLayout)j.findViewById(0x7f0c0268);
        BBYTextView bbytextview = (BBYTextView)linearlayout.findViewById(0x7f0c0269);
        BBYTextView bbytextview1 = (BBYTextView)linearlayout.findViewById(0x7f0c026a);
        BBYTextView bbytextview2 = (BBYTextView)linearlayout.findViewById(0x7f0c026b);
        BBYTextView bbytextview3 = (BBYTextView)linearlayout.findViewById(0x7f0c026c);
        int i1 = 0;
        do
        {
            if (i1 >= list.size())
            {
                break;
            }
            Object obj = (Feature)list.get(i1);
            if (obj != null && ((Feature) (obj)).getTitle() != null && ((Feature) (obj)).getTitle().length() > 0)
            {
                obj = ((Feature) (obj)).getTitle();
            } else
            {
                obj = ((Feature) (obj)).getDescription();
            }
            obj = Html.fromHtml(((String) (obj))).toString();
            if (i1 == 0)
            {
                bbytextview.setText((new StringBuilder()).append("\u2022 ").append(((String) (obj))).toString());
            } else
            if (i1 == 1)
            {
                bbytextview1.setText((new StringBuilder()).append("\u2022 ").append(((String) (obj))).toString());
                bbytextview1.setVisibility(0);
            } else
            if (i1 == 2)
            {
                bbytextview2.setText((new StringBuilder()).append("\u2022 ").append(((String) (obj))).toString());
                bbytextview2.setVisibility(0);
            } else
            if (i1 == 3)
            {
                bbytextview3.setText((new StringBuilder()).append("\u2022 ").append(((String) (obj))).toString());
                bbytextview3.setVisibility(0);
            }
            i1++;
        } while (i1 != 4);
    }

    private void h()
    {
        if (b.getSpecialFeatures() != null && b.getSpecialFeatures().size() > 0)
        {
            E = true;
            ((BBYTextView)u.findViewById(0x7f0c025b)).setText(getResources().getString(0x7f08032e));
            w.add(getResources().getString(0x7f08032e));
            u.setVisibility(0);
        }
    }

    private void i()
    {
        if (b.getBonusContent() != null && b.getBonusContent().size() > 0)
        {
            ((BBYTextView)g.findViewById(0x7f0c025d)).setText(getResources().getString(0x7f0801b0));
            w.add(getResources().getString(0x7f0801b0));
            g.setVisibility(0);
            x = true;
        }
    }

    private void j()
    {
        if (b != null)
        {
            Descriptions descriptions = b.getDescriptions();
            if (descriptions != null)
            {
                String s1 = descriptions.getLongDesc();
                String s2 = descriptions.getShortDesc();
                Resources resources = getResources();
                if (s1 != null && s1.length() > 0 || s2 != null && s2.length() > 0)
                {
                    ((BBYTextView)h.findViewById(0x7f0c025f)).setText(resources.getString(0x7f0802b8));
                    if (s1 == null || s1.length() <= 0)
                    {
                        s1 = s2;
                    }
                    s1 = Html.fromHtml(s1).toString().replaceAll("[\\r\\n]+\\s", "").replaceAll("[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|'?/<,>/\"\\+]", "");
                    ((BBYTextView)h.findViewById(0x7f0c0260)).setText(s1);
                    w.add(resources.getString(0x7f0802b8));
                    h.setVisibility(0);
                    z = true;
                }
                s1 = descriptions.getSynopsis();
                if (s1 != null && s1.length() > 0)
                {
                    ((BBYTextView)i.findViewById(0x7f0c0262)).setText(resources.getString(0x7f0802bf));
                    s1 = Html.fromHtml(s1).toString().replaceAll("[\\r\\n]+\\s", "").replaceAll("[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|'?/<,>/\"\\+]", "");
                    ((BBYTextView)i.findViewById(0x7f0c0264)).setText(s1);
                    w.add(resources.getString(0x7f0802bf));
                    i.setVisibility(0);
                    y = true;
                }
            }
        }
    }

    private void k()
    {
        if (b.getFeatures() != null)
        {
            Resources resources = getResources();
            ((BBYTextView)j.findViewById(0x7f0c0266)).setText(resources.getString(0x7f0802b9));
            w.add(resources.getString(0x7f0802b9));
            g();
            j.setVisibility(0);
            B = true;
        }
    }

    private void m()
    {
        List list = b.getIncludedItems();
        if (list != null && list.size() > 0)
        {
            Resources resources = getResources();
            BBYTextView bbytextview = (BBYTextView)k.findViewById(0x7f0c026e);
            w.add(resources.getString(0x7f0802ba));
            bbytextview.setText(resources.getString(0x7f0802ba));
            k.setVisibility(0);
            A = true;
        }
    }

    private void n()
    {
        List list = b.getSpecifications();
        if (list != null && list.size() > 0 && ((Specification)list.get(0)).getDisplayName().length() > 0)
        {
            Resources resources = getResources();
            ((BBYTextView)l.findViewById(0x7f0c0270)).setText(resources.getString(0x7f0802be));
            w.add(resources.getString(0x7f0802be));
            l.setVisibility(0);
            C = true;
        }
    }

    private void o()
    {
        D = true;
        Resources resources = getResources();
        Iterator iterator = b.getSubSections().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = ((SubSection)iterator.next()).getId();
            if (s1.startsWith("movieDetails") || s1.startsWith("movie") || s1.startsWith("Movie") || s1.startsWith("MOVIE"))
            {
                (new ie(d, this, b, b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                ((BBYTextView)n.findViewById(0x7f0c0276)).setText(resources.getString(0x7f08023b));
            }
            if (s1.startsWith("episodes") || s1.startsWith("episode"))
            {
                (new ic(d, this, b, b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                ((BBYTextView)o.findViewById(0x7f0c0278)).setText(resources.getString(0x7f08018f));
            }
            if (s1.startsWith("castAndCrew") || s1.startsWith("cast") || s1.startsWith("Cast") || s1.startsWith("CAST"))
            {
                (new ib(d, this, b, b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                ((BBYTextView)p.findViewById(0x7f0c0274)).setText(resources.getString(0x7f0800ee));
            }
            if (s1.startsWith("musicDetails") || s1.startsWith("music") || s1.startsWith("Music") || s1.startsWith("MUSIC"))
            {
                (new if(d, this, b, b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                ((BBYTextView)q.findViewById(0x7f0c027a)).setText(resources.getString(0x7f080241));
                List list = b.getTrackInfo();
                if (list != null && list.size() > 0)
                {
                    ((BBYTextView)r.findViewById(0x7f0c027e)).setText(resources.getString(0x7f08032a));
                    r.setVisibility(0);
                    w.add(resources.getString(0x7f08032a));
                }
            }
            if (s1.startsWith("softwareDetails") || s1.startsWith("software") || s1.startsWith("Software") || s1.startsWith("SOFTWARE"))
            {
                t.setText(resources.getString(0x7f080327));
                s.setVisibility(0);
                w.add(resources.getString(0x7f080327));
            }
            if (s1.startsWith("gameDetails") || s1.startsWith("game") || s1.startsWith("Game") || s1.startsWith("GAME"))
            {
                t.setText(resources.getString(0x7f0801b3));
                s.setVisibility(0);
                w.add(resources.getString(0x7f0801b3));
            }
        } while (true);
    }

    public void b()
    {
        FragmentTransaction fragmenttransaction = getParentFragment().getChildFragmentManager().beginTransaction();
        fragmenttransaction.remove(this);
        fragmenttransaction.commitAllowingStateLoss();
    }

    public void c()
    {
        p.setVisibility(0);
        w.add(getResources().getString(0x7f0800ee));
        if (v != null)
        {
            v.b().notifyDataSetChanged();
        }
    }

    public void d()
    {
        n.setVisibility(0);
        w.add(getResources().getString(0x7f08023b));
        if (v != null)
        {
            v.b().notifyDataSetChanged();
        }
    }

    public void e()
    {
        o.setVisibility(0);
        w.add(getResources().getString(0x7f08018f));
        if (v != null)
        {
            v.b().notifyDataSetChanged();
        }
    }

    public void f()
    {
        q.setVisibility(0);
        w.add(getResources().getString(0x7f080241));
        if (v != null)
        {
            v.b().notifyDataSetChanged();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        w = new ArrayList();
        if (b != null)
        {
            h();
            j();
            i();
            k();
            m();
            n();
            o();
        }
        if (!y && !z && !A && !B && !B && !C && !D && !x && !E)
        {
            b();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        int i1 = view.getId();
        if (i1 != h.getId()) goto _L2; else goto _L1
_L1:
        a(0x7f0802b8);
_L4:
        if (v != null && (getParentFragment() instanceof PDPFragment))
        {
            view = ((PDPFragment)getParentFragment()).getParentFragment();
            if (view instanceof PDPFragmentContainer)
            {
                ((PDPFragmentContainer)view).a(v, true);
            }
        }
        return;
_L2:
        if (i1 == i.getId())
        {
            a(0x7f0802bf);
        } else
        if (i1 == u.getId())
        {
            a(0x7f08032e);
        } else
        if (i1 == j.getId())
        {
            a(0x7f0802b9);
        } else
        if (i1 == k.getId())
        {
            a(0x7f0802ba);
        } else
        if (i1 == l.getId())
        {
            a(0x7f0802be);
        } else
        if (i1 == m.getId())
        {
            a(0x7f0802bd);
        } else
        if (i1 == n.getId())
        {
            a(0x7f08023b);
        } else
        if (i1 == o.getId())
        {
            a(0x7f08018f);
        } else
        if (i1 == p.getId())
        {
            a(0x7f0800ee);
        } else
        if (i1 == q.getId())
        {
            a(0x7f080241);
        } else
        if (i1 == r.getId())
        {
            a(0x7f08032a);
        } else
        if (i1 == s.getId())
        {
            view = getResources();
            if (t.getText().toString().equalsIgnoreCase(view.getString(0x7f080327)))
            {
                a(0x7f080327);
            } else
            {
                a(0x7f0801b3);
            }
        } else
        if (i1 == g.getId())
        {
            a(0x7f0801b0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (b == null)
        {
            b = (OverviewResponse)getArguments().getSerializable("product");
        }
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f0300a7, viewgroup, false);
            g = (LinearLayout)c.findViewById(0x7f0c025c);
            h = (LinearLayout)c.findViewById(0x7f0c025e);
            j = (LinearLayout)c.findViewById(0x7f0c0265);
            k = (LinearLayout)c.findViewById(0x7f0c026d);
            l = (LinearLayout)c.findViewById(0x7f0c026f);
            m = (LinearLayout)c.findViewById(0x7f0c0271);
            n = (LinearLayout)c.findViewById(0x7f0c0275);
            o = (LinearLayout)c.findViewById(0x7f0c0277);
            p = (LinearLayout)c.findViewById(0x7f0c0273);
            q = (LinearLayout)c.findViewById(0x7f0c0279);
            r = (LinearLayout)c.findViewById(0x7f0c027d);
            s = (LinearLayout)c.findViewById(0x7f0c027b);
            t = (BBYTextView)s.findViewById(0x7f0c027c);
            u = (LinearLayout)c.findViewById(0x7f0c025a);
            i = (LinearLayout)c.findViewById(0x7f0c0261);
            g.setOnClickListener(this);
            h.setOnClickListener(this);
            j.setOnClickListener(this);
            k.setOnClickListener(this);
            l.setOnClickListener(this);
            m.setOnClickListener(this);
            n.setOnClickListener(this);
            o.setOnClickListener(this);
            p.setOnClickListener(this);
            q.setOnClickListener(this);
            r.setOnClickListener(this);
            s.setOnClickListener(this);
            u.setOnClickListener(this);
            i.setOnClickListener(this);
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }

}
