// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.tag;

import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.model.TagBeanImpl;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.amazon.gallery.framework.data.dao.tag:
//            TagDao, TagAllTagObserver, TagTagObserver, TagTagTypeObserver, 
//            LocalTagDao

public class TagDaoImpl
    implements TagDao
{

    protected Set allItemsObservers;
    private final LocalTagDao localTagDao;
    private SortTypeDao sortTypeDao;
    protected ConcurrentHashMap tagObservers;
    protected ConcurrentHashMap tagTypeObservers;

    public TagDaoImpl(LocalTagDao localtagdao)
    {
        allItemsObservers = Collections.newSetFromMap(new HashMap());
        tagTypeObservers = new ConcurrentHashMap();
        tagObservers = new ConcurrentHashMap();
        localTagDao = localtagdao;
    }

    private void notifyAllItemsObservers(ChangeList changelist)
    {
        for (Iterator iterator = allItemsObservers.iterator(); iterator.hasNext(); ((TagAllTagObserver)iterator.next()).onTagsChanged(changelist)) { }
    }

    private void notifyTagObservers(Tag tag)
    {
        Object obj = (Set)tagObservers.get(tag);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((TagTagObserver)((Iterator) (obj)).next()).onTagChanged(tag)) { }
        }
    }

    private void notifyTagObservers(Set set)
    {
        for (set = set.iterator(); set.hasNext(); notifyTagObservers((Tag)set.next())) { }
    }

    private void notifyTagTypeObservers(TagType tagtype, TagDaoChangeList tagdaochangelist)
    {
        Object obj = (Set)tagTypeObservers.get(tagtype);
        if (obj != null)
        {
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((TagTagTypeObserver)((Iterator) (obj)).next()).onTagsChanged(tagtype, tagdaochangelist.getChangeList(tagtype))) { }
        }
    }

    private void notifyTagTypeObservers(Set set, TagDaoChangeList tagdaochangelist)
    {
        for (set = set.iterator(); set.hasNext(); notifyTagTypeObservers((TagType)set.next(), tagdaochangelist)) { }
    }

    public void applyChangeList(ChangeList changelist, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        if (changelist == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        tagdaochangelist.addAll(localTagDao.save(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED)));
        tagdaochangelist.addAll(localTagDao.save(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED)));
        tagdaochangelist.addAll(localTagDao.delete(changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        notify(tagdaochangelist);
        this;
        JVM INSTR monitorexit ;
        return;
        changelist;
        throw changelist;
    }

    public TagDaoChangeList bulkInsert(Collection collection, boolean flag)
    {
        collection = localTagDao.bulkInsert(collection);
        if (flag)
        {
            notify(collection);
        }
        return collection;
    }

    public Tag create(TagType tagtype)
    {
        return localTagDao.create(tagtype);
    }

    public void delete(Collection collection, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        collection = localTagDao.delete(collection);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        notify(collection);
        this;
        JVM INSTR monitorexit ;
        return;
        collection;
        throw collection;
    }

    public void deleteChildlessTags(Set set, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        set = localTagDao.deleteChildlessTags(set);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        notify(set);
        this;
        JVM INSTR monitorexit ;
        return;
        set;
        throw set;
    }

    public void filter(Set set, TagProperty tagproperty, boolean flag)
    {
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            boolean flag1 = ((Tag)set.next()).hasProperty(tagproperty);
            if (flag && !flag1 || !flag && flag1)
            {
                set.remove();
            }
        } while (true);
    }

    public Tag getTagById(ObjectID objectid)
    {
        return localTagDao.getTagById(objectid);
    }

    public List getTags()
    {
        return localTagDao.getTags();
    }

    public List getTagsByPathPrefix(TagType tagtype, String s)
    {
        return localTagDao.getTagsByPathPrefix(tagtype, s);
    }

    public List getTagsByProperty(TagType tagtype, TagProperty tagproperty)
    {
        return localTagDao.getTagsByProperty(tagtype, tagproperty);
    }

    public List getTagsByProperty(TagType tagtype, TagProperty tagproperty, SortOrder sortorder)
    {
        return localTagDao.getTagsByProperty(tagtype, tagproperty, sortorder);
    }

    public List getTagsByType(TagType tagtype)
    {
        return localTagDao.getTagsByType(tagtype);
    }

    public List getTagsByType(TagType tagtype, SortOrder sortorder)
    {
        return localTagDao.getTagsByType(tagtype, sortorder);
    }

    public void notify(TagDaoChangeList tagdaochangelist)
    {
        Set set = tagdaochangelist.getModifiedTags();
        notifyTagTypeObservers(tagdaochangelist.getModifiedTagTypes(), tagdaochangelist);
        notifyTagObservers(set);
        if (set.size() > 0)
        {
            notifyAllItemsObservers(tagdaochangelist.getAllChangeList());
        }
    }

    public void registerObserver(TagAllTagObserver tagalltagobserver)
    {
        allItemsObservers.add(tagalltagobserver);
    }

    public void registerObserver(TagTagTypeObserver tagtagtypeobserver, TagType tagtype)
    {
        CopyOnWriteArraySet copyonwritearrayset = new CopyOnWriteArraySet();
        tagtype = (Set)tagTypeObservers.putIfAbsent(tagtype, copyonwritearrayset);
        if (tagtype != null)
        {
            tagtype.add(tagtagtypeobserver);
            return;
        } else
        {
            copyonwritearrayset.add(tagtagtypeobserver);
            return;
        }
    }

    public TagDaoChangeList removeTemporarySyncStates(Tag tag, boolean flag, boolean flag1, boolean flag2)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        if (localTagDao.removeTemporarySyncStates(tag, flag, flag1))
        {
            tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        }
        if (flag2)
        {
            notify(tagdaochangelist);
        }
        return tagdaochangelist;
    }

    public void removeTemporarySyncStates(boolean flag, boolean flag1)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        for (Iterator iterator = getTagsByType(TagType.LOCAL_FOLDER).iterator(); iterator.hasNext(); tagdaochangelist.addAll(removeTemporarySyncStates((Tag)iterator.next(), flag, flag1, false))) { }
        notify(tagdaochangelist);
    }

    public TagDaoChangeList save(Collection collection, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        collection = localTagDao.save(collection);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        notify(collection);
        this;
        JVM INSTR monitorexit ;
        return collection;
        collection;
        throw collection;
    }

    public void save(Tag tag, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        tag = localTagDao.save(tag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        notify(tag);
        this;
        JVM INSTR monitorexit ;
        return;
        tag;
        throw tag;
    }

    public void setSortTypeDao(SortTypeDao sorttypedao)
    {
        sortTypeDao = sorttypedao;
    }

    public void unregisterObserver(TagTagTypeObserver tagtagtypeobserver, TagType tagtype)
    {
        tagtype = (Set)tagTypeObservers.get(tagtype);
        if (tagtype != null)
        {
            tagtype.remove(tagtagtypeobserver);
        }
    }

    public boolean updateSortDateForTag(Tag tag, List list, boolean flag, boolean flag1)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag4 = false;
_L4:
        return flag4;
_L2:
        boolean flag2;
        boolean flag3;
        long l1;
        long l2;
        flag4 = tag.getHasSortDate();
        long l3 = tag.getSortDateMs();
        MediaItemSortType mediaitemsorttype = sortTypeDao.getSortTypeById(tag.getObjectId().toString());
        long l;
        if (flag1)
        {
            l = 0L;
        } else
        {
            l = l3;
        }
        if (flag1)
        {
            l2 = 0L;
        } else
        {
            l2 = l3;
        }
        list = list.iterator();
        l1 = l;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            l = mediaitemsorttype.getSortingDate((MediaItem)list.next());
            if (l2 == 0L || l1 == 0L)
            {
                l2 = l;
                l1 = l;
            } else
            if (l != 0L && l >= l2)
            {
                l2 = l;
            } else
            if (l != 0L && l < l1)
            {
                l1 = l;
            }
        } while (true);
        if (l2 != l3 && l2 != 0L && mediaitemsorttype.isDescending())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (l1 != l3 && l1 != 0L && !mediaitemsorttype.isDescending())
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (l2 == 0L && flag4 || flag2 || flag3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag4 = flag1;
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (l2 != 0L) goto _L6; else goto _L5
_L5:
        tag.setHasSortDate(false);
        tag.setSortDateMs(TagBeanImpl.NO_SORT_DATE);
_L8:
        list = new ChangeList();
        list.add(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        applyChangeList(list, flag);
        return flag1;
_L6:
        if (flag2)
        {
            tag.setHasSortDate(true);
            tag.setSortDateMs(l2);
        } else
        if (flag3)
        {
            tag.setHasSortDate(true);
            tag.setSortDateMs(l1);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
