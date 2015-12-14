// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.DocumentProperties;
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
        if (nodeextended.getContentProperties() != null && nodeextended.getContentProperties().getDocument() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((set = nodeextended.getContentProperties().getDocument().getAuthors()) != null && !set.isEmpty())
        {
            set = set.iterator();
            while (set.hasNext()) 
            {
                String s = (String)set.next();
                CloudMetadataStore.bindValue(mInsertStatement, 1, Long.valueOf(l));
                CloudMetadataStore.bindValue(mInsertStatement, 2, nodeextended.getId());
                CloudMetadataStore.bindValue(mInsertStatement, 3, s);
                mInsertStatement.execute();
                mInsertStatement.clearBindings();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private (SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO document_authors(event_id, node_id, author) VALUES (?, ?, ?);");
        mContentUri = com.amazon.mixtape.provider.ContentUri(s, s1);
    }

    mContentUri(SQLiteDatabase sqlitedatabase, String s, String s1, mContentUri mcontenturi)
    {
        this(sqlitedatabase, s, s1);
    }
}
