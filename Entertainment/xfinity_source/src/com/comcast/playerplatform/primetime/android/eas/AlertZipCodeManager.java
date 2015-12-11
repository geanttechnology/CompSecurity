// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.StringUtil;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertEventListener, AlertsXmlParser

public class AlertZipCodeManager
{

    private String fipsCode;
    private HttpClient httpClient;
    private AlertEventListener listener;
    private int retryAttempt;
    private int retryInterval;
    private AbstractResponseEventListener zipResponseReceived;
    private String zipsToFipsUri;

    public AlertZipCodeManager()
    {
        retryInterval = 1000;
        retryAttempt = 1;
        zipResponseReceived = new AbstractResponseEventListener() {

            final AlertZipCodeManager this$0;

            public void requestFailed(String s)
            {
                retryFips();
            }

            public void responseReceived(String s)
            {
                fipsCode = AlertsXmlParser.parseFipsCodeResponse(s);
                if (StringUtil.isNotNullOrEmpty(fipsCode))
                {
                    listener.fipsCodeFound(fipsCode);
                    return;
                }
                try
                {
                    listener.requestFailed((new StringBuilder()).append("Failed to receive fips from uri: ").append(zipsToFipsUri).toString());
                    retryFips();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    listener.requestFailed((new StringBuilder()).append("Failed to receive fips from zipcode. Exception occured: ").append(String.valueOf(s.getMessage())).toString());
                }
                return;
            }

            
            {
                this$0 = AlertZipCodeManager.this;
                super();
            }
        };
    }

    private void getFipsCode()
    {
        ThreadManager.getInstance().executeRunnable(new XrestHelper("", zipsToFipsUri, "GET", null, zipResponseReceived, httpClient, null));
    }

    private void retryFips()
    {
        double d = retryInterval;
        double d1 = Math.pow(2D, retryAttempt);
        (new Timer()).schedule(new TimerTask() {

            final AlertZipCodeManager this$0;

            public void run()
            {
                getFipsCode();
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = AlertZipCodeManager.this;
                super();
            }
        }, Double.valueOf(d * d1).intValue());
    }

    public void setAlertListener(AlertEventListener alerteventlistener)
    {
        listener = alerteventlistener;
    }



/*
    static String access$002(AlertZipCodeManager alertzipcodemanager, String s)
    {
        alertzipcodemanager.fipsCode = s;
        return s;
    }

*/






/*
    static int access$508(AlertZipCodeManager alertzipcodemanager)
    {
        int i = alertzipcodemanager.retryAttempt;
        alertzipcodemanager.retryAttempt = i + 1;
        return i;
    }

*/
}
