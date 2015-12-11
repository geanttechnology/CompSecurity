// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorDelegate;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorFactoryDelegate;
import com.amazon.geo.mapsv2.pvt.RemoteContextUtils;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtil;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            BitmapDescriptor

public final class BitmapDescriptorFactory
{

    public static final float HUE_AZURE = 210F;
    public static final float HUE_BLUE = 240F;
    public static final float HUE_CYAN = 180F;
    public static final float HUE_GREEN = 120F;
    public static final float HUE_MAGENTA = 300F;
    public static final float HUE_ORANGE = 30F;
    public static final float HUE_RED = 0F;
    public static final float HUE_ROSE = 330F;
    public static final float HUE_VIOLET = 270F;
    public static final float HUE_YELLOW = 60F;

    private BitmapDescriptorFactory()
    {
    }

    private static BitmapDescriptor createDescriptor(IBitmapDescriptorDelegate ibitmapdescriptordelegate)
    {
        return new BitmapDescriptor(ibitmapdescriptordelegate);
    }

    public static BitmapDescriptor defaultMarker()
    {
        return createDescriptor(getFactory().defaultMarker());
    }

    public static BitmapDescriptor defaultMarker(float f)
    {
        return createDescriptor(getFactory().defaultMarker(f));
    }

    public static BitmapDescriptor fromAsset(String s)
    {
        return createDescriptor(getFactory().fromAsset(s));
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap)
    {
        return createDescriptor(getFactory().fromBitmap(bitmap));
    }

    public static BitmapDescriptor fromFile(String s)
    {
        return createDescriptor(getFactory().fromFile(s));
    }

    static BitmapDescriptor fromParcel(Parcel parcel)
    {
        parcel = getFactory().fromParcel(parcel);
        if (parcel == null)
        {
            return null;
        } else
        {
            return createDescriptor(parcel);
        }
    }

    public static BitmapDescriptor fromPath(String s)
    {
        return createDescriptor(getFactory().fromPath(s));
    }

    public static BitmapDescriptor fromResource(int i)
    {
        return createDescriptor(getFactory().fromResource(i));
    }

    private static IBitmapDescriptorFactoryDelegate getFactory()
    {
        IMapEngineDelegate imapenginedelegate = null;
        android.content.Context context = AmazonMapsRuntimeUtil.getRemoteContext(null);
        if (context != null)
        {
            imapenginedelegate = RemoteContextUtils.getMapEngine(context);
        }
        if (imapenginedelegate == null)
        {
            throw new NullPointerException("BitmapDescriptorFactory is not initialized");
        } else
        {
            return imapenginedelegate.getBitmapDescriptorFactory();
        }
    }

    static void write(BitmapDescriptor bitmapdescriptor, Parcel parcel, int i)
    {
        if (bitmapdescriptor == null)
        {
            bitmapdescriptor = null;
        } else
        {
            bitmapdescriptor = ((BitmapDescriptor) (bitmapdescriptor.id()));
        }
        getFactory().write((IBitmapDescriptorDelegate)com/amazon/geo/mapsv2/model/internal/IBitmapDescriptorDelegate.cast(bitmapdescriptor), parcel, i);
    }
}
