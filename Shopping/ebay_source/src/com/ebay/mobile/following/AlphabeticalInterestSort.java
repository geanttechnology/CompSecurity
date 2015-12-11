// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import java.util.Comparator;

public class AlphabeticalInterestSort
    implements Comparator
{

    public AlphabeticalInterestSort()
    {
    }

    public int compare(com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest, com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest followedinterest1)
    {
        return followedinterest.getDisplayTitle().compareToIgnoreCase(followedinterest1.getDisplayTitle());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)obj, (com.ebay.nautilus.domain.data.FollowingContent.FollowedInterest)obj1);
    }
}
