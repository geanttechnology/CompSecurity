// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.media.MediaProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.kindle.provider:
//            FilterCollection, MediaContentConfiguration

public class GalleryInternalContentProvider extends ContentProvider
{
    public static class Audit
    {

        public static final Uri CONTENT_URI = Uri.parse("content://com.amazon.gallery.provider.internal/audit");

    }

    public static class MediaItem
    {

        public static final Uri CONTENT_URI = Uri.parse("content://com.amazon.gallery.provider.internal/media_item");

    }

    public static class MediaItem.Columns
    {

        public static final String ALL_PROJECTION[] = {
            "_id", "type", "object_id_low", "object_id_hi", "width", "height", "name", "asset_hash", "caption", "local_path", 
            "date_created", "date_created_utc", "date_modified", "date_added", "lat", "lon", "duration", "uploaded_id_low", "uploaded_id_hi", "orientation", 
            "parent_media_id_low", "parent_media_id_hi", "group_type", "sync_state", "potentially_orphaned", "time_stamp", "mime_type", "event_id", "full_md5", "file_size", 
            "hidden"
        };

    }

    public static class SortType
    {

        public static final Uri CONTENT_URI = Uri.parse("content://com.amazon.gallery.provider.internal/sort_preference");

    }

    public static class Tag
    {

        public static Uri CONTENT_URI = Uri.parse("content://com.amazon.gallery.provider.internal/tag");

    }

    public static class Tag.Columns
    {

        public static final String ALL_PROJECTION[] = {
            "_id", "object_id_hi", "object_id_low", "cover_id_high", "cover_id_low", "label", "local_path", "date_created", "sort_date", "has_sort_date", 
            "time_stamp", "type", "media_items_sync_version", "storage", "misc", "tag_sync_version", "new_content", "auto_save", "update_status", "tag_revision_id", 
            "valid", "custom_cover_id_low", "custom_cover_id_high", "db_version"
        };

    }

    private static final class UriSelector extends Enum
    {

        private static final UriSelector $VALUES[];
        public static final UriSelector AUDIT;
        public static final UriSelector COLLECTION_ID;
        public static final UriSelector COLLECTION_ID_MEDIA;
        public static final UriSelector DYNAMIC_ALBUM_MEDIA;
        public static final UriSelector FRAME;
        public static final UriSelector MEDIA_ITEM;
        public static final UriSelector MEDIA_ITEM_ID;
        public static final UriSelector MEDIA_PROPERTY_ID_MEDIA;
        public static final UriSelector METADATA_MEDIA;
        public static final UriSelector SORT_TYPE;
        public static final UriSelector TAG;
        public static final UriSelector TAG_ID;
        public static final UriSelector TAG_ID_MEDIA;

        public static UriSelector valueOf(String s)
        {
            return (UriSelector)Enum.valueOf(com/amazon/gallery/framework/kindle/provider/GalleryInternalContentProvider$UriSelector, s);
        }

        public static UriSelector[] values()
        {
            return (UriSelector[])$VALUES.clone();
        }

        static 
        {
            MEDIA_ITEM = new UriSelector("MEDIA_ITEM", 0);
            MEDIA_ITEM_ID = new UriSelector("MEDIA_ITEM_ID", 1);
            MEDIA_PROPERTY_ID_MEDIA = new UriSelector("MEDIA_PROPERTY_ID_MEDIA", 2);
            METADATA_MEDIA = new UriSelector("METADATA_MEDIA", 3);
            TAG = new UriSelector("TAG", 4);
            TAG_ID = new UriSelector("TAG_ID", 5);
            TAG_ID_MEDIA = new UriSelector("TAG_ID_MEDIA", 6);
            COLLECTION_ID = new UriSelector("COLLECTION_ID", 7);
            COLLECTION_ID_MEDIA = new UriSelector("COLLECTION_ID_MEDIA", 8);
            DYNAMIC_ALBUM_MEDIA = new UriSelector("DYNAMIC_ALBUM_MEDIA", 9);
            FRAME = new UriSelector("FRAME", 10);
            SORT_TYPE = new UriSelector("SORT_TYPE", 11);
            AUDIT = new UriSelector("AUDIT", 12);
            $VALUES = (new UriSelector[] {
                MEDIA_ITEM, MEDIA_ITEM_ID, MEDIA_PROPERTY_ID_MEDIA, METADATA_MEDIA, TAG, TAG_ID, TAG_ID_MEDIA, COLLECTION_ID, COLLECTION_ID_MEDIA, DYNAMIC_ALBUM_MEDIA, 
                FRAME, SORT_TYPE, AUDIT
            });
        }

        private UriSelector(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String LOG_TAG = com/amazon/gallery/framework/kindle/provider/GalleryInternalContentProvider.getName();
    private static final UriMatcher sURIMatcher;

    public GalleryInternalContentProvider()
    {
    }

    public static final Uri createCollectionMediaUri(Uri uri)
    {
        return uri.buildUpon().appendPath("media").build();
    }

    private String createColumnAlias(String s, String s1, String s2)
    {
        return (new StringBuilder()).append(s).append(".").append(s1).append(" AS ").append(s2).toString();
    }

    public static final Uri createDynamicAlbumContentUri(String s)
    {
        return Uri.parse((new StringBuilder()).append("content://com.amazon.gallery.provider.internal/dynamic_album_membership/").append(s).toString());
    }

    public static final Uri createDynamicAlbumMediaUri(long l)
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").appendPath("dynamic_album_membership").appendPath(Long.toString(l)).appendPath("media").build();
    }

    private Map createMediaItemProjectionMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_id", createColumnAlias("media_item", "id", "_id"));
        hashmap.put("type", createColumnAlias("media_item", "type", "type"));
        hashmap.put("object_id_low", createColumnAlias("media_item", "object_id_low", "object_id_low"));
        hashmap.put("object_id_hi", createColumnAlias("media_item", "object_id_hi", "object_id_hi"));
        hashmap.put("width", createColumnAlias("media_item", "width", "width"));
        hashmap.put("height", createColumnAlias("media_item", "height", "height"));
        hashmap.put("name", createColumnAlias("media_item", "name", "name"));
        hashmap.put("asset_hash", createColumnAlias("media_item", "asset_hash", "asset_hash"));
        hashmap.put("caption", createColumnAlias("media_item", "caption", "caption"));
        hashmap.put("local_path", createColumnAlias("media_item", "local_path", "local_path"));
        hashmap.put("date_created", createColumnAlias("media_item", "date_created", "date_created"));
        hashmap.put("date_created_utc", createColumnAlias("media_item", "date_created_utc", "date_created_utc"));
        hashmap.put("date_modified", createColumnAlias("media_item", "date_modified", "date_modified"));
        hashmap.put("date_added", createColumnAlias("media_item", "date_added", "date_added"));
        hashmap.put("lat", createColumnAlias("media_item", "lat", "lat"));
        hashmap.put("lon", createColumnAlias("media_item", "lon", "lon"));
        hashmap.put("duration", createColumnAlias("media_item", "duration", "duration"));
        hashmap.put("uploaded_id_low", createColumnAlias("media_item", "uploaded_id_low", "uploaded_id_low"));
        hashmap.put("uploaded_id_hi", createColumnAlias("media_item", "uploaded_id_hi", "uploaded_id_hi"));
        hashmap.put("orientation", createColumnAlias("media_item", "orientation", "orientation"));
        hashmap.put("parent_media_id_low", createColumnAlias("media_item", "parent_media_id_low", "parent_media_id_low"));
        hashmap.put("parent_media_id_hi", createColumnAlias("media_item", "parent_media_id_hi", "parent_media_id_hi"));
        hashmap.put("group_type", createColumnAlias("media_item", "group_type", "group_type"));
        hashmap.put("sync_state", createColumnAlias("media_item", "sync_state", "sync_state"));
        hashmap.put("potentially_orphaned", createColumnAlias("media_item", "potentially_orphaned", "potentially_orphaned"));
        hashmap.put("time_stamp", createColumnAlias("media_item", "time_stamp", "time_stamp"));
        hashmap.put("mime_type", createColumnAlias("media_item", "mime_type", "mime_type"));
        hashmap.put("event_id", createColumnAlias("media_item", "event_id", "event_id"));
        hashmap.put("full_md5", createColumnAlias("media_item", "full_md5", "full_md5"));
        hashmap.put("file_size", createColumnAlias("media_item", "file_size", "file_size"));
        hashmap.put("hidden", createColumnAlias("media_item", "hidden", "hidden"));
        hashmap.put("COUNT(*) AS count", "COUNT(*) AS count");
        return hashmap;
    }

    public static final Uri createMediaItemUri(long l)
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").path((new StringBuilder()).append("media_item/").append(l).toString()).build();
    }

    public static final Uri createMediaPropertyUri(MediaProperty mediaproperty)
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").appendPath("media_item").appendPath(mediaproperty.getName()).appendPath("media").build();
    }

    public static final Uri createMetadataUri()
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").appendPath("metadata").appendPath("media").build();
    }

    public static final Uri createTagMediaUri(Uri uri)
    {
        return uri.buildUpon().appendPath("media").build();
    }

    private Map createTagProjectionMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_id", createColumnAlias("tag", "id", "_id"));
        hashmap.put("cover_id_high", createColumnAlias("tag", "cover_id_high", "cover_id_high"));
        hashmap.put("cover_id_low", createColumnAlias("tag", "cover_id_low", "cover_id_low"));
        hashmap.put("date_created", createColumnAlias("tag", "date_created", "date_created"));
        hashmap.put("object_id_hi", createColumnAlias("tag", "object_id_hi", "object_id_hi"));
        hashmap.put("object_id_low", createColumnAlias("tag", "object_id_low", "object_id_low"));
        hashmap.put("sort_date", createColumnAlias("tag", "sort_date", "sort_date"));
        hashmap.put("has_sort_date", createColumnAlias("tag", "has_sort_date", "has_sort_date"));
        hashmap.put("time_stamp", createColumnAlias("tag", "time_stamp", "time_stamp"));
        hashmap.put("label", createColumnAlias("tag", "label", "label"));
        hashmap.put("local_path", createColumnAlias("tag", "local_path", "local_path"));
        hashmap.put("tag_revision_id", createColumnAlias("tag", "tag_revision_id", "tag_revision_id"));
        hashmap.put("media_items_sync_version", createColumnAlias("tag", "media_items_sync_version", "media_items_sync_version"));
        hashmap.put("tag_sync_version", createColumnAlias("tag", "tag_sync_version", "tag_sync_version"));
        hashmap.put("update_status", createColumnAlias("tag", "update_status", "update_status"));
        hashmap.put("auto_save", createColumnAlias("tag", "auto_save", "auto_save"));
        hashmap.put("storage", createColumnAlias("tag", "storage", "storage"));
        hashmap.put("misc", createColumnAlias("tag", "misc", "misc"));
        hashmap.put("new_content", createColumnAlias("tag", "new_content", "new_content"));
        hashmap.put("type", createColumnAlias("tag", "type", "type"));
        hashmap.put("valid", createColumnAlias("tag", "valid", "valid"));
        hashmap.put("custom_cover_id_low", createColumnAlias("tag", "custom_cover_id_low", "custom_cover_id_low"));
        hashmap.put("custom_cover_id_high", createColumnAlias("tag", "custom_cover_id_high", "custom_cover_id_high"));
        hashmap.put("db_version", createColumnAlias("tag", "db_version", "db_version"));
        hashmap.put("COUNT(*) AS count", "COUNT(*) AS count");
        return hashmap;
    }

    public static final Uri createTagUri(long l)
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").appendPath("tag").appendPath(Long.toString(l)).build();
    }

    private SQLiteDatabase getDatabase()
    {
        return ((GalleryDBConnectionManager)((BeanAwareApplication)getContext().getApplicationContext()).getBeanFactory().getBean(Keys.DB_CONNECTION_MANAGER)).getWritableConnection().getDatabase();
    }

    private Uri getNotificationUri(UriSelector uriselector, Uri uri)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector = new int[UriSelector.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.COLLECTION_ID.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.MEDIA_ITEM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.MEDIA_PROPERTY_ID_MEDIA.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.TAG_ID_MEDIA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.MEDIA_ITEM_ID.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.TAG.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.TAG_ID.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.COLLECTION_ID_MEDIA.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.METADATA_MEDIA.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.DYNAMIC_ALBUM_MEDIA.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.FRAME.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.SORT_TYPE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$provider$GalleryInternalContentProvider$UriSelector[UriSelector.AUDIT.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.UriSelector[uriselector.ordinal()])
        {
        default:
            return uri;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return MediaItem.CONTENT_URI;
        }
    }

    public static Uri stripMediaUriSuffix(Uri uri)
    {
        Object obj;
label0:
        {
            Object obj1 = UriSelector.values()[sURIMatcher.match(uri)];
            if (obj1 != UriSelector.TAG_ID_MEDIA)
            {
                obj = uri;
                if (obj1 != UriSelector.COLLECTION_ID_MEDIA)
                {
                    break label0;
                }
            }
            obj = uri.getPathSegments();
            obj1 = new android.net.Uri.Builder();
            ((android.net.Uri.Builder) (obj1)).scheme(uri.getScheme());
            ((android.net.Uri.Builder) (obj1)).encodedAuthority(uri.getAuthority());
            ((android.net.Uri.Builder) (obj1)).encodedQuery(uri.getQuery());
            for (int i = 0; i < ((List) (obj)).size() - 1; i++)
            {
                ((android.net.Uri.Builder) (obj1)).appendPath((String)((List) (obj)).get(i));
            }

            obj = ((android.net.Uri.Builder) (obj1)).build();
        }
        return ((Uri) (obj));
    }

    private String uriMatchToTableName(UriSelector uriselector)
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.UriSelector[uriselector.ordinal()])
        {
        case 8: // '\b'
        default:
            return null;

        case 2: // '\002'
        case 5: // '\005'
            return "media_item";

        case 3: // '\003'
            return "media_property INNER JOIN media_item ON (id = media_item_id)";

        case 9: // '\t'
            return "media_item INNER JOIN metadata ON (id = media_item_id)";

        case 6: // '\006'
        case 7: // '\007'
            return "tag";

        case 4: // '\004'
            return "tag_membership INNER JOIN media_item ON (id = media_item_id)";

        case 10: // '\n'
            return "media_item INNER JOIN dynamic_album_membership ON (id = media_item_id)";

        case 11: // '\013'
            return "frame";

        case 12: // '\f'
            return "sort_preference";

        case 13: // '\r'
            return "audit";
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        String s1 = uriMatchToTableName(UriSelector.values()[sURIMatcher.match(uri)]);
        SQLiteDatabase sqlitedatabase = getDatabase();
        ArrayList arraylist = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null)
        {
            stringbuilder.append((new StringBuilder()).append(s).append(" ").toString());
        }
        if (as != null)
        {
            arraylist.addAll(Arrays.asList(as));
        }
        int i = sqlitedatabase.delete(s1, stringbuilder.toString(), (String[])arraylist.toArray(new String[arraylist.size()]));
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    public String getType(Uri uri)
    {
        uri = UriSelector.values()[sURIMatcher.match(uri)];
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.UriSelector[uri.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return "vnd.android.cursor.item/collection";

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return "vnd.android.cursor.dir/media_item";

        case 5: // '\005'
            return "vnd.android.cursor.item/media_item";

        case 6: // '\006'
            return "vnd.android.cursor.dir/tag";

        case 7: // '\007'
            return "vnd.android.cursor.item/tag";
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        String s = uriMatchToTableName(UriSelector.values()[sURIMatcher.match(uri)]);
        contentvalues = Uri.withAppendedPath(uri, Long.toString(getDatabase().insertWithOnConflict(s, null, contentvalues, 5)));
        getContext().getContentResolver().notifyChange(uri, null);
        getContext().getContentResolver().notifyChange(contentvalues, null);
        return contentvalues;
    }

    public boolean onCreate()
    {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        String s2;
        Object obj;
        StringBuilder stringbuilder;
        ArrayList arraylist;
        SQLiteQueryBuilder sqlitequerybuilder;
        obj = uri.getQueryParameter("limit");
        s2 = ((String) (obj));
        if (obj != null)
        {
            s2 = ((String) (obj));
            if (uri.getQueryParameter("offset") != null)
            {
                s2 = (new StringBuilder()).append(uri.getQueryParameter("offset")).append(",").append(((String) (obj))).toString();
            }
        }
        obj = UriSelector.values()[sURIMatcher.match(uri)];
        stringbuilder = new StringBuilder();
        arraylist = new ArrayList();
        if (s != null)
        {
            stringbuilder.append((new StringBuilder()).append(s).append(" ").toString());
        }
        if (as1 != null)
        {
            arraylist.addAll(Arrays.asList(as1));
        }
        s = ((String) (obj));
        as1 = uri;
        if (obj == UriSelector.COLLECTION_ID_MEDIA)
        {
            s = FilterCollection.valueOf(stripMediaUriSuffix(uri)).getMediaContentConfiguration();
            uri = s.getContentUri();
            obj = UriSelector.values()[sURIMatcher.match(uri)];
            as1 = s.getSelection();
            if (as1 != null)
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append("AND ");
                }
                stringbuilder.append(as1);
            }
            String as2[] = s.getSelectionArgs();
            s = ((String) (obj));
            as1 = uri;
            if (as2 != null)
            {
                arraylist.addAll(Arrays.asList(as2));
                as1 = uri;
                s = ((String) (obj));
            }
        }
        uri = uriMatchToTableName(s);
        obj = getDatabase();
        sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables(uri);
        _cls1..SwitchMap.com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.UriSelector[s.ordinal()];
        JVM INSTR tableswitch 2 10: default 344
    //                   2 501
    //                   3 501
    //                   4 501
    //                   5 501
    //                   6 523
    //                   7 523
    //                   8 501
    //                   9 501
    //                   10 501;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3 _L2 _L2 _L2
_L3:
        break MISSING_BLOCK_LABEL_523;
_L1:
        uri = as;
_L4:
        if (s == UriSelector.MEDIA_ITEM_ID)
        {
            sqlitequerybuilder.appendWhere((new StringBuilder()).append("id=").append(as1.getLastPathSegment()).toString());
        } else
        if (s == UriSelector.TAG_ID)
        {
            sqlitequerybuilder.appendWhere((new StringBuilder()).append("id=").append(as1.getLastPathSegment()).toString());
        } else
        if (s == UriSelector.MEDIA_PROPERTY_ID_MEDIA)
        {
            sqlitequerybuilder.appendWhere((new StringBuilder()).append("property='").append((String)as1.getPathSegments().get(1)).append("'").toString());
        } else
        if (s == UriSelector.TAG_ID_MEDIA)
        {
            sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag_id=").append((String)as1.getPathSegments().get(1)).toString());
        } else
        if (s == UriSelector.DYNAMIC_ALBUM_MEDIA)
        {
            sqlitequerybuilder.appendWhere((new StringBuilder()).append("tag_id=").append((String)as1.getPathSegments().get(1)).toString());
        }
        GLogger.d(LOG_TAG, "SQL query: %s", new Object[] {
            sqlitequerybuilder.buildQuery(uri, stringbuilder.toString(), (String[])arraylist.toArray(new String[arraylist.size()]), null, null, s1, s2)
        });
        uri = sqlitequerybuilder.query(((SQLiteDatabase) (obj)), uri, stringbuilder.toString(), (String[])arraylist.toArray(new String[arraylist.size()]), null, null, s1, s2);
        if (uri != null)
        {
            uri.setNotificationUri(getContext().getContentResolver(), getNotificationUri(s, as1));
        }
        return uri;
_L2:
        sqlitequerybuilder.setProjectionMap(createMediaItemProjectionMap());
        uri = as;
        if (as == null)
        {
            uri = MediaItem.Columns.ALL_PROJECTION;
        }
          goto _L4
        sqlitequerybuilder.setProjectionMap(createTagProjectionMap());
        uri = as;
        if (as == null)
        {
            uri = Tag.Columns.ALL_PROJECTION;
        }
          goto _L4
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        String s1 = uriMatchToTableName(UriSelector.values()[sURIMatcher.match(uri)]);
        ArrayList arraylist = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null)
        {
            stringbuilder.append((new StringBuilder()).append(s).append(" ").toString());
        }
        if (as != null)
        {
            arraylist.addAll(Arrays.asList(as));
        }
        int i = getDatabase().update(s1, contentvalues, stringbuilder.toString(), (String[])arraylist.toArray(new String[arraylist.size()]));
        getContext().getContentResolver().notifyChange(uri, null);
        return i;
    }

    static 
    {
        sURIMatcher = new UriMatcher(-1);
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "media_item", UriSelector.MEDIA_ITEM.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "media_item/#", UriSelector.MEDIA_ITEM_ID.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "media_item/*/media", UriSelector.MEDIA_PROPERTY_ID_MEDIA.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "metadata/media", UriSelector.METADATA_MEDIA.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "tag", UriSelector.TAG.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "tag/#", UriSelector.TAG_ID.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "tag/#/media", UriSelector.TAG_ID_MEDIA.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "collection/*", UriSelector.COLLECTION_ID.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "collection/*/media", UriSelector.COLLECTION_ID_MEDIA.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "dynamic_album_membership/#/media", UriSelector.DYNAMIC_ALBUM_MEDIA.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "frame", UriSelector.FRAME.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "sort_preference", UriSelector.SORT_TYPE.ordinal());
        sURIMatcher.addURI("com.amazon.gallery.provider.internal", "audit", UriSelector.AUDIT.ordinal());
    }
}
