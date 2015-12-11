// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.vandalsoftware.io:
//            IoUtils

public final class DiskLruCache
    implements Closeable
{
    public final class Editor
    {

        private final Entry entry;
        private boolean hasErrors;
        final DiskLruCache this$0;

        public void abort()
            throws IOException
        {
            completeEdit(this, false);
        }

        public void commit()
            throws IOException
        {
            if (hasErrors)
            {
                completeEdit(this, false);
                remove(entry.key);
                return;
            } else
            {
                completeEdit(this, true);
                return;
            }
        }

        public OutputStream newOutputStream(int i)
            throws IOException
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Exception exception;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
            ErrorCatchingOutputStream errorcatchingoutputstream = new ErrorCatchingOutputStream(new FileOutputStream(entry.getDirtyFile(i)));
            disklrucache;
            JVM INSTR monitorexit ;
            return errorcatchingoutputstream;
        }



/*
        static boolean access$1402(Editor editor, boolean flag)
        {
            editor.hasErrors = flag;
            return flag;
        }

*/

        private Editor(Entry entry1)
        {
            this$0 = DiskLruCache.this;
            super();
            entry = entry1;
        }

    }

    private class Editor.ErrorCatchingOutputStream extends FilterOutputStream
    {

        final Editor this$1;

        public void close()
            throws IOException
        {
            try
            {
                out.close();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
                throw ioexception;
            }
        }

        public void flush()
            throws IOException
        {
            try
            {
                out.flush();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
                throw ioexception;
            }
        }

        public void write(int i)
            throws IOException
        {
            try
            {
                out.write(i);
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
                throw ioexception;
            }
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            try
            {
                out.write(abyte0, i, j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                hasErrors = true;
            }
            throw abyte0;
        }

        private Editor.ErrorCatchingOutputStream(OutputStream outputstream)
        {
            this$1 = Editor.this;
            super(outputstream);
        }

    }

    public final class Entry
    {

        private Editor currentEditor;
        private final String key;
        private final long lengths[];
        private boolean readable;
        final DiskLruCache this$0;

        public File getCleanFile(int i)
        {
            return new File(directory, (new StringBuilder()).append(key).append(".").append(i).toString());
        }

        public File getDirtyFile(int i)
        {
            return new File(directory, (new StringBuilder()).append(key).append(".").append(i).append(".tmp").toString());
        }



/*
        static boolean access$502(Entry entry, boolean flag)
        {
            entry.readable = flag;
            return flag;
        }

*/



/*
        static Editor access$602(Entry entry, Editor editor)
        {
            entry.currentEditor = editor;
            return editor;
        }

*/



        private Entry(String s)
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            lengths = new long[valueCount];
        }

    }

    public static final class Snapshot
        implements Closeable
    {

        private final InputStream ins[];
        private final String paths[];

        public void close()
        {
            InputStream ainputstream[] = ins;
            int j = ainputstream.length;
            for (int i = 0; i < j; i++)
            {
                IoUtils.closeQuietly(ainputstream[i]);
            }

        }

        public InputStream getInputStream(int i)
        {
            return ins[i];
        }

        public String getPath(int i)
        {
            return paths[i];
        }

        private Snapshot(InputStream ainputstream[], String as[])
        {
            ins = ainputstream;
            paths = as;
        }

    }


    private static final int CLEAN = 1;
    private static final int DIRTY = 2;
    private static final String JOURNAL_FILE = "journal";
    private static final String JOURNAL_FILE_TMP = "journal.tmp";
    private static final long MAGIC = 0x814a4c450d0a1a0aL;
    private static final int READ = 4;
    private static final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
    private static final int REMOVE = 3;
    private static final int VERSION = 2;
    private final int appVersion;
    private final Callable cleanupCallable = new Callable() {

        final DiskLruCache this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
label0:
            {
                synchronized (DiskLruCache.this)
                {
                    if (journalStream != null)
                    {
                        break label0;
                    }
                }
                return null;
            }
            trimToSize();
            if (journalRebuildRequired())
            {
                rebuildJournal();
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = DiskLruCache.this;
                super();
            }
    };
    private final File directory;
    private final ExecutorService executorService;
    private final File journalFile;
    private final File journalFileTmp;
    private DataOutputStream journalStream;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private final long maxSize;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private DiskLruCache(File file, int i, int j, long l)
    {
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        size = 0L;
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        valueCount = j;
        maxSize = l;
    }

    private void checkNotClosed()
    {
        if (journalStream == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void completeEdit(Editor editor, boolean flag)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        entry = editor.entry;
        if (entry.currentEditor != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_28;
        editor;
        this;
        JVM INSTR monitorexit ;
        throw editor;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (entry.readable) goto _L2; else goto _L3
_L3:
        int i = 0;
_L9:
        if (i >= valueCount) goto _L2; else goto _L4
_L4:
        if (!entry.getDirtyFile(i).exists())
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder()).append("edit didn't create file ").append(i).toString());
        }
          goto _L5
_L10:
        if (i >= valueCount) goto _L7; else goto _L6
_L6:
        editor = entry.getDirtyFile(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        if (editor.exists())
        {
            File file = entry.getCleanFile(i);
            IoUtils.renameFileOrThrow(editor, file);
            long l = entry.lengths[i];
            long l1 = file.length();
            entry.lengths[i] = l1;
            size = (size - l) + l1;
        }
        break MISSING_BLOCK_LABEL_305;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_305;
_L7:
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag))
        {
            break MISSING_BLOCK_LABEL_262;
        }
        entry.readable = true;
        writeCleanEntry(journalStream, entry);
_L8:
        if (size > maxSize || journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        lruEntries.remove(entry.key);
        writeEntryKey(journalStream, 3, entry.key);
          goto _L8
_L5:
        i++;
          goto _L9
_L2:
        i = 0;
          goto _L10
        i++;
          goto _L10
    }

    private static boolean deleteIfExists(File file)
        throws IOException
    {
        return file.exists() && file.delete();
    }

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int j, long l)
        throws IOException
    {
        DiskLruCache disklrucache;
        if (l <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        disklrucache = new DiskLruCache(file, i, j, l);
        if (!disklrucache.journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        int k = disklrucache.readJournal();
        disklrucache.processJournal();
        disklrucache.journalStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(disklrucache.journalFile, true)));
        disklrucache.redundantOpCount = k - disklrucache.lruEntries.size();
        return disklrucache;
        IOException ioexception;
        ioexception;
        Log.w("DiskLruCache", (new StringBuilder()).append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        disklrucache.delete();
        if (file.mkdirs() || file.exists())
        {
            file = new DiskLruCache(file, i, j, l);
            file.rebuildJournal();
            return file;
        } else
        {
            throw new FileNotFoundException((new StringBuilder()).append("directory not found ").append(file).toString());
        }
    }

    private void processJournal()
        throws IOException
    {
        deleteIfExists(journalFileTmp);
        for (Iterator iterator = lruEntries.values().iterator(); iterator.hasNext();)
        {
            Entry entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                int i = 0;
                while (i < valueCount) 
                {
                    size = size + entry.lengths[i];
                    i++;
                }
            } else
            {
                entry.currentEditor = null;
                for (int j = 0; j < valueCount; j++)
                {
                    deleteIfExists(entry.getCleanFile(j));
                    deleteIfExists(entry.getDirtyFile(j));
                }

                iterator.remove();
            }
        }

    }

    private int readJournal()
        throws IOException
    {
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(journalFile)));
        int i;
        int k;
        int l;
        byte byte0;
        long l1;
        l1 = datainputstream.readLong();
        i = datainputstream.readUnsignedByte();
        k = datainputstream.readInt();
        l = datainputstream.readInt();
        byte0 = datainputstream.readByte();
        if (0x814a4c450d0a1a0aL != l1 || 2 != i)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (appVersion == k && valueCount == l && byte0 == 10)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        Exception exception;
        throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(l1).append(", ").append(i).append(", ").append(l).append(", ").append(byte0).append("]").toString());
        int j = 0;
        do
        {
            try
            {
                readJournalLine(datainputstream);
            }
            catch (EOFException eofexception)
            {
                IoUtils.closeQuietly(datainputstream);
                return j;
            }
            finally
            {
                IoUtils.closeQuietly(datainputstream);
                throw exception;
            }
            j++;
        } while (true);
    }

    private void readJournalLine(DataInput datainput)
        throws IOException
    {
        int j = datainput.readUnsignedByte();
        String s = datainput.readUTF();
        if (j == 3 && datainput.readByte() == 10)
        {
            lruEntries.remove(s);
        } else
        {
            Entry entry1 = (Entry)lruEntries.get(s);
            Entry entry = entry1;
            if (entry1 == null)
            {
                entry = new Entry(s);
                lruEntries.put(s, entry);
            }
            if (j == 1)
            {
                long al[] = new long[valueCount];
                for (int i = 0; i < valueCount; i++)
                {
                    al[i] = datainput.readLong();
                }

                if (datainput.readByte() != 10)
                {
                    throw new IOException((new StringBuilder()).append("unexpected journal entry: ").append(j).append(" ").append(s).toString());
                } else
                {
                    entry.readable = true;
                    entry.currentEditor = null;
                    System.arraycopy(al, 0, entry.lengths, 0, valueCount);
                    return;
                }
            }
            if (j == 2 && datainput.readByte() == 10)
            {
                entry.currentEditor = new Editor(entry);
                return;
            }
            if (j != 4 || datainput.readByte() != 10)
            {
                throw new IOException((new StringBuilder()).append("unexpected journal entry: ").append(j).append(" ").append(s).toString());
            }
        }
    }

    private void rebuildJournal()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (journalStream != null)
        {
            journalStream.close();
        }
        obj = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(journalFileTmp)));
        Iterator iterator;
        ((DataOutputStream) (obj)).writeLong(0x814a4c450d0a1a0aL);
        ((DataOutputStream) (obj)).writeByte(2);
        ((DataOutputStream) (obj)).writeInt(appVersion);
        ((DataOutputStream) (obj)).writeInt(valueCount);
        ((DataOutputStream) (obj)).writeByte(10);
        iterator = lruEntries.values().iterator();
_L1:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_149;
            }
            entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                break MISSING_BLOCK_LABEL_140;
            }
            writeEntryKey(((DataOutput) (obj)), 2, entry.key);
        } while (true);
        Exception exception;
        exception;
        ((DataOutputStream) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        writeCleanEntry(((DataOutput) (obj)), entry);
          goto _L1
        ((DataOutputStream) (obj)).close();
        IoUtils.renameFileOrThrow(journalFileTmp, journalFile);
        journalStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(journalFile, true)));
        redundantOpCount = 0;
        this;
        JVM INSTR monitorexit ;
    }

    private void trimToSize()
        throws IOException
    {
        while (size > maxSize) 
        {
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    private void validateKey(String s)
    {
        if (s.contains(" ") || s.contains("\n") || s.contains("\r"))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must not contain spaces or newlines: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    private void writeCleanEntry(DataOutput dataoutput, Entry entry)
        throws IOException
    {
        dataoutput.writeByte(1);
        dataoutput.writeUTF(entry.key);
        entry = entry.lengths;
        int j = entry.length;
        for (int i = 0; i < j; i++)
        {
            dataoutput.writeLong(entry[i]);
        }

        dataoutput.writeByte(10);
    }

    private void writeEntryKey(DataOutput dataoutput, int i, String s)
        throws IOException
    {
        dataoutput.writeByte(i);
        dataoutput.writeUTF(s);
        dataoutput.writeByte(10);
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        DataOutputStream dataoutputstream = journalStream;
        if (dataoutputstream != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = (new ArrayList(lruEntries.values())).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Entry entry = (Entry)iterator.next();
            if (entry.currentEditor != null)
            {
                entry.currentEditor.abort();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_73;
        Exception exception;
        exception;
        throw exception;
        trimToSize();
        journalStream.close();
        journalStream = null;
          goto _L1
    }

    public void delete()
        throws IOException
    {
        close();
        if (directory.isDirectory())
        {
            IoUtils.deleteContents(directory);
        }
    }

    public Editor edit(String s)
        throws IOException
    {
        Editor editor = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        entry = new Entry(s);
        lruEntries.put(s, entry);
_L6:
        editor = new Editor(entry);
        entry.currentEditor = editor;
        writeEntryKey(journalStream, 2, s);
        journalStream.flush();
        s = editor;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        Editor editor1 = entry.currentEditor;
        if (editor1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = editor;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public void flush()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        checkNotClosed();
        trimToSize();
        journalStream.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Snapshot get(String s)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        s = get(s, false);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Snapshot get(String s, boolean flag)
        throws IOException
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Snapshot) (obj));
_L2:
        obj = obj1;
        String as[];
        if (!entry.readable)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new InputStream[valueCount];
        as = new String[valueCount];
        int i = 0;
        do
        {
            try
            {
                if (i >= valueCount)
                {
                    break;
                }
                File file = entry.getCleanFile(i);
                obj[i] = new FileInputStream(file);
                as[i] = file.getAbsolutePath();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                obj = obj1;
                continue; /* Loop/switch isn't completed */
            }
            finally
            {
                this;
            }
            i++;
        } while (true);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        redundantOpCount = redundantOpCount + 1;
        writeEntryKey(journalStream, 4, s);
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        obj = new Snapshot(((InputStream []) (obj)), as);
        if (true) goto _L4; else goto _L3
_L3:
        throw s;
    }

    public File getDirectory()
    {
        return directory;
    }

    public LinkedHashMap getLruEntries()
    {
        return lruEntries;
    }

    public boolean isClosed()
    {
        return journalStream == null;
    }

    public long maxSize()
    {
        return maxSize;
    }

    public boolean remove(String s)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry == null) goto _L2; else goto _L1
_L1:
        Editor editor = entry.currentEditor;
        if (editor == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        int i = 0;
_L5:
        if (i >= valueCount)
        {
            break; /* Loop/switch isn't completed */
        }
        IoUtils.deleteFileOrThrow(entry.getCleanFile(i));
        size = size - entry.lengths[i];
        entry.lengths[i] = 0L;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        redundantOpCount = redundantOpCount + 1;
        writeEntryKey(journalStream, 3, s);
        lruEntries.remove(s);
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
        s;
        throw s;
    }

    public long size()
    {
        this;
        JVM INSTR monitorenter ;
        long l = size;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }







}
