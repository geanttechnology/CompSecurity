// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.streaming;


// Referenced classes of package com.comscore.streaming:
//            g, StreamSenseState, StreamSense

class d extends g
{

    final StreamSenseState a;
    final StreamSense b;

    d(StreamSense streamsense, StreamSenseState streamsensestate)
    {
        b = streamsense;
        a = streamsensestate;
        super(streamsense, null);
    }

    public StreamSenseState getNextState()
    {
        return a;
    }
}
