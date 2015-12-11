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
import android.net.Uri;
import android.text.TextUtils;
import com.wishabi.flipp.util.a;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.content:
//            x, p, q, r, 
//            s, t, u, v, 
//            i, w

public class FlyersContentProvider extends ContentProvider
{

    private static final UriMatcher a;
    private static final x c[] = {
        new p(), new com.wishabi.flipp.content.q(), new r(), new s(), new t(), new u(), new v()
    };
    private SQLiteDatabase b;

    public FlyersContentProvider()
    {
    }

    static x[] a()
    {
        return c;
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist)
    {
        ContentProviderResult acontentproviderresult[];
        Object obj;
        int j;
        int k;
        b.beginTransaction();
        k = arraylist.size();
        acontentproviderresult = new ContentProviderResult[k];
        obj = new HashSet();
        j = 0;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ContentProviderOperation contentprovideroperation = (ContentProviderOperation)arraylist.get(j);
        ((HashSet) (obj)).add(contentprovideroperation.getUri());
        acontentproviderresult[j] = contentprovideroperation.apply(this, acontentproviderresult, j);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        b.setTransactionSuccessful();
        b.endTransaction();
        arraylist = getContext().getContentResolver();
        for (obj = ((HashSet) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.notifyChange((Uri)((Iterator) (obj)).next(), null)) { }
        break MISSING_BLOCK_LABEL_143;
        arraylist;
        b.endTransaction();
        throw arraylist;
        return acontentproviderresult;
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        Context context;
        int k;
        String s1 = null;
        k = 0;
        context = getContext();
        if (context == null)
        {
            return 0;
        }
        int j = a.match(uri);
        ContentValues contentvalues;
        int l;
        int i1;
        long l1;
        if (j == 1)
        {
            s1 = "flyers";
        } else
        if (j == 3)
        {
            s1 = "categories";
        } else
        if (j == 4)
        {
            s1 = "items";
        } else
        if (j == 5)
        {
            s1 = "featured_items";
        } else
        if (j == 6)
        {
            s1 = "coupons";
        } else
        if (j == 7)
        {
            s1 = "coupon_categories";
        } else
        if (j == 8)
        {
            s1 = "flyer_item_coupons";
        }
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_232;
        }
        b.beginTransaction();
        i1 = acontentvalues.length;
        j = 0;
_L2:
        if (j >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = acontentvalues[j];
        l1 = Long.valueOf(b.insertWithOnConflict(s1, null, contentvalues, 5)).longValue();
        l = k;
        if (l1 >= 0L)
        {
            l = k + 1;
        }
        j++;
        k = l;
        if (true) goto _L2; else goto _L1
_L1:
        b.setTransactionSuccessful();
        context.getContentResolver().notifyChange(uri, null);
        b.endTransaction();
        return k;
        uri;
        b.endTransaction();
        throw uri;
        return super.bulkInsert(uri, acontentvalues);
    }

    public int delete(Uri uri, String s1, String as[])
    {
        Context context = getContext();
        if (context != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L14:
        return k;
_L2:
        a.match(uri);
        JVM INSTR tableswitch 1 9: default 76
    //                   1 100
    //                   2 149
    //                   3 165
    //                   4 181
    //                   5 197
    //                   6 213
    //                   7 229
    //                   8 245
    //                   9 261;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_261;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L4:
        int j = b.delete("flyers", s1, as);
_L15:
        k = j;
        if (j > 0)
        {
            k = j;
            if (!b.inTransaction())
            {
                context.getContentResolver().notifyChange(uri, null);
                return j;
            }
        }
        if (true) goto _L14; else goto _L13
_L13:
        j = b.delete("flyers", s1, as);
          goto _L15
_L6:
        j = b.delete("categories", s1, as);
          goto _L15
_L7:
        j = b.delete("items", s1, as);
          goto _L15
_L8:
        j = b.delete("featured_items", s1, as);
          goto _L15
_L9:
        j = b.delete("coupons", s1, as);
          goto _L15
_L10:
        j = b.delete("coupon_categories", s1, as);
          goto _L15
_L11:
        j = b.delete("flyer_item_coupons", s1, as);
          goto _L15
        j = b.delete("flyer_pages", s1, as);
          goto _L15
    }

    public String getType(Uri uri)
    {
        return "vnd.android.cursor.dir/vnd.flipp.flyer";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        Context context;
        context = getContext();
        if (context == null)
        {
            return null;
        }
        a.match(uri);
        JVM INSTR tableswitch 1 9: default 68
    //                   1 92
    //                   2 68
    //                   3 153
    //                   4 192
    //                   5 231
    //                   6 270
    //                   7 309
    //                   8 348
    //                   9 387;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        throw new IllegalArgumentException((new StringBuilder("unsupported uri: ")).append(uri).toString());
_L2:
        uri = Long.valueOf(b.insertWithOnConflict("flyers", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(com.wishabi.flipp.content.i.a, uri.longValue());
_L11:
        if (uri != null && !b.inTransaction())
        {
            context.getContentResolver().notifyChange(uri, null);
        }
        return uri;
_L3:
        uri = Long.valueOf(b.insertWithOnConflict("categories", null, contentvalues, 5));
        if (uri.longValue() >= 0L)
        {
            uri = ContentUris.withAppendedId(i.b, uri.longValue());
            continue; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L4:
        uri = Long.valueOf(b.insertWithOnConflict("items", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.c, uri.longValue());
        continue; /* Loop/switch isn't completed */
_L5:
        uri = Long.valueOf(b.insertWithOnConflict("featured_items", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.e, uri.longValue());
        continue; /* Loop/switch isn't completed */
_L6:
        uri = Long.valueOf(b.insertWithOnConflict("coupons", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.n, uri.longValue());
        continue; /* Loop/switch isn't completed */
_L7:
        uri = Long.valueOf(b.insertWithOnConflict("coupon_categories", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.o, uri.longValue());
        continue; /* Loop/switch isn't completed */
_L8:
        uri = Long.valueOf(b.insertWithOnConflict("flyer_item_coupons", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.p, uri.longValue());
        continue; /* Loop/switch isn't completed */
_L9:
        uri = Long.valueOf(b.insertWithOnConflict("flyer_pages", null, contentvalues, 5));
        if (uri.longValue() < 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        uri = ContentUris.withAppendedId(i.d, uri.longValue());
        continue; /* Loop/switch isn't completed */
        uri = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public boolean onCreate()
    {
        b = (new w(getContext())).getWritableDatabase();
        return true;
    }

    public Cursor query(Uri uri, String as[], String s1, String as1[], String s2)
    {
        Context context;
        context = getContext();
        if (context == null)
        {
            return null;
        }
        a.match(uri);
        JVM INSTR tableswitch 1 9: default 72
    //                   1 96
    //                   2 594
    //                   3 637
    //                   4 660
    //                   5 681
    //                   6 702
    //                   7 723
    //                   8 746
    //                   9 768;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_768;
_L1:
        throw new IllegalArgumentException((new StringBuilder("unsupported uri: ")).append(uri).toString());
_L2:
        if (s2 == null)
        {
            s2 = "premium DESC, priority ASC, available_from DESC";
        }
        if (uri.getQueryParameter("filter_field") == null) goto _L12; else goto _L11
_L11:
        String s3;
        as = uri.getQueryParameter("filter_field");
        s3 = uri.getQueryParameter("filter_values");
        if (as != null && s3 != null) goto _L14; else goto _L13
_L13:
        as = null;
_L19:
        String as2[];
        String s4;
        if (as == null)
        {
            return null;
        } else
        {
            as.setNotificationUri(context.getContentResolver(), uri);
            return as;
        }
_L14:
        as2 = s3.split(",");
        if (!as.equals("categories")) goto _L16; else goto _L15
_L15:
        as = "categories.name";
_L18:
        if (s1 == null)
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder()).append(s1).append(" AND ").toString();
        }
        s4 = (new StringBuilder()).append(s1).append(as).append(" in (").append(q.a("?", as2.length, ",")).append(")").toString();
        if (as1 == null)
        {
            s1 = as2;
        } else
        {
            s1 = (String[])com.wishabi.flipp.util.a.a(as1, as2);
        }
        as1 = (new StringBuilder("CASE ")).append(as).append(" ").toString();
        for (int j = 0; j < as2.length; j++)
        {
            as1 = (new StringBuilder()).append(as1).append("WHEN ? THEN ").append(Integer.toString(j)).append(" ").toString();
        }

        break MISSING_BLOCK_LABEL_369;
_L16:
        if (q.a(as2)) goto _L18; else goto _L17
_L17:
        as = null;
          goto _L19
        as1 = (new StringBuilder()).append(as1).append("END").toString();
        as1 = (new StringBuilder()).append(as1).append(", ").append(s2).toString();
        if (as.equals("categories.name"))
        {
            as = (new StringBuilder("SELECT flyers.* FROM flyers, categories WHERE flyers._id = categories.flyer_id AND ")).append(s4).append(" ORDER BY ").append(as1).toString();
        } else
        {
            as = (new StringBuilder("SELECT * FROM flyers WHERE ")).append(s4).append(" ORDER BY ").append(as1).toString();
        }
        s1 = (String[])com.wishabi.flipp.util.a.a(s1, as2);
        String.format("query: '%s' args: '%s'", new Object[] {
            as, Arrays.toString(s1)
        });
        as = b.rawQuery(as, s1);
          goto _L19
_L12:
        String.format("table: 'flyers' projection: '%s' selection: '%s'selectionArgs: '%s' sort: '%s'", new Object[] {
            Arrays.toString(as), s1, Arrays.toString(as1), s2
        });
        as = b.query("flyers", as, s1, as1, null, null, s2);
          goto _L19
_L3:
        long l = ContentUris.parseId(uri);
        as = b.query("flyers", as, (new StringBuilder("_id = ")).append(l).toString(), as1, null, null, null);
          goto _L19
_L4:
        as = b.query(true, "categories", as, s1, as1, null, null, s2, null);
          goto _L19
_L5:
        as = b.query("items", as, s1, as1, null, null, s2);
          goto _L19
_L6:
        as = b.query("featured_items", as, s1, as1, null, null, s2);
          goto _L19
_L7:
        as = b.query("coupons", as, s1, as1, null, null, s2);
          goto _L19
_L8:
        as = b.query(true, "coupon_categories", as, s1, as1, null, null, s2, null);
          goto _L19
_L9:
        as = b.query("flyer_item_coupons", as, s1, as1, null, null, s2, null);
          goto _L19
        as = b.query("flyer_pages", as, s1, as1, null, null, s2, null);
          goto _L19
    }

    public int update(Uri uri, ContentValues contentvalues, String s1, String as[])
    {
        Context context;
        int j;
        int k;
        k = 0;
        j = 0;
        context = getContext();
        if (context != null) goto _L2; else goto _L1
_L1:
        k = j;
_L14:
        return k;
_L2:
        a.match(uri);
        JVM INSTR tableswitch 1 9: default 80
    //                   1 104
    //                   2 155
    //                   3 281
    //                   4 299
    //                   5 317
    //                   6 335
    //                   7 353
    //                   8 371
    //                   9 389;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_389;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L4:
        j = b.update("flyers", contentvalues, s1, as);
_L15:
        k = j;
        if (j > 0)
        {
            k = j;
            if (!b.inTransaction())
            {
                context.getContentResolver().notifyChange(uri, null);
                return j;
            }
        }
        if (true) goto _L14; else goto _L13
_L13:
        List list = uri.getPathSegments();
        j = k;
        if (list != null)
        {
            j = k;
            if (list.size() >= 2)
            {
                SQLiteDatabase sqlitedatabase = b;
                StringBuilder stringbuilder = (new StringBuilder("_id = ")).append((String)uri.getPathSegments().get(1));
                if (TextUtils.isEmpty(s1))
                {
                    s1 = "";
                } else
                {
                    s1 = (new StringBuilder(" AND (")).append(s1).append(")").toString();
                }
                j = sqlitedatabase.update("flyers", contentvalues, stringbuilder.append(s1).toString(), as);
            }
        }
          goto _L15
_L6:
        j = b.update("categories", contentvalues, s1, as);
          goto _L15
_L7:
        j = b.update("items", contentvalues, s1, as);
          goto _L15
_L8:
        j = b.update("featured_items", contentvalues, s1, as);
          goto _L15
_L9:
        j = b.update("coupons", contentvalues, s1, as);
          goto _L15
_L10:
        j = b.update("coupon_categories", contentvalues, s1, as);
          goto _L15
_L11:
        j = b.update("flyer_item_coupons", contentvalues, s1, as);
          goto _L15
        j = b.update("flyer_pages", contentvalues, s1, as);
          goto _L15
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        a = urimatcher;
        urimatcher.addURI("com.wishabi.flipp.content.Flyer", "flyers", 1);
        a.addURI("com.wishabi.flipp.content.Flyer", "flyers/#", 2);
        a.addURI("com.wishabi.flipp.content.Flyer", "categories", 3);
        a.addURI("com.wishabi.flipp.content.Flyer", "items", 4);
        a.addURI("com.wishabi.flipp.content.Flyer", "featured_items", 5);
        a.addURI("com.wishabi.flipp.content.Flyer", "coupons", 6);
        a.addURI("com.wishabi.flipp.content.Flyer", "coupon_categories", 7);
        a.addURI("com.wishabi.flipp.content.Flyer", "flyer_item_coupons", 8);
        a.addURI("com.wishabi.flipp.content.Flyer", "flyer_pages", 9);
    }
}
