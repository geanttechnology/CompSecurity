// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;

import com.shazam.model.streaming.SubscriptionType;

// Referenced classes of package com.shazam.model.rdio:
//            RdioUser

public static class Type
{

    public boolean is48hTrialAvailable;
    public SubscriptionType subscriptionType;

    public static Type a()
    {
        return new <init>();
    }

    static SubscriptionType a(<init> <init>1)
    {
        return <init>1.subscriptionType;
    }

    static boolean b(subscriptionType subscriptiontype)
    {
        return subscriptiontype.is48hTrialAvailable;
    }

    public Type()
    {
    }
}
