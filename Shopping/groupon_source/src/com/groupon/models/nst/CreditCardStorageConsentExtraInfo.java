// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CreditCardStorageConsentExtraInfo extends JsonEncodedNSTField
{

    public String defaultSelection;
    public String pageId;

    public CreditCardStorageConsentExtraInfo(String s, String s1)
    {
        pageId = s;
        defaultSelection = s1;
    }
}
