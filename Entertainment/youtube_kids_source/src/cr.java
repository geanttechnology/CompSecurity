// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class cr
    implements cp
{

    cr()
    {
    }

    public final boolean a(ConnectivityManager connectivitymanager)
    {
        connectivitymanager = connectivitymanager.getActiveNetworkInfo();
        if (connectivitymanager == null) goto _L2; else goto _L1
_L1:
        connectivitymanager.getType();
        JVM INSTR tableswitch 0 9: default 68
    //                   0 68
    //                   1 70
    //                   2 68
    //                   3 68
    //                   4 68
    //                   5 68
    //                   6 68
    //                   7 70
    //                   8 68
    //                   9 70;
           goto _L2 _L2 _L3 _L2 _L2 _L2 _L2 _L2 _L3 _L2 _L3
_L2:
        return true;
_L3:
        return false;
    }
}
