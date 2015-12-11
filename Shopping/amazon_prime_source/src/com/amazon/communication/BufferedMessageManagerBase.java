// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.communication:
//            PeriodicTimeoutInstanceRemover, ByteBufferChainMessageImpl, InstanceTracker, MessageIdentity

public abstract class BufferedMessageManagerBase
{
    public static class ByteBufferChainMessageEntry extends MessageEntry
    {

        protected int mFragmentCount;
        protected long mLastFragmentArrivalTimeInMillis;

        public void appendFragment(Message message)
        {
            ((ByteBufferChainMessageImpl)mMessage).appendPayload(message);
            mFragmentCount = mFragmentCount + 1;
            mLastFragmentArrivalTimeInMillis = GlobalTimeSource.INSTANCE.currentTimeMillis();
        }

        public long getLastFragmentArrivalTimeInMillis()
        {
            return mLastFragmentArrivalTimeInMillis;
        }

        public String toString()
        {
            Message message = mMessage;
            int i = mMessageId;
            int j = mMessage.getPayloadSize();
            Object obj;
            if (mChannel == -1)
            {
                obj = "NO_CHANNEL_SPECIFIED";
            } else
            {
                obj = Integer.valueOf(mChannel);
            }
            return DPFormattedMessage.toDPFormat("MessageEntry", "message details", new Object[] {
                "message", message, "messageId", Integer.valueOf(i), "message size", Integer.valueOf(j), "channel", obj, "fragmentCount", Integer.valueOf(mFragmentCount), 
                "lastFragmentArrivalTimeMillis", Long.valueOf(mLastFragmentArrivalTimeInMillis)
            });
        }

        public ByteBufferChainMessageEntry(ByteBufferChainMessageImpl bytebufferchainmessageimpl, int i, int j)
        {
            super(bytebufferchainmessageimpl, i, j);
            mFragmentCount = 1;
            mLastFragmentArrivalTimeInMillis = GlobalTimeSource.INSTANCE.currentTimeMillis();
        }
    }

    public static class MessageEntry
    {

        protected final int mChannel;
        protected final Message mMessage;
        protected final int mMessageId;

        public int getChannel()
        {
            return mChannel;
        }

        public Message getMessage()
        {
            return mMessage;
        }

        public int getMessageId()
        {
            return mMessageId;
        }

        public String toString()
        {
            Message message = mMessage;
            int i = getMessageId();
            int j = mMessage.getPayloadSize();
            Object obj;
            if (mChannel == -1)
            {
                obj = "NO_CHANNEL_SPECIFIED";
            } else
            {
                obj = Integer.valueOf(mChannel);
            }
            return DPFormattedMessage.toDPFormat("MessageEntry", "message details", new Object[] {
                "message", message, "messageId", Integer.valueOf(i), "message size", Integer.valueOf(j), "channel", obj
            });
        }

        public MessageEntry(Message message, int i, int j)
        {
            mMessage = message;
            mMessageId = i;
            mChannel = j;
        }
    }

    public static interface MessageIdentityKey
    {
    }

    protected static class MessageIdentityWithMessageId extends MessageIdentity
        implements MessageIdentityKey
    {

        public MessageIdentityWithMessageId(EndpointIdentity endpointidentity, int i)
        {
            super(endpointidentity, i);
        }
    }

    protected class MessageInstanceTracker
        implements InstanceTracker
    {

        final BufferedMessageManagerBase this$0;

        public Set getTrackedInstances()
        {
            HashSet hashset = new HashSet(mMessageFragmentMap.keySet());
            hashset.addAll(mThrownAwayMessages.keySet());
            return hashset;
        }

        public boolean isTimedOut(MessageIdentityKey messageidentitykey)
        {
            ByteBufferChainMessageEntry bytebufferchainmessageentry = (ByteBufferChainMessageEntry)mMessageFragmentMap.get(messageidentitykey);
            long l = 0L;
            if (bytebufferchainmessageentry != null)
            {
                l = bytebufferchainmessageentry.getLastFragmentArrivalTimeInMillis();
            } else
            {
                messageidentitykey = (Long)mThrownAwayMessages.get(messageidentitykey);
                if (messageidentitykey != null)
                {
                    l = messageidentitykey.longValue();
                }
            }
            return mMessageTrackingTimeoutInMillis < GlobalTimeSource.INSTANCE.currentTimeMillis() - l;
        }

        public volatile boolean isTimedOut(Object obj)
        {
            return isTimedOut((MessageIdentityKey)obj);
        }

        public boolean stopTrackingInstance(MessageIdentityKey messageidentitykey)
        {
            if (mMessageFragmentMap.remove(messageidentitykey) != null)
            {
                BufferedMessageManagerBase.log.debug("stopTrackingInstance", "stop tracking buffered message", new Object[] {
                    "instance", messageidentitykey
                });
                return true;
            }
            if (mThrownAwayMessages.remove(messageidentitykey) != null)
            {
                BufferedMessageManagerBase.log.debug("stopTrackingInstance", "stop tracking thrown away message", new Object[] {
                    "instance", messageidentitykey
                });
                return true;
            } else
            {
                BufferedMessageManagerBase.log.warn("stopTrackingInstance", "message already processed", new Object[] {
                    "instance", messageidentitykey
                });
                return false;
            }
        }

        public volatile boolean stopTrackingInstance(Object obj)
        {
            return stopTrackingInstance((MessageIdentityKey)obj);
        }

        protected MessageInstanceTracker()
        {
            this$0 = BufferedMessageManagerBase.this;
            super();
        }
    }


    public static final long DEFAULT_MESSAGE_TRACKING_TIMEOUT_IN_MILLIS = 0x1b7740L;
    public static final int MAX_MESSAGE_BUFFER_SIZE = 0xa00000;
    protected static final int NO_CHANNEL_SPECIFIED = -1;
    private static final DPLogger log = new DPLogger("TComm.BufferedMessageManagerBase");
    private static AtomicInteger sDeadMessageRemoverNumber = new AtomicInteger(0);
    private final PeriodicTimeoutInstanceRemover mDeadMessageRemover;
    protected Map mMessageFragmentMap;
    private final InstanceTracker mMessageInstanceTracker;
    protected final long mMessageTrackingTimeoutInMillis;
    private final Map mThrownAwayMessages;

    public BufferedMessageManagerBase()
    {
        this(0x1b7740L);
    }

    public BufferedMessageManagerBase(long l)
    {
        mThrownAwayMessages = new ConcurrentHashMap();
        mMessageFragmentMap = new ConcurrentHashMap();
        mMessageTrackingTimeoutInMillis = l;
        mMessageInstanceTracker = new MessageInstanceTracker();
        mDeadMessageRemover = createDeadMessageRemover(mMessageInstanceTracker, mMessageTrackingTimeoutInMillis);
    }

    protected PeriodicTimeoutInstanceRemover createDeadMessageRemover(InstanceTracker instancetracker, long l)
    {
        return new PeriodicTimeoutInstanceRemover(instancetracker, l);
    }

    public MessageIdentityKey createMessageIdentityKey(EndpointIdentity endpointidentity, int i)
    {
        return new MessageIdentityWithMessageId(endpointidentity, i);
    }

    public Map getMessageFragmentMap()
    {
        return mMessageFragmentMap;
    }

    protected abstract void handleCompletedMessage(EndpointIdentity endpointidentity, MessageEntry messageentry);

    public void handleMessageFragment(EndpointIdentity endpointidentity, int i, Message message, boolean flag)
    {
        handleMessageFragment(endpointidentity, i, message, flag, -1);
    }

    public void handleMessageFragment(EndpointIdentity endpointidentity, int i, Message message, boolean flag, int j)
    {
        verifyOnMessageFragmentParams(endpointidentity, message);
        log.debug("handleMessageFragment", "beginning execution", new Object[] {
            "identity", endpointidentity, "messageId", Integer.valueOf(i), "message", message, "moreToCome", Boolean.valueOf(flag)
        });
        mDeadMessageRemover.cleanIfTimesUp();
        MessageIdentityKey messageidentitykey = createMessageIdentityKey(endpointidentity, i);
        ByteBufferChainMessageEntry bytebufferchainmessageentry = (ByteBufferChainMessageEntry)mMessageFragmentMap.get(messageidentitykey);
        if (mThrownAwayMessages.containsKey(messageidentitykey))
        {
            if (!flag)
            {
                log.warn("handleMessageFragment", "last fragment of a thrown away message.", new Object[] {
                    "identity", EndpointIdentity.logSafe(endpointidentity), "messageId", Integer.valueOf(i)
                });
                mThrownAwayMessages.remove(messageidentitykey);
                return;
            } else
            {
                log.debug("handleMessageFragment", "non-last fragment of a thrown away message.", new Object[] {
                    "identity", EndpointIdentity.logSafe(endpointidentity), "messageId", Integer.valueOf(i)
                });
                mThrownAwayMessages.put(messageidentitykey, Long.valueOf(GlobalTimeSource.INSTANCE.currentTimeMillis()));
                return;
            }
        }
        if (!flag)
        {
            if (bytebufferchainmessageentry != null)
            {
                log.info("handleMessageFragment", "last fragment of a buffered message.", new Object[] {
                    "identity", EndpointIdentity.logSafe(endpointidentity), "messageId", Integer.valueOf(i), "receivedMessageFragments", bytebufferchainmessageentry
                });
                mMessageFragmentMap.remove(messageidentitykey);
                bytebufferchainmessageentry.appendFragment(message);
                handleCompletedMessage(endpointidentity, bytebufferchainmessageentry);
                return;
            } else
            {
                log.warn("handleMessageFragment", "last and first fragment of a message, possibly bug", new Object[0]);
                handleCompletedMessage(endpointidentity, new MessageEntry(message, i, j));
                return;
            }
        }
        int k;
        boolean flag1;
        if (message.getPayloadSize() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        FailFast.expectTrue(flag1);
        if (bytebufferchainmessageentry == null)
        {
            k = message.getPayloadSize();
        } else
        {
            k = bytebufferchainmessageentry.getMessage().getPayloadSize() + message.getPayloadSize();
        }
        if (k > 0xa00000)
        {
            log.error("handleMessageFragment", "can't buffer a too large message, throw it away.", new Object[] {
                "receivedMessageFragments", bytebufferchainmessageentry
            });
            if (bytebufferchainmessageentry != null)
            {
                mMessageFragmentMap.remove(messageidentitykey);
            }
            mThrownAwayMessages.put(messageidentitykey, Long.valueOf(GlobalTimeSource.INSTANCE.currentTimeMillis()));
            return;
        }
        if (bytebufferchainmessageentry == null)
        {
            log.info("handleMessageFragment", "new fragmented message.", new Object[] {
                "identity", EndpointIdentity.logSafe(endpointidentity), "messageId", Integer.valueOf(i), "moreToCome", Boolean.valueOf(flag)
            });
            endpointidentity = new ByteBufferChainMessageEntry(new ByteBufferChainMessageImpl(message), i, j);
            mMessageFragmentMap.put(messageidentitykey, endpointidentity);
            log.info("handleMessageFragment", "added message entry to message fragment map", new Object[] {
                "mMessageFragmentMap.size", Integer.valueOf(mMessageFragmentMap.size())
            });
            return;
        } else
        {
            log.info("handleMessageFragment", "append to buffered fragments.", new Object[] {
                "receivedMessageFragments", bytebufferchainmessageentry
            });
            bytebufferchainmessageentry.appendFragment(message);
            return;
        }
    }

    public void setMessageFragmentMap(Map map)
    {
        mMessageFragmentMap = map;
    }

    public void verifyOnMessageFragmentParams(EndpointIdentity endpointidentity, Message message)
    {
        if (endpointidentity == null)
        {
            throw new IllegalArgumentException("EndpointIdentity cannot be null");
        }
        if (message == null)
        {
            throw new IllegalArgumentException("Message cannot be null");
        } else
        {
            return;
        }
    }



}
