// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class bou
{

    private static bou f;
    private final ConcurrentMap a = new ConcurrentHashMap();
    private final ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
    private Context c;
    private File d;
    private box e;

    private bou(Context context)
    {
        c = context;
        d = c.getDir("cache", 0);
    }

    public static bou a(Context context)
    {
        if (f == null)
        {
            f = new bou(context);
            f.a();
        }
        return f;
    }

    static ConcurrentLinkedQueue a(bou bou1)
    {
        return bou1.b;
    }

    static File b(bou bou1)
    {
        return bou1.d;
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

    static ConcurrentMap c(bou bou1)
    {
        return bou1.a;
    }

    private byte[] c(String s)
    {
label0:
        {
            synchronized (b)
            {
                Iterator iterator = b.iterator();
                bow bow1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    bow1 = (bow)iterator.next();
                } while (bow1.a.compareToIgnoreCase(s) != 0);
                s = bow1.b;
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
            e = new box(this, null);
            e.setPriority(4);
        }
        e.start();
    }

    public void a(String s, byte abyte0[])
    {
        bow bow1 = new bow(this, null);
        bow1.a = s;
        bow1.b = abyte0;
        synchronized (b)
        {
            b.add(bow1);
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
        if (d != null)
        {
            obj = d.listFiles();
            if (obj != null)
            {
                int j = obj.length;
                for (int i = 0; i < j; i++)
                {
                    obj[i].delete();
                }

            }
        }
        break MISSING_BLOCK_LABEL_66;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
