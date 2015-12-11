// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.Iterator;
import java.util.List;

public class CameraUtils
{

    public CameraUtils()
    {
    }

    public static android.hardware.Camera.Size getBestMatchedSize(List list, int i, int j, boolean flag)
    {
        double d2 = (double)i / (double)j;
        if (list != null && list.size() != 0) goto _L2; else goto _L1
_L1:
        android.hardware.Camera.Size size1 = null;
_L4:
        return size1;
_L2:
        android.hardware.Camera.Size size = null;
        double d = 1.7976931348623157E+308D;
        double d1 = 0.10000000000000001D;
        do
        {
            size1 = size;
            if (size != null)
            {
                continue;
            }
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                android.hardware.Camera.Size size2 = (android.hardware.Camera.Size)iterator.next();
                if (Math.abs((double)size2.width / (double)size2.height - d2) <= d1)
                {
                    if (flag)
                    {
                        if ((double)(size2.height - j) < d && size2.height - j > 0)
                        {
                            size = size2;
                            d = Math.abs(size2.height - j);
                        }
                    } else
                    if ((double)Math.abs(size2.height - j) < d)
                    {
                        size = size2;
                        d = Math.abs(size2.height - j);
                    }
                }
            } while (true);
            d1 += 0.10000000000000001D;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
