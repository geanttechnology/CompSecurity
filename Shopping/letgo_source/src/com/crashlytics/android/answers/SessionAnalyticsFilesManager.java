// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import android.support.v7.ams;
import android.support.v7.anx;
import android.support.v7.anz;
import android.support.v7.aov;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventTransform

class SessionAnalyticsFilesManager extends anx
{

    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private aov analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessioneventtransform, ams ams1, anz anz)
        throws IOException
    {
        super(context, sessioneventtransform, ams1, anz, 100);
    }

    protected String generateUniqueRollOverFileName()
    {
        UUID uuid = UUID.randomUUID();
        return (new StringBuilder()).append("sa").append("_").append(uuid.toString()).append("_").append(currentTimeProvider.a()).append(".tap").toString();
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
            return analyticsSettingsData.e;
        }
    }

    void setAnalyticsSettingsData(aov aov1)
    {
        analyticsSettingsData = aov1;
    }
}
