// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            Branch

private static final class  extends Enum
{

    private static final NON_REFERRABLE $VALUES[];
    public static final NON_REFERRABLE NON_REFERRABLE;
    public static final NON_REFERRABLE REFERRABLE;
    public static final NON_REFERRABLE USE_DEFAULT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/branch/referral/Branch$CUSTOM_REFERRABLE_SETTINGS, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        USE_DEFAULT = new <init>("USE_DEFAULT", 0);
        REFERRABLE = new <init>("REFERRABLE", 1);
        NON_REFERRABLE = new <init>("NON_REFERRABLE", 2);
        $VALUES = (new .VALUES[] {
            USE_DEFAULT, REFERRABLE, NON_REFERRABLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
