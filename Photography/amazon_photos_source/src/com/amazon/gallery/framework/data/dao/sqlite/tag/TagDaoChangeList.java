// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TagDaoChangeList
{

    private final ChangeList allChangeList = new ChangeList();
    private final Map changeListMap = new HashMap();
    private final Set modifiedTagTypes = new HashSet();
    private final Set modifiedTags = new HashSet();

    public TagDaoChangeList()
    {
    }

    private void addAllChangeList(ChangeList changelist)
    {
        Set set = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
        allChangeList.addAll(set, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.ADDED);
        set = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        allChangeList.addAll(set, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        changelist = changelist.getChangeListForType(com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
        allChangeList.addAll(changelist, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.REMOVED);
    }

    private void addAllChangeListMap(Map map)
    {
        changeListMap.putAll(map);
    }

    private void addModifiedItem(Tag tag)
    {
        modifiedTags.add(tag);
    }

    private void addModifiedTagTypes(Set set)
    {
        modifiedTagTypes.addAll(set);
    }

    private void addModifiedTags(Set set)
    {
        modifiedTags.addAll(set);
    }

    public void addAll(TagDaoChangeList tagdaochangelist)
    {
        addModifiedTags(tagdaochangelist.getModifiedTags());
        addModifiedTagTypes(tagdaochangelist.getModifiedTagTypes());
        addAllChangeList(tagdaochangelist.getAllChangeList());
        addAllChangeListMap(tagdaochangelist.getChangeListMap());
    }

    public void addContentsOf(Tag tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType changetype)
    {
        addModifiedItem(tag);
        addModifiedItem(tag.getType());
        allChangeList.add(tag, changetype);
        ChangeList changelist1 = (ChangeList)changeListMap.get(tag.getType());
        ChangeList changelist = changelist1;
        if (changelist1 == null)
        {
            changelist = new ChangeList();
            changeListMap.put(tag.getType(), changelist);
        }
        changelist.add(tag, changetype);
    }

    public void addModifiedItem(TagType tagtype)
    {
        modifiedTagTypes.add(tagtype);
    }

    public ChangeList getAllChangeList()
    {
        return allChangeList;
    }

    public ChangeList getChangeList(TagType tagtype)
    {
        ChangeList changelist = (ChangeList)changeListMap.get(tagtype);
        tagtype = changelist;
        if (changelist == null)
        {
            tagtype = new ChangeList();
        }
        return tagtype;
    }

    public Map getChangeListMap()
    {
        return changeListMap;
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
