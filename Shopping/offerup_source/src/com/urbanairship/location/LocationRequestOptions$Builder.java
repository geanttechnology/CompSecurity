// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.urbanairship.location:
//            LocationRequestOptions

public class priority
{

    private float minDistance;
    private long minTime;
    private int priority;

    public LocationRequestOptions create()
    {
        return new LocationRequestOptions(this, null);
    }

    public priority setMinDistance(float f)
    {
        LocationRequestOptions.access$500(f);
        minDistance = f;
        return this;
    }

    public minDistance setMinTime(long l, TimeUnit timeunit)
    {
        LocationRequestOptions.access$400(timeunit.toMillis(l));
        minTime = timeunit.toMillis(l);
        return this;
    }

    public minTime setPriority(int i)
    {
        LocationRequestOptions.access$600(i);
        priority = i;
        return this;
    }




    public ()
    {
        minTime = 0x493e0L;
        minDistance = 800F;
        priority = 2;
    }
}
