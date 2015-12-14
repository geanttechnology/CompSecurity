// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.pipcamera.application.PIPCameraApplication;

public class ly
{

    public static int a(int i)
    {
        char c;
        boolean flag;
        char c1;
        char c2;
        char c3;
        c1 = '\u03C0';
        c2 = '\u0244';
        c3 = '\u0190';
        c = '\u0280';
        if (!PIPCameraApplication.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i;
        JVM INSTR tableswitch 1 9: default 76
    //                   1 87
    //                   2 97
    //                   3 107
    //                   4 119
    //                   5 131
    //                   6 144
    //                   7 157
    //                   8 173
    //                   9 185;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        i = 640;
_L12:
        return i;
_L2:
        i = c1;
        if (!flag) goto _L12; else goto _L11
_L11:
        return 1280;
_L3:
        i = c1;
        if (flag) goto _L12; else goto _L13
_L13:
        return 640;
_L4:
        return !flag ? 580 : 800;
_L5:
        return !flag ? 480 : 720;
_L6:
        if (!flag)
        {
            c = '\u0190';
        }
        return c;
_L7:
        if (!flag)
        {
            c = '\u0168';
        }
        return c;
_L8:
        if (flag)
        {
            i = c2;
        } else
        {
            i = 300;
        }
        return i;
_L9:
        return !flag ? 280 : 500;
_L10:
        if (flag)
        {
            i = c3;
        } else
        {
            i = 260;
        }
        return i;
    }
}
