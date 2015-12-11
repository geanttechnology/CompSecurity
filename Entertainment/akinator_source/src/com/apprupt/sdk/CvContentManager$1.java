// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvContentManager, CvPreloaderResponse

class eloaderListener
    implements Runnable
{

    final CvContentManager this$0;
    final eloaderListener val$listener;

    public void run()
    {
        val$listener.onPreloaderFinish(new CvPreloaderResponse());
    }

    eloaderListener()
    {
        this$0 = final_cvcontentmanager;
        val$listener = eloaderListener.this;
        super();
    }
}
