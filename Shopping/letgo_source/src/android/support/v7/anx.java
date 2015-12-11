// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.support.v7:
//            ams, anz, amq, aoa, 
//            anw

public abstract class anx
{
    static class a
    {

        final File a;
        final long b;

        public a(File file, long l)
        {
            a = file;
            b = l;
        }
    }


    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final ams currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final anz eventStorage;
    protected volatile long lastRollOverTime;
    protected final List rollOverListeners = new CopyOnWriteArrayList();
    protected final anw transform;

    public anx(Context context1, anw anw1, ams ams1, anz anz1, int i)
        throws IOException
    {
        context = context1.getApplicationContext();
        transform = anw1;
        eventStorage = anz1;
        currentTimeProvider = ams1;
        lastRollOverTime = currentTimeProvider.a();
        defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i)
        throws IOException
    {
        if (!eventStorage.a(i, getMaxByteSizePerFile()))
        {
            String s = String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[] {
                Integer.valueOf(eventStorage.a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())
            });
            amq.a(context, 4, "Fabric", s);
            rollFileOver();
        }
    }

    private void triggerRollOverOnListeners(String s)
    {
        for (Iterator iterator = rollOverListeners.iterator(); iterator.hasNext();)
        {
            aoa aoa1 = (aoa)iterator.next();
            try
            {
                aoa1.onRollOver(s);
            }
            catch (Exception exception)
            {
                amq.a(context, "One of the roll over listeners threw an exception", exception);
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
        amq.a(context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[] {
            Integer.valueOf(((List) (obj1)).size()), Integer.valueOf(i), Integer.valueOf(j)
        }));
        Object obj = new TreeSet(new Comparator() {

            final anx a;

            public int a(a a1, a a2)
            {
                return (int)(a1.b - a2.b);
            }

            public int compare(Object obj2, Object obj3)
            {
                return a((a)obj2, (a)obj3);
            }

            
            {
                a = anx.this;
                super();
            }
        });
        File file;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((TreeSet) (obj)).add(new a(file, parseCreationTimestampFromFileName(file.getName()))))
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
            ((ArrayList) (obj1)).add(((a)((Iterator) (obj)).next()).a);
        } while (((ArrayList) (obj1)).size() != j);
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

    public void registerRollOverListener(aoa aoa1)
    {
        if (aoa1 != null)
        {
            rollOverListeners.add(aoa1);
        }
    }

    public boolean rollFileOver()
        throws IOException
    {
        boolean flag = true;
        String s = null;
        if (!eventStorage.b())
        {
            s = generateUniqueRollOverFileName();
            eventStorage.a(s);
            amq.a(context, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[] {
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
        throws IOException
    {
        obj = transform.toBytes(obj);
        rollFileOverIfNeeded(obj.length);
        eventStorage.a(((byte []) (obj)));
    }
}
