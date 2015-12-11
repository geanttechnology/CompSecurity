// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            MultiDataBufferRef, AppContentCondition, AppContentConditionEntity, AppContentUtils

public final class AppContentConditionRef extends MultiDataBufferRef
    implements AppContentCondition
{

    AppContentConditionRef(ArrayList arraylist, int i)
    {
        super(arraylist, 4, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return AppContentConditionEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzuj();
    }

    public int hashCode()
    {
        return AppContentConditionEntity.zza(this);
    }

    public String toString()
    {
        return AppContentConditionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((AppContentConditionEntity)zzuj()).writeToParcel(parcel, i);
    }

    public String zzuf()
    {
        return getString("condition_default_value");
    }

    public String zzug()
    {
        return getString("condition_expected_value");
    }

    public String zzuh()
    {
        return getString("condition_predicate");
    }

    public Bundle zzui()
    {
        return AppContentUtils.zzd(zzabq, zzauU, "condition_predicate_parameters", zzadl);
    }

    public AppContentCondition zzuj()
    {
        return new AppContentConditionEntity(this);
    }
}
