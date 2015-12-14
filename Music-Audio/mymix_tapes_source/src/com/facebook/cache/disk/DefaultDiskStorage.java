// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.facebook.cache.disk:
//            DiskStorage

public class DefaultDiskStorage
    implements DiskStorage
{
    private class EntriesCollector
        implements FileTreeVisitor
    {

        private final List result;
        final DefaultDiskStorage this$0;

        public List getEntries()
        {
            return Collections.unmodifiableList(result);
        }

        public void postVisitDirectory(File file)
        {
        }

        public void preVisitDirectory(File file)
        {
        }

        public void visitFile(File file)
        {
            FileInfo fileinfo = getShardFileInfo(file);
            if (fileinfo != null && fileinfo.type == FileType.CONTENT)
            {
                result.add(new EntryImpl(file));
            }
        }

        private EntriesCollector()
        {
            this$0 = DefaultDiskStorage.this;
            super();
            result = new ArrayList();
        }

    }

    class EntryImpl
        implements DiskStorage.Entry
    {

        private final FileBinaryResource resource;
        private long size;
        final DefaultDiskStorage this$0;
        private long timestamp;

        public volatile BinaryResource getResource()
        {
            return getResource();
        }

        public FileBinaryResource getResource()
        {
            return resource;
        }

        public long getSize()
        {
            if (size < 0L)
            {
                size = resource.size();
            }
            return size;
        }

        public long getTimestamp()
        {
            if (timestamp < 0L)
            {
                timestamp = resource.getFile().lastModified();
            }
            return timestamp;
        }

        private EntryImpl(File file)
        {
            this$0 = DefaultDiskStorage.this;
            super();
            Preconditions.checkNotNull(file);
            resource = FileBinaryResource.createOrNull(file);
            size = -1L;
            timestamp = -1L;
        }

    }

    private static class FileInfo
    {

        public final String resourceId;
        public final FileType type;

        public static FileInfo fromFile(File file)
        {
            int i;
            file = file.getName();
            i = file.lastIndexOf('.');
            if (i > 0) goto _L2; else goto _L1
_L1:
            FileType filetype;
            return null;
_L2:
            if ((filetype = FileType.fromExtension(file.substring(i))) == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            String s = file.substring(0, i);
            file = s;
            if (!filetype.equals(FileType.TEMP))
            {
                break; /* Loop/switch isn't completed */
            }
            i = s.lastIndexOf('.');
            if (i <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            file = s.substring(0, i);
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L3
_L3:
            return new FileInfo(filetype, file);
        }

        public File createTempFile(File file)
            throws IOException
        {
            return File.createTempFile((new StringBuilder()).append(resourceId).append(".").toString(), ".tmp", file);
        }

        public File toFile(File file)
        {
            return new File(file, (new StringBuilder()).append(resourceId).append(type.extension).toString());
        }

        public String toString()
        {
            return (new StringBuilder()).append(type).append("(").append(resourceId).append(")").toString();
        }

        private FileInfo(FileType filetype, String s)
        {
            type = filetype;
            resourceId = s;
        }

    }

    private static final class FileType extends Enum
    {

        private static final FileType $VALUES[];
        public static final FileType CONTENT;
        public static final FileType TEMP;
        public final String extension;

        public static FileType fromExtension(String s)
        {
            if (".cnt".equals(s))
            {
                return CONTENT;
            }
            if (".tmp".equals(s))
            {
                return TEMP;
            } else
            {
                return null;
            }
        }

        public static FileType valueOf(String s)
        {
            return (FileType)Enum.valueOf(com/facebook/cache/disk/DefaultDiskStorage$FileType, s);
        }

        public static FileType[] values()
        {
            return (FileType[])$VALUES.clone();
        }

        static 
        {
            CONTENT = new FileType("CONTENT", 0, ".cnt");
            TEMP = new FileType("TEMP", 1, ".tmp");
            $VALUES = (new FileType[] {
                CONTENT, TEMP
            });
        }

        private FileType(String s, int i, String s1)
        {
            super(s, i);
            extension = s1;
        }
    }

    private static class IncompleteFileException extends IOException
    {

        public final long actual;
        public final long expected;

        public IncompleteFileException(long l, long l1)
        {
            super((new StringBuilder()).append("File was not written completely. Expected: ").append(l).append(", found: ").append(l1).toString());
            expected = l;
            actual = l1;
        }
    }

    private class PurgingVisitor
        implements FileTreeVisitor
    {

        private boolean insideBaseDirectory;
        final DefaultDiskStorage this$0;

        private boolean isExpectedFile(File file)
        {
            boolean flag = false;
            FileInfo fileinfo = getShardFileInfo(file);
            if (fileinfo == null)
            {
                return false;
            }
            if (fileinfo.type == FileType.TEMP)
            {
                return isRecentFile(file);
            }
            if (fileinfo.type == FileType.CONTENT)
            {
                flag = true;
            }
            Preconditions.checkState(flag);
            return true;
        }

        private boolean isRecentFile(File file)
        {
            return file.lastModified() > mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }

        public void postVisitDirectory(File file)
        {
            if (!mRootDirectory.equals(file) && !insideBaseDirectory)
            {
                file.delete();
            }
            if (insideBaseDirectory && file.equals(mVersionDirectory))
            {
                insideBaseDirectory = false;
            }
        }

        public void preVisitDirectory(File file)
        {
            if (!insideBaseDirectory && file.equals(mVersionDirectory))
            {
                insideBaseDirectory = true;
            }
        }

        public void visitFile(File file)
        {
            if (!insideBaseDirectory || !isExpectedFile(file))
            {
                file.delete();
            }
        }

        private PurgingVisitor()
        {
            this$0 = DefaultDiskStorage.this;
            super();
        }

    }


    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final Class TAG = com/facebook/cache/disk/DefaultDiskStorage;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    static final long TEMP_FILE_LIFETIME_MS;
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock = SystemClock.get();
    private final File mRootDirectory;
    private final File mVersionDirectory;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheerrorlogger)
    {
        Preconditions.checkNotNull(file);
        mRootDirectory = file;
        mVersionDirectory = new File(mRootDirectory, getVersionSubdirectoryName(i));
        mCacheErrorLogger = cacheerrorlogger;
        recreateDirectoryIfVersionChanges();
    }

    private long doRemove(File file)
    {
        long l;
        if (!file.exists())
        {
            l = 0L;
        } else
        {
            l = file.length();
            if (!file.delete())
            {
                return -1L;
            }
        }
        return l;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry)
        throws IOException
    {
        EntryImpl entryimpl = (EntryImpl)entry;
        String s = "";
        byte abyte0[] = entryimpl.getResource().read();
        String s1 = typeOfBytes(abyte0);
        entry = s;
        if (s1.equals("undefined"))
        {
            entry = s;
            if (abyte0.length >= 4)
            {
                entry = String.format((Locale)null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[] {
                    Byte.valueOf(abyte0[0]), Byte.valueOf(abyte0[1]), Byte.valueOf(abyte0[2]), Byte.valueOf(abyte0[3])
                });
            }
        }
        return new DiskStorage.DiskDumpInfoEntry(entryimpl.getResource().getFile().getPath(), s1, entryimpl.getSize(), entry);
    }

    private FileInfo getShardFileInfo(File file)
    {
        FileInfo fileinfo = FileInfo.fromFile(file);
        if (fileinfo == null)
        {
            return null;
        }
        if (getSubdirectory(fileinfo.resourceId).equals(file.getParentFile()))
        {
            file = fileinfo;
        } else
        {
            file = null;
        }
        return file;
    }

    private File getSubdirectory(String s)
    {
        int i = Math.abs(s.hashCode() % 100);
        return new File(mVersionDirectory, String.valueOf(i));
    }

    static String getVersionSubdirectoryName(int i)
    {
        return String.format((Locale)null, "%s.ols%d.%d", new Object[] {
            "v2", Integer.valueOf(100), Integer.valueOf(i)
        });
    }

    private void mkdirs(File file, String s)
        throws IOException
    {
        try
        {
            FileUtils.mkdirs(file);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, s, file);
        }
        throw file;
    }

    private boolean query(String s, boolean flag)
    {
        s = getContentFileFor(s);
        boolean flag1 = s.exists();
        if (flag && flag1)
        {
            s.setLastModified(mClock.now());
        }
        return flag1;
    }

    private void recreateDirectoryIfVersionChanges()
    {
        boolean flag = false;
        if (mRootDirectory.exists()) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        FileUtils.mkdirs(mVersionDirectory);
        return;
_L2:
        if (!mVersionDirectory.exists())
        {
            flag = true;
            FileTree.deleteRecursively(mRootDirectory);
        }
        if (true) goto _L4; else goto _L3
_L3:
        com.facebook.common.file.FileUtils.CreateDirectoryException createdirectoryexception;
        createdirectoryexception;
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, (new StringBuilder()).append("version directory could not be created: ").append(mVersionDirectory).toString(), null);
        return;
    }

    private String typeOfBytes(byte abyte0[])
    {
        if (abyte0.length >= 2)
        {
            if (abyte0[0] == -1 && abyte0[1] == -40)
            {
                return "jpg";
            }
            if (abyte0[0] == -119 && abyte0[1] == 80)
            {
                return "png";
            }
            if (abyte0[0] == 82 && abyte0[1] == 73)
            {
                return "webp";
            }
            if (abyte0[0] == 71 && abyte0[1] == 73)
            {
                return "gif";
            }
        }
        return "undefined";
    }

    public void clearAll()
    {
        FileTree.deleteContents(mRootDirectory);
    }

    public volatile BinaryResource commit(String s, BinaryResource binaryresource, Object obj)
        throws IOException
    {
        return commit(s, binaryresource, obj);
    }

    public FileBinaryResource commit(String s, BinaryResource binaryresource, Object obj)
        throws IOException
    {
        binaryresource = ((FileBinaryResource)binaryresource).getFile();
        s = getContentFileFor(s);
        try
        {
            FileUtils.rename(binaryresource, s);
        }
        // Misplaced declaration of an exception variable
        catch (BinaryResource binaryresource)
        {
            s = binaryresource.getCause();
            if (s == null)
            {
                s = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
            } else
            if (s instanceof com.facebook.common.file.FileUtils.ParentDirNotFoundException)
            {
                s = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
            } else
            if (s instanceof FileNotFoundException)
            {
                s = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
            } else
            {
                s = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
            }
            mCacheErrorLogger.logError(s, TAG, "commit", binaryresource);
            throw binaryresource;
        }
        if (s.exists())
        {
            s.setLastModified(mClock.now());
        }
        return FileBinaryResource.createOrNull(s);
    }

    public boolean contains(String s, Object obj)
    {
        return query(s, false);
    }

    public volatile BinaryResource createTemporary(String s, Object obj)
        throws IOException
    {
        return createTemporary(s, obj);
    }

    public FileBinaryResource createTemporary(String s, Object obj)
        throws IOException
    {
        s = new FileInfo(FileType.TEMP, s);
        obj = getSubdirectory(((FileInfo) (s)).resourceId);
        if (!((File) (obj)).exists())
        {
            mkdirs(((File) (obj)), "createTemporary");
        }
        try
        {
            s = FileBinaryResource.createOrNull(s.createTempFile(((File) (obj))));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "createTemporary", s);
            throw s;
        }
        return s;
    }

    File getContentFileFor(String s)
    {
        s = new FileInfo(FileType.CONTENT, s);
        return s.toFile(getSubdirectory(((FileInfo) (s)).resourceId));
    }

    public DiskStorage.DiskDumpInfo getDumpInfo()
        throws IOException
    {
        Object obj = getEntries();
        DiskStorage.DiskDumpInfo diskdumpinfo = new DiskStorage.DiskDumpInfo();
        DiskStorage.DiskDumpInfoEntry diskdumpinfoentry;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); diskdumpinfo.entries.add(diskdumpinfoentry))
        {
            diskdumpinfoentry = dumpCacheEntry((DiskStorage.Entry)((Iterator) (obj)).next());
            String s = diskdumpinfoentry.type;
            if (!diskdumpinfo.typeCounts.containsKey(s))
            {
                diskdumpinfo.typeCounts.put(s, Integer.valueOf(0));
            }
            diskdumpinfo.typeCounts.put(s, Integer.valueOf(((Integer)diskdumpinfo.typeCounts.get(s)).intValue() + 1));
        }

        return diskdumpinfo;
    }

    public volatile Collection getEntries()
        throws IOException
    {
        return getEntries();
    }

    public List getEntries()
        throws IOException
    {
        EntriesCollector entriescollector = new EntriesCollector();
        FileTree.walkFileTree(mVersionDirectory, entriescollector);
        return entriescollector.getEntries();
    }

    public volatile BinaryResource getResource(String s, Object obj)
        throws IOException
    {
        return getResource(s, obj);
    }

    public FileBinaryResource getResource(String s, Object obj)
    {
        s = getContentFileFor(s);
        if (s.exists())
        {
            s.setLastModified(mClock.now());
            return FileBinaryResource.createOrNull(s);
        } else
        {
            return null;
        }
    }

    public boolean isEnabled()
    {
        return true;
    }

    public void purgeUnexpectedResources()
    {
        FileTree.walkFileTree(mRootDirectory, new PurgingVisitor());
    }

    public long remove(DiskStorage.Entry entry)
    {
        return doRemove(((EntryImpl)entry).getResource().getFile());
    }

    public long remove(String s)
    {
        return doRemove(getContentFileFor(s));
    }

    public boolean touch(String s, Object obj)
    {
        return query(s, true);
    }

    public void updateResource(String s, BinaryResource binaryresource, WriterCallback writercallback, Object obj)
        throws IOException
    {
        binaryresource = ((FileBinaryResource)binaryresource).getFile();
        long l;
        try
        {
            s = new FileOutputStream(binaryresource);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TAG, "updateResource", s);
            throw s;
        }
        obj = new CountingOutputStream(s);
        writercallback.write(((java.io.OutputStream) (obj)));
        ((CountingOutputStream) (obj)).flush();
        l = ((CountingOutputStream) (obj)).getCount();
        s.close();
        if (binaryresource.length() != l)
        {
            throw new IncompleteFileException(l, binaryresource.length());
        } else
        {
            return;
        }
        binaryresource;
        s.close();
        throw binaryresource;
    }

    static 
    {
        TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30L);
    }




}
