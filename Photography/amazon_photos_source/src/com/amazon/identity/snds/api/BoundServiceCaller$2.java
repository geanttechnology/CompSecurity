// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;


// Referenced classes of package com.amazon.identity.snds.api:
//            BoundServiceCaller

class this._cls0
    implements Runnable
{

    final BoundServiceCaller this$0;

    public void run()
    {
label0:
        {
            synchronized (BoundServiceCaller.access$100(BoundServiceCaller.this))
            {
                if (!BoundServiceCaller.access$000(BoundServiceCaller.this))
                {
                    break label0;
                }
            }
            return;
        }
        BoundServiceCaller.access$202(BoundServiceCaller.this, null);
        aobj;
        JVM INSTR monitorexit ;
        serviceTimedOut();
        return;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = BoundServiceCaller.this;
        super();
    }
}
