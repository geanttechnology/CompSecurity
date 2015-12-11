// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.scan;


// Referenced classes of package com.target.ui.model.scan:
//            ScanResultItem

public static final class  extends Enum
{

    private static final CONNECTION_ISSUE $VALUES[];
    public static final CONNECTION_ISSUE CONNECTION_ISSUE;
    public static final CONNECTION_ISSUE NO_RESULT;
    public static final CONNECTION_ISSUE PRODUCT_NOT_FOUND;
    public static final CONNECTION_ISSUE PRODUCT_RESULT;
    public static final CONNECTION_ISSUE UPC_RESULT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/model/scan/ScanResultItem$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_RESULT = new <init>("NO_RESULT", 0);
        UPC_RESULT = new <init>("UPC_RESULT", 1);
        PRODUCT_RESULT = new <init>("PRODUCT_RESULT", 2);
        PRODUCT_NOT_FOUND = new <init>("PRODUCT_NOT_FOUND", 3);
        CONNECTION_ISSUE = new <init>("CONNECTION_ISSUE", 4);
        $VALUES = (new .VALUES[] {
            NO_RESULT, UPC_RESULT, PRODUCT_RESULT, PRODUCT_NOT_FOUND, CONNECTION_ISSUE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
