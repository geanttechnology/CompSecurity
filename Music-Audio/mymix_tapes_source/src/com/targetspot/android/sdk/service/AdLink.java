// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;


// Referenced classes of package com.targetspot.android.sdk.service:
//            AdLog

public class AdLink
{

    AdLog linkLog;
    String linkUrl;

    AdLink(String s, AdLog adlog)
    {
        linkUrl = s;
        linkLog = adlog;
    }

    public AdLog getLinkLog()
    {
        return linkLog;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }
}
