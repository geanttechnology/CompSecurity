// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.media;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.model.media:
//            GroupType, SyncState, MediaType, MediaProperty

public interface MediaItem
    extends Persistable
{

    public abstract int getAssetHash();

    public abstract long getDateAddedMs();

    public abstract long getDateCreatedMs();

    public abstract long getDateCreatedUTCMs();

    public abstract long getDateModifiedMs();

    public abstract String getFullMd5();

    public abstract GroupType getGroupType();

    public abstract int getHeight();

    public abstract Map getLocalMetadata();

    public abstract String getLocalPath();

    public abstract String getMIMEType();

    public abstract Map getMetadata();

    public abstract String getName();

    public abstract int getOrientation();

    public abstract ObjectID getParentObjectID();

    public abstract Set getProperties();

    public abstract long getSize();

    public abstract SyncState getSyncState();

    public abstract Set getTags();

    public abstract long getTimestampMs();

    public abstract MediaType getType();

    public abstract int getWidth();

    public abstract boolean hasProperty(MediaProperty mediaproperty);

    public abstract boolean isHidden();

    public abstract void setAssetHash(int i);

    public abstract void setDateAddedMs(long l);

    public abstract void setDateCreatedMs(long l);

    public abstract void setDateCreatedUTCMs(long l);

    public abstract void setDateModifiedMs(long l);

    public abstract void setEventId(long l);

    public abstract void setFullMd5(String s);

    public abstract void setGroupType(GroupType grouptype);

    public abstract void setHeight(int i);

    public abstract void setHidden(boolean flag);

    public abstract void setLocalPath(String s);

    public abstract void setMIMEType(String s);

    public abstract void setMetadata(Map map);

    public abstract void setName(String s);

    public abstract void setOrientation(int i);

    public abstract void setParentObjectID(ObjectID objectid);

    public abstract void setProperties(Set set);

    public abstract void setSize(long l);

    public abstract void setSyncState(SyncState syncstate);

    public abstract void setTags(Set set);

    public abstract void setTimestampMs(long l);

    public abstract void setWidth(int i);
}
