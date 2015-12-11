// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.models:
//            SearchSongbookResult

final class 
    implements android.os.earchSongbookResult._cls1
{

    public SearchSongbookResult a(Parcel parcel)
    {
        return new SearchSongbookResult(parcel);
    }

    public SearchSongbookResult[] a(int i)
    {
        return new SearchSongbookResult[i];
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
