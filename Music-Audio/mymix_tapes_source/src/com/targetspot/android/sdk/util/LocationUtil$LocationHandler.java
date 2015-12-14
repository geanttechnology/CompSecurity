// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.location.Location;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.targetspot.android.sdk.util:
//            LocationUtil

public static class  extends Handler
{

    public static final int ERR = -1;
    public static final int OK = 0;
    public static final int OK_LOCATION = 1;
    private Location location;

    public Location getLocation()
    {
        if (location != null)
        {
            return new Location(location);
        } else
        {
            return null;
        }
    }

    public void handleError(Message message)
    {
    }

    public void handleLocation(Location location1)
    {
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case -1: 
            handleError(message);
            return;

        case 0: // '\0'
            handleOk(message);
            return;

        case 1: // '\001'
            break;
        }
        if (message.obj instanceof Location)
        {
            location = (Location)message.obj;
        }
        if (location != null)
        {
            message = new Location(location);
        } else
        {
            message = null;
        }
        handleLocation(message);
    }

    public void handleOk(Message message)
    {
    }

    public ()
    {
    }
}
