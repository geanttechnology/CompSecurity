// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class AutoCompleteFeature extends Feature
{

    boolean enabled;

    public AutoCompleteFeature()
    {
        enabled = false;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
