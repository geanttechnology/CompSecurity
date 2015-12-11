// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;


// Referenced classes of package com.target.ui.fragment.list:
//            ListDialogFragment

public static final class  extends Enum
{

    private static final CREATE $VALUES[];
    public static final CREATE CREATE;
    public static final CREATE EDIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/list/ListDialogFragment$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EDIT = new <init>("EDIT", 0);
        CREATE = new <init>("CREATE", 1);
        $VALUES = (new .VALUES[] {
            EDIT, CREATE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
