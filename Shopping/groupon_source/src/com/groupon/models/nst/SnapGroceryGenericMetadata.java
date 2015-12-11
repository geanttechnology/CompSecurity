// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class SnapGroceryGenericMetadata extends JsonEncodedNSTField
{

    public String buttonType;
    public String offerId;
    public String pageId;
    public String position;

    public SnapGroceryGenericMetadata()
    {
        offerId = null;
        pageId = null;
        position = null;
        buttonType = null;
    }

    public SnapGroceryGenericMetadata(String s, String s1, String s2, String s3)
    {
        offerId = null;
        pageId = null;
        position = null;
        buttonType = null;
        offerId = s;
        pageId = s1;
        position = s2;
        buttonType = s3;
    }
}
