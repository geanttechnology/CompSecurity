// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import java.io.File;

public interface TagFactory
{

    public abstract Tag createLocalTag(ObjectID objectid, String s, File file, MediaItem mediaitem);

    public abstract boolean isInCameraDirectory(File file);

    public abstract void setCameraDirPath(String s);

    public abstract void setRemovableCameraDirPath(String s);
}
