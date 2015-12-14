// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.socialin.android.d;
import com.socialin.android.util.ae;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.net:
//            a, c, b

public class e extends a
{

    private final String e = com/socialin/android/net/e.getSimpleName();
    private c f;
    private Handler g;
    private Runnable h;
    private String i;
    private String j;
    private Activity k;

    public e(Activity activity)
    {
        super(activity);
        f = null;
        g = null;
        h = null;
        i = "";
        j = "";
        k = null;
        k = activity;
        f = new c(activity);
        g = new Handler();
        h = new _cls1();
    }

    static String a(e e1)
    {
        return e1.i;
    }

    static String a(e e1, InputStream inputstream, String s)
    {
        return e1.a(inputstream, s);
    }

    static String a(e e1, String s)
    {
        e1.i = s;
        return s;
    }

    private String a(InputStream inputstream, String s)
    {
        File file;
        file = new File(s);
        file.getParentFile().mkdirs();
        file.createNewFile();
        Object obj1 = new FileOutputStream(file);
        Throwable throwable = null;
        byte abyte0[] = new byte[1024];
_L4:
        int l = inputstream.read(abyte0);
        if (l == -1) goto _L2; else goto _L1
_L1:
        if (d) goto _L2; else goto _L3
_L3:
        ((OutputStream) (obj1)).write(abyte0, 0, l);
          goto _L4
        throwable;
        throw throwable;
        Object obj;
        obj;
_L10:
        if (throwable == null) goto _L6; else goto _L5
_L5:
        ((OutputStream) (obj1)).close();
_L8:
        throw obj;
        obj;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
_L7:
        inputstream.close();
        return s;
_L2:
        ((OutputStream) (obj1)).flush();
        ((OutputStream) (obj1)).close();
          goto _L7
        s;
        inputstream.close();
        throw s;
        obj1;
        throwable.addSuppressed(((Throwable) (obj1)));
          goto _L8
_L6:
        ((OutputStream) (obj1)).close();
          goto _L8
        obj;
        com.socialin.android.d.b(e, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L7
        obj;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static String a(String s)
    {
        return b(s);
    }

    static String b(e e1)
    {
        return e1.j;
    }

    private static String b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = ".png";
        } else
        {
            String s1 = s.substring(s.lastIndexOf("."), s.length());
            s = s1;
            if (s1.contains("?"))
            {
                return s1.substring(0, s1.indexOf("?"));
            }
        }
        return s;
    }

    static c c(e e1)
    {
        return e1.f;
    }

    static Runnable d(e e1)
    {
        return e1.h;
    }

    static Handler e(e e1)
    {
        return e1.g;
    }

    static String f(e e1)
    {
        return e1.e;
    }

    static Activity g(e e1)
    {
        return e1.k;
    }

    public final long a(String s, String s1, String s2, String s3, boolean flag)
    {
        return f.a(s, s1, s2, s3, false);
    }

    public final BroadcastReceiver a()
    {
        return f.a();
    }

    public final void a(ArrayList arraylist, String s, b b1)
    {
        int l = arraylist.size();
        if (l == 0)
        {
            return;
        } else
        {
            j = s;
            String as[] = new String[l];
            ProgressDialog progressdialog = new ProgressDialog(k);
            progressdialog.setProgressStyle(1);
            progressdialog.setTitle("Downloading images.");
            progressdialog.setMessage("Downloading");
            progressdialog.setIndeterminate(false);
            progressdialog.setMax(l);
            k.runOnUiThread(new _cls4(progressdialog));
            progressdialog.setCancelable(true);
            progressdialog.setOnCancelListener(new _cls5());
            f.a(c);
            (new _cls6(l, b1, as, arraylist, s, progressdialog)).execute(new Integer[] {
                Integer.valueOf(0)
            });
            return;
        }
    }

    public final String[] a(List list, String s, b b1)
    {
        int l = list.size();
        if (l == 0)
        {
            b1 = null;
        } else
        {
            j = s;
            String as[] = new String[l];
            ProgressDialog progressdialog = new ProgressDialog(k);
            progressdialog.setProgressStyle(1);
            progressdialog.setTitle("Downloading images.");
            progressdialog.setMessage("Downloading");
            progressdialog.setIndeterminate(false);
            progressdialog.setMax(l);
            progressdialog.show();
            progressdialog.setCancelable(true);
            progressdialog.setOnCancelListener(new _cls2());
            b1 = new _cls3(b1, as, progressdialog, list, s);
            f.a(b1);
            b1 = as;
            if (l != 0)
            {
                list = (String)list.get(0);
                b1 = (new StringBuilder()).append(ae.b(list)).append(b(list)).toString();
                as[0] = (new StringBuilder()).append(s).append(b1).toString();
                a(((String) (list)), (new StringBuilder()).append(s).append(b1).toString(), null, null, false);
                return as;
            }
        }
        return b1;
    }

    protected final String c()
    {
        return "intent.action.download.complete";
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
