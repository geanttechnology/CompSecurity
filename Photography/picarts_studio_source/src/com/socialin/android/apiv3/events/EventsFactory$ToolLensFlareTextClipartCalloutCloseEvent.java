// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONArray;

public class addParam extends addParam
{

    public (String s, String s1, int i, int j, int k, JSONArray jsonarray, int l, 
            int i1, int j1, int k1)
    {
        super("tool_lens_flare_text_clipart_callout_close");
        addParam(EventParam.UID, s);
        addParam(EventParam.METHOD, s1);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(k));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(j));
        addParam(EventParam.LENS_NAMES, jsonarray);
        addParam(EventParam.TEXTS_COUNT, Integer.valueOf(l));
        addParam(EventParam.CLIPART_COUNT, Integer.valueOf(i1));
        addParam(EventParam.CALLOUT_COUNT, Integer.valueOf(j1));
        addParam(EventParam.SESSION_ID, Integer.valueOf(k1));
    }
}
