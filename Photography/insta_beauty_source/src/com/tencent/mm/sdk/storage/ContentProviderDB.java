// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.storage:
//            ISQLiteDatabase

public abstract class ContentProviderDB
    implements ISQLiteDatabase
{

    private final Context R;

    public ContentProviderDB(Context context)
    {
        R = context;
    }

    public int delete(String s, String s1, String as[])
    {
        Uri uri = getUriFromTable(s);
        if (uri == null)
        {
            Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("get uri from table failed, table=")).append(s).toString());
            return 0;
        } else
        {
            return R.getContentResolver().delete(uri, s1, as);
        }
    }

    public boolean execSQL(String s, String s1)
    {
        Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("do not support, execSQL sql=")).append(s1).toString());
        return false;
    }

    public abstract Uri getUriFromTable(String s);

    public long insert(String s, String s1, ContentValues contentvalues)
    {
        s1 = getUriFromTable(s);
        if (s1 == null)
        {
            Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("get uri from table failed, table=")).append(s).toString());
            return -1L;
        } else
        {
            return ContentUris.parseId(R.getContentResolver().insert(s1, contentvalues));
        }
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        s2 = getUriFromTable(s);
        if (s2 == null)
        {
            Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("get uri from table failed, table=")).append(s).toString());
            s = new MatrixCursor(as);
        } else
        {
            s1 = R.getContentResolver().query(s2, as, s1, as1, s4);
            s = s1;
            if (s1 == null)
            {
                return new MatrixCursor(as);
            }
        }
        return s;
    }

    public Cursor rawQuery(String s, String as[])
    {
        Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("do not support, rawQuery sql=")).append(s).toString());
        return null;
    }

    public long replace(String s, String s1, ContentValues contentvalues)
    {
        Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("do not support, replace table=")).append(s).toString());
        return 0L;
    }

    public int update(String s, ContentValues contentvalues, String s1, String as[])
    {
        Uri uri = getUriFromTable(s);
        if (uri == null)
        {
            Log.e("MicroMsg.SDK.MContentProviderDB", (new StringBuilder("get uri from table failed, table=")).append(s).toString());
            return 0;
        } else
        {
            return R.getContentResolver().update(uri, contentvalues, s1, as);
        }
    }
}
