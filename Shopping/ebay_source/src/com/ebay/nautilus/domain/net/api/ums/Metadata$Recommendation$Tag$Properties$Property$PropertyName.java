// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;


// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public static final class  extends Enum
{

    private static final HelpText $VALUES[];
    public static final HelpText Closed;
    public static final HelpText DataType;
    public static final HelpText DisableAsVariant;
    public static final HelpText HelpText;
    public static final HelpText Multivalued;
    public static final HelpText Precision;
    public static final HelpText Required;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/ums/Metadata$Recommendation$Tag$Properties$Property$PropertyName, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Required = new <init>("Required", 0);
        Multivalued = new <init>("Multivalued", 1);
        Closed = new <init>("Closed", 2);
        DisableAsVariant = new <init>("DisableAsVariant", 3);
        DataType = new <init>("DataType", 4);
        Precision = new <init>("Precision", 5);
        HelpText = new <init>("HelpText", 6);
        $VALUES = (new .VALUES[] {
            Required, Multivalued, Closed, DisableAsVariant, DataType, Precision, HelpText
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
