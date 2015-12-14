// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.http.HttpParameters;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class TwitterUtils
{

    private static final String b;
    private static final String c;
    public String a;
    private OAuthProvider d;
    private OAuthConsumer e;
    private HttpParameters f;

    public TwitterUtils()
    {
    }

    static String a()
    {
        return b;
    }

    static OAuthConsumer a(TwitterUtils twitterutils)
    {
        return twitterutils.e;
    }

    static OAuthConsumer a(TwitterUtils twitterutils, OAuthConsumer oauthconsumer)
    {
        twitterutils.e = oauthconsumer;
        return oauthconsumer;
    }

    static OAuthProvider a(TwitterUtils twitterutils, OAuthProvider oauthprovider)
    {
        twitterutils.d = oauthprovider;
        return oauthprovider;
    }

    static HttpParameters a(TwitterUtils twitterutils, HttpParameters httpparameters)
    {
        twitterutils.f = httpparameters;
        return httpparameters;
    }

    static String b()
    {
        return c;
    }

    static OAuthProvider b(TwitterUtils twitterutils)
    {
        return twitterutils.d;
    }

    static HttpParameters c(TwitterUtils twitterutils)
    {
        return twitterutils.f;
    }

    public j a(Activity activity)
    {
        return (new j(activity) {

            final Activity a;
            final TwitterUtils b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected String a(Void void1)
            {
                try
                {
                    TwitterUtils.a(b, new CommonsHttpOAuthConsumer(TwitterUtils.a(), TwitterUtils.b()));
                    TwitterUtils.a(b, new DefaultOAuthProvider("https://twitter.com/oauth/request_token", "https://twitter.com/oauth/access_token", "https://twitter.com/oauth/authenticate"));
                    void1 = TwitterUtils.b(b).a(TwitterUtils.a(b), "http://www.perfectcorp.com/ybc/twitter/callback", new String[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        void1
                    });
                    return null;
                }
                return void1;
            }

            protected void a(String s)
            {
                if (s != null)
                {
                    com.cyberlink.beautycircle.c.a(a, s, 0, 48162);
                }
                super.a_(s);
            }

            protected void a_(Object obj)
            {
                a((String)obj);
            }

            
            {
                b = TwitterUtils.this;
                a = activity;
                super();
            }
        }).d(null);
    }

    public j a(UserInfo userinfo)
    {
        if (userinfo == null)
        {
            return null;
        } else
        {
            return (new j(userinfo) {

                final UserInfo a;
                final TwitterUtils b;

                protected TwitterUser a(Void void1)
                {
                    void1 = new HttpGet((new StringBuilder()).append("https://api.twitter.com/1.1/users/show.json?user_id=").append(b.a).toString());
                    BasicHttpParams basichttpparams = new BasicHttpParams();
                    HttpProtocolParams.setUseExpectContinue(basichttpparams, false);
                    void1.setParams(basichttpparams);
                    TwitterUtils.a(b).a(void1);
                    void1 = (TwitterUser)Model.a(com/cyberlink/beautycircle/utility/TwitterUtils$TwitterUser, (String)(new DefaultHttpClient()).execute(void1, new BasicResponseHandler()));
                    a.displayName = ((TwitterUser) (void1)).name;
                    a.description = ((TwitterUser) (void1)).description;
                    return void1;
                    Exception exception;
                    exception;
                    void1 = null;
_L2:
                    com.perfectcorp.utility.e.e(new Object[] {
                        exception
                    });
                    return void1;
                    exception;
                    if (true) goto _L2; else goto _L1
_L1:
                }

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

            
            {
                b = TwitterUtils.this;
                a = userinfo;
                super();
            }

                private class TwitterUser extends Model
                {

                    public boolean default_profile_image;
                    public String description;
                    public Long id;
                    public String name;
                    public String profile_image_url;
                    public String screen_name;

                    public String a(String s)
                    {
                        String s2 = profile_image_url;
                        if (s2 != null)
                        {
                            int i = s2.lastIndexOf("_");
                            int k = s2.lastIndexOf(".");
                            int l = s2.lastIndexOf("/");
                            String s1 = (new StringBuilder()).append(s2.substring(0, i)).append(s).toString();
                            s = s1;
                            if (k > l)
                            {
                                s = (new StringBuilder()).append(s1).append(s2.substring(k)).toString();
                            }
                            return s;
                        } else
                        {
                            return null;
                        }
                    }

                    public TwitterUser()
                    {
                    }
                }

            }).d(null);
        }
    }

    public j a(String s)
    {
        return (new j(s) {

            final String a;
            final TwitterUtils b;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected OAuthConsumer a(Void void1)
            {
                try
                {
                    TwitterUtils.b(b).b(TwitterUtils.a(b), a, new String[0]);
                    TwitterUtils.a(b, TwitterUtils.b(b).a());
                    b.a = com.cyberlink.beautycircle.utility.TwitterUtils.c(b).b("user_id");
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        void1
                    });
                }
                return TwitterUtils.a(b);
            }

            
            {
                b = TwitterUtils.this;
                a = s;
                super();
            }
        }).d(null);
    }

    static 
    {
        b = Globals.n().getResources().getString(m.share_twitter_consumer_key);
        c = Globals.n().getResources().getString(m.share_twitter_consumer_secret);
    }
}
