// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;


// Referenced classes of package com.ebay.nautilus.domain.content:
//            ServiceContentOverride

private static class <init>
{

    public isShipped feedbackLeft;
    public isShipped isShipped;
    public isShipped paidStatus;

    public boolean purgeOutdatedContent()
    {
        boolean flag = true;
        if (feedbackLeft == null || feedbackLeft.d())
        {
            feedbackLeft = null;
        } else
        {
            flag = false;
        }
        if (paidStatus == null || paidStatus.d())
        {
            paidStatus = null;
        } else
        {
            flag = false;
        }
        if (isShipped == null || isShipped.d())
        {
            isShipped = null;
            return flag;
        } else
        {
            return false;
        }
    }

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }
}
