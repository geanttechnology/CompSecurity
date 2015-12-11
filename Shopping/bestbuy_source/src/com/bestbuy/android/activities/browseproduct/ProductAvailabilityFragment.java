// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import ahr;
import ahx;
import ahy;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPMedia;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.SKUAvailability;
import com.bestbuy.android.api.lib.models.store.Sku;
import com.bestbuy.android.api.lib.models.store.availability.Availability;
import com.bestbuy.android.api.lib.models.store.availability.InStoreAvailability;
import com.bestbuy.android.api.lib.models.store.availability.InStoreOnly;
import com.bestbuy.android.api.lib.models.store.availability.Pickup;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.AverageRating;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CustomerRatings;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.MediaImage;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dq;
import ij;
import ik;
import in;
import ip;
import java.util.ArrayList;
import kf;
import ll;
import nb;
import ng;
import nr;
import pp;
import qm;
import qn;
import qo;
import qp;

public class ProductAvailabilityFragment extends BBYBaseFragment
    implements ahx, android.view.View.OnClickListener, qo, qp
{

    private static final String a = com/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment.getSimpleName();
    private OverviewResponse b;
    private View c;
    private View g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private EditText l;
    private ListView m;
    private dq n;
    private ArrayList o;
    private String p;
    private LinearLayout q;
    private boolean r;
    private LinearLayout s;
    private LinearLayout t;
    private LinearLayout u;
    private RelativeLayout v;
    private FrameLayout w;
    private qm x;
    private LinearLayout y;
    private boolean z;

    public ProductAvailabilityFragment()
    {
        o = new ArrayList();
        r = false;
        z = true;
    }

    public ProductAvailabilityFragment(OverviewResponse overviewresponse)
    {
        o = new ArrayList();
        r = false;
        z = true;
        b = overviewresponse;
    }

    static LinearLayout a(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.i;
    }

    static EditText b(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.l;
    }

    static LinearLayout c(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.j;
    }

    static LinearLayout d(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.k;
    }

    private boolean d()
    {
        return ((LocationManager)d.getSystemService("location")).isProviderEnabled("gps");
    }

    static ListView e(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.m;
    }

    static View f(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.c;
    }

    static View g(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.g;
    }

    static OverviewResponse h(ProductAvailabilityFragment productavailabilityfragment)
    {
        return productavailabilityfragment.b;
    }

    public void a(Double double1, Double double2)
    {
        (new ij(d, this, null, double1.doubleValue(), double2.doubleValue(), b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
    }

    public void a(String s1)
    {
        i.setVisibility(0);
        b(s1);
    }

    public void a(ArrayList arraylist)
    {
        o.clear();
        if (arraylist != null)
        {
            int i1 = 0;
            while (i1 < arraylist.size()) 
            {
                if (arraylist.get(i1) != null && ((BBYStore)arraylist.get(i1)).getAvailability() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability() != null)
                {
                    if (((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getPickup() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getPickup().getInStoreAvailability() != null)
                    {
                        if (((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getPickup().getInStoreAvailability().getPickupMessage() != null && !((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getPickup().getInStoreAvailability().getPickupMessage().equals("Unavailable"))
                        {
                            o.add(arraylist.get(i1));
                        }
                    } else
                    if (((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getInStoreOnly() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getInStoreOnly().getInStoreAvailability() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getInStoreOnly().getInStoreAvailability().getPickupMessage() != null && ((BBYStore)arraylist.get(i1)).getAvailability().getSku().getAvailability().getInStoreOnly().getInStoreAvailability().getPickupMessage().equals("Unavailable"))
                    {
                        o.add(arraylist.get(i1));
                    }
                }
                i1++;
            }
        }
        n.notifyDataSetChanged();
        if (c != null)
        {
            c.setVisibility(8);
        }
        i.setVisibility(8);
        j.setVisibility(0);
        k.setVisibility(8);
        if (o != null && o.size() != 0)
        {
            m.setVisibility(0);
            z = false;
        } else
        {
            z = true;
            m.setVisibility(8);
            if (z)
            {
                z = false;
                ((BBYTextView)u.findViewById(0x7f0c0083)).setText("We could not find any results for Current Location. Please try another.");
                ll.b(u);
                return;
            }
        }
    }

    public void b()
    {
        w.setVisibility(8);
        ll.b(s);
    }

    public void b(String s1)
    {
        ((BBYTextView)u.findViewById(0x7f0c0083)).setText((new StringBuilder()).append("We could not find any results for ").append(s1).append(". Please try another.").toString());
        ll.b(u);
    }

    public void c()
    {
        String s1 = b.getPriceBlock().getUrl();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(d);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'> <small>You will be redirected to BestBuy.com to complete your transaction. Do you want to continue?</small> </font>"));
        builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'> <b>Yes</b> </font>"), new android.content.DialogInterface.OnClickListener(s1) {

            final String a;
            final ProductAvailabilityFragment b;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.bestbuy.com").append(a).toString()));
                b.startActivity(dialoginterface);
            }

            
            {
                b = ProductAvailabilityFragment.this;
                a = s1;
                super();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>No</font>"), new android.content.DialogInterface.OnClickListener() {

            final ProductAvailabilityFragment a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
            }

            
            {
                a = ProductAvailabilityFragment.this;
                super();
            }
        });
        builder.create();
        builder.show();
    }

    public void c(String s1)
    {
        w.setVisibility(0);
        (new in(d, this, c, b.getSkuId(), s1)).execute(new Void[0]);
    }

    public void d(String s1)
    {
        String s2;
label0:
        {
            w.setVisibility(8);
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s2 = getString(0x7f08009e);
        }
        ((BBYTextView)t.findViewById(0x7f0c0339)).setText(s2);
        ll.b(t);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Product Availability");
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        f = nb.a();
        ((BBYBaseFragmentActivity)activity).changeActionBarAddToVisibility(activity, false);
        d = activity;
        if (c != null)
        {
            c.setVisibility(0);
        }
        if (d())
        {
            Double double1 = Double.valueOf(f.y());
            Double double2 = Double.valueOf(f.z());
            if (double1 == null || double1.doubleValue() == 0.0D || double2 == null || double2.doubleValue() == 0.0D)
            {
                x = (new qn(activity)).a(ahy.a).a(this).a(this).b();
                x.b();
            }
        }
    }

    public void onClick(View view)
    {
        if (view != h) goto _L2; else goto _L1
_L1:
        if (!(getParentFragment() instanceof BaseTabContainer)) goto _L4; else goto _L3
_L3:
        ((BaseTabContainer)getParentFragment()).a_();
_L6:
        return;
_L4:
        if (!(getParentFragment() instanceof PDPFragmentContainer)) goto _L6; else goto _L5
_L5:
        ((PDPFragmentContainer)getParentFragment()).d();
        return;
_L2:
        if (view != s)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(d instanceof HomeActivity)) goto _L6; else goto _L7
_L7:
        view = ((HomeActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(view instanceof HomeTabFragment)) goto _L6; else goto _L8
_L8:
        ((HomeTabFragment)view).a(3);
        return;
        if (view != y) goto _L6; else goto _L9
_L9:
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(x, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        if (pp1.a())
        {
            try
            {
                pp1.a(d, 9000);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (pp pp1)
            {
                pp1.printStackTrace();
            }
            return;
        } else
        {
            kf.b(a, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b(a, (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        ImageView imageview;
label0:
        {
label1:
            {
                g = layoutinflater.inflate(0x7f0300cc, null);
                h = (LinearLayout)g.findViewById(0x7f0c032e);
                y = (LinearLayout)g.findViewById(0x7f0c0330);
                q = (LinearLayout)g.findViewById(0x7f0c006c);
                i = (LinearLayout)g.findViewById(0x7f0c0332);
                j = (LinearLayout)g.findViewById(0x7f0c0334);
                k = (LinearLayout)g.findViewById(0x7f0c0036);
                m = (ListView)g.findViewById(0x7f0c0106);
                n = new dq(d, o, false, true, this, b);
                m.setAdapter(n);
                c = g.findViewById(0x7f0c0064);
                h.setOnClickListener(this);
                s = (LinearLayout)g.findViewById(0x7f0c0080);
                u = (LinearLayout)g.findViewById(0x7f0c0082);
                t = (LinearLayout)g.findViewById(0x7f0c0338);
                s.setOnClickListener(this);
                v = (RelativeLayout)g.findViewById(0x7f0c032d);
                w = (FrameLayout)g.findViewById(0x7f0c0064);
                w.setBackgroundColor(0);
                y.setOnClickListener(this);
                imageview = (ImageView)h.findViewById(0x7f0c022b);
                bundle = null;
                layoutinflater = null;
                viewgroup = bundle;
                if (b == null)
                {
                    break label0;
                }
                viewgroup = bundle;
                if (b.getMedia() == null)
                {
                    break label0;
                }
                if (b.getMedia().getPrimaryImage() != null)
                {
                    layoutinflater = b.getMedia().getPrimaryImage().getUrl();
                }
                if (layoutinflater != null && !layoutinflater.isEmpty())
                {
                    viewgroup = layoutinflater;
                    if (!layoutinflater.equals(getString(0x7f080068)))
                    {
                        break label1;
                    }
                }
                viewgroup = layoutinflater;
                if (b.getMedia().getBackImage() != null)
                {
                    viewgroup = b.getMedia().getBackImage().getUrl();
                }
            }
            if (viewgroup != null && !viewgroup.isEmpty() && !viewgroup.equals(getString(0x7f080068)))
            {
                ng.a(viewgroup, imageview, false);
            } else
            {
                imageview.setImageResource(0x7f020130);
            }
        }
        if (viewgroup != null && !viewgroup.isEmpty() && !viewgroup.equals(getString(0x7f080068)))
        {
            ng.a(viewgroup, imageview, false);
        } else
        {
            imageview.setImageResource(0x7f020130);
        }
        if (b != null && b.getNames() != null && b.getNames().getShortName() != null && !b.getNames().getShortName().isEmpty())
        {
            p = b.getNames().getShortName();
        }
        ((BBYTextView)h.findViewById(0x7f0c032f)).setText(Html.fromHtml(p));
        layoutinflater = (RatingBar)y.findViewById(0x7f0c00cb);
        viewgroup = (BBYTextView)y.findViewById(0x7f0c0331);
        if (b != null && b.getCustomerRatings() != null && b.getCustomerRatings().getAverageRating() != null && b.getCustomerRatings().getAverageRating().getScore() != 0.0D)
        {
            layoutinflater.setNumStars(5);
            layoutinflater.setRating((float)b.getCustomerRatings().getAverageRating().getScore());
            int i1 = b.getCustomerRatings().getTotalCount();
            if (i1 == 1)
            {
                viewgroup.setText((new StringBuilder()).append("(").append(i1).append(" ").append(d.getString(0x7f0802df)).toString());
            } else
            {
                viewgroup.setText((new StringBuilder()).append("(").append(i1).append(" ").append(d.getString(0x7f0802e0)).toString());
            }
        } else
        {
            viewgroup.setTextColor(0xff888888);
            viewgroup.setText(d.getString(0x7f080394));
        }
        layoutinflater = Double.valueOf(f.y());
        viewgroup = Double.valueOf(f.z());
        if (layoutinflater != null && layoutinflater.doubleValue() != 0.0D && viewgroup != null && viewgroup.doubleValue() != 0.0D)
        {
            (new ij(d, this, c, layoutinflater.doubleValue(), viewgroup.doubleValue(), b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
            ((BBYTextView)j.findViewById(0x7f0c0335)).setText("Results for \"Current Location\" ");
            ((BBYTextView)j.findViewById(0x7f0c0336)).setOnClickListener(new android.view.View.OnClickListener() {

                final ProductAvailabilityFragment a;

                public void onClick(View view)
                {
                    ProductAvailabilityFragment.a(a).setVisibility(0);
                    ProductAvailabilityFragment.b(a).setText("");
                    ProductAvailabilityFragment.b(a).requestFocus();
                    ((InputMethodManager)a.d.getSystemService("input_method")).toggleSoftInput(2, 0);
                    ProductAvailabilityFragment.c(a).setVisibility(8);
                    ProductAvailabilityFragment.d(a).setVisibility(8);
                    ProductAvailabilityFragment.e(a).setVisibility(8);
                }

            
            {
                a = ProductAvailabilityFragment.this;
                super();
            }
            });
        } else
        {
            i.setVisibility(0);
            j.setVisibility(8);
            k.setVisibility(8);
            m.setVisibility(8);
        }
        l = (EditText)i.findViewById(0x7f0c0333);
        l.setOnKeyListener(new android.view.View.OnKeyListener() {

            final ProductAvailabilityFragment a;

            public boolean onKey(View view, int j1, KeyEvent keyevent)
            {
                if (keyevent.getAction() == 0 && j1 == 66)
                {
                    ProductAvailabilityFragment.f(a).setVisibility(0);
                    ProductAvailabilityFragment.a(a).setVisibility(8);
                    ProductAvailabilityFragment.c(a).setVisibility(8);
                    ProductAvailabilityFragment.d(a).setVisibility(8);
                    ProductAvailabilityFragment.e(a).setVisibility(8);
                    view = ProductAvailabilityFragment.b(a).getText().toString();
                    ((BBYTextView)ProductAvailabilityFragment.c(a).findViewById(0x7f0c0335)).setText((new StringBuilder()).append("Results for \"").append(view).append("\" ").toString());
                    ((BBYTextView)ProductAvailabilityFragment.c(a).findViewById(0x7f0c0336)).setOnClickListener(new android.view.View.OnClickListener(this) {

                        final _cls2 a;

                        public void onClick(View view)
                        {
                            ProductAvailabilityFragment.a(a.a).setVisibility(0);
                            ProductAvailabilityFragment.b(a.a).setText("");
                            ProductAvailabilityFragment.b(a.a).requestFocus();
                            ((InputMethodManager)a.a.d.getSystemService("input_method")).toggleSoftInput(2, 0);
                            ProductAvailabilityFragment.c(a.a).setVisibility(8);
                            ProductAvailabilityFragment.d(a.a).setVisibility(8);
                            ProductAvailabilityFragment.e(a.a).setVisibility(8);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    ((InputMethodManager)a.d.getSystemService("input_method")).hideSoftInputFromWindow(ProductAvailabilityFragment.g(a).getWindowToken(), 0);
                    if (view.length() > 4 && nr.c(view.substring(0, 4)))
                    {
                        (new ik(a.d, a, ProductAvailabilityFragment.f(a), view, ProductAvailabilityFragment.h(a).getSkuId())).executeOnExecutor(nb.h, new Void[0]);
                    } else
                    {
                        (new ip(a.d, a, ProductAvailabilityFragment.f(a), view)).executeOnExecutor(nb.h, new Void[0]);
                    }
                    ProductAvailabilityFragment.a(a).setVisibility(8);
                    ProductAvailabilityFragment.c(a).setVisibility(8);
                    ProductAvailabilityFragment.d(a).setVisibility(8);
                    ProductAvailabilityFragment.e(a).setVisibility(0);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = ProductAvailabilityFragment.this;
                super();
            }
        });
        return g;
    }

    public void onDestroy()
    {
        super.onDestroy();
        InputMethodManager inputmethodmanager = (InputMethodManager)d.getSystemService("input_method");
        if (d.getCurrentFocus() != null && d.getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(d.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (x != null && x.d())
        {
            x.c();
        }
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            f.a(location.getLatitude());
            f.b(location.getLongitude());
            if (x.d())
            {
                ahy.b.a(x, this);
            }
        }
        (new ij(d, this, c, f.y(), f.z(), b.getSkuId())).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Product Availability");
    }

}
