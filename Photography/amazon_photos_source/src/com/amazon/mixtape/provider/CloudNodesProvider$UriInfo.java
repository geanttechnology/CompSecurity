// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.content.UriMatcher;
import android.net.Uri;
import java.util.List;

// Referenced classes of package com.amazon.mixtape.provider:
//            CloudNodesProvider

private static final class uriPattern extends Enum
{

    private static final QUERY_EXCLUDED_IDS $VALUES[];
    public static final QUERY_EXCLUDED_IDS ACCOUNT;
    public static final QUERY_EXCLUDED_IDS ACCOUNTS;
    public static final QUERY_EXCLUDED_IDS ACCOUNT_METADATA_STATE;
    public static final QUERY_EXCLUDED_IDS ACCOUNT_METADATA_STATES;
    public static final QUERY_EXCLUDED_IDS ALL_COVER_PHOTOS;
    public static final QUERY_EXCLUDED_IDS ALL_NODE_CHILDREN;
    public static final QUERY_EXCLUDED_IDS ALL_NODE_LABELS;
    public static final QUERY_EXCLUDED_IDS ALL_NODE_TRANSFORMS;
    public static final QUERY_EXCLUDED_IDS ALL_QUERY_EXCLUDED_IDS;
    public static final QUERY_EXCLUDED_IDS ALL_QUERY_INCLUDE;
    public static final QUERY_EXCLUDED_IDS ALL_UPLOAD_LOG_ENTRIES;
    public static final QUERY_EXCLUDED_IDS ALL_UPLOAD_QUEUE_BLOCKER;
    public static final QUERY_EXCLUDED_IDS ALL_UPLOAD_REQUESTS;
    public static final QUERY_EXCLUDED_IDS ALL_UPLOAD_REQUEST_BLOCKER;
    public static final QUERY_EXCLUDED_IDS CHANGE;
    public static final QUERY_EXCLUDED_IDS CHANGES;
    public static final QUERY_EXCLUDED_IDS CHECKPOINT;
    public static final QUERY_EXCLUDED_IDS CHECKPOINTS;
    public static final QUERY_EXCLUDED_IDS COVER_PHOTOS;
    public static final QUERY_EXCLUDED_IDS DOCUMENT_AUTHOR;
    public static final QUERY_EXCLUDED_IDS DOCUMENT_AUTHORS;
    public static final QUERY_EXCLUDED_IDS MEDIA_PARENT;
    public static final QUERY_EXCLUDED_IDS MEDIA_PARENTS;
    public static final QUERY_EXCLUDED_IDS NODE;
    public static final QUERY_EXCLUDED_IDS NODES;
    public static final QUERY_EXCLUDED_IDS NODE_CHILDREN;
    public static final QUERY_EXCLUDED_IDS NODE_LABELS;
    public static final QUERY_EXCLUDED_IDS NODE_PARENT;
    public static final QUERY_EXCLUDED_IDS NODE_PARENTS;
    public static final QUERY_EXCLUDED_IDS NODE_PROPERTIES;
    public static final QUERY_EXCLUDED_IDS NODE_PROPERTY;
    public static final QUERY_EXCLUDED_IDS NODE_TRANSFORMS;
    public static final QUERY_EXCLUDED_IDS QUERY_EXCLUDED_IDS;
    public static final QUERY_EXCLUDED_IDS QUERY_INCLUDE;
    public static final QUERY_EXCLUDED_IDS UPLOAD_LOG_ENTRY;
    public static final QUERY_EXCLUDED_IDS UPLOAD_QUEUE_BLOCKER;
    public static final QUERY_EXCLUDED_IDS UPLOAD_REQUESTS;
    public static final QUERY_EXCLUDED_IDS UPLOAD_REQUEST_BLOCKER;
    public boolean isAccountPartitioned;
    public final boolean isDirType;
    public final String tableIdSelection;
    public final String tableName;
    public final String type;
    public final int uriConstant;
    public final String uriPattern;

    public static uriPattern getUriInfoFromConstant(int i)
    {
        uriPattern auripattern[] = values();
        int k = auripattern.length;
        for (int j = 0; j < k; j++)
        {
            uriPattern uripattern = auripattern[j];
            if (i == uripattern.uriConstant)
            {
                return uripattern;
            }
        }

        return null;
    }

    public static uriConstant valueOf(String s)
    {
        return (uriConstant)Enum.valueOf(com/amazon/mixtape/provider/CloudNodesProvider$UriInfo, s);
    }

    public static uriConstant[] values()
    {
        return (uriConstant[])$VALUES.clone();
    }

    public String getTableIdSelection(Uri uri)
    {
        if (tableIdSelection == null)
        {
            return null;
        } else
        {
            uri = (String)uri.getPathSegments().get(2);
            return String.format(tableIdSelection, new Object[] {
                uri
            });
        }
    }

    public void registerToMatcher(UriMatcher urimatcher, String s)
    {
        urimatcher.addURI(s, uriPattern, uriConstant);
    }

    static 
    {
        ACCOUNTS = new <init>("ACCOUNTS", 0, 31, false, "accounts", "vnd.android.cursor.dir/accounts");
        ACCOUNT = new <init>("ACCOUNT", 1, 32, false, "accounts", "vnd.android.cursor.item/accounts", "name = '%s'");
        NODES = new <init>("NODES", 2, 1, true, "cloud_nodes", "vnd.android.cursor.dir/cloud_nodes");
        NODE = new <init>("NODE", 3, 2, true, "cloud_nodes", "vnd.android.cursor.item/cloud_nodes", "node_id = '%s'");
        NODE_PARENTS = new <init>("NODE_PARENTS", 4, 3, true, "cloud_node_parents", "vnd.android.cursor.dir/cloud_node_parents");
        NODE_PARENT = new <init>("NODE_PARENT", 5, 4, true, "cloud_node_parents", "vnd.android.cursor.item/cloud_node_parent", "node_id = '%s'");
        NODE_PROPERTIES = new <init>("NODE_PROPERTIES", 6, 5, true, "cloud_node_properties", "vnd.android.cursor.dir/cloud_node_properties");
        NODE_PROPERTY = new <init>("NODE_PROPERTY", 7, 6, true, "cloud_node_properties", "vnd.android.cursor.item/cloud_node_property", "node_id = '%s'");
        DOCUMENT_AUTHORS = new <init>("DOCUMENT_AUTHORS", 8, 11, true, "document_authors", "vnd.android.cursor.dir/document_authors");
        DOCUMENT_AUTHOR = new <init>("DOCUMENT_AUTHOR", 9, 12, true, "document_authors", "vnd.android.cursor.item/document_author", "node_id = '%s'");
        CHECKPOINTS = new <init>("CHECKPOINTS", 10, 17, true, "checkpoints", "vnd.android.cursor.dir/checkpoints");
        CHECKPOINT = new <init>("CHECKPOINT", 11, 18, true, "checkpoints", "vnd.android.cursor.item/checkpoint", "checkpoint_id = '%s'");
        CHANGES = new <init>("CHANGES", 12, 19, true, "events", "vnd.android.cursor.dir/events");
        CHANGE = new <init>("CHANGE", 13, 20, true, "events", "vnd.android.cursor.item/event", "_id = %s");
        ACCOUNT_METADATA_STATES = new <init>("ACCOUNT_METADATA_STATES", 14, 21, true, "account_metadata_states", "vnd.android.cursor.dir/account_metadata_states");
        ACCOUNT_METADATA_STATE = new <init>("ACCOUNT_METADATA_STATE", 15, 22, true, "account_metadata_states", "vnd.android.cursor.item/account_metadata_state", "_id = %s");
        MEDIA_PARENTS = new <init>("MEDIA_PARENTS", 16, 23, true, "cloud_media_parents", "vnd.android.cursor.dir/cloud_media_parents");
        MEDIA_PARENT = new <init>("MEDIA_PARENT", 17, 24, true, "cloud_media_parents", "vnd.android.cursor.item/cloud_media_parents", "node_id = '%s'");
        ALL_NODE_CHILDREN = new <init>("ALL_NODE_CHILDREN", 18, 25, true, "cloud_node_children", "vnd.android.cursor.dir/cloud_node_children");
        NODE_CHILDREN = new <init>("NODE_CHILDREN", 19, 26, true, "cloud_node_children", "vnd.android.cursor.item/cloud_node_children", "parent_node_id = '%s'");
        ALL_NODE_LABELS = new <init>("ALL_NODE_LABELS", 20, 27, true, "cloud_node_labels", "vnd.android.cursor.dir/cloud_node_labels");
        NODE_LABELS = new <init>("NODE_LABELS", 21, 28, true, "cloud_node_labels", "vnd.android.cursor.item/cloud_node_label", "node_id = '%s'");
        ALL_NODE_TRANSFORMS = new <init>("ALL_NODE_TRANSFORMS", 22, 29, true, "cloud_node_transforms", "vnd.android.cursor.dir/cloud_node_transforms");
        NODE_TRANSFORMS = new <init>("NODE_TRANSFORMS", 23, 30, true, "cloud_node_transforms", "vnd.android.cursor.item/cloud_node_transforms", "node_id = '%s'");
        ALL_UPLOAD_REQUESTS = new <init>("ALL_UPLOAD_REQUESTS", 24, 33, true, "upload_requests", "vnd.android.cursor.dir/upload_requests");
        UPLOAD_REQUESTS = new <init>("UPLOAD_REQUESTS", 25, 34, true, "upload_requests", "vnd.android.cursor.item/upload_requests", "_id = %s");
        ALL_UPLOAD_QUEUE_BLOCKER = new <init>("ALL_UPLOAD_QUEUE_BLOCKER", 26, 35, true, "upload_queue_blockers", "vnd.android.cursor.dir/upload_queue_blockers");
        UPLOAD_QUEUE_BLOCKER = new <init>("UPLOAD_QUEUE_BLOCKER", 27, 36, true, "upload_queue_blockers", "vnd.android.cursor.item/upload_queue_blockers", "_id = %s");
        ALL_UPLOAD_LOG_ENTRIES = new <init>("ALL_UPLOAD_LOG_ENTRIES", 28, 37, true, "upload_log", "vnd.android.cursor.dir/upload_log");
        UPLOAD_LOG_ENTRY = new <init>("UPLOAD_LOG_ENTRY", 29, 38, true, "upload_log", "vnd.android.cursor.item/upload_log", "_id = %s");
        ALL_UPLOAD_REQUEST_BLOCKER = new <init>("ALL_UPLOAD_REQUEST_BLOCKER", 30, 39, true, "upload_request_blockers", "vnd.android.cursor.dir/upload_request_blockers");
        UPLOAD_REQUEST_BLOCKER = new <init>("UPLOAD_REQUEST_BLOCKER", 31, 40, true, "upload_request_blockers", "vnd.android.cursor.item/upload_request_blockers", "request_id = %s");
        ALL_COVER_PHOTOS = new <init>("ALL_COVER_PHOTOS", 32, 41, true, "cloud_node_cover_photos", "vnd.android.cursor.dir/cloud_node_cover_photos");
        COVER_PHOTOS = new <init>("COVER_PHOTOS", 33, 42, true, "cloud_node_cover_photos", "vnd.android.cursor.item/cloud_node_cover_photos", "node_id = '%s'");
        ALL_QUERY_INCLUDE = new <init>("ALL_QUERY_INCLUDE", 34, 43, true, "cloud_node_query_include", "vnd.android.cursor.dir/cloud_node_query_include");
        QUERY_INCLUDE = new <init>("QUERY_INCLUDE", 35, 44, true, "cloud_node_query_include", "vnd.android.cursor.item/cloud_node_query_include", "node_id = '%s'");
        ALL_QUERY_EXCLUDED_IDS = new <init>("ALL_QUERY_EXCLUDED_IDS", 36, 45, true, "cloud_node_query_excluded_ids", "vnd.android.cursor.dir/cloud_node_query_excluded_ids");
        QUERY_EXCLUDED_IDS = new <init>("QUERY_EXCLUDED_IDS", 37, 46, true, "cloud_node_query_excluded_ids", "vnd.android.cursor.item/cloud_node_query_excluded_ids", "node_id = '%s'");
        $VALUES = (new .VALUES[] {
            ACCOUNTS, ACCOUNT, NODES, NODE, NODE_PARENTS, NODE_PARENT, NODE_PROPERTIES, NODE_PROPERTY, DOCUMENT_AUTHORS, DOCUMENT_AUTHOR, 
            CHECKPOINTS, CHECKPOINT, CHANGES, CHANGE, ACCOUNT_METADATA_STATES, ACCOUNT_METADATA_STATE, MEDIA_PARENTS, MEDIA_PARENT, ALL_NODE_CHILDREN, NODE_CHILDREN, 
            ALL_NODE_LABELS, NODE_LABELS, ALL_NODE_TRANSFORMS, NODE_TRANSFORMS, ALL_UPLOAD_REQUESTS, UPLOAD_REQUESTS, ALL_UPLOAD_QUEUE_BLOCKER, UPLOAD_QUEUE_BLOCKER, ALL_UPLOAD_LOG_ENTRIES, UPLOAD_LOG_ENTRY, 
            ALL_UPLOAD_REQUEST_BLOCKER, UPLOAD_REQUEST_BLOCKER, ALL_COVER_PHOTOS, COVER_PHOTOS, ALL_QUERY_INCLUDE, QUERY_INCLUDE, ALL_QUERY_EXCLUDED_IDS, QUERY_EXCLUDED_IDS
        });
    }

    private (String s, int i, int j, boolean flag, String s1, String s2)
    {
        this(s, i, j, flag, s1, s2, null);
    }

    private <init>(String s, int i, int j, boolean flag, String s1, String s2, String s3)
    {
        super(s, i);
        uriConstant = j;
        tableName = s1;
        type = s2;
        isDirType = s2.startsWith("vnd.android.cursor.dir");
        tableIdSelection = s3;
        isAccountPartitioned = flag;
        s = new StringBuilder();
        if (flag)
        {
            s.append("*/");
        }
        s.append(s1);
        if (!isDirType)
        {
            s.append("/*");
        }
        uriPattern = s.toString();
    }
}
