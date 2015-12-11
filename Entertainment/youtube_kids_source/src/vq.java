// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.apps.youtube.kids.activities.BrowseActivity;
import com.google.android.apps.youtube.kids.activities.SearchActivity;
import com.google.android.apps.youtube.kids.activities.TimeLimitExpiredActivity;
import com.google.android.apps.youtube.kids.activities.WatchActivity;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.YouTubeKidsTextView;
import com.google.userfeedback.android.api.UserFeedback;
import com.google.userfeedback.android.api.UserFeedbackSpec;
import java.io.IOException;

public abstract class vq extends m
{

    public dre f;
    public acd g;
    private Handler h;
    private View i;
    private TextView j;
    private Toast k;
    private acr l;
    private bme m;
    private SharedPreferences n;
    private BroadcastReceiver o;

    public vq()
    {
        o = new vr(this);
    }

    static acr a(vq vq1)
    {
        return vq1.l;
    }

    static TextView b(vq vq1)
    {
        return vq1.j;
    }

    static Toast c(vq vq1)
    {
        return vq1.k;
    }

    static void d(vq vq1)
    {
        AudioManager audiomanager = (AudioManager)vq1.getSystemService("audio");
        if (audiomanager.requestAudioFocus(null, 3, 3) == 1)
        {
            MediaPlayer mediaplayer = new MediaPlayer();
            AssetFileDescriptor assetfiledescriptor = vq1.getResources().openRawResourceFd(0x7f08000d);
            mediaplayer.setOnCompletionListener(new vs(vq1, audiomanager));
            if (assetfiledescriptor != null)
            {
                try
                {
                    mediaplayer.setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getLength());
                    mediaplayer.prepare();
                }
                catch (IOException ioexception)
                {
                    Log.e("TimerToast", ioexception.getMessage());
                }
            }
            vq1.h.postDelayed(new vu(vq1, mediaplayer), 1500L);
        }
    }

    static Handler e(vq vq1)
    {
        return vq1.h;
    }

    protected void a()
    {
        View view = findViewById(0x7f100166);
        if (view != null)
        {
            view.setOnClickListener(new vv(this, view));
        }
        view = findViewById(0x7f100081);
        if (view != null)
        {
            view.setOnClickListener(new vw(this));
            if (f())
            {
                findViewById(0x7f100081).setVisibility(8);
            } else
            {
                findViewById(0x7f100081).setVisibility(0);
            }
        }
        view = findViewById(0x7f1000c0);
        if (view != null)
        {
            view.setContentDescription(getResources().getString(0x7f0b01ea));
            view.setOnClickListener(new vx(this));
        }
    }

    public final void b()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            byte abyte0[] = bundle.getByteArray("navigation_endpoint");
            if (abyte0 != null)
            {
                f = bqf.a(abyte0);
            }
        }
    }

    public final aaa c()
    {
        return ((KidsApplication)getApplicationContext()).h();
    }

    public final cnq d()
    {
        return ((nc) ((KidsApplication)getApplicationContext())).b;
    }

    public final bgv e()
    {
        return ((nc) ((KidsApplication)getApplicationContext())).a;
    }

    public final boolean f()
    {
        return !n.getBoolean("search_mode", true);
    }

    public void g()
    {
        g.a(true);
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 1)
        {
            View view = findViewById(0x7f100166);
            if (view != null)
            {
                view.setEnabled(true);
            }
        }
        if (j1 == -1 && intent != null)
        {
            if (i1 == 1 && intent.getAction().equals("ACTION_START_GFEEDBACK"))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                intent = String.valueOf(getApplicationContext().getPackageName());
                Object obj = String.valueOf("USER_INITIATED_FEEDBACK_REPORT");
                intent = (new StringBuilder(String.valueOf(intent).length() + 1 + String.valueOf(obj).length())).append(intent).append(".").append(((String) (obj))).toString();
                obj = new UserFeedbackSpec(this, getCurrentFocus(), "*:S", intent);
                intent = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
                if (intent != null && intent.getType() == 1)
                {
                    intent = "Yes";
                } else
                {
                    intent = "No";
                }
                ((UserFeedbackSpec) (obj)).addProductSpecificBinaryData("Is on WIFI", "text/plain", intent.getBytes());
                if (f != null)
                {
                    ((UserFeedbackSpec) (obj)).addProductSpecificBinaryData("navigation", "text/plain", f.toString().getBytes());
                }
                intent = a.a(this, 0x100000);
                ((UserFeedbackSpec) (obj)).setScreenshotEnabled(true).setSystemLogEnabled(false).setScreenshot(intent);
                (new UserFeedback()).startFeedback(((UserFeedbackSpec) (obj)));
            }
            return;
        } else
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = new Handler();
        if (getApplicationContext() instanceof KidsApplication)
        {
            l = ((KidsApplication)getApplicationContext()).d;
        }
        i = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f040067, (ViewGroup)findViewById(0x7f1001bc));
        j = (YouTubeKidsTextView)i.findViewById(0x7f1001be);
        k = new Toast(getApplicationContext());
        int i1 = getResources().getDimensionPixelOffset(0x7f0a010b);
        k.setGravity(81, 0, i1);
        k.setView(i);
        k.setDuration(0);
        m = c().r();
        g = c().R();
        n = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    public void onPause()
    {
        bw.a(this).a(o);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("time_limit_start_intent");
        intentfilter.addAction("time_limit_update_intent");
        intentfilter.addAction("time_limit_cancel_intent");
        intentfilter.addAction("time_limit_expired_intent");
        bw.a(this).a(o, intentfilter);
        if (((KidsApplication)getApplicationContext()).d.f && ((this instanceof BrowseActivity) || (this instanceof SearchActivity) || (this instanceof WatchActivity)))
        {
            startActivity(new Intent(this, com/google/android/apps/youtube/kids/activities/TimeLimitExpiredActivity));
        }
        g();
    }

    public void onStart()
    {
        super.onStart();
        a();
        g.b(true);
    }

    protected void onStop()
    {
        g.b(false);
        super.onStop();
    }

    public void onUserInteraction()
    {
        if (m != null)
        {
            m.a();
        }
        super.onUserInteraction();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        Object obj = g;
        if (flag)
        {
            obj = ((acd) (obj)).f;
            if (((ack) (obj)).a != 1)
            {
                obj.c = false;
                if (((ack) (obj)).b)
                {
                    obj.b = false;
                } else
                if (((ack) (obj)).f.d && ((ack) (obj)).d && !((ack) (obj)).e)
                {
                    ((ack) (obj)).a(3);
                } else
                {
                    ((ack) (obj)).a(2);
                }
            }
        }
        super.onWindowFocusChanged(flag);
    }
}
