// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DTFGenericMetadata extends JsonEncodedNSTField
{

    public static final String BOOKABLE_TOGGLE = "bookable_toggle";
    public static final String DTF_INPUTS = "dtf_inputs";
    public static final String OFF = "off";
    public static final String ON = "on";
    public static final String PULL = "pull";
    public String DTFValue;
    public String date;
    public Integer partysize;
    public String service;
    public String state;
    public Integer tag;
    public String time;
    public String type;

    public DTFGenericMetadata()
    {
        type = null;
        state = null;
        partysize = null;
        service = null;
        date = null;
        time = null;
        tag = null;
        DTFValue = null;
    }
}
