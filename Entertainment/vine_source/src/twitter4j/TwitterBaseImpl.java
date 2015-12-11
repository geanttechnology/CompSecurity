// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpResponseEvent;
import twitter4j.internal.http.HttpResponseListener;
import twitter4j.internal.http.XAuthAuthorization;
import twitter4j.internal.json.z_T4JInternalFactory;
import twitter4j.internal.json.z_T4JInternalJSONImplFactory;

// Referenced classes of package twitter4j:
//            TwitterBase, TwitterException

abstract class TwitterBaseImpl
    implements TwitterBase, Serializable, OAuthSupport, HttpResponseListener
{

    private static final long serialVersionUID = 0xcb186dfe36c9c194L;
    protected Authorization auth;
    protected Configuration conf;
    protected z_T4JInternalFactory factory;
    protected transient HttpClientWrapper http;
    protected transient long id;
    protected transient String screenName;

    TwitterBaseImpl(Configuration configuration, Authorization authorization)
    {
        screenName = null;
        id = 0L;
        conf = configuration;
        auth = authorization;
        init();
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

    private void init()
    {
        if (auth == null)
        {
            String s = conf.getOAuthConsumerKey();
            String s1 = conf.getOAuthConsumerSecret();
            if (s != null && s1 != null && !conf.isApplicationOnlyAuthEnabled())
            {
                OAuthAuthorization oauthauthorization = new OAuthAuthorization(conf);
                String s2 = conf.getOAuthAccessToken();
                String s3 = conf.getOAuthAccessTokenSecret();
                if (s2 != null && s3 != null)
                {
                    oauthauthorization.setOAuthAccessToken(new AccessToken(s2, s3));
                }
                auth = oauthauthorization;
            }
        }
        http = new HttpClientWrapper(conf);
        http.setHttpResponseListener(this);
        setFactory();
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.readFields();
        conf = (Configuration)objectinputstream.readObject();
        auth = (Authorization)objectinputstream.readObject();
        http = new HttpClientWrapper(conf);
        http.setHttpResponseListener(this);
        setFactory();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.putFields();
        objectoutputstream.writeFields();
        objectoutputstream.writeObject(conf);
        objectoutputstream.writeObject(auth);
    }

    protected final void ensureAuthorizationEnabled()
    {
        if (!auth.isEnabled())
        {
            throw new IllegalStateException("Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for the detail.");
        } else
        {
            return;
        }
    }

    protected final void ensureOAuthEnabled()
    {
        if (!(auth instanceof OAuthAuthorization))
        {
            throw new IllegalStateException("OAuth required. Authentication credentials are missing. See http://twitter4j.org/en/configuration.html for the detail.");
        } else
        {
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof TwitterBaseImpl))
            {
                return false;
            }
            obj = (TwitterBaseImpl)obj;
            if (auth == null ? ((TwitterBaseImpl) (obj)).auth != null : !auth.equals(((TwitterBaseImpl) (obj)).auth))
            {
                return false;
            }
            if (!conf.equals(((TwitterBaseImpl) (obj)).conf))
            {
                return false;
            }
            if (http == null ? ((TwitterBaseImpl) (obj)).http != null : !http.equals(((TwitterBaseImpl) (obj)).http))
            {
                return false;
            }
        }
        return true;
    }

    public final Authorization getAuthorization()
    {
        return auth;
    }

    public Configuration getConfiguration()
    {
        return conf;
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
        authorization = AuthorizationFactory.getInstance(conf);
        if (!(authorization instanceof OAuthAuthorization)) goto _L4; else goto _L3
_L3:
        auth = authorization;
        obj = ((OAuthAuthorization)authorization).getOAuthAccessToken(((BasicAuthorization) (obj)).getUserId(), ((BasicAuthorization) (obj)).getPassword());
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
        s = getOAuth().getOAuthAccessToken(s);
        screenName = s.getScreenName();
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
        s = getOAuth().getOAuthAccessToken(s, s1);
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
        requesttoken = getOAuth().getOAuthAccessToken(requesttoken);
        screenName = requesttoken.getScreenName();
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
        requesttoken = getOAuth().getOAuthAccessToken(requesttoken, s);
        this;
        JVM INSTR monitorexit ;
        return requesttoken;
        requesttoken;
        throw requesttoken;
    }

    public RequestToken getOAuthRequestToken()
        throws TwitterException
    {
        return getOAuthRequestToken(null);
    }

    public RequestToken getOAuthRequestToken(String s)
        throws TwitterException
    {
        return getOAuth().getOAuthRequestToken(s);
    }

    public RequestToken getOAuthRequestToken(String s, String s1)
        throws TwitterException
    {
        return getOAuth().getOAuthRequestToken(s, s1);
    }

    public int hashCode()
    {
        int j = 0;
        int k = conf.hashCode();
        int i;
        if (http != null)
        {
            i = http.hashCode();
        } else
        {
            i = 0;
        }
        if (auth != null)
        {
            j = auth.hashCode();
        }
        return (k * 31 + i) * 31 + j;
    }

    public void httpResponseReceived(HttpResponseEvent httpresponseevent)
    {
    }

    protected void setFactory()
    {
        factory = new z_T4JInternalJSONImplFactory(conf);
    }

    public void setOAuthAccessToken(AccessToken accesstoken)
    {
        this;
        JVM INSTR monitorenter ;
        getOAuth().setOAuthAccessToken(accesstoken);
        this;
        JVM INSTR monitorexit ;
        return;
        accesstoken;
        throw accesstoken;
    }

    public void setOAuthConsumer(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new NullPointerException("consumer key is null");
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new NullPointerException("consumer secret is null");
        if (auth != null) goto _L2; else goto _L1
_L1:
        boolean flag = conf.isApplicationOnlyAuthEnabled();
        if (!flag) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        OAuthAuthorization oauthauthorization = new OAuthAuthorization(conf);
        oauthauthorization.setOAuthConsumer(s, s1);
        auth = oauthauthorization;
          goto _L3
_L2:
        if (!(auth instanceof BasicAuthorization))
        {
            continue; /* Loop/switch isn't completed */
        }
        XAuthAuthorization xauthauthorization = new XAuthAuthorization((BasicAuthorization)auth);
        xauthauthorization.setOAuthConsumer(s, s1);
        auth = xauthauthorization;
          goto _L3
        if (!(auth instanceof OAuthAuthorization)) goto _L3; else goto _L5
_L5:
        throw new IllegalStateException("consumer key/secret pair already set.");
    }

    public void shutdown()
    {
        if (http != null)
        {
            http.shutdown();
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("TwitterBase{conf=").append(conf).append(", http=").append(http).append(", auth=").append(auth).append('}').toString();
    }
}
