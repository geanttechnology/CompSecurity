// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONArray;

public class addParam extends addParam
{

    public (String s, int i, int j, boolean flag, boolean flag1, long l, 
            boolean flag2, JSONArray jsonarray, String s1)
    {
        super("effect_apply");
        addParam(EventParam.EFFECT_NAME, s);
        addParam(EventParam.WIDTH, Integer.valueOf(i));
        addParam(EventParam.HEIGHT, Integer.valueOf(j));
        addParam(EventParam.DEFAULT_SETTINGS, Boolean.valueOf(flag));
        addParam(EventParam.EXPLICIT_APPLY, Boolean.valueOf(flag1));
        addParam(EventParam.PROCESSING_TIME, Long.valueOf(l));
        addParam(EventParam.APPLY_DURING_TRY, Boolean.valueOf(flag2));
        addParam(EventParam.SETTINGS, jsonarray);
        addParam(EventParam.UID, s1);
    }
}
