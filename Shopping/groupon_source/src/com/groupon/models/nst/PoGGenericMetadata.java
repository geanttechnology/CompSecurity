// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class PoGGenericMetadata extends JsonEncodedNSTField
{

    public Double lat;
    public Double lng;
    public String merchantId;
    public String placeName;
    public Integer placement;
    public String query;

    public PoGGenericMetadata()
    {
        merchantId = null;
        placeName = null;
        query = null;
        lat = null;
        lng = null;
        placement = null;
    }
}
