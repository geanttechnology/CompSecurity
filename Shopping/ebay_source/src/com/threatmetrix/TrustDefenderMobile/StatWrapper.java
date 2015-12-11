// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.os.StatFs;
import java.lang.reflect.Method;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            WrapperHelper

class StatWrapper extends WrapperHelper
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/StatWrapper.getName();
    private static final Method m_getAvailableBlocks = getMethod(android/os/StatFs, "getAvailableBlocks", new Class[0]);
    private static final Method m_getAvailableBlocksLong = getMethod(android/os/StatFs, "getAvailableBlocksLong", new Class[0]);
    private static final Method m_getBlockCount = getMethod(android/os/StatFs, "getBlockCount", new Class[0]);
    private static final Method m_getBlockCountLong = getMethod(android/os/StatFs, "getBlockCountLong", new Class[0]);
    private static final Method m_getBlockSize = getMethod(android/os/StatFs, "getBlockSize", new Class[0]);
    private static final Method m_getBlockSizeLong = getMethod(android/os/StatFs, "getBlockSizeLong", new Class[0]);
    private final StatFs m_stat;

    public StatWrapper(String s)
    {
        m_stat = new StatFs(s);
    }

    public long getAvailableBlocks()
    {
        if (m_getAvailableBlocksLong != null)
        {
            Long long1 = (Long)invoke(m_stat, m_getAvailableBlocksLong, new Object[0]);
            if (long1 != null)
            {
                return long1.longValue();
            }
        }
        if (m_getAvailableBlocks != null)
        {
            Integer integer = (Integer)invoke(m_stat, m_getAvailableBlocks, new Object[0]);
            if (integer != null)
            {
                return (long)integer.intValue();
            }
        }
        return 0L;
    }

    public long getBlockCount()
    {
        if (m_getBlockCountLong != null)
        {
            Long long1 = (Long)invoke(m_stat, m_getBlockCountLong, new Object[0]);
            if (long1 != null)
            {
                return long1.longValue();
            }
        }
        if (m_getBlockCount != null)
        {
            Integer integer = (Integer)invoke(m_stat, m_getBlockCount, new Object[0]);
            if (integer != null)
            {
                return (long)integer.intValue();
            }
        }
        return 0L;
    }

    public long getBlockSize()
    {
        if (m_getBlockSizeLong != null)
        {
            Long long1 = (Long)invoke(m_stat, m_getBlockSizeLong, new Object[0]);
            if (long1 != null)
            {
                return long1.longValue();
            }
        }
        if (m_getBlockSize != null)
        {
            Integer integer = (Integer)invoke(m_stat, m_getBlockSize, new Object[0]);
            if (integer != null)
            {
                return (long)integer.intValue();
            }
        }
        return 0L;
    }

}
