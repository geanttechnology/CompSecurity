// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;


// Referenced classes of package org.acra.sender:
//            HttpSender

public static final class  extends Enum
{

    private static final PUT $VALUES[];
    public static final PUT POST;
    public static final PUT PUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/acra/sender/HttpSender$Method, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        POST = new <init>("POST", 0);
        PUT = new <init>("PUT", 1);
        $VALUES = (new .VALUES[] {
            POST, PUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
