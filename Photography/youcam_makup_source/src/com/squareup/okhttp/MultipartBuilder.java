// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;
import okio.d;

// Referenced classes of package com.squareup.okhttp:
//            MediaType, Headers, RequestBody

public final class MultipartBuilder
{

    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    private static final byte COLONSPACE[] = {
        58, 32
    };
    private static final byte CRLF[] = {
        13, 10
    };
    private static final byte DASHDASH[] = {
        45, 45
    };
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final ByteString boundary;
    private long length;
    private final List partBodies;
    private final List partHeadings;
    private MediaType type;

    public MultipartBuilder()
    {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String s)
    {
        type = MIXED;
        length = 0L;
        partHeadings = new ArrayList();
        partBodies = new ArrayList();
        boundary = ByteString.a(s);
    }

    private static StringBuilder appendQuotedString(StringBuilder stringbuilder, String s)
    {
        int i;
        int j;
        stringbuilder.append('"');
        i = 0;
        j = s.length();
_L6:
        char c;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 3: default 64
    //                   10: 77
    //                   13: 87
    //                   34: 97;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_97;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuilder.append(c);
_L7:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        stringbuilder.append("%0A");
          goto _L7
_L3:
        stringbuilder.append("%0D");
          goto _L7
        stringbuilder.append("%22");
          goto _L7
        stringbuilder.append('"');
        return stringbuilder;
    }

    private d createPartHeading(Headers headers, RequestBody requestbody, boolean flag)
    {
        d d1 = new d();
        if (!flag)
        {
            d1.b(CRLF);
        }
        d1.b(DASHDASH);
        d1.a(boundary);
        d1.b(CRLF);
        if (headers != null)
        {
            for (int i = 0; i < headers.size(); i++)
            {
                d1.a(headers.name(i)).b(COLONSPACE).a(headers.value(i)).b(CRLF);
            }

        }
        headers = requestbody.contentType();
        if (headers != null)
        {
            d1.a("Content-Type: ").a(headers.toString()).b(CRLF);
        }
        long l = requestbody.contentLength();
        if (l != -1L)
        {
            d1.a("Content-Length: ").a(Long.toString(l)).b(CRLF);
        }
        d1.b(CRLF);
        return d1;
    }

    public MultipartBuilder addFormDataPart(String s, String s1)
    {
        return addFormDataPart(s, null, RequestBody.create(null, s1));
    }

    public MultipartBuilder addFormDataPart(String s, String s1, RequestBody requestbody)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        StringBuilder stringbuilder = new StringBuilder("form-data; name=");
        appendQuotedString(stringbuilder, s);
        if (s1 != null)
        {
            stringbuilder.append("; filename=");
            appendQuotedString(stringbuilder, s1);
        }
        return addPart(Headers.of(new String[] {
            "Content-Disposition", stringbuilder.toString()
        }), requestbody);
    }

    public MultipartBuilder addPart(Headers headers, RequestBody requestbody)
    {
        if (requestbody == null)
        {
            throw new NullPointerException("body == null");
        }
        if (headers != null && headers.get("Content-Type") != null)
        {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (headers != null && headers.get("Content-Length") != null)
        {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        headers = createPartHeading(headers, requestbody, partHeadings.isEmpty());
        partHeadings.add(headers);
        partBodies.add(requestbody);
        long l = requestbody.contentLength();
        if (l == -1L)
        {
            length = -1L;
        } else
        if (length != -1L)
        {
            long l1 = length;
            length = headers.a() + l + l1;
            return this;
        }
        return this;
    }

    public MultipartBuilder addPart(RequestBody requestbody)
    {
        return addPart(null, requestbody);
    }

    public RequestBody build()
    {
        if (partHeadings.isEmpty())
        {
            throw new IllegalStateException("Multipart body must have at least one part.");
        } else
        {
            return new MultipartRequestBody(type, boundary, partHeadings, partBodies, length);
        }
    }

    public MultipartBuilder type(MediaType mediatype)
    {
        if (mediatype == null)
        {
            throw new NullPointerException("type == null");
        }
        if (!mediatype.type().equals("multipart"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("multipart != ").append(mediatype).toString());
        } else
        {
            type = mediatype;
            return this;
        }
    }




    private class MultipartRequestBody extends RequestBody
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

            e1.c(MultipartBuilder.CRLF);
            e1.c(MultipartBuilder.DASHDASH);
            e1.b(boundary);
            e1.c(MultipartBuilder.DASHDASH);
            e1.c(MultipartBuilder.CRLF);
        }

        public MultipartRequestBody(MediaType mediatype, ByteString bytestring, List list, List list1, long l)
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
                l1 = l + (long)(MultipartBuilder.CRLF.length + MultipartBuilder.DASHDASH.length + bytestring.e() + MultipartBuilder.DASHDASH.length + MultipartBuilder.CRLF.length);
            }
            length = l1;
        }
    }

}
