// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpec, RFC2109Spec, CookieSpecBase, NetscapeDraftSpec, 
//            RFC2965Spec

public abstract class CookiePolicy
{

    public static final String BROWSER_COMPATIBILITY = "compatibility";
    public static final int COMPATIBILITY = 0;
    public static final String DEFAULT = "default";
    public static final String IGNORE_COOKIES = "ignoreCookies";
    protected static final Log LOG;
    public static final String NETSCAPE = "netscape";
    public static final int NETSCAPE_DRAFT = 1;
    public static final int RFC2109 = 2;
    public static final int RFC2965 = 3;
    public static final String RFC_2109 = "rfc2109";
    public static final String RFC_2965 = "rfc2965";
    private static Map SPECS = Collections.synchronizedMap(new HashMap());
    static Class class$org$apache$commons$httpclient$cookie$CookiePolicy;
    static Class class$org$apache$commons$httpclient$cookie$CookieSpecBase;
    static Class class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec;
    static Class class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec;
    static Class class$org$apache$commons$httpclient$cookie$RFC2109Spec;
    static Class class$org$apache$commons$httpclient$cookie$RFC2965Spec;
    private static int defaultPolicy = 2;

    public CookiePolicy()
    {
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

    public static CookieSpec getCompatibilitySpec()
    {
        return getSpecByPolicy(0);
    }

    public static CookieSpec getCookieSpec(String s)
        throws IllegalStateException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Id may not be null");
        }
        Class class1 = (Class)SPECS.get(s.toLowerCase());
        if (class1 != null)
        {
            CookieSpec cookiespec;
            try
            {
                cookiespec = (CookieSpec)class1.newInstance();
            }
            catch (Exception exception)
            {
                LOG.error("Error initializing cookie spec: " + s, exception);
                throw new IllegalStateException(s + " cookie spec implemented by " + class1.getName() + " could not be initialized");
            }
            return cookiespec;
        } else
        {
            throw new IllegalStateException("Unsupported cookie spec " + s);
        }
    }

    public static int getDefaultPolicy()
    {
        return defaultPolicy;
    }

    public static CookieSpec getDefaultSpec()
    {
        CookieSpec cookiespec;
        try
        {
            cookiespec = getCookieSpec("default");
        }
        catch (IllegalStateException illegalstateexception)
        {
            LOG.warn("Default cookie policy is not registered");
            return new RFC2109Spec();
        }
        return cookiespec;
    }

    public static String[] getRegisteredCookieSpecs()
    {
        return (String[])(String[])SPECS.keySet().toArray(new String[SPECS.size()]);
    }

    public static CookieSpec getSpecByPolicy(int i)
    {
        switch (i)
        {
        default:
            return getDefaultSpec();

        case 0: // '\0'
            return new CookieSpecBase();

        case 1: // '\001'
            return new NetscapeDraftSpec();

        case 2: // '\002'
            return new RFC2109Spec();

        case 3: // '\003'
            return new RFC2965Spec();
        }
    }

    public static CookieSpec getSpecByVersion(int i)
    {
        switch (i)
        {
        default:
            return getDefaultSpec();

        case 0: // '\0'
            return new NetscapeDraftSpec();

        case 1: // '\001'
            return new RFC2109Spec();
        }
    }

    public static void registerCookieSpec(String s, Class class1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (class1 == null)
        {
            throw new IllegalArgumentException("Cookie spec class may not be null");
        } else
        {
            SPECS.put(s.toLowerCase(), class1);
            return;
        }
    }

    public static void setDefaultPolicy(int i)
    {
        defaultPolicy = i;
    }

    public static void unregisterCookieSpec(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Id may not be null");
        } else
        {
            SPECS.remove(s.toLowerCase());
            return;
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$cookie$RFC2109Spec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.RFC2109Spec");
            class$org$apache$commons$httpclient$cookie$RFC2109Spec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$RFC2109Spec;
        }
        registerCookieSpec("default", class1);
        if (class$org$apache$commons$httpclient$cookie$RFC2109Spec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.RFC2109Spec");
            class$org$apache$commons$httpclient$cookie$RFC2109Spec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$RFC2109Spec;
        }
        registerCookieSpec("rfc2109", class1);
        if (class$org$apache$commons$httpclient$cookie$RFC2965Spec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.RFC2965Spec");
            class$org$apache$commons$httpclient$cookie$RFC2965Spec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$RFC2965Spec;
        }
        registerCookieSpec("rfc2965", class1);
        if (class$org$apache$commons$httpclient$cookie$CookieSpecBase == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.CookieSpecBase");
            class$org$apache$commons$httpclient$cookie$CookieSpecBase = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$CookieSpecBase;
        }
        registerCookieSpec("compatibility", class1);
        if (class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.NetscapeDraftSpec");
            class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec;
        }
        registerCookieSpec("netscape", class1);
        if (class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.IgnoreCookiesSpec");
            class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec;
        }
        registerCookieSpec("ignoreCookies", class1);
        if (class$org$apache$commons$httpclient$cookie$CookiePolicy == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.cookie.CookiePolicy");
            class$org$apache$commons$httpclient$cookie$CookiePolicy = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$cookie$CookiePolicy;
        }
        LOG = LogFactory.getLog(class1);
    }
}
