// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.io.File;
import java.io.FileOutputStream;
import java.net.SocketTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, n, y, az, 
//            ad

public class bi extends bf
{

    n a;
    File b;
    Context c;
    boolean d;

    public bi(bf.a a1, Context context, n n1)
    {
        super(a1);
        a = n1;
        c = context;
        d = false;
    }

    private void h()
    {
        Object obj;
        FileOutputStream fileoutputstream;
        Object obj2;
        FileOutputStream fileoutputstream1;
        Object obj3;
        String s;
        boolean flag1;
        flag1 = false;
        if (a.s() == null)
        {
            a(bf.b.b);
            return;
        }
        obj3 = null;
        s = null;
        fileoutputstream1 = null;
        fileoutputstream = fileoutputstream1;
        obj2 = obj3;
        obj = s;
        b = y.a(c.getFilesDir(), "survey-image");
        fileoutputstream = fileoutputstream1;
        obj2 = obj3;
        obj = s;
        fileoutputstream1 = c.openFileOutput(b.getName(), 32769);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        obj3 = new BasicHttpParams();
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj3)), 18000);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj3)), 18000);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        ((HttpParams) (obj3)).setBooleanParameter("http.protocol.expect-continue", false);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        ((HttpParams) (obj3)).setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        obj3 = new DefaultHttpClient(((HttpParams) (obj3)));
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        s = a.s().c();
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        HttpGet httpget = new HttpGet(s);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        ae.a(httpget, s);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        ((HttpClient) (obj3)).execute(httpget).getEntity().writeTo(fileoutputstream1);
        fileoutputstream = fileoutputstream1;
        obj2 = fileoutputstream1;
        obj = fileoutputstream1;
        d = true;
        boolean flag;
        flag = flag1;
        if (fileoutputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        fileoutputstream1.close();
        flag = flag1;
_L2:
        Object obj1;
        if (!d)
        {
            if (flag)
            {
                a(bf.b.f);
                return;
            } else
            {
                a(bf.b.c);
                return;
            }
        } else
        {
            a.s().a(b);
            a(bf.b.b);
            return;
        }
        obj2;
        obj = fileoutputstream;
        ad.a("Timeout Downloading Image: ", ((Throwable) (obj2)));
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = obj2;
        ad.a("Error Downloading Image: ", ((Throwable) (obj1)));
        flag = flag1;
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            ((FileOutputStream) (obj2)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        obj1;
        Exception exception;
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            catch (Exception exception1) { }
        }
        throw obj1;
        exception;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void e()
    {
        h();
    }

    protected void f()
    {
    }

    protected void g()
    {
        h();
    }

    public String toString()
    {
        return "Download Survey";
    }
}
