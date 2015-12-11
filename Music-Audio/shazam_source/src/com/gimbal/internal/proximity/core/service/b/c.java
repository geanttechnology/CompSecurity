// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.b;

import com.gimbal.internal.proximity.core.d.a;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersRequest;
import com.gimbal.internal.proximity.core.service.protocol.ServerError;
import com.gimbal.internal.proximity.core.service.protocol.parser.ServerErrorParser;
import com.gimbal.internal.proximity.core.service.protocol.parser.ServerErrorParserImpl;
import com.gimbal.internal.proximity.d;
import java.util.concurrent.ExecutorService;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class c
{

    private static final com.gimbal.a.a b = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/service/b/c.getSimpleName());
    protected final com.gimbal.internal.rest.c a;

    public c(com.gimbal.internal.rest.c c1)
    {
        a = c1;
    }

    static com.gimbal.a.a a()
    {
        return b;
    }

    public abstract void a(Object obj, com.gimbal.internal.proximity.c c1, RestTemplate resttemplate);

    public final void b(Object obj, com.gimbal.internal.proximity.c c1, RestTemplate resttemplate)
    {
        obj = new Runnable(obj, c1, resttemplate) {

            private Object a;
            private com.gimbal.internal.proximity.c b;
            private RestTemplate c;
            private c d;

            public final void run()
            {
                String s;
                String s1;
                int i;
                int j;
                j = d.a.b;
                s1 = "incomplete";
                s = s1;
                i = j;
                d.a(a, b, c);
_L2:
                return;
                Exception exception1;
                exception1;
                s = s1;
                i = j;
                Object obj1 = a;
                s = s1;
                i = j;
                if (!(exception1 instanceof HttpClientErrorException))
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                s = s1;
                i = j;
                if (!(obj1 instanceof ResolveTransmittersRequest))
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                s = s1;
                i = j;
                obj1 = exception1.getMessage();
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                s = s1;
                i = j;
                if (((String) (obj1)).startsWith("404"))
                {
                    break MISSING_BLOCK_LABEL_145;
                }
                s = s1;
                i = j;
                com.gimbal.internal.proximity.core.service.b.c.a();
                s = s1;
                i = j;
                exception1.getClass().getSimpleName();
                s = s1;
                i = j;
                exception1.getMessage();
                s = s1;
                i = j;
                s1 = (new StringBuilder("Error is:")).append(exception1.getMessage()).toString();
                int k;
                obj1 = s1;
                k = j;
                s = s1;
                i = j;
                if (!(exception1 instanceof HttpClientErrorException))
                {
                    continue; /* Loop/switch isn't completed */
                }
                s = s1;
                i = j;
                obj1 = (HttpClientErrorException)exception1;
                s = s1;
                i = j;
                obj1 = (new ServerErrorParserImpl()).parse(((HttpClientErrorException) (obj1)).getResponseBodyAsString());
                s = s1;
                i = j;
                k = ((ServerError) (obj1)).getCode().intValue();
                s = s1;
                i = k;
                obj1 = ((ServerError) (obj1)).getReason();
                if (obj1 == null) goto _L2; else goto _L1
_L1:
                b.a(k, ((String) (obj1)));
                return;
                Throwable throwable;
                throwable;
                s = s1;
                i = j;
                com.gimbal.internal.proximity.core.service.b.c.a();
                s = s1;
                i = j;
                throwable.getClass().getSimpleName();
                s = s1;
                i = j;
                throwable.getMessage();
                b.a(j, "incomplete");
                return;
                Exception exception;
                exception;
                if (s != null)
                {
                    b.a(i, s);
                }
                throw exception;
            }

            
            {
                d = c.this;
                a = obj;
                b = c2;
                c = resttemplate;
                super();
            }
        };
        com.gimbal.internal.proximity.core.d.a.a().execute(((Runnable) (obj)));
    }

}
