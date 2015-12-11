// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.apps.youtube.core.player.PlayerView;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.apps.youtube.kids.ui.ParentalControlLaunchBar;
import com.google.android.apps.youtube.kids.ui.ScrollAwareHorizontalListView;
import com.google.android.apps.youtube.kids.ui.TimeLimitProgressBar;

public class xz extends vq
    implements adu
{

    private rx h;
    private PlayerView i;
    private View j;
    private VideoView k;
    private adw l;
    private aec m;
    private ParentalControlLaunchBar n;
    private TimeLimitProgressBar o;
    private ScrollAwareHorizontalListView p;
    private boolean q;
    private boolean r;
    private boolean s;
    private aei t;

    public xz()
    {
    }

    public static Intent a(Context context, aei aei1)
    {
        context = new Intent(context, xz);
        context.putExtra("playback_sing_along_recording", aei1);
        return context;
    }

    static ScrollAwareHorizontalListView a(xz xz1)
    {
        return xz1.p;
    }

    private void handlePlaybackServiceException(cse cse1)
    {
        ya.a[cse1.a.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 53
    //                   2 53
    //                   3 53
    //                   4 53
    //                   5 53
    //                   6 53
    //                   7 59;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3
_L1:
        return;
_L2:
        q = true;
        return;
_L3:
        cse1 = cse1.c;
        if (cse1 != null && cse1.equals(getString(0x7f0b0122)))
        {
            s = true;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void handleSequencerStageEvent(csy csy1)
    {
        ya.b[csy1.a.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        csy1 = csy1.b;
        q = false;
        if (j != null)
        {
            ((TextView)findViewById(0x7f100072)).setText(csy1.c());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void handleConnectivityChangeEvent(bjv bjv1)
    {
        if (bjv1.a && s)
        {
            s = false;
            h.j();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c().A().a = true;
        setContentView(0x7f04005a);
        h = c().H();
        i = (PlayerView)findViewById(0x7f100193);
        ((KidsApplication)getApplicationContext()).h().y().a(i);
        j = findViewById(0x7f100097);
        k = (VideoView)findViewById(0x7f100191);
        n = (ParentalControlLaunchBar)findViewById(0x7f1000b9);
        n.a();
        o = (TimeLimitProgressBar)findViewById(0x7f1000b2);
        o.a();
        p = (ScrollAwareHorizontalListView)findViewById(0x7f100194);
        r = true;
        s = false;
        t = aei.getRecordingFromExtras(getIntent().getExtras(), "playback_sing_along_recording");
        if (t == null || !t.isValidRecording())
        {
            finish();
            return;
        } else
        {
            l = new adw(this);
            m = new aec(l, k, c().H());
            ((ViewGroup)findViewById(0x7f100190)).addView(l);
            k.setVideoPath(t.getRecordingPath());
            (new yb(this)).execute(new String[] {
                t.getVideoId()
            });
            return;
        }
    }

    protected void onPause()
    {
        m.onPause();
        bje bje1 = e().d();
        bje1.b(this);
        bje1.b(m);
        h.a(100F);
        h.c(isFinishing());
        super.onPause();
        c().A().a = false;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        q = bundle.getBoolean("isError");
        r = bundle.getBoolean("isFirstTime");
        s = bundle.getBoolean("isReloadNeeded");
        bundle = (uy)bundle.getParcelable("playbackServiceState");
        h.a(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        c().A().a = true;
        h.a(i.a);
        h.a(0.0F);
        bje bje1 = e().d();
        bje1.a(this);
        bje1.a(m);
        if (r)
        {
            r = false;
            cto cto1 = new cto(t.getVideoId(), null, 0, 0);
            if (!h.b(cto1))
            {
                h.a(cto1);
            }
        } else
        {
            NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
            boolean flag;
            if (networkinfo != null && networkinfo.isConnected())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && s)
            {
                s = false;
                h.j();
                return;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isError", q);
        bundle.putBoolean("isFirstTime", r);
        bundle.putBoolean("isReloadNeeded", s);
        bundle.putParcelable("playbackServiceState", h.e(false));
    }

    public void playRecording(aei aei1)
    {
        if (aei1 != t)
        {
            t = aei1;
            m.changeRecording(t);
        }
    }
}
