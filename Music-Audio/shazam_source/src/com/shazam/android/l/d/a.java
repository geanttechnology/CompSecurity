// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.f.f;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.model.AddOn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    private final b a;

    public a(b b1)
    {
        a = b1;
    }

    private List a(Cursor cursor)
    {
        if (cursor == null || cursor.isClosed())
        {
            break MISSING_BLOCK_LABEL_70;
        }
        ArrayList arraylist = new ArrayList();
        boolean flag;
        if (cursor.moveToFirst())
        {
            do
            {
                arraylist.addAll(b(cursor));
                flag = cursor.moveToNext();
            } while (flag);
        }
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        return Collections.emptyList();
    }

    private List b(Cursor cursor)
    {
        String s = com.shazam.android.util.d.a.a(cursor, "track_id");
        Object obj;
        try
        {
            obj = com.shazam.android.util.d.a.a(cursor, "serialized_addons");
            cursor = Collections.emptyList();
            if (com.shazam.b.e.a.c(((String) (obj))))
            {
                cursor = ((com.google.b.c.a) (new com.google.b.c.a() {

                    final a d;

            
            {
                d = a.this;
                super();
            }
                })).b;
                cursor = (List)a.a(((String) (obj)), cursor);
            }
            obj = new ArrayList(cursor.size());
            com.shazam.k.e.a a1;
            for (cursor = cursor.iterator(); cursor.hasNext(); ((List) (obj)).add(a1.a()))
            {
                Object obj1 = com.shazam.model.AddOn.Builder.a((AddOn)cursor.next());
                obj1.trackId = s;
                obj1 = ((com.shazam.model.AddOn.Builder) (obj1)).b();
                a1 = new com.shazam.k.e.a();
                a1.a = s;
                a1.b = obj1;
            }

        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            throw new f("Could not deserialize addons", cursor);
        }
        return ((List) (obj));
    }

    public final volatile Object a(Object obj)
    {
        return a((Cursor)obj);
    }
}
