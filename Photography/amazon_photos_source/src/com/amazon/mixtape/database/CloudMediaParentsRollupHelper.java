// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.database.sqlite.SQLiteDatabase;

public class CloudMediaParentsRollupHelper
{

    public static void updateCloudMediaParents(SQLiteDatabase sqlitedatabase, long l)
    {
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("INSERT OR REPLACE INTO cloud_media_parents(node_id, is_dirty) SELECT DISTINCT parents_with_changed_children.parent_node_id, 1 FROM cloud_nodes AS changed_nodes JOIN cloud_node_parents AS parents_with_changed_children ON changed_nodes.node_id = parents_with_changed_children.node_id WHERE changed_nodes.event_id >= ? UNION SELECT changed_parents.node_id, 1 FROM cloud_nodes as changed_parents WHERE changed_parents.event_id >= ? AND kind NOT IN ('FILE', 'ASSET')", new String[] {
            Long.toString(l), Long.toString(l)
        });
        sqlitedatabase.execSQL("INSERT OR REPLACE INTO cloud_media_parents(node_id, created_by, created_date, description, exclusively_trashed, is_root, is_shared, kind, modified_date, name , recursively_trashed, restricted, status, version, favorite, hidden, metadata_version, sort_date, count, is_dirty) SELECT parent_nodes.node_id, parent_nodes.created_by, parent_nodes.created_date, parent_nodes.description, parent_nodes.exclusively_trashed, parent_nodes.is_root, parent_nodes.is_shared, parent_nodes.kind, parent_nodes.modified_date, parent_nodes.name, parent_nodes.recursively_trashed, parent_nodes.restricted, parent_nodes.status, parent_nodes.version, parent_nodes.favorite, parent_nodes.hidden, parent_nodes.metadata_version, MAX(child_nodes.content_sort_date) sort_date, TOTAL(1) count, 0 FROM cloud_media_parents AS media_parents JOIN cloud_node_parents AS np_relations ON media_parents.node_id = np_relations.parent_node_id JOIN cloud_nodes AS child_nodes ON child_nodes.node_id = np_relations.node_id AND child_nodes.event_id = np_relations.event_id JOIN cloud_nodes AS parent_nodes ON parent_nodes.node_id = media_parents.node_id WHERE media_parents.is_dirty = 1 AND (child_nodes.is_video = 1 OR child_nodes.is_image = 1) AND child_nodes.kind = 'FILE' AND child_nodes.status = 'AVAILABLE' AND child_nodes.hidden = 0 GROUP BY parent_nodes.node_id, parent_nodes.created_by, parent_nodes.created_date, parent_nodes.description, parent_nodes.exclusively_trashed, parent_nodes.is_root, parent_nodes.is_shared, parent_nodes.kind, parent_nodes.modified_date, parent_nodes.name, parent_nodes.recursively_trashed, parent_nodes.restricted, parent_nodes.status, parent_nodes.version, parent_nodes.favorite, parent_nodes.hidden, parent_nodes.metadata_version");
        sqlitedatabase.delete("cloud_media_parents", "count = 0 OR is_dirty = 1", null);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }
}
