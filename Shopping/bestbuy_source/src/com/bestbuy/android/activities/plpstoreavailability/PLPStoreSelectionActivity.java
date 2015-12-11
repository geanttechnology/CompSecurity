// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.plpstoreavailability;

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
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import bu;
import com.bestbuy.android.activities.blueassist.BlueAssistStoreListFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import jy;
import jz;
import kf;
import nb;
import nr;
import pp;
import qm;
import qn;
import qo;
import qp;

public class PLPStoreSelectionActivity extends BBYBaseFragmentActivity
    implements ahx, android.view.View.OnClickListener, bu, qo, qp
{

    private static final String a = com/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity.getSimpleName();
    private nb b;
    private SearchView c;
    private LinearLayout d;
    private ImageView e;
    private ImageView f;
    private int g;
    private boolean h;
    private View i;
    private boolean j;
    private double k;
    private double l;
    private ArrayList m;
    private jz n;
    private BlueAssistStoreListFragment o;
    private qm p;
    private boolean q;
    private RelativeLayout r;
    private BBYButton s;
    private String t;
    private FrameLayout u;

    public PLPStoreSelectionActivity()
    {
        g = 0;
        h = false;
        m = null;
        q = false;
    }

    static String a(PLPStoreSelectionActivity plpstoreselectionactivity, String s1)
    {
        plpstoreselectionactivity.t = s1;
        return s1;
    }

    private ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            BBYStore bbystore = (BBYStore)arraylist.next();
            StoreDetails storedetails = bbystore.getStoreDetails();
            if (storedetails != null && !storedetails.getLocationSubType().equalsIgnoreCase("Mobile Store"))
            {
                arraylist1.add(bbystore);
            }
        } while (true);
        return arraylist1;
    }

    private void a(double d1, double d2)
    {
        j = true;
        k = d1;
        l = d2;
        n = new jz(this, null, i, d1, d2, g, 50);
        n.executeOnExecutor(nb.h, new Void[0]);
    }

    private boolean b()
    {
        return ((LocationManager)getSystemService("location")).isProviderEnabled("gps");
    }

    private void c()
    {
        i.setVisibility(0);
        p = (new qn(this)).a(ahy.a).a(this).a(this).b();
        p.b();
    }

    private void d()
    {
        i.setVisibility(0);
        c.setQuery("", false);
        a(b.y(), b.z());
    }

    private void e()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Location providers are disabled. Please enable it from your device's Location settings.</font>"));
            builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>OK</font>"), new android.content.DialogInterface.OnClickListener() {

                final PLPStoreSelectionActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    a.startActivityForResult(dialoginterface, 1000);
                }

            
            {
                a = PLPStoreSelectionActivity.this;
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
        u.setVisibility(8);
        d.setVisibility(0);
        ((BBYTextView)d.findViewById(0x7f0c0035)).setText((new StringBuilder()).append("\"").append(t).append("\"").toString());
    }

    public void a(int i1, int j1, int k1, boolean flag, int l1)
    {
        boolean flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (k1 > l1)
            {
                flag1 = false;
            }
        }
        if (!flag1 && i1 == k1 - j1 && q)
        {
            g = g + 10;
            if (h)
            {
                String s1 = t;
                if (s1.length() > 0)
                {
                    j = true;
                    (new jy(this, null, null, s1, g, 50)).executeOnExecutor(nb.h, new Void[0]);
                }
            } else
            if (n != null)
            {
                n = new jz(this, null, null, k, l, g, 50);
                n.executeOnExecutor(nb.h, new Void[0]);
                return;
            }
        }
    }

    public void a(BBYStore bbystore)
    {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SelectedStore", bbystore);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
        overridePendingTransition(0x7f040005, 0x7f040008);
    }

    public void a(String s1)
    {
        t = s1.toUpperCase(Locale.US);
        g = 0;
        if (!nr.c(s1))
        {
            s1 = s1.toUpperCase(Locale.US);
        }
        if (s1.length() > 0)
        {
            h = true;
            j = true;
            BlueAssistStoreListFragment blueassiststorelistfragment = o;
            (new jy(this, null, i, s1, g, 50)).executeOnExecutor(nb.h, new Void[0]);
        }
    }

    public void a(ArrayList arraylist, boolean flag)
    {
        arraylist = a(arraylist);
        u.setVisibility(0);
        d.setVisibility(8);
        m = arraylist;
        q = flag;
        r.setVisibility(8);
        o.a(this, arraylist, g, flag);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
            if (i1 == 1000)
            {
                if (!b())
                {
                    break label0;
                }
                f.setImageResource(0x7f0200d9);
                r.setVisibility(8);
            }
            return;
        }
        f.setImageResource(0x7f0200da);
        r.setVisibility(0);
    }

    public void onClick(View view)
    {
        if (view != f) goto _L2; else goto _L1
_L1:
        if (b()) goto _L4; else goto _L3
_L3:
        e();
_L6:
        return;
_L4:
        g = 0;
        h = false;
        d();
        return;
_L2:
        if (view == e)
        {
            view = new Intent(getApplicationContext(), com/bestbuy/android/activities/home/HomeActivity);
            view.addFlags(0x4000000);
            startActivity(view);
            finish();
            overridePendingTransition(0x7f040005, 0x7f040008);
            return;
        }
        if (view == s)
        {
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1000);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(p, BBYBaseFragmentActivity.REQUEST, this);
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
        setContentView(0x7f030002);
        b = nb.a();
        b.i(true);
        getActionBar().hide();
        c = (SearchView)findViewById(0x7f0c0032);
        d = (LinearLayout)findViewById(0x7f0c0034);
        r = (RelativeLayout)findViewById(0x7f0c0036);
        u = (FrameLayout)findViewById(0x7f0c0033);
        f = (ImageView)findViewById(0x7f0c0031);
        e = (ImageView)findViewById(0x7f0c0030);
        i = findViewById(0x7f0c0064);
        s = (BBYButton)findViewById(0x7f0c0037);
        c.setQueryHint(getString(0x7f080352));
        c.onActionViewExpanded();
        bundle = (SearchManager)getSystemService("search");
        c.setSearchableInfo(bundle.getSearchableInfo(getComponentName()));
        int i1 = c.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        bundle = (TextView)c.findViewById(i1);
        bundle.setTextColor(0xff888888);
        bundle.setHintTextColor(0xff888888);
        bundle.setBackgroundDrawable(null);
        i1 = c.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        bundle = c.findViewById(i1);
        if (bundle != null)
        {
            bundle.setBackgroundColor(-1);
        }
        int j1 = c.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
        bundle = (ImageView)c.findViewById(j1);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        bundle.setImageResource(0x7f02017f);
        int k1 = c.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        bundle = (ImageView)c.findViewById(k1);
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
        c.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {

            final PLPStoreSelectionActivity a;

            public boolean onQueryTextChange(String s1)
            {
                return false;
            }

            public boolean onQueryTextSubmit(String s1)
            {
                InputMethodManager inputmethodmanager = (InputMethodManager)a.getSystemService("input_method");
                if (a.getCurrentFocus() != null && a.getCurrentFocus().getWindowToken() != null)
                {
                    inputmethodmanager.hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 0);
                }
                PLPStoreSelectionActivity.a(a, s1);
                a.a(s1);
                return false;
            }

            
            {
                a = PLPStoreSelectionActivity.this;
                super();
            }
        });
        if (m == null || m.isEmpty())
        {
            o = new BlueAssistStoreListFragment(this);
            c();
        } else
        {
            o = new BlueAssistStoreListFragment(this, m);
        }
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.replace(0x7f0c0033, o, "BlueAssistStoreListFragment");
        bundle.commit();
        if (b())
        {
            r.setVisibility(8);
            i.setVisibility(0);
        } else
        {
            r.setVisibility(0);
        }
        f.setOnClickListener(this);
        e.setOnClickListener(this);
        s.setOnClickListener(this);
        return;
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            b.a(location.getLatitude());
            b.b(location.getLongitude());
            if (p.d())
            {
                ahy.b.a(p, this);
            }
        }
        r.setVisibility(8);
        d();
    }

    public void onResume()
    {
        super.onResume();
        if (!b())
        {
            i.setVisibility(8);
            r.setVisibility(0);
            f.setImageResource(0x7f0200da);
        }
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

}
