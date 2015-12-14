// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.tag;

import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface LocalTagDao
{

    public abstract TagDaoChangeList bulkInsert(Collection collection);

    public abstract Tag create(TagType tagtype);

    public abstract TagDaoChangeList delete(Collection collection);

    public abstract TagDaoChangeList deleteChildlessTags(Set set);

    public abstract Tag getTagById(ObjectID objectid);

    public abstract List getTags();

    public abstract Set getTagsByMediaItem(MediaItem mediaitem);

    public abstract List getTagsByPathPrefix(TagType tagtype, String s);

    public abstract List getTagsByProperty(TagType tagtype, TagProperty tagproperty);

    public abstract List getTagsByProperty(TagType tagtype, TagProperty tagproperty, SortOrder sortorder);

    public abstract List getTagsByType(TagType tagtype);

    public abstract List getTagsByType(TagType tagtype, SortOrder sortorder);

    public abstract boolean removeTemporarySyncStates(Tag tag, boolean flag, boolean flag1);

    public abstract TagDaoChangeList save(Tag tag);

    public abstract TagDaoChangeList save(Collection collection);
}
