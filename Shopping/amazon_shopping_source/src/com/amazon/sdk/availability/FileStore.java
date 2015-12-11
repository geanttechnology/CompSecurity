// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import android.util.Base64;
import com.amazon.profiling.Profiler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            DataStore, StringUtil, DataStoreException, Preferences, 
//            EncryptionKeyState, Logger, KeySpec, EncryptionManager, 
//            DataStoreIterator, EncryptionFactory

public class FileStore
    implements DataStore
{
    static class Iterator
        implements DataStoreIterator
    {

        private boolean calledHasNext;
        private File currentFile;
        private int currentIndex;
        private String currentLineContents;
        private final EncryptionKeyState encryptionKeyState;
        private final List filesMarkedForDeletion = new ArrayList();
        private final FilenameFilter filter;
        private final File measurementFiles[];
        private BufferedReader reader;

        private boolean filesAreLeft()
        {
            while (measurementFiles == null || measurementFiles.length == 0 || currentIndex >= measurementFiles.length) 
            {
                return false;
            }
            return true;
        }

        private BufferedReader getReader(File file1)
        {
            if (file1 == null)
            {
                return null;
            }
            try
            {
                file1 = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile)));
            }
            // Misplaced declaration of an exception variable
            catch (File file1)
            {
                throw new DataStoreException(file1);
            }
            return file1;
        }

        public void clear()
        {
            if (filesMarkedForDeletion.size() > 0)
            {
                java.util.Iterator iterator = filesMarkedForDeletion.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    File file1 = (File)iterator.next();
                    if (!file1.delete())
                    {
                        Logger.w((new StringBuilder()).append("Could not delete file ").append(file1.getName()).toString());
                    }
                } while (true);
            }
        }

        public void closeAfterUse()
        {
            safelyClose(reader);
        }

        protected void ensureReaderIsInitialized()
        {
            if (reader == null)
            {
                if (currentFile == null)
                {
                    currentFile = getNextFile();
                }
                reader = getReader(currentFile);
            }
        }

        protected File getNextFile()
        {
            if (measurementFiles != null && measurementFiles.length > 0)
            {
                currentIndex = currentIndex + 1;
                if (currentIndex < measurementFiles.length)
                {
                    return measurementFiles[currentIndex];
                }
            }
            return null;
        }

        public boolean hasNext()
        {
            calledHasNext = true;
            ensureReaderIsInitialized();
            while (filesAreLeft()) 
            {
                if (readNextLine(reader))
                {
                    return true;
                }
                filesMarkedForDeletion.add(currentFile);
                safelyClose(reader);
                currentFile = getNextFile();
                reader = getReader(currentFile);
            }
            return false;
        }

        public Object next()
        {
            if (!calledHasNext)
            {
                hasNext();
            }
            calledHasNext = false;
            if (StringUtil.isEmpty(currentLineContents))
            {
                break MISSING_BLOCK_LABEL_116;
            }
            Object obj;
            String s;
            KeySpec keyspec;
            try
            {
                JSONObject jsonobject = new JSONObject(currentLineContents);
                long l = jsonobject.optLong("timestamp");
                s = jsonobject.optString("content");
                keyspec = encryptionKeyState.getApplicableKeySpec(l);
            }
            catch (JSONException jsonexception)
            {
                throw new DataStoreException(jsonexception);
            }
            obj = null;
            if (keyspec == null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            obj = EncryptionFactory.getEncryptionManager(keyspec.getEncryptionAlgorithm(), keyspec.getKey());
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            return ((EncryptionManager) (obj)).decrypt(Base64.decode(s, 11));
            obj = currentLineContents;
            return obj;
            throw new NoSuchElementException();
        }

        protected boolean readNextLine(BufferedReader bufferedreader)
        {
            if (bufferedreader != null)
            {
                boolean flag;
                try
                {
                    currentLineContents = bufferedreader.readLine();
                    flag = StringUtil.isEmpty(currentLineContents);
                }
                // Misplaced declaration of an exception variable
                catch (BufferedReader bufferedreader)
                {
                    throw new DataStoreException(bufferedreader);
                }
                if (!flag)
                {
                    return true;
                }
            }
            return false;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        void safelyClose(Closeable closeable)
        {
            if (closeable == null)
            {
                break MISSING_BLOCK_LABEL_10;
            }
            closeable.close();
            return;
            closeable;
            throw new DataStoreException(closeable);
        }

        public Iterator(File file1, long l, EncryptionKeyState encryptionkeystate)
        {
            filter = new MeasureMentFilter(l);
            measurementFiles = file1.listFiles(filter);
            encryptionKeyState = encryptionkeystate;
            currentIndex = -1;
            calledHasNext = false;
        }
    }

    static class MeasureMentFilter
        implements FilenameFilter
    {

        private final long timeStamp;

        public boolean accept(File file1, String s)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (s != null)
            {
                flag = flag1;
                if (FileStore.PATTERN.matcher(s).matches())
                {
                    flag = flag1;
                    if ((new File(file1, s)).lastModified() >= timeStamp)
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public MeasureMentFilter(long l)
        {
            timeStamp = l;
        }
    }


    private static final Pattern PATTERN = Pattern.compile("availability_measurements_(.*)\\.measure");
    private final String clientId;
    private Context context;
    private EncryptionKeyState encryptionKeyState;
    private EncryptionManager encryptionManager;
    private File file;
    private boolean isOpen;
    private final Long localStorageMaxRollOver;
    private final Long localStorageMaxRollOverSize;
    private OutputStream out;
    private Preferences preferences;

    public FileStore(String s, Long long1, Long long2)
    {
        if (StringUtil.isEmpty(s))
        {
            throw new DataStoreException("'clientId' cannot be null/empty");
        } else
        {
            clientId = s;
            localStorageMaxRollOver = long1;
            localStorageMaxRollOverSize = long2;
            return;
        }
    }

    private void initFileStore()
    {
        try
        {
            file = lastFile();
            out = new BufferedOutputStream(new FileOutputStream(file, true), 32768);
            return;
        }
        catch (Exception exception)
        {
            if (exception instanceof DataStoreException)
            {
                throw (DataStoreException)exception;
            } else
            {
                throw new DataStoreException(exception);
            }
        }
    }

    public void close()
    {
        closeCurrentStream();
        if (file != null)
        {
            preferences.put("last-file-used", file.getName());
        }
        if (encryptionKeyState != null)
        {
            preferences.put(String.format("%s-encryption-key-state", new Object[] {
                clientId
            }), encryptionKeyState.toJSON().toString());
        }
        context = null;
    }

    protected void closeCurrentStream()
    {
        if (out != null)
        {
            try
            {
                out.flush();
                out.close();
            }
            catch (Exception exception)
            {
                Logger.w("error closing output stream", exception);
            }
        }
        out = null;
    }

    public File getDataDirectory()
    {
        return context.getDir(clientId, 0);
    }

    protected String getLastUsedFile()
    {
        return preferences.get("last-file-used", String.format("availability_measurements_%s.measure", new Object[] {
            Long.valueOf(System.currentTimeMillis())
        }));
    }

    public DataStoreIterator getMeasurementsAfter(long l)
    {
        encryptionKeyState.clearKeySpecsBefore(l);
        return new Iterator(getDataDirectory(), l, encryptionKeyState);
    }

    protected int getRollOverCount()
    {
        File afile[] = getDataDirectory().listFiles(new MeasureMentFilter(0L));
        if (afile == null)
        {
            return 0;
        } else
        {
            return afile.length;
        }
    }

    protected File lastFile()
    {
        return new File(getDataDirectory(), getLastUsedFile());
    }

    public void open(Context context1, EncryptionManager encryptionmanager)
    {
        com.amazon.profiling.ProfilerScope profilerscope;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/FileStore, "open");
        if (context1 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        throw new DataStoreException("'context' is null");
        context1;
        Profiler.scopeEnd(profilerscope);
        throw context1;
        boolean flag1;
        isOpen = true;
        context = context1;
        preferences = new Preferences(context);
        context1 = preferences.get(String.format("%s-encryption-key-state", new Object[] {
            clientId
        }), null);
        flag1 = StringUtil.isEmpty(context1);
        if (flag1) goto _L2; else goto _L1
_L1:
        encryptionKeyState = EncryptionKeyState.fromJSON(new JSONObject(context1));
_L4:
        if (encryptionmanager == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        Object obj;
        context1 = new KeySpec(encryptionmanager.getKey(), encryptionmanager.getEncryptionAlgorithm(), 0L);
        obj = encryptionKeyState.getState();
        boolean flag = false;
        for (obj = ((List) (obj)).iterator(); ((java.util.Iterator) (obj)).hasNext();)
        {
            if (((KeySpec)((java.util.Iterator) (obj)).next()).equals(context1))
            {
                flag = true;
            }
        }

        break; /* Loop/switch isn't completed */
        context1;
        encryptionKeyState = new EncryptionKeyState();
        continue; /* Loop/switch isn't completed */
_L2:
        encryptionKeyState = new EncryptionKeyState();
        if (true) goto _L4; else goto _L3
_L3:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        encryptionKeyState.addKeySpec(context1);
        encryptionManager = encryptionmanager;
        initFileStore();
        Profiler.scopeEnd(profilerscope);
        return;
    }

    public boolean put(JSONObject jsonobject)
    {
        com.amazon.profiling.ProfilerScope profilerscope;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/FileStore, "put");
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        throw new DataStoreException("'json' cannot be null");
        jsonobject;
        Profiler.scopeEnd(profilerscope);
        throw jsonobject;
        Long long1;
        if (!isOpen)
        {
            throw new DataStoreException("must call open() before calling put()");
        }
        if (localStorageMaxRollOver == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        long1 = localStorageMaxRollOverSize;
        if (long1 != null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        Profiler.scopeEnd(profilerscope);
        return false;
        boolean flag = false;
        if (file == null || !file.exists())
        {
            initFileStore();
        }
        if ((long)(getRollOverCount() + 1) > localStorageMaxRollOver.longValue() + 1L)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (encryptionManager != null) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.toString();
_L3:
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("timestamp", System.currentTimeMillis());
        jsonobject1.put("content", jsonobject);
        out.write((new StringBuilder()).append(jsonobject1.toString()).append("\r\n").toString().getBytes("UTF-8"));
        rollOverIfNeeded();
        flag = true;
_L4:
        Profiler.scopeEnd(profilerscope);
        return flag;
_L2:
        com.amazon.profiling.ProfilerScope profilerscope1 = Profiler.methodScopeStart(com/amazon/sdk/availability/FileStore, "put/b64");
        jsonobject = Base64.encodeToString(encryptionManager.encrypt(jsonobject), 11);
        Profiler.scopeEnd(profilerscope1);
          goto _L3
        jsonobject;
        throw new DataStoreException(jsonobject);
        Logger.i((new StringBuilder()).append("Ignoring a put() as exceeded persistence config: ").append(localStorageMaxRollOver).append("x ").append(localStorageMaxRollOverSize).append("B").toString());
          goto _L4
    }

    protected void rollOverIfNeeded()
        throws IOException
    {
        while (localStorageMaxRollOver == null || localStorageMaxRollOverSize == null || file.length() <= localStorageMaxRollOverSize.longValue()) 
        {
            return;
        }
        if ((long)(getRollOverCount() + 1) <= localStorageMaxRollOver.longValue() + 1L)
        {
            String s = String.format("availability_measurements_%s.measure", new Object[] {
                Long.valueOf(System.currentTimeMillis())
            });
            closeCurrentStream();
            preferences.put("last-file-used", s);
            file = new File(getDataDirectory(), s);
            out = new BufferedOutputStream(new FileOutputStream(file, true), 32768);
            return;
        } else
        {
            Logger.i((new StringBuilder()).append("not rolling over, as exceeded 'localStorageMaxRollOver': ").append(localStorageMaxRollOver).append("x ").append(localStorageMaxRollOverSize).append("B").toString());
            return;
        }
    }


}
