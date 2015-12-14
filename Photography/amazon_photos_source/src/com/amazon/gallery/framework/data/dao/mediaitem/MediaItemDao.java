// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.deduplicate.Deduplicater;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.data.dao.mediaitem:
//            MediaTagPropertyObserver, MediaTagTypeObserver

public interface MediaItemDao
    extends AccountChangeListener
{

    public abstract void addDeduplicater(Deduplicater deduplicater);

    public abstract void addTagMemberships(List list, Tag tag);

    public abstract void applyChangeList(ChangeList changelist, boolean flag);

    public abstract void bulkInsert(Collection collection, boolean flag, boolean flag1);

    public abstract MediaItem create(MediaType mediatype);

    public abstract MediaItem create(MediaType mediatype, GroupType grouptype);

    public abstract void deleteCloudFields(MediaItem mediaitem, boolean flag);

    public abstract void deleteCloudFields(Collection collection, boolean flag);

    public abstract void deleteItem(Collection collection, boolean flag);

    public abstract void deleteLocalFields(MediaItem mediaitem, boolean flag, boolean flag1);

    public abstract void deleteLocalFields(Collection collection, boolean flag, boolean flag1);

    public abstract void deleteTagMemberships(List list, Tag tag);

    public abstract MediaItemCollection getAllItems();

    public abstract int getAutosaveableMediaItemCount(boolean flag);

    public abstract Map getCloudCountByType();

    public abstract MediaItem getItemById(ObjectID objectid);

    public abstract Long getItemIdByObjectID(ObjectID objectid);

    public abstract MediaItemCollection getItemsByFullMd5(String s);

    public abstract MediaItemCollection getItemsByFullMd5AndSyncState(SyncState syncstate, String s);

    public abstract MediaItemCollection getItemsByGroupType(GroupType grouptype);

    public abstract MediaItemCollection getItemsByLocalPath(String s);

    public abstract List getItemsByMetadata(String s, List list);

    public abstract MediaItemCollection getItemsByMimeType(String s);

    public abstract MediaItemCollection getItemsByProperty(MediaProperty mediaproperty, SortOrder sortorder);

    public abstract MediaItemCollection getItemsBySyncState(SyncState syncstate);

    public abstract MediaItemCollection getItemsByTag(Tag tag);

    public abstract MediaItemCollection getItemsByTag(Tag tag, MediaFilter mediafilter);

    public abstract int getMediaItemCount(Tag tag);

    public abstract void getMediaItemDataFromRawQuery(String s, String as[], CursorRowProcessor cursorrowprocessor);

    public abstract long getMediaItemSizeForTag(Tag tag);

    public abstract MediaItemCollection getPossibleDuplicateCutItems(MediaItem mediaitem);

    public abstract MediaItemCollection getPossibleDuplicateLocalItems(MediaItem mediaitem);

    public abstract MediaItemCollection getUnuploadedItemsByTag(Tag tag);

    public abstract MediaItemCollection getUnuploadedItemsByTag(Tag tag, MediaFilter mediafilter);

    public abstract void mergeToCloud(MediaItem mediaitem, ObjectID objectid, boolean flag);

    public abstract void onAccountRegistered();

    public abstract void registerObserverByTagProperty(MediaTagPropertyObserver mediatagpropertyobserver, TagProperty tagproperty);

    public abstract void registerObserverByTagType(MediaTagTypeObserver mediatagtypeobserver, TagType tagtype);

    public abstract void saveCloudFields(Collection collection, boolean flag);

    public abstract void saveLocalFields(MediaItem mediaitem, boolean flag);

    public abstract void saveLocalFields(Collection collection, boolean flag);

    public abstract void saveMergedFields(MediaItem mediaitem, boolean flag);

    public abstract void saveMergedFields(Collection collection, boolean flag);

    public abstract void saveSyncState(ObjectID objectid, SyncState syncstate, boolean flag);

    public abstract void unregisterObserver(MediaTagPropertyObserver mediatagpropertyobserver, TagProperty tagproperty);

    public abstract void unregisterObserver(MediaTagTypeObserver mediatagtypeobserver, TagType tagtype);
}
