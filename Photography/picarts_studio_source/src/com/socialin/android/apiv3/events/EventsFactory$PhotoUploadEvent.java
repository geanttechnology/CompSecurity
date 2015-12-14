// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import android.text.TextUtils;
import com.picsart.studio.EditingData;
import com.socialin.android.constants.EventParam;
import org.json.JSONArray;

public class addParam extends addParam
{

    public (EditingData editingdata, long l, String s, String s1, JSONArray jsonarray, int i, 
            int j, int k, String s2, String s3, double d, double d1)
    {
        super("photo_upload");
        addParam(EventParam.PHOTO_ID, Long.valueOf(l));
        addParam(EventParam.HASH, s);
        addParam(EventParam.UID, editingdata.a);
        addParam(EventParam.TITLE, s1);
        addParam(EventParam.TAGS, jsonarray);
        addParam(EventParam.UPLOAD_DURATION, Integer.valueOf(k));
        addParam(EventParam.HEIGHT, Integer.valueOf(i));
        addParam(EventParam.WIDTH, Integer.valueOf(j));
        addParam(EventParam.LATITUDE, Double.valueOf(d));
        addParam(EventParam.LONGITUDE, Double.valueOf(d1));
        addParam(EventParam.EFFECTS_APPLIED, Integer.valueOf(editingdata.k));
        addParam(EventParam.LAYERS_USED, Integer.valueOf(editingdata.g));
        addParam(EventParam.PHOTOS_ADDED, Integer.valueOf(editingdata.j));
        addParam(EventParam.FORMAT, s3);
        s1 = EventParam.ORIGIN;
        if (!TextUtils.isEmpty(editingdata.b))
        {
            s = editingdata.b.toLowerCase();
        } else
        {
            s = editingdata.b;
        }
        addParam(s1, s);
        addParam(EventParam.DESTINATION, s2);
        addParam(EventParam.TOTAL_EDITOR_ACTIONS, editingdata.a());
        addParam(EventParam.TOOLS_USED, editingdata.b());
        addParam(EventParam.TOTAL_DRAW_TIME, Integer.valueOf(editingdata.e));
        addParam(EventParam.TOTAL_EDITOR_TIME, Integer.valueOf(editingdata.i));
        addParam(EventParam.TOTAL_DRAW_ACTIONS, Integer.valueOf(editingdata.f));
        addParam(EventParam.TOTAL_EFFECTS_ACTIONS, Integer.valueOf(editingdata.d));
        addParam(EventParam.TOTAL_EFFECTS_TIME, Integer.valueOf(editingdata.c));
        addParam(EventParam.BRUSHES_USED, Integer.valueOf(editingdata.h));
        addParam(EventParam.EFFECTS_TRIED, Integer.valueOf(editingdata.l));
    }
}
