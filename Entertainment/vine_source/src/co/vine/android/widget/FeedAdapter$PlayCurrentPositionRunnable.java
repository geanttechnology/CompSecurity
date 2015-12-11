// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;


// Referenced classes of package co.vine.android.widget:
//            FeedAdapter

public class this._cls0
    implements Runnable
{

    final FeedAdapter this$0;

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        int i = FeedAdapter.access$900(FeedAdapter.this);
        if (i <= -1) goto _L2; else goto _L1
_L1:
        if (FeedAdapter.access$1000(FeedAdapter.this, i)) goto _L4; else goto _L3
_L3:
        play(i);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        pauseCurrentPlayer();
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public ()
    {
        this$0 = FeedAdapter.this;
        super();
    }
}
