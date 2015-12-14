// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.location.Location;
import java.util.EnumSet;

// Referenced classes of package com.mopub.nativeads:
//            RequestParameters

public static final class 
{

    private EnumSet desiredAssets;
    private String keywords;
    private Location location;

    public final RequestParameters build()
    {
        return new RequestParameters(this, null);
    }

    public final  desiredAssets(EnumSet enumset)
    {
        desiredAssets = EnumSet.copyOf(enumset);
        return this;
    }

    public final desiredAssets keywords(String s)
    {
        keywords = s;
        return this;
    }

    public final keywords location(Location location1)
    {
        location = location1;
        return this;
    }




    public ()
    {
    }
}
