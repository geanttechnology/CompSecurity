// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.stores.StoreDetailsFragment;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.SKUAvailability;
import com.bestbuy.android.api.lib.models.store.Sku;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.api.lib.models.store.availability.Availability;
import com.bestbuy.android.api.lib.models.store.availability.InStoreAvailability;
import com.bestbuy.android.api.lib.models.store.availability.Pickup;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;

public class dq extends ArrayAdapter
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, lg
{

    private LayoutInflater a;
    private ArrayList b;
    private nb c;
    private Activity d;
    private boolean e;
    private boolean f;
    private boolean g;
    private BBYBaseFragment h;
    private OverviewResponse i;

    public dq(Activity activity, ArrayList arraylist, boolean flag, boolean flag1, BBYBaseFragment bbybasefragment, OverviewResponse overviewresponse)
    {
        super(activity, 0x7f030107, arraylist);
        e = false;
        g = false;
        b = arraylist;
        d = activity;
        g = flag1;
        f = flag;
        h = bbybasefragment;
        i = overviewresponse;
        a = activity.getLayoutInflater();
        c = nb.a();
    }

    static BBYBaseFragment a(dq dq1)
    {
        return dq1.h;
    }

    private void a(Uri uri, String s)
    {
        (new lf(d, uri, s, this)).show();
    }

    private void a(BBYStore bbystore, String s)
    {
        c.c("Background");
        bbystore = new StoreDetailsFragment(bbystore, s, false);
        s = ((BBYBaseFragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (s instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)s).getChildFragmentManager().findFragmentByTag("STORES")).a(bbystore, true);
        }
    }

    static OverviewResponse b(dq dq1)
    {
        return dq1.i;
    }

    static Activity c(dq dq1)
    {
        return dq1.d;
    }

    public int a(BBYStore bbystore)
    {
        return b.indexOf(bbystore);
    }

    public void a(boolean flag)
    {
        e = false;
    }

    public int getCount()
    {
        return b.size();
    }

    public int getPosition(Object obj)
    {
        return a((BBYStore)obj);
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        String s;
        Object obj;
        BBYStore bbystore;
        StoreDetails storedetails;
        Object obj1;
        if (view == null)
        {
            dr dr1 = new dr();
            view = a.inflate(0x7f030107, viewgroup, false);
            dr1.a = (BBYTextView)view.findViewById(0x7f0c0024);
            dr1.b = (BBYTextView)view.findViewById(0x7f0c0025);
            dr1.c = (BBYTextView)view.findViewById(0x7f0c0026);
            dr1.e = (BBYTextView)view.findViewById(0x7f0c0027);
            dr1.d = (BBYTextView)view.findViewById(0x7f0c0028);
            dr1.g = (ImageView)view.findViewById(0x7f0c03dd);
            dr1.h = (ImageView)view.findViewById(0x7f0c004c);
            dr1.i = (RelativeLayout)view.findViewById(0x7f0c0233);
            dr1.j = (LinearLayout)view.findViewById(0x7f0c0220);
            dr1.f = (BBYTextView)view.findViewById(0x7f0c03de);
            view.setTag(0x7f0d0006, dr1);
            viewgroup = dr1;
        } else
        {
            viewgroup = (dr)view.getTag(0x7f0d0006);
        }
        bbystore = (BBYStore)b.get(j);
        storedetails = bbystore.getStoreDetails();
        view.setTag(bbystore);
        s = storedetails.getName().replace("Best Buy Mobile - ", "").trim();
        ((dr) (viewgroup)).a.setText(s);
        ((dr) (viewgroup)).b.setText(storedetails.getAddress());
        ((dr) (viewgroup)).c.setText((new StringBuilder()).append(storedetails.getCity()).append(", ").append(storedetails.getState()).append(" ").append(storedetails.getZipCode()).toString());
        ((dr) (viewgroup)).b.setMovementMethod(LinkMovementMethod.getInstance());
        ((dr) (viewgroup)).e.setText(nr.a(bbystore));
        ((dr) (viewgroup)).d.setText((new StringBuilder()).append(bbystore.getDistance()).append("mi").toString());
        obj1 = bbystore.getAvailability();
        obj = null;
        s = obj;
        if (obj1 != null)
        {
            s = obj;
            if (((SKUAvailability) (obj1)).getSku() != null)
            {
                obj1 = ((SKUAvailability) (obj1)).getSku().getAvailability();
                s = obj;
                if (obj1 != null)
                {
                    s = obj;
                    if (((Availability) (obj1)).getPickup() != null)
                    {
                        s = obj;
                        if (((Availability) (obj1)).getPickup().getInStoreAvailability() != null)
                        {
                            s = ((Availability) (obj1)).getPickup().getInStoreAvailability().getPickupMessage();
                        }
                    }
                }
            }
        }
        if (s != null)
        {
            ((dr) (viewgroup)).f.setText(s);
        }
        if (storedetails.getName().contains("Mobile"))
        {
            ((dr) (viewgroup)).g.setVisibility(0);
        } else
        {
            ((dr) (viewgroup)).g.setVisibility(8);
        }
        if (f)
        {
            ((dr) (viewgroup)).h.setVisibility(0);
        } else
        {
            ((dr) (viewgroup)).h.setVisibility(8);
        }
        if (g)
        {
            if (i.getPriceBlock() != null && i.getPriceBlock().getButtonState() != null)
            {
                if (i.getPriceBlock().getButtonState().getButtonStateID().equals(d.getString(0x7f080029)))
                {
                    ((dr) (viewgroup)).j.setVisibility(0);
                    ((dr) (viewgroup)).j.setOnClickListener(new android.view.View.OnClickListener() {

                        final dq a;

                        public void onClick(View view1)
                        {
                            if (dq.a(a) != null && (dq.a(a) instanceof ProductAvailabilityFragment))
                            {
                                ((ProductAvailabilityFragment)dq.a(a)).c();
                            }
                        }

            
            {
                a = dq.this;
                super();
            }
                    });
                } else
                {
                    ((dr) (viewgroup)).i.setVisibility(0);
                    if (i.getPriceBlock().getButtonState().isCommerceUnavailable())
                    {
                        ((dr) (viewgroup)).i.setBackgroundResource(0x7f020009);
                    }
                    ((dr) (viewgroup)).i.setOnClickListener(new android.view.View.OnClickListener(bbystore) {

                        final BBYStore a;
                        final dq b;

                        public void onClick(View view1)
                        {
                            if (dq.b(b).getPriceBlock().getButtonState().isCommerceUnavailable())
                            {
                                if ((dq.a(b) instanceof ProductAvailabilityFragment) && dq.a(b).isAdded())
                                {
                                    ((ProductAvailabilityFragment)dq.a(b)).d(dq.c(b).getString(0x7f08009f));
                                }
                            } else
                            if (dq.a(b) != null && (dq.a(b) instanceof ProductAvailabilityFragment))
                            {
                                ((ProductAvailabilityFragment)dq.a(b)).c(a.getStoreId());
                                return;
                            }
                        }

            
            {
                b = dq.this;
                a = bbystore;
                super();
            }
                    });
                }
            }
        } else
        {
            ((dr) (viewgroup)).i.setVisibility(8);
        }
        view.setOnClickListener(this);
        return view;
    }

    public void onClick(View view)
    {
        if (f)
        {
            BBYStore bbystore = (BBYStore)view.getTag();
            if (bbystore != null && view.getId() == 0x7f0c03dc && !e)
            {
                a(bbystore, bbystore.getStoreId());
            }
        }
    }

    public boolean onLongClick(View view)
    {
        e = true;
        Store store = (Store)view.getTag();
        if (view.getId() == 0x7f0c0025 || view.getId() == 0x7f0c0026)
        {
            view = (new StringBuilder()).append(store.getCity()).append(",").append(store.getRegion()).append(" ").append(store.getPostalCode()).toString();
            view = (new StringBuilder()).append(store.getAddress()).append(",").append(view).toString();
            a(Uri.parse((new StringBuilder()).append(d.getResources().getString(0x7f0801d0)).append(c.y()).append(",").append(c.z()).append("&daddr=").append(view).append("&hl=en").toString()), view);
        }
        return false;
    }
}
