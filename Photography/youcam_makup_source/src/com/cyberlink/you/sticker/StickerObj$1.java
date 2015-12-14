// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.os.Parcel;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerObj

final class 
    implements android.os.eator
{

    public StickerObj a(Parcel parcel)
    {
        return new StickerObj(parcel);
    }

    public StickerObj[] a(int i)
    {
        return new StickerObj[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
