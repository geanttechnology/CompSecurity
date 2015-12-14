// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            LocalStateDao

static final class  extends SQLiteOpenHelper
{

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        GLogger.d(LocalStateDao.access$000(), "Created localstate Table", new Object[0]);
        sqlitedatabase.execSQL("CREATE TABLE localstate (key TEXT PRIMARY KEY, value INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        GLogger.d(LocalStateDao.access$000(), (new StringBuilder()).append("Upgrading localstate from version ").append(i).append(" to ").append(j).toString(), new Object[0]);
        sqlitedatabase.execSQL("DROP TABLE localstate;");
        onCreate(sqlitedatabase);
    }

    public (Context context)
    {
        super(context, "localstate.db", null, 1);
    }
}
