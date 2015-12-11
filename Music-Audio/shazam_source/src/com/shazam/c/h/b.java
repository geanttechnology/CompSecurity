// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.h;

import com.shazam.b.a.a;
import com.shazam.server.response.lyricplay.Line;

public final class b
    implements a
{

    public b()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Line)obj;
        com.shazam.model.lyrics.Line.Builder builder = com.shazam.model.lyrics.Line.Builder.a();
        builder.offset = ((Line) (obj)).o;
        builder.lenght = ((Line) (obj)).l;
        builder.text = ((Line) (obj)).e;
        return new com.shazam.model.lyrics.Line(builder, null);
    }
}
