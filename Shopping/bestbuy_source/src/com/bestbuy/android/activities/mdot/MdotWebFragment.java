// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mdot;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.registry.Entity;
import com.bestbuy.android.api.lib.models.registry.LoggedInUserProfile;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.bbyobjects.BBYWebView;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import fr;
import gw;
import io;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kj;
import ll;
import lu;
import nb;
import nd;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

public class MdotWebFragment extends BBYBaseFragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, nd
{

    private static String a = "&sp=&cp=1&scValue=Y&sc=Global&ev=event41%2Cevent1&channel=Enhanced&search=true&usearch=yes&usc=All+Categories&clearImgUrl=http%3A%2F%2Fimages.bestbuy.com%3A80%2FBestBuy_US%2Fmobile%2Fimages%2Fclear.png";
    private float A;
    private boolean B;
    private boolean C;
    private BBYWebView b;
    private CookieManager c;
    private String g;
    private View h;
    private String i;
    private boolean j;
    private StringBuffer k;
    private View l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private LinearLayout q;
    private LinearLayout r;
    private boolean s;
    private BBYTextView t;
    private FrameLayout u;
    private nb v;
    private boolean w;
    private ImageView x;
    private CustomSwipeToRefresh y;
    private float z;

    public MdotWebFragment()
    {
        j = true;
        k = new StringBuffer();
        m = true;
        n = false;
        o = false;
        p = "";
        w = false;
        B = true;
        C = false;
    }

    public MdotWebFragment(boolean flag)
    {
        j = true;
        k = new StringBuffer();
        m = true;
        n = false;
        o = false;
        p = "";
        w = false;
        B = true;
        C = false;
        m = flag;
    }

    public MdotWebFragment(boolean flag, boolean flag1)
    {
        j = true;
        k = new StringBuffer();
        m = true;
        n = false;
        o = false;
        p = "";
        w = false;
        B = true;
        C = false;
        m = flag;
        n = flag1;
    }

    public MdotWebFragment(boolean flag, boolean flag1, String s1)
    {
        j = true;
        k = new StringBuffer();
        m = true;
        n = false;
        o = false;
        p = "";
        w = false;
        B = true;
        C = false;
        m = flag;
        n = flag1;
        p = s1;
    }

    public MdotWebFragment(boolean flag, boolean flag1, boolean flag2, String s1, String s2)
    {
        j = true;
        k = new StringBuffer();
        m = true;
        n = false;
        o = false;
        p = "";
        w = false;
        B = true;
        C = false;
        m = flag;
        n = flag1;
        o = flag2;
        p = s1;
        g = s2;
    }

    static float a(MdotWebFragment mdotwebfragment, float f1)
    {
        mdotwebfragment.A = f1;
        return f1;
    }

    static ImageView a(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.x;
    }

    static boolean a(MdotWebFragment mdotwebfragment, boolean flag)
    {
        mdotwebfragment.B = flag;
        return flag;
    }

    static float b(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.z;
    }

    static float b(MdotWebFragment mdotwebfragment, float f1)
    {
        mdotwebfragment.z = f1;
        return f1;
    }

    static float c(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.A;
    }

    static boolean d(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.B;
    }

    static String e(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.g;
    }

    static CustomSwipeToRefresh f(MdotWebFragment mdotwebfragment)
    {
        return mdotwebfragment.y;
    }

    private void m()
    {
        u = (FrameLayout)h.findViewById(0x7f0c004a);
        u.removeAllViews();
        Activity activity = d;
        View view = l;
        boolean flag;
        if (!o)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = new BBYWebView(activity, this, view, flag);
        if (g.equals("http://www.bestbuy.com/site/DSKU/HowItWorks_Games/pcmcat248100050001.c?id=pcmcat248100050001") || g.equals("http://www.esrb.org/ratings/ratings_guide_print_sept13.jsp") || g.startsWith("http://bbyoffer.appspot.com/api/v1/offer/") || g.equals("http://www.bestbuy.com/site/Help-Topics/California-Privacy-Rights/pcmcat204400050063.c?id=pcmcat204400050063") || g.equals("http://www.bestbuy.com/site/Help-Topics/Privacy-Policy/pcmcat204400050062.c?id=pcmcat204400050062") || g.equals("http://www.bestbuy.com/site/legal-privacy-policies/conditions-of-use/pcmcat204400050067.c?id=pcmcat204400050067") || g.contains("http://www.bestbuy.com/site/olspage.jsp?id=pcat17089&type=page&sellerId=") || g.startsWith("file:///android_asset/") || g.contains("Global-Promotions/Product-Recalls") || g.contains("http://www.bestbuy.com/site/misc/native-app/"))
        {
            b.getSettings().setLoadWithOverviewMode(true);
            b.getSettings().setUseWideViewPort(true);
            b.getSettings().setBuiltInZoomControls(true);
            b.getSettings().setSupportZoom(true);
        }
        c = CookieManager.getInstance();
        c.setAcceptCookie(true);
        CookieManager.setAcceptFileSchemeCookies(true);
        if (w)
        {
            b.setCartEmpty(w);
        }
        u.addView(b);
    }

    public void a(WebView webview)
    {
        ll.b(r);
    }

    public void a(LoggedInUserProfile loggedinuserprofile)
    {
        if (loggedinuserprofile == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        String s1 = loggedinuserprofile.getRefreshToken();
        String s2 = ((Entity)loggedinuserprofile.getEntities().get(0)).getUsername();
        v.d(s2);
        if (!s1.equalsIgnoreCase(getString(0x7f080068)) && s1.length() > 0)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("bb.rzTier", ((Entity)loggedinuserprofile.getEntities().get(0)).getRzTierStatus());
            lu.b(lu.c, hashmap);
        }
        return;
        loggedinuserprofile;
        loggedinuserprofile.printStackTrace();
        return;
    }

    public void a(String s1)
    {
        CookieSyncManager cookiesyncmanager;
        Object obj;
        Cookie cookie;
        String s2;
        try
        {
            CookieSyncManager.createInstance(d);
            cookiesyncmanager = CookieSyncManager.getInstance();
            obj = gw.a().getCookieStore().getCookies();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (((List) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        obj = ((List) (obj)).iterator();
_L1:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        cookie = (Cookie)((Iterator) (obj)).next();
        s2 = (new StringBuilder()).append(cookie.getName()).append("=").append(cookie.getValue()).append("; Domain=").append(cookie.getDomain()).toString();
        if (cookie == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (cookie.getName() != null && !cookie.getName().trim().equals("bby_rdp"))
        {
            c.setCookie(".bestbuy.com", s2);
        }
        cookiesyncmanager.sync();
          goto _L1
        c.setCookie(s1, v.L());
        c.setCookie(s1, v.M());
        c.setCookie(s1, v.N());
        c.setCookie(s1, v.O());
        if (fr.d() != null)
        {
            c.setCookie(s1, v.J());
            c.setCookie(s1, v.K());
        }
        cookiesyncmanager.sync();
        return;
    }

    public void a(String s1, String s2)
    {
        (new io(d, this, null, s1, s2)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void a(boolean flag)
    {
        C = flag;
    }

    public String b()
    {
        return b.getUrl();
    }

    public void b(String s1)
    {
        q.setVisibility(0);
        t.setText(Html.fromHtml(s1));
    }

    public void c()
    {
        HashMap hashmap;
        if (!g.startsWith("file:///android_asset/") && !g.startsWith("https://secure.opinionlab.com/"))
        {
            if (g.contains("?"))
            {
                g = (new StringBuilder()).append(g).append("&appvi=").append(nb.a().r()).toString();
            } else
            {
                g = (new StringBuilder()).append(g).append("?appvi=").append(nb.a().r()).toString();
            }
        }
        hashmap = new HashMap();
        if (!g.startsWith("https://secure.opinionlab.com/"))
        {
            a(g);
            hashmap.put(getString(0x7f08008f), getString(0x7f080090));
        }
        b.loadUrl(g, hashmap);
        b.requestFocus(130);
        b.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MdotWebFragment a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 34
            //                           1 61
            //                           2 48;
                   goto _L1 _L2 _L3 _L4
_L1:
                return false;
_L2:
                MdotWebFragment.a(a, motionevent.getY());
                return false;
_L4:
                MdotWebFragment.a(a).setVisibility(0);
                return false;
_L3:
                MdotWebFragment.b(a, motionevent.getY());
                motionevent = a;
                boolean flag;
                if (MdotWebFragment.b(a) - MdotWebFragment.c(a) > 300F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                MdotWebFragment.a(motionevent, flag);
                if (!view.hasFocus())
                {
                    view.requestFocus();
                    return false;
                }
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                a = MdotWebFragment.this;
                super();
            }
        });
        b.setOnScrollChangedCallback(new kj() {

            final MdotWebFragment a;

            public void a(int i1, int j1)
            {
                if (j1 < 200 && MdotWebFragment.d(a))
                {
                    MdotWebFragment.a(a, false);
                    if (MdotWebFragment.e(a).contains(".bestbuy.com/cart"))
                    {
                        return;
                    }
                    if (MdotWebFragment.a(a).getVisibility() == 8)
                    {
                        MdotWebFragment.a(a).setVisibility(0);
                    }
                    MdotWebFragment.f(a).setPullDownEvent(true);
                    MotionEvent motionevent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 0, 0.0F, 0.0F, 0);
                    MdotWebFragment.f(a).dispatchTouchEvent(motionevent);
                    return;
                } else
                {
                    MdotWebFragment.a(a).setVisibility(8);
                    return;
                }
            }

            
            {
                a = MdotWebFragment.this;
                super();
            }
        });
    }

    public boolean d()
    {
        return b.canGoBack();
    }

    public void e()
    {
        if (b().contains("pcat17009"))
        {
            f();
            return;
        } else
        {
            x.setVisibility(8);
            b.goBack();
            return;
        }
    }

    public void f()
    {
        g = "http://www.bestbuy.com/cart";
        m();
        c();
    }

    public void g()
    {
        y.setEnabled(true);
    }

    public void h()
    {
        y.setEnabled(false);
    }

    public boolean i()
    {
        return b.getScrollY() > 0;
    }

    public boolean j()
    {
        return C;
    }

    public ImageView k()
    {
        return x;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if ((getParentFragment() instanceof CartTabContainer) && !b.canGoBack())
        {
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Cart");
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        v = nb.a();
        if (m)
        {
            ((BBYBaseFragmentActivity)activity).changeActionBarAddToVisibility(activity, false);
            String s1 = ((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle();
            if (s1 != null && !s1.isEmpty())
            {
                v.i(s1);
            }
            ((BBYBaseFragmentActivity)activity).updateActionBarTitle(p);
            if (n)
            {
                ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
            } else
            {
                ((BBYBaseFragmentActivity)activity).hideActionBarHome();
            }
            if (s)
            {
                ((BBYBaseFragmentActivity)activity).showActionBarHome();
                ((BBYBaseFragmentActivity)activity).showSearchBarWithBackButton();
            }
        }
        if (o)
        {
            ((BBYBaseFragmentActivity)activity).updateActionBarTitle(p);
            ((HomeActivity)activity).fragmentHasOptionsMenu(true);
            ((HomeActivity)activity).changeOptionsVisibility(false);
        }
    }

    public void onClick(View view)
    {
        while (view == q || view != r) 
        {
            return;
        }
        view = ((HomeActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(view instanceof HomeTabFragment))
        {
            break MISSING_BLOCK_LABEL_58;
        }
        view = (HomeTabFragment)view;
_L1:
        view.a(3);
        return;
        view;
        view.printStackTrace();
        return;
        view = null;
          goto _L1
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        bundle = getArguments();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        if (!bundle.containsKey(getResources().getString(0x7f080055))) goto _L4; else goto _L3
_L3:
        g = bundle.getString(getResources().getString(0x7f080055));
_L6:
        if (bundle.containsKey(getResources().getString(0x7f080059)))
        {
            w = bundle.getBoolean(getResources().getString(0x7f080059));
        }
_L2:
        h = (RelativeLayout)layoutinflater.inflate(0x7f030066, viewgroup, false);
        l = h.findViewById(0x7f0c0064);
        m();
        c();
        x = (ImageView)h.findViewById(0x7f0c006d);
        y = (CustomSwipeToRefresh)h.findViewById(0x7f0c006e);
        y.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
        y.setOnRefreshListener(this);
        y.setFromMDotWebFragment(true);
        y.setEnabled(false);
        q = (LinearLayout)h.findViewById(0x7f0c016c);
        t = (BBYTextView)h.findViewById(0x7f0c016d);
        r = (LinearLayout)h.findViewById(0x7f0c0080);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        y.setCanChildScrollUpCallback(this);
        return h;
_L4:
        if (bundle.containsKey(getResources().getString(0x7f080071)))
        {
            i = bundle.getString(getResources().getString(0x7f080071));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (m)
        {
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(v.T());
        }
        d.getWindow().setSoftInputMode(32);
    }

    public void onRefresh()
    {
        h();
        (new Handler()).postDelayed(new Runnable() {

            final MdotWebFragment a;

            public void run()
            {
                MdotWebFragment.f(a).setRefreshing(false);
                MdotWebFragment.a(a).setVisibility(8);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    HashMap hashmap = new HashMap();
                    hashmap.put("bb.prevPageLink", "From Web Page: Blue Assist");
                    lu.b(lu.aT, hashmap);
                    a.startActivity(intent);
                }
            }

            
            {
                a = MdotWebFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        if (getParentFragment() instanceof CartTabContainer)
        {
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Cart");
            return;
        }
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (!ChatRunningStatus.getChatRunning())
        {
            g();
            return;
        } else
        {
            h();
            return;
        }
    }

}
