// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, ThreadUtils, MobileAdsLogger, AndroidTargetUtils

class Settings
{
    public static interface SettingsListener
    {

        public abstract void settingsLoaded();
    }

    static final class SettingsStatics
    {

        static final String IU_SERVICE_LAST_CHECKIN = "amzn-ad-iu-last-checkin";

        SettingsStatics()
        {
        }
    }

    class TransientValue extends Value
    {

        final Settings this$0;

        public TransientValue(Class class1, Object obj)
        {
            this$0 = Settings.this;
            super(class1, obj);
            isTransientData = true;
        }
    }

    class Value
    {

        public Class clazz;
        public boolean isTransientData;
        final Settings this$0;
        public Object value;

        public Value(Class class1, Object obj)
        {
            this$0 = Settings.this;
            super();
            clazz = class1;
            value = obj;
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/Settings.getSimpleName();
    private static final String PREFS_NAME = "AmazonMobileAds";
    public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
    protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
    protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
    private static Settings instance = new Settings();
    private final ConcurrentHashMap cache = new ConcurrentHashMap();
    private LinkedBlockingQueue listeners;
    private final MobileAdsLogger logger;
    private final CountDownLatch settingsLoadedLatch = new CountDownLatch(1);
    private SharedPreferences sharedPreferences;
    private final ReentrantLock writeToSharedPreferencesLock = new ReentrantLock();

    protected Settings()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        listeners = new LinkedBlockingQueue();
    }

    private void commit(android.content.SharedPreferences.Editor editor)
    {
        if (ThreadUtils.isOnMainThread())
        {
            logger.e("Committing settings must be executed on a background thread.");
        }
        if (AndroidTargetUtils.isAtLeastAndroidAPI(9))
        {
            AndroidTargetUtils.editorApply(editor);
            return;
        } else
        {
            editor.commit();
            return;
        }
    }

    public static Settings getInstance()
    {
        return instance;
    }

    private void putSetting(String s, Value value)
    {
        if (value.value == null)
        {
            logger.w("Could not set null value for setting: %s", new Object[] {
                s
            });
        } else
        {
            putSettingWithNoFlush(s, value);
            if (!value.isTransientData && isSettingsLoaded())
            {
                flush();
                return;
            }
        }
    }

    private void putSettingWithNoFlush(String s, Value value)
    {
        if (value.value == null)
        {
            logger.w("Could not set null value for setting: %s", new Object[] {
                s
            });
            return;
        } else
        {
            cache.put(s, value);
            return;
        }
    }

    private void writeCacheToSharedPreferences()
    {
        writeCacheToSharedPreferences(sharedPreferences);
    }

    void beginFetch(final Context context)
    {
        ThreadUtils.scheduleRunnable(new Runnable() {

            final Settings this$0;
            final Context val$context;

            public void run()
            {
                fetchSharedPreferences(context);
            }

            
            {
                this$0 = Settings.this;
                context = context1;
                super();
            }
        });
    }

    void cacheAdditionalEntries(Map map)
    {
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            if (s != null && !cache.containsKey(s))
            {
                obj = ((java.util.Map.Entry) (obj)).getValue();
                if (obj != null)
                {
                    cache.put(s, new Value(obj.getClass(), obj));
                } else
                {
                    logger.w("Could not cache null value for SharedPreferences setting: %s", new Object[] {
                        s
                    });
                }
            }
        } while (true);
    }

    public boolean containsKey(String s)
    {
        return cache.containsKey(s);
    }

    void contextReceived(Context context)
    {
        if (context == null)
        {
            return;
        } else
        {
            beginFetch(context);
            return;
        }
    }

    void fetchSharedPreferences(Context context)
    {
        if (!isSettingsLoaded())
        {
            context = getSharedPreferencesFromContext(context);
            readSharedPreferencesIntoCache(context);
            sharedPreferences = context;
            writeCacheToSharedPreferences(context);
        }
        settingsLoadedLatch.countDown();
        notifySettingsListeners();
    }

    void flush()
    {
        writeCacheToSharedPreferences();
    }

    public Boolean getBoolean(String s, Boolean boolean1)
    {
        s = (Value)cache.get(s);
        if (s == null)
        {
            return boolean1;
        } else
        {
            return (Boolean)((Value) (s)).value;
        }
    }

    public boolean getBoolean(String s, boolean flag)
    {
        s = getBoolean(s, ((Boolean) (null)));
        if (s == null)
        {
            return flag;
        } else
        {
            return s.booleanValue();
        }
    }

    ConcurrentHashMap getCache()
    {
        return cache;
    }

    public int getInt(String s, int i)
    {
        s = (Value)cache.get(s);
        if (s == null)
        {
            return i;
        } else
        {
            return ((Integer)((Value) (s)).value).intValue();
        }
    }

    public long getLong(String s, long l)
    {
        s = (Value)cache.get(s);
        if (s == null)
        {
            return l;
        } else
        {
            return ((Long)((Value) (s)).value).longValue();
        }
    }

    public Object getObject(String s, Object obj, Class class1)
    {
        Value value = (Value)cache.get(s);
        s = ((String) (obj));
        if (value != null)
        {
            s = ((String) (obj));
            if (class1.isInstance(value.value))
            {
                s = ((String) (value.value));
            }
        }
        return s;
    }

    SharedPreferences getSharedPreferences()
    {
        return sharedPreferences;
    }

    SharedPreferences getSharedPreferencesFromContext(Context context)
    {
        return context.getSharedPreferences("AmazonMobileAds", 0);
    }

    public String getString(String s, String s1)
    {
        s = (Value)cache.get(s);
        if (s == null)
        {
            return s1;
        } else
        {
            return (String)((Value) (s)).value;
        }
    }

    public boolean getWrittenBoolean(String s, boolean flag)
    {
        boolean flag1 = flag;
        if (isSettingsLoaded())
        {
            flag1 = sharedPreferences.getBoolean(s, flag);
        }
        return flag1;
    }

    public int getWrittenInt(String s, int i)
    {
        int j = i;
        if (isSettingsLoaded())
        {
            j = sharedPreferences.getInt(s, i);
        }
        return j;
    }

    public long getWrittenLong(String s, long l)
    {
        long l1 = l;
        if (isSettingsLoaded())
        {
            l1 = sharedPreferences.getLong(s, l);
        }
        return l1;
    }

    public String getWrittenString(String s, String s1)
    {
        String s2 = s1;
        if (isSettingsLoaded())
        {
            s2 = sharedPreferences.getString(s, s1);
        }
        return s2;
    }

    public boolean isSettingsLoaded()
    {
        return sharedPreferences != null;
    }

    public void listenForSettings(SettingsListener settingslistener)
    {
        if (isSettingsLoaded())
        {
            settingslistener.settingsLoaded();
            return;
        }
        try
        {
            listeners.put(settingslistener);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SettingsListener settingslistener)
        {
            logger.e("Interrupted exception while adding listener: %s", new Object[] {
                settingslistener.getMessage()
            });
        }
    }

    void notifySettingsListeners()
    {
        do
        {
            SettingsListener settingslistener = (SettingsListener)listeners.poll();
            if (settingslistener != null)
            {
                settingslistener.settingsLoaded();
            } else
            {
                return;
            }
        } while (true);
    }

    void putBoolean(String s, boolean flag)
    {
        putSetting(s, new Value(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    void putBooleanWithNoFlush(String s, boolean flag)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    void putInt(String s, int i)
    {
        putSetting(s, new Value(java/lang/Integer, Integer.valueOf(i)));
    }

    void putIntWithNoFlush(String s, int i)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Integer, Integer.valueOf(i)));
    }

    void putLong(String s, long l)
    {
        putSetting(s, new Value(java/lang/Long, Long.valueOf(l)));
    }

    void putLongWithNoFlush(String s, long l)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Long, Long.valueOf(l)));
    }

    void putString(String s, String s1)
    {
        putSetting(s, new Value(java/lang/String, s1));
    }

    void putStringWithNoFlush(String s, String s1)
    {
        putSettingWithNoFlush(s, new Value(java/lang/String, s1));
    }

    void putTransientBoolean(String s, boolean flag)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    void putTransientInt(String s, int i)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Integer, Integer.valueOf(i)));
    }

    void putTransientLong(String s, long l)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Long, Long.valueOf(l)));
    }

    public void putTransientObject(String s, Object obj)
    {
        putSettingWithNoFlush(s, new TransientValue(obj.getClass(), obj));
    }

    void putTransientString(String s, String s1)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/String, s1));
    }

    void readSharedPreferencesIntoCache(SharedPreferences sharedpreferences)
    {
        cacheAdditionalEntries(sharedpreferences.getAll());
    }

    void remove(String s)
    {
        s = (Value)cache.remove(s);
        if (s != null && !((Value) (s)).isTransientData && isSettingsLoaded())
        {
            flush();
        }
    }

    void removeWithNoFlush(String s)
    {
        cache.remove(s);
    }

    void writeCacheToSharedPreferences(final SharedPreferences sharedPreferences)
    {
        ThreadUtils.scheduleRunnable(new Runnable() {

            final Settings this$0;
            final SharedPreferences val$sharedPreferences;

            public void run()
            {
                writeToSharedPreferencesLock.lock();
                android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                Iterator iterator = cache.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Value value = (Value)entry.getValue();
                    if (!value.isTransientData)
                    {
                        if (value.clazz == java/lang/String)
                        {
                            editor.putString((String)entry.getKey(), (String)value.value);
                        } else
                        if (value.clazz == java/lang/Long)
                        {
                            editor.putLong((String)entry.getKey(), ((Long)value.value).longValue());
                        } else
                        if (value.clazz == java/lang/Integer)
                        {
                            editor.putInt((String)entry.getKey(), ((Integer)value.value).intValue());
                        } else
                        if (value.clazz == java/lang/Boolean)
                        {
                            editor.putBoolean((String)entry.getKey(), ((Boolean)value.value).booleanValue());
                        }
                    }
                } while (true);
                commit(editor);
                writeToSharedPreferencesLock.unlock();
            }

            
            {
                this$0 = Settings.this;
                sharedPreferences = sharedpreferences;
                super();
            }
        });
    }




}
