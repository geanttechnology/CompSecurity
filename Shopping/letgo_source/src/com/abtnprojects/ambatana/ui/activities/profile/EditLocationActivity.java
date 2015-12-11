// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dy;
import android.support.v7.eo;
import android.support.v7.fk;
import android.support.v7.fv;
import android.support.v7.gh;
import android.support.v7.hf;
import android.support.v7.hg;
import android.support.v7.hv;
import android.support.v7.ib;
import android.support.v7.is;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.LetgoApplication;
import com.abtnprojects.ambatana.location.GeocodeIntentService;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.ui.activities.d;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.k;
import com.google.android.gms.location.m;
import com.google.android.gms.location.o;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.g;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.b;
import com.google.android.gms.maps.model.c;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;

public class EditLocationActivity extends d
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, k, e
{
    private static class a
        implements com.google.android.gms.maps.c.a
    {

        private final Context a;

        public View a(com.google.android.gms.maps.model.d d1)
        {
            return null;
        }

        public View b(com.google.android.gms.maps.model.d d1)
        {
            View view = LayoutInflater.from(a).inflate(0x7f040041, null);
            TextView textview = (TextView)view.findViewById(0x7f100116);
            textview.setText(d1.b());
            TextView textview1 = (TextView)view.findViewById(0x7f100117);
            textview1.setText(d1.c());
            if (TextUtils.isEmpty(textview1.getText()))
            {
                textview1.setVisibility(8);
            }
            if (TextUtils.isEmpty(textview.getText()))
            {
                textview.setVisibility(8);
            }
            return view;
        }

        public a(Context context)
        {
            a = context;
        }
    }


    private static final LocationRequest O = LocationRequest.a().a(5000L).c(16L).a(102);
    private com.google.android.gms.maps.model.d A;
    private c B;
    private String C;
    private hv D;
    private ParseGeoPoint E;
    private ProgressDialog F;
    private LatLng G;
    private String H;
    private String I;
    private boolean J;
    private int K;
    private LetgoAddress L;
    private Location M;
    private LetgoAddress N;
    private com.google.android.gms.common.api.c P;
    private boolean Q;
    private boolean R;
    private boolean S;
    AutoCompleteTextView acInputAddress;
    CheckBox cbLocationAccuracy;
    ImageButton ivDeleteAddress;
    private com.google.android.gms.maps.c n;

    public EditLocationActivity()
    {
    }

    private boolean F()
    {
        return K > 1 || K == 1 && !is.e(this);
    }

    private void G()
    {
        J = true;
        invalidateOptionsMenu();
        S = true;
        Q = false;
        H = "";
        I = "";
        acInputAddress.setText("");
        if (N != null) goto _L2; else goto _L1
_L1:
        Location location = m.b.a(P);
        if (location != null)
        {
            GeocodeIntentService.a(this, location, Geocoder.isPresent());
        } else
        {
            c(0x7f0901bf);
        }
_L4:
        I();
        return;
_L2:
        d(N);
        LatitudeLongitude latitudelongitude = L.getPoint();
        if (latitudelongitude != null)
        {
            a(cbLocationAccuracy.isChecked(), latitudelongitude.toLatLng());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void H()
    {
        Object obj = a(10000L, 5000L, 104);
        LocationRequest locationrequest = a(0x493e0L, 0x1d4c0L, 102);
        obj = (new com.google.android.gms.location.LocationSettingsRequest.a()).a(((LocationRequest) (obj))).a(locationrequest).a(true);
        m.d.a(P, ((com.google.android.gms.location.LocationSettingsRequest.a) (obj)).a()).a(new h() {

            final EditLocationActivity a;

            public volatile void a(com.google.android.gms.common.api.g g1)
            {
                a((LocationSettingsResult)g1);
            }

            public void a(LocationSettingsResult locationsettingsresult)
            {
                locationsettingsresult = locationsettingsresult.a();
                switch (locationsettingsresult.g())
                {
                default:
                    return;

                case 0: // '\0'
                    EditLocationActivity.a(a);
                    return;

                case 6: // '\006'
                    try
                    {
                        locationsettingsresult.a(a, 433);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (LocationSettingsResult locationsettingsresult)
                    {
                        return;
                    }

                case 8502: 
                    EditLocationActivity.a(a);
                    return;
                }
            }

            
            {
                a = EditLocationActivity.this;
                super();
            }
        });
    }

    private void I()
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(acInputAddress.getWindowToken(), 0);
    }

    private void J()
    {
        Toast.makeText(this, getString(0x7f09009a), 0).show();
    }

    private void K()
    {
        L();
        M();
        if (L != null)
        {
            a(L, L.getPoint());
            E();
            fv fv1 = new fv(this, L);
            Void avoid[] = new Void[0];
            if (!(fv1 instanceof AsyncTask))
            {
                fv1.execute(avoid);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)fv1, avoid);
                return;
            }
        } else
        {
            D();
            return;
        }
    }

    private void L()
    {
        if (!Q) goto _L2; else goto _L1
_L1:
        is.d(this, true);
        is.c(this, true);
        CurrentUserLocation currentuserlocation = LetgoApplication.i();
        if (currentuserlocation != null)
        {
            is.a(this, currentuserlocation);
        } else
        {
            is.h(this);
        }
_L4:
        is.b(this, cbLocationAccuracy.isChecked());
        return;
_L2:
        if (R)
        {
            is.d(this, false);
            is.c(this, true);
        } else
        if (S)
        {
            is.d(this, false);
            is.h(this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void M()
    {
        hf hf1 = (new hg()).a(new gh(), ParseUser.getCurrentUser(), new iu());
        if (Q)
        {
            hf1.h(this);
        } else
        if (S)
        {
            hf1.i(this);
            return;
        }
    }

    private LocationRequest a(long l, long l1, int i)
    {
        LocationRequest locationrequest = new LocationRequest();
        locationrequest.a(l);
        locationrequest.c(l1);
        locationrequest.b(2L * l);
        locationrequest.a(i);
        return locationrequest;
    }

    private String a(String s, String s1, String s2)
    {
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag = TextUtils.isEmpty(s);
        boolean flag1 = TextUtils.isEmpty(s1);
        boolean flag2 = TextUtils.isEmpty(s2);
        if (!flag)
        {
            stringbuffer.append(s);
            if (!flag1)
            {
                stringbuffer.append(" ");
            }
        }
        if (!flag1)
        {
            stringbuffer.append(s1);
            if (!flag2)
            {
                stringbuffer.append(", ");
            }
        }
        if (!flag2)
        {
            stringbuffer.append(s2);
        }
        return stringbuffer.toString();
    }

    private void a(LetgoAddress letgoaddress, LatitudeLongitude latitudelongitude)
    {
        CurrentUserLocation.getInstance().updateLocationData(latitudelongitude.getLatitude(), latitudelongitude.getLongitude(), "UserManual");
        q.a(letgoaddress);
        b(letgoaddress.getCountryCode());
    }

    static void a(EditLocationActivity editlocationactivity)
    {
        editlocationactivity.G();
    }

    static void a(EditLocationActivity editlocationactivity, boolean flag)
    {
        editlocationactivity.e(flag);
    }

    private void b(boolean flag)
    {
        d(flag);
        c(flag);
    }

    private String c(LetgoAddress letgoaddress)
    {
        Object obj = null;
        String s;
        String s1;
        if (letgoaddress == null)
        {
            s = null;
        } else
        {
            s = letgoaddress.getZipCode();
        }
        if (letgoaddress == null)
        {
            s1 = null;
        } else
        {
            s1 = letgoaddress.getCity();
        }
        if (letgoaddress == null)
        {
            letgoaddress = obj;
        } else
        {
            letgoaddress = letgoaddress.getCountryCode();
        }
        return a(s, s1, letgoaddress);
    }

    private void c(boolean flag)
    {
        if (B != null)
        {
            B.a();
        }
        if (G != null && flag)
        {
            B = a(n, G);
        }
    }

    private void d(LetgoAddress letgoaddress)
    {
        d(c(letgoaddress));
    }

    private void d(String s)
    {
        acInputAddress.setText(s);
        acInputAddress.setSelection(s.length());
        acInputAddress.dismissDropDown();
    }

    private void d(boolean flag)
    {
        if (A != null)
        {
            A.a();
        }
        if (G == null || n == null) goto _L2; else goto _L1
_L1:
        MarkerOptions markeroptions;
        boolean flag2;
        int i;
        boolean flag1;
        if (flag)
        {
            i = 0x7f02010d;
        } else
        {
            i = 0x7f0200dd;
        }
        markeroptions = (new MarkerOptions()).a(G).a(com.google.android.gms.maps.model.b.a(i));
        flag1 = TextUtils.isEmpty(H);
        flag2 = TextUtils.isEmpty(I);
        if (flag1) goto _L4; else goto _L3
_L3:
        markeroptions.a(H);
        if (!flag2)
        {
            markeroptions.b(I);
        }
_L6:
        A = n.a(markeroptions);
        n.a(new a(this));
        e(flag);
        n.a(new com.google.android.gms.maps.c.d(flag) {

            final boolean a;
            final EditLocationActivity b;

            public boolean a(com.google.android.gms.maps.model.d d1)
            {
                EditLocationActivity.a(b, a);
                return true;
            }

            
            {
                b = EditLocationActivity.this;
                a = flag;
                super();
            }
        });
        n.a(new com.google.android.gms.maps.c.b(flag) {

            final boolean a;
            final EditLocationActivity b;

            public void a(LatLng latlng)
            {
                EditLocationActivity.a(b, a);
            }

            
            {
                b = EditLocationActivity.this;
                a = flag;
                super();
            }
        });
_L2:
        return;
_L4:
        if (!flag2)
        {
            markeroptions.a(I);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void e(LetgoAddress letgoaddress)
    {
        Object obj;
        Object obj1;
        Object obj2;
        if (letgoaddress == null)
        {
            obj = null;
        } else
        {
            obj = letgoaddress.getStreetName();
        }
        H = ((String) (obj));
        if (letgoaddress == null)
        {
            obj = null;
        } else
        {
            obj = letgoaddress.getZipCode();
        }
        if (letgoaddress == null)
        {
            letgoaddress = null;
        } else
        {
            letgoaddress = letgoaddress.getCity();
        }
        if (H == null || obj == null || !H.contains(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        obj = "";
        obj1 = letgoaddress;
        obj2 = obj;
        if (H != null)
        {
            obj1 = letgoaddress;
            obj2 = obj;
            if (letgoaddress != null)
            {
                obj1 = letgoaddress;
                obj2 = obj;
                if (H.contains(letgoaddress))
                {
                    obj1 = "";
                    obj2 = obj;
                }
            }
        }
_L4:
        I = a(((String) (obj2)), ((String) (obj1)), ((String) (null)));
        return;
_L2:
        obj1 = letgoaddress;
        obj2 = obj;
        if (H != null)
        {
            obj1 = letgoaddress;
            obj2 = obj;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                obj1 = letgoaddress;
                obj2 = obj;
                if (letgoaddress != null)
                {
                    obj1 = letgoaddress;
                    obj2 = obj;
                    if (H.contains(letgoaddress))
                    {
                        obj1 = "";
                        obj2 = obj;
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void e(boolean flag)
    {
        if (!flag && (!TextUtils.isEmpty(H) || !TextUtils.isEmpty(I)))
        {
            A.d();
            return;
        } else
        {
            A.e();
            return;
        }
    }

    protected void C()
    {
        g g1 = n.b();
        n.a(false);
        if (g1 != null)
        {
            g1.c(false);
            g1.b(false);
            g1.a(false);
        }
    }

    public void D()
    {
        iv.a(F);
        setResult(-1);
        finish();
    }

    public void E()
    {
        F = new ProgressDialog(this);
        F.setMessage(getString(0x7f090071));
        F.setIndeterminate(false);
        F.show();
    }

    public void a(Location location)
    {
        if (M == null)
        {
            M = location;
            GeocodeIntentService.a(this, location, Geocoder.isPresent());
        } else
        if (!M.equals(location))
        {
            GeocodeIntentService.a(this, location, Geocoder.isPresent());
            return;
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        if (!flag)
        {
            ButterKnife.bind(this);
            P = (new com.google.android.gms.common.api.c.a(this)).a(this, 0, this).a(com.google.android.gms.location.places.k.c).a(m.a).b();
            LetgoAddress letgoaddress = q.a();
            e(letgoaddress);
            a(letgoaddress);
            a(0x7f0200d1);
            a(((e) (this)));
            cbLocationAccuracy.setChecked(is.e(this));
            R = is.g(this);
            if (bundle != null)
            {
                J = bundle.getBoolean("changes");
                S = bundle.getBoolean("auto_location");
            }
        }
    }

    protected void a(LetgoAddress letgoaddress)
    {
        ib ib1 = new ib(ivDeleteAddress);
        acInputAddress.addTextChangedListener(ib1);
        d(letgoaddress);
        double d1;
        double d2;
        if (letgoaddress == null)
        {
            letgoaddress = null;
        } else
        {
            letgoaddress = letgoaddress.getPoint();
        }
        if (letgoaddress == null)
        {
            d1 = 41.380000000000003D;
        } else
        {
            d1 = letgoaddress.getLatitude();
        }
        if (letgoaddress == null)
        {
            d2 = 2.1699999999999999D;
        } else
        {
            d2 = letgoaddress.getLongitude();
        }
        D = new hv(this, P, new LatLng(d1, d2));
        acInputAddress.setAdapter(D);
        acInputAddress.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final EditLocationActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                a.d(i);
            }

            
            {
                a = EditLocationActivity.this;
                super();
            }
        });
        acInputAddress.setHint(0x7f090099);
    }

    public void a(com.google.android.gms.maps.c c1)
    {
        n = c1;
        boolean flag = is.e(getApplicationContext());
        C();
        E = ParseUser.getCurrentUser().getParseGeoPoint("gpscoords");
        if (E != null)
        {
            G = new LatLng(E.getLatitude(), E.getLongitude());
            a(flag, G);
        }
    }

    protected void a(boolean flag, LatLng latlng)
    {
        if (n != null && latlng != null)
        {
            n.a(com.google.android.gms.maps.b.a(latlng, 15F));
            b(flag);
        }
    }

    public void b(LetgoAddress letgoaddress)
    {
        iv.a(F);
        if (letgoaddress != null)
        {
            Q = true;
            aqo.a(letgoaddress.toString(), new Object[0]);
            acInputAddress.dismissDropDown();
            LatitudeLongitude latitudelongitude = letgoaddress.getPoint();
            L = letgoaddress;
            G = new LatLng(latitudelongitude.getLatitude(), latitudelongitude.getLongitude());
            e(letgoaddress);
            a(cbLocationAccuracy.isChecked(), G);
        } else
        {
            J();
        }
        I();
    }

    protected void d(int i)
    {
        S = false;
        Q = true;
        C = D.a(i);
        Object obj = ParseUser.getCurrentUser().getSessionToken();
        obj = new fk(this, C, ((String) (obj)));
        Void avoid[] = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((fk) (obj)).execute(avoid);
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, avoid);
        }
        J = true;
        invalidateOptionsMenu();
    }

    protected void k()
    {
        setContentView(0x7f040029);
    }

    protected boolean m()
    {
        return false;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 433)
        {
            switch (j)
            {
            default:
                return;

            case -1: 
                G();
                return;

            case 0: // '\0'
                aqo.b("User cancelled using location settings", new Object[0]);
                break;
            }
            return;
        } else
        {
            super.onActivityResult(i, j, intent);
            return;
        }
    }

    void onCheckChanged(boolean flag)
    {
        K = K + 1;
        b(flag);
        if (F())
        {
            J = true;
            invalidateOptionsMenu();
        }
    }

    public void onConnected(Bundle bundle)
    {
        m.b.a(P, O, this);
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        aqo.d((new StringBuilder()).append("Could not connect to Google API Client: Error ").append(connectionresult.c()).toString(), new Object[0]);
        Toast.makeText(this, 0x7f0900b2, 0).show();
    }

    public void onConnectionSuspended(int i)
    {
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110008, menu);
        return true;
    }

    void onDeleteAddressTap()
    {
        acInputAddress.setText("");
        acInputAddress.clearListSelection();
        I();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        iv.a(F);
    }

    public void onEvent(dy dy1)
    {
        if (Q)
        {
            N = dy1.a();
        }
        if (S)
        {
            dy1 = dy1.a();
            if (dy1 != null)
            {
                L = dy1;
                N = dy1;
                LatitudeLongitude latitudelongitude = dy1.getPoint();
                G = new LatLng(latitudelongitude.getLatitude(), latitudelongitude.getLongitude());
                e(dy1);
                a(cbLocationAccuracy.isChecked(), G);
                d(dy1);
            }
        }
    }

    public void onEvent(eo eo)
    {
        E();
    }

    void onMyLocationPressed()
    {
        aqo.a("onResetUserLocationPressed", new Object[0]);
        H();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        I();
        if (menuitem.getItemId() == 0x7f100176)
        {
            K();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        P.c();
        iv.b(this);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu = menu.findItem(0x7f100176);
        if (J)
        {
            menu.setIcon(0x7f0200e7);
            menu.setEnabled(true);
            return true;
        } else
        {
            menu.setIcon(0x7f0200e8);
            menu.setEnabled(false);
            return true;
        }
    }

    protected void onResume()
    {
        super.onResume();
        P.b();
        iv.a(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("changes", J);
        bundle.putBoolean("auto_location", S);
        super.onSaveInstanceState(bundle);
    }

    boolean onTypeAddressFinish(int i)
    {
        String s;
        if (i != 3)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        s = acInputAddress.getText().toString();
        if (D == null || D.getCount() != 0 || TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Toast.makeText(getApplicationContext(), String.format(getString(0x7f0901b0), new Object[] {
            s
        }), 1).show();
_L4:
        return true;
_L2:
        if (D == null || D.getCount() <= 0) goto _L4; else goto _L3
_L3:
        d(D.b(0));
        d(0);
        return true;
        return false;
    }

    public void u()
    {
    }

}
