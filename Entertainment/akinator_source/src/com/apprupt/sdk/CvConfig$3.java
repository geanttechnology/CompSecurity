// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.List;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig

class stener
    implements Runnable
{

    final CvConfig this$0;
    final stener val$listener;

    public void run()
    {
        CvConfig.access$200(CvConfig.this).remove(val$listener);
    }

    stener()
    {
        this$0 = final_cvconfig;
        val$listener = stener.this;
        super();
    }
}
