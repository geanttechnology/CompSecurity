// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.os.Parcel;

// Referenced classes of package com.picsart.studio.editor.item:
//            SvgItem

public class SvgClipArtItem extends SvgItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SvgClipArtItem(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SvgClipArtItem[i];
        }

    };

    protected SvgClipArtItem()
    {
    }

    protected SvgClipArtItem(Parcel parcel)
    {
        super(parcel);
    }

    public static SvgClipArtItem h()
    {
        return new SvgClipArtItem();
    }

}
