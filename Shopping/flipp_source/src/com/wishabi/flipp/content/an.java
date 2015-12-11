// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.content:
//            aj, SearchTermProvider, ao

final class an extends SQLiteOpenHelper
{

    public an(Context context)
    {
        super(context, "search_term.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        onUpgrade(sqlitedatabase, 0, 1);
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues;
        for (Iterator iterator = aj.a(0x7f070000, true).iterator(); iterator.hasNext(); sqlitedatabase.insert("item", null, contentvalues))
        {
            String s = (String)iterator.next();
            contentvalues = new ContentValues();
            contentvalues.put("word", s);
            contentvalues.put("locale", "en");
        }

        break MISSING_BLOCK_LABEL_88;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
        ContentValues contentvalues1;
        for (Iterator iterator1 = aj.a(0x7f070001, true).iterator(); iterator1.hasNext(); sqlitedatabase.insert("item", null, contentvalues1))
        {
            String s1 = (String)iterator1.next();
            contentvalues1 = new ContentValues();
            contentvalues1.put("word", s1);
            contentvalues1.put("locale", "fr");
        }

        Object obj = aj.a();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        ContentValues contentvalues2;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); sqlitedatabase.insert("merchant", null, contentvalues2))
        {
            String s2 = (String)((Iterator) (obj)).next();
            contentvalues2 = new ContentValues();
            contentvalues2.put("word", s2);
        }

        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (i--; i >= j; i--)
        {
            SearchTermProvider.a()[i].b(sqlitedatabase);
        }

    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (; i < j; i++)
        {
            SearchTermProvider.a()[i].a(sqlitedatabase);
        }

    }
}
