// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            Device

public class DeviceList extends Vector
{

    public static final String ELEM_NAME = "deviceList";

    public DeviceList()
    {
    }

    public Device getDevice(int i)
    {
        return (Device)get(i);
    }
}
