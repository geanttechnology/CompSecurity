// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.BasicPathProvider;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemDateParser;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagFactory;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.data.store.RewindHelper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.RewindPhoto;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            MediaStoreHelper

public abstract class AbstractMediaStoreHelper
    implements MediaStoreHelper
{

    private static final Pattern CUT_EMBEDDED_ID_PATTERN = Pattern.compile("(.*)_ID_[^_]*(\\.mp4$)");
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/AbstractMediaStoreHelper.getName();
    protected Context context;
    protected final Set excludedDirectoryPaths = new HashSet();
    protected MediaItemDao mediaItemDao;
    protected MediaItemDateParser mediaItemDateParser;
    protected RemovableStorageManager removableStorageManager;
    protected TagDao tagDao;
    protected TagFactory tagFactory;

    public AbstractMediaStoreHelper()
    {
    }

    public void addExcludedDirectory(File file)
    {
        if (file != null)
        {
            excludedDirectoryPaths.add(file.getAbsolutePath());
        }
    }

    boolean checkMediaContent(File file)
    {
        return file.exists();
    }

    protected void contentFromCursor(Uri uri, Cursor cursor, Map map, Map map1)
    {
        Object obj;
        String s;
        ObjectID objectid;
        int i = cursor.getColumnIndexOrThrow("_id");
        int j = cursor.getColumnIndexOrThrow("_data");
        int k = cursor.getColumnIndexOrThrow("date_added");
        int l = cursor.getColumnIndexOrThrow("bucket_id");
        int i1 = cursor.getColumnIndexOrThrow("bucket_display_name");
        long l1 = cursor.getLong(i);
        obj = cursor.getString(j);
        cursor.getLong(k);
        s = cursor.getString(i1);
        long l2 = cursor.getLong(l);
        if (!checkMediaContent(new File(((String) (obj)))))
        {
            deleteFromMediaStore(uri, l1);
            return;
        }
        uri = (new File(((String) (obj)))).getParentFile();
        obj = mediaItemFromCursor(cursor);
        ((MediaItem) (obj)).setProperties(getMediaProperties(uri));
        objectid = new ObjectID(0L, l2);
        cursor = (Tag)map1.get(objectid);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        uri = tagFactory.createLocalTag(objectid, s, uri, ((MediaItem) (obj)));
        map1.put(objectid, uri);
_L4:
        cursor = new HashSet();
        cursor.add(uri);
        ((MediaItem) (obj)).setTags(cursor);
        map1 = (List)map.get(uri);
        cursor = map1;
        if (map1 == null)
        {
            cursor = new ArrayList();
            map.put(uri, cursor);
        }
        cursor.add(obj);
        return;
_L2:
        uri = cursor;
        if (((MediaItem) (obj)).getDateModifiedMs() > cursor.getDateCreatedMs())
        {
            cursor.setDateCreatedMs(((MediaItem) (obj)).getDateModifiedMs());
            uri = cursor;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int deleteFromMediaStore(Uri uri, long l)
    {
        return context.getContentResolver().delete(uri, "_id=?", new String[] {
            String.valueOf(l)
        });
    }

    protected void deleteFromMediaStoreAndFileSystem(Uri uri, String s, Tag tag)
    {
        int i;
        int j;
        long l;
        if (tag.getType() != TagType.LOCAL_FOLDER)
        {
            throw new RuntimeException("Unable to delete non-local-folder Tag from MediaStore");
        }
        if (!tag.hasProperty(com.amazon.gallery.framework.model.tags.CommonTagProperty.Storage.LOCAL))
        {
            throw new RuntimeException("Unable to delete non-local Tag from MediaStore");
        }
        ContentResolver contentresolver = context.getContentResolver();
        s = (new StringBuilder()).append(s).append("=?").toString();
        String as[] = new String[1];
        as[0] = (new StringBuilder()).append(tag.getObjectId().getLeastSignificantBits()).append("").toString();
        GLogger.d(TAG, "DELETE FROM %s where BUCKET_ID = %s", new Object[] {
            uri, as[0]
        });
        l = SystemClock.uptimeMillis();
        boolean flag = false;
        i = 0;
        j = 0;
        s = contentresolver.query(uri, new String[] {
            "_data"
        }, s, as, null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        i = ((flag) ? 1 : 0);
        if (!s.moveToFirst()) goto _L2; else goto _L1
_L1:
        i = j;
        if (s.isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        j += deleteFromMediaStoreByPath(uri, s.getString(s.getColumnIndex("_data")));
        s.moveToNext();
        if (true) goto _L1; else goto _L2
        uri;
        s.close();
        throw uri;
_L2:
        s.close();
label0:
        {
label1:
            {
                GLogger.d(TAG, "Deleted %d item(s) in %dms", new Object[] {
                    Integer.valueOf(i), Long.valueOf(SystemClock.uptimeMillis() - l)
                });
                uri = new File(tag.getLocalPath());
                if (!BasicPathProvider.getCameraDirPath().equals(uri.getAbsolutePath()))
                {
                    s = uri.listFiles();
                    if (s == null || s.length != 0)
                    {
                        break label0;
                    }
                    if (!uri.delete())
                    {
                        break label1;
                    }
                    GLogger.i(TAG, "Deleted '%s'", new Object[] {
                        tag.getLocalPath()
                    });
                }
                return;
            }
            GLogger.i(TAG, "Failed to delete '%s'", new Object[] {
                tag.getLocalPath()
            });
            return;
        }
        GLogger.i(TAG, "Directory '%s' does not exist or is not empty", new Object[] {
            tag.getLocalPath()
        });
        return;
    }

    protected void deleteFromMediaStoreAndFileSystem(Uri uri, List list)
    {
        HashSet hashset = new HashSet();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)list.next();
            if (deleteFromMediaStoreByPath(uri, mediaitem.getLocalPath()) > 0)
            {
                String s = mediaitem.getLocalPath();
                if (s != null)
                {
                    hashset.add((new File(s)).getParentFile());
                    if (MediaItemUtil.isRewindPhoto(mediaitem))
                    {
                        RewindHelper.getInstance().deleteNonPreferredRewindFrames((RewindPhoto)mediaitem);
                    }
                }
                list.remove();
            }
        } while (true);
        uri = hashset.iterator();
        do
        {
            if (!uri.hasNext())
            {
                break;
            }
            list = (File)uri.next();
            if (!BasicPathProvider.getCameraDirPath().equals(list.getAbsolutePath()))
            {
                String as[] = list.list();
                if (as == null)
                {
                    GLogger.e(TAG, (new StringBuilder()).append("Is not a directory or does not exist, ").append(list).toString(), new Object[0]);
                } else
                if (as.length == 0 && !list.delete())
                {
                    GLogger.e(TAG, (new StringBuilder()).append("Can't delete local dir ").append(list).toString(), new Object[0]);
                }
            }
        } while (true);
    }

    public void deleteFromMediaStoreAndFileSystem(Tag tag)
    {
        deleteFromMediaStoreAndFileSystem(getMediaStoreUri(), "bucket_id", tag);
    }

    public void deleteFromMediaStoreAndFileSystem(List list)
    {
        deleteFromMediaStoreAndFileSystem(getMediaStoreUri(), list);
    }

    public int deleteFromMediaStoreByPath(Uri uri, String s)
    {
        int i = context.getContentResolver().delete(uri, "_data=?", new String[] {
            s
        });
        uri = new File(s);
        if (uri.exists())
        {
            uri.delete();
        }
        return i;
    }

    public Map getAllContent()
    {
        return retrieveContentNewerThan(0L);
    }

    protected long getDateFromColumnIndex(Cursor cursor, int i)
    {
        if (i != -1)
        {
            return cursor.getLong(i);
        } else
        {
            return 0L;
        }
    }

    protected Set getMediaProperties(File file)
    {
        HashSet hashset = new HashSet();
        hashset.add(CommonMediaProperty.LOCAL);
        if (tagFactory != null && tagFactory.isInCameraDirectory(file))
        {
            hashset.add(CommonMediaProperty.CAMERA);
        }
        if (removableStorageManager.isRemovableStorageMounted() && removableStorageManager.isFileOnRemovableStorage(file))
        {
            hashset.add(CommonMediaProperty.REMOVABLE);
        }
        return hashset;
    }

    public int getMediaStoreItemCount()
    {
        return getMediaStoreItemCount(getMediaStoreUri());
    }

    protected int getMediaStoreItemCount(Uri uri)
    {
        int i;
        i = 0;
        boolean flag = false;
        Object obj = null;
        if (!excludedDirectoryPaths.isEmpty())
        {
            obj = new StringBuilder();
            Iterator iterator = excludedDirectoryPaths.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ((StringBuilder) (obj)).append("_data").append(" NOT LIKE '").append((String)iterator.next()).append("%'");
                if (iterator.hasNext())
                {
                    ((StringBuilder) (obj)).append(" AND ");
                }
            } while (true);
            obj = ((StringBuilder) (obj)).toString();
        }
        uri = context.getContentResolver().query(uri, new String[] {
            "COUNT(*)"
        }, ((String) (obj)), null, null);
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        i = ((flag) ? 1 : 0);
        if (uri.moveToFirst())
        {
            i = uri.getInt(0);
        }
        uri.close();
        return i;
        Exception exception;
        exception;
        uri.close();
        throw exception;
    }

    protected abstract Uri getMediaStoreUri();

    public Map getNewContent(long l)
    {
        return retrieveContentNewerThan(l);
    }

    protected String[] getProjectedColumns(List list)
    {
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            list.add("width");
            list.add("height");
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    protected abstract List getStandardMediaItemColumns();

    protected Map getTagIdByPath(Uri uri, String s)
    {
        HashMap hashmap;
        HashSet hashset;
        hashmap = new HashMap();
        hashset = new HashSet();
        String s1 = (new StringBuilder()).append(s).append(File.separator).toString();
        uri = context.getContentResolver().query(uri, new String[] {
            "bucket_id", "_data"
        }, "_data LIKE (? || '%')", new String[] {
            s1
        }, null);
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        if (uri.moveToFirst())
        {
            for (; !uri.isAfterLast(); uri.moveToNext())
            {
                Long long1 = Long.valueOf(uri.getLong(uri.getColumnIndex("bucket_id")));
                if (!hashset.contains(long1))
                {
                    hashset.add(long1);
                    hashmap.put((new File(uri.getString(uri.getColumnIndex("_data")))).getParent(), new ObjectID(0L, long1.longValue()));
                }
            }

        }
        break MISSING_BLOCK_LABEL_204;
        s;
        uri.close();
        throw s;
        uri.close();
        GLogger.e(TAG, (new StringBuilder()).append("Can't find album by path ").append(s).toString(), new Object[0]);
        return hashmap;
    }

    public Map getTagIdByPath(String s)
    {
        return getTagIdByPath(getMediaStoreUri(), s);
    }

    public boolean itemFileExistsAndNotExcluded(Cursor cursor)
    {
        cursor = new File(cursor.getString(cursor.getColumnIndexOrThrow("_data")));
        return cursor.exists() && !excludedDirectoryPaths.contains(cursor.getParent());
    }

    protected abstract MediaItem mediaItemFromCursor(Cursor cursor);

    protected Map retrieveContentNewThan(Uri uri, long l, String as[])
    {
        HashMap hashmap;
        HashMap hashmap1;
        Object obj = tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.LOCAL);
        hashmap = new HashMap(((List) (obj)).size() * 2);
        hashmap1 = new HashMap(((List) (obj)).size() * 2);
        Tag tag;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashmap1.put(tag, new ArrayList()))
        {
            tag = (Tag)((Iterator) (obj)).next();
            hashmap.put(tag.getObjectId(), tag);
        }

        obj = (new StringBuilder()).append(Long.toString(l / 1000L)).append(".0").toString();
        as = context.getContentResolver().query(uri, as, "date_added >= ?", new String[] {
            obj
        }, "date_added");
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        if (as.moveToFirst())
        {
            for (; !as.isAfterLast(); as.moveToNext())
            {
                if (itemFileExistsAndNotExcluded(as))
                {
                    contentFromCursor(uri, as, hashmap1, hashmap);
                }
            }

        }
        break MISSING_BLOCK_LABEL_245;
        uri;
        as.close();
        throw uri;
        as.close();
        return hashmap1;
    }

    protected Map retrieveContentNewerThan(long l)
    {
        List list = getStandardMediaItemColumns();
        list.add("bucket_id");
        list.add("bucket_display_name");
        String as[] = getProjectedColumns(list);
        return retrieveContentNewThan(getMediaStoreUri(), l, as);
    }

    public AbstractMediaStoreHelper setContext(Context context1)
    {
        context = context1;
        return this;
    }

    public AbstractMediaStoreHelper setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
        return this;
    }

    protected void setMetadata(Cursor cursor, MediaItem mediaitem, String s, Uri uri)
    {
        int i = cursor.getColumnIndex("date_added");
        int j = cursor.getColumnIndex("date_modified");
        int k = cursor.getColumnIndex("datetaken");
        long l2 = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        long l3 = getDateFromColumnIndex(cursor, i);
        long l1 = getDateFromColumnIndex(cursor, j) * 1000L;
        getDateFromColumnIndex(cursor, k);
        File file = new File(s);
        String s1 = file.getName();
        Matcher matcher = CUT_EMBEDDED_ID_PATTERN.matcher(s1);
        if (matcher.matches())
        {
            s1 = matcher.replaceAll("$1$2");
        }
        long l = l1;
        if (l1 == 0L)
        {
            l = file.lastModified();
        }
        mediaitem.setObjectId(new ObjectID(0L, l2));
        mediaitem.setLocalPath(s);
        mediaitem.setName(s1);
        mediaitem.setDateAddedMs(l3 * 1000L);
        mediaitem.setSize(file.length());
        mediaItemDateParser.setDateCreated(cursor, mediaitem);
        mediaitem.setTimestampMs(MediaItemUtil.createTimestamp(mediaitem));
        mediaitem.setDateModifiedMs(l);
        mediaitem.setProperties(getMediaProperties(file.getParentFile()));
        mediaitem.getMetadata().put("media-store.uri", (new StringBuilder()).append(uri).append("/").append(l2).toString());
    }

    public AbstractMediaStoreHelper setRemovableStorageManager(RemovableStorageManager removablestoragemanager)
    {
        removableStorageManager = removablestoragemanager;
        return this;
    }

    public AbstractMediaStoreHelper setTagDao(TagDao tagdao)
    {
        tagDao = tagdao;
        return this;
    }

    public AbstractMediaStoreHelper setTagFactory(TagFactory tagfactory)
    {
        tagFactory = tagfactory;
        return this;
    }

    public boolean updateMediaStorePath(String s, String s1)
    {
        ContentProviderClient contentproviderclient;
        Uri uri;
        ContentValues contentvalues;
        uri = Uri.parse("content://media/external/object");
        contentvalues = new ContentValues();
        contentvalues.put("_data", s1);
        contentproviderclient = context.getContentResolver().acquireContentProviderClient("media");
        int i = contentproviderclient.update(uri, contentvalues, "_data=?", new String[] {
            s
        });
        if (i > 0)
        {
            contentproviderclient.release();
            return true;
        }
        GLogger.e(TAG, (new StringBuilder()).append("Can't update media store album from ").append(s).append(" -> ").append(s1).toString(), new Object[0]);
        contentproviderclient.release();
_L2:
        return false;
        s;
        GLogger.w(TAG, "RemoteException in MediaProvider update", new Object[0]);
        contentproviderclient.release();
        if (true) goto _L2; else goto _L1
_L1:
        s;
        contentproviderclient.release();
        throw s;
    }

}
