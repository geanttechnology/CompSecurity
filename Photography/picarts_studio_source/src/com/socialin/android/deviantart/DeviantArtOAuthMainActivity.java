// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.kevinsawicki.http.HttpRequest;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.adapter.b;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.oauth2.OAuth2BaseActivity;
import com.socialin.android.oauth2.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONObject;

public class DeviantArtOAuthMainActivity extends BaseActivity
{

    private static final String a = com/socialin/android/deviantart/DeviantArtOAuthMainActivity.getSimpleName();
    private String b;
    private String c;
    private SharedPreferences d;
    private g e;
    private ImageView f;
    private LinearLayout g;
    private AutoCompleteTextView h;
    private TextView i;
    private String j;
    private String k;
    private String l;
    private long m;
    private List n;
    private int o;

    public DeviantArtOAuthMainActivity()
    {
        b = null;
        c = "";
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = "";
        k = "";
        l = "";
        m = -1L;
    }

    static int a(DeviantArtOAuthMainActivity deviantartoauthmainactivity, int i1)
    {
        deviantartoauthmainactivity.o = i1;
        return i1;
    }

    static TextView a(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        return deviantartoauthmainactivity.i;
    }

    static String a()
    {
        return a;
    }

    static String a(DeviantArtOAuthMainActivity deviantartoauthmainactivity, String s1)
    {
        deviantartoauthmainactivity.k = s1;
        return s1;
    }

    private void a(String s1)
    {
        myobfuscated.f.m.b(this, e);
        if (s1 != null)
        {
            Intent intent = new Intent();
            intent.putExtra("errorMessage", s1);
            setResult(0, intent);
        }
        finish();
    }

    static String b(DeviantArtOAuthMainActivity deviantartoauthmainactivity, String s1)
    {
        deviantartoauthmainactivity.l = s1;
        return s1;
    }

    private void b()
    {
        int i1 = 0;
        Object obj = SocialinV3.getInstance().getAppProps().getGalleryPromoTags();
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("onCreate() - popularTagsStr: ")).append(((String) (obj))).toString()
        });
        n = new ArrayList();
        String as[] = ((String) (obj)).split(",");
        for (int j1 = as.length; i1 < j1; i1++)
        {
            String s1 = as[i1];
            n.add((new StringBuilder("#")).append(s1).toString());
        }

        as = new b(this, 0x7f03024f, n);
        h.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private DeviantArtOAuthMainActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                adapterview = ((TextView)view).getText().toString();
                view = com.socialin.android.deviantart.DeviantArtOAuthMainActivity.d(a);
                k1 = com.socialin.android.deviantart.DeviantArtOAuthMainActivity.d(a).getText().toString().lastIndexOf(adapterview, DeviantArtOAuthMainActivity.c(a));
                view.setSelection(adapterview.length() + k1 + 1);
            }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
        });
        h.setAdapter(as);
        h.addTextChangedListener(new TextWatcher(as) {

            private b a;
            private DeviantArtOAuthMainActivity b;

            public final void afterTextChanged(Editable editable)
            {
                com.socialin.android.deviantart.DeviantArtOAuthMainActivity.b(b, editable.toString());
            }

            public final void beforeTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
                com.socialin.android.deviantart.DeviantArtOAuthMainActivity.a(b, a.b);
                a.b = com.socialin.android.deviantart.DeviantArtOAuthMainActivity.d(b).getSelectionStart();
            }

            
            {
                b = DeviantArtOAuthMainActivity.this;
                a = b1;
                super();
            }
        });
    }

    static void b(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        (deviantartoauthmainactivity. new Thread() {

            private DeviantArtOAuthMainActivity a;

            public final void run()
            {
                try
                {
                    DeviantArtOAuthMainActivity.e(a);
                    DeviantArtOAuthMainActivity.f(a);
                    return;
                }
                catch (Exception exception)
                {
                    DeviantArtOAuthMainActivity.c(a, "");
                    com.socialin.android.d.a(com.socialin.android.deviantart.DeviantArtOAuthMainActivity.a(), exception);
                    return;
                }
            }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
        }).start();
    }

    static int c(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        return deviantartoauthmainactivity.o;
    }

    static String c(DeviantArtOAuthMainActivity deviantartoauthmainactivity, String s1)
    {
        deviantartoauthmainactivity.j = s1;
        return s1;
    }

    private void c()
    {
        if (!"success".equals(s.a((new StringBuilder("https://www.deviantart.com/api/draft15/placebo?access_token=")).append(d.getString("oauth2AccessToken", null)).toString()).getString("status")))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        if ("auth".equals(c))
        {
            myobfuscated.f.m.b(this, e);
            setResult(-1);
            finish();
            return;
        }
        try
        {
            d();
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.a(a, exception);
        }
        finish();
        return;
        com.socialin.android.oauth2.a.a(d);
        e();
        return;
    }

    static AutoCompleteTextView d(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        return deviantartoauthmainactivity.h;
    }

    private void d()
    {
        Object obj;
        File file = new File(b);
        obj = getString(0x7f08041e);
        if (m > 0L)
        {
            obj = (new StringBuilder()).append(getString(0x7f080408)).append(" http://picsart.com/i/").append(m).toString();
        }
        HttpRequest httprequest = HttpRequest.a("https://www.deviantart.com/api/draft15/stash/submit");
        httprequest.a("file", file.getName(), "image/*", file);
        httprequest.b("access_token", d.getString("oauth2AccessToken", null));
        httprequest.b("title", k);
        httprequest.b("artist_comments", (new StringBuilder()).append(l).append(" ").append(((String) (obj))).toString());
        httprequest.b("folder", "PicsArt");
        if (!httprequest.c())
        {
            break MISSING_BLOCK_LABEL_294;
        }
        obj = new JSONObject(httprequest.e());
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder(" submit to Sta.sh response :::::::::: ")).append(((JSONObject) (obj)).toString()).toString()
        });
        if ("success".equals(((JSONObject) (obj)).getString("status")))
        {
            myobfuscated.f.m.b(this, e);
            setResult(-1);
            finish();
            return;
        }
        try
        {
            a(((JSONObject) (obj)).getString("error_description"));
            return;
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString(), exception);
        }
        a(((String) (null)));
    }

    private void e()
    {
        Intent intent = new Intent(this, com/socialin/android/oauth2/OAuth2BaseActivity);
        intent.putExtra("oauth2AuthorizationEndpoint", "https://www.deviantart.com/oauth2/draft15/authorize");
        intent.putExtra("oauth2AccessTokenEndpoint", "https://www.deviantart.com/oauth2/draft15/token");
        intent.putExtra("oauth2ClientId", "466");
        intent.putExtra("oauth2ClientSecret", "c729c296a51355062c09cbb300f5a827");
        intent.putExtra("oauth2SocialKey", 0);
        startActivityForResult(intent, 325);
    }

    static void e(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        String as[] = deviantartoauthmainactivity.h.getText().toString().split(" ");
        deviantartoauthmainactivity.j = "";
        int i1 = 0;
        while (i1 < as.length) 
        {
            if (as[i1].startsWith("#") && as[i1].length() > 1 && as[i1].charAt(1) != '#')
            {
                if ("".equals(deviantartoauthmainactivity.j))
                {
                    deviantartoauthmainactivity.j = (new StringBuilder()).append(deviantartoauthmainactivity.j).append(as[i1]).toString();
                } else
                {
                    deviantartoauthmainactivity.j = (new StringBuilder()).append(deviantartoauthmainactivity.j).append(",").append(as[i1]).toString();
                }
            }
            i1++;
        }
    }

    static void f(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        if (!s.a(deviantartoauthmainactivity))
        {
            myobfuscated.cy.d.a(deviantartoauthmainactivity);
            return;
        }
        if (com.socialin.android.oauth2.a.b(deviantartoauthmainactivity.d))
        {
            myobfuscated.f.m.a(deviantartoauthmainactivity, deviantartoauthmainactivity.e);
            deviantartoauthmainactivity.c();
            return;
        } else
        {
            deviantartoauthmainactivity.e();
            return;
        }
    }

    static ImageView g(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        return deviantartoauthmainactivity.f;
    }

    static void h(DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        deviantartoauthmainactivity.d();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 != 325) goto _L2; else goto _L1
_L1:
        if (j1 != 326) goto _L4; else goto _L3
_L3:
        com.socialin.android.oauth2.a.a(intent, d);
        if ("auth".equals(c))
        {
            setResult(-1);
            finish();
        } else
        {
            myobfuscated.f.m.a(this, e);
            (new Thread() {

                private DeviantArtOAuthMainActivity a;

                public final void run()
                {
                    try
                    {
                        DeviantArtOAuthMainActivity.h(a);
                        return;
                    }
                    catch (Exception exception)
                    {
                        com.socialin.android.d.a(com.socialin.android.deviantart.DeviantArtOAuthMainActivity.a(), exception);
                    }
                }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
            }).start();
        }
_L2:
        if (j1 == 0 && "auth".equals(c))
        {
            setResult(1);
            finish();
        }
        return;
_L4:
        if (j1 == 327)
        {
            a(intent.getStringExtra("oauth2FailedErrorDesc"));
        } else
        if (j1 == 1)
        {
            setResult(1);
            finish();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle != null)
        {
            if (bundle.hasExtra("method"))
            {
                c = bundle.getStringExtra("method");
                com.socialin.android.d.b(a, new Object[] {
                    "readIntent() - method: ", c
                });
            }
            if (bundle.hasExtra("item_id"))
            {
                m = bundle.getLongExtra("item_id", -1L);
                com.socialin.android.d.b(a, new Object[] {
                    "readIntent() - picsartItemId: ", Long.valueOf(m)
                });
            }
            if (bundle.hasExtra("path"))
            {
                b = bundle.getStringExtra("path");
                com.socialin.android.d.b(a, new Object[] {
                    "readIntent() - path: ", b
                });
            } else
            if (!"auth".equals(c))
            {
                throw new IllegalStateException();
            }
        }
        bundle = getSupportActionBar();
        bundle.setIcon(getResources().getDrawable(0x7f02033e));
        bundle.setTitle(0x7f0802b5);
        e = new g(this);
        e.setMessage(getString(0x7f08043d));
        e.setCancelable(true);
        e.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private DeviantArtOAuthMainActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.setResult(1);
                a.finish();
            }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
        });
        d = getSharedPreferences("DeviantArtPrefs", 0);
        if ("auth".equals(c))
        {
            if (com.socialin.android.oauth2.a.b(d))
            {
                myobfuscated.f.m.a(this, e);
                c();
                return;
            } else
            {
                e();
                return;
            }
        }
        setContentView(0x7f03009d);
        f = (ImageView)findViewById(0x7f100356);
        g = (LinearLayout)findViewById(0x7f10035a);
        h = (AutoCompleteTextView)findViewById(0x7f100358);
        i = (TextView)findViewById(0x7f100359);
        b();
        i.addTextChangedListener(new TextWatcher() {

            private DeviantArtOAuthMainActivity a;

            public final void afterTextChanged(Editable editable)
            {
                editable = com.socialin.android.deviantart.DeviantArtOAuthMainActivity.a(a).getText().toString();
                com.socialin.android.deviantart.DeviantArtOAuthMainActivity.a(a, editable);
            }

            public final void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
        });
        g.setOnClickListener(new android.view.View.OnClickListener() {

            private DeviantArtOAuthMainActivity a;

            public final void onClick(View view)
            {
                com.socialin.android.deviantart.DeviantArtOAuthMainActivity.b(a);
            }

            
            {
                a = DeviantArtOAuthMainActivity.this;
                super();
            }
        });
        if (b == null)
        {
            Utils.b(this, 0x7f08024e);
            finish();
            return;
        }
        bundle = w.a(b, 0);
        if (bundle == null)
        {
            Utils.b(this, 0x7f08024e);
            finish();
            return;
        } else
        {
            int i1 = f.getLayoutParams().height;
            runOnUiThread(new Runnable(Math.min((int)(((float)getResources().getDisplayMetrics().widthPixels / (float)bundle.getWidth()) * (float)bundle.getHeight()), i1), bundle) {

                private int a;
                private Bitmap b;
                private DeviantArtOAuthMainActivity c;

                public final void run()
                {
                    com.socialin.android.deviantart.DeviantArtOAuthMainActivity.g(c).getLayoutParams().height = a;
                    com.socialin.android.deviantart.DeviantArtOAuthMainActivity.g(c).setImageDrawable(new myobfuscated.cd.a(c.getResources(), b));
                    com.socialin.android.deviantart.DeviantArtOAuthMainActivity.g(c).setVisibility(0);
                }

            
            {
                c = DeviantArtOAuthMainActivity.this;
                a = i1;
                b = bitmap;
                super();
            }
            });
            return;
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            setResult(1);
            finish();
        }
        return super.onKeyDown(i1, keyevent);
    }

}
