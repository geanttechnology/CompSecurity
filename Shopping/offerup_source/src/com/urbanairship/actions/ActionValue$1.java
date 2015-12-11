// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Parcel;
import com.urbanairship.json.JsonValue;

// Referenced classes of package com.urbanairship.actions:
//            ActionValue

final class 
    implements android.os.ator
{

    public final ActionValue createFromParcel(Parcel parcel)
    {
        return new ActionValue((JsonValue)parcel.readParcelable(com/urbanairship/json/JsonValue.getClassLoader()));
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final ActionValue[] newArray(int i)
    {
        return new ActionValue[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
