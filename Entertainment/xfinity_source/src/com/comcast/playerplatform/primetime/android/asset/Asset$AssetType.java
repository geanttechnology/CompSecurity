// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;


// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            Asset

public static final class  extends Enum
{

    private static final DISNEY $VALUES[];
    public static final DISNEY DISNEY;
    public static final DISNEY ESPN;
    public static final DISNEY PRIMETIME;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/asset/Asset$AssetType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRIMETIME = new <init>("PRIMETIME", 0);
        ESPN = new <init>("ESPN", 1);
        DISNEY = new <init>("DISNEY", 2);
        $VALUES = (new .VALUES[] {
            PRIMETIME, ESPN, DISNEY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
