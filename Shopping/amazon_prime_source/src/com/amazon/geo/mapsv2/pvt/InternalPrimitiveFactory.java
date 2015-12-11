// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import com.amazon.geo.mapsv2.model.TileProvider;
import com.amazon.geo.mapsv2.model.internal.ITileProviderPrimitive;

public interface InternalPrimitiveFactory
{

    public abstract ITileProviderPrimitive create(TileProvider tileprovider);
}
