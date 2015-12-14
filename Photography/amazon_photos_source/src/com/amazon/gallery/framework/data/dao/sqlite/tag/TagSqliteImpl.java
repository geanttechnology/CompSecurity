// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.model.TagBeanImpl;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TagSqliteImpl extends TagBeanImpl
{

    protected transient MediaItem coverItem;
    private boolean localPathDirtyFlag;
    protected TagType tagType;

    public TagSqliteImpl(TagType tagtype)
    {
        localPathDirtyFlag = false;
        tagType = tagtype;
    }

    public boolean clearLocalPathDirtyFlag()
    {
        boolean flag = localPathDirtyFlag;
        localPathDirtyFlag = false;
        return flag;
    }

    public MediaItem getCoverItem()
    {
        return coverItem;
    }

    public Set getProperties()
    {
        return new HashSet(properties.values());
    }

    public TagType getType()
    {
        return tagType;
    }

    public void setCoverItem(MediaItem mediaitem)
    {
        coverItem = mediaitem;
    }

    public void setLocalPath(String s)
    {
        if (getLocalPath() != null)
        {
            localPathDirtyFlag = true;
        }
        super.setLocalPath(s);
    }

    public void setProperties(Set set)
    {
        properties = new HashMap();
        TagProperty tagproperty;
        for (set = set.iterator(); set.hasNext(); properties.put(tagproperty.getClass(), tagproperty))
        {
            tagproperty = (TagProperty)set.next();
        }

    }

    public void setTagType(TagType tagtype)
    {
        tagType = tagtype;
    }
}
