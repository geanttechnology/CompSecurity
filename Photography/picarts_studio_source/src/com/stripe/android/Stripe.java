// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android;

import com.stripe.android.compat.AsyncTask;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.util.TextUtils;
import com.stripe.exception.AuthenticationException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.stripe.android:
//            TokenCallback

public class Stripe
{

    private String defaultPublishableKey;
    public TokenCreator tokenCreator = new TokenCreator() {

        final Stripe this$0;

        public void create(final Card card, final String publishableKey, Executor executor, TokenCallback tokencallback)
        {
            card = tokencallback. new AsyncTask() {

                final _cls1 this$1;
                final TokenCallback val$callback;
                final Card val$card;
                final String val$publishableKey;

                protected transient ResponseWrapper doInBackground(Void avoid[])
                {
                    try
                    {
                        avoid = com.stripe.model.Token.create(hashMapFromCard(card), publishableKey);
                        Object obj = avoid.getCard();
                        obj = androidCardFromStripeCard(((com.stripe.model.Card) (obj)));
                        avoid = androidTokenFromStripeToken(((Card) (obj)), avoid);
                        avoid = new ResponseWrapper(avoid, null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return new ResponseWrapper(null, avoid);
                    }
                    return avoid;
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(ResponseWrapper responsewrapper)
                {
                    tokenTaskPostExecution(responsewrapper, callback);
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((ResponseWrapper)obj);
                }

            
            {
                this$1 = final__pcls1;
                card = card1;
                publishableKey = s;
                callback = TokenCallback.this;
                super();
            }
            };
            executeTokenTask(executor, card);
        }

            
            {
                this$0 = Stripe.this;
                super();
            }
    };
    public TokenRequester tokenRequester = new TokenRequester() {

        final Stripe this$0;

        public void request(final String tokenId, final String publishableKey, Executor executor, TokenCallback tokencallback)
        {
            tokenId = tokencallback. new AsyncTask() {

                final _cls2 this$1;
                final TokenCallback val$callback;
                final String val$publishableKey;
                final String val$tokenId;

                protected transient ResponseWrapper doInBackground(Void avoid[])
                {
                    try
                    {
                        avoid = com.stripe.model.Token.retrieve(tokenId, publishableKey);
                        Object obj = avoid.getCard();
                        obj = androidCardFromStripeCard(((com.stripe.model.Card) (obj)));
                        avoid = androidTokenFromStripeToken(((Card) (obj)), avoid);
                        avoid = new ResponseWrapper(avoid, null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return new ResponseWrapper(null, avoid);
                    }
                    return avoid;
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(ResponseWrapper responsewrapper)
                {
                    tokenTaskPostExecution(responsewrapper, callback);
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((ResponseWrapper)obj);
                }

            
            {
                this$1 = final__pcls2;
                tokenId = s;
                publishableKey = s1;
                callback = TokenCallback.this;
                super();
            }
            };
            executeTokenTask(executor, tokenId);
        }

            
            {
                this$0 = Stripe.this;
                super();
            }
    };

    public Stripe()
    {
    }

    public Stripe(String s)
    {
        setDefaultPublishableKey(s);
    }

    private Card androidCardFromStripeCard(com.stripe.model.Card card)
    {
        return new Card(null, card.getExpMonth(), card.getExpYear(), null, card.getName(), card.getAddressLine1(), card.getAddressLine2(), card.getAddressCity(), card.getAddressState(), card.getAddressZip(), card.getAddressCountry(), card.getLast4(), card.getType(), card.getFingerprint(), card.getCountry());
    }

    private Token androidTokenFromStripeToken(Card card, com.stripe.model.Token token)
    {
        return new Token(token.getId(), token.getLivemode().booleanValue(), new Date(token.getCreated().longValue() * 1000L), token.getUsed(), card);
    }

    private void executeTokenTask(Executor executor, AsyncTask asynctask)
    {
        if (executor != null)
        {
            asynctask.executeOnExecutor(executor, new Void[0]);
            return;
        } else
        {
            asynctask.execute(new Void[0]);
            return;
        }
    }

    private Map hashMapFromCard(Card card)
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap1.put("number", TextUtils.nullIfBlank(card.getNumber()));
        hashmap1.put("cvc", TextUtils.nullIfBlank(card.getCVC()));
        hashmap1.put("exp_month", card.getExpMonth());
        hashmap1.put("exp_year", card.getExpYear());
        hashmap1.put("name", TextUtils.nullIfBlank(card.getName()));
        hashmap1.put("address_line1", TextUtils.nullIfBlank(card.getAddressLine1()));
        hashmap1.put("address_line2", TextUtils.nullIfBlank(card.getAddressLine2()));
        hashmap1.put("address_city", TextUtils.nullIfBlank(card.getAddressCity()));
        hashmap1.put("address_zip", TextUtils.nullIfBlank(card.getAddressZip()));
        hashmap1.put("address_state", TextUtils.nullIfBlank(card.getAddressState()));
        hashmap1.put("address_country", TextUtils.nullIfBlank(card.getAddressCountry()));
        card = (new HashSet(hashmap1.keySet())).iterator();
        do
        {
            if (!card.hasNext())
            {
                break;
            }
            String s = (String)card.next();
            if (hashmap1.get(s) == null)
            {
                hashmap1.remove(s);
            }
        } while (true);
        hashmap.put("card", hashmap1);
        return hashmap;
    }

    private void tokenTaskPostExecution(ResponseWrapper responsewrapper, TokenCallback tokencallback)
    {
        if (responsewrapper.token != null)
        {
            tokencallback.onSuccess(responsewrapper.token);
            return;
        }
        if (responsewrapper.error != null)
        {
            tokencallback.onError(responsewrapper.error);
            return;
        } else
        {
            tokencallback.onError(new RuntimeException("Somehow got neither a token response or an error response"));
            return;
        }
    }

    private void validateKey(String s)
    {
        if (s == null || s.length() == 0)
        {
            throw new AuthenticationException("Invalid Publishable Key: You must use a valid publishable key to create a token.  For more info, see https://stripe.com/docs/stripe.js.");
        }
        if (s.startsWith("sk_"))
        {
            throw new AuthenticationException("Invalid Publishable Key: You are using a secret key to create a token, instead of the publishable one. For more info, see https://stripe.com/docs/stripe.js");
        } else
        {
            return;
        }
    }

    public void createToken(Card card, TokenCallback tokencallback)
    {
        createToken(card, defaultPublishableKey, tokencallback);
    }

    public void createToken(Card card, String s, TokenCallback tokencallback)
    {
        createToken(card, s, null, tokencallback);
    }

    public void createToken(Card card, String s, Executor executor, TokenCallback tokencallback)
    {
        if (card == null)
        {
            try
            {
                throw new RuntimeException("Required Parameter: 'card' is required to create a token");
            }
            // Misplaced declaration of an exception variable
            catch (Card card)
            {
                tokencallback.onError(card);
            }
            return;
        }
        if (tokencallback != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        throw new RuntimeException("Required Parameter: 'callback' is required to use the created token and handle errors");
        validateKey(s);
        tokenCreator.create(card, s, executor, tokencallback);
        return;
    }

    public void createToken(Card card, Executor executor, TokenCallback tokencallback)
    {
        createToken(card, defaultPublishableKey, executor, tokencallback);
    }

    public void requestToken(String s, TokenCallback tokencallback)
    {
        requestToken(s, defaultPublishableKey, tokencallback);
    }

    public void requestToken(String s, String s1, TokenCallback tokencallback)
    {
        requestToken(s, s1, null, tokencallback);
    }

    public void requestToken(String s, String s1, Executor executor, TokenCallback tokencallback)
    {
        if (s == null)
        {
            try
            {
                throw new RuntimeException("Required Parameter: 'tokenId' is required to request a token");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                tokencallback.onError(s);
            }
            return;
        }
        if (tokencallback != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        throw new RuntimeException("Required Parameter: 'callback' is required to use the requested token and handle errors");
        validateKey(s1);
        tokenRequester.request(s, s1, executor, tokencallback);
        return;
    }

    public void requestToken(String s, Executor executor, TokenCallback tokencallback)
    {
        requestToken(s, defaultPublishableKey, executor, tokencallback);
    }

    public void setDefaultPublishableKey(String s)
    {
        validateKey(s);
        defaultPublishableKey = s;
    }






    private class ResponseWrapper
    {

        public final Exception error;
        final Stripe this$0;
        public final Token token;

        private ResponseWrapper(Token token1, Exception exception)
        {
            this$0 = Stripe.this;
            super();
            error = exception;
            token = token1;
        }

    }


    private class TokenCreator
    {

        public abstract void create(Card card, String s, Executor executor, TokenCallback tokencallback);
    }


    private class TokenRequester
    {

        public abstract void request(String s, String s1, Executor executor, TokenCallback tokencallback);
    }

}
