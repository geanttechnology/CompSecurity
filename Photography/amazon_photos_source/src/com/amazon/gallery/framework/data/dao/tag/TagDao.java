// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.tag;

import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.tag:
//            TagAllTagObserver, TagTagTypeObserver

public interface TagDao
{

    public abstract TagDaoChangeList bulkInsert(Collection collection, boolean flag);

    public abstract Tag create(TagType tagtype);

    public abstract void delete(Collection collection, boolean flag);

    public abstract void deleteChildlessTags(Set set, boolean flag);

    public abstract void filter(Set set, TagProperty tagproperty, boolean flag);

    public abstract Tag getTagById(ObjectID objectid);

    public abstract List getTags();

    public abstract List getTagsByPathPrefix(TagType tagtype, String s);

    public abstract List getTagsByProperty(TagType tagtype, TagProperty tagproperty);

    public abstract List getTagsByProperty(TagType tagtype, TagProperty tagproperty, SortOrder sortorder);

    public abstract List getTagsByType(TagType tagtype);

    public abstract List getTagsByType(TagType tagtype, SortOrder sortorder);

    public abstract void notify(TagDaoChangeList tagdaochangelist);

    public abstract void registerObserver(TagAllTagObserver tagalltagobserver);

    public abstract void registerObserver(TagTagTypeObserver tagtagtypeobserver, TagType tagtype);

    public abstract TagDaoChangeList removeTemporarySyncStates(Tag tag, boolean flag, boolean flag1, boolean flag2);

    public abstract void removeTemporarySyncStates(boolean flag, boolean flag1);

    public abstract TagDaoChangeList save(Collection collection, boolean flag);

    public abstract void save(Tag tag, boolean flag);

    public abstract void setSortTypeDao(SortTypeDao sorttypedao);

    public abstract void unregisterObserver(TagTagTypeObserver tagtagtypeobserver, TagType tagtype);

    public abstract boolean updateSortDateForTag(Tag tag, List list, boolean flag, boolean flag1);
}
