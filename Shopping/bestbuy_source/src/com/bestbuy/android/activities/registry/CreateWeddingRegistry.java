// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cr;
import cu;
import fr;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingDateFragment, WeddingRegistrySettings

public class CreateWeddingRegistry extends BBYBaseFragment
    implements cg
{

    private FragmentActivity a;
    private EditText b;
    private EditText c;
    private EditText g;
    private EditText h;
    private cu i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private Fragment o;
    private boolean p;
    private RegistryWishList q;
    private Bundle r;
    private WeddingRegistryData s;
    private String t;

    public CreateWeddingRegistry()
    {
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
    }

    public CreateWeddingRegistry(Fragment fragment, boolean flag, RegistryWishList registrywishlist)
    {
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        o = fragment;
        p = flag;
        q = registrywishlist;
    }

    public CreateWeddingRegistry(String s1)
    {
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        t = s1;
    }

    public static boolean a(CreateWeddingRegistry createweddingregistry)
    {
        return createweddingregistry.k;
    }

    public static boolean a(CreateWeddingRegistry createweddingregistry, boolean flag)
    {
        createweddingregistry.k = flag;
        return flag;
    }

    private void b()
    {
        Object obj1 = new Bundle();
        Object obj = b.getText().toString();
        String s1 = c.getText().toString();
        String s2 = g.getText().toString();
        String s3 = h.getText().toString();
        s = new WeddingRegistryData();
        s.firstName = ((String) (obj));
        s.lastName = s1;
        s.coregistrantFirstName = s2;
        s.coregistrantLastName = s3;
        s.createdBy = fr.c();
        s.lastModifiedBy = fr.c();
        if (t != null && !t.isEmpty())
        {
            obj = new WeddingDateFragment(t);
        } else
        {
            obj = new WeddingDateFragment();
        }
        ((Bundle) (obj1)).putSerializable("data", s);
        ((WeddingDateFragment) (obj)).setArguments(((Bundle) (obj1)));
        obj1 = getParentFragment();
        if (obj1 instanceof BaseFragmentContainer)
        {
            ((BaseFragmentContainer)obj1).a(((Fragment) (obj)), true, "WeddingDateFragment");
        }
        if (obj1 instanceof HomeTabContainer)
        {
            ((HomeTabContainer)obj1).a(((Fragment) (obj)), true);
        }
    }

    public static boolean b(CreateWeddingRegistry createweddingregistry)
    {
        return createweddingregistry.l;
    }

    public static boolean b(CreateWeddingRegistry createweddingregistry, boolean flag)
    {
        createweddingregistry.l = flag;
        return flag;
    }

    private void c()
    {
        String s1 = b.getText().toString();
        String s2 = c.getText().toString();
        String s3 = g.getText().toString();
        String s4 = h.getText().toString();
        r = new Bundle();
        r.putString("firstName", s1);
        r.putString("lastName", s2);
        r.putString("coRegFirstName", s3);
        r.putString("coRegLastName", s4);
        s = new WeddingRegistryData();
        s.setFirstName(s1);
        s.setLastName(s2);
        s.setCoregistrantFirstName(s3);
        s.setCoregistrantLastName(s4);
        s.setPrivacySetting(q.getPrivacySetting());
        s.setTheKnot(q.isTheKnot());
        s.setMyregistry(q.isMyRegistry());
        ((WeddingRegistrySettings)o).a(r, s, false, 0);
        ((HomeActivity)a).onBackPressed();
    }

    public static boolean c(CreateWeddingRegistry createweddingregistry)
    {
        return createweddingregistry.m;
    }

    public static boolean c(CreateWeddingRegistry createweddingregistry, boolean flag)
    {
        createweddingregistry.m = flag;
        return flag;
    }

    public static boolean d(CreateWeddingRegistry createweddingregistry)
    {
        return createweddingregistry.n;
    }

    public static boolean d(CreateWeddingRegistry createweddingregistry, boolean flag)
    {
        createweddingregistry.n = flag;
        return flag;
    }

    public static boolean e(CreateWeddingRegistry createweddingregistry, boolean flag)
    {
        createweddingregistry.j = flag;
        return flag;
    }

    public void g()
    {
label0:
        {
            if (j)
            {
                if (!p)
                {
                    break label0;
                }
                c();
            }
            return;
        }
        b();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = (FragmentActivity)activity;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f080338));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        i = (cu)activity;
        i.onCreateRegistryFragmentLaunch();
        lu.a(lu.au);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = layoutinflater.inflate(0x7f030026, viewgroup, false);
        a.getWindow().setSoftInputMode(16);
        b = (EditText)bundle.findViewById(0x7f0c00a7);
        c = (EditText)bundle.findViewById(0x7f0c00a8);
        g = (EditText)bundle.findViewById(0x7f0c00a9);
        String s1;
        if (p)
        {
            b.requestFocus();
        } else
        {
            g.requestFocus();
        }
        ((InputMethodManager)getActivity().getSystemService("input_method")).toggleSoftInput(1, 0);
        h = (EditText)bundle.findViewById(0x7f0c00aa);
        b.addTextChangedListener(new cr(this, b));
        c.addTextChangedListener(new cr(this, c));
        b.setKeyListener(null);
        c.setKeyListener(null);
        g.addTextChangedListener(new cr(this, g));
        h.addTextChangedListener(new cr(this, h));
        viewgroup = fr.e();
        s1 = fr.f();
        layoutinflater = viewgroup;
        if (viewgroup != null)
        {
            layoutinflater = viewgroup;
            if (!viewgroup.isEmpty())
            {
                layoutinflater = viewgroup.toLowerCase();
                layoutinflater = (new StringBuilder()).append(Character.toString(layoutinflater.charAt(0)).toUpperCase()).append(layoutinflater.substring(1)).toString();
                b.setText(layoutinflater);
            }
        }
        if (s1 != null && !s1.isEmpty())
        {
            layoutinflater = s1.toLowerCase();
            layoutinflater = (new StringBuilder()).append(Character.toString(layoutinflater.charAt(0)).toUpperCase()).append(layoutinflater.substring(1)).toString();
            c.setText(layoutinflater);
        } else
        {
            b.setText(layoutinflater);
            c.setText(s1);
        }
        if (q != null)
        {
            layoutinflater = q.getFirstName();
            if (layoutinflater != null && !layoutinflater.isEmpty())
            {
                layoutinflater = layoutinflater.toLowerCase();
                layoutinflater = (new StringBuilder()).append(Character.toString(layoutinflater.charAt(0)).toUpperCase()).append(layoutinflater.substring(1)).toString();
                b.setText(layoutinflater);
            }
            layoutinflater = q.getLastName();
            if (layoutinflater != null && !layoutinflater.isEmpty())
            {
                layoutinflater = layoutinflater.toLowerCase();
                layoutinflater = (new StringBuilder()).append(Character.toString(layoutinflater.charAt(0)).toUpperCase()).append(layoutinflater.substring(1)).toString();
                c.setText(layoutinflater);
            }
            viewgroup = q.getCoRegistrantFirstName();
            layoutinflater = q.getCoRegistrantLastName();
            if (viewgroup != null && !viewgroup.isEmpty())
            {
                viewgroup = viewgroup.toLowerCase();
                viewgroup = (new StringBuilder()).append(Character.toString(viewgroup.charAt(0)).toUpperCase()).append(viewgroup.substring(1)).toString();
                g.setText(viewgroup);
            }
            if (layoutinflater != null && !layoutinflater.isEmpty())
            {
                layoutinflater = layoutinflater.toLowerCase();
                layoutinflater = (new StringBuilder()).append(Character.toString(layoutinflater.charAt(0)).toUpperCase()).append(layoutinflater.substring(1)).toString();
                h.setText(layoutinflater);
            }
        }
        return bundle;
    }

    public void onDestroy()
    {
        super.onDestroy();
        a.getWindow().setSoftInputMode(32);
        ((HomeActivity)a).setOnLifeEventsTopNavigationListener(this, "", true);
    }

    public void onResume()
    {
        super.onResume();
        if (p)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("");
            ((HomeActivity)a).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)a).updateActionBarTitle(getString(0x7f080338));
            ((HomeActivity)a).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
            return;
        }
    }
}
