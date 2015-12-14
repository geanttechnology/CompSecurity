// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.deduplicate.CompositeDeduplicater;
import com.amazon.gallery.framework.data.dao.deduplicate.Deduplicater;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemDaoChangeList;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import com.amazon.gallery.framework.model.media.RewindPhoto;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.amazon.gallery.framework.data.dao.mediaitem:
//            MediaItemDao, AllMediaItemsObserver, MediaTypeObserver, MediaPropertyObserver, 
//            MediaTagObserver, MediaTagPropertyObserver, MediaTagTypeObserver

public class MediaItemDaoImpl
    implements MediaItemDao
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/mediaitem/MediaItemDaoImpl.getName();
    protected Set allItemsObservers;
    private CompositeDeduplicater deduplicater;
    protected LocalMediaItemDaoSqliteImpl localMediaItemDao;
    protected ConcurrentHashMap mediaTypeObservers;
    protected ConcurrentHashMap propertyObservers;
    protected ConcurrentHashMap tagObservers;
    protected ConcurrentHashMap tagPropertyObservers;
    protected ConcurrentHashMap tagTypeObservers;

    public MediaItemDaoImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        localMediaItemDao = localmediaitemdaosqliteimpl;
        allItemsObservers = new CopyOnWriteArraySet();
        tagTypeObservers = new ConcurrentHashMap();
        tagObservers = new ConcurrentHashMap();
        propertyObservers = new ConcurrentHashMap();
        mediaTypeObservers = new ConcurrentHashMap();
        tagPropertyObservers = new ConcurrentHashMap();
        deduplicater = new CompositeDeduplicater();
    }

    private Set copyCloudTags(Set set)
    {
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Tag tag = (Tag)set.next();
            if (tag.hasProperty(TagProperty.CLOUD))
            {
                hashset.add(tag);
            }
        } while (true);
        return hashset;
    }

    private Set copyLocalTags(Set set)
    {
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            Tag tag = (Tag)set.next();
            if (tag.hasProperty(TagProperty.LOCAL))
            {
                hashset.add(tag);
            }
        } while (true);
        return hashset;
    }

    private void doUnification(MediaItem mediaitem, MediaItem mediaitem1)
    {
        Set set = copyCloudTags(mediaitem1.getTags());
        Set set1 = copyLocalTags(mediaitem.getTags());
        set1.addAll(set);
        mediaitem.setTags(set1);
        mediaitem.setSyncState(mediaitem1.getSyncState());
        mediaitem.setObjectId(mediaitem1.getObjectId());
        if (mediaitem.getFullMd5() == null && mediaitem1.getFullMd5() != null)
        {
            mediaitem.setFullMd5(mediaitem1.getFullMd5());
        }
        boolean flag;
        if (mediaitem1.isHidden() || mediaitem.isHidden())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mediaitem.setHidden(flag);
    }

    private void mergeCloudMediaItemWithExistingMediaItem(MediaItem mediaitem)
    {
        Object obj;
        MediaItem mediaitem1;
        boolean flag;
        mediaitem1 = getItemById(mediaitem.getObjectId());
        flag = false;
        obj = mediaitem1;
        if (mediaitem1 != null) goto _L2; else goto _L1
_L1:
        obj = deduplicater.getLocalDuplicates(mediaitem);
        if (!((List) (obj)).isEmpty()) goto _L4; else goto _L3
_L3:
        if (GroupType.REWIND == mediaitem.getGroupType())
        {
            mediaitem.setGroupType(GroupType.NONE);
        }
_L6:
        return;
_L4:
        flag = true;
        obj = (MediaItem)((List) (obj)).get(0);
_L2:
        if (GroupType.REWIND == mediaitem.getGroupType() && GroupType.NONE == ((MediaItem) (obj)).getGroupType())
        {
            mediaitem.setGroupType(GroupType.NONE);
        }
        if (GroupType.LENTICULAR == mediaitem.getGroupType() && GroupType.LENTICULAR == ((MediaItem) (obj)).getGroupType() || GroupType.REWIND == mediaitem.getGroupType() && GroupType.REWIND == ((MediaItem) (obj)).getGroupType())
        {
            OrderedGroupPhoto orderedgroupphoto = (OrderedGroupPhoto)obj;
            ((OrderedGroupPhoto)mediaitem).setFrames(orderedgroupphoto.getFrames());
        }
        mediaitem.setLocalPath(((MediaItem) (obj)).getLocalPath());
        mediaitem.setSize(((MediaItem) (obj)).getSize());
        mediaitem.setProperties(new HashSet(((MediaItem) (obj)).getProperties()));
        mediaitem.getMetadata().putAll(((MediaItem) (obj)).getMetadata());
        Set set = copyLocalTags(((MediaItem) (obj)).getTags());
        Set set1 = copyCloudTags(mediaitem.getTags());
        set1.addAll(set);
        mediaitem.setTags(set1);
        mediaitem.setOrientation(((MediaItem) (obj)).getOrientation());
        if (flag)
        {
            deleteKeepFile(((MediaItem) (obj)), false);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void mergeCloudMediaItemWithExistingMediaItems(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); mergeCloudMediaItemWithExistingMediaItem((MediaItem)collection.next())) { }
    }

    private void mergeLocalMediaItemWithExistingMediaItem(MediaItem mediaitem)
    {
        List list = deduplicater.getCloudDuplicates(mediaitem);
        if (list.isEmpty())
        {
            return;
        }
        if (mediaitem.getId() != -1L && MediaItemUtil.isCloudMediaItem((MediaItem)list.get(0)))
        {
            localMediaItemDao.mergeToCloud(mediaitem, ((MediaItem)list.get(0)).getObjectId());
            return;
        } else
        {
            doUnification(mediaitem, (MediaItem)list.get(0));
            return;
        }
    }

    private void mergeLocalMediaItemWithExistingMediaItems(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); mergeLocalMediaItemWithExistingMediaItem((MediaItem)collection.next())) { }
    }

    private void notify(MediaItemDaoChangeList mediaitemdaochangelist)
    {
        notifyAllPropertyObservers(mediaitemdaochangelist);
        notifyMediaTypeObservers(mediaitemdaochangelist.getMediaTypes());
        notifyTagTypeObservers(mediaitemdaochangelist.getModifiedTagTypes());
        notifyTagObservers(mediaitemdaochangelist.getModifiedTags());
        notifyTagPropertyObservers(mediaitemdaochangelist.getModifiedTagProperties(), mediaitemdaochangelist.getAllChangeList());
        if (mediaitemdaochangelist.getModifiedMediaItems().size() > 0)
        {
            notifyAllItemsObservers(mediaitemdaochangelist.getAllChangeList());
        }
    }

    private void notifyAdditionalTags(Set set)
    {
        if (set == null || set.isEmpty())
        {
            return;
        } else
        {
            MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
            mediaitemdaochangelist.addContentsOf(set);
            notify(mediaitemdaochangelist);
            return;
        }
    }

    private void notifyAllItemsObservers(ChangeList changelist)
    {
        for (Iterator iterator = allItemsObservers.iterator(); iterator.hasNext(); ((AllMediaItemsObserver)iterator.next()).onMediaItemCollectionChanged(changelist)) { }
    }

    private void notifyAllPropertyObservers(MediaItemDaoChangeList mediaitemdaochangelist)
    {
        for (Iterator iterator = MediaProperty.getRegisteredMediaProperties().iterator(); iterator.hasNext(); notifyPropertyObservers((MediaProperty)iterator.next(), mediaitemdaochangelist)) { }
    }

    private void notifyMediaTypeObservers(MediaType mediatype)
    {
        Object obj = (Set)mediaTypeObservers.get(mediatype);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((MediaTypeObserver)((Iterator) (obj)).next()).onMediaItemCollectionChanged(mediatype)) { }
        }
    }

    private void notifyMediaTypeObservers(Set set)
    {
        for (set = set.iterator(); set.hasNext(); notifyMediaTypeObservers((MediaType)set.next())) { }
    }

    private void notifyPropertyObservers(MediaProperty mediaproperty, MediaItemDaoChangeList mediaitemdaochangelist)
    {
        Object obj = (Set)propertyObservers.get(mediaproperty);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((MediaPropertyObserver)((Iterator) (obj)).next()).onMediaItemCollectionChanged(mediaproperty, mediaitemdaochangelist)) { }
        }
    }

    private void notifyTagObservers(Tag tag)
    {
        Object obj = (Set)tagObservers.get(tag);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((MediaTagObserver)((Iterator) (obj)).next()).onMediaItemCollectionChanged(tag)) { }
        }
    }

    private void notifyTagObservers(Set set)
    {
        for (set = set.iterator(); set.hasNext(); notifyTagObservers((Tag)set.next())) { }
    }

    private void notifyTagPropertyObservers(TagProperty tagproperty, ChangeList changelist)
    {
        Object obj = (Set)tagPropertyObservers.get(tagproperty);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((MediaTagPropertyObserver)((Iterator) (obj)).next()).onMediaItemCollectionChanged(tagproperty, changelist)) { }
        }
    }

    private void notifyTagPropertyObservers(Set set, ChangeList changelist)
    {
        for (set = set.iterator(); set.hasNext(); notifyTagPropertyObservers((TagProperty)set.next(), changelist)) { }
    }

    private void notifyTagTypeObservers(TagType tagtype)
    {
        Object obj = (Set)tagTypeObservers.get(tagtype);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((MediaTagTypeObserver)((Iterator) (obj)).next()).onMediaItemCollectionChanged(tagtype)) { }
        }
    }

    private void notifyTagTypeObservers(Set set)
    {
        for (set = set.iterator(); set.hasNext(); notifyTagTypeObservers((TagType)set.next())) { }
    }

    public void addDeduplicater(Deduplicater deduplicater1)
    {
        deduplicater.addDeduplicater(deduplicater1);
    }

    public void addTagMemberships(List list, Tag tag)
    {
        localMediaItemDao.addTagMemberships(list, tag);
    }

    public void applyChangeList(ChangeList changelist, boolean flag)
    {
        MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
        if (changelist != null)
        {
            Set set = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
            mergeCloudMediaItemWithExistingMediaItems(set);
            mediaitemdaochangelist.addAll(localMediaItemDao.save(set));
            set = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
            mergeCloudMediaItemWithExistingMediaItems(set);
            mediaitemdaochangelist.addAll(localMediaItemDao.save(set));
            deleteCloudFields(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED), flag);
        }
        if (flag)
        {
            notify(mediaitemdaochangelist);
        }
    }

    public void bulkInsert(Collection collection, boolean flag, boolean flag1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        mergeCloudMediaItemWithExistingMediaItems(collection);
_L1:
        collection = localMediaItemDao.bulkInsert(collection);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        notify(collection);
        this;
        JVM INSTR monitorexit ;
        return;
        mergeLocalMediaItemWithExistingMediaItems(collection);
          goto _L1
        collection;
        throw collection;
    }

    public MediaItem create(MediaType mediatype)
    {
        return localMediaItemDao.create(mediatype);
    }

    public MediaItem create(MediaType mediatype, GroupType grouptype)
    {
        return localMediaItemDao.create(mediatype, grouptype);
    }

    public void deleteCloudFields(MediaItem mediaitem, boolean flag)
    {
        mediaitem = localMediaItemDao.getItemById(mediaitem.getObjectId());
        if (mediaitem == null)
        {
            return;
        }
        if (MediaItemUtil.isLocalMediaItem(mediaitem) || MediaItemUtil.hasLocalLenticularParts(mediaitem))
        {
            Set set = copyCloudTags(mediaitem.getTags());
            mediaitem.setTags(copyLocalTags(mediaitem.getTags()));
            mediaitem.setSyncState(SyncState.SKIPPED);
            saveMergedFields(mediaitem, flag);
            notifyAdditionalTags(set);
            return;
        } else
        {
            deleteItem(mediaitem, flag);
            return;
        }
    }

    public void deleteCloudFields(Collection collection, boolean flag)
    {
        for (collection = collection.iterator(); collection.hasNext(); deleteCloudFields((MediaItem)collection.next(), flag)) { }
    }

    public void deleteItem(MediaItem mediaitem, boolean flag)
    {
        mediaitem = localMediaItemDao.delete(mediaitem);
        if (flag)
        {
            notify(mediaitem);
        }
    }

    public void deleteItem(Collection collection, boolean flag)
    {
        collection = localMediaItemDao.delete(collection);
        if (flag)
        {
            notify(collection);
        }
    }

    public void deleteKeepFile(MediaItem mediaitem, boolean flag)
    {
        mediaitem = localMediaItemDao.deleteKeepFile(mediaitem);
        if (flag)
        {
            notify(mediaitem);
        }
    }

    public void deleteLocalFields(MediaItem mediaitem, boolean flag, boolean flag1)
    {
        MediaItem mediaitem1 = localMediaItemDao.getItemById(mediaitem.getObjectId());
        if (mediaitem1 == null)
        {
            return;
        }
        if (MediaItemUtil.isCloudMediaItem(mediaitem))
        {
            mediaitem = copyLocalTags(mediaitem1.getTags());
            mediaitem1.setTags(copyCloudTags(mediaitem1.getTags()));
            mediaitem1.setProperties(Collections.emptySet());
            mediaitem1.setLocalPath(null);
            if (MediaItemUtil.isRewindPhoto(mediaitem1))
            {
                RewindPhoto rewindphoto = (RewindPhoto)mediaitem1;
                rewindphoto.clearFrames();
                rewindphoto.setGroupType(GroupType.NONE);
            }
            mediaitem1.setSize(0L);
            saveMergedFields(mediaitem1, flag);
            notifyAdditionalTags(mediaitem);
            return;
        }
        if (flag1)
        {
            deleteKeepFile(mediaitem1, flag);
            return;
        } else
        {
            deleteItem(mediaitem1, flag);
            return;
        }
    }

    public void deleteLocalFields(Collection collection, boolean flag, boolean flag1)
    {
        for (collection = collection.iterator(); collection.hasNext(); deleteLocalFields((MediaItem)collection.next(), flag, flag1)) { }
    }

    public void deleteTagMemberships(List list, Tag tag)
    {
        localMediaItemDao.deleteTagMemberships(list, tag);
    }

    public MediaItemCollection getAllItems()
    {
        return localMediaItemDao.getAllItems();
    }

    public int getAutosaveableMediaItemCount(boolean flag)
    {
        return localMediaItemDao.getAutosaveableMediaItemCount(flag);
    }

    public Map getCloudCountByType()
    {
        return localMediaItemDao.getCloudCountByType();
    }

    public MediaItem getItemById(ObjectID objectid)
    {
        return localMediaItemDao.getItemById(objectid);
    }

    public Long getItemIdByObjectID(ObjectID objectid)
    {
        return localMediaItemDao.getItemIdByObjectID(objectid);
    }

    public MediaItemCollection getItemsByFullMd5(String s)
    {
        return localMediaItemDao.getItemsByFullMd5(s);
    }

    public MediaItemCollection getItemsByFullMd5AndSyncState(SyncState syncstate, String s)
    {
        return localMediaItemDao.getItemsByFullMd5AndSyncState(s, syncstate);
    }

    public MediaItemCollection getItemsByGroupType(GroupType grouptype)
    {
        return localMediaItemDao.getItemsByGroupType(grouptype);
    }

    public MediaItemCollection getItemsByLocalPath(String s)
    {
        return localMediaItemDao.getItemsByLocalPath(s);
    }

    public List getItemsByMetadata(String s, List list)
    {
        return localMediaItemDao.getItemsByMetadata(s, list);
    }

    public MediaItemCollection getItemsByMimeType(String s)
    {
        return localMediaItemDao.getItemsByMimeType(s);
    }

    public MediaItemCollection getItemsByProperty(MediaProperty mediaproperty, SortOrder sortorder)
    {
        return localMediaItemDao.getItemsByProperty(mediaproperty, sortorder);
    }

    public MediaItemCollection getItemsBySyncState(SyncState syncstate)
    {
        return localMediaItemDao.getItemsBySyncState(syncstate);
    }

    public MediaItemCollection getItemsByTag(Tag tag)
    {
        return localMediaItemDao.getItemsByTag(tag);
    }

    public MediaItemCollection getItemsByTag(Tag tag, MediaFilter mediafilter)
    {
        return localMediaItemDao.getItemsByTag(tag, mediafilter);
    }

    public int getMediaItemCount(Tag tag)
    {
        return localMediaItemDao.getMediaItemCount(tag);
    }

    public void getMediaItemDataFromRawQuery(String s, String as[], CursorRowProcessor cursorrowprocessor)
    {
        localMediaItemDao.getMediaItemDataFromRawQuery(s, as, cursorrowprocessor);
    }

    public long getMediaItemSizeForTag(Tag tag)
    {
        return localMediaItemDao.getMediaItemSizeForTag(tag);
    }

    public MediaItemCollection getPossibleDuplicateCutItems(MediaItem mediaitem)
    {
        return localMediaItemDao.getPossibleDuplicateCutItems(mediaitem);
    }

    public MediaItemCollection getPossibleDuplicateLocalItems(MediaItem mediaitem)
    {
        return localMediaItemDao.getPossibleDuplicateLocalItems(mediaitem);
    }

    public MediaItemCollection getUnuploadedItemsByTag(Tag tag)
    {
        return localMediaItemDao.getUnuploadedItemsByTag(tag);
    }

    public MediaItemCollection getUnuploadedItemsByTag(Tag tag, MediaFilter mediafilter)
    {
        return localMediaItemDao.getUnuploadedItemsByTag(tag, mediafilter);
    }

    public void mergeToCloud(MediaItem mediaitem, ObjectID objectid, boolean flag)
    {
        mediaitem = localMediaItemDao.mergeToCloud(mediaitem, objectid);
        if (flag)
        {
            notify(mediaitem);
        }
    }

    public void onAccountDeregistered()
    {
        localMediaItemDao.onAccountDeregistered();
    }

    public void onAccountRegistered()
    {
        deduplicater.onAccountRegistered();
    }

    public void registerObserverByTagProperty(MediaTagPropertyObserver mediatagpropertyobserver, TagProperty tagproperty)
    {
        HashSet hashset = new HashSet();
        tagproperty = (Set)tagPropertyObservers.putIfAbsent(tagproperty, hashset);
        if (tagproperty != null)
        {
            tagproperty.add(mediatagpropertyobserver);
            return;
        } else
        {
            hashset.add(mediatagpropertyobserver);
            return;
        }
    }

    public void registerObserverByTagType(MediaTagTypeObserver mediatagtypeobserver, TagType tagtype)
    {
        HashSet hashset = new HashSet();
        tagtype = (Set)tagTypeObservers.putIfAbsent(tagtype, hashset);
        if (tagtype != null)
        {
            tagtype.add(mediatagtypeobserver);
            return;
        } else
        {
            hashset.add(mediatagtypeobserver);
            return;
        }
    }

    public void saveCloudFields(Collection collection, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mergeCloudMediaItemWithExistingMediaItems(collection);
        saveMergedFields(collection, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        collection;
        throw collection;
    }

    public void saveLocalFields(MediaItem mediaitem, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mergeLocalMediaItemWithExistingMediaItem(mediaitem);
        saveMergedFields(mediaitem, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        mediaitem;
        throw mediaitem;
    }

    public void saveLocalFields(Collection collection, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mergeLocalMediaItemWithExistingMediaItems(collection);
        saveMergedFields(collection, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        collection;
        throw collection;
    }

    public void saveMergedFields(MediaItem mediaitem, boolean flag)
    {
        mediaitem = localMediaItemDao.save(mediaitem);
        if (flag)
        {
            notify(mediaitem);
        }
    }

    public void saveMergedFields(Collection collection, boolean flag)
    {
        collection = localMediaItemDao.save(collection);
        if (flag)
        {
            notify(collection);
        }
    }

    public void saveSyncState(ObjectID objectid, SyncState syncstate, boolean flag)
    {
        objectid = localMediaItemDao.getItemById(objectid);
        if (objectid != null)
        {
            objectid.setSyncState(syncstate);
            objectid = localMediaItemDao.save(objectid);
            if (flag)
            {
                notify(objectid);
                return;
            }
        }
    }

    public void unregisterObserver(MediaTagPropertyObserver mediatagpropertyobserver, TagProperty tagproperty)
    {
        tagproperty = (Set)tagPropertyObservers.get(tagproperty);
        if (tagproperty != null)
        {
            tagproperty.remove(mediatagpropertyobserver);
        }
    }

    public void unregisterObserver(MediaTagTypeObserver mediatagtypeobserver, TagType tagtype)
    {
        tagtype = (Set)tagTypeObservers.get(tagtype);
        if (tagtype != null)
        {
            tagtype.remove(mediatagtypeobserver);
        }
    }

}
