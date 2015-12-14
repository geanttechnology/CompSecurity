// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.oauth2.OAuth2BaseActivity;
import com.socialin.android.util.Utils;
import com.socialin.android.util.an;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import java.io.File;
import myobfuscated.cd.a;
import myobfuscated.f.m;
import org.json.JSONObject;

public class FoursquareOAuthMainActivity extends AppCompatActivity
{

    private static final String b = com/socialin/android/foursquare/FoursquareOAuthMainActivity.getSimpleName();
    private String a;
    private String c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private Bitmap h;
    private EditText i;
    private Button j;
    private SharedPreferences k;
    private g l;
    private String m;
    private String n;
    private String o;
    private long p;

    public FoursquareOAuthMainActivity()
    {
        a = "auth";
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = "";
        n = null;
        o = null;
        p = -1L;
    }

    static String a()
    {
        return b;
    }

    static String a(FoursquareOAuthMainActivity foursquareoauthmainactivity, String s1)
    {
        foursquareoauthmainactivity.m = s1;
        return s1;
    }

    static void a(FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        (foursquareoauthmainactivity. new an() {

            private FoursquareOAuthMainActivity a;

            protected final Object doInBackground(Object aobj[])
            {
                FoursquareOAuthMainActivity.c(a);
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Void)obj;
                myobfuscated.f.m.b(a, com.socialin.android.foursquare.FoursquareOAuthMainActivity.d(a));
                super.onPostExecute(obj);
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        }).execute(new Integer[] {
            Integer.valueOf(0)
        });
    }

    private void a(String s1)
    {
        s1 = new Request((new StringBuilder("https://api.foursquare.com/v2/users/self?oauth_token=")).append(s1).toString());
        com.socialin.asyncnet.b.a().a(s1, new com.socialin.asyncnet.d() {

            private FoursquareOAuthMainActivity a;

            public final volatile void onCancelRequest(Object obj, Request request)
            {
            }

            public final void onFailure(Exception exception, Request request)
            {
                FoursquareOAuthMainActivity.c(a, "Wrong access token.");
            }

            public final transient void onProgressUpdate(Integer ainteger[])
            {
            }

            public final void onSuccess(Object obj, Request request)
            {
                obj = (String)obj;
                com.socialin.android.foursquare.FoursquareOAuthMainActivity.b(a, ((String) (obj)));
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        });
    }

    private void a(String s1, String s2, String s3)
    {
        d.setVisibility(0);
        if (c == null)
        {
            Utils.b(this, 0x7f08024e);
            finish();
        } else
        {
            h = w.c(c, 120, 120, 110, 110, 0);
            if (h == null)
            {
                Utils.a(this, 0x7f08024e);
                b(getString(0x7f08024e));
            } else
            {
                g.setBackgroundDrawable(new a(getResources(), h));
                g.setVisibility(0);
                j.setVisibility(0);
            }
        }
        if (s1 == null || s2 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        e.setText((new StringBuilder()).append(s1).append(" ").append(s2).toString());
        if (!TextUtils.isEmpty(s3))
        {
            com.bumptech.glide.b.b(getApplicationContext()).i().a(s3).a(0.1F).a(com.bumptech.glide.request.e.b(l.e).b(getApplicationContext())).a(f);
        }
        return;
        s1;
        com.socialin.android.d.b(b, new Object[] {
            s1
        });
        return;
    }

    static EditText b(FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        return foursquareoauthmainactivity.i;
    }

    static void b(FoursquareOAuthMainActivity foursquareoauthmainactivity, String s1)
    {
        s1 = new JSONObject(s1);
        if (Integer.parseInt(s1.getJSONObject("meta").getString("code")) == 200)
        {
            Object obj = s1.getJSONObject("response").getJSONObject("user");
            s1 = ((JSONObject) (obj)).getString("firstName");
            String s2 = ((JSONObject) (obj)).getString("lastName");
            obj = ((JSONObject) (obj)).getString("photo");
            com.socialin.android.oauth2.a.a(foursquareoauthmainactivity.k, s1, s2, ((String) (obj)));
            myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
            foursquareoauthmainactivity.a(s1, s2, ((String) (obj)));
            return;
        }
        try
        {
            com.socialin.android.oauth2.a.a(foursquareoauthmainactivity.k);
            foursquareoauthmainactivity.b("Wrong access token.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FoursquareOAuthMainActivity foursquareoauthmainactivity)
        {
            com.socialin.android.d.b(b, new Object[] {
                "getUserInfo: success", foursquareoauthmainactivity
            });
        }
        return;
    }

    private void b(String s1)
    {
        myobfuscated.f.m.b(this, l);
        Intent intent = new Intent();
        intent.putExtra("oauth2FailedErrorDesc", s1);
        setResult(0, intent);
        finish();
    }

    static void c(FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        try
        {
            if (!s.a(foursquareoauthmainactivity))
            {
                foursquareoauthmainactivity.runOnUiThread(foursquareoauthmainactivity. new Runnable() {

                    private FoursquareOAuthMainActivity a;

                    public final void run()
                    {
                        myobfuscated.cy.d.a(a);
                    }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
                });
                return;
            }
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(b, "createNewCheckIn", exception);
            myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
            foursquareoauthmainactivity.b(exception.getMessage());
            return;
        }
        if (foursquareoauthmainactivity.o == null)
        {
            Utils.b(foursquareoauthmainactivity, foursquareoauthmainactivity.getString(0x7f08048d));
            return;
        }
        Request request;
        String s1 = foursquareoauthmainactivity.getString(0x7f08041e);
        if (foursquareoauthmainactivity.p > 0L)
        {
            s1 = (new StringBuilder()).append(foursquareoauthmainactivity.getString(0x7f080408)).append(" http://picsart.com/i/").append(foursquareoauthmainactivity.p).toString();
        }
        if ("".equals(foursquareoauthmainactivity.m))
        {
            foursquareoauthmainactivity.m = (new StringBuilder()).append(foursquareoauthmainactivity.getString(0x7f080284)).append(" ").append(s1).toString();
        }
        request = new Request("https://api.foursquare.com/v2/checkins/add", null, "POST");
        request.c();
        request.b("venueId", foursquareoauthmainactivity.o);
        if (foursquareoauthmainactivity.m.length() <= 140) goto _L2; else goto _L1
_L1:
        Object obj = (new StringBuilder()).append(foursquareoauthmainactivity.m.substring(0, 135)).append("...").toString();
_L4:
        request.b("shout", ((String) (obj)));
        request.b("broadcast", "public");
        request.b("oauth_token", foursquareoauthmainactivity.k.getString("oauth2AccessToken", null));
        obj = new JSONObject((String)request.d());
        if (Integer.parseInt(((JSONObject) (obj)).getJSONObject("meta").getString("code")) != 200)
        {
            break MISSING_BLOCK_LABEL_575;
        }
        obj = ((JSONObject) (obj)).getJSONObject("response").getJSONObject("checkin");
        (new StringBuilder("check-in response : ")).append(((JSONObject) (obj)).toString());
        obj = ((JSONObject) (obj)).getString("id");
        File file = new File(foursquareoauthmainactivity.c);
        Request request1 = new Request("https://api.foursquare.com/v2/photos/add", null, "POST");
        request1.c();
        request1.a("photo", file.getName(), "image/*", file);
        request1.a("checkinId", ((String) (obj)));
        request1.a("broadcast", "facebook,twitter");
        request1.a("public", "1");
        request1.a("oauth_token", foursquareoauthmainactivity.k.getString("oauth2AccessToken", null));
        obj = new JSONObject((String)request1.d());
        if (Integer.parseInt(((JSONObject) (obj)).getJSONObject("meta").getString("code")) == 200)
        {
            myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
            foursquareoauthmainactivity.setResult(-1);
            foursquareoauthmainactivity.finish();
            return;
        }
          goto _L3
_L5:
        com.socialin.android.d.b(b, new Object[] {
            "addPhotoToCheckin", obj
        });
        myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
        foursquareoauthmainactivity.b(((Exception) (obj)).getMessage());
        return;
_L2:
        obj = foursquareoauthmainactivity.m;
          goto _L4
_L3:
        try
        {
            myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
            foursquareoauthmainactivity.b(((JSONObject) (obj)).optJSONObject("meta").optString("errorDetail"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L5
        myobfuscated.f.m.b(foursquareoauthmainactivity, foursquareoauthmainactivity.l);
        foursquareoauthmainactivity.b("Wrong access token.");
        com.socialin.android.oauth2.a.a(foursquareoauthmainactivity.k);
        return;
          goto _L4
    }

    static void c(FoursquareOAuthMainActivity foursquareoauthmainactivity, String s1)
    {
        foursquareoauthmainactivity.b(s1);
    }

    static g d(FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        return foursquareoauthmainactivity.l;
    }

    static String e(FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        return foursquareoauthmainactivity.n;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 != 325) goto _L2; else goto _L1
_L1:
        if (j1 != 326) goto _L4; else goto _L3
_L3:
        com.socialin.android.oauth2.a.a(intent, k);
        if (!"auth".equals(a)) goto _L6; else goto _L5
_L5:
        setResult(-1);
        finish();
_L2:
        if (j1 == -1 && i1 == 1 && intent != null)
        {
            n = intent.getStringExtra("name");
            o = intent.getStringExtra("venue_id");
            intent.getFloatExtra("lat", 0.0F);
            intent.getFloatExtra("lng", 0.0F);
            runOnUiThread(new Runnable() {

                private FoursquareOAuthMainActivity a;

                public final void run()
                {
                    ((TextView)a.findViewById(0x7f10053c)).setText(com.socialin.android.foursquare.FoursquareOAuthMainActivity.e(a));
                    ((ImageView)a.findViewById(0x7f10053d)).setImageResource(0x7f02048f);
                }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
            });
        }
        if (j1 == 0)
        {
            setResult(1);
            finish();
        }
        return;
_L6:
        myobfuscated.f.m.a(this, l);
        String s1 = intent.getStringExtra("oauth2AccessToken");
        if ("checkin".equals(a))
        {
            a(s1);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j1 == 327)
        {
            b(intent.getStringExtra("oauth2FailedErrorDesc"));
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
        }
        setContentView(0x7f0300ff);
        bundle = getIntent();
        if (bundle != null)
        {
            if (bundle.hasExtra("method"))
            {
                a = bundle.getStringExtra("method");
                com.socialin.android.d.b(b, new Object[] {
                    "onCreate() - method: ", a
                });
            }
            if (bundle.hasExtra("path"))
            {
                c = bundle.getStringExtra("path");
                com.socialin.android.d.b(b, new Object[] {
                    "onCreate() - path: ", c
                });
            } else
            if ("checkin".equals(a))
            {
                throw new IllegalStateException();
            }
            p = bundle.getLongExtra("item_id", -1L);
            com.socialin.android.d.b(b, new Object[] {
                "onCreate() - picsartItemId: ", Long.valueOf(p)
            });
        }
        bundle = getSupportActionBar();
        bundle.setIcon(getResources().getDrawable(0x7f02067c));
        bundle.setTitle(getResources().getString(0x7f080624));
        l = new g(this);
        l.setMessage(getString(0x7f08043d));
        l.setCancelable(true);
        l.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private FoursquareOAuthMainActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.setResult(1);
                a.finish();
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        });
        k = getSharedPreferences("FoursquarePrefs", 0);
        d = (RelativeLayout)findViewById(0x7f100530);
        e = (TextView)findViewById(0x7f100533);
        f = (ImageView)findViewById(0x7f100532);
        g = (ImageView)findViewById(0x7f100536);
        j = (Button)findViewById(0x7f10053e);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            private FoursquareOAuthMainActivity a;

            public final void onClick(View view)
            {
                com.socialin.android.foursquare.FoursquareOAuthMainActivity.a(a);
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        });
        i = (EditText)findViewById(0x7f100538);
        i.addTextChangedListener(new TextWatcher() {

            private FoursquareOAuthMainActivity a;

            public final void afterTextChanged(Editable editable)
            {
                com.socialin.android.foursquare.FoursquareOAuthMainActivity.a(a, com.socialin.android.foursquare.FoursquareOAuthMainActivity.b(a).getText().toString());
            }

            public final void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        });
        findViewById(0x7f10053a).setOnClickListener(new android.view.View.OnClickListener() {

            private FoursquareOAuthMainActivity a;

            public final void onClick(View view)
            {
                if (!Utils.a(a))
                {
                    break MISSING_BLOCK_LABEL_55;
                }
                view = new Intent();
                view.setClassName(a.getPackageName(), Class.forName("com.picsart.studio.activity.MapActivity").getName());
                view.putExtra("onlyFoursquare", true);
                a.startActivityForResult(view, 1);
                return;
                view;
                com.socialin.android.d.a(com.socialin.android.foursquare.FoursquareOAuthMainActivity.a(), view);
                return;
            }

            
            {
                a = FoursquareOAuthMainActivity.this;
                super();
            }
        });
        if (com.socialin.android.oauth2.a.b(k))
        {
            if ("auth".equals(a))
            {
                setResult(-1);
                finish();
                return;
            }
            if (k.getString("oauth2userFirstName", null) != null)
            {
                a(k.getString("oauth2userFirstName", null), k.getString("oauth2userLastName", null), k.getString("oauth2userPhoto", null));
                return;
            } else
            {
                a(k.getString("oauth2AccessToken", null));
                return;
            }
        } else
        {
            bundle = new Intent(this, com/socialin/android/oauth2/OAuth2BaseActivity);
            bundle.putExtra("oauth2AuthorizationEndpoint", "https://foursquare.com/oauth2/authorize");
            bundle.putExtra("oauth2AccessTokenEndpoint", "https://foursquare.com/oauth2/access_token");
            bundle.putExtra("oauth2ClientId", "U52Y01XR51AK4IJEQETRY0GAKCMMX2JA1DBVJVL4LQUIJFL0");
            bundle.putExtra("oauth2ClientSecret", "GO05TZUUVKPHRG4LLYC3DXOK1F02IIKS2DOTARHB3BWKC2CP");
            bundle.putExtra("oauth2SocialKey", 1);
            startActivityForResult(bundle, 325);
            return;
        }
    }

}
