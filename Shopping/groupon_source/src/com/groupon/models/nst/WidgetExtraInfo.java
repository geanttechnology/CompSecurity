// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class WidgetExtraInfo extends JsonEncodedNSTField
{

    private String campaign;
    private String depth;
    private String requestID;
    private String widgetTreatment;

    public WidgetExtraInfo(String s, String s1, String s2)
    {
        this(s, s1, s2, null);
    }

    public WidgetExtraInfo(String s, String s1, String s2, String s3)
    {
        requestID = s;
        widgetTreatment = s1;
        campaign = s2;
        depth = s3;
    }
}
