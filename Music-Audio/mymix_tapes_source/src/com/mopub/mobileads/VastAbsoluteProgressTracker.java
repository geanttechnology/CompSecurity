// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package com.mopub.mobileads:
//            VastTracker

public class VastAbsoluteProgressTracker extends VastTracker
    implements Comparable, Serializable
{

    private static final long serialVersionUID = 0L;
    private final int mTrackingMilliseconds;

    public VastAbsoluteProgressTracker(String s, int i)
    {
        super(s);
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mTrackingMilliseconds = i;
    }

    public int compareTo(VastAbsoluteProgressTracker vastabsoluteprogresstracker)
    {
        int i = vastabsoluteprogresstracker.getTrackingMilliseconds();
        return getTrackingMilliseconds() - i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VastAbsoluteProgressTracker)obj);
    }

    public int getTrackingMilliseconds()
    {
        return mTrackingMilliseconds;
    }

    public String toString()
    {
        return String.format(Locale.US, "%dms: %s", new Object[] {
            Integer.valueOf(mTrackingMilliseconds), mTrackingUrl
        });
    }
}
