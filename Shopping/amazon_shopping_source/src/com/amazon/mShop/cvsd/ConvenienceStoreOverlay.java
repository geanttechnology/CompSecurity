// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.graphics.drawable.Drawable;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.amazon.rio.j2me.client.services.mShop.Coordinates;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.cvsd:
//            ConvenienceStoreMarkerTapListener

public class ConvenienceStoreOverlay extends ItemizedOverlay
{

    private final List mConvenienceStoreOverlayItemList = new ArrayList();
    private List mConvenienceStoreResultList;
    private final ConvenienceStoreMarkerTapListener mStoreMarkerTapListener;

    public ConvenienceStoreOverlay(Drawable drawable, List list, ConvenienceStoreMarkerTapListener conveniencestoremarkertaplistener)
    {
        super(boundCenterBottom(drawable));
        mConvenienceStoreResultList = list;
        mStoreMarkerTapListener = conveniencestoremarkertaplistener;
        mConvenienceStoreOverlayItemList.clear();
        for (int i = 0; i < mConvenienceStoreResultList.size(); i++)
        {
            drawable = (Address)mConvenienceStoreResultList.get(i);
            list = drawable.getLocation().getLatitude();
            conveniencestoremarkertaplistener = drawable.getLocation().getLongitude();
            drawable = new OverlayItem(new GeoPoint((int)((double)Float.parseFloat(list) * Math.pow(10D, 6D)), (int)((double)Float.parseFloat(conveniencestoremarkertaplistener) * Math.pow(10D, 6D))), drawable.getName(), "");
            mConvenienceStoreOverlayItemList.add(drawable);
            populate();
        }

    }

    protected OverlayItem createItem(int i)
    {
        return (OverlayItem)mConvenienceStoreOverlayItemList.get(i);
    }

    public int getOverlayItemIndex(OverlayItem overlayitem)
    {
        return mConvenienceStoreOverlayItemList.indexOf(overlayitem);
    }

    protected boolean onTap(int i)
    {
        mStoreMarkerTapListener.onTap((OverlayItem)mConvenienceStoreOverlayItemList.get(i));
        return true;
    }

    public boolean onTap(GeoPoint geopoint, MapView mapview)
    {
        boolean flag = super.onTap(geopoint, mapview);
        if (!flag)
        {
            mStoreMarkerTapListener.onNoOverlayItemTap();
        }
        return flag;
    }

    public int size()
    {
        return mConvenienceStoreOverlayItemList.size();
    }
}
