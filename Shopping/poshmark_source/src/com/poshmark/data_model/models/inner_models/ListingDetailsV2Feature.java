// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class ListingDetailsV2Feature
{
    class Feature
    {

        boolean enabled;
        final ListingDetailsV2Feature this$0;

        Feature()
        {
            this$0 = ListingDetailsV2Feature.this;
            super();
            enabled = false;
        }
    }


    Feature android;

    public ListingDetailsV2Feature()
    {
    }

    public boolean isEnabled()
    {
        if (android == null)
        {
            return false;
        } else
        {
            return android.enabled;
        }
    }
}
