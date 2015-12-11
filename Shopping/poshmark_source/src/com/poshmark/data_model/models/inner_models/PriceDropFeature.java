// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class PriceDropFeature extends Feature
{
    public class SubFeature
    {

        public boolean enabled;
        final PriceDropFeature this$0;

        public SubFeature()
        {
            this$0 = PriceDropFeature.this;
            super();
            enabled = false;
        }
    }


    public SubFeature br;
    public SubFeature ld;
    public SubFeature mlk;
    public SubFeature shr;

    public PriceDropFeature()
    {
    }
}
