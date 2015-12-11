// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.List;

public class u extends t
{

    public List playlists;

    public String toString()
    {
        return (new StringBuilder()).append("PlaylistsResponse [mResponse=").append(a).append(", playlists=").append(playlists).append("]").toString();
    }
}
