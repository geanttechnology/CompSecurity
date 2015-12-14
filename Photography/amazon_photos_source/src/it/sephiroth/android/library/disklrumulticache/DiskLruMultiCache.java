// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.disklrumulticache;

import android.content.Context;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

// Referenced classes of package it.sephiroth.android.library.disklrumulticache:
//            DiskUtils, DigestUtils, DiskLruMultiCacheReadException

public class DiskLruMultiCache
{
    public static final class Entry
    {

        private final Metadata metadata;
        private final EntryObject object;

        public Metadata getMetadata()
        {
            return metadata;
        }

        public EntryObject getValue()
        {
            return object;
        }

        public Entry(Metadata metadata1, EntryObject entryobject)
        {
            object = entryobject;
            metadata = metadata1;
        }
    }

    public static abstract class EntryObject
    {

        public abstract void read(InputStream inputstream)
            throws IOException;

        public abstract void write(OutputStream outputstream)
            throws IOException;

        public EntryObject()
        {
        }
    }

    public static class Metadata
        implements Parcelable
    {

        public int describeContents()
        {
            return 0;
        }

        public void readFromParcel(Parcel parcel)
        {
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }

        public Metadata()
        {
        }
    }


    private static final int APP_VALUES = 2;
    private static final int APP_VERSION = 2;
    private static final int ENTRY_INDEX = 0;
    private static final String LOG_TAG = "DiskLruMultiCache";
    private static final int METADATA_INDEX = 1;
    final DiskLruCache mDiskCache;

    public DiskLruMultiCache(Context context, String s, int i)
        throws IOException
    {
        mDiskCache = DiskLruCache.open(getCacheDir(context, s), 2, 2, i);
    }

    public DiskLruMultiCache(Context context, String s, int i, int j)
        throws IOException
    {
        mDiskCache = DiskLruCache.open(getCacheDir(context, s), j, 2, i);
    }

    public static File getCacheDir(Context context, String s)
    {
        Log.i("DiskLruMultiCache", (new StringBuilder()).append("getCacheDir: ").append(s).toString());
        String s1 = Environment.getExternalStorageState();
        if ("checking".equals(s1) || "mounted".equals(s1) || !DiskUtils.isExternalStorageRemovable())
        {
            context = DiskUtils.getExternalCacheDir(context);
        } else
        {
            context = context.getCacheDir();
        }
        Log.i("DiskLruMultiCache", (new StringBuilder()).append("cacheDir:").append(context.getAbsolutePath()).toString());
        return new File(context, s);
    }

    private String makeKey(String s)
    {
        return DigestUtils.md5Hex(s).toLowerCase();
    }

    private EntryObject readEntry(com.jakewharton.disklrucache.DiskLruCache.Snapshot snapshot, Class class1)
        throws IOException, IllegalAccessException, InstantiationException
    {
        snapshot = snapshot.getInputStream(0);
        class1 = (EntryObject)class1.newInstance();
        class1.read(snapshot);
        return class1;
    }

    private Metadata readMetadata(com.jakewharton.disklrucache.DiskLruCache.Snapshot snapshot, Class class1)
        throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        com.jakewharton.disklrucache.DiskLruCache.Snapshot snapshot1;
        Parcel parcel;
        Parcel parcel1;
        snapshot1 = null;
        parcel1 = null;
        parcel = parcel1;
        snapshot = snapshot.getInputStream(1);
        snapshot1 = snapshot;
        parcel = parcel1;
        byte abyte0[] = IOUtils.toByteArray(snapshot);
        snapshot1 = snapshot;
        parcel = parcel1;
        parcel1 = Parcel.obtain();
        snapshot1 = snapshot;
        parcel = parcel1;
        parcel1.unmarshall(abyte0, 0, abyte0.length);
        snapshot1 = snapshot;
        parcel = parcel1;
        parcel1.setDataPosition(0);
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        snapshot1 = snapshot;
        parcel = parcel1;
        class1 = (Metadata)class1.newInstance();
        snapshot1 = snapshot;
        parcel = parcel1;
        class1.readFromParcel(parcel1);
        if (snapshot != null)
        {
            IOUtils.closeQuietly(snapshot);
        }
        if (parcel1 != null)
        {
            parcel1.recycle();
        }
        return class1;
        if (snapshot != null)
        {
            IOUtils.closeQuietly(snapshot);
        }
        if (parcel1 != null)
        {
            parcel1.recycle();
        }
        return null;
        snapshot;
        if (snapshot1 != null)
        {
            IOUtils.closeQuietly(snapshot1);
        }
        if (parcel != null)
        {
            parcel.recycle();
        }
        throw snapshot;
    }

    private void write(com.jakewharton.disklrucache.DiskLruCache.Editor editor, Entry entry)
        throws IOException
    {
        Object obj = null;
        editor = new BufferedOutputStream(editor.newOutputStream(0), 8192);
        entry.getValue().write(editor);
        if (editor != null)
        {
            IOUtils.closeQuietly(editor);
        }
        return;
        entry;
        editor = obj;
_L2:
        if (editor != null)
        {
            IOUtils.closeQuietly(editor);
        }
        throw entry;
        entry;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void writeMetadata(com.jakewharton.disklrucache.DiskLruCache.Editor editor, Metadata metadata)
        throws IOException
    {
        com.jakewharton.disklrucache.DiskLruCache.Editor editor1;
        Object obj;
        obj = null;
        editor1 = obj;
        Parcel parcel = Parcel.obtain();
        if (metadata == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        editor1 = obj;
        metadata.writeToParcel(parcel, 0);
        editor1 = obj;
        metadata = parcel.marshall();
        editor1 = obj;
        parcel.recycle();
        editor1 = obj;
        editor = editor.newOutputStream(1);
        editor1 = editor;
        editor.write(metadata);
        if (editor != null)
        {
            IOUtils.closeQuietly(editor);
        }
        return;
        editor;
        if (editor1 != null)
        {
            IOUtils.closeQuietly(editor1);
        }
        throw editor;
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("DiskLruMultiCache", "close");
        mDiskCache.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean containsKey(String s)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        s = mDiskCache.get(makeKey(s));
        if (s != null)
        {
            flag = true;
        }
        flag1 = flag;
        if (s != null)
        {
            s.close();
            flag1 = flag;
        }
_L2:
        return flag1;
        s;
        s.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        throw new NullPointerException();
        s;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw s;
        }
    }

    public void delete()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Log.i("DiskLruMultiCache", "delete");
        mDiskCache.delete();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Entry get(String s, Class class1, Class class2)
        throws DiskLruMultiCacheReadException
    {
        String s1;
        String s2;
        s2 = null;
        s1 = null;
        s = mDiskCache.get(makeKey(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        s1 = s;
        s2 = s;
        class1 = readMetadata(s, class1);
        s1 = s;
        s2 = s;
        class2 = readEntry(s, class2);
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        s1 = s;
        s2 = s;
        class1 = new Entry(class1, class2);
        if (s != null)
        {
            s.close();
        }
        return class1;
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        s2 = s1;
        throw new DiskLruMultiCacheReadException(s);
        s;
        if (s2 != null)
        {
            s2.close();
        }
        throw s;
    }

    public File getDirectory()
    {
        return mDiskCache.getDirectory();
    }

    public long getMaxSize()
    {
        return mDiskCache.getMaxSize();
    }

    public Metadata getMetadata(String s, Class class1)
        throws DiskLruMultiCacheReadException
    {
        String s1;
        String s2;
        s2 = null;
        s1 = null;
        s = mDiskCache.get(makeKey(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        s1 = s;
        s2 = s;
        class1 = readMetadata(s, class1);
        if (s != null)
        {
            s.close();
        }
        return class1;
        if (s != null)
        {
            s.close();
        }
        return null;
        s;
        s2 = s1;
        throw new DiskLruMultiCacheReadException(s);
        s;
        if (s2 != null)
        {
            s2.close();
        }
        throw s;
    }

    public boolean isClosed()
    {
        return mDiskCache.isClosed();
    }

    public boolean put(String s, Entry entry)
        throws IOException
    {
        String s1 = null;
        s = mDiskCache.edit(makeKey(s));
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s1 = s;
        Log.w("DiskLruMultiCache", "editor is null");
        return false;
        s1 = s;
        writeMetadata(s, entry.getMetadata());
        write(s, entry);
        mDiskCache.flush();
        s.commit();
        return false;
        entry;
        s1 = s;
        Log.w("DiskLruMultiCache", "failed to write entry");
        s1 = s;
        s.abort();
        return false;
        s;
        s.printStackTrace();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1.abort();
        return false;
        s;
        Log.w("DiskLruMultiCache", "abort failed", s);
        return false;
    }

    public void remove(String s)
        throws IOException
    {
        mDiskCache.remove(makeKey(s));
    }

    public long size()
    {
        return mDiskCache.size();
    }
}
