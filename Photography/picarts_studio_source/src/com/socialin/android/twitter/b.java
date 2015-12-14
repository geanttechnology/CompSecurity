// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import com.socialin.android.d;
import com.socialin.android.util.ModernAsyncTask;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterSessionManager, TwitterOAuthActivity

final class b extends ModernAsyncTask
{

    private String a;
    private TwitterOAuthActivity b;

    public b(TwitterOAuthActivity twitteroauthactivity, String s)
    {
        b = twitteroauthactivity;
        super();
        a = s;
    }

    private transient Void a()
    {
        TwitterOAuthActivity.a(b, TwitterSessionManager.getTwitterInstance(b).showUser(TwitterSessionManager.getTwitterInstance(b).getId()));
_L1:
        Object obj;
        if (TwitterOAuthActivity.g(b) != null)
        {
            TwitterOAuthActivity.a(b, (new StringBuilder("&twitter_creator=@")).append(TwitterOAuthActivity.g(b).getScreenName()).append("&twitter_creator_id=").append(TwitterOAuthActivity.g(b).getId()).toString());
        }
        String s = TwitterOAuthActivity.c(b, TwitterOAuthActivity.h(b));
        d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), new Object[] {
            (new StringBuilder("createTweetPic::::   cardUrl = ")).append(TwitterOAuthActivity.h(b)).append("\n shortenCardUrl==  ").append(s).toString()
        });
        try
        {
            TwitterSessionManager.getTwitterInstance(b).updateStatus((new StringBuilder()).append(s).append("  ").append(a).toString());
            TwitterOAuthActivity.i(b);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d.a(com.socialin.android.twitter.TwitterOAuthActivity.d(), ((Throwable) (obj)));
            com.socialin.android.twitter.TwitterOAuthActivity.d(b, ((TwitterException) (obj)).getErrorMessage());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString(), ((Throwable) (obj)));
            com.socialin.android.twitter.TwitterOAuthActivity.d(b, null);
            return null;
        }
        return null;
        obj;
_L2:
        d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), new Object[] {
            " requestForUserAndTweet", obj
        });
          goto _L1
        obj;
        d.a(com.socialin.android.twitter.TwitterOAuthActivity.d(), ((Throwable) (obj)));
          goto _L1
        obj;
          goto _L2
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
