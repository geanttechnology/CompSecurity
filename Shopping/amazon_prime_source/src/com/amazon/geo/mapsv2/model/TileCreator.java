// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.Parcel;

// Referenced classes of package com.amazon.geo.mapsv2.model:
//            Tile

public class TileCreator
    implements android.os.Parcelable.Creator
{

    public TileCreator()
    {
    }

    static void write(Tile tile, Parcel parcel, int i)
    {
        parcel.writeInt(tile.width);
        parcel.writeInt(tile.height);
        parcel.writeInt(tile.data.length);
        parcel.writeByteArray(tile.data);
    }

    public Tile createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        int j = parcel.readInt();
        byte abyte0[] = new byte[parcel.readInt()];
        parcel.readByteArray(abyte0);
        return new Tile(i, j, abyte0);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public Tile[] newArray(int i)
    {
        return new Tile[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
