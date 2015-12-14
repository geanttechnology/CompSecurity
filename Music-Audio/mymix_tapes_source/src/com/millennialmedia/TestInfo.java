// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            MMSDK

public class TestInfo
{

    public String bidder;
    public String creativeId;

    public TestInfo()
    {
        if (!MMSDK.initialized)
        {
            throw new IllegalStateException("Unable to create TestInfo instance, SDK must be initialized first");
        } else
        {
            return;
        }
    }

    public void setBidder(String s)
    {
        bidder = s;
    }

    public void setCreativeId(String s)
    {
        creativeId = s;
    }
}
