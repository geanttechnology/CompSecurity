// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;


// Referenced classes of package com.gotv.crackle.data:
//            ItemsListRequest

public static final class  extends Enum
{

    private static final Popular $VALUES[];
    public static final Popular Featured;
    public static final Popular Popular;
    public static final Popular Recent;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/data/ItemsListRequest$ItemsListType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Featured = new <init>("Featured", 0);
        Recent = new <init>("Recent", 1);
        Popular = new <init>("Popular", 2);
        $VALUES = (new .VALUES[] {
            Featured, Recent, Popular
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
