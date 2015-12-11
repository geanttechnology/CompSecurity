// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.d.u;
import com.smule.android.f.j;
import com.smule.android.network.core.b;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.a;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ao;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.aq;
import com.smule.android.network.managers.ar;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.db.c;
import com.smule.pianoandroid.data.db.e;
import com.smule.pianoandroid.data.db.h;
import com.smule.pianoandroid.utils.f;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.m;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.t;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, at, ProductListFragment, MagicApplication, 
//            b, as, PurchaseActivity_, av, 
//            n, ac, bb, TrialSubsActivity_, 
//            ar

public class ProductListActivity extends ag
    implements FlurryAdListener, ab, ao, e, at
{

    private static int C = 0;
    static final String a = com/smule/pianoandroid/magicpiano/ProductListActivity.getName();
    static String e;
    private static String f = "FOLLOW_DATA_URI";
    private static final int z[] = {
        0x7f050007, 0x7f050006
    };
    private int A[];
    private SoundPool B;
    private BroadcastReceiver D;
    private Observer E;
    private android.view.View.OnClickListener F;
    Integer b;
    Integer c;
    Intent d;
    private ArrayList g;
    private int h;
    private String i[];
    private ViewGroup j;
    private PublisherAdView k;
    private com.smule.pianoandroid.magicpiano.b l;
    private ProductListFragment m;
    private TextView n;
    private View t;
    private boolean u;
    private boolean v;
    private t w;
    private com.smule.pianoandroid.magicpiano.a.a x;
    private MenuItem y;

    public ProductListActivity()
    {
        h = 5;
        n = null;
        t = null;
        u = false;
        v = true;
        b = null;
        c = null;
        D = new BroadcastReceiver() {

            final ProductListActivity a;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction() == "BALANCE_UPDATE_EVENT")
                {
                    com.smule.pianoandroid.magicpiano.ProductListActivity.c(a).c();
                    return;
                }
                if (intent.getAction() == "SUBSCRIPTION_UPDATED")
                {
                    ProductListActivity.d(a).c();
                    return;
                } else
                {
                    aa.b(com.smule.pianoandroid.magicpiano.ProductListActivity.a, "Unknown Broadcast received!");
                    return;
                }
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        };
        E = new Observer() {

            final ProductListActivity a;

            public void update(Observable observable, Object obj)
            {
                observable = new Runnable(this) {

                    final _cls22 a;

                    public void run()
                    {
                        if (!bb.d())
                        {
                            MagicApplication.getLoader().a("TrialSubsPopup", Arrays.asList(new String[] {
                                "InitAppTask.OP_LOCALIZE_SETTINGS"
                            }), com.smule.pianoandroid.utils.n.a(a.a, new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    if (!bb.d() && !ap.a().b() && ap.a().e())
                                    {
                                        a.a.a.findViewById(0x7f0a00a9).setVisibility(0);
                                        com.smule.pianoandroid.utils.e.a(a.a.a, new f(this) {

                                            final _cls1 a;

                                            public void a()
                                            {
                                                a.a.a.a.findViewById(0x7f0a00a9).setVisibility(8);
                                            }

                                            public void a(Map map, List list)
                                            {
                                                Object obj = null;
                                                Iterator iterator = list.iterator();
                                                do
                                                {
                                                    list = obj;
                                                    if (!iterator.hasNext())
                                                    {
                                                        break;
                                                    }
                                                    list = (com.smule.android.network.models.f)iterator.next();
                                                    if (!((com.smule.android.network.models.f) (list)).trial)
                                                    {
                                                        continue;
                                                    }
                                                    list = ((com.smule.android.network.models.f) (list)).sku;
                                                    break;
                                                } while (true);
                                                if (TextUtils.isEmpty(list)) goto _L2; else goto _L1
_L1:
                                                if (map != null)
                                                {
                                                    Intent intent = new Intent(a.a.a.a, com/smule/pianoandroid/magicpiano/TrialSubsActivity_);
                                                    intent.putExtra("SKU", list);
                                                    intent.putExtra("PRICE", ((u)map.get(list)).b());
                                                    aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("Start activity TrialSubs ").append(list).append(" ").append(((u)map.get(list)).b()).toString());
                                                    com.smule.pianoandroid.magicpiano.bb.a(true);
                                                    a.a.a.a.startActivity(intent);
                                                    a.a.a.a.overridePendingTransition(0x7f040013, 0x7f040015);
                                                }
_L4:
                                                a.a.a.a.findViewById(0x7f0a00a9).setVisibility(8);
                                                return;
_L2:
                                                if (!com.smule.pianoandroid.magicpiano.ar.a())
                                                {
                                                    a.a.a.a.runOnUiThread(new Runnable(this) {

                                                        final _cls1 a;

                                                        public void run()
                                                        {
                                                            o.a(a.a.a.a.a, new Runnable(this) {

                                                                final _cls1 a;

                                                                public void run()
                                                                {
                                                                }

            
            {
                a = _pcls1;
                super();
            }
                                                            }, null, a.a.a.a.a.getResources().getString(0x7f0c02b9), a.a.a.a.a.getResources().getString(0x7f0c021b));
                                                        }

            
            {
                a = _pcls1;
                super();
            }
                                                    });
                                                    com.smule.pianoandroid.magicpiano.ar.a(true);
                                                }
                                                if (true) goto _L4; else goto _L3
_L3:
                                            }

            
            {
                a = _pcls1;
                super();
            }
                                        });
                                    }
                                }

            
            {
                a = _pcls1;
                super();
            }
                            })).a();
                            return;
                        } else
                        {
                            o.b(a.a);
                            return;
                        }
                    }

            
            {
                a = _pcls22;
                super();
            }
                };
                if (com.smule.pianoandroid.magicpiano.c.a.a().d())
                {
                    if (ProductListActivity.d() > 0)
                    {
                        a.a(observable);
                        return;
                    } else
                    {
                        observable.run();
                        return;
                    }
                } else
                {
                    com.smule.pianoandroid.magicpiano.ac.a().a("NOTIFICATION_ACHIEVEMENTS", ProductListActivity.d());
                    return;
                }
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        };
        F = new android.view.View.OnClickListener() {

            final ProductListActivity a;

            public void onClick(View view)
            {
                int i1 = Integer.parseInt(view.getTag().toString());
                ProductListActivity.d(a).a(i1);
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        };
    }

    static SoundPool a(ProductListActivity productlistactivity)
    {
        return productlistactivity.B;
    }

    static PublisherAdView a(ProductListActivity productlistactivity, PublisherAdView publisheradview)
    {
        productlistactivity.k = publisheradview;
        return publisheradview;
    }

    private List a(String as1[], Map map)
    {
        ArrayList arraylist = new ArrayList();
        int j1 = as1.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            String s = as1[i1];
            if (map.containsKey(s))
            {
                arraylist.add(s);
            }
        }

        return arraylist;
    }

    public static void a(int i1)
    {
        C += i1;
    }

    private void a(MenuItem menuitem, SearchView searchview)
    {
        menuitem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener() {

            final ProductListActivity a;

            public boolean onMenuItemActionCollapse(MenuItem menuitem1)
            {
                com.smule.pianoandroid.magicpiano.ProductListActivity.h(a);
                return true;
            }

            public boolean onMenuItemActionExpand(MenuItem menuitem1)
            {
                ((DrawerLayout)a.findViewById(0x7f0a016b)).closeDrawer(0x800003);
                com.smule.pianoandroid.magicpiano.ProductListActivity.a(a, true);
                com.smule.android.c.a.a();
                a.findViewById(0x7f0a00a9).setVisibility(0);
                return true;
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        });
        searchview.setOnCloseListener(new android.widget.SearchView.OnCloseListener() {

            final ProductListActivity a;

            public boolean onClose()
            {
                com.smule.pianoandroid.magicpiano.ProductListActivity.h(a);
                return true;
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        });
        searchview.setOnSearchClickListener(new android.view.View.OnClickListener(searchview) {

            final SearchView a;
            final ProductListActivity b;

            public void onClick(View view)
            {
                aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, "setOnSearchClickListener");
                view = ProductListActivity.d(b).a().g();
                if (view != null && view.length() != 0)
                {
                    a.setQuery(view, false);
                    aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("setOnSearchClickListener - ").append(view).toString());
                }
            }

            
            {
                b = ProductListActivity.this;
                a = searchview;
                super();
            }
        });
        menuitem = new com.smule.pianoandroid.search.b() {

            final ProductListActivity a;

            public void a(com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult afuzzysearchresult[])
            {
                long l1 = System.currentTimeMillis();
                HashMap hashmap = new HashMap(afuzzysearchresult.length);
                int j1 = afuzzysearchresult.length;
                for (int i1 = 0; i1 < j1; i1++)
                {
                    com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult = afuzzysearchresult[i1];
                    hashmap.put(fuzzysearchresult.mKey, ak.a().a(fuzzysearchresult.mKey).title);
                }

                Arrays.sort(afuzzysearchresult, new Comparator(this, hashmap) {

                    final Map a;
                    final _cls9 b;

                    public int a(com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult, com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult fuzzysearchresult1)
                    {
                        if (fuzzysearchresult.mScore < fuzzysearchresult1.mScore)
                        {
                            return 1;
                        }
                        if (fuzzysearchresult.mScore > fuzzysearchresult1.mScore)
                        {
                            return -1;
                        } else
                        {
                            return ((String)a.get(fuzzysearchresult.mKey)).compareTo((String)a.get(fuzzysearchresult1.mKey));
                        }
                    }

                    public int compare(Object obj, Object obj1)
                    {
                        return a((com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult)obj, (com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult)obj1);
                    }

            
            {
                b = _pcls9;
                a = map;
                super();
            }
                });
                long l2 = System.currentTimeMillis();
                a.runOnUiThread(new Runnable(this, afuzzysearchresult, l2, l1) {

                    final com.smule.pianoandroid.search.FuzzySearchIndex.FuzzySearchResult a[];
                    final long b;
                    final long c;
                    final _cls9 d;

                    public void run()
                    {
                        byte byte2 = 8;
                        long l1 = System.currentTimeMillis();
                        ProductListActivity.d(d.a).a().a(a);
                        TextView textview;
                        byte byte0;
                        byte byte1;
                        if (a.length > 0)
                        {
                            byte0 = 1;
                        } else
                        {
                            byte0 = 0;
                        }
                        textview = com.smule.pianoandroid.magicpiano.ProductListActivity.i(d.a);
                        if (byte0 != 0)
                        {
                            byte1 = 8;
                        } else
                        {
                            byte1 = 0;
                        }
                        textview.setVisibility(byte1);
                        if (byte0 != 0)
                        {
                            ProductListActivity.d(d.a).b();
                        }
                        if (r.a(MagicApplication.getContext()))
                        {
                            View view = com.smule.pianoandroid.magicpiano.ProductListActivity.j(d.a);
                            if (ProductListActivity.d(d.a).a().e().booleanValue())
                            {
                                byte0 = byte2;
                            } else
                            {
                                byte0 = 0;
                            }
                            view.setVisibility(byte0);
                        } else
                        {
                            com.smule.pianoandroid.magicpiano.ProductListActivity.j(d.a).setVisibility(8);
                        }
                        aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("Callback executed for ").append(System.currentTimeMillis() - l1).append("ms. Sorting for ").append(b - c).append("ms.").toString());
                    }

            
            {
                d = _pcls9;
                a = afuzzysearchresult;
                b = l1;
                c = l2;
                super();
            }
                });
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        };
        searchview.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener(searchview) {

            final SearchView a;
            final ProductListActivity b;
            private boolean c;

            public boolean onQueryTextChange(String s)
            {
                aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("onQueryTextChange - ").append(s).append(" submitted ").append(c).toString());
                if (c)
                {
                    c = false;
                    return true;
                }
                if (!TextUtils.isEmpty(s))
                {
                    b.findViewById(0x7f0a01d0).setVisibility(8);
                } else
                {
                    b.findViewById(0x7f0a01d0).setVisibility(0);
                }
                ProductListActivity.d(b).a().a(s, Boolean.TRUE);
                return true;
            }

            public boolean onQueryTextSubmit(String s)
            {
                aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("onQueryTextSubmit - ").append(s).toString());
                c = true;
                b.findViewById(0x7f0a00a9).setVisibility(8);
                a.clearFocus();
                return true;
            }

            
            {
                b = ProductListActivity.this;
                a = searchview;
                super();
                c = false;
            }
        });
        searchview = new Runnable(searchview) {

            final SearchView a;
            final ProductListActivity b;

            public void run()
            {
                byte byte1 = 8;
                Object obj = a.getQuery().toString();
                boolean flag = ProductListActivity.d(b).a().a(((String) (obj)), Boolean.TRUE);
                obj = com.smule.pianoandroid.magicpiano.ProductListActivity.i(b);
                byte byte0;
                if (flag)
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                ((TextView) (obj)).setVisibility(byte0);
                if (flag)
                {
                    ProductListActivity.d(b).b();
                }
                if (r.a(MagicApplication.getContext()))
                {
                    View view = com.smule.pianoandroid.magicpiano.ProductListActivity.j(b);
                    if (ProductListActivity.d(b).a().e().booleanValue())
                    {
                        byte0 = byte1;
                    } else
                    {
                        byte0 = 0;
                    }
                    view.setVisibility(byte0);
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.ProductListActivity.j(b).setVisibility(8);
                    return;
                }
            }

            
            {
                b = ProductListActivity.this;
                a = searchview;
                super();
            }
        };
        if (m == null)
        {
            m = (ProductListFragment)getSupportFragmentManager().findFragmentById(0x7f0a01d2);
        }
        m.a().a(menuitem);
        m.a().a(searchview);
    }

    private void a(View view, View view1, View view2, Runnable runnable)
    {
        view.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04001d);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view1, view, view2, runnable) {

            final View a;
            final View b;
            final View c;
            final Runnable d;
            final ProductListActivity e;

            public void onAnimationEnd(Animation animation1)
            {
                com.smule.pianoandroid.magicpiano.ProductListActivity.a(e, b, a, c, d);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
                com.smule.pianoandroid.utils.n.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a(e), com.smule.pianoandroid.magicpiano.ProductListActivity.b(e)[0], 1.2F, false);
                a.setVisibility(0);
            }

            
            {
                e = ProductListActivity.this;
                a = view;
                b = view1;
                c = view2;
                d = runnable;
                super();
            }
        });
        view1.startAnimation(animation);
    }

    static void a(ProductListActivity productlistactivity, View view, View view1, View view2, Runnable runnable)
    {
        productlistactivity.b(view, view1, view2, runnable);
    }

    static void a(ProductListActivity productlistactivity, Runnable runnable)
    {
        productlistactivity.b(runnable);
    }

    static boolean a(ProductListActivity productlistactivity, boolean flag)
    {
        productlistactivity.u = flag;
        return flag;
    }

    static int b(int i1)
    {
        C = i1;
        return i1;
    }

    private void b(View view, View view1, View view2, Runnable runnable)
    {
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04001c);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view2, view, view1, runnable) {

            final View a;
            final View b;
            final View c;
            final Runnable d;
            final ProductListActivity e;

            public void onAnimationEnd(Animation animation1)
            {
                animation1 = (TextView)e.findViewById(0x7f0a01d5);
                animation1.setText((new StringBuilder()).append("+").append(ProductListActivity.d()).toString());
                animation1.setVisibility(0);
                com.smule.pianoandroid.magicpiano.ProductListActivity.b(e, b, c, a, d);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
                a.setVisibility(0);
            }

            
            {
                e = ProductListActivity.this;
                a = view;
                b = view1;
                c = view2;
                d = runnable;
                super();
            }
        });
        view2.startAnimation(animation);
    }

    static void b(ProductListActivity productlistactivity, View view, View view1, View view2, Runnable runnable)
    {
        productlistactivity.c(view, view1, view2, runnable);
    }

    private void b(Runnable runnable)
    {
        if (com.smule.android.network.managers.a.a().a("sectionBarUids", "sectionBarUids", null) != null)
        {
            f();
            runnable.run();
        }
    }

    static int[] b(ProductListActivity productlistactivity)
    {
        return productlistactivity.A;
    }

    private View c(int i1)
    {
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f0a01d1);
        if (i1 == 0)
        {
            linearlayout.removeAllViews();
        }
        View view = getLayoutInflater().inflate(0x7f030067, null);
        linearlayout.addView(view);
        return view;
    }

    static com.smule.pianoandroid.magicpiano.b c(ProductListActivity productlistactivity)
    {
        return productlistactivity.l;
    }

    private void c(View view, View view1, View view2, Runnable runnable)
    {
        Object obj = new RotateAnimation(18F, 72F, 1, 0.5F, 1, 0.5F);
        ((RotateAnimation) (obj)).setDuration(1200L);
        ((RotateAnimation) (obj)).setInterpolator(new LinearInterpolator());
        view2.startAnimation(((Animation) (obj)));
        obj = findViewById(0x7f0a01d5);
        ((View) (obj)).startAnimation(AnimationUtils.loadAnimation(this, 0x7f040014));
        (new Handler()).postDelayed(new Runnable(((View) (obj))) {

            final View a;
            final ProductListActivity b;

            public void run()
            {
                a.startAnimation(AnimationUtils.loadAnimation(b, 0x7f040015));
            }

            
            {
                b = ProductListActivity.this;
                a = view;
                super();
            }
        }, 800L);
        Animation animation = AnimationUtils.loadAnimation(this, 0x7f04001e);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(((View) (obj)), view2, view, view1, runnable) {

            final View a;
            final View b;
            final View c;
            final View d;
            final Runnable e;
            final ProductListActivity f;

            public void onAnimationEnd(Animation animation1)
            {
                b.setVisibility(8);
                com.smule.pianoandroid.magicpiano.ProductListActivity.c(f, c, d, b, e);
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
                a.setVisibility(8);
            }

            
            {
                f = ProductListActivity.this;
                a = view;
                b = view1;
                c = view2;
                d = view3;
                e = runnable;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable(view2, animation) {

            final View a;
            final Animation b;
            final ProductListActivity c;

            public void run()
            {
                a.startAnimation(b);
            }

            
            {
                c = ProductListActivity.this;
                a = view;
                b = animation;
                super();
            }
        }, 1200L);
    }

    static void c(ProductListActivity productlistactivity, View view, View view1, View view2, Runnable runnable)
    {
        productlistactivity.d(view, view1, view2, runnable);
    }

    static int d()
    {
        return C;
    }

    static ProductListFragment d(ProductListActivity productlistactivity)
    {
        return productlistactivity.m;
    }

    private void d(View view, View view1, View view2, Runnable runnable)
    {
        view2 = new AnimationSet(true);
        view2.setFillAfter(true);
        view2.setInterpolator(new AccelerateInterpolator());
        Object obj = new com.smule.pianoandroid.c.a(0.0F, -0.6F, 0.0F, -0.7F, 1.0F, 0.1F, 1.0F, 0.1F, 1, 0.5F, 1, 0.5F);
        ((com.smule.pianoandroid.c.a) (obj)).setDuration(300L);
        view2.addAnimation(((Animation) (obj)));
        obj = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation) (obj)).setDuration(150L);
        ((AlphaAnimation) (obj)).setStartOffset(150L);
        view2.addAnimation(((Animation) (obj)));
        view2.setAnimationListener(new android.view.animation.Animation.AnimationListener(view1, view, runnable) {

            final View a;
            final View b;
            final Runnable c;
            final ProductListActivity d;

            public void onAnimationEnd(Animation animation)
            {
                a.setVisibility(8);
                b.setVisibility(8);
                com.smule.pianoandroid.magicpiano.ac.a().a("NOTIFICATION_ACHIEVEMENTS", ProductListActivity.d());
                com.smule.pianoandroid.magicpiano.ProductListActivity.b(0);
                if (c != null)
                {
                    c.run();
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                com.smule.pianoandroid.utils.n.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a(d), com.smule.pianoandroid.magicpiano.ProductListActivity.b(d)[1], 1.2F, false);
            }

            
            {
                d = ProductListActivity.this;
                a = view;
                b = view1;
                c = runnable;
                super();
            }
        });
        view1.startAnimation(view2);
    }

    private void e()
    {
        Map map = m.a().i();
        List list = a(i, map);
        int i1 = 0;
        while (i1 < list.size()) 
        {
            View view = (View)g.get(i1);
            if (map.containsKey(list.get(i1)))
            {
                view.setVisibility(0);
                Pair pair = (Pair)map.get(list.get(i1));
                ((TextView)view.findViewById(0x7f0a0208)).setText((CharSequence)pair.first);
                view.setTag(pair.second);
                if (((String)pair.first).toLowerCase().contains("jam"))
                {
                    e = (String)list.get(i1);
                    m.a(e);
                }
            } else
            {
                view.setVisibility(8);
            }
            i1++;
        }
        for (int j1 = list.size(); j1 < h; j1++)
        {
            ((View)g.get(j1)).setVisibility(8);
        }

    }

    static void e(ProductListActivity productlistactivity)
    {
        productlistactivity.e();
    }

    static PublisherAdView f(ProductListActivity productlistactivity)
    {
        return productlistactivity.k;
    }

    private void f()
    {
        i = com.smule.android.network.managers.a.a().a("sectionBarUids", "sectionBarUids", "my_songs").replaceAll("\\s", "").split(",");
        h = i.length;
        g = new ArrayList(h);
        for (int i1 = 0; i1 < h; i1++)
        {
            View view = c(i1);
            g.add(view);
            view.setOnClickListener(F);
        }

    }

    static ViewGroup g(ProductListActivity productlistactivity)
    {
        return productlistactivity.j;
    }

    private void g()
    {
        if (!MagicApplication.isAdvertisingEnabled().booleanValue())
        {
            return;
        } else
        {
            com.smule.pianoandroid.utils.n.a(this, new Runnable(j) {

                final ViewGroup a;
                final ProductListActivity b;

                public void run()
                {
                    if (com.smule.pianoandroid.utils.n.a("banner_source"))
                    {
                        b.spaceDidReceiveAd("PIANDROID_Songbook_Banner");
                        return;
                    }
                    if (com.smule.pianoandroid.utils.n.b("banner_source"))
                    {
                        com.smule.pianoandroid.magicpiano.ProductListActivity.a(b, new PublisherAdView(b));
                        com.smule.pianoandroid.magicpiano.ProductListActivity.f(b).setAdUnitId(MessageFormat.format("/{0}/{1}", new Object[] {
                            b.getString(0x7f0c00ce), b.getString(0x7f0c00cc)
                        }));
                        com.smule.pianoandroid.magicpiano.ProductListActivity.f(b).setAdSizes(new AdSize[] {
                            new AdSize(320, 40)
                        });
                        a.addView(com.smule.pianoandroid.magicpiano.ProductListActivity.f(b));
                        aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, "Loading DFP banner ");
                        com.smule.pianoandroid.magicpiano.ProductListActivity.f(b).setAdListener(new com.smule.pianoandroid.ads.b(com.smule.pianoandroid.magicpiano.ProductListActivity.f(b)));
                        com.smule.pianoandroid.magicpiano.ProductListActivity.f(b).setAppEventListener(new com.smule.pianoandroid.utils.b(b, null));
                        com.smule.pianoandroid.magicpiano.ProductListActivity.f(b).loadAd((new com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder()).addNetworkExtras(new AdMobExtras(com.smule.pianoandroid.utils.a.a(null))).build());
                        return;
                    } else
                    {
                        a.setVisibility(8);
                        return;
                    }
                }

            
            {
                b = ProductListActivity.this;
                a = viewgroup;
                super();
            }
            }).run();
            return;
        }
    }

    private void h()
    {
        aa.a(a, "onClose");
        u = false;
        findViewById(0x7f0a00a9).setVisibility(8);
        m.a().a("", Boolean.TRUE);
        findViewById(0x7f0a01d0).setVisibility(0);
        n.setVisibility(8);
    }

    static void h(ProductListActivity productlistactivity)
    {
        productlistactivity.h();
    }

    static TextView i(ProductListActivity productlistactivity)
    {
        return productlistactivity.n;
    }

    private void i()
    {
        Object obj;
        String s;
        s = null;
        obj = getIntent().getData();
        if (obj != null && v) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            {
                Object obj1 = ((Uri) (obj)).getPath();
                v = false;
                if (obj1 != null && ((String) (obj1)).startsWith("/songbook/smoola"))
                {
                    l.a(((Uri) (obj)));
                    return;
                }
                if (!"songbook".equals(((Uri) (obj)).getHost()))
                {
                    break label0;
                }
                obj = obj1;
                if (((String) (obj1)).startsWith("/"))
                {
                    obj = ((String) (obj1)).substring(1);
                }
                obj1 = obj;
                if (((String) (obj)).lastIndexOf("/") != -1)
                {
                    obj1 = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf("/"));
                }
                String s1;
                int i1;
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    obj = obj1;
                } else
                {
                    obj = null;
                }
            }
            aa.c(a, (new StringBuilder()).append("Jumping to : [").append(s).append("] : [").append(((String) (obj))).append("]").toString());
            if (s != null && obj == null)
            {
                m.d(s);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        s1 = ((Uri) (obj)).toString();
        i1 = s1.indexOf("/section/");
        if (i1 <= -1)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        i1 += 9;
        if (s1.indexOf("/", i1) != -1)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        obj1 = s1.substring(i1, s1.length());
_L5:
        i1 = s1.indexOf("/song/");
        obj = obj1;
        if (i1 > -1)
        {
            s = s1.substring(i1 + 6, s1.length());
            obj = obj1;
        }
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_121;
_L3:
        if (s != null && obj != null)
        {
            m.a(s, ((String) (obj)));
            return;
        }
        if (obj != null)
        {
            m.b(((String) (obj)));
            return;
        }
          goto _L1
        obj1 = null;
          goto _L5
    }

    static View j(ProductListActivity productlistactivity)
    {
        return productlistactivity.t;
    }

    public void a(aq aq)
    {
        m.a().notifyDataSetChanged();
    }

    public void a(ListingV2 listingv2, Runnable runnable, boolean flag)
    {
        listingv2 = new as(this, listingv2, com.smule.pianoandroid.e.c.a().b(listingv2.song.songId), runnable, flag);
        listingv2.a(this);
        listingv2.show();
    }

    public void a(Runnable runnable)
    {
        if ((d == null || TextUtils.isEmpty(d.getStringExtra("PRODUCT_UID"))) && C > 0)
        {
            a(findViewById(0x7f0a00a9), findViewById(0x7f0a01d4), findViewById(0x7f0a01d3), runnable);
        }
    }

    public void a(String s)
    {
        List list = ap.a().f();
        if (r.a(getApplicationContext()) && list != null && !list.isEmpty())
        {
            Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
            intent.putExtra("DESIRED_SUBSCRIPTION", s);
            startActivity(intent);
            overridePendingTransition(0x7f040013, 0x7f040011);
            return;
        } else
        {
            com.smule.android.network.core.b.d().p();
            return;
        }
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "Songbook";
    }

    public void b(String s)
    {
        if (s != null && g != null)
        {
            Iterator iterator = g.iterator();
            while (iterator.hasNext()) 
            {
                View view = (View)iterator.next();
                String s1 = ((TextView)view.findViewById(0x7f0a0208)).getText().toString();
                if (s1 != null)
                {
                    if (s.equals(s1))
                    {
                        view.setBackgroundResource(0x7f0201a8);
                    } else
                    {
                        view.setBackgroundResource(0x7f020192);
                    }
                }
            }
        }
    }

    public void c()
    {
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        aa.a(a, (new StringBuilder()).append("onActivityResult : ").append(i1).append("/").append(j1).append(" : ").append(this).toString());
        super.onActivityResult(i1, j1, intent);
        if (x.a(i1))
        {
            b = Integer.valueOf(i1);
            c = Integer.valueOf(j1);
            d = intent;
            return;
        } else
        {
            m.a(0xffff & i1, j1, intent);
            return;
        }
    }

    public void onAdClicked(String s)
    {
    }

    public void onAdClosed(String s)
    {
    }

    public void onAdOpened(String s)
    {
    }

    public void onApplicationExit(String s)
    {
    }

    public void onBackPressed()
    {
        aa.c(a, "OnBackPressed");
        if (u)
        {
            h();
            y.collapseActionView();
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(0x7f0c0032).setTitle(0x7f0c00fa).setPositiveButton(0x7f0c0153, new android.content.DialogInterface.OnClickListener() {

                final ProductListActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = ProductListActivity.this;
                super();
            }
            }).setNegativeButton(0x7f0c00fa, new android.content.DialogInterface.OnClickListener() {

                final ProductListActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.cancel();
                    a.finish();
                }

            
            {
                a = ProductListActivity.this;
                super();
            }
            });
            builder.show();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (isFinishing())
        {
            return;
        }
        setContentView(0x7f030057);
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.a);
        n = (TextView)findViewById(0x7f0a01e2);
        t = findViewById(0x1020004);
        m = (ProductListFragment)getSupportFragmentManager().findFragmentById(0x7f0a01d2);
        l = (com.smule.pianoandroid.magicpiano.b)getSupportFragmentManager().findFragmentById(0x7f0a0133);
        Object obj = new h(new Runnable() {

            final ProductListActivity a;

            public void run()
            {
                com.smule.pianoandroid.magicpiano.ProductListActivity.e(a);
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        }) {

            final Runnable a;
            final ProductListActivity b;

            public void a()
            {
                com.smule.pianoandroid.magicpiano.ProductListActivity.a(b, a);
            }

            
            {
                b = ProductListActivity.this;
                a = runnable;
                super();
            }
        };
        m.a(((h) (obj)));
        ((h) (obj)).a();
        m.a(e);
        setVolumeControlStream(3);
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("BALANCE_UPDATE_EVENT");
        ((IntentFilter) (obj)).addAction("SUBSCRIPTION_UPDATED");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(D, ((IntentFilter) (obj)));
        if (bundle != null)
        {
            v = bundle.getBoolean(f, true);
        }
        aa.a(a, "onCreate");
        onNewIntent(getIntent());
        x = new com.smule.pianoandroid.magicpiano.a.a(this);
        ar.a().a(this, true);
        aa.a(a, "Setting action bar");
        getActionBar().setCustomView(0x7f03001c);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().show();
        j = (ViewGroup)findViewById(0x7f0a006c);
        FlurryAds.setAdListener(this);
        A = new int[z.length];
        B = new SoundPool(1, 3, 0);
        for (int i1 = 0; i1 < z.length; i1++)
        {
            A[i1] = B.load(this, z[i1], 1);
        }

        com.smule.pianoandroid.utils.m.a(this);
        findViewById(0x7f0a00a9).setOnClickListener(new android.view.View.OnClickListener() {

            final ProductListActivity a;

            public void onClick(View view)
            {
            }

            
            {
                a = ProductListActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0002, menu);
        y = menu.findItem(0x7f0a024d);
        SearchView searchview = (SearchView)y.getActionView();
        searchview.setQueryHint(getString(0x7f0c0243));
        a(y, searchview);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        if (m != null && m.a() != null)
        {
            m.a().a(null);
        }
        if (k != null)
        {
            k.destroy();
        }
        if (x != null)
        {
            x.c();
        }
        int ai[] = A;
        int j1 = ai.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            int k1 = ai[i1];
            if (k1 != 0)
            {
                B.unload(k1);
            }
        }

        B.release();
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(D);
    }

    protected void onNewIntent(Intent intent)
    {
        aa.a(a, (new StringBuilder()).append("onNewIntent action=").append(intent.getAction()).append(" data=").append(intent.getDataString()).append(" type=").append(intent.getType()).append(" ").append(intent).toString());
        super.onNewIntent(intent);
        setIntent(intent);
        boolean flag;
        if (intent.getData() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        v = flag;
        i();
    }

    protected void onPause()
    {
        if (k != null)
        {
            k.pause();
        }
        x.b();
        com.smule.android.f.h.a().b("LEVEL_PROGRESS_UPDATED", E);
        super.onPause();
        MagicApplication.getInstance().onPause();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        if (w != null)
        {
            w.d();
            w = null;
        }
        if (b != null)
        {
            if (x.a(b.intValue(), c.intValue(), d))
            {
                String s = d.getStringExtra("PRODUCT_UID");
                com.smule.pianoandroid.utils.i.d().a(ak.a().f(s), false);
                w = new t(this);
                w.a(false);
                w.a(s);
            }
            b = null;
            c = null;
            d = null;
        }
        x.a();
    }

    public void onRenderFailed(String s)
    {
    }

    public void onRendered(String s)
    {
    }

    protected void onResume()
    {
        if (k != null)
        {
            k.resume();
        }
        super.onResume();
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.a);
        MagicApplication.getInstance().onResume();
        com.smule.pianoandroid.magicpiano.suggestions.c.a().b();
        if (!ap.a().c()) goto _L2; else goto _L1
_L1:
        if (!com.smule.pianoandroid.magicpiano.av.c(this))
        {
            com.smule.pianoandroid.magicpiano.av.a(this, true);
            Object obj = getString(0x7f0c01bf);
            String s = getString(0x7f0c01c8);
            Runnable runnable = new Runnable() {

                final ProductListActivity a;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.ProductListActivity.c(a).a(null);
                }

            
            {
                a = ProductListActivity.this;
                super();
            }
            };
            obj = com.smule.pianoandroid.magicpiano.n.a(this, 0x7f020122, ((String) (obj)), null, s, getString(0x7f0c01b3), getString(0x7f0c0224), null, runnable);
            ((Dialog) (obj)).setCancelable(false);
            q.z();
            ((Dialog) (obj)).show();
        }
_L4:
        com.smule.pianoandroid.e.i.a().c();
        g();
        com.smule.android.f.h.a().a("LEVEL_PROGRESS_UPDATED", E);
        return;
_L2:
        if (ap.a().b() && com.smule.pianoandroid.magicpiano.av.c(this))
        {
            com.smule.pianoandroid.magicpiano.av.a(this, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f, v);
    }

    protected void onStart()
    {
        MagicApplication.onActivityStart(this);
        super.onStart();
        FlurryAds.initializeAds(this);
        FlurryAds.setTargetingKeywords(com.smule.pianoandroid.utils.a.c());
        if (com.smule.pianoandroid.utils.n.a("banner_source"))
        {
            FlurryAds.fetchAd(this, "PIANDROID_Songbook_Banner", (ViewGroup)findViewById(0x7f0a006c), FlurryAdSize.BANNER_TOP);
        }
        q.o();
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }

    public void onVideoCompleted(String s)
    {
    }

    public boolean shouldDisplayAd(String s, FlurryAdType flurryadtype)
    {
        if (s.equals("PIANDROID_Songbook_Banner"))
        {
            return com.smule.pianoandroid.utils.n.a("banner_source");
        } else
        {
            return m.a(s, flurryadtype);
        }
    }

    public void spaceDidFailToReceiveAd(String s)
    {
        aa.a(a, (new StringBuilder()).append("Flurry spaceDidFailToReceiveAd ").append(s).toString());
    }

    public void spaceDidReceiveAd(String s)
    {
        aa.a(a, (new StringBuilder()).append("Flurry spaceDidReceiveAd ").append(s).toString());
        if (com.smule.pianoandroid.utils.n.a("banner_source") && s.equals("PIANDROID_Songbook_Banner"))
        {
            com.smule.pianoandroid.utils.n.c();
            runOnUiThread(new Runnable() {

                final ProductListActivity a;

                public void run()
                {
                    if (!a.isFinishing())
                    {
                        FlurryAds.displayAd(a, "PIANDROID_Songbook_Banner", ProductListActivity.g(a));
                    }
                }

            
            {
                a = ProductListActivity.this;
                super();
            }
            });
        } else
        if (com.smule.pianoandroid.utils.n.a("pre_free_download_source") && s.equals("PIANDROID_FreeDownload_FullScreen"))
        {
            m.f(s);
            return;
        }
    }

}
