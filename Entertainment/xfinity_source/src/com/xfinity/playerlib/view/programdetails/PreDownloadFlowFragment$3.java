// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import java.util.Comparator;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

static final class I
    implements Comparator
{

    public int compare(com.comcast.cim.cmasl.hls.ofile ofile, com.comcast.cim.cmasl.hls.ofile ofile1)
    {
        if (ofile.getBandwidth() < ofile1.getBandwidth())
        {
            return -1;
        }
        return ofile.getBandwidth() != ofile1.getBandwidth() ? 1 : 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((com.comcast.cim.cmasl.hls.ofile)obj, (com.comcast.cim.cmasl.hls.ofile)obj1);
    }

    I()
    {
    }
}
