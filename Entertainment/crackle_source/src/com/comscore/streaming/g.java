// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.streaming;

import java.util.Timer;

// Referenced classes of package com.comscore.streaming:
//            StreamSense, a, StreamSenseState

abstract class g extends Timer
{

    final StreamSense c;

    private g(StreamSense streamsense)
    {
        c = streamsense;
        super();
    }

    g(StreamSense streamsense, a a)
    {
        this(streamsense);
    }

    public abstract StreamSenseState getNextState();
}
