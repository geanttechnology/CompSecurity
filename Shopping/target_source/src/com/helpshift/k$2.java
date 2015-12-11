// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.c.b;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            k

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
        Object obj1;
        Object obj2;
        Object obj3;
        obj3 = k.a(f, a, b, c);
        obj1 = new File((String)((HashMap) (obj3)).get("screenshot"));
        obj2 = com.helpshift.k.b(f, ((File) (obj1)).getPath());
        if (!(new HashSet(Arrays.asList(new String[] {
    "image/jpeg", "image/png", "image/gif", "image/x-png", "image/x-citrix-pjpeg", "image/x-citrix-gif", "image/pjpeg"
}))).contains(obj2))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("status", Integer.valueOf(-1));
            Message message = d.obtainMessage();
            message.obj = hashmap;
            e.sendMessage(message);
            return;
        }
        Object obj = new URL(k.a(f, b));
_L2:
        DataOutputStream dataoutputstream;
        try
        {
            obj = (HttpURLConnection)HttpInstrumentation.openConnection(((URL) (obj)).openConnection());
            ((HttpURLConnection) (obj)).setDoInput(true);
            ((HttpURLConnection) (obj)).setDoOutput(true);
            ((HttpURLConnection) (obj)).setUseCaches(false);
            ((HttpURLConnection) (obj)).setRequestMethod("POST");
            ((HttpURLConnection) (obj)).setConnectTimeout(30000);
            ((HttpURLConnection) (obj)).setReadTimeout(30000);
            ((HttpURLConnection) (obj)).setRequestProperty("Connection", "Keep-Alive");
            ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data;boundary=").append("*****").toString());
            dataoutputstream = new DataOutputStream(((HttpURLConnection) (obj)).getOutputStream());
            dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("\r\n").toString());
            Iterator iterator = (new ArrayList(((HashMap) (obj3)).keySet())).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (!s.equals("screenshot"))
                {
                    String s1 = (String)((HashMap) (obj3)).get(s);
                    dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"; ").append("\r\n").toString());
                    dataoutputstream.writeBytes((new StringBuilder()).append("Content-Type: text/plain;charset=UTF-8").append("\r\n").toString());
                    dataoutputstream.writeBytes((new StringBuilder()).append("Content-Length: ").append(s1.length()).append("\r\n").toString());
                    dataoutputstream.writeBytes("\r\n");
                    dataoutputstream.writeBytes((new StringBuilder()).append(s1).append("\r\n").toString());
                    dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("\r\n").toString());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            try
            {
                Log.d("HelpShiftDebug", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
                k.a(f, e, 2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("HelpShiftDebug", "Error : ", ((Throwable) (obj)));
            }
            k.a(f, e, 1);
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        Log.d("HelpShiftDebug", ((MalformedURLException) (obj)).getMessage(), ((Throwable) (obj)));
        k.a(f, e, 2);
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int i;
        int j;
        obj3 = new FileInputStream(((File) (obj1)));
        dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("\r\n").toString());
        dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"screenshot\"; filename=\"").append(((File) (obj1)).getName()).append("\"").append("\r\n").toString());
        dataoutputstream.writeBytes((new StringBuilder()).append("Content-Type: ").append(((String) (obj2))).append("\r\n").toString());
        dataoutputstream.writeBytes((new StringBuilder()).append("Content-Length: ").append(((File) (obj1)).length()).append("\r\n").toString());
        dataoutputstream.writeBytes("\r\n");
        i = Math.min(((FileInputStream) (obj3)).available(), 0x100000);
        abyte0 = new byte[i];
        j = ((FileInputStream) (obj3)).read(abyte0, 0, i);
_L3:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_801;
        }
        dataoutputstream.write(abyte0, 0, i);
        i = Math.min(((FileInputStream) (obj3)).available(), 0x100000);
        j = ((FileInputStream) (obj3)).read(abyte0, 0, i);
          goto _L3
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("--").append("\r\n").toString());
        ((FileInputStream) (obj3)).close();
        i = ((HttpURLConnection) (obj)).getResponseCode();
        ((HttpURLConnection) (obj)).getResponseMessage();
        abyte0 = new StringBuilder();
        obj2 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L4:
        obj3 = ((BufferedReader) (obj2)).readLine();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_932;
        }
        abyte0.append(((String) (obj3)));
          goto _L4
        IOException ioexception;
        ioexception;
        Log.d("HelpShiftDebug", "IO Exception ex", ioexception);
        k.a(f, e, 2);
        ioexception = abyte0.toString();
        abyte0 = new HashMap();
        abyte0.put("status", Integer.valueOf(i));
        if (i < 200 || i >= 300)
        {
            break MISSING_BLOCK_LABEL_1046;
        }
        abyte0.put("response", JSONArrayInstrumentation.init(ioexception));
_L5:
        ioexception = d.obtainMessage();
        ioexception.obj = abyte0;
        d.sendMessage(ioexception);
_L6:
        ((HttpURLConnection) (obj)).disconnect();
        dataoutputstream.flush();
        dataoutputstream.close();
        return;
        JSONException jsonexception1;
        jsonexception1;
        abyte0.put("response", JSONObjectInstrumentation.init(ioexception));
          goto _L5
        JSONException jsonexception;
        jsonexception;
        throw jsonexception;
        Message message1 = e.obtainMessage();
        message1.obj = abyte0;
        e.sendMessage(message1);
          goto _L6
    }

    (k k1, HashMap hashmap, String s, String s1, Handler handler, Handler handler1)
    {
        f = k1;
        a = hashmap;
        b = s;
        c = s1;
        d = handler;
        e = handler1;
        super();
    }
}
