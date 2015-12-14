// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.Appboy;
import com.bumptech.glide.b;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.view.FlowLayout;
import com.socialin.android.apiv3.PicsartAnalytics;
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
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.LoginFragmentActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import myobfuscated.bp.a;
import myobfuscated.cv.c;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.shop:
//            n, a, t, ShopItemActivity, 
//            ShopItemsListActivity

public class m extends Fragment
{

    private static final String c = com/picsart/shop/m.getSimpleName();
    private int A;
    private View B;
    private com.picsart.studio.d C;
    private String D;
    private ImageView E;
    boolean a;
    public myobfuscated.cb.c b;
    private RecyclerView d;
    private n e;
    private View f;
    private int g;
    private ImageView h;
    private com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem i;
    private t j;
    private GridLayoutManager k;
    private TextView l;
    private TextView m;
    private TextView n;
    private FlowLayout o;
    private View p;
    private int q;
    private int r;
    private g s;
    private BaseSocialinApiRequestController t;
    private myobfuscated.cp.c u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;
    private android.view.View.OnClickListener x;
    private com.socialin.android.billing.d y;
    private boolean z;

    public m()
    {
        d = null;
        f = null;
        g = 0;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = 2;
        r = 0;
        s = null;
        t = RequestControllerFactory.createCheckoutShopItemsController();
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        a = false;
        z = false;
        A = 0;
        B = null;
        D = "";
        E = null;
        b = null;
        e = new n();
    }

    static int a(m m1, int i1)
    {
        i1 = m1.g - i1;
        m1.g = i1;
        return i1;
    }

    static String a()
    {
        return c;
    }

    private void a(Activity activity)
    {
        s = new g(activity);
        s.setMessage(getString(0x7f080450));
    }

    static void a(m m1)
    {
        Intent intent = new Intent();
        myobfuscated.cv.c.a(intent, m1.getActivity());
        intent.setClassName(m1.getActivity().getPackageName(), com/socialin/android/picsart/profile/activity/LoginFragmentActivity.getName());
        intent.setFlags(0x20000);
        intent.putExtra("from", "shop");
        m1.getActivity().startActivityForResult(intent, 201);
    }

    static void a(m m1, String s1)
    {
        Object obj;
        try
        {
            m1.a(m1.getActivity());
            m1.s.show();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
        }
        obj = new CheckoutShopItemParams();
        obj.shopItemId = m1.i.id;
        obj.amount = "0";
        obj.data = s1;
        if (m1.z && m1.i.data.price > 0 && !m1.i.owned)
        {
            PublicSyncInventory.removeShopItem(m1.i);
            PublicSyncInventory.writeShopItem(m1.i);
        }
        m1.a = true;
        s1 = m1.getActivity();
        if (s1 == null || s1.isFinishing())
        {
            return;
        } else
        {
            int i1 = m1.i.data.price;
            m1.t.setRequestCompleteListener(null);
            m1.t = RequestControllerFactory.createCheckoutShopItemsController();
            m1.t.setRequestCompleteListener(m1. new com.socialin.asyncnet.d() {

                private m a;

                public final volatile void onCancelRequest(Object obj1, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    exception.printStackTrace();
                    try
                    {
                        if (m.p(a).isShowing())
                        {
                            m.p(a).dismiss();
                        }
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Exception exception)
                    {
                        com.socialin.android.d.b(com.picsart.shop.m.a(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                        });
                    }
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj1, Request request)
                {
                    com.picsart.shop.m.c(a).hidden = false;
                    Inventory.addShopItem(com.picsart.shop.m.c(a).toJson());
                    if (com.picsart.shop.m.c(a).data.shopItemUid.equals("ad_remover")) goto _L2; else goto _L1
_L1:
                    com.picsart.shop.m.b(a, "");
_L6:
                    obj1 = a.getActivity();
                    if (obj1 == null) goto _L4; else goto _L3
_L3:
                    if (((Activity) (obj1)).isFinishing())
                    {
                        return;
                    }
                      goto _L5
_L2:
                    if (a.getString(0x7f0808c8).equals(a.getString(0x7f0808ce)))
                    {
                        PublicSyncInventory.setAdsState(true);
                    }
                    m.n(a);
                      goto _L6
_L7:
                    if (m.p(a) != null && m.p(a).isShowing())
                    {
                        try
                        {
                            m.p(a).dismiss();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            return;
                        }
                    }
                    break; /* Loop/switch isn't completed */
_L5:
                    try
                    {
                        m.o(a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        com.socialin.android.d.b(com.picsart.shop.m.a(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(((JSONException) (obj1)).getMessage()).toString()
                        });
                    }
                    if (true) goto _L7; else goto _L4
_L4:
                }

            
            {
                a = m.this;
                super();
            }
            });
            m1.t.doRequest("tag", ((com.socialin.android.apiv3.request.RequestParams) (obj)));
            return;
        }
    }

    static int b(m m1, int i1)
    {
        m1.r = i1;
        return i1;
    }

    static com.socialin.android.billing.d b(m m1)
    {
        return m1.y;
    }

    static void b(m m1, String s1)
    {
        Object obj = new ProgressDialog(m1.getActivity());
        ((ProgressDialog) (obj)).setMessage(m1.getString(0x7f08041c));
        ((ProgressDialog) (obj)).setIndeterminate(false);
        ((ProgressDialog) (obj)).setMax(100);
        ((ProgressDialog) (obj)).setProgressStyle(1);
        ((ProgressDialog) (obj)).show();
        m1.u = m1. new myobfuscated.cp.c(((ProgressDialog) (obj)), s1) {

            private ProgressDialog a;
            private String b;
            private m c;

            public final void a()
            {
                try
                {
                    a.dismiss();
                }
                catch (Exception exception) { }
                if (com.picsart.shop.m.c(c).data.price > 0 && !com.picsart.shop.m.c(c).owned && b != null && b.length() > 0)
                {
                    Utils.c(c.getActivity(), b);
                }
                m.n(c);
            }

            public final void a(int i1)
            {
                a.setProgress(i1);
            }

            
            {
                c = m.this;
                a = progressdialog;
                b = s1;
                super();
            }
        };
        obj = m1.getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing())
        {
            com.picsart.shop.a.a(((android.content.Context) (obj))).a(m1.getActivity(), m1.i.data.shopItemUid, m1.i.data.shopItemUid, m1.b, m1.u);
            Appboy appboy = Appboy.getInstance(((android.content.Context) (obj)));
            String s2 = m1.i.data.shopItemUid;
            double d1;
            if (m1.i.data.price > 0 && !TextUtils.isEmpty(m1.i.data.priceString))
            {
                s1 = com.picsart.shop.a.c(m1.i.data.priceString);
            } else
            {
                s1 = "$";
            }
            if (m1.i.data.price > 0)
            {
                if (TextUtils.isEmpty(m1.i.data.priceString))
                {
                    d1 = m1.i.data.price;
                } else
                {
                    d1 = com.picsart.shop.a.b(m1.i.data.priceString);
                }
            } else
            {
                d1 = 0.0D;
            }
            appboy.logPurchase(s2, s1, new BigDecimal(d1), 1);
            com.picsart.shop.a.a(((android.content.Context) (obj))).a(((android.content.Context) (obj)), m1.i.data.shopItemUid, m1.i.data.shopItemUid, m1.u);
        }
    }

    public static boolean b()
    {
        return false;
    }

    static com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem c(m m1)
    {
        return m1.i;
    }

    private void c()
    {
        if (i == null)
        {
            com.socialin.android.d.b("Shop item is null");
        } else
        {
            if (i.owned)
            {
                if (i.installed)
                {
                    d();
                    return;
                } else
                {
                    e();
                    return;
                }
            }
            if (i.data.price > 0)
            {
                if (i != null && i.data.price > 0 && !i.owned)
                {
                    n.setText((new StringBuilder("$")).append(i.getPrice()).toString());
                    y.getShopItemPrice(getActivity(), i, new a(this));
                }
                Object obj;
                if (TextUtils.isEmpty(i.data.priceString))
                {
                    obj = (new StringBuilder("$")).append(i.getPrice()).toString();
                } else
                {
                    obj = i.data.priceString;
                }
                n.setText(((CharSequence) (obj)));
                obj = getActivity();
                if (obj != null && !((Activity) (obj)).isFinishing())
                {
                    Utils.f(((android.content.Context) (obj)));
                    if (i.promoted)
                    {
                        p.setOnClickListener(w);
                        n.setPaintFlags(n.getPaintFlags() | 0x10);
                        return;
                    } else
                    {
                        p.setOnClickListener(v);
                        n.setPaintFlags(n.getPaintFlags() & 0xffffffef);
                        return;
                    }
                }
            } else
            {
                n.setText(getString(0x7f080299));
                p.setOnClickListener(w);
                n.setPaintFlags(n.getPaintFlags() & 0xffffffef);
                return;
            }
        }
    }

    private void d()
    {
        if (i.data.shopItemUid.equals("ad_remover"))
        {
            p.setVisibility(8);
            return;
        } else
        {
            n.setText(0x7f080363);
            p.setOnClickListener(x);
            n.setPaintFlags(n.getPaintFlags() & 0xffffffef);
            return;
        }
    }

    static boolean d(m m1)
    {
        m1.a = true;
        return true;
    }

    private void e()
    {
        n.setText(0x7f0802e3);
        p.setOnClickListener(w);
        n.setPaintFlags(n.getPaintFlags() & 0xffffffef);
    }

    static void e(m m1)
    {
        m1.e();
    }

    static int f(m m1)
    {
        return m1.g;
    }

    static ImageView g(m m1)
    {
        return m1.h;
    }

    static View h(m m1)
    {
        return m1.f;
    }

    static int i(m m1)
    {
        return m1.r;
    }

    static String j(m m1)
    {
        return m1.D;
    }

    static int k(m m1)
    {
        return m1.A;
    }

    static n l(m m1)
    {
        return m1.e;
    }

    static RecyclerView m(m m1)
    {
        return m1.d;
    }

    static void n(m m1)
    {
        m1 = m1.getActivity();
        if (m1 != null && !m1.isFinishing())
        {
            m1.getContentResolver().notifyChange(com.picsart.shop.a.e, null);
        }
    }

    static void o(m m1)
    {
        m1.d();
    }

    static g p(m m1)
    {
        return m1.s;
    }

    public static TextView q(m m1)
    {
        return m1.n;
    }

    public final void a(com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem)
    {
        Activity activity;
        activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ShopPackageOpenEvent(shopitem.data.shopItemUid, D, getResources().getConfiguration().locale.getCountry()));
        if ("swyftmedia".equals(shopitem.data.provider))
        {
            SwyftSerials swyftserials = new SwyftSerials(shopitem.data.brand, shopitem.data.content, "");
            SwyftAnalytics.getInstance().createTrackEvent("shop_package_open").addParam("serials", swyftserials.toJSON().toString()).track();
        }
        i = shopitem;
        getView().setBackgroundColor(Color.parseColor(shopitem.data.previewColor));
        q = getResources().getInteger(0x7f0e000a);
        if (!"x-large".equalsIgnoreCase(shopitem.data.previewSize)) goto _L2; else goto _L1
_L1:
        q = getResources().getInteger(0x7f0e000b);
_L4:
        k.setSpanCount(q);
        o.removeAllViews();
        if (shopitem.tags != null)
        {
            new com.picsart.studio.view.d(-2, -2);
            LayoutInflater layoutinflater = activity.getLayoutInflater();
            for (int i1 = 0; i1 < shopitem.tags.length; i1++)
            {
                if (!TextUtils.isEmpty(shopitem.tags[i1]))
                {
                    View view = layoutinflater.inflate(0x7f0301d7, null);
                    TextView textview = (TextView)view.findViewById(0x7f100885);
                    textview.setText(shopitem.tags[i1]);
                    textview.setBackgroundDrawable(getResources().getDrawable(0x7f020657));
                    textview.setOnClickListener(new android.view.View.OnClickListener() {

                        private m a;

                        public final void onClick(View view1)
                        {
                            Activity activity1 = a.getActivity();
                            if (activity1 == null || activity1.isFinishing())
                            {
                                return;
                            } else
                            {
                                Intent intent = new Intent(activity1, com/picsart/shop/ShopItemsListActivity);
                                intent.putExtra("selectedTag", ((TextView)view1).getText().toString());
                                intent.putExtra("fromSource", m.j(a));
                                activity1.startActivity(intent);
                                return;
                            }
                        }

            
            {
                a = m.this;
                super();
            }
                    });
                    o.addView(view);
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if ("large".equalsIgnoreCase(shopitem.data.previewSize))
        {
            q = getResources().getInteger(0x7f0e0008);
        } else
        if ("medium".equalsIgnoreCase(shopitem.data.previewSize))
        {
            q = getResources().getInteger(0x7f0e0009);
        } else
        if ("small".equalsIgnoreCase(shopitem.data.previewSize))
        {
            q = getResources().getInteger(0x7f0e000a);
        }
        if (true) goto _L4; else goto _L3
_L3:
        l.setText(shopitem.data.name);
        m.setText(shopitem.data.description);
        int j1 = Utils.a(getActivity());
        int k1 = getResources().getConfiguration().orientation;
        if (Utils.d(activity) > 400F)
        {
            A = ((int)(0.69999999999999996D * (double)Utils.c(activity)) * 450) / 1024;
        } else
        if (k1 == 2)
        {
            A = (j1 * 300) / 1024;
        } else
        {
            A = (j1 * 600) / 1024;
        }
        r = A;
        h.getLayoutParams().height = A;
        if (shopitem.data.bannersCount == 0)
        {
            h.setVisibility(8);
        } else
        {
            h.setVisibility(0);
            f.measure(0x40000000, 0x40000000);
            String s1 = com.picsart.shop.a.a(shopitem);
            com.bumptech.glide.b.b(C.a).a(h);
            C.a(s1, h, new com.bumptech.glide.request.d() {

                final m a;

                public final boolean a(Object obj)
                {
                    obj = (Bitmap)obj;
                    Activity activity1 = a.getActivity();
                    if (activity1 != null && !activity1.isFinishing())
                    {
                        m m1 = a;
                        int l1;
                        if (obj == null)
                        {
                            l1 = 0;
                        } else
                        {
                            l1 = m.i(a);
                        }
                        com.picsart.shop.m.b(m1, l1);
                        if (m.i(a) != com.picsart.shop.m.k(a))
                        {
                            com.picsart.shop.m.g(a).getLayoutParams().height = m.i(a);
                            m.h(a).post(new Runnable(this) {

                                private _cls8 a;

                                public final void run()
                                {
                                    m.m(a.a).removeItemDecoration(com.picsart.shop.m.l(a.a));
                                    com.picsart.shop.m.l(a.a).a = m.h(a.a).getMeasuredHeight();
                                    m.m(a.a).addItemDecoration(com.picsart.shop.m.l(a.a));
                                }

            
            {
                a = _pcls8;
                super();
            }
                            });
                            return false;
                        }
                    }
                    return false;
                }

            
            {
                a = m.this;
                super();
            }
            }, com.bumptech.glide.request.e.b(l.e));
        }
        e.b = q;
        f.postDelayed(new Runnable() {

            private m a;

            public final void run()
            {
                com.picsart.shop.m.l(a).a = m.h(a).getMeasuredHeight();
                m.m(a).removeItemDecoration(com.picsart.shop.m.l(a));
                m.m(a).addItemDecoration(com.picsart.shop.m.l(a));
            }

            
            {
                a = m.this;
                super();
            }
        }, 100L);
        if (shopitem.data.previewType != null && !shopitem.data.previewType.equals("none") && shopitem.data.previewType.equals("icons"))
        {
            j = new t(getActivity(), Color.parseColor(shopitem.data.previewColor), false);
            for (j1 = 1; j1 <= shopitem.data.previewCount; j1++)
            {
                j.b(com.picsart.shop.a.a(shopitem, j1));
            }

        } else
        {
            j = new t(getActivity(), Color.parseColor(shopitem.data.previewColor), true);
            j.b((new StringBuilder()).append(shopitem.data.baseUrl).append("package_preview/640/").append(shopitem.data.shopItemUid).append("_preview.jpg").toString());
            k.setSpanCount(1);
        }
        if (j != null)
        {
            d.setAdapter(j);
            d.scrollToPosition(0);
            h.setTranslationY(0.0F);
            f.setTranslationY(0.0F);
            g = 0;
            if (activity != null && !activity.isFinishing() && (activity instanceof ShopItemActivity))
            {
                ((ShopItemActivity)activity).b(0);
                ((ShopItemActivity)activity).a(0);
            }
        }
        c();
        B.setVisibility(8);
        if (shopitem.promoted)
        {
            E.setVisibility(0);
            C.a(com.picsart.shop.a.a(shopitem, Utils.f(activity)), E, com.bumptech.glide.request.e.b(l.e));
            return;
        } else
        {
            E.setVisibility(8);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        C = new com.picsart.studio.d(getActivity().getApplicationContext());
        Activity activity;
        if (bundle == null)
        {
            bundle = getArguments();
        }
        activity = getActivity();
        if (activity != null && !activity.isFinishing())
        {
            z = activity.getString(0x7f0808c8).equals(activity.getString(0x7f0808ce));
            if (bundle != null && i == null)
            {
                i = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)bundle.getParcelable("selectedShopItem");
                D = bundle.getString("fromSource");
            }
            q = getResources().getInteger(0x7f0e0009);
            k = new GridLayoutManager(getActivity(), q);
            d.setLayoutManager(k);
            y = myobfuscated.f.m.a(activity, getString(0x7f0808be));
            a(getActivity());
            if (i == null)
            {
                D = "banner";
                bundle = activity.getIntent().getStringExtra("selectedShopItemId");
                if (bundle != null)
                {
                    B.setVisibility(0);
                    y.requestShopItems(false, new myobfuscated.bp.c(bundle) {

                        private String a;
                        private m b;

                        public final void a(ArrayList arraylist)
                        {
                            Activity activity1 = b.getActivity();
                            if (activity1 != null && !activity1.isFinishing()) goto _L2; else goto _L1
_L1:
                            return;
_L2:
                            com.picsart.shop.a.a(activity1);
                            com.picsart.shop.a.a().a(arraylist);
                            arraylist = arraylist.iterator();
                            com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem;
                            do
                            {
                                if (!arraylist.hasNext())
                                {
                                    continue; /* Loop/switch isn't completed */
                                }
                                shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
                            } while (!a.equals(shopitem.data.shopItemUid));
                            b.a(shopitem);
                            if (activity1 instanceof ShopItemActivity)
                            {
                                ((ShopItemActivity)activity1).a(shopitem);
                                return;
                            }
                            if (true) goto _L1; else goto _L3
_L3:
                        }

            
            {
                b = m.this;
                a = s1;
                super();
            }
                    });
                    return;
                }
            } else
            {
                a(i);
                return;
            }
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (!y.handleActivityResult(i1, j1, intent))
        {
            super.onActivityResult(i1, j1, intent);
            if (j1 == -1)
            {
                switch (i1)
                {
                default:
                    return;

                case 201: 
                    a = true;
                    break;
                }
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        v = new android.view.View.OnClickListener() {

            final m a;

            public final void onClick(View view)
            {
                view = a.getActivity();
                if (view == null || view.isFinishing())
                {
                    return;
                }
                if (!SocialinV3.getInstance().isRegistered() && !a.getString(0x7f0808c8).equals(a.getString(0x7f0808ce)))
                {
                    com.picsart.shop.m.a(a);
                    return;
                }
                if (!com.picsart.shop.m.b(a).isBillingSupported())
                {
                    Utils.a(a.getActivity(), 0x7f080438);
                    return;
                }
                try
                {
                    com.picsart.shop.m.b(a).requestPurchase(view, com.picsart.shop.m.c(a).data.name, com.picsart.shop.m.c(a).data.shopItemUid, "inapp", com.picsart.shop.a.b(com.picsart.shop.m.c(a).getPrice()), new myobfuscated.bp.d(this) {

                        private _cls1 a;

                        public final void a(boolean flag, String s1, JSONObject jsonobject)
                        {
                            if (flag)
                            {
                                if (com.picsart.shop.m.c(a.a) != null && com.picsart.shop.m.c(a.a).data != null)
                                {
                                    PicsartAnalytics.logPurchaseEvent(com.picsart.shop.m.c(a.a).data.shopItemUid, com.picsart.shop.m.c(a.a).data.name, com.picsart.shop.m.c(a.a).data.miniDescription, com.picsart.shop.m.c(a.a).data.priceString);
                                } else
                                {
                                    PicsartAnalytics.logEvent("shopPurchase");
                                }
                                com.picsart.shop.m.d(a.a);
                                com.picsart.shop.m.a(a.a, jsonobject.toString());
                                AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ShopPackagePurchaseEvent(s1)).setType("paid").setStatus("success"));
                                if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
                                {
                                    com.socialin.android.util.b.a(a.a.getActivity()).b("Paid Packages Downloaded", 1);
                                }
                                if (com.picsart.shop.m.c(a.a).data != null && "swyftmedia".equals(com.picsart.shop.m.c(a.a).data.provider))
                                {
                                    s1 = "0";
                                    jsonobject = "USD";
                                    if (com.picsart.shop.m.c(a.a).data.price > 0)
                                    {
                                        SwyftSerials swyftserials;
                                        if (TextUtils.isEmpty(com.picsart.shop.m.c(a.a).data.priceString))
                                        {
                                            s1 = com.picsart.shop.m.c(a.a).getPrice();
                                        } else
                                        {
                                            s1 = String.valueOf(com.picsart.shop.a.b(com.picsart.shop.m.c(a.a).data.priceString));
                                        }
                                        if (TextUtils.isEmpty(com.picsart.shop.m.c(a.a).data.priceString))
                                        {
                                            jsonobject = "USD";
                                        } else
                                        {
                                            jsonobject = String.valueOf(com.picsart.shop.a.c(com.picsart.shop.m.c(a.a).data.priceString));
                                        }
                                    }
                                    swyftserials = new SwyftSerials(com.picsart.shop.m.c(a.a).data.brand, com.picsart.shop.m.c(a.a).data.content, "");
                                    SwyftAnalytics.getInstance().createTrackEvent("shop_package_purchase").addParam("serials", swyftserials.toJSON().toString()).addParam("price", s1).addParam("currency", jsonobject).track();
                                }
                                return;
                            } else
                            {
                                AnalyticUtils.getInstance(a.a.getActivity()).track((new com.socialin.android.apiv3.events.EventsFactory.ShopPackagePurchaseEvent(s1)).setType("paid").setStatus("fail"));
                                return;
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Utils.a(a.getActivity(), 0x7f080438);
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            private m a;

            public final void onClick(View view)
            {
                if (!com.socialin.android.util.s.a(a.getActivity()))
                {
                    com.socialin.android.photo.g.a(a.getActivity());
                } else
                {
                    view = a.getActivity();
                    if (view != null && !view.isFinishing())
                    {
                        if (!SocialinV3.getInstance().isRegistered() && (com.picsart.shop.m.c(a).data.price <= 0 || !a.getString(0x7f0808c8).equals(a.getString(0x7f0808ce)) || com.picsart.shop.m.c(a).promoted))
                        {
                            com.picsart.shop.m.a(a);
                            return;
                        }
                        com.picsart.shop.m.c(a).hidden = false;
                        com.picsart.shop.m.d(a);
                        com.picsart.shop.m.a(a, "");
                        if (com.picsart.shop.m.c(a).data.price == 0 && !com.picsart.shop.m.c(a).owned)
                        {
                            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
                            {
                                com.socialin.android.util.b.a(a.getActivity()).b("Free Packages Downloaded", 1);
                            }
                            if (com.picsart.shop.m.c(a).data != null && "swyftmedia".equals(com.picsart.shop.m.c(a).data.provider))
                            {
                                String s1;
                                SwyftSerials swyftserials;
                                if (com.picsart.shop.m.c(a).data.price > 0)
                                {
                                    if (TextUtils.isEmpty(com.picsart.shop.m.c(a).data.priceString))
                                    {
                                        view = com.picsart.shop.m.c(a).getPrice();
                                    } else
                                    {
                                        view = String.valueOf(com.picsart.shop.a.b(com.picsart.shop.m.c(a).data.priceString));
                                    }
                                } else
                                {
                                    view = "0";
                                }
                                if (com.picsart.shop.m.c(a).data.price > 0 && !TextUtils.isEmpty(com.picsart.shop.m.c(a).data.priceString))
                                {
                                    s1 = String.valueOf(com.picsart.shop.a.c(com.picsart.shop.m.c(a).data.priceString));
                                } else
                                {
                                    s1 = "USD";
                                }
                                swyftserials = new SwyftSerials(com.picsart.shop.m.c(a).data.brand, com.picsart.shop.m.c(a).data.content, "");
                                SwyftAnalytics.getInstance().createTrackEvent("shop_package_purchase").addParam("serials", swyftserials.toJSON().toString()).addParam("price", view).addParam("currency", s1).track();
                                return;
                            }
                        }
                    }
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        x = new android.view.View.OnClickListener() {

            private m a;

            public final void onClick(View view)
            {
                boolean flag = true;
                if (SocialinV3.getInstance().isRegistered())
                {
                    SocialinV3.getInstance().getUser();
                    Inventory.removeShopItem(com.picsart.shop.m.c(a).id);
                    String s1;
                    Object obj;
                    try
                    {
                        Inventory.addShopItem(com.picsart.shop.m.c(a).toJson());
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        com.socialin.android.d.b(com.picsart.shop.m.a(), new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(view.getMessage()).toString()
                        });
                    }
                }
                view = a.getActivity();
                com.picsart.shop.m.d(a);
                com.picsart.shop.m.e(a);
                if (view != null && !view.isFinishing())
                {
                    view = com.picsart.shop.a.a(view);
                    obj = a.getActivity().getApplicationContext();
                    s1 = com.picsart.shop.m.c(a).data.shopItemUid;
                    if (((com.picsart.shop.a) (view)).c == null)
                    {
                        view.c(((android.content.Context) (obj)));
                    }
                    obj = new File((new StringBuilder()).append(((com.picsart.shop.a) (view)).c).append(s1).toString());
                    if (((File) (obj)).exists())
                    {
                        if (!((File) (obj)).delete())
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                    obj = new File((new StringBuilder()).append(((com.picsart.shop.a) (view)).c).append(s1).append(".part").toString());
                    if (((File) (obj)).exists() && !flag)
                    {
                        ((File) (obj)).delete();
                    }
                    s1 = (new StringBuilder()).append(view.d(s1)).append(s1).toString();
                    ((com.picsart.shop.a) (view)).b.a(s1);
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301d3, viewgroup, false);
    }

    public void onResume()
    {
        super.onResume();
        c();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        l = (TextView)view.findViewById(0x7f100877);
        m = (TextView)view.findViewById(0x7f100878);
        p = view.findViewById(0x7f100879);
        h = (ImageView)view.findViewById(0x7f100875);
        E = (ImageView)view.findViewById(0x7f10087b);
        f = view.findViewById(0x7f100874);
        d = (RecyclerView)view.findViewById(0x7f100873);
        n = (TextView)view.findViewById(0x7f10087a);
        B = view.findViewById(0x7f10087d);
        g = 0;
        d.setOnScrollListener(new android.support.v7.widget.RecyclerView.OnScrollListener() {

            private m a;

            public final void onScrollStateChanged(RecyclerView recyclerview, int i1)
            {
                super.onScrollStateChanged(recyclerview, i1);
            }

            public final void onScrolled(RecyclerView recyclerview, int i1, int j1)
            {
                super.onScrolled(recyclerview, i1, j1);
                com.picsart.shop.m.a(a, j1);
                com.picsart.shop.m.g(a).setTranslationY((m.f(a) * -2) / 3);
                m.h(a).setTranslationY(m.h(a).getTranslationY() - (float)j1);
                recyclerview = a.getActivity();
                if (recyclerview != null && !recyclerview.isFinishing() && (recyclerview instanceof ShopItemActivity))
                {
                    i1 = Math.min(255, (m.f(a) * -255) / m.i(a));
                    ((ShopItemActivity)recyclerview).b(i1);
                    ((ShopItemActivity)recyclerview).a(i1);
                }
            }

            
            {
                a = m.this;
                super();
            }
        });
        o = (FlowLayout)view.findViewById(0x7f10087c);
    }

}
