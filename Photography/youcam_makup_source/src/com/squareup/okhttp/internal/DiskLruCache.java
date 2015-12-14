// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.d;
import okio.e;
import okio.f;
import okio.l;
import okio.q;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal:
//            Util, Platform

public final class DiskLruCache
    implements Closeable
{

    static final long ANY_SEQUENCE_NUMBER = -1L;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final q NULL_SINK = new q() {

        public void close()
        {
        }

        public void flush()
        {
        }

        public s timeout()
        {
            return s.NONE;
        }

        public void write(d d, long l1)
        {
        }

    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new Runnable() {

        final DiskLruCache this$0;

        public void run()
        {
label0:
            {
                synchronized (DiskLruCache.this)
                {
                    if (journalWriter != null)
                    {
                        break label0;
                    }
                }
                return;
            }
            trimToSize();
            if (journalRebuildRequired())
            {
                rebuildJournal();
                redundantOpCount = 0;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
            IOException ioexception;
            ioexception;
            throw new RuntimeException(ioexception);
        }

            
            {
                this$0 = DiskLruCache.this;
                super();
            }
    };
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private e journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private DiskLruCache(File file, int i, int j, long l1)
    {
        size = 0L;
        nextSequenceNumber = 0L;
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true));
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        journalFileBackup = new File(file, "journal.bkp");
        valueCount = j;
        maxSize = l1;
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

    private void completeEdit(Editor editor, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        entry = editor.entry;
        if (entry.currentEditor != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        editor;
        this;
        JVM INSTR monitorexit ;
        throw editor;
        int j = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j = ((flag1) ? 1 : 0);
        if (entry.readable) goto _L2; else goto _L3
_L3:
        int i = 0;
_L7:
        j = ((flag1) ? 1 : 0);
        if (i >= valueCount) goto _L2; else goto _L4
_L4:
        if (!editor.written[i])
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder()).append("Newly created entry didn't create value for index ").append(i).toString());
        }
        if (entry.dirtyFiles[i].exists()) goto _L6; else goto _L5
_L5:
        editor.abort();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        i++;
          goto _L7
_L2:
        File file;
        long l1;
        long l2;
        for (; j >= valueCount; j++)
        {
            break MISSING_BLOCK_LABEL_230;
        }

        editor = entry.dirtyFiles[j];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        if (editor.exists())
        {
            file = entry.cleanFiles[j];
            editor.renameTo(file);
            l1 = entry.lengths[j];
            l2 = file.length();
            entry.lengths[j] = l2;
            size = (size - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_447;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_447;
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag))
        {
            break MISSING_BLOCK_LABEL_387;
        }
        entry.readable = true;
        journalWriter.b("CLEAN").g(32);
        journalWriter.b(entry.key);
        journalWriter.b(entry.getLengths());
        journalWriter.g(10);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        l1 = nextSequenceNumber;
        nextSequenceNumber = 1L + l1;
        entry.sequenceNumber = l1;
_L9:
        journalWriter.flush();
        if (size > maxSize || journalRebuildRequired())
        {
            executorService.execute(cleanupRunnable);
        }
          goto _L8
        lruEntries.remove(entry.key);
        journalWriter.b("REMOVE").g(32);
        journalWriter.b(entry.key);
        journalWriter.g(10);
          goto _L9
    }

    private static void deleteIfExists(File file)
    {
        if (!file.delete() && file.exists())
        {
            throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
        } else
        {
            return;
        }
    }

    private Editor edit(String s, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (entry == null) goto _L4; else goto _L3
_L3:
        long l2 = entry.sequenceNumber;
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s = null;
_L10:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (entry != null) goto _L6; else goto _L5
_L5:
        entry = new Entry(s);
        lruEntries.put(s, entry);
_L8:
        Editor editor;
        editor = new Editor(entry);
        entry.currentEditor = editor;
        journalWriter.b("DIRTY").g(32).b(s).g(10);
        journalWriter.flush();
        s = editor;
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L6:
        editor = entry.currentEditor;
        if (editor == null) goto _L8; else goto _L7
_L7:
        s = null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int j, long l1)
    {
        Object obj;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (j <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        obj = new File(file, "journal.bkp");
        if (((File) (obj)).exists())
        {
            File file1 = new File(file, "journal");
            if (file1.exists())
            {
                ((File) (obj)).delete();
            } else
            {
                renameTo(((File) (obj)), file1, false);
            }
        }
        obj = new DiskLruCache(file, i, j, l1);
        if (!((DiskLruCache) (obj)).journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ((DiskLruCache) (obj)).readJournal();
        ((DiskLruCache) (obj)).processJournal();
        return ((DiskLruCache) (obj));
        IOException ioexception;
        ioexception;
        Platform.get().logW((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((DiskLruCache) (obj)).delete();
        file.mkdirs();
        file = new DiskLruCache(file, i, j, l1);
        file.rebuildJournal();
        return file;
    }

    private void processJournal()
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
                    deleteIfExists(entry.cleanFiles[j]);
                    deleteIfExists(entry.dirtyFiles[j]);
                }

                iterator.remove();
            }
        }

    }

    private void readJournal()
    {
        f f1 = l.a(l.a(journalFile));
        String s = f1.o();
        String s1 = f1.o();
        String s2 = f1.o();
        String s3 = f1.o();
        String s4 = f1.o();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(appVersion).equals(s2) || !Integer.toString(valueCount).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_181;
        Object obj;
        obj;
        Util.closeQuietly(f1);
        throw obj;
        int i = 0;
_L2:
        readJournalLine(f1.o());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        redundantOpCount = i - lruEntries.size();
        if (f1.e())
        {
            break MISSING_BLOCK_LABEL_236;
        }
        rebuildJournal();
_L3:
        Util.closeQuietly(f1);
        return;
        journalWriter = l.a(l.c(journalFile));
          goto _L3
    }

    private void readJournalLine(String s)
    {
        int i;
        int j;
        int k;
        i = s.indexOf(' ');
        if (i == -1)
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        j = i + 1;
        k = s.indexOf(' ', j);
        if (k != -1) goto _L2; else goto _L1
_L1:
        String s1 = s.substring(j);
        if (i != "REMOVE".length() || !s.startsWith("REMOVE")) goto _L4; else goto _L3
_L3:
        lruEntries.remove(s1);
_L6:
        return;
_L2:
        s1 = s.substring(j, k);
_L4:
        Entry entry1 = (Entry)lruEntries.get(s1);
        Entry entry = entry1;
        if (entry1 == null)
        {
            entry = new Entry(s1);
            lruEntries.put(s1, entry);
        }
        if (k != -1 && i == "CLEAN".length() && s.startsWith("CLEAN"))
        {
            s = s.substring(k + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(s);
            return;
        }
        if (k == -1 && i == "DIRTY".length() && s.startsWith("DIRTY"))
        {
            entry.currentEditor = new Editor(entry);
            return;
        }
        if (k != -1 || i != "READ".length() || !s.startsWith("READ"))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void rebuildJournal()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (journalWriter != null)
        {
            journalWriter.close();
        }
        obj = l.a(l.b(journalFileTmp));
        Iterator iterator;
        ((e) (obj)).b("libcore.io.DiskLruCache").g(10);
        ((e) (obj)).b("1").g(10);
        ((e) (obj)).b(Integer.toString(appVersion)).g(10);
        ((e) (obj)).b(Integer.toString(valueCount)).g(10);
        ((e) (obj)).g(10);
        iterator = lruEntries.values().iterator();
_L1:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_254;
            }
            entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                break MISSING_BLOCK_LABEL_204;
            }
            ((e) (obj)).b("DIRTY").g(32);
            ((e) (obj)).b(entry.key);
            ((e) (obj)).g(10);
        } while (true);
        Exception exception;
        exception;
        ((e) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((e) (obj)).b("CLEAN").g(32);
        ((e) (obj)).b(entry.key);
        ((e) (obj)).b(entry.getLengths());
        ((e) (obj)).g(10);
          goto _L1
        ((e) (obj)).close();
        if (journalFile.exists())
        {
            renameTo(journalFile, journalFileBackup, true);
        }
        renameTo(journalFileTmp, journalFile, false);
        journalFileBackup.delete();
        journalWriter = l.a(l.c(journalFile));
        this;
        JVM INSTR monitorexit ;
    }

    private boolean removeEntry(Entry entry)
    {
        if (entry.currentEditor != null)
        {
            entry.currentEditor.hasErrors = true;
        }
        for (int i = 0; i < valueCount; i++)
        {
            deleteIfExists(entry.cleanFiles[i]);
            size = size - entry.lengths[i];
            entry.lengths[i] = 0L;
        }

        redundantOpCount = redundantOpCount + 1;
        journalWriter.b("REMOVE").g(32).b(entry.key).g(10);
        lruEntries.remove(entry.key);
        if (journalRebuildRequired())
        {
            executorService.execute(cleanupRunnable);
        }
        return true;
    }

    private static void renameTo(File file, File file1, boolean flag)
    {
        if (flag)
        {
            deleteIfExists(file1);
        }
        if (!file.renameTo(file1))
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private static String sourceToString(r r1)
    {
        String s = l.a(r1).n();
        Util.closeQuietly(r1);
        return s;
        Exception exception;
        exception;
        Util.closeQuietly(r1);
        throw exception;
    }

    private void trimToSize()
    {
        while (size > maxSize) 
        {
            removeEntry((Entry)lruEntries.values().iterator().next());
        }
    }

    private void validateKey(String s)
    {
        if (!LEGAL_KEY_PATTERN.matcher(s).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must match regex [a-z0-9_-]{1,120}: \"").append(s).append("\"").toString());
        } else
        {
            return;
        }
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        e e1 = journalWriter;
        if (e1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Entry aentry[];
        int j;
        aentry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
        j = aentry.length;
        Exception exception;
        Entry entry;
        for (int i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_73;
        }

        entry = aentry[i];
        if (entry.currentEditor != null)
        {
            entry.currentEditor.abort();
        }
        break MISSING_BLOCK_LABEL_99;
        trimToSize();
        journalWriter.close();
        journalWriter = null;
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        throw exception;
    }

    public void delete()
    {
        close();
        Util.deleteContents(directory);
    }

    public Editor edit(String s)
    {
        return edit(s, -1L);
    }

    public void evictAll()
    {
        this;
        JVM INSTR monitorenter ;
        Entry aentry[];
        int j;
        aentry = (Entry[])lruEntries.values().toArray(new Entry[lruEntries.size()]);
        j = aentry.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        removeEntry(aentry[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void flush()
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
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        validateKey(s);
        entry = (Entry)lruEntries.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        Snapshot snapshot = obj;
_L7:
        this;
        JVM INSTR monitorexit ;
        return snapshot;
_L2:
        snapshot = obj;
        r ar[];
        if (!entry.readable)
        {
            continue; /* Loop/switch isn't completed */
        }
        ar = new r[valueCount];
        int i = 0;
_L4:
        if (i >= valueCount)
        {
            break; /* Loop/switch isn't completed */
        }
        ar[i] = l.a(entry.cleanFiles[i]);
        i++;
        if (true) goto _L4; else goto _L3
        s;
        i = 0;
_L5:
        snapshot = obj;
        if (i >= valueCount)
        {
            continue; /* Loop/switch isn't completed */
        }
        snapshot = obj;
        if (ar[i] == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Util.closeQuietly(ar[i]);
        i++;
        if (true) goto _L5; else goto _L3
_L3:
        redundantOpCount = redundantOpCount + 1;
        journalWriter.b("READ").g(32).b(s).g(10);
        if (journalRebuildRequired())
        {
            executorService.execute(cleanupRunnable);
        }
        snapshot = new Snapshot(s, entry.sequenceNumber, ar, entry.lengths);
        if (true) goto _L7; else goto _L6
_L6:
        s;
        throw s;
    }

    public File getDirectory()
    {
        return directory;
    }

    public long getMaxSize()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = maxSize;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isClosed()
    {
        return journalWriter == null;
    }

    public boolean remove(String s)
    {
        this;
        JVM INSTR monitorenter ;
        checkNotClosed();
        validateKey(s);
        s = (Entry)lruEntries.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = removeEntry(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void setMaxSize(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        maxSize = l1;
        executorService.execute(cleanupRunnable);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long size()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = size;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }














/*
    static int access$402(DiskLruCache disklrucache, int i)
    {
        disklrucache.redundantOpCount = i;
        return i;
    }

*/

    private class Editor
    {
        private class Entry
        {

            private final File cleanFiles[];
            private Editor currentEditor;
            private final File dirtyFiles[];
            private final String key;
            private final long lengths[];
            private boolean readable;
            private long sequenceNumber;
            final DiskLruCache this$0;

            private IOException invalidLengths(String as[])
            {
                throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
            }

            private void setLengths(String as[])
            {
                if (as.length != valueCount)
                {
                    throw invalidLengths(as);
                }
                int i = 0;
                do
                {
                    try
                    {
                        if (i >= as.length)
                        {
                            break;
                        }
                        lengths[i] = Long.parseLong(as[i]);
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        throw invalidLengths(as);
                    }
                    i++;
                } while (true);
            }

            public String getLengths()
            {
                StringBuilder stringbuilder = new StringBuilder();
                long al[] = lengths;
                int j = al.length;
                for (int i = 0; i < j; i++)
                {
                    long l1 = al[i];
                    stringbuilder.append(' ').append(l1);
                }

                return stringbuilder.toString();
            }







/*
            static long access$1402(Entry entry1, long l1)
            {
                entry1.sequenceNumber = l1;
                return l1;
            }

*/



/*
            static boolean access$602(Entry entry1, boolean flag)
            {
                entry1.readable = flag;
                return flag;
            }

*/



/*
            static Editor access$702(Entry entry1, Editor editor)
            {
                entry1.currentEditor = editor;
                return editor;
            }

*/


            private Entry(String s)
            {
                this$0 = DiskLruCache.this;
                super();
                key = s;
                lengths = new long[valueCount];
                cleanFiles = new File[valueCount];
                dirtyFiles = new File[valueCount];
                s = (new StringBuilder(s)).append('.');
                int j = s.length();
                for (int i = 0; i < valueCount; i++)
                {
                    s.append(i);
                    cleanFiles[i] = new File(directory, s.toString());
                    s.append(".tmp");
                    dirtyFiles[i] = new File(directory, s.toString());
                    s.setLength(j);
                }

            }

        }


        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        final DiskLruCache this$0;
        private final boolean written[];

        public void abort()
        {
            synchronized (DiskLruCache.this)
            {
                completeEdit(this, false);
            }
            return;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void abortUnlessCommitted()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            boolean flag = committed;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_25;
            }
            Exception exception;
            try
            {
                completeEdit(this, false);
            }
            catch (IOException ioexception) { }
            disklrucache;
            JVM INSTR monitorexit ;
            return;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void commit()
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (!hasErrors)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            completeEdit(this, false);
            removeEntry(entry);
_L2:
            committed = true;
            return;
            completeEdit(this, true);
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public String getString(int i)
        {
            r r1 = newSource(i);
            if (r1 != null)
            {
                return DiskLruCache.sourceToString(r1);
            } else
            {
                return null;
            }
        }

        public q newSink(int i)
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            disklrucache;
            JVM INSTR monitorexit ;
            throw obj;
            File file;
            if (!entry.readable)
            {
                written[i] = true;
            }
            file = entry.dirtyFiles[i];
            Object obj1 = l.b(file);
_L1:
            class FaultHidingSink extends h
            {

                final Editor this$1;

                public void close()
                {
                    try
                    {
                        super.close();
                        return;
                    }
                    catch (IOException ioexception) { }
                    synchronized (_fld0)
                    {
                        hasErrors = true;
                    }
                    return;
                    exception;
                    disklrucache1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public void flush()
                {
                    try
                    {
                        super.flush();
                        return;
                    }
                    catch (IOException ioexception) { }
                    synchronized (_fld0)
                    {
                        hasErrors = true;
                    }
                    return;
                    exception;
                    disklrucache1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public void write(d d, long l1)
                {
                    try
                    {
                        super.write(d, l1);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (d d) { }
                    synchronized (_fld0)
                    {
                        hasErrors = true;
                    }
                    return;
                    exception;
                    d;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public FaultHidingSink(q q)
                {
                    this$1 = Editor.this;
                    super(q);
                }
            }

            obj1 = new FaultHidingSink(((q) (obj1)));
            disklrucache;
            JVM INSTR monitorexit ;
            return ((q) (obj1));
            obj1;
            directory.mkdirs();
            obj1 = l.b(file);
              goto _L1
            obj1;
            obj1 = DiskLruCache.NULL_SINK;
            disklrucache;
            JVM INSTR monitorexit ;
            return ((q) (obj1));
        }

        public r newSource(int i)
        {
            DiskLruCache disklrucache = DiskLruCache.this;
            disklrucache;
            JVM INSTR monitorenter ;
            if (entry.currentEditor != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            disklrucache;
            JVM INSTR monitorexit ;
            throw obj;
            if (entry.readable)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
            r r1 = l.a(entry.cleanFiles[i]);
            disklrucache;
            JVM INSTR monitorexit ;
            return r1;
            r1;
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
        }

        public void set(int i, String s)
        {
            e e1 = l.a(newSink(i));
            e1.b(s);
            e1.close();
        }




/*
        static boolean access$1802(Editor editor, boolean flag)
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
            if (entry1.readable)
            {
                disklrucache = null;
            } else
            {
                disklrucache = new boolean[valueCount];
            }
            written = DiskLruCache.this;
        }

    }


    private class Snapshot
        implements Closeable
    {

        private final String key;
        private final long lengths[];
        private final long sequenceNumber;
        private final r sources[];
        final DiskLruCache this$0;

        public void close()
        {
            r ar[] = sources;
            int j = ar.length;
            for (int i = 0; i < j; i++)
            {
                Util.closeQuietly(ar[i]);
            }

        }

        public Editor edit()
        {
            return DiskLruCache.this.edit(key, sequenceNumber);
        }

        public long getLength(int i)
        {
            return lengths[i];
        }

        public r getSource(int i)
        {
            return sources[i];
        }

        public String getString(int i)
        {
            return DiskLruCache.sourceToString(getSource(i));
        }

        private Snapshot(String s, long l1, r ar[], long al[])
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            sequenceNumber = l1;
            sources = ar;
            lengths = al;
        }

        Snapshot(String s, long l1, r ar[], long al[], _cls1 _pcls1)
        {
            this(s, l1, ar, al);
        }
    }

}
