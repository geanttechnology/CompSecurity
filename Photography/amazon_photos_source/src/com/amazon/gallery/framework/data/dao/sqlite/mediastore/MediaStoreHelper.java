// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.Context;
import android.net.Uri;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import java.io.File;
import java.util.List;
import java.util.Map;

public interface MediaStoreHelper
{

    public abstract Uri addEditedImageToMediaStore(Context context, Uri uri, File file);

    public abstract void addExcludedDirectory(File file);

    public abstract Uri addImageToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, int k);

    public abstract Uri addVideoToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, long l1);

    public abstract MediaItem createMediaItemFromMediaStoreUri(Uri uri);

    public abstract void deleteFromMediaStoreAndFileSystem(Tag tag);

    public abstract void deleteFromMediaStoreAndFileSystem(List list);

    public abstract Map getAllContent();

    public abstract int getMediaStoreItemCount();

    public abstract Map getNewContent(long l);

    public abstract Map getTagIdByPath(String s);

    public abstract boolean updateMediaStorePath(String s, String s1);
}
