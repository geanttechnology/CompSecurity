// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IMapOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapOptions

class this._cls0 extends PrimitiveBase
    implements IMapOptionsPrimitive
{

    final AmazonMapOptions this$0;

    public Boolean getAlignCompassBottom()
    {
        return ((AmazonMapOptions)get()).getAlignCompassBottom();
    }

    public Boolean getAlignCompassLeft()
    {
        return ((AmazonMapOptions)get()).getAlignCompassLeft();
    }

    public Boolean getAlignCompassRight()
    {
        return ((AmazonMapOptions)get()).getAlignCompassRight();
    }

    public Boolean getAlignCompassTop()
    {
        return ((AmazonMapOptions)get()).getAlignCompassTop();
    }

    public Boolean getAlignLocatorBottom()
    {
        return ((AmazonMapOptions)get()).getAlignLocatorBottom();
    }

    public Boolean getAlignLocatorLeft()
    {
        return ((AmazonMapOptions)get()).getAlignLocatorLeft();
    }

    public Boolean getAlignLocatorRight()
    {
        return ((AmazonMapOptions)get()).getAlignLocatorRight();
    }

    public Boolean getAlignLocatorTop()
    {
        return ((AmazonMapOptions)get()).getAlignLocatorTop();
    }

    public ICameraPositionPrimitive getCamera()
    {
        return Primitives.create(((AmazonMapOptions)get()).getCamera());
    }

    public Integer getCompassDrawable()
    {
        return ((AmazonMapOptions)get()).getCompassDrawable();
    }

    public Boolean getCompassEnabled()
    {
        return ((AmazonMapOptions)get()).getCompassEnabled();
    }

    public Boolean getLiteMode()
    {
        return ((AmazonMapOptions)get()).getLiteMode();
    }

    public Integer getLocatorDrawable()
    {
        return ((AmazonMapOptions)get()).getLocatorDrawable();
    }

    public Boolean getMapToolbarEnabled()
    {
        return ((AmazonMapOptions)get()).getMapToolbarEnabled();
    }

    public int getMapType()
    {
        return ((AmazonMapOptions)get()).getMapType();
    }

    public Boolean getRestrictCamera()
    {
        return ((AmazonMapOptions)get()).getRestrictCamera();
    }

    public String getRestrictCameraBounds()
    {
        return ((AmazonMapOptions)get()).getRestrictCameraBounds();
    }

    public Boolean getRotateGesturesEnabled()
    {
        return ((AmazonMapOptions)get()).getRotateGesturesEnabled();
    }

    public Boolean getScrollGesturesEnabled()
    {
        return ((AmazonMapOptions)get()).getScrollGesturesEnabled();
    }

    public Boolean getTileReplacer()
    {
        return ((AmazonMapOptions)get()).getTileReplacer();
    }

    public Boolean getTiltGesturesEnabled()
    {
        return ((AmazonMapOptions)get()).getTiltGesturesEnabled();
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return ((AmazonMapOptions)get()).getUseViewLifecycleInFragment();
    }

    public Boolean getZOrderOnTop()
    {
        return ((AmazonMapOptions)get()).getZOrderOnTop();
    }

    public Boolean getZoomControlsEnabled()
    {
        return ((AmazonMapOptions)get()).getZoomControlsEnabled();
    }

    public Boolean getZoomGesturesEnabled()
    {
        return ((AmazonMapOptions)get()).getZoomGesturesEnabled();
    }

    ve()
    {
        this$0 = AmazonMapOptions.this;
        super(AmazonMapOptions.this);
    }
}
