// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.shareview.a;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.r;
import com.facebook.FacebookException;
import com.facebook.widget.PickerFragment;
import com.facebook.widget.PlacePickerFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.UUID;
import w.a.b;

public class FacebookPlacePickerActivity extends FragmentActivity
    implements com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener, LocationListener
{

    public static final UUID a = UUID.randomUUID();
    private static final String c = com/cyberlink/youcammakeup/kernelctrl/status/StatusManager.getName();
    LocationManager b;
    private PlacePickerFragment d;
    private LocationRequest e;
    private LocationClient f;
    private int g;
    private b h;

    public FacebookPlacePickerActivity()
    {
    }

    static void a(FacebookPlacePickerActivity facebookplacepickeractivity)
    {
        facebookplacepickeractivity.b();
    }

    static void a(FacebookPlacePickerActivity facebookplacepickeractivity, String s)
    {
        facebookplacepickeractivity.a(s);
    }

    private void a(String s)
    {
        if (!StatusManager.j().o().equals("facebookPlacePickerPage"))
        {
            return;
        }
        h();
        boolean flag = e();
        s = new r(flag) {

            final boolean a;
            final FacebookPlacePickerActivity b;

            public void a()
            {
                Globals.d().i().a(null);
                if (!a)
                {
                    com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.a(b);
                }
            }

            
            {
                b = FacebookPlacePickerActivity.this;
                a = flag;
                super();
            }
        };
        Globals.d().i().a(s);
        int j;
        if (flag)
        {
            j = 0x7f070683;
        } else
        {
            j = 0x7f070682;
        }
        Globals.d().i().a(this, null, Globals.d().getString(j), true);
    }

    private void a(boolean flag, long l)
    {
        if (i())
        {
            g = g + 1;
            return;
        } else
        {
            h = new b(this, flag);
            h.a(l);
            h.show();
            g = g + 1;
            return;
        }
    }

    private void b()
    {
        Globals globals = Globals.d();
        if (d != null)
        {
            globals.a(d.getSelection());
        }
        finish();
    }

    static void b(FacebookPlacePickerActivity facebookplacepickeractivity)
    {
        facebookplacepickeractivity.h();
    }

    static PlacePickerFragment c(FacebookPlacePickerActivity facebookplacepickeractivity)
    {
        return facebookplacepickeractivity.d;
    }

    private boolean c()
    {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0;
    }

    private void d()
    {
        if (!f())
        {
            a("Network not connect");
            return;
        } else
        {
            (new a(b, new com.cyberlink.youcammakeup.pages.shareview.b() {

                final FacebookPlacePickerActivity a;

                public void a(Location location)
                {
                    if (!StatusManager.j().o().equals("facebookPlacePickerPage"))
                    {
                        return;
                    }
                    if (location == null)
                    {
                        com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.a(a, "Get location null");
                        return;
                    } else
                    {
                        com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.b(a);
                        FacebookPlacePickerActivity.c(a).setLocation(location);
                        FacebookPlacePickerActivity.c(a).loadData(false);
                        return;
                    }
                }

            
            {
                a = FacebookPlacePickerActivity.this;
                super();
            }
            })).a();
            return;
        }
    }

    private boolean e()
    {
        boolean flag3 = false;
        boolean flag = b.isProviderEnabled("gps");
        boolean flag1 = b.isProviderEnabled("network");
_L2:
        boolean flag2 = flag3;
        if (flag)
        {
            flag2 = flag3;
            if (flag1)
            {
                flag2 = flag3;
                if (f())
                {
                    flag2 = true;
                }
            }
        }
        return flag2;
        Exception exception;
        exception;
        flag = false;
_L3:
        exception.printStackTrace();
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
          goto _L3
    }

    private boolean f()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    private void g()
    {
        a(true, 1000L);
    }

    private void h()
    {
        if (i())
        {
            g = g - 1;
            if (g == 0)
            {
                h.dismiss();
                h = null;
            }
        }
    }

    private boolean i()
    {
        return h != null;
    }

    protected void a()
    {
        Globals.d().c("facebookPlacePickerPage");
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
    }

    public void onConnected(Bundle bundle)
    {
        if (!f())
        {
            a("Network not connect");
            return;
        }
        if (c())
        {
            bundle = f.getLastLocation();
            if (bundle != null)
            {
                h();
                d.setLocation(bundle);
                d.loadData(false);
                return;
            } else
            {
                a("Get location null");
                return;
            }
        } else
        {
            d();
            return;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        d();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000e);
        StatusManager.j().a("facebookPlacePickerPage");
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.h, this);
        if (Globals.d().v() == "facebookPlacePickerPage")
        {
            StatusManager.j().D();
        }
        Bundle bundle1 = getIntent().getExtras();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (bundle == null)
        {
            d = new PlacePickerFragment(bundle1);
        } else
        {
            d = (PlacePickerFragment)fragmentmanager.findFragmentById(0x7f0c0112);
        }
        d.setOnSelectionChangedListener(new com.facebook.widget.PickerFragment.OnSelectionChangedListener() {

            final FacebookPlacePickerActivity a;

            public void onSelectionChanged(PickerFragment pickerfragment)
            {
                com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.a(a);
            }

            
            {
                a = FacebookPlacePickerActivity.this;
                super();
            }
        });
        d.setOnErrorListener(new com.facebook.widget.PickerFragment.OnErrorListener() {

            final FacebookPlacePickerActivity a;

            public void onError(PickerFragment pickerfragment, FacebookException facebookexception)
            {
            }

            
            {
                a = FacebookPlacePickerActivity.this;
                super();
            }
        });
        d.setOnDoneButtonClickedListener(new com.facebook.widget.PickerFragment.OnDoneButtonClickedListener() {

            final FacebookPlacePickerActivity a;

            public void onDoneButtonClicked(PickerFragment pickerfragment)
            {
                com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.a(a);
            }

            
            {
                a = FacebookPlacePickerActivity.this;
                super();
            }
        });
        bundle = d;
        e = LocationRequest.create();
        e.setInterval(5000L);
        e.setPriority(100);
        e.setFastestInterval(1000L);
        f = new LocationClient(this, this, this);
        b = (LocationManager)getSystemService("location");
        fragmentmanager.beginTransaction().replace(0x7f0c0112, bundle).commit();
        g();
    }

    public void onDestroy()
    {
        Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.h, null);
        super.onDestroy();
    }

    public void onDisconnected()
    {
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 4 && keyevent.getRepeatCount() == 0)
        {
            keyevent.startTracking();
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    public boolean onKeyUp(int j, KeyEvent keyevent)
    {
        if (j == 4 && getFragmentManager().getBackStackEntryCount() == 0 && keyevent.isTracking() && !keyevent.isCanceled())
        {
            finish();
            return true;
        } else
        {
            return super.onKeyUp(j, keyevent);
        }
    }

    public void onLocationChanged(Location location)
    {
    }

    protected void onPause()
    {
        super.onPause();
        a();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(c, StatusManager.j());
    }

    protected void onStart()
    {
        super.onStart();
        f.connect();
        StatusManager.j().a("facebookPlacePickerPage");
        StatusManager.j().a(Boolean.valueOf(true));
    }

    public void onStop()
    {
        f.disconnect();
        super.onStop();
    }

}
