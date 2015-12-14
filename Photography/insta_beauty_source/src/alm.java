// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import com.fotoable.fotoproedit.view.ui.MyProgressDialog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class alm extends AsyncTask
{

    public boolean a;
    alo b;
    private final String c;
    private URL d;
    private File e;
    private MyProgressDialog f;
    private int g;
    private alp h;
    private Context i;

    public alm(String s, String s1, String s2, Context context, boolean flag)
    {
        c = "DownLoaderTask";
        g = 0;
        a = flag;
        if (context != null)
        {
            if (a)
            {
                f = new MyProgressDialog(context);
            }
            i = context;
        } else
        {
            f = null;
        }
        try
        {
            d = new URL(s);
            s = new File(s1);
            if (!s.exists())
            {
                s.mkdir();
            }
            e = new File(s1, s2);
            flag = e.exists();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        e.createNewFile();
_L1:
        Log.d("DownLoaderTask", (new StringBuilder()).append("out=").append(s1).append(", name=").append(s2).append(",mUrl.getFile()=").append(d.getFile()).toString());
        return;
        s;
        s.printStackTrace();
          goto _L1
    }

    static int a(alm alm1)
    {
        return alm1.g;
    }

    static int a(alm alm1, int j)
    {
        alm1.g = j;
        return j;
    }

    private int a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[];
        int j;
        abyte0 = new byte[8192];
        inputstream = new BufferedInputStream(inputstream, 8192);
        outputstream = new BufferedOutputStream(outputstream, 8192);
        j = 0;
_L2:
        int k = inputstream.read(abyte0, 0, 8192);
        if (k == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        outputstream.write(abyte0, 0, k);
        j = k + j;
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
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return j;
        }
        return j;
        Object obj;
        obj;
        ((IOException) (obj)).printStackTrace();
        try
        {
            outputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            outputstream.printStackTrace();
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return j;
        }
        return j;
        obj;
        try
        {
            outputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            outputstream.printStackTrace();
        }
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw obj;
    }

    private long a()
    {
        int j;
        int k;
        URLConnection urlconnection = d.openConnection();
        k = urlconnection.getContentLength();
        h = new alp(this, e);
        publishProgress(new Integer[] {
            Integer.valueOf(0), Integer.valueOf(k)
        });
        j = a(urlconnection.getInputStream(), ((OutputStream) (h)));
        if (j == k || k == -1)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        Log.e("DownLoaderTask", (new StringBuilder()).append("Download incomplete bytesCopied=").append(j).append(", length").append(k).toString());
        h.close();
_L2:
        return (long)j;
        IOException ioexception;
        ioexception;
        j = 0;
_L3:
        ioexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
          goto _L3
    }

    static void a(alm alm1, Object aobj[])
    {
        alm1.publishProgress(aobj);
    }

    protected transient Long a(Void avoid[])
    {
        return Long.valueOf(a());
    }

    public void a(alo alo1)
    {
        b = alo1;
    }

    protected void a(Long long1)
    {
        if (f != null && f.isShowing())
        {
            f.dismiss();
        }
        if (long1.longValue() == -1L)
        {
            cancel(true);
            b.a(-1);
            return;
        }
        if (isCancelled())
        {
            b.a(0);
            return;
        } else
        {
            b.a(1);
            return;
        }
    }

    protected transient void a(Integer ainteger[])
    {
        if (f != null)
        {
            if (ainteger.length > 1)
            {
                int j = ainteger[1].intValue();
                if (j == -1)
                {
                    cancel(true);
                    b.a(-1);
                    if (f != null && f.isShowing())
                    {
                        f.dismiss();
                        return;
                    }
                } else
                {
                    f.a(j);
                    return;
                }
            } else
            {
                f.b(ainteger[0].intValue());
                return;
            }
        }
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
        if (f != null && a)
        {
            f.a(com.fotoable.fotoproedit.view.ui.MyProgressDialog.MyProgressStyle.STYLE_MYPROGRESS);
            f.setOnCancelListener(new aln(this));
            f.show();
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
