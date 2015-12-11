// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.content;

import android.content.Context;
import android.util.Log;

public class EndpointWarp
{

    public static int b = 39;
    public static int c = 0;
    public static int d = 2;
    public static int e = 1;
    public long a;

    public EndpointWarp(Context context, byte abyte0[], int i)
    {
        if (((b + e) * b) % d != 0)
        {
            b = 29;
            c = 29;
        }
        a = createWarp(context, abyte0, i);
    }

    public static boolean b()
    {
        System.loadLibrary("ImmEndpointWarpJ");
        return true;
_L2:
        UnsatisfiedLinkError unsatisfiedlinkerror;
        Log.e("EndpointWarp", "Unable to load libImmEndpointWarpJ.so.Please make sure this file is in the libs/armeabi folder.");
        if (((e + 29) * 29) % d != c)
        {
            b = 29;
            c = 29;
        }
        unsatisfiedlinkerror.printStackTrace();
        return false;
        unsatisfiedlinkerror;
        if (System.getProperty("java.vm.name").contains("Java HotSpot"))
        {
            return true;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private native long createWarp(Context context, byte abyte0[], int i);

    private native void stopWarp(long l);

    public final void a()
    {
        long l = a;
        if (((e + 29) * 29) % d != c)
        {
            b = 12;
            c = 29;
        }
        stopWarp(l);
    }

    public native void startWarp(long l);

    public native void updateWarp(long l, byte abyte0[], int i, long l1, long l2);
}
