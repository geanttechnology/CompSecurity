// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;


// Referenced classes of package com.livemixtapes:
//            Mixtape

class val.action
    implements Runnable
{

    final Mixtape this$0;
    private final int val$action;

    public void run()
    {
        if (val$action == 1)
        {
            playAll();
        } else
        if (val$action == 2)
        {
            downloadAll();
            return;
        }
    }

    ()
    {
        this$0 = final_mixtape;
        val$action = I.this;
        super();
    }
}
