// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;
import com.amazon.geo.mapsv2.pvt.SafeParcelable;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            TileCreator

public final class Tile
    implements SafeParcelable
{

    public static final TileCreator CREATOR = new TileCreator();
    public final byte data[];
    public final int height;
    public final int width;

    public Tile(int i, int j, byte abyte0[])
    {
        width = i;
        height = j;
        data = abyte0;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        TileCreator.write(this, parcel, i);
    }

}
