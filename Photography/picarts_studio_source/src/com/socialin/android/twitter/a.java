// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.text.TextUtils;
import com.socialin.android.d;
import com.socialin.android.util.an;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterOAuthActivity, TwitterSessionManager

final class a extends an
{

    private TwitterOAuthActivity a;

    private a(TwitterOAuthActivity twitteroauthactivity)
    {
        a = twitteroauthactivity;
        super();
    }

    a(TwitterOAuthActivity twitteroauthactivity, byte byte0)
    {
        this(twitteroauthactivity);
    }

    protected final Object doInBackground(Object aobj[])
    {
        return TwitterOAuthActivity.a(a, "Twitter");
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        TwitterOAuthActivity.b(a, (new StringBuilder("http://picsart.com/i?twitter_site=@")).append(a.getString(0x7f080978)).append("&og_image=").append(((String) (obj))).append("&og_title=Photo").toString());
        if (TwitterOAuthActivity.g(a) != null || TwitterSessionManager.getTwitterInstance(a) == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        TwitterOAuthActivity.a(a, TwitterSessionManager.getTwitterInstance(a).showUser(TwitterSessionManager.getTwitterInstance(a).getId()));
_L3:
        if (TwitterOAuthActivity.g(a) != null)
        {
            TwitterOAuthActivity.a(a, (new StringBuilder("&twitter_creator=@")).append(TwitterOAuthActivity.g(a).getScreenName()).append("&twitter_creator_id=").append(TwitterOAuthActivity.g(a).getId()).toString());
        }
_L2:
        return;
        obj;
_L4:
        d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), "initUser", ((Throwable) (obj)));
          goto _L3
        obj;
        d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
          goto _L3
        obj;
          goto _L4
    }
}
