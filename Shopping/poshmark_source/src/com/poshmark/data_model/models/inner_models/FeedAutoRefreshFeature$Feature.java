// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            FeedAutoRefreshFeature

class enabled
{

    int auto_refresh_interval;
    boolean enabled;
    final FeedAutoRefreshFeature this$0;

    ()
    {
        this$0 = FeedAutoRefreshFeature.this;
        super();
        enabled = false;
    }
}
