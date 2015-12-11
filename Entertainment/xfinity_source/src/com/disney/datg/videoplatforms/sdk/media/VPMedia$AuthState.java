// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static final class  extends Enum
{

    private static final AUTHORIZED $VALUES[];
    public static final AUTHORIZED AUTHORIZED;
    public static final AUTHORIZED NOT_AUTHORIZED;
    public static final AUTHORIZED RECEIVED;
    public static final AUTHORIZED TIMEOUT;
    public static final AUTHORIZED VALIDATE;
    public static final AUTHORIZED WAITING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_AUTHORIZED = new <init>("NOT_AUTHORIZED", 0);
        WAITING = new <init>("WAITING", 1);
        RECEIVED = new <init>("RECEIVED", 2);
        VALIDATE = new <init>("VALIDATE", 3);
        TIMEOUT = new <init>("TIMEOUT", 4);
        AUTHORIZED = new <init>("AUTHORIZED", 5);
        $VALUES = (new .VALUES[] {
            NOT_AUTHORIZED, WAITING, RECEIVED, VALIDATE, TIMEOUT, AUTHORIZED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
