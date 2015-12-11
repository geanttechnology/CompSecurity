// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import iy;
import ja;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryFragmentContainer, MyWishListsFragment, WishListWithProductsFragment, WishlistAddressFragment, 
//            WishListFragmentContainer

public class WishlistAdditionalOptions extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private EditText a;
    private EditText b;
    private TextView c;
    private EditText g;
    private EditText h;
    private Spinner i;
    private EditText j;
    private RelativeLayout k;
    private WishListReqData l;
    private Calendar m;
    private android.app.DatePickerDialog.OnDateSetListener n;
    private View o;
    private RelativeLayout p;
    private ImageView q;
    private ImageView r;
    private String s;
    private String t;
    private RegistryWishList u;
    private int v;

    public WishlistAdditionalOptions(WishListReqData wishlistreqdata)
    {
        l = wishlistreqdata;
    }

    public WishlistAdditionalOptions(WishListReqData wishlistreqdata, String s1)
    {
        l = wishlistreqdata;
        s = s1;
    }

    static Calendar a(WishlistAdditionalOptions wishlistadditionaloptions)
    {
        return wishlistadditionaloptions.m;
    }

    static EditText b(WishlistAdditionalOptions wishlistadditionaloptions)
    {
        return wishlistadditionaloptions.j;
    }

    private void b()
    {
        String s1;
        Bundle bundle;
        String s2;
        Object obj = (InputMethodManager)d.getSystemService("input_method");
        if (d.getCurrentFocus() != null && d.getCurrentFocus().getWindowToken() != null)
        {
            ((InputMethodManager) (obj)).hideSoftInputFromWindow(d.getCurrentFocus().getWindowToken(), 0);
        }
        bundle = new Bundle();
        obj = a.getText().toString();
        String s3 = b.getText().toString();
        String s4 = g.getText().toString();
        String s5 = h.getText().toString();
        s1 = i.getSelectedItem().toString();
        s2 = j.getText().toString();
        l.setShippingAddress(((String) (obj)));
        l.setAddDescription(s3);
        l.setEventLocation(s4);
        l.setEventCity(s5);
        if (s1 == null || s1.length() <= 0 || !s1.equals("Select a state")) goto _L2; else goto _L1
_L1:
        Object obj1 = "";
_L4:
        l.setEventState(((String) (obj1)));
        l.setEventDate(s2);
        l.setCreatedBy(fr.c());
        l.setLastModifiedBy(fr.c());
        bundle.putSerializable("data", l);
        if (s == null || s.isEmpty())
        {
            obj1 = new HashMap();
            ((HashMap) (obj1)).put("bb.createList", "1");
            lu.b(lu.z, ((HashMap) (obj1)));
        }
        (new ja(d, this, o, l)).executeOnExecutor(nb.g, new Void[0]);
        return;
_L2:
        obj1 = s1;
        if (s1 != null)
        {
            obj1 = s1;
            if (s1.length() > 0)
            {
                obj1 = s1.substring(0, s1.indexOf("-"));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(RegistryWishList registrywishlist)
    {
        u = registrywishlist;
        if (s != null && !s.isEmpty())
        {
            (new iy((HomeActivity)d, this, null, registrywishlist.getUuid(), s, registrywishlist.getType(), "1")).executeOnExecutor(nb.g, new Void[0]);
            return;
        } else
        {
            b(false);
            return;
        }
    }

    public void a(WishListReqData wishlistreqdata)
    {
        if (wishlistreqdata != null)
        {
            if (wishlistreqdata.getAddressLine1() != null && wishlistreqdata.getAddressLine2() != null && wishlistreqdata.getCity() != null && wishlistreqdata.getPhone() != null && wishlistreqdata.getZipCode() != null && wishlistreqdata.getState() != null)
            {
                a.setText((new StringBuilder()).append(wishlistreqdata.getAddressLine1()).append(" ").append(wishlistreqdata.getAddressLine2()).append(" ").append(wishlistreqdata.getCity()).append(" ").append(wishlistreqdata.getState()).append(" ").append(wishlistreqdata.getZipCode()).append(" ").append(wishlistreqdata.getPhone()).toString());
                l.setAddressLine1(wishlistreqdata.getAddressLine1());
                l.setAddressLine2(wishlistreqdata.getAddressLine2());
                l.setCity(wishlistreqdata.getCity());
                l.setPhone(wishlistreqdata.getPhone());
                l.setState(wishlistreqdata.getState());
                l.setZipCode(wishlistreqdata.getZipCode());
            }
            if (wishlistreqdata.getEventDate() != null)
            {
                j.setText(wishlistreqdata.getEventDate());
                l.setEventDate(wishlistreqdata.getEventDate());
            }
            if (wishlistreqdata.getEventLocation() != null)
            {
                g.setText(wishlistreqdata.getEventLocation());
                l.setEventLocation(wishlistreqdata.getEventLocation());
            }
            if (wishlistreqdata.getAddDescription() != null)
            {
                b.setText(wishlistreqdata.getAddDescription());
                l.setAddDescription(wishlistreqdata.getAddDescription());
            }
        }
    }

    public void a(WishListReqData wishlistreqdata, int i1)
    {
        l = wishlistreqdata;
        v = i1;
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            b(true);
        }
    }

    public void b(boolean flag)
    {
        BaseFragmentContainer basefragmentcontainer = (BaseFragmentContainer)getParentFragment();
        List list = basefragmentcontainer.getChildFragmentManager().getFragments();
        int i1 = list.size() - 1;
        while (i1 >= 0) 
        {
            Fragment fragment = (Fragment)list.get(i1);
            if (basefragmentcontainer instanceof RegistryFragmentContainer)
            {
                if (fragment != null && fragment.getTag() != null && !fragment.getTag().equals("RegistryAndGiftsFragment"))
                {
                    ((HomeActivity)d).onBackPressed();
                } else
                {
                    basefragmentcontainer.a(new MyWishListsFragment(), true, "MyWishListsFragment");
                }
            } else
            {
                Object obj;
                if (!flag)
                {
                    obj = "mywishlistsfragment";
                } else
                {
                    obj = "WishListFragmentContainer";
                }
                if (fragment == null || !fragment.getTag().equals(obj))
                {
                    if (fragment instanceof MyWishListsFragment)
                    {
                        MyWishListsFragment.a = false;
                        HomeActivity.inPDPFragment = false;
                        HomeActivity.inLifeEventsFragment = true;
                        ((HomeActivity)d).onBackPressed();
                        if (flag)
                        {
                            obj = new HashMap();
                            ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.f()).append("Create a Wishlist").toString());
                            ((HashMap) (obj)).put("bb.createList", "1");
                            lu.b((new StringBuilder()).append(lu.L).append(t).toString(), ((HashMap) (obj)));
                        }
                        basefragmentcontainer.a(new WishListWithProductsFragment(true, this, u), true, "WishListWithProductsFragment");
                    } else
                    {
                        ((HomeActivity)d).onBackPressed();
                    }
                }
            }
            i1--;
        }
    }

    public void g()
    {
        b();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f0800a3));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        if (l != null)
        {
            t = l.getListType().substring(0, l.getListType().length() - 1);
            lu.a((new StringBuilder()).append(lu.O).append(t).toString());
        }
    }

    public void onClick(View view)
    {
        if (view == a || view == q)
        {
            view = new WishlistAddressFragment(l, this, false, v, s);
            Fragment fragment = getParentFragment();
            if (fragment instanceof WishListFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(view, true);
            }
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(view, true);
            }
            if (fragment instanceof HomeTabContainer)
            {
                ((HomeTabContainer)fragment).a(view, true);
            }
        } else
        {
            if (view == r || view == j)
            {
                view = new DatePickerDialog(getActivity(), n, m.get(1), m.get(2), m.get(5));
                view.getDatePicker().setMinDate(System.currentTimeMillis() - 1000L);
                view.getDatePicker().setMaxDate(System.currentTimeMillis() + 0x757b12c00L);
                view.show();
                return;
            }
            if (view == k)
            {
                b();
                return;
            }
            if (view == p)
            {
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030117, viewgroup, false);
        p = (RelativeLayout)layoutinflater.findViewById(0x7f0c0076);
        d.getWindow().setSoftInputMode(16);
        o = layoutinflater.findViewById(0x7f0c0064);
        q = (ImageView)layoutinflater.findViewById(0x7f0c0411);
        r = (ImageView)layoutinflater.findViewById(0x7f0c041e);
        a = (EditText)layoutinflater.findViewById(0x7f0c0410);
        b = (EditText)layoutinflater.findViewById(0x7f0c0413);
        c = (TextView)layoutinflater.findViewById(0x7f0c0415);
        g = (EditText)layoutinflater.findViewById(0x7f0c0416);
        h = (EditText)layoutinflater.findViewById(0x7f0c0418);
        i = (Spinner)layoutinflater.findViewById(0x7f0c041a);
        j = (EditText)layoutinflater.findViewById(0x7f0c041d);
        a.setOnClickListener(this);
        q.setOnClickListener(this);
        m = Calendar.getInstance();
        n = new android.app.DatePickerDialog.OnDateSetListener() {

            final WishlistAdditionalOptions a;

            private void a()
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                WishlistAdditionalOptions.b(a).setText(simpledateformat.format(WishlistAdditionalOptions.a(a).getTime()));
            }

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                WishlistAdditionalOptions.a(a).set(1, i1);
                WishlistAdditionalOptions.a(a).set(2, j1);
                WishlistAdditionalOptions.a(a).set(5, k1);
                a();
            }

            
            {
                a = WishlistAdditionalOptions.this;
                super();
            }
        };
        r.setOnClickListener(this);
        j.setOnClickListener(this);
        k = (RelativeLayout)layoutinflater.findViewById(0x7f0c0420);
        k.setOnClickListener(this);
        p.setOnClickListener(this);
        if (t.contains("school"))
        {
            c.setText(0x7f0802ec);
            return layoutinflater;
        } else
        {
            c.setText(0x7f080216);
            return layoutinflater;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        d.getWindow().setSoftInputMode(32);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08014a), false);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)getActivity()).changeActionBarSearchVisibility(getActivity(), false);
        ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f0800a3));
        HomeActivity.inLifeEventsFragment = true;
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08014a), true);
        a(l);
    }
}
