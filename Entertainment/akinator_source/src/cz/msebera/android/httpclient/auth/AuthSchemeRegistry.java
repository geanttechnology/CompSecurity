// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            AuthSchemeFactory, AuthScheme, AuthSchemeProvider

public final class AuthSchemeRegistry
    implements Lookup
{

    private final ConcurrentHashMap registeredSchemes = new ConcurrentHashMap();

    public AuthSchemeRegistry()
    {
    }

    public AuthScheme getAuthScheme(String s, HttpParams httpparams)
        throws IllegalStateException
    {
        Args.notNull(s, "Name");
        AuthSchemeFactory authschemefactory = (AuthSchemeFactory)registeredSchemes.get(s.toLowerCase(Locale.ENGLISH));
        if (authschemefactory != null)
        {
            return authschemefactory.newInstance(httpparams);
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Unsupported authentication scheme: ").append(s).toString());
        }
    }

    public List getSchemeNames()
    {
        return new ArrayList(registeredSchemes.keySet());
    }

    public AuthSchemeProvider lookup(final String name)
    {
        return new AuthSchemeProvider() {

            final AuthSchemeRegistry this$0;
            final String val$name;

            public AuthScheme create(HttpContext httpcontext)
            {
                httpcontext = (HttpRequest)httpcontext.getAttribute("http.request");
                return getAuthScheme(name, httpcontext.getParams());
            }

            
            {
                this$0 = AuthSchemeRegistry.this;
                name = s;
                super();
            }
        };
    }

    public volatile Object lookup(String s)
    {
        return lookup(s);
    }

    public void register(String s, AuthSchemeFactory authschemefactory)
    {
        Args.notNull(s, "Name");
        Args.notNull(authschemefactory, "Authentication scheme factory");
        registeredSchemes.put(s.toLowerCase(Locale.ENGLISH), authschemefactory);
    }

    public void setItems(Map map)
    {
        if (map == null)
        {
            return;
        } else
        {
            registeredSchemes.clear();
            registeredSchemes.putAll(map);
            return;
        }
    }

    public void unregister(String s)
    {
        Args.notNull(s, "Name");
        registeredSchemes.remove(s.toLowerCase(Locale.ENGLISH));
    }
}
