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
import android.os.Handler;
import com.wishabi.flipp.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.content:
//            bk, bc, bd, be, 
//            bf, i, bj, bg, 
//            bh, bi

public class UserContentProvider extends ContentProvider
{

    private static String c[];
    private static String d[];
    private static final UriMatcher e;
    private static final bk f[] = {
        new bc(), new bd(), new be(), new bf()
    };
    private SQLiteDatabase a;
    private Handler b;

    public UserContentProvider()
    {
    }

    private int a(String s, String as[])
    {
        int j = 1;
        String s1;
        SQLiteQueryBuilder sqlitequerybuilder;
        if (!s.contains("user_coupon_data."))
        {
            j = 0;
        }
        s1 = "flyerdb.coupons";
        if (j != 0)
        {
            s1 = (new StringBuilder()).append("flyerdb.coupons").append(" LEFT JOIN user_coupon_data ON flyerdb.coupons._id = user_coupon_data._id").toString();
        }
        sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables(s1);
        s = sqlitequerybuilder.query(a, new String[] {
            "flyerdb.coupons._id AS coupon_id"
        }, s, as, null, null, null);
        as = com.wishabi.flipp.util.f.b(s, "coupon_id");
        if (s != null)
        {
            s.close();
        }
        if (as.length == 0)
        {
            return 0;
        } else
        {
            j = a.delete("flyerdb.coupons", com.wishabi.flipp.util.f.a("_id", as), as);
            a.delete("user_coupon_data", com.wishabi.flipp.util.f.a("_id", as), as);
            return j;
        }
        as;
        s = null;
_L2:
        if (s != null)
        {
            s.close();
        }
        throw as;
        as;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Cursor a(String as[], String s, String as1[], String s1)
    {
        String as2[];
        SQLiteQueryBuilder sqlitequerybuilder;
        boolean flag1;
        boolean flag3;
label0:
        {
            boolean flag5 = false;
            sqlitequerybuilder = new SQLiteQueryBuilder();
            boolean flag4;
            if (as != null)
            {
                as2 = new String[as.length];
            } else
            {
                as2 = null;
            }
            if (as != null)
            {
                int j = 0;
                boolean flag2 = false;
                boolean flag = false;
                do
                {
                    flag4 = flag2;
                    flag3 = flag;
                    if (j >= as.length)
                    {
                        break;
                    }
                    String s2 = as[j];
                    if (s2.contains("category"))
                    {
                        as2[j] = String.format(s2.replace("category", "cat.name AS category"), new Object[0]);
                        flag = true;
                    } else
                    if (s2.contains("user_coupon_data."))
                    {
                        as2[j] = s2;
                        flag2 = true;
                    } else
                    if (s2.equals("clipped") || s2.equals("sent"))
                    {
                        as2[j] = String.format("IFNULL(user_coupon_data.%s, 0) AS %s", new Object[] {
                            s2, s2
                        });
                        flag2 = true;
                    } else
                    {
                        as2[j] = (new StringBuilder("c.")).append(as[j]).toString();
                    }
                    j++;
                } while (true);
            } else
            {
                flag4 = false;
                flag3 = false;
            }
            as = "flyerdb.coupons c";
            if (!flag4)
            {
                flag1 = flag5;
                if (s == null)
                {
                    break label0;
                }
                flag1 = flag5;
                if (!s.contains("user_coupon_data."))
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        if (flag3)
        {
            as = (new StringBuilder()).append("flyerdb.coupons c").append(" LEFT JOIN flyerdb.coupon_categories cat ON c._id = cat.coupon_id").toString();
        }
        Object obj = as;
        if (flag1)
        {
            obj = (new StringBuilder()).append(as).append(" LEFT JOIN user_coupon_data ON c._id = user_coupon_data._id").toString();
        }
        sqlitequerybuilder.setTables(((String) (obj)));
        return sqlitequerybuilder.query(a, as2, s, as1, null, null, s1);
    }

    static bk[] a()
    {
        return f;
    }

    private Cursor b(String as[], String s, String as1[], String s1)
    {
        ArrayList arraylist;
        int j;
        boolean flag;
        int i1;
        int j1;
        boolean flag2;
        int k1;
        arraylist = new ArrayList();
        k1 = as.length;
        j = 0;
        flag = false;
        flag2 = false;
        j1 = 0;
        i1 = 0;
_L7:
        if (j >= k1) goto _L2; else goto _L1
_L1:
        String s2 = as[j];
        if (!s2.contains("flyerdb.coupons.")) goto _L4; else goto _L3
_L3:
        boolean flag1;
        int k;
        int l;
        l = 1;
        k = j1;
        flag1 = flag2;
_L6:
        if (!s2.startsWith("flyerdb.coupons.*"))
        {
            break; /* Loop/switch isn't completed */
        }
        String as2[] = c;
        j1 = as2.length;
        for (i1 = 0; i1 < j1; i1++)
        {
            arraylist.add(String.format(s2.replace("*", as2[i1]), new Object[0]));
        }

        break MISSING_BLOCK_LABEL_286;
_L4:
        if (s2.contains("flyerdb.flyers"))
        {
            k = 1;
            flag1 = flag2;
            l = i1;
        } else
        if (s2.contains("user_coupon_data."))
        {
            flag1 = true;
            k = j1;
            l = i1;
        } else
        {
            flag1 = flag2;
            k = j1;
            l = i1;
            if (s2.contains("clipped_items."))
            {
                flag = true;
                flag1 = flag2;
                k = j1;
                l = i1;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (s2.startsWith("user_coupon_data.*"))
        {
            String as3[] = d;
            j1 = as3.length;
            for (i1 = 0; i1 < j1; i1++)
            {
                arraylist.add(String.format(s2.replace("*", as3[i1]), new Object[0]));
            }

        } else
        {
            arraylist.add(s2);
        }
        j++;
        flag2 = flag1;
        j1 = k;
        i1 = l;
          goto _L7
_L2:
        Object obj;
        if (i1 != 0)
        {
            as = (new StringBuilder()).append("flyerdb.flyer_item_coupons").append(" INNER JOIN flyerdb.coupons ON flyerdb.flyer_item_coupons.coupon_id = flyerdb.coupons._id").toString();
        } else
        {
            as = "flyerdb.flyer_item_coupons";
        }
        if (j1 != 0)
        {
            as = (new StringBuilder()).append(as).append(" INNER JOIN flyerdb.flyers ON flyerdb.flyer_item_coupons.flyer_id = flyerdb.flyers._id").toString();
        }
        if (flag2)
        {
            as = (new StringBuilder()).append(as).append(" LEFT JOIN user_coupon_data ON flyerdb.flyer_item_coupons.coupon_id = user_coupon_data._id").toString();
        }
        obj = as;
        if (flag)
        {
            obj = (new StringBuilder()).append(as).append(" LEFT JOIN clipped_items ON flyerdb.flyer_item_coupons.flyer_item_id = clipped_items._id").toString();
        }
        as = new SQLiteQueryBuilder();
        as.setTables(((String) (obj)));
        return as.query(a, (String[])arraylist.toArray(new String[arraylist.size()]), s, as1, null, null, s1);
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist)
    {
        ContentProviderResult acontentproviderresult[];
        Object obj;
        int j;
        int k;
        a.beginTransaction();
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
        a.setTransactionSuccessful();
        a.endTransaction();
        arraylist = getContext().getContentResolver();
        for (obj = ((HashSet) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.notifyChange((Uri)((Iterator) (obj)).next(), null)) { }
        break MISSING_BLOCK_LABEL_151;
        arraylist;
        a.endTransaction();
        getContext().getContentResolver();
        throw arraylist;
        return acontentproviderresult;
    }

    public int delete(Uri uri, String s, String as[])
    {
        Context context = getContext();
        if (context != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L16:
        return k;
_L2:
        e.match(uri);
        JVM INSTR tableswitch 1 13: default 92
    //                   1 117
    //                   2 166
    //                   3 183
    //                   4 199
    //                   5 215
    //                   6 231
    //                   7 247
    //                   8 264
    //                   9 281
    //                   10 292
    //                   11 92
    //                   12 292
    //                   13 303;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L3 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_303;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L4:
        int j = a.delete("favorite_merchants", s, as);
_L17:
        k = j;
        if (j > 0)
        {
            k = j;
            if (!a.inTransaction())
            {
                context.getContentResolver().notifyChange(uri, null);
                return j;
            }
        }
        if (true) goto _L16; else goto _L15
_L15:
        j = a.delete("clipped_items", s, as);
          goto _L17
_L6:
        j = a.delete("read_flyers", s, as);
          goto _L17
_L7:
        j = a.delete("sent_analytics", s, as);
          goto _L17
_L8:
        j = a.delete("shopping_lists", s, as);
          goto _L17
_L9:
        j = a.delete("shopping_list_items", s, as);
          goto _L17
_L10:
        j = a.delete("shopping_list_categories", s, as);
          goto _L17
_L11:
        j = a.delete("shopping_list_cat_order", s, as);
          goto _L17
_L12:
        j = a(s, as);
          goto _L17
_L13:
        throw new IllegalAccessError("Delete on associations_query URI is not supported");
        j = a.delete("user_coupon_data", s, as);
          goto _L17
    }

    public String getType(Uri uri)
    {
        return "vnd.android.cursor.dir/vnd.flipp.flyer";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        Context context = getContext();
        if (context != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        switch (e.match(uri))
        {
        case 11: // '\013'
        default:
            throw new IllegalArgumentException((new StringBuilder("unsupported uri: ")).append(uri).toString());

        case 1: // '\001'
            uri = Long.valueOf(a.insertWithOnConflict("favorite_merchants", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(com.wishabi.flipp.content.i.f, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 2: // '\002'
            uri = Long.valueOf(a.insertWithOnConflict("clipped_items", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.g, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 3: // '\003'
            uri = Long.valueOf(a.insertWithOnConflict("read_flyers", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.h, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 4: // '\004'
            uri = Long.valueOf(a.insertWithOnConflict("sent_analytics", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.i, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 5: // '\005'
            uri = Long.valueOf(a.insertWithOnConflict("shopping_lists", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.j, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 6: // '\006'
            uri = Long.valueOf(a.insertWithOnConflict("shopping_list_items", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.k, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 7: // '\007'
            uri = Long.valueOf(a.insertWithOnConflict("shopping_list_categories", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.l, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 8: // '\b'
            uri = Long.valueOf(a.insertWithOnConflict("shopping_list_cat_order", null, contentvalues, 5));
            if (uri.longValue() != -1L)
            {
                uri = ContentUris.withAppendedId(i.m, uri.longValue());
                if (!a.inTransaction())
                {
                    context.getContentResolver().notifyChange(uri, null);
                }
                return uri;
            }
            break;

        case 9: // '\t'
            throw new IllegalAccessError("Insert on the coupons_query URI is not supported");

        case 10: // '\n'
        case 12: // '\f'
            throw new IllegalAccessError("Insert on associations_query URI is not supported");

        case 13: // '\r'
            uri = Long.valueOf(a.insertWithOnConflict("user_coupon_data", null, contentvalues, 5));
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (uri.longValue() == -1L) goto _L1; else goto _L4
_L4:
        uri = ContentUris.withAppendedId(i.t, uri.longValue());
        if (!a.inTransaction())
        {
            context.getContentResolver().notifyChange(uri, null);
        }
        return uri;
    }

    public boolean onCreate()
    {
        a = (new bj(getContext())).getWritableDatabase();
        Object obj = getContext().getDatabasePath("flyers.db").getPath();
        a.execSQL("attach database ? as flyerdb", new String[] {
            obj
        });
        obj = a.query("coupons", null, null, null, null, null, null);
        c = ((Cursor) (obj)).getColumnNames();
        ((Cursor) (obj)).close();
        obj = a.query("user_coupon_data", null, null, null, null, null, null);
        d = ((Cursor) (obj)).getColumnNames();
        ((Cursor) (obj)).close();
        b = new Handler();
        obj = getContext().getContentResolver();
        if (obj != null)
        {
            Object obj1 = new bg(this, b);
            ((ContentResolver) (obj)).registerContentObserver(i.n, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.t, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.p, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.g, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.o, true, ((android.database.ContentObserver) (obj1)));
            obj1 = new bh(this, b);
            ((ContentResolver) (obj)).registerContentObserver(i.n, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.p, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.t, true, ((android.database.ContentObserver) (obj1)));
            obj1 = new bi(this, b);
            ((ContentResolver) (obj)).registerContentObserver(i.p, true, ((android.database.ContentObserver) (obj1)));
            ((ContentResolver) (obj)).registerContentObserver(i.g, true, ((android.database.ContentObserver) (obj1)));
        }
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        Context context;
        context = getContext();
        if (context == null)
        {
            return null;
        }
        e.match(uri);
        JVM INSTR tableswitch 1 13: default 88
    //                   1 113
    //                   2 145
    //                   3 167
    //                   4 188
    //                   5 209
    //                   6 230
    //                   7 461
    //                   8 483
    //                   9 505
    //                   10 519
    //                   11 88
    //                   12 519
    //                   13 533;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L1 _L11 _L12
_L1:
        throw new IllegalArgumentException((new StringBuilder("unsupported uri: ")).append(uri).toString());
_L2:
        as = a.query("favorite_merchants", as, s, as1, null, null, s1);
_L14:
        as.setNotificationUri(context.getContentResolver(), uri);
        return as;
_L3:
        as = a.query("clipped_items", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L4:
        as = a.query("read_flyers", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L5:
        as = a.query("sent_analytics", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L6:
        as = a.query("shopping_lists", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L7:
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        boolean flag = false;
        boolean flag1 = false;
        String as2[] = new String[as.length];
        int j = 0;
        while (j < as.length) 
        {
            if (as[j].equals("category"))
            {
                as2[j] = "IFNULL(c.category, 'Other') AS category";
                flag = true;
            } else
            if (as[j].equals("cat_position"))
            {
                as2[j] = String.format("IFNULL(co.position, %d) AS cat_position", new Object[] {
                    Integer.valueOf(1000)
                });
                flag1 = true;
            } else
            {
                as2[j] = (new StringBuilder("i.")).append(as[j]).toString();
            }
            j++;
        }
        as = "shopping_list_items i";
        if (flag || flag1)
        {
            as = (new StringBuilder()).append("shopping_list_items i").append(" LEFT JOIN shopping_list_categories c ON LOWER(i.name) = c.item_name").toString();
        }
        Object obj = as;
        if (flag1)
        {
            obj = (new StringBuilder()).append(as).append(" LEFT JOIN shopping_list_cat_order co ON c.category = co.category").toString();
        }
        sqlitequerybuilder.setTables(((String) (obj)));
        as = sqlitequerybuilder.query(a, as2, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L8:
        as = a.query("shopping_list_categories", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L9:
        as = a.query("shopping_list_cat_order", as, s, as1, null, null, s1);
        continue; /* Loop/switch isn't completed */
_L10:
        as = a(as, s, as1, s1);
        continue; /* Loop/switch isn't completed */
_L11:
        as = b(as, s, as1, s1);
        continue; /* Loop/switch isn't completed */
_L12:
        as = a.query("user_coupon_data", as, s, as1, null, null, s1);
        if (true) goto _L14; else goto _L13
_L13:
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        Context context = getContext();
        if (context != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L16:
        return k;
_L2:
        e.match(uri);
        JVM INSTR tableswitch 1 13: default 92
    //                   1 117
    //                   2 168
    //                   3 187
    //                   4 205
    //                   5 223
    //                   6 241
    //                   7 259
    //                   8 278
    //                   9 297
    //                   10 308
    //                   11 92
    //                   12 308
    //                   13 319;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L3 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_319;
_L5:
        break; /* Loop/switch isn't completed */
_L3:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L4:
        int j = a.update("favorite_merchants", contentvalues, s, as);
_L17:
        k = j;
        if (j > 0)
        {
            k = j;
            if (!a.inTransaction())
            {
                context.getContentResolver().notifyChange(uri, null);
                return j;
            }
        }
        if (true) goto _L16; else goto _L15
_L15:
        j = a.update("clipped_items", contentvalues, s, as);
          goto _L17
_L6:
        j = a.update("read_flyers", contentvalues, s, as);
          goto _L17
_L7:
        j = a.update("sent_analytics", contentvalues, s, as);
          goto _L17
_L8:
        j = a.update("shopping_lists", contentvalues, s, as);
          goto _L17
_L9:
        j = a.update("shopping_list_items", contentvalues, s, as);
          goto _L17
_L10:
        j = a.update("shopping_list_categories", contentvalues, s, as);
          goto _L17
_L11:
        j = a.update("shopping_list_cat_order", contentvalues, s, as);
          goto _L17
_L12:
        throw new IllegalAccessError("Insert on the coupons_query URI is not supported");
_L13:
        throw new IllegalAccessError("Insert on associations_query URI is not supported");
        j = a.update("user_coupon_data", contentvalues, s, as);
          goto _L17
    }

    static 
    {
        UriMatcher urimatcher = new UriMatcher(-1);
        e = urimatcher;
        urimatcher.addURI("com.wishabi.flipp.models.User", "favorite_merchants", 1);
        e.addURI("com.wishabi.flipp.models.User", "clippings", 2);
        e.addURI("com.wishabi.flipp.models.User", "read_flyers", 3);
        e.addURI("com.wishabi.flipp.models.User", "sent_analytics", 4);
        e.addURI("com.wishabi.flipp.models.User", "shopping_lists", 5);
        e.addURI("com.wishabi.flipp.models.User", "shopping_list_items", 6);
        e.addURI("com.wishabi.flipp.models.User", "shopping_list_items/categories", 7);
        e.addURI("com.wishabi.flipp.models.User", "shopping_list_items/cat_order", 8);
        e.addURI("com.wishabi.flipp.models.User", "coupons_query", 9);
        e.addURI("com.wishabi.flipp.models.User", "coupons_for_items", 10);
        e.addURI("com.wishabi.flipp.models.User", "items_for_coupons", 12);
        e.addURI("com.wishabi.flipp.models.User", "user_coupon_data", 13);
    }
}
