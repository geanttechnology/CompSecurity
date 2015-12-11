// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.crash;

import com.amazon.device.crashmanager.CrashDetailsCollectable;
import com.amazon.now.location.Location;
import java.util.HashMap;
import java.util.Map;

public class CrashDetailsCollector
    implements CrashDetailsCollectable
{

    public CrashDetailsCollector()
    {
    }

    public Map collect(Throwable throwable)
    {
        throwable = new HashMap();
        throwable.put("SelectedMarketplace", Location.getMarketplace());
        return throwable;
    }
}
