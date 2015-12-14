// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appboy.Appboy;
import com.picsart.studio.view.e;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.request.CheckoutShopItemParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.apiv3.util.PublicSyncInventory;
import com.socialin.android.billing.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.b;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cv.c;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.shop:
//            p, h, a, k, 
//            ShopRecyclerViewBaseAdapter, s, v, ShopItemActivity, 
//            c

public class o extends Fragment
{

    RecyclerView a;
    android.support.v7.widget.RecyclerView.OnScrollListener b;
    int c;
    boolean d;
    com.picsart.shop.s e;
    private k f;
    private d g;
    private p h;
    private String i;
    private String j;
    private TextView k;
    private View l;
    private View m;
    private ProgressBar n;
    private ProgressDialog o;
    private int p;
    private boolean q;
    private BaseSocialinApiRequestController r;
    private List s;
    private boolean t;
    private myobfuscated.cp.c u;
    private View v;
    private int w;
    private int x;
    private FrameLayout y;
    private boolean z;

    public o()
    {
        a = null;
        f = null;
        g = null;
        b = null;
        h = new p(this, (byte)0);
        i = "all";
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = 0;
        q = true;
        r = RequestControllerFactory.createCheckoutShopItemsController();
        new ArrayList();
        s = new ArrayList();
        t = false;
        u = null;
        c = 0;
        v = null;
        w = 0;
        x = 1;
        d = false;
        y = null;
        e = null;
        z = false;
        setRetainInstance(true);
    }

    static int a(o o1)
    {
        return o1.w;
    }

    static List a(o o1, List list)
    {
        o1.s = list;
        return list;
    }

    static void a(o o1, com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        o1.d = true;
        shopitem.hidden = false;
        Inventory.addShopItem(shopitem.toJson());
        if (shopitem.data.shopItemUid.equals("ad_remover")) goto _L2; else goto _L1
_L1:
        FragmentActivity fragmentactivity = o1.getActivity();
        if (fragmentactivity == null) goto _L4; else goto _L3
_L3:
        boolean flag = fragmentactivity.isFinishing();
        if (!flag) goto _L5; else goto _L4
_L4:
        shopitem = o1.getActivity();
        if (shopitem == null || shopitem.isFinishing() || !(shopitem instanceof AppCompatActivity)) goto _L7; else goto _L6
_L6:
        shopitem = ((AppCompatActivity)shopitem).getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
        if (shopitem == null || !(shopitem instanceof h)) goto _L9; else goto _L8
_L8:
        ((h)shopitem).a(false);
_L7:
        return;
_L5:
        Appboy appboy;
        String s2;
        ProgressDialog progressdialog = new ProgressDialog(fragmentactivity);
        progressdialog.setMessage(fragmentactivity.getString(0x7f08041c));
        progressdialog.setIndeterminate(false);
        progressdialog.setMax(100);
        progressdialog.setProgressStyle(1);
        progressdialog.show();
        o1.u = o1. new myobfuscated.cp.c(progressdialog) {

            private ProgressDialog a;
            private o b;

            public final void a()
            {
                try
                {
                    a.dismiss();
                    b.a();
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

            public final void a(int i1)
            {
                a.setProgress(i1);
            }

            
            {
                b = o.this;
                a = progressdialog;
                super();
            }
        };
        appboy = Appboy.getInstance(fragmentactivity);
        s2 = shopitem.data.shopItemUid;
        if (shopitem.data.price <= 0 || TextUtils.isEmpty(shopitem.data.priceString)) goto _L11; else goto _L10
_L10:
        String s1 = com.picsart.shop.a.c(shopitem.data.priceString);
_L17:
        if (shopitem.data.price <= 0)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        if (!TextUtils.isEmpty(shopitem.data.priceString)) goto _L13; else goto _L12
_L12:
        double d1 = shopitem.data.price;
_L14:
        appboy.logPurchase(s2, s1, new BigDecimal(d1), 1);
        com.picsart.shop.a.a(fragmentactivity).a(fragmentactivity, shopitem.data.shopItemUid, shopitem.data.shopItemUid, o1.u);
          goto _L4
_L13:
        d1 = com.picsart.shop.a.b(shopitem.data.priceString);
          goto _L14
_L2:
        shopitem = o1.getActivity();
        if (shopitem == null) goto _L7; else goto _L15
_L15:
        if (shopitem.isFinishing()) goto _L7; else goto _L16
_L16:
        if (shopitem.getString(0x7f0808c8).equals(shopitem.getString(0x7f0808ce)))
        {
            PublicSyncInventory.setAdsState(true);
        }
          goto _L4
_L9:
        o1.a();
        return;
        shopitem;
          goto _L4
_L11:
        s1 = "$";
          goto _L17
        d1 = 0.0D;
          goto _L14
    }

    static void a(o o1, com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem, String s1)
    {
        CheckoutShopItemParams checkoutshopitemparams;
        try
        {
            o1.o.show();
        }
        catch (Exception exception) { }
        checkoutshopitemparams = new CheckoutShopItemParams();
        checkoutshopitemparams.shopItemId = shopitem.id;
        checkoutshopitemparams.amount = "0";
        checkoutshopitemparams.data = s1;
        o1.d = true;
        if (o1.t && shopitem.data.price > 0)
        {
            PublicSyncInventory.removeShopItem(shopitem);
            PublicSyncInventory.writeShopItem(shopitem);
        }
        if (o1.r != null)
        {
            o1.r.setRequestCompleteListener(null);
        }
        o1.r = RequestControllerFactory.createCheckoutShopItemsController();
        o1.r.setRequestCompleteListener(o1. new com.socialin.asyncnet.d(shopitem) {

            private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem a;
            private o b;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception1, Request request)
            {
                exception1.printStackTrace();
                try
                {
                    o.n(b).dismiss();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception1)
                {
                    return;
                }
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                FragmentActivity fragmentactivity = b.getActivity();
                if (fragmentactivity != null && !fragmentactivity.isFinishing())
                {
                    if (a.data != null && a.data.price > 0)
                    {
                        AnalyticUtils.getInstance(b.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ShopPackagePurchaseEvent(a.data.shopItemUid)).setPrice(a.data.price).setBrand("PicsArt"));
                        if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
                        {
                            com.socialin.android.util.b.a(b.getActivity()).b("Paid Packages Downloaded", 1);
                        }
                        if (a.data != null && "swyftmedia".equals(a.data.provider))
                        {
                            if (a.data.price > 0)
                            {
                                if (TextUtils.isEmpty(a.data.priceString))
                                {
                                    obj = a.getPrice();
                                } else
                                {
                                    obj = String.valueOf(com.picsart.shop.a.b(a.data.priceString));
                                }
                            } else
                            {
                                obj = "0";
                            }
                            if (a.data.price > 0 && !TextUtils.isEmpty(a.data.priceString))
                            {
                                request = String.valueOf(com.picsart.shop.a.c(a.data.priceString));
                            } else
                            {
                                request = "USD";
                            }
                            SwyftAnalytics.getInstance().createTrackEvent("shop_package_purchase").addParam("serials", (new SwyftSerials(a.data.brand, a.data.content, "")).toJSON().toString()).addParam("price", ((String) (obj))).addParam("currency", request).track();
                        }
                    }
                    obj = ((AppCompatActivity)fragmentactivity).getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
                    if (obj != null && (obj instanceof h))
                    {
                        ((h)obj).a(false);
                    } else
                    {
                        b.a();
                    }
                }
                o.a(b, a);
                o.n(b).dismiss();
            }

            
            {
                b = o.this;
                a = shopitem;
                super();
            }
        });
        o1.r.doRequest("tag", checkoutshopitemparams);
    }

    static void a(o o1, String s1, String s2, int i1)
    {
        o1.a(s1, s2, i1);
    }

    private void a(String s1, String s2, int i1)
    {
        if (i1 > 0)
        {
            v.setVisibility(0);
        }
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            b(s1, s2, i1);
            return;
        } else
        {
            g.getPurchasedItems(new myobfuscated.bp.b(s1, s2, i1) {

                private String a;
                private String b;
                private int c;
                private o d;

                public final void a()
                {
                    o.o(d).setVisibility(8);
                }

                public final void a(List list)
                {
                    o.a(d, list);
                    com.picsart.shop.o.b(d, a, b, c);
                }

            
            {
                d = o.this;
                a = s1;
                b = s2;
                c = i1;
                super();
            }
            });
            return;
        }
    }

    static boolean a(o o1, boolean flag)
    {
        o1.z = flag;
        return flag;
    }

    private int b()
    {
        FragmentActivity fragmentactivity;
        if (!q && w != 0)
        {
            if ((fragmentactivity = getActivity()) != null && !fragmentactivity.isFinishing())
            {
                int k1 = (int)Utils.b(fragmentactivity);
                float f1;
                int i1;
                int l1;
                int j2;
                if (l.getVisibility() == 0)
                {
                    i1 = l.getMeasuredHeight();
                } else
                {
                    i1 = 0;
                }
                k1 -= i1;
                if (f == null)
                {
                    f1 = 0.0F;
                } else
                {
                    int i2 = f.getItemCount() / x;
                    int j1;
                    if (f.getItemCount() % x > 0)
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    f1 = (float)(j1 + i2) * Utils.a(110F, fragmentactivity);
                }
                i1 = (int)f1;
                l1 = (int)getResources().getDimension(0x7f0b0011);
                j2 = (int)Utils.a(48F, fragmentactivity);
                if (i1 <= k1)
                {
                    return k1 - j2 - i1 - l1;
                }
            }
        }
        return 0;
    }

    static TextView b(o o1)
    {
        return o1.k;
    }

    static void b(o o1, String s1, String s2, int i1)
    {
        o1.b(s1, s2, i1);
    }

    private void b(String s1, String s2, int i1)
    {
        if (s == null)
        {
            s = new ArrayList();
        }
        Object obj = getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        if (f.c())
        {
            n.setVisibility(0);
        }
        y.setVisibility(8);
        if (com.socialin.android.util.s.a(((android.content.Context) (obj))) || f.getItemCount() > 0)
        {
            g.requestShopItemsForTypeAndTag(false, s1, s2, new myobfuscated.bp.c(i1) {

                private int a;
                private o b;

                public final void a(ArrayList arraylist)
                {
                    FragmentActivity fragmentactivity = b.getActivity();
                    if (fragmentactivity == null || fragmentactivity.isFinishing())
                    {
                        return;
                    }
                    if (o.p(b))
                    {
                        o.a(b, false);
                        if (o.q(b) != null)
                        {
                            o.q(b).a();
                        }
                    }
                    if (arraylist.size() < 20)
                    {
                        o.r(b);
                        if (com.picsart.shop.o.s(b) != null)
                        {
                            com.picsart.shop.o.s(b).b = o.t(b);
                        }
                    }
                    if (arraylist.size() == 0 && a == 0)
                    {
                        com.picsart.shop.o.b(b).setVisibility(0);
                        com.picsart.shop.o.b(b).setText(b.getString(0x7f0805bd));
                    }
                    o.o(b).setVisibility(8);
                    com.picsart.shop.a.a(fragmentactivity).a(arraylist);
                    arraylist = arraylist.iterator();
                    do
                    {
                        if (!arraylist.hasNext())
                        {
                            break;
                        }
                        com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
                        if (shopitem.isVisible && !com.picsart.shop.o.d(b).a(shopitem))
                        {
                            com.picsart.shop.o.d(b).b(shopitem);
                        }
                    } while (true);
                    o.u(b).setVisibility(8);
                }

            
            {
                b = o.this;
                a = i1;
                super();
            }
            }, i1);
        } else
        {
            obj = ((Activity) (obj)).getLayoutInflater().inflate(0x7f03020b, null, false);
            ((View) (obj)).findViewById(0x7f100979).setOnClickListener(new android.view.View.OnClickListener(s1, s2, i1) {

                private String a;
                private String b;
                private int c;
                private o d;

                public final void onClick(View view)
                {
                    o.a(d, true);
                    com.picsart.shop.o.b(d, a, b, c);
                }

            
            {
                d = o.this;
                a = s1;
                b = s2;
                c = i1;
                super();
            }
            });
            y.setVisibility(0);
            y.removeAllViews();
            y.addView(((View) (obj)));
            n.setVisibility(8);
        }
        h.b = b();
    }

    static RecyclerView c(o o1)
    {
        return o1.a;
    }

    private void c()
    {
        Object obj = getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        obj = com.picsart.shop.a.a(((android.content.Context) (obj))).b().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((Iterator) (obj)).next();
            if (shopitem.owned && shopitem.isVisible && !f.a(shopitem))
            {
                f.b(shopitem);
            }
        } while (true);
        n.setVisibility(8);
        if (SocialinV3.getInstance().isRegistered())
        {
            l.setVisibility(8);
        } else
        {
            l.setVisibility(0);
            m.setOnClickListener(new android.view.View.OnClickListener() {

                private o a;

                public final void onClick(View view)
                {
                    if (!SocialinV3.getInstance().isRegistered())
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent("shop", "installed_tab_login_button"));
                    }
                    o.f(a);
                }

            
            {
                a = o.this;
                super();
            }
            });
        }
        if (f.getItemCount() > 0)
        {
            k.setVisibility(8);
        } else
        {
            k.setVisibility(0);
        }
        q = false;
        f.notifyDataSetChanged();
    }

    static k d(o o1)
    {
        return o1.f;
    }

    static android.support.v7.widget.RecyclerView.OnScrollListener e(o o1)
    {
        return o1.b;
    }

    static void f(o o1)
    {
        FragmentActivity fragmentactivity = o1.getActivity();
        if (fragmentactivity != null && !fragmentactivity.isFinishing())
        {
            Intent intent = new Intent();
            myobfuscated.cv.c.a(intent, fragmentactivity);
            intent.setClassName(fragmentactivity.getPackageName(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity.getName());
            intent.setFlags(0x20000);
            intent.putExtra("from", "shop");
            o1.startActivityForResult(intent, 10001);
        }
    }

    static d g(o o1)
    {
        return o1.g;
    }

    static boolean h(o o1)
    {
        return o1.t;
    }

    static boolean i(o o1)
    {
        return o1.q;
    }

    static String j(o o1)
    {
        return o1.i;
    }

    static int k(o o1)
    {
        int i1 = o1.p;
        o1.p = i1 + 1;
        return i1;
    }

    static String l(o o1)
    {
        return o1.j;
    }

    static int m(o o1)
    {
        return o1.p;
    }

    static ProgressDialog n(o o1)
    {
        return o1.o;
    }

    static View o(o o1)
    {
        return o1.v;
    }

    static boolean p(o o1)
    {
        return o1.z;
    }

    static com.picsart.shop.s q(o o1)
    {
        return o1.e;
    }

    static boolean r(o o1)
    {
        o1.q = false;
        return false;
    }

    static p s(o o1)
    {
        return o1.h;
    }

    static int t(o o1)
    {
        return o1.b();
    }

    static ProgressBar u(o o1)
    {
        return o1.n;
    }

    static int v(o o1)
    {
        return o1.x;
    }

    public final void a()
    {
        FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity != null)
        {
            com.picsart.shop.a.a(fragmentactivity).a(f.b());
        }
        if (f != null && "installed".equals(i))
        {
            q = true;
            f.a();
            n.setVisibility(0);
            p = 0;
            c();
        } else
        if (f != null)
        {
            f.notifyDataSetChanged();
            return;
        }
    }

    public final void a(int i1)
    {
        int j1 = i1 - c;
        c = i1;
        if (n != null)
        {
            n.setTranslationY((w - i1) / 2);
        }
        if (j1 != 0 && a != null && a.getLayoutManager() != null)
        {
            a.post(new Runnable(i1, j1) {

                private int a;
                private int b;
                private o c;

                public final void run()
                {
                    com.picsart.shop.o.c(c).setOnScrollListener(null);
                    if (com.picsart.shop.o.d(c) != null && com.picsart.shop.o.d(c).getItemCount() > 0)
                    {
                        if (a == 0)
                        {
                            com.picsart.shop.o.c(c).scrollToPosition(0);
                        } else
                        {
                            com.picsart.shop.o.c(c).scrollBy(0, -b);
                        }
                    }
                    com.picsart.shop.o.c(c).setOnScrollListener(com.picsart.shop.o.e(c));
                }

            
            {
                c = o.this;
                a = i1;
                b = j1;
                super();
            }
            });
        }
    }

    public final void a(int i1, boolean flag)
    {
        w = i1;
        h.a = i1;
        h.b = b();
        if (flag)
        {
            a.removeItemDecoration(h);
            a.addItemDecoration(h);
            a.scrollToPosition(0);
        } else
        {
            if (n != null)
            {
                n.setTranslationY(i1 / 2);
            }
            if (k != null)
            {
                k.post(new Runnable() {

                    private o a;

                    public final void run()
                    {
                        FragmentActivity fragmentactivity = a.getActivity();
                        TextView textview = com.picsart.shop.o.b(a);
                        float f2 = o.a(a) / 2;
                        float f1;
                        if (SocialinV3.getInstance().isRegistered() && fragmentactivity != null && !fragmentactivity.isFinishing())
                        {
                            f1 = 0.0F;
                        } else
                        {
                            f1 = Utils.a(24F, fragmentactivity);
                        }
                        textview.setTranslationY(f2 - f1);
                    }

            
            {
                a = o.this;
                super();
            }
                });
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle != null)
        {
            i = bundle.getString("price");
            j = bundle.getString("tag");
        }
        x = getResources().getInteger(0x7f0e0007);
        p = 0;
        bundle = getActivity();
        a(0);
        f = new k(bundle);
        f.a(new v(bundle) {

            private Activity a;
            private o b;

            public final transient void a(int i1)
            {
                if (a == null || a.isFinishing())
                {
                    return;
                } else
                {
                    Intent intent = new Intent(a, com/picsart/shop/ShopItemActivity);
                    intent.putExtra("selectedShopItem", (Parcelable)com.picsart.shop.o.d(b).b(i1));
                    b.startActivityForResult(intent, 100);
                    return;
                }
            }

            
            {
                b = o.this;
                a = activity;
                super();
            }
        });
        q = true;
        f.a = new com.picsart.shop.c() {

            final o a;

            public final void a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
            {
                FragmentActivity fragmentactivity = a.getActivity();
                if (fragmentactivity == null || fragmentactivity.isFinishing())
                {
                    return;
                }
                if (!SocialinV3.getInstance().isRegistered() && (!fragmentactivity.getString(0x7f0808c8).equals(fragmentactivity.getString(0x7f0808ce)) || shopitem.data.price == 0 || shopitem.promoted))
                {
                    o.f(a);
                    return;
                }
                if (shopitem.owned)
                {
                    o.a(a, shopitem);
                    return;
                }
                if (shopitem.data.price > 0 && !shopitem.promoted)
                {
                    if (!com.picsart.shop.o.g(a).isBillingSupported())
                    {
                        Utils.a(fragmentactivity, 0x7f080438);
                        return;
                    }
                    try
                    {
                        com.picsart.shop.o.g(a).requestPurchase(fragmentactivity, shopitem.data.name, shopitem.data.shopItemUid, "inapp", com.picsart.shop.a.b(shopitem.getPrice()), new myobfuscated.bp.d(this, shopitem) {

                            private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem a;
                            private _cls8 b;

                            public final void a(boolean flag, String s1, JSONObject jsonobject)
                            {
                                if (flag)
                                {
                                    if (o.h(b.a))
                                    {
                                        PublicSyncInventory.writeShopItem(a);
                                    }
                                    o.a(b.a, a, jsonobject.toString());
                                }
                            }

            
            {
                b = _pcls8;
                a = shopitem;
                super();
            }
                        });
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
                    {
                        Utils.a(fragmentactivity, 0x7f080438);
                    }
                    return;
                }
                if (!shopitem.owned)
                {
                    if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
                    {
                        com.socialin.android.util.b.a(a.getActivity()).b("Free Packages Downloaded", 1);
                    }
                    if (shopitem.data != null && "swyftmedia".equals(shopitem.data.provider))
                    {
                        String s1;
                        String s2;
                        if (shopitem.data.price > 0)
                        {
                            if (TextUtils.isEmpty(shopitem.data.priceString))
                            {
                                s1 = shopitem.getPrice();
                            } else
                            {
                                s1 = String.valueOf(com.picsart.shop.a.b(shopitem.data.priceString));
                            }
                        } else
                        {
                            s1 = "0";
                        }
                        if (shopitem.data.price > 0 && !TextUtils.isEmpty(shopitem.data.priceString))
                        {
                            s2 = String.valueOf(com.picsart.shop.a.c(shopitem.data.priceString));
                        } else
                        {
                            s2 = "USD";
                        }
                        SwyftAnalytics.getInstance().createTrackEvent("shop_package_purchase").addParam("serials", (new SwyftSerials(shopitem.data.brand, shopitem.data.content, "")).toJSON().toString()).addParam("price", s1).addParam("currency", s2).track();
                    }
                }
                o.a(a, shopitem, "");
            }

            
            {
                a = o.this;
                super();
            }
        };
        a.addItemDecoration(h);
        f.d = new e() {

            private o a;

            public final void a()
            {
                if (o.i(a) && !"installed".equals(o.j(a)))
                {
                    o.k(a);
                    o.a(a, o.l(a), o.j(a), com.picsart.shop.o.m(a));
                }
            }

            
            {
                a = o.this;
                super();
            }
        };
        bundle = new GridLayoutManager(getActivity(), x);
        a.setLayoutManager(bundle);
        a.setAdapter(f);
        if (b != null)
        {
            a.setOnScrollListener(b);
        }
        t = getString(0x7f0808c8).equals(getString(0x7f0808ce));
        o = new g(getActivity());
        if (w > 0)
        {
            h.b = b();
            if (n != null)
            {
                n.setTranslationY(w / 2);
            }
        }
        if ("installed".equals(i))
        {
            c();
            return;
        } else
        {
            a(j, i, 0);
            return;
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (intent != null)
        {
            FragmentActivity fragmentactivity = getActivity();
            if (fragmentactivity != null && !fragmentactivity.isFinishing() && i1 == 100)
            {
                d = intent.getBooleanExtra("needUpdate", false);
                if (d)
                {
                    intent = (h)getActivity().getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
                    if (intent != null)
                    {
                        intent.a(false);
                    } else
                    {
                        a();
                    }
                }
            }
        }
        if (i1 == 101)
        {
            a();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = myobfuscated.f.m.a(getActivity(), getString(0x7f0808be));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301d8, viewgroup, false);
        a = (RecyclerView)layoutinflater.findViewById(0x7f100886);
        m = layoutinflater.findViewById(0x7f10088a);
        k = (TextView)layoutinflater.findViewById(0x7f100888);
        l = layoutinflater.findViewById(0x7f100887);
        n = (ProgressBar)layoutinflater.findViewById(0x7f1003fd);
        v = layoutinflater.findViewById(0x7f10088b);
        if (k != null)
        {
            k.post(new Runnable() {

                private o a;

                public final void run()
                {
                    FragmentActivity fragmentactivity = a.getActivity();
                    TextView textview = com.picsart.shop.o.b(a);
                    float f2 = o.a(a) / 2;
                    float f1;
                    if (SocialinV3.getInstance().isRegistered() && fragmentactivity != null && !fragmentactivity.isFinishing())
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = Utils.a(24F, fragmentactivity);
                    }
                    textview.setTranslationY(f2 - f1);
                }

            
            {
                a = o.this;
                super();
            }
            });
        }
        y = (FrameLayout)layoutinflater.findViewById(0x7f100889);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if ("installed".equals(i) && f != null && f.getItemCount() != 0)
        {
            Iterator iterator = f.b().iterator();
            boolean flag = false;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next()).installed)
                {
                    flag = true;
                }
            } while (true);
            if (flag)
            {
                FragmentActivity fragmentactivity = getActivity();
                if (fragmentactivity != null && !fragmentactivity.isFinishing())
                {
                    h h1 = (h)getActivity().getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
                    if (h1 != null)
                    {
                        h1.a(false);
                        return;
                    } else
                    {
                        a();
                        return;
                    }
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("price", i);
        bundle.putString("tag", j);
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
    }
}
