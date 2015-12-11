// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.followinterest;


// Referenced classes of package com.ebay.common.model.followinterest:
//            FollowDescriptor

public static final class  extends Enum
{

    private static final PUSH $VALUES[];
    public static final PUSH EMAIL;
    public static final PUSH PUSH;
    public static final PUSH SMS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/model/followinterest/FollowDescriptor$NotificationEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EMAIL = new <init>("EMAIL", 0);
        SMS = new <init>("SMS", 1);
        PUSH = new <init>("PUSH", 2);
        $VALUES = (new .VALUES[] {
            EMAIL, SMS, PUSH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
