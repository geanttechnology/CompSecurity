// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.amazon.clouddrive.extended.model.NodeExtended;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore

private static class <init>
    implements Closeable
{

    private final Uri mContentUri;
    private final SQLiteStatement mInsertStatement;

    public void close()
    {
        mInsertStatement.close();
    }

    void insert(long l, NodeExtended nodeextended, Set set)
    {
        set.add(mContentUri);
        if (nodeextended.getLabels() != null && !nodeextended.getLabels().isEmpty())
        {
            set = nodeextended.getLabels().iterator();
            while (set.hasNext()) 
            {
                String s = (String)set.next();
                mInsertStatement.bindLong(1, l);
                mInsertStatement.bindString(2, nodeextended.getId());
                mInsertStatement.bindString(3, s);
                mInsertStatement.executeInsert();
                mInsertStatement.clearBindings();
            }
        }
    }

    private (SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_labels (event_id, node_id, label) VALUES (?, ?, ?);");
        mContentUri = com.amazon.mixtape.provider.ContentUri(s, s1);
    }

    mContentUri(SQLiteDatabase sqlitedatabase, String s, String s1, mContentUri mcontenturi)
    {
        this(sqlitedatabase, s, s1);
    }
}
