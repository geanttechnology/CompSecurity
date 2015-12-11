// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import com.shazam.b.a.a;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.model.Tag;
import com.shazam.model.TagContext;
import com.shazam.model.location.SimpleLocation;

public final class m
    implements a
{

    private final b a;

    public m(b b1)
    {
        a = b1;
    }

    private Tag a(Cursor cursor)
    {
        if (cursor == null)
        {
            return null;
        }
        int i = cursor.getPosition();
        if (i < 0 || i >= cursor.getCount())
        {
            throw new CursorIndexOutOfBoundsException(i, cursor.getCount());
        }
        Tag tag = new Tag();
        String s = com.shazam.android.util.d.a.a(cursor, "request_id");
        String s1 = com.shazam.android.util.d.a.a(cursor, "status");
        String s2 = com.shazam.android.util.d.a.a(cursor, "datetime");
        String s3 = com.shazam.android.util.d.a.a(cursor, "short_datetime");
        long l = com.shazam.android.util.d.a.b(cursor, "timestamp");
        byte abyte0[] = com.shazam.android.util.d.a.d(cursor, "sig");
        double d = com.shazam.android.util.d.a.e(cursor, "lat");
        double d1 = com.shazam.android.util.d.a.e(cursor, "lon");
        double d2 = com.shazam.android.util.d.a.e(cursor, "alt");
        cursor = com.shazam.android.util.d.a.a(cursor, "serialized_tag_context");
        SimpleLocation simplelocation;
        Object obj;
        if (com.shazam.b.e.a.c(cursor))
        {
            try
            {
                cursor = (TagContext)a.a(cursor, com/shazam/model/TagContext);
            }
            // Misplaced declaration of an exception variable
            catch (Cursor cursor)
            {
                throw new RuntimeException(cursor);
            }
        } else
        {
            cursor = null;
        }
        obj = null;
        simplelocation = obj;
        if (!Double.isNaN(d))
        {
            simplelocation = obj;
            if (!Double.isNaN(d1))
            {
                simplelocation = new SimpleLocation(null, d, d1, Double.valueOf(d2));
            }
        }
        if (com.shazam.b.e.a.a(s))
        {
            throw new IllegalArgumentException((new StringBuilder("tagId value = ")).append(s).toString());
        }
        if (com.shazam.b.e.a.a(s1))
        {
            throw new IllegalArgumentException((new StringBuilder("status value = ")).append(s1).toString());
        }
        if (com.shazam.b.e.a.a(s2))
        {
            throw new IllegalArgumentException((new StringBuilder("dateTime value = ")).append(s2).toString());
        }
        if (com.shazam.b.e.a.a(s3))
        {
            throw new IllegalArgumentException((new StringBuilder("shortDateTime value = ")).append(s3).toString());
        }
        if (l == -1L)
        {
            throw new IllegalArgumentException((new StringBuilder("timestamp value = ")).append(l).toString());
        }
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new IllegalArgumentException("sig value is null or empty");
        } else
        {
            tag.requestId = s;
            tag.status = com.shazam.model.Tag.Status.getStatusForName(s1, com.shazam.model.Tag.Status.UNSUBMITTED);
            tag.dateTime = s2;
            tag.shortDateTime = s3;
            tag.timestamp = l;
            tag.sig = abyte0;
            tag.location = simplelocation;
            tag.tagContext = cursor;
            return tag;
        }
    }

    public final volatile Object a(Object obj)
    {
        return a((Cursor)obj);
    }
}
