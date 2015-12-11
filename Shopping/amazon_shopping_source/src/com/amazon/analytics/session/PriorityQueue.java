// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.AnalyticsConfiguration;
import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.analytics.session:
//            SessionObserver

public class PriorityQueue
{
    private class SweeperRunnable
        implements Runnable
    {

        final PriorityQueue this$0;

        private boolean canContinue(long l, Message message)
        {
            if (message == null)
            {
                PriorityQueue.logger.d("Cannot continue.... head is empty");
            } else
            {
                message = (Long)message.getExtras().get("TimeStamp");
                if (message == null)
                {
                    PriorityQueue.logger.d("Cannot continue.... timestamp is empty");
                    return false;
                }
                Long long1 = Long.valueOf(l - message.longValue());
                PriorityQueue.logger.d((new StringBuilder()).append("Can we continue???? delta is ").append(long1.toString()).append(" message timestamp ").append(message).toString());
                l = getSweeperDelay();
                if (long1.longValue() >= l)
                {
                    return true;
                }
            }
            return false;
        }

        public void run()
        {
            Object obj = null;
_L7:
            queueLock.lock();
            Message message;
            Object obj1;
            Object obj2;
            InterruptedException interruptedexception1;
            long l;
            boolean flag;
            if (obj != null)
            {
                try
                {
                    messageQueue.put(obj);
                }
                catch (InterruptedException interruptedexception) { }
            }
            PriorityQueue.logger.d("Running sweeper");
            l = System.currentTimeMillis();
_L5:
            flag = canContinue(l, (Message)messageQueue.peek());
            if (!flag) goto _L2; else goto _L1
_L1:
            message = null;
            obj2 = (Message)messageQueue.take();
            message = ((Message) (obj2));
_L9:
            if (message == null) goto _L4; else goto _L3
_L3:
            obj2 = (Long)message.getExtras().get("TimeStamp");
            PriorityQueue.logger.d((new StringBuilder()).append("Dequeing message with timestamp ").append(obj2).toString());
            PriorityQueue.logger.d((new StringBuilder()).append("Remaining queue size ").append(messageQueue.size()).toString());
            doPublish(message);
            lastMessagePushTime.set(((Long) (obj2)).longValue());
              goto _L5
            obj1;
            PriorityQueue.logger.e("Error dequeuing message", ((Throwable) (obj1)));
              goto _L5
            obj1;
            PriorityQueue.logger.e("An error occurred in the sweeper", ((Throwable) (obj1)));
            queueLock.unlock();
_L6:
            PriorityQueue.logger.d("Finished running through queue... Waiting for message maturity");
            obj1 = (Message)messageQueue.take();
            obj = obj1;
            break MISSING_BLOCK_LABEL_258;
_L4:
            PriorityQueue.logger.d("breaking out of loop");
_L2:
            queueLock.unlock();
              goto _L6
            obj;
            queueLock.unlock();
            throw obj;
_L8:
            if (Thread.interrupted())
            {
                PriorityQueue.logger.w("Sweeper thread is being interrupted. This will stop the processing of session events");
                return;
            }
            waitForMessageMaturity(((Message) (obj)));
              goto _L7
            obj1;
              goto _L8
            interruptedexception1;
              goto _L9
        }

        private SweeperRunnable()
        {
            this$0 = PriorityQueue.this;
            super();
        }

    }


    private static final Logger logger = Logging.getLogger(com/amazon/analytics/session/PriorityQueue);
    private AnalyticsConfiguration config;
    private AtomicLong lastMessagePushTime;
    private BlockingQueue messageQueue;
    private Lock queueLock;
    private SessionObserver sessionObserver;
    private ExecutorService sweeperService;

    public PriorityQueue(SessionObserver sessionobserver, AnalyticsConfiguration analyticsconfiguration)
    {
        sweeperService = Executors.newSingleThreadExecutor();
        lastMessagePushTime = new AtomicLong(0L);
        queueLock = new ReentrantLock(true);
        messageQueue = new PriorityBlockingQueue(16, new Comparator() {

            final PriorityQueue this$0;

            public int compare(Message message, Message message1)
            {
                message = (Long)message.getExtras().get("TimeStamp");
                message1 = (Long)message1.getExtras().get("TimeStamp");
                if (message == null && message1 == null)
                {
                    return 0;
                }
                if (message == null)
                {
                    return 1;
                }
                if (message1 == null)
                {
                    return -1;
                } else
                {
                    return message.compareTo(message1);
                }
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Message)obj, (Message)obj1);
            }

            
            {
                this$0 = PriorityQueue.this;
                super();
            }
        });
        sessionObserver = sessionobserver;
        config = analyticsconfiguration;
        sweeperService.execute(new SweeperRunnable());
    }

    private void doPublish(Message message)
    {
        logger.d("sending publish to base broker");
        sessionObserver.onUpdate(message);
    }

    private final long getSweeperDelay()
    {
        return Math.max(2L, (long)config.getInt(com.amazon.analytics.AnalyticsConfiguration.Setting.IgnoreSessionInterval) - (long)config.getInt(com.amazon.analytics.AnalyticsConfiguration.Setting.MaturityDelta)) * 1000L;
    }

    private void waitForMessageMaturity(Message message)
    {
        long l2 = getSweeperDelay();
        long l = l2;
        Long long1 = Long.valueOf(System.currentTimeMillis());
        long l1 = l;
        Object obj = long1;
        if (message != null)
        {
            l1 = l;
            obj = long1;
            if (message.getExtras() != null)
            {
                obj = (Long)message.getExtras().get("TimeStamp");
                message = long1;
                if (obj != null)
                {
                    message = ((Message) (obj));
                }
                l1 = Math.max(l2 - (System.currentTimeMillis() - message.longValue()), 0L);
                obj = message;
            }
        }
        if (l1 == 0L)
        {
            return;
        }
        try
        {
            logger.d((new StringBuilder()).append("Waiting for a delay of ").append(l1).append(" based off message timestamp of ").append(((Long) (obj)).toString()).toString());
            Thread.sleep(l1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }

    public void enqueue(Message message)
    {
        Long long1;
        if (message == null)
        {
            try
            {
                logger.d("Message is being dropped because: The message is null");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                return;
            }
        }
        long1 = (Long)message.getExtras().get("TimeStamp");
        if (long1 != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        logger.d("Message is being dropped because: There is no message timestamp");
        return;
        if (long1.longValue() <= lastMessagePushTime.get())
        {
            logger.d("Message is being dropped because: The timestamp is too old");
            return;
        }
        queueLock.lock();
        messageQueue.put(message);
        logger.d((new StringBuilder()).append("Enqueing message with timestamp ").append(long1).append(" @ the time of ").append(System.currentTimeMillis()).toString());
        queueLock.unlock();
        return;
        message;
        queueLock.unlock();
        throw message;
    }








}
