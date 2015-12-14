// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class bvq
{

    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    public final btx currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final bvu eventStorage;
    protected volatile long lastRollOverTime;
    protected final List rollOverListeners = new CopyOnWriteArrayList();
    protected final bvp transform;

    public bvq(Context context1, bvp bvp1, btx btx1, bvu bvu1, int i)
    {
        context = context1.getApplicationContext();
        transform = bvp1;
        eventStorage = bvu1;
        currentTimeProvider = btx1;
        lastRollOverTime = currentTimeProvider.a();
        defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i)
    {
        if (!eventStorage.a(i, getMaxByteSizePerFile()))
        {
            String s = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] {
                Integer.valueOf(eventStorage.a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())
            });
            CommonUtils.a(context, 4, "Fabric", s);
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String s)
    {
        for (Iterator iterator = rollOverListeners.iterator(); iterator.hasNext();)
        {
            bvv bvv1 = (bvv)iterator.next();
            try
            {
                bvv1.onRollOver(s);
            }
            catch (Exception exception)
            {
                CommonUtils.a(context, "One of the roll over listeners threw an exception", exception);
            }
        }

    }

    public void deleteAllEventsFiles()
    {
        eventStorage.a(eventStorage.c());
        eventStorage.d();
    }

    public void deleteOldestInRollOverIfOverMax()
    {
        Object obj1 = eventStorage.c();
        int i = getMaxFilesToKeep();
        if (((List) (obj1)).size() <= i)
        {
            return;
        }
        int j = ((List) (obj1)).size() - i;
        CommonUtils.a(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] {
            Integer.valueOf(((List) (obj1)).size()), Integer.valueOf(i), Integer.valueOf(j)
        }));
        Object obj = new TreeSet(new bvr(this));
        File file;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((TreeSet) (obj)).add(new bvs(file, parseCreationTimestampFromFileName(file.getName()))))
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
            ((ArrayList) (obj1)).add(((bvs)((Iterator) (obj)).next()).a);
        } while (((ArrayList) (obj1)).size() != j);
        eventStorage.a(((List) (obj1)));
    }

    public void deleteSentFiles(List list)
    {
        eventStorage.a(list);
    }

    public abstract String generateUniqueRollOverFileName();

    public List getBatchOfFilesToSend()
    {
        return eventStorage.a(1);
    }

    public long getLastRollOverTime()
    {
        return lastRollOverTime;
    }

    public int getMaxByteSizePerFile()
    {
        return 8000;
    }

    public int getMaxFilesToKeep()
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

    public void registerRollOverListener(bvv bvv1)
    {
        if (bvv1 != null)
        {
            rollOverListeners.add(bvv1);
        }
    }

    public boolean rollFileOver()
    {
        boolean flag = true;
        String s = null;
        if (!eventStorage.b())
        {
            s = generateUniqueRollOverFileName();
            eventStorage.a(s);
            CommonUtils.a(context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[] {
                s
            }));
            lastRollOverTime = currentTimeProvider.a();
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
        eventStorage.a(((byte []) (obj)));
    }
}
