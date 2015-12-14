// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import com.socialin.android.d;
import com.socialin.android.util.ModernAsyncTask;
import twitter4j.Twitter;
import twitter4j.TwitterException;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterOAuthActivity, TwitterSessionManager

final class a extends ModernAsyncTask
{

    private TwitterOAuthActivity a;

    private transient Void a()
    {
        TwitterOAuthActivity.a(a, TwitterSessionManager.getTwitterInstance(a).showUser(TwitterSessionManager.getTwitterInstance(a).getId()));
_L1:
        return null;
        Object obj;
        obj;
_L2:
        d.b(com.socialin.android.twitter.TwitterOAuthActivity.d(), "loadUser", ((Throwable) (obj)));
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

    protected final void onPostExecute(Object obj)
    {
        TwitterOAuthActivity.b(a);
    }

    _cls9(TwitterOAuthActivity twitteroauthactivity)
    {
        a = twitteroauthactivity;
        super();
    }
}
