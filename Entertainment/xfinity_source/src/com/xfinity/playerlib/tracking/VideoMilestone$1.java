// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.tracking:
//            VideoMilestone

static final class nit> extends VideoMilestone
{

    public String getEvent()
    {
        VideoMilestone.access$100().warn("getPositionInSeconds() unexpected invocation this={}", this);
        return null;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
