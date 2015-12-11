// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;


// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander

public static final class  extends Enum
{

    private static final ALWAYS_UPGRADE $VALUES[];
    public static final ALWAYS_UPGRADE ALWAYS_UPGRADE;
    public static final ALWAYS_UPGRADE DONT_UPGRADE;
    public static final ALWAYS_UPGRADE USE_DEFAULT_UPGRADE_LOGIC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/client/framework/acf/module/ApkAssetExpander$VersionQueryResponse, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        USE_DEFAULT_UPGRADE_LOGIC = new <init>("USE_DEFAULT_UPGRADE_LOGIC", 0);
        DONT_UPGRADE = new <init>("DONT_UPGRADE", 1);
        ALWAYS_UPGRADE = new <init>("ALWAYS_UPGRADE", 2);
        $VALUES = (new .VALUES[] {
            USE_DEFAULT_UPGRADE_LOGIC, DONT_UPGRADE, ALWAYS_UPGRADE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
