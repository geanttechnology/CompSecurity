// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class GoogleSmartLockExtraInfo extends JsonEncodedNSTField
{

    protected String pageId;
    protected String trigger;

    public GoogleSmartLockExtraInfo(String s)
    {
        trigger = s;
    }

    public GoogleSmartLockExtraInfo(String s, String s1)
    {
        this(s1);
        pageId = s;
    }
}
