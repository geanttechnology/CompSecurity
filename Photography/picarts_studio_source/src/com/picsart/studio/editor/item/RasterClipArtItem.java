// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor.item:
//            ImageItem

public class RasterClipArtItem extends ImageItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new RasterClipArtItem(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new RasterClipArtItem[i];
        }

    };

    protected RasterClipArtItem()
    {
    }

    protected RasterClipArtItem(Parcel parcel)
    {
        super(parcel);
    }

    public static RasterClipArtItem p()
    {
        return new RasterClipArtItem();
    }

}
