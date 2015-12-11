// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.internal.gd;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.MraidView;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tapjoy:
//            TJAdUnitSaveStateData, TJAdUnit, TapjoyLog, TJPlacementData, 
//            TJPlacementManager, TJPlacement, TapjoyConnectCore, TJCloseButton, 
//            TJPlacementListener

public class TJAdUnitActivity extends Activity
    implements android.view.View.OnClickListener
{
    final class a extends BroadcastReceiver
    {

        final TJAdUnitActivity a;

        public final void onReceive(Context context, Intent intent)
        {
            if (intent.getBooleanExtra("noConnectivity", false))
            {
                TapjoyLog.i("TJAdUnitActivity", "Network connectivity lost during ad unit activity");
                a.showErrorDialog();
            }
        }

        private a()
        {
            a = TJAdUnitActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private TJAdUnit a;
    private TJPlacementData b;
    private a c;
    private TJAdUnitSaveStateData d;
    private RelativeLayout e;
    private TJCloseButton f;
    private ProgressBar g;
    private boolean h;

    public TJAdUnitActivity()
    {
        d = new TJAdUnitSaveStateData();
        e = null;
        h = false;
    }

    static TJAdUnit a(TJAdUnitActivity tjadunitactivity)
    {
        return tjadunitactivity.a;
    }

    public void handleClose()
    {
        if (!a.getCloseRequested())
        {
            TapjoyLog.i("TJAdUnitActivity", "closeRequested");
            a.closeRequested();
            TimerTask timertask = new TimerTask() {

                final TJAdUnitActivity a;

                public final void run()
                {
                    if (TJAdUnitActivity.a(a).getCloseRequested())
                    {
                        TapjoyLog.i("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
                        a.finish();
                    }
                }

            
            {
                a = TJAdUnitActivity.this;
                super();
            }
            };
            (new Timer()).schedule(timertask, 1000L);
        }
    }

    public void onBackPressed()
    {
        handleClose();
    }

    public void onClick(View view)
    {
        handleClose();
    }

    protected void onCreate(Bundle bundle)
    {
        TapjoyLog.i("TJAdUnitActivity", (new StringBuilder("TJAdUnitActivity onCreate: ")).append(bundle).toString());
        super.onCreate(bundle);
        if (bundle != null)
        {
            d = (TJAdUnitSaveStateData)bundle.getSerializable("ad_unit_bundle");
        }
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("placement_data") != null)
        {
            b = (TJPlacementData)bundle.getSerializable("placement_data");
            MraidView mraidview;
            Object obj;
            android.widget.RelativeLayout.LayoutParams layoutparams;
            if (TJPlacementManager.get(b.getGuid()) != null)
            {
                a = TJPlacementManager.get(b.getGuid()).c();
                a.setContext(this);
            } else
            {
                a = new TJAdUnit(this);
            }
            a.setViewType(b.getViewType());
            if (!a.isAdUnitConstructed())
            {
                TapjoyLog.i("TJAdUnitActivity", "No content loaded for ad unit -- loading now");
                a.load(b);
            }
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                setTheme(0x1030005);
            } else
            {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
                getWindow().setFlags(0x1000000, 0x1000000);
            }
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            if (!TapjoyConnectCore.isUnitTestMode())
            {
                c = new a((byte)0);
                registerReceiver(c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            e = new RelativeLayout(this);
            e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            if (b.getViewType() == 1)
            {
                e.setBackgroundColor(-1);
                e.getBackground().setAlpha(255);
            } else
            {
                e.setBackgroundColor(0);
            }
            bundle = a.getBackgroundWebView();
            bundle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            if (bundle.getParent() != null)
            {
                ((ViewGroup)bundle.getParent()).removeView(bundle);
            }
            mraidview = a.getWebView();
            mraidview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            if (mraidview.getParent() != null)
            {
                ((ViewGroup)mraidview.getParent()).removeView(mraidview);
            }
            obj = a.getVideoView();
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(13);
            ((VideoView) (obj)).setLayoutParams(layoutparams);
            if (((VideoView) (obj)).getParent() != null)
            {
                ((ViewGroup)((VideoView) (obj)).getParent()).removeView(((View) (obj)));
            }
            e.addView(bundle);
            e.addView(((View) (obj)));
            e.addView(mraidview);
            if (b.hasProgressSpinner())
            {
                g = new ProgressBar(this, null, 0x101007a);
                g.setVisibility(0);
                bundle = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                bundle.addRule(13);
                g.setLayoutParams(bundle);
                e.addView(g);
            }
            if (!a.getWebView().isMraid())
            {
                f = new TJCloseButton(this);
                f.setOnClickListener(this);
                e.addView(f);
            }
            setContentView(e);
            a.setVisible(true);
            TapjoyConnectCore.viewDidOpen(b.getViewType());
            bundle = TJPlacementManager.get(b.getGuid());
            if (bundle != null && bundle.a() != null)
            {
                bundle.a().onContentShow(bundle);
            }
            return;
        } else
        {
            TapjoyLog.e("TJAdUnitActivity", "Failed to launch AdUnit Activity");
            finish();
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        TapjoyLog.i("TJAdUnitActivity", "onDestroy");
        if (a != null)
        {
            a.destroy();
        }
        if (c != null && !TapjoyConnectCore.isUnitTestMode())
        {
            unregisterReceiver(c);
        }
        TapjoyConnectCore.viewWillClose(b.getViewType());
        TapjoyConnectCore.viewDidClose(b.getViewType());
        TJPlacement tjplacement = TJPlacementManager.get(b.getGuid());
        if (tjplacement != null && tjplacement.a() != null)
        {
            tjplacement.a().onContentDismiss(tjplacement);
        }
    }

    protected void onPause()
    {
        super.onPause();
        a.pauseVideo();
    }

    protected void onResume()
    {
        TapjoyLog.i("TJAdUnitActivity", "onResume");
        super.onResume();
        if (a.isLockedOrientation())
        {
            setRequestedOrientation(a.getOrientation());
        }
        a.resume(d);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        TapjoyLog.i("TJAdUnitActivity", "onSaveInstanceState");
        d.seekTime = a.getVideoSeekTime();
        bundle.putSerializable("ad_unit_bundle", d);
    }

    protected void onStart()
    {
        super.onStart();
        if (TapjoyConnectCore.isAutoSessionTrackingStarted())
        {
            h = true;
            gd.a().a(this);
        }
    }

    protected void onStop()
    {
        if (h)
        {
            h = false;
            gd.a().b(this);
        }
        super.onStop();
    }

    public void setCloseButtonVisibility(boolean flag)
    {
        if (flag)
        {
            f.setVisibility(0);
            return;
        } else
        {
            f.setVisibility(4);
            return;
        }
    }

    public void setProgressSpinnerVisibility(boolean flag)
    {
label0:
        {
            if (g != null)
            {
                if (!flag)
                {
                    break label0;
                }
                g.setVisibility(0);
            }
            return;
        }
        g.setVisibility(4);
    }

    public void showErrorDialog()
    {
        if (!isFinishing())
        {
            (new android.app.AlertDialog.Builder(this)).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                final TJAdUnitActivity a;

                public final void onClick(DialogInterface dialoginterface, int i)
                {
                    a.handleClose();
                    dialoginterface.cancel();
                }

            
            {
                a = TJAdUnitActivity.this;
                super();
            }
            }).create().show();
        }
    }
}
