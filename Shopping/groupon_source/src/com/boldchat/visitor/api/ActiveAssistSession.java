// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RequestUtil;
import com.boldchat.visitor.api.json.JSONObject;
import java.util.Date;

// Referenced classes of package com.boldchat.visitor.api:
//            ActiveAssistType

public class ActiveAssistSession
{

    private Long activeAssistID;
    private ActiveAssistType activeAssistType;
    private Date ended;
    private String pinCode;
    private Date started;

    protected ActiveAssistSession(JSONObject jsonobject)
    {
        updateValues(jsonobject);
    }

    public Long getActiveAssistID()
    {
        return activeAssistID;
    }

    protected void updateValues(JSONObject jsonobject)
    {
        String s = jsonobject.optString("ActiveAssistID", null);
        String s1 = jsonobject.optString("ActiveAssistType", null);
        String s2 = jsonobject.optString("PinCode", null);
        String s3 = jsonobject.optString("Started", null);
        jsonobject = jsonobject.optString("Ended", null);
        if (s != null)
        {
            activeAssistID = Long.valueOf(s);
        }
        if (s1 != null)
        {
            activeAssistType = ActiveAssistType.getActiveAssistType(s1);
        }
        if (s2 != null)
        {
            pinCode = s2;
        }
        if (s3 != null)
        {
            started = RequestUtil.getDateFromISO8601(s3);
        }
        if (jsonobject != null)
        {
            ended = RequestUtil.getDateFromISO8601(jsonobject);
        }
    }
}
