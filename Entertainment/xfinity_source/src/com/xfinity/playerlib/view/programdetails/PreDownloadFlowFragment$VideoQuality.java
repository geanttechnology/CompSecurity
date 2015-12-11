// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;


// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

private static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT DEFAULT;
    public static final DEFAULT HIGH;
    public static final DEFAULT LOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HIGH = new <init>("HIGH", 0);
        LOW = new <init>("LOW", 1);
        DEFAULT = new <init>("DEFAULT", 2);
        $VALUES = (new .VALUES[] {
            HIGH, LOW, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
