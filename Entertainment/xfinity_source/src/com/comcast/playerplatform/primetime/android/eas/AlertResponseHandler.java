// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertsXmlParser, AlertEventListener

public class AlertResponseHandler extends AbstractResponseEventListener
{

    private AlertEventListener listener;

    public AlertResponseHandler(AlertEventListener alerteventlistener)
    {
        listener = alerteventlistener;
    }

    private void handleResponse(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = s.isEmpty();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        java.util.ArrayList arraylist = AlertsXmlParser.parseAlertXML(s);
        listener.updateAlertsReceived(arraylist);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        listener.requestFailed((new StringBuilder()).append("An Exception occured parsing the emergency alert response {").append(s).append("}").toString());
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

    public void requestFailed(String s)
    {
        listener.requestFailed(s);
    }

    public void responseReceived(String s)
    {
        handleResponse(s);
    }
}
