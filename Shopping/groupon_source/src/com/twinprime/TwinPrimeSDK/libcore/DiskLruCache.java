// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
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
import java.io.Writer;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            RawHeaders, CacheUtils

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
            FaultHidingOutputStream faulthidingoutputstream = new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(i)));
            disklrucache;
            JVM INSTR monitorexit ;
            return faulthidingoutputstream;
        }



/*
        static boolean access$1902(Editor editor, boolean flag)
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

    }

    public static final class Entry
    {

        String cipherSuite;
        Editor currentEditor;
        private String key;
        private long lengths[];
        Certificate localCertificates[];
        Certificate peerCertificates[];
        private boolean readable;
        private String requestMethod;
        RawHeaders responseHeaders;
        private long sequenceNumber;
        private String uri;
        private RawHeaders varyHeaders;

        private IOException invalidLengths(String as[])
            throws IOException
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
        }

        private void setLengths(String as[])
            throws IOException
        {
            if (as.length != DiskLruCache.valueCount)
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
            return new File(DiskLruCache.directory, (new StringBuilder()).append(key).append(".").append(i).toString());
        }

        public File getDirtyFile(int i)
        {
            return new File(DiskLruCache.directory, (new StringBuilder()).append(key).append(".").append(i).append(".tmp").toString());
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

        public void writeTo(Editor editor, URI uri1, HttpURLConnection httpurlconnection)
            throws IOException
        {
            BufferedWriter bufferedwriter;
            bufferedwriter = new BufferedWriter(new OutputStreamWriter(editor.newOutputStream(0), Charset.forName("UTF-8")));
            bufferedwriter.write((new StringBuilder()).append(uri1.toString()).append('\n').toString());
            bufferedwriter.write((new StringBuilder()).append(httpurlconnection.getRequestMethod()).append('\n').toString());
            Object obj = httpurlconnection.getHeaderFields();
            HashMap hashmap = new HashMap();
            editor = new HashMap();
            Iterator iterator = ((Map) (obj)).keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if ("Vary".equalsIgnoreCase(s))
                {
                    hashmap.put(s, ((Map) (obj)).get(s));
                } else
                if ((s == null || !s.startsWith("X-TwinPrime")) && !"Keep-Alive".equalsIgnoreCase(s))
                {
                    editor.put(s, ((Map) (obj)).get(s));
                }
            } while (true);
            obj = RawHeaders.fromMultimap(hashmap, true);
            bufferedwriter.write((new StringBuilder()).append(Integer.toString(((RawHeaders) (obj)).length())).append('\n').toString());
            for (int i = 0; i < ((RawHeaders) (obj)).length(); i++)
            {
                bufferedwriter.write((new StringBuilder()).append(((RawHeaders) (obj)).getFieldName(i)).append(": ").append(((RawHeaders) (obj)).getValue(i)).append('\n').toString());
            }

            editor = RawHeaders.fromMultimap(editor, true);
            bufferedwriter.write((new StringBuilder()).append(editor.getStatusLine()).append('\n').toString());
            bufferedwriter.write((new StringBuilder()).append(Integer.toString(editor.length() + 1)).append('\n').toString());
            bufferedwriter.write("X-Android-Response-Source: CACHE 200\n");
            for (int j = 0; j < editor.length(); j++)
            {
                bufferedwriter.write((new StringBuilder()).append(editor.getFieldName(j)).append(": ").append(editor.getValue(j)).append('\n').toString());
            }

            if (!uri1.toString().startsWith("https")) goto _L2; else goto _L1
_L1:
            HttpsURLConnection httpsurlconnection;
            httpsurlconnection = (HttpsURLConnection)httpurlconnection;
            httpurlconnection = httpsurlconnection.getCipherSuite();
            editor = null;
            uri1 = httpsurlconnection.getServerCertificates();
            editor = uri1;
_L4:
            uri1 = httpsurlconnection.getLocalCertificates();
            bufferedwriter.write(10);
            bufferedwriter.write((new StringBuilder()).append(httpurlconnection).append('\n').toString());
            CacheUtils.writeCertArray(bufferedwriter, editor);
            CacheUtils.writeCertArray(bufferedwriter, uri1);
_L2:
            bufferedwriter.close();
            return;
            uri1;
            if (true) goto _L4; else goto _L3
_L3:
        }



/*
        static long access$1002(Entry entry, long l)
        {
            entry.sequenceNumber = l;
            return l;
        }

*/



/*
        static boolean access$502(Entry entry, boolean flag)
        {
            entry.readable = flag;
            return flag;
        }

*/




        public Entry(InputStream inputstream)
        {
            int j;
            inputstream = new BufferedReader(new InputStreamReader(inputstream));
            uri = inputstream.readLine();
            requestMethod = inputstream.readLine();
            varyHeaders = new RawHeaders();
            j = Integer.parseInt(inputstream.readLine());
            int i = 0;
_L2:
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            varyHeaders.addLine(inputstream.readLine());
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            int k;
            responseHeaders = new RawHeaders();
            responseHeaders.setStatusLine(inputstream.readLine());
            k = Integer.parseInt(inputstream.readLine());
            boolean flag;
            flag = false;
            i = 0;
_L4:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj = inputstream.readLine();
            if (((String) (obj)).startsWith("X-Android-Response-Source"))
            {
                flag = true;
            }
            responseHeaders.addLine(((String) (obj)));
            i++;
            if (true) goto _L4; else goto _L3
_L3:
            if (flag)
            {
                break MISSING_BLOCK_LABEL_178;
            }
            responseHeaders.addLine("X-Android-Response-Source: CACHE 200\n");
            if (!uri.startsWith("https"))
            {
                break MISSING_BLOCK_LABEL_290;
            }
            obj = inputstream.readLine();
            if (((String) (obj)).length() > 0)
            {
                throw new IOException((new StringBuilder()).append("expected \"\" but was \"").append(((String) (obj))).append("\"").toString());
            }
              goto _L5
            inputstream;
            inputstream.printStackTrace();
_L7:
            return;
_L5:
            cipherSuite = inputstream.readLine();
            peerCertificates = CacheUtils.readCertArray(inputstream);
            localCertificates = CacheUtils.readCertArray(inputstream);
_L9:
            obj = new StringBuilder();
_L8:
            String s = inputstream.readLine();
            if (s == null) goto _L7; else goto _L6
_L6:
            ((StringBuilder) (obj)).append(s);
              goto _L8
            cipherSuite = null;
            peerCertificates = null;
            localCertificates = null;
              goto _L9
        }

        public Entry(String s)
        {
            key = s;
            lengths = new long[DiskLruCache.valueCount];
        }
    }

    public final class Snapshot
        implements Closeable
    {

        private final InputStream ins[];
        private final String key;
        private final long sequenceNumber;
        final DiskLruCache this$0;

        public void close()
        {
            InputStream ainputstream[] = ins;
            int j = ainputstream.length;
            for (int i = 0; i < j; i++)
            {
                DiskLruCache.closeQuietly(ainputstream[i]);
            }

        }

        public InputStream getInputStream(int i)
        {
            return ins[i];
        }

        private Snapshot(String s, long l, InputStream ainputstream[])
        {
            this$0 = DiskLruCache.this;
            super();
            key = s;
            sequenceNumber = l;
            ins = ainputstream;
        }

        Snapshot(String s, long l, InputStream ainputstream[], _cls1 _pcls1)
        {
            this(s, l, ainputstream);
        }
    }


    private static final Charset UTF_8 = Charset.forName("UTF-8");
    static File directory;
    static int valueCount;
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
    private final ExecutorService executorService;
    private final File journalFile;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75F, true);
    private final long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;

    private DiskLruCache(File file, int i, int j, long l)
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

    private static void closeQuietly(Closeable closeable)
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
        Entry entry = editor.entry;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        if (entry.currentEditor != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_32;
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
            break MISSING_BLOCK_LABEL_181;
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
        break MISSING_BLOCK_LABEL_392;
        deleteIfExists(editor);
        break MISSING_BLOCK_LABEL_392;
_L7:
        redundantOpCount = redundantOpCount + 1;
        entry.currentEditor = null;
        if (!(entry.readable | flag))
        {
            break MISSING_BLOCK_LABEL_327;
        }
        entry.readable = true;
        journalWriter.write((new StringBuilder()).append("CLEAN ").append(entry.key).append(entry.getLengths()).append('\n').toString());
        journalWriter.flush();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        long l1 = nextSequenceNumber;
        nextSequenceNumber = 1L + l1;
        entry.sequenceNumber = l1;
_L8:
        if (size > maxSize || journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        lruEntries.remove(entry.key);
        journalWriter.write((new StringBuilder()).append("REMOVE ").append(entry.key).append('\n').toString());
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
            Object aobj1[] = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
            System.arraycopy(((Object) (aobj)), i, ((Object) (aobj1)), 0, k);
            return aobj1;
        }
    }

    private static void deleteContents(File file)
        throws IOException
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("not a directory: ").append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                deleteContents(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file).toString());
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
        obj = new Entry(s);
        lruEntries.put(s, obj);
_L9:
        editor = new Editor(((Entry) (obj)));
        obj.currentEditor = editor;
        journalWriter.write((new StringBuilder()).append("DIRTY ").append(s).append('\n').toString());
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
            break MISSING_BLOCK_LABEL_104;
        }
        disklrucache.readJournal();
        disklrucache.processJournal();
        disklrucache.journalWriter = new BufferedWriter(new FileWriter(disklrucache.journalFile, true), 8192);
        return disklrucache;
        IOException ioexception;
        ioexception;
        disklrucache.delete();
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

    private static String readAsciiLine(InputStream inputstream)
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
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s).append(", ").append(s1).append(", ").append(s3).append(", ").append(s4).append("]").toString());
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
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
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
                entry = new Entry(s1);
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
                entry.currentEditor = new Editor(entry);
                return;
            }
            if (!as[0].equals("READ") || as.length != 2)
            {
                throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s).toString());
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
_L1:
        Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_228;
            }
            entry = (Entry)iterator.next();
            if (entry.currentEditor == null)
            {
                break MISSING_BLOCK_LABEL_187;
            }
            ((Writer) (obj)).write((new StringBuilder()).append("DIRTY ").append(entry.key).append('\n').toString());
        } while (true);
        obj;
        throw obj;
        ((Writer) (obj)).write((new StringBuilder()).append("CLEAN ").append(entry.key).append(entry.getLengths()).append('\n').toString());
          goto _L1
        ((Writer) (obj)).close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true), 8192);
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

    void delete()
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
_L4:
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
        do
        {
            try
            {
                if (i >= valueCount)
                {
                    break;
                }
                obj[i] = new FileInputStream(entry.getCleanFile(i));
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
        redundantOpCount = redundantOpCount + 1;
        journalWriter.append("READ");
        journalWriter.append(' ');
        journalWriter.append(s);
        journalWriter.append('\n');
        if (journalRebuildRequired())
        {
            executorService.submit(cleanupCallable);
        }
        obj = new Snapshot(s, entry.sequenceNumber, ((InputStream []) (obj)));
        if (true) goto _L4; else goto _L3
_L3:
        throw s;
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
        File file = entry.getCleanFile(i);
        if (!file.delete())
        {
            throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
        }
        break MISSING_BLOCK_LABEL_102;
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
