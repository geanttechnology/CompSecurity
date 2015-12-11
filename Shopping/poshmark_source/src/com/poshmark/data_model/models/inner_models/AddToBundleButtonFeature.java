// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class AddToBundleButtonFeature
{
    class Feature
    {

        boolean enabled;
        final AddToBundleButtonFeature this$0;
        String title;

        Feature()
        {
            this$0 = AddToBundleButtonFeature.this;
            super();
            enabled = false;
        }
    }


    Feature android;

    public AddToBundleButtonFeature()
    {
    }

    public String getTitle()
    {
        if (android == null)
        {
            return null;
        } else
        {
            return android.title;
        }
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
