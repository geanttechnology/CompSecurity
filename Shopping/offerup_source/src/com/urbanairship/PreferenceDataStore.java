// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.Context;
import android.database.Cursor;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.urbanairship:
//            UrbanAirshipResolver, Logger, UrbanAirshipProvider

public final class PreferenceDataStore
{

    private static final String WHERE_CLAUSE_KEY = "_id = ?";
    Executor executor;
    private final List listeners;
    private final Map preferences;
    private final UrbanAirshipResolver resolver;

    PreferenceDataStore(Context context)
    {
        this(new UrbanAirshipResolver(context));
    }

    PreferenceDataStore(UrbanAirshipResolver urbanairshipresolver)
    {
        executor = Executors.newSingleThreadExecutor();
        preferences = new HashMap();
        listeners = new ArrayList();
        resolver = urbanairshipresolver;
    }

    private Preference getPreference(String s)
    {
        Map map = preferences;
        map;
        JVM INSTR monitorenter ;
        if (!preferences.containsKey(s)) goto _L2; else goto _L1
_L1:
        s = (Preference)preferences.get(s);
_L4:
        return s;
_L2:
        Preference preference;
        preference = new Preference(s, null);
        preferences.put(s, preference);
        s = preference;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void onPreferenceChanged(String s)
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PreferenceChangeListener)iterator.next()).onPreferenceChange(s)) { }
        break MISSING_BLOCK_LABEL_49;
        s;
        list;
        JVM INSTR monitorexit ;
        throw s;
        list;
        JVM INSTR monitorexit ;
    }

    public final void addListener(PreferenceChangeListener preferencechangelistener)
    {
        synchronized (listeners)
        {
            listeners.add(preferencechangelistener);
        }
        return;
        preferencechangelistener;
        list;
        JVM INSTR monitorexit ;
        throw preferencechangelistener;
    }

    public final boolean getBoolean(String s, boolean flag)
    {
        s = getPreference(s).get();
        if (s == null)
        {
            return flag;
        } else
        {
            return Boolean.valueOf(s).booleanValue();
        }
    }

    public final int getInt(String s, int i)
    {
        s = getPreference(s).get();
        if (s == null)
        {
            return i;
        }
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public final JsonValue getJsonValue(String s)
    {
        JsonValue jsonvalue;
        try
        {
            jsonvalue = JsonValue.parseString(getPreference(s).get());
        }
        catch (JsonException jsonexception)
        {
            Logger.debug((new StringBuilder("Unable to parse preference value: ")).append(s).toString(), jsonexception);
            return JsonValue.NULL;
        }
        return jsonvalue;
    }

    public final long getLong(String s, long l)
    {
        s = getPreference(s).get();
        if (s == null)
        {
            return l;
        }
        long l1;
        try
        {
            l1 = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }

    public final String getString(String s, String s1)
    {
        s = getPreference(s).get();
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    final void loadAll()
    {
        Cursor cursor = resolver.query(UrbanAirshipProvider.getPreferencesContentUri(), null, null, null, null);
        if (cursor == null)
        {
            return;
        }
        int i = cursor.getColumnIndex("_id");
        int j = cursor.getColumnIndex("value");
        String s;
        String s1;
        for (; cursor.moveToNext(); preferences.put(s, new Preference(s, s1)))
        {
            s = cursor.getString(i);
            s1 = cursor.getString(j);
        }

        cursor.close();
    }

    public final void put(String s, int i)
    {
        getPreference(s).put(String.valueOf(i));
    }

    public final void put(String s, long l)
    {
        getPreference(s).put(String.valueOf(l));
    }

    public final void put(String s, JsonSerializable jsonserializable)
    {
        if (jsonserializable == null)
        {
            remove(s);
            return;
        } else
        {
            put(s, jsonserializable.toJsonValue());
            return;
        }
    }

    public final void put(String s, JsonValue jsonvalue)
    {
        if (jsonvalue == null)
        {
            remove(s);
            return;
        } else
        {
            getPreference(s).put(jsonvalue.toString());
            return;
        }
    }

    public final void put(String s, String s1)
    {
        getPreference(s).put(s1);
    }

    public final void put(String s, boolean flag)
    {
        getPreference(s).put(String.valueOf(flag));
    }

    public final boolean putSync(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = null;
        } else
        {
            s1 = String.valueOf(s1);
        }
        return getPreference(s).putSync(s1);
    }

    public final void remove(String s)
    {
        getPreference(s).put(null);
    }

    public final void removeListener(PreferenceChangeListener preferencechangelistener)
    {
        synchronized (listeners)
        {
            listeners.remove(preferencechangelistener);
        }
        return;
        preferencechangelistener;
        list;
        JVM INSTR monitorexit ;
        throw preferencechangelistener;
    }

    public final boolean removeSync(String s)
    {
        return putSync(s, null);
    }



    private class Preference
    {

        private final String key;
        final PreferenceDataStore this$0;
        private String value;

        private void registerObserver()
        {
            class _cls2 extends ContentObserver
            {

                final Preference this$1;

                public void onChange(boolean flag)
                {
                    super.onChange(flag);
                    Logger.verbose((new StringBuilder("PreferenceDataStore - Preference updated:")).append(key).toString());
                    class _cls1
                        implements Runnable
                    {

                        final _cls2 this$2;

                        public void run()
                        {
                            syncValue();
                        }

                            _cls1()
                            {
                                this$2 = _cls2.this;
                                super();
                            }
                    }

                    executor.execute(new _cls1());
                }

                _cls2(Handler handler)
                {
                    this$1 = Preference.this;
                    super(handler);
                }
            }

            _cls2 _lcls2 = new _cls2(null);
            Uri uri = Uri.withAppendedPath(UrbanAirshipProvider.getPreferencesContentUri(), key);
            resolver.registerContentObserver(uri, true, _lcls2);
        }

        private void setValue(String s)
        {
            this;
            JVM INSTR monitorenter ;
            if (!UAStringUtil.equals(s, value))
            {
                break MISSING_BLOCK_LABEL_16;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            value = s;
            this;
            JVM INSTR monitorexit ;
            onPreferenceChanged(key);
            return;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        private boolean writeValue(String s)
        {
            boolean flag1 = true;
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            if (s != null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            Logger.verbose((new StringBuilder("PreferenceDataStore - Removing preference: ")).append(key).toString());
            ContentValues contentvalues;
            if (resolver.delete(UrbanAirshipProvider.getPreferencesContentUri(), "_id = ?", new String[] {
        key
    }) < 0)
            {
                flag = false;
            }
            this;
            JVM INSTR monitorexit ;
            return flag;
            Logger.verbose((new StringBuilder("PreferenceDataStore - Saving preference: ")).append(key).append(" value: ").append(s).toString());
            contentvalues = new ContentValues();
            contentvalues.put("_id", key);
            contentvalues.put("value", s);
            if (resolver.insert(UrbanAirshipProvider.getPreferencesContentUri(), contentvalues) != null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            this;
            JVM INSTR monitorexit ;
            return flag;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        String get()
        {
            this;
            JVM INSTR monitorenter ;
            String s = value;
            this;
            JVM INSTR monitorexit ;
            return s;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void put(final String value)
        {
            setValue(value);
            class _cls1
                implements Runnable
            {

                final Preference this$1;
                final String val$value;

                public void run()
                {
                    writeValue(value);
                }

                _cls1()
                {
                    this$1 = Preference.this;
                    value = s;
                    super();
                }
            }

            executor.execute(new _cls1());
        }

        boolean putSync(String s)
        {
            this;
            JVM INSTR monitorenter ;
            if (!writeValue(s))
            {
                break MISSING_BLOCK_LABEL_19;
            }
            setValue(s);
            return true;
            this;
            JVM INSTR monitorexit ;
            return false;
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
        }

        void syncValue()
        {
            Object obj1 = null;
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = resolver;
            Uri uri = UrbanAirshipProvider.getPreferencesContentUri();
            String s = key;
            obj = ((UrbanAirshipResolver) (obj)).query(uri, new String[] {
                "value"
            }, "_id = ?", new String[] {
                s
            }, null);
            Object obj2 = obj;
            this;
            JVM INSTR monitorexit ;
            if (obj == null) goto _L2; else goto _L1
_L1:
            obj2 = obj1;
            obj1 = obj;
            if (!((Cursor) (obj)).moveToFirst())
            {
                break MISSING_BLOCK_LABEL_80;
            }
            obj1 = obj;
            obj2 = ((Cursor) (obj)).getString(0);
            obj1 = obj;
            setValue(((String) (obj2)));
_L3:
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return;
            obj;
            obj1 = null;
_L5:
            obj2 = obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
_L4:
            if (obj1 != null)
            {
                ((Cursor) (obj1)).close();
            }
            throw obj;
_L2:
            obj1 = obj;
            Logger.debug((new StringBuilder("PreferenceDataStore - Unable to get preference ")).append(key).append(" from database. Falling back to cached value.").toString());
              goto _L3
            obj;
            obj1 = null;
              goto _L4
            obj;
            obj1 = obj2;
              goto _L5
        }



        Preference(String s, String s1)
        {
            this$0 = PreferenceDataStore.this;
            super();
            key = s;
            value = s1;
            registerObserver();
        }
    }


    private class PreferenceChangeListener
    {

        public abstract void onPreferenceChange(String s);
    }

}
