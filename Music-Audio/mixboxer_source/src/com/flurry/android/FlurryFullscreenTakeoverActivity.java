// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.Collections;

// Referenced classes of package com.flurry.android:
//            cf, s, FlurryAds, cy, 
//            ft, gk, h, ee, 
//            aq, FlurryAgent, AdUnit

public final class FlurryFullscreenTakeoverActivity extends Activity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
    public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
    public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
    public static final String EXTRA_KEY_URL = "url";
    private static final String p = com/flurry/android/FlurryFullscreenTakeoverActivity.getSimpleName();
    private AdUnit T;
    private String dq;
    private long fA;
    private ft fr;
    private ViewGroup fs;
    private cf ft;
    private ProgressDialog fu;
    private VideoView fv;
    private boolean fw;
    private MediaController fx;
    private boolean fy;
    private Intent fz;

    public FlurryFullscreenTakeoverActivity()
    {
    }

    static VideoView a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        return flurryfullscreentakeoveractivity.fv;
    }

    static VideoView a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, VideoView videoview)
    {
        flurryfullscreentakeoveractivity.fv = videoview;
        return videoview;
    }

    static void a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, String s1)
    {
        flurryfullscreentakeoveractivity.u(s1);
    }

    static boolean a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, String s1, String s2)
    {
        if (!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2))
        {
            if (!TextUtils.isEmpty(flurryfullscreentakeoveractivity = Uri.parse(s2).getQueryParameter("link")) && flurryfullscreentakeoveractivity.equalsIgnoreCase(s1))
            {
                return true;
            }
        }
        return false;
    }

    static boolean a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, boolean flag)
    {
        flurryfullscreentakeoveractivity.fw = flag;
        return flag;
    }

    private void aG()
    {
        if (fu != null)
        {
            if (fu.isShowing())
            {
                fu.dismiss();
            }
            fu = null;
        }
        if (ft != null)
        {
            ft.setVisibility(0);
        }
        if (fv != null)
        {
            if (fv.isPlaying())
            {
                fv.stopPlayback();
            }
            if (fs != null)
            {
                fs.removeView(fv);
            }
            fv = null;
        }
        fw = false;
        fx = null;
    }

    static String b(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        return flurryfullscreentakeoveractivity.dq;
    }

    static boolean b(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, String s1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!TextUtils.isEmpty(s1))
        {
            flurryfullscreentakeoveractivity = Uri.parse(s1);
            flag = flag1;
            if (flurryfullscreentakeoveractivity.getScheme() != null)
            {
                flag = flag1;
                if (flurryfullscreentakeoveractivity.getScheme().equals("market"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static boolean t(String s1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!TextUtils.isEmpty(s1))
        {
            s1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(s1));
            flag = flag1;
            if (s1 != null)
            {
                flag = flag1;
                if (s1.startsWith("video/"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void u(String s1)
    {
        if (!TextUtils.isEmpty(s1) && fv != null && fs != null)
        {
            fx = new MediaController(this);
            fv.setOnPreparedListener(this);
            fv.setOnCompletionListener(this);
            fv.setOnErrorListener(this);
            fv.setMediaController(fx);
            fv.setVideoURI(Uri.parse(s1));
            fs.addView(fv, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            fu = new ProgressDialog(this);
            fu.setProgressStyle(0);
            fu.setMessage("Loading...");
            fu.setCancelable(true);
            fu.show();
            if (ft != null)
            {
                ft.setVisibility(8);
                return;
            }
        }
    }

    static boolean v(String s1)
    {
        return t(s1);
    }

    final AdUnit L()
    {
        return T;
    }

    final ft aH()
    {
        return fr;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public final void onCreate(Bundle bundle)
    {
        Intent intent;
        int i;
        i = -1;
        setTheme(0x1030007);
        super.onCreate(bundle);
        s.a(getWindow());
        intent = getIntent();
        fz = (Intent)intent.getParcelableExtra("targetIntent");
        dq = intent.getStringExtra("adSpaceName");
        if (fz == null) goto _L2; else goto _L1
_L1:
        try
        {
            startActivity(fz);
            fA = SystemClock.elapsedRealtime();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            cy.b(p, "Cannot launch Activity", bundle);
            fz = null;
            finish();
        }
_L4:
        FlurryAds.getInstance().a(this);
        return;
_L2:
        String s1 = intent.getStringExtra("url");
        if (s1 == null)
        {
            fs = new RelativeLayout(this);
            int j;
            if (bundle != null)
            {
                i = bundle.getInt("frameIndex", -1);
            }
            j = i;
            if (i < 0)
            {
                j = intent.getIntExtra("frameIndex", 0);
            }
            bundle = FlurryAds.getInstance();
            T = bundle.br();
            if (T != null)
            {
                fr = new ft(this, bundle, bundle.bq(), T, j);
                fr.initLayout(this);
                bundle = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                bundle.addRule(13);
                fs.addView(fr, bundle);
                setContentView(fs);
            }
        } else
        {
            fs = new FrameLayout(this);
            setContentView(fs);
            if (t(s1))
            {
                fv = new gk(this);
                u(s1);
            } else
            {
                ft = new cf(this, s1);
                ft.a(new h(this));
                ft.a(new ee(this));
                ft.a(new aq(this));
                fs.addView(ft);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void onDestroy()
    {
        aG();
        if (ft != null)
        {
            ft.destroy();
        }
        if (fr != null)
        {
            fr.stop();
        }
        FlurryAds.getInstance().b(this);
        super.onDestroy();
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        cy.d(p, "error occurs during video playback");
        if (ft != null)
        {
            if (fw)
            {
                if (ft.canGoBack())
                {
                    ft.goBack();
                    aG();
                } else
                {
                    finish();
                }
            } else
            {
                aG();
            }
        } else
        {
            finish();
        }
        return true;
    }

    public final boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (fr != null)
            {
                fr.a("adWillClose", Collections.emptyMap(), fr.T, fr.S, fr.U, 0);
                return true;
            }
            if (fv != null)
            {
                if (ft != null)
                {
                    if (fw)
                    {
                        if (ft.canGoBack())
                        {
                            ft.goBack();
                            aG();
                            return true;
                        }
                    } else
                    {
                        aG();
                        return true;
                    }
                }
            } else
            if (ft != null && ft.canGoBack())
            {
                ft.goBack();
                return true;
            }
        }
        return super.onKeyUp(i, keyevent);
    }

    protected final void onPause()
    {
        super.onPause();
        fy = false;
        if (fv != null && fv.isPlaying())
        {
            fv.pause();
        }
        if (fr != null)
        {
            fr.pause();
        }
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (fu != null && fu.isShowing())
        {
            fu.dismiss();
        }
        if (fv != null && fy)
        {
            fv.start();
        }
    }

    protected final void onRestart()
    {
        super.onRestart();
    }

    protected final void onResume()
    {
        super.onResume();
        fy = true;
        if (fx != null)
        {
            fx.show(0);
        }
        if (fr != null)
        {
            fr.resume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (fr != null)
        {
            bundle.putInt("frameIndex", fr.U);
        }
    }

    public final void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (FlurryAgent.y() != null)
        {
            FlurryAgent.onStartSession(this, FlurryAgent.y());
            return;
        } else
        {
            finish();
            return;
        }
    }

    public final void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        FlurryAgent.onEndSession(this);
        super.onStop();
    }

    public final void onWindowFocusChanged(boolean flag)
    {
        (new StringBuilder()).append("onWindowFocusChanged hasFocus = ").append(flag).toString();
        if (fy && flag && fz != null && SystemClock.elapsedRealtime() - fA > 250L)
        {
            finish();
        }
        super.onWindowFocusChanged(flag);
    }

}
