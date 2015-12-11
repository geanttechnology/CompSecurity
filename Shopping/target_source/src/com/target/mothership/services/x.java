// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.google.a.a.e;
import com.target.mothership.util.o;
import java.util.Map;

// Referenced classes of package com.target.mothership.services:
//            z

public class x extends Exception
{
    public static class a
    {

        private Throwable mCause;
        private Map mHeaders;
        private String mMessage;
        private com.target.mothership.services.f.a.b.b mRequest;
        private String mResponseBody;
        private z mResponseCode;

        public a a(com.target.mothership.services.f.a.b.b b1)
        {
            mRequest = b1;
            return this;
        }

        public a a(z z1)
        {
            mResponseCode = z1;
            return this;
        }

        public a a(String s)
        {
            mMessage = s;
            return this;
        }

        public a a(Throwable throwable)
        {
            mCause = throwable;
            return this;
        }

        public a a(Map map)
        {
            mHeaders = map;
            return this;
        }

        public x a()
        {
            if (mResponseCode == null)
            {
                mResponseCode = z.NONE;
            }
            if (o.g(mMessage))
            {
                return new x(mCause, mMessage, mResponseCode, mResponseBody, mHeaders, mRequest);
            } else
            {
                return new x(mCause, mResponseCode, mResponseBody, mHeaders, mRequest);
            }
        }

        public a b(String s)
        {
            mResponseBody = s;
            return this;
        }

        public a()
        {
        }
    }


    private final Map mHeaders;
    private final com.target.mothership.services.f.a.b.b mRequest;
    private final String mResponseBody;
    private final z mResponseCode;

    private x(Throwable throwable, z z, String s, Map map, com.target.mothership.services.f.a.b.b b1)
    {
        super(throwable);
        mResponseCode = z;
        mResponseBody = s;
        mHeaders = map;
        mRequest = b1;
    }


    private x(Throwable throwable, String s, z z, String s1, Map map, com.target.mothership.services.f.a.b.b b1)
    {
        super(s, throwable);
        mResponseCode = z;
        mResponseBody = s1;
        mHeaders = map;
        mRequest = b1;
    }


    public static a a(String s)
    {
        return (new a()).a(s);
    }

    public static a a(Throwable throwable)
    {
        return (new a()).a(throwable);
    }

    public String a()
    {
        return mResponseBody;
    }

    public z b()
    {
        return mResponseCode;
    }

    public e c()
    {
        return e.c(mRequest);
    }
}
