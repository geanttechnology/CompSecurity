// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

class box extends Thread
{

    final bou a;

    private box(bou bou1)
    {
        a = bou1;
        super();
    }

    box(bou bou1, bov bov)
    {
        this(bou1);
    }

    public void run()
    {
_L4:
        if (bou.a(a).size() != 0) goto _L2; else goto _L1
_L1:
        synchronized (bou.a(a))
        {
            bou.a(a).wait();
        }
_L5:
        boolean flag = Thread.interrupted();
        if (!flag) goto _L4; else goto _L3
_L3:
        return;
        exception3;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        bow bow1;
        FileOutputStream fileoutputstream;
        try
        {
            throw exception3;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_236;
_L2:
        synchronized (bou.a(a))
        {
            bow1 = (bow)bou.a(a).peek();
        }
        obj = (new StringBuilder()).append(bou.b(a).getPath()).append("/").append(bow1.a).toString();
        fileoutputstream = new FileOutputStream(new File(((String) (obj))));
        fileoutputstream.write(bow1.b);
        fileoutputstream.close();
        synchronized (bou.c(a))
        {
            bou.c(a).put(bow1.a, obj);
        }
        synchronized (bou.a(a))
        {
            bou.a(a).poll();
        }
        Log.d("BitmapIoCache", (new StringBuilder()).append("One item cached key:").append(bow1.a).toString());
          goto _L5
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        concurrentmap;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        obj;
        JVM INSTR monitorexit ;
        throw exception2;
    }
}
