// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import java.util.HashMap;
import java.util.Map;

public abstract class TagBeanImpl
    implements Tag
{

    public static long NO_SORT_DATE = 0x8000000000000000L;
    private ObjectID coverId;
    private ObjectID customCoverId;
    private int databaseVersion;
    private long dateCreatedMs;
    private boolean hasSortDate;
    protected long id;
    protected String label;
    private Map localMetadata;
    private String localPath;
    private int mediaItemsSyncVersion;
    protected ObjectID objectId;
    protected Map properties;
    private boolean shared;
    private long sortDateMs;
    private int tagSyncVersion;
    private long timestampMs;
    private boolean valid;

    public TagBeanImpl()
    {
        id = -1L;
        properties = new HashMap();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (TagBeanImpl)obj;
            if (!ObjectID.objectIdEqual(objectId, ((TagBeanImpl) (obj)).objectId))
            {
                return false;
            }
        }
        return true;
    }

    public ObjectID getCoverId()
    {
        return coverId;
    }

    public ObjectID getCustomCoverId()
    {
        return customCoverId;
    }

    public int getDatabaseVersion()
    {
        return databaseVersion;
    }

    public long getDateCreatedMs()
    {
        return dateCreatedMs;
    }

    public boolean getHasSortDate()
    {
        return hasSortDate;
    }

    public long getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getLocalMetaField(String s)
    {
        if (localMetadata == null)
        {
            return null;
        } else
        {
            return (String)localMetadata.get(s);
        }
    }

    public String getLocalPath()
    {
        return localPath;
    }

    public int getMediaItemsSyncVersion()
    {
        return mediaItemsSyncVersion;
    }

    public ObjectID getObjectId()
    {
        return objectId;
    }

    public long getSortDateMs()
    {
        return sortDateMs;
    }

    public int getTagSyncVersion()
    {
        return tagSyncVersion;
    }

    public long getTimestampMs()
    {
        return timestampMs;
    }

    public boolean hasProperty(TagProperty tagproperty)
    {
        return properties.containsValue(tagproperty);
    }

    public int hashCode()
    {
        if (objectId != null)
        {
            return objectId.hashCode();
        } else
        {
            return 0;
        }
    }

    public boolean isPersisted()
    {
        return id != -1L;
    }

    public boolean isShared()
    {
        return shared;
    }

    public boolean isValid()
    {
        return valid;
    }

    public void setCoverId(ObjectID objectid)
    {
        coverId = objectid;
    }

    public void setCustomCoverId(ObjectID objectid)
    {
        customCoverId = objectid;
    }

    public void setDatabaseVersion(int i)
    {
        databaseVersion = i;
    }

    public void setDateCreatedMs(long l)
    {
        dateCreatedMs = l;
    }

    public void setHasSortDate(boolean flag)
    {
        hasSortDate = flag;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setLocalMetaField(String s, String s1)
    {
        if (localMetadata == null)
        {
            localMetadata = new HashMap();
        }
        localMetadata.put(s, s1);
    }

    public void setLocalPath(String s)
    {
        localPath = s;
    }

    public void setMediaItemsSyncVersion(int i)
    {
        mediaItemsSyncVersion = i;
    }

    public void setObjectId(ObjectID objectid)
    {
        objectId = objectid;
    }

    public void setProperty(TagProperty tagproperty)
    {
        properties.put(tagproperty.getClass(), tagproperty);
    }

    public void setShared(boolean flag)
    {
        shared = flag;
    }

    public void setSortDateMs(long l)
    {
        sortDateMs = l;
    }

    public void setTagSyncVersion(int i)
    {
        tagSyncVersion = i;
    }

    public void setTimestampMs(long l)
    {
        timestampMs = l;
    }

    public void setValid(boolean flag)
    {
        valid = flag;
    }

    public String toString()
    {
        return String.format("Tag[ObjectID: %s, Label: %s]", new Object[] {
            getObjectId(), getLabel()
        });
    }

    public boolean visiblyEqual(Tag tag)
    {
        while (!equals(tag) || getCoverId() == null && tag.getCoverId() != null || getCoverId() != null && !getCoverId().equals(tag.getCoverId()) || getCustomCoverId() == null && tag.getCustomCoverId() != null || getCustomCoverId() != null && !getCustomCoverId().equals(tag.getCustomCoverId()) || getLabel() != null && !getLabel().equals(tag.getLabel())) 
        {
            return false;
        }
        return true;
    }

}
