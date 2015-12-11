// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            RequestContext

static final class 
    implements android.os.r
{

    public RequestContext createFromParcel(Parcel parcel)
    {
        return new RequestContext(parcel);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public RequestContext[] newArray(int i)
    {
        return new RequestContext[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
