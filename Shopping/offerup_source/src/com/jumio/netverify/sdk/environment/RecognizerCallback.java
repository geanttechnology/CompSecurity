// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.environment;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import jumiomobile.ab;
import jumiomobile.hx;
import jumiomobile.hy;

// Referenced classes of package com.jumio.netverify.sdk.environment:
//            NativePoint

public class RecognizerCallback
{

    private static ArrayList mListeners = new ArrayList();

    public RecognizerCallback()
    {
    }

    private static void _onObjectDetected(NativePoint anativepoint[], int i, int j, hx hx1)
    {
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorenter ;
        if (!isSuccess(hx1) || anativepoint == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (anativepoint.length <= 0)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        hx1 = mListeners.iterator();
_L1:
        hy hy1;
        if (!hx1.hasNext())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        hy1 = (hy)hx1.next();
        hy1.a(convert(anativepoint), i, j);
          goto _L1
        Exception exception;
        exception;
        ab.a(exception);
          goto _L1
        anativepoint;
        throw anativepoint;
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorexit ;
    }

    public static boolean addListener(hy hy1)
    {
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorenter ;
        if (mListeners.contains(hy1)) goto _L2; else goto _L1
_L1:
        mListeners.add(hy1);
        boolean flag = true;
_L4:
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        hy1;
        throw hy1;
    }

    private static Point[] convert(NativePoint anativepoint[])
    {
        Point apoint[] = new Point[anativepoint.length];
        for (int i = 0; i < anativepoint.length; i++)
        {
            apoint[i] = new Point(anativepoint[i].x, anativepoint[i].y);
        }

        return apoint;
    }

    private static boolean isSuccess(hx hx1)
    {
        return hx1 != null && (hx1.equals(hx.a) || hx1.equals(hx.d));
    }

    public static void onObjectDetected(NativePoint anativepoint[], int i, int j, int k)
    {
        _onObjectDetected(anativepoint, i, j, hx.a(k));
    }

    public static void releaseListeners()
    {
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorenter ;
        mListeners.clear();
        com/jumio/netverify/sdk/environment/RecognizerCallback;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
