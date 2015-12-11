// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.Headers;
import com.squareup.okhttp.internal.http.Request;
import com.squareup.okhttp.internal.http.Response;
import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.Okio;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            HttpResponseCache, Handshake

private static final class handshake
{

    private final Handshake handshake;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final String statusLine;
    private final String url;
    private final Headers varyHeaders;

    private boolean isHttps()
    {
        return url.startsWith("https://");
    }

    private List readCertificateList(BufferedSource bufferedsource)
        throws IOException
    {
        int j = HttpResponseCache.access$400(bufferedsource);
        if (j != -1) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist;
        CertificateFactory certificatefactory;
        int i;
        try
        {
            certificatefactory = CertificateFactory.getInstance("X.509");
            arraylist = new ArrayList(j);
        }
        // Misplaced declaration of an exception variable
        catch (BufferedSource bufferedsource)
        {
            throw new IOException(bufferedsource.getMessage());
        }
        i = 0;
        obj = arraylist;
        if (i >= j) goto _L4; else goto _L3
_L3:
        arraylist.add(certificatefactory.generateCertificate(new ByteArrayInputStream(ByteString.decodeBase64(bufferedsource.readUtf8Line(true)).toByteArray())));
        i++;
        break MISSING_BLOCK_LABEL_38;
    }

    private void writeCertArray(Writer writer, List list)
        throws IOException
    {
        String s;
        int i;
        int j;
        try
        {
            writer.write((new StringBuilder()).append(Integer.toString(list.size())).append('\n').toString());
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new IOException(writer.getMessage());
        }
        i = 0;
        j = list.size();
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = ByteString.of(((Certificate)list.get(i)).getEncoded()).base64();
        writer.write((new StringBuilder()).append(s).append('\n').toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean matches(Request request, Response response1)
    {
        return url.equals(request.urlString()) && requestMethod.equals(request.method()) && response1.varyMatches(varyHeaders, request);
    }

    public Response response(Request request, com.squareup.okhttp.internal.rs rs)
    {
        String s = responseHeaders.get("Content-Type");
        String s1 = responseHeaders.get("Content-Length");
        return (new com.squareup.okhttp.internal.http.s()).(request).ine(statusLine).(responseHeaders).s(new esponseBody(rs, s, s1)).ke(handshake).ke();
    }

    public void writeTo(com.squareup.okhttp.internal.ild ild)
        throws IOException
    {
        ild = new BufferedWriter(new OutputStreamWriter(ild.utputStream(0), Util.UTF_8));
        ild.write((new StringBuilder()).append(url).append('\n').toString());
        ild.write((new StringBuilder()).append(requestMethod).append('\n').toString());
        ild.write((new StringBuilder()).append(Integer.toString(varyHeaders.size())).append('\n').toString());
        for (int i = 0; i < varyHeaders.size(); i++)
        {
            ild.write((new StringBuilder()).append(varyHeaders.name(i)).append(": ").append(varyHeaders.value(i)).append('\n').toString());
        }

        ild.write((new StringBuilder()).append(statusLine).append('\n').toString());
        ild.write((new StringBuilder()).append(Integer.toString(responseHeaders.size())).append('\n').toString());
        for (int j = 0; j < responseHeaders.size(); j++)
        {
            ild.write((new StringBuilder()).append(responseHeaders.name(j)).append(": ").append(responseHeaders.value(j)).append('\n').toString());
        }

        if (isHttps())
        {
            ild.write(10);
            ild.write((new StringBuilder()).append(handshake.cipherSuite()).append('\n').toString());
            writeCertArray(ild, handshake.peerCertificates());
            writeCertArray(ild, handshake.localCertificates());
        }
        ild.close();
    }

    public itor(Response response1)
    {
        url = response1.request().urlString();
        varyHeaders = response1.request().headers().getAll(response1.getVaryFields());
        requestMethod = response1.request().method();
        statusLine = response1.statusLine();
        responseHeaders = response1.headers();
        handshake = response1.handshake();
    }

    public urce(InputStream inputstream)
        throws IOException
    {
        Object obj;
        Object obj1;
        int j;
        obj = Okio.buffer(Okio.source(inputstream));
        url = ((BufferedSource) (obj)).readUtf8Line(true);
        requestMethod = ((BufferedSource) (obj)).readUtf8Line(true);
        obj1 = new com.squareup.okhttp.internal.http.ine();
        j = HttpResponseCache.access$400(((BufferedSource) (obj)));
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((com.squareup.okhttp.internal.http.ine) (obj1)).ine(((BufferedSource) (obj)).readUtf8Line(true));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        varyHeaders = ((com.squareup.okhttp.internal.http.ine) (obj1)).ine();
        statusLine = ((BufferedSource) (obj)).readUtf8Line(true);
        obj1 = new com.squareup.okhttp.internal.http.ine();
        j = HttpResponseCache.access$400(((BufferedSource) (obj)));
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((com.squareup.okhttp.internal.http.ine) (obj1)).ine(((BufferedSource) (obj)).readUtf8Line(true));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        responseHeaders = ((com.squareup.okhttp.internal.http.s) (obj1)).s();
        if (!isHttps())
        {
            break MISSING_BLOCK_LABEL_241;
        }
        obj1 = ((BufferedSource) (obj)).readUtf8Line(true);
        if (((String) (obj1)).length() > 0)
        {
            throw new IOException((new StringBuilder()).append("expected \"\" but was \"").append(((String) (obj1))).append("\"").toString());
        }
        break MISSING_BLOCK_LABEL_212;
        obj;
        inputstream.close();
        throw obj;
        handshake = Handshake.get(((BufferedSource) (obj)).readUtf8Line(true), readCertificateList(((BufferedSource) (obj))), readCertificateList(((BufferedSource) (obj))));
_L5:
        inputstream.close();
        return;
        handshake = null;
          goto _L5
    }
}
