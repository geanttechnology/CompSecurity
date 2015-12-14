// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.os.AsyncTask;
import android.os.Environment;
import android.webkit.URLUtil;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.rendering.RenderView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends AsyncTask
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int l);
    }


    private static final String a = com/inmobi/rendering/mraid/c.getSimpleName();
    private int b;
    private File c;
    private String d;
    private String e;
    private String f;
    private WeakReference g;
    private a h;
    private ArrayList i;
    private long j;
    private String k;

    public c(String s, File file, String s1, String s2, RenderView renderview)
    {
        k = s;
        c = file;
        d = s1;
        e = s2;
        i = renderview.getRenderingConfig().h();
        j = renderview.getRenderingConfig().g();
        g = new WeakReference(renderview);
    }

    public String a()
    {
        return e;
    }

    protected transient String a(Void avoid[])
    {
        int l;
        if (!com.inmobi.commons.core.utilities.d.a())
        {
            b = 8;
            return "fail";
        }
        if (!e.matches("[A-Za-z0-9]+") || e.equals(""))
        {
            b = 2;
            return "fail";
        }
        if (d.equals("") || !URLUtil.isValidUrl(d))
        {
            b = 3;
            return "fail";
        }
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            b = 10;
            return "fail";
        }
        String as[] = (String[])i.toArray(new String[i.size()]);
        Object obj;
        String s;
        byte abyte0[];
        String s1;
        long l1;
        long l2;
        boolean flag;
        try
        {
            l2 = System.currentTimeMillis();
            avoid = (HttpURLConnection)(new URL(d)).openConnection();
            avoid.setRequestMethod("GET");
            avoid.setConnectTimeout(5000);
            l = avoid.getResponseCode();
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Response code: ").append(l).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "SocketTimeoutException");
            b = 4;
            return "fail";
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "FileNotFoundException");
            b = 4;
            return "fail";
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "MalformedURLException");
            b = 3;
            return "fail";
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "ProtocolException");
            b = 8;
            return "fail";
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "IOException");
            b = 8;
            return "fail";
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "JSONException");
            b = 0;
            return "fail";
        }
        if (l >= 400) goto _L2; else goto _L1
_L1:
        s = avoid.getContentType();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Content Type: ").append(s).toString());
        l = 0;
_L16:
        if (l >= as.length) goto _L4; else goto _L3
_L3:
        s1 = as[l];
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Allowed Type: ").append(s1).toString());
        if (s == null) goto _L6; else goto _L5
_L5:
        if (!s1.toLowerCase(Locale.ENGLISH).equals(s.toLowerCase(Locale.ENGLISH))) goto _L6; else goto _L7
_L7:
        l = 1;
_L14:
        if (l != 0) goto _L2; else goto _L8
_L8:
        b = 6;
        return "fail";
_L2:
        l1 = avoid.getContentLength();
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("ContentSize: ").append(l1).append(" max size: ").append(j).toString());
        if (l1 <= j)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        b = 7;
        return "fail";
        avoid.connect();
        obj = new FileOutputStream(c);
        avoid = avoid.getInputStream();
        abyte0 = new byte[1024];
        l1 = 0L;
_L12:
        l = avoid.read(abyte0);
        if (l <= 0) goto _L10; else goto _L9
_L9:
        if (!isCancelled()) goto _L11; else goto _L10
_L10:
        ((FileOutputStream) (obj)).close();
        l1 = System.currentTimeMillis();
        if (isCancelled())
        {
            break MISSING_BLOCK_LABEL_653;
        }
        avoid = (new StringBuilder()).append("file://").append(c.getAbsolutePath()).toString();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("file path of video: ").append(avoid).toString());
        obj = new JSONObject();
        ((JSONObject) (obj)).put("url", d);
        ((JSONObject) (obj)).put("saved_url", avoid);
        ((JSONObject) (obj)).put("size_in_bytes", c.length());
        ((JSONObject) (obj)).put("download_started_at", l2);
        ((JSONObject) (obj)).put("download_ended_at", l1);
        f = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
_L13:
        return "success";
_L11:
        l1 += l;
        if (l1 <= j)
        {
            break MISSING_BLOCK_LABEL_621;
        }
        b = 7;
        return "fail";
        ((FileOutputStream) (obj)).write(abyte0, 0, l);
          goto _L12
        flag = c.delete();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("cancelSaveContent called.File: ").append(c.getAbsolutePath()).append(" deleted: ").append(flag).toString());
          goto _L13
_L4:
        l = 0;
        if (true) goto _L14; else goto _L6
_L6:
        l++;
        if (true) goto _L16; else goto _L15
_L15:
    }

    protected void a(String s)
    {
        if (!s.equals("success")) goto _L2; else goto _L1
_L1:
        if (g.get() != null)
        {
            ((RenderView)g.get()).a(k, (new StringBuilder()).append("sendSaveContentResult(\"saveContent_").append(e).append("\", 'success', \"").append(f).append("\");").toString());
        }
        if (h != null)
        {
            h.a();
        }
_L4:
        super.onPostExecute(s);
        return;
_L2:
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("url", d);
            ((JSONObject) (obj)).put("reason", b);
            obj = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
            if (g.get() != null)
            {
                ((RenderView)g.get()).a(k, (new StringBuilder()).append("sendSaveContentResult(\"saveContent_").append(e).append("\", 'failed', \"").append(((String) (obj))).append("\");").toString());
            }
            if (h != null)
            {
                h.a(b);
            }
        }
        catch (JSONException jsonexception)
        {
            if (g.get() != null)
            {
                ((RenderView)g.get()).a(k, (new StringBuilder()).append("sendSaveContentResult(\"saveContent_").append(e).append("\", 'failed', \"JSONException\");").toString());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

}
