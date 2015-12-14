// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ColdBootSaveEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.AlbumCoverPhotoRetriever;
import com.amazon.mixtape.metadata.processing.AccountChangedException;
import com.amazon.mixtape.metadata.processing.NodeProcessor;
import com.amazon.mixtape.utils.MixtapeCursorUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            TagCursorConverter, MediaItemCursorConverter, CDSUtil

class ThorNodeProcessor
    implements NodeProcessor
{

    public static final String TAG = com/amazon/gallery/thor/cds/ThorNodeProcessor.getName();
    private final AlbumCoverPhotoRetriever albumCoverPhotoRetriever;
    private final AuthenticationManager mAuthenticationManager;
    private final Context mContext;
    private final MediaItemCursorConverter mMediaItemCursorConverter;
    private final MediaItemDao mMediaItemDao;
    private final SharedPreferences mSharedPreferences;
    private final TagCursorConverter mTagCursorConverter;
    private final TagDao mTagDao;

    public ThorNodeProcessor(Context context, AuthenticationManager authenticationmanager, TagDao tagdao, MediaItemDao mediaitemdao)
    {
        mContext = context;
        mAuthenticationManager = authenticationmanager;
        mTagDao = tagdao;
        mMediaItemDao = mediaitemdao;
        mTagCursorConverter = new TagCursorConverter(mTagDao, mContext.getString(0x7f0e009a));
        mMediaItemCursorConverter = new MediaItemCursorConverter(mMediaItemDao);
        mSharedPreferences = context.getSharedPreferences("galleryKindleSharedPrefs", 0);
        albumCoverPhotoRetriever = new AlbumCoverPhotoRetriever(context);
    }

    private String getAccountMetadataState()
    {
        ContentProviderClient contentproviderclient;
        Object obj;
        obj = com.amazon.mixtape.provider.CloudNodesContract.AccountMetadataStates.getContentUri(mContext.getResources().getString(0x7f0e02fb), mAuthenticationManager.getAccountId());
        contentproviderclient = mContext.getContentResolver().acquireContentProviderClient(((android.net.Uri) (obj)));
        obj = CDSUtil.getAccountState(contentproviderclient, ((android.net.Uri) (obj)));
        contentproviderclient.release();
        return ((String) (obj));
        Exception exception;
        exception;
        contentproviderclient.release();
        throw exception;
    }

    private void saveData(Collection collection, Collection collection1)
    {
        if (mSharedPreferences.getBoolean("coldBootStatus", false))
        {
            Iterator iterator = collection.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Tag tag = (Tag)iterator.next();
                if (tag.getType() != TagType.ALBUM)
                {
                    tag.setProperty(TagProperty.NEW_CONTENT);
                } else
                {
                    ObjectID objectid = albumCoverPhotoRetriever.fetchForAlbum(tag.getObjectId());
                    if (objectid != null && !objectid.equals(tag.getCoverId()))
                    {
                        tag.setCoverId(objectid);
                        tag.setCustomCoverId(objectid);
                    }
                }
            } while (true);
            mTagDao.save(collection, true);
            mMediaItemDao.saveCloudFields(collection1, true);
            return;
        } else
        {
            mTagDao.bulkInsert(collection, true);
            mMediaItemDao.bulkInsert(collection1, true, true);
            GlobalMessagingBus.post(new ColdBootSaveEvent());
            return;
        }
    }

    private static boolean shouldDelete(Cursor cursor)
    {
        cursor = cursor.getString(cursor.getColumnIndex("status"));
        return "TRASH".equals(cursor) || "PURGED".equals(cursor);
    }

    public void addRelationship(Tag tag, MediaItem mediaitem)
    {
        if (mediaitem.getTags() == null)
        {
            HashSet hashset = new HashSet();
            hashset.add(tag);
            mediaitem.setTags(hashset);
            return;
        } else
        {
            mediaitem.getTags().add(tag);
            return;
        }
    }

    public volatile void addRelationship(Object obj, Object obj1)
    {
        addRelationship((Tag)obj, (MediaItem)obj1);
    }

    public MediaItem createChild(Cursor cursor)
    {
        return mMediaItemCursorConverter.convert(cursor);
    }

    public volatile Object createChild(Cursor cursor)
    {
        return createChild(cursor);
    }

    public Tag createPlaceholderParent(String s)
    {
        Tag tag = mTagDao.create(TagType.UNKNOWN);
        tag.setProperty(TagProperty.CLOUD);
        tag.setObjectId(CDSUtil.getObjectId(s));
        tag.setLabel("");
        tag.setValid(false);
        return tag;
    }

    public volatile Object createPlaceholderParent(String s)
    {
        return createPlaceholderParent(s);
    }

    public void delete(String s, Collection collection, Collection collection1)
        throws AccountChangedException
    {
        if (!s.equals(mAuthenticationManager.getAccountId()))
        {
            throw new AccountChangedException("The account has changed. Stop migration and do not delete data.");
        }
        s = new LinkedList();
        LinkedList linkedlist = new LinkedList();
        HashSet hashset = new HashSet();
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj = (String)collection.next();
            obj = mTagDao.getTagById(CDSUtil.getObjectId(((String) (obj))));
            if (obj != null)
            {
                s.add(obj);
            }
        } while (true);
        collection = collection1.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            collection1 = (String)collection.next();
            collection1 = mMediaItemDao.getItemById(CDSUtil.getObjectId(collection1));
            if (collection1 != null)
            {
                linkedlist.add(collection1);
                hashset.addAll(collection1.getTags());
            }
        } while (true);
        mTagDao.delete(s, true);
        mMediaItemDao.deleteCloudFields(linkedlist, true);
        mTagDao.deleteChildlessTags(hashset, true);
        mTagDao.notify(tagdaochangelist);
        GLogger.logCustomerEvent(TAG, new Object[] {
            "Deleted %d tags : %d mediaItems", Integer.valueOf(s.size()), Integer.valueOf(linkedlist.size())
        });
    }

    public Tag getExistingParent(String s, String s1)
        throws AccountChangedException
    {
        if (!s.equals(mAuthenticationManager.getAccountId()))
        {
            throw new AccountChangedException("The account has changed. Stop migration and do not check the database.");
        } else
        {
            s = CDSUtil.getObjectId(s1);
            return mTagDao.getTagById(s);
        }
    }

    public volatile Object getExistingParent(String s, String s1)
        throws AccountChangedException
    {
        return getExistingParent(s, s1);
    }

    public String[] getNeededColumns()
    {
        return (new String[] {
            "event_id", "node_id", "kind", "status", "is_video", "change_type", "name", "created_date", "is_image", "content_md5", 
            "content_type", "content_size", "content_version", "content_date", "image_width", "image_height", "video_width", "video_height", "video_duration", "is_root", 
            "image_date_time_original", "hidden", "has_share_parent"
        });
    }

    public boolean isChild(Cursor cursor)
    {
        return "FILE".equals(cursor.getString(cursor.getColumnIndex("kind"))) && (MixtapeCursorUtils.getBooleanFromCursor(cursor, "is_image") || MixtapeCursorUtils.getBooleanFromCursor(cursor, "is_video"));
    }

    public boolean isParent(Cursor cursor)
    {
        cursor = cursor.getString(cursor.getColumnIndex("kind"));
        return "VISUAL_COLLECTION".equals(cursor) || "FOLDER".equals(cursor);
    }

    public void notifyProcessingComplete(String s)
    {
        GLogger.d(TAG, "Node processing has completed", new Object[0]);
        if (s.equals(mAuthenticationManager.getAccountId()))
        {
            s = getAccountMetadataState();
            if ("COLDBOOT".equals(s) && !mSharedPreferences.getBoolean("partialSyncStatus", false))
            {
                GLogger.i(TAG, "Partial sync completed", new Object[0]);
                mSharedPreferences.edit().putBoolean("partialSyncStatus", true).apply();
                mContext.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, null);
            } else
            if ("READY".equals(s) && !mSharedPreferences.getBoolean("coldBootStatus", false))
            {
                GLogger.i(TAG, "Cold boot completed", new Object[0]);
                mSharedPreferences.edit().putBoolean("coldBootStatus", true).apply();
                mContext.getContentResolver().notifyChange(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, null);
                albumCoverPhotoRetriever.fetchAllAndPersist();
                return;
            }
        }
    }

    public void save(String s, Collection collection, Collection collection1, Collection collection2)
        throws AccountChangedException
    {
        if (!s.equals(mAuthenticationManager.getAccountId()))
        {
            throw new AccountChangedException("The account has changed. Stop migration and do not save data.");
        }
        s = new LinkedList(collection);
        s.addAll(collection1);
        saveData(s, collection2);
        GLogger.logCustomerEvent(TAG, new Object[] {
            "Saved %d tags : %d mediaItems", Integer.valueOf(s.size()), Integer.valueOf(collection2.size())
        });
        collection = new HashMap();
        for (collection1 = collection2.iterator(); collection1.hasNext();)
        {
            collection2 = (MediaItem)collection1.next();
            Iterator iterator = collection2.getTags().iterator();
            while (iterator.hasNext()) 
            {
                Tag tag1 = (Tag)iterator.next();
                if (!collection.containsKey(tag1))
                {
                    collection.put(tag1, new LinkedList());
                }
                ((List)collection.get(tag1)).add(collection2);
            }
        }

        collection1 = new TagDaoChangeList();
        Tag tag;
        for (collection2 = collection.keySet().iterator(); collection2.hasNext(); collection1.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED))
        {
            tag = (Tag)collection2.next();
            mTagDao.updateSortDateForTag(tag, (List)collection.get(tag), false, false);
        }

        mTagDao.deleteChildlessTags(new HashSet(s), false);
        mTagDao.notify(collection1);
    }

    public boolean shouldRemoveChild(Cursor cursor)
    {
        return shouldDelete(cursor);
    }

    public boolean shouldRemoveParent(Cursor cursor)
    {
        return shouldDelete(cursor);
    }

    public void updateExistingParent(Tag tag, Cursor cursor)
    {
        Tag tag1 = mTagCursorConverter.convert(cursor);
        if (tag.getType() == TagType.UNKNOWN)
        {
            if (MixtapeCursorUtils.getStringFromCursor(cursor, "kind").equals("VISUAL_COLLECTION"))
            {
                tag.setTagType(TagType.ALBUM);
            } else
            {
                tag.setTagType(TagType.FOLDER);
            }
        } else
        {
            tag.setTagType(tag.getType());
        }
        tag.setLabel(tag1.getLabel());
        tag.setDateCreatedMs(tag1.getDateCreatedMs());
        tag.setSortDateMs(tag1.getSortDateMs());
        tag.setHasSortDate(tag1.getHasSortDate());
        tag.setShared(tag1.isShared());
        ((TagSqliteImpl)tag).setProperties(((TagSqliteImpl)tag1).getProperties());
        if (tag.getType() == TagType.ALBUM && tag.getSortDateMs() == 0L)
        {
            tag.setSortDateMs(tag1.getDateCreatedMs());
            tag.setHasSortDate(true);
        }
        tag.setValid(true);
    }

    public void updateExistingParent(Tag tag, Tag tag1)
    {
        if (tag instanceof TagSqliteImpl)
        {
            ((TagSqliteImpl)tag).setId(tag1.getId());
            tag.setTagType(tag1.getType());
            tag.setValid(tag1.isValid());
            tag.setLabel(tag1.getLabel());
            tag.setSortDateMs(tag1.getSortDateMs());
            tag.setDateCreatedMs(tag1.getDateCreatedMs());
            tag.setHasSortDate(tag1.getHasSortDate());
            if (tag.getType() == TagType.ALBUM && tag.getSortDateMs() == 0L)
            {
                tag.setSortDateMs(tag1.getDateCreatedMs());
                tag.setHasSortDate(true);
            }
            ((TagSqliteImpl)tag).setProperties(((TagSqliteImpl)tag1).getProperties());
        }
    }

    public volatile void updateExistingParent(Object obj, Cursor cursor)
    {
        updateExistingParent((Tag)obj, cursor);
    }

    public volatile void updateExistingParent(Object obj, Object obj1)
    {
        updateExistingParent((Tag)obj, (Tag)obj1);
    }

}
