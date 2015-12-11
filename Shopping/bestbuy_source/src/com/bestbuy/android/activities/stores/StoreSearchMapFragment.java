// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import ahr;
import ahx;
import ahy;
import ail;
import aim;
import aip;
import aiq;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import ani;
import ank;
import cf;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.bbyobjects.MapBaseFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import dp;
import ea;
import ec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import jy;
import jz;
import kf;
import ll;
import lu;
import nb;
import nr;
import pp;
import qm;
import qn;
import qo;
import qp;

public class StoreSearchMapFragment extends BBYBaseFragment
    implements ahx, aiq, android.view.View.OnClickListener, cf, qo, qp
{

    public static boolean b = false;
    private static final String c = com/bestbuy/android/activities/stores/StoreSearchMapFragment.getSimpleName();
    private BBYTextView A;
    private String B;
    private boolean C;
    private boolean D;
    private int E;
    private double F;
    private double G;
    private boolean H;
    private boolean I;
    private int J;
    private View K;
    private int L;
    private qm M;
    private boolean N;
    private android.widget.AbsListView.OnScrollListener O;
    public dp a;
    private View g;
    private LinearLayout h;
    private RelativeLayout i;
    private LinearLayout j;
    private BBYButton k;
    private jz l;
    private aim m;
    private ViewPager n;
    private ArrayList o;
    private View p;
    private MapBaseFragment q;
    private ank r;
    private nb s;
    private boolean t;
    private ListView u;
    private ea v;
    private LinearLayout w;
    private boolean x;
    private ec y;
    private BBYTextView z;

    public StoreSearchMapFragment()
    {
        o = new ArrayList();
        t = false;
        x = false;
        C = true;
        D = false;
        E = 0;
        I = true;
        J = 0;
        L = 9;
        N = false;
        O = new android.widget.AbsListView.OnScrollListener() {

            final StoreSearchMapFragment a;

            public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
            {
                if (StoreSearchMapFragment.m(a) && k1 > StoreSearchMapFragment.n(a))
                {
                    StoreSearchMapFragment.b(a, k1);
                    StoreSearchMapFragment.c(a, false);
                }
                if (StoreSearchMapFragment.m(a) || i1 != k1 - j1 || !StoreSearchMapFragment.e(a)) goto _L2; else goto _L1
_L1:
                StoreSearchMapFragment.a(a, StoreSearchMapFragment.f(a) + 10);
                StoreSearchMapFragment.a(a, nb.a().b().getBoolean("IS_MAP_VIEW", false));
                if (!StoreSearchMapFragment.g(a)) goto _L4; else goto _L3
_L3:
                abslistview = StoreSearchMapFragment.o(a).getText().toString();
                if (abslistview.length() > 0)
                {
                    StoreSearchMapFragment.b(a, true);
                    (new jy(a.d, a, null, abslistview, StoreSearchMapFragment.f(a), 50)).executeOnExecutor(nb.h, new Void[0]);
                }
_L6:
                StoreSearchMapFragment.c(a, true);
_L2:
                return;
_L4:
                if (StoreSearchMapFragment.j(a) != null)
                {
                    StoreSearchMapFragment.a(a, new jz(a.d, a, null, StoreSearchMapFragment.k(a), StoreSearchMapFragment.l(a), StoreSearchMapFragment.f(a), 50));
                    StoreSearchMapFragment.j(a).executeOnExecutor(nb.h, new Void[0]);
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onScrollStateChanged(AbsListView abslistview, int i1)
            {
            }

            
            {
                a = StoreSearchMapFragment.this;
                super();
            }
        };
    }

    static int a(StoreSearchMapFragment storesearchmapfragment, int i1)
    {
        storesearchmapfragment.E = i1;
        return i1;
    }

    static aim a(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.m;
    }

    static jz a(StoreSearchMapFragment storesearchmapfragment, jz jz1)
    {
        storesearchmapfragment.l = jz1;
        return jz1;
    }

    private void a(double d1, double d2)
    {
        x = true;
        F = d1;
        G = d2;
        H = nb.a().b().getBoolean("IS_MAP_VIEW", false);
        l = new jz(d, this, g, d1, d2, E, 50);
        l.executeOnExecutor(nb.h, new Void[0]);
    }

    private void a(ank ank1, LatLng latlng)
    {
        int i1 = 0;
_L3:
        Double double1;
        Object obj;
        if (i1 >= o.size())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj = (BBYStore)o.get(i1);
        double1 = Double.valueOf(((BBYStore) (obj)).getStoreDetails().getLatitude());
        obj = Double.valueOf(((BBYStore) (obj)).getStoreDetails().getLongitude());
        if (Math.abs(double1.doubleValue() - latlng.a) >= 1.0000000000000001E-05D || Math.abs(((Double) (obj)).doubleValue() - latlng.b) >= 1.0000000000000001E-05D) goto _L2; else goto _L1
_L1:
        if (i1 != -1)
        {
            t = true;
            n.setCurrentItem(i1);
        }
        r.a(ani.a(0x7f0201a6));
        r = ank1;
        t = false;
        return;
_L2:
        i1++;
          goto _L3
        i1 = -1;
          goto _L1
    }

    static void a(StoreSearchMapFragment storesearchmapfragment, ank ank1, LatLng latlng)
    {
        storesearchmapfragment.a(ank1, latlng);
    }

    private void a(ArrayList arraylist)
    {
        if (m == null)
        {
            q = MapBaseFragment.a(this);
            arraylist = getChildFragmentManager().beginTransaction();
            arraylist.add(0x7f0c0107, q);
            arraylist.commitAllowingStateLoss();
        } else
        {
            q.a();
            y.notifyDataSetChanged();
        }
        if (C)
        {
            C = false;
        }
    }

    static boolean a(StoreSearchMapFragment storesearchmapfragment, boolean flag)
    {
        storesearchmapfragment.H = flag;
        return flag;
    }

    static int b(StoreSearchMapFragment storesearchmapfragment, int i1)
    {
        storesearchmapfragment.J = i1;
        return i1;
    }

    static boolean b(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.t;
    }

    static boolean b(StoreSearchMapFragment storesearchmapfragment, boolean flag)
    {
        storesearchmapfragment.x = flag;
        return flag;
    }

    static ArrayList c(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.o;
    }

    static boolean c(StoreSearchMapFragment storesearchmapfragment, boolean flag)
    {
        storesearchmapfragment.I = flag;
        return flag;
    }

    static int d(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.L;
    }

    static boolean e(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.N;
    }

    static int f(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.E;
    }

    private void f()
    {
        g.setVisibility(0);
        b = true;
        a(s.y(), s.z());
    }

    private void g()
    {
        g.setVisibility(8);
        w.setVisibility(8);
        h.setVisibility(8);
        j.setVisibility(0);
    }

    static boolean g(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.D;
    }

    static BBYTextView h(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.z;
    }

    private void h()
    {
label0:
        {
            lu.a(lu.ae);
            if (j != null)
            {
                if (o == null || o.isEmpty())
                {
                    break label0;
                }
                j.setVisibility(0);
                w.setVisibility(8);
                g();
            }
            return;
        }
        w.setVisibility(0);
        i.setVisibility(8);
    }

    static View i(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.g;
    }

    private void i()
    {
        lu.a(lu.af);
        w.setVisibility(8);
        if (j != null)
        {
            j.setVisibility(8);
        }
        if (k())
        {
            i.setVisibility(8);
            h.setVisibility(0);
            if (x)
            {
                a(o);
                x = false;
            }
            return;
        }
        if (o != null && !o.isEmpty() && k())
        {
            i.setVisibility(8);
            h.setVisibility(0);
            a(o);
            return;
        } else
        {
            i.setVisibility(0);
            h.setVisibility(8);
            return;
        }
    }

    static jz j(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.l;
    }

    private void j()
    {
        if (d.isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(d);
            builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Location providers are disabled. Please enable it from your device's Location settings.</font>"));
            builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>OK</font>"), new android.content.DialogInterface.OnClickListener() {

                final StoreSearchMapFragment a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    a.d.startActivityForResult(dialoginterface, 1000);
                }

            
            {
                a = StoreSearchMapFragment.this;
                super();
            }
            });
            builder.create();
            builder.show();
            return;
        }
    }

    static double k(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.F;
    }

    private boolean k()
    {
        return ((LocationManager)d.getSystemService("location")).isProviderEnabled("gps");
    }

    static double l(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.G;
    }

    static boolean m(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.I;
    }

    static int n(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.J;
    }

    static BBYTextView o(StoreSearchMapFragment storesearchmapfragment)
    {
        return storesearchmapfragment.A;
    }

    public void a(StoreList storelist)
    {
        N = storelist.isHasNext();
        if (B != null && !B.isEmpty())
        {
            z.setText((new StringBuilder()).append(" ").append(B).toString());
            A.setText((new StringBuilder()).append(" ").append(B).toString());
            B = "";
        }
        g.setVisibility(8);
        i.setVisibility(8);
        H = nb.a().b().getBoolean("IS_MAP_VIEW", false);
        if (H)
        {
            h.setVisibility(0);
        } else
        {
            j.setVisibility(0);
        }
        b = false;
        if (E <= 1)
        {
            o.clear();
            u.removeFooterView(K);
        }
        o.addAll(storelist.getStores());
        if (E <= 1)
        {
            K = d.getLayoutInflater().inflate(0x7f0300fc, null);
            y = new ec(d, o);
            n.setAdapter(y);
            I = true;
            J = 0;
            u.addFooterView(K, null, false);
            v = new ea(d, o, true, false, false);
            u.setAdapter(v);
        } else
        {
            y.notifyDataSetChanged();
            v.notifyDataSetChanged();
        }
        if (!N)
        {
            u.removeFooterView(K);
        }
        a(o);
        b = false;
        if (!H)
        {
            g();
        }
    }

    public void a(String s1)
    {
        B = s1.toUpperCase(Locale.US);
        w.setVisibility(8);
        E = 0;
        if (!nr.c(s1))
        {
            s1 = s1.toUpperCase(Locale.US);
        }
        H = nb.a().b().getBoolean("IS_MAP_VIEW", false);
        if (s1.length() > 0)
        {
            D = true;
            x = true;
            (new jy(d, this, g, s1, E, 50)).executeOnExecutor(nb.h, new Void[0]);
        }
        HashMap hashmap = new HashMap();
        hashmap.put("bb.searchTerm", s1);
        hashmap.put("bb.numResults", "25");
        lu.a(lu.aa, hashmap);
    }

    public boolean a(ank ank1)
    {
        lu.a(lu.ag);
        if (!ank1.equals(r))
        {
            ank1.a(ani.a(0x7f020183));
            a(ank1, ank1.a());
        }
        return false;
    }

    public void b()
    {
        lu.a(lu.ah);
        if (k())
        {
            E = 0;
            C = true;
            D = false;
            f();
            z.setText("BY");
            A.setText("BY");
            return;
        } else
        {
            j();
            return;
        }
    }

    public void b_()
    {
        m = q.b();
        if (m != null && !o.isEmpty())
        {
            m.b();
            m.a(new aip() {

                final StoreSearchMapFragment a;

                public void a(LatLng latlng)
                {
                }

            
            {
                a = StoreSearchMapFragment.this;
                super();
            }
            });
            m.a(this);
            if (m != null)
            {
                int i1 = 0;
                while (i1 < o.size()) 
                {
                    Object obj1 = (BBYStore)o.get(i1);
                    Object obj = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLatitude());
                    obj1 = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLongitude());
                    obj = new LatLng(((Double) (obj)).doubleValue(), ((Double) (obj1)).doubleValue());
                    if (i1 == 0)
                    {
                        m.a(ail.a(((LatLng) (obj)), L));
                        r = m.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f020183)));
                    } else
                    {
                        m.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f0201a6)));
                    }
                    i1++;
                }
            }
        }
    }

    public void c()
    {
label0:
        {
            if (g.getVisibility() == 8)
            {
                H = nb.a().b().getBoolean("IS_MAP_VIEW", false);
                if (!H)
                {
                    break label0;
                }
                h();
            }
            return;
        }
        i();
    }

    public void d()
    {
        u.removeFooterView(K);
    }

    public void e()
    {
        ll.b(w);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
            if (i1 == 1000)
            {
                if (!k())
                {
                    break label0;
                }
                C = true;
                i.setVisibility(8);
                f();
            }
            return;
        }
        i.setVisibility(0);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        M = (new qn(activity)).a(ahy.a).a(this).a(this).b();
        M.b();
    }

    public void onClick(View view)
    {
        if (view == k)
        {
            view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            d.startActivity(view);
        }
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(M, BBYBaseFragmentActivity.REQUEST, this);
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
            kf.b(c, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b(c, (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = (dp)d;
        ((HomeActivity)d).setOnActionIconClickListener(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (p == null)
        {
            s = nb.a();
            p = layoutinflater.inflate(0x7f0300ff, viewgroup, false);
            u = (ListView)p.findViewById(0x7f0c0106);
            g = p.findViewById(0x7f0c0064);
            h = (LinearLayout)p.findViewById(0x7f0c03c9);
            i = (RelativeLayout)p.findViewById(0x7f0c0036);
            j = (LinearLayout)p.findViewById(0x7f0c03cc);
            w = (LinearLayout)p.findViewById(0x7f0c0034);
            z = (BBYTextView)p.findViewById(0x7f0c03ca);
            A = (BBYTextView)p.findViewById(0x7f0c03cd);
            k = (BBYButton)p.findViewById(0x7f0c0037);
            k.setOnClickListener(this);
            n = (ViewPager)p.findViewById(0x7f0c03cb);
            n.setPageMargin(35);
            y = new ec(d, o);
            n.setAdapter(y);
            u.setOnScrollListener(O);
            v = new ea(d, o, true, false, false);
            u.setAdapter(v);
            q = MapBaseFragment.a(this);
            layoutinflater = getChildFragmentManager().beginTransaction();
            layoutinflater.add(0x7f0c0107, q);
            layoutinflater.commit();
            if (k())
            {
                i.setVisibility(8);
                g.setVisibility(0);
                b = true;
            } else
            {
                i.setVisibility(0);
            }
        } else
        {
            ((ViewGroup)p.getParent()).removeView(p);
        }
        a.onStoresFramentLaunch();
        n.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final StoreSearchMapFragment a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                if (StoreSearchMapFragment.a(a) != null && !StoreSearchMapFragment.b(a))
                {
                    Object obj1 = (BBYStore)StoreSearchMapFragment.c(a).get(i1);
                    Object obj = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLatitude());
                    obj1 = Double.valueOf(((BBYStore) (obj1)).getStoreDetails().getLongitude());
                    obj1 = new LatLng(((Double) (obj)).doubleValue(), ((Double) (obj1)).doubleValue());
                    StoreSearchMapFragment.a(a).a(ail.a(((LatLng) (obj1)), StoreSearchMapFragment.d(a)));
                    obj = StoreSearchMapFragment.a(a).a().a;
                    obj1 = StoreSearchMapFragment.a(a).a((new MarkerOptions()).a(((LatLng) (obj1))).a(ani.a(0x7f020183)));
                    StoreSearchMapFragment.a(a, ((ank) (obj1)), ((LatLng) (obj)));
                }
                if (i1 == StoreSearchMapFragment.c(a).size() - 1 && StoreSearchMapFragment.e(a))
                {
                    StoreSearchMapFragment.a(a, StoreSearchMapFragment.f(a) + 10);
                    StoreSearchMapFragment.a(a, nb.a().b().getBoolean("IS_MAP_VIEW", false));
                    if (StoreSearchMapFragment.g(a))
                    {
                        String s1 = StoreSearchMapFragment.h(a).getText().toString();
                        HashMap hashmap = new HashMap();
                        hashmap.put("bb.searchTerm", s1);
                        hashmap.put("bb.numResults", "25");
                        lu.a(lu.ad, hashmap);
                        if (s1.length() > 0)
                        {
                            StoreSearchMapFragment.b(a, true);
                            (new jy(a.d, a, StoreSearchMapFragment.i(a), s1, StoreSearchMapFragment.f(a), 50)).executeOnExecutor(nb.h, new Void[0]);
                        }
                    } else
                    if (StoreSearchMapFragment.j(a) != null)
                    {
                        StoreSearchMapFragment.a(a, new jz(a.d, a, StoreSearchMapFragment.i(a), StoreSearchMapFragment.k(a), StoreSearchMapFragment.l(a), StoreSearchMapFragment.f(a), 50));
                        StoreSearchMapFragment.j(a).executeOnExecutor(nb.h, new Void[0]);
                        return;
                    }
                }
            }

            
            {
                a = StoreSearchMapFragment.this;
                super();
            }
        });
        return p;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, "");
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        a.onStoresFramentExit();
        if (M.d())
        {
            M.c();
        }
        ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, "");
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            s.a(location.getLatitude());
            s.b(location.getLongitude());
            if (M.d())
            {
                ahy.b.a(M, this);
            }
        }
        i.setVisibility(8);
        if (H)
        {
            h.setVisibility(0);
        } else
        {
            j.setVisibility(0);
        }
        f();
    }

    public void onResume()
    {
        super.onResume();
        if (!k())
        {
            i.setVisibility(0);
        }
        ((BBYBaseFragmentActivity)d).showActionBarHome();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Stores");
    }

    public void onStop()
    {
        super.onStop();
        ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, "");
    }

}
