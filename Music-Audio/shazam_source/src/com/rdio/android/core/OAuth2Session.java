// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.a;
import com.google.api.a.a.a.b;
import com.google.api.a.a.a.c;
import com.google.api.a.a.a.f;
import com.google.api.a.a.a.i;
import com.google.api.a.a.a.j;
import com.google.api.a.a.a.m;
import com.google.api.a.a.a.n;
import com.google.api.a.a.a.p;
import com.google.api.a.a.a.q;
import com.google.api.a.a.a.r;
import com.google.api.a.a.a.s;
import com.google.api.a.a.a.t;
import com.google.api.a.d.b.e;
import com.google.api.a.d.d;
import com.google.api.a.d.h;
import com.google.api.a.d.v;
import com.google.api.a.g.b.g;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public abstract class OAuth2Session
{
    private class CredentialListenerForwarder
        implements j
    {

        final OAuth2Session this$0;

        public void onTokenErrorResponse(i k, q q)
        {
            accessToken = null;
            dispatchAsyncResult(q. new Runnable() {

                final CredentialListenerForwarder this$1;
                final q val$tokenErrorResponse;

                public void run()
                {
                    if (credentialsListener != null)
                    {
                        credentialsListener.onError(tokenErrorResponse.error);
                    }
                }

            
            {
                this$1 = final_credentiallistenerforwarder;
                tokenErrorResponse = q.this;
                super();
            }
            });
        }

        public void onTokenResponse(i k, s s1)
        {
            accessToken = s1.accessToken;
            dispatchAsyncResult(k. new Runnable() {

                final CredentialListenerForwarder this$1;
                final i val$credential;

                public void run()
                {
                    if (credentialsListener != null)
                    {
                        credentialsListener.onCredentialRefreshed(credential);
                    }
                }

            
            {
                this$1 = final_credentiallistenerforwarder;
                credential = i.this;
                super();
            }
            });
        }

        private CredentialListenerForwarder()
        {
            this$0 = OAuth2Session.this;
            super();
        }

    }

    private abstract class ErrorReportingStringCallable
        implements Callable
    {

        private String errorMessage;
        private Runnable errorRunnable = new _cls1();
        final OAuth2Session this$0;

        public void dispatchError(String s)
        {
            errorMessage = s;
            dispatchAsyncResult(errorRunnable);
        }


        private ErrorReportingStringCallable()
        {
            this$0 = OAuth2Session.this;
            super();
        }

    }

    public static interface OAuth2ClientCredentialsListener
    {

        public abstract void onCredentialRefreshed(i j);

        public abstract void onError(String s);

        public abstract void onReceivedCredentials(i j);
    }


    public static final String OAUTH2_AUTHORIZE_URL = "/oauth2/authorize?mode=redirect";
    public static final String OAUTH2_BASE_URI = "https://www.rdio.com";
    public static final String OAUTH2_TOKEN_URL = "/oauth2/token";
    private static final String TAG = "OAuth2Session";
    private String accessToken;
    private a authorizationCodeFlow;
    private String clientId;
    private String clientSecret;
    private i credential;
    private OAuth2ClientCredentialsListener credentialsListener;
    private g dataStoreFactory;
    private ExecutorService executorService;
    private String oauth2AuthorizeUrl;
    private String oauth2TokenUrl;

    public OAuth2Session(String s, String s1, String s2, String s3, Long long1)
    {
        executorService = Executors.newSingleThreadExecutor();
        oauth2AuthorizeUrl = "https://www.rdio.com/oauth2/authorize?mode=redirect";
        oauth2TokenUrl = "https://www.rdio.com/oauth2/token";
        clientId = s;
        clientSecret = s1;
        accessToken = s2;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        credential = buildCredential(null, s2, s3, long1);
        return;
        s;
    }

    private i buildCredential(String s, String s1, String s2, Long long1)
    {
        com.google.api.a.a.a.i.b b1 = new com.google.api.a.a.a.i.b(f.a());
        b1.b = getCurrentOrCreateNewHttpTransport();
        b1.c = createJsonFactory();
        b1.d = new h(oauth2TokenUrl);
        b1.f = new d(clientId, clientSecret);
        if (s != null)
        {
            b1.a(new m(s, dataStoreFactory));
        }
        b1.a(new CredentialListenerForwarder());
        s = b1.a();
        s.b(s2);
        s.a(s1);
        s.a(long1);
        return s;
    }

    private String generateAuthUrl(String s, Collection collection, String s1)
    {
        b b1 = authorizationCodeFlow.a();
        b1.a(s);
        if (collection != null)
        {
            b1.b(collection);
        }
        if (s1 != null)
        {
            b1.c(s1);
        }
        return b1.d();
    }

    private r generateTokenRequest(String s, String s1)
    {
        s = new c(s);
        if (((c) (s)).error != null)
        {
            return null;
        } else
        {
            s = ((c) (s)).code;
            s = authorizationCodeFlow.a(s);
            s.c(s1);
            return s;
        }
    }

    private void initializeAuthFlow(String s)
    {
        dataStoreFactory = g.a();
        Object obj = p.a(dataStoreFactory);
        obj = (new com.google.api.a.a.a.a.a(f.a(), getCurrentOrCreateNewHttpTransport(), createJsonFactory(), new h(oauth2TokenUrl), new d(clientId, clientSecret), clientId, oauth2AuthorizeUrl)).a(((com.google.api.a.g.b.d) (obj)));
        ((com.google.api.a.a.a.a.a) (obj)).a(new com.google.api.a.a.a.a.b() {

            final OAuth2Session this$0;

            public void onCredentialCreated(i j, s s1)
            {
                accessToken = s1.accessToken;
                credential = j;
                if (credentialsListener != null)
                {
                    dispatchAsyncResult(j. new Runnable() {

                        final _cls6 this$1;
                        final i val$newCredential;

                        public void run()
                        {
                            credentialsListener.onReceivedCredentials(newCredential);
                        }

            
            {
                this$1 = final__pcls6;
                newCredential = i.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = OAuth2Session.this;
                super();
            }
        });
        ((com.google.api.a.a.a.a.a) (obj)).a(new CredentialListenerForwarder());
        authorizationCodeFlow = ((com.google.api.a.a.a.a.a) (obj)).a();
        authorizationCodeFlow.b(s);
    }

    public void authorizeUser(final String userId, final String request, String s, OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        credentialsListener = oauth2clientcredentialslistener;
        initializeAuthFlow(userId);
        request = new n(getCurrentOrCreateNewHttpTransport(), createJsonFactory(), new h(oauth2TokenUrl), request, s);
        request.a(new d(clientId, clientSecret));
        userId = new FutureTask(new ErrorReportingStringCallable() {

            final OAuth2Session this$0;
            final n val$request;
            final String val$userId;

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                try
                {
                    s s1 = request.b();
                    accessToken = s1.accessToken;
                    authorizationCodeFlow.a(s1, userId);
                }
                catch (Object obj)
                {
                    ((t) (obj)).printStackTrace();
                    if (((t) (obj)).a != null)
                    {
                        obj = ((t) (obj)).a.errorDescription;
                    } else
                    {
                        obj = ((t) (obj)).getMessage();
                    }
                    dispatchError(((String) (obj)));
                }
                catch (IOException ioexception)
                {
                    dispatchError(ioexception.getMessage());
                    ioexception.printStackTrace();
                }
                return accessToken;
            }

            
            {
                this$0 = OAuth2Session.this;
                request = n1;
                userId = s1;
                super();
            }
        });
        executorService.execute(userId);
    }

    public String beginAuthorizeUser(String s, String s1, Collection collection, String s2, OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        credentialsListener = oauth2clientcredentialslistener;
        initializeAuthFlow(s);
        return generateAuthUrl(s1, collection, s2);
    }

    protected v createHttpTransport()
    {
        return new e();
    }

    protected abstract com.google.api.a.e.c createJsonFactory();

    public void customGrantTypeAuthentication(final String userId, final String request, Map map, final OAuth2ClientCredentialsListener listener)
    {
        credentialsListener = listener;
        dataStoreFactory = g.a();
        final i newCredential = (p)p.a(dataStoreFactory).a(userId);
        if (newCredential != null)
        {
            try
            {
                newCredential = buildCredential(userId, newCredential.a(), newCredential.c(), newCredential.b());
                credential = newCredential;
                dispatchAsyncResult(new Runnable() {

                    final OAuth2Session this$0;
                    final OAuth2ClientCredentialsListener val$listener;
                    final i val$newCredential;

                    public void run()
                    {
                        listener.onReceivedCredentials(newCredential);
                    }

            
            {
                this$0 = OAuth2Session.this;
                listener = oauth2clientcredentialslistener;
                newCredential = j;
                super();
            }
                });
                return;
            }
            catch (IOException ioexception) { }
        }
        request = (new r(getCurrentOrCreateNewHttpTransport(), createJsonFactory(), new h(oauth2TokenUrl), request)).b(new d(clientId, clientSecret));
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); request.b(s, map.get(s)))
        {
            s = (String)iterator.next();
        }

        userId = new FutureTask(new ErrorReportingStringCallable() {

            final OAuth2Session this$0;
            final OAuth2ClientCredentialsListener val$listener;
            final r val$request;
            final String val$userId;

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                try
                {
                    s s1 = request.b();
                    accessToken = s1.accessToken;
                    Object obj1 = new com.google.api.a.a.a.i.b(f.a());
                    obj1.b = getCurrentOrCreateNewHttpTransport();
                    obj1.c = createJsonFactory();
                    obj1.d = new h(oauth2TokenUrl);
                    obj1.f = new d(clientId, clientSecret);
                    if (userId != null)
                    {
                        ((com.google.api.a.a.a.i.b) (obj1)).a(new m(userId, dataStoreFactory));
                    }
                    ((com.google.api.a.a.a.i.b) (obj1)).a(new CredentialListenerForwarder());
                    obj1 = ((com.google.api.a.a.a.i.b) (obj1)).a();
                    ((i) (obj1)).a(s1);
                    credential = ((i) (obj1));
                    if (credentialsListener != null)
                    {
                        dispatchAsyncResult(((_cls1) (obj1)). new Runnable() {

                            final _cls3 this$1;
                            final i val$newCredential;

                            public void run()
                            {
                                listener.onReceivedCredentials(newCredential);
                            }

            
            {
                this$1 = final__pcls3;
                newCredential = i.this;
                super();
            }
                        });
                    }
                    p.a(dataStoreFactory).a(userId, new p(credential));
                }
                catch (Object obj)
                {
                    ((t) (obj)).printStackTrace();
                    if (((t) (obj)).a != null)
                    {
                        obj = ((t) (obj)).a.error;
                    } else
                    {
                        obj = ((t) (obj)).getMessage();
                    }
                    dispatchError(((String) (obj)));
                }
                catch (IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                    dispatchError(ioexception1.getMessage());
                }
                return accessToken;
            }

            
            {
                this$0 = OAuth2Session.this;
                request = r1;
                userId = s1;
                listener = oauth2clientcredentialslistener;
                super();
            }
        });
        executorService.execute(userId);
        return;
    }

    protected abstract void dispatchAsyncResult(Runnable runnable);

    public String getAccessToken()
    {
        return accessToken;
    }

    public i getCredential()
    {
        return credential;
    }

    public i getCredential(String s)
    {
        if (authorizationCodeFlow != null)
        {
            return authorizationCodeFlow.b(s);
        } else
        {
            return credential;
        }
    }

    public v getCurrentHttpTransport()
    {
        if (authorizationCodeFlow != null)
        {
            return authorizationCodeFlow.a;
        } else
        {
            return null;
        }
    }

    protected v getCurrentOrCreateNewHttpTransport()
    {
        if (getCurrentHttpTransport() != null)
        {
            return getCurrentHttpTransport();
        } else
        {
            return createHttpTransport();
        }
    }

    public void getUserAccessToken(String s, String s1, String s2)
    {
        s = new FutureTask(new ErrorReportingStringCallable() {

            final OAuth2Session this$0;
            final r val$request;
            final String val$userId;

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                try
                {
                    s s3 = request.b();
                    accessToken = s3.accessToken;
                    authorizationCodeFlow.a(s3, userId);
                }
                catch (Object obj)
                {
                    ((t) (obj)).printStackTrace();
                    if (((t) (obj)).a != null)
                    {
                        obj = ((t) (obj)).a.error;
                    } else
                    {
                        obj = ((t) (obj)).getMessage();
                    }
                    dispatchError(((String) (obj)));
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    dispatchError(ioexception.getMessage());
                }
                return accessToken;
            }

            
            {
                this$0 = OAuth2Session.this;
                request = r1;
                userId = s1;
                super();
            }
        });
        executorService.execute(s);
    }

    public void requestClientAccessToken(final OAuth2ClientCredentialsListener listener)
    {
        final com.google.api.a.a.a.g request = new com.google.api.a.a.a.g(createHttpTransport(), new com.google.api.a.b.a.a.a(), new h(oauth2TokenUrl));
        request.a(new d(clientId, clientSecret));
        listener = new FutureTask(new Callable() {

            final OAuth2Session this$0;
            final OAuth2ClientCredentialsListener val$listener;
            final com.google.api.a.a.a.g val$request;

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                try
                {
                    Object obj = request.b();
                    accessToken = ((s) (obj)).accessToken;
                    obj = (new com.google.api.a.a.a.i.b(f.a())).a().a(((s) (obj)));
                    credential = ((i) (obj));
                    dispatchAsyncResult(((_cls1) (obj)). new Runnable() {

                        final _cls1 this$1;
                        final i val$newCredential;

                        public void run()
                        {
                            listener.onReceivedCredentials(newCredential);
                        }

            
            {
                this$1 = final__pcls1;
                newCredential = i.this;
                super();
            }
                    });
                }
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
                return accessToken;
            }

            
            {
                this$0 = OAuth2Session.this;
                request = g1;
                listener = oauth2clientcredentialslistener;
                super();
            }
        });
        executorService.execute(listener);
    }

    public void setCredentialsListener(OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        credentialsListener = oauth2clientcredentialslistener;
    }

    public void setOAuth2BaseUri(String s)
    {
        oauth2AuthorizeUrl = (new StringBuilder()).append(s).append("/oauth2/authorize?mode=redirect").toString();
        oauth2TokenUrl = (new StringBuilder()).append(s).append("/oauth2/token").toString();
    }

    public void setOAuth2BaseUri(String s, String s1)
    {
        oauth2AuthorizeUrl = (new StringBuilder()).append(s1).append("/oauth2/authorize?mode=redirect").toString();
        oauth2TokenUrl = (new StringBuilder()).append(s).append("/oauth2/token").toString();
    }



/*
    static String access$002(OAuth2Session oauth2session, String s)
    {
        oauth2session.accessToken = s;
        return s;
    }

*/



/*
    static i access$102(OAuth2Session oauth2session, i j)
    {
        oauth2session.credential = j;
        return j;
    }

*/







    // Unreferenced inner class com/rdio/android/core/OAuth2Session$ErrorReportingStringCallable$1

/* anonymous class */
    class ErrorReportingStringCallable._cls1
        implements Runnable
    {

        final ErrorReportingStringCallable this$1;

        public void run()
        {
            credentialsListener.onError(errorMessage);
        }

            
            {
                this$1 = ErrorReportingStringCallable.this;
                super();
            }
    }

}
