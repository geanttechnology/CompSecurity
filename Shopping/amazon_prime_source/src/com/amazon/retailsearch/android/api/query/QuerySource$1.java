// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.query;

import android.os.Parcel;

// Referenced classes of package com.amazon.retailsearch.android.api.query:
//            QuerySource

static final class 
    implements android.os.ator
{

    public QuerySource createFromParcel(Parcel parcel)
    {
        return QuerySource.access$000()[parcel.readInt()];
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public QuerySource[] newArray(int i)
    {
        return new QuerySource[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
