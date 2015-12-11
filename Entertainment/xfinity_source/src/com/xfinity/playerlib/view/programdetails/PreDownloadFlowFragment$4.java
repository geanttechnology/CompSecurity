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

    public int compare(com.comcast.cim.cmasl.hls.dioProfile dioprofile, com.comcast.cim.cmasl.hls.dioProfile dioprofile1)
    {
        if (!dioprofile.getLanguage().equals("eng") || dioprofile1.getLanguage().equals("eng"))
        {
            if (dioprofile1.getLanguage().equals("eng") && !dioprofile.getLanguage().equals("eng"))
            {
                return 1;
            }
            if (!dioprofile.getLanguage().equals("spa") || dioprofile1.getLanguage().equals("spa"))
            {
                if (dioprofile1.getLanguage().equals("spa") && !dioprofile.getLanguage().equals("spa"))
                {
                    return 1;
                } else
                {
                    return dioprofile.getLanguage().compareTo(dioprofile1.getLanguage());
                }
            }
        }
        return -1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((com.comcast.cim.cmasl.hls.dioProfile)obj, (com.comcast.cim.cmasl.hls.dioProfile)obj1);
    }

    I()
    {
    }
}
