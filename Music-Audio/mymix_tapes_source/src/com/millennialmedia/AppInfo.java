// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            MMSDK

public class AppInfo
{

    private Boolean coppa;
    private String mediator;
    private String siteId;

    public AppInfo()
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create AppInfo instance, SDK must be initialized first");
        } else
        {
            return;
        }
    }

    public Boolean getCoppa()
    {
        return coppa;
    }

    public String getMediator()
    {
        return mediator;
    }

    public String getSiteId()
    {
        return siteId;
    }

    public AppInfo setCoppa(boolean flag)
    {
        coppa = Boolean.valueOf(flag);
        return this;
    }

    public AppInfo setMediator(String s)
    {
        mediator = s;
        return this;
    }

    public AppInfo setSiteId(String s)
    {
        siteId = s;
        return this;
    }
}
