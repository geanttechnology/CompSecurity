// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DMSManagerOptions
{

    private static final String Option_Camera_KB_Json = "DMSManagerCameraKbJson";
    private static final String Option_Disable_Checkin = "DMSManagerDisableStartupCheckin";
    private String mCameraKbJson;
    private boolean mDisableCheckin;

    public DMSManagerOptions()
    {
    }

    public String getCameraKbJson()
    {
        return mCameraKbJson;
    }

    public boolean isCameraKbLocal()
    {
        return mCameraKbJson != null;
    }

    public boolean isDisableCheckin()
    {
        return mDisableCheckin;
    }

    public void parseOptions(Map map)
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = map.get(s);
            if (s.compareTo("DMSManagerDisableStartupCheckin") == 0)
            {
                if (obj.getClass().equals(java/lang/Boolean))
                {
                    mDisableCheckin = ((Boolean)obj).booleanValue();
                }
            } else
            if (s.compareTo("DMSManagerCameraKbJson") == 0 && obj.getClass().equals(java/lang/String))
            {
                mCameraKbJson = (String)obj;
            }
        } while (true);
    }
}
