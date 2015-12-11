// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;

// Referenced classes of package twitter4j:
//            TwitterBaseImpl, Twitter, TwitterException

class TwitterImpl extends TwitterBaseImpl
    implements Twitter
{

    private static final Map implicitParamsMap = new HashMap();
    private static final Map implicitParamsStrMap = new HashMap();
    private static final long serialVersionUID = 0xeb5f6361d798c8fcL;
    private final HttpParameter IMPLICIT_PARAMS[];
    private final String IMPLICIT_PARAMS_STR;
    private final HttpParameter INCLUDE_MY_RETWEET;

    TwitterImpl(Configuration configuration, Authorization authorization)
    {
        super(configuration, authorization);
        INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", configuration.isIncludeMyRetweetEnabled());
        HttpParameter ahttpparameter[] = (HttpParameter[])implicitParamsMap.get(configuration);
        String s = (String)implicitParamsStrMap.get(configuration);
        authorization = ahttpparameter;
        if (ahttpparameter == null)
        {
            String s1;
            Object obj;
            boolean flag;
            if (configuration.isIncludeEntitiesEnabled())
            {
                authorization = "1";
            } else
            {
                authorization = "0";
            }
            if (configuration.isIncludeRTsEnabled())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            if (configuration.getContributingTo() != -1L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = (new StringBuilder()).append("include_entities=").append(authorization).append("&include_rts=").append(s);
            if (flag)
            {
                s1 = (new StringBuilder()).append("&contributingto=").append(configuration.getContributingTo()).toString();
            } else
            {
                s1 = "";
            }
            s1 = ((StringBuilder) (obj)).append(s1).toString();
            implicitParamsStrMap.put(configuration, s1);
            obj = new ArrayList(4);
            ((List) (obj)).add(new HttpParameter("include_entities", authorization));
            ((List) (obj)).add(new HttpParameter("include_rts", s));
            if (flag)
            {
                ((List) (obj)).add(new HttpParameter("contributingto", configuration.getContributingTo()));
            }
            if (configuration.isTrimUserEnabled())
            {
                ((List) (obj)).add(new HttpParameter("trim_user", "1"));
            }
            authorization = (HttpParameter[])((List) (obj)).toArray(new HttpParameter[((List) (obj)).size()]);
            implicitParamsMap.put(configuration, authorization);
            s = s1;
        }
        IMPLICIT_PARAMS = authorization;
        IMPLICIT_PARAMS_STR = s;
    }

    private HttpResponse get(String s)
        throws TwitterException
    {
        ensureAuthorizationEnabled();
        if (s.contains("?"))
        {
            s = (new StringBuilder()).append(s).append("&").append(IMPLICIT_PARAMS_STR).toString();
        } else
        {
            s = (new StringBuilder()).append(s).append("?").append(IMPLICIT_PARAMS_STR).toString();
        }
        if (!conf.isMBeanEnabled())
        {
            return http.get(s, auth);
        }
        System.currentTimeMillis();
        s = http.get(s, auth);
        System.currentTimeMillis();
        return s;
        s;
        System.currentTimeMillis();
        throw s;
    }

    private HttpResponse get(String s, HttpParameter ahttpparameter[])
        throws TwitterException
    {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled())
        {
            return http.get(s, mergeImplicitParams(ahttpparameter), auth);
        }
        System.currentTimeMillis();
        s = http.get(s, mergeImplicitParams(ahttpparameter), auth);
        System.currentTimeMillis();
        return s;
        s;
        System.currentTimeMillis();
        throw s;
    }

    private boolean isOk(HttpResponse httpresponse)
    {
        return httpresponse != null && httpresponse.getStatusCode() < 300;
    }

    private HttpParameter[] mergeImplicitParams(HttpParameter ahttpparameter[])
    {
        return mergeParameters(ahttpparameter, IMPLICIT_PARAMS);
    }

    private HttpParameter[] mergeParameters(HttpParameter ahttpparameter[], HttpParameter httpparameter)
    {
        if (ahttpparameter != null && httpparameter != null)
        {
            HttpParameter ahttpparameter1[] = new HttpParameter[ahttpparameter.length + 1];
            System.arraycopy(ahttpparameter, 0, ahttpparameter1, 0, ahttpparameter.length);
            ahttpparameter1[ahttpparameter1.length - 1] = httpparameter;
            return ahttpparameter1;
        }
        if (ahttpparameter == null && httpparameter == null)
        {
            return new HttpParameter[0];
        }
        if (ahttpparameter != null)
        {
            return ahttpparameter;
        } else
        {
            return (new HttpParameter[] {
                httpparameter
            });
        }
    }

    private HttpParameter[] mergeParameters(HttpParameter ahttpparameter[], HttpParameter ahttpparameter1[])
    {
        if (ahttpparameter != null && ahttpparameter1 != null)
        {
            HttpParameter ahttpparameter2[] = new HttpParameter[ahttpparameter.length + ahttpparameter1.length];
            System.arraycopy(ahttpparameter, 0, ahttpparameter2, 0, ahttpparameter.length);
            System.arraycopy(ahttpparameter1, 0, ahttpparameter2, ahttpparameter.length, ahttpparameter1.length);
            return ahttpparameter2;
        }
        if (ahttpparameter == null && ahttpparameter1 == null)
        {
            return new HttpParameter[0];
        }
        if (ahttpparameter != null)
        {
            return ahttpparameter;
        } else
        {
            return ahttpparameter1;
        }
    }

    private HttpResponse post(String s)
        throws TwitterException
    {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled())
        {
            return http.post(s, IMPLICIT_PARAMS, auth);
        }
        System.currentTimeMillis();
        s = http.post(s, IMPLICIT_PARAMS, auth);
        System.currentTimeMillis();
        return s;
        s;
        System.currentTimeMillis();
        throw s;
    }

    private HttpResponse post(String s, HttpParameter ahttpparameter[])
        throws TwitterException
    {
        ensureAuthorizationEnabled();
        if (!conf.isMBeanEnabled())
        {
            return http.post(s, mergeImplicitParams(ahttpparameter), auth);
        }
        System.currentTimeMillis();
        s = http.post(s, mergeImplicitParams(ahttpparameter), auth);
        System.currentTimeMillis();
        return s;
        s;
        System.currentTimeMillis();
        throw s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TwitterImpl{INCLUDE_MY_RETWEET=").append(INCLUDE_MY_RETWEET).append('}').toString();
    }

}
