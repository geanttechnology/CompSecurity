// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.Comparator;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            FwLog

static final class gInfo
    implements Comparator
{

    public int compare(gInfo ginfo, gInfo ginfo1)
    {
        ginfo = (new StringBuilder()).append(ginfo.tag).append(9 - ginfo.priority).toString();
        ginfo1 = (new StringBuilder()).append(ginfo1.tag).append(9 - ginfo1.priority).toString();
        int i = ginfo.compareToIgnoreCase(ginfo1);
        if (i != 0)
        {
            return i;
        } else
        {
            return ginfo.compareTo(ginfo1);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((gInfo)obj, (gInfo)obj1);
    }

    gInfo()
    {
    }
}
