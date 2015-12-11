// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;


// Referenced classes of package co.vine.android.widget:
//            FakeActionBar

public static final class  extends Enum
{

    private static final LIGHT $VALUES[];
    public static final LIGHT DARK;
    public static final LIGHT LIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/widget/FakeActionBar$Theme, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DARK = new <init>("DARK", 0);
        LIGHT = new <init>("LIGHT", 1);
        $VALUES = (new .VALUES[] {
            DARK, LIGHT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
