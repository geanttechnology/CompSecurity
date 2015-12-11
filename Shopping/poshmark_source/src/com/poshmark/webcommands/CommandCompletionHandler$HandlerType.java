// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.webcommands;


// Referenced classes of package com.poshmark.webcommands:
//            CommandCompletionHandler

static final class  extends Enum
{

    private static final SIMPLE_CALLBACK $VALUES[];
    public static final SIMPLE_CALLBACK PICTURE;
    public static final SIMPLE_CALLBACK SIMPLE_CALLBACK;
    public static final SIMPLE_CALLBACK START_LISTINGS_FLOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/webcommands/CommandCompletionHandler$HandlerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PICTURE = new <init>("PICTURE", 0);
        START_LISTINGS_FLOW = new <init>("START_LISTINGS_FLOW", 1);
        SIMPLE_CALLBACK = new <init>("SIMPLE_CALLBACK", 2);
        $VALUES = (new .VALUES[] {
            PICTURE, START_LISTINGS_FLOW, SIMPLE_CALLBACK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
