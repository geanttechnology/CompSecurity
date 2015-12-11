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
    long a;

    public EndpointWarp(Context context, byte abyte0[], int i)
    {
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        if (((b + e) * b) % d != b())
        {
            b = a();
            c = a();
        }
        a = createWarp(context, abyte0, i);
    }

    public static int a()
    {
        return 29;
    }

    public static int b()
    {
        return 0;
    }

    private native long createWarp(Context context, byte abyte0[], int i);

    private native void disposeWarp(long l);

    public static boolean f()
    {
        System.loadLibrary("ImmEndpointWarpJ");
        return true;
_L2:
        UnsatisfiedLinkError unsatisfiedlinkerror;
        Log.e("EndpointWarp", "Unable to load libImmEndpointWarpJ.so.Please make sure this file is in the libs/armeabi folder.");
        if (((a() + e) * a()) % d != c)
        {
            b = a();
            c = a();
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

    private native void startWarp(long l);

    private native void stopWarp(long l);

    private native void updateWarp(long l, byte abyte0[], int i, long l1, long l2);

    public void a(byte abyte0[], int i, long l, long l1)
    {
        try
        {
            updateWarp(a, abyte0, i, l, l1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        if (((b + e) * b) % d != c)
        {
            b = a();
            c = a();
        }
    }

    public void c()
    {
        int i;
        long l;
        try
        {
            l = a;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        i = b;
        switch ((i * (e + i)) % d)
        {
        default:
            b = 27;
            c = a();
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            startWarp(l);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    public void d()
    {
        long l = a;
        if (((a() + e) * a()) % d != c)
        {
            b = 12;
            c = a();
        }
        stopWarp(l);
    }

    public void e()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
}
