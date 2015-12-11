// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.amc;
import android.support.v7.ami;
import android.support.v7.amz;
import android.support.v7.aoj;
import android.support.v7.aok;
import android.support.v7.aol;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            CreateReportSpiCall, CreateReportRequest, CrashlyticsCore, Report

class DefaultCreateReportSpiCall extends ami
    implements CreateReportSpiCall
{

    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";

    public DefaultCreateReportSpiCall(alz alz, String s, String s1, aol aol)
    {
        super(alz, s, s1, aol, aoj.b);
    }

    DefaultCreateReportSpiCall(alz alz, String s, String s1, aol aol, aoj aoj1)
    {
        super(alz, s, s1, aol, aoj1);
    }

    private aok applyHeadersTo(aok aok1, CreateReportRequest createreportrequest)
    {
        aok1 = aok1.a("X-CRASHLYTICS-API-KEY", createreportrequest.apiKey).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getInstance().getVersion());
        for (createreportrequest = createreportrequest.report.getCustomHeaders().entrySet().iterator(); createreportrequest.hasNext();)
        {
            aok1 = aok1.a((java.util.Map.Entry)createreportrequest.next());
        }

        return aok1;
    }

    private aok applyMultipartDataTo(aok aok1, CreateReportRequest createreportrequest)
    {
        createreportrequest = createreportrequest.report;
        return aok1.a("report[file]", createreportrequest.getFileName(), "application/octet-stream", createreportrequest.getFile()).e("report[identifier]", createreportrequest.getIdentifier());
    }

    public boolean invoke(CreateReportRequest createreportrequest)
    {
        createreportrequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createreportrequest), createreportrequest);
        alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Sending report to: ").append(getUrl()).toString());
        int i = createreportrequest.b();
        alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Create report request ID: ").append(createreportrequest.b("X-REQUEST-ID")).toString());
        alt.h().a("CrashlyticsCore", (new StringBuilder()).append("Result was: ").append(i).toString());
        return amz.a(i) == 0;
    }
}
