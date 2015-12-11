// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package com.mopub.mobileads:
//            VastTracker

public class VastFractionalProgressTracker extends VastTracker
    implements Comparable, Serializable
{

    private static final long serialVersionUID = 0L;
    private final float mFraction;

    public VastFractionalProgressTracker(String s, float f)
    {
        super(s);
        boolean flag;
        if (f >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mFraction = f;
    }

    public int compareTo(VastFractionalProgressTracker vastfractionalprogresstracker)
    {
        float f = vastfractionalprogresstracker.trackingFraction();
        return Double.compare(trackingFraction(), f);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((VastFractionalProgressTracker)obj);
    }

    public String toString()
    {
        return String.format(Locale.US, "%2f: %s", new Object[] {
            Float.valueOf(mFraction), mTrackingUrl
        });
    }

    public float trackingFraction()
    {
        return mFraction;
    }
}
