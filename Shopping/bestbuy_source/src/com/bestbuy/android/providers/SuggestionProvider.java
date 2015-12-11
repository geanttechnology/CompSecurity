// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.providers;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.bestbuy.android.activities.home.HomeActivity;
import fs;
import ft;
import java.util.ArrayList;
import java.util.List;
import mz;
import nb;

public class SuggestionProvider extends SearchRecentSuggestionsProvider
{

    private static Uri a = Uri.parse("content://com.bestbuy.android.SuggestionProvider/suggestions");
    private static Uri b = Uri.parse("content://com.bestbuy.android.SuggestionProvider/storesearchsuggestions");
    private static Uri c = Uri.parse("content://com.bestbuy.android.SuggestionProvider/listidsearchsuggestions");
    private static Uri d = Uri.parse("content://com.bestbuy.android.SuggestionProvider/dnmsearchsuggestions");
    private static final String f[] = {
        "_id", "suggest_text_1", "suggest_intent_data"
    };
    private ArrayList e;

    public SuggestionProvider()
    {
        setupSuggestions("com.bestbuy.android.SuggestionProvider", 1);
    }

    public static void a(SQLiteDatabase sqlitedatabase)
    {
        b(sqlitedatabase);
    }

    private static void b(SQLiteDatabase sqlitedatabase)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("display1", "Product Scan");
        contentvalues.put("query", "ProductScan");
        contentvalues.put("icon", "android.resource://com.bestbuy.android/2130837857");
        contentvalues.put("date", "9999999999999");
        if (((String)a.getPathSegments().get(0)).equals("suggestions"))
        {
            sqlitedatabase.insert("suggestions", "query", contentvalues);
        }
    }

    public void a(Context context, String s)
    {
        if (s.compareToIgnoreCase("ProductScan") == 0) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        context = (new mz(context, 513)).getReadableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("display1", s);
        contentvalues.put("query", s);
        contentvalues.put("icon", "android.resource://com.bestbuy.android/2130837884");
        contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
        s = nb.a();
        if (!HomeActivity.inStoresFragment) goto _L4; else goto _L3
_L3:
        if (((String)b.getPathSegments().get(0)).equals("storesearchsuggestions"))
        {
            context.insert("storesearchsuggestions", "query", contentvalues);
        }
_L2:
        return;
_L4:
        if (!s.Q())
        {
            break; /* Loop/switch isn't completed */
        }
        if (((String)d.getPathSegments().get(0)).equals("dnmsearchsuggestions"))
        {
            context.insert("dnmsearchsuggestions", "query", contentvalues);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (!HomeActivity.inListIdSearchFragment)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((String)d.getPathSegments().get(0)).equals("listidsearchsuggestions")) goto _L2; else goto _L6
_L6:
        context.insert("listidsearchsuggestions", "query", contentvalues);
        return;
        if (!((String)a.getPathSegments().get(0)).equals("suggestions")) goto _L2; else goto _L7
_L7:
        context.insert("suggestions", "query", contentvalues);
        return;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        s = (new mz(getContext(), 513)).getReadableDatabase();
        as = nb.a();
        if (TextUtils.isEmpty(as1[0]))
        {
            if (HomeActivity.inStoresFragment)
            {
                as = "storesearchsuggestions";
            } else
            if (as.Q())
            {
                as = "dnmsearchsuggestions";
            } else
            if (HomeActivity.inListIdSearchFragment)
            {
                as = "listidsearchsuggestions";
            } else
            {
                as = "suggestions";
            }
            as = s.rawQuery((new StringBuilder()).append("SELECT _id, display1 AS suggest_text_1, query AS suggest_intent_query,  icon AS suggest_icon_1 FROM ").append(as).append(" ORDER BY date DESC").toString(), null);
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
        if (HomeActivity.inStoresFragment || as.Q())
        {
            break MISSING_BLOCK_LABEL_377;
        }
        if (as1[0] != null)
        {
            as1[0] = as1[0].trim();
            as1[0] = as1[0].replaceAll("\\s+", " ");
        }
        if (as1[0] == null || as1[0].isEmpty() || as1[0].length() <= 1)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        as = (new String((new StringBuilder()).append("%").append(as1[0]).append("%").toString())).trim();
        if (as.isEmpty() || as.equalsIgnoreCase("% %"))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        as = new MatrixCursor(f);
        e = fs.a(ft.a, as1[0]);
        if (e == null || e.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        if (i >= e.size())
        {
            break; /* Loop/switch isn't completed */
        }
        as.addRow(new String[] {
            Integer.toString(i), (String)e.get(i), (String)e.get(i)
        });
        i++;
        if (true) goto _L3; else goto _L2
        s;
        s.printStackTrace();
_L2:
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
        return null;
    }

}
