// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ManifestInfo

static final class  extends Enum
{

    private static final MISSING_REQUIRED_DECLARATIONS $VALUES[];
    public static final MISSING_REQUIRED_DECLARATIONS HAS_ALL_DECLARATIONS;
    public static final MISSING_REQUIRED_DECLARATIONS MISSING_OPTIONAL_DECLARATIONS;
    public static final MISSING_REQUIRED_DECLARATIONS MISSING_REQUIRED_DECLARATIONS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/parse/ManifestInfo$ManifestCheckResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HAS_ALL_DECLARATIONS = new <init>("HAS_ALL_DECLARATIONS", 0);
        MISSING_OPTIONAL_DECLARATIONS = new <init>("MISSING_OPTIONAL_DECLARATIONS", 1);
        MISSING_REQUIRED_DECLARATIONS = new <init>("MISSING_REQUIRED_DECLARATIONS", 2);
        $VALUES = (new .VALUES[] {
            HAS_ALL_DECLARATIONS, MISSING_OPTIONAL_DECLARATIONS, MISSING_REQUIRED_DECLARATIONS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
