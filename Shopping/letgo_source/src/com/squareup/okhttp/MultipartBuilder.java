// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apy;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.squareup.okhttp:
//            MediaType, RequestBody, Headers

public final class MultipartBuilder
{
    private static final class MultipartRequestBody extends RequestBody
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
            apw1.c(MultipartBuilder.DASHDASH);
            apw1.b(boundary);
            apw1.c(MultipartBuilder.CRLF);
            if (obj != null)
            {
                j = 0;
                for (l = ((Headers) (obj)).size(); j < l; j++)
                {
                    apw1.b(((Headers) (obj)).name(j)).c(MultipartBuilder.COLONSPACE).b(((Headers) (obj)).value(j)).c(MultipartBuilder.CRLF);
                }

            }
            obj = requestbody.contentType();
            if (obj != null)
            {
                apw1.b("Content-Type: ").b(((MediaType) (obj)).toString()).c(MultipartBuilder.CRLF);
            }
            l2 = requestbody.contentLength();
            if (l2 == -1L) goto _L4; else goto _L3
_L3:
            apw1.b("Content-Length: ").k(l2).c(MultipartBuilder.CRLF);
_L6:
            apw1.c(MultipartBuilder.CRLF);
            if (flag)
            {
                l1 = l2 + l1;
            } else
            {
                ((RequestBody)partBodies.get(i)).writeTo(apw1);
            }
            apw1.c(MultipartBuilder.CRLF);
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
            apw1.c(MultipartBuilder.DASHDASH);
            apw1.b(boundary);
            apw1.c(MultipartBuilder.DASHDASH);
            apw1.c(MultipartBuilder.CRLF);
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

        public MultipartRequestBody(MediaType mediatype, apy apy1, List list, List list1)
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
    private final apy boundary;
    private final List partBodies;
    private final List partHeaders;
    private MediaType type;

    public MultipartBuilder()
    {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String s)
    {
        type = MIXED;
        partHeaders = new ArrayList();
        partBodies = new ArrayList();
        boundary = apy.a(s);
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
        } else
        {
            partHeaders.add(headers);
            partBodies.add(requestbody);
            return this;
        }
    }

    public MultipartBuilder addPart(RequestBody requestbody)
    {
        return addPart(null, requestbody);
    }

    public RequestBody build()
    {
        if (partHeaders.isEmpty())
        {
            throw new IllegalStateException("Multipart body must have at least one part.");
        } else
        {
            return new MultipartRequestBody(type, boundary, partHeaders, partBodies);
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




}
