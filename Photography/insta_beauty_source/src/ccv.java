// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import java.util.Comparator;

class ccv
    implements Comparator
{

    final ccu a;

    ccv(ccu ccu)
    {
        a = ccu;
        super();
    }

    public int a(PointF pointf, PointF pointf1)
    {
        if (pointf.x < pointf1.x)
        {
            return -1;
        }
        return pointf.x <= pointf1.x ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((PointF)obj, (PointF)obj1);
    }
}
