// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session;

import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.idresolver.Id;
import com.amazon.insights.core.io.EncryptedBufferedReader;
import com.amazon.insights.core.io.EncryptedWriter;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.FileManager;
import com.amazon.insights.core.system.System;
import com.amazon.insights.delivery.EventStoreException;
import com.amazon.insights.delivery.FileEventStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.amazon.insights.session:
//            SessionStore, SessionStoreException, Session

public class FileSessionStore
    implements SessionStore
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/delivery/FileEventStore);
    private final InsightsContext context;
    private final ReentrantReadWriteLock lock;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock readSessionLock;
    private EncryptedBufferedReader reader;
    private SecretKey secretKey;
    private File sessionFile;
    private final java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeSessionLock;

    public FileSessionStore(InsightsContext insightscontext)
    {
        lock = new ReentrantReadWriteLock(true);
        readSessionLock = lock.readLock();
        writeSessionLock = lock.writeLock();
        reader = null;
        context = insightscontext;
        insightscontext = context.getSystem().getFileManager();
        Object obj = insightscontext.createDirectory("sessions");
        byte abyte0[];
        String s;
        byte abyte1[];
        try
        {
            sessionFile = insightscontext.createFile(new File(((File) (obj)), "sessionFile"));
        }
        // Misplaced declaration of an exception variable
        catch (InsightsContext insightscontext)
        {
            logger.deve("Unable to open session file");
            logger.e("An error occurred while attempting to create/open the session file", insightscontext);
        }
        abyte1 = new byte[32];
        obj = context.getCredentials().getPrivateKey();
        insightscontext = ((InsightsContext) (obj));
        if (context.getUniqueId() == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        insightscontext = ((InsightsContext) (obj));
        if (context.getUniqueId() == Id.getEmptyId())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        insightscontext = ((InsightsContext) (obj));
        if (context.getUniqueId().getValue() != null)
        {
            insightscontext = context.getUniqueId().getValue();
        }
        s = context.getCredentials().getPrivateKey();
        obj = s;
        if (s.length() > 16)
        {
            obj = s.substring(16);
        }
        obj = (new StringBuilder()).append(context.getConfiguration().optString("encryptionPrefix", ((String) (obj)))).append(insightscontext).toString();
        insightscontext = ((String) (obj)).getBytes("UTF-8");
        abyte0 = MessageDigest.getInstance("SHA-256").digest(((String) (obj)).getBytes("UTF-8"));
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

    private void tryCloseReader()
    {
        if (reader == null) goto _L2; else goto _L1
_L1:
        readSessionLock.lock();
        reader.close();
        reader = null;
_L4:
        readSessionLock.unlock();
_L2:
        return;
        Object obj;
        obj;
        logger.e("Unable to close reader for session file", ((Throwable) (obj)));
        reader = null;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        readSessionLock.unlock();
        throw obj;
        obj;
        reader = null;
        throw obj;
    }

    private void tryCloseWriter(Writer writer)
        throws SessionStoreException
    {
        if (writer == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        writer.close();
        return;
        writer;
        logger.e("Unable to close writer for session file", writer);
        return;
    }

    private Writer tryInitializeWriter()
        throws SessionStoreException
    {
        EncryptedWriter encryptedwriter;
        try
        {
            encryptedwriter = new EncryptedWriter(new OutputStreamWriter(context.getSystem().getFileManager().newOutputStream(sessionFile, false)), secretKey);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            logger.e("Session file not found to persist session to", filenotfoundexception);
            throw new EventStoreException("Unable to open session file writer", filenotfoundexception);
        }
        catch (Exception exception)
        {
            logger.e("Unexpected exception", exception);
            return null;
        }
        return encryptedwriter;
    }

    private boolean tryOpenReader()
    {
        InputStreamReader inputstreamreader;
        if (reader != null)
        {
            return true;
        }
        inputstreamreader = null;
        InputStreamReader inputstreamreader1 = new InputStreamReader(context.getSystem().getFileManager().newInputStream(sessionFile));
        inputstreamreader = inputstreamreader1;
_L1:
        FileNotFoundException filenotfoundexception;
        if (inputstreamreader != null)
        {
            reader = new EncryptedBufferedReader(new BufferedReader(inputstreamreader), secretKey);
            return true;
        } else
        {
            return false;
        }
        filenotfoundexception;
        logger.e("Could not open the session file", filenotfoundexception);
          goto _L1
    }

    public Session getSession()
    {
        Object obj;
        FileManager filemanager;
        filemanager = null;
        obj = null;
        readSessionLock.lock();
        tryOpenReader();
        if (reader != null)
        {
            obj = reader.readLine();
        }
        tryCloseReader();
        filemanager = context.getSystem().getFileManager();
        if (filemanager.deleteFile(sessionFile))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Object obj2 = obj;
        if (sessionFile.exists())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        sessionFile = filemanager.createFile(sessionFile);
        obj2 = obj;
_L2:
        readSessionLock.unlock();
        return Session.getSessionFromSerializedSession(((String) (obj2)));
        obj2;
        logger.e("Unable to clear session file", ((Throwable) (obj2)));
        obj2 = obj;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        readSessionLock.unlock();
        throw obj1;
        obj1;
        logger.e("Failed to read the session", ((Throwable) (obj1)));
        tryCloseReader();
        obj1 = context.getSystem().getFileManager();
        if (((FileManager) (obj1)).deleteFile(sessionFile))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        obj2 = filemanager;
        if (sessionFile.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        sessionFile = ((FileManager) (obj1)).createFile(sessionFile);
        obj2 = filemanager;
        continue; /* Loop/switch isn't completed */
        obj1;
        logger.e("Unable to clear session file", ((Throwable) (obj1)));
        obj2 = filemanager;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        tryCloseReader();
        obj2 = context.getSystem().getFileManager();
        if (((FileManager) (obj2)).deleteFile(sessionFile) || !sessionFile.exists())
        {
            sessionFile = ((FileManager) (obj2)).createFile(sessionFile);
        }
_L3:
        throw obj1;
        IOException ioexception;
        ioexception;
        logger.e("Unable to clear session file", ioexception);
          goto _L3
    }

    public void storeSession(Session session)
        throws SessionStoreException
    {
        Object obj;
        String s;
        s = session.toString();
        obj = null;
        session = null;
        writeSessionLock.lock();
        Writer writer = tryInitializeWriter();
        if (writer == null) goto _L2; else goto _L1
_L1:
        session = writer;
        obj = writer;
        long l = context.getConfiguration().optLong("maxStorageSize", Long.valueOf(22560L)).longValue();
        session = writer;
        obj = writer;
        if (sessionFile.length() + (long)s.length() > l) goto _L4; else goto _L3
_L3:
        session = writer;
        obj = writer;
        writer.write(s);
        session = writer;
        obj = writer;
        writer.flush();
_L2:
        tryCloseWriter(writer);
_L5:
        writeSessionLock.unlock();
        return;
_L4:
        session = writer;
        obj = writer;
        logger.e((new StringBuilder()).append("The session file exceeded its allowed size of ").append(l).append(" bytes").toString());
          goto _L2
        IOException ioexception;
        ioexception;
        obj = session;
        logger.e("Failed to persist the session", ioexception);
        tryCloseWriter(session);
          goto _L5
        session;
        writeSessionLock.unlock();
        throw session;
        session;
        tryCloseWriter(((Writer) (obj)));
        throw session;
          goto _L2
    }

}
