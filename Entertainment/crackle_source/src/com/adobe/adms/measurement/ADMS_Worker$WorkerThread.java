// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;


// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_Worker, ADMS_Measurement, ADMS_RequestProperties, ADMS_RequestHandler

private static class worker extends Thread
{

    public boolean cancelled;
    private long delay;
    private ADMS_Worker worker;

    public void run()
    {
_L9:
        if (cancelled) goto _L2; else goto _L1
_L1:
        if (!ADMS_Measurement.isOnline())
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (worker.getTrackingQueueSize() <= 0) goto _L4; else goto _L3
_L3:
        Object obj = worker.popRequest();
        if (obj == null) goto _L6; else goto _L5
_L5:
        ADMS_RequestProperties adms_requestproperties = new ADMS_RequestProperties(((String) (obj)));
        if (!ADMS_RequestHandler.sendRequest(adms_requestproperties.getUrl(), adms_requestproperties.getHeaders())) goto _L8; else goto _L7
_L7:
        if (worker.trackOffline)
        {
            worker.writeToDisk();
        }
_L6:
        Thread.sleep(delay);
        delay = 0L;
          goto _L9
_L2:
        return;
_L8:
        ADMS_Measurement.sharedInstance().debugLog("ADMS SDK Error: Error Sending Hit");
        if (worker.trackOffline)
        {
            delay = 30000L;
            worker.pushRequest(((String) (obj)));
        }
          goto _L6
_L4:
        try
        {
            cancelled = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("ADMS SDK Error: Background Thread Interrupted -- ").append(((Exception) (obj)).getMessage()).toString());
        }
          goto _L2
        delay = 30000L;
          goto _L6
    }

    public _cls9(ADMS_Worker adms_worker)
    {
        delay = 0L;
        worker = null;
        cancelled = false;
        worker = adms_worker;
    }
}
