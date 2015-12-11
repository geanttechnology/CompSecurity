// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.h;

import com.shazam.b.a.a;
import com.shazam.model.lyrics.SynchInfo;
import com.shazam.server.response.lyricplay.LyricPlay;
import java.util.List;

public final class c
    implements a
{

    private final a a;
    private final a b;
    private final Long c;

    public c(a a1, a a2, Long long1)
    {
        a = a1;
        b = a2;
        c = long1;
    }

    public final Object a(Object obj)
    {
        obj = (LyricPlay)obj;
        com.shazam.model.lyrics.LyricPlay.Builder builder = com.shazam.model.lyrics.LyricPlay.Builder.a();
        builder.provider = ((LyricPlay) (obj)).provider;
        builder.synchInfo = (SynchInfo)a.a(((LyricPlay) (obj)).synchInfo);
        builder.payload = (List)b.a(((LyricPlay) (obj)).payload);
        builder.tagTime = c.longValue();
        return new com.shazam.model.lyrics.LyricPlay(builder, null);
    }
}
