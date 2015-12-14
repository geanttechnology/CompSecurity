// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.MatrixCursor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.picsart.studio.utils.c;
import com.picsart.studio.utils.d;
import com.picsart.studio.utils.e;
import com.socialin.android.apiv3.model.Adress;
import com.socialin.android.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.activity:
//            b, a

public class MapActivity extends AppCompatActivity
    implements LocationListener
{

    private static final String a = com/picsart/studio/activity/MapActivity.getSimpleName();
    private GoogleMap b;
    private ListView c;
    private a d;
    private View e;
    private SearchView f;
    private double g;
    private double h;
    private Adress i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private d o;
    private b p;
    private List q;
    private AsyncTask r;

    public MapActivity()
    {
        c = null;
        d = null;
        g = 0.0D;
        h = 0.0D;
        j = "";
        k = "";
        l = "";
        m = "";
        n = "";
        q = new ArrayList();
    }

    static a a(MapActivity mapactivity)
    {
        return mapactivity.d;
    }

    static d a(MapActivity mapactivity, d d1)
    {
        mapactivity.o = d1;
        return d1;
    }

    static String a(MapActivity mapactivity, String s)
    {
        mapactivity.n = s;
        return s;
    }

    private void a()
    {
        Location location = com.picsart.studio.utils.c.a(getApplicationContext(), this);
        if (location != null)
        {
            if (i == null)
            {
                i = com.picsart.studio.utils.c.a(location, this);
            }
            a(location.getLatitude(), location.getLongitude());
        }
    }

    private void a(double d1, double d2)
    {
        (new AsyncTask(d1, d2) {

            private double a;
            private double b;
            private MapActivity c;

            protected final Object doInBackground(Object aobj[])
            {
                return com.picsart.studio.utils.c.a(c.getApplicationContext(), a, b);
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (List)obj;
                super.onPostExecute(obj);
                c.b(true);
                c.a(false);
                com.picsart.studio.activity.MapActivity.d(c).clear();
                MapActivity.a(c).clear();
                if (obj == null || ((List) (obj)).isEmpty())
                {
                    Utils.a(c, 0x7f08022f);
                    return;
                }
                if (com.picsart.studio.activity.MapActivity.e(c) == null) goto _L2; else goto _L1
_L1:
                ((List) (obj)).add(0, com.picsart.studio.activity.MapActivity.e(c));
_L4:
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    d d3 = (d)((Iterator) (obj)).next();
                    MapActivity.a(c).add(d3);
                    if (d3.i)
                    {
                        LatLng latlng = new LatLng((double)d3.d.a / 1000000D, (double)d3.d.b / 1000000D);
                        com.picsart.studio.activity.MapActivity.d(c).addMarker((new MarkerOptions()).position(latlng).title(d3.b));
                    }
                } while (true);
                break; /* Loop/switch isn't completed */
_L2:
                if (MapActivity.f(c) != null)
                {
                    MapActivity.b(c, ((List) (obj)));
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (com.picsart.studio.activity.MapActivity.c(c).getFooterViewsCount() == 0)
                {
                    obj = new ImageView(c);
                    ((ImageView) (obj)).setImageDrawable(c.getResources().getDrawable(0x7f0205c9));
                    ((ImageView) (obj)).setPadding(0, (int)Utils.a(12F, c), 0, 0);
                    com.picsart.studio.activity.MapActivity.c(c).addFooterView(((View) (obj)), null, false);
                }
                com.picsart.studio.activity.MapActivity.c(c).setAdapter(MapActivity.a(c));
                com.picsart.studio.activity.MapActivity.d(c).moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(a, b), 3F));
                com.picsart.studio.activity.MapActivity.d(c).animateCamera(CameraUpdateFactory.zoomTo(13F), 2000, null);
                return;
            }

            protected final void onPreExecute()
            {
                c.b(false);
                c.a(true);
            }

            
            {
                c = MapActivity.this;
                a = d1;
                b = d2;
                super();
            }
        }).execute(new String[0]);
    }

    static void a(MapActivity mapactivity, double d1, double d2)
    {
        mapactivity.a(d1, d2);
    }

    static void a(MapActivity mapactivity, double d1, double d2, String s, boolean flag)
    {
        mapactivity.r = mapactivity. new AsyncTask(flag, d1, d2, s) {

            private boolean a;
            private double b;
            private double c;
            private String d;
            private MapActivity e;

            protected final Object doInBackground(Object aobj[])
            {
                return com.picsart.studio.utils.c.a(b, c, d);
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (List)obj;
                super.onPostExecute(obj);
                e.b(true);
                e.a(false);
                if (obj == null || ((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
                if (!a) goto _L4; else goto _L3
_L3:
                MapActivity.a(e, (double)((d)((List) (obj)).get(0)).d.a / 1000000D, (double)((d)((List) (obj)).get(0)).d.b / 1000000D);
_L6:
                return;
_L4:
                MapActivity.a(e, ((List) (obj)));
                return;
_L2:
                if (a)
                {
                    com.picsart.studio.activity.MapActivity.d(e).clear();
                    MapActivity.a(e).clear();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            protected final void onPreExecute()
            {
                MapActivity mapactivity1 = e;
                boolean flag1;
                if (!a)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                mapactivity1.b(flag1);
                e.a(true);
            }

            
            {
                e = MapActivity.this;
                a = flag;
                b = d1;
                c = d2;
                d = s;
                super();
            }
        };
        mapactivity.r.execute(new Object[] {
            Double.valueOf(d1), Double.valueOf(d2), s
        });
    }

    static void a(MapActivity mapactivity, String s, float f1, float f2, String s1)
    {
        Intent intent = new Intent();
        intent.putExtra("name", s);
        intent.putExtra("lat", f1);
        intent.putExtra("lng", f2);
        intent.putExtra("city", mapactivity.l);
        intent.putExtra("country", mapactivity.k);
        intent.putExtra("country_code", mapactivity.m);
        intent.putExtra("venue_Id", s1);
        mapactivity.setResult(-1, intent);
    }

    static void a(MapActivity mapactivity, List list)
    {
        mapactivity.q.clear();
        mapactivity.q.addAll(list);
        MatrixCursor matrixcursor = new MatrixCursor(new String[] {
            "_id", "text", "lat", "lng"
        });
        String as[] = new String[4];
        int j1 = 0;
        int i1 = 0;
        while (j1 < list.size()) 
        {
            as[0] = String.valueOf(i1);
            StringBuilder stringbuilder = (new StringBuilder()).append(((d)list.get(j1)).b);
            String s;
            if (((d)list.get(j1)).c.isEmpty())
            {
                s = "";
            } else
            {
                s = (new StringBuilder(", ")).append(((d)list.get(j1)).c).toString();
            }
            as[1] = stringbuilder.append(s).toString();
            as[2] = String.valueOf((double)((d)list.get(j1)).d.a / 1000000D);
            as[3] = String.valueOf((double)((d)list.get(j1)).d.b / 1000000D);
            matrixcursor.addRow(as);
            j1++;
            i1++;
        }
        if (matrixcursor.getCount() != 0)
        {
            mapactivity.p.changeCursor(matrixcursor);
            mapactivity.p.notifyDataSetChanged();
        }
    }

    static String b(MapActivity mapactivity)
    {
        return mapactivity.n;
    }

    private void b()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText() && getWindow().getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            f.clearFocus();
        }
    }

    static void b(MapActivity mapactivity, List list)
    {
        d d1 = new d();
        d1.b = mapactivity.i.city;
        d1.c = mapactivity.getString(0x7f08067c);
        d1.d = new e((int)(mapactivity.i.getLatitude() * 1000000F), (int)(mapactivity.i.getLongitude() * 1000000F));
        d1.i = false;
        list.add(0, d1);
    }

    static ListView c(MapActivity mapactivity)
    {
        return mapactivity.c;
    }

    static GoogleMap d(MapActivity mapactivity)
    {
        return mapactivity.b;
    }

    static d e(MapActivity mapactivity)
    {
        return mapactivity.o;
    }

    static Adress f(MapActivity mapactivity)
    {
        return mapactivity.i;
    }

    static View g(MapActivity mapactivity)
    {
        return mapactivity.e;
    }

    static void h(MapActivity mapactivity)
    {
        mapactivity.b();
    }

    static SearchView i(MapActivity mapactivity)
    {
        return mapactivity.f;
    }

    static double j(MapActivity mapactivity)
    {
        return mapactivity.g;
    }

    static double k(MapActivity mapactivity)
    {
        return mapactivity.h;
    }

    static AsyncTask l(MapActivity mapactivity)
    {
        return mapactivity.r;
    }

    static List m(MapActivity mapactivity)
    {
        return mapactivity.q;
    }

    public final void a(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            private boolean a;
            private MapActivity b;

            public final void run()
            {
                View view = MapActivity.g(b);
                int i1;
                if (a)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                view.setVisibility(i1);
            }

            
            {
                b = MapActivity.this;
                a = flag;
                super();
            }
        });
    }

    public final void b(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            private boolean a;
            private MapActivity b;

            public final void run()
            {
                ListView listview = com.picsart.studio.activity.MapActivity.c(b);
                int i1;
                if (a)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                listview.setVisibility(i1);
            }

            
            {
                b = MapActivity.this;
                a = flag;
                super();
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 2)
        {
            b();
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == 0 && i1 == 10)
        {
            Utils.a(this, getString(0x7f0805ca), 0);
            finish();
        }
        if (i1 == 11)
        {
            a();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030156);
        e = findViewById(0x7f1003fe);
        c = (ListView)findViewById(0x7f1006e0);
        bundle = getIntent();
        if (bundle.hasExtra("country_code"))
        {
            m = bundle.getStringExtra("country_code");
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("onCreate() - countryCode: ")).append(m).toString()
            });
        }
        if (bundle.hasExtra("country"))
        {
            k = bundle.getStringExtra("country");
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("onCreate() - country: ")).append(k).toString()
            });
        }
        if (bundle.hasExtra("city"))
        {
            l = bundle.getStringExtra("city");
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("onCreate() - city: ")).append(l).toString()
            });
        }
        if (bundle.hasExtra("place"))
        {
            j = bundle.getStringExtra("place");
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("onCreate() - place: ")).append(j).toString()
            });
        }
        ActionBar actionbar;
        if (bundle.hasExtra("title"))
        {
            bundle = bundle.getStringExtra("title");
        } else
        {
            bundle = "";
        }
        actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
            if (!TextUtils.isEmpty(bundle))
            {
                actionbar.setTitle(bundle);
                actionbar.setIcon(getResources().getDrawable(0x7f02047f));
            }
        }
        if (j == null || j.equals(""))
        {
            int i1;
            if (k != null && !k.equals(""))
            {
                bundle = k;
            } else
            {
                bundle = "";
            }
            j = bundle;
            if (l != null && !l.equals(""))
            {
                bundle = (new StringBuilder()).append(j).append(",").append(l).toString();
            } else
            {
                bundle = "";
            }
            j = bundle;
        }
        if (d != null)
        {
            d.notifyDataSetChanged();
        } else
        {
            d = new a(this, getApplicationContext());
            c.setAdapter(d);
            a();
        }
        c.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private MapActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int j1, long l1)
            {
                adapterview = (d)MapActivity.a(a).getItem(j1);
                MapActivity.a(a, ((d) (adapterview)).b, ((d) (adapterview)).d.a, ((d) (adapterview)).d.b, ((d) (adapterview)).h);
                a.finish();
            }

            
            {
                a = MapActivity.this;
                super();
            }
        });
        i1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i1 != 0)
        {
            bundle = GooglePlayServicesUtil.getErrorDialog(i1, this, 10);
            bundle.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                private MapActivity a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    a.finish();
                }

            
            {
                a = MapActivity.this;
                super();
            }
            });
            bundle.show();
        } else
        {
            b = ((MapFragment)getFragmentManager().findFragmentById(0x7f1006de)).getMap();
            b.setMyLocationEnabled(true);
            if (com.picsart.studio.utils.c.a(this, new Criteria(), Boolean.valueOf(true)) == null)
            {
                myobfuscated.f.m.a(this, com.picsart.studio.utils.c.b(this));
                return;
            }
            b.setOnMarkerClickListener(new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener() {

                private MapActivity a;

                public final boolean onMarkerClick(Marker marker)
                {
                    MapActivity.a(a, marker.getTitle());
                    MapActivity.a(a).notifyDataSetChanged();
                    com.picsart.studio.activity.MapActivity.c(a).setSelection(MapActivity.a(a).a(MapActivity.b(a)));
                    return false;
                }

            
            {
                a = MapActivity.this;
                super();
            }
            });
            b.setOnMapLongClickListener(new com.google.android.gms.maps.GoogleMap.OnMapLongClickListener() {

                private MapActivity a;

                public final void onMapLongClick(LatLng latlng)
                {
                    MarkerOptions markeroptions = (new MarkerOptions()).position(latlng).title(latlng.toString());
                    com.picsart.studio.activity.MapActivity.d(a).clear();
                    com.picsart.studio.activity.MapActivity.d(a).addMarker(markeroptions);
                    MapActivity.a(a, latlng.latitude, latlng.longitude);
                }

            
            {
                a = MapActivity.this;
                super();
            }
            });
            b.setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

                private MapActivity a;

                public final void onInfoWindowClick(Marker marker)
                {
                    MapActivity.a(a, marker.getTitle(), (int)(marker.getPosition().latitude * 1000000D), (int)(marker.getPosition().longitude * 1000000D), ((d)MapActivity.a(a).getItem(MapActivity.a(a).a(MapActivity.b(a)))).h);
                    a.finish();
                }

            
            {
                a = MapActivity.this;
                super();
            }
            });
        }
        if (!com.picsart.studio.utils.c.a(this))
        {
            myobfuscated.f.m.a(this, com.picsart.studio.utils.c.b(this));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.clear();
        getMenuInflater().inflate(0x7f110009, menu);
        MenuItem menuitem = menu.findItem(0x7f100ae8);
        f = (SearchView)MenuItemCompat.getActionView(menuitem);
        f.setQueryHint(getString(0x7f080343));
        ((ImageView)f.findViewById(0x7f100111)).setOnClickListener(new android.view.View.OnClickListener() {

            private MapActivity a;

            public final void onClick(View view)
            {
                MapActivity.h(a);
                MapActivity.i(a).setQuery("", false);
            }

            
            {
                a = MapActivity.this;
                super();
            }
        });
        p = new b(this, getBaseContext(), new String[] {
            "text"
        }, new int[] {
            0x1020014
        });
        f.setSuggestionsAdapter(p);
        f.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {

            private MapActivity a;

            public final boolean onQueryTextChange(String s)
            {
                boolean flag = false;
                if (!s.isEmpty())
                {
                    if (MapActivity.l(a) != null && MapActivity.l(a).getStatus() != android.os.AsyncTask.Status.FINISHED)
                    {
                        MapActivity.l(a).cancel(true);
                    }
                    MapActivity.a(a, MapActivity.j(a), MapActivity.k(a), s, false);
                    flag = true;
                }
                return flag;
            }

            public final boolean onQueryTextSubmit(String s)
            {
                MapActivity.i(a).clearFocus();
                MapActivity.a(a, MapActivity.j(a), MapActivity.k(a), s, true);
                return false;
            }

            
            {
                a = MapActivity.this;
                super();
            }
        });
        MenuItemCompat.setOnActionExpandListener(menuitem, new android.support.v4.view.MenuItemCompat.OnActionExpandListener() {

            private MapActivity a;

            public final boolean onMenuItemActionCollapse(MenuItem menuitem1)
            {
                if (MapActivity.a(a) != null && MapActivity.a(a).isEmpty())
                {
                    MapActivity.a(a, MapActivity.j(a), MapActivity.k(a));
                }
                return true;
            }

            public final boolean onMenuItemActionExpand(MenuItem menuitem1)
            {
                return true;
            }

            
            {
                a = MapActivity.this;
                super();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        com.picsart.studio.utils.c.a(this);
    }

    public void onLocationChanged(Location location)
    {
        g = location.getLatitude();
        h = location.getLongitude();
        if (i == null)
        {
            i = com.picsart.studio.utils.c.a(location, this);
        }
        if (d.isEmpty())
        {
            b(false);
            a(true);
            a();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        finish();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i1, Bundle bundle)
    {
    }

}
