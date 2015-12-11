// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


// Referenced classes of package com.ebay.nautilus.kernel.content:
//            ResultStatus

public static final class  extends Enum
{

    private static final PartialFailure $VALUES[];
    public static final PartialFailure Error;
    public static final PartialFailure PartialFailure;
    public static final PartialFailure Warning;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/kernel/content/ResultStatus$Severity, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Warning = new <init>("Warning", 0);
        Error = new <init>("Error", 1);
        PartialFailure = new <init>("PartialFailure", 2);
        $VALUES = (new .VALUES[] {
            Warning, Error, PartialFailure
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
