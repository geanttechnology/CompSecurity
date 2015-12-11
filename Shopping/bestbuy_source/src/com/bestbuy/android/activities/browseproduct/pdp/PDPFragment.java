// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import ahr;
import ahx;
import ahy;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import cg;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.MyEmptyWishListFragment;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.BreadCrumb;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponseRoot;
import com.bestbuy.android.api.lib.models.pdp.SIPDPOverviewResponse;
import com.bestbuy.android.api.lib.models.product.Product;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Attributes;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Price;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Properties;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.SellerInfo;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import in;
import iw;
import ix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kb;
import kf;
import ll;
import lu;
import nb;
import pp;
import qm;
import qn;
import qo;
import qp;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragmentContainer

public class PDPFragment extends BBYBaseFragment
    implements ahx, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, cg, ix, qo, qp
{

    private static ArrayList E = new ArrayList();
    private static RegistryWishList F;
    private static Product I;
    private static String R;
    private static OverviewResponse T;
    private static String b;
    private static boolean j;
    private BBYTextView A;
    private boolean B;
    private boolean C;
    private int D;
    private LinearLayout G;
    private BBYTextView H;
    private boolean J;
    private qm K;
    private boolean L;
    private String M;
    private String N;
    private boolean O;
    private BBYProduct P;
    private String Q;
    private PDPOverviewResponse S;
    private CustomSwipeToRefresh U;
    private boolean V;
    private PDPOverviewResponseRoot W;
    private String X;
    private View a;
    private String c;
    private LinearLayout g;
    private ScrollView h;
    private View i;
    private iw k;
    private RelativeLayout l;
    private RelativeLayout m;
    private RelativeLayout n;
    private RelativeLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private BBYTextView s;
    private DNMProduct t;
    private FrameLayout u;
    private boolean v;
    private boolean w;
    private String x;
    private LinearLayout y;
    private LinearLayout z;

    public PDPFragment()
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
    }

    public PDPFragment(String s1, String s2, boolean flag)
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
        b = s1;
        c = s2;
        B = flag;
        j = false;
    }

    public PDPFragment(String s1, String s2, boolean flag, DNMProduct dnmproduct, boolean flag1)
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
        b = s1;
        c = s2;
        j = flag;
        B = flag1;
        t = dnmproduct;
    }

    public PDPFragment(String s1, String s2, boolean flag, DNMProduct dnmproduct, boolean flag1, int i1)
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
        b = s1;
        c = s2;
        j = flag;
        B = flag1;
        t = dnmproduct;
        D = i1;
    }

    public PDPFragment(String s1, String s2, boolean flag, boolean flag1)
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
        b = s1;
        c = s2;
        B = flag;
        C = flag1;
        j = false;
    }

    public PDPFragment(String s1, String s2, boolean flag, boolean flag1, BBYProduct bbyproduct, String s3)
    {
        a = null;
        c = "";
        v = false;
        w = false;
        x = "";
        C = false;
        J = false;
        L = true;
        M = "";
        N = "";
        O = false;
        X = "";
        b = s1;
        c = s2;
        B = flag;
        j = false;
        O = flag1;
        P = bbyproduct;
        Q = s3;
    }

    static String a(PDPFragment pdpfragment)
    {
        return pdpfragment.x;
    }

    static CustomSwipeToRefresh b(PDPFragment pdpfragment)
    {
        return pdpfragment.U;
    }

    public static String b()
    {
        return b;
    }

    public static Product c()
    {
        return I;
    }

    static String c(PDPFragment pdpfragment)
    {
        return pdpfragment.M;
    }

    public static HashMap e()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("WishListData", E);
        hashmap.put("sku", b);
        hashmap.put("RegistryData", F);
        hashmap.put("Product", T);
        hashmap.put("isFromDNM", Boolean.valueOf(j));
        return hashmap;
    }

    public static String f()
    {
        return R;
    }

    private boolean j()
    {
        return ((LocationManager)d.getSystemService("location")).isProviderEnabled("gps");
    }

    public void a(PDPOverviewResponseRoot pdpoverviewresponseroot)
    {
        kf.c("PDPFragment", "The showPDPData methos is called.");
        W = pdpoverviewresponseroot;
        if (pdpoverviewresponseroot == null || pdpoverviewresponseroot.getSi() == null || pdpoverviewresponseroot.getSi().getResponse() == null) goto _L2; else goto _L1
_L1:
        S = pdpoverviewresponseroot.getSi().getResponse();
        if (pdpoverviewresponseroot.getSi().getResponse().getOverview() == null || pdpoverviewresponseroot.getSi().getResponse().getOverview() == null) goto _L2; else goto _L3
_L3:
        Object obj;
        obj = pdpoverviewresponseroot.getSi().getResponse().getOverview();
        T = ((OverviewResponse) (obj));
_L5:
        if (obj != null && ((OverviewResponse) (obj)).getBreadcrumb() != null)
        {
            for (int i1 = 1; i1 < ((OverviewResponse) (obj)).getBreadcrumb().size(); i1++)
            {
                M = (new StringBuilder()).append(M).append(((BreadCrumb)((OverviewResponse) (obj)).getBreadcrumb().get(i1)).getDisplayName()).append(": ").toString();
            }

            if (M.contains(": Product Info"))
            {
                M = M.replace(": Product Info", "");
            }
        }
        a(pdpoverviewresponseroot, M);
        Object obj1;
        String as[];
        int k1;
        if (j)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
            L = true;
        } else
        if (obj != null && (((OverviewResponse) (obj)).getAttributes() != null && ((OverviewResponse) (obj)).getAttributes().isMarketplace() || ((OverviewResponse) (obj)).getCondition() != null && ((OverviewResponse) (obj)).getCondition().equalsIgnoreCase("openbox") || ((OverviewResponse) (obj)).getAttributes() != null && ((OverviewResponse) (obj)).getAttributes().isMarketplace() || ((OverviewResponse) (obj)).getPriceBlock() != null && ((OverviewResponse) (obj)).getPriceBlock().getProperties() != null && ((OverviewResponse) (obj)).getPriceBlock().getProperties().getContractCondition() != null || ((OverviewResponse) (obj)).getPriceBlock() != null && ((OverviewResponse) (obj)).getPriceBlock().getButtonState() != null && !((OverviewResponse) (obj)).getPriceBlock().getButtonState().isPurchasable()))
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
            L = true;
        } else
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, true);
            L = false;
        }
        if (g != null)
        {
            g.removeAllViews();
        }
        if (s != null)
        {
            s.setOnClickListener(this);
        }
        if (obj != null)
        {
            obj1 = ((OverviewResponse) (obj)).getPriceBlock();
        } else
        {
            obj1 = null;
        }
        if (obj1 != null)
        {
            x = ((PriceBlock) (obj1)).getUrl();
        }
        if (t == null)
        {
            if (obj1 != null && ((PriceBlock) (obj1)).getButtonState().isPurchasable())
            {
                if (q != null)
                {
                    ((BBYTextView)q.findViewById(0x7f0c0238)).setText(((PriceBlock) (obj1)).getButtonState().getDisplayName());
                }
                int j1;
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f080029)))
                {
                    if (s != null)
                    {
                        s.setVisibility(0);
                        s.setText(getString(0x7f0800d3));
                        s.startAnimation(ll.b(d));
                    }
                    w = true;
                    ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
                    L = true;
                } else
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f080028)))
                {
                    if (n != null)
                    {
                        n.setVisibility(0);
                        n.startAnimation(ll.b(d));
                    }
                } else
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f08002d)))
                {
                    if (r != null)
                    {
                        r.setVisibility(0);
                        r.startAnimation(ll.b(d));
                    }
                } else
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f08002a)))
                {
                    if (l != null)
                    {
                        l.setVisibility(0);
                        l.startAnimation(ll.b(d));
                    }
                } else
                {
                    if (s != null)
                    {
                        s.setVisibility(0);
                        s.setText(getString(0x7f0800d3));
                        s.setBackgroundColor(d.getResources().getColor(0x7f0b0002));
                        s.setTextColor(d.getResources().getColor(0x7f0b0063));
                        s.startAnimation(ll.b(d));
                    }
                    w = true;
                }
            } else
            if (obj1 != null && !((PriceBlock) (obj1)).getButtonState().isPurchasable())
            {
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f08002e)))
                {
                    if (o != null)
                    {
                        o.setVisibility(0);
                        A.setText(getString(0x7f0800d7));
                        o.startAnimation(ll.b(d));
                        o.setOnClickListener(this);
                    }
                    if (s != null)
                    {
                        s.setVisibility(8);
                    }
                } else
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f08002c)))
                {
                    if (o != null)
                    {
                        o.setVisibility(0);
                        A.setText(getString(0x7f0800d5));
                        o.startAnimation(ll.b(d));
                        o.setOnClickListener(this);
                    }
                    if (s != null)
                    {
                        s.setVisibility(8);
                    }
                } else
                if (((PriceBlock) (obj1)).getButtonState().getButtonStateID().equals(getString(0x7f08002b)))
                {
                    ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, true);
                    L = false;
                    if (o != null)
                    {
                        o.setVisibility(0);
                        A.setText(getString(0x7f0800d4));
                        o.startAnimation(ll.b(d));
                        o.setOnClickListener(this);
                    }
                    if (s != null)
                    {
                        s.setVisibility(8);
                    }
                } else
                {
                    if (s != null)
                    {
                        s.setVisibility(0);
                        s.setText(getString(0x7f0800d3));
                        s.setBackgroundColor(d.getResources().getColor(0x7f0b0002));
                        s.setTextColor(d.getResources().getColor(0x7f0b0063));
                        s.startAnimation(ll.b(d));
                    }
                    w = true;
                    ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
                    L = true;
                }
            } else
            {
                if (p != null)
                {
                    p.setVisibility(0);
                    p.startAnimation(ll.b(d));
                }
                if (o != null)
                {
                    o.setVisibility(8);
                }
            }
            if (obj1 != null && ((PriceBlock) (obj1)).getButtonState().isCommerceUnavailable() && m != null)
            {
                m.setVisibility(0);
                m.startAnimation(ll.b(d));
                m.setOnClickListener(this);
            }
        }
        as = getResources().getStringArray(0x7f0a0003);
        k1 = -1;
        j1 = 0;
        while (k1 < as.length) 
        {
            LinearLayout linearlayout;
            BBYBaseFragment bbybasefragment;
            if (k1 == -1)
            {
                obj1 = "EmptyFragment";
            } else
            {
                obj1 = as[k1];
            }
            if (!((String) (obj1)).equals("PDPBundledItemsFragment"));
            linearlayout = new LinearLayout(d);
            linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            linearlayout.setId(j1);
            linearlayout.setTag(obj1);
            bbybasefragment = kb.a(((String) (obj1)), S, ((OverviewResponse) (obj)), t, j);
            if (!j || !((String) (obj1)).equals("PDPOverviewFragment"))
            {
                if (((String) (obj1)).equals("PDPCustomerAlsoBoughtFragment") || ((String) (obj1)).equals("PDPCustomerAlsoViewedFragment"))
                {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isFromMdot", B);
                    bundle.putString("BreadCrumb", M);
                    bbybasefragment.setArguments(bundle);
                }
                if (((String) (obj1)).equals("PDPReviewAndRatingsFragment") || ((String) (obj1)).equals("PDPPriceBlockFragment"))
                {
                    Bundle bundle2 = bbybasefragment.getArguments();
                    Bundle bundle1 = bundle2;
                    if (bundle2 == null)
                    {
                        bundle1 = new Bundle();
                    }
                    bundle1.putBoolean("isFromMdot", B);
                    bundle1.putString("BreadCrumb", M);
                    bundle1.putSerializable("PDPOverviewResponseRoot", pdpoverviewresponseroot);
                    bbybasefragment.setArguments(bundle1);
                }
                if (((String) (obj1)).equals("PDPAvailabilityFragment"))
                {
                    obj1 = new Bundle();
                    ((Bundle) (obj1)).putInt("NumOfStores", D);
                    bbybasefragment.setArguments(((Bundle) (obj1)));
                }
                (new Handler()).post(new Runnable(linearlayout, bbybasefragment) {

                    final LinearLayout a;
                    final BBYBaseFragment b;
                    final PDPFragment c;

                    public void run()
                    {
                        c.getChildFragmentManager().beginTransaction().add(a.getId(), b).commitAllowingStateLoss();
                    }

            
            {
                c = PDPFragment.this;
                a = linearlayout;
                b = bbybasefragment;
                super();
            }
                });
                if (g != null)
                {
                    g.addView(linearlayout);
                }
            }
            k1++;
            j1++;
        }
        obj = getParentFragment();
        if (obj instanceof PDPFragmentContainer)
        {
            ((PDPFragmentContainer)obj).a(pdpoverviewresponseroot.getSi().getResponse().getOverview().getUrl());
        }
        R = M;
        return;
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(PDPOverviewResponseRoot pdpoverviewresponseroot, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("bb.prodView", "1");
        hashmap.put("&&products", (new StringBuilder()).append(";").append(T.getSkuId()).toString());
        hashmap.put(lu.bo, "browse,pdp");
        hashmap.put(lu.bp, "PDH");
        if (O)
        {
            hashmap.put("bb.recClick", "1");
            String s2;
            if (Q.equals("customeralsoviewed") || Q.equals("customeralsobought"))
            {
                hashmap.put("bb.recCode", (new StringBuilder()).append(P.getEp()).append(": ").append(N).append("pdp").toString());
            } else
            {
                hashmap.put("bb.recCode", (new StringBuilder()).append(P.getEp()).append(": ").append(Q).toString());
            }
        }
        if (T != null && T.getPriceBlock() != null && T.getPriceBlock().getPrice() != null && T.getPriceBlock().getPrice().getPricingType() != null)
        {
            s2 = T.getPriceBlock().getPrice().getPricingType();
            if (s2.equals("ICR-noPrice") || s2.equals("MAP"))
            {
                hashmap.put("bb.pdpImpression", "1");
            }
        }
        if (pdpoverviewresponseroot != null && pdpoverviewresponseroot.getSi() != null && pdpoverviewresponseroot.getSi().getResponse() != null && pdpoverviewresponseroot.getSi().getResponse().getDistilledReviewSummary() != null)
        {
            hashmap.put("bb.distilledReviewImp", "1");
            hashmap.put("bb.reviewsInteraction", "browse,pdp");
        }
        lu.b((new StringBuilder()).append(s1).append("pdp").toString(), hashmap);
    }

    public void a(String s1)
    {
        String s2;
label0:
        {
            z = (LinearLayout)a.findViewById(0x7f0c0082);
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
        ((BBYTextView)z.findViewById(0x7f0c0083)).setText(s2);
        ll.b(z);
    }

    public void a(ArrayList arraylist)
    {
        E.clear();
        int i1 = 0;
        while (i1 < arraylist.size()) 
        {
            RegistryWishList registrywishlist = (RegistryWishList)arraylist.get(i1);
            if (!registrywishlist.getType().equals("weddingregistrylists"))
            {
                E.add(registrywishlist);
            } else
            {
                F = registrywishlist;
            }
            i1++;
        }
        Collections.sort(E);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            H.setText("Item Added");
        } else
        {
            H.setText("Item cannot be Added");
        }
        G.setVisibility(0);
        ll.b(G);
    }

    public void a(boolean flag, BBYProduct bbyproduct, String s1, String s2)
    {
label0:
        {
            O = flag;
            P = bbyproduct;
            N = s2;
            if (s1 != null)
            {
                if (!s1.equals("customeralsobought"))
                {
                    break label0;
                }
                Q = "customeralsobought";
            }
            return;
        }
        if (s1.equals("customeralsoviewed"))
        {
            Q = "customeralsoviewed";
            return;
        }
        if (s1.equals("product"))
        {
            Q = "Products";
            return;
        }
        if (s1.equals("stores"))
        {
            Q = "Store Locator";
            return;
        }
        if (s1.equals("recentlyviewed"))
        {
            Q = "Best Buy";
            return;
        }
        if (s1.equals("GHP"))
        {
            Q = "Best Buy";
            return;
        }
        if (s1.equals("Checkout: Cart \u2013 Empty"))
        {
            Q = "Checkout: Cart \u2013 Empty";
            return;
        } else
        {
            Q = s1;
            return;
        }
    }

    public void b(boolean flag)
    {
        J = flag;
    }

    public void d()
    {
        ll.b(y);
        int i1 = nb.a().b().getInt("cartQuantity", 0);
        HashMap hashmap = new HashMap();
        if (i1 == 0)
        {
            hashmap.put("bb.scOpen", "1");
        }
        hashmap.put("bb.scAdd", "1");
        hashmap.put("&&products", (new StringBuilder()).append(";").append(T.getSkuId()).append(";;;;eVar7=PDH").toString());
        hashmap.put(lu.bp, "PDH");
        lu.b((new StringBuilder()).append(M).append("pdp").toString(), hashmap);
    }

    public void g()
    {
    }

    public void h()
    {
        U.setEnabled(true);
    }

    public void i()
    {
        U.setEnabled(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        if (activity != null)
        {
            BBYBaseFragmentActivity bbybasefragmentactivity = (BBYBaseFragmentActivity)activity;
            boolean flag;
            if (!L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bbybasefragmentactivity.changeActionBarAddToVisibility(activity, flag);
            ((HomeActivity)activity).setOnLifeEventsTopNavigationListener(this, "", false);
            ((HomeActivity)activity).changeOptionsVisibility(true);
        }
        nb.a().i(((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle());
        if (j())
        {
            K = (new qn(activity)).a(ahy.a).a(this).a(this).b();
            K.b();
        }
    }

    public void onClick(View view)
    {
        if (view != n && view != r) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        String s2;
        u.setVisibility(0);
        s2 = "";
        view = "";
        s1 = "";
        obj = view;
        if (T.getPriceBlock() == null) goto _L4; else goto _L3
_L3:
        if (T.getPriceBlock().getSellerInfo() != null)
        {
            view = T.getPriceBlock().getSellerInfo().getSellerId();
        }
        obj = view;
        if (T.getPriceBlock().getPrice() == null) goto _L4; else goto _L5
_L5:
        obj = T.getPriceBlock().getPrice().getListingId();
_L11:
        s1 = s2;
        if (X != null)
        {
            s1 = s2;
            if (!X.isEmpty())
            {
                s1 = X;
            }
        }
        (new in(d, this, i, T.getSkuId(), view, ((String) (obj)), s1, "")).execute(new Void[0]);
_L7:
        return;
_L2:
        if (view == s && w)
        {
            view = new android.app.AlertDialog.Builder(d);
            view.setMessage(Html.fromHtml("<font face = 'Sans-Serif'> <small>You will be redirected to BestBuy.com to complete your transaction. Do you want to continue?</small> </font>"));
            view.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'> <b>Yes</b> </font>"), new android.content.DialogInterface.OnClickListener() {

                final PDPFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://www.bestbuy.com").append(PDPFragment.a(a)).toString()));
                    a.startActivity(dialoginterface);
                }

            
            {
                a = PDPFragment.this;
                super();
            }
            });
            view.setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>No</font>"), new android.content.DialogInterface.OnClickListener() {

                final PDPFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.cancel();
                }

            
            {
                a = PDPFragment.this;
                super();
            }
            });
            view.create();
            view.show();
            return;
        }
        if (view != y)
        {
            break; /* Loop/switch isn't completed */
        }
        if (d instanceof HomeActivity)
        {
            view = ((HomeActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (view instanceof HomeTabFragment)
            {
                ((HomeTabFragment)view).a(3);
                return;
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (view == m)
        {
            a(getString(0x7f08009f));
            return;
        }
        if (view != l) goto _L7; else goto _L8
_L8:
        view = kb.a("ProductAvailabilityFragment", null, T, null, false);
        obj = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (obj instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)obj).e()).a(view, true);
        }
        if (!(obj instanceof PDPFragmentContainer) || !((PDPFragment)((PDPFragmentContainer)obj).b() instanceof PDPFragment)) goto _L7; else goto _L9
_L9:
        ((PDPFragmentContainer)obj).a(view, true);
        return;
_L4:
        view = ((View) (obj));
        obj = s1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(K, BBYBaseFragmentActivity.REQUEST, this);
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
            kf.b("PDPFragment", (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b("PDPFragment", (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null && bundle.containsKey("availability_storeid"))
        {
            X = bundle.getString("availability_storeid");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            a = layoutinflater.inflate(0x7f030090, viewgroup, false);
            U = (CustomSwipeToRefresh)a.findViewById(0x7f0c006e);
            U.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
            U.setOnRefreshListener(this);
            V = ChatRunningStatus.getChatRunning();
            if (!V)
            {
                h();
            } else
            {
                i();
            }
            h = (ScrollView)a.findViewById(0x7f0c0231);
            h.setVerticalScrollBarEnabled(false);
            h.setHorizontalScrollBarEnabled(false);
            g = (LinearLayout)a.findViewById(0x7f0c0232);
            i = a.findViewById(0x7f0c0064);
            if (j())
            {
                i.setVisibility(0);
            }
            o = (RelativeLayout)a.findViewById(0x7f0c0221);
            A = (BBYTextView)a.findViewById(0x7f0c0222);
            q = (RelativeLayout)a.findViewById(0x7f0c0237);
            p = (RelativeLayout)a.findViewById(0x7f0c0236);
            n = (RelativeLayout)a.findViewById(0x7f0c0233);
            s = (BBYTextView)a.findViewById(0x7f0c0239);
            r = (RelativeLayout)a.findViewById(0x7f0c0235);
            m = (RelativeLayout)a.findViewById(0x7f0c023a);
            l = (RelativeLayout)a.findViewById(0x7f0c0234);
            l.setOnClickListener(this);
            r.setOnClickListener(this);
            n.setOnClickListener(this);
            y = (LinearLayout)a.findViewById(0x7f0c0080);
            y.setOnClickListener(this);
            G = (LinearLayout)a.findViewById(0x7f0c0133);
            H = (BBYTextView)a.findViewById(0x7f0c0134);
            if (t != null)
            {
                boolean flag;
                if (t.getSkuTypeCode() != null && !t.getSkuTypeCode().equals(getString(0x7f080068)))
                {
                    if (t.getSkuTypeCode().equals(getString(0x7f08003a)))
                    {
                        flag = true;
                    } else
                    if (t.getSkuDisplayable() != null)
                    {
                        if (t.getSkuDisplayable().equals("1"))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    A.setText(getString(0x7f0800d5));
                    o.setVisibility(0);
                    o.startAnimation(ll.b(d));
                    o.setOnClickListener(this);
                } else
                {
                    o.setVisibility(8);
                    p.setVisibility(8);
                    n.setVisibility(0);
                    n.startAnimation(ll.b(d));
                    n.setOnClickListener(this);
                }
            }
            u = (FrameLayout)a.findViewById(0x7f0c0064);
            u.setBackgroundColor(0);
            if (!j())
            {
                k = new iw(d, b, X, this, i);
                k.executeOnExecutor(nb.h, new Void[0]);
            }
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        if (k != null)
        {
            k.cancel(true);
        }
        if (!J || !(getActivity() instanceof HomeActivity)) goto _L2; else goto _L1
_L1:
        Object obj;
        EmptyWeddingRegistryContainer emptyweddingregistrycontainer;
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(f.T());
        obj = ((HomeActivity)d).getSupportFragmentManager();
        emptyweddingregistrycontainer = (EmptyWeddingRegistryContainer)((FragmentManager) (obj)).findFragmentByTag("EmptyWeddingRegistryContainer");
        if (emptyweddingregistrycontainer == null) goto _L4; else goto _L3
_L3:
        obj = emptyweddingregistrycontainer.b();
        if (!(obj instanceof MyEmptyWeddingRegistryList)) goto _L6; else goto _L5
_L5:
        ((MyEmptyWeddingRegistryList)obj).c();
_L8:
        return;
_L6:
        if (obj instanceof WishListWithProductsFragment)
        {
            ((WishListWithProductsFragment)obj).f();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (f.C())
        {
            obj = (WishListFragmentContainer)((FragmentManager) (obj)).findFragmentByTag("WishListFragmentContainer");
            if (obj != null)
            {
                obj = ((WishListFragmentContainer) (obj)).b();
                if (obj != null && (obj instanceof MyEmptyWishListFragment))
                {
                    ((MyEmptyWishListFragment)obj).b();
                    return;
                }
                if (obj != null && (obj instanceof WishListWithProductsFragment))
                {
                    ((WishListWithProductsFragment)obj).f();
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!B && !J && !j)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(f.T());
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (y != null)
        {
            y.setVisibility(8);
        }
        if (z != null)
        {
            z.setVisibility(8);
        }
        if (K != null && K.d())
        {
            K.c();
        }
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            f.a(location.getLatitude());
            f.b(location.getLongitude());
            if (K.d())
            {
                ahy.b.a(K, this);
            }
        }
        k = new iw(d, b, X, this, i);
        k.executeOnExecutor(nb.h, new Void[0]);
    }

    public void onPause()
    {
        super.onPause();
        if (!j)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
        }
    }

    public void onRefresh()
    {
        i();
        (new Handler()).postDelayed(new Runnable() {

            final PDPFragment a;

            public void run()
            {
                PDPFragment.b(a).setRefreshing(false);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    intent.putExtra("fromPDPFragment", true);
                    HashMap hashmap = new HashMap();
                    hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PDPFragment.c(a)).append("pdp: Blue Assist").toString());
                    lu.b(lu.aT, hashmap);
                    a.startActivityForResult(intent, 8998);
                }
            }

            
            {
                a = PDPFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        V = ChatRunningStatus.getChatRunning();
        BBYBaseFragmentActivity bbybasefragmentactivity;
        Activity activity;
        boolean flag;
        if (!V)
        {
            h();
        } else
        {
            i();
        }
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        bbybasefragmentactivity = (BBYBaseFragmentActivity)d;
        activity = d;
        if (!L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bbybasefragmentactivity.changeActionBarAddToVisibility(activity, flag);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
        if (l())
        {
            k = new iw(d, b, X, this, i);
            k.executeOnExecutor(nb.h, new Void[0]);
        }
    }

}
