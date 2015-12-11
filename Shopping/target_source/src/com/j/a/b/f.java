// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.view.VelocityTracker;

// Referenced classes of package com.j.a.b:
//            e

class f
    implements e
{

    f()
    {
    }

    public float a(VelocityTracker velocitytracker, int i)
    {
        return velocitytracker.getXVelocity();
    }

    public float b(VelocityTracker velocitytracker, int i)
    {
        return velocitytracker.getYVelocity();
    }
}
