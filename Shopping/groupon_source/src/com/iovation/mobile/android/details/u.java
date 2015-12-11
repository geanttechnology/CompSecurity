// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.app.ActivityManager;
import android.content.Context;
import android.os.UserManager;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j

public class u
    implements i
{

    public u()
    {
    }

    public void a(Context context, j j1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17 && ((UserManager)context.getSystemService("user")).isUserAGoat())
        {
            j1.a("AGOAT", "1");
        }
        if (android.os.Build.VERSION.SDK_INT >= 8 && ActivityManager.isUserAMonkey())
        {
            j1.a("AMONK", "1");
        }
    }
}
