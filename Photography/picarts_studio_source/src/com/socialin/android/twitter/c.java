// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.SharedPreferences;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.d;
import com.socialin.android.util.an;
import myobfuscated.f.m;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterSessionManager, TwitterOAuthActivity

final class c extends an
{

    private String a;
    private TwitterOAuthActivity b;

    public c(TwitterOAuthActivity twitteroauthactivity, String s)
    {
        b = twitteroauthactivity;
        super();
        a = s;
    }

    private transient AccessToken a()
    {
        AccessToken accesstoken;
        try
        {
            accesstoken = TwitterSessionManager.getTwitterInstance(b).getOAuthAccessToken(TwitterOAuthActivity.j(b), a);
        }
        catch (Exception exception)
        {
            d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), "RetrieveAuthDataTask", exception);
            b.setResult(0);
            b.finish();
            return null;
        }
        return accesstoken;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
label0:
        {
            Object obj1 = (AccessToken)obj;
            if (!b.isFinishing())
            {
                m.b(b, TwitterOAuthActivity.k(b));
            }
            obj = b;
            if (obj1 != null)
            {
                obj.a = ((AccessToken) (obj1)).getToken();
                obj.b = ((AccessToken) (obj1)).getTokenSecret();
                TwitterSessionManager.createTwitterWithNewConfiguration(((TwitterOAuthActivity) (obj)).a, ((TwitterOAuthActivity) (obj)).b);
                obj1 = ((TwitterOAuthActivity) (obj)).a;
                String s = ((TwitterOAuthActivity) (obj)).b;
                if (SocialinV3.getInstance().getUserTwitterToken() == null && SocialinV3.getInstance().getUserTwitterSecret() == null)
                {
                    ((TwitterOAuthActivity) (obj)).c().edit().putString("user_token", ((String) (obj1))).commit();
                    ((TwitterOAuthActivity) (obj)).c().edit().putString("user_secret", s).commit();
                }
                if (!((TwitterOAuthActivity) (obj)).c)
                {
                    break label0;
                }
                ((TwitterOAuthActivity) (obj)).b();
            }
            return;
        }
        ((TwitterOAuthActivity) (obj)).a();
    }
}
