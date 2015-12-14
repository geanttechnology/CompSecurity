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

    private final int zzasz;

    AppContentSectionRef(ArrayList arraylist, int i, int j)
    {
        super(arraylist, 0, i);
        zzasz = j;
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
        return zztx();
    }

    public List getActions()
    {
        return zzty();
    }

    public Bundle getExtras()
    {
        return AppContentUtils.zzd(zzYX, zzasw, "section_data", zzabg);
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
        ((AppContentSectionEntity)zztx()).writeToParcel(parcel, i);
    }

    public ArrayList zztA()
    {
        ArrayList arraylist = new ArrayList(zzasz);
        for (int i = 0; i < zzasz; i++)
        {
            arraylist.add(new AppContentCardRef(zzasw, zzabg + i));
        }

        return arraylist;
    }

    public String zztb()
    {
        return getString("section_content_description");
    }

    public List zztl()
    {
        return zztz();
    }

    public String zztn()
    {
        return getString("section_subtitle");
    }

    public List zztv()
    {
        return zztA();
    }

    public String zztw()
    {
        return getString("section_card_type");
    }

    public AppContentSection zztx()
    {
        return new AppContentSectionEntity(this);
    }

    public ArrayList zzty()
    {
        return AppContentUtils.zza(zzYX, zzasw, "section_actions", zzabg);
    }

    public ArrayList zztz()
    {
        return AppContentUtils.zzb(zzYX, zzasw, "section_annotations", zzabg);
    }
}
