// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ck;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.mybby.CIALoginFragment;
import com.bestbuy.android.activities.recentlyviewed.RecentlyViewedHomeCard;
import com.bestbuy.android.api.lib.models.home.DealsOfTheDay;
import com.bestbuy.android.api.lib.models.home.HomeFragmentResponse;
import com.bestbuy.android.api.lib.models.home.HomeFragmentResponseData;
import com.bestbuy.android.api.lib.models.home.HomeScreenData;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import fq;
import fr;
import is;
import it;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kb;
import kf;
import lu;
import mw;
import mx;
import my;
import nb;
import nc;
import nf;

// Referenced classes of package com.bestbuy.android.activities.home:
//            GHPBannersHomeCard, DODHomeCard, TrendingHomeCardFragment, MyBBYHomeCard, 
//            WebViewActivity

public class HomeFragment extends BBYBaseFragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener
{

    private final String a = "HomeFragment.java";
    private ck b;
    private my c;
    private View g;
    private ScrollView h;
    private LinearLayout i;
    private Activity j;
    private View k;
    private View l;
    private BBYTextView m;
    private BBYButton n;
    private BBYButton o;
    private boolean p;
    private String q;
    private HomeFragmentResponse r;
    private CustomSwipeToRefresh s;
    private boolean t;
    private ImageView u;
    private android.view.View.OnClickListener v;
    private android.view.View.OnClickListener w;

    public HomeFragment()
    {
        c = null;
        q = "market://details?id=com.bestbuy.android";
        v = new android.view.View.OnClickListener() {

            final HomeFragment a;

            public void onClick(View view)
            {
                view = ((BBYButton)view).getText().toString();
                if (view.equals(HomeFragment.a(a).getResources().getString(0x7f08027b)))
                {
                    HomeFragment.b(a).setText(HomeFragment.a(a).getResources().getString(0x7f08032c));
                    HomeFragment.c(a).setText(HomeFragment.a(a).getResources().getString(0x7f080275));
                    HomeFragment.d(a).setText(HomeFragment.a(a).getResources().getString(0x7f080283));
                } else
                if (view.equals(HomeFragment.a(a).getResources().getString(0x7f08027a)) || view.equals(HomeFragment.a(a).getResources().getString(0x7f080275)))
                {
                    HomeFragment.f(a).removeView(HomeFragment.e(a));
                    HomeFragment.a(a, true);
                    return;
                }
            }

            
            {
                a = HomeFragment.this;
                super();
            }
        };
        w = new android.view.View.OnClickListener() {

            final HomeFragment a;

            public void onClick(View view)
            {
                view = ((BBYButton)view).getText().toString();
                if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080392)))
                {
                    HomeFragment.b(a).setText(HomeFragment.a(a).getResources().getString(0x7f0801d1));
                    HomeFragment.c(a).setText(HomeFragment.a(a).getResources().getString(0x7f08027a));
                    HomeFragment.d(a).setText(HomeFragment.a(a).getResources().getString(0x7f080356));
                } else
                {
                    if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080356)))
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setData(Uri.parse("market://details?id=com.bestbuy.android"));
                        try
                        {
                            a.startActivity(view);
                            HomeFragment.f(a).removeView(HomeFragment.e(a));
                            HomeFragment.a(a, false);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            kf.a("HomeFragment.java", view);
                        }
                        kf.e("HomeFragment.java", (new StringBuilder()).append("Not able to find Market Activity: ").append(view).toString());
                        return;
                    }
                    if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080283)))
                    {
                        view = a.f.l();
                        view = (new StringBuilder()).append("Best Buy Mobile App Feedback v").append(view).toString();
                        a.startActivity(a.a("onlinestore@bestbuy.com", view, ""));
                        HomeFragment.f(a).removeView(HomeFragment.e(a));
                        HomeFragment.a(a, false);
                        return;
                    }
                }
            }

            
            {
                a = HomeFragment.this;
                super();
            }
        };
    }

    static Activity a(HomeFragment homefragment)
    {
        return homefragment.j;
    }

    private Recommendation a(String s1)
    {
        if (r.getSi().getResponse().getRecommendations() != null)
        {
            for (int i1 = 0; i1 < r.getSi().getResponse().getRecommendations().size(); i1++)
            {
                if (((Recommendation)r.getSi().getResponse().getRecommendations().get(i1)).getRecommendationsType().equalsIgnoreCase(s1))
                {
                    return (Recommendation)r.getSi().getResponse().getRecommendations().get(i1);
                }
            }

        }
        return null;
    }

    private void a(Activity activity)
    {
        (new it(activity, this)).executeOnExecutor(nb.h, new Void[0]);
    }

    private void a(LinearLayout linearlayout, BBYBaseFragment bbybasefragment)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("LAYOUT_ID", linearlayout.getId());
        bbybasefragment.setArguments(bundle);
        (new Handler()).post(new Runnable(linearlayout, bbybasefragment) {

            final LinearLayout a;
            final BBYBaseFragment b;
            final HomeFragment c;

            public void run()
            {
                c.getChildFragmentManager().beginTransaction().add(a.getId(), b).commitAllowingStateLoss();
            }

            
            {
                c = HomeFragment.this;
                a = linearlayout;
                b = bbybasefragment;
                super();
            }
        });
        i.addView(linearlayout);
        linearlayout = new View(j);
        linearlayout.setBackgroundColor(Color.rgb(223, 223, 223));
        i.addView(linearlayout, new android.view.ViewGroup.LayoutParams(-1, 1));
    }

    static void a(HomeFragment homefragment, boolean flag)
    {
        homefragment.a(flag);
    }

    private void a(my my1)
    {
        h.removeAllViews();
        i.removeAllViews();
        h.setVerticalScrollBarEnabled(false);
        h.setHorizontalScrollBarEnabled(false);
        if (r != null && r.getSi() != null && r.getSi().getResponse() != null)
        {
            if (my1 != null && my1.a().size() > 0)
            {
label0:
                for (int i1 = 0; i1 < my1.a().size(); i1++)
                {
                    Iterator iterator = ((mx)my1.a().get(i1)).b().iterator();
                    int j1 = 0;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            continue label0;
                        }
                        Object obj = (mw)iterator.next();
                        int l1 = (int)nb.a().a((int)Double.parseDouble(((mw) (obj)).g()));
                        int i2 = (int)nb.a().b((int)Double.parseDouble(((mw) (obj)).h()));
                        LinearLayout linearlayout = new LinearLayout(j);
                        int k1 = l1;
                        if (l1 == 0)
                        {
                            k1 = -2;
                        }
                        l1 = i2;
                        if (i2 == 0)
                        {
                            l1 = -2;
                        }
                        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(k1, l1));
                        j1++;
                        linearlayout.setId(j1);
                        linearlayout.setTag(((mw) (obj)).i());
                        obj = kb.a(((mw) (obj)).i());
                        if (obj instanceof GHPBannersHomeCard)
                        {
                            a(linearlayout, ((BBYBaseFragment) (obj)));
                        } else
                        if ((obj instanceof DODHomeCard) && r.getSi().getResponse().getDealsOfTheDay() != null)
                        {
                            DealsOfTheDay dealsoftheday = new DealsOfTheDay();
                            dealsoftheday.setDealsOfTheDay(r.getSi().getResponse().getDealsOfTheDay());
                            ((DODHomeCard)obj).a(dealsoftheday);
                            a(linearlayout, ((BBYBaseFragment) (obj)));
                        } else
                        if (obj instanceof RecentlyViewedHomeCard)
                        {
                            Recommendation recommendation = a("recentlyViewedAlsoViewed");
                            if (recommendation != null)
                            {
                                ((RecentlyViewedHomeCard)obj).a(recommendation);
                                a(linearlayout, ((BBYBaseFragment) (obj)));
                            }
                        } else
                        if (obj instanceof TrendingHomeCardFragment)
                        {
                            Recommendation recommendation1 = a("trendingMostPopular");
                            if (recommendation1 != null)
                            {
                                ((TrendingHomeCardFragment)obj).a(recommendation1);
                                a(linearlayout, ((BBYBaseFragment) (obj)));
                            }
                        } else
                        {
                            a(linearlayout, ((BBYBaseFragment) (obj)));
                        }
                    } while (true);
                }

                if (p)
                {
                    m.setText(j.getResources().getString(0x7f08018a));
                    n.setText(j.getResources().getString(0x7f08027b));
                    o.setText(j.getResources().getString(0x7f080392));
                    i.addView(k);
                }
            }
            h.addView(i);
        }
    }

    private void a(boolean flag)
    {
        SharedPreferences sharedpreferences = j.getSharedPreferences("sharedPrefs", 0);
        sharedpreferences.edit().putBoolean("ratingReminder", flag).commit();
        sharedpreferences.edit().putInt("launchCount", 0).commit();
        p = false;
    }

    static BBYTextView b(HomeFragment homefragment)
    {
        return homefragment.m;
    }

    static BBYButton c(HomeFragment homefragment)
    {
        return homefragment.n;
    }

    static BBYButton d(HomeFragment homefragment)
    {
        return homefragment.o;
    }

    static View e(HomeFragment homefragment)
    {
        return homefragment.k;
    }

    static LinearLayout f(HomeFragment homefragment)
    {
        return homefragment.i;
    }

    static CustomSwipeToRefresh g(HomeFragment homefragment)
    {
        return homefragment.s;
    }

    private void h()
    {
        SharedPreferences sharedpreferences = j.getSharedPreferences("sharedPrefs", 0);
        boolean flag = sharedpreferences.getBoolean("ratingReminder", true);
        int i1 = sharedpreferences.getInt("launchCount", 0);
        String s1 = sharedpreferences.getString("appVersion", null);
        String s2 = f.l();
        if (s1 == null || !s1.equals(s2))
        {
            sharedpreferences.edit().putString("appVersion", s2).commit();
            sharedpreferences.edit().putInt("launchCount", 1).commit();
            sharedpreferences.edit().putBoolean("ratingReminder", true).commit();
            p = true;
        } else
        if (flag)
        {
            i1++;
            sharedpreferences.edit().putInt("launchCount", i1).commit();
            if (i1 > 10)
            {
                p = true;
                return;
            }
        } else
        {
            p = false;
            return;
        }
    }

    private void i()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(q));
        j.startActivity(intent);
    }

    public Intent a(String s1, String s2, String s3)
    {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse((new StringBuilder()).append("mailto:").append(Uri.encode(s1)).append("?subject=").append(Uri.encode(s2)).append("&body=").append(Uri.encode(s3)).toString()));
        if (j.getPackageManager().queryIntentActivities(intent, 0).size() > 0)
        {
            return intent;
        } else
        {
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("message/rfc822");
            intent1.putExtra("android.intent.extra.EMAIL", new String[] {
                s1
            });
            intent1.putExtra("android.intent.extra.SUBJECT", s2);
            intent1.putExtra("android.intent.extra.TEXT", s3);
            return Intent.createChooser(intent1, "Choose an Email client :");
        }
    }

    public void a(HomeFragmentResponse homefragmentresponse)
    {
        r = homefragmentresponse;
        d();
    }

    public void b()
    {
        s.setEnabled(true);
    }

    public void c()
    {
        s.setEnabled(false);
    }

    public void d()
    {
        try
        {
            c = new my(nb.a().b().getString("Hometiles", ""), "Hometiles");
        }
        catch (Exception exception)
        {
            kf.e("HomeFragment.java", (new StringBuilder()).append("Could not create all UISections: ").append(exception.getLocalizedMessage()).toString());
        }
        a(c);
        if (fq.a(System.currentTimeMillis()))
        {
            getActivity().runOnUiThread(new Runnable() {

                final HomeFragment a;

                public void run()
                {
                    (new Handler()).postDelayed(new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            Intent intent = new Intent(a.a.getActivity(), com/bestbuy/android/activities/home/WebViewActivity);
                            intent.putExtra("com.bestbuy.android.URL_TOBE_LOADED", "https://secure.opinionlab.com/ccc01/o.asp?id=UdgWGjJa");
                            a.a.startActivity(intent);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    }, 3000L);
                }

            
            {
                a = HomeFragment.this;
                super();
            }
            });
        }
    }

    public void e()
    {
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(nf.b(2.0F, j), nf.b(2.0F, j), nf.b(2.0F, j), nf.b(2.0F, j));
        ((ViewGroup)g).addView(l, ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = (ImageView)l.findViewById(0x7f0c024f);
        ImageView imageview = (ImageView)l.findViewById(0x7f0c0067);
        TextView textview = (TextView)l.findViewById(0x7f0c03f0);
        imageview.setOnClickListener(this);
        textview.setOnClickListener(this);
        ((ImageView) (obj)).setOnClickListener(this);
        obj = (TextView)l.findViewById(0x7f0c03f0);
        l.setVisibility(0);
        l.bringToFront();
        ((TextView) (obj)).setText(Html.fromHtml(j.getResources().getString(0x7f080269)));
    }

    public void f()
    {
        Iterator iterator = getChildFragmentManager().getFragments().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Fragment fragment = (Fragment)iterator.next();
            if (fragment != null && ((fragment instanceof MyBBYHomeCard) || (fragment instanceof DODHomeCard) || (fragment instanceof TrendingHomeCardFragment) || (fragment instanceof RecentlyViewedHomeCard)))
            {
                FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
                fragmenttransaction.detach(fragment);
                fragmenttransaction.attach(fragment);
                fragmenttransaction.commitAllowingStateLoss();
            }
        } while (true);
    }

    public void g()
    {
        if (u.getVisibility() == 8)
        {
            u.setVisibility(0);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        int i1;
        super.onAttach(activity);
        j = activity;
        i1 = 0;
_L2:
        String s1;
        Object obj;
        if (i1 >= nb.d.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new nc();
        s1 = null;
        obj = ((nc) (obj)).a(activity, nb.e, nb.d[i1]);
        s1 = ((String) (obj));
_L3:
        nb.a().b().edit().putString(nb.d[i1], s1).commit();
        i1++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
_L1:
        a(activity);
        return;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131492967: 46
    //                   2131493455: 41
    //                   2131493872: 41;
           goto _L1 _L2 _L3 _L3
_L1:
        return;
_L3:
        i();
        return;
_L2:
        if (l != null)
        {
            l.setVisibility(8);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = nb.a();
        i = new LinearLayout(j);
        i.setOrientation(1);
        i.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        h();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f030050, viewgroup, false);
            k = layoutinflater.inflate(0x7f0300dd, viewgroup, false);
            h = (ScrollView)g.findViewById(0x7f0c0120);
            m = (BBYTextView)k.findViewById(0x7f0c035d);
            n = (BBYButton)k.findViewById(0x7f0c035e);
            o = (BBYButton)k.findViewById(0x7f0c035f);
            n.setOnClickListener(v);
            o.setOnClickListener(w);
            u = (ImageView)g.findViewById(0x7f0c006d);
            s = (CustomSwipeToRefresh)g.findViewById(0x7f0c006e);
            s.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
            s.setOnRefreshListener(this);
            t = ChatRunningStatus.getChatRunning();
            if (!t)
            {
                b();
            } else
            {
                c();
            }
            l = layoutinflater.inflate(0x7f030110, viewgroup, false);
            (new is(j, this, null)).executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)g.getParent()).removeView(g);
        }
        return g;
    }

    public void onDetach()
    {
        super.onDetach();
        b = null;
    }

    public void onRefresh()
    {
        c();
        (new Handler()).postDelayed(new Runnable() {

            final HomeFragment a;

            public void run()
            {
                HomeFragment.g(a).setRefreshing(false);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    HashMap hashmap = new HashMap();
                    hashmap.put("bb.prevPageLink", "Best Buy : Blue Assist");
                    lu.b(lu.aT, hashmap);
                    a.startActivityForResult(intent, 8998);
                }
            }

            
            {
                a = HomeFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        t = ChatRunningStatus.getChatRunning();
        String s1;
        if (!t)
        {
            b();
        } else
        {
            c();
        }
        try
        {
            ((BBYBaseFragmentActivity)j).updateActionBarTitle("Home");
            ((BBYBaseFragmentActivity)j).showActionBarHome();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        s1 = fr.j();
        if (CIALoginFragment.a)
        {
            if (s1 != null && !s1.equals("10130"))
            {
                f();
            }
            CIALoginFragment.a = false;
        }
    }
}
