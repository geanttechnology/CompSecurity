// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class  extends Enum
{

    private static final SESSION $VALUES[];
    public static final SESSION LOGIN;
    public static final SESSION SESSION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/sdk/InMobiSdk$ImIdType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOGIN = new <init>("LOGIN", 0);
        SESSION = new <init>("SESSION", 1);
        $VALUES = (new .VALUES[] {
            LOGIN, SESSION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
