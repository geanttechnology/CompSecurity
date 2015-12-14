// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            AbstractMediaStoreHelper, MediaStoreHelper

public class MediaStoreHelperImpl extends AbstractMediaStoreHelper
    implements MediaStoreHelper
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/MediaStoreHelperImpl.getName();
    private static final Comparator modifiedTimeComparator = new Comparator() {

        public int compare(MediaItem mediaitem, MediaItem mediaitem1)
        {
            return (int)(mediaitem.getDateModifiedMs() - mediaitem1.getDateModifiedMs());
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((MediaItem)obj, (MediaItem)obj1);
        }

    };
    private final Map mediaHelpers;

    public MediaStoreHelperImpl(Map map)
    {
        mediaHelpers = map;
    }

    private MediaType getMediaTypeFromContentUri(Uri uri)
    {
        String s = context.getContentResolver().getType(uri);
        if (s == null)
        {
            GLogger.w(TAG, "MIME type is null for content uri: [%s]", new Object[] {
                uri
            });
            return null;
        }
        if (s.matches("(?i)image/.*"))
        {
            return MediaType.PHOTO;
        }
        if (s.matches("(?i)video/.*"))
        {
            return MediaType.VIDEO;
        } else
        {
            GLogger.w(TAG, "MIME type [%s] for content uri [%s] could not be found", new Object[] {
                s, uri
            });
            return null;
        }
    }

    private Map joinTwoMaps(Map map, Map map1)
    {
        HashMap hashmap = new HashMap();
        Tag tag;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); hashmap.put(tag.getObjectId(), tag))
        {
            tag = (Tag)iterator.next();
        }

        Iterator iterator1 = map1.entrySet().iterator();
label0:
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            map1 = (java.util.Map.Entry)iterator1.next();
            Object obj = (Tag)map1.getKey();
            Object obj1 = (List)map1.getValue();
            map1 = null;
            if (hashmap.containsKey(((Tag) (obj)).getObjectId()))
            {
                map1 = (List)map.get(hashmap.get(((Tag) (obj)).getObjectId()));
            }
            if (map1 != null)
            {
                obj = ((List) (obj1)).iterator();
label1:
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    Object obj2 = (MediaItem)((Iterator) (obj)).next();
                    obj1 = ((MediaItem) (obj2)).getTags();
                    Iterator iterator2 = ((Set) (obj1)).iterator();
                    map1.add(obj2);
                    do
                    {
                        if (!iterator2.hasNext())
                        {
                            continue label1;
                        }
                        obj2 = (Tag)iterator2.next();
                    } while (!hashmap.containsKey(((Tag) (obj2)).getObjectId()));
                    iterator2.remove();
                    ((Set) (obj1)).add(hashmap.get(((Tag) (obj2)).getObjectId()));
                } while (true);
            }
            map.put(obj, obj1);
        } while (true);
        return map;
    }

    public Uri addEditedImageToMediaStore(Context context, Uri uri, File file)
    {
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            Uri uri1 = ((MediaStoreHelper)iterator.next()).addEditedImageToMediaStore(context, uri, file);
            if (uri1 != null)
            {
                return uri1;
            }
        }

        return null;
    }

    public void addExcludedDirectory(File file)
    {
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext(); ((MediaStoreHelper)iterator.next()).addExcludedDirectory(file)) { }
    }

    public Uri addImageToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, int k)
    {
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            Uri uri = ((MediaStoreHelper)iterator.next()).addImageToMediaStore(context, file, s, i, j, l, s1, k);
            if (uri != null)
            {
                return uri;
            }
        }

        return null;
    }

    public Uri addVideoToMediaStore(Context context, File file, String s, int i, int j, long l, 
            String s1, long l1)
    {
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            Uri uri = ((MediaStoreHelper)iterator.next()).addVideoToMediaStore(context, file, s, i, j, l, s1, l1);
            if (uri != null)
            {
                return uri;
            }
        }

        return null;
    }

    public MediaItem createMediaItemFromMediaStoreUri(Uri uri)
    {
        MediaType mediatype = getMediaTypeFromContentUri(uri);
        if (mediatype != null)
        {
            return ((MediaStoreHelper)mediaHelpers.get(mediatype)).createMediaItemFromMediaStoreUri(uri);
        } else
        {
            return null;
        }
    }

    public void deleteFromMediaStoreAndFileSystem(Tag tag)
    {
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext(); ((MediaStoreHelper)iterator.next()).deleteFromMediaStoreAndFileSystem(tag)) { }
    }

    public void deleteFromMediaStoreAndFileSystem(List list)
    {
        list = new ArrayList(list);
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext(); ((MediaStoreHelper)iterator.next()).deleteFromMediaStoreAndFileSystem(list)) { }
    }

    public Map getAllContent()
    {
        Object obj = new HashMap();
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            obj = joinTwoMaps(((Map) (obj)), ((MediaStoreHelper)iterator.next()).getAllContent());
        }

        return ((Map) (obj));
    }

    public int getMediaStoreItemCount()
    {
        int i = 0;
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            i += ((MediaStoreHelper)iterator.next()).getMediaStoreItemCount();
        }

        return i;
    }

    protected Uri getMediaStoreUri()
    {
        throw new UnsupportedOperationException();
    }

    public Map getNewContent(long l)
    {
        l /= 1000L;
        Object obj = new HashMap();
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext();)
        {
            obj = joinTwoMaps(((Map) (obj)), ((MediaStoreHelper)iterator.next()).getNewContent(1000L * l));
        }

        return ((Map) (obj));
    }

    protected List getStandardMediaItemColumns()
    {
        throw new UnsupportedOperationException();
    }

    public Map getTagIdByPath(String s)
    {
        HashMap hashmap = new HashMap();
        for (Iterator iterator = mediaHelpers.values().iterator(); iterator.hasNext(); hashmap.putAll(((MediaStoreHelper)iterator.next()).getTagIdByPath(s))) { }
        return hashmap;
    }

    protected MediaItem mediaItemFromCursor(Cursor cursor)
    {
        throw new UnsupportedOperationException();
    }

    protected Map retrieveContentNewerThan(long l)
    {
        throw new UnsupportedOperationException();
    }

    public boolean updateMediaStorePath(String s, String s1)
    {
        return super.updateMediaStorePath(s, s1);
    }

}
