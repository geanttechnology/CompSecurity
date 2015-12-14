// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.amazon.mixtape.account.AccountContextFactory;
import com.amazon.mixtape.database.AccountsDatabaseHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mixtape.provider:
//            UnknownUriException

public class CloudNodesProvider extends ContentProvider
{
    private static final class UriInfo extends Enum
    {

        private static final UriInfo $VALUES[];
        public static final UriInfo ACCOUNT;
        public static final UriInfo ACCOUNTS;
        public static final UriInfo ACCOUNT_METADATA_STATE;
        public static final UriInfo ACCOUNT_METADATA_STATES;
        public static final UriInfo ALL_COVER_PHOTOS;
        public static final UriInfo ALL_NODE_CHILDREN;
        public static final UriInfo ALL_NODE_LABELS;
        public static final UriInfo ALL_NODE_TRANSFORMS;
        public static final UriInfo ALL_QUERY_EXCLUDED_IDS;
        public static final UriInfo ALL_QUERY_INCLUDE;
        public static final UriInfo ALL_UPLOAD_LOG_ENTRIES;
        public static final UriInfo ALL_UPLOAD_QUEUE_BLOCKER;
        public static final UriInfo ALL_UPLOAD_REQUESTS;
        public static final UriInfo ALL_UPLOAD_REQUEST_BLOCKER;
        public static final UriInfo CHANGE;
        public static final UriInfo CHANGES;
        public static final UriInfo CHECKPOINT;
        public static final UriInfo CHECKPOINTS;
        public static final UriInfo COVER_PHOTOS;
        public static final UriInfo DOCUMENT_AUTHOR;
        public static final UriInfo DOCUMENT_AUTHORS;
        public static final UriInfo MEDIA_PARENT;
        public static final UriInfo MEDIA_PARENTS;
        public static final UriInfo NODE;
        public static final UriInfo NODES;
        public static final UriInfo NODE_CHILDREN;
        public static final UriInfo NODE_LABELS;
        public static final UriInfo NODE_PARENT;
        public static final UriInfo NODE_PARENTS;
        public static final UriInfo NODE_PROPERTIES;
        public static final UriInfo NODE_PROPERTY;
        public static final UriInfo NODE_TRANSFORMS;
        public static final UriInfo QUERY_EXCLUDED_IDS;
        public static final UriInfo QUERY_INCLUDE;
        public static final UriInfo UPLOAD_LOG_ENTRY;
        public static final UriInfo UPLOAD_QUEUE_BLOCKER;
        public static final UriInfo UPLOAD_REQUESTS;
        public static final UriInfo UPLOAD_REQUEST_BLOCKER;
        public boolean isAccountPartitioned;
        public final boolean isDirType;
        public final String tableIdSelection;
        public final String tableName;
        public final String type;
        public final int uriConstant;
        public final String uriPattern;

        public static UriInfo getUriInfoFromConstant(int i)
        {
            UriInfo auriinfo[] = values();
            int k = auriinfo.length;
            for (int j = 0; j < k; j++)
            {
                UriInfo uriinfo = auriinfo[j];
                if (i == uriinfo.uriConstant)
                {
                    return uriinfo;
                }
            }

            return null;
        }

        public static UriInfo valueOf(String s)
        {
            return (UriInfo)Enum.valueOf(com/amazon/mixtape/provider/CloudNodesProvider$UriInfo, s);
        }

        public static UriInfo[] values()
        {
            return (UriInfo[])$VALUES.clone();
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
            ACCOUNTS = new UriInfo("ACCOUNTS", 0, 31, false, "accounts", "vnd.android.cursor.dir/accounts");
            ACCOUNT = new UriInfo("ACCOUNT", 1, 32, false, "accounts", "vnd.android.cursor.item/accounts", "name = '%s'");
            NODES = new UriInfo("NODES", 2, 1, true, "cloud_nodes", "vnd.android.cursor.dir/cloud_nodes");
            NODE = new UriInfo("NODE", 3, 2, true, "cloud_nodes", "vnd.android.cursor.item/cloud_nodes", "node_id = '%s'");
            NODE_PARENTS = new UriInfo("NODE_PARENTS", 4, 3, true, "cloud_node_parents", "vnd.android.cursor.dir/cloud_node_parents");
            NODE_PARENT = new UriInfo("NODE_PARENT", 5, 4, true, "cloud_node_parents", "vnd.android.cursor.item/cloud_node_parent", "node_id = '%s'");
            NODE_PROPERTIES = new UriInfo("NODE_PROPERTIES", 6, 5, true, "cloud_node_properties", "vnd.android.cursor.dir/cloud_node_properties");
            NODE_PROPERTY = new UriInfo("NODE_PROPERTY", 7, 6, true, "cloud_node_properties", "vnd.android.cursor.item/cloud_node_property", "node_id = '%s'");
            DOCUMENT_AUTHORS = new UriInfo("DOCUMENT_AUTHORS", 8, 11, true, "document_authors", "vnd.android.cursor.dir/document_authors");
            DOCUMENT_AUTHOR = new UriInfo("DOCUMENT_AUTHOR", 9, 12, true, "document_authors", "vnd.android.cursor.item/document_author", "node_id = '%s'");
            CHECKPOINTS = new UriInfo("CHECKPOINTS", 10, 17, true, "checkpoints", "vnd.android.cursor.dir/checkpoints");
            CHECKPOINT = new UriInfo("CHECKPOINT", 11, 18, true, "checkpoints", "vnd.android.cursor.item/checkpoint", "checkpoint_id = '%s'");
            CHANGES = new UriInfo("CHANGES", 12, 19, true, "events", "vnd.android.cursor.dir/events");
            CHANGE = new UriInfo("CHANGE", 13, 20, true, "events", "vnd.android.cursor.item/event", "_id = %s");
            ACCOUNT_METADATA_STATES = new UriInfo("ACCOUNT_METADATA_STATES", 14, 21, true, "account_metadata_states", "vnd.android.cursor.dir/account_metadata_states");
            ACCOUNT_METADATA_STATE = new UriInfo("ACCOUNT_METADATA_STATE", 15, 22, true, "account_metadata_states", "vnd.android.cursor.item/account_metadata_state", "_id = %s");
            MEDIA_PARENTS = new UriInfo("MEDIA_PARENTS", 16, 23, true, "cloud_media_parents", "vnd.android.cursor.dir/cloud_media_parents");
            MEDIA_PARENT = new UriInfo("MEDIA_PARENT", 17, 24, true, "cloud_media_parents", "vnd.android.cursor.item/cloud_media_parents", "node_id = '%s'");
            ALL_NODE_CHILDREN = new UriInfo("ALL_NODE_CHILDREN", 18, 25, true, "cloud_node_children", "vnd.android.cursor.dir/cloud_node_children");
            NODE_CHILDREN = new UriInfo("NODE_CHILDREN", 19, 26, true, "cloud_node_children", "vnd.android.cursor.item/cloud_node_children", "parent_node_id = '%s'");
            ALL_NODE_LABELS = new UriInfo("ALL_NODE_LABELS", 20, 27, true, "cloud_node_labels", "vnd.android.cursor.dir/cloud_node_labels");
            NODE_LABELS = new UriInfo("NODE_LABELS", 21, 28, true, "cloud_node_labels", "vnd.android.cursor.item/cloud_node_label", "node_id = '%s'");
            ALL_NODE_TRANSFORMS = new UriInfo("ALL_NODE_TRANSFORMS", 22, 29, true, "cloud_node_transforms", "vnd.android.cursor.dir/cloud_node_transforms");
            NODE_TRANSFORMS = new UriInfo("NODE_TRANSFORMS", 23, 30, true, "cloud_node_transforms", "vnd.android.cursor.item/cloud_node_transforms", "node_id = '%s'");
            ALL_UPLOAD_REQUESTS = new UriInfo("ALL_UPLOAD_REQUESTS", 24, 33, true, "upload_requests", "vnd.android.cursor.dir/upload_requests");
            UPLOAD_REQUESTS = new UriInfo("UPLOAD_REQUESTS", 25, 34, true, "upload_requests", "vnd.android.cursor.item/upload_requests", "_id = %s");
            ALL_UPLOAD_QUEUE_BLOCKER = new UriInfo("ALL_UPLOAD_QUEUE_BLOCKER", 26, 35, true, "upload_queue_blockers", "vnd.android.cursor.dir/upload_queue_blockers");
            UPLOAD_QUEUE_BLOCKER = new UriInfo("UPLOAD_QUEUE_BLOCKER", 27, 36, true, "upload_queue_blockers", "vnd.android.cursor.item/upload_queue_blockers", "_id = %s");
            ALL_UPLOAD_LOG_ENTRIES = new UriInfo("ALL_UPLOAD_LOG_ENTRIES", 28, 37, true, "upload_log", "vnd.android.cursor.dir/upload_log");
            UPLOAD_LOG_ENTRY = new UriInfo("UPLOAD_LOG_ENTRY", 29, 38, true, "upload_log", "vnd.android.cursor.item/upload_log", "_id = %s");
            ALL_UPLOAD_REQUEST_BLOCKER = new UriInfo("ALL_UPLOAD_REQUEST_BLOCKER", 30, 39, true, "upload_request_blockers", "vnd.android.cursor.dir/upload_request_blockers");
            UPLOAD_REQUEST_BLOCKER = new UriInfo("UPLOAD_REQUEST_BLOCKER", 31, 40, true, "upload_request_blockers", "vnd.android.cursor.item/upload_request_blockers", "request_id = %s");
            ALL_COVER_PHOTOS = new UriInfo("ALL_COVER_PHOTOS", 32, 41, true, "cloud_node_cover_photos", "vnd.android.cursor.dir/cloud_node_cover_photos");
            COVER_PHOTOS = new UriInfo("COVER_PHOTOS", 33, 42, true, "cloud_node_cover_photos", "vnd.android.cursor.item/cloud_node_cover_photos", "node_id = '%s'");
            ALL_QUERY_INCLUDE = new UriInfo("ALL_QUERY_INCLUDE", 34, 43, true, "cloud_node_query_include", "vnd.android.cursor.dir/cloud_node_query_include");
            QUERY_INCLUDE = new UriInfo("QUERY_INCLUDE", 35, 44, true, "cloud_node_query_include", "vnd.android.cursor.item/cloud_node_query_include", "node_id = '%s'");
            ALL_QUERY_EXCLUDED_IDS = new UriInfo("ALL_QUERY_EXCLUDED_IDS", 36, 45, true, "cloud_node_query_excluded_ids", "vnd.android.cursor.dir/cloud_node_query_excluded_ids");
            QUERY_EXCLUDED_IDS = new UriInfo("QUERY_EXCLUDED_IDS", 37, 46, true, "cloud_node_query_excluded_ids", "vnd.android.cursor.item/cloud_node_query_excluded_ids", "node_id = '%s'");
            $VALUES = (new UriInfo[] {
                ACCOUNTS, ACCOUNT, NODES, NODE, NODE_PARENTS, NODE_PARENT, NODE_PROPERTIES, NODE_PROPERTY, DOCUMENT_AUTHORS, DOCUMENT_AUTHOR, 
                CHECKPOINTS, CHECKPOINT, CHANGES, CHANGE, ACCOUNT_METADATA_STATES, ACCOUNT_METADATA_STATE, MEDIA_PARENTS, MEDIA_PARENT, ALL_NODE_CHILDREN, NODE_CHILDREN, 
                ALL_NODE_LABELS, NODE_LABELS, ALL_NODE_TRANSFORMS, NODE_TRANSFORMS, ALL_UPLOAD_REQUESTS, UPLOAD_REQUESTS, ALL_UPLOAD_QUEUE_BLOCKER, UPLOAD_QUEUE_BLOCKER, ALL_UPLOAD_LOG_ENTRIES, UPLOAD_LOG_ENTRY, 
                ALL_UPLOAD_REQUEST_BLOCKER, UPLOAD_REQUEST_BLOCKER, ALL_COVER_PHOTOS, COVER_PHOTOS, ALL_QUERY_INCLUDE, QUERY_INCLUDE, ALL_QUERY_EXCLUDED_IDS, QUERY_EXCLUDED_IDS
            });
        }

        private UriInfo(String s, int i, int j, boolean flag, String s1, String s2)
        {
            this(s, i, j, flag, s1, s2, null);
        }

        private UriInfo(String s, int i, int j, boolean flag, String s1, String s2, String s3)
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


    private String mAuthority;
    private UriMatcher mUriMatcher;

    public CloudNodesProvider()
    {
    }

    private String getAccountFromUri(Uri uri)
    {
        return (String)uri.getPathSegments().get(0);
    }

    private SQLiteDatabase getDatabaseForUri(Uri uri, UriInfo uriinfo)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$mixtape$provider$CloudNodesProvider$UriInfo[];

            static 
            {
                $SwitchMap$com$amazon$mixtape$provider$CloudNodesProvider$UriInfo = new int[UriInfo.values().length];
                try
                {
                    $SwitchMap$com$amazon$mixtape$provider$CloudNodesProvider$UriInfo[UriInfo.ACCOUNT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mixtape$provider$CloudNodesProvider$UriInfo[UriInfo.ACCOUNTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.mixtape.provider.CloudNodesProvider.UriInfo[uriinfo.ordinal()])
        {
        default:
            uri = getAccountFromUri(uri);
            return AccountContextFactory.getContextForAccountId(getContext(), uri).getWritableDatabase();

        case 1: // '\001'
        case 2: // '\002'
            return ((AccountsDatabaseHelper)AccountContextFactory.ACCOUNTS_DATABASE_HELPER.get(getContext())).getWritableDatabase();
        }
    }

    private void initializeUriMatcher()
    {
        mUriMatcher = new UriMatcher(-1);
        UriInfo auriinfo[] = UriInfo.values();
        int j = auriinfo.length;
        for (int i = 0; i < j; i++)
        {
            auriinfo[i].registerToMatcher(mUriMatcher, mAuthority);
        }

    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist)
        throws OperationApplicationException
    {
        if (!arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        arraylist = null;
_L4:
        return arraylist;
_L2:
        Object obj;
        SQLiteDatabase sqlitedatabase;
        obj = new HashSet();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((Set) (obj)).add(((ContentProviderOperation)iterator.next()).getUri())) { }
        HashSet hashset = new HashSet();
        Uri uri;
        for (Iterator iterator1 = ((Set) (obj)).iterator(); iterator1.hasNext(); hashset.add(getDatabaseForUri(uri, UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri)))))
        {
            uri = (Uri)iterator1.next();
        }

        if (hashset.size() > 1)
        {
            throw new IllegalArgumentException("Cannot apply a batch over multiple matched databases.");
        }
        sqlitedatabase = (SQLiteDatabase)hashset.iterator().next();
        sqlitedatabase.beginTransaction();
        ContentProviderResult acontentproviderresult[];
        acontentproviderresult = super.applyBatch(arraylist);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        obj = ((Set) (obj)).iterator();
        do
        {
            arraylist = acontentproviderresult;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            arraylist = (Uri)((Iterator) (obj)).next();
            getContext().getContentResolver().notifyChange(arraylist, null);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        sqlitedatabase.endTransaction();
        throw arraylist;
    }

    public void attachInfo(Context context, ProviderInfo providerinfo)
    {
        mAuthority = providerinfo.authority;
        initializeUriMatcher();
        super.attachInfo(context, providerinfo);
    }

    public int delete(Uri uri, String s, String as[])
    {
        UriInfo uriinfo = UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri));
        if (uriinfo == null)
        {
            throw new UnknownUriException(uri);
        }
        SQLiteDatabase sqlitedatabase = getDatabaseForUri(uri, uriinfo);
        int i;
        if (!uriinfo.isDirType)
        {
            i = sqlitedatabase.delete(uriinfo.tableName, uriinfo.getTableIdSelection(uri), null);
        } else
        {
            i = sqlitedatabase.delete(uriinfo.tableName, s, as);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    public String getType(Uri uri)
    {
        uri = UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri));
        if (uri == null)
        {
            return null;
        } else
        {
            return ((UriInfo) (uri)).type;
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        UriInfo uriinfo = UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri));
        if (uriinfo == null)
        {
            throw new UnknownUriException(uri);
        }
        SQLiteDatabase sqlitedatabase = getDatabaseForUri(uri, uriinfo);
        long l;
        try
        {
            l = sqlitedatabase.replace(uriinfo.tableName, null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            throw new IllegalArgumentException(uri.getMessage());
        }
        if (l >= 0L)
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
        UriInfo uriinfo = UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri));
        if (uriinfo == null)
        {
            throw new UnknownUriException(uri);
        }
        SQLiteDatabase sqlitedatabase = getDatabaseForUri(uri, uriinfo);
        if (!uriinfo.isDirType)
        {
            SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables(uriinfo.tableName);
            sqlitequerybuilder.appendWhere(uriinfo.getTableIdSelection(uri));
            as = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1);
        } else
        {
            (new SQLiteQueryBuilder()).setTables(uriinfo.tableName);
            as = sqlitedatabase.query(uriinfo.tableName, as, s, as1, null, null, s1);
        }
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        UriInfo uriinfo = UriInfo.getUriInfoFromConstant(mUriMatcher.match(uri));
        if (uriinfo == null)
        {
            throw new UnknownUriException(uri);
        }
        SQLiteDatabase sqlitedatabase = getDatabaseForUri(uri, uriinfo);
        int i;
        if (!uriinfo.isDirType)
        {
            i = sqlitedatabase.update(uriinfo.tableName, contentvalues, uriinfo.getTableIdSelection(uri), null);
        } else
        {
            i = sqlitedatabase.update(uriinfo.tableName, contentvalues, s, as);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }
}
