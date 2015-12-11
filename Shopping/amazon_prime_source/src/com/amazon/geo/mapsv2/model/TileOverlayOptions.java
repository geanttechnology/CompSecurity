// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            TileOverlayOptionsCreator, TileProvider

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private boolean mFadeIn;
    private TileProvider mTileProvider;
    private boolean mVisible;
    private float mZIndex;

    public TileOverlayOptions()
    {
        mTileProvider = null;
        mVisible = true;
        mFadeIn = true;
        mZIndex = 0.0F;
    }

    TileOverlayOptions(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mTileProvider = null;
        mVisible = true;
        mFadeIn = true;
        mZIndex = 0.0F;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFadeIn = flag;
        mZIndex = parcel.readFloat();
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mVisible = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean flag)
    {
        mFadeIn = flag;
        return this;
    }

    public boolean getFadeIn()
    {
        return mFadeIn;
    }

    public TileProvider getTileProvider()
    {
        return mTileProvider;
    }

    public float getZIndex()
    {
        return mZIndex;
    }

    public boolean isVisible()
    {
        return mVisible;
    }

    public TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        mTileProvider = tileprovider;
        return this;
    }

    public TileOverlayOptions visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (mFadeIn)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeFloat(mZIndex);
        if (mVisible)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

    public TileOverlayOptions zIndex(float f)
    {
        mZIndex = f;
        return this;
    }

}
