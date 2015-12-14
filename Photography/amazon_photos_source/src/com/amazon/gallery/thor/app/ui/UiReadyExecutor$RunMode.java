// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui;


// Referenced classes of package com.amazon.gallery.thor.app.ui:
//            UiReadyExecutor

private static final class  extends Enum
{

    private static final RUNNING $VALUES[];
    public static final RUNNING QUEUEING;
    public static final RUNNING RUNNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/ui/UiReadyExecutor$RunMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        QUEUEING = new <init>("QUEUEING", 0);
        RUNNING = new <init>("RUNNING", 1);
        $VALUES = (new .VALUES[] {
            QUEUEING, RUNNING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
