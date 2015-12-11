// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class RootProvider
    implements i
{

    public RootProvider()
    {
    }

    public void a(Context context, j j1)
    {
        try
        {
            System.loadLibrary("deviceprint");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            j1.a("RTCLK", "1");
            return;
        }
        try
        {
            j1.a("ROOT", getRootStatus());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public native String getRootStatus();
}
