// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.support.v7.cu;
import com.parse.internal.AsyncCallback;
import com.parse.twitter.Twitter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider, ParseException

class TwitterAuthenticationProvider extends ParseAuthenticationProvider
{

    private static final String AUTH_TOKEN_KEY = "auth_token";
    private static final String AUTH_TOKEN_SECRET_KEY = "auth_token_secret";
    public static final String AUTH_TYPE = "twitter";
    private static final String CONSUMER_KEY_KEY = "consumer_key";
    private static final String CONSUMER_SECRET_KEY = "consumer_secret";
    private static final String ID_KEY = "id";
    private static final String SCREEN_NAME_KEY = "screen_name";
    private WeakReference baseContext;
    private ParseAuthenticationProvider.ParseAuthenticationCallback currentOperationCallback;
    private final Twitter twitter;

    public TwitterAuthenticationProvider(Twitter twitter1)
    {
        twitter = twitter1;
    }

    private void authenticate(final ParseAuthenticationProvider.ParseAuthenticationCallback callback)
    {
        if (currentOperationCallback != null)
        {
            cancel();
        }
        currentOperationCallback = callback;
        Context context;
        if (baseContext == null)
        {
            context = null;
        } else
        {
            context = (Context)baseContext.get();
        }
        if (context == null)
        {
            throw new IllegalStateException("Context must be non-null for Twitter authentication to proceed.");
        } else
        {
            twitter.authorize(context, new AsyncCallback() {

                final TwitterAuthenticationProvider this$0;
                final ParseAuthenticationProvider.ParseAuthenticationCallback val$callback;

                public void onCancel()
                {
                    handleCancel(callback);
                }

                public void onFailure(Throwable throwable)
                {
                    if (currentOperationCallback != callback)
                    {
                        return;
                    }
                    callback.onError(throwable);
                    currentOperationCallback = null;
                    return;
                    throwable;
                    currentOperationCallback = null;
                    throw throwable;
                }

                public void onSuccess(Object obj)
                {
                    if (currentOperationCallback != callback)
                    {
                        return;
                    }
                    obj = getAuthData(twitter.getUserId(), twitter.getScreenName(), twitter.getAuthToken(), twitter.getAuthTokenSecret());
                    callback.onSuccess(((Map) (obj)));
                    currentOperationCallback = null;
                    return;
                    obj;
                    currentOperationCallback = null;
                    throw obj;
                }

            
            {
                this$0 = TwitterAuthenticationProvider.this;
                callback = parseauthenticationcallback;
                super();
            }
            });
            return;
        }
    }

    private void handleCancel(ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        if (currentOperationCallback != parseauthenticationcallback || parseauthenticationcallback == null)
        {
            return;
        }
        parseauthenticationcallback.onCancel();
        currentOperationCallback = null;
        return;
        parseauthenticationcallback;
        currentOperationCallback = null;
        throw parseauthenticationcallback;
    }

    public cu authenticateAsync()
    {
        final android.support.v7.cu.a tcs = cu.a();
        authenticate(new ParseAuthenticationProvider.ParseAuthenticationCallback() {

            final TwitterAuthenticationProvider this$0;
            final android.support.v7.cu.a val$tcs;

            public void onCancel()
            {
                tcs.c();
            }

            public void onError(Throwable throwable)
            {
                tcs.b(new ParseException(throwable));
            }

            public void onSuccess(Map map)
            {
                tcs.b(map);
            }

            
            {
                this$0 = TwitterAuthenticationProvider.this;
                tcs = a;
                super();
            }
        });
        return tcs.a();
    }

    public void cancel()
    {
        handleCancel(currentOperationCallback);
    }

    public void deauthenticate()
    {
        twitter.setAuthToken(null);
        twitter.setAuthTokenSecret(null);
        twitter.setScreenName(null);
        twitter.setUserId(null);
    }

    public Map getAuthData(String s, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("auth_token", s2);
        hashmap.put("auth_token_secret", s3);
        hashmap.put("id", s);
        hashmap.put("screen_name", s1);
        hashmap.put("consumer_key", twitter.getConsumerKey());
        hashmap.put("consumer_secret", twitter.getConsumerSecret());
        return hashmap;
    }

    public String getAuthType()
    {
        return "twitter";
    }

    public Twitter getTwitter()
    {
        return twitter;
    }

    public boolean restoreAuthentication(Map map)
    {
        if (map == null)
        {
            twitter.setAuthToken(null);
            twitter.setAuthTokenSecret(null);
            twitter.setScreenName(null);
            twitter.setUserId(null);
            return true;
        }
        try
        {
            twitter.setAuthToken((String)map.get("auth_token"));
            twitter.setAuthTokenSecret((String)map.get("auth_token_secret"));
            twitter.setUserId((String)map.get("id"));
            twitter.setScreenName((String)map.get("screen_name"));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return true;
    }

    public TwitterAuthenticationProvider setContext(Context context)
    {
        baseContext = new WeakReference(context);
        return this;
    }




/*
    static ParseAuthenticationProvider.ParseAuthenticationCallback access$102(TwitterAuthenticationProvider twitterauthenticationprovider, ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        twitterauthenticationprovider.currentOperationCallback = parseauthenticationcallback;
        return parseauthenticationcallback;
    }

*/

}
