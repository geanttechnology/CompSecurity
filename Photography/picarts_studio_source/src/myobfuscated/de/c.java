// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.de;

import android.opengl.GLSurfaceView;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import myobfuscated.dd.a;

// Referenced classes of package myobfuscated.de:
//            b

final class c extends Thread
{

    boolean a;
    boolean b;
    final b c;
    private a d;
    private long e;

    public c(b b1, a a1, long l)
    {
        c = b1;
        super();
        a = false;
        setDaemon(true);
        d = a1;
        e = l;
        b = true;
    }

    public final void run()
    {
        this;
        JVM INSTR monitorenter ;
        setName("ConversionWorker");
_L11:
        if (!b) goto _L2; else goto _L1
_L1:
        if (e == myobfuscated.de.b.a(c)) goto _L4; else goto _L3
_L3:
        Log.e("ex", "threadRunUniqueId != previewUniqueId");
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        boolean flag = a;
        if (flag) goto _L6; else goto _L5
_L5:
        Object obj;
        try
        {
            wait();
        }
        catch (InterruptedException interruptedexception) { }
        finally
        {
            this;
        }
        if (true) goto _L4; else goto _L6
_L6:
        a = false;
        obj = myobfuscated.de.b.b(c);
        obj;
        JVM INSTR monitorenter ;
        myobfuscated.de.b.c(c);
        JVM INSTR tableswitch 0 1: default 478
    //                   0 137
    //                   1 350;
           goto _L7 _L8 _L9
_L7:
        if (!myobfuscated.de.b.f(c))
        {
            myobfuscated.de.b.l(c).requestRender();
        }
        yield();
        if (true) goto _L11; else goto _L10
_L10:
        JVM INSTR monitorexit ;
        throw obj;
_L8:
        if (myobfuscated.de.b.d(c) == null || myobfuscated.de.b.e(c) == null || myobfuscated.de.b.f(c)) goto _L7; else goto _L12
_L12:
        myobfuscated.de.b.a(c, true);
        d.a().lock();
        myobfuscated.de.b.d(c).position(0);
        ImageOpCommon.yuv420sp2rgb(myobfuscated.de.b.e(c), myobfuscated.de.b.g(c), myobfuscated.de.b.h(c), myobfuscated.de.b.i(c), myobfuscated.de.b.d(c));
        if (myobfuscated.de.b.d(c) != null && myobfuscated.de.b.e(c) != null)
        {
            myobfuscated.de.b.d(c).position(0);
            d.a(myobfuscated.de.b.d(c));
        }
        d.a().unlock();
        if (myobfuscated.de.b.f(c) && myobfuscated.de.b.j(c))
        {
            Log.e("ex", "isFinishing && removeAfterUsingsNativeBuffers");
            myobfuscated.de.b.k(c);
        }
        myobfuscated.de.b.a(c, false);
          goto _L7
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L9:
        if (myobfuscated.de.b.e(c) == null || myobfuscated.de.b.f(c)) goto _L7; else goto _L13
_L13:
        myobfuscated.de.b.a(c, true);
        d.a().lock();
        myobfuscated.de.b.e(c).position(0);
        d.a(myobfuscated.de.b.e(c));
        d.a().unlock();
        if (myobfuscated.de.b.f(c) && myobfuscated.de.b.j(c))
        {
            Log.e("ex", "isFinishing && removeAfterUsingsNativeBuffers");
            myobfuscated.de.b.k(c);
        }
        myobfuscated.de.b.a(c, false);
          goto _L7
    }
}
