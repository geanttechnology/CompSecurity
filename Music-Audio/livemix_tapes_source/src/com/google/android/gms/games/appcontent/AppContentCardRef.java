// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            MultiDataBufferRef, AppContentCard, AppContentCardEntity, AppContentUtils

public final class AppContentCardRef extends MultiDataBufferRef
    implements AppContentCard
{

    AppContentCardRef(ArrayList arraylist, int i)
    {
        super(arraylist, 0, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return AppContentCardEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zztp();
    }

    public List getActions()
    {
        return AppContentUtils.zza(zzYX, zzasw, "card_actions", zzabg);
    }

    public String getDescription()
    {
        return getString("card_description");
    }

    public Bundle getExtras()
    {
        return AppContentUtils.zzd(zzYX, zzasw, "card_data", zzabg);
    }

    public String getId()
    {
        return getString("card_id");
    }

    public String getTitle()
    {
        return getString("card_title");
    }

    public String getType()
    {
        return getString("card_type");
    }

    public int hashCode()
    {
        return AppContentCardEntity.zza(this);
    }

    public String toString()
    {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((AppContentCardEntity)zztp()).writeToParcel(parcel, i);
    }

    public List zzta()
    {
        return AppContentUtils.zzc(zzYX, zzasw, "card_conditions", zzabg);
    }

    public String zztb()
    {
        return getString("card_content_description");
    }

    public List zztl()
    {
        return AppContentUtils.zzb(zzYX, zzasw, "card_annotations", zzabg);
    }

    public int zztm()
    {
        return getInteger("card_current_steps");
    }

    public String zztn()
    {
        return getString("card_subtitle");
    }

    public int zzto()
    {
        return getInteger("card_total_steps");
    }

    public AppContentCard zztp()
    {
        return new AppContentCardEntity(this);
    }
}
