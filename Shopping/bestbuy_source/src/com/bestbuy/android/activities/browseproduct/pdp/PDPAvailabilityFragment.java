// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.home.availability.CheckLink;
import com.bestbuy.android.api.lib.models.home.availability.Delivery;
import com.bestbuy.android.api.lib.models.home.availability.Download;
import com.bestbuy.android.api.lib.models.home.availability.InStoreAvailability;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Availability;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.CheckShipLink;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.InStoreOnly;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Pickup;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Ship;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import kb;
import kf;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragmentContainer, PDPFragment

public class PDPAvailabilityFragment extends BBYBaseFragment
{

    private View a;
    private View b;
    private OverviewResponse c;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private DNMProduct o;
    private int p;

    public PDPAvailabilityFragment()
    {
    }

    public PDPAvailabilityFragment(OverviewResponse overviewresponse, DNMProduct dnmproduct)
    {
        c = overviewresponse;
        o = dnmproduct;
    }

    static OverviewResponse a(PDPAvailabilityFragment pdpavailabilityfragment)
    {
        return pdpavailabilityfragment.c;
    }

    static void a(PDPAvailabilityFragment pdpavailabilityfragment, MdotWebFragment mdotwebfragment)
    {
        pdpavailabilityfragment.a(mdotwebfragment);
    }

    private void a(MdotWebFragment mdotwebfragment)
    {
        try
        {
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            Fragment fragment = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (fragment instanceof HomeTabFragment)
            {
                ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(mdotwebfragment, true);
            }
            if ((fragment instanceof PDPFragmentContainer) && ((PDPFragment)((PDPFragmentContainer)fragment).b() instanceof PDPFragment))
            {
                ((PDPFragmentContainer)fragment).a(mdotwebfragment, true);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MdotWebFragment mdotwebfragment)
        {
            kf.e("PDPAvailabilityFragment", (new StringBuilder()).append("Error attempting to open delievery mDot punch out").append(mdotwebfragment.getLocalizedMessage()).toString());
        }
    }

    private void a(DNMProduct dnmproduct)
    {
        j.setVisibility(0);
        g.setVisibility(0);
        BBYTextView bbytextview = (BBYTextView)j.findViewById(0x7f0c01f9);
        bbytextview.setVisibility(0);
        BBYTextView bbytextview1 = (BBYTextView)j.findViewById(0x7f0c01fa);
        bbytextview1.setVisibility(8);
        bbytextview.setText((new StringBuilder()).append(dnmproduct.getStoreName()).append(", Pickup Today").toString());
        if (p > 1)
        {
            bbytextview1.setVisibility(0);
            bbytextview1.setOnClickListener(new android.view.View.OnClickListener() {

                final PDPAvailabilityFragment a;

                public void onClick(View view)
                {
                    ((BaseFragmentContainer)((PDPFragment)a.getParentFragment()).getParentFragment().getParentFragment()).d();
                }

            
            {
                a = PDPAvailabilityFragment.this;
                super();
            }
            });
        }
        ((ImageView)j.findViewById(0x7f0c01f8)).setImageResource(0x7f020148);
        ((ImageView)g.findViewById(0x7f0c0200)).setImageResource(0x7f020144);
        ((BBYTextView)g.findViewById(0x7f0c0201)).setText(getResources().getString(0x7f0802a1));
    }

    private void c()
    {
        BBYTextView bbytextview1;
        BBYTextView bbytextview2;
        boolean flag1;
        flag1 = false;
        bbytextview1 = (BBYTextView)j.findViewById(0x7f0c01fa);
        j.setVisibility(0);
        bbytextview2 = (BBYTextView)j.findViewById(0x7f0c01f9);
        bbytextview2.setVisibility(0);
        if (c == null || c.getAvailability() == null || c.getAvailability() == null || c.getAvailability().getPickup() == null) goto _L2; else goto _L1
_L1:
        Pickup pickup = c.getAvailability().getPickup();
        if (!c.getAvailability().getPickup().isAvailable()) goto _L4; else goto _L3
_L3:
        PriceBlock priceblock = c.getPriceBlock();
        boolean flag = flag1;
        if (priceblock != null)
        {
            flag = flag1;
            if (priceblock.getButtonState() != null)
            {
                flag = flag1;
                if (priceblock.getButtonState().getAvailabilityType() != null)
                {
                    String s;
                    BBYTextView bbytextview;
                    if (priceblock.getButtonState().getAvailabilityType().equals(getString(0x7f0802ac)))
                    {
                        if (pickup != null && pickup.getCheckStoresLink() != null && pickup.getCheckStoresLink().getUrl() != null && !pickup.getCheckStoresLink().getUrl().isEmpty())
                        {
                            flag = false;
                        } else
                        {
                            flag = true;
                        }
                    } else
                    {
                        flag = false;
                    }
                    if (priceblock.getButtonState().getButtonStateID() != null && priceblock.getButtonState().getButtonStateID().equals(getString(0x7f080029)))
                    {
                        flag = true;
                    }
                }
            }
        }
        if (flag)
        {
            bbytextview1.setVisibility(8);
            bbytextview2.setText(pickup.getDisplayMessage().replaceAll("<b>([^<]*)</b>:", "").replaceAll("<b>([^<]*)</b>", "").trim());
            return;
        }
        bbytextview = null;
        if (pickup.getInStoreAvailability() == null) goto _L6; else goto _L5
_L5:
        s = pickup.getInStoreAvailability().getStoreName();
_L13:
        if (s == null || s.isEmpty()) goto _L8; else goto _L7
_L7:
        if (pickup.getInStoreAvailability() == null || pickup.getInStoreAvailability().getPickupMessage() == null || pickup.getInStoreAvailability().getPickupMessage().isEmpty()) goto _L10; else goto _L9
_L9:
        bbytextview2.setText(Html.fromHtml((new StringBuilder()).append(s).append(" - ").append(pickup.getInStoreAvailability().getPickupMessage()).toString()));
_L11:
        bbytextview1.setOnClickListener(new android.view.View.OnClickListener(priceblock, pickup) {

            final PriceBlock a;
            final Pickup b;
            final PDPAvailabilityFragment c;

            public void onClick(View view)
            {
                if (a != null && a.getButtonState() != null && a.getButtonState().getAvailabilityType() != null && a.getButtonState().getAvailabilityType().equals(c.getString(0x7f0802ac)))
                {
                    if (b != null && b.getCheckStoresLink() != null && b.getCheckStoresLink().getUrl() != null && !b.getCheckStoresLink().getUrl().isEmpty())
                    {
                        view = new MdotWebFragment(true, true);
                        Bundle bundle = new Bundle();
                        bundle.putString(c.getResources().getString(0x7f080055), (new StringBuilder()).append("http://www.bestbuy.com").append(b.getCheckStoresLink().getUrl()).toString());
                        view.setArguments(bundle);
                        PDPAvailabilityFragment.a(c, view);
                    }
                } else
                {
                    view = kb.a("ProductAvailabilityFragment", null, PDPAvailabilityFragment.a(c), null, false);
                    Fragment fragment = ((FragmentActivity)c.d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                    if (fragment instanceof HomeTabFragment)
                    {
                        ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(view, true);
                    }
                    if ((fragment instanceof PDPFragmentContainer) && ((PDPFragment)((PDPFragmentContainer)fragment).b() instanceof PDPFragment))
                    {
                        ((PDPFragmentContainer)fragment).a(view, true);
                        return;
                    }
                }
            }

            
            {
                c = PDPAvailabilityFragment.this;
                a = priceblock;
                b = pickup;
                super();
            }
        });
        return;
_L6:
        s = bbytextview;
        if (priceblock != null)
        {
            s = bbytextview;
            if (priceblock.getButtonState() != null)
            {
                s = bbytextview;
                if (priceblock.getButtonState().getAvailabilityType() != null)
                {
                    s = bbytextview;
                    if (priceblock.getButtonState().getAvailabilityType().equals(getString(0x7f0802ac)))
                    {
                        s = bbytextview;
                        if (pickup != null)
                        {
                            s = bbytextview;
                            if (pickup.getCheckStoresLink() != null)
                            {
                                s = bbytextview;
                                if (pickup.getCheckStoresLink().getUrl() != null)
                                {
                                    s = bbytextview;
                                    if (!pickup.getCheckStoresLink().getUrl().isEmpty())
                                    {
                                        s = pickup.getDisplayMessage();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (priceblock != null && priceblock.getButtonState() != null && priceblock.getButtonState().getAvailabilityType() != null && priceblock.getButtonState().getAvailabilityType().equals(getString(0x7f0802ac)) && pickup != null && pickup.getCheckStoresLink() != null && pickup.getCheckStoresLink().getUrl() != null && !pickup.getCheckStoresLink().getUrl().isEmpty())
        {
            bbytextview2.setText(Html.fromHtml(s.replaceAll("<b>([^<]*)</b>:", "").replaceAll("<b>([^<]*)</b>", "").trim()));
        }
        continue; /* Loop/switch isn't completed */
_L8:
        bbytextview2.setVisibility(8);
        if (true) goto _L11; else goto _L4
_L4:
        ((ImageView)j.findViewById(0x7f0c01f8)).setImageResource(0x7f020147);
        bbytextview = (BBYTextView)j.findViewById(0x7f0c01f9);
        s = pickup.getDisplayMessage().replaceAll("<b>([^<]*)</b>", "").trim();
        if (s == null || s.isEmpty())
        {
            s = getResources().getString(0x7f0802a1);
        } else
        {
            bbytextview2.setText(s);
        }
        bbytextview.setText(s);
        bbytextview.setVisibility(0);
        bbytextview1.setVisibility(8);
        return;
_L2:
        j.setVisibility(8);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void b()
    {
        c();
        if (c != null && c.getPriceBlock() != null && c.getPriceBlock().getAvailability() != null)
        {
            Object obj = c.getPriceBlock().getAvailability().getShip();
            BBYTextView bbytextview = (BBYTextView)g.findViewById(0x7f0c0201);
            if (obj != null)
            {
                g.setVisibility(0);
                BBYTextView bbytextview3;
                if (((Ship) (obj)).isAvailable())
                {
                    if (((Ship) (obj)).getDisplayMessage() != null)
                    {
                        bbytextview.setText(((Ship) (obj)).getDisplayMessage().replaceAll("<b>([^<]*)</b>:", "").replaceAll("<b>([^<]*)</b>", "").trim());
                    }
                    if (((Ship) (obj)).isSignatureRequired())
                    {
                        BBYTextView bbytextview1 = (BBYTextView)g.findViewById(0x7f0c0202);
                        bbytextview1.setVisibility(0);
                        bbytextview1.setOnClickListener(new android.view.View.OnClickListener() {

                            final PDPAvailabilityFragment a;

                            public void onClick(View view)
                            {
                                view = new MdotWebFragment(true, true);
                                Bundle bundle = new Bundle();
                                bundle.putString(a.getResources().getString(0x7f080055), a.d.getResources().getString(0x7f080315));
                                view.setArguments(bundle);
                                PDPAvailabilityFragment.a(a, view);
                            }

            
            {
                a = PDPAvailabilityFragment.this;
                super();
            }
                        });
                    }
                    if (((Ship) (obj)).getCheckLink() != null && ((Ship) (obj)).getCheckLink().getUrl() != null && ((Ship) (obj)).getCheckLink().getUrl().length() > 0)
                    {
                        BBYTextView bbytextview2 = (BBYTextView)g.findViewById(0x7f0c0203);
                        bbytextview2.setVisibility(0);
                        bbytextview2.setOnClickListener(new android.view.View.OnClickListener(((Ship) (obj))) {

                            final Ship a;
                            final PDPAvailabilityFragment b;

                            public void onClick(View view)
                            {
                                view = new MdotWebFragment(true, true);
                                Bundle bundle = new Bundle();
                                bundle.putString(b.getResources().getString(0x7f080055), (new StringBuilder()).append("http://www.bestbuy.com").append(a.getCheckLink().getUrl()).toString());
                                view.setArguments(bundle);
                                PDPAvailabilityFragment.a(b, view);
                            }

            
            {
                b = PDPAvailabilityFragment.this;
                a = ship;
                super();
            }
                        });
                    }
                    if (!((Ship) (obj)).isAvailable() || o != null)
                    {
                        ((ImageView)g.findViewById(0x7f0c0200)).setImageResource(0x7f020144);
                        if (((Ship) (obj)).getDisplayMessage().isEmpty())
                        {
                            bbytextview.setText(getResources().getString(0x7f0802a1));
                        }
                    }
                } else
                {
                    g.setVisibility(0);
                    ((ImageView)g.findViewById(0x7f0c0200)).setImageResource(0x7f020144);
                    if (obj != null && ((Ship) (obj)).getDisplayMessage() != null && !((Ship) (obj)).getDisplayMessage().isEmpty())
                    {
                        bbytextview.setText(((Ship) (obj)).getDisplayMessage().replaceAll("<b>([^<]*)</b>:", "").replaceAll("<b>([^<]*)</b>", "").trim());
                    } else
                    {
                        bbytextview.setText(getResources().getString(0x7f0802a1));
                    }
                }
            }
        }
        if (c != null && c.getPriceBlock() != null && c.getPriceBlock().getAvailability() != null && c.getPriceBlock().getAvailability().getDelivery() != null)
        {
            obj = c.getPriceBlock().getAvailability().getDelivery();
            if (obj != null)
            {
                if (((Delivery) (obj)).isAvailable())
                {
                    h.setVisibility(0);
                    if (((Delivery) (obj)).getCheckLink() != null)
                    {
                        obj = ((Delivery) (obj)).getCheckLink().getUrl();
                        if (obj != null && !((String) (obj)).isEmpty())
                        {
                            bbytextview = (BBYTextView)h.findViewById(0x7f0c0207);
                            bbytextview.setVisibility(0);
                            bbytextview.setOnClickListener(new android.view.View.OnClickListener(((String) (obj))) {

                                final String a;
                                final PDPAvailabilityFragment b;

                                public void onClick(View view)
                                {
                                    view = new MdotWebFragment(true, true);
                                    Bundle bundle = new Bundle();
                                    bundle.putString(b.getResources().getString(0x7f080055), (new StringBuilder()).append("http://www.bestbuy.com").append(a).toString());
                                    view.setArguments(bundle);
                                    PDPAvailabilityFragment.a(b, view);
                                }

            
            {
                b = PDPAvailabilityFragment.this;
                a = s;
                super();
            }
                            });
                        }
                    }
                } else
                {
                    h.setVisibility(0);
                    ((ImageView)h.findViewById(0x7f0c0205)).setImageResource(0x7f02013a);
                    ((BBYTextView)h.findViewById(0x7f0c0206)).setVisibility(0);
                }
            }
        }
        if (c != null && c.getPriceBlock() != null && c.getPriceBlock().getAvailability() != null && c.getPriceBlock().getAvailability().getDownload() != null)
        {
            obj = c.getPriceBlock().getAvailability().getDownload();
            if (obj != null && ((Download) (obj)).isAvailable())
            {
                i.setVisibility(0);
                bbytextview = (BBYTextView)i.findViewById(0x7f0c020b);
                bbytextview3 = (BBYTextView)i.findViewById(0x7f0c020a);
                if (!((Download) (obj)).isAvailable())
                {
                    ((ImageView)i.findViewById(0x7f0c0209)).setImageResource(0x7f02013c);
                    bbytextview3.setText(((Download) (obj)).getDisplayMessage());
                }
                bbytextview.setOnClickListener(new android.view.View.OnClickListener() {

                    final PDPAvailabilityFragment a;

                    public void onClick(View view)
                    {
                        view = new MdotWebFragment(true, true);
                        Bundle bundle = new Bundle();
                        bundle.putString(a.getResources().getString(0x7f080055), a.d.getResources().getString(0x7f0801df));
                        view.setArguments(bundle);
                        PDPAvailabilityFragment.a(a, view);
                    }

            
            {
                a = PDPAvailabilityFragment.this;
                super();
            }
                });
            }
        }
        if (c != null && c.getPriceBlock() != null && c.getPriceBlock().getAvailability() != null && c.getPriceBlock().getAvailability().getInStoreOnly() != null && c.getPriceBlock().getAvailability().getInStoreOnly().isAvailable())
        {
            n.setVisibility(0);
            obj = null;
            bbytextview = (BBYTextView)n.findViewById(0x7f0c01fe);
            if (c.getPriceBlock().getAvailability().getInStoreOnly().getCheckLink() != null)
            {
                obj = c.getPriceBlock().getAvailability().getInStoreOnly().getCheckLink().getUrl();
            }
            if (obj == null || ((String) (obj)).isEmpty())
            {
                bbytextview.setVisibility(8);
            }
            bbytextview.setOnClickListener(new android.view.View.OnClickListener() {

                final PDPAvailabilityFragment a;

                public void onClick(View view)
                {
                    view = kb.a("ProductAvailabilityFragment", null, PDPAvailabilityFragment.a(a), null, false);
                    Fragment fragment = ((FragmentActivity)a.d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                    if (fragment instanceof HomeTabFragment)
                    {
                        ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(view, true);
                    }
                    if ((fragment instanceof PDPFragmentContainer) && ((PDPFragment)((PDPFragmentContainer)fragment).b() instanceof PDPFragment))
                    {
                        ((PDPFragmentContainer)fragment).a(view, true);
                    }
                }

            
            {
                a = PDPAvailabilityFragment.this;
                super();
            }
            });
        }
        if (c != null && c.getPriceBlock() != null && c.getPriceBlock().getAttributes() != null)
        {
            if (c.getPriceBlock().getAttributes().isSpecialOrderDelivery())
            {
                k.setVisibility(0);
                ((BBYTextView)b.findViewById(0x7f0c020d)).setOnClickListener(new android.view.View.OnClickListener() {

                    final PDPAvailabilityFragment a;

                    public void onClick(View view)
                    {
                        view = ((BBYBaseFragmentActivity)a.d).getCurrentActionBarTitle();
                        a.f.i(view);
                        ((BBYBaseFragmentActivity)a.d).updateActionBarTitle(a.getResources().getString(0x7f080332));
                        view = new MdotWebFragment(false);
                        Bundle bundle = new Bundle();
                        bundle.putString(a.getResources().getString(0x7f080055), "file:///android_asset/special_order_info.html");
                        view.setArguments(bundle);
                        PDPAvailabilityFragment.a(a, view);
                    }

            
            {
                a = PDPAvailabilityFragment.this;
                super();
            }
                });
            } else
            {
                k.setVisibility(8);
            }
        }
        l.setVisibility(8);
        if (a != null)
        {
            a.setVisibility(8);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle.containsKey("NumOfStores"))
        {
            p = bundle.getInt("NumOfStores");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (b == null)
        {
            b = layoutinflater.inflate(0x7f030089, viewgroup, false);
            a = b.findViewById(0x7f0c0064);
            m = (LinearLayout)b.findViewById(0x7f0c01f6);
            g = (LinearLayout)b.findViewById(0x7f0c01ff);
            h = (LinearLayout)b.findViewById(0x7f0c0204);
            i = (LinearLayout)b.findViewById(0x7f0c0208);
            j = (LinearLayout)b.findViewById(0x7f0c01f7);
            k = (LinearLayout)b.findViewById(0x7f0c020c);
            l = (LinearLayout)b.findViewById(0x7f0c020e);
            n = (LinearLayout)b.findViewById(0x7f0c01fb);
            if (o == null)
            {
                b();
            } else
            {
                a(o);
            }
        } else
        {
            ((ViewGroup)b.getParent()).removeView(b);
        }
        return b;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
    }
}
