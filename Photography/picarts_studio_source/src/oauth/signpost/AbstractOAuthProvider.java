// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.http.HttpRequest;
import oauth.signpost.http.HttpResponse;

// Referenced classes of package oauth.signpost:
//            OAuthProvider, OAuthConsumer, OAuth, OAuthProviderListener

public abstract class AbstractOAuthProvider
    implements OAuthProvider
{

    private static final long serialVersionUID = 1L;
    private String accessTokenEndpointUrl;
    private String authorizationWebsiteUrl;
    private Map defaultHeaders;
    private boolean isOAuth10a;
    private transient OAuthProviderListener listener;
    private String requestTokenEndpointUrl;
    private HttpParameters responseParameters;

    public AbstractOAuthProvider(String s, String s1, String s2)
    {
        requestTokenEndpointUrl = s;
        accessTokenEndpointUrl = s1;
        authorizationWebsiteUrl = s2;
        responseParameters = new HttpParameters();
        defaultHeaders = new HashMap();
    }

    public void closeConnection(HttpRequest httprequest, HttpResponse httpresponse)
    {
    }

    public abstract HttpRequest createRequest(String s);

    public String getAccessTokenEndpointUrl()
    {
        return accessTokenEndpointUrl;
    }

    public String getAuthorizationWebsiteUrl()
    {
        return authorizationWebsiteUrl;
    }

    public Map getRequestHeaders()
    {
        return defaultHeaders;
    }

    public String getRequestTokenEndpointUrl()
    {
        return requestTokenEndpointUrl;
    }

    protected String getResponseParameter(String s)
    {
        return responseParameters.getFirst(s);
    }

    public HttpParameters getResponseParameters()
    {
        return responseParameters;
    }

    protected void handleUnexpectedResponse(int i, HttpResponse httpresponse)
    {
        if (httpresponse == null)
        {
            return;
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpresponse.getContent()));
        StringBuilder stringbuilder = new StringBuilder();
        for (String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
        {
            stringbuilder.append(s);
        }

        switch (i)
        {
        default:
            throw new OAuthCommunicationException((new StringBuilder("Service provider responded in error: ")).append(i).append(" (").append(httpresponse.getReasonPhrase()).append(")").toString(), stringbuilder.toString());

        case 401: 
            throw new OAuthNotAuthorizedException(stringbuilder.toString());
        }
    }

    public boolean isOAuth10a()
    {
        return isOAuth10a;
    }

    public void removeListener(OAuthProviderListener oauthproviderlistener)
    {
        listener = null;
    }

    public void retrieveAccessToken(OAuthConsumer oauthconsumer, String s)
    {
        if (oauthconsumer.getToken() == null || oauthconsumer.getTokenSecret() == null)
        {
            throw new OAuthExpectationFailedException("Authorized request token or token secret not set. Did you retrieve an authorized request token before?");
        }
        if (isOAuth10a && s != null)
        {
            retrieveToken(oauthconsumer, accessTokenEndpointUrl, new String[] {
                "oauth_verifier", s
            });
            return;
        } else
        {
            retrieveToken(oauthconsumer, accessTokenEndpointUrl, new String[0]);
            return;
        }
    }

    public String retrieveRequestToken(OAuthConsumer oauthconsumer, String s)
    {
        oauthconsumer.setTokenWithSecret(null, null);
        retrieveToken(oauthconsumer, requestTokenEndpointUrl, new String[] {
            "oauth_callback", s
        });
        String s1 = responseParameters.getFirst("oauth_callback_confirmed");
        responseParameters.remove("oauth_callback_confirmed");
        isOAuth10a = Boolean.TRUE.toString().equals(s1);
        if (isOAuth10a)
        {
            return OAuth.addQueryParameters(authorizationWebsiteUrl, new String[] {
                "oauth_token", oauthconsumer.getToken()
            });
        } else
        {
            return OAuth.addQueryParameters(authorizationWebsiteUrl, new String[] {
                "oauth_token", oauthconsumer.getToken(), "oauth_callback", s
            });
        }
    }

    protected transient void retrieveToken(OAuthConsumer oauthconsumer, String s, String as[])
    {
        Object obj;
        Object obj1;
        String s1;
        Object obj2;
        Object obj3;
        Map map;
        obj1 = null;
        s1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        map = getRequestHeaders();
        if (oauthconsumer.getConsumerKey() == null || oauthconsumer.getConsumerSecret() == null)
        {
            throw new OAuthExpectationFailedException("Consumer key or secret not set");
        }
        s = createRequest(s);
        obj = obj3;
        obj1 = s;
        Iterator iterator = map.keySet().iterator();
_L2:
        obj = obj3;
        obj1 = s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj3;
        obj1 = s;
        String s2 = (String)iterator.next();
        obj = obj3;
        obj1 = s;
        s.setHeader(s2, (String)map.get(s2));
        if (true) goto _L2; else goto _L1
        obj;
        as = null;
        oauthconsumer = s;
        s = ((String) (obj));
_L6:
        throw s;
        obj1;
        s = oauthconsumer;
        obj = as;
        oauthconsumer = ((OAuthConsumer) (obj1));
_L3:
        HttpParameters httpparameters;
        int i;
        boolean flag;
        try
        {
            closeConnection(s, ((HttpResponse) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (OAuthConsumer oauthconsumer)
        {
            throw new OAuthCommunicationException(oauthconsumer);
        }
        throw oauthconsumer;
_L1:
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj = obj3;
        obj1 = s;
        httpparameters = new HttpParameters();
        obj = obj3;
        obj1 = s;
        httpparameters.putAll(as, true);
        obj = obj3;
        obj1 = s;
        oauthconsumer.setAdditionalParameters(httpparameters);
        obj = obj3;
        obj1 = s;
        if (listener == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = obj3;
        obj1 = s;
        listener.prepareRequest(s);
        obj = obj3;
        obj1 = s;
        oauthconsumer.sign(s);
        obj = obj3;
        obj1 = s;
        if (listener == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        obj = obj3;
        obj1 = s;
        listener.prepareSubmission(s);
        obj = obj3;
        obj1 = s;
        as = sendRequest(s);
        i = as.getStatusCode();
        flag = false;
        if (listener != null)
        {
            flag = listener.onResponseReceived(s, as);
        }
        if (flag)
        {
            try
            {
                closeConnection(s, as);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OAuthConsumer oauthconsumer)
            {
                throw new OAuthCommunicationException(oauthconsumer);
            }
        }
        if (i < 300)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        handleUnexpectedResponse(i, as);
        obj = OAuth.decodeForm(as.getContent());
        obj1 = ((HttpParameters) (obj)).getFirst("oauth_token");
        s1 = ((HttpParameters) (obj)).getFirst("oauth_token_secret");
        ((HttpParameters) (obj)).remove("oauth_token");
        ((HttpParameters) (obj)).remove("oauth_token_secret");
        setResponseParameters(((HttpParameters) (obj)));
        if (obj1 != null && s1 != null)
        {
            break MISSING_BLOCK_LABEL_453;
        }
        throw new OAuthExpectationFailedException("Request token or token secret not set in server reply. The service provider you use is probably buggy.");
        oauthconsumer.setTokenWithSecret(((String) (obj1)), s1);
        try
        {
            closeConnection(s, as);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OAuthConsumer oauthconsumer)
        {
            throw new OAuthCommunicationException(oauthconsumer);
        }
        oauthconsumer;
        s = null;
        obj = s1;
_L5:
        obj1 = s;
        throw oauthconsumer;
_L4:
        obj1 = s;
        throw new OAuthCommunicationException(oauthconsumer);
        oauthconsumer;
        s = null;
        obj = obj1;
          goto _L3
        oauthconsumer;
        obj = as;
          goto _L3
        oauthconsumer;
        obj = obj2;
          goto _L4
        oauthconsumer;
        obj = as;
          goto _L4
        oauthconsumer;
        obj = s1;
          goto _L5
        oauthconsumer;
        obj = as;
          goto _L5
        s;
        as = null;
        oauthconsumer = ((OAuthConsumer) (obj));
          goto _L6
        obj;
        oauthconsumer = s;
        s = ((String) (obj));
          goto _L6
        oauthconsumer;
        s = ((String) (obj1));
          goto _L3
        oauthconsumer;
        s = null;
        obj = obj2;
          goto _L4
    }

    public abstract HttpResponse sendRequest(HttpRequest httprequest);

    public void setListener(OAuthProviderListener oauthproviderlistener)
    {
        listener = oauthproviderlistener;
    }

    public void setOAuth10a(boolean flag)
    {
        isOAuth10a = flag;
    }

    public void setRequestHeader(String s, String s1)
    {
        defaultHeaders.put(s, s1);
    }

    public void setResponseParameters(HttpParameters httpparameters)
    {
        responseParameters = httpparameters;
    }
}
