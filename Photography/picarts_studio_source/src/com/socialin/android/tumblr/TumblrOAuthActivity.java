// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.socialin.android.d;
import java.io.IOException;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.signature.HmacSha1MessageSigner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.tumblr:
//            b, a

public class TumblrOAuthActivity extends AppCompatActivity
{

    private static final String b = com/socialin/android/tumblr/TumblrOAuthActivity.getSimpleName();
    private String a;
    private SharedPreferences c;
    private CommonsHttpOAuthConsumer d;
    private CommonsHttpOAuthProvider e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;

    public TumblrOAuthActivity()
    {
        a = "auth";
        c = null;
        j = null;
        k = "";
        l = "";
        m = "";
        n = 0;
        o = 0;
    }

    static String a()
    {
        return b;
    }

    static void a(TumblrOAuthActivity tumblroauthactivity)
    {
        Object obj;
        HttpGet httpget;
        obj = new DefaultHttpClient();
        httpget = new HttpGet("http://api.tumblr.com/v2/user/info");
        if (TextUtils.isEmpty(tumblroauthactivity.d.getConsumerKey()) || TextUtils.isEmpty(tumblroauthactivity.d.getConsumerSecret()))
        {
            String s = tumblroauthactivity.c.getString("tumblr_oauth_token", null);
            String s1 = tumblroauthactivity.c.getString("tumblr_oauth_token_secret", null);
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                tumblroauthactivity.d.setTokenWithSecret(s, s1);
            }
        }
        tumblroauthactivity.d.sign(httpget);
        obj = EntityUtils.toString(((DefaultHttpClient) (obj)).execute(httpget).getEntity());
        com.socialin.android.d.a(b, new Object[] {
            "user info................... ", obj
        });
        if (!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        tumblroauthactivity.finish();
        tumblroauthactivity = "";
_L3:
        com.socialin.android.d.c(new Object[] {
            b, tumblroauthactivity
        });
        return;
_L2:
        obj = new JSONObject(((String) (obj)));
        if (((JSONObject) (obj)).getJSONObject("meta").getInt("status") == 200)
        {
            obj = ((JSONObject) (obj)).getJSONObject("response").getJSONObject("user").getString("name");
            android.content.SharedPreferences.Editor editor = tumblroauthactivity.c.edit();
            editor.putString("tumblr_user_name", ((String) (obj)));
            editor.commit();
            tumblroauthactivity.b();
        }
        tumblroauthactivity = "";
          goto _L3
        JSONException jsonexception;
        jsonexception;
        com.socialin.android.d.a(b, jsonexception);
        tumblroauthactivity.finish();
        tumblroauthactivity = "";
          goto _L3
        tumblroauthactivity;
_L4:
        com.socialin.android.d.a(b, tumblroauthactivity);
        tumblroauthactivity = (new StringBuilder()).append("").append(tumblroauthactivity.toString()).toString();
          goto _L3
        tumblroauthactivity;
        com.socialin.android.d.a(b, tumblroauthactivity);
        tumblroauthactivity = (new StringBuilder()).append("").append(tumblroauthactivity.toString()).toString();
          goto _L3
        tumblroauthactivity;
          goto _L4
        tumblroauthactivity;
          goto _L4
    }

    static void a(TumblrOAuthActivity tumblroauthactivity, String s)
    {
        tumblroauthactivity.runOnUiThread(tumblroauthactivity. new Runnable(s) {

            private String a;
            private TumblrOAuthActivity b;

            public final void run()
            {
                WebView webview = (WebView)b.findViewById(0x7f100a6f);
                webview.setWebViewClient(new a(b, "android-tumblr://success"));
                webview.getSettings().setJavaScriptEnabled(true);
                webview.clearHistory();
                webview.clearFormData();
                webview.getSettings().setCacheMode(2);
                webview.loadUrl(a);
            }

            
            {
                b = TumblrOAuthActivity.this;
                a = s;
                super();
            }
        });
    }

    static CommonsHttpOAuthProvider b(TumblrOAuthActivity tumblroauthactivity)
    {
        return tumblroauthactivity.e;
    }

    private void b()
    {
        if ("auth".equals(a))
        {
            setResult(-1);
        } else
        if ("post".equals(a))
        {
            getSupportActionBar().show();
            (new b(this)).a(j, k, m, l, n, o);
            return;
        }
        finish();
    }

    static CommonsHttpOAuthConsumer c(TumblrOAuthActivity tumblroauthactivity)
    {
        return tumblroauthactivity.d;
    }

    public final boolean a(Uri uri)
    {
        if (uri == null) goto _L2; else goto _L1
_L1:
        h = uri.getQueryParameter("oauth_token");
        uri = uri.getQueryParameter("oauth_verifier");
        com.socialin.android.d.a(b, (new StringBuilder("Token:")).append(h).toString());
        com.socialin.android.d.a(b, (new StringBuilder("Verifier:")).append(uri).toString());
        e.retrieveAccessToken(d, uri);
        com.socialin.android.d.b(b, new Object[] {
            (new StringBuilder("accessToken       retrieveAccessToken    : ")).append(d.getToken()).toString()
        });
        com.socialin.android.d.b(b, new Object[] {
            (new StringBuilder("accessTokenSecret retrieveAccessToken    : ")).append(d.getTokenSecret()).toString()
        });
        if (TextUtils.isEmpty(h) && !TextUtils.isEmpty(i))
        {
            d.setTokenWithSecret(h, i);
        }
        uri = d.getToken();
        String s = d.getTokenSecret();
        h = uri;
        i = s;
        android.content.SharedPreferences.Editor editor = c.edit();
        editor.putString("tumblr_oauth_token", uri);
        editor.putString("tumblr_oauth_token_secret", s);
        editor.commit();
        return true;
        uri;
_L6:
        com.socialin.android.d.a(b, uri);
        return false;
        uri;
_L4:
        com.socialin.android.d.a(b, uri);
        return false;
_L2:
        return false;
        uri;
        if (true) goto _L4; else goto _L3
_L3:
        uri;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030246);
        f = getString(0x7f080973);
        g = getString(0x7f080974);
        c = getSharedPreferences("TumblrPrefs", 0);
        k = (new StringBuilder("Taken via <a target='_blank' href='https://market.android.com/details?id=")).append(getPackageName()).append("&feature=top-free'>  ").append(getString(0x7f0808ad)).append(".</a>").toString();
        d = new CommonsHttpOAuthConsumer(f, g);
        e = new CommonsHttpOAuthProvider("http://www.tumblr.com/oauth/request_token", "http://www.tumblr.com/oauth/access_token", "http://www.tumblr.com/oauth/authorize");
        d.setMessageSigner(new HmacSha1MessageSigner());
        bundle = getIntent();
        if (bundle.hasExtra("method"))
        {
            a = bundle.getStringExtra("method");
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("onCreate() - method: ")).append(a).toString()
            });
        }
        m = bundle.getStringExtra("tags");
        l = bundle.getStringExtra("link");
        n = bundle.getIntExtra("imgWidth", 0);
        o = bundle.getIntExtra("imgHeight", 0);
        if (bundle.hasExtra("tumblr_img_url"))
        {
            j = bundle.getStringExtra("tumblr_img_url");
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("onCreate() - path: ")).append(j).toString()
            });
        } else
        if (!"auth".equals(a))
        {
            throw new IllegalStateException();
        }
        h = c.getString("tumblr_oauth_token", null);
        i = c.getString("tumblr_oauth_token_secret", null);
        com.socialin.android.d.b(b, new Object[] {
            (new StringBuilder("this.token       : ")).append(h).toString()
        });
        com.socialin.android.d.b(b, new Object[] {
            (new StringBuilder("this.tokenSecret : ")).append(i).toString()
        });
        if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(i) && !TextUtils.isEmpty(c.getString("tumblr_user_name", null)))
        {
            b();
            return;
        } else
        {
            getSupportActionBar().hide();
            (new Thread(new Runnable() {

                private TumblrOAuthActivity a;

                public final void run()
                {
                    TumblrOAuthActivity.b(a).setOAuth10a(true);
                    String s = TumblrOAuthActivity.b(a).retrieveRequestToken(TumblrOAuthActivity.c(a), "android-tumblr://success");
                    com.socialin.android.d.a(TumblrOAuthActivity.a(), (new StringBuilder("Auth url:")).append(s).toString());
                    TumblrOAuthActivity.a(a, s);
                    return;
                    Object obj;
                    obj;
_L4:
                    com.socialin.android.d.b(TumblrOAuthActivity.a(), "openLogin", ((Throwable) (obj)));
                    return;
                    obj;
_L2:
                    com.socialin.android.d.a(TumblrOAuthActivity.a(), ((Throwable) (obj)));
                    return;
                    obj;
                    if (true) goto _L2; else goto _L1
_L1:
                    obj;
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = TumblrOAuthActivity.this;
                super();
            }
            })).start();
            return;
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            setResult(0);
            finish();
        }
        return super.onKeyDown(i1, keyevent);
    }


    // Unreferenced inner class com/socialin/android/tumblr/TumblrOAuthActivity$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final TumblrOAuthActivity a;
        private Uri b;

        public final void run()
        {
            if (!a.a(b))
            {
                a.setResult(0);
                a.finish();
                return;
            } else
            {
                a.runOnUiThread(new Runnable(this) {

                    private _cls1 a;

                    public final void run()
                    {
    final class _cls1
        implements Runnable
    {
                        a.a.findViewById(0x7f100a6f).setVisibility(4);
                        a.a.findViewById(0x7f100a6e).setVisibility(0);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                TumblrOAuthActivity.a(a);
                return;
            }
        }

            
            {
                a = TumblrOAuthActivity.this;
                b = uri;
                super();
            }
    }

}
