// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.amazon.mixtape.database.MixtapeMetricsDatabaseHelper;

// Referenced classes of package com.amazon.mixtape.provider:
//            UnknownUriException

public class MixtapeMetricsProvider extends ContentProvider
{

    private String mAuthority;
    private SQLiteDatabase mDatabase;
    private UriMatcher mUriMatcher;

    public MixtapeMetricsProvider()
    {
    }

    private SQLiteDatabase getDatabase()
    {
        this;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (mDatabase == null)
        {
            mDatabase = (new MixtapeMetricsDatabaseHelper(getContext())).getWritableDatabase();
        }
        sqlitedatabase = mDatabase;
        this;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    private String getGroupByClause(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2: // '\002'
            return "event_name, is_error";
        }
    }

    private void initializeUriMatcher()
    {
        mUriMatcher = new UriMatcher(-1);
        mUriMatcher.addURI(mAuthority, "metrics", 1);
        mUriMatcher.addURI(mAuthority, "metrics_agg", 2);
    }

    private String uriMatchToTableName(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return "metrics";
        }
    }

    public void attachInfo(Context context, ProviderInfo providerinfo)
    {
        mAuthority = providerinfo.authority;
        initializeUriMatcher();
        super.attachInfo(context, providerinfo);
    }

    public int delete(Uri uri, String s, String as[])
    {
        String s1 = uriMatchToTableName(mUriMatcher.match(uri));
        if (s1 == null)
        {
            throw new UnknownUriException(uri);
        }
        int i = getDatabase().delete(s1, s, as);
        if (i > 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return i;
    }

    public String getType(Uri uri)
    {
        switch (mUriMatcher.match(uri))
        {
        default:
            return null;

        case 1: // '\001'
            return "vnd.android.cursor.dir/metrics";

        case 2: // '\002'
            return "vnd.android.cursor.dir/metrics_agg";
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        String s = uriMatchToTableName(mUriMatcher.match(uri));
        if (s == null)
        {
            throw new UnknownUriException(uri);
        }
        if (getDatabase().insertOrThrow(s, null, contentvalues) >= 0L)
        {
            getContext().getContentResolver().notifyChange(uri, null);
            return uri;
        } else
        {
            throw new SQLException((new StringBuilder()).append("Failed to insert row into ").append(uri).toString());
        }
    }

    public boolean onCreate()
    {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        int i = mUriMatcher.match(uri);
        String s2 = uriMatchToTableName(i);
        if (s2 == null)
        {
            throw new UnknownUriException(uri);
        } else
        {
            SQLiteDatabase sqlitedatabase = getDatabase();
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables(s2);
            as = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, getGroupByClause(i), null, s1);
            as.setNotificationUri(getContext().getContentResolver(), uri);
            return as;
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        String s1 = uriMatchToTableName(mUriMatcher.match(uri));
        if (s1 == null)
        {
            throw new UnknownUriException(uri);
        }
        int i = getDatabase().update(s1, contentvalues, s, as);
        if (i > 0)
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return i;
    }
}
