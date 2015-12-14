// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import java.util.Locale;

public final class PlacementType extends Enum
{

    private static final PlacementType $VALUES[];
    public static final PlacementType INLINE;
    public static final PlacementType INTERSTITIAL;

    private PlacementType(String s, int i)
    {
        super(s, i);
    }

    public static PlacementType valueOf(String s)
    {
        return (PlacementType)Enum.valueOf(com/mopub/mraid/PlacementType, s);
    }

    public static PlacementType[] values()
    {
        return (PlacementType[])$VALUES.clone();
    }

    String toJavascriptString()
    {
        return toString().toLowerCase(Locale.US);
    }

    static 
    {
        INLINE = new PlacementType("INLINE", 0);
        INTERSTITIAL = new PlacementType("INTERSTITIAL", 1);
        $VALUES = (new PlacementType[] {
            INLINE, INTERSTITIAL
        });
    }
}
