// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            SearchParameters

static final class _cls9
    implements android.os.ls.SearchParameters._cls1
{

    public SearchParameters createFromParcel(Parcel parcel)
    {
        return new SearchParameters(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public SearchParameters[] newArray(int i)
    {
        return new SearchParameters[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    _cls9()
    {
    }
}
