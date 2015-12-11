// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;

// Referenced classes of package com.shazam.android.l.d:
//            j

public final class k
    implements a
{

    private final j a;

    public k(j j1)
    {
        a = j1;
    }

    public final Object a(Object obj)
    {
        Object obj3 = (Cursor)obj;
        Object obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "request_id");
        obj = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "track_id");
        Object obj2 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "datetime");
        String s = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "short_datetime");
        long l = com.shazam.android.util.d.a.b(((Cursor) (obj3)), "timestamp");
        com.shazam.model.Tag.Status status = com.shazam.model.Tag.Status.getStatusForName(com.shazam.android.util.d.a.a(((Cursor) (obj3)), "status"), null);
        String s1 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "location_name");
        String s2 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "json");
        com.shazam.model.location.SimpleLocation simplelocation = com.shazam.android.l.d.j.a(((Cursor) (obj3)));
        Double double1 = com.shazam.android.util.d.a.f(((Cursor) (obj3)), "offset");
        Double double2 = com.shazam.android.util.d.a.f(((Cursor) (obj3)), "skew");
        Double double3 = com.shazam.android.util.d.a.f(((Cursor) (obj3)), "frequency_skew");
        String s3 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "event_id");
        obj3 = com.shazam.android.util.d.a.h(((Cursor) (obj3)), "unread");
        com.shazam.model.Tag.Builder builder = com.shazam.model.Tag.Builder.a();
        builder.requestId = ((String) (obj1));
        builder.dateTime = ((String) (obj2));
        builder.shortDateTime = s;
        builder.timestamp = l;
        builder.status = status;
        builder.locationName = s1;
        builder.location = simplelocation;
        builder.lyricOffset = double1;
        builder.lyricSkew = double2;
        builder.frequencySkew = double3;
        builder.eventId = s3;
        builder.unread = ((Boolean) (obj3)).booleanValue();
        builder.json = s2;
        obj1 = builder.b();
        obj2 = new com.shazam.k.e.a();
        obj2.b = obj1;
        obj2.a = ((String) (obj));
        return ((com.shazam.k.e.a) (obj2)).a();
    }
}
