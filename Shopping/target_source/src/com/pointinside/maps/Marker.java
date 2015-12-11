// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.drawable.Drawable;
import com.pointinside.maps.model.MarkerOptions;
import com.sun.jna.ptr.IntByReference;
import java.util.Arrays;
import java.util.UUID;

// Referenced classes of package com.pointinside.maps:
//            MarkerController, Location

public final class Marker
{

    private final MarkerController mController;
    private Drawable mDrawable;
    private boolean mIsDirty;
    private Location mLocation;
    private IntByReference mRef;
    private IntByReference mStyleRef;
    private int mTintColor;
    private String mTitle;
    private UUID mUUID;
    private MarkerOptions mUpdate;

    Marker(MarkerController markercontroller, MarkerOptions markeroptions, IntByReference intbyreference, IntByReference intbyreference1)
    {
        mController = markercontroller;
        mLocation = markeroptions.getLocation();
        mTitle = markeroptions.getTitle();
        mTintColor = markeroptions.getTintColor();
        mRef = intbyreference;
        mStyleRef = intbyreference1;
        mUUID = UUID.randomUUID();
        mDrawable = markeroptions.getMarkerDrawable();
        checkDirty();
    }

    private MarkerOptions getUpdateOptions()
    {
        if (mUpdate == null)
        {
            mUpdate = (new MarkerOptions()).location(mLocation).tintColor(mTintColor).title(mTitle).markerDrawable(mDrawable);
        }
        return mUpdate;
    }

    void checkDirty()
    {
        boolean flag;
        if (mRef == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsDirty = flag;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Marker))
        {
            return false;
        } else
        {
            obj = (Marker)obj;
            return mUUID.equals(((Marker) (obj)).mUUID);
        }
    }

    IntByReference get()
    {
        return mRef;
    }

    public Drawable getDrawable()
    {
        return mDrawable;
    }

    public Location getLocation()
    {
        return mLocation;
    }

    IntByReference getStyle()
    {
        return mStyleRef;
    }

    public Integer getTintColor()
    {
        return Integer.valueOf(mTintColor);
    }

    public String getTitle()
    {
        return mTitle;
    }

    UUID getUUID()
    {
        return mUUID;
    }

    MarkerOptions getUpdate()
    {
        return mUpdate;
    }

    public int hashCode()
    {
        Object obj;
        if (mRef == null)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(mRef.getValue());
        }
        return Arrays.hashCode(new Object[] {
            obj, mUUID, mLocation
        });
    }

    boolean isDirty()
    {
        return mIsDirty;
    }

    public Marker location(Location location1)
    {
        getUpdateOptions().location(location1);
        return this;
    }

    public Marker markerDrawable(Drawable drawable)
    {
        getUpdateOptions().markerDrawable(drawable);
        return this;
    }

    public Marker markerDrawable(Drawable drawable, com.pointinside.maps.model.MarkerOptions.AnchorPoint anchorpoint)
    {
        getUpdateOptions().markerDrawable(drawable, anchorpoint);
        return this;
    }

    public void remove()
    {
        mController.removeMarker(this);
    }

    public void sendToBack()
    {
        mController.sendToBack(this);
    }

    public void sendToFront()
    {
        mController.sendToFront(this);
    }

    void setRef(IntByReference intbyreference)
    {
        mRef = intbyreference;
        checkDirty();
    }

    void setStyle(IntByReference intbyreference)
    {
        mStyleRef = intbyreference;
    }

    public Marker shadowDrawable(Drawable drawable)
    {
        getUpdateOptions().shadowDrawable(drawable);
        return this;
    }

    public Marker shadowDrawable(Drawable drawable, com.pointinside.maps.model.MarkerOptions.AnchorPoint anchorpoint)
    {
        getUpdateOptions().shadowDrawable(drawable, anchorpoint);
        return this;
    }

    public Marker tintColor(int i)
    {
        getUpdateOptions().tintColor(i);
        return this;
    }

    public Marker title(String s)
    {
        getUpdateOptions().title(s);
        return this;
    }

    public void update(PIMap.UpdateMarkerAnimation updatemarkeranimation)
    {
        if (mUpdate != null)
        {
            Location location1 = mUpdate.getLocation();
            if (location1 != null)
            {
                mLocation = location1;
            }
            mTitle = mUpdate.getTitle();
            mTintColor = mUpdate.getTintColor();
            if (mUpdate.getMarkerDrawable() != null)
            {
                mDrawable = mUpdate.getMarkerDrawable();
            }
            mController.updateMarker(this, updatemarkeranimation);
            mUpdate = null;
        }
    }
}
