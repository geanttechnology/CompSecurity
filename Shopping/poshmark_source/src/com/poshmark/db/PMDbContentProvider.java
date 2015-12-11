// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.poshmark.application.PMApplication;

// Referenced classes of package com.poshmark.db:
//            PMDbHelper

public class PMDbContentProvider extends ContentProvider
{

    public static final String AUTHORITY = PMApplication.getContext().getResources().getString(0x7f06004c);
    public static final int BRANDS = 1;
    public static final int CATEGORY = 6;
    public static final int CATEGORY_SIZES = 7;
    public static final int CATEGORY_STYLETAGS = 8;
    public static final int COLORS = 9;
    public static final Uri CONTENT_URI_BRANDS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("brands").toString());
    public static final Uri CONTENT_URI_CATEGORY = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("category").toString());
    public static final Uri CONTENT_URI_CATEGORY_SIZES = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("sizes").toString());
    public static final Uri CONTENT_URI_CATEGORY_STYLE_TAGS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("subcategory").toString());
    public static final Uri CONTENT_URI_COLORS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("colors").toString());
    public static final Uri CONTENT_URI_FOLLOWING_BRANDS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("following").toString());
    public static final Uri CONTENT_URI_RECENTS_BRANDS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("recent_brands").toString());
    public static final Uri CONTENT_URI_SAVED_SEARCHES = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("saved_searches").toString());
    public static final Uri CONTENT_URI_TIMESTAMPS = Uri.parse((new StringBuilder()).append("content://").append(AUTHORITY).append("/").append("timestamps").toString());
    public static final int FOLLOWING_BRANDS = 3;
    public static final int RECENTS = 4;
    public static final int SAVED_SEARCHES = 5;
    public static final int TIMESTAMPS = 2;
    private static final UriMatcher sURIMatcher;
    private PMDbHelper database;

    public PMDbContentProvider()
    {
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = database.getWritableDatabase();
        sURIMatcher.match(uri);
        JVM INSTR tableswitch 1 9: default 735
    //                   1 514
    //                   2 68
    //                   3 638
    //                   4 68
    //                   5 68
    //                   6 100
    //                   7 308
    //                   8 199
    //                   9 417;
           goto _L1 _L2 _L1 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
        throw new UnsupportedOperationException((new StringBuilder()).append("unsupported uri: ").append(uri).toString());
        uri;
        this;
        JVM INSTR monitorexit ;
        throw uri;
_L4:
        int j;
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into category(_id,canonical_name) values (?,?)");
        j = acontentvalues.length;
        int i = 0;
_L9:
        ContentValues contentvalues;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(1, contentvalues.getAsString("_id"));
        uri.bindString(2, contentvalues.getAsString("canonical_name"));
        uri.execute();
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_CATEGORY, null);
_L12:
        this;
        JVM INSTR monitorexit ;
        return i;
_L6:
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into subcategory(_id,name,category_id) values (?,?,?)");
        j = acontentvalues.length;
        i = 0;
_L11:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(1, contentvalues.getAsString("_id"));
        uri.bindString(2, contentvalues.getAsString("name"));
        uri.bindString(3, contentvalues.getAsString("category_id"));
        uri.execute();
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_CATEGORY, null);
          goto _L12
_L5:
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into sizes(_id,short_name,long_name) values (?,?,?)");
        j = acontentvalues.length;
        i = 0;
_L14:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(1, contentvalues.getAsString("_id"));
        uri.bindString(2, contentvalues.getAsString("short_name"));
        uri.bindString(3, contentvalues.getAsString("long_name"));
        uri.execute();
        i++;
        if (true) goto _L14; else goto _L13
_L13:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_CATEGORY, null);
          goto _L12
_L7:
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into colors(_id,rgb) values (?,RTRIM(?))");
        j = acontentvalues.length;
        i = 0;
_L16:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(1, contentvalues.getAsString("_id"));
        uri.bindString(2, contentvalues.getAsString("rgb"));
        uri.execute();
        i++;
        if (true) goto _L16; else goto _L15
_L15:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_CATEGORY, null);
          goto _L12
_L2:
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into brands(_id,canonical_name,description,following) values (?,?,?,?)");
        j = acontentvalues.length;
        i = 0;
_L18:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(2, contentvalues.getAsString("canonical_name"));
        uri.bindString(3, contentvalues.getAsString("description"));
        contentvalues.getAsInteger("following").intValue();
        uri.bindLong(4, contentvalues.getAsInteger("following").intValue());
        uri.execute();
        i++;
        if (true) goto _L18; else goto _L17
_L17:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_BRANDS, null);
          goto _L12
_L3:
        sqlitedatabase.beginTransaction();
        uri = sqlitedatabase.compileStatement("insert into following(_id,user,canonical_name) values (?,?,?)");
        j = acontentvalues.length;
        i = 0;
_L20:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[i];
        uri.bindString(2, contentvalues.getAsString("user"));
        uri.bindString(3, contentvalues.getAsString("canonical_name"));
        uri.execute();
        i++;
        if (true) goto _L20; else goto _L19
_L19:
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        getContext().getContentResolver().notifyChange(CONTENT_URI_FOLLOWING_BRANDS, null);
          goto _L12
    }

    public int delete(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = database.getWritableDatabase();
        switch (sURIMatcher.match(uri))
        {
        case 4: // '\004'
        case 5: // '\005'
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("unsupported uri: ").append(uri).toString());

        case 6: // '\006'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("category", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "category", s, as);
            }

        case 9: // '\t'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("colors", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "colors", s, as);
            }

        case 1: // '\001'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("brands", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "brands", s, as);
            }

        case 3: // '\003'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("following", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "following", s, as);
            }

        case 2: // '\002'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("timestamps", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "timestamps", s, as);
            }

        case 8: // '\b'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                return sqlitedatabase.delete("subcategory", s, as);
            } else
            {
                return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "subcategory", s, as);
            }

        case 7: // '\007'
            break;
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            return sqlitedatabase.delete("sizes", s, as);
        } else
        {
            return SQLiteInstrumentation.delete((SQLiteDatabase)sqlitedatabase, "sizes", s, as);
        }
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = database.getWritableDatabase();
        switch (sURIMatcher.match(uri))
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI: ").append(uri).toString());

        case 1: // '\001'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.insert("brands", null, contentvalues);
            } else
            {
                SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "brands", null, contentvalues);
            }
            return CONTENT_URI_BRANDS;

        case 2: // '\002'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.insert("timestamps", null, contentvalues);
            } else
            {
                SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "timestamps", null, contentvalues);
            }
            return CONTENT_URI_TIMESTAMPS;

        case 4: // '\004'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.insert("recent_brands", null, contentvalues);
            } else
            {
                SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "recent_brands", null, contentvalues);
            }
            return CONTENT_URI_RECENTS_BRANDS;

        case 5: // '\005'
            if (!(sqlitedatabase instanceof SQLiteDatabase))
            {
                sqlitedatabase.insert("saved_searches", null, contentvalues);
            } else
            {
                SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "saved_searches", null, contentvalues);
            }
            return CONTENT_URI_SAVED_SEARCHES;

        case 3: // '\003'
            break;
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.insert("following", null, contentvalues);
        } else
        {
            SQLiteInstrumentation.insert((SQLiteDatabase)sqlitedatabase, "following", null, contentvalues);
        }
        return CONTENT_URI_FOLLOWING_BRANDS;
    }

    public boolean onCreate()
    {
        database = new PMDbHelper(getContext());
        return false;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        as = database.getWritableDatabase();
        switch (sURIMatcher.match(uri))
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI: ").append(uri).toString());

        case 9: // '\t'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 8: // '\b'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 7: // '\007'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 6: // '\006'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 1: // '\001'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 2: // '\002'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 4: // '\004'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 5: // '\005'
            if (!(as instanceof SQLiteDatabase))
            {
                as = as.rawQuery(s, null);
            } else
            {
                as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
            }
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;

        case 3: // '\003'
            break;
        }
        if (!(as instanceof SQLiteDatabase))
        {
            as = as.rawQuery(s, null);
        } else
        {
            as = SQLiteInstrumentation.rawQuery((SQLiteDatabase)as, s, null);
        }
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        int j;
        sqlitedatabase = database.getWritableDatabase();
        j = sURIMatcher.match(uri);
        i = 0;
        j;
        JVM INSTR tableswitch 1 5: default 56
    //                   1 104
    //                   2 104
    //                   3 56
    //                   4 83
    //                   5 122;
           goto _L1 _L2 _L2 _L1 _L3 _L4
_L1:
        throw new UnsupportedOperationException((new StringBuilder()).append("unsupported uri: ").append(uri).toString());
_L3:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        i = sqlitedatabase.update("recent_brands", contentvalues, s, as);
_L2:
        return i;
_L6:
        return SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "recent_brands", contentvalues, s, as);
_L4:
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            return sqlitedatabase.update("saved_searches", contentvalues, s, as);
        } else
        {
            return SQLiteInstrumentation.update((SQLiteDatabase)sqlitedatabase, "saved_searches", contentvalues, s, as);
        }
    }

    static 
    {
        sURIMatcher = new UriMatcher(-1);
        sURIMatcher.addURI(AUTHORITY, "category", 6);
        sURIMatcher.addURI(AUTHORITY, "sizes", 7);
        sURIMatcher.addURI(AUTHORITY, "subcategory", 8);
        sURIMatcher.addURI(AUTHORITY, "colors", 9);
        sURIMatcher.addURI(AUTHORITY, "brands", 1);
        sURIMatcher.addURI(AUTHORITY, "timestamps", 2);
        sURIMatcher.addURI(AUTHORITY, "following", 3);
        sURIMatcher.addURI(AUTHORITY, "recent_brands", 4);
        sURIMatcher.addURI(AUTHORITY, "saved_searches", 5);
    }
}
