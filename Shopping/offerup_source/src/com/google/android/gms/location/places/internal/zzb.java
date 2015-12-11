// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzu, zzc, AutocompletePredictionEntity

public class zzb extends zzu
    implements AutocompletePrediction
{

    public zzb(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private String zzwX()
    {
        return zzF("ap_description", "");
    }

    private String zzwY()
    {
        return zzF("ap_primary_text", "");
    }

    private String zzwZ()
    {
        return zzF("ap_secondary_text", "");
    }

    private List zzxa()
    {
        return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List zzxb()
    {
        return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List zzxc()
    {
        return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    public Object freeze()
    {
        return zzwV();
    }

    public String getDescription()
    {
        return zzwX();
    }

    public CharSequence getFullText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzwX(), zzxa(), characterstyle);
    }

    public List getMatchedSubstrings()
    {
        return zzxa();
    }

    public String getPlaceId()
    {
        return zzF("ap_place_id", null);
    }

    public List getPlaceTypes()
    {
        return zza("ap_place_types", Collections.emptyList());
    }

    public CharSequence getPrimaryText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzwY(), zzxb(), characterstyle);
    }

    public CharSequence getSecondaryText(CharacterStyle characterstyle)
    {
        return zzc.zza(zzwZ(), zzxc(), characterstyle);
    }

    public AutocompletePrediction zzwV()
    {
        return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzwW(), zzwX(), zzxa(), zzwY(), zzxb(), zzwZ(), zzxc());
    }

    public int zzwW()
    {
        return zzz("ap_personalization_type", 6);
    }
}
