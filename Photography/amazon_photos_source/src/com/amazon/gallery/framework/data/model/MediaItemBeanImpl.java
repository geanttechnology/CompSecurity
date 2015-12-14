// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class MediaItemBeanImpl
    implements MediaItem
{

    protected int assetHash;
    protected String caption;
    protected long dateAddedMs;
    protected long dateCreatedMs;
    protected long dateCreatedUTCMs;
    protected long dateModifiedMs;
    protected long eventId;
    protected String fullMd5;
    protected GroupType groupType;
    protected int height;
    protected boolean hidden;
    protected long id;
    protected String lat;
    protected Map localMetadata;
    protected String localPath;
    protected String lon;
    protected Map metadata;
    protected String mimeType;
    protected String name;
    protected ObjectID objectId;
    protected int orientation;
    protected ObjectID parentObjectId;
    protected Set properties;
    protected long size;
    protected SyncState syncState;
    protected Set tags;
    protected long timeStampMs;
    protected ObjectID uploadedObjectId;
    protected int width;

    public MediaItemBeanImpl()
    {
        id = -1L;
        tags = new HashSet();
        properties = new HashSet();
        metadata = new HashMap();
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
            obj = (MediaItemBeanImpl)obj;
            if (!ObjectID.objectIdEqual(objectId, ((MediaItemBeanImpl) (obj)).objectId))
            {
                return false;
            }
        }
        return true;
    }

    public int getAssetHash()
    {
        return assetHash;
    }

    public String getCaption()
    {
        return caption;
    }

    public long getDateAddedMs()
    {
        return dateAddedMs;
    }

    public long getDateCreatedMs()
    {
        return dateCreatedMs;
    }

    public long getDateCreatedUTCMs()
    {
        return dateCreatedUTCMs;
    }

    public long getDateModifiedMs()
    {
        return dateModifiedMs;
    }

    public long getEventId()
    {
        return eventId;
    }

    public String getFullMd5()
    {
        return fullMd5;
    }

    public GroupType getGroupType()
    {
        return groupType;
    }

    public int getHeight()
    {
        return height;
    }

    public long getId()
    {
        return id;
    }

    public Map getLocalMetadata()
    {
        if (localMetadata == null)
        {
            localMetadata = new HashMap();
        }
        return localMetadata;
    }

    public String getLocalPath()
    {
        return localPath;
    }

    public String getMIMEType()
    {
        if (mimeType == null || mimeType.equals(""))
        {
            setMIMEType(MimeTypeUtil.getMimeTypeFromPath(name));
        }
        return mimeType;
    }

    public Map getMetadata()
    {
        return metadata;
    }

    public String getName()
    {
        return name;
    }

    public ObjectID getObjectId()
    {
        return objectId;
    }

    public int getOrientation()
    {
        return orientation;
    }

    public ObjectID getParentObjectID()
    {
        return parentObjectId;
    }

    public Set getProperties()
    {
        return properties;
    }

    public long getSize()
    {
        return size;
    }

    public SyncState getSyncState()
    {
        return syncState;
    }

    public Set getTags()
    {
        return tags;
    }

    public long getTimestampMs()
    {
        return timeStampMs;
    }

    public MediaType getType()
    {
        return null;
    }

    public ObjectID getUploadedObjectId()
    {
        return uploadedObjectId;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean hasDate()
    {
        return dateCreatedMs > 0L;
    }

    public boolean hasProperty(MediaProperty mediaproperty)
    {
        if (properties == null)
        {
            return false;
        } else
        {
            return properties.contains(mediaproperty);
        }
    }

    public boolean hasTimestamp()
    {
        return timeStampMs != 0L;
    }

    public int hashCode()
    {
        int i;
        if (objectId != null)
        {
            i = objectId.hashCode();
        } else
        {
            i = 0;
        }
        return i + 31;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public boolean isPersisted()
    {
        return id != -1L;
    }

    public void setAssetHash(int i)
    {
        assetHash = i;
    }

    public void setCaption(String s)
    {
        caption = s;
    }

    public void setDateAddedMs(long l)
    {
        dateAddedMs = l;
    }

    public void setDateCreatedMs(long l)
    {
        dateCreatedMs = l;
    }

    public void setDateCreatedUTCMs(long l)
    {
        dateCreatedUTCMs = l;
    }

    public void setDateModifiedMs(long l)
    {
        dateModifiedMs = l;
    }

    public void setEventId(long l)
    {
        eventId = l;
    }

    public void setFullMd5(String s)
    {
        fullMd5 = s;
    }

    public void setGroupType(GroupType grouptype)
    {
        groupType = grouptype;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setHidden(boolean flag)
    {
        hidden = flag;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setLat(String s)
    {
        lat = s;
    }

    public void setLocalPath(String s)
    {
        localPath = s;
    }

    public void setLon(String s)
    {
        lon = s;
    }

    public void setMIMEType(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        mimeType = s1;
    }

    public void setMetadata(Map map)
    {
        metadata = map;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setObjectId(ObjectID objectid)
    {
        objectId = objectid;
    }

    public void setOrientation(int i)
    {
        orientation = i;
    }

    public void setParentObjectID(ObjectID objectid)
    {
        parentObjectId = objectid;
    }

    public void setProperties(Set set)
    {
        properties = set;
    }

    public void setSize(long l)
    {
        size = l;
    }

    public void setSyncState(SyncState syncstate)
    {
        syncState = syncstate;
    }

    public void setTags(Set set)
    {
        tags = set;
    }

    public void setTimestampMs(long l)
    {
        timeStampMs = l;
    }

    public void setUploadedObjectId(ObjectID objectid)
    {
        uploadedObjectId = objectid;
    }

    public void setWidth(int i)
    {
        width = i;
    }

    public String toString()
    {
        return (new ToStringBuilder(this)).append("rowId", id).append("objectId", objectId).append("width", width).append("height", height).append("caption", caption).append("properties", properties).append("localPath", localPath).toString();
    }
}
