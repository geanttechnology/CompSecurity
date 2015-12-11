// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package co.vine.android:
//            CaptchaActivity, AppImpl

class > extends WebViewClient
{

    final CaptchaActivity this$0;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        webview.setVisibility(8);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag = false;
        webview = Uri.parse(s);
        if (webview.getScheme().equals("vine") || webview.getScheme().equals("vine-dev"))
        {
            if ("_captcha_complete".equals(webview.getHost()))
            {
                webview = new Intent();
                webview.putExtra("rid", CaptchaActivity.access$000(CaptchaActivity.this));
                setResult(-1, webview);
                (new AsyncTask() {

                    final CaptchaActivity._cls1 this$1;

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        AppImpl.getInstance().clearUploadCaptchas(getApplicationContext());
                        return null;
                    }

            
            {
                this$1 = CaptchaActivity._cls1.this;
                super();
            }
                }).execute(new Void[0]);
                finish();
            }
            flag = true;
        }
        return flag;
    }

    _cls1.this._cls1()
    {
        this$0 = CaptchaActivity.this;
        super();
    }
}
