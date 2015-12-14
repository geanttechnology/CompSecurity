// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractPanelLoaderService

private static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT DEFAULT;
    public static final DEFAULT FREETIME;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService$PanelMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FREETIME = new <init>("FREETIME", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        $VALUES = (new .VALUES[] {
            FREETIME, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
