// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONObject;

public class addParam extends addParam
{

    public I(JSONObject jsonobject, String s)
    {
        super("card_click_title");
        addParam(EventParam.CARD_JSON, jsonobject);
        addParam(EventParam.SECTION, s);
    }
}
