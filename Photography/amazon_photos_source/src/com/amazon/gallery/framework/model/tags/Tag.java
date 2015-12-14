// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.Serializable;

// Referenced classes of package com.amazon.gallery.framework.model.tags:
//            TagType, TagProperty

public interface Tag
    extends Persistable, Serializable
{

    public abstract ObjectID getCoverId();

    public abstract MediaItem getCoverItem();

    public abstract ObjectID getCustomCoverId();

    public abstract int getDatabaseVersion();

    public abstract long getDateCreatedMs();

    public abstract boolean getHasSortDate();

    public abstract String getLabel();

    public abstract String getLocalMetaField(String s);

    public abstract String getLocalPath();

    public abstract int getMediaItemsSyncVersion();

    public abstract long getSortDateMs();

    public abstract int getTagSyncVersion();

    public abstract long getTimestampMs();

    public abstract TagType getType();

    public abstract boolean hasProperty(TagProperty tagproperty);

    public abstract boolean isPersisted();

    public abstract boolean isShared();

    public abstract boolean isValid();

    public abstract void setCoverId(ObjectID objectid);

    public abstract void setCustomCoverId(ObjectID objectid);

    public abstract void setDateCreatedMs(long l);

    public abstract void setHasSortDate(boolean flag);

    public abstract void setLabel(String s);

    public abstract void setLocalMetaField(String s, String s1);

    public abstract void setLocalPath(String s);

    public abstract void setProperty(TagProperty tagproperty);

    public abstract void setShared(boolean flag);

    public abstract void setSortDateMs(long l);

    public abstract void setTagType(TagType tagtype);

    public abstract void setValid(boolean flag);

    public abstract boolean visiblyEqual(Tag tag);
}
