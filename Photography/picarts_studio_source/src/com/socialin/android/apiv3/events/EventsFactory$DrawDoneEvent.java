// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONObject;

public class addParam extends addParam
{

    public (String s, String s1, JSONObject jsonobject, JSONObject jsonobject1, String s2, long l)
    {
        super("draw_done");
        addParam(EventParam.UID, s);
        addParam(EventParam.DRAW_SESSION_ID, s1);
        addParam(EventParam.TIME_PER_BRUSH, jsonobject);
        addParam(EventParam.TIME_PER_ERASER, jsonobject1);
        addParam(EventParam.EXIT_ACTION, s2);
        addParam(EventParam.DRAW_SESSION_LENGTH, Long.valueOf(l));
    }
}
