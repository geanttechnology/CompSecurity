// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.content.Context;
import android.util.AttributeSet;
import com.amazon.geo.mapsv2.model.CameraPosition;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapOptions

public final class AmazonMapOptionsInternal
{

    private final AmazonMapOptions mOptions;

    public AmazonMapOptionsInternal()
    {
        this(new AmazonMapOptions());
    }

    public AmazonMapOptionsInternal(AmazonMapOptions amazonmapoptions)
    {
        mOptions = amazonmapoptions;
    }

    public static AmazonMapOptionsInternal createFromAttributes(Context context, AttributeSet attributeset)
    {
        return new AmazonMapOptionsInternal(AmazonMapOptions.createFromAttributes(context, attributeset));
    }

    public AmazonMapOptionsInternal alignCompassBottom(Boolean boolean1)
    {
        get().alignCompassBottom(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignCompassLeft(Boolean boolean1)
    {
        get().alignCompassLeft(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignCompassRight(Boolean boolean1)
    {
        get().alignCompassRight(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignCompassTop(Boolean boolean1)
    {
        get().alignCompassTop(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignLocatorBottom(Boolean boolean1)
    {
        get().alignLocatorBottom(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignLocatorLeft(Boolean boolean1)
    {
        get().alignLocatorLeft(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignLocatorRight(Boolean boolean1)
    {
        get().alignLocatorRight(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal alignLocatorTop(Boolean boolean1)
    {
        get().alignLocatorTop(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal camera(CameraPosition cameraposition)
    {
        get().camera(cameraposition);
        return this;
    }

    public AmazonMapOptionsInternal compassDrawable(Integer integer)
    {
        get().compassDrawable(integer);
        return this;
    }

    public AmazonMapOptionsInternal compassEnabled(boolean flag)
    {
        get().compassEnabled(flag);
        return this;
    }

    public AmazonMapOptions get()
    {
        return mOptions;
    }

    public Boolean getAlignCompassBottom()
    {
        return get().getAlignCompassBottom();
    }

    public Boolean getAlignCompassLeft()
    {
        return get().getAlignCompassLeft();
    }

    public Boolean getAlignCompassRight()
    {
        return get().getAlignCompassRight();
    }

    public Boolean getAlignCompassTop()
    {
        return get().getAlignCompassTop();
    }

    public Boolean getAlignLocatorBottom()
    {
        return get().getAlignLocatorBottom();
    }

    public Boolean getAlignLocatorLeft()
    {
        return get().getAlignLocatorLeft();
    }

    public Boolean getAlignLocatorRight()
    {
        return get().getAlignLocatorRight();
    }

    public Boolean getAlignLocatorTop()
    {
        return get().getAlignLocatorTop();
    }

    public CameraPosition getCamera()
    {
        return get().getCamera();
    }

    public Integer getCompassDrawable()
    {
        return get().getCompassDrawable();
    }

    public Boolean getCompassEnabled()
    {
        return get().getCompassEnabled();
    }

    public Boolean getLiteMode()
    {
        return get().getLiteMode();
    }

    public Integer getLocatorDrawable()
    {
        return get().getLocatorDrawable();
    }

    public Boolean getMapToolbarEnabled()
    {
        return get().getMapToolbarEnabled();
    }

    public int getMapType()
    {
        return get().getMapType();
    }

    public Boolean getRestrictCamera()
    {
        return get().getRestrictCamera();
    }

    public String getRestrictCameraBounds()
    {
        return get().getRestrictCameraBounds();
    }

    public Boolean getRotateGesturesEnabled()
    {
        return get().getRotateGesturesEnabled();
    }

    public Boolean getScrollGesturesEnabled()
    {
        return get().getScrollGesturesEnabled();
    }

    public Boolean getTileReplacer()
    {
        return get().getTileReplacer();
    }

    public Boolean getTiltGesturesEnabled()
    {
        return get().getTiltGesturesEnabled();
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return get().getUseViewLifecycleInFragment();
    }

    public Boolean getZOrderOnTop()
    {
        return get().getZOrderOnTop();
    }

    public Boolean getZoomControlsEnabled()
    {
        return get().getZoomControlsEnabled();
    }

    public Boolean getZoomGesturesEnabled()
    {
        return get().getZoomGesturesEnabled();
    }

    public AmazonMapOptionsInternal liteMode(boolean flag)
    {
        get().liteMode(flag);
        return this;
    }

    public AmazonMapOptionsInternal locatorDrawable(Integer integer)
    {
        get().locatorDrawable(integer);
        return this;
    }

    public AmazonMapOptionsInternal mapToolbarEnabled(boolean flag)
    {
        get().mapToolbarEnabled(flag);
        return this;
    }

    public AmazonMapOptionsInternal mapType(int i)
    {
        get().mapType(i);
        return this;
    }

    public AmazonMapOptionsInternal restrictCamera(Boolean boolean1)
    {
        get().restrictCamera(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal restrictCameraBounds(String s)
    {
        get().restrictCameraBounds(s);
        return this;
    }

    public AmazonMapOptionsInternal rotateGesturesEnabled(boolean flag)
    {
        get().rotateGesturesEnabled(flag);
        return this;
    }

    public AmazonMapOptionsInternal scrollGesturesEnabled(boolean flag)
    {
        get().scrollGesturesEnabled(flag);
        return this;
    }

    public AmazonMapOptionsInternal tileReplacer(Boolean boolean1)
    {
        get().tileReplacer(boolean1);
        return this;
    }

    public AmazonMapOptionsInternal tiltGesturesEnabled(boolean flag)
    {
        get().tiltGesturesEnabled(flag);
        return this;
    }

    public AmazonMapOptionsInternal useViewLifecycleInFragment(boolean flag)
    {
        get().useViewLifecycleInFragment(flag);
        return this;
    }

    public AmazonMapOptionsInternal zOrderOnTop(boolean flag)
    {
        get().zOrderOnTop(flag);
        return this;
    }

    public AmazonMapOptionsInternal zoomControlsEnabled(boolean flag)
    {
        get().zoomControlsEnabled(flag);
        return this;
    }

    public AmazonMapOptionsInternal zoomGesturesEnabled(boolean flag)
    {
        get().zoomGesturesEnabled(flag);
        return this;
    }
}
