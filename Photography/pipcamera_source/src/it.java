// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.AysDownloadFile.MyProgressDialog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class it extends AsyncTask
{

    iv a;
    private final String b = "ZipExtractorTask";
    private final File c;
    private final File d;
    private final MyProgressDialog e;
    private int f;
    private final Context g;
    private boolean h;
    private boolean i;

    public it(String s, String s1, Context context, boolean flag, boolean flag1)
    {
        f = 0;
        c = new File(s);
        d = new File(s1);
        i = flag1;
        if (!d.exists() && !d.mkdirs())
        {
            Log.e("ZipExtractorTask", (new StringBuilder()).append("Failed to make directories:").append(d.getAbsolutePath()).toString());
        }
        if (context != null && i)
        {
            e = new MyProgressDialog(context);
        } else
        {
            e = null;
        }
        g = context;
        h = flag;
    }

    static int a(it it1)
    {
        return it1.f;
    }

    static int a(it it1, int j)
    {
        it1.f = j;
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
        Object obj = new ZipFile(c);
        Object obj1;
        publishProgress(new Integer[] {
            Integer.valueOf(0), Integer.valueOf((int)a(((ZipFile) (obj))))
        });
        obj1 = ((ZipFile) (obj)).entries();
        long l = 0L;
_L4:
        long l1;
        long l2;
        l1 = l;
        l2 = l;
        if (!((Enumeration) (obj1)).hasMoreElements()) goto _L2; else goto _L1
_L1:
        l1 = l;
        l2 = l;
        ZipEntry zipentry = (ZipEntry)((Enumeration) (obj1)).nextElement();
        l1 = l;
        l2 = l;
        if (zipentry.isDirectory()) goto _L4; else goto _L3
_L3:
        l1 = l;
        l2 = l;
        Object obj3 = new File(d, zipentry.getName());
        l1 = l;
        l2 = l;
        if (((File) (obj3)).getParentFile().exists())
        {
            break MISSING_BLOCK_LABEL_198;
        }
        l1 = l;
        l2 = l;
        Log.e("ZipExtractorTask", (new StringBuilder()).append("make=").append(((File) (obj3)).getParentFile().getAbsolutePath()).toString());
        l1 = l;
        l2 = l;
        ((File) (obj3)).getParentFile().mkdirs();
        l1 = l;
        l2 = l;
        if (!((File) (obj3)).exists())
        {
            break MISSING_BLOCK_LABEL_244;
        }
        l1 = l;
        l2 = l;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        l1 = l;
        l2 = l;
        if (h);
        l1 = l;
        l2 = l;
        obj3 = new iu(this, ((File) (obj3)));
        l1 = l;
        l2 = l;
        l += a(((ZipFile) (obj)).getInputStream(zipentry), ((OutputStream) (obj3)));
        l1 = l;
        l2 = l;
        ((iu) (obj3)).close();
          goto _L4
        Object obj2;
        obj2;
        l = l1;
_L11:
        obj1 = obj;
        ((ZipException) (obj2)).printStackTrace();
        l1 = l;
        if (obj != null)
        {
            try
            {
                ((ZipFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                return l;
            }
            l1 = l;
        }
_L6:
        return l1;
_L2:
        if (obj != null)
        {
            try
            {
                ((ZipFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                return l;
            }
        }
        return l;
        obj2;
        obj = null;
        l = 0L;
_L9:
        obj1 = obj;
        ((IOException) (obj2)).printStackTrace();
        l1 = l;
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            ((ZipFile) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return l;
        }
        return l;
        obj1;
        obj = null;
_L8:
        if (obj != null)
        {
            try
            {
                ((ZipFile) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
        l = 0L;
          goto _L9
        obj2;
        l = l2;
          goto _L9
        obj2;
        obj = null;
        l = 0L;
        continue; /* Loop/switch isn't completed */
        obj2;
        l = 0L;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private long a(ZipFile zipfile)
    {
        zipfile = zipfile.entries();
        long l = 0L;
        do
        {
            if (!zipfile.hasMoreElements())
            {
                break;
            }
            ZipEntry zipentry = (ZipEntry)zipfile.nextElement();
            if (zipentry.getSize() >= 0L)
            {
                l = zipentry.getSize() + l;
            }
        } while (true);
        return l;
    }

    static void a(it it1, Object aobj[])
    {
        it1.publishProgress(aobj);
    }

    protected transient Long a(Void avoid[])
    {
        return Long.valueOf(a());
    }

    public void a(iv iv1)
    {
        a = iv1;
    }

    protected void a(Long long1)
    {
        if (e != null && e.isShowing() && i)
        {
            e.dismiss();
        }
        if (isCancelled())
        {
            return;
        } else
        {
            a.a();
            return;
        }
    }

    protected transient void a(Integer ainteger[])
    {
        if (e == null || !i)
        {
            return;
        }
        if (ainteger.length > 1)
        {
            int j = ainteger[1].intValue();
            e.a(j);
            return;
        } else
        {
            e.b(ainteger[0].intValue());
            return;
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
        if (e != null && i)
        {
            e.a(com.pipcamera.activity.AysDownloadFile.MyProgressDialog.MyProgressStyle.STYLE_MYSPINNER);
            e.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final it a;

                public void onCancel(DialogInterface dialoginterface)
                {
                }

            
            {
                a = it.this;
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
