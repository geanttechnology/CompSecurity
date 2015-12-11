// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e;

import com.google.api.a.c.b.b;
import com.google.api.a.d.h;
import com.google.api.a.d.q;
import com.google.api.a.d.r;
import com.google.api.a.d.v;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.aa;
import com.google.api.a.g.u;
import com.google.api.a.g.w;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.c.e:
//            d, b

public abstract class com.google.api.a.c.e.a
{
    public static abstract class a
    {

        String applicationName;
        d googleClientRequestInitializer;
        r httpRequestInitializer;
        final u objectParser;
        String rootUrl;
        String servicePath;
        boolean suppressPatternChecks;
        boolean suppressRequiredParameterChecks;
        final v transport;

        public abstract com.google.api.a.c.e.a build();

        public final String getApplicationName()
        {
            return applicationName;
        }

        public final d getGoogleClientRequestInitializer()
        {
            return googleClientRequestInitializer;
        }

        public final r getHttpRequestInitializer()
        {
            return httpRequestInitializer;
        }

        public u getObjectParser()
        {
            return objectParser;
        }

        public final String getRootUrl()
        {
            return rootUrl;
        }

        public final String getServicePath()
        {
            return servicePath;
        }

        public final boolean getSuppressPatternChecks()
        {
            return suppressPatternChecks;
        }

        public final boolean getSuppressRequiredParameterChecks()
        {
            return suppressRequiredParameterChecks;
        }

        public final v getTransport()
        {
            return transport;
        }

        public a setApplicationName(String s)
        {
            applicationName = s;
            return this;
        }

        public a setGoogleClientRequestInitializer(d d1)
        {
            googleClientRequestInitializer = d1;
            return this;
        }

        public a setHttpRequestInitializer(r r)
        {
            httpRequestInitializer = r;
            return this;
        }

        public a setRootUrl(String s)
        {
            rootUrl = com.google.api.a.c.e.a.normalizeRootUrl(s);
            return this;
        }

        public a setServicePath(String s)
        {
            servicePath = com.google.api.a.c.e.a.normalizeServicePath(s);
            return this;
        }

        public a setSuppressAllChecks(boolean flag)
        {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }

        public a setSuppressPatternChecks(boolean flag)
        {
            suppressPatternChecks = flag;
            return this;
        }

        public a setSuppressRequiredParameterChecks(boolean flag)
        {
            suppressRequiredParameterChecks = flag;
            return this;
        }

        public a(v v1, String s, String s1, u u, r r)
        {
            transport = (v)c.a(v1);
            objectParser = u;
            setRootUrl(s);
            setServicePath(s1);
            httpRequestInitializer = r;
        }
    }


    static final Logger LOGGER = Logger.getLogger(com/google/api/a/c/e/a.getName());
    private final String applicationName;
    private final d googleClientRequestInitializer;
    private final u objectParser;
    private final q requestFactory;
    private final String rootUrl;
    private final String servicePath;
    private boolean suppressPatternChecks;
    private boolean suppressRequiredParameterChecks;

    public com.google.api.a.c.e.a(a a1)
    {
        googleClientRequestInitializer = a1.googleClientRequestInitializer;
        rootUrl = normalizeRootUrl(a1.rootUrl);
        servicePath = normalizeServicePath(a1.servicePath);
        if (aa.a(a1.applicationName))
        {
            LOGGER.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        applicationName = a1.applicationName;
        q q1;
        if (a1.httpRequestInitializer == null)
        {
            q1 = a1.transport.a(null);
        } else
        {
            q1 = a1.transport.a(a1.httpRequestInitializer);
        }
        requestFactory = q1;
        objectParser = a1.objectParser;
        suppressPatternChecks = a1.suppressPatternChecks;
        suppressRequiredParameterChecks = a1.suppressRequiredParameterChecks;
    }

    static String normalizeRootUrl(String s)
    {
        w.a(s, "root URL cannot be null.");
        String s1 = s;
        if (!s.endsWith("/"))
        {
            s1 = String.valueOf(s).concat("/");
        }
        return s1;
    }

    static String normalizeServicePath(String s)
    {
        w.a(s, "service path cannot be null");
        String s1;
        if (s.length() == 1)
        {
            w.a("/".equals(s), "service path must equal \"/\" if it is of length 1.");
            s1 = "";
        } else
        {
            s1 = s;
            if (s.length() > 0)
            {
                String s2 = s;
                if (!s.endsWith("/"))
                {
                    s2 = String.valueOf(s).concat("/");
                }
                s1 = s2;
                if (s2.startsWith("/"))
                {
                    return s2.substring(1);
                }
            }
        }
        return s1;
    }

    public final b batch()
    {
        return batch(null);
    }

    public final b batch(r r)
    {
        r = new b(getRequestFactory().a, r);
        r.a = new h(String.valueOf(getRootUrl()).concat("batch"));
        return r;
    }

    public final String getApplicationName()
    {
        return applicationName;
    }

    public final String getBaseUrl()
    {
        String s = String.valueOf(rootUrl);
        String s1 = String.valueOf(servicePath);
        if (s1.length() != 0)
        {
            return s.concat(s1);
        } else
        {
            return new String(s);
        }
    }

    public final d getGoogleClientRequestInitializer()
    {
        return googleClientRequestInitializer;
    }

    public u getObjectParser()
    {
        return objectParser;
    }

    public final q getRequestFactory()
    {
        return requestFactory;
    }

    public final String getRootUrl()
    {
        return rootUrl;
    }

    public final String getServicePath()
    {
        return servicePath;
    }

    public final boolean getSuppressPatternChecks()
    {
        return suppressPatternChecks;
    }

    public final boolean getSuppressRequiredParameterChecks()
    {
        return suppressRequiredParameterChecks;
    }

    public void initialize(com.google.api.a.c.e.b b1)
    {
        if (getGoogleClientRequestInitializer() != null)
        {
            getGoogleClientRequestInitializer().initialize(b1);
        }
    }

}
