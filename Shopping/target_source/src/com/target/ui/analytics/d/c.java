// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.d;

import android.net.Uri;
import com.google.a.a.e;
import com.target.mothership.services.f.a.d;
import com.target.mothership.services.f.b.a;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.analytics.g;
import java.util.Map;

public class c
    implements g
{

    private static final String KEY_BASE_PATH = "TGT_HTTP_ENDPOINT_PATH";
    private static final String KEY_ERROR_CODE = "TGT_HTTP_ERROR_CODE";
    private static final String KEY_ERROR_RESPONSE_BODY = "TGT_HTTP_ERROR_RESPONSE_BODY";
    private static final String KEY_HOST = "TGT_HTTP_HOST";
    private static final String KEY_HTTP_METHOD = "TGT_HTTP_METHOD";
    private static final int MAX_RESPONSE_BODY_BYTES = 1024;
    private static final String TRUNCATED_MSG = " (body data truncated)";
    private static final String VALUE_BASE_PATH_UNAVAILBLE = "BASE_PATH_UNAVAILABLE";
    private static final String VALUE_HOST_UNAVAILBLE = "HOST_UNAVAILABLE";
    private static final String VALUE_METHOD_UNAVAILABLE = "METHOD_UNAVAILABLE";
    private final a mHosts;
    private final int mMaxResponseBodySize = 1024 - " (body data truncated)".length();

    public c(a a1)
    {
        mHosts = a1;
    }

    private Object b(x x1)
    {
        x1 = f(x1);
        if (x1 == null)
        {
            return "HOST_UNAVAILABLE";
        }
        if (((com.target.mothership.services.f.a.c) (x1)).host != null)
        {
            return mHosts.a(((com.target.mothership.services.f.a.c) (x1)).host);
        } else
        {
            return Uri.parse(x1.a(mHosts).toString()).getHost();
        }
    }

    private Object c(x x1)
    {
        x1 = f(x1);
        if (x1 == null || ((com.target.mothership.services.f.a.c) (x1)).path == null)
        {
            return "BASE_PATH_UNAVAILABLE";
        } else
        {
            return ((com.target.mothership.services.f.a.c) (x1)).path;
        }
    }

    private Object d(x x1)
    {
        x1 = f(x1);
        if (x1 == null)
        {
            return "METHOD_UNAVAILABLE";
        } else
        {
            return com.target.mothership.services.f.a.d.a(((com.target.mothership.services.f.a.c) (x1)).method).name();
        }
    }

    private Object e(x x1)
    {
        Object obj;
        if (x1.a() == null)
        {
            x1 = "";
        } else
        {
            x1 = x1.a();
        }
        obj = x1;
        if (x1.length() > mMaxResponseBodySize)
        {
            obj = x1.substring(0, mMaxResponseBodySize);
        }
        return obj;
    }

    private com.target.mothership.services.f.a.c f(x x1)
    {
        if (!x1.c().b())
        {
            return null;
        } else
        {
            return ((com.target.mothership.services.f.a.b.b)x1.c().c()).i();
        }
    }

    public Map a(x x1)
    {
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put("TGT_HTTP_HOST", b(x1));
        a1.put("TGT_HTTP_ENDPOINT_PATH", c(x1));
        a1.put("TGT_HTTP_METHOD", d(x1));
        a1.put("TGT_HTTP_ERROR_CODE", x1.b().name());
        a1.put("TGT_HTTP_ERROR_RESPONSE_BODY", e(x1));
        return a1;
    }

    public volatile Map a(Object obj)
    {
        return a((x)obj);
    }
}
