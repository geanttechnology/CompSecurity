// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import java.util.ArrayList;
import java.util.HashMap;
import jo;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            CreateWeddingRegistry, RegistryFragmentContainer, CreateWishListFragment, RegistrySearchResults, 
//            ListIdSearchFragment, LEBannerHomeCard, EmptyWeddingRegistryContainer

public class RegistryAndGiftsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private LinearLayout a;
    private LinearLayout b;
    private ImageButton c;
    private ImageButton g;
    private Button h;
    private Button i;
    private LinearLayout j;
    private EditText k;
    private EditText l;
    private EditText m;
    private String n;
    private boolean o;
    private ArrayList p;

    public RegistryAndGiftsFragment()
    {
        o = false;
        p = new ArrayList();
    }

    private void b()
    {
        h.setSelected(o);
        Button button = i;
        boolean flag;
        if (!o)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setSelected(flag);
        m.setText("");
        n = "";
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            Object obj = new android.app.AlertDialog.Builder(d);
            ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(d.getResources().getString(0x7f08028b))).setCancelable(true).setNegativeButton(Html.fromHtml(d.getResources().getString(0x7f080283)), new android.content.DialogInterface.OnClickListener() {

                final RegistryAndGiftsFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = RegistryAndGiftsFragment.this;
                super();
            }
            }).setPositiveButton(Html.fromHtml(d.getResources().getString(0x7f080242)), new android.content.DialogInterface.OnClickListener() {

                final RegistryAndGiftsFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                    dialoginterface = new EmptyWeddingRegistryContainer(false);
                    FragmentTransaction fragmenttransaction = ((BBYBaseFragmentActivity)a.d).getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.add(0x7f0c0033, dialoginterface, "EmptyWeddingRegistryContainer");
                    fragmenttransaction.addToBackStack(null);
                    fragmenttransaction.commit();
                }

            
            {
                a = RegistryAndGiftsFragment.this;
                super();
            }
            });
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).show();
            ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
        } else
        {
            CreateWeddingRegistry createweddingregistry = new CreateWeddingRegistry();
            android.support.v4.app.Fragment fragment = getParentFragment();
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(createweddingregistry, true, "CreateWeddingRegistry");
                return;
            }
        }
    }

    public void g()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        activity = new HashMap();
        activity.put(lu.bo, "profile,lifeEvents,dashboard");
        activity.put(lu.bp, "LE");
        lu.b(lu.A, activity);
    }

    public void onClick(View view)
    {
        if (view != a) goto _L2; else goto _L1
_L1:
        if (fr.c() == null) goto _L4; else goto _L3
_L3:
        view = new CreateWishListFragment();
        android.support.v4.app.Fragment fragment = getParentFragment();
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(view, true, "CreateWishListFragment");
        }
_L6:
        return;
_L4:
        nb.a().j("WishList");
        view = new Intent(d.getApplicationContext(), com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
        d.startActivityForResult(view, 7890);
        d.overridePendingTransition(0x7f04000e, 0x7f040005);
        return;
_L2:
        if (view == b)
        {
            if (fr.c() != null)
            {
                (new jo(d, this, null, fr.d())).executeOnExecutor(nb.g, new Void[0]);
                return;
            } else
            {
                nb.a().j("Registry");
                view = new Intent(d.getApplicationContext(), com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
                d.startActivityForResult(view, 7890);
                d.overridePendingTransition(0x7f04000e, 0x7f040005);
                return;
            }
        }
        if (view == c)
        {
            ((InputMethodManager)d.getSystemService("input_method")).hideSoftInputFromWindow(c.getWindowToken(), 2);
            view = k.getText().toString();
            Object obj = l.getText().toString();
            if (!view.isEmpty() && !((String) (obj)).isEmpty())
            {
                n = (new StringBuilder()).append(view.trim()).append(" ").append(((String) (obj)).trim()).toString();
            } else
            if (((String) (obj)).isEmpty() && !view.isEmpty())
            {
                n = view.trim();
            } else
            if (view.isEmpty() && !((String) (obj)).isEmpty())
            {
                n = ((String) (obj)).trim();
            }
            if (o)
            {
                nb.a().n(true);
            } else
            {
                nb.a().n(false);
            }
            view = new RegistrySearchResults(n, o, view.trim(), ((String) (obj)).trim());
            obj = getParentFragment();
            if (obj instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)obj).a(view, true);
            }
            if (o)
            {
                view = new HashMap();
                view.put("Search Details", n);
                lu.a(lu.X, view);
                return;
            } else
            {
                view = new HashMap();
                view.put("Search Details", n);
                lu.a(lu.aG, view);
                return;
            }
        }
        if (view == h)
        {
            o = true;
            m.setHint("Search Using List ID");
            b();
            return;
        }
        if (view == i)
        {
            o = false;
            m.setHint("Search Using Registry ID");
            b();
            return;
        }
        if (view == g)
        {
            view = m.getText().toString();
            ((InputMethodManager)d.getSystemService("input_method")).hideSoftInputFromWindow(g.getWindowToken(), 2);
            ListIdSearchFragment listidsearchfragment = new ListIdSearchFragment(o, view);
            android.support.v4.app.Fragment fragment1 = getParentFragment();
            if (fragment1 instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment1).a(listidsearchfragment, true);
            }
            if (o)
            {
                nb.a().n(true);
            } else
            {
                nb.a().n(false);
            }
            if (o)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("Wish List ID", view);
                lu.a(lu.W, hashmap);
                return;
            } else
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("Registry List ID", view);
                lu.a(lu.aF, hashmap1);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e6, viewgroup, false);
        d.getWindow().setSoftInputMode(16);
        k = (EditText)layoutinflater.findViewById(0x7f0c0391);
        l = (EditText)layoutinflater.findViewById(0x7f0c0392);
        m = (EditText)layoutinflater.findViewById(0x7f0c0394);
        a = (LinearLayout)layoutinflater.findViewById(0x7f0c038d);
        a.setOnClickListener(this);
        b = (LinearLayout)layoutinflater.findViewById(0x7f0c038c);
        b.setOnClickListener(this);
        c = (ImageButton)layoutinflater.findViewById(0x7f0c0390);
        c.setOnClickListener(this);
        g = (ImageButton)layoutinflater.findViewById(0x7f0c0395);
        g.setOnClickListener(this);
        h = (Button)layoutinflater.findViewById(0x7f0c038f);
        h.setOnClickListener(this);
        i = (Button)layoutinflater.findViewById(0x7f0c038e);
        i.setOnClickListener(this);
        j = (LinearLayout)layoutinflater.findViewById(0x7f0c038b);
        viewgroup = new LEBannerHomeCard();
        bundle = getChildFragmentManager().beginTransaction();
        bundle.add(0x7f0c038b, viewgroup, "LEBannerHomeCard");
        bundle.commit();
        l = (EditText)layoutinflater.findViewById(0x7f0c0392);
        o = nb.a().aa();
        b();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        nb.a().n(false);
        d.getWindow().setSoftInputMode(32);
    }

    public void onResume()
    {
        super.onResume();
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Registry, Gifts & Lists");
        ((BBYBaseFragmentActivity)d).showActionBarHome();
        ((BBYBaseFragmentActivity)d).changeActionBarSearchVisibility(getActivity(), false);
        if (nb.a().Y() != null && nb.a().Y().equalsIgnoreCase("Registry"))
        {
            nb.a().j("");
            if (fr.c() != null)
            {
                (new jo(d, this, null, fr.d())).executeOnExecutor(nb.g, new Void[0]);
            }
        } else
        if (nb.a().Y() != null && nb.a().Y().equalsIgnoreCase("WishList"))
        {
            nb.a().j("");
            if (fr.c() != null)
            {
                CreateWishListFragment createwishlistfragment = new CreateWishListFragment();
                android.support.v4.app.Fragment fragment = getParentFragment();
                if (fragment instanceof RegistryFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(createwishlistfragment, true, "CreateWishListFragment");
                    return;
                }
            }
        }
    }
}
