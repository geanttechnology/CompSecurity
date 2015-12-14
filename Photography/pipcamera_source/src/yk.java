// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

class yk extends Thread
{

    final yi a;

    private yk(yi yi1)
    {
        a = yi1;
        super();
    }

    yk(yi yi1, yi._cls1 _pcls1)
    {
        this(yi1);
    }

    public void run()
    {
_L4:
        if (yi.a(a).size() != 0) goto _L2; else goto _L1
_L1:
        synchronized (yi.a(a))
        {
            yi.a(a).wait();
        }
_L5:
        yj yj1;
        boolean flag;
        try
        {
            flag = Thread.interrupted();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            Crashlytics.logException(interruptedexception);
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Crashlytics.logException(ioexception);
            return;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        return;
        exception3;
        concurrentlinkedqueue;
        JVM INSTR monitorexit ;
        throw exception3;
_L2:
        synchronized (yi.a(a))
        {
            yj1 = (yj)yi.a(a).peek();
        }
        obj = (new StringBuilder()).append(yi.b(a).getPath()).append("/").append(yj1.a).toString();
        FileOutputStream fileoutputstream = new FileOutputStream(new File(((String) (obj))));
        fileoutputstream.write(yj1.b);
        fileoutputstream.close();
        synchronized (yi.c(a))
        {
            yi.c(a).put(yj1.a, obj);
        }
        synchronized (yi.a(a))
        {
            yi.a(a).poll();
        }
        Log.d("BitmapIoCache", (new StringBuilder()).append("One item cached key:").append(yj1.a).toString());
          goto _L5
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
