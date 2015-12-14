// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import java.util.Comparator;

// Referenced classes of package com.google.android.exoplayer.util:
//            SlidingPercentile

static final class mple
    implements Comparator
{

    public int compare(mple mple, mple mple1)
    {
        return mple.index - mple1.index;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((mple)obj, (mple)obj1);
    }

    mple()
    {
    }
}
