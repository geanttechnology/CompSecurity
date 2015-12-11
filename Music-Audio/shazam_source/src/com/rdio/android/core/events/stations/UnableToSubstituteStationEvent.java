// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.stations;

import com.rdio.android.api.models.ApiModel;

public class UnableToSubstituteStationEvent
{

    private final ApiModel model;

    public UnableToSubstituteStationEvent(ApiModel apimodel)
    {
        model = apimodel;
    }

    public ApiModel getModel()
    {
        return model;
    }
}
