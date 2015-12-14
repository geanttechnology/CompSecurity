// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseTestUtils, PushConnection

static class toState
{

    public final PushConnection connection;
    public final toState fromState;
    public final long timestamp;
    public final toState toState;

    public String toString()
    {
        return (new StringBuilder()).append(timestamp).append(" ms: ").append(fromState).append(" to ").append(toState).toString();
    }

    (long l, PushConnection pushconnection,  ,  1)
    {
        timestamp = l;
        connection = pushconnection;
        fromState = ;
        toState = 1;
    }
}
