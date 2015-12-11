// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.f.a;


// Referenced classes of package com.target.ui.util.f.a:
//            a

public static final class  extends Enum
{

    private static final FOUND_NONE $VALUES[];
    public static final FOUND_NONE FOUND_AISLE;
    public static final FOUND_NONE FOUND_KNOWN_DEPARTMENT;
    public static final FOUND_NONE FOUND_NONE;
    public static final FOUND_NONE FOUND_UNKNOWN_DEPARTMENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/f/a/a$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FOUND_KNOWN_DEPARTMENT = new <init>("FOUND_KNOWN_DEPARTMENT", 0);
        FOUND_UNKNOWN_DEPARTMENT = new <init>("FOUND_UNKNOWN_DEPARTMENT", 1);
        FOUND_AISLE = new <init>("FOUND_AISLE", 2);
        FOUND_NONE = new <init>("FOUND_NONE", 3);
        $VALUES = (new .VALUES[] {
            FOUND_KNOWN_DEPARTMENT, FOUND_UNKNOWN_DEPARTMENT, FOUND_AISLE, FOUND_NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
