// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import cv;
import di;
import fr;
import java.util.HashMap;
import ju;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishlistAdditionalOptions, WishListFragmentContainer, RegistryFragmentContainer, WishListSettingsFragment

public class WishlistAddressFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private boolean A;
    private boolean B;
    private LinearLayout C;
    private BBYBaseFragment D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private InputFilter I = new InputFilter() {

        final WishlistAddressFragment a;

        public CharSequence filter(CharSequence charsequence, int i1, int j1, Spanned spanned, int k1, int l1)
        {
            if (charsequence != null && WishlistAddressFragment.h(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
            {
                return "";
            } else
            {
                return null;
            }
        }

            
            {
                a = WishlistAddressFragment.this;
                super();
            }
    };
    private EditText a;
    private EditText b;
    private EditText c;
    private EditText g;
    private EditText h;
    private Spinner i;
    private EditText j;
    private EditText k;
    private WishListReqData l;
    private boolean m;
    private cv n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private ImageButton u;
    private BBYTextView v;
    private BBYTextView w;
    private boolean x;
    private boolean y;
    private boolean z;

    public WishlistAddressFragment()
    {
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        F = false;
        G = "()-/*#,.+;NPWpw;><?_$%^&@!";
    }

    public WishlistAddressFragment(WishListReqData wishlistreqdata, BBYBaseFragment bbybasefragment, boolean flag, int i1, String s1)
    {
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        F = false;
        G = "()-/*#,.+;NPWpw;><?_$%^&@!";
        l = wishlistreqdata;
        D = bbybasefragment;
        m = flag;
        E = i1;
        H = s1;
    }

    static BBYTextView a(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.v;
    }

    static boolean a(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.F = flag;
        return flag;
    }

    static Spinner b(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.i;
    }

    public static boolean b(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.B = flag;
        return flag;
    }

    public static boolean c(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.x;
    }

    public static boolean c(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.x = flag;
        return flag;
    }

    public static boolean d(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.y;
    }

    public static boolean d(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.y = flag;
        return flag;
    }

    public static boolean e(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.z;
    }

    public static boolean e(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.z = flag;
        return flag;
    }

    public static boolean f(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.A;
    }

    public static boolean f(WishlistAddressFragment wishlistaddressfragment, boolean flag)
    {
        wishlistaddressfragment.A = flag;
        return flag;
    }

    public static boolean g(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.F;
    }

    static String h(WishlistAddressFragment wishlistaddressfragment)
    {
        return wishlistaddressfragment.G;
    }

    public void b()
    {
        WishlistAdditionalOptions wishlistadditionaloptions = new WishlistAdditionalOptions(l, H);
        android.support.v4.app.Fragment fragment = getParentFragment();
        if (fragment instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(wishlistadditionaloptions, true);
        }
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(wishlistadditionaloptions, true);
        }
    }

    public void c()
    {
        d();
        if (D instanceof WishlistAdditionalOptions)
        {
            e();
            ((WishlistAdditionalOptions)D).a(l, E);
            ((HomeActivity)d).onBackPressed();
            return;
        } else
        {
            e();
            ((WishListSettingsFragment)D).a(l, true, E);
            ((HomeActivity)d).onBackPressed();
            return;
        }
    }

    public void d()
    {
        o = c.getText().toString();
        p = g.getText().toString();
        q = h.getText().toString();
        if (i.getSelectedItem().toString().length() > 0)
        {
            r = i.getSelectedItem().toString().substring(0, 2);
            E = i.getSelectedItemPosition();
        }
        s = j.getText().toString();
        t = k.getText().toString();
        t = t.replaceAll("\\D", "");
    }

    public void e()
    {
        l.setAddressFirstName(fr.e());
        l.setAddressLastName(fr.f());
        l.setAddressLine1(o);
        l.setAddressLine2(p);
        l.setZipCode(q);
        l.setState(r);
        l.setCity(s);
        l.setPhone(t);
    }

    public void g()
    {
        if (B)
        {
            c();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        HomeActivity.inLifeEventsFragment = true;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f08030c));
        ((HomeActivity)activity).setOnLifeEventsTopNavigationListener(this, "Save", true);
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        n = (cv)activity;
        n.onCreateWishListFragmentLaunch();
        if (l != null)
        {
            activity = l.getListType().substring(0, l.getListType().length() - 1);
            lu.a((new StringBuilder()).append(lu.P).append(activity).toString());
        }
    }

    public void onClick(View view)
    {
        if (view != C);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030112, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        C = (LinearLayout)layoutinflater.findViewById(0x7f0c0076);
        w = (BBYTextView)layoutinflater.findViewById(0x7f0c03f1);
        a = (EditText)layoutinflater.findViewById(0x7f0c00a7);
        b = (EditText)layoutinflater.findViewById(0x7f0c00a8);
        c = (EditText)layoutinflater.findViewById(0x7f0c03e8);
        g = (EditText)layoutinflater.findViewById(0x7f0c03e9);
        h = (EditText)layoutinflater.findViewById(0x7f0c03ea);
        i = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        j = (EditText)layoutinflater.findViewById(0x7f0c0374);
        k = (EditText)layoutinflater.findViewById(0x7f0c03eb);
        k.setInputType(3);
        k.setFilters(new InputFilter[] {
            I, new android.text.InputFilter.LengthFilter(14)
        });
        k.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        c.addTextChangedListener(new di(this, c));
        h.addTextChangedListener(new di(this, h));
        j.addTextChangedListener(new di(this, j));
        k.addTextChangedListener(new di(this, k));
        u = (ImageButton)layoutinflater.findViewById(0x7f0c03ec);
        v = (BBYTextView)layoutinflater.findViewById(0x7f0c03ed);
        v.setVisibility(8);
        C.setOnClickListener(this);
        u.setOnClickListener(new android.view.View.OnClickListener() {

            final WishlistAddressFragment a;

            public void onClick(View view)
            {
                if (WishlistAddressFragment.a(a).getVisibility() == 0)
                {
                    WishlistAddressFragment.a(a).setVisibility(8);
                    return;
                } else
                {
                    WishlistAddressFragment.a(a).setVisibility(0);
                    WishlistAddressFragment.a(a).setText(a.getResources().getString(0x7f0801ea));
                    return;
                }
            }

            
            {
                a = WishlistAddressFragment.this;
                super();
            }
        });
        i.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final WishlistAddressFragment a;

            public void onItemSelected(AdapterView adapterview, View view, int j1, long l1)
            {
                if (!WishlistAddressFragment.b(a).getSelectedItem().toString().equals("Select a state"))
                {
                    WishlistAddressFragment.a(a, true);
                    if (WishlistAddressFragment.c(a) && WishlistAddressFragment.d(a) && WishlistAddressFragment.e(a) && WishlistAddressFragment.f(a))
                    {
                        WishlistAddressFragment.b(a, true);
                        return;
                    } else
                    {
                        WishlistAddressFragment.b(a, false);
                        return;
                    }
                } else
                {
                    WishlistAddressFragment.a(a, false);
                    WishlistAddressFragment.b(a, false);
                    return;
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
                WishlistAddressFragment.a(a, false);
            }

            
            {
                a = WishlistAddressFragment.this;
                super();
            }
        });
        if (l == null || !m) goto _L2; else goto _L1
_L1:
        viewgroup = l.getRecepient();
        if (viewgroup == null) goto _L4; else goto _L3
_L3:
        if (viewgroup.getAddressLine1().equals("") || viewgroup.getAddressCity().equals("") || viewgroup.getAddressState().equals("") || viewgroup.getAddressZip().equals("") || viewgroup.getPhoneNumber().equals("")) goto _L6; else goto _L5
_L5:
        int i1;
        w.setText(Html.fromHtml(getResources().getString(0x7f080120)));
        w.setVisibility(8);
        c.setText(viewgroup.getAddressLine1());
        g.setText(viewgroup.getAddressLine2());
        j.setText(viewgroup.getAddressCity());
        h.setText(viewgroup.getAddressZip());
        bundle = viewgroup.getPhoneNumber();
        bundle = (new StringBuilder()).append("(").append(bundle.substring(0, 3)).append(") ").append(bundle.substring(3, 6)).append("-").append(bundle.substring(6, 10)).toString();
        k.setText(bundle);
        viewgroup = (String)ju.a().get(viewgroup.getAddressState());
        bundle = getResources().getStringArray(0x7f0a0000);
        i1 = 0;
_L10:
        if (i1 >= bundle.length) goto _L4; else goto _L7
_L7:
        if (!bundle[i1].equals(viewgroup)) goto _L9; else goto _L8
_L8:
        i.setSelection(i1);
_L4:
        if (fr.e() != null)
        {
            viewgroup = fr.e().toLowerCase();
            viewgroup = (new StringBuilder()).append(viewgroup.substring(0, 1).toUpperCase()).append(viewgroup.substring(1)).toString();
            a.setText(viewgroup);
        }
        if (fr.f() != null)
        {
            viewgroup = fr.f().toLowerCase();
            viewgroup = (new StringBuilder()).append(viewgroup.substring(0, 1).toUpperCase()).append(viewgroup.substring(1)).toString();
            b.setText(viewgroup);
        }
        return layoutinflater;
_L9:
        i1++;
          goto _L10
_L6:
        w.setVisibility(0);
        w.setText(getString(0x7f08018b));
          goto _L4
_L2:
        if (l.getAddressLine1() == null || l.getCity() == null || l.getState() == null || l.getZipCode() == null || l.getPhone() == null)
        {
            break MISSING_BLOCK_LABEL_1010;
        }
        w.setText(Html.fromHtml(getResources().getString(0x7f080120)));
        w.setVisibility(8);
        c.setText(l.getAddressLine1());
        g.setText(l.getAddressLine2());
        j.setText(l.getCity());
        h.setText(l.getZipCode());
        k.setText(l.getPhone());
        viewgroup = (String)ju.a().get(l.getState());
        bundle = getResources().getStringArray(0x7f0a0000);
        i1 = 0;
_L11:
        if (i1 < bundle.length)
        {
label0:
            {
                if (!bundle[i1].equals(viewgroup))
                {
                    break label0;
                }
                i.setSelection(i1);
            }
        }
          goto _L4
        i1++;
          goto _L11
        w.setVisibility(0);
        w.setText(getString(0x7f08018b));
          goto _L4
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }

    public void onDetach()
    {
        super.onDetach();
        if (!m)
        {
            b();
        }
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)getActivity()).changeActionBarSearchVisibility(getActivity(), false);
        if (m)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f08017e));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
        } else
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f08030c));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "Save", true);
        }
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
    }
}
