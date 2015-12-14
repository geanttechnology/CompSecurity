// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONObject;

public class addParam extends addParam
{

    public addParam setExtras(JSONObject jsonobject)
    {
        addParam(EventParam.EXTRAS, jsonobject);
        return this;
    }

    public (String s, String s1)
    {
        super("tag_favorite");
        addParam(EventParam.SOURCE, s);
        addParam(EventParam.TAG_NAME, s1);
    }
}
