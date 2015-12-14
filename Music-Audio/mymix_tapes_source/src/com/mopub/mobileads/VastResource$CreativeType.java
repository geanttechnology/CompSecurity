// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            VastResource

static final class  extends Enum
{

    private static final JAVASCRIPT $VALUES[];
    public static final JAVASCRIPT IMAGE;
    public static final JAVASCRIPT JAVASCRIPT;
    public static final JAVASCRIPT NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/VastResource$CreativeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        IMAGE = new <init>("IMAGE", 1);
        JAVASCRIPT = new <init>("JAVASCRIPT", 2);
        $VALUES = (new .VALUES[] {
            NONE, IMAGE, JAVASCRIPT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
