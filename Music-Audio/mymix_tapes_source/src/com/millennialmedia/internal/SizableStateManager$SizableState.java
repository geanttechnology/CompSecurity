// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            SizableStateManager

private static final class  extends Enum
{

    private static final STATE_COLLAPSED $VALUES[];
    public static final STATE_COLLAPSED STATE_COLLAPSED;
    public static final STATE_COLLAPSED STATE_EXPANDED;
    public static final STATE_COLLAPSED STATE_RESIZED;
    public static final STATE_COLLAPSED STATE_UNRESIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/millennialmedia/internal/SizableStateManager$SizableState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_RESIZED = new <init>("STATE_RESIZED", 0);
        STATE_UNRESIZED = new <init>("STATE_UNRESIZED", 1);
        STATE_EXPANDED = new <init>("STATE_EXPANDED", 2);
        STATE_COLLAPSED = new <init>("STATE_COLLAPSED", 3);
        $VALUES = (new .VALUES[] {
            STATE_RESIZED, STATE_UNRESIZED, STATE_EXPANDED, STATE_COLLAPSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
