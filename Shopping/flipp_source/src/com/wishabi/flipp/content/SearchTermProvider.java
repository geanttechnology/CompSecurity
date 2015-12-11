// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.content:
//            ao, am, an, aj

public class SearchTermProvider extends ContentProvider
{

    static final String a = com/wishabi/flipp/content/SearchTermProvider.getSimpleName();
    private static final UriMatcher b;
    private static boolean d;
    private static final ao e[] = {
        new am()
    };
    private an c;

    public SearchTermProvider()
    {
    }

    public static void a(boolean flag)
    {
        com/wishabi/flipp/content/SearchTermProvider;
        JVM INSTR monitorenter ;
        d = flag;
        com/wishabi/flipp/content/SearchTermProvider;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static ao[] a()
    {
        return e;
    }

    private static boolean b()
    {
        com/wishabi/flipp/content/SearchTermProvider;
        JVM INSTR monitorenter ;
        boolean flag = d;
        com/wishabi/flipp/content/SearchTermProvider;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist)
    {
        ContentProviderResult acontentproviderresult[];
        Object obj;
        HashSet hashset;
        int i;
        int j;
        obj = c.getWritableDatabase();
        ((SQLiteDatabase) (obj)).beginTransaction();
        j = arraylist.size();
        acontentproviderresult = new ContentProviderResult[j];
        hashset = new HashSet();
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ContentProviderOperation contentprovideroperation = (ContentProviderOperation)arraylist.get(i);
        hashset.add(contentprovideroperation.getUri());
        acontentproviderresult[i] = contentprovideroperation.apply(this, acontentproviderresult, i);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ((SQLiteDatabase) (obj)).setTransactionSuccessful();
        ((SQLiteDatabase) (obj)).endTransaction();
        arraylist = getContext().getContentResolver();
        for (obj = hashset.iterator(); ((Iterator) (obj)).hasNext(); arraylist.notifyChange((Uri)((Iterator) (obj)).next(), null)) { }
        break MISSING_BLOCK_LABEL_142;
        arraylist;
        ((SQLiteDatabase) (obj)).endTransaction();
        throw arraylist;
        return acontentproviderresult;
    }

    public int delete(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        int j;
        j = b.match(uri);
        sqlitedatabase = c.getWritableDatabase();
        i = 0;
        if (j != 1) goto _L2; else goto _L1
_L1:
        i = sqlitedatabase.delete("history", s, as);
_L4:
        if (i > 0 && !sqlitedatabase.inTransaction())
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return i;
_L2:
        if (j == 2)
        {
            i = sqlitedatabase.delete("item", s, as);
        } else
        if (j == 3)
        {
            i = sqlitedatabase.delete("merchant", s, as);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getType(Uri uri)
    {
        int i = b.match(uri);
        if (i == 1 || i == 2 || i == 3)
        {
            return "vnd.android.cursor.dir/vnd.android.search.suggest";
        } else
        {
            throw new IllegalArgumentException("Unknown Uri");
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        i = b.match(uri);
        sqlitedatabase = c.getWritableDatabase();
        if (i != 1) goto _L2; else goto _L1
_L1:
        if (!b()) goto _L4; else goto _L3
_L3:
        uri = Long.valueOf(sqlitedatabase.insert("history", null, contentvalues));
        if (uri.longValue() < 0L) goto _L4; else goto _L5
_L5:
        uri = ContentUris.withAppendedId(aj.b, uri.longValue());
_L7:
        if (uri != null && !sqlitedatabase.inTransaction())
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return uri;
_L2:
        if (i == 2)
        {
            uri = Long.valueOf(sqlitedatabase.insert("item", null, contentvalues));
            if (uri.longValue() >= 0L)
            {
                uri = ContentUris.withAppendedId(aj.c, uri.longValue());
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (i == 3)
        {
            uri = Long.valueOf(sqlitedatabase.insert("merchant", null, contentvalues));
            if (uri.longValue() >= 0L)
            {
                uri = ContentUris.withAppendedId(aj.d, uri.longValue());
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            throw new RuntimeException((new StringBuilder("Unsupported table: ")).append(uri.toString()).toString());
        }
_L4:
        uri = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean onCreate()
    {
        c = new an(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        (new StringBuilder("query ")).append(uri.toString());
        s = uri.getPathSegments();
        as = ((String)s.get(s.size() - 1)).toLowerCase();
        if (as.equals("search_suggest_query"))
        {
            as = null;
        } else
        {
            s1 = ((String)s.get(0)).split("\\|");
            s = c.getReadableDatabase();
            ArrayList arraylist = new ArrayList();
            as1 = new ArrayList();
            int j = s1.length;
            int i = 0;
            while (i < j) 
            {
                String s2 = s1[i];
                if (s2.equalsIgnoreCase("history"))
                {
                    if (b() && !TextUtils.isEmpty(as))
                    {
                        s2 = (new StringBuilder("%")).append(as).append("%").toString();
                        arraylist.add(SQLiteQueryBuilder.buildQueryString(false, "history", aj.f, "word LIKE ?", null, null, null, null));
                        as1.add(s2);
                    }
                } else
                if (s2.equalsIgnoreCase("item"))
                {
                    if (!TextUtils.isEmpty(as))
                    {
                        s2 = (new StringBuilder("%")).append(as).append("%").toString();
                        String s3 = Locale.getDefault().getLanguage();
                        arraylist.add(SQLiteQueryBuilder.buildQueryString(false, "item", aj.j, "word LIKE ? AND locale = ?", null, null, null, null));
                        as1.add(s2);
                        as1.add(s3);
                    }
                } else
                if (s2.equalsIgnoreCase("merchant"))
                {
                    if (!TextUtils.isEmpty(as))
                    {
                        s2 = (new StringBuilder("%")).append(as).append("%").toString();
                        arraylist.add(SQLiteQueryBuilder.buildQueryString(false, "merchant", aj.h, "word LIKE ?", null, null, null, null));
                        as1.add(s2);
                        s2 = (new StringBuilder()).append(as).append("%").toString();
                        arraylist.add(SQLiteQueryBuilder.buildQueryString(false, "merchant", aj.g, "word LIKE ?", null, null, null, null));
                        as1.add(s2);
                    }
                } else
                {
                    throw new RuntimeException((new StringBuilder("Unsupported table: ")).append(s2).toString());
                }
                i++;
            }
            as = (new SQLiteQueryBuilder()).buildUnionQuery((String[])arraylist.toArray(new String[arraylist.size()]), null, null);
            s = s.rawQuery((new StringBuilder("SELECT * FROM (")).append(as).append(") GROUP BY suggest_text_1 ORDER BY type, _id DESC").toString(), (String[])as1.toArray(new String[as1.size()]));
            as = s;
            if (s != null)
            {
                as = s;
                if (s.getCount() > 0)
                {
                    s.setNotificationUri(getContext().getContentResolver(), uri);
                    return s;
                }
            }
        }
        return as;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        b = urimatcher;
        urimatcher.addURI("com.wishabi.flipp.content.SearchTerm", "history", 1);
        b.addURI("com.wishabi.flipp.content.SearchTerm", "item", 2);
        b.addURI("com.wishabi.flipp.content.SearchTerm", "merchant", 3);
    }
}
