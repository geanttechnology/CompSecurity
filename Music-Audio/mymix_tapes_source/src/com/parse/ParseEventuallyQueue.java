// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.util.SparseArray;
import bolts.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.parse:
//            ParseCommand, ParseObject, ParseOperationSet, EventuallyPin

abstract class ParseEventuallyQueue
{
    public static class TestHelper
    {

        public static final int COMMAND_ENQUEUED = 3;
        public static final int COMMAND_FAILED = 2;
        public static final int COMMAND_NOT_ENQUEUED = 4;
        public static final int COMMAND_SUCCESSFUL = 1;
        private static final int MAX_EVENTS = 1000;
        public static final int NETWORK_DOWN = 7;
        public static final int OBJECT_REMOVED = 6;
        public static final int OBJECT_UPDATED = 5;
        private SparseArray events;

        public static String getEventString(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalStateException((new StringBuilder()).append("Encountered unknown event: ").append(i).toString());

            case 1: // '\001'
                return "COMMAND_SUCCESSFUL";

            case 2: // '\002'
                return "COMMAND_FAILED";

            case 3: // '\003'
                return "COMMAND_ENQUEUED";

            case 4: // '\004'
                return "COMMAND_NOT_ENQUEUED";

            case 5: // '\005'
                return "OBJECT_UPDATED";

            case 6: // '\006'
                return "OBJECT_REMOVED";

            case 7: // '\007'
                return "NETWORK_DOWN";
            }
        }

        public void clear()
        {
            events.clear();
            events.put(1, new Semaphore(1000));
            events.put(2, new Semaphore(1000));
            events.put(3, new Semaphore(1000));
            events.put(4, new Semaphore(1000));
            events.put(5, new Semaphore(1000));
            events.put(6, new Semaphore(1000));
            events.put(7, new Semaphore(1000));
            for (int i = 0; i < events.size(); i++)
            {
                int j = events.keyAt(i);
                ((Semaphore)events.get(j)).acquireUninterruptibly(1000);
            }

        }

        public List getUnexpectedEvents()
        {
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < events.size(); i++)
            {
                int j = events.keyAt(i);
                if (((Semaphore)events.get(j)).availablePermits() > 0)
                {
                    arraylist.add(getEventString(j));
                }
            }

            return arraylist;
        }

        public void notify(int i)
        {
            ((Semaphore)events.get(i)).release();
        }

        public int unexpectedEvents()
        {
            int j = 0;
            for (int i = 0; i < events.size(); i++)
            {
                int k = events.keyAt(i);
                j += ((Semaphore)events.get(k)).availablePermits();
            }

            return j;
        }

        public boolean waitFor(int i)
        {
            return waitFor(i, 1);
        }

        public boolean waitFor(int i, int j)
        {
            boolean flag;
            try
            {
                flag = ((Semaphore)events.get(i)).tryAcquire(j, 120L, TimeUnit.SECONDS);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
                return false;
            }
            return flag;
        }

        private TestHelper()
        {
            events = new SparseArray();
            clear();
        }

    }


    private boolean isConnected;
    private TestHelper testHelper;

    ParseEventuallyQueue()
    {
    }

    public abstract void clear();

    public abstract Task enqueueEventuallyAsync(ParseCommand parsecommand, ParseObject parseobject);

    void fakeObjectUpdate()
    {
        if (testHelper != null)
        {
            testHelper.notify(3);
            testHelper.notify(1);
            testHelper.notify(5);
        }
    }

    public TestHelper getTestHelper()
    {
        if (testHelper == null)
        {
            testHelper = new TestHelper();
        }
        return testHelper;
    }

    public boolean isConnected()
    {
        return isConnected;
    }

    protected void notifyTestHelper(int i)
    {
        if (testHelper != null)
        {
            testHelper.notify(i);
        }
    }

    public abstract void pause();

    public abstract int pendingCount();

    public abstract void resume();

    public void setConnected(boolean flag)
    {
        isConnected = flag;
    }

    public void setMaxCacheSizeBytes(int i)
    {
    }

    public void setTimeoutRetryWaitSeconds(double d)
    {
    }

    abstract void simulateReboot();

    Task waitForOperationSetAndEventuallyPin(ParseOperationSet parseoperationset, EventuallyPin eventuallypin)
    {
        return Task.forResult(null);
    }
}
