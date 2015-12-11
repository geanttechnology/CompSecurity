// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerWebViewLoader, AdTrackerRequestResponseBuilder

protected static class 
{

    public String getParams()
    {
        String s2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        String s1 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
        String s = s1;
        if (s2 != null)
        {
            s = (new StringBuilder()).append(s1).append("&referrer=").append(s2).toString();
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.5", (new StringBuilder()).append("Request param for webview").append(s).toString());
        return s;
    }

    protected ()
    {
    }
}
