// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aaz;
import ach;
import ack;
import adi;
import android.content.Context;
import java.util.UUID;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventTransform

class SessionAnalyticsFilesManager extends ach
{

    private static final String SESSION_ANALYTICS_TO_SEND_FILE_EXTENSION = ".tap";
    private static final String SESSION_ANALYTICS_TO_SEND_FILE_PREFIX = "sa";
    private adi analyticsSettingsData;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessioneventtransform, aaz aaz1, ack ack)
    {
        super(context, sessioneventtransform, aaz1, ack, 100);
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

    void setAnalyticsSettingsData(adi adi1)
    {
        analyticsSettingsData = adi1;
    }
}
