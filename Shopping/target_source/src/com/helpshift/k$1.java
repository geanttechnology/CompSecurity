// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.c.b;
import com.helpshift.i.n;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            k, s

class init>
    implements Runnable
{

    final HashMap a;
    final String b;
    final String c;
    final Handler d;
    final Handler e;
    final k f;

    public void run()
    {
        Object obj;
        Object obj2;
        obj2 = new HashMap(a);
        obj = k.a(f, b);
        if (c != "GET") goto _L2; else goto _L1
_L1:
        String s1 = k.a(f, k.a(f, a, b, c));
        obj = (HttpURLConnection)HttpInstrumentation.openConnection((new URL((new StringBuilder()).append(((String) (obj))).append("?").append(s1).toString())).openConnection());
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        k.a(((HttpURLConnection) (obj)));
        s1 = k.a(f).s(b);
        if (!TextUtils.isEmpty(s1))
        {
            ((HttpURLConnection) (obj)).setRequestProperty("If-None-Match", s1);
        }
_L10:
        Object obj3;
        int i;
        i = ((HttpURLConnection) (obj)).getResponseCode();
        obj3 = ((HttpURLConnection) (obj)).getHeaderFields().entrySet();
        Iterator iterator = ((Set) (obj3)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Entry entry = (java.util.Entry)iterator.next();
            if (entry.getKey() != null && ((String)entry.getKey()).equals("ETag"))
            {
                k.a(f).e(b, (String)((List)entry.getValue()).get(0));
            }
        } while (true);
          goto _L3
_L2:
        Object obj1;
        IOException ioexception;
        StringBuilder stringbuilder;
        Object obj4;
        java.util.Entry entry1;
        if (c == "POST")
        {
            List list = com.helpshift.k.b(f, k.a(f, a, b, c));
            obj = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(((String) (obj)))).openConnection());
            ((HttpURLConnection) (obj)).setRequestMethod("POST");
            ((HttpURLConnection) (obj)).setDoOutput(true);
            ((HttpURLConnection) (obj)).setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            k.a(((HttpURLConnection) (obj)));
            obj3 = ((HttpURLConnection) (obj)).getOutputStream();
            BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(((OutputStream) (obj3)), "UTF-8"));
            bufferedwriter.write(k.a(list));
            bufferedwriter.flush();
            bufferedwriter.close();
            ((OutputStream) (obj3)).close();
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder = new StringBuilder();
        if (i < 200 || i >= 300)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        obj1 = new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream());
        obj4 = ((Set) (obj3)).iterator();
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            entry1 = (java.util.Entry)((Iterator) (obj4)).next();
            if (entry1.getKey() != null && ((String)entry1.getKey()).equals("Content-Encoding") && ((String)((List)entry1.getValue()).get(0)).equalsIgnoreCase("gzip"))
            {
                obj1 = new GZIPInputStream(((java.io.InputStream) (obj1)));
            }
        } while (true);
        obj1 = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj1))));
_L4:
        obj4 = ((BufferedReader) (obj1)).readLine();
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_586;
        }
        stringbuilder.append(((String) (obj4)));
          goto _L4
        ioexception;
        Log.d("HelpShiftDebug", "IO Exception ex", ioexception);
        ioexception = new HashMap();
        ioexception.put("status", Integer.valueOf(i));
        if (i < 200 || i >= 300) goto _L6; else goto _L5
_L5:
        try
        {
            k.a(0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            try
            {
                k.a(f, e, 1);
                Log.d("HelpShiftDebug", "Exception JSON", ((Throwable) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("HelpShiftDebug", "install() not called", ((Throwable) (obj)));
                k.a(f, e, 1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("HelpShiftDebug", "Exception Malformed URL", ((Throwable) (obj)));
                k.a(f, e, 1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("HelpShiftDebug", "Exception Protocol", ((Throwable) (obj)));
                k.a(f, e, 1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("HelpShiftDebug", "Exception Unknown Host", ((Throwable) (obj)));
                k.a(f, e, 3);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj)));
            }
            k.a(f, e, 1);
            return;
        }
        ioexception.put("response", JSONArrayInstrumentation.init(stringbuilder.toString()));
_L7:
        obj2 = d.obtainMessage();
        obj2.obj = ioexception;
        d.sendMessage(((Message) (obj2)));
_L8:
        ((HttpURLConnection) (obj)).disconnect();
        return;
        obj;
        k.a(f, e, 3);
        Log.d("HelpShiftDebug", "Exception Unknown Host", ((Throwable) (obj)));
        return;
        obj2;
        ioexception.put("response", JSONObjectInstrumentation.init(stringbuilder.toString()));
          goto _L7
        obj;
        throw obj;
        obj;
        k.a(f, e, 0);
        Log.d("HelpShiftDebug", "Exception cannot connect Host", ((Throwable) (obj)));
        return;
_L6:
        if (i != 304)
        {
            break MISSING_BLOCK_LABEL_863;
        }
        k.a();
        ioexception = d.obtainMessage();
        ioexception.obj = null;
        d.sendMessage(ioexception);
          goto _L8
        obj;
        Log.d("HelpShiftDebug", "Exception Socket timeout", ((Throwable) (obj)));
        return;
        if (i != 422)
        {
            break MISSING_BLOCK_LABEL_1124;
        }
        k.a();
        if (com.helpshift.k.b() > 3)
        {
            break MISSING_BLOCK_LABEL_1046;
        }
        ioexception = ((Set) (obj3)).iterator();
        while (ioexception.hasNext()) 
        {
            obj3 = (java.util.Entry)ioexception.next();
            if (((java.util.Entry) (obj3)).getKey() != null && ((String)((java.util.Entry) (obj3)).getKey()).equals("HS-UEpoch"))
            {
                k.a(f).a(n.a((String)((List)((java.util.Entry) (obj3)).getValue()).get(0)));
                k.a(f, c, b, ((HashMap) (obj2)), d, e);
            }
        }
          goto _L8
        obj;
        k.a(f, e, 0);
        Log.d("HelpShiftDebug", "Exception Socket timeout", ((Throwable) (obj)));
        return;
        k.a(0);
        obj2 = e.obtainMessage();
        obj2.obj = ioexception;
        e.sendMessage(((Message) (obj2)));
          goto _L8
        obj;
        k.a(f, e, 1);
        Log.d("HelpShiftDebug", "Exception Client Protocol", ((Throwable) (obj)));
        return;
        k.a(0);
        obj2 = e.obtainMessage();
        obj2.obj = ioexception;
        e.sendMessage(((Message) (obj2)));
          goto _L8
        obj;
        Log.d("HelpShiftDebug", "Exception SSL Peer Unverified", ((Throwable) (obj)));
        return;
        obj;
        k.a(f, e, 1);
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj)));
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    (k k1, HashMap hashmap, String s1, String s2, Handler handler, Handler handler1)
    {
        f = k1;
        a = hashmap;
        b = s1;
        c = s2;
        d = handler;
        e = handler1;
        super();
    }
}
