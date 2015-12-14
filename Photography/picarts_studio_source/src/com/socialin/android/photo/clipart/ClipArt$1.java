// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.os.Parcel;

// Referenced classes of package com.socialin.android.photo.clipart:
//            ClipArt

final class 
    implements android.os..Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new ClipArt(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ClipArt[i];
    }

    ()
    {
    }
}
