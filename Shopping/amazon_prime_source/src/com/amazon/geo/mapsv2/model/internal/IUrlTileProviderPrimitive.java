// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import java.net.URL;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            ITileProviderPrimitive

public interface IUrlTileProviderPrimitive
    extends ITileProviderPrimitive
{

    public abstract int getHeight();

    public abstract URL getTileUrl(int i, int j, int k);

    public abstract int getWidth();
}
