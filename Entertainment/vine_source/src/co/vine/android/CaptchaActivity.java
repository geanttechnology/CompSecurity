// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import co.vine.android.network.HttpOperation;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, AppImpl

public class CaptchaActivity extends BaseControllerActionBarActivity
{

    public static final int CAPTCHA_CANCELED = 2;
    private static final String CAPTCHA_COMPLETE = "_captcha_complete";
    private String mReqId;

    public CaptchaActivity()
    {
    }

    private void cancelCaptcha()
    {
        Intent intent = new Intent();
        intent.putExtra("rid", mReqId);
        setResult(2, intent);
        finish();
    }

    public static Intent getIntent(Context context, String s, String s1)
    {
        context = new Intent(context, co/vine/android/CaptchaActivity);
        context.putExtra("captcha_url", s);
        context.putExtra("rid", s1);
        return context;
    }

    public void onBackPressed()
    {
        cancelCaptcha();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f0300a9, false);
        Object obj = getIntent().getExtras();
        bundle = (WebView)findViewById(0x7f0a00e1);
        mReqId = ((Bundle) (obj)).getString("rid");
        obj = ((Bundle) (obj)).getString("captcha_url");
        bundle.getSettings().setUserAgentString(HttpOperation.USER_AGENT_STRING);
        bundle.loadUrl(((String) (obj)));
        bundle.setWebViewClient(new WebViewClient() {

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
                        webview.putExtra("rid", mReqId);
                        setResult(-1, webview);
                        (new AsyncTask() {

                            final _cls1 this$1;

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
                this$1 = _cls1.this;
                super();
            }
                        }).execute(new Void[0]);
                        finish();
                    }
                    flag = true;
                }
                return flag;
            }

            
            {
                this$0 = CaptchaActivity.this;
                super();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            cancelCaptcha();
            return true;
        } else
        {
            return false;
        }
    }

}
