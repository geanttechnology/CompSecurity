// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.view.VelocityTracker;

// Referenced classes of package com.j.a.b:
//            o, f, e

public class i
{

    static final e a;

    public static float a(VelocityTracker velocitytracker, int j)
    {
        return a.a(velocitytracker, j);
    }

    public static float b(VelocityTracker velocitytracker, int j)
    {
        return a.b(velocitytracker, j);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new o();
        } else
        {
            a = new f();
        }
    }
}
