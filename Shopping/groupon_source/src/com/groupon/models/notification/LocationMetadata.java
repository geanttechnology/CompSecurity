// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.notification;

import com.groupon.models.nst.JsonEncodedNSTField;

public class LocationMetadata extends JsonEncodedNSTField
{

    public boolean hadLocation;
    public boolean hadToken;
    public boolean locationEnabled;

    public LocationMetadata()
    {
    }
}
