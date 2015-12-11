// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import net.hockeyapp.android.b.a;
import net.hockeyapp.android.q;

// Referenced classes of package net.hockeyapp.android.d:
//            e, f

public final class d extends AsyncTask
{

    public Context a;
    public ProgressDialog b;
    private a c;
    private String d;
    private String e;
    private String f;

    public d(Context context, String s, a a1)
    {
        a = context;
        d = s;
        e = (new StringBuilder()).append(UUID.randomUUID()).append(".apk").toString();
        f = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Download").toString();
        c = a1;
    }

    private transient Boolean a()
    {
        Object obj;
        Object obj1;
        int i;
        URL url;
        URL url1;
        try
        {
            url = new URL((new StringBuilder()).append(d).append("&type=apk").toString());
            obj1 = (HttpURLConnection)url.openConnection();
            a(((HttpURLConnection) (obj1)));
            i = ((HttpURLConnection) (obj1)).getResponseCode();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return Boolean.valueOf(false);
        }
        if (i != 301)
        {
            obj = obj1;
            if (i != 302)
            {
                break MISSING_BLOCK_LABEL_111;
            }
        }
        url1 = new URL(((HttpURLConnection) (obj1)).getHeaderField("Location"));
        obj = obj1;
        if (!url.getProtocol().equals(url1.getProtocol()))
        {
            obj = (HttpURLConnection)url1.openConnection();
            a(((HttpURLConnection) (obj)));
        }
        ((URLConnection) (obj)).connect();
        i = ((URLConnection) (obj)).getContentLength();
        obj1 = new File(f);
        if (!((File) (obj1)).mkdirs() && !((File) (obj1)).exists())
        {
            throw new IOException((new StringBuilder("Could not create the dir(s):")).append(((File) (obj1)).getAbsolutePath()).toString());
        }
        byte abyte0[];
        obj1 = new File(((File) (obj1)), e);
        obj = new BufferedInputStream(((URLConnection) (obj)).getInputStream());
        obj1 = new FileOutputStream(((File) (obj1)));
        abyte0 = new byte[1024];
        long l = 0L;
_L1:
        int j = ((InputStream) (obj)).read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        l += j;
        publishProgress(new Integer[] {
            Integer.valueOf((int)((100L * l) / (long)i))
        });
        ((OutputStream) (obj1)).write(abyte0, 0, j);
          goto _L1
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
        ((InputStream) (obj)).close();
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    static a a(d d1)
    {
        return d1.c;
    }

    private static void a(HttpURLConnection httpurlconnection)
    {
        httpurlconnection.addRequestProperty("User-Agent", "HockeySDK/Android");
        httpurlconnection.setInstanceFollowRedirects(true);
        if (android.os.Build.VERSION.SDK_INT <= 9)
        {
            httpurlconnection.setRequestProperty("connection", "close");
        }
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        if (b != null)
        {
            try
            {
                b.dismiss();
            }
            catch (Exception exception) { }
        }
        if (((Boolean) (obj)).booleanValue())
        {
            c.a();
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).setDataAndType(Uri.fromFile(new File(f, e)), "application/vnd.android.package-archive");
            ((Intent) (obj)).setFlags(0x10000000);
            a.startActivity(((Intent) (obj)));
            return;
        }
        try
        {
            obj = new android.app.AlertDialog.Builder(a);
            ((android.app.AlertDialog.Builder) (obj)).setTitle(q.a(c, 4));
            ((android.app.AlertDialog.Builder) (obj)).setMessage(q.a(c, 5));
            ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(q.a(c, 6), new e(this));
            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(q.a(c, 7), new f(this));
            ((android.app.AlertDialog.Builder) (obj)).create().show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    protected final void onProgressUpdate(Object aobj[])
    {
        aobj = (Integer[])aobj;
        try
        {
            if (b == null)
            {
                b = new ProgressDialog(a);
                b.setProgressStyle(1);
                b.setMessage("Loading...");
                b.setCancelable(false);
                b.show();
            }
            b.setProgress(((Integer) (aobj[0])).intValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            return;
        }
    }
}
