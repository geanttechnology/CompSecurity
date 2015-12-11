// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import c.a.a.a.a.b.r;
import c.a.a.a.a.d.l;
import c.a.a.a.a.f.a;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionEventTransform, SessionAnalyticsFilesManager

class AnswersFilesManagerProvider
{

    static final String SESSION_ANALYTICS_FILE_NAME = "session_analytics.tap";
    static final String SESSION_ANALYTICS_TO_SEND_DIR = "session_analytics_to_send";
    final Context context;
    final a fileStore;

    public AnswersFilesManagerProvider(Context context1, a a1)
    {
        context = context1;
        fileStore = a1;
    }

    public SessionAnalyticsFilesManager getAnalyticsFilesManager()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        } else
        {
            SessionEventTransform sessioneventtransform = new SessionEventTransform();
            r r1 = new r();
            Object obj = fileStore.a();
            obj = new l(context, ((java.io.File) (obj)), "session_analytics.tap", "session_analytics_to_send");
            return new SessionAnalyticsFilesManager(context, sessioneventtransform, r1, ((c.a.a.a.a.d.h) (obj)));
        }
    }
}
