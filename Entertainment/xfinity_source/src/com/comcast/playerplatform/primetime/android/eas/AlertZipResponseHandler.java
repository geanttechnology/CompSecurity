// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertsXmlParser, AlertEventListener

public class AlertZipResponseHandler extends AbstractResponseEventListener
{

    public static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/eas/AlertZipResponseHandler);
    private String fipsCode;
    private AlertEventListener listener;
    private int retryAttempt;
    private int retryInterval;

    public AlertZipResponseHandler(AlertEventListener alerteventlistener)
    {
        retryInterval = 1000;
        retryAttempt = 1;
        listener = alerteventlistener;
    }

    private void handleResponse(String s)
    {
        this;
        JVM INSTR monitorenter ;
        fipsCode = AlertsXmlParser.parseFipsCodeResponse(s);
        if (!StringUtil.isNotNullOrEmpty(fipsCode)) goto _L2; else goto _L1
_L1:
        listener.fipsCodeFound(fipsCode);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        try
        {
            listener.requestFailed((new StringBuilder()).append("Failed to receive fips from uri: : ").append(s).toString());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            this;
        }
        listener.requestFailed((new StringBuilder()).append("Failed to receive fips from zipcode. Exception occured: ").append(String.valueOf(s.getMessage())).toString());
        if (true) goto _L4; else goto _L3
_L3:
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
