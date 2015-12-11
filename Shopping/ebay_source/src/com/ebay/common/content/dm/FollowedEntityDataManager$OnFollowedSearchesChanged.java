// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.model.followinterest.FollowDescriptor;
import java.util.Map;

// Referenced classes of package com.ebay.common.content.dm:
//            FollowedEntityDataManager

public static interface 
{

    public abstract String getSearchQuery();

    public abstract void onFollowedInterestDeleted(String s);

    public abstract void onFollowedInterestsLoaded(Map map);

    public abstract void onSearchFollowed(FollowDescriptor followdescriptor);
}
