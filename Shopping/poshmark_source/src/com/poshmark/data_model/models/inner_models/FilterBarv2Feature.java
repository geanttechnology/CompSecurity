// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class FilterBarv2Feature extends com.poshmark.data_model.models.inner_models.Feature
{
    class Feature
    {

        boolean enabled;
        final FilterBarv2Feature this$0;

        Feature()
        {
            this$0 = FilterBarv2Feature.this;
            super();
        }
    }


    Feature android;

    public FilterBarv2Feature()
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
