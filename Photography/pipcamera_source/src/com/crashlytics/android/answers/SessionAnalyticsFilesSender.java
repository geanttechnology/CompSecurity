// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aad;
import aag;
import aam;
import abh;
import aco;
import acy;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import zw;

class SessionAnalyticsFilesSender extends aam
    implements aco
{

    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(aad aad1, String s, String s1, acy acy, String s2)
    {
        super(aad1, s, s1, acy, HttpMethod.POST);
        apiKey = s2;
    }

    public boolean send(List list)
    {
        boolean flag = false;
        HttpRequest httprequest = getHttpRequest().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("X-CRASHLYTICS-API-KEY", apiKey);
        Iterator iterator = list.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            File file = (File)iterator.next();
            httprequest.a((new StringBuilder()).append("session_analytics_file_").append(i).toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
        }

        zw.h().a("Answers", (new StringBuilder()).append("Sending ").append(list.size()).append(" analytics files to ").append(getUrl()).toString());
        int j = httprequest.b();
        zw.h().a("Answers", (new StringBuilder()).append("Response code for analytics file send is ").append(j).toString());
        if (abh.a(j) == 0)
        {
            flag = true;
        }
        return flag;
    }
}
