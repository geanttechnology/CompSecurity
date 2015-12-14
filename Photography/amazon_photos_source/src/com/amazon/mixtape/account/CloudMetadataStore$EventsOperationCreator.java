// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.amazon.clouddrive.extended.model.NodeExtended;
import java.io.Closeable;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore

private static class <init>
    implements Closeable
{

    private final SQLiteStatement mInsertStatement;

    public void close()
    {
        mInsertStatement.close();
    }

    public long insert(NodeExtended nodeextended)
    {
        long l;
        CloudMetadataStore.bindValue(mInsertStatement, 1, nodeextended.getId());
        CloudMetadataStore.bindValue(mInsertStatement, 2, CloudMetadataStore.access$1500(nodeextended));
        l = mInsertStatement.executeInsert();
        mInsertStatement.clearBindings();
        return l;
        nodeextended;
        mInsertStatement.clearBindings();
        throw nodeextended;
    }

    private (SQLiteDatabase sqlitedatabase)
    {
        mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO events (changed_object_id, change_type) VALUES (?, ?);");
    }

    mInsertStatement(SQLiteDatabase sqlitedatabase, mInsertStatement minsertstatement)
    {
        this(sqlitedatabase);
    }
}
