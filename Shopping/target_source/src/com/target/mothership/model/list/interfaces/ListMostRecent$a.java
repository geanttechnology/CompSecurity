// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces;


// Referenced classes of package com.target.mothership.model.list.interfaces:
//            ListMostRecent

public static final class  extends Enum
{

    private static final SEARCH $VALUES[];
    public static final SEARCH SEARCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/model/list/interfaces/ListMostRecent$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SEARCH = new <init>("SEARCH", 0);
        $VALUES = (new .VALUES[] {
            SEARCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
