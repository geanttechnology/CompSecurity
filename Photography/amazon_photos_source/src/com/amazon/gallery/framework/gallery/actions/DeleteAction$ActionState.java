// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

protected static final class  extends Enum
{

    private static final COMPLETED $VALUES[];
    public static final COMPLETED ACTIVATED;
    public static final COMPLETED COMPLETED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$ActionState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACTIVATED = new <init>("ACTIVATED", 0);
        COMPLETED = new <init>("COMPLETED", 1);
        $VALUES = (new .VALUES[] {
            ACTIVATED, COMPLETED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
