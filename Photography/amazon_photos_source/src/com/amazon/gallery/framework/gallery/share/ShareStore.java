// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.share;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;

public interface ShareStore
{

    public abstract File getSharedDirectory();

    public abstract File prepareMediaItemForSharing(MediaItem mediaitem, int i, int j, com.amazon.gallery.framework.data.store.Asset.AssetType assettype);

    public abstract File prepareMediaItemForSharing(MediaItem mediaitem, int i, int j, com.amazon.gallery.framework.data.store.Asset.AssetType assettype, int k);

    public abstract File prepareThumbnailForSharing(MediaItem mediaitem, int i, int j);

    public abstract File resolveNameConflict(File file, long l);
}
