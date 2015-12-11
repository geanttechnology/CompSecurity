// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.device.ads:
//            AdView, IAdActivityAdapter, Assets, AndroidTargetUtils, 
//            ThreadUtils, AdUtils, WebViewFactory, DeviceInfo, 
//            MraidView

class InterstitialAdActivityAdapter
    implements AdView, IAdActivityAdapter
{

    private final int CLOSE_BUTTON_SIZE_DP = 60;
    private final int CLOSE_BUTTON_TAP_TARGET_SIZE_DP = 80;
    private Activity activity;
    private String uniqueId;

    InterstitialAdActivityAdapter()
    {
        activity = null;
        uniqueId = null;
    }

    private void addNativeCloseButton(final FrameLayout parentView)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)activity.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        int i = (int)(60F * displaymetrics.density + 0.5F);
        int j = (int)(80F * displaymetrics.density + 0.5F);
        ThreadUtils.executeAsyncTask(new AsyncTask() {

            final InterstitialAdActivityAdapter this$0;
            final int val$buttonSize;
            final BitmapDrawable val$closeNormal;
            final BitmapDrawable val$closePressed;
            final FrameLayout val$parentView;
            final int val$tapTargetSize;

            protected transient RelativeLayout doInBackground(Void avoid[])
            {
                avoid = new RelativeLayout(parentView.getContext());
                ImageButton imagebutton = new ImageButton(parentView.getContext());
                imagebutton.setImageDrawable(closeNormal);
                imagebutton.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                imagebutton.setBackgroundDrawable(null);
                Object obj = new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        activity.finish();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                };
                imagebutton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
                avoid.setOnClickListener(((android.view.View.OnClickListener) (obj)));
                obj = imagebutton. new android.view.View.OnTouchListener() {

                    final _cls1 this$1;
                    final ImageView val$closeButton;

                    public boolean onTouch(View view, MotionEvent motionevent)
                    {
                        motionevent.getAction();
                        JVM INSTR tableswitch 0 1: default 28
                    //                                   0 30
                    //                                   1 47;
                           goto _L1 _L2 _L3
_L1:
                        return false;
_L2:
                        closeButton.setImageDrawable(closePressed);
                        continue; /* Loop/switch isn't completed */
_L3:
                        closeButton.setImageDrawable(closeNormal);
                        if (true) goto _L1; else goto _L4
_L4:
                    }

            
            {
                this$1 = final__pcls1;
                closeButton = ImageView.this;
                super();
            }
                };
                avoid.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
                imagebutton.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
                obj = new android.widget.RelativeLayout.LayoutParams(buttonSize, buttonSize);
                ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
                avoid.addView(imagebutton, ((android.view.ViewGroup.LayoutParams) (obj)));
                return avoid;
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(RelativeLayout relativelayout)
            {
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(tapTargetSize, tapTargetSize, 5);
                layoutparams.topMargin = 0;
                layoutparams.rightMargin = 0;
                parentView.addView(relativelayout, layoutparams);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((RelativeLayout)obj);
            }

            
            {
                this$0 = InterstitialAdActivityAdapter.this;
                parentView = framelayout;
                closeNormal = bitmapdrawable;
                closePressed = bitmapdrawable1;
                buttonSize = i;
                tapTargetSize = j;
                super();
            }
        }, new Void[0]);
    }

    private void sendBroadcast(String s)
    {
        Intent intent = new Intent("amazon.mobile.ads.interstitial");
        intent.putExtra("action", s);
        intent.putExtra("uniqueIdentifier", uniqueId);
        activity.sendBroadcast(intent);
    }

    Activity getActivity()
    {
        return activity;
    }

    public int getHeight()
    {
        return 0;
    }

    public AdWebViewClient.UrlExecutor getSpecialUrlExecutor()
    {
        return new AdWebViewClient.AmazonMobileExecutor(this, activity);
    }

    public boolean isAdViewRenderable()
    {
        return true;
    }

    public boolean launchExternalBrowserForLink(String s)
    {
        if (isAdViewRenderable())
        {
            return AdUtils.launchActivityForIntentLink(s, activity);
        } else
        {
            return false;
        }
    }

    public void onCreate()
    {
        WebView webview = WebViewFactory.getInstance().createWebView(activity);
        if (DeviceInfo.getUserAgentString() == null)
        {
            DeviceInfo.setUserAgentString(webview.getSettings().getUserAgentString());
        }
        uniqueId = activity.getIntent().getStringExtra("uniqueIdentifier");
        String s = activity.getIntent().getStringExtra("creative").replace("<head>", "<head>\n  <script type='text/javascript'>\n  function fireImpression(a) {\n    var container = document.createElement('div');\n    var pix = document.createElement('img');\n    pix.setAttribute('src', a);\n    pix.style.position = 'absolute';\n    pix.style.top = '0px';\n    pix.style.right = '0px';\n    pix.style.display = 'none';\n    container.appendChild(pix);\n    document.body.appendChild(container);\n  }\n  </script>\n");
        MraidView mraidview = MraidView.removeCachedMraidView(uniqueId);
        if (mraidview == null)
        {
            webview.setBackgroundColor(0);
            mraidview = new MraidView(this, activity, webview);
        } else
        {
            mraidview.registerReceivers();
            mraidview.setAdView(this);
        }
        mraidview.loadHtmlData("http://amazon-adsystem.amazon.com/", s);
        addNativeCloseButton(mraidview);
        activity.setContentView(mraidview);
    }

    public void onPageFinished()
    {
        sendBroadcast("finished");
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onStop()
    {
        if (activity.isFinishing())
        {
            sendBroadcast("dismissed");
        }
    }

    public void preOnCreate()
    {
        activity.requestWindowFeature(1);
        activity.getWindow().setFlags(1024, 1024);
        if (android.os.Build.VERSION.SDK_INT > 11)
        {
            AndroidTargetUtils.hideActionAndStatusBars(activity);
        }
    }

    public void setActivity(Activity activity1)
    {
        activity = activity1;
    }

    public boolean shouldDisableWebViewHardwareAcceleration()
    {
        return false;
    }

}
