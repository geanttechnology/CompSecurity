// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SearchFilterNameAndPositionExtraInfo extends JsonEncodedNSTField
{

    public String facetName;
    public int filterPosition;

    public SearchFilterNameAndPositionExtraInfo(String s, int i)
    {
        facetName = s;
        filterPosition = i;
    }
}
