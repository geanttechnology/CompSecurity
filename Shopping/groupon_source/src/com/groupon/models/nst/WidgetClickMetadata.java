// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class WidgetClickMetadata extends JsonEncodedNSTField
{

    private String campaign;
    private String dealUUID;
    private int depth;
    private String pageID;
    private String parentDealUUID;
    private String requestID;
    private String widgetTreatment;

    public WidgetClickMetadata(String s, String s1, String s2, String s3, String s4, String s5, int i)
    {
        pageID = s;
        requestID = s1;
        widgetTreatment = s2;
        campaign = s3;
        dealUUID = s4;
        parentDealUUID = s5;
        depth = i;
    }
}
