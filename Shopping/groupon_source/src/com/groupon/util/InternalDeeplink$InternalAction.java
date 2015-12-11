// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            InternalDeeplink

public static final class  extends Enum
{

    private static final INVALID $VALUES[];
    public static final INVALID CAMERA;
    public static final INVALID CLOSE;
    public static final INVALID INVALID;
    public static final INVALID LOGIN;
    public static final INVALID PHOTO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/util/InternalDeeplink$InternalAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PHOTO = new <init>("PHOTO", 0);
        CAMERA = new <init>("CAMERA", 1);
        CLOSE = new <init>("CLOSE", 2);
        LOGIN = new <init>("LOGIN", 3);
        INVALID = new <init>("INVALID", 4);
        $VALUES = (new .VALUES[] {
            PHOTO, CAMERA, CLOSE, LOGIN, INVALID
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
