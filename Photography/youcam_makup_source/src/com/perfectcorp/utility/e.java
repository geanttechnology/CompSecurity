// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Referenced classes of package com.perfectcorp.utility:
//            f

public class e
{

    public static boolean a = false;
    public static Context b;
    private static SimpleDateFormat c;
    private static SimpleDateFormat d;
    private static SimpleDateFormat e;
    private static FileOutputStream f;
    private static long g = 0x240c8400L;
    private static BlockingQueue h;
    private static String i = null;
    private static ThreadPoolExecutor j;

    public static transient int a(Object aobj[])
    {
        if (f())
        {
            return 0;
        } else
        {
            aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
            a(((f) (aobj)).b, ((f) (aobj)).a);
            return Log.v(((f) (aobj)).a, ((f) (aobj)).b);
        }
    }

    public static String a()
    {
        String s;
        try
        {
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("Beauty Circle").append(File.separator).toString();
            File file = new File(s);
            if (!file.exists())
            {
                file.mkdir();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return "";
        }
        return s;
    }

    public static String a(Context context, ArrayList arraylist)
    {
        a(d());
        if (arraylist != null && arraylist.size() != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        Context context1;
        ZipOutputStream zipoutputstream;
        String s;
        obj = context.getPackageManager();
        context = context.getPackageName();
        boolean flag;
        try
        {
            context = ((PackageManager) (obj)).getPackageInfo(context, 0).applicationInfo.dataDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context == null) goto _L1; else goto _L3
_L3:
        context = a();
        try
        {
            flag = (new File(context)).canWrite();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        if (!flag) goto _L1; else goto _L4
_L4:
        s = d();
        context = new File(s);
        if (context.exists())
        {
            context.delete();
        }
        context = new FileOutputStream(context);
        zipoutputstream = new ZipOutputStream(context);
        obj = zipoutputstream;
        context1 = context;
        arraylist = arraylist.iterator();
_L6:
        obj = zipoutputstream;
        context1 = context;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = zipoutputstream;
        context1 = context;
        a((File)arraylist.next(), zipoutputstream);
        if (true) goto _L6; else goto _L5
        obj;
        arraylist = context;
        context = zipoutputstream;
_L12:
        ((FileNotFoundException) (obj)).printStackTrace();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        context.close();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        arraylist.close();
        context = null;
_L7:
        return context;
_L5:
        obj = zipoutputstream;
        context1 = context;
        zipoutputstream.close();
        obj = zipoutputstream;
        context1 = context;
        context.close();
        if (zipoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        zipoutputstream.close();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        context.close();
        context = s;
          goto _L7
        context;
        context.printStackTrace();
        context = s;
          goto _L7
        context;
        context.printStackTrace();
        context = null;
          goto _L7
        IOException ioexception;
        ioexception;
        arraylist = null;
        context = null;
_L10:
        obj = arraylist;
        context1 = context;
        ioexception.printStackTrace();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        arraylist.close();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        context.close();
        context = null;
          goto _L7
        context;
        context.printStackTrace();
        context = null;
          goto _L7
        arraylist;
        obj = null;
        context = null;
_L9:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        ((ZipOutputStream) (obj)).close();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        throw arraylist;
        arraylist;
        obj = null;
        continue; /* Loop/switch isn't completed */
        arraylist;
        context = context1;
        continue; /* Loop/switch isn't completed */
        obj;
        ArrayList arraylist1 = arraylist;
        arraylist = ((ArrayList) (obj));
        obj = context;
        context = arraylist1;
        if (true) goto _L9; else goto _L8
_L8:
        ioexception;
        arraylist = null;
          goto _L10
        ioexception;
        arraylist = zipoutputstream;
          goto _L10
        obj;
        context = null;
        arraylist = null;
        continue; /* Loop/switch isn't completed */
        obj;
        Object obj1 = null;
        arraylist = context;
        context = obj1;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static String a(boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = b();
        } else
        {
            obj = a();
        }
        obj = new File(((String) (obj)));
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdir();
        }
        return ((File) (obj)).toString();
    }

    public static String a(boolean flag, String s, String s1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        return ((String) (obj));
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj = a();
_L6:
        obj = new File(((String) (obj)), s1);
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).createNewFile();
        }
        s1 = new FileOutputStream(((File) (obj)));
        s1.write(s.getBytes());
        s1.flush();
        s = ((File) (obj)).getPath();
        obj = s;
        if (s1 == null) goto _L2; else goto _L5
_L5:
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return s;
        }
        return s;
        obj = b();
          goto _L6
        s;
        s1 = null;
_L10:
        obj = obj1;
        if (s1 == null) goto _L2; else goto _L7
_L7:
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return null;
        s;
        s1 = null;
_L9:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        if (true) goto _L9; else goto _L8
_L8:
        s;
          goto _L10
    }

    public static void a(Activity activity)
    {
        if (activity == null)
        {
            return;
        } else
        {
            File file = new File(d());
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.SUBJECT", "Log File").putExtra("android.intent.extra.TEXT", String.format(Locale.getDefault(), "Send %1$s file.", new Object[] {
                file.getName()
            })).putExtra("android.intent.extra.STREAM", Uri.fromFile(file)).putExtra("android.intent.extra.EMAIL", e()).setType("application/zip");
            activity.startActivity(Intent.createChooser(intent, "Choose an Email client."));
            return;
        }
    }

    public static void a(Activity activity, String s)
    {
        SpannableString spannablestring = new SpannableString(s);
        spannablestring.setSpan(new android.text.style.AlignmentSpan.Standard(android.text.Layout.Alignment.ALIGN_CENTER), 0, s.length() - 1, 18);
        activity = Toast.makeText(activity, spannablestring, 1);
        activity.setGravity(17, 0, 0);
        activity.show();
    }

    public static void a(Context context)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new File(i));
        a(context, arraylist);
    }

    public static void a(File file, String s, ZipOutputStream zipoutputstream)
    {
        byte abyte0[] = new byte[1024];
        FileInputStream fileinputstream = new FileInputStream(file);
        if (s != null)
        {
            zipoutputstream.putNextEntry(new ZipEntry((new StringBuilder()).append(s).append("/").append(file.getName()).toString()));
        } else
        {
            zipoutputstream.putNextEntry(new ZipEntry(file.getName()));
        }
        do
        {
            int k = fileinputstream.read(abyte0);
            if (k > 0)
            {
                zipoutputstream.write(abyte0, 0, k);
            } else
            {
                fileinputstream.close();
                return;
            }
        } while (true);
    }

    public static void a(File file, ZipOutputStream zipoutputstream)
    {
        a(file, null, zipoutputstream);
    }

    public static void a(String s)
    {
        s = new File(s);
        if (s.exists())
        {
            s.delete();
        }
    }

    protected static void a(String s, String s1)
    {
        if (j == null)
        {
            return;
        } else
        {
            j.execute(new Runnable(s, s1) {

                final String a;
                final String b;

                public void run()
                {
                    e.b(a, b);
                }

            
            {
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public static transient int b(Object aobj[])
    {
        if (f())
        {
            return 0;
        } else
        {
            aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
            a(((f) (aobj)).b, ((f) (aobj)).a);
            return Log.d(((f) (aobj)).a, ((f) (aobj)).b);
        }
    }

    private static File b(String s)
    {
        Object obj = new Date();
        synchronized (d)
        {
            obj = (new StringBuilder()).append(d.format(((Date) (obj)))).append(".log").toString();
        }
        s = new File(s, ((String) (obj)));
        i = s.getAbsolutePath();
        if (s.exists())
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_74;
        s;
        simpledateformat;
        JVM INSTR monitorexit ;
        throw s;
        try
        {
            s.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static String b()
    {
        String s = "";
        if (b != null)
        {
            try
            {
                s = (new StringBuilder()).append(b.getCacheDir().toString()).append(File.separator).append("Beauty Circle").append(File.separator).toString();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return "";
            }
        }
        return s;
    }

    public static String b(boolean flag)
    {
        Object obj2 = null;
        Object obj = Runtime.getRuntime().exec("logcat -d -v time").getInputStream();
        Object obj4 = new Date();
        synchronized (e)
        {
            obj4 = (new StringBuilder()).append(e.format(((Date) (obj4)))).append("_logcat.log").toString();
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        obj1 = a();
_L8:
        obj1 = new File(((String) (obj1)), ((String) (obj4)));
        if (!((File) (obj1)).exists())
        {
            ((File) (obj1)).createNewFile();
        }
        obj5 = ((File) (obj1)).toString();
        obj1 = new FileOutputStream(((File) (obj1)));
        obj2 = new byte[4096];
_L5:
        int k = ((InputStream) (obj)).read(((byte []) (obj2)));
        if (k == -1) goto _L4; else goto _L3
_L3:
        ((OutputStream) (obj1)).write(((byte []) (obj2)), 0, k);
          goto _L5
        obj2;
        obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L11:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj == null) goto _L7; else goto _L6
_L6:
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj = null;
        return ((String) (obj));
        obj5;
        obj1;
        JVM INSTR monitorexit ;
        throw obj5;
_L2:
        obj1 = b();
          goto _L8
_L4:
        ((OutputStream) (obj1)).flush();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        obj = obj5;
        if (obj1 != null)
        {
            try
            {
                ((OutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return ((String) (obj5));
            }
            return ((String) (obj5));
        } else
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj1;
        obj = null;
_L10:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (obj2 != null)
        {
            try
            {
                ((OutputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        obj2 = obj1;
        obj1 = exception1;
        if (true) goto _L10; else goto _L9
_L9:
        obj;
        obj = null;
        obj1 = null;
          goto _L11
_L7:
        return null;
        Exception exception;
        exception;
        Object obj3 = null;
        exception = ((Exception) (obj));
        obj = obj3;
          goto _L11
    }

    static void b(String s, String s1)
    {
        c(s, s1);
    }

    public static transient int c(Object aobj[])
    {
        if (f())
        {
            return 0;
        } else
        {
            aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
            a(((f) (aobj)).b, ((f) (aobj)).a);
            return Log.i(((f) (aobj)).a, ((f) (aobj)).b);
        }
    }

    public static void c()
    {
        long l1 = System.currentTimeMillis();
        File afile[] = (new File(a(true).toString())).listFiles();
        if (afile != null)
        {
            int l = afile.length;
            for (int k = 0; k < l; k++)
            {
                File file = afile[k];
                if (l1 - file.lastModified() > g)
                {
                    file.delete();
                }
            }

        }
    }

    private static void c(String s, String s1)
    {
        Object obj;
        obj = new Date(System.currentTimeMillis());
        obj = c.format(((Date) (obj)));
        if (f != null) goto _L2; else goto _L1
_L1:
        File file = g();
        if (file != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        try
        {
            f = new FileOutputStream(file, true);
        }
        catch (FileNotFoundException filenotfoundexception) { }
_L2:
        if (f != null)
        {
            try
            {
                s1 = (new StringBuilder()).append("======== ").append(s1).append(" ========\n").toString();
                s1 = (new StringBuilder()).append(s1).append("timestamp: ").append(((String) (obj))).append("\n").toString();
                s = (new StringBuilder()).append(s1).append(s).append("\n\n").toString();
                f.write(s.getBytes());
                f.flush();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static transient int d(Object aobj[])
    {
        if (f())
        {
            return 0;
        } else
        {
            aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
            a(((f) (aobj)).b, ((f) (aobj)).a);
            return Log.w(((f) (aobj)).a, ((f) (aobj)).b);
        }
    }

    public static String d()
    {
        return (new StringBuilder()).append(a()).append("CL_LOGCAT_DATA.zip").toString();
    }

    public static transient int e(Object aobj[])
    {
        if (f())
        {
            return 0;
        } else
        {
            aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
            a(((f) (aobj)).b, ((f) (aobj)).a);
            return Log.e(((f) (aobj)).a, ((f) (aobj)).b);
        }
    }

    public static String[] e()
    {
        return (new String[] {
            "tommy_chang@perfectcorp.com"
        });
    }

    public static transient int f(Object aobj[])
    {
        aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
        a(((f) (aobj)).b, ((f) (aobj)).a);
        return Log.d(((f) (aobj)).a, ((f) (aobj)).b);
    }

    private static boolean f()
    {
        while (a || Log.isLoggable("LOG_TAG_BC", 2)) 
        {
            return false;
        }
        return true;
    }

    public static transient int g(Object aobj[])
    {
        aobj = new f(Thread.currentThread().getStackTrace()[3], aobj);
        a(((f) (aobj)).b, ((f) (aobj)).a);
        return Log.e(((f) (aobj)).a, ((f) (aobj)).b);
    }

    private static File g()
    {
        return b(a(true).toString());
    }

    static 
    {
        c = new SimpleDateFormat("MM/dd HH:mm:ss.S", Locale.US);
        d = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        e = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        h = new LinkedBlockingQueue();
        j = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS, h, new ThreadFactory() {

            int a;

            public Thread newThread(Runnable runnable)
            {
                this;
                JVM INSTR monitorenter ;
                int k;
                k = a;
                a = k + 1;
                this;
                JVM INSTR monitorexit ;
                return new Thread(runnable, (new StringBuilder()).append("BCLog #").append(k).toString());
                runnable;
                this;
                JVM INSTR monitorexit ;
                throw runnable;
            }

            
            {
                a = 0;
            }
        });
    }
}
