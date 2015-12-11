// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class LruDiskCache
    implements Closeable
{
    public final class Editor
    {

        private final Entry entry;
        private boolean hasErrors;
        final LruDiskCache this$0;

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

        public String getString(int i)
            throws IOException
        {
            InputStream inputstream = newInputStream(i);
            if (inputstream != null)
            {
                return LruDiskCache.inputStreamToString(inputstream);
            } else
            {
                return null;
            }
        }

        public InputStream newInputStream(int i)
            throws IOException
        {
            LruDiskCache lrudiskcache = LruDiskCache.this;
            lrudiskcache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Exception exception;
            exception;
            lrudiskcache;
            JVM INSTR monitorexit ;
            throw exception;
            if (entry.readable)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            lrudiskcache;
            JVM INSTR monitorexit ;
            return null;
            FileInputStream fileinputstream = new FileInputStream(entry.getCleanFile(i));
            lrudiskcache;
            JVM INSTR monitorexit ;
            return fileinputstream;
        }

        public OutputStream newOutputStream(int i)
            throws IOException
        {
            LruDiskCache lrudiskcache = LruDiskCache.this;
            lrudiskcache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Exception exception;
            exception;
            lrudiskcache;
            JVM INSTR monitorexit ;
            throw exception;
            FaultHidingOutputStream faulthidingoutputstream = new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(i)), null);
            lrudiskcache;
            JVM INSTR monitorexit ;
            return faulthidingoutputstream;
        }

        public void set(int i, String s)
            throws IOException
        {
            Object obj1 = null;
            Object obj = new OutputStreamWriter(newOutputStream(i), LruDiskCache.UTF_8);
            ((Writer) (obj)).write(s);
            LruDiskCache.closeQuietly(((Closeable) (obj)));
            return;
            obj;
            s = obj1;
_L2:
            LruDiskCache.closeQuietly(s);
            throw obj;
            Exception exception;
            exception;
            s = ((String) (obj));
            obj = exception;
            if (true) goto _L2; else goto _L1
_L1:
        }



        private Editor(Entry entry1)
        {
            this$0 = LruDiskCache.this;
            super();
            entry = entry1;
        }

        Editor(Entry entry1, Editor editor)
        {
            this(entry1);
        }
    }

    private class Editor.FaultHidingOutputStream extends FilterOutputStream
    {

        final Editor this$1;

        public void close()
        {
            try
            {
                out.close();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void flush()
        {
            try
            {
                out.flush();
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void write(int i)
        {
            try
            {
                out.write(i);
                return;
            }
            catch (IOException ioexception)
            {
                hasErrors = true;
            }
        }

        public void write(byte abyte0[], int i, int j)
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
        }

        private Editor.FaultHidingOutputStream(OutputStream outputstream)
        {
            this$1 = Editor.this;
            super(outputstream);
        }

        Editor.FaultHidingOutputStream(OutputStream outputstream, Editor.FaultHidingOutputStream faulthidingoutputstream)
        {
            this(outputstream);
        }
    }

    private final class Entry
    {

        private Editor currentEditor;
        private final String key;
        private final long lengths[];
        private boolean readable;
        private long sequenceNumber;
        final LruDiskCache this$0;

        private IOException invalidLengths(String as[])
            throws IOException
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
        }

        private void setLengths(String as[])
            throws IOException
        {
            int i;
            if (as.length != valueCount)
            {
                throw invalidLengths(as);
            }
            i = 0;
_L1:
            try
            {
                if (i >= as.length)
                {
                    return;
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                throw invalidLengths(as);
            }
            lengths[i] = Long.parseLong(as[i]);
            i++;
              goto _L1
        }

        public File getCleanFile(int i)
        {
            return new File(directory, (new StringBuilder(String.valueOf(key))).append(".").append(i).toString());
        }

        public File getDirtyFile(int i)
        {
            return new File(directory, (new StringBuilder(String.valueOf(key))).append(".").append(i).append(".tmp").toString());
        }

        public String getLengths()
            throws IOException
        {
            StringBuilder stringbuilder = new StringBuilder();
            long al[] = lengths;
            int j = al.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return stringbuilder.toString();
                }
                long l = al[i];
                stringbuilder.append(' ').append(l);
                i++;
            } while (true);
        }










        private Entry(String s)
        {
            this$0 = LruDiskCache.this;
            super();
            key = s;
            lengths = new long[valueCount];
        }

        Entry(String s, Entry entry)
        {
            this(s);
        }
    }

    public final class Snapshot
        implements Closeable
    {

        private final InputStream ins[];
        private final String key;
        private final long sequenceNumber;
        final LruDiskCache this$0;

        public void close()
        {
            InputStream ainputstream[] = ins;
            int j = ainputstream.length;
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return;
                }
                LruDiskCache.closeQuietly(ainputstream[i]);
                i++;
            } while (true);
        }

        public Editor edit()
            throws IOException
        {
            return LruDiskCache.this.edit(key, sequenceNumber);
        }

        public InputStream getInputStream(int i)
        {
            return ins[i];
        }

        public String getString(int i)
            throws IOException
        {
            return LruDiskCache.inputStreamToString(getInputStream(i));
        }

        private Snapshot(String s, long l, InputStream ainputstream[])
        {
            this$0 = LruDiskCache.this;
            super();
            key = s;
            sequenceNumber = l;
            ins = ainputstream;
        }

        Snapshot(String s, long l, InputStream ainputstream[], Snapshot snapshot)
        {
            this(s, l, ainputstream);
        }
    }


    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final int IO_BUFFER_SIZE = 8192;
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_TMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable cleanupCallable = new Callable() {

        final LruDiskCache this$0;

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
                synchronized (LruDiskCache.this)
                {
                    if (journalWriter != null)
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
                redundantOpCount = 0;
            }
            lrudiskcache;
            JVM INSTR monitorexit ;
            return null;
            exception;
            lrudiskcache;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = LruDiskCache.this;
                super();
            }
    };
    private final File directory;
    private final ExecutorService executorService;
    private final File journalFile;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private final long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private LruDiskCache(File file, int i, int j, long l)
    {
        size = 0L;
        nextSequenceNumber = 0L;
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        valueCount = j;
        maxSize = l;
    }

    private void checkNotClosed()
    {
        if (journalWriter == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
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
_L12:
        if (i < valueCount) goto _L4; else goto _L2
_L11:
        if (i < valueCount) goto _L6; else goto _L5
_L5:
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag)) goto _L8; else goto _L7
_L7:
        entry.readable = true;
        journalWriter.write((new StringBuilder("CLEAN ")).append(entry.key).append(entry.getLengths()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        long l = nextSequenceNumber;
        nextSequenceNumber = 1L + l;
        entry.sequenceNumber = l;
_L10:
        if (size > maxSize || journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!entry.getDirtyFile(i).exists())
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder("edit didn't create file ")).append(i).toString());
        }
          goto _L9
_L6:
        editor = entry.getDirtyFile(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        if (editor.exists())
        {
            File file = entry.getCleanFile(i);
            editor.renameTo(file);
            long l1 = entry.lengths[i];
            long l2 = file.length();
            entry.lengths[i] = l2;
            size = (size - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_376;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_376;
_L8:
        lruEntries.remove(entry.key);
        journalWriter.write((new StringBuilder("REMOVE ")).append(entry.key).append('\n').toString());
          goto _L10
_L2:
        i = 0;
          goto _L11
_L9:
        i++;
          goto _L12
        i++;
          goto _L11
    }

    private static Object[] copyOfRange(Object aobj[], int i, int j)
    {
        int k = aobj.length;
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            Object aobj1[] = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
            System.arraycopy(((Object) (aobj)), i, ((Object) (aobj1)), 0, k);
            return aobj1;
        }
    }

    public static void deleteContents(File file)
        throws IOException
    {
        file = file.listFiles();
        if (file != null)
        {
            int j = file.length;
            int i = 0;
            while (i < j) 
            {
                File file1 = file[i];
                if (file1.isDirectory())
                {
                    deleteContents(file1);
                }
                if (!file1.delete())
                {
                    throw new IOException((new StringBuilder("failed to delete file: ")).append(file1).toString());
                }
                i++;
            }
        }
    }

    private static void deleteIfExists(File file)
        throws IOException
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private Editor edit(String s, long l)
        throws IOException
    {
        Editor editor = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (l == -1L) goto _L2; else goto _L1
_L1:
        Object obj = editor;
        if (entry == null) goto _L4; else goto _L3
_L3:
        long l1 = entry.sequenceNumber;
        if (l1 == l) goto _L2; else goto _L5
_L5:
        obj = editor;
_L4:
        this;
        JVM INSTR monitorexit ;
        return ((Editor) (obj));
_L2:
        if (entry != null) goto _L7; else goto _L6
_L6:
        obj = new Entry(s, null);
        lruEntries.put(s, obj);
_L9:
        editor = new Editor(((Entry) (obj)), null);
        obj.currentEditor = editor;
        journalWriter.write((new StringBuilder("DIRTY ")).append(s).append('\n').toString());
        journalWriter.flush();
        obj = editor;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L7:
        Editor editor1 = entry.currentEditor;
        obj = entry;
        if (editor1 == null) goto _L9; else goto _L8
_L8:
        obj = editor;
        if (true) goto _L4; else goto _L10
_L10:
    }

    private static String inputStreamToString(InputStream inputstream)
        throws IOException
    {
        return readFully(new InputStreamReader(inputstream, UTF_8));
    }

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    public static LruDiskCache open(File file, int i, int j, long l)
        throws IOException
    {
        LruDiskCache lrudiskcache;
        if (l <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        if (file != null && !file.exists())
        {
            file.mkdirs();
        }
        lrudiskcache = new LruDiskCache(file, i, j, l);
        if (!lrudiskcache.journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        lrudiskcache.readJournal();
        lrudiskcache.processJournal();
        lrudiskcache.journalWriter = new BufferedWriter(new FileWriter(lrudiskcache.journalFile, true), 8192);
        return lrudiskcache;
        IOException ioexception;
        ioexception;
        lrudiskcache.delete();
        file.mkdirs();
        file = new LruDiskCache(file, i, j, l);
        file.rebuildJournal();
        return file;
    }

    private void processJournal()
        throws IOException
    {
        Iterator iterator;
        deleteIfExists(journalFileTmp);
        iterator = lruEntries.values().iterator();
_L2:
        Entry entry;
        int j;
        if (!iterator.hasNext())
        {
            return;
        }
        entry = (Entry)iterator.next();
        if (entry.currentEditor == null)
        {
            int i = 0;
            while (i < valueCount) 
            {
                size = size + entry.lengths[i];
                i++;
            }
            continue; /* Loop/switch isn't completed */
        }
        entry.currentEditor = null;
        j = 0;
_L3:
label0:
        {
            if (j < valueCount)
            {
                break label0;
            }
            iterator.remove();
        }
        if (true) goto _L2; else goto _L1
_L1:
        deleteIfExists(entry.getCleanFile(j));
        deleteIfExists(entry.getDirtyFile(j));
        j++;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static String readAsciiLine(InputStream inputstream)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder(80);
        do
        {
            int i = inputstream.read();
            if (i == -1)
            {
                throw new EOFException();
            }
            if (i == 10)
            {
                i = stringbuilder.length();
                if (i > 0 && stringbuilder.charAt(i - 1) == '\r')
                {
                    stringbuilder.setLength(i - 1);
                }
                return stringbuilder.toString();
            }
            stringbuilder.append((char)i);
        } while (true);
    }

    public static String readFully(Reader reader)
        throws IOException
    {
        Object obj;
        char ac[];
        obj = new StringWriter();
        ac = new char[1024];
_L1:
        int i = reader.read(ac);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = ((StringWriter) (obj)).toString();
        reader.close();
        return ((String) (obj));
        ((StringWriter) (obj)).write(ac, 0, i);
          goto _L1
        Exception exception;
        exception;
        reader.close();
        throw exception;
    }

    private void readJournal()
        throws IOException
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(journalFile), 8192);
        Exception exception;
        String s = readAsciiLine(bufferedinputstream);
        String s1 = readAsciiLine(bufferedinputstream);
        String s2 = readAsciiLine(bufferedinputstream);
        String s3 = readAsciiLine(bufferedinputstream);
        String s4 = readAsciiLine(bufferedinputstream);
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(appVersion).equals(s2) || !Integer.toString(valueCount).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        try
        {
            do
            {
                readJournalLine(readAsciiLine(bufferedinputstream));
            } while (true);
        }
        catch (EOFException eofexception)
        {
            closeQuietly(bufferedinputstream);
        }
        finally
        {
            closeQuietly(bufferedinputstream);
            throw exception;
        }
        return;
    }

    private void readJournalLine(String s)
        throws IOException
    {
        String as[] = s.split(" ");
        if (as.length < 2)
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
        }
        String s1 = as[1];
        if (as[0].equals("REMOVE") && as.length == 2)
        {
            lruEntries.remove(s1);
        } else
        {
            Entry entry1 = (Entry)lruEntries.get(s1);
            Entry entry = entry1;
            if (entry1 == null)
            {
                entry = new Entry(s1, null);
                lruEntries.put(s1, entry);
            }
            if (as[0].equals("CLEAN") && as.length == valueCount + 2)
            {
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths((String[])copyOfRange(as, 2, as.length));
                return;
            }
            if (as[0].equals("DIRTY") && as.length == 2)
            {
                entry.currentEditor = new Editor(entry, null);
                return;
            }
            if (!as[0].equals("READ") || as.length != 2)
            {
                throw new IOException((new StringBuilder("unexpected journal line: ")).append(s).toString());
            }
        }
    }

    private void rebuildJournal()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        if (journalWriter != null)
        {
            journalWriter.close();
        }
        obj = new BufferedWriter(new FileWriter(journalFileTmp), 8192);
        ((Writer) (obj)).write("libcore.io.DiskLruCache");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("1");
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(appVersion));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write(Integer.toString(valueCount));
        ((Writer) (obj)).write("\n");
        ((Writer) (obj)).write("\n");
        iterator = lruEntries.values().iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ((Writer) (obj)).close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true), 8192);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Entry entry;
        entry = (Entry)iterator.next();
        if (entry.currentEditor == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        ((Writer) (obj)).write((new StringBuilder("DIRTY ")).append(entry.key).append('\n').toString());
          goto _L3
        obj;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder("CLEAN ")).append(entry.key).append(entry.getLengths()).append('\n').toString());
          goto _L3
    }

    private void trimToSize()
        throws IOException
    {
        do
        {
            if (size <= maxSize)
            {
                return;
            }
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        } while (true);
    }

    private void validateKey(String s)
    {
        if (s.contains(" ") || s.contains("\n") || s.contains("\r"))
        {
            throw new IllegalArgumentException((new StringBuilder("keys must not contain spaces or newlines: \"")).append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = journalWriter;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = (new ArrayList(lruEntries.values())).iterator();
_L4:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        trimToSize();
        journalWriter.close();
        journalWriter = null;
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
        Entry entry = (Entry)((Iterator) (obj)).next();
        if (entry.currentEditor != null)
        {
            entry.currentEditor.abort();
        }
          goto _L4
    }

    public void delete()
        throws IOException
    {
        close();
        deleteContents(directory);
    }

    public Editor edit(String s)
        throws IOException
    {
        return edit(s, -1L);
    }

    public void flush()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
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
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((Snapshot) (obj));
_L2:
        obj = obj1;
        if (!entry.readable)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new InputStream[valueCount];
        int i = 0;
_L3:
        int j = valueCount;
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        redundantOpCount = redundantOpCount + 1;
        journalWriter.append((new StringBuilder("READ ")).append(s).append('\n').toString());
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        obj = new Snapshot(s, entry.sequenceNumber, ((InputStream []) (obj)), null);
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
        obj[i] = new FileInputStream(entry.getCleanFile(i));
        i++;
          goto _L3
        s;
        obj = obj1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public File getDirectory()
    {
        return directory;
    }

    public boolean isClosed()
    {
        return journalWriter == null;
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
            redundantOpCount = redundantOpCount + 1;
            journalWriter.append((new StringBuilder("REMOVE ")).append(s).append('\n').toString());
            lruEntries.remove(s);
            if (journalRebuildRequired())
            {
                executorService.submit(cleanupCallable);
            }
            break; /* Loop/switch isn't completed */
        }
        File file = entry.getCleanFile(i);
        if (!file.delete())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        }
        break MISSING_BLOCK_LABEL_173;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        size = size - entry.lengths[i];
        entry.lengths[i] = 0L;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
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
