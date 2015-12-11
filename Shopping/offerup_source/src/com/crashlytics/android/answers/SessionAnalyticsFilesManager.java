// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import c.a.a.a.a.b.r;
import c.a.a.a.a.d.d;
import c.a.a.a.a.d.h;
import c.a.a.a.a.g.b;
import java.util.UUID;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventTransform

class SessionAnalyticsFilesManager extends d
{

    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private b analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessioneventtransform, r r1, h h)
    {
        super(context, sessioneventtransform, r1, h, 100);
    }

    protected String generateUniqueRollOverFileName()
    {
        UUID uuid = UUID.randomUUID();
        return (new StringBuilder("sa")).append("_").append(uuid.toString()).append("_").append(currentTimeProvider.a()).append(".tap").toString();
    }

    protected int getMaxByteSizePerFile()
    {
        if (analyticsSettingsData == null)
        {
            return super.getMaxByteSizePerFile();
        } else
        {
            return analyticsSettingsData.c;
        }
    }

    protected int getMaxFilesToKeep()
    {
        if (analyticsSettingsData == null)
        {
            return super.getMaxFilesToKeep();
        } else
        {
            return analyticsSettingsData.d;
        }
    }

    void setAnalyticsSettingsData(b b1)
    {
        analyticsSettingsData = b1;
    }
}
