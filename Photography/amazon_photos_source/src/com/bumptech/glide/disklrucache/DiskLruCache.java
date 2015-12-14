// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.bumptech.glide.disklrucache:
//            StrictLineReader, Util

public final class DiskLruCache
    implements Closeable
{
    public final class Editor
    {

        private boolean committed;
        private final Entry entry;
        final DiskLruCache this$0;
        private final boolean written[];

        public void abort()
            throws IOException
        {
            completeEdit(this, false);
        }

        public void abortUnlessCommitted()
        {
            if (committed)
            {
                break MISSING_BLOCK_LABEL_11;
            }
            abort();
            return;
            IOException ioexception;
            ioexception;
        }

        public void commit()
            throws IOException
        {
            completeEdit(this, true);
            committed = true;
        }

        public File getFile(int i)
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
            File file;
            if (!entry.readable)
            {
                written[i] = true;
            }
            file = entry.getDirtyFile(i);
            if (!directory.exists())
            {
                directory.mkdirs();
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return file;
        }



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

    private final class Entry
    {

        File cleanFiles[];
        private Editor currentEditor;
        File dirtyFiles[];
        private final String key;
        private final long lengths[];
        private boolean readable;
        private long sequenceNumber;
        final DiskLruCache this$0;

        private IOException invalidLengths(String as[])
            throws IOException
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
        }

        private void setLengths(String as[])
            throws IOException
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

        public File getCleanFile(int i)
        {
            return cleanFiles[i];
        }

        public File getDirtyFile(int i)
        {
            return dirtyFiles[i];
        }

        public String getLengths()
            throws IOException
        {
            StringBuilder stringbuilder = new StringBuilder();
            long al[] = lengths;
            int j = al.length;
            for (int i = 0; i < j; i++)
            {
                long l = al[i];
                stringbuilder.append(' ').append(l);
            }

            return stringbuilder.toString();
        }





/*
        static long access$1202(Entry entry, long l)
        {
            entry.sequenceNumber = l;
            return l;
        }

*/



/*
        static boolean access$602(Entry entry, boolean flag)
        {
            entry.readable = flag;
            return flag;
        }

*/



/*
        static Editor access$702(Entry entry, Editor editor)
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

    public final class Value
    {

        private final File files[];
        private final String key;
        private final long lengths[];
        private final long sequenceNumber;
        final DiskLruCache this$0;

        public File getFile(int i)
        {
            return files[i];
        }

        private Value(String s, long l, File afile[], long al[])
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            sequenceNumber = l;
            files = afile;
            lengths = al;
        }

        Value(String s, long l, File afile[], long al[], _cls1 _pcls1)
        {
            this(s, l, afile, al);
        }
    }


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
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    private DiskLruCache(File file, int i, int j, long l)
    {
        size = 0L;
        nextSequenceNumber = 0L;
        executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        directory = file;
        appVersion = i;
        journalFile = new File(file, "journal");
        journalFileTmp = new File(file, "journal.tmp");
        journalFileBackup = new File(file, "journal.bkp");
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
_L7:
        if (i >= valueCount) goto _L2; else goto _L4
_L4:
        if (!editor.written[i])
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder()).append("Newly created entry didn't create value for index ").append(i).toString());
        }
        if (entry.getDirtyFile(i).exists()) goto _L6; else goto _L5
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
        i = 0;
_L10:
        if (i >= valueCount)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        editor = entry.getDirtyFile(i);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (editor.exists())
        {
            File file = entry.getCleanFile(i);
            editor.renameTo(file);
            long l = entry.lengths[i];
            long l2 = file.length();
            entry.lengths[i] = l2;
            size = (size - l) + l2;
        }
        break MISSING_BLOCK_LABEL_423;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_423;
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag))
        {
            break MISSING_BLOCK_LABEL_366;
        }
        entry.readable = true;
        journalWriter.append("CLEAN");
        journalWriter.append(' ');
        journalWriter.append(entry.key);
        journalWriter.append(entry.getLengths());
        journalWriter.append('\n');
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        long l1 = nextSequenceNumber;
        nextSequenceNumber = 1L + l1;
        entry.sequenceNumber = l1;
_L9:
        journalWriter.flush();
        if (size > maxSize || journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
          goto _L8
        lruEntries.remove(entry.key);
        journalWriter.append("REMOVE");
        journalWriter.append(' ');
        journalWriter.append(entry.key);
        journalWriter.append('\n');
          goto _L9
        i++;
          goto _L10
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
        obj = new Entry(s);
        lruEntries.put(s, obj);
_L9:
        editor = new Editor(((Entry) (obj)));
        obj.currentEditor = editor;
        journalWriter.append("DIRTY");
        journalWriter.append(' ');
        journalWriter.append(s);
        journalWriter.append('\n');
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

    private boolean journalRebuildRequired()
    {
        return redundantOpCount >= 2000 && redundantOpCount >= lruEntries.size();
    }

    public static DiskLruCache open(File file, int i, int j, long l)
        throws IOException
    {
        Object obj;
        if (l <= 0L)
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
        obj = new DiskLruCache(file, i, j, l);
        if (!((DiskLruCache) (obj)).journalFile.exists())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ((DiskLruCache) (obj)).readJournal();
        ((DiskLruCache) (obj)).processJournal();
        return ((DiskLruCache) (obj));
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        ((DiskLruCache) (obj)).delete();
        file.mkdirs();
        file = new DiskLruCache(file, i, j, l);
        file.rebuildJournal();
        return file;
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

    private void readJournal()
        throws IOException
    {
        StrictLineReader strictlinereader = new StrictLineReader(new FileInputStream(journalFile), Util.US_ASCII);
        String s = strictlinereader.readLine();
        String s1 = strictlinereader.readLine();
        String s2 = strictlinereader.readLine();
        String s3 = strictlinereader.readLine();
        String s4 = strictlinereader.readLine();
        if (!"libcore.io.DiskLruCache".equals(s) || !"1".equals(s1) || !Integer.toString(appVersion).equals(s2) || !Integer.toString(valueCount).equals(s3) || !"".equals(s4))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_184;
        Object obj;
        obj;
        Util.closeQuietly(strictlinereader);
        throw obj;
        int i = 0;
_L2:
        readJournalLine(strictlinereader.readLine());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        redundantOpCount = i - lruEntries.size();
        if (!strictlinereader.hasUnterminatedLine())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        rebuildJournal();
_L3:
        Util.closeQuietly(strictlinereader);
        return;
        journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFile, true), Util.US_ASCII));
          goto _L3
    }

    private void readJournalLine(String s)
        throws IOException
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
        String s1;
        String s2;
        s2 = s.substring(j);
        s1 = s2;
        if (i != "REMOVE".length()) goto _L4; else goto _L3
_L3:
        s1 = s2;
        if (!s.startsWith("REMOVE")) goto _L4; else goto _L5
_L5:
        lruEntries.remove(s2);
_L7:
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
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void rebuildJournal()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (journalWriter != null)
        {
            journalWriter.close();
        }
        obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFileTmp), Util.US_ASCII));
        Iterator iterator;
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
_L1:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_244;
            }
            entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                break MISSING_BLOCK_LABEL_202;
            }
            ((Writer) (obj)).write((new StringBuilder()).append("DIRTY ").append(entry.key).append('\n').toString());
        } while (true);
        Exception exception;
        exception;
        ((Writer) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder()).append("CLEAN ").append(entry.key).append(entry.getLengths()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        if (journalFile.exists())
        {
            renameTo(journalFile, journalFileBackup, true);
        }
        renameTo(journalFileTmp, journalFile, false);
        journalFileBackup.delete();
        journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(journalFile, true), Util.US_ASCII));
        this;
        JVM INSTR monitorexit ;
    }

    private static void renameTo(File file, File file1, boolean flag)
        throws IOException
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

    private void trimToSize()
        throws IOException
    {
        while (size > maxSize) 
        {
            remove((String)((java.util.Map.Entry)lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = journalWriter;
        if (writer != null) goto _L2; else goto _L1
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
        journalWriter.close();
        journalWriter = null;
          goto _L1
    }

    public void delete()
        throws IOException
    {
        close();
        Util.deleteContents(directory);
    }

    public Editor edit(String s)
        throws IOException
    {
        return edit(s, -1L);
    }

    public Value get(String s)
        throws IOException
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
        entry = (Entry)lruEntries.get(s);
        if (entry != null) goto _L2; else goto _L1
_L1:
        Value value = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return value;
_L2:
        value = obj;
        File afile[];
        int j;
        if (!entry.readable)
        {
            continue; /* Loop/switch isn't completed */
        }
        afile = entry.cleanFiles;
        j = afile.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        value = obj;
        if (!afile[i].exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        redundantOpCount = redundantOpCount + 1;
        journalWriter.append("READ");
        journalWriter.append(' ');
        journalWriter.append(s);
        journalWriter.append('\n');
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        value = new Value(s, entry.sequenceNumber, entry.cleanFiles, entry.lengths);
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public boolean remove(String s)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        checkNotClosed();
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
        File file = entry.getCleanFile(i);
        if (file.exists() && !file.delete())
        {
            throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
        }
        break MISSING_BLOCK_LABEL_105;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        size = size - entry.lengths[i];
        entry.lengths[i] = 0L;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        redundantOpCount = redundantOpCount + 1;
        journalWriter.append("REMOVE");
        journalWriter.append(' ');
        journalWriter.append(s);
        journalWriter.append('\n');
        lruEntries.remove(s);
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }









/*
    static int access$402(DiskLruCache disklrucache, int i)
    {
        disklrucache.redundantOpCount = i;
        return i;
    }

*/
}
