// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            MalformedChallengeException, AuthenticationException, AuthState, AuthScheme, 
//            AuthChallengeException, AuthPolicy

public final class AuthChallengeProcessor
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$auth$AuthChallengeProcessor;
    private HttpParams params;

    public AuthChallengeProcessor(HttpParams httpparams)
    {
        params = null;
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameter collection may not be null");
        } else
        {
            params = httpparams;
            return;
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public AuthScheme processChallenge(AuthState authstate, Map map)
        throws MalformedChallengeException, AuthenticationException
    {
        if (authstate == null)
        {
            throw new IllegalArgumentException("Authentication state may not be null");
        }
        if (map == null)
        {
            throw new IllegalArgumentException("Challenge map may not be null");
        }
        if (authstate.isPreemptive() || authstate.getAuthScheme() == null)
        {
            authstate.setAuthScheme(selectAuthScheme(map));
        }
        authstate = authstate.getAuthScheme();
        String s = authstate.getSchemeName();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Using authentication scheme: " + s);
        }
        map = (String)map.get(s.toLowerCase());
        if (map == null)
        {
            throw new AuthenticationException(s + " authorization challenge expected, but not found");
        } else
        {
            authstate.processChallenge(map);
            LOG.debug("Authorization challenge processed");
            return authstate;
        }
    }

    public AuthScheme selectAuthScheme(Map map)
        throws AuthChallengeException
    {
        Object obj;
label0:
        {
            if (map == null)
            {
                throw new IllegalArgumentException("Challenge map may not be null");
            }
            Collection collection = (Collection)params.getParameter("http.auth.scheme-priority");
            if (collection != null)
            {
                obj = collection;
                if (!collection.isEmpty())
                {
                    break label0;
                }
            }
            obj = AuthPolicy.getDefaultAuthPrefs();
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Supported authentication schemes in the order of preference: " + obj);
        }
        Object obj2 = null;
        Iterator iterator = ((Collection) (obj)).iterator();
        do
        {
label1:
            {
                Object obj1 = obj2;
                if (iterator.hasNext())
                {
                    obj1 = (String)iterator.next();
                    if ((String)map.get(((String) (obj1)).toLowerCase()) == null)
                    {
                        break label1;
                    }
                    if (LOG.isInfoEnabled())
                    {
                        LOG.info(obj1 + " authentication scheme selected");
                    }
                    try
                    {
                        obj1 = AuthPolicy.getAuthScheme(((String) (obj1)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Map map)
                    {
                        throw new AuthChallengeException(map.getMessage());
                    }
                }
                if (obj1 == null)
                {
                    throw new AuthChallengeException("Unable to respond to any of these challenges: " + map);
                } else
                {
                    return ((AuthScheme) (obj1));
                }
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Challenge for " + obj1 + " authentication scheme not available");
            }
        } while (true);
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$AuthChallengeProcessor == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.AuthChallengeProcessor");
            class$org$apache$commons$httpclient$auth$AuthChallengeProcessor = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$AuthChallengeProcessor;
        }
        LOG = LogFactory.getLog(class1);
    }
}
