// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.mixtape.utils.MixtapeCursorUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FolderPathLoader
{
    private static class NodeData
    {

        private final boolean isRoot;
        private final String name;
        private final String nodeId;

        public String getName()
        {
            return name;
        }

        public String getNodeId()
        {
            return nodeId;
        }

        public boolean isRootNode()
        {
            return isRoot;
        }

        public NodeData(String s, String s1, boolean flag)
        {
            nodeId = s;
            name = s1;
            isRoot = flag;
        }
    }


    private static final String CLOUD_NODES_PROJECTION[] = {
        "node_id", "name", "is_root"
    };
    private static final String CLOUD_NODE_PARENTS_PROJECTION[] = {
        "parent_node_id"
    };
    public static final String TAG = com/amazon/gallery/thor/folders/FolderPathLoader.getName();
    private final String accountId;
    private final Context context;
    private final String mixtapeAuthority;
    private final Map nodeDataMap = new HashMap();

    public FolderPathLoader(Context context1, String s)
    {
        context = context1;
        accountId = s;
        mixtapeAuthority = context1.getResources().getString(0x7f0e02fb);
    }

    private void getPath(StringBuilder stringbuilder, String s)
    {
        s = (NodeData)nodeDataMap.get(s);
        if (s == null)
        {
            return;
        }
        if (s.isRootNode())
        {
            stringbuilder.append(File.separator);
            return;
        } else
        {
            getPath(stringbuilder, s.getNodeId());
            stringbuilder.append(s.getName());
            stringbuilder.append(File.separator);
            return;
        }
    }

    private void populateMap(String s)
    {
        if (nodeDataMap.containsKey(s))
        {
            return;
        }
        String s1 = queryParentNodeId(s);
        if (s1 == null)
        {
            GLogger.e(TAG, "Could not complete populating due to null parent node id!", new Object[0]);
            return;
        }
        NodeData nodedata = queryNodeData(s1);
        if (nodedata == null)
        {
            GLogger.e(TAG, "Could not complete populating due to no node data!", new Object[0]);
            return;
        }
        GLogger.v(TAG, "Added [nodeId: %s, parentId: %s] to map", new Object[] {
            s, nodedata.getNodeId()
        });
        nodeDataMap.put(s, nodedata);
        if (nodedata.isRootNode())
        {
            GLogger.v(TAG, "Reached root node", new Object[0]);
            return;
        } else
        {
            GLogger.v(TAG, "Recursing to find parent of [%s]", new Object[] {
                nodedata.getName()
            });
            populateMap(s1);
            return;
        }
    }

    private NodeData queryNodeData(String s)
    {
        Cursor cursor = null;
        Cursor cursor1 = context.getContentResolver().query(com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(mixtapeAuthority, accountId), CLOUD_NODES_PROJECTION, "node_id = ?", new String[] {
            s
        }, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        cursor = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        cursor = cursor1;
        s = new NodeData(s, cursor1.getString(cursor1.getColumnIndex("name")), MixtapeCursorUtils.getBooleanFromCursor(cursor1, "is_root"));
        IOUtils.closeSilently(cursor1);
        return s;
        IOUtils.closeSilently(cursor1);
        return null;
        s;
        IOUtils.closeSilently(cursor);
        throw s;
    }

    private String queryParentNodeId(String s)
    {
        Cursor cursor;
        Object obj;
        cursor = null;
        obj = null;
        Cursor cursor1 = context.getContentResolver().query(com.amazon.mixtape.provider.CloudNodesContract.NodeParents.getContentUri(mixtapeAuthority, accountId), CLOUD_NODE_PARENTS_PROJECTION, "node_id = ?", new String[] {
            s
        }, null);
        s = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        s = obj;
        cursor = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_83;
        }
        cursor = cursor1;
        s = cursor1.getString(cursor1.getColumnIndex("parent_node_id"));
        IOUtils.closeSilently(cursor1);
        return s;
        s;
        IOUtils.closeSilently(cursor);
        throw s;
    }

    public void addFolder(String s)
    {
        if (!isPathAvailable(s))
        {
            populateMap(s);
        }
    }

    public String getPath(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        getPath(stringbuilder, s);
        return stringbuilder.toString();
    }

    public boolean isPathAvailable(String s)
    {
        return nodeDataMap.containsKey(s);
    }

}
