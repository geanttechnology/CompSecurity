// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;


// Referenced classes of package bolts:
//            CancellationTokenSource

class this._cls0
    implements Runnable
{

    final CancellationTokenSource this$0;

    public void run()
    {
        synchronized (CancellationTokenSource.access$000(CancellationTokenSource.this))
        {
            CancellationTokenSource.access$102(CancellationTokenSource.this, null);
        }
        cancel();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = CancellationTokenSource.this;
        super();
    }
}
