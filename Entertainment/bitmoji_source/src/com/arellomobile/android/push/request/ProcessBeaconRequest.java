// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class ProcessBeaconRequest extends PushRequest
{

    public static final String CAME = "came";
    public static final String CAME_OUT = "cameout";
    public static final String INDOOR = "indoor";
    private String mAction;
    private String mMajor;
    private String mMinor;
    private String mProximityUuid;

    public ProcessBeaconRequest(String s, String s1, String s2, String s3)
    {
        mProximityUuid = s;
        mMajor = s1;
        mMinor = s2;
        mAction = s3;
    }

    protected void buildParams(Context context, Map map)
        throws JSONException
    {
        map.put("uuid", mProximityUuid.toUpperCase());
        map.put("major_number", mMajor);
        map.put("minor_number", mMinor);
        map.put("action", mAction);
    }

    public String getMethod()
    {
        return "processBeacon";
    }
}
