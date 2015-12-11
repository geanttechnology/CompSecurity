// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public final class av
    implements Thread.UncaughtExceptionHandler
{

    private final Context a;
    private final ScheduledExecutorService b;
    private final Thread.UncaughtExceptionHandler c;
    private volatile ao d;
    private final az e;
    private final ba f;

    av(Context context, ScheduledExecutorService scheduledexecutorservice, Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        this(context, scheduledexecutorservice, uncaughtexceptionhandler, az.a);
    }

    private av(Context context, ScheduledExecutorService scheduledexecutorservice, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, az az1)
    {
        a = context;
        b = scheduledexecutorservice;
        c = uncaughtexceptionhandler;
        e = az1;
        f = new ba(99);
    }

    static Context a(av av1)
    {
        return av1.a;
    }

    static File a(Context context)
    {
        return b(context);
    }

    private void a(bd bd1)
    {
        bd1.a("bcs").f().d();
        Iterator iterator = f.iterator();
        for (boolean flag = false; iterator.hasNext(); flag = true)
        {
            at at1 = (at)iterator.next();
            if (flag)
            {
                bd1.a();
            }
            bd1.b().a("ts", at1.a).a().a("text", at1.b).c();
        }

        bd1.e();
    }

    private static File b(Context context)
    {
        return new File((new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/crash-reports").toString());
    }

    private static void b(bd bd1)
    {
        Object obj;
        if (l.c != null)
        {
            if ((obj = l.c.o.b()) != null)
            {
                bd1.a();
                bd1.a("userdata").f().b();
                obj = ((Map) (obj)).entrySet().iterator();
                for (boolean flag = false; ((Iterator) (obj)).hasNext(); flag = true)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    if (flag)
                    {
                        bd1.a();
                    }
                    bd1.a((String)entry.getKey(), (String)entry.getValue());
                }

                bd1.c();
                return;
            }
        }
    }

    public final int a()
    {
        File afile[] = b(a).listFiles(new FilenameFilter() {

            public final boolean accept(File file, String s)
            {
                return s.startsWith("crash-");
            }

        });
        if (afile == null)
        {
            return 0;
        } else
        {
            return afile.length;
        }
    }

    public final void a(ao ao1)
    {
        d = ao1;
    }

    public final void a(ao ao1, ah ah)
    {
        b.submit(new aw(this, ao1, ah));
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        long l1 = System.currentTimeMillis();
        Object obj;
        bc.a((new StringBuilder("Writing stack trace to disk from thread: [")).append(Thread.currentThread()).append("]").toString());
        obj = b(a);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        if (((File) (obj)).mkdirs()) goto _L4; else goto _L3
_L3:
        bc.a((new StringBuilder("Unable to create output directory: ")).append(obj).append(". Not writing crash reports...").toString());
_L5:
        obj = l.c;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        ((l) (obj)).a();
        if (d != null)
        {
            d.b();
            d.e();
        }
_L7:
        if (c != null)
        {
            c.uncaughtException(thread, throwable);
        }
        return;
_L4:
        bc.a((new StringBuilder("Created output directory: ")).append(obj).toString());
_L2:
        String s = (new StringBuilder()).append(obj).append("/crash-").append(System.currentTimeMillis()).toString();
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(new FileOutputStream(s));
        obj = outputstreamwriter;
        bd bd1 = new bd(outputstreamwriter);
        obj = outputstreamwriter;
        bd1.b().a("type", "crash-report").a();
        obj = outputstreamwriter;
        if (l.d == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        obj = outputstreamwriter;
        bd1.a("ec", l.d.g()).a();
        obj = outputstreamwriter;
        bc.a("Adding device specific information to json packet");
        obj = outputstreamwriter;
        if (l.c == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        obj = outputstreamwriter;
        l.c.n.a(bd1);
        obj = outputstreamwriter;
        bd1.a();
        obj = outputstreamwriter;
        l.c.n.b(bd1);
        obj = outputstreamwriter;
        bd1.a();
        obj = outputstreamwriter;
        bd1.a("androidCrashReport").f();
        obj = outputstreamwriter;
        bd1.b().a("stackTrace").f().a(throwable, true).a().a("thread", thread.toString()).a().a("time", l1).c().a();
        obj = outputstreamwriter;
        a(bd1);
        obj = outputstreamwriter;
        b(bd1);
        obj = outputstreamwriter;
        bd1.c();
        obj = outputstreamwriter;
        outputstreamwriter.flush();
        obj = outputstreamwriter;
        bc.a((new StringBuilder("Completed writing contents to file: ")).append(s).toString());
        bc.a(outputstreamwriter);
          goto _L5
_L6:
        bc.a("Error trying to write stacktrace to disk..", ((Throwable) (obj)));
          goto _L5
        Exception exception1;
        exception1;
        outputstreamwriter = null;
_L9:
        obj = outputstreamwriter;
        bc.b((new StringBuilder("Exception trying to write to file: ")).append(s).toString(), exception1);
        bc.a(outputstreamwriter);
          goto _L5
_L8:
        Exception exception;
        try
        {
            bc.a(((java.io.Closeable) (obj)));
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            if (c != null)
            {
                c.uncaughtException(thread, throwable);
            }
            throw obj;
        }
          goto _L6
        Throwable throwable1;
        throwable1;
        bc.b("Exception trying to clear up the beacon queue...", throwable1);
          goto _L7
        exception;
          goto _L8
        exception1;
          goto _L9
        exception;
        throwable1 = null;
          goto _L8
    }
}
