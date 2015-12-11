// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            DiskLruCache, RawHeaders, CacheUtils

public static final class ount
{

    String cipherSuite;
     currentEditor;
    private String key;
    private long lengths[];
    Certificate localCertificates[];
    Certificate peerCertificates[];
    private boolean readable;
    private String requestMethod;
    RawHeaders responseHeaders;
    private long sequenceNumber;
    private String uri;
    private RawHeaders varyHeaders;

    private IOException invalidLengths(String as[])
        throws IOException
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    private void setLengths(String as[])
        throws IOException
    {
        if (as.length != DiskLruCache.valueCount)
        {
            throw invalidLengths(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                lengths[i] = Long.parseLong(as[i]);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw invalidLengths(as);
            }
            i++;
        } while (true);
    }

    public File getCleanFile(int i)
    {
        return new File(DiskLruCache.directory, (new StringBuilder()).append(key).append(".").append(i).toString());
    }

    public File getDirtyFile(int i)
    {
        return new File(DiskLruCache.directory, (new StringBuilder()).append(key).append(".").append(i).append(".tmp").toString());
    }

    public String getLengths()
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = lengths;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }

    public void writeTo( , URI uri1, HttpURLConnection httpurlconnection)
        throws IOException
    {
        BufferedWriter bufferedwriter;
        bufferedwriter = new BufferedWriter(new OutputStreamWriter(.newOutputStream(0), Charset.forName("UTF-8")));
        bufferedwriter.write((new StringBuilder()).append(uri1.toString()).append('\n').toString());
        bufferedwriter.write((new StringBuilder()).append(httpurlconnection.getRequestMethod()).append('\n').toString());
        Object obj = httpurlconnection.getHeaderFields();
        HashMap hashmap = new HashMap();
         = new HashMap();
        Iterator iterator = ((Map) (obj)).keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if ("Vary".equalsIgnoreCase(s))
            {
                hashmap.put(s, ((Map) (obj)).get(s));
            } else
            if ((s == null || !s.startsWith("X-TwinPrime")) && !"Keep-Alive".equalsIgnoreCase(s))
            {
                .put(s, ((Map) (obj)).get(s));
            }
        } while (true);
        obj = RawHeaders.fromMultimap(hashmap, true);
        bufferedwriter.write((new StringBuilder()).append(Integer.toString(((RawHeaders) (obj)).length())).append('\n').toString());
        for (int i = 0; i < ((RawHeaders) (obj)).length(); i++)
        {
            bufferedwriter.write((new StringBuilder()).append(((RawHeaders) (obj)).getFieldName(i)).append(": ").append(((RawHeaders) (obj)).getValue(i)).append('\n').toString());
        }

         = RawHeaders.fromMultimap(, true);
        bufferedwriter.write((new StringBuilder()).append(.getStatusLine()).append('\n').toString());
        bufferedwriter.write((new StringBuilder()).append(Integer.toString(.length() + 1)).append('\n').toString());
        bufferedwriter.write("X-Android-Response-Source: CACHE 200\n");
        for (int j = 0; j < .length(); j++)
        {
            bufferedwriter.write((new StringBuilder()).append(.getFieldName(j)).append(": ").append(.getValue(j)).append('\n').toString());
        }

        if (!uri1.toString().startsWith("https")) goto _L2; else goto _L1
_L1:
        HttpsURLConnection httpsurlconnection;
        httpsurlconnection = (HttpsURLConnection)httpurlconnection;
        httpurlconnection = httpsurlconnection.getCipherSuite();
         = null;
        uri1 = httpsurlconnection.getServerCertificates();
         = uri1;
_L4:
        uri1 = httpsurlconnection.getLocalCertificates();
        bufferedwriter.write(10);
        bufferedwriter.write((new StringBuilder()).append(httpurlconnection).append('\n').toString());
        CacheUtils.writeCertArray(bufferedwriter, );
        CacheUtils.writeCertArray(bufferedwriter, uri1);
_L2:
        bufferedwriter.close();
        return;
        uri1;
        if (true) goto _L4; else goto _L3
_L3:
    }



/*
    static long access$1002( , long l)
    {
        .sequenceNumber = l;
        return l;
    }

*/



/*
    static boolean access$502(sequenceNumber sequencenumber, boolean flag)
    {
        sequencenumber.readable = flag;
        return flag;
    }

*/




    public readable(InputStream inputstream)
    {
        int j;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        uri = inputstream.readLine();
        requestMethod = inputstream.readLine();
        varyHeaders = new RawHeaders();
        j = Integer.parseInt(inputstream.readLine());
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        varyHeaders.addLine(inputstream.readLine());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        int k;
        responseHeaders = new RawHeaders();
        responseHeaders.setStatusLine(inputstream.readLine());
        k = Integer.parseInt(inputstream.readLine());
        boolean flag;
        flag = false;
        i = 0;
_L4:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = inputstream.readLine();
        if (((String) (obj)).startsWith("X-Android-Response-Source"))
        {
            flag = true;
        }
        responseHeaders.addLine(((String) (obj)));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        responseHeaders.addLine("X-Android-Response-Source: CACHE 200\n");
        if (!uri.startsWith("https"))
        {
            break MISSING_BLOCK_LABEL_290;
        }
        obj = inputstream.readLine();
        if (((String) (obj)).length() > 0)
        {
            throw new IOException((new StringBuilder()).append("expected \"\" but was \"").append(((String) (obj))).append("\"").toString());
        }
          goto _L5
        inputstream;
        inputstream.printStackTrace();
_L7:
        return;
_L5:
        cipherSuite = inputstream.readLine();
        peerCertificates = CacheUtils.readCertArray(inputstream);
        localCertificates = CacheUtils.readCertArray(inputstream);
_L9:
        obj = new StringBuilder();
_L8:
        String s = inputstream.readLine();
        if (s == null) goto _L7; else goto _L6
_L6:
        ((StringBuilder) (obj)).append(s);
          goto _L8
        cipherSuite = null;
        peerCertificates = null;
        localCertificates = null;
          goto _L9
    }

    public localCertificates(String s)
    {
        key = s;
        lengths = new long[DiskLruCache.valueCount];
    }
}
