// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.flurry.android.AppCloudResponse;

// Referenced classes of package com.flurry.android.caching:
//            c, b, ObjectOperationData, m

final class l
{

    private b gA;
    private Context mContext;

    public l(Context context)
    {
        mContext = context;
        new c();
        gA = new b();
    }

    public final m i(ObjectOperationData objectoperationdata)
    {
        long l1 = c.h(objectoperationdata);
        Object obj;
        NetworkInfo networkinfo;
        boolean flag;
        if (l1 == -1L)
        {
            Log.i("RetryManager", "timeToStart == OPERATION_DIDNT_PROCCEED_CODE");
        } else
        {
            try
            {
                Thread.sleep(l1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((InterruptedException) (obj)).printStackTrace();
            }
        }
        objectoperationdata.incrementRetryCount();
        obj = (ConnectivityManager)mContext.getSystemService("connectivity");
        networkinfo = ((ConnectivityManager) (obj)).getNetworkInfo(1);
        if (networkinfo != null && networkinfo.isConnected())
        {
            flag = true;
        } else
        {
            NetworkInfo networkinfo1 = ((ConnectivityManager) (obj)).getNetworkInfo(0);
            if (networkinfo1 != null && networkinfo1.isConnected())
            {
                flag = true;
            } else
            {
                obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
                if (obj != null && ((NetworkInfo) (obj)).isConnected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        if (flag)
        {
            obj = gA.a(objectoperationdata);
        } else
        {
            obj = new m((byte)0);
            obj.it = 711;
            obj.iu = new AppCloudResponse(null);
        }
        ((m) (obj)).it;
        JVM INSTR lookupswitch 4: default 120
    //                   701: 128
    //                   711: 228
    //                   721: 228
    //                   731: 128;
           goto _L1 _L2 _L3 _L3 _L2
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        Log.e("RetryManager", "ERROR! UNKNOWN RESPONSE CODE!");
_L5:
        return ((m) (obj));
_L3:
        if (c.h(objectoperationdata) != -1L)
        {
            return i(objectoperationdata);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }
}
