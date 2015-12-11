// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.device.yearclass;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.facebook.device.yearclass:
//            DeviceInfo

static final class 
    implements FileFilter
{

    public boolean accept(File file)
    {
        file = file.getName();
        if (!file.startsWith("cpu")) goto _L2; else goto _L1
_L1:
        int i = 3;
_L5:
        if (i >= file.length())
        {
            break; /* Loop/switch isn't completed */
        }
        if (file.charAt(i) >= '0' && file.charAt(i) <= '9') goto _L3; else goto _L2
_L2:
        return false;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return true;
    }

    ()
    {
    }
}
