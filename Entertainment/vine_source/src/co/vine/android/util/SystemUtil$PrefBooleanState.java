// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


// Referenced classes of package co.vine.android.util:
//            SystemUtil

public static final class  extends Enum
{

    private static final FALSE $VALUES[];
    public static final FALSE FALSE;
    public static final FALSE TRUE;
    public static final FALSE UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/util/SystemUtil$PrefBooleanState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        TRUE = new <init>("TRUE", 1);
        FALSE = new <init>("FALSE", 2);
        $VALUES = (new .VALUES[] {
            UNKNOWN, TRUE, FALSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
