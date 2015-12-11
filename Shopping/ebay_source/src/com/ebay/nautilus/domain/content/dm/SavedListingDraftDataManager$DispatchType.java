// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager

public static final class  extends Enum
{

    private static final ADD $VALUES[];
    public static final ADD ADD;
    public static final ADD DELETE;
    public static final ADD LOAD;
    public static final ADD REMOVE;
    public static final ADD UPDATE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/content/dm/SavedListingDraftDataManager$DispatchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOAD = new <init>("LOAD", 0);
        UPDATE = new <init>("UPDATE", 1);
        DELETE = new <init>("DELETE", 2);
        REMOVE = new <init>("REMOVE", 3);
        ADD = new <init>("ADD", 4);
        $VALUES = (new .VALUES[] {
            LOAD, UPDATE, DELETE, REMOVE, ADD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
