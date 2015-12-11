// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


// Referenced classes of package com.comcast.cim.android.accessibility:
//            DefaultTalkDelegate

public static final class  extends Enum
{

    private static final DO_NOTHING $VALUES[];
    public static final DO_NOTHING DO_NOTHING;
    public static final DO_NOTHING FOLLOWUP_WITH_LISTEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/cim/android/accessibility/DefaultTalkDelegate$UtteranceID, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FOLLOWUP_WITH_LISTEN = new <init>("FOLLOWUP_WITH_LISTEN", 0);
        DO_NOTHING = new <init>("DO_NOTHING", 1);
        $VALUES = (new .VALUES[] {
            FOLLOWUP_WITH_LISTEN, DO_NOTHING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
