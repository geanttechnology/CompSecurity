// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;


// Referenced classes of package co.vine.android.client:
//            Session

public static final class  extends Enum
{

    private static final LOGGING_OUT $VALUES[];
    public static final LOGGING_OUT LOGGED_IN;
    public static final LOGGING_OUT LOGGED_OUT;
    public static final LOGGING_OUT LOGGING_IN;
    public static final LOGGING_OUT LOGGING_OUT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/client/Session$LoginStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOGGED_OUT = new <init>("LOGGED_OUT", 0);
        LOGGING_IN = new <init>("LOGGING_IN", 1);
        LOGGED_IN = new <init>("LOGGED_IN", 2);
        LOGGING_OUT = new <init>("LOGGING_OUT", 3);
        $VALUES = (new .VALUES[] {
            LOGGED_OUT, LOGGING_IN, LOGGED_IN, LOGGING_OUT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
