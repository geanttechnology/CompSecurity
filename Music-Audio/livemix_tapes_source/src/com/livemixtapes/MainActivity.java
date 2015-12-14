// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.ActionBar;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.app.NotificationManager;
import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gcm.GCMRegistrar;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.ui.AnimatedTabHostListener;
import com.livemixtapes.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.livemixtapes:
//            Utils, console, User, GCMIntentService, 
//            MixtapesActivity, WorldActivity, NowPlayingActivity, SearchActivity, 
//            ProfileActivity, App, Login

public class MainActivity extends TabActivity
{

    public static Activity activity;
    public static boolean firstLoad = false;
    public static boolean fromWidget = false;
    public static boolean isPlaying = false;
    public static TextView logoutText;
    public static MainActivity mainActivity;
    public static ImageView nowplayingbutton;
    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {

        final MainActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            console.log(new Object[] {
                intent.getExtras().getString("message")
            });
        }

            
            {
                this$0 = MainActivity.this;
                super();
            }
    };
    AsyncTask mRegisterTask;
    public AnimatedTabHostListener tabHostListener;

    public MainActivity()
    {
    }

    private void gcm(final Context context)
    {
        GCMRegistrar.checkDevice(context);
        GCMRegistrar.checkManifest(context);
        registerReceiver(mHandleMessageReceiver, new IntentFilter("com.livemixtapes.DISPLAY_MESSAGE"));
        final String RegistrationId = GCMRegistrar.getRegistrationId(context);
        Utils.savePreferences(context, "PUSHTOKEN", GCMRegistrar.getRegistrationId(context));
        Log.d("LiveMixTapes", (new StringBuilder("retrieved registration id is :")).append(RegistrationId).toString());
        if (RegistrationId.equals(""))
        {
            GCMRegistrar.register(context, new String[] {
                "663004151835"
            });
            return;
        }
        if (GCMRegistrar.isRegisteredOnServer(context))
        {
            Log.d("LiveMixTapes", "GCM Display Message : Already registered");
            console.log(new Object[] {
                "GCM REGISTERED ALREADY"
            });
            ArrayList arraylist = new ArrayList(3);
            context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
            JSONParser jsonparser = new JSONParser();
            arraylist.add(new BasicNameValuePair("auth", User.getAuth()));
            console.log(new Object[] {
                (new StringBuilder("AUTH IS: ")).append(User.getAuth()).toString()
            });
            arraylist.add(new BasicNameValuePair("device_id", context));
            console.log(new Object[] {
                (new StringBuilder("DEVICEID IS: ")).append(context).toString()
            });
            arraylist.add(new BasicNameValuePair("device_token", RegistrationId));
            console.log(new Object[] {
                (new StringBuilder("REGISTRATIONID IS: ")).append(RegistrationId).toString()
            });
            arraylist.add(new BasicNameValuePair("device_description", (new StringBuilder(String.valueOf(GCMIntentService.getDeviceName()))).append(" - ").append(android.os.Build.VERSION.RELEASE).toString()));
            console.log(new Object[] {
                (new StringBuilder("DEVICEDESCRIPTION IS: ")).append(GCMIntentService.getDeviceName()).append(" - ").append(android.os.Build.VERSION.RELEASE).toString()
            });
            jsonparser.postData("https://api.livemixtapes.com/api/user/android_push", arraylist);
            return;
        } else
        {
            Log.d("LiveMixTapes", (new StringBuilder("retrieved registration id is :")).append(RegistrationId).toString());
            mRegisterTask = new AsyncTask() {

                final MainActivity this$0;
                private final String val$RegistrationId;
                private final Context val$context;

                protected transient Boolean doInBackground(Void avoid[])
                {
                    avoid = new ArrayList(3);
                    String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                    JSONParser jsonparser1 = new JSONParser();
                    avoid.add(new BasicNameValuePair("device_id", s));
                    avoid.add(new BasicNameValuePair("device_token", RegistrationId));
                    avoid.add(new BasicNameValuePair("device_description", (new StringBuilder(String.valueOf(GCMIntentService.getDeviceName()))).append(" - ").append(android.os.Build.VERSION.RELEASE).toString()));
                    return Boolean.valueOf(jsonparser1.isSuccessfulRequest(jsonparser1.postData("https://api.livemixtapes.com/api/user/android_push", avoid)));
                }

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Boolean boolean1)
                {
                    mRegisterTask = null;
                    if (boolean1.booleanValue())
                    {
                        GCMRegistrar.setRegisteredOnServer(context, true);
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Boolean)obj);
                }

            
            {
                this$0 = MainActivity.this;
                context = context1;
                RegistrationId = s;
                super();
            }
            };
            mRegisterTask.execute(new Void[] {
                null, null, null
            });
            return;
        }
    }

    public static void goBack()
    {
        mainActivity.onBackPressed();
    }

    private void showDialog(String s, String s1)
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(s).setMessage(s1).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final MainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        }).setIcon(0x1080027).show();
    }

    public void addImageToActionBar()
    {
label0:
        {
            getActionBar().setDisplayShowCustomEnabled(true);
            Object obj = LayoutInflater.from(this).inflate(0x7f030018, null);
            ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f08005f);
            int i = getResources().getDisplayMetrics().widthPixels;
            imageview.measure(0, 0);
            imageview.getMeasuredWidth();
            try
            {
                Object obj1 = (ViewGroup)findViewById(0x102002c).getParent();
                View view = ((ViewGroup) (obj1)).getChildAt(0);
                obj1 = ((ViewGroup) (obj1)).getChildAt(1);
                view.getWidth();
                ((View) (obj1)).getWidth();
            }
            catch (Exception exception) { }
            getActionBar().setCustomView(((View) (obj)));
            if (obj != null)
            {
                obj = (android.app.ActionBar.LayoutParams)((View) (obj)).getLayoutParams();
                if (obj == null)
                {
                    break label0;
                }
                int j = i / 4 - 20;
                i = j;
                if (j <= 0)
                {
                    i = 0;
                }
                obj.leftMargin = i;
            }
            return;
        }
        console.log(new Object[] {
            "NULL PARAMS"
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        activity = this;
        mainActivity = this;
        requestWindowFeature(1);
        setContentView(0x7f030019);
        nowplayingbutton = (ImageView)findViewById(0x7f080061);
        bundle = new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    if (MainActivity.isPlaying)
                    {
                        MainActivity.fromWidget = true;
                        startActivity(new Intent(MainActivity.this, com/livemixtapes/NowPlayingActivity));
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
        nowplayingbutton.setOnClickListener(bundle);
        new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                User.logout();
                try
                {
                    NowPlayingActivity.stop();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                startActivity(new Intent(MainActivity.this, com/livemixtapes/Login));
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
        bundle = getTabHost();
        android.widget.TabHost.TabSpec tabspec = bundle.newTabSpec("Explore");
        tabspec.setIndicator("", getResources().getDrawable(0x7f0200ae));
        Object obj = new Intent(this, com/livemixtapes/MixtapesActivity);
        tabspec.setContent(((Intent) (obj)));
        Object obj1 = getIntent().getStringExtra("mixtapeId");
        if (obj1 != null && ((String) (obj1)).length() > 0)
        {
            ((Intent) (obj)).putExtra("mixtapeId", ((String) (obj1)));
        }
        obj = bundle.newTabSpec("World");
        ((android.widget.TabHost.TabSpec) (obj)).setIndicator("", getResources().getDrawable(0x7f0200b3));
        ((android.widget.TabHost.TabSpec) (obj)).setContent(new Intent(this, com/livemixtapes/WorldActivity));
        obj1 = bundle.newTabSpec("Player");
        ((android.widget.TabHost.TabSpec) (obj1)).setIndicator("");
        ((android.widget.TabHost.TabSpec) (obj1)).setContent(new Intent(this, com/livemixtapes/NowPlayingActivity));
        android.widget.TabHost.TabSpec tabspec1 = bundle.newTabSpec("Search");
        tabspec1.setIndicator("", getResources().getDrawable(0x7f0200b1));
        tabspec1.setContent(new Intent(this, com/livemixtapes/SearchActivity));
        android.widget.TabHost.TabSpec tabspec2 = bundle.newTabSpec("Profile");
        tabspec2.setIndicator("", getResources().getDrawable(0x7f0200b0));
        Intent intent = new Intent(this, com/livemixtapes/ProfileActivity);
        intent.addFlags(0x4000000);
        tabspec2.setContent(intent);
        bundle.addTab(tabspec);
        bundle.addTab(((android.widget.TabHost.TabSpec) (obj)));
        bundle.addTab(((android.widget.TabHost.TabSpec) (obj1)));
        bundle.addTab(tabspec1);
        bundle.addTab(tabspec2);
        bundle.getTabWidget().setStripEnabled(false);
        bundle.getTabWidget().getChildTabViewAt(2).setEnabled(false);
        int i = 0;
        do
        {
            if (i >= bundle.getTabWidget().getChildCount())
            {
                (new AsyncTask() {

                    final MainActivity this$0;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        if (!"generic".equals(Build.BRAND.toLowerCase()))
                        {
                            gcm(getApplicationContext());
                        }
                        return null;
                    }

            
            {
                this$0 = MainActivity.this;
                super();
            }
                }).execute(new Void[0]);
                if (!User.isLogged().booleanValue())
                {
                    User.hasAuth().booleanValue();
                }
                tabHostListener = new AnimatedTabHostListener(bundle);
                return;
            }
            bundle.getTabWidget().getChildAt(i).setBackgroundResource(0x7f0200fd);
            ((TextView)bundle.getTabWidget().getChildAt(i).findViewById(0x1020016)).setTextColor(Color.parseColor("#ffffff"));
            bundle.getTabWidget().setBackgroundDrawable(getResources().getDrawable(0x7f020057));
            bundle.setOnTabChangedListener(new android.widget.TabHost.OnTabChangeListener() {

                final MainActivity this$0;

                public void onTabChanged(String s)
                {
                    Activity activity1 = getLocalActivityManager().getActivity(s);
                    if (activity1 != null)
                    {
                        activity1.onWindowFocusChanged(true);
                        s.equals("Profile");
                    }
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
            i++;
        } while (true);
    }

    public void onDestroy()
    {
        console.log(new Object[] {
            "MAIN ACTIVITY DESTORYED"
        });
        ((NotificationManager)getSystemService("notification")).cancelAll();
        NotificationManager notificationmanager = (NotificationManager)App.context.getSystemService("notification");
        notificationmanager.cancel(1);
        notificationmanager.cancelAll();
        if (mRegisterTask != null)
        {
            mRegisterTask.cancel(true);
        }
        try
        {
            unregisterReceiver(mHandleMessageReceiver);
            GCMRegistrar.onDestroy(getApplicationContext());
        }
        catch (Exception exception) { }
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING MAIN ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~MainActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
        Utility.hideKeyboard(this);
    }


}
