// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;

import com.comcast.cim.cmasl.analytics.EventData;

public class XfinityEventData extends EventData
{

    public XfinityEventData(String s)
    {
        addData("ev", s);
    }
}
