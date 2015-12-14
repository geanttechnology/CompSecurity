// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import aad;
import aag;
import aam;
import abh;
import acy;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import zw;

// Referenced classes of package com.crashlytics.android.core:
//            CreateReportSpiCall, CreateReportRequest, CrashlyticsCore, Report

class DefaultCreateReportSpiCall extends aam
    implements CreateReportSpiCall
{

    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";

    public DefaultCreateReportSpiCall(aad aad, String s, String s1, acy acy)
    {
        super(aad, s, s1, acy, HttpMethod.POST);
    }

    DefaultCreateReportSpiCall(aad aad, String s, String s1, acy acy, HttpMethod httpmethod)
    {
        super(aad, s, s1, acy, httpmethod);
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
        zw.h().a("CrashlyticsCore", (new StringBuilder()).append("Sending report to: ").append(getUrl()).toString());
        int i = createreportrequest.b();
        zw.h().a("CrashlyticsCore", (new StringBuilder()).append("Create report request ID: ").append(createreportrequest.b("X-REQUEST-ID")).toString());
        zw.h().a("CrashlyticsCore", (new StringBuilder()).append("Result was: ").append(i).toString());
        return abh.a(i) == 0;
    }
}
