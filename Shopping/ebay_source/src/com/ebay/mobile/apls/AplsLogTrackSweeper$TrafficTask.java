// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.apls;

import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageRequest;
import com.ebay.nautilus.domain.net.api.apls.AplsLogMessageResponse;
import com.ebay.nautilus.domain.net.api.apls.AplsReportInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.apls:
//            AplsLogTrackSweeper

private final class reportInfo extends reportInfo
{

    private final ArrayList perfList;
    private final AplsReportInfo reportInfo;
    final AplsLogTrackSweeper this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (AplsLogTrackSweeper.access$700().round)
        {
            AplsLogTrackSweeper.access$700().round("Sending APLS performance data");
        }
        backgroundPrepare();
        avoid = buildServices(reportInfo.epochSessionStart, perfList);
        ArrayList arraylist = buildBeacons(perfList);
        try
        {
            avoid = ((AplsLogMessageResponse)AplsLogTrackSweeper.access$1100(AplsLogTrackSweeper.this).getConnector().sendRequest(new AplsLogMessageRequest(clientInfo, reportInfo, avoid, arraylist))).getResultStatus();
            if (AplsLogTrackSweeper.access$700().etResultStatus && avoid.hasError())
            {
                AplsLogTrackSweeper.access$700().etResultStatus((new StringBuilder()).append("Error while sending APLS performance data: ").append(avoid.toString()).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected esponse(ArrayList arraylist, AplsReportInfo aplsreportinfo, String s)
    {
        this$0 = AplsLogTrackSweeper.this;
        super(AplsLogTrackSweeper.this, s);
        perfList = arraylist;
        reportInfo = aplsreportinfo;
    }
}
