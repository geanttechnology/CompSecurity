// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import com.parse.internal.AsyncCallback;
import com.parse.twitter.Twitter;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

class TwitterAuthenticationProvider
    implements ParseAuthenticationProvider
{

    private static final String AUTH_TOKEN_KEY = "auth_token";
    private static final String AUTH_TOKEN_SECRET_KEY = "auth_token_secret";
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

    public void authenticate(final ParseAuthenticationProvider.ParseAuthenticationCallback callback)
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
                    callback.onSuccess(((JSONObject) (obj)));
                    currentOperationCallback = null;
                    return;
                    obj;
                    callback.onError(((Throwable) (obj)));
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

    public JSONObject getAuthData(String s, String s1, String s2, String s3)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("auth_token", s2);
        jsonobject.put("auth_token_secret", s3);
        jsonobject.put("id", s);
        jsonobject.put("screen_name", s1);
        jsonobject.put("consumer_key", twitter.getConsumerKey());
        jsonobject.put("consumer_secret", twitter.getConsumerSecret());
        return jsonobject;
    }

    public String getAuthType()
    {
        return "twitter";
    }

    public Twitter getTwitter()
    {
        return twitter;
    }

    public boolean restoreAuthentication(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            twitter.setAuthToken(null);
            twitter.setAuthTokenSecret(null);
            twitter.setScreenName(null);
            twitter.setUserId(null);
            return true;
        }
        try
        {
            twitter.setAuthToken(jsonobject.getString("auth_token"));
            twitter.setAuthTokenSecret(jsonobject.getString("auth_token_secret"));
            twitter.setUserId(jsonobject.getString("id"));
            twitter.setScreenName(jsonobject.getString("screen_name"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return false;
        }
        return true;
    }

    public void setContext(Context context)
    {
        baseContext = new WeakReference(context);
    }




/*
    static ParseAuthenticationProvider.ParseAuthenticationCallback access$102(TwitterAuthenticationProvider twitterauthenticationprovider, ParseAuthenticationProvider.ParseAuthenticationCallback parseauthenticationcallback)
    {
        twitterauthenticationprovider.currentOperationCallback = parseauthenticationcallback;
        return parseauthenticationcallback;
    }

*/

}
