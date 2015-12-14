// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.List;
import okio.ByteString;
import okio.d;
import okio.e;

// Referenced classes of package com.squareup.okhttp:
//            RequestBody, MediaType, MultipartBuilder

final class length extends RequestBody
{

    private final ByteString boundary;
    private final MediaType contentType;
    private final long length;
    private final List partBodies;
    private final List partHeadings;

    public long contentLength()
    {
        return length;
    }

    public MediaType contentType()
    {
        return contentType;
    }

    public void writeTo(e e1)
    {
        int j = partHeadings.size();
        for (int i = 0; i < j; i++)
        {
            e1.a(((d)partHeadings.get(i)).r());
            ((RequestBody)partBodies.get(i)).writeTo(e1);
        }

        e1.c(MultipartBuilder.access$000());
        e1.c(MultipartBuilder.access$100());
        e1.b(boundary);
        e1.c(MultipartBuilder.access$100());
        e1.c(MultipartBuilder.access$000());
    }

    public (MediaType mediatype, ByteString bytestring, List list, List list1, long l)
    {
        if (mediatype == null)
        {
            throw new NullPointerException("type == null");
        }
        boundary = bytestring;
        contentType = MediaType.parse((new StringBuilder()).append(mediatype).append("; boundary=").append(bytestring.a()).toString());
        partHeadings = Util.immutableList(list);
        partBodies = Util.immutableList(list1);
        long l1 = l;
        if (l != -1L)
        {
            l1 = l + (long)(MultipartBuilder.access$000().length + MultipartBuilder.access$100().length + bytestring.e() + MultipartBuilder.access$100().length + MultipartBuilder.access$000().length);
        }
        length = l1;
    }
}
