// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.res.Configuration;
import android.content.res.Resources;

// Referenced classes of package com.google.android.gms.d:
//            io

public final class ik
{

    public static boolean a(Resources resources)
    {
        if (resources != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        if ((resources.getConfiguration().screenLayout & 0xf) > 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (io.a(11) && flag)
        {
            break; /* Loop/switch isn't completed */
        }
        resources = resources.getConfiguration();
        if (io.a(13))
        {
            if ((((Configuration) (resources)).screenLayout & 0xf) <= 3 && ((Configuration) (resources)).smallestScreenWidthDp >= 600)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (!flag) goto _L1; else goto _L3
_L3:
        return true;
    }
}
