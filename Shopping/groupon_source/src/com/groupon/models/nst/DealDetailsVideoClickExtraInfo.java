// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DealDetailsVideoClickExtraInfo extends JsonEncodedNSTField
{

    protected String dealID;
    protected String dealUUID;
    protected boolean isFirstClick;

    public DealDetailsVideoClickExtraInfo(String s, String s1, boolean flag)
    {
        dealID = s;
        dealUUID = s1;
        isFirstClick = flag;
    }
}
