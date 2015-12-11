// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.rdio;

import java.util.List;

public class RdioPlaylist
{

    public static final RdioPlaylist EMPTY = new RdioPlaylist(null, null, null, null, 0);
    public final String key;
    public final int length;
    public final String name;
    public final List trackKeys;
    public final String url;

    private RdioPlaylist(String s, String s1, List list, String s2, int i)
    {
        key = s;
        url = s1;
        trackKeys = list;
        name = s2;
        length = i;
    }

}
