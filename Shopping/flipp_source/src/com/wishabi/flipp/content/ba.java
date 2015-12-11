// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;

// Referenced classes of package com.wishabi.flipp.content:
//            SimpleSearchResult

final class ba
    implements android.os.Parcelable.Creator
{

    ba()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new SimpleSearchResult(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new SimpleSearchResult[i];
    }
}
