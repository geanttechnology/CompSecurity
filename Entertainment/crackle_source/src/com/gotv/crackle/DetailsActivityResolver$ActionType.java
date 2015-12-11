// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;


// Referenced classes of package com.gotv.crackle:
//            DetailsActivityResolver

public static final class _cls9 extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE CRACKLE_DEEPLINK;
    public static final NONE NONE;
    public static final NONE URI_DEEPLINK;
    public static final NONE YOSEMITE_DEEPLINK;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/gotv/crackle/DetailsActivityResolver$ActionType, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        CRACKLE_DEEPLINK = new <init>("CRACKLE_DEEPLINK", 0);
        YOSEMITE_DEEPLINK = new <init>("YOSEMITE_DEEPLINK", 1);
        URI_DEEPLINK = new <init>("URI_DEEPLINK", 2);
        NONE = new <init>("NONE", 3);
        $VALUES = (new .VALUES[] {
            CRACKLE_DEEPLINK, YOSEMITE_DEEPLINK, URI_DEEPLINK, NONE
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
