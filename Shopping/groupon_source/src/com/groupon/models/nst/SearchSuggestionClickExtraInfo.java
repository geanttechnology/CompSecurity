// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SearchSuggestionClickExtraInfo extends JsonEncodedNSTField
{

    private String placement;
    private String suggestionId;
    private String suggestionName;

    public SearchSuggestionClickExtraInfo(String s, String s1, String s2)
    {
        suggestionName = s;
        suggestionId = s1;
        placement = s2;
    }
}
