// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import com.amazon.clouddrive.model.Node;
import java.io.Closeable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.account:
//            CloudMetadataStore

class NodePropertiesOperationCreator
    implements Closeable
{

    private final Uri mContentUri;
    private final SQLiteStatement mInsertStatement;

    NodePropertiesOperationCreator(SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        mInsertStatement = sqlitedatabase.compileStatement("INSERT INTO cloud_node_properties(event_id, node_id, owner, key, value) VALUES (?, ?, ?, ?, ?);");
        mContentUri = com.amazon.mixtape.provider.CloudNodesContract.NodeProperties.getContentUri(s, s1);
    }

    public void close()
    {
        mInsertStatement.close();
    }

    void insert(long l, Node node, Set set)
    {
        set.add(mContentUri);
        set = node.getProperties();
        if (set != null && !set.isEmpty() && set.containsKey("AMZClient"))
        {
            set = ((Map)set.get("AMZClient")).entrySet().iterator();
            while (set.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)set.next();
                CloudMetadataStore.bindValue(mInsertStatement, 1, Long.valueOf(l));
                CloudMetadataStore.bindValue(mInsertStatement, 2, node.getId());
                CloudMetadataStore.bindValue(mInsertStatement, 3, "AMZClient");
                CloudMetadataStore.bindValue(mInsertStatement, 4, (String)entry.getKey());
                CloudMetadataStore.bindValue(mInsertStatement, 5, (String)entry.getValue());
                mInsertStatement.executeInsert();
                mInsertStatement.clearBindings();
            }
        }
    }
}
