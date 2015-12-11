// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.SyncFailedException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.smule.android.network.core:
//            s, j

public class r
{

    private static final String a = com/smule/android/network/core/r.getName();

    public r()
    {
    }

    public static BroadcastReceiver a(Context context, Runnable runnable)
    {
        runnable = new BroadcastReceiver(runnable) {

            final Runnable a;

            public void onReceive(Context context1, Intent intent)
            {
                Log.i(r.a(), "Network connectivity changed.");
                if (r.a(context1))
                {
                    Log.i(r.a(), "Network just connected");
                    a.run();
                }
            }

            
            {
                a = runnable;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(runnable, intentfilter);
        return runnable;
    }

    static String a()
    {
        return a;
    }

    public static String a(String s1, String s2, long l, String s3, String s4)
    {
        Object obj = null;
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        messagedigest.update(s1.getBytes("UTF-8"));
        messagedigest.update(s2.getBytes("UTF-8"));
        messagedigest.update(String.valueOf(l).getBytes("UTF-8"));
        messagedigest.update(s3.getBytes("UTF-8"));
        s1 = messagedigest;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        messagedigest.update(s4.getBytes("UTF-8"));
        s1 = messagedigest;
_L1:
        s2 = obj;
        if (s1 != null)
        {
            s2 = a(s1.digest());
        }
        return s2;
        s2;
        s1 = null;
_L3:
        Log.e(a, "Couldn't get response digest", s2);
          goto _L1
        s2;
        s1 = null;
_L2:
        Log.e(a, "Couldn't get response digest", s2);
          goto _L1
        s2;
        s1 = messagedigest;
          goto _L2
        s2;
        s1 = messagedigest;
          goto _L3
    }

    private static String a(String s1, String s2, String s3, int i)
    {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        byte abyte0[] = new byte[40];
        messagedigest.update(s2.getBytes("UTF-8"));
        if (i == 2)
        {
            messagedigest.update(s3.getBytes("UTF-8"));
        }
        messagedigest.update(s1.getBytes("UTF-8"));
        return a(messagedigest.digest());
    }

    public static String a(List list, String s1, String s2, int i, String s3)
    {
        StringBuilder stringbuilder;
        Collections.sort(list, new Comparator() {

            public int a(NameValuePair namevaluepair1, NameValuePair namevaluepair2)
            {
                return namevaluepair1.getName().compareTo(namevaluepair2.getName());
            }

            public int compare(Object obj, Object obj1)
            {
                return a((NameValuePair)obj, (NameValuePair)obj1);
            }

        });
        stringbuilder = new StringBuilder();
        NameValuePair namevaluepair;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)list.next();
            if (i == 2)
            {
                stringbuilder.append(namevaluepair.getName());
            }
        }

        if (s3 != null)
        {
            stringbuilder.append(s3);
        }
        list = a(stringbuilder.toString(), s1, s2, i);
        return list;
        list;
        Log.e(a, "Couldn't get digest", list);
_L2:
        return null;
        list;
        Log.e(a, "Couldn't handle UTF-8", list);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String a(HttpResponse httpresponse)
    {
        return a(httpresponse, ((s) (null)));
    }

    public static String a(HttpResponse httpresponse, s s1)
    {
        String s2 = "";
        if (httpresponse.getEntity() != null) goto _L2; else goto _L1
_L1:
        httpresponse = s2;
_L3:
        return httpresponse;
_L2:
        StringBuffer stringbuffer;
        char ac[];
        httpresponse = new BufferedReader(new InputStreamReader(httpresponse.getEntity().getContent()));
        stringbuffer = new StringBuffer("");
        ac = new char[4096];
_L4:
        int i = httpresponse.read(ac, 0, ac.length);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (Thread.currentThread().isInterrupted())
        {
            httpresponse.close();
            throw new RuntimeException("API call canceled during read.");
        }
        break MISSING_BLOCK_LABEL_128;
        try
        {
            httpresponse.close();
            httpresponse = stringbuffer.toString();
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            Log.e(a, "Error reading body", httpresponse);
            httpresponse = s2;
        }
        if (Thread.interrupted())
        {
            throw new RuntimeException("API call canceled after read.");
        }
          goto _L3
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        l = i;
        s1.b(l);
        s1.a();
        stringbuffer.append(ac, 0, i);
          goto _L4
    }

    private static String a(byte abyte0[])
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer();
        i = 0;
_L2:
        int k;
        int l;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        l = abyte0[i] >>> 4 & 0xf;
        k = 0;
_L3:
        if (l >= 0 && l <= 9)
        {
            stringbuffer.append((char)(l + 48));
        } else
        {
            stringbuffer.append((char)((l - 10) + 97));
        }
        l = abyte0[i];
        if (k < 1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuffer.toString();
        k++;
        l &= 0xf;
          goto _L3
    }

    private static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    private static void a(OutputStream outputstream)
    {
        outputstream.flush();
        try
        {
            if (outputstream instanceof FileOutputStream)
            {
                ((FileOutputStream)outputstream).getFD().sync();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            return;
        }
    }

    public static boolean a(Context context)
    {
        context = ((ConnectivityManager)context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    public static boolean a(j j1, OutputStream outputstream, s s1)
    {
        if (s1 != null)
        {
            s1.a(j1.d);
        }
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(outputstream);
        Object obj = bufferedoutputstream;
        byte abyte0[] = new byte[4096];
_L2:
        obj = bufferedoutputstream;
        int i = j1.c.read(abyte0);
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = bufferedoutputstream;
        bufferedoutputstream.flush();
        obj = bufferedoutputstream;
        a(outputstream);
        a(((Closeable) (bufferedoutputstream)));
        a(((Closeable) (outputstream)));
        a(((Closeable) (j1.c)));
        return true;
        long l;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        l = i;
        obj = bufferedoutputstream;
        s1.b(l);
        obj = bufferedoutputstream;
        s1.a();
        obj = bufferedoutputstream;
        bufferedoutputstream.write(abyte0, 0, i);
        obj = bufferedoutputstream;
        if (!Thread.currentThread().isInterrupted()) goto _L2; else goto _L1
_L1:
        obj = bufferedoutputstream;
        j1.a.abort();
        Object obj1;
        obj = bufferedoutputstream;
        boolean flag;
        try
        {
            throw new RuntimeException("Server call canceled during read.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s1 = bufferedoutputstream;
        }
        finally { }
        obj1 = obj;
_L4:
        obj = s1;
        obj1 = ((IOException) (obj1)).getMessage();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        obj = s1;
        flag = ((String) (obj1)).startsWith("No space");
        if (flag)
        {
            a(((Closeable) (s1)));
            a(((Closeable) (outputstream)));
            a(((Closeable) (j1.c)));
            return false;
        }
        a(((Closeable) (s1)));
        a(((Closeable) (outputstream)));
        a(((Closeable) (j1.c)));
        return false;
        s1;
        obj = null;
        a(((Closeable) (obj)));
        a(((Closeable) (outputstream)));
        a(((Closeable) (j1.c)));
        throw s1;
        obj1;
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void b(Context context, Runnable runnable)
    {
        if (a(context))
        {
            runnable.run();
        }
        a(context, runnable);
    }

}
