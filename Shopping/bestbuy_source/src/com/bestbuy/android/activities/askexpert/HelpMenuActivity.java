// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import ahr;
import ahx;
import ahy;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import bp;
import com.bestbuy.android.activities.blueassist.BlueAssistDepartmentSelectionActivity;
import com.bestbuy.android.activities.browseproduct.pdp.StickyGroupExpandableListView;
import com.bestbuy.android.api.lib.models.blueshirt.FeatureFlagResponse;
import com.bestbuy.android.base.BBYApplication;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.ApplicationStatusModel.Utils;
import com.inc247.ChatSDK;
import com.inc247.ChatSDKEventsListener;
import com.inc247.constants.CheckInternetConnection;
import com.inc247.errors.ChatSDKError;
import fd;
import hx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kf;
import lu;
import nb;
import nj;
import org.json.JSONException;
import org.json.JSONObject;
import pp;
import qm;
import qn;
import qo;
import qp;

public class HelpMenuActivity extends BBYBaseFragmentActivity
    implements ahx, ChatSDKEventsListener, qo, qp
{

    public static boolean a = false;
    private static ChatSDK h;
    private static JSONObject i;
    private static JSONObject j = null;
    private static int k = 0;
    private android.view.View.OnClickListener A;
    private android.view.View.OnClickListener B;
    private android.view.View.OnClickListener C;
    private String b;
    private StickyGroupExpandableListView c;
    private bp d;
    private ArrayList e;
    private ArrayList f;
    private ImageView g;
    private boolean l;
    private String m[];
    private String n[];
    private View o;
    private Switch p;
    private boolean q;
    private boolean r;
    private qm s;
    private View t;
    private ProgressBar u;
    private ArrayList v;
    private BBYTextView w;
    private String x;
    private boolean y;
    private boolean z;

    public HelpMenuActivity()
    {
        b = com/bestbuy/android/activities/askexpert/HelpMenuActivity.getSimpleName();
        e = new ArrayList();
        f = new ArrayList();
        l = false;
        q = false;
        r = false;
        v = new ArrayList();
        x = "";
        y = false;
        z = false;
        A = new android.view.View.OnClickListener() {

            final HelpMenuActivity a;

            public void onClick(View view)
            {
                HelpMenuActivity.a(a, true);
                if (ChatRunningStatus.getChatRunning())
                {
                    HelpMenuActivity.c().maximizeChat();
                    a.stopService(new Intent(a.getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
                    return;
                }
                if (HelpMenuActivity.a(a))
                {
                    HelpMenuActivity.b(a).setVisibility(0);
                    HelpMenuActivity.a(a, "bestbuy-App-Sales");
                    return;
                } else
                {
                    HelpMenuActivity.a(a, false);
                    view = new android.app.AlertDialog.Builder(a);
                    view.setCancelable(true);
                    view.setMessage(a.getString(0x7f080210));
                    view.setNeutralButton(0x7f080283, new android.content.DialogInterface.OnClickListener(this) {

                        final _cls1 a;

                        public void onClick(DialogInterface dialoginterface, int i1)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    view.create().show();
                    return;
                }
            }

            
            {
                a = HelpMenuActivity.this;
                super();
            }
        };
        B = new android.view.View.OnClickListener() {

            final HelpMenuActivity a;

            public void onClick(View view)
            {
                if (HelpMenuActivity.c(a) == null || !HelpMenuActivity.c(a).equals("PurchasingProduct")) goto _L2; else goto _L1
_L1:
                view = new HashMap();
                view.put("bb.prevPageLink", lu.aV);
                view.put("bb.makeAppt", "1");
                lu.b(lu.aY, view);
_L4:
                view = new Intent(a, com/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity);
                a.startActivity(view);
                return;
_L2:
                if (HelpMenuActivity.c(a) != null && HelpMenuActivity.c(a).equals("ExistingOrder"))
                {
                    view = new HashMap();
                    view.put("bb.prevPageLink", "Blue Assist: Existing Order: Mobile");
                    view.put("bb.makeAppt", "1");
                    lu.b("Blue Assist: Existing Order: Mobile: Make Appt", view);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = HelpMenuActivity.this;
                super();
            }
        };
        C = new android.view.View.OnClickListener() {

            final HelpMenuActivity a;

            public void onClick(View view)
            {
                HelpMenuActivity.b(a, true);
                if (ChatRunningStatus.getChatRunning())
                {
                    HelpMenuActivity.c().maximizeChat();
                    a.stopService(new Intent(a.getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
                    return;
                }
                if (HelpMenuActivity.a(a))
                {
                    HelpMenuActivity.b(a).setVisibility(0);
                    HelpMenuActivity.a(a, "bestbuy-App-Care");
                    return;
                } else
                {
                    HelpMenuActivity.b(a, false);
                    view = new android.app.AlertDialog.Builder(a);
                    view.setCancelable(true);
                    view.setMessage(a.getString(0x7f080210));
                    view.setNeutralButton(0x7f080283, new android.content.DialogInterface.OnClickListener(this) {

                        final _cls3 a;

                        public void onClick(DialogInterface dialoginterface, int i1)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    view.create().show();
                    return;
                }
            }

            
            {
                a = HelpMenuActivity.this;
                super();
            }
        };
    }

    static void a(HelpMenuActivity helpmenuactivity, String s1)
    {
        helpmenuactivity.b(s1);
    }

    static boolean a(HelpMenuActivity helpmenuactivity)
    {
        return helpmenuactivity.l;
    }

    static boolean a(HelpMenuActivity helpmenuactivity, boolean flag)
    {
        helpmenuactivity.y = flag;
        return flag;
    }

    static ProgressBar b(HelpMenuActivity helpmenuactivity)
    {
        return helpmenuactivity.u;
    }

    private void b(String s1)
    {
        if (Utils.isOnline(this))
        {
            j = new JSONObject();
            try
            {
                j.put("queueId", s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1.printStackTrace();
            }
            ChatRunningStatus.setChatRunning(true);
            h.startChat(i, this, j, false);
            return;
        } else
        {
            CheckInternetConnection.ShowInternetConnectionLossAlert(this);
            return;
        }
    }

    static boolean b(HelpMenuActivity helpmenuactivity, boolean flag)
    {
        helpmenuactivity.z = flag;
        return flag;
    }

    static ChatSDK c()
    {
        return h;
    }

    static String c(HelpMenuActivity helpmenuactivity)
    {
        return helpmenuactivity.x;
    }

    static int d()
    {
        return k;
    }

    static JSONObject e()
    {
        return i;
    }

    static BBYBaseFragmentActivity f()
    {
        return baseFragmentActivity;
    }

    static JSONObject g()
    {
        return j;
    }

    private void h()
    {
        j = new JSONObject();
        try
        {
            j.put("queueId", "bestbuy-App-Sales");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        h = ChatSDK.initializeChat(this);
        h.activity = this;
        h.setChatEventsListener(this);
        h.getQueueId(j);
        h.getQueueIdParameters();
        i = new JSONObject();
        try
        {
            i.put("username", "Test Account");
            i.put("email", "Testing");
            i.put("accountnumber", "Sample Testing");
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private boolean i()
    {
        return ((LocationManager)getSystemService("location")).isProviderEnabled("gps");
    }

    public android.view.View.OnClickListener a()
    {
        return A;
    }

    public android.view.View.OnClickListener a(String s1)
    {
        x = s1;
        return B;
    }

    public void a(FeatureFlagResponse featureflagresponse)
    {
        if (featureflagresponse != null)
        {
            r = featureflagresponse.isChat();
            q = featureflagresponse.isBookABlueShirt();
            r = featureflagresponse.isChat();
            if (r && !ChatRunningStatus.getChatRunning())
            {
                h();
            }
            if (q && featureflagresponse.getBookABlueShirtStores() != null)
            {
                v.addAll(featureflagresponse.getBookABlueShirtStores());
                try
                {
                    nj.a(this, "blueassist_storelist", v);
                }
                // Misplaced declaration of an exception variable
                catch (FeatureFlagResponse featureflagresponse)
                {
                    featureflagresponse.printStackTrace();
                }
            }
        }
        d = new bp(c, this, e, f, r, q);
        featureflagresponse = new fd(d);
        c.addFooterView(o);
        c.setAdapter(featureflagresponse);
        c.expandGroup(0);
    }

    public android.view.View.OnClickListener b()
    {
        return C;
    }

    public void onAgentMessage(JSONObject jsonobject)
    {
        if (a)
        {
            k++;
            ChatBubbleService.c();
        }
    }

    public void onChatAgentAvailability(boolean flag)
    {
        l = flag;
    }

    public void onChatEnded(JSONObject jsonobject)
    {
        y = false;
        z = false;
        if (nb.a().b().getString("shake_your_device", "Off").equalsIgnoreCase("On"))
        {
            BBYApplication.getInstance().registerSensor();
        }
        a = false;
        k = 0;
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("chatstatus"));
        stopService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        baseFragmentActivity.reEnablePullDown();
        h = null;
        finish();
        overridePendingTransition(0x7f040005, 0x7f040008);
    }

    public void onChatError(ChatSDKError chatsdkerror)
    {
        kf.c("OnChatError:", (new StringBuilder()).append("Inside function onChatError ").append(chatsdkerror.getErrorMsg()).toString());
    }

    public void onChatMaximized(JSONObject jsonobject)
    {
        if (u.getVisibility() == 0)
        {
            u.setVisibility(8);
        }
        if (nb.a().b().getString("shake_your_device", "Off").equalsIgnoreCase("On"))
        {
            BBYApplication.getInstance().registerSensor();
        }
        a = false;
        k = 0;
    }

    public void onChatMinimized(JSONObject jsonobject)
    {
        if (nb.a().b().getString("shake_your_device", "Off").equalsIgnoreCase("On"))
        {
            BBYApplication.getInstance().unRegisterSensor();
        }
        a = true;
        startService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        finish();
        overridePendingTransition(0x7f040005, 0x7f040008);
    }

    public void onChatStarted(JSONObject jsonobject)
    {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("chatstatus"));
        jsonobject = new HashMap();
        jsonobject.put("bb.liveChat", "1");
        if (y)
        {
            jsonobject.put("bb.prevPageLink", lu.aV);
            lu.b(lu.aX, jsonobject);
        } else
        if (z)
        {
            jsonobject.put("bb.prevPageLink", (new StringBuilder()).append(lu.aZ).append(": All Other Categories").toString());
            lu.b(lu.ba, jsonobject);
            return;
        }
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(s, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        if (pp1.a())
        {
            try
            {
                pp1.a(this, 9000);
            }
            // Misplaced declaration of an exception variable
            catch (pp pp1)
            {
                pp1.printStackTrace();
            }
        } else
        {
            kf.b(b, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
        }
        d = new bp(c, this, e, f, r, q);
        pp1 = new fd(d);
        c.addFooterView(o);
        c.setAdapter(pp1);
        c.expandGroup(0);
        t.setVisibility(8);
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b(b, (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public void onCreate(Bundle bundle)
    {
        HashMap hashmap;
        super.onCreate(bundle);
        setContentView(0x7f030045);
        u = (ProgressBar)findViewById(0x7f0c0111);
        appData = nb.a();
        appData.i(true);
        getActionBar().hide();
        t = findViewById(0x7f0c0064);
        c = (StickyGroupExpandableListView)findViewById(0x7f0c0110);
        g = (ImageView)findViewById(0x7f0c0067);
        w = (BBYTextView)findViewById(0x7f0c010e);
        w.setText(Html.fromHtml(getResources().getString(0x7f080389)));
        n = getResources().getStringArray(0x7f0a0002);
        e = new ArrayList(Arrays.asList(n));
        m = getResources().getStringArray(0x7f0a0001);
        f = new ArrayList(Arrays.asList(m));
        o = getLayoutInflater().inflate(0x7f0300ee, null, false);
        p = (Switch)o.findViewById(0x7f0c03b1);
        boolean flag;
        if (nb.a().b().getString("shake_your_device", "Off").equals("On"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p.setChecked(flag);
        if (getIntent() == null || getIntent().getStringExtra(nb.k) == null) goto _L2; else goto _L1
_L1:
        bundle = getIntent().getStringExtra(nb.k);
        getIntent().getStringExtra(nb.l);
        hashmap = new HashMap();
        if (!bundle.equalsIgnoreCase(nb.m)) goto _L4; else goto _L3
_L3:
        hashmap.put("bb.prevPageLink", "More: Blue Assist");
        hashmap.put(lu.bo, "browse,service");
        hashmap.put(lu.bp, "BLUEA");
_L6:
        lu.b(lu.aT, hashmap);
_L2:
        p.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final HelpMenuActivity a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                if (flag1)
                {
                    compoundbutton = "On";
                } else
                {
                    compoundbutton = "Off";
                }
                nb.a().b().edit().putString("shake_your_device", compoundbutton).commit();
            }

            
            {
                a = HelpMenuActivity.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final HelpMenuActivity a;

            public void onClick(View view)
            {
                if (ChatRunningStatus.getChatRunning() && HelpMenuActivity.c() != null)
                {
                    HelpMenuActivity.c().endChat();
                }
                a.finish();
                a.overridePendingTransition(0x7f040005, 0x7f040008);
            }

            
            {
                a = HelpMenuActivity.this;
                super();
            }
        });
        if (i())
        {
            s = (new qn(this)).a(ahy.a).a(this).a(this).b();
            s.b();
            t.setVisibility(0);
            return;
        } else
        {
            (new hx(this, null, t, null, null, null)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
_L4:
        if (bundle.equalsIgnoreCase(nb.n))
        {
            hashmap.put("bb.prevPageLink", "Shake: Blue Assist");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (!a)
        {
            h = null;
        }
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            appData.a(location.getLatitude());
            appData.b(location.getLongitude());
            if (s.d())
            {
                ahy.b.a(s, this);
            }
            (new hx(this, null, t, (new StringBuilder()).append("").append(location.getLatitude()).toString(), (new StringBuilder()).append("").append(location.getLongitude()).toString(), null)).executeOnExecutor(nb.h, new Void[0]);
        }
    }

    public void onNavigationRequest(JSONObject jsonobject)
    {
        kf.c("onNavigationRequest:", "Inside function onNavigationRequest ");
    }

    public void onQueueIdParamRetrievalFinished()
    {
    }

    public void onQueueIdParamRetrievalStarted()
    {
    }


    private class ChatBubbleService extends Service
    {

        private static BBYTextView c;
        private View a;
        private ImageView b;

        static ImageView a(ChatBubbleService chatbubbleservice)
        {
            return chatbubbleservice.b;
        }

        public static void c()
        {
            if (c != null)
            {
                c.setText((new StringBuilder()).append("").append(HelpMenuActivity.d()).toString());
                c.setVisibility(0);
            }
        }

        public void a()
        {
            WindowManager windowmanager = (WindowManager)getSystemService("window");
            LayoutInflater layoutinflater = (LayoutInflater)getSystemService("layout_inflater");
            android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
            layoutparams.gravity = 51;
            DisplayMetrics displaymetrics = new DisplayMetrics();
            windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
            layoutparams.x = displaymetrics.widthPixels - displaymetrics.widthPixels / 4;
            layoutparams.y = displaymetrics.heightPixels - displaymetrics.heightPixels / 4;
            layoutparams.type = 2003;
            layoutparams.flags = 0x20108;
            layoutparams.format = -3;
            layoutparams.width = -2;
            layoutparams.height = -2;
            a = layoutinflater.inflate(0x7f030020, null, false);
            b = (ImageView)a.findViewById(0x7f0c009f);
            c = (BBYTextView)a.findViewById(0x7f0c00a0);
            if (HelpMenuActivity.d() > 0)
            {
                c();
            }
            windowmanager.addView(a, layoutparams);
            a.setOnClickListener(new android.view.View.OnClickListener() {

                final ChatBubbleService a;

                public void onClick(View view)
                {
                    if (ChatRunningStatus.getChatRunning())
                    {
                        HelpMenuActivity.c().maximizeChat();
                    } else
                    {
                        ChatRunningStatus.setChatRunning(true);
                        HelpMenuActivity.c().startChat(HelpMenuActivity.e(), HelpMenuActivity.f(), HelpMenuActivity.g(), false);
                    }
                    a.stopService(new Intent(a.getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
                }

                
                {
                    a = ChatBubbleService.this;
                    super();
                }
            });
            b.setOnTouchListener(new android.view.View.OnTouchListener(layoutparams, windowmanager) {

                final android.view.WindowManager.LayoutParams a;
                final WindowManager b;
                final ChatBubbleService c;
                private android.view.WindowManager.LayoutParams d;
                private int e;
                private int f;
                private float g;
                private float h;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    motionevent.getAction();
                    JVM INSTR tableswitch 0 2: default 32
                //                               0 34
                //                               1 32
                //                               2 75;
                       goto _L1 _L2 _L1 _L3
_L1:
                    return false;
_L2:
                    e = d.x;
                    f = d.y;
                    g = motionevent.getRawX();
                    h = motionevent.getRawY();
                    continue; /* Loop/switch isn't completed */
_L3:
                    d.x = e + (int)(motionevent.getRawX() - g);
                    d.y = f + (int)(motionevent.getRawY() - h);
                    b.updateViewLayout(ChatBubbleService.a(c), d);
                    if (true) goto _L1; else goto _L4
_L4:
                }

                
                {
                    c = ChatBubbleService.this;
                    a = layoutparams;
                    b = windowmanager;
                    super();
                    d = a;
                }
            });
        }

        public void b()
        {
            if (a != null)
            {
                ((WindowManager)getSystemService("window")).removeView(a);
            }
        }

        public IBinder onBind(Intent intent)
        {
            return null;
        }

        public void onCreate()
        {
            super.onCreate();
        }

        public void onDestroy()
        {
            super.onDestroy();
            b();
            c = null;
            b = null;
            a = null;
        }

        public int onStartCommand(Intent intent, int i1, int j1)
        {
            a();
            return super.onStartCommand(intent, i1, j1);
        }

        public ChatBubbleService()
        {
        }
    }

}
