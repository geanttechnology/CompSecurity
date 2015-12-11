// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTAnalyticsCommand, ParseEventuallyQueue

class ParseAnalyticsController
{

    ParseEventuallyQueue eventuallyQueue;

    public ParseAnalyticsController(ParseEventuallyQueue parseeventuallyqueue)
    {
        eventuallyQueue = parseeventuallyqueue;
    }

    public cu trackAppOpenedInBackground(String s, String s1)
    {
        s = ParseRESTAnalyticsCommand.trackAppOpenedCommand(s, s1);
        return eventuallyQueue.enqueueEventuallyAsync(s, null).j();
    }

    public cu trackEventInBackground(String s, JSONObject jsonobject, String s1)
    {
        s = ParseRESTAnalyticsCommand.trackEventCommand(s, jsonobject, s1);
        return eventuallyQueue.enqueueEventuallyAsync(s, null).j();
    }
}
