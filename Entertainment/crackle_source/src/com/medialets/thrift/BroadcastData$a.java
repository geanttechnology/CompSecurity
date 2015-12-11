// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;

// Referenced classes of package com.medialets.thrift:
//            BroadcastData

private static final class verticalAccuracy
    implements Serializable
{

    public boolean alt;
    public boolean horizontalAccuracy;
    public boolean lat;
    public boolean locSrvOn;
    public boolean locTrOn;
    public boolean lon;
    public boolean verticalAccuracy;

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        locTrOn = false;
        locSrvOn = false;
        lat = false;
        lon = false;
        alt = false;
        horizontalAccuracy = false;
        verticalAccuracy = false;
    }
}
