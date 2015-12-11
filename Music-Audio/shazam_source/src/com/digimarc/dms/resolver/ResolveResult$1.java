// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Parcel;
import com.digimarc.dms.imagereader.Payload;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolveResult, StandardPayoff

static final class yoffType
    implements android.os.or
{

    public final ResolveResult createFromParcel(Parcel parcel)
    {
        return new ResolveResult(yoffType.valueOf(parcel.readString()), (Payload)parcel.readParcelable(com/digimarc/dms/imagereader/Payload.getClassLoader()), parcel.readInt(), (StandardPayoff)parcel.readParcelable(com/digimarc/dms/resolver/StandardPayoff.getClassLoader()));
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ResolveResult[] newArray(int i)
    {
        return null;
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    yoffType()
    {
    }
}
