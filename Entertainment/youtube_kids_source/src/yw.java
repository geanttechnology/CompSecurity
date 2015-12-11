// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.apps.youtube.core.player.PlayerView;
import com.google.android.apps.youtube.kids.ui.ParentalControlLaunchBar;
import com.google.android.apps.youtube.kids.ui.TimeLimitProgressBar;

public class yw extends vq
{

    private rx h;
    private PlayerView i;
    private aem j;
    private FrameLayout k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private TextView q;
    private FrameLayout r;
    private ParentalControlLaunchBar s;
    private TimeLimitProgressBar t;
    private boolean u;
    private boolean v;
    private boolean w;
    private yz x;
    private Bundle y;

    public yw()
    {
    }

    private void a(int i1)
    {
        if (i1 == 0)
        {
            q.setVisibility(8);
            r.setVisibility(8);
            j.startRecording();
            h.g();
            a(yz.d);
            return;
        } else
        {
            r.getLayoutParams().width = i.getWidth();
            r.getLayoutParams().height = i.getHeight();
            r.requestLayout();
            r.setVisibility(0);
            q.setVisibility(0);
            q.setText(Integer.toString(i1));
            AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation.setDuration(1000L);
            alphaanimation.setAnimationListener(new yx(this, i1));
            q.startAnimation(alphaanimation);
            return;
        }
    }

    static void a(yw yw1, int i1)
    {
        yw1.a(i1);
    }

    private void a(yz yz1)
    {
        x = yz1;
        switch (yy.a[yz1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            m.setVisibility(8);
            return;

        case 2: // '\002'
            m.setVisibility(0);
            return;

        case 3: // '\003'
            m.setVisibility(8);
            o.setVisibility(8);
            return;

        case 4: // '\004'
            n.setVisibility(0);
            return;

        case 5: // '\005'
            n.setVisibility(8);
            break;
        }
    }

    private void h()
    {
        h.i();
        j.stopRecording();
        a(yz.e);
        if (j.hasValidRecording())
        {
            startActivityForResult(yg.a(this, j.getSingAlongRecording()), 1);
        }
    }

    private void handleSequencerStageEvent(csy csy1)
    {
        switch (yy.b[csy1.a.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            csy1 = csy1.b;
            break;
        }
        u = false;
        if (l != null)
        {
            ((TextView)findViewById(0x7f100072)).setText(csy1.c());
        }
        j.setVideoId(bxb.a(((bxb) (csy1)).a));
    }

    public void flipCameraClicked(View view)
    {
        j.flipCamera();
    }

    public void handleConnectivityChangeEvent(bjv bjv1)
    {
        if (bjv1.a && w)
        {
            w = false;
            h.j();
        }
    }

    public void handleVideoStageEvent(ctd ctd1)
    {
        if (ctd1.b == ctt.j && x == yz.d)
        {
            h();
        }
    }

    public void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        boolean flag = false;
        ctf1.a;
        JVM INSTR tableswitch 5 6: default 28
    //                   5 29
    //                   6 52;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        p.setVisibility(0);
        if (x == yz.d)
        {
            h();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        p.setVisibility(8);
        ctf1 = x;
        yz yz1 = yz.d;
        if (ctf1.ordinal() < yz1.ordinal())
        {
            flag = true;
        }
        if (flag)
        {
            h.i();
            a(yz.b);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 1)
        {
            if (j1 == -1)
            {
                startActivity(xz.a(this, j.getSingAlongRecording()));
                finish();
            } else
            if (j1 == 0)
            {
                j.deleteRecording();
                h.a(0);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c().A().a = true;
        setContentView(0x7f04005d);
        y = getIntent().getExtras();
        h = c().H();
        i = (PlayerView)findViewById(0x7f100193);
        l = findViewById(0x7f100097);
        m = findViewById(0x7f1001a1);
        n = findViewById(0x7f1001a2);
        s = (ParentalControlLaunchBar)findViewById(0x7f1000b9);
        s.a();
        t = (TimeLimitProgressBar)findViewById(0x7f1000b2);
        t.a();
        q = (TextView)findViewById(0x7f10019d);
        r = (FrameLayout)findViewById(0x7f10019c);
        k = (FrameLayout)findViewById(0x7f10019e);
        o = findViewById(0x7f10019f);
        p = findViewById(0x7f1000cd);
        x = yz.a;
        v = true;
        w = false;
        j = new aem(this);
        k.addView(j.getCameraPreview());
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        b();
    }

    public void onPause()
    {
        e().d().b(this);
        h.c(isFinishing());
        if (x == yz.d)
        {
            j.stopRecording();
            a(yz.e);
        }
        super.onPause();
        j.onActivityPause();
        c().A().a = false;
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        u = bundle.getBoolean("isError");
        v = bundle.getBoolean("isFirstTime");
        w = bundle.getBoolean("isReloadNeeded");
        bundle = (uy)bundle.getParcelable("playbackServiceState");
        h.a(bundle);
        p.setVisibility(8);
    }

    public void onResume()
    {
        super.onResume();
        c().A().a = true;
        if (j.hasValidRecording())
        {
            startActivityForResult(yg.a(this, j.getSingAlongRecording()), 1);
        }
        h.a(i.a);
        e().d().a(this);
        a(yz.a);
        if (!v || !y.containsKey("playbackStartDescriptor")) goto _L2; else goto _L1
_L1:
        v = false;
        cto cto1 = (cto)y.getParcelable("playbackStartDescriptor");
        if (cto1 != null)
        {
            h.a(cto1);
        }
_L4:
        j.onActivityResume();
        return;
_L2:
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if (networkinfo != null && networkinfo.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && w)
        {
            w = false;
            h.j();
            p.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isError", u);
        bundle.putBoolean("isFirstTime", v);
        bundle.putBoolean("isReloadNeeded", w);
        bundle.putParcelable("playbackServiceState", h.e(false));
    }

    public void startSingingClicked(View view)
    {
        a(yz.c);
        a(3);
    }

    public void stopSingingClicked(View view)
    {
        h();
    }
}
