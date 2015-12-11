// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;
import com.shazam.model.location.SimpleLocation;

public final class j
    implements a
{

    public j()
    {
    }

    public static SimpleLocation a(Cursor cursor)
    {
label0:
        {
            double d = com.shazam.android.util.d.a.e(cursor, "lat");
            if (!Double.isNaN(d))
            {
                cursor = new SimpleLocation(null, d, com.shazam.android.util.d.a.e(cursor, "lon"), Double.valueOf(com.shazam.android.util.d.a.e(cursor, "alt")));
                if (((SimpleLocation) (cursor)).latitude != 0.0D || ((SimpleLocation) (cursor)).longitude != 0.0D || ((SimpleLocation) (cursor)).altitude.doubleValue() != 0.0D)
                {
                    break label0;
                }
            }
            return null;
        }
        return cursor;
    }

    public final volatile Object a(Object obj)
    {
        return a((Cursor)obj);
    }
}
