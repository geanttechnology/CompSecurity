// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template;


// Referenced classes of package com.damnhandy.uri.template:
//            UriTemplate

public static final class  extends Enum
{

    private static final UF $VALUES[];
    public static final UF U;
    public static final UF UF;
    public static final UF UR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/damnhandy/uri/template/UriTemplate$Encoding, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        U = new <init>("U", 0);
        UR = new <init>("UR", 1);
        UF = new <init>("UF", 2);
        $VALUES = (new .VALUES[] {
            U, UR, UF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
