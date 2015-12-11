// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.d;

import android.content.Context;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package c.a.a.a.a.d:
//            h, i, e, f, 
//            c

public abstract class d
{

    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final r currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final h eventStorage;
    protected volatile long lastRollOverTime;
    protected final List rollOverListeners = new CopyOnWriteArrayList();
    protected final c transform;

    public d(Context context1, c c1, r r1, h h1, int j)
    {
        context = context1.getApplicationContext();
        transform = c1;
        eventStorage = h1;
        currentTimeProvider = r1;
        lastRollOverTime = currentTimeProvider.a();
        defaultMaxFilesToKeep = j;
    }

    private void rollFileOverIfNeeded(int j)
    {
        if (!eventStorage.a(j, getMaxByteSizePerFile()))
        {
            String s = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] {
                Integer.valueOf(eventStorage.a()), Integer.valueOf(j), Integer.valueOf(getMaxByteSizePerFile())
            });
            l.a(context, 4, s);
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String s)
    {
        for (Iterator iterator = rollOverListeners.iterator(); iterator.hasNext();)
        {
            i j = (i)iterator.next();
            try
            {
                j.onRollOver(s);
            }
            catch (Exception exception)
            {
                l.b(context, "One of the roll over listeners threw an exception");
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
        int j = getMaxFilesToKeep();
        if (((List) (obj1)).size() <= j)
        {
            return;
        }
        int k = ((List) (obj1)).size() - j;
        l.a(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] {
            Integer.valueOf(((List) (obj1)).size()), Integer.valueOf(j), Integer.valueOf(k)
        }));
        Object obj = new TreeSet(new e(this));
        File file;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((TreeSet) (obj)).add(new f(file, parseCreationTimestampFromFileName(file.getName()))))
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
            ((ArrayList) (obj1)).add(((f)((Iterator) (obj)).next()).a);
        } while (((ArrayList) (obj1)).size() != k);
        eventStorage.a(((List) (obj1)));
    }

    public void deleteSentFiles(List list)
    {
        eventStorage.a(list);
    }

    protected abstract String generateUniqueRollOverFileName();

    public List getBatchOfFilesToSend()
    {
        return eventStorage.a(1);
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
        long l1;
        try
        {
            l1 = Long.valueOf(s[2]).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0L;
        }
        return l1;
    }

    public void registerRollOverListener(i j)
    {
        if (j != null)
        {
            rollOverListeners.add(j);
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
            l.a(context, 4, String.format(Locale.US, "generated new file %s", new Object[] {
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
