// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.internal.AsyncCallback;
import com.parse.twitter.Twitter;

// Referenced classes of package com.parse:
//            TwitterAuthenticationProvider

class eAuthenticationCallback
    implements AsyncCallback
{

    final TwitterAuthenticationProvider this$0;
    final eAuthenticationCallback val$callback;

    public void onCancel()
    {
        TwitterAuthenticationProvider.access$000(TwitterAuthenticationProvider.this, val$callback);
    }

    public void onFailure(Throwable throwable)
    {
        if (TwitterAuthenticationProvider.access$100(TwitterAuthenticationProvider.this) != val$callback)
        {
            return;
        }
        val$callback.onError(throwable);
        TwitterAuthenticationProvider.access$102(TwitterAuthenticationProvider.this, null);
        return;
        throwable;
        TwitterAuthenticationProvider.access$102(TwitterAuthenticationProvider.this, null);
        throw throwable;
    }

    public void onSuccess(Object obj)
    {
        if (TwitterAuthenticationProvider.access$100(TwitterAuthenticationProvider.this) != val$callback)
        {
            return;
        }
        obj = getAuthData(TwitterAuthenticationProvider.access$200(TwitterAuthenticationProvider.this).getUserId(), TwitterAuthenticationProvider.access$200(TwitterAuthenticationProvider.this).getScreenName(), TwitterAuthenticationProvider.access$200(TwitterAuthenticationProvider.this).getAuthToken(), TwitterAuthenticationProvider.access$200(TwitterAuthenticationProvider.this).getAuthTokenSecret());
        val$callback.onSuccess(((java.util.Map) (obj)));
        TwitterAuthenticationProvider.access$102(TwitterAuthenticationProvider.this, null);
        return;
        obj;
        TwitterAuthenticationProvider.access$102(TwitterAuthenticationProvider.this, null);
        throw obj;
    }

    eAuthenticationCallback()
    {
        this$0 = final_twitterauthenticationprovider;
        val$callback = eAuthenticationCallback.this;
        super();
    }
}
