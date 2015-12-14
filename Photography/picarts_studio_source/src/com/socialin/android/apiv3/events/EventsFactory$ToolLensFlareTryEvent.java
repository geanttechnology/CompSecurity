// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, String s1, int i, int j, int k, String s2, int l, 
            int i1, int j1)
    {
        super("tool_lens_flare_try");
        addParam(EventParam.UID, s);
        addParam(EventParam.ACTION, s1);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(k));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(j));
        addParam(EventParam.LENS_NAME, s2);
        addParam(EventParam.OPACITY_VALUE, Integer.valueOf(l));
        addParam(EventParam.HUE_VALUE, Integer.valueOf(i1));
        addParam(EventParam.SESSION_ID, Integer.valueOf(j1));
    }
}
