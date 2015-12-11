// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SearchFilterExpansionExtraInfo extends JsonEncodedNSTField
{

    public String action;
    public String filterName;

    public SearchFilterExpansionExtraInfo(String s, String s1)
    {
        action = s;
        filterName = s1;
    }
}
