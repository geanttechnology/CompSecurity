// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryAdditionalOptions, RegistryFragmentContainer, WeddingRegistrySettings

public class RegistryPrivacySetting extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private Fragment a;
    private boolean b;
    private RegistryWishList c;
    private BBYButton g;
    private BBYButton h;
    private Switch i;
    private Switch j;
    private WeddingRegistryData k;
    private boolean l;
    private boolean m;
    private String n;
    private Bundle o;
    private RelativeLayout p;
    private boolean q;
    private BBYTextView r;
    private BBYTextView s;
    private ImageView t;
    private ImageView u;
    private int v;
    private String w;

    public RegistryPrivacySetting(int i1)
    {
        q = true;
        v = i1;
    }

    public RegistryPrivacySetting(int i1, String s1)
    {
        q = true;
        v = i1;
        w = s1;
    }

    public RegistryPrivacySetting(Fragment fragment, boolean flag, RegistryWishList registrywishlist)
    {
        q = true;
        a = fragment;
        b = flag;
        c = registrywishlist;
    }

    static Switch a(RegistryPrivacySetting registryprivacysetting)
    {
        return registryprivacysetting.i;
    }

    static String a(RegistryPrivacySetting registryprivacysetting, String s1)
    {
        registryprivacysetting.n = s1;
        return s1;
    }

    static boolean a(RegistryPrivacySetting registryprivacysetting, boolean flag)
    {
        registryprivacysetting.l = flag;
        return flag;
    }

    static BBYTextView b(RegistryPrivacySetting registryprivacysetting)
    {
        return registryprivacysetting.r;
    }

    static boolean b(RegistryPrivacySetting registryprivacysetting, boolean flag)
    {
        registryprivacysetting.m = flag;
        return flag;
    }

    static Switch c(RegistryPrivacySetting registryprivacysetting)
    {
        return registryprivacysetting.j;
    }

    static boolean c(RegistryPrivacySetting registryprivacysetting, boolean flag)
    {
        registryprivacysetting.q = flag;
        return flag;
    }

    static BBYTextView d(RegistryPrivacySetting registryprivacysetting)
    {
        return registryprivacysetting.s;
    }

    public void b()
    {
        o = new Bundle();
        if (k != null)
        {
            k.setPrivacySetting(n);
            k.setTheKnot(l);
            k.setMyregistry(m);
        }
        RegistryAdditionalOptions registryadditionaloptions;
        Fragment fragment;
        if (w != null && !w.isEmpty())
        {
            registryadditionaloptions = new RegistryAdditionalOptions(w);
        } else
        {
            registryadditionaloptions = new RegistryAdditionalOptions();
        }
        o.putSerializable("data", k);
        registryadditionaloptions.setArguments(o);
        fragment = getParentFragment();
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(registryadditionaloptions, true, "RegistryAdditionalOptions");
        }
        if (fragment instanceof HomeTabContainer)
        {
            ((HomeTabContainer)fragment).a(registryadditionaloptions, true);
        }
    }

    public void c()
    {
        k = new WeddingRegistryData();
        o = new Bundle();
        if (q)
        {
            n = "public";
        } else
        {
            n = "private";
        }
        k.setPrivacySetting(n);
        k.setTheKnot(l);
        k.setMyregistry(m);
        o.putString("newPrivacySetting", n);
        o.putBoolean("newIsKnot", l);
        o.putBoolean("newMyRegistry", m);
        ((WeddingRegistrySettings)a).a(o, k, false, 0);
        ((HomeActivity)d).onBackPressed();
    }

    public void d()
    {
        g.setBackgroundResource(0x7f02011e);
        g.setTextColor(getResources().getColor(0x7f0b0063));
        h.setBackgroundResource(0x7f0200ad);
        h.setTextColor(getResources().getColor(0x7f0b0000));
    }

    public void e()
    {
        h.setBackgroundResource(0x7f02011e);
        h.setTextColor(getResources().getColor(0x7f0b0063));
        g.setBackgroundResource(0x7f0200ad);
        g.setTextColor(getResources().getColor(0x7f0b0000));
    }

    public void f()
    {
        i.setChecked(true);
        i.setClickable(true);
        j.setChecked(true);
        j.setClickable(true);
        r.setTextColor(d.getResources().getColor(0x7f0b0047));
        s.setTextColor(d.getResources().getColor(0x7f0b0047));
        i.setTextColor(d.getResources().getColor(0x7f0b0047));
        j.setTextColor(d.getResources().getColor(0x7f0b0047));
    }

    public void g()
    {
        if (b)
        {
            c();
            return;
        } else
        {
            b();
            return;
        }
    }

    public void h()
    {
        i.setChecked(false);
        j.setChecked(false);
        i.setClickable(false);
        j.setClickable(false);
        r.setTextColor(d.getResources().getColor(0x7f0b0022));
        s.setTextColor(d.getResources().getColor(0x7f0b0022));
        i.setTextColor(d.getResources().getColor(0x7f0b0022));
        j.setTextColor(d.getResources().getColor(0x7f0b0022));
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            k = (WeddingRegistryData)bundle.getSerializable("data");
        }
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f08033d));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        lu.a(lu.ax);
    }

    public void onClick(View view)
    {
        if (view == t)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(d);
            builder.setMessage(Html.fromHtml(d.getResources().getString(0x7f0801d2))).setCancelable(true);
            builder.create().show();
        }
        if (view == u)
        {
            view = new android.app.AlertDialog.Builder(d);
            view.setMessage(Html.fromHtml(d.getResources().getString(0x7f080381))).setCancelable(true);
            view.create().show();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e3, viewgroup, false);
        p = (RelativeLayout)layoutinflater.findViewById(0x7f0c0076);
        g = (BBYButton)layoutinflater.findViewById(0x7f0c037d);
        h = (BBYButton)layoutinflater.findViewById(0x7f0c037e);
        i = (Switch)layoutinflater.findViewById(0x7f0c0381);
        j = (Switch)layoutinflater.findViewById(0x7f0c0383);
        r = (BBYTextView)layoutinflater.findViewById(0x7f0c0380);
        s = (BBYTextView)layoutinflater.findViewById(0x7f0c0382);
        t = (ImageView)layoutinflater.findViewById(0x7f0c037c);
        u = (ImageView)layoutinflater.findViewById(0x7f0c037f);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        if (q)
        {
            n = "public";
            d();
        } else
        {
            n = "private";
            e();
        }
        l = true;
        m = true;
        i.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final RegistryPrivacySetting a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    RegistryPrivacySetting.a(a).setText("Yes");
                    RegistryPrivacySetting.a(a, true);
                    RegistryPrivacySetting.a(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
                    RegistryPrivacySetting.b(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
                    return;
                } else
                {
                    RegistryPrivacySetting.a(a).setText("No");
                    RegistryPrivacySetting.a(a, false);
                    RegistryPrivacySetting.a(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
                    RegistryPrivacySetting.b(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
                    return;
                }
            }

            
            {
                a = RegistryPrivacySetting.this;
                super();
            }
        });
        j.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final RegistryPrivacySetting a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    RegistryPrivacySetting.c(a).setText("Yes");
                    RegistryPrivacySetting.b(a, true);
                    RegistryPrivacySetting.c(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
                    RegistryPrivacySetting.d(a).setTextColor(a.d.getResources().getColor(0x7f0b0047));
                    return;
                } else
                {
                    RegistryPrivacySetting.c(a).setText("No");
                    RegistryPrivacySetting.b(a, false);
                    RegistryPrivacySetting.c(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
                    RegistryPrivacySetting.d(a).setTextColor(a.d.getResources().getColor(0x7f0b0022));
                    return;
                }
            }

            
            {
                a = RegistryPrivacySetting.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final RegistryPrivacySetting a;

            public void onClick(View view)
            {
                RegistryPrivacySetting.a(a, "public");
                RegistryPrivacySetting.c(a, true);
                a.d();
                a.f();
                RegistryPrivacySetting.b(a, true);
                RegistryPrivacySetting.a(a, true);
            }

            
            {
                a = RegistryPrivacySetting.this;
                super();
            }
        });
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final RegistryPrivacySetting a;

            public void onClick(View view)
            {
                RegistryPrivacySetting.a(a, "private");
                RegistryPrivacySetting.c(a, false);
                a.e();
                a.h();
                RegistryPrivacySetting.b(a, false);
                RegistryPrivacySetting.a(a, false);
            }

            
            {
                a = RegistryPrivacySetting.this;
                super();
            }
        });
        if (b && c != null)
        {
            if (c.getPrivacySetting().equals("public"))
            {
                q = true;
                d();
                f();
            } else
            if (c.getPrivacySetting().equals("private"))
            {
                q = false;
                e();
                h();
            }
            if (c.isTheKnot())
            {
                i.setChecked(true);
                i.setText("Yes");
            } else
            {
                i.setChecked(false);
                i.setText("No");
            }
            if (c.isMyRegistry())
            {
                j.setChecked(true);
                j.setText("Yes");
            } else
            {
                j.setChecked(false);
                j.setText("No");
            }
        }
        p.setOnClickListener(new android.view.View.OnClickListener() {

            final RegistryPrivacySetting a;

            public void onClick(View view)
            {
            }

            
            {
                a = RegistryPrivacySetting.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (b)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("");
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(getString(0x7f08033d));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
            return;
        }
    }
}
