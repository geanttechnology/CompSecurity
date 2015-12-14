// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            Cookie, Credentials

public class HttpState
{

    private static final Log LOG;
    public static final String PREEMPTIVE_DEFAULT = "false";
    public static final String PREEMPTIVE_PROPERTY = "httpclient.authentication.preemptive";
    static Class class$org$apache$commons$httpclient$HttpState;
    private int cookiePolicy;
    protected ArrayList cookies;
    protected HashMap credMap;
    private boolean preemptive;
    protected HashMap proxyCred;

    public HttpState()
    {
        credMap = new HashMap();
        proxyCred = new HashMap();
        cookies = new ArrayList();
        preemptive = false;
        cookiePolicy = -1;
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

    private static String getCookiesStringRepresentation(List list)
    {
        StringBuffer stringbuffer = new StringBuffer();
        Cookie cookie;
        for (list = list.iterator(); list.hasNext(); stringbuffer.append(cookie.toExternalForm()))
        {
            cookie = (Cookie)list.next();
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append("#");
            }
        }

        return stringbuffer.toString();
    }

    private static String getCredentialsStringRepresentation(Map map)
    {
        StringBuffer stringbuffer = new StringBuffer();
        Credentials credentials;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuffer.append(credentials.toString()))
        {
            Object obj = iterator.next();
            credentials = (Credentials)map.get(obj);
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append(", ");
            }
            stringbuffer.append(obj);
            stringbuffer.append("#");
        }

        return stringbuffer.toString();
    }

    private static Credentials matchCredentials(HashMap hashmap, AuthScope authscope)
    {
        Credentials credentials = (Credentials)hashmap.get(authscope);
        Object obj1 = credentials;
        if (credentials == null)
        {
            int i = -1;
            Object obj = null;
            Iterator iterator = hashmap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj1 = (AuthScope)iterator.next();
                int j = authscope.match(((AuthScope) (obj1)));
                if (j > i)
                {
                    i = j;
                    obj = obj1;
                }
            } while (true);
            obj1 = credentials;
            if (obj != null)
            {
                obj1 = (Credentials)hashmap.get(obj);
            }
        }
        return ((Credentials) (obj1));
    }

    public void addCookie(Cookie cookie)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.addCookie(Cookie)");
        if (cookie == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        Iterator iterator = cookies.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!cookie.equals((Cookie)iterator.next()))
            {
                continue;
            }
            iterator.remove();
            break;
        } while (true);
        if (!cookie.isExpired())
        {
            cookies.add(cookie);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        cookie;
        throw cookie;
    }

    public void addCookies(Cookie acookie[])
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.addCookies(Cookie[])");
        if (acookie == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= acookie.length)
        {
            break; /* Loop/switch isn't completed */
        }
        addCookie(acookie[i]);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        acookie;
        throw acookie;
    }

    public void clear()
    {
        clearCookies();
        clearCredentials();
        clearProxyCredentials();
    }

    public void clearCookies()
    {
        this;
        JVM INSTR monitorenter ;
        cookies.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void clearCredentials()
    {
        credMap.clear();
    }

    public void clearProxyCredentials()
    {
        proxyCred.clear();
    }

    public int getCookiePolicy()
    {
        return cookiePolicy;
    }

    public Cookie[] getCookies()
    {
        this;
        JVM INSTR monitorenter ;
        Cookie acookie[];
        LOG.trace("enter HttpState.getCookies()");
        acookie = (Cookie[])(Cookie[])cookies.toArray(new Cookie[cookies.size()]);
        this;
        JVM INSTR monitorexit ;
        return acookie;
        Exception exception;
        exception;
        throw exception;
    }

    public Cookie[] getCookies(String s, int i, String s1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        CookieSpec cookiespec;
        ArrayList arraylist;
        LOG.trace("enter HttpState.getCookies(String, int, String, boolean)");
        cookiespec = CookiePolicy.getDefaultSpec();
        arraylist = new ArrayList(cookies.size());
        int j = 0;
        int k = cookies.size();
_L2:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        Cookie cookie = (Cookie)(Cookie)cookies.get(j);
        if (cookiespec.match(s, i, s1, flag, cookie))
        {
            arraylist.add(cookie);
        }
        break MISSING_BLOCK_LABEL_126;
        s = (Cookie[])(Cookie[])arraylist.toArray(new Cookie[arraylist.size()]);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Credentials getCredentials(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.getCredentials(String, String");
        s = matchCredentials(credMap, new AuthScope(s1, -1, s, AuthScope.ANY_SCHEME));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Credentials getCredentials(AuthScope authscope)
    {
        this;
        JVM INSTR monitorenter ;
        if (authscope != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
        authscope;
        this;
        JVM INSTR monitorexit ;
        throw authscope;
        LOG.trace("enter HttpState.getCredentials(AuthScope)");
        authscope = matchCredentials(credMap, authscope);
        this;
        JVM INSTR monitorexit ;
        return authscope;
    }

    public Credentials getProxyCredentials(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.getCredentials(String, String");
        s = matchCredentials(proxyCred, new AuthScope(s1, -1, s, AuthScope.ANY_SCHEME));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Credentials getProxyCredentials(AuthScope authscope)
    {
        this;
        JVM INSTR monitorenter ;
        if (authscope != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
        authscope;
        this;
        JVM INSTR monitorexit ;
        throw authscope;
        LOG.trace("enter HttpState.getProxyCredentials(AuthScope)");
        authscope = matchCredentials(proxyCred, authscope);
        this;
        JVM INSTR monitorexit ;
        return authscope;
    }

    public boolean isAuthenticationPreemptive()
    {
        return preemptive;
    }

    public boolean purgeExpiredCookies()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        LOG.trace("enter HttpState.purgeExpiredCookies()");
        flag = purgeExpiredCookies(new Date());
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean purgeExpiredCookies(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.purgeExpiredCookies(Date)");
        boolean flag = false;
        Iterator iterator = cookies.iterator();
_L1:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_62;
            }
        } while (!((Cookie)(Cookie)iterator.next()).isExpired(date));
        iterator.remove();
        flag = true;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return flag;
        date;
        throw date;
    }

    public void setAuthenticationPreemptive(boolean flag)
    {
        preemptive = flag;
    }

    public void setCookiePolicy(int i)
    {
        cookiePolicy = i;
    }

    public void setCredentials(String s, String s1, Credentials credentials)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.setCredentials(String, String, Credentials)");
        credMap.put(new AuthScope(s1, -1, s, AuthScope.ANY_SCHEME), credentials);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setCredentials(AuthScope authscope, Credentials credentials)
    {
        this;
        JVM INSTR monitorenter ;
        if (authscope != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
        authscope;
        this;
        JVM INSTR monitorexit ;
        throw authscope;
        LOG.trace("enter HttpState.setCredentials(AuthScope, Credentials)");
        credMap.put(authscope, credentials);
        this;
        JVM INSTR monitorexit ;
    }

    public void setProxyCredentials(String s, String s1, Credentials credentials)
    {
        this;
        JVM INSTR monitorenter ;
        LOG.trace("enter HttpState.setProxyCredentials(String, String, Credentials");
        proxyCred.put(new AuthScope(s1, -1, s, AuthScope.ANY_SCHEME), credentials);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setProxyCredentials(AuthScope authscope, Credentials credentials)
    {
        this;
        JVM INSTR monitorenter ;
        if (authscope != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
        authscope;
        this;
        JVM INSTR monitorexit ;
        throw authscope;
        LOG.trace("enter HttpState.setProxyCredentials(AuthScope, Credentials)");
        proxyCred.put(authscope, credentials);
        this;
        JVM INSTR monitorexit ;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new StringBuffer();
        ((StringBuffer) (obj)).append("[");
        ((StringBuffer) (obj)).append(getCredentialsStringRepresentation(proxyCred));
        ((StringBuffer) (obj)).append(" | ");
        ((StringBuffer) (obj)).append(getCredentialsStringRepresentation(credMap));
        ((StringBuffer) (obj)).append(" | ");
        ((StringBuffer) (obj)).append(getCookiesStringRepresentation(cookies));
        ((StringBuffer) (obj)).append("]");
        obj = ((StringBuffer) (obj)).toString();
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpState == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpState");
            class$org$apache$commons$httpclient$HttpState = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpState;
        }
        LOG = LogFactory.getLog(class1);
    }
}
