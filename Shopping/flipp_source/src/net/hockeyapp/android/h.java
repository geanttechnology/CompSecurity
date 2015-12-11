// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.os.Process;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

// Referenced classes of package net.hockeyapp.android:
//            a, g

public final class h
    implements Thread.UncaughtExceptionHandler
{

    g a;
    private boolean b;
    private Thread.UncaughtExceptionHandler c;

    public h(Thread.UncaughtExceptionHandler uncaughtexceptionhandler, g g1, boolean flag)
    {
        b = false;
        c = uncaughtexceptionhandler;
        b = flag;
        a = g1;
    }

    private static String a(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.length() > 255)
            {
                s1 = s.substring(0, 255);
            }
        }
        return s1;
    }

    private static void a(String s, String s1)
    {
        try
        {
            s1 = (new StringBuilder()).append(a.a).append("/").append(s1).toString();
            if (s.trim().length() > 0)
            {
                s1 = new BufferedWriter(new FileWriter(s1));
                s1.write(s);
                s1.flush();
                s1.close();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        g g1;
        Date date;
        StringWriter stringwriter;
        if (a.a == null)
        {
            c.uncaughtException(thread, throwable);
            return;
        }
        g1 = a;
        date = new Date();
        stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        String s;
        s = UUID.randomUUID().toString();
        Object obj = (new StringBuilder()).append(a.a).append("/").append(s).append(".stacktrace").toString();
        Log.d("HockeyApp", (new StringBuilder("Writing unhandled exception to: ")).append(((String) (obj))).toString());
        obj = new BufferedWriter(new FileWriter(((String) (obj))));
        ((BufferedWriter) (obj)).write((new StringBuilder("Package: ")).append(a.d).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Version Code: ")).append(a.b).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Version Name: ")).append(a.c).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Android: ")).append(a.e).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Manufacturer: ")).append(a.g).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Model: ")).append(a.f).append("\n").toString());
        ((BufferedWriter) (obj)).write((new StringBuilder("Date: ")).append(date).append("\n").toString());
        ((BufferedWriter) (obj)).write("\n");
        ((BufferedWriter) (obj)).write(stringwriter.toString());
        ((BufferedWriter) (obj)).flush();
        ((BufferedWriter) (obj)).close();
        if (g1 != null)
        {
            try
            {
                a(a(g1.b()), (new StringBuilder()).append(s).append(".user").toString());
                a(a(null), (new StringBuilder()).append(s).append(".contact").toString());
                a(null, (new StringBuilder()).append(s).append(".description").toString());
            }
            catch (Exception exception)
            {
                Log.e("HockeyApp", "Error saving exception stacktrace!\n", exception);
            }
        }
        if (!b)
        {
            c.uncaughtException(thread, throwable);
            return;
        } else
        {
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
    }
}
