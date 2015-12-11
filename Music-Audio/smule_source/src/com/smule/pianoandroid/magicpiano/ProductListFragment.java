// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.crittercism.app.Crittercism;
import com.flurry.android.FlurryAdType;
import com.foound.widget.AmazingListView;
import com.smule.android.c.aa;
import com.smule.android.c.m;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.StoreSectionV2;
import com.smule.pianoandroid.ads.h;
import com.smule.pianoandroid.data.db.d;
import com.smule.pianoandroid.e.c;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.utils.i;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.t;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ak, am, t, ProductListActivity, 
//            MagicApplication, ai, av, ProductListItem, 
//            ListingListItem

public class ProductListFragment extends ListFragment
    implements com.smule.pianoandroid.magicpiano.ak, am, com.smule.pianoandroid.magicpiano.t
{

    public static String a = "";
    public static int b = 0;
    public static String c = "";
    static final boolean d;
    private static final String e = com/smule/pianoandroid/magicpiano/ProductListFragment.getName();
    private com.smule.pianoandroid.data.db.c f;
    private AmazingListView g;
    private Context h;
    private h i;
    private String j;
    private t k;
    private String l;
    private Runnable m;
    private String n;
    private String o;
    private String p;

    public ProductListFragment()
    {
        j = null;
        m = new Runnable() {

            final ProductListFragment a;

            public void run()
            {
                (new AsyncTask(this) {

                    ListingV2 a;
                    final _cls1 b;

                    protected transient Void a(Void avoid[])
                    {
                        if (com.smule.pianoandroid.magicpiano.ProductListFragment.a(b.a) != null)
                        {
                            a = com.smule.pianoandroid.utils.i.d().a();
                        }
                        return null;
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

            
            {
                b = _pcls1;
                super();
            }
                }).execute((Void[])null);
            }

            
            {
                a = ProductListFragment.this;
                super();
            }
        };
    }

    static String a(ProductListFragment productlistfragment)
    {
        return productlistfragment.j;
    }

    static String a(ProductListFragment productlistfragment, String s)
    {
        productlistfragment.n = s;
        return s;
    }

    private void a(String s, String s1, String s2)
    {
        n = s;
        o = s1;
        p = s2;
    }

    static String b(ProductListFragment productlistfragment, String s)
    {
        productlistfragment.o = s;
        return s;
    }

    static void b(ProductListFragment productlistfragment)
    {
        productlistfragment.h();
    }

    static String c(ProductListFragment productlistfragment)
    {
        return productlistfragment.p;
    }

    static String c(ProductListFragment productlistfragment, String s)
    {
        productlistfragment.p = s;
        return s;
    }

    static String d()
    {
        return e;
    }

    static String d(ProductListFragment productlistfragment)
    {
        return productlistfragment.n;
    }

    private void d(ListingV2 listingv2)
    {
label0:
        {
            if (listingv2 != null)
            {
                StoreSectionV2 storesectionv2 = ak.a().e(listingv2.listingId);
                if (storesectionv2 != null)
                {
                    a = storesectionv2.sectionId;
                } else
                {
                    a = "my_songs";
                }
                com.smule.pianoandroid.utils.i.d().a(listingv2, listingv2.b());
                if (!com.smule.android.network.managers.i.a().c(listingv2.song.songId) && !ap.a().b())
                {
                    break label0;
                }
                k.b(listingv2.song);
            }
            return;
        }
        k.a(listingv2);
    }

    static String e(ProductListFragment productlistfragment)
    {
        return productlistfragment.o;
    }

    private void e()
    {
        ListingV2 listingv2 = com.smule.pianoandroid.utils.i.d().a();
        Object obj = com.smule.pianoandroid.e.c.a().b(listingv2.productId);
        if (listingv2.isFree && obj == null)
        {
            try
            {
                if (i.a(getActivity(), 0x7f0a00b5))
                {
                    j = listingv2.listingId;
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                aa.b(e, "Failed to load ad", ((Throwable) (obj)));
            }
            j = null;
            g(listingv2);
            return;
        } else
        {
            com.smule.pianoandroid.utils.o.a(getActivity(), listingv2, ((Integer) (obj)), new Runnable() {

                final ProductListFragment a;

                public void run()
                {
                    ProductListFragment.b(a);
                }

            
            {
                a = ProductListFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void e(ListingV2 listingv2)
    {
        if (r.a(getActivity()))
        {
            ((ProductListActivity)getActivity()).a(listingv2, null, false);
            return;
        } else
        {
            MagicApplication.getInstance().showToast(h.getString(0x7f0c02c6), 0);
            return;
        }
    }

    static String f(ProductListFragment productlistfragment)
    {
        return productlistfragment.l;
    }

    private void f()
    {
        q.B();
    }

    private void f(ListingV2 listingv2)
    {
        Crittercism.a((new StringBuilder()).append("Renewing for song ").append(listingv2.song.songId).append(" player ").append(UserManager.n().c()).toString());
        Crittercism.a(new Exception((new StringBuilder()).append("Renewing for song ").append(listingv2.song.songId).append(" player ").append(UserManager.n().c()).toString()));
        if (r.a(h))
        {
            ((ProductListActivity)getActivity()).a(listingv2, new Runnable(listingv2) {

                final ListingV2 a;
                final ProductListFragment b;

                public void run()
                {
                    if (!a.subscriberOnly)
                    {
                        ProductListFragment.b(b);
                    }
                }

            
            {
                b = ProductListFragment.this;
                a = listingv2;
                super();
            }
            }, true);
            return;
        } else
        {
            MagicApplication.getInstance().showToast(h.getString(0x7f0c02c6), 0);
            return;
        }
    }

    private void g()
    {
        q.B();
        while (i() || p == null && n == null && p == null) 
        {
            return;
        }
        getActivity().findViewById(0x1020004).setVisibility(0);
        (new Handler()).postDelayed(new Runnable() {

            final ProductListFragment a;

            public void run()
            {
                if (com.smule.pianoandroid.magicpiano.ProductListFragment.c(a) == null) goto _L2; else goto _L1
_L1:
                a.e(com.smule.pianoandroid.magicpiano.ProductListFragment.c(a));
_L4:
                com.smule.pianoandroid.magicpiano.ProductListFragment.a(a, null);
                ProductListFragment.b(a, null);
                com.smule.pianoandroid.magicpiano.ProductListFragment.c(a, null);
                FragmentActivity fragmentactivity = a.getActivity();
                if (fragmentactivity != null)
                {
                    fragmentactivity.findViewById(0x1020004).setVisibility(8);
                }
                return;
_L2:
                if (com.smule.pianoandroid.magicpiano.ProductListFragment.d(a) != null && ProductListFragment.e(a) != null)
                {
                    a.b(ProductListFragment.e(a), com.smule.pianoandroid.magicpiano.ProductListFragment.d(a));
                } else
                if (com.smule.pianoandroid.magicpiano.ProductListFragment.d(a) != null)
                {
                    a.c(com.smule.pianoandroid.magicpiano.ProductListFragment.d(a));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ProductListFragment.this;
                super();
            }
        }, 1500L);
    }

    private void g(ListingV2 listingv2)
    {
        j = null;
        if (listingv2.b())
        {
            com.smule.pianoandroid.magicpiano.ai.a(getActivity(), listingv2, false, this).show();
            return;
        } else
        {
            k.b(listingv2);
            return;
        }
    }

    static void g(ProductListFragment productlistfragment)
    {
        productlistfragment.g();
    }

    private void h()
    {
        ListingV2 listingv2 = com.smule.pianoandroid.utils.i.d().a();
        k.c(listingv2);
    }

    static void h(ProductListFragment productlistfragment)
    {
        productlistfragment.f();
    }

    private boolean i()
    {
        if (getActivity().isFinishing() || l == null || l.equals(""))
        {
            return false;
        }
        aa.a(e, (new StringBuilder()).append("Days since install : ").append(UserManager.n().k()).toString());
        if (UserManager.n().k() >= 2 && !av.f(getActivity()))
        {
            com.smule.pianoandroid.utils.o.c(getActivity(), new Runnable() {

                final ProductListFragment a;

                public void run()
                {
                    aa.a(com.smule.pianoandroid.magicpiano.ProductListFragment.d(), (new StringBuilder()).append("Jumping to jam section ").append(ProductListFragment.f(a)).toString());
                    if (ProductListFragment.f(a) != null && !ProductListFragment.f(a).equals(""))
                    {
                        a.c(ProductListFragment.f(a));
                    }
                }

            
            {
                a = ProductListFragment.this;
                super();
            }
            });
            com.smule.pianoandroid.magicpiano.av.c(getActivity(), true);
            return true;
        } else
        {
            return false;
        }
    }

    public com.smule.pianoandroid.data.db.c a()
    {
        return f;
    }

    public void a(int i1)
    {
        g.a(i1);
        c = b(i1);
    }

    public void a(int i1, int j1, Intent intent)
    {
        if (i1 != 214) goto _L2; else goto _L1
_L1:
        if (j1 != 215) goto _L4; else goto _L3
_L3:
        if (intent != null) goto _L6; else goto _L5
_L5:
        aa.c(e, "On resume purchase result, did not get valid resultData");
_L8:
        return;
_L6:
        intent = intent.getStringExtra(i.a);
        if (intent == null)
        {
            aa.c(e, "On resume purchase result, resultData does not contain desiredListing extra");
            return;
        } else
        {
            (new AsyncTask(intent) {

                final String a;
                final ProductListFragment b;

                protected transient Integer a(Integer ainteger[])
                {
                    return null;
                }

                protected void a(Integer integer)
                {
                    integer = ak.a().i(a);
                    aa.c(com.smule.pianoandroid.magicpiano.ProductListFragment.d(), (new StringBuilder()).append("Resuming user purchase flow of listing with uid: ").append(((ListingV2) (integer)).productId).toString());
                    com.smule.pianoandroid.utils.i.d().a(integer, false);
                    ProductListFragment.b(b);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Integer[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Integer)obj);
                }

            
            {
                b = ProductListFragment.this;
                a = s;
                super();
            }
            }).execute(new Integer[] {
                Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)
            });
            return;
        }
_L4:
        if (j1 == 216)
        {
            intent = intent.getStringExtra(i.a);
            if (intent == null)
            {
                aa.c(e, "On resume purchase result, resultData does not contain desiredListing extra");
                return;
            } else
            {
                c(ak.a().i(intent));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 == 213)
        {
            if (j1 == 1)
            {
                (new AsyncTask() {

                    final ProductListFragment a;

                    protected transient Integer a(Integer ainteger[])
                    {
                        return null;
                    }

                    protected void a(Integer integer)
                    {
                        a.c(com.smule.pianoandroid.utils.i.d().a());
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Integer[])aobj);
                    }

                    protected void onPostExecute(Object obj)
                    {
                        a((Integer)obj);
                    }

            
            {
                a = ProductListFragment.this;
                super();
            }
                }).execute(new Integer[] {
                    Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)
                });
                return;
            }
        } else
        {
            aa.b(e, (new StringBuilder()).append("Unhandled activity result : ").append(i1).append("/").append(j1).toString());
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(ListingV2 listingv2)
    {
        d(listingv2);
    }

    public void a(ListingV2 listingv2, boolean flag)
    {
        boolean flag1;
        if (com.smule.android.network.managers.i.a().c(listingv2.productId) || ap.a().b())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(listingv2.song, flag);
        if (Boolean.valueOf(flag1).booleanValue())
        {
            com.smule.pianoandroid.utils.i.d().a(listingv2, flag);
            k.a(listingv2, flag);
        } else
        if (listingv2.isFree)
        {
            k.b(listingv2);
            return;
        }
    }

    void a(SongV2 songv2, boolean flag)
    {
        q.a(songv2, a, Integer.valueOf(b));
        if (flag && !com.smule.pianoandroid.magicpiano.c.a.a().h())
        {
            q.m(songv2.songId);
        }
    }

    public void a(com.smule.pianoandroid.data.db.h h1)
    {
        f.a(h1);
    }

    public void a(String s)
    {
        l = s;
    }

    public void a(String s, String s1)
    {
        if (f.e().booleanValue())
        {
            b(s, s1);
            return;
        } else
        {
            a(s1, s, ((String) (null)));
            return;
        }
    }

    public boolean a(String s, FlurryAdType flurryadtype)
    {
        return i.b();
    }

    public String b(int i1)
    {
        return g.b(i1);
    }

    public void b()
    {
        g.setSelection(0);
    }

    public void b(ListingV2 listingv2)
    {
        d(listingv2);
    }

    public void b(String s)
    {
        if (f.e().booleanValue())
        {
            aa.a(e, (new StringBuilder()).append("jump to ").append(s).toString());
            c(s);
            return;
        } else
        {
            aa.a(e, (new StringBuilder()).append("jump to deferred ").append(s).toString());
            a(s, ((String) (null)), ((String) (null)));
            return;
        }
    }

    public void b(String s, String s1)
    {
        int i1;
label0:
        {
            i1 = f.a(s, s1);
            int j1 = f.a(s1);
            if (i1 != -1)
            {
                if (i1 == j1)
                {
                    break label0;
                }
                if (!d && i1 <= 0)
                {
                    throw new AssertionError();
                }
                g.setSelection(i1 - 1);
            }
            return;
        }
        g.setSelection(i1);
    }

    public void c()
    {
        f.notifyDataSetInvalidated();
    }

    public void c(ListingV2 listingv2)
    {
        Boolean boolean1;
        boolean flag;
        if (com.smule.android.network.managers.i.a().c(listingv2.productId) || ap.a().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean1 = Boolean.valueOf(flag);
        if (listingv2.b() && boolean1.booleanValue())
        {
            com.smule.pianoandroid.magicpiano.ai.a(getActivity(), listingv2, true, this).show();
            return;
        }
        com.smule.pianoandroid.utils.i.d().a(listingv2, false);
        SongV2 songv2 = ak.a().a(listingv2.productId);
        if (boolean1.booleanValue())
        {
            a(listingv2, false);
            return;
        }
        if (com.smule.pianoandroid.magicpiano.a.g.a().b(songv2.songId) && !listingv2.isFree)
        {
            f(listingv2);
            return;
        }
        if (!listingv2.b())
        {
            a(listingv2.song, false);
        }
        if (listingv2.subscriberOnly)
        {
            e(listingv2);
            return;
        } else
        {
            e();
            return;
        }
    }

    public void c(String s)
    {
        int i1 = f.a(s);
        if (i1 != -1)
        {
            g.setSelection(i1);
        }
    }

    public void d(String s)
    {
        a(((String) (null)), ((String) (null)), s);
    }

    public void e(String s)
    {
        ListingV2 listingv2_1 = ak.a().f(s);
        ListingV2 listingv2 = listingv2_1;
        if (listingv2_1 == null)
        {
            listingv2 = ak.a().f(s);
        }
        if (listingv2 != null)
        {
            aa.a(e, (new StringBuilder()).append("Playing listing ").append(listingv2).append(" for song ").append(s).append(" from notification").toString());
            c(listingv2);
            return;
        } else
        {
            aa.a(e, (new StringBuilder()).append("Can't find listing for song ").append(s).append(" from notification").toString());
            return;
        }
    }

    public void f(String s)
    {
        aa.a(e, (new StringBuilder()).append("Flurry received ad for space ").append(s).toString());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f03005b, null);
        if (getActivity().isFinishing())
        {
            return viewgroup;
        }
        k = new t(getActivity());
        g = (AmazingListView)viewgroup.findViewById(0x102000a);
        h = layoutinflater.getContext();
        try
        {
            g.setOverscrollFooter(null);
        }
        catch (Throwable throwable)
        {
            aa.b(e, "Caught a Motorola related error in ProductListFragment.onCreateView()", throwable);
        }
        layoutinflater = layoutinflater.inflate(0x7f030058, g, false);
        g.setPinnedHeaderView(layoutinflater);
        com.smule.pianoandroid.data.db.c.d().a(getActivity(), this, this, (ProductListActivity)h);
        f = com.smule.pianoandroid.data.db.c.d();
        g.setAdapter(f);
        i = new h();
        if (bundle != null)
        {
            j = bundle.getString("PLAY_LISTING_UID");
        }
        return viewgroup;
    }

    public void onDestroy()
    {
        super.onDestroy();
        i.c(this);
        i.f();
        k.c();
        f.f();
        h = null;
    }

    public void onListItemClick(ListView listview, View view, int i1, long l1)
    {
        a = f.d(i1);
        b = i1;
        if (view instanceof ProductListItem)
        {
            listview = ((ProductListItem)view).getListing();
        } else
        {
            listview = ((ListingListItem)view).getListing();
        }
        if (f.h())
        {
            com.smule.android.c.a.a(m.a, ((ListingV2) (listview)).productId, Integer.valueOf(i1), null, null);
        }
        c(listview);
    }

    public void onPause()
    {
        i.a(this);
        super.onPause();
    }

    public void onResume()
    {
        i.b(this);
        super.onResume();
        if (!k.e())
        {
            Object obj = new d() {

                final ProductListFragment a;

                public void a()
                {
                    com.smule.pianoandroid.magicpiano.ProductListFragment.g(a);
                }

                public void b()
                {
                    com.smule.pianoandroid.magicpiano.ProductListFragment.h(a);
                }

            
            {
                a = ProductListFragment.this;
                super();
            }
            };
            if (f.e().booleanValue())
            {
                aa.a(e, "loaded");
                f.a(null);
                g();
            } else
            {
                aa.a(e, "not loaded");
                f.a(((d) (obj)));
            }
        }
        k.d();
        if (j != null)
        {
            obj = ak.a().i(j);
            j = null;
            if (obj != null && ((ListingV2) (obj)).isFree)
            {
                g(((ListingV2) (obj)));
            }
        }
        if (com.smule.pianoandroid.utils.i.d().c())
        {
            g.setSelectionAfterHeaderView();
            com.smule.pianoandroid.utils.i.d().a(false);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (j != null)
        {
            bundle.putString("PLAY_LISTING_UID", j);
        }
    }

    public void onStart()
    {
        super.onStart();
        i.b(getActivity(), 0x7f0a00b5, m, null);
    }

    static 
    {
        boolean flag;
        if (!com/smule/pianoandroid/magicpiano/ProductListFragment.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }
}
