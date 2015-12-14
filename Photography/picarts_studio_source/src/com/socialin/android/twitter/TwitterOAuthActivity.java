// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.AddConnectionController;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.TwitterConnection;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ab;
import com.socialin.android.util.an;
import com.socialin.android.util.b;
import com.socialin.android.util.n;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import myobfuscated.cd.a;
import myobfuscated.f.m;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.RequestToken;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterSessionManager, TwitterWebAuthentication, b, c, 
//            a

public class TwitterOAuthActivity extends AppCompatActivity
{

    private static final String d = (new StringBuilder()).append(com/socialin/android/twitter/TwitterOAuthActivity.getSimpleName()).append(" - ").toString();
    String a;
    String b;
    boolean c;
    private RequestToken e;
    private String f;
    private String g;
    private String h;
    private String i;
    private AddConnectionController j;
    private g k;
    private SharedPreferences l;
    private Bitmap m;
    private ImageView n;
    private EditText o;
    private User p;
    private long q;

    public TwitterOAuthActivity()
    {
        e = null;
        f = null;
        g = null;
        i = "createTweetWithPic";
        j = new AddConnectionController();
        k = null;
        l = null;
        c = false;
        q = -1L;
    }

    private String a(int i1)
    {
        String s2 = "";
        String s1 = s2;
        if (o != null)
        {
            s1 = s2;
            if (o.getVisibility() == 0)
            {
                String s3 = o.getText().toString();
                s1 = s2;
                if (!"".equals(s3))
                {
                    s1 = (new StringBuilder()).append(s3).append("\n").toString();
                }
            }
        }
        return TwitterSessionManager.trimTweetMessage(s1, i1);
    }

    static String a(TwitterOAuthActivity twitteroauthactivity, Object obj)
    {
        obj = (new StringBuilder()).append(twitteroauthactivity.h).append(obj).toString();
        twitteroauthactivity.h = ((String) (obj));
        return ((String) (obj));
    }

    static String a(TwitterOAuthActivity twitteroauthactivity, String s1)
    {
        return twitteroauthactivity.a(s1, false);
    }

    private String a(String s1, boolean flag)
    {
        String as[] = new String[2];
        String s2;
        Object obj;
        obj = "http://picsin.com/";
        s2 = ((String) (obj));
        if (SocialinV3.getInstance().getAppProps() == null) goto _L2; else goto _L1
_L1:
        String s4 = SocialinV3.getInstance().getAppProps().getDownlaodUrl();
        s2 = ((String) (obj));
        obj = s4;
        if (TextUtils.isEmpty(SocialinV3.getInstance().getAppProps().getUploadAnonymousUrl())) goto _L4; else goto _L3
_L3:
        String s3 = SocialinV3.getInstance().getAppProps().getUploadAnonymousUrl();
        s2 = s3;
        obj = s4;
        if (!TextUtils.isEmpty(s4)) goto _L4; else goto _L5
_L5:
        s2 = s3;
          goto _L2
_L4:
        s3 = s2;
        if (!s2.contains("http://"))
        {
            s3 = (new StringBuilder("http://")).append(s2).toString();
        }
        s2 = ((String) (obj));
        if (!((String) (obj)).contains("http://"))
        {
            s2 = (new StringBuilder("http://")).append(((String) (obj))).toString();
        }
        obj = new StringBuilder();
        if (!s3.endsWith("/"))
        {
            s3 = (new StringBuilder()).append(s3).append("/").toString();
        }
        obj = ((StringBuilder) (obj)).append(s3).append("ups").toString();
        as[0] = s2;
        as[1] = ((String) (obj));
        s2 = as[0];
        obj = as[1];
        s3 = (new StringBuilder("=1&appName=")).append(s1).toString();
        obj = s.a(new FileInputStream(f), (new StringBuilder()).append(((String) (obj))).append("/upload.php").toString(), s3, ".jpg");
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("getUploadedImageUrl : Upload PicsArt Response : ")).append(((String) (obj))).toString()
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        obj = new JSONObject(((String) (obj)));
        if ("ok".equals(((JSONObject) (obj)).getString("status")))
        {
            return (new StringBuilder()).append(s2).append("/ups/data/").append(s1).append("/").append(((JSONObject) (obj)).getString("imageUrl")).toString();
        }
        break MISSING_BLOCK_LABEL_420;
        try
        {
            com.socialin.android.d.b(d.a, new Object[] {
                (new StringBuilder("Problem with uploading image on server : folder = ")).append(s1).toString()
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.socialin.android.d.a(d, s1);
        }
        return null;
_L2:
        obj = s2;
        if (true) goto _L4; else goto _L6
_L6:
    }

    static User a(TwitterOAuthActivity twitteroauthactivity, User user)
    {
        twitteroauthactivity.p = user;
        return user;
    }

    static void a(TwitterOAuthActivity twitteroauthactivity)
    {
        twitteroauthactivity.e = TwitterSessionManager.getTwitterInstance(twitteroauthactivity).getOAuthRequestToken("twitterconnect://success");
        String s1 = twitteroauthactivity.e.getAuthenticationURL();
        myobfuscated.f.m.b(twitteroauthactivity, twitteroauthactivity.k);
        Intent intent = new Intent(twitteroauthactivity, com/socialin/android/twitter/TwitterWebAuthentication);
        intent.putExtra("query", s1);
        twitteroauthactivity.startActivityForResult(intent, 456);
_L1:
        return;
        TwitterException twitterexception;
        twitterexception;
        com.socialin.android.d.b(d, new Object[] {
            "doOAuth", twitterexception
        });
        if (twitterexception.getErrorMessage() != null && twitterexception.getErrorMessage().toLowerCase().contains("Timestamp out of bounds.".toLowerCase()))
        {
            Utils.c(twitteroauthactivity, twitteroauthactivity.getString(0x7f080830));
            return;
        }
          goto _L1
    }

    private void a(String s1)
    {
        myobfuscated.f.m.b(this, k);
        if (s1 != null)
        {
            Intent intent = new Intent();
            intent.putExtra("errorMessage", s1);
            setResult(0, intent);
        }
        finish();
    }

    static String b(TwitterOAuthActivity twitteroauthactivity, String s1)
    {
        twitteroauthactivity.h = s1;
        return s1;
    }

    private String b(String s1)
    {
        s1 = (new StringBuilder()).append(s1).append("&package=").append(getPackageName()).append("&api=").append(android.os.Build.VERSION.SDK_INT).toString();
        s1 = s.a((new StringBuilder("http://px4.me/my_api.php?format=json&action=shorturl&url=")).append(URLEncoder.encode(s1, "UTF-8")).toString());
        if (!s1.has("statusCode") || !"200".equals(s1.get("statusCode").toString())) goto _L2; else goto _L1
_L1:
        if (!s1.has("shorturl")) goto _L4; else goto _L3
_L3:
        s1 = s1.getString("shorturl");
_L6:
        String s2;
        if (s1.contains("www"))
        {
            s2 = "http://";
        } else
        {
            s2 = "http://www.";
        }
        s1 = (new StringBuilder()).append(s2).append(s1.substring(s1.indexOf(":") + 3, s1.length())).toString();
        com.socialin.android.d.b(d, new Object[] {
            "getPicsartUploadShortUrl:", s1
        });
        return s1;
        s1;
        com.socialin.android.d.b(d, "getShortenUrl", s1);
_L2:
        return null;
_L4:
        s1 = "";
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void b(TwitterOAuthActivity twitteroauthactivity)
    {
        twitteroauthactivity.a();
    }

    static String c(TwitterOAuthActivity twitteroauthactivity, String s1)
    {
        return twitteroauthactivity.b(s1);
    }

    static void c(TwitterOAuthActivity twitteroauthactivity)
    {
        Object obj;
        Object obj1;
        String s2;
        boolean flag;
        try
        {
            if (TwitterSessionManager.getTwitterInstance(twitteroauthactivity) == null || !TwitterSessionManager.isValidTwitterInstance())
            {
                twitteroauthactivity.a(((String) (null)));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(d, new Object[] {
                obj
            });
            twitteroauthactivity.a(((String) (null)));
            return;
        }
        obj = twitteroauthactivity.a(95);
        flag = TextUtils.isEmpty(twitteroauthactivity.h);
        if (!flag) goto _L2; else goto _L1
_L1:
        obj1 = twitteroauthactivity.f;
        if (w.a(twitteroauthactivity.f, null).c <= 0x100000)
        {
            break MISSING_BLOCK_LABEL_510;
        }
        obj1 = new File(Environment.getExternalStorageDirectory(), "resized_image_tw");
        obj = w.f(twitteroauthactivity.f);
_L3:
        w.a(((File) (obj1)), ((Bitmap) (obj)), android.graphics.Bitmap.CompressFormat.JPEG, twitteroauthactivity);
        s2 = ((File) (obj1)).getAbsolutePath();
        obj = obj1;
        obj1 = s2;
_L5:
        obj1 = (new ImageUploadFactory(TwitterSessionManager.getTwitterInstance(twitteroauthactivity).getConfiguration())).getInstance(MediaProvider.TWITTER).upload(new File(((String) (obj1))), twitteroauthactivity.a(140));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        ((File) (obj)).delete();
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("upload url : ")).append(((String) (obj1))).toString()
        });
        twitteroauthactivity.e();
_L4:
        twitteroauthactivity.f();
        return;
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = null;
          goto _L3
        obj;
        com.socialin.android.d.b(d, new Object[] {
            " doSimpleTweet", obj
        });
        twitteroauthactivity.a(((TwitterException) (obj)).getErrorMessage());
          goto _L4
_L2:
label0:
        {
            if (twitteroauthactivity.h.contains("twitter_creator") || twitteroauthactivity.p != null)
            {
                break label0;
            }
            (new com.socialin.android.twitter.b(twitteroauthactivity, ((String) (obj)))).execute(new Void[0]);
        }
          goto _L4
        if (!twitteroauthactivity.h.contains("twitter_creator") && twitteroauthactivity.p != null)
        {
            twitteroauthactivity.h = (new StringBuilder()).append(twitteroauthactivity.h).append("&twitter_creator=@").append(twitteroauthactivity.p.getScreenName()).append("&twitter_creator_id=").append(twitteroauthactivity.p.getId()).toString();
        }
        String s1 = twitteroauthactivity.b(twitteroauthactivity.h);
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("cardUrl = ")).append(twitteroauthactivity.h).append("\n shortenCardUrl==  ").append(s1).toString()
        });
        if (((String) (obj)).contains("#PicsArt"))
        {
            TwitterSessionManager.getTwitterInstance(twitteroauthactivity).updateStatus((new StringBuilder()).append(s1).append("  ").append(((String) (obj))).toString());
        }
          goto _L4
        obj;
        com.socialin.android.d.b(d, new Object[] {
            " doTweetAsCard", obj
        });
        twitteroauthactivity.a(((TwitterException) (obj)).getErrorMessage());
          goto _L4
        obj = null;
          goto _L5
    }

    static String d()
    {
        return d;
    }

    static void d(TwitterOAuthActivity twitteroauthactivity)
    {
        twitteroauthactivity.k.setOnCancelListener(null);
        myobfuscated.f.m.a(twitteroauthactivity, twitteroauthactivity.k);
        (twitteroauthactivity. new an() {

            private TwitterOAuthActivity a;

            protected final Object doInBackground(Object aobj[])
            {
                TwitterOAuthActivity.c(a);
                return null;
            }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
        }).a(new Void[0]);
    }

    static void d(TwitterOAuthActivity twitteroauthactivity, String s1)
    {
        twitteroauthactivity.a(s1);
    }

    static EditText e(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.o;
    }

    private void e()
    {
        if (Inventory.isAdsEnabled())
        {
            ab.a(this, 5);
        }
    }

    static ImageView f(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.n;
    }

    private void f()
    {
        myobfuscated.f.m.b(this, k);
        Intent intent = new Intent();
        intent.putExtra("twitterMethod", i);
        setResult(-1, intent);
        finish();
    }

    static User g(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.p;
    }

    static String h(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.h;
    }

    static void i(TwitterOAuthActivity twitteroauthactivity)
    {
        twitteroauthactivity.f();
    }

    static RequestToken j(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.e;
    }

    static g k(TwitterOAuthActivity twitteroauthactivity)
    {
        return twitteroauthactivity.k;
    }

    void a()
    {
        if (!"auth".equals(i)) goto _L2; else goto _L1
_L1:
        if (p != null)
        {
            String s3 = p.getOriginalProfileImageURL();
            String s1 = s3;
            if (s3.contains("http: //"))
            {
                s1 = s3.replace("http: //", "http://");
            }
            if (SocialinV3.getInstance().isRegistered())
            {
                Object obj = new TwitterConnection();
                obj.token = a;
                obj.connectionId = String.valueOf(p.getId());
                try
                {
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("name", p.getName());
                    jsonobject.put("id", String.valueOf(p.getId()));
                    jsonobject.put("screen_name", p.getScreenName());
                    jsonobject.put("profile_img_url", s1);
                    jsonobject.put("token", a);
                    jsonobject.put("token_secret", b);
                    ((TwitterConnection) (obj)).setData(jsonobject);
                }
                catch (JSONException jsonexception)
                {
                    com.socialin.android.d.b(d, "handleOAuth", jsonexception);
                }
                j.setRequestParams(((com.socialin.android.apiv3.request.RequestParams) (obj)));
                j.doRequest("add_connection", ((com.socialin.android.apiv3.model.UserConnection) (obj)));
            }
            obj = getIntent();
            ((Intent) (obj)).putExtra("tw_user_name", p.getName());
            ((Intent) (obj)).putExtra("tw_user_id", String.valueOf(p.getId()));
            ((Intent) (obj)).putExtra("tw_user_screen_name", p.getScreenName());
            ((Intent) (obj)).putExtra("tw_user_profile_url", s1);
            ((Intent) (obj)).putExtra("tw_profile_bg_img_url", p.getProfileBackgroundImageURL());
            ((Intent) (obj)).putExtra("tw_profile_banner_img_url", p.getProfileBannerURL());
            ((Intent) (obj)).putExtra("tw_user_token", a);
            ((Intent) (obj)).putExtra("tw_user_token_secret", b);
            setResult(-1, ((Intent) (obj)));
            if (SocialinV3.getInstance().getSettings().isAppboyEnabled())
            {
                com.socialin.android.util.b.a(getApplicationContext()).a("Connected Twitter w/PicsArt", true);
            }
        } else
        {
            setResult(-1);
        }
        myobfuscated.f.m.b(this, k);
        finish();
_L4:
        TwitterSessionManager.sendFriendsAnal(getApplicationContext(), true);
        return;
_L2:
        if (!"createTweet".equals(i))
        {
            break MISSING_BLOCK_LABEL_531;
        }
        TwitterException twitterexception;
        if (TwitterSessionManager.getTwitterInstance(this) == null || !TwitterSessionManager.isValidTwitterInstance())
        {
            a(((String) (null)));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            TwitterSessionManager.getTwitterInstance(this).updateStatus(g);
            e();
            f();
        }
        // Misplaced declaration of an exception variable
        catch (TwitterException twitterexception)
        {
            com.socialin.android.d.b(d, new Object[] {
                "createTweet", twitterexception
            });
            a(twitterexception.getErrorMessage());
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(d, new Object[] {
                "createTweet", exception
            });
        }
        continue; /* Loop/switch isn't completed */
        if ("createTweetWithPic".equals(i))
        {
            myobfuscated.f.m.b(this, k);
            View view = findViewById(0x7f100ace);
            n = (ImageView)findViewById(0x7f100acf);
            o = (EditText)findViewById(0x7f100ad0);
            View view1 = findViewById(0x7f100ad1);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                private TwitterOAuthActivity a;

                public final void onClick(View view2)
                {
                    com.socialin.android.twitter.TwitterOAuthActivity.d(a);
                }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
            });
            if (f == null)
            {
                Utils.b(this, getString(0x7f08024e));
                finish();
            } else
            {
                try
                {
                    m = w.c(f, 120, 120, 90, 90, 0);
                }
                catch (Exception exception2)
                {
                    com.socialin.android.d.b(d, (new StringBuilder("Got unexpected exception: ")).append(exception2.getMessage()).toString(), exception2);
                }
                if (m == null)
                {
                    Utils.b(this, getString(0x7f08024e));
                    finish();
                } else
                {
                    runOnUiThread(new Runnable(view, new a(getResources(), m), view1) {

                        private View a;
                        private a b;
                        private View c;
                        private TwitterOAuthActivity d;

                        public final void run()
                        {
                            a.setVisibility(0);
                            TwitterOAuthActivity.e(d).setText("#PicsArt");
                            TwitterOAuthActivity.f(d).setBackgroundDrawable(b);
                            TwitterOAuthActivity.f(d).setVisibility(0);
                            c.setVisibility(0);
                        }

            
            {
                d = TwitterOAuthActivity.this;
                a = view;
                b = a1;
                c = view1;
                super();
            }
                    });
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!"uploadToTweetPic".equals(i))
        {
            break MISSING_BLOCK_LABEL_965;
        }
        TwitterException twitterexception1;
        if (TwitterSessionManager.getTwitterInstance(this) == null || !TwitterSessionManager.isValidTwitterInstance())
        {
            a(((String) (null)));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            String s2 = getString(0x7f08041e);
            if (q > 0L)
            {
                s2 = (new StringBuilder()).append(getString(0x7f080408)).append(" http://picsart.com/i/").append(q).toString();
            }
            s2 = (new ImageUploadFactory(TwitterSessionManager.getTwitterInstance(this).getConfiguration())).getInstance(MediaProvider.TWITPIC).upload(new File(f), s2);
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("uploadToTwitPic : url : ")).append(s2).toString()
            });
            e();
            f();
        }
        // Misplaced declaration of an exception variable
        catch (TwitterException twitterexception1)
        {
            com.socialin.android.d.b(d, new Object[] {
                " uploadToTwitPic", twitterexception1
            });
            a(twitterexception1.getErrorMessage());
        }
        catch (Exception exception1)
        {
            com.socialin.android.d.b(d, new Object[] {
                exception1
            });
            a(((String) (null)));
        }
        continue; /* Loop/switch isn't completed */
        if (!"updateProfilePic".equals(i))
        {
            continue; /* Loop/switch isn't completed */
        }
        TwitterException twitterexception2;
        if (TwitterSessionManager.getTwitterInstance(this) == null || !TwitterSessionManager.isValidTwitterInstance())
        {
            a(((String) (null)));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            TwitterSessionManager.getTwitterInstance(this).updateProfileImage(new File(f));
            e();
            f();
        }
        // Misplaced declaration of an exception variable
        catch (TwitterException twitterexception2)
        {
            com.socialin.android.d.b(d, new Object[] {
                "updateProfilePicture", twitterexception2
            });
            a(twitterexception2.getErrorMessage());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void b()
    {
        (new ModernAsyncTask() {

            private TwitterOAuthActivity a;

            private transient Void a()
            {
                com.socialin.android.twitter.TwitterOAuthActivity.a(a, TwitterSessionManager.getTwitterInstance(a).showUser(TwitterSessionManager.getTwitterInstance(a).getId()));
_L1:
                return null;
                Object obj;
                obj;
_L2:
                com.socialin.android.d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), "loadUser", ((Throwable) (obj)));
                  goto _L1
                obj;
                com.socialin.android.d.a(com.socialin.android.twitter.TwitterOAuthActivity.d(), ((Throwable) (obj)));
                  goto _L1
                obj;
                  goto _L2
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                com.socialin.android.twitter.TwitterOAuthActivity.b(a);
            }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    SharedPreferences c()
    {
        if (l == null)
        {
            l = getSharedPreferences("TwitterPrefs", 0);
        }
        return l;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        myobfuscated.f.m.b(this, k);
        if (j1 == -1 && i1 == 456)
        {
            com.socialin.android.d.b(d, new Object[] {
                "OK  ..REQUEST_TWITTER_WEB_AUTH"
            });
            if (intent != null && intent.getExtras() != null)
            {
                intent = intent.getExtras();
                try
                {
                    intent = myobfuscated.cy.d.a(intent.getString("url"), "twitterconnect").getString("oauth_verifier");
                    myobfuscated.f.m.a(this, k);
                    (new c(this, intent)).a(new Void[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    com.socialin.android.d.b(d, "onAuthCallback", intent);
                    setResult(0);
                    finish();
                }
            }
        }
        if (j1 == 0)
        {
            setResult(1);
            TwitterSessionManager.resetTwitterInstance();
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = true;
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030260);
        bundle = getSupportActionBar();
        bundle.setIcon(getResources().getDrawable(0x7f02040d));
        bundle.setTitle(0x7f080360);
        bundle = getIntent();
        c = bundle.getBooleanExtra("is_return_user_info", false);
        h = bundle.getStringExtra("twitterCardUrl");
        q = bundle.getLongExtra("item_id", -1L);
        i = bundle.getStringExtra("twitterMethod");
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("onCreate() - twitterMethod: ")).append(i).toString()
        });
        com.socialin.android.d.b(d, new Object[] {
            "onCreate() - picsartItemId: ", Long.valueOf(q)
        });
        boolean flag1;
        if (bundle.hasExtra("path"))
        {
            f = bundle.getStringExtra("path");
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("onCreate() - path: ")).append(f).toString()
            });
        } else
        if ("updateProfilePic".equals(i) || "createTweetWithPic".equals(i) || "uploadToTweetPic".equals(i))
        {
            throw new IllegalStateException();
        }
        if (bundle.hasExtra("tweet"))
        {
            g = bundle.getStringExtra("tweet");
            com.socialin.android.d.b(d, new Object[] {
                (new StringBuilder("onCreate() - tweet: ")).append(g).toString()
            });
        } else
        if ("createTweet".equals(i))
        {
            throw new IllegalStateException();
        }
        k = new g(this);
        k.setTitle("");
        k.setMessage(getString(0x7f08043d));
        k.setCancelable(true);
        k.setIndeterminate(true);
        k.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private TwitterOAuthActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.setResult(1);
                a.finish();
            }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
        });
        myobfuscated.f.m.a(this, k);
        if (SocialinV3.getInstance().getUserTwitterToken() != null && SocialinV3.getInstance().getUserTwitterSecret() != null)
        {
            a = SocialinV3.getInstance().getUserTwitterToken();
            b = SocialinV3.getInstance().getUserTwitterSecret();
        } else
        {
            a = c().getString("user_token", null);
            b = c().getString("user_secret", null);
        }
        if (a != null && b != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("user is authenticated...")).append(flag1).toString()
        });
        if (flag1)
        {
            if (c)
            {
                b();
                flag = false;
            }
            if (flag)
            {
                (new an() {

                    private TwitterOAuthActivity a;

                    protected final Object doInBackground(Object aobj[])
                    {
                        com.socialin.android.twitter.TwitterOAuthActivity.b(a);
                        return null;
                    }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
                }).a(new Void[0]);
            }
            if ("createTweetWithPic".equals(i) && TextUtils.isEmpty(h))
            {
                (new com.socialin.android.twitter.a(this, (byte)0)).a(new Void[0]);
            }
            return;
        } else
        {
            (new an() {

                private TwitterOAuthActivity a;

                protected final Object doInBackground(Object aobj[])
                {
                    com.socialin.android.twitter.TwitterOAuthActivity.a(a);
                    return null;
                }

            
            {
                a = TwitterOAuthActivity.this;
                super();
            }
            }).a(new Void[0]);
            return;
        }
    }

    protected void onDestroy()
    {
        if (m != null)
        {
            if (n != null)
            {
                n.setBackgroundDrawable(null);
            }
            m.recycle();
            m = null;
        }
        super.onDestroy();
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

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (bundle.getSerializable("reqToken") != null)
        {
            e = (RequestToken)bundle.getSerializable("reqToken");
        }
        if (bundle.getSerializable("token") != null)
        {
            a = bundle.getString("token");
        }
        if (bundle.getSerializable("tokenSecret") != null)
        {
            b = bundle.getString("tokenSecret");
        }
        if (bundle.getSerializable("isReturnUserInfo") != null)
        {
            c = bundle.getBoolean("isReturnUserInfo");
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("reqToken", e);
        bundle.putString("token", a);
        bundle.putSerializable("tokenSecret", b);
        bundle.putSerializable("isReturnUserInfo", Boolean.valueOf(c));
    }

}
