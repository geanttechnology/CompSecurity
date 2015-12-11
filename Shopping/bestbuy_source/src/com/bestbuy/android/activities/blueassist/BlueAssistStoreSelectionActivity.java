// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import ahr;
import ahx;
import ahy;
import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import hx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kf;
import ll;
import lu;
import nb;
import nj;
import nr;
import pp;
import qm;
import qn;
import qo;
import qp;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistStoreMapFragment, BlueAssistDateTimeSelectionActivity, BlueAssistStoreListFragment

public class BlueAssistStoreSelectionActivity extends BBYBaseFragmentActivity
    implements ahx, android.view.View.OnClickListener, qo, qp
{

    private static final String a = com/bestbuy/android/activities/stores/StoreSearchMapFragment.getSimpleName();
    private boolean A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private ArrayList G;
    private nb b;
    private FrameLayout c;
    private ImageView d;
    private ImageView e;
    private qm f;
    private boolean g;
    private int h;
    private double i;
    private double j;
    private boolean k;
    private View l;
    private BlueAssistStoreListFragment m;
    private boolean n;
    private String o;
    private boolean p;
    private int q;
    private boolean r;
    private SearchView s;
    private BBYButton t;
    private LinearLayout u;
    private BlueAssistStoreMapFragment v;
    private ImageView w;
    private ImageView x;
    private RelativeLayout y;
    private BBYTextView z;

    public BlueAssistStoreSelectionActivity()
    {
        h = 0;
        k = false;
        n = false;
        p = false;
        q = 0;
        r = false;
        G = null;
    }

    private void a(double d1, double d2)
    {
        g = true;
        i = d1;
        j = d2;
        (new hx(this, null, l, (new StringBuilder()).append("").append(d1).toString(), (new StringBuilder()).append("").append(d2).toString(), null)).executeOnExecutor(nb.h, new Void[0]);
    }

    private void b()
    {
        l.setVisibility(0);
        f = (new qn(this)).a(ahy.a).a(this).a(this).b();
        f.b();
    }

    private void c()
    {
        if (v == null)
        {
            v = new BlueAssistStoreMapFragment(G);
        }
        d.setImageResource(0x7f020045);
        if (k)
        {
            d.setImageResource(0x7f020046);
            getSupportFragmentManager().popBackStack();
            k = false;
            return;
        } else
        {
            k = true;
            getSupportFragmentManager().beginTransaction().replace(0x7f0c0033, v, "").addToBackStack(null).commit();
            return;
        }
    }

    private void d()
    {
        l.setVisibility(0);
        a(b.y(), b.z());
    }

    private boolean e()
    {
        return ((LocationManager)getSystemService("location")).isProviderEnabled("gps");
    }

    private void f()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Location providers are disabled. Please enable it from your device's Location settings.</font>"));
            builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>OK</font>"), new android.content.DialogInterface.OnClickListener() {

                final BlueAssistStoreSelectionActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    a.startActivityForResult(dialoginterface, 1000);
                }

            
            {
                a = BlueAssistStoreSelectionActivity.this;
                super();
            }
            });
            builder.create();
            builder.show();
            return;
        }
    }

    public void a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("bb.apErrorCode", "Bad location");
        lu.b(lu.aN, hashmap);
        ll.b(u);
    }

    public void a(BBYStore bbystore)
    {
        Intent intent = new Intent(this, com/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity);
        Bundle bundle = new Bundle();
        bundle.putSerializable(getResources().getString(0x7f080050), bbystore);
        if (A)
        {
            bundle.putString(getResources().getString(0x7f080141), B);
            bundle.putString(getResources().getString(0x7f080143), C);
            bundle.putString(getResources().getString(0x7f080144), D);
            bundle.putString(getResources().getString(0x7f080140), E);
            bundle.putString(getResources().getString(0x7f0800b9), F);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void a(String s1)
    {
        o = s1.toUpperCase(Locale.US);
        h = 0;
        if (!nr.c(s1))
        {
            s1 = s1.toUpperCase(Locale.US);
        }
        if (s1.length() > 0)
        {
            r = true;
            g = true;
            Object obj;
            if (k)
            {
                obj = v;
            } else
            {
                obj = m;
            }
            (new hx(this, null, l, null, null, s1)).executeOnExecutor(nb.h, new Void[0]);
        }
        obj = new HashMap();
        ((HashMap) (obj)).put("bb.searchTerm", s1);
        ((HashMap) (obj)).put("bb.numResults", "25");
        lu.a(lu.aa, ((HashMap) (obj)));
    }

    public void a(ArrayList arraylist)
    {
        G = arraylist;
        v.a(arraylist, h);
        m.a(this, arraylist, h, n);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
            if (i1 == 1000)
            {
                if (!e())
                {
                    break label0;
                }
                e.setImageResource(0x7f0200d9);
                d();
            }
            return;
        }
        e.setImageResource(0x7f0200da);
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 1)
        {
            fragmentmanager.popBackStack();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view == d)
        {
            if (e())
            {
                c();
            }
        } else
        {
            if (view == e)
            {
                l.setVisibility(0);
                lu.a(lu.ah);
                if (e())
                {
                    h = 0;
                    r = false;
                    d();
                    return;
                } else
                {
                    f();
                    return;
                }
            }
            if (view == t)
            {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            }
            if (view == x)
            {
                finish();
                return;
            }
            if (view == w)
            {
                view = new Intent(getApplicationContext(), com/bestbuy/android/activities/home/HomeActivity);
                view.addFlags(0x4000000);
                startActivity(view);
                finish();
                overridePendingTransition(0x7f040005, 0x7f040008);
                return;
            }
        }
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(f, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        if (pp1.a())
        {
            try
            {
                pp1.a(this, 9000);
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
            kf.b(a, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b(a, (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030014);
        lu.a(lu.aM);
        b = nb.a();
        b.i(true);
        getActionBar().hide();
        bundle = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
        {
            bundle.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        s = (SearchView)findViewById(0x7f0c0032);
        u = (LinearLayout)findViewById(0x7f0c0034);
        t = (BBYButton)findViewById(0x7f0c0037);
        w = (ImageView)findViewById(0x7f0c0067);
        x = (ImageView)findViewById(0x7f0c0068);
        t.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        s.setQueryHint(getString(0x7f080352));
        s.onActionViewExpanded();
        bundle = (SearchManager)getSystemService("search");
        s.setSearchableInfo(bundle.getSearchableInfo(getComponentName()));
        int i1 = s.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        bundle = (TextView)s.findViewById(i1);
        bundle.setTextColor(0xff888888);
        bundle.setHintTextColor(0xff888888);
        bundle.setBackgroundDrawable(null);
        i1 = s.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        bundle = s.findViewById(i1);
        if (bundle != null)
        {
            bundle.setBackgroundColor(-1);
        }
        bundle = getIntent();
        if (bundle != null)
        {
            bundle = bundle.getExtras();
            if (bundle != null)
            {
                A = bundle.getBoolean("blueassist_update");
                B = bundle.getString(getResources().getString(0x7f080141));
                C = bundle.getString(getResources().getString(0x7f080143));
                D = bundle.getString(getResources().getString(0x7f080144));
                E = bundle.getString(getResources().getString(0x7f080140));
                F = bundle.getString(getResources().getString(0x7f0800b9));
            }
        }
        try
        {
            G = (ArrayList)nj.a(this, "blueassist_storelist");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        i1 = s.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
        bundle = (ImageView)s.findViewById(i1);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        bundle.setImageResource(0x7f02017f);
        i1 = s.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        bundle = (ImageView)s.findViewById(i1);
        if (bundle != null)
        {
            try
            {
                bundle.setImageResource(0x7f02017e);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        s.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {

            final BlueAssistStoreSelectionActivity a;

            public boolean onQueryTextChange(String s1)
            {
                return false;
            }

            public boolean onQueryTextSubmit(String s1)
            {
                a.a(s1);
                return false;
            }

            
            {
                a = BlueAssistStoreSelectionActivity.this;
                super();
            }
        });
        c = (FrameLayout)findViewById(0x7f0c0033);
        d = (ImageView)findViewById(0x7f0c0069);
        e = (ImageView)findViewById(0x7f0c0031);
        l = findViewById(0x7f0c0064);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        if (G == null || G.isEmpty())
        {
            v = new BlueAssistStoreMapFragment();
            m = new BlueAssistStoreListFragment(this);
            b();
        } else
        {
            v = new BlueAssistStoreMapFragment(G);
            m = new BlueAssistStoreListFragment(this, G);
        }
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.replace(0x7f0c0033, m, "BlueAssistStoreListFragment");
        bundle.commit();
        y = (RelativeLayout)findViewById(0x7f0c0020);
        z = (BBYTextView)y.findViewById(0x7f0c015e);
        bundle = (BBYTextView)y.findViewById(0x7f0c015f);
        z.setText(Html.fromHtml(getString(0x7f08021f)));
        bundle.setText(Html.fromHtml(getString(0x7f0802fa)));
        lu.a(lu.aL);
        return;
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            onBackPressed();
        }
        return super.onKeyDown(i1, keyevent);
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            b.a(location.getLatitude());
            b.b(location.getLongitude());
            if (f.d())
            {
                ahy.b.a(f, this);
            }
        }
        d();
    }

    public void onResume()
    {
        super.onResume();
        if (!e())
        {
            l.setVisibility(8);
            e.setImageResource(0x7f0200da);
        }
    }

}
