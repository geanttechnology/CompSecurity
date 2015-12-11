// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvConfig

class tener
    implements Runnable
{

    final CvConfig this$0;
    final tener val$listener;

    public void run()
    {
        val$listener.onConfigUpdated(CvConfig.this);
    }

    tener()
    {
        this$0 = final_cvconfig;
        val$listener = tener.this;
        super();
    }
}
