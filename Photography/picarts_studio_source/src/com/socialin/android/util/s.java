// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.socialin.android.d;
import com.socialin.asyncnet.Request;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.util:
//            FileUtils

public final class s
{

    private static String a = "UNKNOWN";

    public static String a()
    {
        return a;
    }

    public static String a(InputStream inputstream, String s1, String s2, String s3)
    {
        s1 = (HttpURLConnection)(new URL((new StringBuilder()).append(s1).append("?query=uploadImage&par=").append(s2).toString())).openConnection();
        int i;
        int j;
        s1.setDoInput(true);
        s1.setDoOutput(true);
        s1.setUseCaches(false);
        s1.setRequestMethod("POST");
        s1.setRequestProperty("Connection", "Keep-Alive");
        s1.setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data;boundary=")).append("*****").toString());
        s1.setRequestProperty("Content-Language", "en-US");
        s2 = new DataOutputStream(s1.getOutputStream());
        s2.writeBytes((new StringBuilder()).append("--").append("*****").append("\r\n").toString());
        s2.writeBytes((new StringBuilder("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"")).append(s3).append("\"").append("\r\n").toString());
        s2.writeBytes("\r\n");
        i = Math.min(inputstream.available(), 1024);
        s3 = new byte[i];
        j = inputstream.read(s3, 0, i);
_L1:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        s2.write(s3, 0, i);
        i = Math.min(inputstream.available(), 1024);
        j = inputstream.read(s3, 0, i);
          goto _L1
        s2.writeBytes("\r\n");
        s2.writeBytes((new StringBuilder()).append("--").append("*****").append("--").append("\r\n").toString());
        inputstream.close();
        s2.flush();
        s2.close();
        inputstream = s1;
_L4:
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        s1 = new BufferedReader(new InputStreamReader(inputstream.getInputStream()));
        s2 = new StringBuilder();
_L2:
        s3 = s1.readLine();
        if (s3 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s2.append(s3);
          goto _L2
        s1;
        Log.e(d.a, (new StringBuilder("error: ")).append(s1.getMessage()).toString(), s1);
        inputstream.disconnect();
        return null;
        s1;
        inputstream = null;
_L5:
        Log.e(d.a, (new StringBuilder("error: ")).append(s1.getMessage()).toString(), s1);
        if (true) goto _L4; else goto _L3
_L3:
        s1.close();
        s1 = s2.toString();
        inputstream.disconnect();
        return s1;
        s1;
        inputstream.disconnect();
        throw s1;
        s2;
        inputstream = s1;
        s1 = s2;
          goto _L5
    }

    public static JSONObject a(String s1)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            s1 = new JSONObject(c(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            d.b(d.a, s1.getMessage(), s1);
            return jsonobject;
        }
        return s1;
    }

    public static boolean a(Context context)
    {
        if (context != null)
        {
            context = (ConnectivityManager)context.getSystemService("connectivity");
            if (context != null)
            {
                context = context.getActiveNetworkInfo();
                return context != null && context.isAvailable() && context.isConnected();
            }
        }
        return false;
    }

    public static boolean a(String s1, String s2)
    {
        Object obj1;
        Exception exception;
        Object obj2;
        obj2 = null;
        obj1 = null;
        exception = null;
        if (!FileUtils.a()) goto _L2; else goto _L1
_L1:
        File file;
        file = new File(s2);
        if (file.exists())
        {
            return true;
        }
        s1 = (HttpURLConnection)(new URL(s1)).openConnection();
        s1.setReadTimeout(20000);
        s1.setConnectTimeout(20000);
        s1.setRequestMethod("GET");
        s1.setRequestProperty("Content-Type", "application/octet-stream");
        s1.connect();
        s2 = new BufferedInputStream(s1.getInputStream(), 8192);
        File file1 = new File((new StringBuilder()).append(file.getPath()).append(".tmp").toString());
        if (!FileUtils.a()) goto _L4; else goto _L3
_L3:
        Object obj;
        file1.getParentFile().mkdirs();
        obj = new FileOutputStream(file1);
        obj1 = new byte[8192];
_L7:
        int i = s2.read(((byte []) (obj1)));
        if (i == -1) goto _L6; else goto _L5
_L5:
        ((OutputStream) (obj)).write(((byte []) (obj1)), 0, i);
          goto _L7
        obj1;
        obj1 = s2;
        s2 = s1;
        s1 = ((String) (obj1));
_L12:
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        s2.disconnect();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        ((OutputStream) (obj)).close();
        IOException ioexception;
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        return false;
_L6:
        ((OutputStream) (obj)).flush();
        if (file.exists())
        {
            file.delete();
        }
        file1.renameTo(file);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        s1.disconnect();
        ((OutputStream) (obj)).close();
        s2.close();
_L14:
        return true;
_L4:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        s1.disconnect();
        s2.close();
_L13:
        return false;
        s1;
        s2 = null;
        s1 = null;
        obj = obj2;
_L11:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        s1.disconnect();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        ((OutputStream) (obj)).close();
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        return false;
        s1;
        s2 = null;
        obj = null;
_L9:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        ((HttpURLConnection) (obj)).disconnect();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        ((OutputStream) (obj1)).close();
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s2) { }
        }
        throw s1;
_L2:
        return false;
        exception;
        s2 = null;
        obj = s1;
        s1 = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj = s1;
        s1 = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        obj = s1;
        s1 = exception;
        if (true) goto _L9; else goto _L8
_L8:
        s2;
        s2 = null;
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj;
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        ioexception;
        if (true) goto _L11; else goto _L10
_L10:
        s1;
        s1 = null;
        s2 = null;
        obj = exception;
          goto _L12
        s2;
        s2 = s1;
        s1 = null;
        obj = exception;
          goto _L12
        MalformedURLException malformedurlexception;
        malformedurlexception;
        malformedurlexception = s1;
        s1 = s2;
        s2 = malformedurlexception;
        malformedurlexception = exception;
          goto _L12
        s1;
          goto _L13
        s1;
          goto _L14
    }

    public static InputStream b(String s1)
    {
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1;
            if (s1.contains(" "))
            {
                s2 = s1.replaceAll(" ", "%20");
            }
        }
        s1 = (HttpURLConnection)(new URL(s2)).openConnection();
        s1.setDoInput(true);
        s1.setConnectTimeout(60000);
        s1.setReadTimeout(0x186a0);
        HttpURLConnection.setFollowRedirects(true);
        s1.connect();
        return s1.getInputStream();
    }

    public static boolean b(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        return context != null && context.getNetworkInfo(1) != null && context.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED;
    }

    private static String c(String s1)
    {
        s1 = new Request(s1);
        try
        {
            s1 = (String)s1.d();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e(d.a, (new StringBuilder("error: ")).append(s1.getMessage()).toString(), s1);
            return null;
        }
        return s1;
    }

    public static void c(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null && context.isConnected() && context.isAvailable()) goto _L2; else goto _L1
_L1:
        context = "-";
_L4:
        a = context;
        return;
_L2:
        int i;
        int j;
        i = context.getType();
        j = context.getSubtype();
        if (i != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        context = "WIFI";
        if (true) goto _L4; else goto _L3
_L3:
        if (i == 0)
        {
            switch (j)
            {
            default:
                context = "UNKNOWN";
                break;

            case 1: // '\001'
                context = "GPRS";
                break;

            case 2: // '\002'
                context = "EDGE";
                break;

            case 4: // '\004'
                context = "CDMA";
                break;

            case 7: // '\007'
                context = "1xRTT";
                break;

            case 11: // '\013'
                context = "IDEN";
                break;

            case 3: // '\003'
                context = "UMTS";
                break;

            case 5: // '\005'
                context = "EVDO_0";
                break;

            case 6: // '\006'
                context = "EVDO_A";
                break;

            case 8: // '\b'
                context = "HSDPA";
                break;

            case 9: // '\t'
                context = "HSUPA";
                break;

            case 10: // '\n'
                context = "HSPA";
                break;

            case 12: // '\f'
                context = "EVDO_B";
                break;

            case 14: // '\016'
                context = "EHRPD";
                break;

            case 15: // '\017'
                context = "HSPAP";
                break;

            case 13: // '\r'
                context = "LTE";
                break;
            }
        } else
        {
            context = "UNKNOWN";
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

}
