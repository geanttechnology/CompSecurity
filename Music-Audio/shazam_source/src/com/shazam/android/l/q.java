// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.android.ay.b.d;
import com.shazam.b.a.a;
import java.util.Date;

public final class q
    implements a
{

    public q()
    {
    }

    public final Object a(Object obj)
    {
        obj = (d)obj;
        Date date = new Date(((d) (obj)).a());
        com.shazam.model.Tag.Builder builder = com.shazam.model.Tag.Builder.a();
        builder.requestId = ((d) (obj)).d();
        builder.location = ((d) (obj)).e();
        builder.tagContext = ((d) (obj)).f().b();
        builder.timestamp = ((d) (obj)).a();
        builder.dateTime = com.shazam.o.d.a(date);
        builder.shortDateTime = com.shazam.o.d.b(date);
        builder.sig = ((d) (obj)).b();
        return builder.b();
    }
}
