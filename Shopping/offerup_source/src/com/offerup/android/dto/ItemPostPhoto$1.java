// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            ItemPostPhoto

final class 
    implements android.os.or
{

    public final ItemPostPhoto createFromParcel(Parcel parcel)
    {
        return new ItemPostPhoto((String)parcel.readValue(java/lang/String.getClassLoader()), (Uri)parcel.readValue(android/net/Uri.getClassLoader()));
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ItemPostPhoto[] newArray(int i)
    {
        return new ItemPostPhoto[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
