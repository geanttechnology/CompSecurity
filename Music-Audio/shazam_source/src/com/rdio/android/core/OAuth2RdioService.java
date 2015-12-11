// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import com.google.api.a.a.a.i;
import com.google.api.a.d.ac;
import com.google.api.a.d.h;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.s;
import com.google.api.a.d.v;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core:
//            RdioService_Api, RdioApiRequestArg, OAuth2Session, RdioApiResponse

public class OAuth2RdioService extends RdioService_Api
{
    public static interface ClientAuthorizedListener
    {

        public abstract void onAuthorized(i i);

        public abstract void onError(String s);
    }


    private static final String API_BASE_URI = "https://www.rdio.com";
    private static final String API_INVOKE_URI = "https://www.rdio.com/api/1/";
    private static final String API_SUB_URI = "/api/1/";
    private String apiBaseUri;
    private String apiInvokeUri;
    private String apiSubUri;
    private ExecutorService executorService;
    private OAuth2Session oAuth2Session;
    private String userId;

    public OAuth2RdioService(OAuth2Session oauth2session)
    {
        apiBaseUri = "https://www.rdio.com";
        apiSubUri = "/api/1/";
        apiInvokeUri = "https://www.rdio.com/api/1/";
        executorService = Executors.newSingleThreadExecutor();
        oAuth2Session = oauth2session;
    }

    protected void asyncPostRequest(RdioApiRequestArg ardioapirequestarg[], RdioService_Api.ResponseListener responselistener, boolean flag, Object obj)
    {
        if (flag)
        {
            System.err.print("Request wants response cached, but caching not supported.");
        }
        try
        {
            ardioapirequestarg = new FutureTask(new Callable() {

                final OAuth2RdioService this$0;
                final RdioService_Api.ResponseListener val$listener;
                final p val$request;

                public volatile Object call()
                {
                    return call();
                }

                public JSONObject call()
                {
                    try
                    {
                        final s response = request.a();
                        JSONObject jsonobject = new JSONObject(response.e());
                        oAuth2Session.dispatchAsyncResult(jsonobject. new Runnable() {

                            final _cls2 this$1;
                            final JSONObject val$jsonResponse;
                            final s val$response;

                            public void run()
                            {
                                if (listener != null)
                                {
                                    listener.onResponse(RdioApiResponse.responseFactory(response.c, jsonResponse, response.e.c));
                                }
                            }

            
            {
                this$1 = final__pcls2;
                response = s1;
                jsonResponse = JSONObject.this;
                super();
            }
                        });
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                    }
                    return null;
                }

            
            {
                this$0 = OAuth2RdioService.this;
                request = p1;
                listener = responselistener;
                super();
            }
            });
            executorService.execute(ardioapirequestarg);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RdioApiRequestArg ardioapirequestarg[])
        {
            ardioapirequestarg.printStackTrace();
        }
    }

    public void authorizeClient(final ClientAuthorizedListener listener)
    {
        if (oAuth2Session.getCredential() == null)
        {
            oAuth2Session.requestClientAccessToken(new OAuth2Session.OAuth2ClientCredentialsListener() {

                final OAuth2RdioService this$0;
                final ClientAuthorizedListener val$listener;

                public void onCredentialRefreshed(i i)
                {
                    listener.onAuthorized(i);
                }

                public void onError(String s)
                {
                    if (listener != null)
                    {
                        listener.onError(s);
                    }
                }

                public void onReceivedCredentials(i i)
                {
                    listener.onAuthorized(i);
                }

            
            {
                this$0 = OAuth2RdioService.this;
                listener = clientauthorizedlistener;
                super();
            }
            });
        } else
        if (listener != null)
        {
            listener.onAuthorized(oAuth2Session.getCredential());
            return;
        }
    }

    public void authorizeUser(String s, String s1, String s2, OAuth2Session.OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        userId = s;
        oAuth2Session.authorizeUser(s, s1, s2, oauth2clientcredentialslistener);
    }

    public String beginAuthorizeUser(String s, String s1, Collection collection, String s2, OAuth2Session.OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        userId = s;
        return oAuth2Session.beginAuthorizeUser(s, s1, collection, s2, oauth2clientcredentialslistener);
    }

    public void customGrantTypeAuthentication(String s, String s1, Map map, OAuth2Session.OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        userId = s;
        oAuth2Session.customGrantTypeAuthentication(s, s1, map, oauth2clientcredentialslistener);
    }

    protected String getApiInvokeUri()
    {
        return apiInvokeUri;
    }

    protected OAuth2Session getOAuth2Session()
    {
        return oAuth2Session;
    }

    public void getUserAccessToken(String s, String s1)
    {
        oAuth2Session.getUserAccessToken(s, s1, userId);
    }

    protected q requestFactory(String s)
    {
        s = oAuth2Session.getCredential(s);
        return oAuth2Session.getCurrentOrCreateNewHttpTransport().a(s);
    }

    public void setApiBaseUri(String s)
    {
        apiBaseUri = s;
        setApiInvokeUri((new StringBuilder()).append(s).append(apiSubUri).toString());
        oAuth2Session.setOAuth2BaseUri(s);
    }

    public void setApiBaseUri(String s, String s1, String s2)
    {
        apiBaseUri = s;
        setApiInvokeUri((new StringBuilder()).append(s).append(apiSubUri).toString());
        oAuth2Session.setOAuth2BaseUri(s1, s2);
    }

    public void setApiInvokeUri(String s)
    {
        apiInvokeUri = s;
    }

    public void setCredentialsListener(OAuth2Session.OAuth2ClientCredentialsListener oauth2clientcredentialslistener)
    {
        oAuth2Session.setCredentialsListener(oauth2clientcredentialslistener);
    }

}
