// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.utils:
//            MD5, Myutils

public class publicTools
{

    private static String aiokey;
    public static Handler app_detail_handler;
    public static Handler app_popular_handler;
    public static Handler app_recent_handler;
    public static Handler app_search_handler;
    public static boolean appdownload = false;
    public static Handler apppopularhandler;
    public static Handler apprecenthandler;
    public static JSONObject apps_in_downloading_list;
    public static Handler appsearchhandler;
    public static boolean cleanertag = false;
    public static CookieManager cookieManager;
    public static Context ctx;
    public static boolean detailtag = false;
    public static Handler dmhandler;
    public static String downkey;
    public static Handler game_popular_handler;
    public static Handler game_recent_handler;
    public static Boolean isbu = Boolean.valueOf(true);
    public static String keyid = "";
    public static Handler mp3_popular_handler;
    public static Handler mp3_recent_handler;
    public static Handler mp3_search_handler;
    public static Handler mp3popularhandler;
    public static Handler mp3recenthandler;
    public static Handler mp3searchhandler;
    public static int noticomplete = 0;
    public static String openid = "";
    public static String openimgpath;
    public static String opentitle;
    public static Handler popuhandler;
    public static Handler ringtone_popular_handler;
    public static Handler ringtone_recent_handler;
    public static Handler ringtone_search_handler;
    public static Handler ringtonepopularhandler;
    public static Handler ringtonerecenthandler;
    public static Handler ringtonesearchhandler;
    public static final String secret = "this_is_mobile_2014";
    public static int serial = 0;
    public static SharedPreferences sp;
    public static SharedPreferences spkey;
    public static String tagfeatured = "";
    public static boolean tagtanchuang = false;
    public static final String timeurl1 = "http://android.downloadatoz.com/_201409/market/time.php";
    public static final String timeurl2 = "http://93app.com/time.php";
    public static final String timeurl3 = "http://www.convert-unix-time.com/api?timestamp=now";
    public static boolean toptoast = false;
    public static final String video_ga_tongji = "http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=";

    public publicTools(Context context)
    {
        ctx = context;
        sp = context.getSharedPreferences("datatime", 0);
        apps_in_downloading_list = new JSONObject();
        spkey = context.getSharedPreferences("keydata", 0);
    }

    public static void copyFile(String s, String s1)
    {
        Log.v("xxxx", (new StringBuilder("oldPath:")).append(s).toString());
        Log.v("xxxx", (new StringBuilder("newPath:")).append(s1).toString());
        byte abyte0[];
        s = new FileInputStream(new File(s));
        s1 = new FileOutputStream(s1, false);
        abyte0 = new byte[1024];
        int i = 0;
_L2:
        if (i <= -1)
        {
            try
            {
                s.close();
                s1.flush();
                s1.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.v("xxxx", (new StringBuilder("error:")).append(s).append(".").toString());
            }
            break; /* Loop/switch isn't completed */
        }
        i = s.read(abyte0);
        s1.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        s.printStackTrace();
        return;
    }

    public static String doHttpPost(String s, HashMap hashmap)
    {
        DefaultHttpClient defaulthttpclient;
        Object obj;
        obj = new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
        defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 5000);
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 5000);
        ConnManagerParams.setTimeout(defaulthttpclient.getParams(), 5000);
        s = new HttpPost(s);
        s.setHeaders(new BasicHeader[] {
            obj
        });
        obj = new ArrayList();
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        hashmap = hashmap.entrySet().iterator();
_L5:
        if (hashmap.hasNext()) goto _L3; else goto _L2
_L2:
        java.util.Map.Entry entry;
        try
        {
            s.setEntity(new UrlEncodedFormEntity(((List) (obj)), "UTF-8"));
            s = defaulthttpclient.execute(s);
            if (s.getStatusLine().getStatusCode() != 200)
            {
                break; /* Loop/switch isn't completed */
            }
            s = EntityUtils.toString(s.getEntity(), "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "TIMEOUTERROR";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "OTHERERROR";
        }
        return s;
_L3:
        entry = (java.util.Map.Entry)hashmap.next();
        ((ArrayList) (obj)).add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
        if (true) goto _L5; else goto _L4
_L4:
        s = (new StringBuilder(String.valueOf(EntityUtils.toString(s.getEntity(), "UTF-8")))).append(s.getStatusLine().getStatusCode()).append("ERROR").toString();
        return s;
    }

    public static String getCode(String s, long l)
    {
        return MD5.getMD5((new StringBuilder(String.valueOf(s))).append(l).append("this_is_mobile_2014").toString());
    }

    public static String getDataFromURL(String s, HashMap hashmap)
    {
        String s1;
        String s2;
        s2 = "X";
        System.setProperty("http.keepAlive", "false");
        s1 = s2;
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf("X"))).append("a/").toString();
        s1 = s2;
        if (((Integer)hashmap.get("redirect")).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        s1 = s2;
        httpurlconnection.setInstanceFollowRedirects(false);
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("a2/").toString();
        s1 = s2;
        if (((Integer)hashmap.get("send_cookie")).intValue() != 1)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        s1 = s2;
        if (cookieManager.getCookieStore().getCookies().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        s1 = s2;
        httpurlconnection.setRequestProperty("Set-Cookie", TextUtils.join(",", cookieManager.getCookieStore().getCookies()));
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("b/").toString();
        s1 = s2;
        httpurlconnection.setRequestMethod("GET");
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("c1/").toString();
        s1 = s2;
        httpurlconnection.setConnectTimeout(15000);
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("c2/").toString();
        s1 = s2;
        httpurlconnection.setRequestProperty("User-Agent", "\tMozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36");
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("c3/").toString();
        s1 = s2;
        httpurlconnection.setRequestProperty("AIO", MD5.getMD5((new StringBuilder(String.valueOf(keyid))).append(spkey.getString("aiokey", "aio_fingerprint")).toString()));
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("c4/").toString();
        s1 = s2;
        StringBuffer stringbuffer = new StringBuffer();
        s1 = s2;
        int i = httpurlconnection.getResponseCode();
        s1 = s2;
        s2 = (new StringBuilder(String.valueOf(s2))).append("d:").append(i).append("/").toString();
        s1 = s2;
        Log.v("koko", (new StringBuilder(String.valueOf(s))).append("===").append(i).toString());
        if (i != 302 && i != 301) goto _L2; else goto _L1
_L1:
        s1 = s2;
        if (((Integer)hashmap.get("show_header")).intValue() != 1)
        {
            break MISSING_BLOCK_LABEL_564;
        }
        s1 = s2;
        stringbuffer.append((new StringBuilder("Location: ")).append(httpurlconnection.getHeaderField("Location")).toString());
        s1 = s2;
        stringbuffer.append("\n");
        s1 = s2;
        stringbuffer.append((new StringBuilder("aio_swf_download_link: ")).append(httpurlconnection.getHeaderField("aio_swf_download_link")).toString());
        s1 = s2;
        Log.e("koko", (new StringBuilder("302sb=")).append(stringbuffer.toString()).toString());
_L10:
        s1 = s2;
        stringbuffer.append("");
        s1 = s2;
        s = (new StringBuilder(String.valueOf(s2))).append("e/").toString();
        s1 = s;
        if (((Integer)hashmap.get("save_cookie")).intValue() != 1) goto _L4; else goto _L3
_L3:
        s1 = s;
        hashmap = (List)httpurlconnection.getHeaderFields().get("Set-Cookie");
        if (hashmap == null) goto _L4; else goto _L5
_L5:
        s1 = s;
        hashmap = hashmap.iterator();
_L13:
        s1 = s;
        if (hashmap.hasNext()) goto _L6; else goto _L4
_L4:
        s1 = s;
        s = (new StringBuilder(String.valueOf(s))).append("f/").toString();
        s1 = s;
        try
        {
            return stringbuffer.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
          goto _L7
_L11:
        s1 = s2;
        s = httpurlconnection.getHeaderFieldKey(i);
        if (s != null) goto _L9; else goto _L8
_L8:
        s1 = s2;
        s = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
_L12:
        s1 = s.readLine();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        Log.e("koko", (new StringBuilder("200sb=")).append(stringbuffer.toString()).toString());
          goto _L10
_L9:
        s1 = s2;
        if (((Integer)hashmap.get("show_header")).intValue() != 1)
        {
            break MISSING_BLOCK_LABEL_853;
        }
        s1 = s2;
        stringbuffer.append((new StringBuilder(String.valueOf(s))).append(":").append(httpurlconnection.getHeaderField(i)).toString());
        s1 = s2;
        Log.e("etet", (new StringBuilder(String.valueOf(s))).append(":").append(httpurlconnection.getHeaderField(i)).toString());
        i++;
          goto _L11
        stringbuffer.append(s1);
          goto _L12
        s;
        s1 = s2;
_L7:
        s.printStackTrace();
        return (new StringBuilder()).append(s).append("***msg=").append(s1).toString();
_L15:
        s1 = s2;
        Log.e("koko", "\u975E\u6B63\u5E38\u8BF7\u6C42\uFF0C\u6BD4\u5982\u7F51\u9875\u6253\u4E0D\u5F00\uFF0C\u6216\u8005\u6CA1\u6709\u6743\u9650");
          goto _L10
_L6:
        s1 = s;
        s2 = (String)hashmap.next();
        s1 = s;
        cookieManager.getCookieStore().add(null, (HttpCookie)HttpCookie.parse(s2).get(0));
          goto _L13
        s;
          goto _L7
_L2:
        if (i != 200) goto _L15; else goto _L14
_L14:
        i = 1;
          goto _L11
    }

    public static void getKey()
    {
        (new Thread(new Runnable() {

            public void run()
            {
                publicTools.aiokey = (new JSONObject(publicTools.getUrl("http://android.downloadatoz.com/_201409/api/_maket_process/aio_fingerprint_verify.php"))).getString("key");
                publicTools.spkey.edit().putString("aiokey", publicTools.aiokey).commit();
                if (publicTools.aiokey != null)
                {
                    publicTools.downkey = publicTools.aiokey;
                    return;
                }
                try
                {
                    publicTools.downkey = "aio_fingerprint";
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                return;
            }

        })).start();
    }

    public static Long getServerTime()
    {
        long l = 0L;
        long l1 = Myutils.setting_json.getLong("time_offset");
        l = l1;
        Log.v("wewe", (new StringBuilder("time_offset===")).append(l1).toString());
        l = l1;
_L2:
        return Long.valueOf((long)(Math.floor(System.currentTimeMillis() / 1000L) + (double)l));
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getUrl(String s)
    {
        Log.e("ccc", "\u8BF7\u6C42\u7F51\u7EDC");
        Object obj;
        String s1;
        try
        {
            obj = (HttpURLConnection)(new URL(s)).openConnection();
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            ((HttpURLConnection) (obj)).setConnectTimeout(15000);
            s = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("ttt", (new StringBuilder("+++")).append(((HttpURLConnection) (obj)).getResponseCode()).toString());
        if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L3:
        s1 = ((BufferedReader) (obj)).readLine();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
_L2:
        s.append("");
        s = s.toString();
        return s;
        s.append(s1);
          goto _L3
        s;
_L5:
        s.printStackTrace();
        Log.e("ttt", (new StringBuilder()).append(s).toString());
        return (new StringBuilder()).append(s).toString();
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String getUrl2(String s)
    {
        Object obj;
        String s1;
        try
        {
            obj = (HttpURLConnection)(new URL(s)).openConnection();
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            ((HttpURLConnection) (obj)).setConnectTimeout(15000);
            s = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L3:
        s1 = ((BufferedReader) (obj)).readLine();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
_L2:
        s.append("");
        s = s.toString();
        return s;
        s.append(s1);
          goto _L3
        s;
_L5:
        s.printStackTrace();
        Log.v("ttt", (new StringBuilder()).append(s).toString());
        return (new StringBuilder()).append(s).toString();
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String get_a_random_user_webview()
    {
        Object obj = ctx.getResources().openRawResource(0x7f050002);
        try
        {
            byte abyte0[] = new byte[((InputStream) (obj)).available()];
            ((InputStream) (obj)).read(abyte0);
            String s = new String(abyte0);
            ((InputStream) (obj)).close();
            Log.v("lolo", s);
            obj = new JSONArray(s);
            ((JSONArray) (obj)).getJSONObject((int)Math.floor(Math.random() * (double)((JSONArray) (obj)).length())).get("text");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "http://m.downloadatoz.com/apps/com.about.wapdam.mp3.music,1186371/download.html";
        }
        return "http://m.downloadatoz.com/apps/com.about.wapdam.mp3.music,1186371/download.html";
    }

    public static boolean isNetworkAvailable(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getAllNetworkInfo();
        if (context == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < context.length) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        if (context[i].getState() == android.net.NetworkInfo.State.CONNECTED)
        {
            return true;
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean is_app_downloading(String s)
    {
        Boolean boolean1;
        int i;
        boolean1 = Boolean.valueOf(false);
        i = 0;
_L4:
        int j = apps_in_downloading_list.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        s = boolean1;
_L3:
        return s.booleanValue();
_L2:
        if (!apps_in_downloading_list.getJSONObject((new StringBuilder()).append(i).toString()).getString("url_id").equals(s))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        s = Boolean.valueOf(true);
          goto _L3
        i++;
          goto _L4
        s;
        s = boolean1;
          goto _L3
    }

    public static boolean is_good_domain(String s)
    {
        return s.contains("93app.com/") || s.contains("downloadatoz.com/") || s.contains("liveloading.com/") || s.contains("xkee.com/");
    }

    public static void make_path_ready(String s)
    {
        s = new File(s);
        if (!s.exists())
        {
            s.mkdirs();
        }
    }

    public static String readFile(String s)
    {
        String s1;
        Log.v("xxxx", (new StringBuilder("filename:")).append(s).toString());
        s1 = "";
        byte abyte0[];
        ByteArrayOutputStream bytearrayoutputstream;
        s = new FileInputStream(new File(s));
        abyte0 = new byte[1024];
        bytearrayoutputstream = new ByteArrayOutputStream();
_L3:
        if (s.read(abyte0) != -1) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.close();
        s.close();
        s = bytearrayoutputstream.toString();
_L4:
        Log.v("xxxx", (new StringBuilder("content length:")).append(s.length()).append(".").toString());
        return s;
_L2:
        bytearrayoutputstream.write(abyte0, 0, abyte0.length);
          goto _L3
        s;
        Log.v("xxxx", (new StringBuilder("error:")).append(s).append(".").toString());
        s.printStackTrace();
        s = s1;
          goto _L4
    }

    public static JSONObject read_json_from_file(String s)
    {
        JSONObject jsonobject = new JSONObject();
        s = new FileInputStream(s);
        Object obj;
        obj = s.getChannel();
        obj = ((FileChannel) (obj)).map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, ((FileChannel) (obj)).size());
        obj = Charset.defaultCharset().decode(((java.nio.ByteBuffer) (obj))).toString();
        Exception exception;
        try
        {
            s.close();
            return new JSONObject(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_71;
        exception;
        s.close();
        throw exception;
        return jsonobject;
    }

    public static void resetServerTime()
    {
        (new AsyncTask() {

            private long offset;
            private String server_time;

            protected transient Long doInBackground(Void avoid[])
            {
                long l;
                l = System.currentTimeMillis();
                server_time = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/time.php?")).append(l).toString());
                if (server_time == null) goto _L2; else goto _L1
_L1:
                offset = (long)((double)Long.parseLong(server_time.trim()) - Math.floor(l / 1000L));
_L4:
                return Long.valueOf(offset);
_L2:
                server_time = publicTools.getUrl((new StringBuilder("http://93app.com/time.php?")).append(l).toString());
                if (server_time != null)
                {
                    offset = (long)((double)Long.parseLong(server_time.trim()) - Math.floor(l / 1000L));
                    continue; /* Loop/switch isn't completed */
                }
                try
                {
                    server_time = publicTools.getUrl("http://www.convert-unix-time.com/api?timestamp=now");
                    if (server_time != null)
                    {
                        offset = (long)((double)Long.parseLong((new JSONObject(server_time)).getString("timestamp").trim()) - Math.floor(l / 1000L));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[]) { }
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Long long1)
            {
                super.onPostExecute(long1);
                if (long1 == null)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                if (System.currentTimeMillis() - Myutils.setting_json.getLong("system_time") > 0x36ee80L)
                {
                    Myutils.setting_json.put("time_offset", long1);
                    Myutils.setting_json.put("system_time", System.currentTimeMillis());
                    Myutils.saveSetting();
                    Log.v("erer", "aaaaaaaaaa");
                }
                return;
                Exception exception;
                exception;
                try
                {
                    Log.v("erer", "bbbbbbbbb");
                    Myutils.setting_json.put("time_offset", long1);
                    Myutils.setting_json.put("system_time", System.currentTimeMillis());
                    Myutils.saveSetting();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Long long1)
                {
                    long1.printStackTrace();
                }
                return;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Long)obj);
            }

            protected void onPreExecute()
            {
                publicTools.sp.edit().putLong("time_offset", 0L).commit();
                super.onPreExecute();
            }

            
            {
                server_time = null;
                offset = 0L;
            }
        }).execute(new Void[0]);
    }

    public static void save_json_to_file(String s, JSONObject jsonobject)
    {
        try
        {
            s = new BufferedWriter(new FileWriter(s));
            s.write(jsonobject.toString());
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static String set_a_random_user_agent()
    {
        String s;
        Object obj;
        s = "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
        obj = ctx.getResources().openRawResource(0x7f050001);
        byte abyte0[] = new byte[((InputStream) (obj)).available()];
        ((InputStream) (obj)).read(abyte0);
        String s1 = new String(abyte0);
        ((InputStream) (obj)).close();
        obj = new JSONArray(s1);
        int i;
        int j;
        j = 0;
        i = 0;
_L7:
        if (i < ((JSONArray) (obj)).length()) goto _L2; else goto _L1
_L1:
        Log.v("max", (new StringBuilder(String.valueOf(j))).toString());
        j = (int)Math.floor(Math.random() * (double)j);
        i = 0;
_L5:
        int k = ((JSONArray) (obj)).length();
        if (i < k) goto _L4; else goto _L3
_L3:
        Myutils.setting_json.put("agent", s);
        Myutils.saveSetting();
        return s;
_L2:
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        jsonobject.put("start", j);
        j += jsonobject.getInt("n");
        jsonobject.put("end", j - 1);
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        JSONObject jsonobject1 = ((JSONArray) (obj)).getJSONObject(i);
        if (j < jsonobject1.getInt("start") || j >= jsonobject1.getInt("end"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj = jsonobject1.getString("text");
        s = ((String) (obj));
          goto _L3
        i++;
          goto _L5
        Object obj1;
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L3
        obj1;
        ((JSONException) (obj1)).printStackTrace();
        return s;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void writeFile(String s, String s1)
    {
        Log.v("xxxx", (new StringBuilder("content length2:")).append(s.length()).append(".").toString());
        try
        {
            s1 = new FileOutputStream(s1, false);
            s1.write(s.getBytes());
            s1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.v("xxxx", (new StringBuilder("error2:")).append(s).append(".").toString());
        }
        s.printStackTrace();
    }

    static 
    {
        detailtag = true;
        appdownload = false;
        noticomplete = 0;
        cleanertag = true;
        serial = 1;
        tagtanchuang = true;
        toptoast = true;
    }


}
