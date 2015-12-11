// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;


// Referenced classes of package com.poshmark.triggers:
//            PMTrigger

public static final class  extends Enum
{

    private static final INTERACTED $VALUES[];
    public static final INTERACTED DISMISSED;
    public static final INTERACTED IGNORED;
    public static final INTERACTED INITIAL;
    public static final INTERACTED INTERACTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/triggers/PMTrigger$TriggerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INITIAL = new <init>("INITIAL", 0);
        IGNORED = new <init>("IGNORED", 1);
        DISMISSED = new <init>("DISMISSED", 2);
        INTERACTED = new <init>("INTERACTED", 3);
        $VALUES = (new .VALUES[] {
            INITIAL, IGNORED, DISMISSED, INTERACTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
