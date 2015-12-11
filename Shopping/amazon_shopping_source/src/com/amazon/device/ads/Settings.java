// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, Log, AndroidTargetUtils

class Settings
{
    static interface SettingsListener
    {

        public abstract void settingsLoaded();
    }

    private class TransientValue extends Value
    {

        final Settings this$0;

        public TransientValue(Class class1, Object obj)
        {
            this$0 = Settings.this;
            super(class1, obj);
            isTransientData = true;
        }
    }

    private class Value
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


    private static final String LOG_TAG = com/amazon/device/ads/Settings.getSimpleName();
    private static final String PREFS_NAME = "AmazonMobileAds";
    public static final String SETTING_ENABLE_WEBVIEW_PAUSE_LOGIC = "shouldPauseWebViewTimersInWebViewRelatedActivities";
    protected static final String SETTING_TESTING_ENABLED = "testingEnabled";
    protected static final String SETTING_TLS_ENABLED = "tlsEnabled";
    private static Settings instance = new Settings();
    private final ConcurrentHashMap cache = new ConcurrentHashMap();
    private ArrayList listeners;
    private final ReentrantLock listenersLock = new ReentrantLock();
    private final CountDownLatch settingsLoadedLatch = new CountDownLatch(1);
    private SharedPreferences sharedPreferences;
    private final ReentrantLock writeToSharedPreferencesLock = new ReentrantLock();

    protected Settings()
    {
        listeners = new ArrayList();
    }

    private void commit(android.content.SharedPreferences.Editor editor)
    {
        if (ThreadUtils.isOnMainThread())
        {
            Log.e(LOG_TAG, "Committing settings must be executed on a background thread.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 9)
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
            Log.w(LOG_TAG, "Could not set null value for setting: %s", new Object[] {
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
            Log.w(LOG_TAG, "Could not set null value for setting: %s", new Object[] {
                s
            });
            return;
        } else
        {
            cache.put(s, value);
            return;
        }
    }

    protected static void reset()
    {
        instance = new Settings();
    }

    protected static void setInstance(Settings settings)
    {
        instance = settings;
    }

    private void writeCacheToSharedPreferences()
    {
        writeCacheToSharedPreferences(sharedPreferences);
    }

    protected void beginFetch(final Context context)
    {
        ThreadUtils.executeRunnable(new Runnable() {

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

    protected void cacheAdditionalEntries(Map map)
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
                    Log.w(LOG_TAG, "Could not cache null value for SharedPreferences setting: %s", new Object[] {
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

    public void contextReceived(Context context)
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

    protected void fetchSharedPreferences(Context context)
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

    public void flush()
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

    protected ConcurrentHashMap getCache()
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

    protected SharedPreferences getSharedPreferences()
    {
        return sharedPreferences;
    }

    protected SharedPreferences getSharedPreferencesFromContext(Context context)
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

    public boolean isSettingsLoaded()
    {
        return sharedPreferences != null;
    }

    public void listenForSettings(SettingsListener settingslistener)
    {
        listenersLock.lock();
        if (isSettingsLoaded())
        {
            settingslistener.settingsLoaded();
        } else
        {
            listeners.add(settingslistener);
        }
        listenersLock.unlock();
    }

    protected void notifySettingsListeners()
    {
        listenersLock.lock();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((SettingsListener)iterator.next()).settingsLoaded()) { }
        listeners.clear();
        listeners = null;
        listenersLock.unlock();
    }

    public void putBoolean(String s, boolean flag)
    {
        putSetting(s, new Value(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    public void putBooleanWithNoFlush(String s, boolean flag)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    public void putInt(String s, int i)
    {
        putSetting(s, new Value(java/lang/Integer, Integer.valueOf(i)));
    }

    public void putIntWithNoFlush(String s, int i)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Integer, Integer.valueOf(i)));
    }

    public void putLong(String s, long l)
    {
        putSetting(s, new Value(java/lang/Long, Long.valueOf(l)));
    }

    public void putLongWithNoFlush(String s, long l)
    {
        putSettingWithNoFlush(s, new Value(java/lang/Long, Long.valueOf(l)));
    }

    public void putString(String s, String s1)
    {
        putSetting(s, new Value(java/lang/String, s1));
    }

    public void putStringWithNoFlush(String s, String s1)
    {
        putSettingWithNoFlush(s, new Value(java/lang/String, s1));
    }

    public void putTransientBoolean(String s, boolean flag)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Boolean, Boolean.valueOf(flag)));
    }

    public void putTransientInt(String s, int i)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Integer, Integer.valueOf(i)));
    }

    public void putTransientLong(String s, long l)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/Long, Long.valueOf(l)));
    }

    public void putTransientString(String s, String s1)
    {
        putSettingWithNoFlush(s, new TransientValue(java/lang/String, s1));
    }

    protected void readSharedPreferencesIntoCache(SharedPreferences sharedpreferences)
    {
        cacheAdditionalEntries(sharedpreferences.getAll());
    }

    public void remove(String s)
    {
        s = (Value)cache.remove(s);
        if (s != null && !((Value) (s)).isTransientData && isSettingsLoaded())
        {
            flush();
        }
    }

    public void removeWithNoFlush(String s)
    {
        cache.remove(s);
    }

    protected void writeCacheToSharedPreferences(final SharedPreferences sharedPreferences)
    {
        ThreadUtils.executeRunnable(new Runnable() {

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
