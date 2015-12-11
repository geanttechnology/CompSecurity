// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.content:
//            FlyerInfo

final class k
    implements android.os.Parcelable.Creator
{

    k()
    {
    }

    private static FlyerInfo a(Parcel parcel)
    {
        parcel = parcel.readString();
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        parcel = FlyerInfo.a(new JSONObject(parcel));
        return parcel;
        parcel;
        return null;
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new FlyerInfo[i];
    }
}
