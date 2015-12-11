// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ii
{

    private Context a;

    public ii(Context context)
    {
        a = context;
    }

    public boolean a()
    {
        ConnectivityManager connectivitymanager;
        boolean flag;
        boolean flag1;
        flag1 = false;
        connectivitymanager = (ConnectivityManager)a.getSystemService("connectivity");
        flag = flag1;
        if (connectivitymanager == null) goto _L2; else goto _L1
_L1:
        NetworkInfo anetworkinfo[];
        anetworkinfo = connectivitymanager.getAllNetworkInfo();
        flag = flag1;
        if (anetworkinfo == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        flag = flag1;
        if (i >= anetworkinfo.length) goto _L2; else goto _L4
_L4:
        if (anetworkinfo[i].getState() != android.net.NetworkInfo.State.CONNECTED) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
