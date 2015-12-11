// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;
import com.google.android.gms.location.places.internal.zzp;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker
{

    public static final int RESULT_ERROR = 2;

    public PlacePicker()
    {
    }

    public static String getAttributions(Intent intent)
    {
        return intent.getStringExtra("third_party_attributions");
    }

    public static LatLngBounds getLatLngBounds(Intent intent)
    {
        return (LatLngBounds)zzc.zza(intent, "final_latlng_bounds", LatLngBounds.CREATOR);
    }

    public static Place getPlace(Intent intent, Context context)
    {
        zzx.zzb(context, "context must not be null");
        intent = (PlaceImpl)zzc.zza(intent, "selected_place", PlaceImpl.CREATOR);
        intent.zza(zzp.zzaF(context));
        return intent;
    }
}
