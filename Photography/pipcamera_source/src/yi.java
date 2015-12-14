// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class yi
{

    private static yi f;
    private final ConcurrentMap a = new ConcurrentHashMap();
    private final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    private Context c;
    private File d;
    private yk e;

    private yi(Context context)
    {
        c = context;
        d = c.getDir("cache", 0);
    }

    static ConcurrentLinkedQueue a(yi yi1)
    {
        return yi1.b;
    }

    public static yi a(Context context)
    {
        if (f == null)
        {
            f = new yi(context);
            f.a();
        }
        return f;
    }

    static File b(yi yi1)
    {
        return yi1.d;
    }

    private byte[] b(String s)
    {
        s = new FileInputStream(new File(s));
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[4096];
        do
        {
            int i = s.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                byte abyte1[] = bytearrayoutputstream.toByteArray();
                s.close();
                bytearrayoutputstream.close();
                return abyte1;
            }
        } while (true);
    }

    static ConcurrentMap c(yi yi1)
    {
        return yi1.a;
    }

    private byte[] c(String s)
    {
label0:
        {
            synchronized (b)
            {
                Iterator iterator = b.iterator();
                yj yj1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    yj1 = (yj)iterator.next();
                } while (yj1.a.compareToIgnoreCase(s) != 0);
                s = yj1.b;
            }
            return s;
        }
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        return null;
        s;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a()
    {
        if (e == null)
        {
            e = new yk(this);
            e.setPriority(4);
        }
        e.start();
    }

    public void a(String s, byte abyte0[])
    {
        yj yj1 = new yj(this);
        yj1.a = s;
        yj1.b = abyte0;
        synchronized (b)
        {
            b.add(yj1);
            b.notify();
        }
        return;
        abyte0;
        s;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public byte[] a(String s)
    {
        boolean flag;
        synchronized (a)
        {
            flag = a.containsKey(s);
        }
        if (flag)
        {
            try
            {
                s = b((String)a.get(s));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return null;
            }
            return s;
        } else
        {
            return c(s);
        }
        s;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b()
    {
        synchronized (b)
        {
            b.clear();
        }
        obj = d.listFiles();
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            obj[i].delete();
        }

        break MISSING_BLOCK_LABEL_55;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
