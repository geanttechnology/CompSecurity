// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.h;

import com.shazam.b.a.a;
import com.shazam.server.response.lyricplay.SynchInfo;

public final class d
    implements a
{

    public d()
    {
    }

    public final Object a(Object obj)
    {
        obj = (SynchInfo)obj;
        com.shazam.model.lyrics.SynchInfo.Builder builder = com.shazam.model.lyrics.SynchInfo.Builder.a();
        builder.offset = ((SynchInfo) (obj)).offset;
        builder.timeSkew = ((SynchInfo) (obj)).timeSkew;
        builder.frequencySkew = ((SynchInfo) (obj)).frequencySkew;
        return new com.shazam.model.lyrics.SynchInfo(builder, null);
    }
}
