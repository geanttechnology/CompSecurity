// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.play;

import java.util.List;

public class Stream
{

    public static final Stream EMPTY = new Stream(null, null);
    public final List actions;
    public final String trackId;

    private Stream(String s, List list)
    {
        trackId = s;
        actions = list;
    }

}
