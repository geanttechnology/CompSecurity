// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.res.Resources;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
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
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.Recipient;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import cu;
import db;
import java.util.HashMap;
import ju;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryPrivacySetting, RegistryFragmentContainer, WeddingRegistrySettings

public class WeddingAddressFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private WeddingRegistryData A;
    private LinearLayout B;
    private BBYTextView C;
    private int D;
    private String E;
    private String F;
    private boolean G;
    private boolean H;
    private String I;
    private InputFilter J = new InputFilter() {

        final WeddingAddressFragment a;

        public CharSequence filter(CharSequence charsequence, int i1, int j1, Spanned spanned, int k1, int l1)
        {
            if (charsequence != null && WeddingAddressFragment.i(a).contains((new StringBuilder()).append("").append(charsequence).toString()))
            {
                return "";
            } else
            {
                return null;
            }
        }

            
            {
                a = WeddingAddressFragment.this;
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
    private BBYTextView l;
    private WeddingRegistryData m;
    private Bundle n;
    private boolean o;
    private cu p;
    private ImageButton q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private Fragment y;
    private RegistryWishList z;

    public WeddingAddressFragment(Fragment fragment, boolean flag, RegistryWishList registrywishlist)
    {
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        G = false;
        H = false;
        I = "()-/*#,.+;NPWpw;><?_$%^&@!";
        y = fragment;
        o = flag;
        z = registrywishlist;
    }

    public WeddingAddressFragment(WeddingRegistryData weddingregistrydata)
    {
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        G = false;
        H = false;
        I = "()-/*#,.+;NPWpw;><?_$%^&@!";
        A = weddingregistrydata;
    }

    public WeddingAddressFragment(WeddingRegistryData weddingregistrydata, String s1)
    {
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        G = false;
        H = false;
        I = "()-/*#,.+;NPWpw;><?_$%^&@!";
        A = weddingregistrydata;
        F = s1;
    }

    static Spinner a(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.i;
    }

    static boolean a(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.G = flag;
        return flag;
    }

    public static boolean b(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.s;
    }

    public static boolean b(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.r = flag;
        return flag;
    }

    public static boolean c(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.t;
    }

    public static boolean c(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.H = flag;
        return flag;
    }

    public static boolean d(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.u;
    }

    public static boolean d(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.s = flag;
        return flag;
    }

    public static boolean e(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.v;
    }

    public static boolean e(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.t = flag;
        return flag;
    }

    public static boolean f(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.x;
    }

    public static boolean f(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.u = flag;
        return flag;
    }

    public static boolean g(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.w;
    }

    public static boolean g(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.v = flag;
        return flag;
    }

    public static boolean h(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.G;
    }

    public static boolean h(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.w = flag;
        return flag;
    }

    static String i(WeddingAddressFragment weddingaddressfragment)
    {
        return weddingaddressfragment.I;
    }

    public static boolean i(WeddingAddressFragment weddingaddressfragment, boolean flag)
    {
        weddingaddressfragment.x = flag;
        return flag;
    }

    public void a(Address address)
    {
        address.getCountryCode();
        address.getCountryName();
    }

    public void b()
    {
        Object obj;
        Object obj1;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        n = new Bundle();
        obj = a.getText().toString();
        s3 = b.getText().toString();
        s4 = c.getText().toString();
        s5 = g.getText().toString();
        s6 = h.getText().toString();
        obj1 = i.getSelectedItem().toString();
        s1 = j.getText().toString();
        s2 = k.getText().toString().replaceAll("\\D", "");
        if (m == null) goto _L2; else goto _L1
_L1:
        m.addressFirstName = ((String) (obj));
        m.addressLastName = s3;
        m.addressLine1 = s4;
        m.addressLine2 = s5;
        m.zipCode = s6;
        if (obj1 == null || !((String) (obj1)).equals("Select") && !((String) (obj1)).equals("Select a state")) goto _L4; else goto _L3
_L3:
        obj = "";
_L6:
        m.state = ((String) (obj));
        m.city = s1;
        m.phone = s2;
_L2:
        D = i.getSelectedItemPosition();
        if (F != null && !F.isEmpty())
        {
            obj = new RegistryPrivacySetting(D, F);
        } else
        {
            obj = new RegistryPrivacySetting(D);
        }
        n.putSerializable("data", m);
        ((RegistryPrivacySetting) (obj)).setArguments(n);
        obj1 = getParentFragment();
        if (obj1 instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)obj1).a(((Fragment) (obj)), true, "RegistryPrivacySetting");
        }
        if (obj1 instanceof HomeTabContainer)
        {
            ((HomeTabContainer)obj1).a(((Fragment) (obj)), true);
        }
        return;
_L4:
        obj = obj1;
        if (obj1 != null)
        {
            obj = ((String) (obj1)).substring(0, ((String) (obj1)).indexOf("-"));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void c()
    {
        String s1;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
label0:
        {
            m = new WeddingRegistryData();
            s4 = a.getText().toString();
            s5 = b.getText().toString();
            s6 = c.getText().toString();
            s7 = g.getText().toString();
            s8 = h.getText().toString();
            String s2 = i.getSelectedItem().toString();
            s1 = s2;
            if (s2 == null)
            {
                break label0;
            }
            if (!s2.equals("Select"))
            {
                s1 = s2;
                if (!s2.equals("Select a state"))
                {
                    break label0;
                }
            }
            s1 = "";
        }
        String s3 = j.getText().toString();
        String s9 = k.getText().toString();
        n = new Bundle();
        n.putString("newFirstName", s4);
        n.putString("newLastName", s5);
        n.putString("newAddressLine1", s6);
        n.putString("newAddressLine2", s7);
        n.putString("newZip", s8);
        n.putString("newState", s1);
        n.putString("newCity", s3);
        n.putString("newPhoneNumber", s9);
        m.setAddressFirstName(s4);
        m.setAddressLastName(s5);
        m.setAddressLine1(s6);
        m.setAddressLine2(s7);
        m.setCity(s3);
        m.setState(s1);
        m.setZipCode(s8);
        m.setPhone(s9);
        m.setPrivacySetting(z.getPrivacySetting());
        m.setTheKnot(z.isTheKnot());
        m.setMyregistry(z.isMyRegistry());
        D = i.getSelectedItemPosition();
        ((WeddingRegistrySettings)y).a(n, m, true, D);
        lu.a(lu.aw);
        ((HomeActivity)d).onBackPressed();
    }

    public void g()
    {
        if (o && H)
        {
            c();
        }
        if (r)
        {
            b();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            m = (WeddingRegistryData)bundle.getSerializable("data");
        }
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f08033c));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        p = (cu)activity;
        p.onCreateRegistryFragmentLaunch();
        lu.a(lu.aw);
    }

    public void onClick(View view)
    {
label0:
        {
            if (view == q)
            {
                if (l.getVisibility() != 0)
                {
                    break label0;
                }
                l.setVisibility(8);
            }
            return;
        }
        l.setVisibility(0);
        l.setText(getResources().getString(0x7f0801ea));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030112, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        B = (LinearLayout)layoutinflater.findViewById(0x7f0c0076);
        C = (BBYTextView)layoutinflater.findViewById(0x7f0c03f1);
        a = (EditText)layoutinflater.findViewById(0x7f0c00a7);
        b = (EditText)layoutinflater.findViewById(0x7f0c00a8);
        c = (EditText)layoutinflater.findViewById(0x7f0c03e8);
        g = (EditText)layoutinflater.findViewById(0x7f0c03e9);
        h = (EditText)layoutinflater.findViewById(0x7f0c03ea);
        i = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        j = (EditText)layoutinflater.findViewById(0x7f0c0374);
        k = (EditText)layoutinflater.findViewById(0x7f0c03eb);
        a.addTextChangedListener(new db(this, a));
        b.addTextChangedListener(new db(this, b));
        c.addTextChangedListener(new db(this, c));
        j.addTextChangedListener(new db(this, j));
        k.addTextChangedListener(new db(this, k));
        k.setInputType(3);
        k.setFilters(new InputFilter[] {
            J, new android.text.InputFilter.LengthFilter(14)
        });
        k.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        h.addTextChangedListener(new db(this, h));
        q = (ImageButton)layoutinflater.findViewById(0x7f0c03ec);
        l = (BBYTextView)layoutinflater.findViewById(0x7f0c03ed);
        q.setOnClickListener(this);
        B.setOnClickListener(new android.view.View.OnClickListener() {

            final WeddingAddressFragment a;

            public void onClick(View view)
            {
            }

            
            {
                a = WeddingAddressFragment.this;
                super();
            }
        });
        i.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final WeddingAddressFragment a;

            public void onItemSelected(AdapterView adapterview, View view, int j1, long l1)
            {
                if (!WeddingAddressFragment.a(a).getSelectedItem().toString().equals("Select a state"))
                {
                    WeddingAddressFragment.a(a, true);
                    if (WeddingAddressFragment.b(a) && WeddingAddressFragment.c(a) && WeddingAddressFragment.d(a) && WeddingAddressFragment.e(a) && WeddingAddressFragment.f(a) && WeddingAddressFragment.g(a) && WeddingAddressFragment.h(a))
                    {
                        WeddingAddressFragment.b(a, true);
                        WeddingAddressFragment.c(a, true);
                        return;
                    } else
                    {
                        WeddingAddressFragment.b(a, false);
                        WeddingAddressFragment.c(a, false);
                        return;
                    }
                } else
                {
                    WeddingAddressFragment.a(a, false);
                    WeddingAddressFragment.b(a, false);
                    WeddingAddressFragment.c(a, false);
                    return;
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
                WeddingAddressFragment.a(a, false);
            }

            
            {
                a = WeddingAddressFragment.this;
                super();
            }
        });
        if (A != null)
        {
            a.setText(A.getFirstName());
            b.setText(A.getLastName());
        }
        if (!o) goto _L2; else goto _L1
_L1:
        int i1;
        Object obj = z.getRecipient();
        C.setVisibility(8);
        bundle = ((Recipient) (obj)).getFirstName();
        String s1 = ((Recipient) (obj)).getLastName();
        String s2 = ((Recipient) (obj)).getAddressLine1();
        String s3 = ((Recipient) (obj)).getAddressLine2();
        String s4 = ((Recipient) (obj)).getAddressCity();
        viewgroup = ((Recipient) (obj)).getAddressState();
        String s5 = ((Recipient) (obj)).getAddressZip();
        obj = ((Recipient) (obj)).getPhoneNumber();
        a.setText(bundle);
        b.setText(s1);
        c.setText(s2);
        g.setText(s3);
        j.setText(s4);
        h.setText(s5);
        k.setText(((CharSequence) (obj)));
        bundle = ju.a();
        if (viewgroup.length() > 0)
        {
            E = (String)bundle.get(viewgroup.substring(0, 2));
        }
        viewgroup = getResources().getStringArray(0x7f0a0000);
        i1 = 0;
_L7:
        if (i1 >= viewgroup.length) goto _L2; else goto _L3
_L3:
        if (!viewgroup[i1].equals(E)) goto _L5; else goto _L4
_L4:
        i.setSelection(i1);
_L2:
        return layoutinflater;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
    }

    public void onResume()
    {
        super.onResume();
        if (o)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f08017e));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(getString(0x7f08033c));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
            return;
        }
    }
}
