// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.apls;

import android.content.Context;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.net.api.apls.AplsErrorReport;
import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageRequest;
import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;

// Referenced classes of package com.ebay.mobile.apls:
//            AplsLogTrackSweeper

private final class nit> extends nit>
{

    final AplsLogTrackSweeper this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (AplsLogTrackSweeper.access$700().round)
        {
            AplsLogTrackSweeper.access$700().round("Sending APLS error data");
        }
        backgroundPrepare();
        avoid = AplsErrorReport.buildErrorReports((Context)AplsLogTrackSweeper.access$800(AplsLogTrackSweeper.this).getExtension(android/content/Context), AplsLogTrackSweeper.access$900(AplsLogTrackSweeper.this), MyApp.getPrefs().getCurrentCountry());
        try
        {
            avoid = ((AplsLogMessageResponse)AplsLogTrackSweeper.access$1000(AplsLogTrackSweeper.this).getConnector().sendRequest(new AplsLogMessageRequest(clientInfo, avoid))).getResultStatus();
            if (AplsLogTrackSweeper.access$700().getResultStatus && avoid.hasError())
            {
                AplsLogTrackSweeper.access$700().getResultStatus((new StringBuilder()).append("Error while sending APLS error data: ").append(avoid.toString()).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.PostExecute(void1);
        handleErrorTaskComplete(this);
    }

    public eResponse(String s)
    {
        this$0 = AplsLogTrackSweeper.this;
        super(AplsLogTrackSweeper.this, s);
    }
}
