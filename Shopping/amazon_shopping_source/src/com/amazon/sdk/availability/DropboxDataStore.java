// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import android.os.DropBoxManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            DataStore, StringUtil, DataStoreException, DataStoreIterator, 
//            EncryptionManager

public class DropboxDataStore
    implements DataStore
{
    static class Iterator
        implements DataStoreIterator
    {

        private boolean calledHasNext;
        private android.os.DropBoxManager.Entry currentEntry;
        private final DropBoxManager dropBoxManager;
        private android.os.DropBoxManager.Entry lastEntry;
        private final String tag;
        private final long timeStamp;

        protected static String transform(android.os.DropBoxManager.Entry entry)
        {
            Object obj;
            StringBuilder stringbuilder;
            obj = null;
            stringbuilder = null;
            Object obj1 = new BufferedReader(new InputStreamReader(entry.getInputStream()));
            stringbuilder = new StringBuilder();
            for (obj = ((BufferedReader) (obj1)).readLine(); !StringUtil.isEmpty(((String) (obj))); obj = ((BufferedReader) (obj1)).readLine())
            {
                stringbuilder.append(((String) (obj)));
            }

            obj = stringbuilder.toString();
            if (obj1 != null)
            {
                try
                {
                    ((BufferedReader) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (android.os.DropBoxManager.Entry entry)
                {
                    throw new DataStoreException(entry);
                }
            }
            entry.close();
            return ((String) (obj));
            obj1;
            obj = stringbuilder;
_L4:
            throw new DataStoreException(((Throwable) (obj1)));
            obj1;
_L2:
            if (obj != null)
            {
                try
                {
                    ((BufferedReader) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (android.os.DropBoxManager.Entry entry)
                {
                    throw new DataStoreException(entry);
                }
            }
            entry.close();
            throw obj1;
            Object obj2;
            obj2;
            obj = obj1;
            obj1 = obj2;
            if (true) goto _L2; else goto _L1
_L1:
            obj2;
            obj = obj1;
            obj1 = obj2;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void clear()
        {
        }

        public void closeAfterUse()
        {
            if (currentEntry != null)
            {
                currentEntry.close();
            }
        }

        public boolean hasNext()
        {
            if (currentEntry != null)
            {
                lastEntry = currentEntry;
            }
            long l;
            if (lastEntry != null)
            {
                l = lastEntry.getTimeMillis();
            } else
            {
                l = 0L;
            }
            currentEntry = dropBoxManager.getNextEntry(tag, Math.max(timeStamp, l));
            calledHasNext = true;
            return currentEntry != null;
        }

        public Object next()
        {
            if (!calledHasNext)
            {
                hasNext();
            }
            calledHasNext = false;
            if (currentEntry == null)
            {
                throw new NoSuchElementException();
            } else
            {
                return transform(currentEntry);
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        Iterator(String s, DropBoxManager dropboxmanager, long l)
        {
            tag = s;
            dropBoxManager = dropboxmanager;
            timeStamp = l;
            lastEntry = null;
            currentEntry = null;
            calledHasNext = false;
        }
    }


    private final String clientId;
    private DropBoxManager dropboxManager;
    private boolean isOpen;
    private String tag;

    public DropboxDataStore(String s)
    {
        if (StringUtil.isEmpty(s))
        {
            throw new DataStoreException("'clientId' cannot be null/empty");
        } else
        {
            clientId = s;
            return;
        }
    }

    public void close()
    {
        dropboxManager = null;
    }

    public DataStoreIterator getMeasurementsAfter(long l)
    {
        return new Iterator(tag, dropboxManager, l);
    }

    public String getTag()
    {
        return String.format("com.amazon.sdk.availability.(%s)", new Object[] {
            clientId
        });
    }

    public void open(Context context, EncryptionManager encryptionmanager)
    {
        if (context == null)
        {
            throw new DataStoreException("'context' is null");
        } else
        {
            isOpen = true;
            tag = getTag();
            dropboxManager = (DropBoxManager)context.getSystemService("dropbox");
            return;
        }
    }

    public boolean put(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            throw new DataStoreException("'json' cannot be null");
        }
        if (!isOpen)
        {
            throw new DataStoreException("must call open() before calling put()");
        }
        try
        {
            dropboxManager.addText(tag, jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new DataStoreException(jsonobject);
        }
        return true;
    }
}
