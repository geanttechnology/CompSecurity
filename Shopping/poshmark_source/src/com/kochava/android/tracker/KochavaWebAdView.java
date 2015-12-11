// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.kochava.android.tracker:
//            Global, Feature

public class KochavaWebAdView extends Activity
    implements TraceFieldInterface
{
    private class MyPictureListener
        implements android.webkit.WebView.PictureListener
    {

        final KochavaWebAdView this$0;

        public void onNewPicture(WebView webview, Picture picture)
        {
            if (mDialog.isShowing())
            {
                mDialog.dismiss();
            }
        }

        private MyPictureListener()
        {
            this$0 = KochavaWebAdView.this;
            super();
        }

        MyPictureListener(MyPictureListener mypicturelistener)
        {
            this();
        }
    }


    Activity activity;
    boolean finishedLoad;
    ProgressDialog mDialog;
    boolean startLoad;

    public KochavaWebAdView()
    {
        startLoad = false;
        finishedLoad = false;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        mDialog.dismiss();
        if (Global.DEBUG)
        {
            Log.i("KochavaAds", "Back pressed.");
        }
        if (Feature.appContext.getResources().getIdentifier("kochava_slide_down", "anim", getPackageName()) != 0)
        {
            overridePendingTransition(Feature.appContext.getResources().getIdentifier("kochava_stay", "anim", getPackageName()), Feature.appContext.getResources().getIdentifier("kochava_slide_down", "anim", getPackageName()));
            return;
        } else
        {
            overridePendingTransition(0, 0x10a0003);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("KochavaWebAdView");
        TraceMachine.enterMethod(_nr_trace, "KochavaWebAdView#onCreate", null);
_L1:
        super.onCreate(bundle);
        activity = this;
        Object obj = getIntent().getExtras().getString("URL");
        bundle = new WebView(this);
        bundle.loadUrl(((String) (obj)));
        bundle.getSettings().setJavaScriptEnabled(true);
        bundle.getSettings().setBuiltInZoomControls(true);
        bundle.setPictureListener(new MyPictureListener(null));
        bundle.setWebViewClient(new WebViewClient() {

            final KochavaWebAdView this$0;

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                if (Global.DEBUG)
                {
                    Log.i("KochavaAds", (new StringBuilder("onPageStart Url = ")).append(s).toString());
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (Global.DEBUG)
                {
                    Log.i("KochavaAds", (new StringBuilder("shouldOverrideUrlLoading Url = ")).append(s).toString());
                }
                if (s.contains("market://"))
                {
                    webview = "";
                    s = Pattern.compile("\\?p=(.*)").matcher(s);
                    if (s.find())
                    {
                        webview = s.group(1);
                    }
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaAds", (new StringBuilder("LOADING: https://market.android.com/details?id=")).append(webview).toString());
                    }
                    s = new Intent("android.intent.action.VIEW");
                    s.setData(Uri.parse((new StringBuilder("https://market.android.com/details?id=")).append(webview).toString()));
                    activity.startActivity(s);
                    activity.finish();
                    return true;
                } else
                {
                    webview.loadUrl(s);
                    return true;
                }
            }

            
            {
                this$0 = KochavaWebAdView.this;
                super();
            }
        });
        requestWindowFeature(1);
        obj = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout) (obj)).setPadding(10, 10, 10, 10);
        Button button = new Button(this);
        button.setText("Close");
        button.setBackgroundColor(0xff000000);
        button.setTextColor(-1);
        button.setPadding(7, 3, 7, 5);
        ShapeDrawable shapedrawable = new ShapeDrawable(new RoundRectShape(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F, 5F, 5F, 0.0F, 0.0F
        }, null, null));
        shapedrawable.setPadding(7, 3, 7, 5);
        StateListDrawable statelistdrawable = new StateListDrawable();
        statelistdrawable.addState(new int[0], shapedrawable);
        button.setBackgroundDrawable(statelistdrawable);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final KochavaWebAdView this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = KochavaWebAdView.this;
                super();
            }
        });
        if (bundle.getParent() != null)
        {
            ((ViewGroup)bundle.getParent()).removeView(bundle);
        }
        ((RelativeLayout) (obj)).addView(bundle);
        ((RelativeLayout) (obj)).addView(button);
        setContentView(((View) (obj)), layoutparams);
        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final KochavaWebAdView this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (Global.DEBUG)
                {
                    Log.i("KochavaAds", "Back pressed during loading dialog.");
                }
                activity.onBackPressed();
            }

            
            {
                this$0 = KochavaWebAdView.this;
                super();
            }
        });
        mDialog.setMessage("Loading...");
        mDialog.show();
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "KochavaWebAdView#onCreate", null);
          goto _L1
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
