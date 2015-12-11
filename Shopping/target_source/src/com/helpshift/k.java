// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.c.b;
import com.helpshift.i.n;
import com.helpshift.i.s;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            s

public final class k
{

    private static int j = 0;
    final String a = "/api/lib/";
    final String b = "https://";
    final String c = "Did not accept the solution";
    final String d = "Accepted the solution";
    final String e = "Accepted review request";
    final String f = "Screenshot sent";
    final String g;
    final String h;
    final String i;
    private com.helpshift.s k;

    protected k(String s1, String s2, String s3, com.helpshift.s s4)
    {
        h = s1;
        g = s2;
        i = s3;
        k = s4;
    }

    static int a()
    {
        int l = j;
        j = l + 1;
        return l;
    }

    static int a(int l)
    {
        j = l;
        return l;
    }

    static com.helpshift.s a(k k1)
    {
        return k1.k;
    }

    static String a(k k1, String s1)
        throws b
    {
        return k1.c(s1);
    }

    static String a(k k1, HashMap hashmap)
    {
        return k1.a(hashmap);
    }

    private String a(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if (obj instanceof ArrayList)
        {
            obj = new JSONArray((ArrayList)obj);
            if (!(obj instanceof JSONArray))
            {
                obj = ((JSONArray) (obj)).toString();
            } else
            {
                obj = JSONArrayInstrumentation.toString((JSONArray)obj);
            }
            return ((String) (obj));
        } else
        {
            return null;
        }
    }

    private String a(String s1)
        throws GeneralSecurityException, b
    {
        Object obj = i;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new b("apiKey Missing");
        }
        try
        {
            obj = new SecretKeySpec(((String) (obj)).getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(((java.security.Key) (obj)));
            s1 = a(mac.doFinal(s1.getBytes("UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new GeneralSecurityException(s1);
        }
        return s1;
    }

    private String a(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        String s1;
        for (Iterator iterator = (new ArrayList(hashmap.keySet())).iterator(); iterator.hasNext(); arraylist.add(new String((new StringBuilder()).append(s1).append("=").append(Uri.encode((String)hashmap.get(s1))).toString())))
        {
            s1 = (String)iterator.next();
        }

        return TextUtils.join("&", arraylist);
    }

    static String a(List list)
    {
        return b(list);
    }

    private String a(byte abyte0[])
    {
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        char ac1[] = new char[abyte0.length * 2];
        for (int l = 0; l < abyte0.length; l++)
        {
            int i1 = abyte0[l] & 0xff;
            ac1[l * 2] = ac[i1 >>> 4];
            ac1[l * 2 + 1] = ac[i1 & 0xf];
        }

        return new String(ac1);
    }

    static HashMap a(k k1, HashMap hashmap, String s1, String s2)
        throws b
    {
        return k1.a(hashmap, s1, s2);
    }

    private HashMap a(HashMap hashmap, String s1, String s2)
        throws b
    {
        s1 = b(s1);
        if (TextUtils.isEmpty(g))
        {
            throw new b("appId Missing");
        }
        hashmap.put("platform-id", g);
        hashmap.put("method", s2);
        hashmap.put("uri", s1);
        hashmap.put("timestamp", n.a(k.G()));
        s2 = new ArrayList(hashmap.keySet());
        s1 = new ArrayList();
        Collections.sort(s2);
        s2 = s2.iterator();
        do
        {
            if (!s2.hasNext())
            {
                break;
            }
            String s3 = (String)s2.next();
            if (s3 != "screenshot" && s3 != "meta")
            {
                String s4 = a(hashmap.get(s3));
                if (s4 != null)
                {
                    s1.add(new String((new StringBuilder()).append(s3).append("=").append(s4).toString()));
                }
            }
        } while (true);
        try
        {
            hashmap.put("signature", a(TextUtils.join("&", s1)));
            hashmap.remove("method");
            hashmap.remove("uri");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", (new StringBuilder()).append("Could not generate signature: ").append(s1.getLocalizedMessage()).toString(), s1);
            return hashmap;
        }
        return hashmap;
    }

    private void a(Handler handler, int l)
    {
        Message message = handler.obtainMessage();
        HashMap hashmap = new HashMap();
        hashmap.put("status", Integer.valueOf(l));
        message.obj = hashmap;
        handler.sendMessage(message);
    }

    static void a(k k1, Handler handler, int l)
    {
        k1.a(handler, l);
    }

    static void a(k k1, String s1, String s2, HashMap hashmap, Handler handler, Handler handler1)
    {
        k1.a(s1, s2, hashmap, handler, handler1);
    }

    private void a(String s1, String s2, HashMap hashmap, Handler handler, Handler handler1)
    {
        (new Thread(new Runnable(hashmap, s2, s1, handler, handler1) {

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
                String s3 = k.a(f, k.a(f, a, b, c));
                obj = (HttpURLConnection)HttpInstrumentation.openConnection((new URL((new StringBuilder()).append(((String) (obj))).append("?").append(s3).toString())).openConnection());
                ((HttpURLConnection) (obj)).setRequestMethod("GET");
                k.a(((HttpURLConnection) (obj)));
                s3 = k.a(f).s(b);
                if (!TextUtils.isEmpty(s3))
                {
                    ((HttpURLConnection) (obj)).setRequestProperty("If-None-Match", s3);
                }
_L10:
                Object obj3;
                int l;
                l = ((HttpURLConnection) (obj)).getResponseCode();
                obj3 = ((HttpURLConnection) (obj)).getHeaderFields().entrySet();
                Iterator iterator = ((Set) (obj3)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
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
                java.util.Map.Entry entry1;
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
                if (l < 200 || l >= 300)
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
                    entry1 = (java.util.Map.Entry)((Iterator) (obj4)).next();
                    if (entry1.getKey() != null && ((String)entry1.getKey()).equals("Content-Encoding") && ((String)((List)entry1.getValue()).get(0)).equalsIgnoreCase("gzip"))
                    {
                        obj1 = new GZIPInputStream(((InputStream) (obj1)));
                    }
                } while (true);
                obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj1))));
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
                ioexception.put("status", Integer.valueOf(l));
                if (l < 200 || l >= 300) goto _L6; else goto _L5
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
                if (l != 304)
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
                if (l != 422)
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
                    obj3 = (java.util.Map.Entry)ioexception.next();
                    if (((java.util.Map.Entry) (obj3)).getKey() != null && ((String)((java.util.Map.Entry) (obj3)).getKey()).equals("HS-UEpoch"))
                    {
                        k.a(f).a(n.a((String)((List)((java.util.Map.Entry) (obj3)).getValue()).get(0)));
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

            
            {
                f = k.this;
                a = hashmap;
                b = s1;
                c = s2;
                d = handler;
                e = handler1;
                super();
            }
        })).start();
    }

    static void a(HttpURLConnection httpurlconnection)
    {
        b(httpurlconnection);
    }

    static int b()
    {
        return j;
    }

    static String b(k k1, String s1)
    {
        return k1.d(s1);
    }

    private String b(String s1)
    {
        return new String((new StringBuilder()).append("/api/lib/2").append(s1).toString());
    }

    private static String b(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        list = list.iterator();
        boolean flag = true;
        while (list.hasNext()) 
        {
            NameValuePair namevaluepair = (NameValuePair)list.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("&");
            }
            try
            {
                stringbuilder.append(URLEncoder.encode(namevaluepair.getName(), "UTF-8"));
                stringbuilder.append("=");
                stringbuilder.append(URLEncoder.encode(namevaluepair.getValue(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.d("HelpShiftDebug", "Exception Unsupported Encoding", unsupportedencodingexception);
            }
        }
        return stringbuilder.toString();
    }

    static List b(k k1, HashMap hashmap)
    {
        return k1.b(hashmap);
    }

    private List b(HashMap hashmap)
    {
        Object obj = new ArrayList(hashmap.keySet());
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj)).next();
            String s2 = a(hashmap.get(s1));
            if (s2 != null)
            {
                arraylist.add(new BasicNameValuePair(s1, s2));
            }
        } while (true);
        return arraylist;
    }

    private void b(String s1, String s2, HashMap hashmap, Handler handler, Handler handler1)
    {
        (new Thread(new Runnable(hashmap, s2, s1, handler, handler1) {

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
                    HashMap hashmap1 = new HashMap();
                    hashmap1.put("status", Integer.valueOf(-1));
                    Message message = d.obtainMessage();
                    message.obj = hashmap1;
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
                        String s3 = (String)iterator.next();
                        if (!s3.equals("screenshot"))
                        {
                            String s4 = (String)((HashMap) (obj3)).get(s3);
                            dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s3).append("\"; ").append("\r\n").toString());
                            dataoutputstream.writeBytes((new StringBuilder()).append("Content-Type: text/plain;charset=UTF-8").append("\r\n").toString());
                            dataoutputstream.writeBytes((new StringBuilder()).append("Content-Length: ").append(s4.length()).append("\r\n").toString());
                            dataoutputstream.writeBytes("\r\n");
                            dataoutputstream.writeBytes((new StringBuilder()).append(s4).append("\r\n").toString());
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
                int l;
                int i1;
                obj3 = new FileInputStream(((File) (obj1)));
                dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("\r\n").toString());
                dataoutputstream.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"screenshot\"; filename=\"").append(((File) (obj1)).getName()).append("\"").append("\r\n").toString());
                dataoutputstream.writeBytes((new StringBuilder()).append("Content-Type: ").append(((String) (obj2))).append("\r\n").toString());
                dataoutputstream.writeBytes((new StringBuilder()).append("Content-Length: ").append(((File) (obj1)).length()).append("\r\n").toString());
                dataoutputstream.writeBytes("\r\n");
                l = Math.min(((FileInputStream) (obj3)).available(), 0x100000);
                abyte0 = new byte[l];
                i1 = ((FileInputStream) (obj3)).read(abyte0, 0, l);
_L3:
                if (i1 <= 0)
                {
                    break MISSING_BLOCK_LABEL_801;
                }
                dataoutputstream.write(abyte0, 0, l);
                l = Math.min(((FileInputStream) (obj3)).available(), 0x100000);
                i1 = ((FileInputStream) (obj3)).read(abyte0, 0, l);
                  goto _L3
                dataoutputstream.writeBytes("\r\n");
                dataoutputstream.writeBytes((new StringBuilder()).append("--").append("*****").append("--").append("\r\n").toString());
                ((FileInputStream) (obj3)).close();
                l = ((HttpURLConnection) (obj)).getResponseCode();
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
                abyte0.put("status", Integer.valueOf(l));
                if (l < 200 || l >= 300)
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

            
            {
                f = k.this;
                a = hashmap;
                b = s1;
                c = s2;
                d = handler;
                e = handler1;
                super();
            }
        })).start();
    }

    private static void b(HttpURLConnection httpurlconnection)
    {
        String s1 = (new StringBuilder()).append("Helpshift-Android/3.9.1/").append(android.os.Build.VERSION.RELEASE).toString();
        String s2 = String.format("%s;q=1.0", new Object[] {
            s.a()
        });
        httpurlconnection.setConnectTimeout(5000);
        httpurlconnection.setRequestProperty("http.useragent", s1);
        httpurlconnection.setRequestProperty("Accept-Language", s2);
        httpurlconnection.setRequestProperty("Accept-Encoding", "gzip");
        httpurlconnection.setRequestProperty("X-HS-V", "Helpshift-Android/3.9.1");
    }

    private String c(String s1)
        throws b
    {
        if (TextUtils.isEmpty(h))
        {
            throw new b("domain Missing");
        } else
        {
            return new String((new StringBuilder()).append("https://").append(h).append(b(s1)).toString());
        }
    }

    private String d(String s1)
    {
        Object obj;
        FileInputStream fileinputstream;
        fileinputstream = new FileInputStream(s1);
        obj = URLConnection.guessContentTypeFromStream(fileinputstream);
        if (obj != null) goto _L2; else goto _L1
_L1:
        try
        {
            s1 = URLConnection.guessContentTypeFromName(s1);
        }
        catch (IOException ioexception)
        {
            s1 = ((String) (obj));
            obj = ioexception;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        fileinputstream.close();
        return s1;
        obj;
        s1 = null;
_L3:
        ((IOException) (obj)).printStackTrace();
        return s1;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        s1 = ((String) (obj));
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void a(Handler handler, Handler handler1)
    {
        a("GET", "/faqs/", new HashMap(), handler, handler1);
    }

    protected void a(Handler handler, Handler handler1, String s1)
    {
        HashMap hashmap = new HashMap();
        a("POST", new String((new StringBuilder()).append("/faqs/").append(s1).append("/helpful/").toString()), hashmap, handler, handler1);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("token", s1);
        hashmap.put("profile-id", s2);
        a("POST", "/update-ua-token/", hashmap, handler, handler1);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("profile-id", s1);
        hashmap.put("message-text", s2);
        hashmap.put("meta", s3);
        a("POST", "/issues/", hashmap, handler, handler1);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("displayname", s1);
        hashmap.put("email", s2);
        hashmap.put("identifier", s3);
        if (s4 != null)
        {
            hashmap.put("crittercism-id", s4);
        }
        a("POST", "/profiles/", hashmap, handler, handler1);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        HashMap hashmap = new HashMap();
        if (s4 != "ca") goto _L2; else goto _L1
_L1:
        s3 = "Accepted the solution";
_L4:
        hashmap.put("profile-id", s1);
        hashmap.put("message-text", s3);
        hashmap.put("type", s4);
        hashmap.put("refers", s5);
        hashmap.put("message-meta", s6);
        a("POST", new String((new StringBuilder()).append("/issues/").append(s2).append("/messages/").toString()), hashmap, handler, handler1);
        return;
_L2:
        if (s4 == "ncr")
        {
            s3 = "Did not accept the solution";
        } else
        if (s4 == "ar")
        {
            s3 = "Accepted review request";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(Handler handler, Handler handler1, HashMap hashmap)
    {
        a("POST", "/events/", hashmap, handler, handler1);
    }

    protected void a(Integer integer, String s1, String s2, Handler handler, Handler handler1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("rating", (new StringBuilder()).append("").append(integer).toString());
        if (!TextUtils.isEmpty(s1))
        {
            hashmap.put("feedback", s1);
        }
        a("POST", (new StringBuilder()).append("/issues/").append(s2).append("/customer-survey/").toString(), hashmap, handler, handler1);
    }

    protected void a(String s1, Handler handler, Handler handler1)
    {
        HashMap hashmap = new HashMap();
        a("GET", (new StringBuilder()).append("/faqs/").append(s1).append("/").toString(), hashmap, handler, handler1);
    }

    protected void a(JSONArray jsonarray, String s1, String s2, Handler handler, Handler handler1)
    {
        HashMap hashmap = new HashMap();
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        hashmap.put("message-ids", jsonarray);
        hashmap.put("source", s1);
        hashmap.put("read-at", s2);
        a("POST", "/events/messages/seen/", hashmap, handler, handler1);
    }

    protected void b(Handler handler, Handler handler1)
    {
        a("GET", "/config/", new HashMap(), handler, handler1);
    }

    protected void b(Handler handler, Handler handler1, String s1)
    {
        HashMap hashmap = new HashMap();
        a("POST", new String((new StringBuilder()).append("/faqs/").append(s1).append("/unhelpful/").toString()), hashmap, handler, handler1);
    }

    protected void b(Handler handler, Handler handler1, String s1, String s2, String s3, String s4)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("profile-id", s1);
        hashmap.put("since", s2);
        hashmap.put("mc", s3);
        if (s4 != null)
        {
            hashmap.put("chat-launch-source", s4);
        }
        a("POST", "/my-issues/", hashmap, handler, handler1);
    }

    protected void b(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        HashMap hashmap = new HashMap();
        if (s4 == "sc")
        {
            s3 = "Screenshot sent";
        }
        hashmap.put("profile-id", s1);
        hashmap.put("message-text", s3);
        hashmap.put("type", s4);
        hashmap.put("refers", s5);
        hashmap.put("screenshot", s6);
        b("POST", new String((new StringBuilder()).append("/issues/").append(s2).append("/messages/").toString()), hashmap, handler, handler1);
    }

}
