// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apy;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MultipartBuilder, MediaType, Headers

private static final class partBodies extends RequestBody
{

    private final apy boundary;
    private long contentLength;
    private final MediaType contentType;
    private final List partBodies;
    private final List partHeaders;

    private long writeOrCountBytes(apw apw1, boolean flag)
        throws IOException
    {
        long l1 = 0L;
        apw apw2;
        RequestBody requestbody;
        Object obj;
        int i;
        int j;
        int k;
        int l;
        long l2;
        if (flag)
        {
            apw1 = new apv();
            apw2 = apw1;
        } else
        {
            apw2 = null;
        }
        k = partHeaders.size();
        i = 0;
        if (i >= k) goto _L2; else goto _L1
_L1:
        obj = (Headers)partHeaders.get(i);
        requestbody = (RequestBody)partBodies.get(i);
        apw1.c(MultipartBuilder.access$000());
        apw1.b(boundary);
        apw1.c(MultipartBuilder.access$100());
        if (obj != null)
        {
            j = 0;
            for (l = ((Headers) (obj)).size(); j < l; j++)
            {
                apw1.b(((Headers) (obj)).name(j)).c(MultipartBuilder.access$200()).b(((Headers) (obj)).value(j)).c(MultipartBuilder.access$100());
            }

        }
        obj = requestbody.contentType();
        if (obj != null)
        {
            apw1.b("Content-Type: ").b(((MediaType) (obj)).toString()).c(MultipartBuilder.access$100());
        }
        l2 = requestbody.contentLength();
        if (l2 == -1L) goto _L4; else goto _L3
_L3:
        apw1.b("Content-Length: ").k(l2).c(MultipartBuilder.access$100());
_L6:
        apw1.c(MultipartBuilder.access$100());
        if (flag)
        {
            l1 = l2 + l1;
        } else
        {
            ((RequestBody)partBodies.get(i)).writeTo(apw1);
        }
        apw1.c(MultipartBuilder.access$100());
        i++;
        break MISSING_BLOCK_LABEL_31;
_L4:
        if (!flag) goto _L6; else goto _L5
_L5:
        apw2.t();
        l2 = -1L;
_L8:
        return l2;
_L2:
        apw1.c(MultipartBuilder.access$000());
        apw1.b(boundary);
        apw1.c(MultipartBuilder.access$000());
        apw1.c(MultipartBuilder.access$100());
        l2 = l1;
        if (flag)
        {
            l2 = apw2.a();
            apw2.t();
            return l1 + l2;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public long contentLength()
        throws IOException
    {
        long l = contentLength;
        if (l != -1L)
        {
            return l;
        } else
        {
            long l1 = writeOrCountBytes(null, true);
            contentLength = l1;
            return l1;
        }
    }

    public MediaType contentType()
    {
        return contentType;
    }

    public void writeTo(apw apw1)
        throws IOException
    {
        writeOrCountBytes(apw1, false);
    }

    public (MediaType mediatype, apy apy1, List list, List list1)
    {
        contentLength = -1L;
        if (mediatype == null)
        {
            throw new NullPointerException("type == null");
        } else
        {
            boundary = apy1;
            contentType = MediaType.parse((new StringBuilder()).append(mediatype).append("; boundary=").append(apy1.a()).toString());
            partHeaders = Util.immutableList(list);
            partBodies = Util.immutableList(list1);
            return;
        }
    }
}
