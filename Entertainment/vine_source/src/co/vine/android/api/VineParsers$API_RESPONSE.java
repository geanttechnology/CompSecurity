// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;


// Referenced classes of package co.vine.android.api:
//            VineParsers

public static final class  extends Enum
{

    private static final FAILURE $VALUES[];
    public static final FAILURE FAILURE;
    public static final FAILURE SUCCESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/api/VineParsers$API_RESPONSE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new <init>("SUCCESS", 0);
        FAILURE = new <init>("FAILURE", 1);
        $VALUES = (new .VALUES[] {
            SUCCESS, FAILURE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
