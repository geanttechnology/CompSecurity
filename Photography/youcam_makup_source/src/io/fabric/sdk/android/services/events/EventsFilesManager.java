// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package io.fabric.sdk.android.services.events:
//            EventsStorage, EventsStorageListener, EventTransform

public abstract class EventsFilesManager
{

    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final CurrentTimeProvider currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final EventsStorage eventStorage;
    protected volatile long lastRollOverTime;
    protected final List rollOverListeners = new CopyOnWriteArrayList();
    protected final EventTransform transform;

    public EventsFilesManager(Context context1, EventTransform eventtransform, CurrentTimeProvider currenttimeprovider, EventsStorage eventsstorage, int i)
    {
        context = context1.getApplicationContext();
        transform = eventtransform;
        eventStorage = eventsstorage;
        currentTimeProvider = currenttimeprovider;
        lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
        defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i)
    {
        if (!eventStorage.canWorkingFileStore(i, getMaxByteSizePerFile()))
        {
            String s = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] {
                Integer.valueOf(eventStorage.getWorkingFileUsedSizeInBytes()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())
            });
            CommonUtils.logControlled(context, 4, "Fabric", s);
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String s)
    {
        for (Iterator iterator = rollOverListeners.iterator(); iterator.hasNext();)
        {
            EventsStorageListener eventsstoragelistener = (EventsStorageListener)iterator.next();
            try
            {
                eventsstoragelistener.onRollOver(s);
            }
            catch (Exception exception)
            {
                CommonUtils.logControlledError(context, "One of the roll over listeners threw an exception", exception);
            }
        }

    }

    public void deleteAllEventsFiles()
    {
        eventStorage.deleteFilesInRollOverDirectory(eventStorage.getAllFilesInRollOverDirectory());
        eventStorage.deleteWorkingFile();
    }

    public void deleteOldestInRollOverIfOverMax()
    {
        Object obj1 = eventStorage.getAllFilesInRollOverDirectory();
        int i = getMaxFilesToKeep();
        if (((List) (obj1)).size() <= i)
        {
            return;
        }
        int j = ((List) (obj1)).size() - i;
        CommonUtils.logControlled(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] {
            Integer.valueOf(((List) (obj1)).size()), Integer.valueOf(i), Integer.valueOf(j)
        }));
        Object obj = new TreeSet(new _cls1());
        File file;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((TreeSet) (obj)).add(new FileWithTimestamp(file, parseCreationTimestampFromFileName(file.getName()))))
        {
            file = (File)((Iterator) (obj1)).next();
        }

        obj1 = new ArrayList();
        obj = ((TreeSet) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            ((ArrayList) (obj1)).add(((FileWithTimestamp)((Iterator) (obj)).next()).file);
        } while (((ArrayList) (obj1)).size() != j);
        eventStorage.deleteFilesInRollOverDirectory(((List) (obj1)));
    }

    public void deleteSentFiles(List list)
    {
        eventStorage.deleteFilesInRollOverDirectory(list);
    }

    protected abstract String generateUniqueRollOverFileName();

    public List getBatchOfFilesToSend()
    {
        return eventStorage.getBatchOfFilesToSend(1);
    }

    public long getLastRollOverTime()
    {
        return lastRollOverTime;
    }

    protected int getMaxByteSizePerFile()
    {
        return 8000;
    }

    protected int getMaxFilesToKeep()
    {
        return defaultMaxFilesToKeep;
    }

    public long parseCreationTimestampFromFileName(String s)
    {
        s = s.split("_");
        if (s.length != 3)
        {
            return 0L;
        }
        long l;
        try
        {
            l = Long.valueOf(s[2]).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l;
    }

    public void registerRollOverListener(EventsStorageListener eventsstoragelistener)
    {
        if (eventsstoragelistener != null)
        {
            rollOverListeners.add(eventsstoragelistener);
        }
    }

    public boolean rollFileOver()
    {
        boolean flag = true;
        String s = null;
        if (!eventStorage.isWorkingFileEmpty())
        {
            s = generateUniqueRollOverFileName();
            eventStorage.rollOver(s);
            CommonUtils.logControlled(context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[] {
                s
            }));
            lastRollOverTime = currentTimeProvider.getCurrentTimeMillis();
        } else
        {
            flag = false;
        }
        triggerRollOverOnListeners(s);
        return flag;
    }

    public void writeEvent(Object obj)
    {
        obj = transform.toBytes(obj);
        rollFileOverIfNeeded(obj.length);
        eventStorage.add(((byte []) (obj)));
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class FileWithTimestamp {}

}
