// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class UpBackClickExtraInfo extends JsonEncodedNSTField
{

    public static final String APP_BACK_ARROW = "app_back_arrow";
    public static final String SYSTEM_BACK = "system_back";
    protected String backMethod;
    protected String pageId;

    public UpBackClickExtraInfo(String s, String s1)
    {
        pageId = s;
        backMethod = s1;
    }
}
