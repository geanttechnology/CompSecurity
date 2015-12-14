// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthScheme

public abstract class AuthPolicy
{

    public static final String AUTH_SCHEME_PRIORITY = "http.auth.scheme-priority";
    public static final String BASIC = "Basic";
    public static final String DIGEST = "Digest";
    protected static final Log LOG;
    public static final String NTLM = "NTLM";
    private static final HashMap SCHEMES = new HashMap();
    private static final ArrayList SCHEME_LIST = new ArrayList();
    static Class class$org$apache$commons$httpclient$auth$AuthPolicy;
    static Class class$org$apache$commons$httpclient$auth$BasicScheme;
    static Class class$org$apache$commons$httpclient$auth$DigestScheme;
    static Class class$org$apache$commons$httpclient$auth$NTLMScheme;

    public AuthPolicy()
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

    public static AuthScheme getAuthScheme(String s)
        throws IllegalStateException
    {
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Id may not be null");
        s;
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
        throw s;
        Class class1 = (Class)SCHEMES.get(s.toLowerCase());
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        AuthScheme authscheme = (AuthScheme)class1.newInstance();
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
        return authscheme;
        Exception exception;
        exception;
        LOG.error("Error initializing authentication scheme: " + s, exception);
        throw new IllegalStateException(s + " authentication scheme implemented by " + class1.getName() + " could not be initialized");
        throw new IllegalStateException("Unsupported authentication scheme " + s);
    }

    public static List getDefaultAuthPrefs()
    {
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorenter ;
        List list = (List)SCHEME_LIST.clone();
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public static void registerAuthScheme(String s, Class class1)
    {
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Id may not be null");
        s;
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
        throw s;
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        throw new IllegalArgumentException("Authentication scheme class may not be null");
        SCHEMES.put(s.toLowerCase(), class1);
        SCHEME_LIST.add(s.toLowerCase());
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
    }

    public static void unregisterAuthScheme(String s)
    {
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorenter ;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Id may not be null");
        s;
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
        throw s;
        SCHEMES.remove(s.toLowerCase());
        SCHEME_LIST.remove(s.toLowerCase());
        org/apache/commons/httpclient/auth/AuthPolicy;
        JVM INSTR monitorexit ;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$auth$NTLMScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.NTLMScheme");
            class$org$apache$commons$httpclient$auth$NTLMScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$NTLMScheme;
        }
        registerAuthScheme("NTLM", class1);
        if (class$org$apache$commons$httpclient$auth$DigestScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.DigestScheme");
            class$org$apache$commons$httpclient$auth$DigestScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$DigestScheme;
        }
        registerAuthScheme("Digest", class1);
        if (class$org$apache$commons$httpclient$auth$BasicScheme == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.BasicScheme");
            class$org$apache$commons$httpclient$auth$BasicScheme = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$BasicScheme;
        }
        registerAuthScheme("Basic", class1);
        if (class$org$apache$commons$httpclient$auth$AuthPolicy == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.auth.AuthPolicy");
            class$org$apache$commons$httpclient$auth$AuthPolicy = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$auth$AuthPolicy;
        }
        LOG = LogFactory.getLog(class1);
    }
}
