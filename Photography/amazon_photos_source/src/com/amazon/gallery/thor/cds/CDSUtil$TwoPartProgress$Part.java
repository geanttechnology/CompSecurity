// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;


// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSUtil

public static final class  extends Enum
{

    private static final TWO $VALUES[];
    public static final TWO ONE;
    public static final TWO TWO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/cds/CDSUtil$TwoPartProgress$Part, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ONE = new <init>("ONE", 0);
        TWO = new <init>("TWO", 1);
        $VALUES = (new .VALUES[] {
            ONE, TWO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
