// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;

// Referenced classes of package com.medialets.thrift:
//            Run

private static final class countMon
    implements Serializable
{

    public boolean abEnd;
    public boolean countDay;
    public boolean countHr;
    public boolean countMon;
    public boolean dur;
    public boolean first;
    public boolean firstDay;
    public boolean firstHr;
    public boolean firstMon;
    public boolean interval;

    ()
    {
        this((byte)0);
    }

    private <init>(byte byte0)
    {
        interval = false;
        dur = false;
        abEnd = false;
        first = false;
        firstHr = false;
        firstDay = false;
        firstMon = false;
        countHr = false;
        countDay = false;
        countMon = false;
    }
}
