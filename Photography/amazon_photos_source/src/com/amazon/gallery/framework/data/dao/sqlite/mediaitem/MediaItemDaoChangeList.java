// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagSqliteImpl;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MediaItemDaoChangeList
{

    private final ChangeList allChangeList = new ChangeList();
    private final Set modifiedMediaItems = new HashSet();
    private final Set modifiedMediaProperties = new HashSet();
    private final Set modifiedMediaTypes = new HashSet();
    private final Set modifiedTagProperties = new HashSet();
    private final Set modifiedTagTypes = new HashSet();
    private final Set modifiedTags = new HashSet();

    public MediaItemDaoChangeList()
    {
    }

    private void addModifiedItem(MediaItem mediaitem)
    {
        modifiedMediaItems.add(mediaitem);
    }

    private void addModifiedItem(MediaType mediatype)
    {
        modifiedMediaTypes.add(mediatype);
    }

    private void addModifiedItem(Tag tag)
    {
        modifiedTags.add(tag);
    }

    private void addModifiedItem(TagProperty tagproperty)
    {
        modifiedTagProperties.add(tagproperty);
    }

    private void addModifiedItem(TagType tagtype)
    {
        modifiedTagTypes.add(tagtype);
    }

    private void addModifiedMediaItems(Set set)
    {
        modifiedMediaItems.addAll(set);
    }

    private void addModifiedMediaProperties(Set set)
    {
        modifiedMediaProperties.addAll(set);
    }

    private void addModifiedTagTypes(Set set)
    {
        modifiedTagTypes.addAll(set);
    }

    private void addModifiedTags(Set set)
    {
        modifiedTags.addAll(set);
    }

    public void addAll(MediaItemDaoChangeList mediaitemdaochangelist)
    {
        addModifiedMediaItems(mediaitemdaochangelist.getModifiedMediaItems());
        addModifiedTags(mediaitemdaochangelist.getModifiedTags());
        addModifiedTagTypes(mediaitemdaochangelist.getModifiedTagTypes());
        addModifiedMediaProperties(mediaitemdaochangelist.getMediaProperties());
        modifiedMediaTypes.addAll(mediaitemdaochangelist.getMediaTypes());
        mediaitemdaochangelist = mediaitemdaochangelist.getAllChangeList();
        com.amazon.gallery.framework.data.dao.ChangeList.ChangeType achangetype[] = com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.values();
        int j = achangetype.length;
        for (int i = 0; i < j; i++)
        {
            com.amazon.gallery.framework.data.dao.ChangeList.ChangeType changetype = achangetype[i];
            allChangeList.addAll(mediaitemdaochangelist.getChangeListForType(changetype), changetype);
        }

    }

    public void addContentsOf(MediaItem mediaitem, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType changetype)
    {
        addModifiedMediaProperties(mediaitem.getProperties());
        addModifiedItem(mediaitem);
        addModifiedItem(mediaitem.getType());
        allChangeList.add(mediaitem, changetype);
        for (mediaitem = mediaitem.getTags().iterator(); mediaitem.hasNext(); addContentsOf((Tag)mediaitem.next())) { }
    }

    public void addContentsOf(Tag tag)
    {
        addModifiedItem(tag);
        addModifiedItem(tag.getType());
        for (tag = ((TagSqliteImpl)tag).getProperties().iterator(); tag.hasNext(); addModifiedItem((TagProperty)tag.next())) { }
    }

    public void addContentsOf(Collection collection)
    {
        if (collection != null)
        {
            collection = collection.iterator();
            while (collection.hasNext()) 
            {
                addContentsOf((Tag)collection.next());
            }
        }
    }

    public void clear()
    {
        modifiedTags.clear();
        modifiedMediaItems.clear();
        modifiedTagTypes.clear();
        modifiedMediaProperties.clear();
        modifiedMediaTypes.clear();
        modifiedTagProperties.clear();
        allChangeList.clear();
    }

    public ChangeList getAllChangeList()
    {
        return allChangeList;
    }

    public Set getMediaProperties()
    {
        return modifiedMediaProperties;
    }

    public Set getMediaTypes()
    {
        return modifiedMediaTypes;
    }

    public Set getModifiedMediaItems()
    {
        return modifiedMediaItems;
    }

    public Set getModifiedTagProperties()
    {
        return modifiedTagProperties;
    }

    public Set getModifiedTagTypes()
    {
        return modifiedTagTypes;
    }

    public Set getModifiedTags()
    {
        return modifiedTags;
    }
}
