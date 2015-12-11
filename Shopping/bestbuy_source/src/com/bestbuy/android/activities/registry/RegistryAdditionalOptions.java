// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import cg;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cy;
import fr;
import iy;
import iz;
import java.util.HashMap;
import java.util.List;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingRegistrySettings, RegistryFragmentContainer, CreateWeddingRegistry, WishListWithProductsFragment, 
//            EmptyWeddingRegistryContainer

public class RegistryAdditionalOptions extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private EditText a;
    private EditText b;
    private EditText c;
    private EditText g;
    private Spinner h;
    private WeddingRegistryData i;
    private View j;
    private boolean k;
    private Fragment l;
    private boolean m;
    private RelativeLayout n;
    private RelativeLayout o;
    private String p;
    private RegistryWishList q;

    public RegistryAdditionalOptions()
    {
        k = false;
        m = false;
    }

    public RegistryAdditionalOptions(String s)
    {
        k = false;
        m = false;
        p = s;
    }

    public static boolean a(RegistryAdditionalOptions registryadditionaloptions, boolean flag)
    {
        registryadditionaloptions.m = flag;
        return flag;
    }

    private void b()
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        InputMethodManager inputmethodmanager = (InputMethodManager)d.getSystemService("input_method");
        if (d.getCurrentFocus() != null && d.getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(d.getCurrentFocus().getWindowToken(), 0);
        }
        s1 = a.getText().toString();
        s2 = b.getText().toString();
        s3 = c.getText().toString();
        s4 = g.getText().toString();
        s = h.getSelectedItem().toString();
        if (s.length() <= 0 || !s.equals("Select a state")) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        if (i != null)
        {
            i.registryName = s1;
            i.addDescription = s2;
            i.eventLocation = s3;
            i.eventCity = s4;
            i.eventState = ((String) (obj));
        }
        if (p == null || p.isEmpty())
        {
            obj = new HashMap();
            ((HashMap) (obj)).put("bb.createList", "1");
            lu.b(lu.az, ((HashMap) (obj)));
        }
        (new iz(d, this, j, i)).executeOnExecutor(nb.g, new Void[0]);
        return;
_L2:
        obj = s;
        if (s.length() > 0)
        {
            obj = s.substring(0, 2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void c()
    {
        String s = a.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("editRegistryName", s);
        i.setRegistryName(s);
        ((WeddingRegistrySettings)l).a(bundle, i, false, 0);
        ((HomeActivity)d).onBackPressed();
    }

    public void a(RegistryWishList registrywishlist)
    {
        q = registrywishlist;
        if (p != null && !p.isEmpty())
        {
            (new iy((HomeActivity)d, this, null, registrywishlist.getUuid(), p, registrywishlist.getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
            return;
        } else
        {
            b(false);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            b(flag);
        }
    }

    public void b(boolean flag)
    {
        FragmentManager fragmentmanager = ((HomeActivity)d).getSupportFragmentManager();
        fr.a(String.valueOf(true));
        fr.b(q.getShortDescription());
        ((HomeActivity)d).buildSideMenu();
        ((HomeActivity)d).refreshHomeCard();
        BaseFragmentContainer basefragmentcontainer = (BaseFragmentContainer)getParentFragment();
        List list = basefragmentcontainer.getChildFragmentManager().getFragments();
        int i1 = list.size() - 1;
        while (i1 >= 0) 
        {
            Object obj = (Fragment)list.get(i1);
            if (basefragmentcontainer instanceof RegistryFragmentContainer)
            {
                if (p != null && !p.isEmpty())
                {
                    if (obj instanceof CreateWeddingRegistry)
                    {
                        HomeActivity.inPDPFragment = false;
                        HomeActivity.inLifeEventsFragment = true;
                        if (flag)
                        {
                            obj = new HashMap();
                            ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.f()).append("Create a Registry").toString());
                            ((HashMap) (obj)).put("bb.createList", "1");
                            lu.b(lu.aH, ((HashMap) (obj)));
                        }
                        basefragmentcontainer.a(new WishListWithProductsFragment(flag, this, q, true), true, "WishListWithProductsFragment");
                    } else
                    {
                        ((HomeActivity)d).onBackPressed();
                    }
                } else
                if (!((Fragment) (obj)).getTag().equals("RegistryAndGiftsFragment"))
                {
                    ((HomeActivity)d).onBackPressed();
                } else
                {
                    EmptyWeddingRegistryContainer emptyweddingregistrycontainer = new EmptyWeddingRegistryContainer(false, true);
                    FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
                    fragmenttransaction.add(0x7f0c0033, emptyweddingregistrycontainer, "EmptyWeddingRegistryContainer");
                    fragmenttransaction.addToBackStack(null);
                    fragmenttransaction.commit();
                }
            }
            i1--;
        }
    }

    public void g()
    {
label0:
        {
            if (m)
            {
                if (!k)
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
        d = (FragmentActivity)activity;
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            i = (WeddingRegistryData)bundle.getSerializable("data");
        }
        activity.getWindow().setSoftInputMode(32);
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onClick(View view)
    {
        if (view == n)
        {
            b();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        lu.a(lu.ay);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e2, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        j = layoutinflater.findViewById(0x7f0c0064);
        o = (RelativeLayout)layoutinflater.findViewById(0x7f0c0364);
        a = (EditText)layoutinflater.findViewById(0x7f0c012a);
        b = (EditText)layoutinflater.findViewById(0x7f0c0281);
        c = (EditText)layoutinflater.findViewById(0x7f0c0371);
        g = (EditText)layoutinflater.findViewById(0x7f0c0374);
        h = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        a.addTextChangedListener(new cy(this, a));
        n = (RelativeLayout)layoutinflater.findViewById(0x7f0c0379);
        n.setOnClickListener(this);
        a.setText((new StringBuilder()).append(i.getFirstName()).append(" & ").append(i.getCoregistrantFirstName()).append("'s Wedding Registry").toString());
        a.setHint((new StringBuilder()).append(i.getFirstName()).append(" & ").append(i.getCoregistrantFirstName()).append("'s Wedding Registry").toString());
        o.setOnClickListener(new android.view.View.OnClickListener() {

            final RegistryAdditionalOptions a;

            public void onClick(View view)
            {
            }

            
            {
                a = RegistryAdditionalOptions.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", true);
    }

    public void onResume()
    {
        super.onResume();
        if (k)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f08017e));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(getString(0x7f0800a3));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08014a), true);
            return;
        }
    }
}
