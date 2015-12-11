// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.app.Activity;
import android.location.LocationManager;
import android.support.v7.du;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            h, g, f

public class e
{

    public static f a(Activity activity, du du, boolean flag)
    {
        if (flag)
        {
            return new h(activity, du);
        } else
        {
            return new g(activity, du, (LocationManager)activity.getSystemService("location"));
        }
    }
}
