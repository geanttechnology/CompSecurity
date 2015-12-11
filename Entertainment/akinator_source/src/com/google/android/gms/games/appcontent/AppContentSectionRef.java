// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            MultiDataBufferRef, AppContentSection, AppContentSectionEntity, AppContentUtils, 
//            AppContentCardRef

public final class AppContentSectionRef extends MultiDataBufferRef
    implements AppContentSection
{

    private final int zzauX;

    AppContentSectionRef(ArrayList arraylist, int i, int j)
    {
        super(arraylist, 0, i);
        zzauX = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return AppContentSectionEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzum();
    }

    public List getActions()
    {
        return zzun();
    }

    public Bundle getExtras()
    {
        return AppContentUtils.zzd(zzabq, zzauU, "section_data", zzadl);
    }

    public String getId()
    {
        return getString("section_id");
    }

    public String getTitle()
    {
        return getString("section_title");
    }

    public String getType()
    {
        return getString("section_type");
    }

    public int hashCode()
    {
        return AppContentSectionEntity.zza(this);
    }

    public String toString()
    {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((AppContentSectionEntity)zzum()).writeToParcel(parcel, i);
    }

    public String zztQ()
    {
        return getString("section_content_description");
    }

    public List zzua()
    {
        return zzuo();
    }

    public String zzuc()
    {
        return getString("section_subtitle");
    }

    public List zzuk()
    {
        return zzup();
    }

    public String zzul()
    {
        return getString("section_card_type");
    }

    public AppContentSection zzum()
    {
        return new AppContentSectionEntity(this);
    }

    public ArrayList zzun()
    {
        return AppContentUtils.zza(zzabq, zzauU, "section_actions", zzadl);
    }

    public ArrayList zzuo()
    {
        return AppContentUtils.zzb(zzabq, zzauU, "section_annotations", zzadl);
    }

    public ArrayList zzup()
    {
        ArrayList arraylist = new ArrayList(zzauX);
        for (int i = 0; i < zzauX; i++)
        {
            arraylist.add(new AppContentCardRef(zzauU, zzadl + i));
        }

        return arraylist;
    }
}
