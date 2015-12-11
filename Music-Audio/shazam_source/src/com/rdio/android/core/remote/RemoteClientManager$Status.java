// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;


// Referenced classes of package com.rdio.android.core.remote:
//            RemoteClientManager

public static final class  extends Enum
{

    private static final Master $VALUES[];
    public static final Master Elsewhere;
    public static final Master Master;
    public static final Master Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/core/remote/RemoteClientManager$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Unknown = new <init>("Unknown", 0);
        Elsewhere = new <init>("Elsewhere", 1);
        Master = new <init>("Master", 2);
        $VALUES = (new .VALUES[] {
            Unknown, Elsewhere, Master
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
