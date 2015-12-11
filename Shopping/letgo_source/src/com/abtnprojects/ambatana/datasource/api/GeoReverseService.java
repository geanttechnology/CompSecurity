// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.datasource.entities.address.GoogleAddressResponse;

public interface GeoReverseService
{

    public abstract GoogleAddressResponse fetch(String s);
}
