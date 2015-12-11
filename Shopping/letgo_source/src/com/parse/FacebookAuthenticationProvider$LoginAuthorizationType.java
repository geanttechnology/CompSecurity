// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider

public static final class  extends Enum
{

    private static final PUBLISH $VALUES[];
    public static final PUBLISH PUBLISH;
    public static final PUBLISH READ;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/parse/FacebookAuthenticationProvider$LoginAuthorizationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        READ = new <init>("READ", 0);
        PUBLISH = new <init>("PUBLISH", 1);
        $VALUES = (new .VALUES[] {
            READ, PUBLISH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
