// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;


// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            BlockingTokenAccessor

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE AUTH_ERROR;
    public static final NONE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor$ErrorType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUTH_ERROR = new <init>("AUTH_ERROR", 0);
        NONE = new <init>("NONE", 1);
        $VALUES = (new .VALUES[] {
            AUTH_ERROR, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
