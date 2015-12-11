// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;


// Referenced classes of package com.aio.downloader.views:
//            ClearView

class val.angle extends Thread
{

    final ClearView this$0;
    private final int val$angle;

    public void run()
    {
_L3:
        if (!ClearView.access$0(ClearView.this))
        {
            return;
        }
        ClearView clearview;
        try
        {
            Thread.sleep(8L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        if (!state) goto _L2; else goto _L1
_L1:
        clearview = ClearView.this;
        ClearView.access$2(clearview, ClearView.access$1(clearview) - 2);
        if (ClearView.access$1(ClearView.this) <= 0)
        {
            ClearView.access$2(ClearView.this, 0);
            state = false;
        }
_L4:
        ClearView clearview1;
        if (ClearView.access$1(ClearView.this) < 100)
        {
            ClearView.access$4(ClearView.this, 0xff75a7f9);
        } else
        if (ClearView.access$1(ClearView.this) < 250)
        {
            ClearView.access$4(ClearView.this, 0xff75a7f9);
        } else
        {
            ClearView.access$4(ClearView.this, 0xff75a7f9);
        }
        postInvalidate();
        if (true) goto _L3; else goto _L2
_L2:
        clearview1 = ClearView.this;
        ClearView.access$2(clearview1, ClearView.access$1(clearview1) + 2);
        if (ClearView.access$1(ClearView.this) >= val$angle)
        {
            ClearView.access$2(ClearView.this, val$angle);
            ClearView.access$3(ClearView.this, false);
        }
          goto _L4
    }

    ()
    {
        this$0 = final_clearview;
        val$angle = I.this;
        super();
    }
}
