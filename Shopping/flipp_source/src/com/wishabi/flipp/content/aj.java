// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.wishabi.flipp.app.FlippApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.content:
//            i, al, ak

public class aj
{

    static final String a = com/wishabi/flipp/content/aj.getSimpleName();
    public static final Uri b = Uri.parse("content://com.wishabi.flipp.content.SearchTerm/history");
    public static final Uri c = Uri.parse("content://com.wishabi.flipp.content.SearchTerm/item");
    public static final Uri d = Uri.parse("content://com.wishabi.flipp.content.SearchTerm/merchant");
    public static final String e[] = {
        "0 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837693 AS suggest_icon_1"
    };
    public static final String f[] = {
        "1 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837693 AS suggest_icon_1"
    };
    public static final String g[] = {
        "2 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837696 AS suggest_icon_1"
    };
    public static final String h[] = {
        "3 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837696 AS suggest_icon_1"
    };
    public static final String i[] = {
        "4 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837668 AS suggest_icon_1"
    };
    public static final String j[] = {
        "5 AS type", "_id", "word AS suggest_text_1", "word AS suggest_intent_query", "2130837668 AS suggest_icon_1"
    };

    public aj()
    {
    }

    public static List a()
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = FlippApplication.b().getContentResolver().query(i.a, new String[] {
            "DISTINCT merchant, premium"
        }, null, null, null);
        if (obj1 != null && ((Cursor) (obj1)).getCount() != 0) goto _L2; else goto _L1
_L1:
        Log.d(a, "Merchant name cursor is empty");
_L4:
        return ((List) (obj));
_L2:
        if (((Cursor) (obj1)).isClosed())
        {
            Log.d(a, "Merchant name cursor is closed");
            return null;
        }
        obj = new ArrayList();
        ((Cursor) (obj1)).moveToFirst();
        while (!((Cursor) (obj1)).isAfterLast()) 
        {
            String s = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("merchant"));
            boolean flag;
            if (((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndex("premium")) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((List) (obj)).add(new al(s, flag));
            ((Cursor) (obj1)).moveToNext();
        }
        ((Cursor) (obj1)).close();
        Collections.sort(((List) (obj)), new ak());
        obj1 = new ArrayList();
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = obj1;
            if (!iterator.hasNext())
            {
                continue;
            }
            ((List) (obj1)).add(((al)iterator.next()).a);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List a(int k)
    {
        return a(k, false);
    }

    public static List a(int k, boolean flag)
    {
        Object obj = FlippApplication.b();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        InputStream inputstream;
        BufferedReader bufferedreader;
        inputstream = ((Context) (obj)).getResources().openRawResource(k);
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        obj = new ArrayList();
_L3:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((List) (obj)).add(s);
          goto _L3
        IOException ioexception1;
        ioexception1;
        ioexception1.printStackTrace();
        if (((List) (obj)).size() <= 0) goto _L1; else goto _L4
_L4:
        if (flag)
        {
            Collections.reverse(((List) (obj)));
        }
        try
        {
            bufferedreader.close();
            inputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        return ((List) (obj));
    }

    private static void a(ContentResolver contentresolver, int k)
    {
        String s;
        s = null;
        if (k < 0)
        {
            throw new IllegalArgumentException();
        }
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        s = (new StringBuilder("_id IN (SELECT _id FROM history ORDER BY date DESC LIMIT -1 OFFSET ")).append(String.valueOf(k)).append(")").toString();
        contentresolver.delete(b, s, null);
        return;
        contentresolver;
        Log.e(a, "truncateHistory", contentresolver);
        return;
    }

    public static void a(Context context)
    {
        a(context.getContentResolver(), 0);
    }

    public static void a(Context context, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("word", s);
            contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
            context = context.getContentResolver();
            context.insert(b, contentvalues);
            a(((ContentResolver) (context)), 100);
            return;
        }
    }

}
