// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.aq;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.content.ae;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.content.l;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.SearchView;
import com.wishabi.flipp.widget.ShoppingListPopup;
import com.wishabi.flipp.widget.ZeroCaseView;
import com.wishabi.flipp.widget.al;
import com.wishabi.flipp.widget.am;
import com.wishabi.flipp.widget.ci;
import com.wishabi.flipp.widget.cj;
import com.wishabi.flipp.widget.dr;
import com.wishabi.flipp.widget.ec;
import com.wishabi.flipp.widget.eg;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            dz, ef, eg, eh, 
//            ei, ej, en, bm, 
//            ec, ed, FlippApplication, ee, 
//            eb, ea, ek, el, 
//            em, dn

public class SearchFragment extends Fragment
    implements android.app.LoaderManager.LoaderCallbacks
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private final ec E = new dz(this);
    private final dn F = new ef(this);
    private final dn G = new com.wishabi.flipp.app.eg(this);
    private final dn H = new eh(this);
    private final dn I = new ei(this);
    private final dr J = new ej(this);
    String a;
    int b;
    private SearchView c;
    private List d;
    private Cursor e;
    private Cursor f;
    private ae g;
    private SparseBooleanArray h;
    private HashMap i;
    private Cursor j;
    private Cursor k;
    private HashMap l;
    private boolean m;
    private CollectionView n;
    private ShoppingListPopup o;
    private ZeroCaseView p;
    private ZeroCaseView q;
    private ci r;
    private al s;
    private View t;
    private aq u;
    private boolean v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    public SearchFragment()
    {
        w = 0;
    }

    static int a(SearchFragment searchfragment, int i1)
    {
        searchfragment.w = i1;
        return i1;
    }

    private com.wishabi.flipp.content.Flyer.Model a(int i1, RectF rectf, Boolean boolean1)
    {
        com.wishabi.flipp.content.Flyer.Model model;
        Activity activity;
        model = null;
        activity = getActivity();
        if (activity == null)
        {
            return null;
        }
        Cursor cursor = activity.getContentResolver().query(i.a, null, "flyer_id = ?", new String[] {
            String.valueOf(i1)
        }, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        boolean flag = cursor.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        model = new com.wishabi.flipp.content.Flyer.Model(cursor);
        if (cursor != null)
        {
            cursor.close();
        }
        if (boolean1 != null)
        {
            model.e = boolean1.booleanValue();
        }
        if (b == en.b)
        {
            activity.startActivity(new FlyerActivityIntent(activity, model, rectf, bm.b));
        } else
        {
            activity.startActivity(new FlyerActivityIntent(activity, model, rectf));
        }
        activity.overridePendingTransition(0x7f040001, 0x7f040002);
        return model;
        rectf;
        boolean1 = model;
_L2:
        if (boolean1 != null)
        {
            boolean1.close();
        }
        throw rectf;
        rectf;
        boolean1 = cursor;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static com.wishabi.flipp.content.Flyer.Model a(SearchFragment searchfragment, int i1, RectF rectf, Boolean boolean1)
    {
        return searchfragment.a(i1, rectf, boolean1);
    }

    static List a(SearchFragment searchfragment, List list)
    {
        searchfragment.d = list;
        return list;
    }

    static void a(SearchFragment searchfragment)
    {
        searchfragment.b();
    }

    static Cursor b(SearchFragment searchfragment)
    {
        return searchfragment.f;
    }

    private void b()
    {
        if (!e() || !f()) goto _L2; else goto _L1
_L1:
        boolean flag;
        if ((i != null || !z) && (l != null || !A))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag) goto _L3; else goto _L2
_L2:
        return;
_L3:
        n.setEmptyView(null);
        r = null;
        s = null;
        switch (w)
        {
        default:
            throw new IllegalStateException("Invalid search tab clicked");

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            Activity activity1 = getActivity();
            if (activity1 != null && e())
            {
                Cursor cursor1 = e;
                Object obj;
                ae ae1;
                List list;
                HashMap hashmap;
                SparseBooleanArray sparsebooleanarray;
                ZeroCaseView zerocaseview;
                dn dn;
                dn dn1;
                int i1;
                int k1;
                int i2;
                if (y)
                {
                    obj = f;
                } else
                {
                    obj = null;
                }
                if (y)
                {
                    ae1 = g;
                } else
                {
                    ae1 = null;
                }
                if (z)
                {
                    list = d;
                } else
                {
                    list = null;
                }
                sparsebooleanarray = h;
                if (z)
                {
                    hashmap = i;
                } else
                {
                    hashmap = null;
                }
                zerocaseview = p;
                dn = G;
                dn1 = F;
                k1 = w;
                i2 = h();
                if (j != null)
                {
                    i1 = j.getCount();
                } else
                {
                    i1 = 0;
                }
                r = new ci(activity1, cursor1, ((Cursor) (obj)), ae1, list, sparsebooleanarray, hashmap, zerocaseview, dn, dn1, k1, i2, i1, E);
                n.setAdapter(r);
                obj = new eg(activity1);
                obj.b = new cj(activity1, n);
                n.setLayout(((com.wishabi.flipp.widget.n) (obj)));
                n.setOnItemClickListener(new com.wishabi.flipp.app.ec(this));
                com.wishabi.flipp.app.FlippApplication.a(new ed(this));
            }
            break;
        }
_L5:
        c();
        if (!D)
        {
            d();
            D = true;
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
        Activity activity = getActivity();
        if (activity != null && f())
        {
            Cursor cursor = j;
            Object obj1;
            HashMap hashmap1;
            int j1;
            int l1;
            int j2;
            if (B)
            {
                obj1 = k;
            } else
            {
                obj1 = null;
            }
            hashmap1 = l;
            l1 = w;
            j2 = h();
            if (j != null)
            {
                j1 = j.getCount();
            } else
            {
                j1 = 0;
            }
            s = new al(activity, cursor, ((Cursor) (obj1)), hashmap1, l1, j2, j1, C, q, E, H, I);
            n.setAdapter(s);
            obj1 = new eg(activity);
            obj1.b = new am(activity, n);
            n.setLayout(((com.wishabi.flipp.widget.n) (obj1)));
        }
          goto _L5
        if (true) goto _L2; else goto _L6
_L6:
    }

    static ae c(SearchFragment searchfragment)
    {
        return searchfragment.g;
    }

    private void c()
    {
        boolean flag1;
        if (e != null)
        {
            e.moveToFirst();
            int i1 = e.getColumnIndexOrThrow("merchant");
            boolean flag = false;
            do
            {
                flag1 = flag;
                if (e.isAfterLast())
                {
                    break;
                }
                flag1 = flag;
                if (flag)
                {
                    break;
                }
                if (e.getString(i1).equalsIgnoreCase(a))
                {
                    flag = true;
                }
                e.moveToNext();
            } while (true);
        } else
        {
            flag1 = false;
        }
        if (m && !flag1)
        {
            o.a(a, false);
            return;
        } else
        {
            o.a(false);
            return;
        }
    }

    static List d(SearchFragment searchfragment)
    {
        return searchfragment.d;
    }

    private void d()
    {
        boolean flag = false;
        com.wishabi.flipp.app.ee.a[b - 1];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 107
    //                   2 100
    //                   3 114;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_114;
_L1:
        Object obj = "";
_L5:
        int l1;
        if (i != null)
        {
            Iterator iterator = i.values().iterator();
            int i1 = 0;
            do
            {
                l1 = i1;
                if (!iterator.hasNext())
                {
                    break;
                }
                i1 = ((ArrayList)iterator.next()).size() + i1;
            } while (true);
        } else
        {
            l1 = 0;
        }
        break MISSING_BLOCK_LABEL_124;
_L3:
        obj = "global";
          goto _L5
_L2:
        obj = "sl";
          goto _L5
        obj = "global";
          goto _L5
        int i2;
        if (l != null)
        {
            Iterator iterator1 = l.values().iterator();
            int j1 = 0;
            do
            {
                i2 = j1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                j1 = ((ArrayList)iterator1.next()).size() + j1;
            } while (true);
        } else
        {
            i2 = 0;
        }
        a a1 = a.a;
        String s2 = a;
        int k1;
        int j2;
        int k2;
        if (e != null)
        {
            k1 = e.getCount();
        } else
        {
            k1 = 0;
        }
        if (d != null)
        {
            j2 = d.size();
        } else
        {
            j2 = 0;
        }
        if (j != null)
        {
            k2 = j.getCount();
        } else
        {
            k2 = 0;
        }
        if (s2 != null)
        {
            String as[] = s2.split(" ", 2);
            String s1;
            HashMap hashmap;
            int l2;
            if (as.length > 1 && com.wishabi.flipp.util.q.b(as[0]))
            {
                s1 = as[1];
            } else
            {
                s1 = s2;
            }
            l2 = k1 + j2 + k2;
            hashmap = new HashMap();
            hashmap.put("q", s1);
            hashmap.put("q_raw", s2);
            hashmap.put("postal_code", a1.k);
            hashmap.put("flyer_count", String.valueOf(k1));
            hashmap.put("item_count", String.valueOf(j2));
            hashmap.put("coupon_count", String.valueOf(k2));
            hashmap.put("flyer_match_count", String.valueOf(l1));
            hashmap.put("coupon_match_count", String.valueOf(i2));
            hashmap.put("count", String.valueOf(l2));
            hashmap.put("mode", obj);
            com.wishabi.flipp.b.a.b("Searched", hashmap);
            a1.a("searched", hashmap, false);
            a1.a("searched", (new StringBuilder("searched | ")).append(((String) (obj))).toString(), (new StringBuilder("searched | ")).append(((String) (obj))).append(" | ").append(s1).toString(), Long.valueOf(l2));
            obj = new Bundle();
            ((Bundle) (obj)).putString("fb_search_string", s1);
            k1 = ((flag) ? 1 : 0);
            if (l2 > 0)
            {
                k1 = 1;
            }
            ((Bundle) (obj)).putInt("fb_success", k1);
            a1.a("fb_mobile_search", ((Bundle) (obj)));
        }
        return;
    }

    static HashMap e(SearchFragment searchfragment)
    {
        return searchfragment.i;
    }

    private boolean e()
    {
        return (d != null || !z) && (e != null || !x) && (f != null || !y);
    }

    static String f(SearchFragment searchfragment)
    {
        return searchfragment.a;
    }

    private boolean f()
    {
        return j != null || !A;
    }

    static Cursor g(SearchFragment searchfragment)
    {
        return searchfragment.j;
    }

    private void g()
    {
        Object obj;
        for (obj = FlippApplication.b(); obj == null || c == null || b == 0;)
        {
            return;
        }

        if (b == en.c)
        {
            c.setQueryHint(((Context) (obj)).getString(0x7f0e011f));
        }
        obj = new Bundle();
        ((Bundle) (obj)).putInt("search_mode", b - 1);
        c.setSearchExtraData("com.wishabi.flipp.search_bundle", ((Bundle) (obj)));
    }

    private int h()
    {
        int j1 = 0;
        int i1 = j1;
        if (z)
        {
            i1 = j1;
            if (d != null)
            {
                i1 = d.size() + 0;
            }
        }
        j1 = i1;
        if (x)
        {
            j1 = i1;
            if (e != null)
            {
                j1 = i1 + e.getCount();
            }
        }
        return j1;
    }

    static HashMap h(SearchFragment searchfragment)
    {
        return searchfragment.l;
    }

    static Cursor i(SearchFragment searchfragment)
    {
        return searchfragment.k;
    }

    static void j(SearchFragment searchfragment)
    {
        searchfragment.o.a(false);
        searchfragment.m = false;
    }

    static aq k(SearchFragment searchfragment)
    {
        searchfragment.u = null;
        return null;
    }

    static boolean l(SearchFragment searchfragment)
    {
        return searchfragment.A;
    }

    static boolean m(SearchFragment searchfragment)
    {
        return searchfragment.B;
    }

    static boolean n(SearchFragment searchfragment)
    {
        return searchfragment.y;
    }

    static ZeroCaseView o(SearchFragment searchfragment)
    {
        return searchfragment.p;
    }

    static CollectionView p(SearchFragment searchfragment)
    {
        return searchfragment.n;
    }

    static ci q(SearchFragment searchfragment)
    {
        return searchfragment.r;
    }

    static boolean r(SearchFragment searchfragment)
    {
        return searchfragment.z;
    }

    public final void a()
    {
        n.setAdapter(null);
        n.setEmptyView(null);
        n.scrollTo(0, 0);
        a = null;
        m = false;
        if (u != null)
        {
            u.cancel(true);
            u = null;
        }
        d = null;
        f = null;
        e = null;
        h = null;
        j = null;
        l = null;
        i = null;
        D = false;
    }

    public final void a(int i1)
    {
        com.wishabi.flipp.app.ee.a[i1 - 1];
        JVM INSTR tableswitch 1 3: default 32
    //                   1 43
    //                   2 88
    //                   3 126;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("Invalid search mode");
_L2:
        v = false;
        x = false;
        y = true;
        z = true;
        A = true;
        B = true;
        C = false;
_L6:
        b = i1;
        g();
        return;
_L3:
        v = true;
        x = true;
        y = false;
        z = true;
        A = true;
        B = false;
        C = true;
        continue; /* Loop/switch isn't completed */
_L4:
        v = true;
        int j1;
        if (b == 0)
        {
            j1 = 1;
        } else
        {
            j1 = w;
        }
        w = j1;
        x = true;
        y = false;
        z = true;
        A = true;
        B = false;
        C = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(String s1, boolean flag)
    {
        Activity activity = getActivity();
        String s2;
        if (activity != null)
        {
            if ((s2 = com.wishabi.flipp.util.k.a(null)) != null)
            {
                a();
                a = s1;
                m = flag;
                n.setEmptyView(t);
                s1 = a;
                if (b == com.wishabi.flipp.app.en.a)
                {
                    p.setIcon(0x7f0200bf);
                    p.setTitle(0x7f0e00f1);
                    p.setSubTitle(0x7f0e00f4);
                    p.a(getString(0x7f0e00f6, new Object[] {
                        s1
                    }), new eb(this, s1));
                } else
                {
                    p.setIcon(0x7f0200d7);
                    p.setTitle(getString(0x7f0e00f3, new Object[] {
                        s1
                    }));
                    p.setSubTitle(0x7f0e00f2);
                    p.a();
                }
                q.setIcon(0x7f0200d7);
                q.setTitle(getString(0x7f0e00f3, new Object[] {
                    s1
                }));
                q.setSubTitle(0x7f0e00f2);
                s1 = getLoaderManager();
                if (s1 != null)
                {
                    if (x)
                    {
                        s1.restartLoader(0, null, this);
                        s1.restartLoader(1, null, this);
                    }
                    if (y || z || A || B)
                    {
                        if (u != null)
                        {
                            u.cancel(true);
                        }
                        u = new ea(this, activity, activity.getContentResolver(), s2, a, s1);
                        u.execute(new Void[0]);
                        return;
                    }
                }
            }
        }
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        Activity activity = getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        switch (i1)
        {
        default:
            throw new InvalidParameterException("Invalid loader id");

        case 1: // '\001'
            return new CursorLoader(activity, i.h, null, null, null, null);

        case 0: // '\0'
            if (a != null)
            {
                bundle = com.wishabi.flipp.util.k.a(null);
                if (bundle != null)
                {
                    return new CursorLoader(activity, i.a, null, "postal_code = ? AND merchant like ?", new String[] {
                        bundle, (new StringBuilder("%")).append(a).append('%').toString()
                    }, "premium DESC, merchant ASC");
                }
            }
            break;

        case 2: // '\002'
            bundle = bundle.getLongArray("item_ids");
            if (bundle != null)
            {
                bundle = com.wishabi.flipp.util.q.a(bundle);
                return new CursorLoader(activity, i.g, null, com.wishabi.flipp.util.f.a("_id", bundle), bundle, null);
            }
            break;

        case 4: // '\004'
            bundle = bundle.getIntArray("coupon_ids");
            if (bundle != null)
            {
                Object obj = com.wishabi.flipp.util.q.a(bundle);
                String s1 = com.wishabi.flipp.util.f.a("c._id", ((String []) (obj)), false);
                android.net.Uri uri1;
                if (s1 != null)
                {
                    bundle = (String[])com.wishabi.flipp.util.a.a(((Object []) (obj)), ((Object []) (obj)));
                } else
                {
                    bundle = ((Bundle) (obj));
                }
                uri1 = i.q;
                obj = (new StringBuilder()).append(com.wishabi.flipp.util.f.a("c._id", ((String []) (obj)))).append(" AND deleted = 0").toString();
                return new CursorLoader(activity, uri1, new String[] {
                    "*", "sent", "clipped"
                }, ((String) (obj)), bundle, s1);
            }
            break;

        case 5: // '\005'
            bundle = bundle.getIntArray("coupon_ids");
            if (bundle != null)
            {
                bundle = com.wishabi.flipp.util.q.a(bundle);
                android.net.Uri uri = i.q;
                String s2 = (new StringBuilder()).append(com.wishabi.flipp.util.f.a("c._id", bundle)).append(" AND clipped = 1 AND deleted = 0").toString();
                return new CursorLoader(activity, uri, new String[] {
                    "*", "sent", "clipped"
                }, s2, bundle, null);
            }
            break;

        case 6: // '\006'
            bundle = bundle.getIntArray("coupon_ids");
            if (bundle != null)
            {
                return com.wishabi.flipp.content.l.a(activity, bundle, false, true);
            }
            break;

        case 3: // '\003'
            bundle = bundle.getLongArray("item_ids");
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (bundle == null) goto _L1; else goto _L4
_L4:
        return com.wishabi.flipp.content.l.a(activity, bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f100009, menu);
        menuinflater = getActivity();
        menu = menu.findItem(0x7f0b0155);
        if (menu != null && menuinflater != null)
        {
            if (!v)
            {
                menu.setVisible(false);
                return;
            }
            c = (SearchView)menu.getActionView();
            if (c != null)
            {
                menu = (SearchManager)menuinflater.getSystemService("search");
                c.setSearchableInfo(menu.getSearchableInfo(menuinflater.getComponentName()));
                c.setIconifiedByDefault(false);
                c.setQuery(a, false);
                c.setFocusable(false);
                g();
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        setHasOptionsMenu(true);
        layoutinflater = layoutinflater.inflate(0x7f03004a, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        viewgroup = getActivity();
        if (viewgroup == null)
        {
            return null;
        }
        p = new ZeroCaseView(viewgroup);
        p.setOnTouchListener(new ek(this));
        q = new ZeroCaseView(viewgroup);
        q.setOnTouchListener(new el(this));
        t = layoutinflater.findViewById(0x7f0b0078);
        viewgroup = (LinearLayout)layoutinflater.findViewById(0x7f0b0118);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        LayoutTransition layouttransition = new LayoutTransition();
        android.animation.Animator animator = AnimatorInflater.loadAnimator(getActivity(), 0x7f050001);
        android.animation.Animator animator1 = AnimatorInflater.loadAnimator(getActivity(), 0x7f050003);
        layouttransition.setAnimator(2, animator);
        layouttransition.setAnimator(3, animator1);
        layouttransition.setStartDelay(2, 0L);
        layouttransition.setStartDelay(3, 0L);
        layouttransition.setStartDelay(0, 0L);
        layouttransition.setStartDelay(1, 0L);
        layouttransition.setDuration(200L);
        layouttransition.setInterpolator(2, linearinterpolator);
        layouttransition.setInterpolator(3, linearinterpolator);
        layouttransition.setInterpolator(0, linearinterpolator);
        layouttransition.setInterpolator(1, linearinterpolator);
        viewgroup.setLayoutTransition(layouttransition);
        n = (CollectionView)layoutinflater.findViewById(0x7f0b003f);
        n.setOnTouchListener(new em(this));
        o = (ShoppingListPopup)layoutinflater.findViewById(0x7f0b00ad);
        o.setShoppingListPopupListener(J);
        o.a(false);
        if (bundle != null)
        {
            int i1 = bundle.getInt("search_mode", -1);
            if (i1 != -1)
            {
                a(com.wishabi.flipp.app.en.a()[i1]);
            }
            w = bundle.getInt("SAVE_STATE_SEARCH_TAB_KEY");
            viewgroup = bundle.getString("mQuery");
            if (!TextUtils.isEmpty(viewgroup))
            {
                a(viewgroup, false);
            } else
            {
                a();
            }
            if (!bundle.getBoolean("SAVE_STATE_REQUEST_BUTTON_KEY", true))
            {
                p.setIcon(0x7f0200c4);
                p.setTitle(0x7f0e00f5);
                p.setSubTitle(null);
                p.a();
            }
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (u != null)
        {
            u.cancel(true);
            u = null;
        }
    }

    public void onHiddenChanged(boolean flag)
    {
        super.onHiddenChanged(flag);
        if (!flag)
        {
            a.a.a("search");
        }
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        switch (loader.getId())
        {
        default:
            throw new IllegalStateException("Invalid loader for search fragment");

        case 1: // '\001'
            h = new SparseBooleanArray();
            for (boolean flag = ((Cursor) (obj)).moveToFirst(); flag; flag = ((Cursor) (obj)).moveToNext())
            {
                h.put(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id")), true);
            }

            b();
            return;

        case 0: // '\0'
            e = ((Cursor) (obj));
            b();
            return;

        case 2: // '\002'
            f = ((Cursor) (obj));
            g = new ae(f);
            b();
            return;

        case 4: // '\004'
            j = ((Cursor) (obj));
            b();
            return;

        case 5: // '\005'
            k = ((Cursor) (obj));
            b();
            return;

        case 6: // '\006'
            l = com.wishabi.flipp.content.l.b(((Cursor) (obj)));
            b();
            return;

        case 3: // '\003'
            i = com.wishabi.flipp.content.l.a(((Cursor) (obj)));
            b();
            return;
        }
    }

    public void onLoaderReset(Loader loader)
    {
        loader.getId();
        JVM INSTR tableswitch 0 6: default 48
    //                   0 69
    //                   1 59
    //                   2 77
    //                   3 109
    //                   4 85
    //                   5 93
    //                   6 101;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        throw new IllegalStateException("Invalid loader for search fragment");
_L3:
        h = null;
_L10:
        b();
        return;
_L2:
        e = null;
        continue; /* Loop/switch isn't completed */
_L4:
        f = null;
        continue; /* Loop/switch isn't completed */
_L6:
        j = null;
        continue; /* Loop/switch isn't completed */
_L7:
        k = null;
        continue; /* Loop/switch isn't completed */
_L8:
        l = null;
        continue; /* Loop/switch isn't completed */
_L5:
        i = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onResume()
    {
        super.onResume();
        a.a.a("search");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("mQuery", a);
        bundle.putInt("SAVE_STATE_SEARCH_TAB_KEY", w);
        bundle.putInt("search_mode", b - 1);
        if (b == com.wishabi.flipp.app.en.a)
        {
            bundle.putBoolean("SAVE_STATE_REQUEST_BUTTON_KEY", p.b());
        }
    }
}
