// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.kochava.android.tracker:
//            Global, Feature, KochavaWebAdView

class val.clickUrl extends Thread
{

    final val.fAdUrl this$1;
    private final WebView val$adWebview;
    private final String val$clickUrl;
    private final Activity val$context;
    private final String val$fAdUrl;

    public void run()
    {
        val$adWebview.setVerticalScrollBarEnabled(false);
        val$adWebview.setHorizontalScrollBarEnabled(false);
        val$adWebview.getSettings().setBuiltInZoomControls(false);
        val$adWebview.setOnTouchListener(new android.view.View.OnTouchListener() {

            final Feature._cls6._cls1 this$2;
            private final String val$clickUrl;
            private final Activity val$context;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                int i = (int)motionevent.getRawX();
                int j = (int)motionevent.getRawY();
                int ai[] = new int[2];
                view.getLocationOnScreen(ai);
                int k = ai[0];
                int l = view.getWidth();
                int i1 = ai[1];
                int j1 = view.getHeight();
                if (motionevent.getAction() == 1 && i > ai[0] && i < k + l && j > ai[1] && j < i1 + j1)
                {
                    view = new Intent(context, com/kochava/android/tracker/KochavaWebAdView);
                    motionevent = new Bundle();
                    motionevent.putString("URL", clickUrl);
                    view.putExtras(motionevent);
                    context.startActivity(view);
                    if (context.getResources().getIdentifier("kochava_slide_up", "anim", context.getPackageName()) != 0)
                    {
                        context.overridePendingTransition(context.getResources().getIdentifier("kochava_slide_up", "anim", context.getPackageName()), context.getResources().getIdentifier("kochava_stay", "anim", context.getPackageName()));
                    } else
                    {
                        context.overridePendingTransition(0x10a0002, 0x10a0001);
                    }
                }
                return true;
            }

            
            {
                this$2 = Feature._cls6._cls1.this;
                context = activity;
                clickUrl = s;
                super();
            }
        });
        val$adWebview.getSettings().setJavaScriptEnabled(true);
        if (Global.DEBUG)
        {
            Log.e("KochavaAds", (new StringBuilder("Loading add ")).append(val$fAdUrl).toString());
        }
        val$adWebview.loadUrl(val$fAdUrl);
    }

    l.adWebview()
    {
        this$1 = final_adwebview;
        val$adWebview = webview;
        val$fAdUrl = s;
        val$context = activity;
        val$clickUrl = String.this;
        super();
    }

    // Unreferenced inner class com/kochava/android/tracker/Feature$6

/* anonymous class */
    class Feature._cls6 extends Thread
    {

        final Feature this$0;
        private final WebView val$adWebview;
        private final Activity val$context;
        private final int val$height;
        private final int val$width;

        public void run()
        {
            final Object fAdUrl;
            String s;
            Object obj1;
            char ac[];
            int i;
            s = "";
            obj1 = context.getPackageManager();
            try
            {
                fAdUrl = ((PackageManager) (obj1)).getApplicationInfo(Feature.access$50(Feature.this), 0);
            }
            // Misplaced declaration of an exception variable
            catch (final Object fAdUrl)
            {
                fAdUrl = null;
            }
            if (fAdUrl != null)
            {
                fAdUrl = ((PackageManager) (obj1)).getApplicationLabel(((android.content.pm.ApplicationInfo) (fAdUrl)));
            } else
            {
                fAdUrl = "(unknown)";
            }
            obj1 = (String)fAdUrl;
            fAdUrl = Feature.access$38(Feature.this, false);
            if (Feature.access$51() == null || Feature.access$51().trim().isEmpty())
            {
                Feature.access$52("bidder.kochava.com");
            }
            obj1 = new HttpGet((new StringBuilder("http://")).append(Feature.access$51()).append("/adserver/request/").append("?w=").append(width).append("&h=").append(height).append("&odin=").append(Feature.access$53(Feature.this)).append("&aid=").append(Feature.access$49(Feature.this)).append("&an=").append(((String) (obj1))).append("&av=").append("Android20140428").append("&kochava_device_id=").append(Feature.access$18(Feature.this)).toString());
            if (fAdUrl instanceof HttpClient) goto _L2; else goto _L1
_L1:
            fAdUrl = ((HttpClient) (fAdUrl)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
_L7:
            obj1 = ((HttpResponse) (fAdUrl)).getEntity();
            fAdUrl = s;
            if (obj1 == null) goto _L4; else goto _L3
_L3:
            fAdUrl = new InputStreamReader(((HttpEntity) (obj1)).getContent(), "ISO-8859-1");
            obj1 = new StringBuilder();
            ac = new char[1024];
_L8:
            i = ((Reader) (fAdUrl)).read(ac);
            if (i != -1) goto _L6; else goto _L5
_L5:
            fAdUrl = ((StringBuilder) (obj1)).toString();
_L4:
            s = "";
            obj1 = "";
            if (Global.DEBUG)
            {
                Log.e("KochavaAds", (new StringBuilder("Response:")).append(((String) (fAdUrl))).toString());
            }
            ac = Pattern.compile("href='(.*?)'").matcher(((CharSequence) (fAdUrl)));
            if (ac.find())
            {
                s = ac.group(1);
            }
            ac = Pattern.compile("src='(.*?)'").matcher(((CharSequence) (fAdUrl)));
            fAdUrl = obj1;
            if (ac.find())
            {
                fAdUrl = ac.group(1);
            }
            fAdUrl = s. new Feature._cls6._cls1();
            context.runOnUiThread(((Runnable) (fAdUrl)));
            return;
_L2:
            fAdUrl = HttpInstrumentation.execute((HttpClient)fAdUrl, ((org.apache.http.client.methods.HttpUriRequest) (obj1)));
              goto _L7
_L6:
            ((StringBuilder) (obj1)).append(ac, 0, i);
              goto _L8
            fAdUrl;
_L10:
            Object obj;
            if (Global.DEBUG)
            {
                Log.e("KochavaAds", (new StringBuilder("Problem grabbing ad: ")).append(((IOException) (obj)).getMessage()).toString());
            }
            ((IOException) (obj)).printStackTrace();
            obj = s;
              goto _L4
            obj;
_L9:
            if (Global.DEBUG)
            {
                Log.e("KochavaAds", (new StringBuilder("Problem grabbing ad: ")).append(((NoSuchAlgorithmException) (obj)).getMessage()).toString());
            }
            ((NoSuchAlgorithmException) (obj)).printStackTrace();
            obj = s;
              goto _L4
            obj;
              goto _L9
            obj;
              goto _L10
        }

            
            {
                this$0 = final_feature;
                context = activity;
                width = i;
                height = j;
                adWebview = WebView.this;
                super();
            }
    }

}
