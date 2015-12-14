// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.os.Parcel;

// Referenced classes of package com.cyberlink.you.database:
//            StickerPackObj

final class 
    implements android.os.r
{

    public StickerPackObj a(Parcel parcel)
    {
        return new StickerPackObj(parcel);
    }

    public StickerPackObj[] a(int i)
    {
        return new StickerPackObj[i];
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
