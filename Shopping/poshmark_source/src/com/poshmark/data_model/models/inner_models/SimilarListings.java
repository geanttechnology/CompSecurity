// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class SimilarListings extends Feature
{
    public class DeviceType
    {

        public int count;
        public boolean enabled;
        final SimilarListings this$0;

        public DeviceType()
        {
            this$0 = SimilarListings.this;
            super();
        }
    }


    public DeviceType mobile;

    public SimilarListings()
    {
    }
}
