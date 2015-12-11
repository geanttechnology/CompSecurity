// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DeviceNotificationSubscriptions extends BaseApiResponse
{
    public static final class Preference
    {

        public com.ebay.common.model.mdns.NotificationPreference.EventType eventType;
        public Map properties;

        public Preference()
        {
            properties = new HashMap();
        }
    }


    public List activePreferences;
    public String description;
    public List inactivePreferences;
    public boolean isActive;
    public String language;

    public DeviceNotificationSubscriptions()
    {
        activePreferences = new LinkedList();
        inactivePreferences = new LinkedList();
    }
}
