// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Branch

private static final class  extends Enum
{

    private static final UNINITIALISED $VALUES[];
    public static final UNINITIALISED INITIALISED;
    public static final UNINITIALISED INITIALISING;
    public static final UNINITIALISED UNINITIALISED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/branch/referral/Branch$SESSION_STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIALISED = new <init>("INITIALISED", 0);
        INITIALISING = new <init>("INITIALISING", 1);
        UNINITIALISED = new <init>("UNINITIALISED", 2);
        $VALUES = (new .VALUES[] {
            INITIALISED, INITIALISING, UNINITIALISED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
