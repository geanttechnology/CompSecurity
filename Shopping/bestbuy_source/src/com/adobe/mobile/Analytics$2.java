// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.Map;

// Referenced classes of package com.adobe.mobile:
//            Analytics, AnalyticsTrackAction

final class val.cdata
    implements Runnable
{

    final String val$action;
    final Map val$cdata;

    public void run()
    {
        AnalyticsTrackAction.trackAction(val$action, val$cdata);
    }

    ckAction()
    {
        val$action = s;
        val$cdata = map;
        super();
    }
}
