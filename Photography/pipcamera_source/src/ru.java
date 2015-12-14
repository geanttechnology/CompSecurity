// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.pipcamera.activity.AysDownloadFile.MyProgressDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ru extends AsyncTask
{

    rv a;
    public boolean b;
    String c;
    String d;
    private final String e = "CopyFileTask";
    private MyProgressDialog f;
    private int g;
    private Context h;

    public ru(Context context, boolean flag, String s, String s1)
    {
        g = 0;
        b = flag;
        if (context != null)
        {
            if (b)
            {
                f = new MyProgressDialog(context);
            }
            h = context;
            c = s;
            d = s1;
            return;
        } else
        {
            f = null;
            return;
        }
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.valueOf(a(h, c, d));
    }

    protected void a(Boolean boolean1)
    {
        if (isCancelled())
        {
            a.a(0);
            return;
        }
        if (!boolean1.booleanValue())
        {
            cancel(true);
            a.a(-1);
            return;
        } else
        {
            a.a(1);
            return;
        }
    }

    public void a(rv rv1)
    {
        a = rv1;
    }

    protected transient void a(Integer ainteger[])
    {
        if (f != null || !b) goto _L2; else goto _L1
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
        a.a(-1);
        if (f == null || !f.isShowing()) goto _L1; else goto _L3
_L3:
        f.dismiss();
        return;
        if (f == null) goto _L1; else goto _L4
_L4:
        f.a(i);
        return;
        if (f != null)
        {
            f.b(ainteger[0].intValue());
        }
        Log.i("downloading apk", (new StringBuilder()).append("........").append(ainteger[0].intValue()).toString());
        return;
    }

    public boolean a(Context context, String s, String s1)
    {
        int i;
        int j;
        try
        {
            context = context.getAssets().open(s);
            File file = new File(s1);
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(s1).append(s).toString());
            file.createNewFile();
            s = new FileOutputStream(s);
            s1 = new byte[1024];
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return false;
        }
        i = 0;
        j = context.read(s1);
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s.write(s1, 0, j);
        j = i + 1;
        i = j;
        if (j % 10 != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.i("CopyFile", "CopyFile ...Coping...+10240");
        i = j;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_83;
_L1:
        s.close();
        context.close();
        Log.i("CopyFile", "CopyFile ...Finished");
        return true;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onPreExecute()
    {
        if (f != null)
        {
            f.a(com.pipcamera.activity.AysDownloadFile.MyProgressDialog.MyProgressStyle.STYLE_MYPROGRESS);
            f.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final ru a;

                public void onCancel(DialogInterface dialoginterface)
                {
                    a.cancel(true);
                }

            
            {
                a = ru.this;
                super();
            }
            });
            f.show();
        }
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
