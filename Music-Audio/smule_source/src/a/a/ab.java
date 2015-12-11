// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            ai

final class ab
    implements android.os.MessageQueue.IdleHandler
{

    private boolean a;

    private ab()
    {
        a = false;
    }

    ab(byte byte0)
    {
        this();
    }

    public final boolean queueIdle()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a)
        {
            a = true;
            ai.b();
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }
}
