// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.UserProfile;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights.impl:
//            DisabledAmazonInsights

class userProfile
    implements UserProfile
{

    final DisabledAmazonInsights this$0;
    Map userProfile;

    public UserProfile addDimensionAsString(String s, String s1)
    {
        userProfile.put(s, s1);
        return this;
    }

    public Map getDimensions()
    {
        return userProfile;
    }

    ()
    {
        this$0 = DisabledAmazonInsights.this;
        super();
        userProfile = new ConcurrentHashMap();
    }
}
