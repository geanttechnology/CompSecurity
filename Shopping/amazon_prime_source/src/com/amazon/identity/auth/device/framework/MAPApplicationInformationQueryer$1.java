// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import java.util.Comparator;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            MAPApplicationInformationQueryer, RemoteMapInfo

static final class 
    implements Comparator
{

    public int compare(RemoteMapInfo remotemapinfo, RemoteMapInfo remotemapinfo1)
    {
        return RemoteMapInfo.compare(remotemapinfo, remotemapinfo1) * -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((RemoteMapInfo)obj, (RemoteMapInfo)obj1);
    }

    ()
    {
    }
}
