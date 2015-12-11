// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;
import com.shazam.model.ArbitraryMetadata;

public final class e
    implements a
{

    public e()
    {
    }

    public final Object a(Object obj)
    {
        Object obj2 = (Cursor)obj;
        obj = com.shazam.android.util.d.a.a(((Cursor) (obj2)), "track_id");
        Object obj1 = com.shazam.android.util.d.a.a(((Cursor) (obj2)), "entry_key");
        obj2 = com.shazam.android.util.d.a.a(((Cursor) (obj2)), "entry_value");
        com.shazam.model.ArbitraryMetadata.Builder builder = com.shazam.model.ArbitraryMetadata.Builder.a();
        builder.key = ((String) (obj1));
        builder.value = ((String) (obj2));
        obj1 = new ArbitraryMetadata(builder, null);
        obj2 = new com.shazam.k.a();
        obj2.a = ((String) (obj));
        obj2.b = obj1;
        return ((com.shazam.k.a) (obj2)).a();
    }
}
