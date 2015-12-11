// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

// Referenced classes of package com.paypal.android.sdk:
//            ai, au, at, dd

public class an
    implements ai
{

    private static int d = 60000;
    private static int e = 60000;
    private byte a[];
    private Uri b;
    private Map c;

    public an()
    {
        a = null;
        b = null;
        c = null;
    }

    public final int a(byte abyte0[])
    {
        ByteArrayOutputStream bytearrayoutputstream = null;
        Object obj;
        Object obj1;
        Object obj2;
        obj = new URL(b.toString());
        obj2 = au.a();
        obj1 = SSLContext.getInstance("TLS");
        obj2 = new at(((au) (obj2)));
        obj = (HttpsURLConnection)((URL) (obj)).openConnection();
        ((HttpsURLConnection) (obj)).setReadTimeout(e);
        ((HttpsURLConnection) (obj)).setConnectTimeout(d);
        ((HttpsURLConnection) (obj)).setRequestMethod("POST");
        ((HttpsURLConnection) (obj)).setDoInput(true);
        ((HttpsURLConnection) (obj)).setDoOutput(true);
        ((SSLContext) (obj1)).init(null, new TrustManager[] {
            obj2
        }, null);
        ((HttpsURLConnection) (obj)).setSSLSocketFactory(((SSLContext) (obj1)).getSocketFactory());
        for (obj1 = c.entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((HttpsURLConnection) (obj)).setRequestProperty(((java.util.Map.Entry) (obj2)).getKey().toString(), ((java.util.Map.Entry) (obj2)).getValue().toString()))
        {
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

          goto _L1
        abyte0;
        Object obj4 = null;
        obj1 = obj;
        obj2 = bytearrayoutputstream;
        obj = obj4;
_L8:
        dd.a(((java.io.Closeable) (obj2)));
        dd.a(((java.io.Closeable) (obj)));
        if (obj1 != null)
        {
            ((HttpsURLConnection) (obj1)).disconnect();
        }
        throw abyte0;
_L1:
        ((HttpsURLConnection) (obj)).setFixedLengthStreamingMode(abyte0.length);
        obj1 = ((HttpsURLConnection) (obj)).getOutputStream();
        int i;
        ((OutputStream) (obj1)).write(abyte0);
        ((OutputStream) (obj1)).flush();
        i = ((HttpsURLConnection) (obj)).getResponseCode();
        if (i != 200) goto _L3; else goto _L2
_L2:
        obj2 = new BufferedInputStream(((HttpsURLConnection) (obj)).getInputStream());
        abyte0 = new byte[1024];
        bytearrayoutputstream = new ByteArrayOutputStream();
_L4:
        int j = ((BufferedInputStream) (obj2)).read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        bytearrayoutputstream.write(abyte0, 0, j);
          goto _L4
        a = bytearrayoutputstream.toByteArray();
_L6:
        dd.a(((java.io.Closeable) (obj2)));
        dd.a(((java.io.Closeable) (obj1)));
        if (obj != null)
        {
            ((HttpsURLConnection) (obj)).disconnect();
        }
        return i;
_L3:
        a = new byte[0];
        obj2 = null;
        if (true) goto _L6; else goto _L5
_L5:
        abyte0;
        obj = null;
        obj1 = null;
        obj2 = bytearrayoutputstream;
        continue; /* Loop/switch isn't completed */
        abyte0;
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
        obj2 = bytearrayoutputstream;
        continue; /* Loop/switch isn't completed */
        abyte0;
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void a(Uri uri)
    {
        b = uri;
    }

    public final void a(Map map)
    {
        c = map;
    }

    public final byte[] a()
    {
        return a;
    }

    static 
    {
        com/paypal/android/sdk/an.getSimpleName();
    }
}
