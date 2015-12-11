// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.utils;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.device.crashmanager.utils:
//            CrashDescriptorStorageUtil

public class NullCrashDescriptorStorageUtil
    implements CrashDescriptorStorageUtil
{

    public NullCrashDescriptorStorageUtil()
    {
    }

    public void clearAll()
    {
    }

    public boolean contains(String s)
    {
        return false;
    }

    public Integer getCount(String s)
    {
        return Integer.valueOf(0);
    }

    public List getDescriptors()
    {
        return Collections.emptyList();
    }

    public void persistCrashDescriptors()
    {
    }

    public Integer prune(String s)
    {
        return new Integer(0);
    }

    public void push(String s)
    {
    }

    public Boolean shouldDedupe(String s)
    {
        return new Boolean(false);
    }
}
