// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership;


// Referenced classes of package com.target.mothership:
//            c

public static final class  extends Enum
{

    private static final Debug $VALUES[];
    public static final Debug Debug;
    public static final Debug Live;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/c$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Live = new <init>("Live", 0);
        Debug = new <init>("Debug", 1);
        $VALUES = (new .VALUES[] {
            Live, Debug
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
