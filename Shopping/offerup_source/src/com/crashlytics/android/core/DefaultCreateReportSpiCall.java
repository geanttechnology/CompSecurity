// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import c.a.a.a.a.b.a;
import c.a.a.a.a.e.c;
import c.a.a.a.a.e.d;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.crashlytics.android.core:
//            CreateReportSpiCall, CreateReportRequest, CrashlyticsCore, Report

class DefaultCreateReportSpiCall extends a
    implements CreateReportSpiCall
{

    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";

    public DefaultCreateReportSpiCall(n n, String s, String s1, c.a.a.a.a.e.a a1)
    {
        super(n, s, s1, a1, c.b);
    }

    DefaultCreateReportSpiCall(n n, String s, String s1, c.a.a.a.a.e.a a1, int i)
    {
        super(n, s, s1, a1, i);
    }

    private d applyHeadersTo(d d1, CreateReportRequest createreportrequest)
    {
        d1 = d1.a("X-CRASHLYTICS-API-KEY", createreportrequest.apiKey).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getInstance().getVersion());
        for (createreportrequest = createreportrequest.report.getCustomHeaders().entrySet().iterator(); createreportrequest.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)createreportrequest.next();
            d1 = d1.a((String)entry.getKey(), (String)entry.getValue());
        }

        return d1;
    }

    private d applyMultipartDataTo(d d1, CreateReportRequest createreportrequest)
    {
        createreportrequest = createreportrequest.report;
        return d1.a("report[file]", createreportrequest.getFileName(), "application/octet-stream", createreportrequest.getFile()).a("report[identifier]", null, createreportrequest.getIdentifier());
    }

    public boolean invoke(CreateReportRequest createreportrequest)
    {
        createreportrequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createreportrequest), createreportrequest);
        e.d().a("CrashlyticsCore", (new StringBuilder("Sending report to: ")).append(getUrl()).toString());
        int i = createreportrequest.b();
        e.d().a("CrashlyticsCore", (new StringBuilder("Create report request ID: ")).append(createreportrequest.a("X-REQUEST-ID")).toString());
        e.d().a("CrashlyticsCore", (new StringBuilder("Result was: ")).append(i).toString());
        return android.support.v4.e.a.a(i) == 0;
    }
}
