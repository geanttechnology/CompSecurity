// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.alt;
import android.support.v7.alz;
import android.support.v7.amc;
import android.support.v7.ami;
import android.support.v7.amz;
import android.support.v7.aod;
import android.support.v7.aoj;
import android.support.v7.aok;
import android.support.v7.aol;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class SessionAnalyticsFilesSender extends ami
    implements aod
{

    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(alz alz1, String s, String s1, aol aol, String s2)
    {
        super(alz1, s, s1, aol, aoj.b);
        apiKey = s2;
    }

    public boolean send(List list)
    {
        boolean flag = false;
        aok aok1 = getHttpRequest().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("X-CRASHLYTICS-API-KEY", apiKey);
        Iterator iterator = list.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            File file = (File)iterator.next();
            aok1.a((new StringBuilder()).append("session_analytics_file_").append(i).toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
        }

        alt.h().a("Answers", (new StringBuilder()).append("Sending ").append(list.size()).append(" analytics files to ").append(getUrl()).toString());
        int j = aok1.b();
        alt.h().a("Answers", (new StringBuilder()).append("Response code for analytics file send is ").append(j).toString());
        if (amz.a(j) == 0)
        {
            flag = true;
        }
        return flag;
    }
}
