// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import bso;
import bsy;
import btb;
import bth;
import buk;
import bwl;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            CreateReportSpiCall, CreateReportRequest, CrashlyticsCore, Report

class DefaultCreateReportSpiCall extends bth
    implements CreateReportSpiCall
{

    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";

    public DefaultCreateReportSpiCall(bsy bsy, String s, String s1, bwl bwl)
    {
        super(bsy, s, s1, bwl, HttpMethod.POST);
    }

    DefaultCreateReportSpiCall(bsy bsy, String s, String s1, bwl bwl, HttpMethod httpmethod)
    {
        super(bsy, s, s1, bwl, httpmethod);
    }

    private HttpRequest applyHeadersTo(HttpRequest httprequest, CreateReportRequest createreportrequest)
    {
        httprequest = httprequest.a("X-CRASHLYTICS-API-KEY", createreportrequest.apiKey).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getInstance().getVersion());
        for (createreportrequest = createreportrequest.report.getCustomHeaders().entrySet().iterator(); createreportrequest.hasNext();)
        {
            httprequest = httprequest.a((java.util.Map.Entry)createreportrequest.next());
        }

        return httprequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httprequest, CreateReportRequest createreportrequest)
    {
        createreportrequest = createreportrequest.report;
        return httprequest.a("report[file]", createreportrequest.getFileName(), "application/octet-stream", createreportrequest.getFile()).e("report[identifier]", createreportrequest.getIdentifier());
    }

    public boolean invoke(CreateReportRequest createreportrequest)
    {
        createreportrequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createreportrequest), createreportrequest);
        bso.h().a("CrashlyticsCore", (new StringBuilder()).append("Sending report to: ").append(getUrl()).toString());
        int i = createreportrequest.b();
        bso.h().a("CrashlyticsCore", (new StringBuilder()).append("Create report request ID: ").append(createreportrequest.b("X-REQUEST-ID")).toString());
        bso.h().a("CrashlyticsCore", (new StringBuilder()).append("Result was: ").append(i).toString());
        return buk.a(i) == 0;
    }
}
