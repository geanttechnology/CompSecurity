// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

public class aex
{

    public static android.hardware.Camera.Size a(List list, int i, int j)
    {
        double d4;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        d4 = (double)i / (double)j;
        if (list != null) goto _L2; else goto _L1
_L1:
        return ((android.hardware.Camera.Size) (obj1));
_L2:
        double d = 1.7976931348623157E+308D;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            obj1 = (android.hardware.Camera.Size)iterator.next();
            if (Math.abs((double)((android.hardware.Camera.Size) (obj1)).width / (double)((android.hardware.Camera.Size) (obj1)).height - d4) <= 0.050000000000000003D && (double)Math.abs(((android.hardware.Camera.Size) (obj1)).height - j) < d)
            {
                d = Math.abs(((android.hardware.Camera.Size) (obj1)).height - j);
                obj = obj1;
            }
        } while (true);
        obj1 = obj;
        if (obj != null)
        {
            continue;
        }
        iterator = list.iterator();
        double d2 = 1.7976931348623157E+308D;
        double d1 = d;
        d = d2;
        do
        {
            obj1 = obj;
            if (!iterator.hasNext())
            {
                continue;
            }
            list = (android.hardware.Camera.Size)iterator.next();
            double d3 = (double)((android.hardware.Camera.Size) (list)).width / (double)((android.hardware.Camera.Size) (list)).height;
            if (Math.abs(d3 - d4) <= d && d3 > 1.0D)
            {
                if ((double)Math.abs(((android.hardware.Camera.Size) (list)).height - j) < d1)
                {
                    d = Math.abs(d3 - d4);
                    d1 = Math.abs(((android.hardware.Camera.Size) (list)).height - j);
                } else
                {
                    list = ((List) (obj));
                }
                obj = list;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
