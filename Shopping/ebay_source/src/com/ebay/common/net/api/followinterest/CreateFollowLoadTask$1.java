// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.model.followinterest.FollowType;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            CreateFollowLoadTask

static class 
{

    static final int $SwitchMap$com$ebay$common$model$followinterest$FollowType[];

    static 
    {
        $SwitchMap$com$ebay$common$model$followinterest$FollowType = new int[FollowType.values().length];
        try
        {
            $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.INTEREST.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.USER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$common$model$followinterest$FollowType[FollowType.COLLECTION.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
