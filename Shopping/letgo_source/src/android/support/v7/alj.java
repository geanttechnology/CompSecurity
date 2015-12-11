// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package android.support.v7:
//            alb, ali, akh, akf, 
//            alh, ako, akx

final class alj
{
    private static class a
    {

        static int a(ActivityManager activitymanager)
        {
            return activitymanager.getLargeMemoryClass();
        }
    }

    private static class b
    {

        static int a(Bitmap bitmap)
        {
            return bitmap.getByteCount();
        }
    }

    private static class c
    {

        static ako a(Context context)
        {
            return new akx(context);
        }
    }

    private static class d extends Thread
    {

        public void run()
        {
            Process.setThreadPriority(10);
            super.run();
        }

        public d(Runnable runnable)
        {
            super(runnable);
        }
    }

    static class e
        implements ThreadFactory
    {

        public Thread newThread(Runnable runnable)
        {
            return new d(runnable);
        }

        e()
        {
        }
    }


    static final StringBuilder a = new StringBuilder();

    static int a(Resources resources, alb alb1)
        throws FileNotFoundException
    {
        if (alb1.e != 0 || alb1.d == null)
        {
            return alb1.e;
        }
        String s = alb1.d.getAuthority();
        if (s == null)
        {
            throw new FileNotFoundException((new StringBuilder()).append("No package provided: ").append(alb1.d).toString());
        }
        List list = alb1.d.getPathSegments();
        if (list == null || list.isEmpty())
        {
            throw new FileNotFoundException((new StringBuilder()).append("No path segments: ").append(alb1.d).toString());
        }
        if (list.size() == 1)
        {
            int i;
            try
            {
                i = Integer.parseInt((String)list.get(0));
            }
            // Misplaced declaration of an exception variable
            catch (Resources resources)
            {
                throw new FileNotFoundException((new StringBuilder()).append("Last path segment is not a resource ID: ").append(alb1.d).toString());
            }
            return i;
        }
        if (list.size() == 2)
        {
            alb1 = (String)list.get(0);
            return resources.getIdentifier((String)list.get(1), alb1, s);
        } else
        {
            throw new FileNotFoundException((new StringBuilder()).append("More than two path segments: ").append(alb1.d).toString());
        }
    }

    static int a(Bitmap bitmap)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            i = b.a(bitmap);
        } else
        {
            i = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (i < 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("Negative size: ").append(bitmap).toString());
        } else
        {
            return i;
        }
    }

    static long a(File file)
    {
        long l;
        try
        {
            file = new StatFs(file.getAbsolutePath());
            l = file.getBlockCount();
            l = ((long)file.getBlockSize() * l) / 50L;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            l = 0x500000L;
        }
        return Math.max(Math.min(l, 0x3200000L), 0x500000L);
    }

    static Resources a(Context context, alb alb1)
        throws FileNotFoundException
    {
        if (alb1.e != 0 || alb1.d == null)
        {
            return context.getResources();
        }
        String s = alb1.d.getAuthority();
        if (s == null)
        {
            throw new FileNotFoundException((new StringBuilder()).append("No package provided: ").append(alb1.d).toString());
        }
        try
        {
            context = context.getPackageManager().getResourcesForApplication(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new FileNotFoundException((new StringBuilder()).append("Unable to obtain resources for package: ").append(alb1.d).toString());
        }
        return context;
    }

    static ako a(Context context)
    {
        ako ako;
        try
        {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            ako = c.a(context);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return new ali(context);
        }
        return ako;
    }

    static Object a(Context context, String s)
    {
        return context.getSystemService(s);
    }

    static Object a(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException(s);
        } else
        {
            return obj;
        }
    }

    static String a(akh akh1)
    {
        return a(akh1, "");
    }

    static String a(akh akh1, String s)
    {
        s = new StringBuilder(s);
        akf akf1 = akh1.i();
        if (akf1 != null)
        {
            s.append(akf1.b.a());
        }
        akh1 = akh1.k();
        if (akh1 != null)
        {
            int j = akh1.size();
            for (int i = 0; i < j; i++)
            {
                if (i > 0 || akf1 != null)
                {
                    s.append(", ");
                }
                s.append(((akf)akh1.get(i)).b.a());
            }

        }
        return s.toString();
    }

    static String a(alb alb1)
    {
        alb1 = a(alb1, a);
        a.setLength(0);
        return alb1;
    }

    static String a(alb alb1, StringBuilder stringbuilder)
    {
        int i;
        int j;
        if (alb1.f != null)
        {
            stringbuilder.ensureCapacity(alb1.f.length() + 50);
            stringbuilder.append(alb1.f);
        } else
        if (alb1.d != null)
        {
            String s = alb1.d.toString();
            stringbuilder.ensureCapacity(s.length() + 50);
            stringbuilder.append(s);
        } else
        {
            stringbuilder.ensureCapacity(50);
            stringbuilder.append(alb1.e);
        }
        stringbuilder.append('\n');
        if (alb1.m != 0.0F)
        {
            stringbuilder.append("rotation:").append(alb1.m);
            if (alb1.p)
            {
                stringbuilder.append('@').append(alb1.n).append('x').append(alb1.o);
            }
            stringbuilder.append('\n');
        }
        if (alb1.d())
        {
            stringbuilder.append("resize:").append(alb1.h).append('x').append(alb1.i);
            stringbuilder.append('\n');
        }
        if (!alb1.j) goto _L2; else goto _L1
_L1:
        stringbuilder.append("centerCrop").append('\n');
_L4:
        if (alb1.g != null)
        {
            j = alb1.g.size();
            for (i = 0; i < j; i++)
            {
                stringbuilder.append(((alh)alb1.g.get(i)).a());
                stringbuilder.append('\n');
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (alb1.k)
        {
            stringbuilder.append("centerInside").append('\n');
        }
        if (true) goto _L4; else goto _L3
_L3:
        return stringbuilder.toString();
    }

    static void a()
    {
        if (!b())
        {
            throw new IllegalStateException("Method call should happen from the main thread.");
        } else
        {
            return;
        }
    }

    static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    static void a(String s, String s1, String s2)
    {
        a(s, s1, s2, "");
    }

    static void a(String s, String s1, String s2, String s3)
    {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] {
            s, s1, s2, s3
        }));
    }

    static boolean a(String s)
    {
        boolean flag = true;
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.split(" ", 2);
        if ("CACHE".equals(s[0]))
        {
            return true;
        }
        if (s.length == 1) goto _L1; else goto _L3
_L3:
        if (!"CONDITIONAL_CACHE".equals(s[0])) goto _L5; else goto _L4
_L4:
        int i = Integer.parseInt(s[1]);
        if (i != 304) goto _L5; else goto _L6
_L6:
        return flag;
_L5:
        flag = false;
        if (true) goto _L6; else goto _L7
_L7:
        s;
        return false;
    }

    static File b(Context context)
    {
        context = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!context.exists())
        {
            context.mkdirs();
        }
        return context;
    }

    static boolean b()
    {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean b(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    static byte[] b(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    static int c(Context context)
    {
        ActivityManager activitymanager = (ActivityManager)a(context, "activity");
        int i;
        int j;
        if ((context.getApplicationInfo().flags & 0x100000) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = activitymanager.getMemoryClass();
        if (i != 0 && android.os.Build.VERSION.SDK_INT >= 11)
        {
            i = a.a(activitymanager);
        } else
        {
            i = j;
        }
        return (i * 0x100000) / 7;
    }

    static boolean c(InputStream inputstream)
        throws IOException
    {
        boolean flag1 = false;
        byte abyte0[] = new byte[12];
        boolean flag = flag1;
        if (inputstream.read(abyte0, 0, 12) == 12)
        {
            flag = flag1;
            if ("RIFF".equals(new String(abyte0, 0, 4, "US-ASCII")))
            {
                flag = flag1;
                if ("WEBP".equals(new String(abyte0, 8, 4, "US-ASCII")))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    static boolean d(Context context)
    {
        boolean flag = false;
        context = context.getContentResolver();
        int i;
        try
        {
            i = android.provider.Settings.System.getInt(context, "airplane_mode_on", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (i != 0)
        {
            flag = true;
        }
        return flag;
    }

}
