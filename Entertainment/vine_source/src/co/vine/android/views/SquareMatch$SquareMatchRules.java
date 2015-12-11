// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;


// Referenced classes of package co.vine.android.views:
//            SquareMatch

public static final class  extends Enum
{

    private static final MATCH_LESS $VALUES[];
    public static final MATCH_LESS MATCH_GREATER;
    public static final MATCH_LESS MATCH_HEIGHT;
    public static final MATCH_LESS MATCH_LESS;
    public static final MATCH_LESS MATCH_WIDTH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/views/SquareMatch$SquareMatchRules, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MATCH_WIDTH = new <init>("MATCH_WIDTH", 0);
        MATCH_HEIGHT = new <init>("MATCH_HEIGHT", 1);
        MATCH_GREATER = new <init>("MATCH_GREATER", 2);
        MATCH_LESS = new <init>("MATCH_LESS", 3);
        $VALUES = (new .VALUES[] {
            MATCH_WIDTH, MATCH_HEIGHT, MATCH_GREATER, MATCH_LESS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
