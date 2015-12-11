// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import c.a.a.a.a.b.a;
import c.a.a.a.a.d.k;
import c.a.a.a.a.e.c;
import c.a.a.a.a.e.d;
import c.a.a.a.e;
import c.a.a.a.n;
import c.a.a.a.q;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class SessionAnalyticsFilesSender extends a
    implements k
{

    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(n n1, String s, String s1, c.a.a.a.a.e.a a1, String s2)
    {
        super(n1, s, s1, a1, c.b);
        apiKey = s2;
    }

    public boolean send(List list)
    {
        boolean flag = false;
        d d1 = getHttpRequest().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion()).a("X-CRASHLYTICS-API-KEY", apiKey);
        Iterator iterator = list.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            File file = (File)iterator.next();
            d1.a((new StringBuilder("session_analytics_file_")).append(i).toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
        }

        e.d().a("Answers", (new StringBuilder("Sending ")).append(list.size()).append(" analytics files to ").append(getUrl()).toString());
        int j = d1.b();
        e.d().a("Answers", (new StringBuilder("Response code for analytics file send is ")).append(j).toString());
        if (android.support.v4.e.a.a(j) == 0)
        {
            flag = true;
        }
        return flag;
    }
}
