// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.StringUtil;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertZipCodeManager, AlertsXmlParser, AlertEventListener

class init> extends AbstractResponseEventListener
{

    final AlertZipCodeManager this$0;

    public void requestFailed(String s)
    {
        AlertZipCodeManager.access$300(AlertZipCodeManager.this);
    }

    public void responseReceived(String s)
    {
        AlertZipCodeManager.access$002(AlertZipCodeManager.this, AlertsXmlParser.parseFipsCodeResponse(s));
        if (StringUtil.isNotNullOrEmpty(AlertZipCodeManager.access$000(AlertZipCodeManager.this)))
        {
            AlertZipCodeManager.access$100(AlertZipCodeManager.this).fipsCodeFound(AlertZipCodeManager.access$000(AlertZipCodeManager.this));
            return;
        }
        try
        {
            AlertZipCodeManager.access$100(AlertZipCodeManager.this).requestFailed((new StringBuilder()).append("Failed to receive fips from uri: ").append(AlertZipCodeManager.access$200(AlertZipCodeManager.this)).toString());
            AlertZipCodeManager.access$300(AlertZipCodeManager.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AlertZipCodeManager.access$100(AlertZipCodeManager.this).requestFailed((new StringBuilder()).append("Failed to receive fips from zipcode. Exception occured: ").append(String.valueOf(s.getMessage())).toString());
        }
        return;
    }

    ()
    {
        this$0 = AlertZipCodeManager.this;
        super();
    }
}
