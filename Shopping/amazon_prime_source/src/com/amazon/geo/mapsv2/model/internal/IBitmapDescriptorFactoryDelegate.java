// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;

import android.graphics.Bitmap;
import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            IBitmapDescriptorDelegate

public interface IBitmapDescriptorFactoryDelegate
{

    public abstract IBitmapDescriptorDelegate defaultMarker();

    public abstract IBitmapDescriptorDelegate defaultMarker(float f);

    public abstract IBitmapDescriptorDelegate fromAsset(String s);

    public abstract IBitmapDescriptorDelegate fromBitmap(Bitmap bitmap);

    public abstract IBitmapDescriptorDelegate fromFile(String s);

    public abstract IBitmapDescriptorDelegate fromParcel(Parcel parcel);

    public abstract IBitmapDescriptorDelegate fromPath(String s);

    public abstract IBitmapDescriptorDelegate fromResource(int i);

    public abstract void write(IBitmapDescriptorDelegate ibitmapdescriptordelegate, Parcel parcel, int i);
}
