// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import android.content.Context;
import com.shazam.android.t.a.b;
import com.shazam.android.t.a.c;

// Referenced classes of package com.shazam.android.analytics.session:
//            SessionAnalytics

public class FlurrySessionAnalytics
    implements SessionAnalytics
{

    private final b apiKey;
    private final c flurryClient;

    public FlurrySessionAnalytics(c c1, b b1)
    {
        flurryClient = c1;
        apiKey = b1;
    }

    public void startSession(Context context)
    {
        flurryClient.a(context, apiKey.a);
    }

    public void stopSession(Context context)
    {
        flurryClient.a(context);
    }
}
