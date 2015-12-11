// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;


// Referenced classes of package com.target.ui.service:
//            k

public static final class  extends Enum
{

    private static final NETWORK $VALUES[];
    public static final NETWORK AVAILABILITY_ERROR;
    public static final NETWORK GEOCODE_FAILURE;
    public static final NETWORK NETWORK;
    public static final NETWORK NO_NEARBY_STORES;
    public static final NETWORK NO_PRODUCT_DPCI_ERROR;
    public static final NETWORK NO_RELEVANT_STORES;
    public static final NETWORK NO_STORES_ZIP;
    public static final NETWORK RELEVANT_STORE_ERROR;
    public static final NETWORK STORE_LOOKUP_ERROR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/service/k$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_PRODUCT_DPCI_ERROR = new <init>("NO_PRODUCT_DPCI_ERROR", 0);
        AVAILABILITY_ERROR = new <init>("AVAILABILITY_ERROR", 1);
        STORE_LOOKUP_ERROR = new <init>("STORE_LOOKUP_ERROR", 2);
        NO_STORES_ZIP = new <init>("NO_STORES_ZIP", 3);
        RELEVANT_STORE_ERROR = new <init>("RELEVANT_STORE_ERROR", 4);
        NO_RELEVANT_STORES = new <init>("NO_RELEVANT_STORES", 5);
        NO_NEARBY_STORES = new <init>("NO_NEARBY_STORES", 6);
        GEOCODE_FAILURE = new <init>("GEOCODE_FAILURE", 7);
        NETWORK = new <init>("NETWORK", 8);
        $VALUES = (new .VALUES[] {
            NO_PRODUCT_DPCI_ERROR, AVAILABILITY_ERROR, STORE_LOOKUP_ERROR, NO_STORES_ZIP, RELEVANT_STORE_ERROR, NO_RELEVANT_STORES, NO_NEARBY_STORES, GEOCODE_FAILURE, NETWORK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
