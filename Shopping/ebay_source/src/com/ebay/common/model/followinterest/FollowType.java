// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.followinterest;


public final class FollowType extends Enum
{

    private static final FollowType $VALUES[];
    public static final FollowType COLLECTION;
    public static final FollowType INTEREST;
    public static final FollowType USER;
    private String entityTypeString;

    private FollowType(String s, int i, String s1)
    {
        super(s, i);
        entityTypeString = s1;
    }

    public static FollowType valueOf(String s)
    {
        return (FollowType)Enum.valueOf(com/ebay/common/model/followinterest/FollowType, s);
    }

    public static FollowType[] values()
    {
        return (FollowType[])$VALUES.clone();
    }

    public String toString()
    {
        return entityTypeString;
    }

    static 
    {
        INTEREST = new FollowType("INTEREST", 0, "interest");
        COLLECTION = new FollowType("COLLECTION", 1, "collection");
        USER = new FollowType("USER", 2, "user");
        $VALUES = (new FollowType[] {
            INTEREST, COLLECTION, USER
        });
    }
}
