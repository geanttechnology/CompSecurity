// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.AysDownloadFile.MyProgressDialog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class sh extends AsyncTask
{

    si a;
    public boolean b;
    private URL c;
    private File d;
    private MyProgressDialog e;
    private int f;
    private sj g;

    private int a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[];
        int i;
        abyte0 = new byte[8192];
        inputstream = new BufferedInputStream(inputstream, 8192);
        outputstream = new BufferedOutputStream(outputstream, 8192);
        i = 0;
_L2:
        int j = inputstream.read(abyte0, 0, 8192);
        if (j == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        outputstream.write(abyte0, 0, j);
        i = j + i;
        if (true) goto _L2; else goto _L1
_L1:
        outputstream.flush();
        try
        {
            outputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            outputstream.printStackTrace();
            Crashlytics.logException(outputstream);
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
            return i;
        }
        return i;
        Object obj;
        obj;
        ((IOException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        try
        {
            outputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            outputstream.printStackTrace();
            Crashlytics.logException(outputstream);
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
            return i;
        }
        return i;
        obj;
        try
        {
            outputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            outputstream.printStackTrace();
            Crashlytics.logException(outputstream);
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        throw obj;
    }

    static int a(sh sh1)
    {
        return sh1.f;
    }

    static int a(sh sh1, int i)
    {
        sh1.f = i;
        return i;
    }

    private long a()
    {
        int i;
        int j;
        URLConnection urlconnection = c.openConnection();
        j = urlconnection.getContentLength();
        g = new sj(this, d);
        publishProgress(new Integer[] {
            Integer.valueOf(0), Integer.valueOf(j)
        });
        i = a(urlconnection.getInputStream(), ((OutputStream) (g)));
        if (i == j || j == -1)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        Log.e("DownLoaderTask", (new StringBuilder()).append("Download incomplete bytesCopied=").append(i).append(", length").append(j).toString());
        g.close();
_L2:
        return (long)i;
        IOException ioexception;
        ioexception;
        i = 0;
_L3:
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
          goto _L3
    }

    static void a(sh sh1, Object aobj[])
    {
        sh1.publishProgress(aobj);
    }

    protected transient Long a(Void avoid[])
    {
        return Long.valueOf(a());
    }

    protected void a(Long long1)
    {
        if (e != null && e.isShowing())
        {
            e.dismiss();
        }
        if (long1.longValue() == -1L)
        {
            cancel(true);
            a.b(-1);
            return;
        }
        if (isCancelled())
        {
            a.b(0);
            return;
        } else
        {
            a.b(1);
            return;
        }
    }

    protected transient void a(Integer ainteger[])
    {
        if (e != null || !b) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        if (ainteger.length <= 1)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        i = ainteger[1].intValue();
        if (i != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        cancel(true);
        a.b(-1);
        if (e == null || !e.isShowing()) goto _L1; else goto _L3
_L3:
        e.dismiss();
        return;
        if (e == null) goto _L1; else goto _L4
_L4:
        e.a(i);
        return;
        if (e != null)
        {
            e.b(ainteger[0].intValue());
        }
        Log.i("downloading apk", (new StringBuilder()).append("........").append(ainteger[0].intValue()).toString());
        return;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Long)obj);
    }

    protected void onPreExecute()
    {
        if (e != null)
        {
            e.a(com.pipcamera.activity.AysDownloadFile.MyProgressDialog.MyProgressStyle.STYLE_MYPROGRESS);
            e.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final sh a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    a.cancel(true);
                }

            
            {
                a = sh.this;
                super();
            }
            });
            e.show();
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
