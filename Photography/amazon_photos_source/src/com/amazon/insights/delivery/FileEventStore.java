// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.io.DecryptionException;
import com.amazon.insights.core.io.EncryptedBufferedReader;
import com.amazon.insights.core.io.EncryptedWriter;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.FileManager;
import com.amazon.insights.core.system.System;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.amazon.insights.delivery:
//            EventStore, EventStoreException

public class FileEventStore
    implements EventStore
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/delivery/FileEventStore);
    private final ReentrantLock accessLock;
    private final InsightsContext context;
    private File eventsFile;
    private SecretKey secretKey;

    public FileEventStore(InsightsContext insightscontext)
    {
        byte abyte1[];
        accessLock = new ReentrantLock(true);
        context = insightscontext;
        tryCreateEventsFile();
        abyte1 = new byte[32];
        String s1 = insightscontext.getCredentials().getPrivateKey();
        String s = s1;
        if (insightscontext.getUniqueId() == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        s = s1;
        if (insightscontext.getUniqueId() == Id.getEmptyId())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        s = s1;
        if (insightscontext.getUniqueId().getValue() != null)
        {
            s = insightscontext.getUniqueId().getValue();
        }
        String s2 = insightscontext.getCredentials().getPrivateKey();
        s1 = s2;
        if (s2.length() > 16)
        {
            s1 = s2.substring(16);
        }
        s = (new StringBuilder()).append(insightscontext.getConfiguration().optString("encryptionPrefix", s1)).append(s).toString();
        insightscontext = s.getBytes("UTF-8");
        byte abyte0[] = MessageDigest.getInstance("SHA-256").digest(s.getBytes("UTF-8"));
        insightscontext = abyte0;
_L2:
        try
        {
            System.arraycopy(insightscontext, 0, abyte1, 0, 32);
            secretKey = new SecretKeySpec(abyte1, "AES");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InsightsContext insightscontext)
        {
            secretKey = null;
        }
        return;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private File deleteReadEvents(int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj6;
        Object obj7;
        Object obj8;
        File file1;
        FileManager filemanager;
        File file2;
        int j;
        boolean flag;
        boolean flag1;
        filemanager = context.getSystem().getFileManager();
        file1 = filemanager.createDirectory("events");
        long l = (long)((double)context.getConfiguration().optLong("maxStorageSize", Long.valueOf(0x500000L)).longValue() * 1.1000000000000001D);
        if (eventsFile.length() >= l)
        {
            if (!eventsFile.delete())
            {
                logger.e("Failed to delete events file that exceeds the max storage size");
            }
            try
            {
                eventsFile = filemanager.createFile(new File(file1, "eventsFile"));
            }
            catch (IOException ioexception)
            {
                logger.e("An error occurred while attempting to create the eventsFile", ioexception);
            }
            return eventsFile;
        }
        Object obj4;
        int k;
        try
        {
            File file = new File(file1, "eventsFile.tmp");
            if (file.exists() && !file.delete())
            {
                logger.e("Failed to delete previous temp file");
            }
            file2 = filemanager.createFile(file);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logger.e("An error occurred while attempting to create/open the temporary events file", ((Throwable) (obj)));
            return eventsFile;
        }
        flag1 = false;
        flag = false;
        if (file2 == null || !eventsFile.exists() || !file2.exists()) goto _L2; else goto _L1
_L1:
        obj8 = null;
        obj1 = null;
        obj7 = null;
        obj6 = null;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        j = ((flag) ? 1 : 0);
        obj = new BufferedReader(new FileReader(eventsFile));
        obj1 = new PrintWriter(new FileWriter(file2, true));
        j = 0;
_L6:
        obj2 = ((BufferedReader) (obj)).readLine();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        k = j + 1;
        j = k;
        if (k <= i) goto _L6; else goto _L5
_L5:
        ((PrintWriter) (obj1)).println(((String) (obj2)));
        ((PrintWriter) (obj1)).flush();
        j = k;
          goto _L6
        obj3;
        obj4 = obj1;
_L12:
        j = 1;
        obj1 = obj;
        obj2 = obj4;
        logger.e("The events file count not be found", ((Throwable) (obj3)));
        Object obj5;
        if (obj4 != null)
        {
            ((PrintWriter) (obj4)).close();
        }
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (false)
        {
            if (eventsFile.delete())
            {
                if (!file2.renameTo(eventsFile))
                {
                    logger.e("Failed to rename temp file to events file");
                }
                try
                {
                    eventsFile = filemanager.createFile(new File(file1, "eventsFile"));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    logger.e("An error occurred while attempting to create the eventsFile", ((Throwable) (obj)));
                }
            } else
            {
                logger.e("Failed to delete previous events file");
            }
        }
        obj = new File(file1, "eventsFile.tmp");
        if (((File) (obj)).exists() && !((File) (obj)).delete())
        {
            logger.e("Failed to delete temp file");
        }
_L2:
        return eventsFile;
_L4:
        if (obj1 != null)
        {
            ((PrintWriter) (obj1)).close();
        }
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (true)
        {
            if (eventsFile.delete())
            {
                if (!file2.renameTo(eventsFile))
                {
                    logger.e("Failed to rename temp file to events file");
                }
                try
                {
                    eventsFile = filemanager.createFile(new File(file1, "eventsFile"));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    logger.e("An error occurred while attempting to create the eventsFile", ((Throwable) (obj)));
                }
            } else
            {
                logger.e("Failed to delete previous events file");
            }
        }
        break MISSING_BLOCK_LABEL_412;
        obj3;
        obj5 = obj6;
        obj = obj8;
_L10:
        j = ((flag) ? 1 : 0);
        obj1 = obj;
        obj2 = obj5;
        logger.e("An error occurred while attempting to delete the read events", ((Throwable) (obj3)));
        if (obj5 != null)
        {
            ((PrintWriter) (obj5)).close();
        }
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (false)
        {
            if (eventsFile.delete())
            {
                if (!file2.renameTo(eventsFile))
                {
                    logger.e("Failed to rename temp file to events file");
                }
                try
                {
                    eventsFile = filemanager.createFile(new File(file1, "eventsFile"));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    logger.e("An error occurred while attempting to create the eventsFile", ((Throwable) (obj)));
                }
            } else
            {
                logger.e("Failed to delete previous events file");
            }
        }
        break MISSING_BLOCK_LABEL_412;
        obj;
_L8:
        if (obj2 != null)
        {
            ((PrintWriter) (obj2)).close();
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (j == 0)
        {
            if (eventsFile.delete())
            {
                if (!file2.renameTo(eventsFile))
                {
                    logger.e("Failed to rename temp file to events file");
                }
                try
                {
                    eventsFile = filemanager.createFile(new File(file1, "eventsFile"));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    logger.e("An error occurred while attempting to create the eventsFile", ((Throwable) (obj1)));
                }
            } else
            {
                logger.e("Failed to delete previous events file");
            }
        }
        throw obj;
        obj5;
        j = ((flag1) ? 1 : 0);
        obj1 = obj;
        obj2 = obj3;
        obj = obj5;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj2 = obj1;
        j = ((flag1) ? 1 : 0);
        obj1 = obj;
        obj = obj3;
        if (true) goto _L8; else goto _L7
_L7:
        obj3;
        obj5 = obj6;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj5 = obj1;
        if (true) goto _L10; else goto _L9
_L9:
        obj3;
        obj = obj7;
        continue; /* Loop/switch isn't completed */
        obj3;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static FileEventStore newInstance(InsightsContext insightscontext)
    {
        return new FileEventStore(insightscontext);
    }

    private void tryCloseWriter(Writer writer)
        throws EventStoreException
    {
        if (writer == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        writer.close();
        return;
        writer;
        logger.e("Unable to close writer for events file", writer);
        return;
    }

    private boolean tryCreateEventsFile()
    {
        if (eventsFile != null && eventsFile.exists())
        {
            return true;
        }
        this;
        JVM INSTR monitorenter ;
        if (eventsFile == null || !eventsFile.exists())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        FileManager filemanager = context.getSystem().getFileManager();
        eventsFile = filemanager.createFile(new File(filemanager.createDirectory("events"), "eventsFile"));
        this;
        JVM INSTR monitorexit ;
        return true;
        filemanager;
        logger.deve("Unable to open events file");
        logger.e("An error occurred while attempting to create/open the events file", filemanager);
        this;
        JVM INSTR monitorexit ;
        return false;
    }

    private Writer tryInitializeWriter()
        throws EventStoreException
    {
        try
        {
            if (tryCreateEventsFile())
            {
                return new EncryptedWriter(new OutputStreamWriter(context.getSystem().getFileManager().newOutputStream(eventsFile, true)), secretKey);
            } else
            {
                throw new EventStoreException("Unable to create eventsFile");
            }
        }
        catch (EventStoreException eventstoreexception)
        {
            throw eventstoreexception;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            logger.e("Events file not found to persist event to", filenotfoundexception);
            throw new EventStoreException("Unable to open events file writer", filenotfoundexception);
        }
        catch (Exception exception)
        {
            logger.e("Unexpected exception", exception);
            throw new EventStoreException("Unexpected error while creating eventsFile writer", exception);
        }
    }

    public EventStore.EventIterator iterator()
    {
        return new EventStore.EventIterator() {

            boolean isEndOfFile;
            int linesRead;
            String nextBuffer;
            EncryptedBufferedReader reader;
            final FileEventStore this$0;

            private void resetReader()
            {
                tryCloseReader();
                linesRead = 0;
                nextBuffer = null;
            }

            private void tryCloseReader()
            {
                if (reader == null)
                {
                    break MISSING_BLOCK_LABEL_19;
                }
                reader.close();
                reader = null;
                return;
                Object obj;
                obj;
                FileEventStore.logger.e("Unable to close reader for events file", ((Throwable) (obj)));
                reader = null;
                return;
                obj;
                reader = null;
                throw obj;
            }

            private boolean tryOpenReader()
            {
                if (reader != null)
                {
                    return true;
                }
                if (isEndOfFile) goto _L2; else goto _L1
_L1:
                InputStreamReader inputstreamreader = null;
                InputStreamReader inputstreamreader1 = new InputStreamReader(context.getSystem().getFileManager().newInputStream(eventsFile));
                inputstreamreader = inputstreamreader1;
_L3:
                if (inputstreamreader != null)
                {
                    reader = new EncryptedBufferedReader(new BufferedReader(inputstreamreader), secretKey);
                    return true;
                }
                break; /* Loop/switch isn't completed */
                FileNotFoundException filenotfoundexception;
                filenotfoundexception;
                FileEventStore.logger.e("Could not open the events file", filenotfoundexception);
                if (true) goto _L3; else goto _L2
_L2:
                return false;
            }

            public boolean hasNext()
            {
                boolean flag1;
                flag1 = false;
                accessLock.lock();
                String s = nextBuffer;
                if (s == null) goto _L2; else goto _L1
_L1:
                flag1 = true;
_L5:
                accessLock.unlock();
                return flag1;
_L2:
                boolean flag2 = tryOpenReader();
                boolean flag;
                if (!flag2)
                {
                    accessLock.unlock();
                    return false;
                }
                flag = false;
_L4:
                if (flag)
                {
                    break; /* Loop/switch isn't completed */
                }
                nextBuffer = reader.readLine();
                flag = true;
                continue; /* Loop/switch isn't completed */
                Object obj;
                obj;
                linesRead = linesRead + 1;
                flag = false;
                continue; /* Loop/switch isn't completed */
                obj;
                nextBuffer = null;
                flag = true;
                if (true) goto _L4; else goto _L3
_L3:
                if (nextBuffer == null)
                {
                    break MISSING_BLOCK_LABEL_119;
                }
                flag1 = true;
                  goto _L5
                isEndOfFile = true;
                tryCloseReader();
                  goto _L5
                obj;
                accessLock.unlock();
                throw obj;
            }

            public volatile Object next()
            {
                return next();
            }

            public String next()
            {
                Object obj;
                obj = null;
                accessLock.lock();
                if (nextBuffer == null) goto _L2; else goto _L1
_L1:
                obj = nextBuffer;
                linesRead = linesRead + 1;
                nextBuffer = null;
_L4:
                accessLock.unlock();
                return ((String) (obj));
_L2:
                boolean flag1 = tryOpenReader();
                boolean flag;
                if (!flag1)
                {
                    accessLock.unlock();
                    return null;
                }
                flag = false;
_L3:
                if (flag)
                {
                    break MISSING_BLOCK_LABEL_111;
                }
                String s = reader.readLine();
                obj = s;
                flag = true;
                  goto _L3
                DecryptionException decryptionexception;
                decryptionexception;
                linesRead = linesRead + 1;
                flag = false;
                  goto _L3
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_141;
                }
                linesRead = linesRead + 1;
                  goto _L4
                Object obj1;
                obj1;
                accessLock.unlock();
                throw obj1;
                isEndOfFile = true;
                tryCloseReader();
                  goto _L4
                obj1;
                obj1 = null;
                flag = true;
                  goto _L3
            }

            public String peek()
            {
                accessLock.lock();
                String s;
                hasNext();
                s = nextBuffer;
                accessLock.unlock();
                return s;
                Exception exception;
                exception;
                accessLock.unlock();
                throw exception;
            }

            public void remove()
            {
                throw new UnsupportedOperationException("The remove() operation is not supported for this iterator");
            }

            public void removeReadEvents()
            {
                accessLock.lock();
                deleteReadEvents(linesRead);
                resetReader();
                accessLock.unlock();
                return;
                Exception exception;
                exception;
                accessLock.unlock();
                throw exception;
            }

            
            {
                this$0 = FileEventStore.this;
                super();
                linesRead = 0;
                nextBuffer = null;
                reader = null;
                isEndOfFile = false;
            }
        };
    }

    public boolean put(String s)
        throws EventStoreException
    {
        Writer writer;
        Writer writer1;
        boolean flag1;
        flag1 = false;
        writer1 = null;
        writer = null;
        accessLock.lock();
        Writer writer2 = tryInitializeWriter();
        boolean flag = flag1;
        if (writer2 == null) goto _L2; else goto _L1
_L1:
        writer = writer2;
        writer1 = writer2;
        long l = context.getConfiguration().optLong("maxStorageSize", Long.valueOf(0x500000L)).longValue();
        writer = writer2;
        writer1 = writer2;
        if (eventsFile.length() + (long)s.length() > l) goto _L4; else goto _L3
_L3:
        writer = writer2;
        writer1 = writer2;
        writer2.write(s);
        writer = writer2;
        writer1 = writer2;
        writer2.flush();
        flag = true;
_L2:
        accessLock.unlock();
        tryCloseWriter(writer2);
        return flag;
_L4:
        writer = writer2;
        writer1 = writer2;
        logger.e((new StringBuilder()).append("The events file exceeded its allowed size of ").append(l).append(" bytes").toString());
        flag = flag1;
          goto _L2
        s;
        writer1 = writer;
        logger.e("Failed to persist the event", s);
        accessLock.unlock();
        tryCloseWriter(writer);
        return false;
        s;
        accessLock.unlock();
        tryCloseWriter(writer1);
        throw s;
    }







}
