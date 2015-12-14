// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.d;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.database:
//            c, b

public class PicsartProvider extends ContentProvider
{

    private static HashMap a;
    private static HashMap b;
    private static HashMap c;
    private static final UriMatcher d;
    private c e;

    public PicsartProvider()
    {
    }

    private SQLiteDatabase a()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = e.getReadableDatabase();
        }
        catch (SQLException sqlexception)
        {
            com.socialin.android.d.b("picsart_db", new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(sqlexception.getMessage()).toString()
            });
            return null;
        }
        return sqlitedatabase;
    }

    private SQLiteDatabase b()
    {
        SQLiteDatabase sqlitedatabase;
        try
        {
            sqlitedatabase = e.getWritableDatabase();
        }
        catch (SQLException sqlexception)
        {
            com.socialin.android.d.b("picsart_db", new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(sqlexception.getMessage()).toString()
            });
            return null;
        }
        return sqlitedatabase;
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        if (d.match(uri) != 1)
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        }
        uri = new android.database.DatabaseUtils.InsertHelper(e.getWritableDatabase(), "notifications");
        int k = acontentvalues.length;
        int i = 0;
        int j = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            ContentValues contentvalues = acontentvalues[i];
            try
            {
                uri.prepareForInsert();
                uri.insert(contentvalues);
            }
            catch (Exception exception)
            {
                if (d.b)
                {
                    if (exception.getMessage() != null)
                    {
                        exception.getMessage();
                    }
                } else
                {
                    ExceptionReportService.report(getContext(), exception, SocialinV3.getInstance().getUser().id);
                }
            }
            j++;
            i++;
        } while (true);
        getContext().getContentResolver().notifyChange(b.a, null);
        return j;
    }

    public int delete(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = b();
        int j;
        if (sqlitedatabase == null)
        {
            j = -1;
        } else
        {
            int i;
            if (d.match(uri) == 1)
            {
                i = sqlitedatabase.delete("notifications", s, as);
            } else
            if (d.match(uri) == 5)
            {
                i = sqlitedatabase.delete("uploads", s, as);
            } else
            if (d.match(uri) == 6)
            {
                i = sqlitedatabase.delete("addtext", s, as);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
            }
            j = i;
            if (i > 0)
            {
                getContext().getContentResolver().notifyChange(uri, null);
                return i;
            }
        }
        return j;
    }

    public String getType(Uri uri)
    {
        switch (d.match(uri))
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());

        case 1: // '\001'
            return "vnd.android.cursor.dir/vnd.picsart.studio.notifications";

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return "vnd.android.cursor.item/vnd.picsart.studio.notifications.item";

        case 5: // '\005'
            return "vnd.android.cursor.dir/vnd.picsart.studio.uploads";

        case 6: // '\006'
            return "vnd.android.cursor.dir/vnd.picsart.studio.addtext";
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        if (contentvalues == null)
        {
            throw new SQLException("Initial value must not be null");
        }
        SQLiteDatabase sqlitedatabase = e.getWritableDatabase();
        long l;
        if (d.match(uri) == 1)
        {
            if (!contentvalues.containsKey("notification_id"))
            {
                throw new SQLException("Initial value must contain string notification id");
            }
            if (!contentvalues.containsKey("notification_item"))
            {
                throw new SQLException("Initial value must contain notification item as blob");
            }
            l = sqlitedatabase.insertWithOnConflict("notifications", null, contentvalues, 4);
        } else
        if (d.match(uri) == 5)
        {
            l = sqlitedatabase.insertWithOnConflict("uploads", null, contentvalues, 4);
        } else
        if (d.match(uri) == 6)
        {
            l = sqlitedatabase.insertWithOnConflict("addtext", null, contentvalues, 4);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        }
        if (l > 0L)
        {
            uri = ContentUris.withAppendedId(uri, l);
            getContext().getContentResolver().notifyChange(uri, null);
            return uri;
        } else
        {
            throw new SQLException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
    }

    public boolean onCreate()
    {
        e = new c(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        String s2;
        Object obj1;
        SQLiteQueryBuilder sqlitequerybuilder;
        obj1 = null;
        sqlitequerybuilder = new SQLiteQueryBuilder();
        s2 = "";
        d.match(uri);
        JVM INSTR tableswitch 1 6: default 60
    //                   1 84
    //                   2 168
    //                   3 60
    //                   4 225
    //                   5 253
    //                   6 276;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L2:
        Object obj;
        sqlitequerybuilder.setTables("notifications");
        sqlitequerybuilder.setProjectionMap(a);
        obj = "created_at DESC";
_L8:
        if (TextUtils.isEmpty(s1))
        {
            s1 = ((String) (obj));
        }
        SQLiteDatabase sqlitedatabase = a();
        obj = obj1;
        if (sqlitedatabase != null)
        {
            obj = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1, s2);
            ((Cursor) (obj)).setNotificationUri(getContext().getContentResolver(), uri);
        }
        return ((Cursor) (obj));
_L3:
        sqlitequerybuilder.setTables("notifications");
        sqlitequerybuilder.setProjectionMap(a);
        sqlitequerybuilder.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
        obj = "created_at DESC";
        continue; /* Loop/switch isn't completed */
_L4:
        sqlitequerybuilder.setTables("notifications");
        sqlitequerybuilder.setProjectionMap(a);
        s2 = "1";
        obj = "created_at DESC";
        continue; /* Loop/switch isn't completed */
_L5:
        sqlitequerybuilder.setTables("uploads");
        sqlitequerybuilder.setProjectionMap(b);
        obj = "created_at ASC";
        continue; /* Loop/switch isn't completed */
_L6:
        sqlitequerybuilder.setTables("addtext");
        sqlitequerybuilder.setProjectionMap(c);
        obj = "addtext_usage DESC, addtext_created_at DESC";
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = b();
        int j;
        if (sqlitedatabase == null)
        {
            j = -1;
        } else
        {
            int i;
            if (d.match(uri) == 1)
            {
                i = sqlitedatabase.update("notifications", contentvalues, s, null);
            } else
            if (d.match(uri) == 5)
            {
                i = sqlitedatabase.update("uploads", contentvalues, s, null);
            } else
            if (d.match(uri) == 6)
            {
                i = sqlitedatabase.update("addtext", contentvalues, s, as);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
            }
            j = i;
            if (i > 0)
            {
                getContext().getContentResolver().notifyChange(uri, null);
                return i;
            }
        }
        return j;
    }

    static 
    {
        Object obj = new UriMatcher(-1);
        d = ((UriMatcher) (obj));
        ((UriMatcher) (obj)).addURI("com.picsart.studio.provider", "notifications", 1);
        d.addURI("com.picsart.studio.provider", "uploads", 5);
        d.addURI("com.picsart.studio.provider", "addtext", 6);
        d.addURI("com.picsart.studio.provider", "notifications/#", 2);
        d.addURI("com.picsart.studio.provider", "notifications/notification_id", 3);
        d.addURI("com.picsart.studio.provider", "notifications/since_id", 4);
        obj = new HashMap();
        a = ((HashMap) (obj));
        ((HashMap) (obj)).put("_id", "_id");
        a.put("notification_id", "notification_id");
        a.put("notification_item", "notification_item");
        a.put("created_at", "created_at");
        a.put("read", "read");
        obj = new HashMap();
        b = ((HashMap) (obj));
        ((HashMap) (obj)).put("_id", "_id");
        b.put("created_at", "created_at");
        b.put("upload_item", "upload_item");
        b.put("upload_status", "upload_status");
        obj = new HashMap();
        c = ((HashMap) (obj));
        ((HashMap) (obj)).put("_id", "_id");
        c.put("addtext_addedtext", "addtext_addedtext");
        c.put("addtext_usage", "addtext_usage");
    }
}
