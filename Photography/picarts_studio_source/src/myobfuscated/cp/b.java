// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cp;

import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.d;
import com.socialin.android.util.an;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.cb.c;

// Referenced classes of package myobfuscated.cp:
//            a, d, c

public class b extends an
{

    private static final Object d = myobfuscated/cp/b.getSimpleName();
    WeakReference a;
    String b;
    WeakReference c;
    private WeakReference e;

    private b(c c1, String s, a a1)
    {
        a = new WeakReference(c1);
        b = s;
        e = new WeakReference(a1);
    }

    public b(c c1, String s, a a1, myobfuscated.cp.c c2)
    {
        this(c1, s, a1);
        if (c2 != null)
        {
            c = new WeakReference(c2);
        }
    }

    private transient String a(String as[])
    {
        Object obj;
        Object obj1;
        String s;
        Object obj2;
        if (a.a)
        {
            (new StringBuilder("doInBackground, url: ")).append(b);
        }
        obj2 = as[0];
        s = as[1];
        obj = null;
        obj1 = null;
        as = (HttpURLConnection)(new URL(b)).openConnection();
        long l1;
        as.setReadTimeout(20000);
        as.setConnectTimeout(20000);
        as.setDefaultUseCaches(false);
        as.setUseCaches(false);
        as.setRequestMethod("GET");
        as.setRequestProperty("Content-Type", "application/octet-stream");
        as.setRequestProperty("Pragma", "no-cache");
        as.setRequestProperty("Cache-Control", "no-cache");
        as.setRequestProperty("Expires", "-1");
        as.setRequestProperty("Accept-Encoding", "identity");
        as.connect();
        l1 = as.getContentLength();
        if (!a.a);
        obj1 = Environment.getExternalStorageDirectory();
        obj = new BufferedInputStream(as.getInputStream());
        if (!((File) (obj1)).exists() || !((File) (obj1)).canWrite()) goto _L2; else goto _L1
_L1:
        obj1 = new File(((String) (obj2)));
        ((File) (obj1)).mkdirs();
        if (!a.a);
        obj2 = new File(((File) (obj1)), (new StringBuilder()).append(s).append(".part").toString());
        ((File) (obj2)).createNewFile();
_L7:
        Object obj3;
        byte abyte0[];
        obj3 = new FileOutputStream(((File) (obj2)));
        abyte0 = new byte[4096];
        long l = 0L;
_L6:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i == -1) goto _L4; else goto _L3
_L3:
        l += i;
        publishProgress(new Integer[] {
            Integer.valueOf((int)((100L * l) / l1))
        });
        ((OutputStream) (obj3)).write(abyte0, 0, i);
        if (!isCancelled()) goto _L6; else goto _L5
_L5:
        ((File) (obj2)).delete();
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
        }
        return null;
        obj3;
        com.socialin.android.d.a(new Object[] {
            d, (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj3)).getMessage()).toString()
        });
          goto _L7
        obj;
_L14:
        if (a.a)
        {
            com.socialin.android.d.b("MalformedURLException in packFileDownloader");
        }
        com.socialin.android.d.a(new Object[] {
            d, (new StringBuilder("Got unexpected exception: ")).append(((MalformedURLException) (obj)).getMessage()).toString()
        });
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
        }
_L8:
        return null;
_L4:
        ((OutputStream) (obj3)).flush();
        ((OutputStream) (obj3)).close();
        ((InputStream) (obj)).close();
        ((File) (obj2)).renameTo(new File(((File) (obj1)), s));
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
        }
        return s;
_L2:
        if (a.a)
        {
            com.socialin.android.d.b("can't create pack File");
        }
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
        }
        break MISSING_BLOCK_LABEL_420;
        obj;
        as = ((String []) (obj1));
        obj1 = obj;
_L12:
        i = -1;
        obj = as;
        int j = as.getResponseCode();
        i = j;
_L9:
        obj = as;
        if (!a.a)
        {
            break MISSING_BLOCK_LABEL_689;
        }
        obj = as;
        com.socialin.android.d.b((new StringBuilder("IOException in packFileDownloader, statuscode: ")).append(i).toString());
        obj = as;
        com.socialin.android.d.a(new Object[] {
            d, (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
        try
        {
            as.disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(as.getMessage()).toString()
            });
        }
          goto _L8
        Exception exception;
        exception;
        obj = as;
        com.socialin.android.d.a(new Object[] {
            d, (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
          goto _L9
        as;
_L11:
        try
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.a(new Object[] {
                d, (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
        }
        throw as;
        obj1;
        obj = as;
        as = ((String []) (obj1));
        continue; /* Loop/switch isn't completed */
        obj1;
        obj = as;
        as = ((String []) (obj1));
        if (true) goto _L11; else goto _L10
_L10:
        obj1;
          goto _L12
        obj;
        as = null;
        if (true) goto _L14; else goto _L13
_L13:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected volatile void onCancelled(Object obj)
    {
        super.onCancelled((String)obj);
    }

    protected void onPostExecute(Object obj)
    {
        Object obj1 = (String)obj;
        if (!isCancelled() && obj1 != null)
        {
            obj = (a)e.get();
            if (a.a)
            {
                (new StringBuilder("onPostExecute, result:")).append(((String) (obj1))).append(" downloader: ").append(obj);
            }
            if (obj != null)
            {
                ((a) (obj)).c.remove(this);
                c c1 = (c)a.get();
                if (c1 != null)
                {
                    View view = c1.a();
                    if (obj1 != null)
                    {
                        if (c1.a(((String) (obj1))))
                        {
                            if (view != null)
                            {
                                c1.n = "";
                                ((TextView)view.findViewById(0x7f10027c)).setText("");
                                ((TextView)view.findViewById(0x7f10027b)).setText(c1.e);
                                ((ImageView)view.findViewById(0x7f100279)).setBackgroundDrawable(c1.f);
                            }
                            c1.a(0);
                        } else
                        if (view != null)
                        {
                            ((TextView)view.findViewById(0x7f10027c)).setText(0x7f0802c9);
                        }
                    } else
                    {
                        if (view != null)
                        {
                            ((TextView)view.findViewById(0x7f10027c)).setText(0x7f0802c9);
                        }
                        c1.a(1);
                    }
                    c1.b();
                }
                if (((a) (obj)).b.size() > 0)
                {
                    obj1 = (myobfuscated.cp.d)((a) (obj)).b.remove(0);
                    ((a) (obj)).a(((myobfuscated.cp.d) (obj1)).a, ((myobfuscated.cp.d) (obj1)).b, (c)((myobfuscated.cp.d) (obj1)).d.get(), ((myobfuscated.cp.d) (obj1)).c);
                }
                if (c != null)
                {
                    obj = (myobfuscated.cp.c)c.get();
                    if (a.a)
                    {
                        (new StringBuilder("onPostExecute, listener:")).append(obj);
                    }
                    if (obj != null)
                    {
                        ((myobfuscated.cp.c) (obj)).a();
                        return;
                    }
                }
            }
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        int i = ((Integer[])aobj)[0].intValue();
        aobj = (c)a.get();
        if (aobj != null)
        {
            View view = ((c) (aobj)).a();
            if (view != null)
            {
                if (i > 0)
                {
                    aobj.n = (new StringBuilder()).append(String.valueOf(i)).append("%").toString();
                    ((TextView)view.findViewById(0x7f10027c)).setText(((c) (aobj)).n);
                } else
                {
                    ((TextView)view.findViewById(0x7f10027c)).setText(0x7f08041c);
                }
            }
            ((c) (aobj)).b();
        }
        if (c != null)
        {
            aobj = (myobfuscated.cp.c)c.get();
            if (aobj != null)
            {
                if (i < 0)
                {
                    i = 0;
                }
                ((myobfuscated.cp.c) (aobj)).a(i);
            }
        }
    }

}
