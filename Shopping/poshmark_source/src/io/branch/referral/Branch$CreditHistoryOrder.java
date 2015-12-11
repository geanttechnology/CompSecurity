// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Branch

public static final class  extends Enum
{

    private static final kLeastRecentFirst $VALUES[];
    public static final kLeastRecentFirst kLeastRecentFirst;
    public static final kLeastRecentFirst kMostRecentFirst;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/branch/referral/Branch$CreditHistoryOrder, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        kMostRecentFirst = new <init>("kMostRecentFirst", 0);
        kLeastRecentFirst = new <init>("kLeastRecentFirst", 1);
        $VALUES = (new .VALUES[] {
            kMostRecentFirst, kLeastRecentFirst
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
