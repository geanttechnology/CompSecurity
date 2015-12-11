// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;


// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IMapViewDelegate

public static final class  extends Enum
{

    private static final RESUMED $VALUES[];
    public static final RESUMED CREATED;
    public static final RESUMED RESUMED;
    public static final RESUMED UNINITIALIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/geo/mapsv2/internal/IMapViewDelegate$LifecycleState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNINITIALIZED = new <init>("UNINITIALIZED", 0);
        CREATED = new <init>("CREATED", 1);
        RESUMED = new <init>("RESUMED", 2);
        $VALUES = (new .VALUES[] {
            UNINITIALIZED, CREATED, RESUMED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
