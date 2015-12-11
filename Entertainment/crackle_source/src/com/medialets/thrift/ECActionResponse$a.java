// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;

// Referenced classes of package com.medialets.thrift:
//            ECActionResponse

private static final class dcEnabled
    implements Serializable
{

    public boolean dcEnabled;
    public boolean kill;
    public boolean minBroadcastInterval;
    public boolean shutdown;

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        minBroadcastInterval = false;
        shutdown = false;
        kill = false;
        dcEnabled = false;
    }
}
