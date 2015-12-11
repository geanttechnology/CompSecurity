// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItDialogHelper

public static final class  extends Enum
{

    private static final PUBLIC_DATA_MATRIX_INFO $VALUES[];
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_FLOW_SERVER;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_MSHOP_SERVER;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_NETWORK;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_NO_MATCHED_ITEM;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_NO_OBJECT_FOUND;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_PAUSE;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_UNAUTHORIZED;
    public static final PUBLIC_DATA_MATRIX_INFO ERROR_UNKNOWN;
    public static final PUBLIC_DATA_MATRIX_INFO PUBLIC_DATA_MATRIX_INFO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ERROR_NETWORK = new <init>("ERROR_NETWORK", 0);
        ERROR_UNAUTHORIZED = new <init>("ERROR_UNAUTHORIZED", 1);
        ERROR_FLOW_SERVER = new <init>("ERROR_FLOW_SERVER", 2);
        ERROR_MSHOP_SERVER = new <init>("ERROR_MSHOP_SERVER", 3);
        ERROR_NO_MATCHED_ITEM = new <init>("ERROR_NO_MATCHED_ITEM", 4);
        ERROR_NO_OBJECT_FOUND = new <init>("ERROR_NO_OBJECT_FOUND", 5);
        ERROR_PAUSE = new <init>("ERROR_PAUSE", 6);
        ERROR_UNKNOWN = new <init>("ERROR_UNKNOWN", 7);
        PUBLIC_DATA_MATRIX_INFO = new <init>("PUBLIC_DATA_MATRIX_INFO", 8);
        $VALUES = (new .VALUES[] {
            ERROR_NETWORK, ERROR_UNAUTHORIZED, ERROR_FLOW_SERVER, ERROR_MSHOP_SERVER, ERROR_NO_MATCHED_ITEM, ERROR_NO_OBJECT_FOUND, ERROR_PAUSE, ERROR_UNKNOWN, PUBLIC_DATA_MATRIX_INFO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
