// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.VelocityTracker;

public class VelocityTrackerCompat
{

    static final VelocityTrackerVersionImpl IMPL;

    public VelocityTrackerCompat()
    {
    }

    public static float getXVelocity(VelocityTracker velocitytracker, int i)
    {
        return IMPL.getXVelocity(velocitytracker, i);
    }

    public static float getYVelocity(VelocityTracker velocitytracker, int i)
    {
        return IMPL.getYVelocity(velocitytracker, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else
        {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }

    /* member class not found */
    class VelocityTrackerVersionImpl {}


    /* member class not found */
    class HoneycombVelocityTrackerVersionImpl {}


    /* member class not found */
    class BaseVelocityTrackerVersionImpl {}

}
