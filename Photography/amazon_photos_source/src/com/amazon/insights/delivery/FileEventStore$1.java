// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.io.DecryptionException;
import com.amazon.insights.core.io.EncryptedBufferedReader;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.FileManager;
import com.amazon.insights.core.system.System;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.insights.delivery:
//            FileEventStore

class isEndOfFile
    implements terator
{

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
        FileEventStore.access$200().e("Unable to close reader for events file", ((Throwable) (obj)));
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
        InputStreamReader inputstreamreader1 = new InputStreamReader(FileEventStore.access$100(FileEventStore.this).getSystem().getFileManager().newInputStream(FileEventStore.access$000(FileEventStore.this)));
        inputstreamreader = inputstreamreader1;
_L3:
        if (inputstreamreader != null)
        {
            reader = new EncryptedBufferedReader(new BufferedReader(inputstreamreader), FileEventStore.access$300(FileEventStore.this));
            return true;
        }
        break; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        FileEventStore.access$200().e("Could not open the events file", filenotfoundexception);
        if (true) goto _L3; else goto _L2
_L2:
        return false;
    }

    public boolean hasNext()
    {
        boolean flag1;
        flag1 = false;
        FileEventStore.access$400(FileEventStore.this).lock();
        String s = nextBuffer;
        if (s == null) goto _L2; else goto _L1
_L1:
        flag1 = true;
_L5:
        FileEventStore.access$400(FileEventStore.this).unlock();
        return flag1;
_L2:
        boolean flag2 = tryOpenReader();
        boolean flag;
        if (!flag2)
        {
            FileEventStore.access$400(FileEventStore.this).unlock();
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
        FileEventStore.access$400(FileEventStore.this).unlock();
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
        FileEventStore.access$400(FileEventStore.this).lock();
        if (nextBuffer == null) goto _L2; else goto _L1
_L1:
        obj = nextBuffer;
        linesRead = linesRead + 1;
        nextBuffer = null;
_L4:
        FileEventStore.access$400(FileEventStore.this).unlock();
        return ((String) (obj));
_L2:
        boolean flag1 = tryOpenReader();
        boolean flag;
        if (!flag1)
        {
            FileEventStore.access$400(FileEventStore.this).unlock();
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
        FileEventStore.access$400(FileEventStore.this).unlock();
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
        FileEventStore.access$400(FileEventStore.this).lock();
        String s;
        hasNext();
        s = nextBuffer;
        FileEventStore.access$400(FileEventStore.this).unlock();
        return s;
        Exception exception;
        exception;
        FileEventStore.access$400(FileEventStore.this).unlock();
        throw exception;
    }

    public void remove()
    {
        throw new UnsupportedOperationException("The remove() operation is not supported for this iterator");
    }

    public void removeReadEvents()
    {
        FileEventStore.access$400(FileEventStore.this).lock();
        FileEventStore.access$500(FileEventStore.this, linesRead);
        resetReader();
        FileEventStore.access$400(FileEventStore.this).unlock();
        return;
        Exception exception;
        exception;
        FileEventStore.access$400(FileEventStore.this).unlock();
        throw exception;
    }

    n()
    {
        this$0 = FileEventStore.this;
        super();
        linesRead = 0;
        nextBuffer = null;
        reader = null;
        isEndOfFile = false;
    }
}
