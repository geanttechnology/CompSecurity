// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.firegnom.rat.util.DialogUtils;
import com.picsart.studio.utils.c;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.activity:
//            AdBaseActivity, c

public class LocationListActivity extends AdBaseActivity
    implements LocationListener
{

    private static final int DIALOG_LOCATION_DISABLED = 1;
    private final String TAG = com/socialin/android/activity/LocationListActivity.getSimpleName();
    private TextView errorMsgTextView;
    private LayoutInflater inflater;
    private Location location;
    private LocationAdapter locationAdapter;
    private ListView locationListView;
    private g progressDialog;

    public LocationListActivity()
    {
        progressDialog = null;
        locationListView = null;
        inflater = null;
        locationAdapter = null;
        errorMsgTextView = null;
        location = null;
    }

    private void closeProgressDialog()
    {
        try
        {
            progressDialog.dismiss();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void exit()
    {
        finish();
        AnalyticUtils.getInstance(this).trackLocalAction("location:exit");
    }

    private void initActionBar()
    {
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        actionbar.setTitle(0x7f080601);
    }

    private void initLocationProvider()
    {
        if (!s.a(this))
        {
            Utils.a(this, 0x7f080424);
            return;
        }
        progressDialog = g.a(this, getString(0x7f080112), true);
        location = c.a(getApplicationContext(), this);
        if (location != null)
        {
            onLocationChanged(location);
            errorMsgTextView.setVisibility(8);
            locationListView.setVisibility(0);
            return;
        }
        DialogUtils.showNoLocationProviderDialog(this, 0x7f080448, 0x7f08047e, 0x7f0802f6, 0x7f0802a4, 0x7f0203eb);
        errorMsgTextView.setVisibility(0);
        locationListView.setVisibility(8);
        try
        {
            progressDialog.dismiss();
            return;
        }
        catch (Exception exception)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f0301b8);
        AnalyticUtils.getInstance(this).trackLocalAction("location:onCreate");
        inflater = getLayoutInflater();
        locationListView = (ListView)findViewById(0x7f10081b);
        errorMsgTextView = (TextView)findViewById(0x7f10081a);
        locationAdapter = new LocationAdapter(getApplicationContext(), 0);
        locationListView.setAdapter(locationAdapter);
        locationListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private LocationListActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent();
                adapterview.putExtra("text", ((com.socialin.android.activity.c)a.locationAdapter.getItem(i)).a);
                adapterview.putExtra("venue_Id", ((com.socialin.android.activity.c)a.locationAdapter.getItem(i)).b);
                a.setResult(-1, adapterview);
                a.finish();
                AnalyticUtils.getInstance(a).trackLocalAction("location:done");
            }

            
            {
                a = LocationListActivity.this;
                super();
            }
        });
        initActionBar();
        initAd();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 1: // '\001'
            return (new android.app.AlertDialog.Builder(this)).setMessage(getResources().getString(0x7f08043e)).setNegativeButton(getResources().getString(0x7f080311), new android.content.DialogInterface.OnClickListener() {

                private LocationListActivity a;

                public final void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.cancel();
                    a.finish();
                }

            
            {
                a = LocationListActivity.this;
                super();
            }
            }).create();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onLocationChanged(Location location1)
    {
        Double double1 = Double.valueOf(location1.getLatitude());
        location1 = Double.valueOf(location1.getLongitude());
        (new AsyncTask() {

            private LocationListActivity a;

            protected final Object doInBackground(Object aobj[])
            {
                aobj = (Double[])aobj;
                return c.a(a.getApplicationContext(), ((Double) (aobj[0])).doubleValue(), ((Double) (aobj[1])).doubleValue());
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (List)obj;
                super.onPostExecute(obj);
                if (obj != null)
                {
                    a.closeProgressDialog();
                    com.picsart.studio.utils.d d1;
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a.locationAdapter.add(new com.socialin.android.activity.c(d1.b, d1.h)))
                    {
                        d1 = (com.picsart.studio.utils.d)((Iterator) (obj)).next();
                    }

                }
            }

            
            {
                a = LocationListActivity.this;
                super();
            }
        }).execute(new Double[] {
            double1, location1
        });
        (new Thread(new Runnable(new Geocoder(this), double1, location1) {

            final LocationListActivity a;
            private Geocoder b;
            private Double c;
            private Double d;

            public final void run()
            {
                Object obj;
label0:
                {
                    try
                    {
                        obj = b.getFromLocation(c.doubleValue(), d.doubleValue(), 4);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((IOException) (obj)).printStackTrace();
                        obj = null;
                    }
                    if (obj != null && ((List) (obj)).size() != 0)
                    {
                        obj = (Address)((List) (obj)).get(0);
                        if (!a.isFinishing())
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.runOnUiThread(new Runnable(this, ((Address) (obj))) {

                    private Address a;
                    private _cls3 b;

                    public final void run()
                    {
                        b.a.closeProgressDialog();
                        b.a.locationAdapter.add(new com.socialin.android.activity.c((new StringBuilder()).append(a.getLocality()).append(", ").append(a.getCountryName()).toString(), null));
                        b.a.locationAdapter.add(new com.socialin.android.activity.c(a.getCountryName(), null));
                        for (int i = 0; i < a.getMaxAddressLineIndex(); i++)
                        {
                            b.a.locationAdapter.add(new com.socialin.android.activity.c(a.getAddressLine(i), null));
                        }

                    }

            
            {
                b = _pcls3;
                a = address;
                super();
            }
                });
            }

            
            {
                a = LocationListActivity.this;
                b = geocoder;
                c = double1;
                d = double2;
                super();
            }
        })).start();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        exit();
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        ((LocationManager)getApplicationContext().getSystemService("location")).removeUpdates(this);
    }

    public void onProviderDisabled(String s1)
    {
        d.b("\n\nProvider Disabled: ", new Object[] {
            s1
        });
        try
        {
            progressDialog.dismiss();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        showDialog(1);
    }

    public void onProviderEnabled(String s1)
    {
        d.b("\n\nProvider Enabled: ", new Object[] {
            s1
        });
    }

    protected void onResume()
    {
        super.onResume();
        if (location != null)
        {
            errorMsgTextView.setVisibility(8);
            locationListView.setVisibility(0);
            c.a(getApplicationContext(), this);
            return;
        } else
        {
            initLocationProvider();
            return;
        }
    }

    public void onStatusChanged(String s1, int i, Bundle bundle)
    {
        d.b("\n\nProvider Status Changed: ", new Object[] {
            s1
        });
    }




    private class LocationAdapter extends ArrayAdapter
    {

        final LocationListActivity this$0;

        public void add(com.socialin.android.activity.c c1)
        {
            int j = getCount();
            for (int i = 0; i < j; i++)
            {
                if (c1.equals(getItem(i)))
                {
                    return;
                }
            }

            super.add(c1);
        }

        public volatile void add(Object obj)
        {
            add((com.socialin.android.activity.c)obj);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = inflater.inflate(0x7f030151, viewgroup, false);
            }
            ((TextView)view).setText(((com.socialin.android.activity.c)getItem(i)).a);
            return view;
        }

        public LocationAdapter(Context context, int i)
        {
            this$0 = LocationListActivity.this;
            super(context, i);
        }
    }

}
