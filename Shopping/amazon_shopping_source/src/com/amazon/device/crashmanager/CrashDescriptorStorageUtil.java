// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.content.SharedPreferences;
import com.amazon.dp.logger.DPLogger;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class CrashDescriptorStorageUtil
{
    private class DescriptorCount
    {

        private int mCount;
        private long mCreatedMs;
        final CrashDescriptorStorageUtil this$0;

        public int getCount()
        {
            return mCount;
        }

        public long getCreated()
        {
            return mCreatedMs;
        }

        public void increment()
        {
            mCount = mCount + 1;
        }

        public String toString()
        {
            return (new StringBuilder()).append(Integer.toString(mCount)).append("|").append(Long.toString(mCreatedMs)).toString();
        }

        public DescriptorCount()
        {
            this(1, System.currentTimeMillis());
        }

        public DescriptorCount(int i, long l)
        {
            this$0 = CrashDescriptorStorageUtil.this;
            super();
            mCount = i;
            mCreatedMs = l;
        }
    }

    private class LRUCache extends LinkedHashMap
    {

        private final int mMaxCapacity;
        final CrashDescriptorStorageUtil this$0;

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > mMaxCapacity;
        }

        public LRUCache(int i)
        {
            this$0 = CrashDescriptorStorageUtil.this;
            super(i + 1, 0.75F, true);
            mMaxCapacity = i;
        }
    }


    private static final DPLogger log = new DPLogger("CrashDescriptorStorageUtil");
    private final LRUCache mCache;
    private final long mCacheExpirationTimeMs;
    private final long mCheckExpirationTimeMs;
    private long mLastCacheCleanupMs;
    private final int mMaxCapacity;
    private final long mMaxDedupeTimeMs;
    private final SharedPreferences mSharedPreferences;

    public CrashDescriptorStorageUtil(SharedPreferences sharedpreferences, int i, long l)
    {
        if (sharedpreferences == null)
        {
            throw new IllegalArgumentException("context cannot be null in CrashDescriptorStorageUtil");
        }
        if (i < 1)
        {
            throw new IllegalArgumentException("maxCapacity cannot be 0 or less in CrashDescriptorStorageUtil");
        }
        if (l < 1L)
        {
            throw new IllegalArgumentException("cacheExpirationTime cannot be less than 1 millisecond in CrashDescriptorStorageUtil");
        } else
        {
            mSharedPreferences = sharedpreferences;
            mMaxCapacity = i;
            mCacheExpirationTimeMs = l;
            mCache = new LRUCache(mMaxCapacity);
            mMaxDedupeTimeMs = mCacheExpirationTimeMs / 10L;
            mCheckExpirationTimeMs = mMaxDedupeTimeMs / 2L;
            loadFromSharedPreferences();
            return;
        }
    }

    private void checkCacheCleared()
    {
        if (shouldPrune())
        {
            log.info("checkCacheCleared", "Cache check needed, cleaning...", new Object[0]);
            pruneAll();
        }
    }

    private DescriptorCount deserializeDescriptorCount(String s)
    {
        if (s == null)
        {
            return new DescriptorCount();
        }
        s = s.split("|");
        boolean flag = true;
        long l1 = System.currentTimeMillis();
        int i = ((flag) ? 1 : 0);
        long l;
        try
        {
            if (s.length >= 1)
            {
                i = Integer.parseInt(s[0]);
            }
        }
        catch (Exception exception)
        {
            i = ((flag) ? 1 : 0);
        }
        l = l1;
        try
        {
            if (s.length >= 2)
            {
                l = Long.parseLong(s[1]);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            l = l1;
        }
        return new DescriptorCount(i, l);
    }

    private void loadFromSharedPreferences()
    {
        String s;
        long l1 = mSharedPreferences.getLong("lastCacheCleaned", -1L);
        long l = l1;
        if (l1 <= 0L)
        {
            l = (new Date()).getTime();
            log.info("loadFromSharedPreferences", "lastCacheCleared is not stored in Stored Preferences...storing", new Object[] {
                Long.valueOf(l)
            });
        }
        mLastCacheCleanupMs = l;
        s = null;
        String s1 = mSharedPreferences.getString("crashDescriptors", null);
        s = s1;
_L1:
        Exception exception;
        if (s == null || s.isEmpty())
        {
            log.info("loadFromSharedPreferences", "No keys retrieved from shared preferences.", new Object[0]);
        } else
        {
            String as[] = s.split(" ");
            log.debug("loadFromSharedPreferences", "Number of keys retrieved from shared preferences =", new Object[] {
                Integer.valueOf(as.length)
            });
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s2 = as[i];
                try
                {
                    mCache.put(s2, deserializeDescriptorCount(mSharedPreferences.getString(s2, null)));
                    log.debug("loadFromSharedPreferences", "Load Key =", new Object[] {
                        s2
                    });
                }
                catch (Exception exception1)
                {
                    log.warn("loadFromSharedPreferences", "Error when loading crash descriptors counts.", new Object[] {
                        exception1
                    });
                }
                i++;
            }
        }
        return;
        exception;
        log.warn("loadFromSharedPreferences", "Error when loading crash descriptors.", new Object[] {
            exception
        });
          goto _L1
    }

    public boolean contains(String s)
    {
        checkCacheCleared();
        if (s == null || mCache.isEmpty())
        {
            return false;
        } else
        {
            return mCache.containsKey(s);
        }
    }

    public Integer getCount(String s)
    {
        int i = 0;
        if (s == null)
        {
            return Integer.valueOf(0);
        }
        s = (DescriptorCount)mCache.get(s);
        if (s != null)
        {
            i = s.getCount();
        }
        return Integer.valueOf(i);
    }

    public Integer prune(String s)
    {
        int i = 0;
        if (s == null)
        {
            return Integer.valueOf(0);
        }
        s = (DescriptorCount)mCache.remove(s);
        if (s != null)
        {
            i = s.getCount();
        }
        return Integer.valueOf(i);
    }

    public void pruneAll()
    {
        pruneCache();
        saveToSharedPreferences();
    }

    public void pruneCache()
    {
        long l = System.currentTimeMillis();
        int j = 0;
        int i = 0;
        if (mCache != null)
        {
            long l1 = mCacheExpirationTimeMs;
            StringBuilder stringbuilder;
            Iterator iterator;
            if (log.isDebugEnabled())
            {
                stringbuilder = new StringBuilder();
            } else
            {
                stringbuilder = null;
            }
            iterator = mCache.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (((DescriptorCount)entry.getValue()).getCreated() < l - l1)
                {
                    if (stringbuilder != null)
                    {
                        stringbuilder.append((String)entry.getKey()).append(" ");
                    }
                    iterator.remove();
                    i++;
                }
            } while (true);
            j = i;
            if (log.isDebugEnabled())
            {
                log.debug("clearCache", (new StringBuilder()).append("Pruned the following items: ").append(stringbuilder.toString()).toString(), new Object[0]);
                stringbuilder = new StringBuilder();
                for (Iterator iterator1 = mCache.keySet().iterator(); iterator1.hasNext(); stringbuilder.append((String)iterator1.next()).append(" ")) { }
                log.debug("clearCache", (new StringBuilder()).append("New key set: ").append(stringbuilder.toString()).toString(), new Object[0]);
                j = i;
            }
        }
        mLastCacheCleanupMs = l;
        log.info("clearCache", "Pruned expired items from the LRU cache = ", new Object[] {
            Integer.valueOf(j)
        });
    }

    public void push(String s)
    {
        if (s == null)
        {
            return;
        }
        DescriptorCount descriptorcount = (DescriptorCount)mCache.get(s);
        if (descriptorcount != null)
        {
            descriptorcount.increment();
        } else
        {
            mCache.put(s, new DescriptorCount());
        }
        log.info("push", "Pushed Crash Descriptor on to the cache ", new Object[] {
            s
        });
    }

    public void saveToSharedPreferences()
    {
        android.content.SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.putLong("lastCacheCleaned", mLastCacheCleanupMs);
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = mCache.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            log.debug("saveToSharedPreferences", "Save Key =", new Object[] {
                entry.getKey()
            });
            stringbuilder.append((String)entry.getKey()).append(" ");
            if (entry.getValue() != null)
            {
                editor.putString((String)entry.getKey(), ((DescriptorCount)entry.getValue()).toString());
            }
        } while (true);
        editor.putString("crashDescriptors", stringbuilder.toString());
        editor.commit();
        log.info("saveToSharedPreferences", "Added last cleared cache to shared preferences = ", new Object[] {
            Long.valueOf(mLastCacheCleanupMs)
        });
        log.info("saveToSharedPreferences", "Number of keys stored in shared preferences = ", new Object[] {
            Integer.valueOf(mCache.size())
        });
    }

    public Boolean shouldDedupe(String s)
    {
        if (s == null)
        {
            return Boolean.valueOf(false);
        }
        s = (DescriptorCount)mCache.get(s);
        if (s == null)
        {
            return Boolean.valueOf(false);
        }
        if (s.getCount() < 10 && s.getCreated() > System.currentTimeMillis() - mMaxDedupeTimeMs)
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    public boolean shouldPrune()
    {
        long l = System.currentTimeMillis();
        long l1 = l - mLastCacheCleanupMs;
        if (l1 < 0L)
        {
            mLastCacheCleanupMs = l;
        } else
        if (l1 >= mCheckExpirationTimeMs)
        {
            return true;
        }
        return false;
    }

}
