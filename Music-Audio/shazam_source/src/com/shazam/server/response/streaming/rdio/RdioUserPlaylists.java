// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.rdio;

import java.util.List;

public class RdioUserPlaylists
{

    public static final RdioUserPlaylists EMPTY = new RdioUserPlaylists(null, null);
    public final List collaborative;
    public final List owned;

    private RdioUserPlaylists(List list, List list1)
    {
        collaborative = list;
        owned = list1;
    }

}
