// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.cookie;

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

// Referenced classes of package cz.msebera.android.httpclient.cookie:
//            CookieSpecFactory, CookieSpec, CookieSpecProvider

public final class CookieSpecRegistry
    implements Lookup
{

    private final ConcurrentHashMap registeredSpecs = new ConcurrentHashMap();

    public CookieSpecRegistry()
    {
    }

    public CookieSpec getCookieSpec(String s)
        throws IllegalStateException
    {
        return getCookieSpec(s, null);
    }

    public CookieSpec getCookieSpec(String s, HttpParams httpparams)
        throws IllegalStateException
    {
        Args.notNull(s, "Name");
        CookieSpecFactory cookiespecfactory = (CookieSpecFactory)registeredSpecs.get(s.toLowerCase(Locale.ENGLISH));
        if (cookiespecfactory != null)
        {
            return cookiespecfactory.newInstance(httpparams);
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Unsupported cookie spec: ").append(s).toString());
        }
    }

    public List getSpecNames()
    {
        return new ArrayList(registeredSpecs.keySet());
    }

    public CookieSpecProvider lookup(final String name)
    {
        return new CookieSpecProvider() {

            final CookieSpecRegistry this$0;
            final String val$name;

            public CookieSpec create(HttpContext httpcontext)
            {
                httpcontext = (HttpRequest)httpcontext.getAttribute("http.request");
                return getCookieSpec(name, httpcontext.getParams());
            }

            
            {
                this$0 = CookieSpecRegistry.this;
                name = s;
                super();
            }
        };
    }

    public volatile Object lookup(String s)
    {
        return lookup(s);
    }

    public void register(String s, CookieSpecFactory cookiespecfactory)
    {
        Args.notNull(s, "Name");
        Args.notNull(cookiespecfactory, "Cookie spec factory");
        registeredSpecs.put(s.toLowerCase(Locale.ENGLISH), cookiespecfactory);
    }

    public void setItems(Map map)
    {
        if (map == null)
        {
            return;
        } else
        {
            registeredSpecs.clear();
            registeredSpecs.putAll(map);
            return;
        }
    }

    public void unregister(String s)
    {
        Args.notNull(s, "Id");
        registeredSpecs.remove(s.toLowerCase(Locale.ENGLISH));
    }
}
