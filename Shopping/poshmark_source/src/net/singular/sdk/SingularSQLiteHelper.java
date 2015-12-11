// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

// Referenced classes of package net.singular.sdk:
//            SingularLog, EventStore, KeyValueStore

class SingularSQLiteHelper extends SQLiteOpenHelper
{

    static final int DB_VERSION = 1;
    private final SingularLog log;

    public SingularSQLiteHelper(Context context, SingularLog singularlog)
    {
        super(context, "singular.db", null, 1);
        log = singularlog;
        singularlog.d("singular_sdk", "SingularSQLiteHelper initialization complete!");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        EventStore.onCreate(sqlitedatabase, log);
        KeyValueStore.onCreate(sqlitedatabase, log);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("PRAGMA synchronous=NORMAL;");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "PRAGMA synchronous=NORMAL;");
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        EventStore.onUpgrade(sqlitedatabase, i, j, log);
        KeyValueStore.onUpgrade(sqlitedatabase, i, j, log);
    }
}
