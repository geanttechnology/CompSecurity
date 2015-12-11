// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryDatabaseHelper, HistoryEntity

public class HistoryContentProvider extends ContentProvider
{
    private class UserSigninSubscriber
        implements UserListener
    {

        private Context mContext;
        final HistoryContentProvider this$0;

        public void userSignedIn(User user)
        {
            try
            {
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("email", user.getFullName());
                mContext.getContentResolver().update(HistoryContentProvider.PRODUCT_URI, contentvalues, "email=?", new String[] {
                    ""
                });
                mContext.getContentResolver().update(HistoryContentProvider.VISUAL_SEARCH_URI, contentvalues, "email=?", new String[] {
                    ""
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (User user)
            {
                Log.i(HistoryContentProvider.TAG, user.getMessage());
            }
        }

        public void userSignedOut()
        {
        }

        public void userUpdated(User user)
        {
        }

        UserSigninSubscriber(Context context)
        {
            this$0 = HistoryContentProvider.this;
            super();
            mContext = context;
        }
    }


    public static final Uri PRODUCT_URI = Uri.parse("content://com.amazon.mShop.history.HistoryContentProvider/product-history/");
    private static final String TAG = com/amazon/mShop/history/HistoryContentProvider.getSimpleName();
    public static final Uri VISUAL_SEARCH_URI = Uri.parse("content://com.amazon.mShop.history.HistoryContentProvider/visual-search-history/");
    private static final UriMatcher sUriMatcher;
    private static UserSigninSubscriber sUserListener = null;
    private HistoryDatabaseHelper mDatabaseHelper;

    public HistoryContentProvider()
    {
    }

    private int deleteItemsInNecessary(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        sqlitedatabase = mDatabaseHelper.getReadableDatabase();
        i = 0;
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 1 3: default 44
    //                   1 58
    //                   2 44
    //                   3 73;
           goto _L1 _L2 _L1 _L3
_L1:
        s = null;
_L5:
        int j;
        j = 0;
        if (Util.isEmpty(s))
        {
            return 0;
        }
        break; /* Loop/switch isn't completed */
_L2:
        i = 100;
        s = getAppendedSelection("product", s);
        continue; /* Loop/switch isn't completed */
_L3:
        i = 100;
        s = getAppendedSelection("vision", s);
        if (true) goto _L5; else goto _L4
_L4:
        String s1;
        String as1[];
        s1 = (new StringBuilder()).append("select * from history where ").append(s).append(" order by ").append("visit_date").append(" DESC limit -1 offset ").append(i).toString();
        Object obj = null;
        s = null;
        as1 = getAppendedSelectionArgs(as);
        i = j;
        as = obj;
        Cursor cursor = sqlitedatabase.rawQuery(s1, as1);
        s = cursor;
        i = j;
        as = cursor;
        j = cursor.getCount();
_L7:
        s = cursor;
        i = j;
        as = cursor;
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = cursor;
        i = j;
        as = cursor;
        delete(uri, (new StringBuilder()).append("_id=").append(cursor.getInt(cursor.getColumnIndex("_id"))).toString(), null);
        if (true) goto _L7; else goto _L6
        uri;
        as = s;
        Log.d(TAG, uri.getMessage(), uri);
        int k;
        k = i;
        if (s != null)
        {
            s.close();
            k = i;
        }
_L9:
        return k;
_L6:
        k = j;
        if (cursor != null)
        {
            cursor.close();
            k = j;
        }
        if (true) goto _L9; else goto _L8
_L8:
        uri;
        if (as != null)
        {
            as.close();
        }
        throw uri;
    }

    private String getAppendedSelection(String s, String s1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("type=\"").append(s).append("\" AND (").append("email").append("=?").append(") AND ").append("locale").append("=\"").append(getCurrentLocaleName()).append("\"");
        if (!TextUtils.isEmpty(s1))
        {
            s = (new StringBuilder()).append(" AND (").append(s1).append(')').toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    private String[] getAppendedSelectionArgs(String as[])
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(getUserIdentity());
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                arraylist.add(as[i]);
            }

        }
        return (String[])(String[])arraylist.toArray(new String[0]);
    }

    private String getCurrentLocaleName()
    {
        String s1 = AppLocale.getInstance().getCurrentLocaleName();
        String s = s1;
        if (AppLocale.isLocaleOfCA(s1))
        {
            s = "en_CA";
        }
        return s;
    }

    private static final String getUserIdentity()
    {
        if (User.isLoggedIn())
        {
            return User.getUser().getFullName();
        } else
        {
            return "";
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = mDatabaseHelper.getWritableDatabase();
        as = getAppendedSelectionArgs(as);
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 1 3: default 48
    //                   1 75
    //                   2 48
    //                   3 110;
           goto _L1 _L2 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI ").append(uri).toString());
_L2:
        int i = sqlitedatabase.delete("history", getAppendedSelection("product", s), as);
_L5:
        getContext().getContentResolver().notifyChange(PRODUCT_URI, null);
        return i;
_L3:
        i = sqlitedatabase.delete("history", getAppendedSelection("vision", s), as);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        ContentValues contentvalues1;
        int i = sUriMatcher.match(uri);
        if (contentvalues != null)
        {
            contentvalues1 = contentvalues;
        } else
        {
            contentvalues1 = new ContentValues();
        }
        i;
        JVM INSTR tableswitch 1 3: default 44
    //                   1 83
    //                   2 44
    //                   3 138;
           goto _L1 _L2 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI:").append(uri).toString());
_L2:
        contentvalues1.put("type", "product");
_L5:
        long l = System.currentTimeMillis();
        if (!contentvalues1.containsKey("visit_date"))
        {
            contentvalues1.put("visit_date", Long.valueOf(l));
        }
        if (!contentvalues1.containsKey("asin"))
        {
            throw new IllegalArgumentException("ASIN value is missed");
        }
        break; /* Loop/switch isn't completed */
_L3:
        contentvalues1.put("type", "vision");
        if (true) goto _L5; else goto _L4
_L4:
        Uri uri1;
        Cursor cursor;
        contentvalues1.put("email", getUserIdentity());
        uri1 = null;
        cursor = query(uri, HistoryEntity.HISTORY_PROJECTION, "asin=?", new String[] {
            contentvalues1.getAsString("asin")
        }, null);
        contentvalues = uri1;
        if (cursor.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        contentvalues = uri1;
        contentvalues1.remove("asin");
        contentvalues = uri1;
        contentvalues1.remove("type");
        contentvalues = uri1;
        cursor.moveToFirst();
        contentvalues = uri1;
        uri1 = ContentUris.withAppendedId(uri, cursor.getLong(cursor.getColumnIndex("_id")));
        Uri uri2;
        contentvalues = uri1;
        uri2 = uri1;
        if (update(uri1, contentvalues1, null, null) > 0)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        contentvalues = uri1;
        long l1;
        try
        {
            throw new SQLException((new StringBuilder()).append("Failed to update existed row ").append(uri).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri) { }
        finally
        {
            cursor.close();
        }
        Log.e(TAG, uri.getMessage(), uri);
        cursor.close();
        return contentvalues;
        contentvalues = uri1;
        contentvalues1.put("locale", getCurrentLocaleName());
        contentvalues = uri1;
        l1 = mDatabaseHelper.getWritableDatabase().insert("history", null, contentvalues1);
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        contentvalues = uri1;
        deleteItemsInNecessary(uri, null, null);
        contentvalues = uri1;
        uri2 = ContentUris.withAppendedId(PRODUCT_URI, l1);
        contentvalues = uri2;
        getContext().getContentResolver().notifyChange(PRODUCT_URI, null);
        cursor.close();
        return uri2;
        contentvalues = uri1;
        throw new SQLException((new StringBuilder()).append("Failed to insert row into ").append(uri).toString());
        throw uri;
    }

    public boolean onCreate()
    {
        mDatabaseHelper = new HistoryDatabaseHelper(getContext());
        if (sUserListener == null)
        {
            sUserListener = new UserSigninSubscriber(getContext().getApplicationContext());
            User.addUserListener(sUserListener);
        }
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        int i = sUriMatcher.match(uri);
        SQLiteDatabase sqlitedatabase = mDatabaseHelper.getReadableDatabase();
        as1 = getAppendedSelectionArgs(as1);
        switch (i)
        {
        case 2: // '\002'
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI:").append(uri).toString());

        case 1: // '\001'
            return sqlitedatabase.query("history", as, getAppendedSelection("product", s), as1, null, null, s1);

        case 3: // '\003'
            return sqlitedatabase.query("history", as, getAppendedSelection("vision", s), as1, null, null, s1);
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mDatabaseHelper.getWritableDatabase();
        sUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 48
    //                   1 189
    //                   2 75
    //                   3 213
    //                   4 75;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI ").append(uri).toString());
_L3:
        s = (new StringBuilder()).append("_id=").append((String)uri.getPathSegments().get(1)).toString();
_L6:
        int i = sqlitedatabase.update("history", contentvalues, (new StringBuilder()).append(s).append(" AND ").append("locale").append("=\"").append(AppLocale.getInstance().getCurrentLocaleName()).append("\"").toString(), as);
        deleteItemsInNecessary(uri, null, null);
        getContext().getContentResolver().notifyChange(PRODUCT_URI, null);
        return i;
_L2:
        s = (new StringBuilder()).append(s).append(" AND type=\"product\"").toString();
        continue; /* Loop/switch isn't completed */
_L4:
        s = (new StringBuilder()).append(s).append(" AND type=\"vision\"").toString();
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI("com.amazon.mShop.history.HistoryContentProvider", "product-history/", 1);
        sUriMatcher.addURI("com.amazon.mShop.history.HistoryContentProvider", "product-history/#", 2);
        sUriMatcher.addURI("com.amazon.mShop.history.HistoryContentProvider", "visual-search-history/", 3);
        sUriMatcher.addURI("com.amazon.mShop.history.HistoryContentProvider", "visual-search-history/#", 4);
    }

}
