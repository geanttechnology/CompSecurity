// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.auth.VineAuthorizationFactory;
import twitter4j.auth.VineOauthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponseEvent;
import twitter4j.internal.http.XAuthAuthorization;

// Referenced classes of package twitter4j:
//            TwitterImpl, TwitterException

public class VineTwitter4j extends TwitterImpl
{

    VineTwitter4j(Configuration configuration, Authorization authorization)
    {
        super(configuration, authorization);
    }

    private OAuthSupport getOAuth()
    {
        if (!(auth instanceof OAuthSupport))
        {
            throw new IllegalStateException("OAuth consumer key/secret combination not supplied");
        } else
        {
            return (OAuthSupport)auth;
        }
    }

    public volatile boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public volatile Configuration getConfiguration()
    {
        return super.getConfiguration();
    }

    public AccessToken getOAuthAccessToken()
        throws TwitterException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = getAuthorization();
        if (!(obj instanceof BasicAuthorization)) goto _L2; else goto _L1
_L1:
        Authorization authorization;
        obj = (BasicAuthorization)obj;
        authorization = VineAuthorizationFactory.getInstance(conf);
        if (!(authorization instanceof VineOauthAuthorization)) goto _L4; else goto _L3
_L3:
        auth = authorization;
        obj = ((VineOauthAuthorization)authorization).getOAuthAccessToken(((BasicAuthorization) (obj)).getUserId(), ((BasicAuthorization) (obj)).getPassword());
_L5:
        screenName = ((AccessToken) (obj)).getScreenName();
        id = ((AccessToken) (obj)).getUserId();
        this;
        JVM INSTR monitorexit ;
        return ((AccessToken) (obj));
_L4:
        throw new IllegalStateException("consumer key / secret combination not supplied.");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
label0:
        {
            if (!(obj instanceof XAuthAuthorization))
            {
                break label0;
            }
            obj = (XAuthAuthorization)obj;
            auth = ((Authorization) (obj));
            OAuthAuthorization oauthauthorization = new OAuthAuthorization(conf);
            oauthauthorization.setOAuthConsumer(((XAuthAuthorization) (obj)).getConsumerKey(), ((XAuthAuthorization) (obj)).getConsumerSecret());
            obj = oauthauthorization.getOAuthAccessToken(((XAuthAuthorization) (obj)).getUserId(), ((XAuthAuthorization) (obj)).getPassword());
        }
          goto _L5
        obj = getOAuth().getOAuthAccessToken();
          goto _L5
    }

    public AccessToken getOAuthAccessToken(String s)
        throws TwitterException
    {
        this;
        JVM INSTR monitorenter ;
        s = super.getOAuthAccessToken(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public AccessToken getOAuthAccessToken(String s, String s1)
        throws TwitterException
    {
        this;
        JVM INSTR monitorenter ;
        s = super.getOAuthAccessToken(s, s1);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public AccessToken getOAuthAccessToken(RequestToken requesttoken)
        throws TwitterException
    {
        this;
        JVM INSTR monitorenter ;
        requesttoken = super.getOAuthAccessToken(requesttoken);
        this;
        JVM INSTR monitorexit ;
        return requesttoken;
        requesttoken;
        throw requesttoken;
    }

    public AccessToken getOAuthAccessToken(RequestToken requesttoken, String s)
        throws TwitterException
    {
        this;
        JVM INSTR monitorenter ;
        requesttoken = super.getOAuthAccessToken(requesttoken, s);
        this;
        JVM INSTR monitorexit ;
        return requesttoken;
        requesttoken;
        throw requesttoken;
    }

    public volatile RequestToken getOAuthRequestToken()
        throws TwitterException
    {
        return super.getOAuthRequestToken();
    }

    public volatile RequestToken getOAuthRequestToken(String s)
        throws TwitterException
    {
        return super.getOAuthRequestToken(s);
    }

    public volatile RequestToken getOAuthRequestToken(String s, String s1)
        throws TwitterException
    {
        return super.getOAuthRequestToken(s, s1);
    }

    public volatile int hashCode()
    {
        return super.hashCode();
    }

    public void httpResponseReceived(HttpResponseEvent httpresponseevent)
    {
    }

    public volatile void setOAuthAccessToken(AccessToken accesstoken)
    {
        super.setOAuthAccessToken(accesstoken);
    }

    public volatile void setOAuthConsumer(String s, String s1)
    {
        super.setOAuthConsumer(s, s1);
    }

    public volatile void shutdown()
    {
        super.shutdown();
    }

    public volatile String toString()
    {
        return super.toString();
    }
}
