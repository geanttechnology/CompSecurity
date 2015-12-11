// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.f;


// Referenced classes of package com.target.ui.f:
//            c

public static final class > extends Enum
{

    private static final SLIDE_BOTTOM $VALUES[];
    public static final SLIDE_BOTTOM SLIDE_BOTTOM;
    public static final SLIDE_BOTTOM SLIDE_RIGHT;

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/target/ui/f/c$a, s);
    }

    public static Of[] values()
    {
        return (Of[])$VALUES.clone();
    }

    static 
    {
        SLIDE_RIGHT = new <init>("SLIDE_RIGHT", 0);
        SLIDE_BOTTOM = new <init>("SLIDE_BOTTOM", 1);
        $VALUES = (new .VALUES[] {
            SLIDE_RIGHT, SLIDE_BOTTOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
