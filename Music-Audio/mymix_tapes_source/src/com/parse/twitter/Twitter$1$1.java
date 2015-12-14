// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.twitter;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.parse.internal.AsyncCallback;
import com.parse.oauth.OAuth1FlowDialog;
import com.parse.oauth.OAuth1FlowException;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.OAuthProvider;
import com.parse.signpost.http.HttpParameters;

// Referenced classes of package com.parse.twitter:
//            Twitter

class this._cls1
    implements com.parse.oauth.alog.FlowResultHandler
{

    final ption this$1;

    public void onCancel()
    {
        callback.onCancel();
    }

    public void onComplete(final String verifier)
    {
        CookieSyncManager.getInstance().sync();
        verifier = Uri.parse(verifier).getQueryParameter("oauth_verifier");
        if (verifier == null)
        {
            callback.onCancel();
            return;
        } else
        {
            (new AsyncTask() {

                private Throwable error;
                final Twitter._cls1._cls1 this$2;
                final String val$verifier;

                protected transient HttpParameters doInBackground(Void avoid[])
                {
                    try
                    {
                        provider.retrieveAccessToken(consumer, verifier);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        error = avoid;
                    }
                    return provider.getResponseParameters();
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(HttpParameters httpparameters)
                {
                    super.onPostExecute(httpparameters);
                    if (error == null)
                    {
                        break MISSING_BLOCK_LABEL_45;
                    }
                    callback.onFailure(error);
                    progress.dismiss();
                    return;
                    setAuthToken(consumer.getToken());
                    setAuthTokenSecret(consumer.getTokenSecret());
                    setScreenName(httpparameters.getFirst("screen_name"));
                    setUserId(httpparameters.getFirst("user_id"));
                    callback.onSuccess(this$0);
                    progress.dismiss();
                    return;
                    httpparameters;
                    callback.onFailure(httpparameters);
                    progress.dismiss();
                    return;
                    httpparameters;
                    progress.dismiss();
                    throw httpparameters;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((HttpParameters)obj);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress.show();
                }

            
            {
                this$2 = Twitter._cls1._cls1.this;
                verifier = s;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void onError(int i, String s, String s1)
    {
        callback.onFailure(new OAuth1FlowException(i, s, s1));
    }

    l.progress()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/twitter/Twitter$1

/* anonymous class */
    class Twitter._cls1 extends AsyncTask
    {

        private Throwable error;
        final Twitter this$0;
        final AsyncCallback val$callback;
        final OAuthConsumer val$consumer;
        final Context val$context;
        final ProgressDialog val$progress;
        final OAuthProvider val$provider;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                avoid = provider.retrieveRequestToken(consumer, "twitter-oauth://complete");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                error = avoid;
                return null;
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (error == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            callback.onFailure(error);
            progress.dismiss();
            return;
            CookieSyncManager.createInstance(context);
            (new OAuth1FlowDialog(context, s, "twitter-oauth://complete", "api.twitter", new Twitter._cls1._cls1())).show();
            progress.dismiss();
            return;
            s;
            progress.dismiss();
            throw s;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress.show();
        }

            
            {
                this$0 = final_twitter;
                callback = asynccallback;
                context = context1;
                provider = oauthprovider;
                consumer = oauthconsumer;
                progress = ProgressDialog.this;
                super();
            }
    }

}
