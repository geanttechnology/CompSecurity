// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class co
    implements cp
{

    co()
    {
    }

    public final boolean a(ConnectivityManager connectivitymanager)
    {
        connectivitymanager = connectivitymanager.getActiveNetworkInfo();
        if (connectivitymanager != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        switch (connectivitymanager.getType())
        {
        default:
            return true;

        case 1: // '\001'
            return false;

        case 0: // '\0'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
