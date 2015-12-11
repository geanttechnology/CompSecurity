// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kahuna.sdk.m;

public class ahi
{

    protected static boolean a(Context context)
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (i == 0)
        {
            if (m.s())
            {
                Log.d("Kahuna", "Google Play services is available. yay!");
            }
            return true;
        }
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Google Play services is NOT available. Code: ").append(i).toString());
        }
        return false;
    }

    protected static boolean a(Context context, String s)
    {
        boolean flag;
        if (context.checkCallingOrSelfPermission(s) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (m.s())
            {
                Log.d("Kahuna", (new StringBuilder()).append(s).append(" permission available.").toString());
            }
        } else
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Permission ").append(s).append(" NOT available").toString());
            return flag;
        }
        return flag;
    }
}
