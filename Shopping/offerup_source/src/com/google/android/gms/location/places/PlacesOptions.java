// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;


public final class PlacesOptions
    implements com.google.android.gms.common.api.Api.ApiOptions.Optional
{

    public final String zzaGG;

    private PlacesOptions(Builder builder)
    {
        zzaGG = Builder.zza(builder);
    }

    PlacesOptions(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    private class Builder
    {

        private String zzaGH;

        static String zza(Builder builder)
        {
            return builder.zzaGH;
        }

        public PlacesOptions build()
        {
            return new PlacesOptions(this, null);
        }

        public Builder()
        {
        }
    }

}
