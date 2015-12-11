// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.content.Context;
import com.a.a.a.f;
import com.a.a.a.m;
import com.a.a.d;
import com.a.a.j;
import com.a.a.n;
import com.a.a.o;
import com.a.a.s;
import com.a.a.t;
import com.target.a.a.b;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

// Referenced classes of package com.target.mothership.services:
//            p, m, x, z, 
//            q, y, t

public class e
    implements p
{
    private final class a
        implements com.a.a.n.a
    {

        private String mFilterString;
        final e this$0;

        public boolean a(com.a.a.m m1)
        {
            m1 = ((com.a.a.m) (m1.getTag()));
            if (m1 == null)
            {
                return false;
            }
            if (!(m1 instanceof String))
            {
                return false;
            } else
            {
                return ((String)m1).equals(mFilterString);
            }
        }

        public a(String s1)
        {
            this$0 = e.this;
            super();
            mFilterString = s1;
        }
    }

    private class b extends com.a.a.m
    {

        private final com.a.a.o.b mListener;
        private final com.target.mothership.services.f.a.b.b mRequest;
        final e this$0;

        protected void a(y y1)
        {
            mListener.onResponse(y1);
        }

        protected void deliverResponse(Object obj)
        {
            a((y)obj);
        }

        public byte[] getBody()
        {
            if (mRequest.d() == null)
            {
                return null;
            } else
            {
                return mRequest.d().getBytes(Charset.forName("UTF-8"));
            }
        }

        public String getBodyContentType()
        {
            if (mRequest.g() == t.Json)
            {
                return "application/json; charset=utf-8";
            } else
            {
                return "text/xml; charset=utf-8";
            }
        }

        public Map getHeaders()
            throws com.a.a.a
        {
            return mRequest.f();
        }

        protected o parseNetworkResponse(j j1)
        {
            Object obj = (String)j1.headers.get("Content-Type");
            if (obj != null) goto _L2; else goto _L1
_L1:
            j1.headers.put("Content-Type", "charset=UTF-8");
_L4:
            y y1 = new y(j1.statusCode, j1.data, j1.headers, j1.notModified, j1.networkTimeMs);
            obj = null;
            if (!mRequest.h())
            {
                obj = com.a.a.a.e.a(j1);
            }
            return o.a(y1, ((com.a.a.b.a) (obj)));
_L2:
            if (!((String) (obj)).contains("UTF-8"))
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(";charset=UTF-8").toString();
                j1.headers.put("Content-Type", obj);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public b(com.target.mothership.services.f.a.b.b b1, com.a.a.o.b b2, com.a.a.o.a a1)
        {
            this$0 = e.this;
            super(b1.c(), b1.e(), a1);
            mListener = b2;
            mRequest = b1;
        }
    }


    private static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private static final String CONTENT_TYPE_XML = "text/xml; charset=utf-8";
    private static final float DEFAULT_BACKOFF_MULT = 1F;
    private static final int DEFAULT_RETRY_ATTEMPTS = 1;
    private static final int DEFAULT_RETRY_MS = 20000;
    private static final String TAG = "DefaultRequestSender";
    private static final String TYPE_UTF8_CHARSET = "charset=UTF-8";
    private final n mRequestQueue;

    public e(Context context)
    {
        this(context, ((f) (new com.target.mothership.services.m())));
    }

    public e(Context context, f f)
    {
        mRequestQueue = m.a(context, f);
    }

    static x a(t t1, com.target.mothership.services.f.a.b.b b1)
    {
        return b(t1, b1);
    }

    private static x b(t t1, com.target.mothership.services.f.a.b.b b1)
    {
        b1 = x.a(t1).a(b1);
        if (t1.a == null) goto _L2; else goto _L1
_L1:
        t1 = t1.a;
        b1.a(z.a(((j) (t1)).statusCode)).a(((j) (t1)).headers);
        try
        {
            b1.b(new String(((j) (t1)).data, "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            com.target.a.a.b.a("DefaultRequestSender", "failed to convert response bytes into UTF-8 string");
        }
_L4:
        return b1.a();
_L2:
        if (t1 instanceof s)
        {
            b1.a(z.REQUEST_TIMEOUT);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(final com.target.mothership.services.f.a.b.b request, final q responseHandler, String s1)
    {
        com.a.a.o.b b1 = new com.a.a.o.b() {

            final e this$0;
            final com.target.mothership.services.f.a.b.b val$request;
            final q val$responseHandler;

            public void a(y y1)
            {
                responseHandler.a(y1, true, request);
            }

            public void onResponse(Object obj)
            {
                a((y)obj);
            }

            
            {
                this$0 = e.this;
                responseHandler = q1;
                request = b1;
                super();
            }
        };
        responseHandler = new com.a.a.o.a() {

            final e this$0;
            final com.target.mothership.services.f.a.b.b val$request;
            final q val$responseHandler;

            public void onErrorResponse(t t1)
            {
                responseHandler.a(e.a(t1, request), request);
            }

            
            {
                this$0 = e.this;
                responseHandler = q1;
                request = b1;
                super();
            }
        };
        request.a();
        request = new b(request, b1, responseHandler);
        request.setRetryPolicy(new d(20000, 1, 1.0F));
        request.setTag(s1);
        mRequestQueue.a(request);
    }

    public void a(com.target.mothership.services.f.a.b.b b1, q q, String s1)
    {
        b(b1, q, s1);
    }

    public void a(String s1)
        throws IllegalArgumentException
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("cannot cancel requests.  tag must not be null.");
        } else
        {
            s1 = new a(s1);
            mRequestQueue.a(s1);
            return;
        }
    }
}
