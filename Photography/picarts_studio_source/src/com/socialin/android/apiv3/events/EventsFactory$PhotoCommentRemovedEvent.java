// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;
import org.json.JSONArray;

public class addParam extends addParam
{

    public (long l, String s, long l1, boolean flag, JSONArray jsonarray)
    {
        super("photo_comment_removed");
        addParam(EventParam.PHOTO_ID, Long.valueOf(l));
        addParam(EventParam.SOURCE, s);
        addParam(EventParam.PHOTO_OWNER_ID, Long.valueOf(l1));
        addParam(EventParam.MATURE, Boolean.valueOf(flag));
        addParam(EventParam.TAGS, jsonarray);
    }
}
