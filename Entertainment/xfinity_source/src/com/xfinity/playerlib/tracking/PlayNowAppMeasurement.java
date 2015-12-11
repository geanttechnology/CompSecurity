// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import com.comcast.cim.android.PropertyService;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.tracking.CimAppMeasurement;
import com.xfinity.playerlib.PlayerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayNowAppMeasurement extends CimAppMeasurement
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/tracking/PlayNowAppMeasurement);
    private final String applicationName;

    public PlayNowAppMeasurement(PlayerApplication playerapplication, AndroidDevice androiddevice, PropertyService propertyservice, String s)
    {
        super(playerapplication, playerapplication.getVersionNumber(), androiddevice, propertyservice);
        applicationName = s;
    }

    protected void configureAppSpecificFields()
    {
        putCdata("appName", applicationName);
        putCdata("appName", applicationName);
    }

}
