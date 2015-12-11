// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e;

import com.google.api.a.c.d.a;
import com.google.api.a.d.ab;
import com.google.api.a.d.f;
import com.google.api.a.d.g;
import com.google.api.a.d.h;
import com.google.api.a.d.i;
import com.google.api.a.d.m;
import com.google.api.a.d.p;
import com.google.api.a.d.q;
import com.google.api.a.d.s;
import com.google.api.a.d.t;
import com.google.api.a.d.u;
import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.google.api.a.c.e:
//            a

public abstract class b extends l
{

    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final com.google.api.a.c.e.a abstractGoogleClient;
    private boolean disableGZipContent;
    private a downloader;
    private final i httpContent;
    private m lastResponseHeaders;
    private int lastStatusCode;
    private String lastStatusMessage;
    private m requestHeaders;
    private final String requestMethod;
    private Class responseClass;
    private com.google.api.a.c.d.b uploader;
    private final String uriTemplate;

    public b(com.google.api.a.c.e.a a1, String s1, String s2, i i, Class class1)
    {
        requestHeaders = new m();
        lastStatusCode = -1;
        responseClass = (Class)c.a(class1);
        abstractGoogleClient = (com.google.api.a.c.e.a)c.a(a1);
        requestMethod = (String)c.a(s1);
        uriTemplate = (String)c.a(s2);
        httpContent = i;
        s1 = a1.getApplicationName();
        if (s1 != null)
        {
            a1 = requestHeaders;
            s1 = String.valueOf(String.valueOf(s1));
            s2 = String.valueOf(String.valueOf("Google-API-Java-Client"));
            a1.e((new StringBuilder(s1.length() + 1 + s2.length())).append(s1).append(" ").append(s2).toString());
            return;
        } else
        {
            requestHeaders.e("Google-API-Java-Client");
            return;
        }
    }

    private p buildHttpRequest(boolean flag)
    {
        Object obj;
label0:
        {
            boolean flag2 = false;
            boolean flag1;
            if (uploader == null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            w.a(flag1);
            if (flag)
            {
                flag1 = flag2;
                if (!requestMethod.equals("GET"))
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        w.a(flag1);
        if (flag)
        {
            obj = "HEAD";
        } else
        {
            obj = requestMethod;
        }
        obj = getAbstractGoogleClient().getRequestFactory().a(((String) (obj)), buildHttpRequestUrl(), httpContent);
        (new com.google.api.a.c.b()).b(((p) (obj)));
        obj.m = getAbstractGoogleClient().getObjectParser();
        if (httpContent == null && (requestMethod.equals("POST") || requestMethod.equals("PUT") || requestMethod.equals("PATCH")))
        {
            obj.f = new f();
        }
        ((p) (obj)).b.putAll(requestHeaders);
        if (!disableGZipContent)
        {
            obj.n = new g();
        }
        obj.l = new u(((p) (obj)).l, ((p) (obj))) {

            final u a;
            final p b;
            final b c;

            public final void a(s s1)
            {
                if (a != null)
                {
                    a.a(s1);
                }
                if (!s1.a() && b.o)
                {
                    throw c.newExceptionOnError(s1);
                } else
                {
                    return;
                }
            }

            
            {
                c = b.this;
                a = u1;
                b = p1;
                super();
            }
        };
        return ((p) (obj));
    }

    private s executeUnparsed(boolean flag)
    {
        Object obj1;
        if (uploader == null)
        {
            obj1 = buildHttpRequest(flag).a();
        } else
        {
            Object obj = buildHttpRequestUrl();
            boolean flag1 = getAbstractGoogleClient().getRequestFactory().a(requestMethod, ((h) (obj)), httpContent).o;
            obj1 = uploader;
            obj1.d = requestHeaders;
            obj1.g = disableGZipContent;
            if (((com.google.api.a.c.d.b) (obj1)).a == com.google.api.a.c.d.a.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag);
            if (((com.google.api.a.c.d.b) (obj1)).e)
            {
                obj = ((com.google.api.a.c.d.b) (obj1)).a(((h) (obj)));
            } else
            {
                obj = ((com.google.api.a.c.d.b) (obj1)).b(((h) (obj)));
            }
            ((s) (obj)).e.m = getAbstractGoogleClient().getObjectParser();
            obj1 = obj;
            if (flag1)
            {
                obj1 = obj;
                if (!((s) (obj)).a())
                {
                    throw newExceptionOnError(((s) (obj)));
                }
            }
        }
        lastResponseHeaders = ((s) (obj1)).e.c;
        lastStatusCode = ((s) (obj1)).c;
        lastStatusMessage = ((s) (obj1)).d;
        return ((s) (obj1));
    }

    public p buildHttpRequest()
    {
        return buildHttpRequest(false);
    }

    public h buildHttpRequestUrl()
    {
        return new h(ab.a(abstractGoogleClient.getBaseUrl(), uriTemplate, this));
    }

    public p buildHttpRequestUsingHead()
    {
        return buildHttpRequest(true);
    }

    protected final void checkRequiredParameter(Object obj, String s1)
    {
        boolean flag;
        if (abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "Required parameter %s must be specified", new Object[] {
            s1
        });
    }

    public Object execute()
    {
        return executeUnparsed().a(responseClass);
    }

    public void executeAndDownloadTo(OutputStream outputstream)
    {
        executeUnparsed().a(outputstream);
    }

    public InputStream executeAsInputStream()
    {
        return executeUnparsed().b();
    }

    protected s executeMedia()
    {
        set("alt", "media");
        return executeUnparsed();
    }

    protected void executeMediaAndDownloadTo(OutputStream outputstream)
    {
        if (downloader == null)
        {
            executeMedia().a(outputstream);
            return;
        }
        a a1 = downloader;
        h h1 = buildHttpRequestUrl();
        m m1 = requestHeaders;
        boolean flag;
        if (a1.d == com.google.api.a.c.d.a.a.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        h1.put("alt", "media");
        if (a1.a)
        {
            a1.d = com.google.api.a.c.d.a.a.b;
            a1.c = ((Long)m.a(a1.a(a1.f, h1, m1, outputstream).e.c.contentLength)).longValue();
            a1.e = a1.c;
            a1.d = com.google.api.a.c.d.a.a.c;
            return;
        }
        do
        {
            long l2 = (a1.e + (long)a1.b) - 1L;
            l1 = l2;
            if (a1.f != -1L)
            {
                l1 = Math.min(a1.f, l2);
            }
            String s1 = (String)m.a(a1.a(l1, h1, m1, outputstream).e.c.contentRange);
            if (s1 == null)
            {
                l1 = 0L;
            } else
            {
                l1 = Long.parseLong(s1.substring(s1.indexOf('-') + 1, s1.indexOf('/'))) + 1L;
            }
            if (s1 != null && a1.c == 0L)
            {
                a1.c = Long.parseLong(s1.substring(s1.indexOf('/') + 1));
            }
            if (a1.c > l1)
            {
                a1.e = l1;
                a1.d = com.google.api.a.c.d.a.a.b;
            } else
            {
                a1.e = a1.c;
                a1.d = com.google.api.a.c.d.a.a.c;
                return;
            }
        } while (true);
    }

    protected InputStream executeMediaAsInputStream()
    {
        return executeMedia().b();
    }

    public s executeUnparsed()
    {
        return executeUnparsed(false);
    }

    public s executeUsingHead()
    {
        s s1;
        boolean flag;
        if (uploader == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        s1 = executeUnparsed(true);
        s1.c();
        return s1;
    }

    public com.google.api.a.c.e.a getAbstractGoogleClient()
    {
        return abstractGoogleClient;
    }

    public final boolean getDisableGZipContent()
    {
        return disableGZipContent;
    }

    public final i getHttpContent()
    {
        return httpContent;
    }

    public final m getLastResponseHeaders()
    {
        return lastResponseHeaders;
    }

    public final int getLastStatusCode()
    {
        return lastStatusCode;
    }

    public final String getLastStatusMessage()
    {
        return lastStatusMessage;
    }

    public final a getMediaHttpDownloader()
    {
        return downloader;
    }

    public final com.google.api.a.c.d.b getMediaHttpUploader()
    {
        return uploader;
    }

    public final m getRequestHeaders()
    {
        return requestHeaders;
    }

    public final String getRequestMethod()
    {
        return requestMethod;
    }

    public final Class getResponseClass()
    {
        return responseClass;
    }

    public final String getUriTemplate()
    {
        return uriTemplate;
    }

    protected final void initializeMediaDownload()
    {
        q q1 = abstractGoogleClient.getRequestFactory();
        downloader = new a(q1.a, q1.b);
    }

    protected final void initializeMediaUpload(com.google.api.a.d.b b1)
    {
        Object obj = abstractGoogleClient.getRequestFactory();
        uploader = new com.google.api.a.c.d.b(b1, ((q) (obj)).a, ((q) (obj)).b);
        b1 = uploader;
        obj = requestMethod;
        boolean flag;
        if (((String) (obj)).equals("POST") || ((String) (obj)).equals("PUT"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        b1.c = ((String) (obj));
        if (httpContent != null)
        {
            uploader.b = httpContent;
        }
    }

    public IOException newExceptionOnError(s s1)
    {
        return new t(s1);
    }

    public final void queue(com.google.api.a.c.b.b b1, Class class1, com.google.api.a.c.b.a a1)
    {
        p p1;
        Class class2;
        boolean flag;
        if (uploader == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "Batching media requests is not supported");
        p1 = buildHttpRequest();
        class2 = getResponseClass();
        c.a(p1);
        c.a(a1);
        c.a(class2);
        c.a(class1);
        b1.b.add(new com.google.api.a.c.b.a(a1, class2, class1, p1));
    }

    public b set(String s1, Object obj)
    {
        return (b)super.set(s1, obj);
    }

    public volatile l set(String s1, Object obj)
    {
        return set(s1, obj);
    }

    public b setDisableGZipContent(boolean flag)
    {
        disableGZipContent = flag;
        return this;
    }

    public b setRequestHeaders(m m1)
    {
        requestHeaders = m1;
        return this;
    }
}
