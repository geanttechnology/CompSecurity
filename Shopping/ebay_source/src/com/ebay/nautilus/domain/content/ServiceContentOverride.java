// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.SystemClock;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ServiceContentOverride
{
    private static class DatedField
    {

        public long timestamp;
        Object value;

        public boolean isOutdated()
        {
            return SystemClock.elapsedRealtime() - 0x1d4c0L > timestamp;
        }

        public DatedField(Object obj)
        {
            timestamp = SystemClock.elapsedRealtime();
            value = obj;
        }
    }

    private static class ItemOverride
    {

        public DatedField bidCount;
        public DatedField convertedPrice;
        public DatedField currentPrice;
        public DatedField highBidderUserId;
        public HashMap transactions;

        public boolean purgeOutdatedContent()
        {
            boolean flag = true;
            Iterator iterator;
            if (currentPrice == null || currentPrice.isOutdated())
            {
                currentPrice = null;
            } else
            {
                flag = false;
            }
            if (convertedPrice == null || convertedPrice.isOutdated())
            {
                convertedPrice = null;
            } else
            {
                flag = false;
            }
            if (bidCount == null || bidCount.isOutdated())
            {
                bidCount = null;
            } else
            {
                flag = false;
            }
            if (highBidderUserId == null || highBidderUserId.isOutdated())
            {
                highBidderUserId = null;
            } else
            {
                flag = false;
            }
            for (iterator = transactions.entrySet().iterator(); iterator.hasNext();)
            {
                flag &= ((TransactionOverride)((java.util.Map.Entry)iterator.next()).getValue()).purgeOutdatedContent();
            }

            return flag;
        }

        private ItemOverride()
        {
            transactions = new HashMap(5);
        }

    }

    private static class TransactionOverride
    {

        public DatedField feedbackLeft;
        public DatedField isShipped;
        public DatedField paidStatus;

        public boolean purgeOutdatedContent()
        {
            boolean flag = true;
            if (feedbackLeft == null || feedbackLeft.isOutdated())
            {
                feedbackLeft = null;
            } else
            {
                flag = false;
            }
            if (paidStatus == null || paidStatus.isOutdated())
            {
                paidStatus = null;
            } else
            {
                flag = false;
            }
            if (isShipped == null || isShipped.isOutdated())
            {
                isShipped = null;
                return flag;
            } else
            {
                return false;
            }
        }

        private TransactionOverride()
        {
        }

    }


    private static final int DEFAULT_CACHE_SIZE = 5;
    private static final long DEFAULT_TTL = 0x1d4c0L;
    private static final Map itemOverrides = new HashMap(5);
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ContentOverride", 3, "Overrides values returned from a service");

    public ServiceContentOverride()
    {
    }

    public static void clear()
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "Clearing cache");
        }
        synchronized (itemOverrides)
        {
            itemOverrides.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Integer getBidCount(long l)
    {
        Integer integer1 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride = purgeAndGet(Long.valueOf(l));
        Integer integer;
        integer = integer1;
        if (itemoverride == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        integer = integer1;
        if (itemoverride.bidCount == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        integer1 = (Integer)itemoverride.bidCount.value;
        integer = integer1;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding bidCount for item ").append(l).append(" bidCount: ").append(integer1).toString());
        integer = integer1;
        map;
        JVM INSTR monitorexit ;
        return integer;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ItemCurrency getConvertedPrice(long l)
    {
        ItemCurrency itemcurrency1 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride = purgeAndGet(Long.valueOf(l));
        ItemCurrency itemcurrency;
        itemcurrency = itemcurrency1;
        if (itemoverride == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        itemcurrency = itemcurrency1;
        if (itemoverride.convertedPrice == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        itemcurrency1 = (ItemCurrency)itemoverride.convertedPrice.value;
        itemcurrency = itemcurrency1;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding convertedPrice for item ").append(l).append(" convertedPrice: ").append(itemcurrency1).toString());
        itemcurrency = itemcurrency1;
        map;
        JVM INSTR monitorexit ;
        return itemcurrency;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ItemCurrency getCurrentPrice(long l)
    {
        ItemCurrency itemcurrency1 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride = purgeAndGet(Long.valueOf(l));
        ItemCurrency itemcurrency;
        itemcurrency = itemcurrency1;
        if (itemoverride == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        itemcurrency = itemcurrency1;
        if (itemoverride.currentPrice == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        itemcurrency1 = (ItemCurrency)itemoverride.currentPrice.value;
        itemcurrency = itemcurrency1;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding currentPrice for item ").append(l).append(" currentPrice: ").append(itemcurrency1).toString());
        itemcurrency = itemcurrency1;
        map;
        JVM INSTR monitorexit ;
        return itemcurrency;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static boolean getFeedbackLeft(long l, String s)
    {
        boolean flag1;
        if (s == null)
        {
            logTag.logAsError("Invalid argument: transactionId cannot be null");
            return false;
        }
        flag1 = false;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = purgeAndGet(Long.valueOf(l));
        boolean flag;
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = (TransactionOverride)((ItemOverride) (obj)).transactions.get(s);
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (((TransactionOverride) (obj)).feedbackLeft != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map;
        JVM INSTR monitorexit ;
        if (flag && logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Overriding feedbackLeft field for item ").append(l).append(", transactionId ").append(s).toString());
        }
        return flag;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String getHighBidder(long l)
    {
        String s1 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride = purgeAndGet(Long.valueOf(l));
        String s;
        s = s1;
        if (itemoverride == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s = s1;
        if (itemoverride.highBidderUserId == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s1 = (String)itemoverride.highBidderUserId.value;
        s = s1;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding highBidder for item ").append(l).append(" highBidder: ").append(s1).toString());
        s = s1;
        map;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getPaidStatus(long l, String s)
    {
        String s2;
        if (s == null)
        {
            logTag.logAsError("Invalid argument: transactionId cannot be null");
            return null;
        }
        s2 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = purgeAndGet(Long.valueOf(l));
        String s1;
        s1 = s2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = (TransactionOverride)((ItemOverride) (obj)).transactions.get(s);
        s1 = s2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        s1 = s2;
        if (((TransactionOverride) (obj)).paidStatus == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        s2 = (String)((TransactionOverride) (obj)).paidStatus.value;
        s1 = s2;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding paidStatus for item ").append(l).append(" transaction ").append(s).append(" paidStatus: ").append(s2).toString());
        s1 = s2;
        map;
        JVM INSTR monitorexit ;
        return s1;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static Boolean isShipped(long l, String s)
    {
        Boolean boolean2;
        if (s == null)
        {
            logTag.logAsError("Invalid argument: transactionId cannot be null");
            return null;
        }
        boolean2 = null;
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = purgeAndGet(Long.valueOf(l));
        Boolean boolean1;
        boolean1 = boolean2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = (TransactionOverride)((ItemOverride) (obj)).transactions.get(s);
        boolean1 = boolean2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        boolean1 = boolean2;
        if (((TransactionOverride) (obj)).isShipped == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        boolean2 = (Boolean)((TransactionOverride) (obj)).isShipped.value;
        boolean1 = boolean2;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        FwLog.println(logTag, (new StringBuilder()).append("Overriding shipped status for item ").append(l).append(" transaction ").append(s).append(" isShipped: ").append(boolean2).toString());
        boolean1 = boolean2;
        map;
        JVM INSTR monitorexit ;
        return boolean1;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static ItemOverride purgeAndGet(Long long1)
    {
        Iterator iterator = itemOverrides.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((ItemOverride)((java.util.Map.Entry)iterator.next()).getValue()).purgeOutdatedContent())
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, (new StringBuilder()).append("Purged entry for ").append(long1.longValue()).toString());
                }
                iterator.remove();
            }
        } while (true);
        return (ItemOverride)itemOverrides.get(long1);
    }

    public static void setBidCount(long l, int i)
    {
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride1 = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = itemoverride1;
        if (itemoverride1 != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        itemoverride.bidCount = new DatedField(Integer.valueOf(i));
        map;
        JVM INSTR monitorexit ;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Setting bidCount for item ").append(l).append(" bidCount: ").append(i).toString());
        }
        return;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void setConvertedPrice(long l, ItemCurrency itemcurrency)
    {
        if (itemcurrency != null) goto _L2; else goto _L1
_L1:
        logTag.logAsError("Invalid argument: convertedPrice cannot be null");
_L4:
        return;
_L2:
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride1 = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = itemoverride1;
        if (itemoverride1 != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        itemoverride.convertedPrice = new DatedField(itemcurrency);
        map;
        JVM INSTR monitorexit ;
        if (!logTag.isLoggable) goto _L4; else goto _L3
_L3:
        FwLog.println(logTag, (new StringBuilder()).append("Setting convertedPrice for item ").append(l).append(" convertedPrice: ").append(itemcurrency).toString());
        return;
        itemcurrency;
        map;
        JVM INSTR monitorexit ;
        throw itemcurrency;
    }

    public static void setCurrentPrice(long l, ItemCurrency itemcurrency)
    {
        if (itemcurrency != null) goto _L2; else goto _L1
_L1:
        logTag.logAsError("Invalid argument: currentPrice cannot be null");
_L4:
        return;
_L2:
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride1 = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = itemoverride1;
        if (itemoverride1 != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        itemoverride.currentPrice = new DatedField(itemcurrency);
        map;
        JVM INSTR monitorexit ;
        if (!logTag.isLoggable) goto _L4; else goto _L3
_L3:
        FwLog.println(logTag, (new StringBuilder()).append("Setting currentPrice for item ").append(l).append(" currentPrice: ").append(itemcurrency).toString());
        return;
        itemcurrency;
        map;
        JVM INSTR monitorexit ;
        throw itemcurrency;
    }

    public static void setFeedbackLeft(long l, String s)
    {
        if (s == null)
        {
            logTag.logAsError("Invalid argument: transactionId cannot be null");
            return;
        }
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = ((ItemOverride) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        TransactionOverride transactionoverride = (TransactionOverride)itemoverride.transactions.get(s);
        obj = transactionoverride;
        if (transactionoverride != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj = new TransactionOverride();
        itemoverride.transactions.put(s, obj);
        obj.feedbackLeft = new DatedField(Boolean.valueOf(true));
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Setting feedbackLeft for item ").append(l).append(", transactionId ").append(s).toString());
        }
        map;
        JVM INSTR monitorexit ;
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setHighBidder(long l, String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        logTag.logAsError("Invalid argument: highBidder cannot be null");
_L4:
        return;
_L2:
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        ItemOverride itemoverride1 = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = itemoverride1;
        if (itemoverride1 != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        itemoverride.highBidderUserId = new DatedField(s);
        map;
        JVM INSTR monitorexit ;
        if (!logTag.isLoggable) goto _L4; else goto _L3
_L3:
        FwLog.println(logTag, (new StringBuilder()).append("Setting highBidder for item ").append(l).append(" highBidder: ").append(s).toString());
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setPaidStatus(long l, String s, String s1)
    {
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        logTag.logAsError("Invalid argument: transactionId and paidStatus cannot be null");
_L4:
        return;
_L2:
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = ((ItemOverride) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        TransactionOverride transactionoverride = (TransactionOverride)itemoverride.transactions.get(s);
        obj = transactionoverride;
        if (transactionoverride != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = new TransactionOverride();
        itemoverride.transactions.put(s, obj);
        obj.paidStatus = new DatedField(s1);
        map;
        JVM INSTR monitorexit ;
        if (!logTag.isLoggable) goto _L4; else goto _L3
_L3:
        FwLog.println(logTag, (new StringBuilder()).append("Setting paidStatus for item ").append(l).append(" transaction ").append(s).append(" paidStatus: ").append(s1).toString());
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void setShipped(long l, String s, boolean flag)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        logTag.logAsError("Invalid argument: transactionId cannot be null");
_L4:
        return;
_L2:
        Map map = itemOverrides;
        map;
        JVM INSTR monitorenter ;
        Object obj = (ItemOverride)itemOverrides.get(Long.valueOf(l));
        ItemOverride itemoverride;
        itemoverride = ((ItemOverride) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        itemoverride = new ItemOverride();
        itemOverrides.put(Long.valueOf(l), itemoverride);
        TransactionOverride transactionoverride = (TransactionOverride)itemoverride.transactions.get(s);
        obj = transactionoverride;
        if (transactionoverride != null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = new TransactionOverride();
        itemoverride.transactions.put(s, obj);
        obj.isShipped = new DatedField(Boolean.valueOf(flag));
        map;
        JVM INSTR monitorexit ;
        if (!logTag.isLoggable) goto _L4; else goto _L3
_L3:
        FwLog.println(logTag, (new StringBuilder()).append("Setting isShipped for item ").append(l).append(" transaction ").append(s).append(" isShipped: ").append(flag).toString());
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

}
