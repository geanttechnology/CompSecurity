// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.test.utils;

import android.content.SharedPreferences;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class TestSharedPreferences
    implements SharedPreferences
{
    private final class EditorImpl
        implements android.content.SharedPreferences.Editor
    {

        private boolean clear;
        private final Map modified;
        final TestSharedPreferences this$0;

        public void apply()
        {
            commit();
        }

        public android.content.SharedPreferences.Editor clear()
        {
            this;
            JVM INSTR monitorenter ;
            clear = true;
            this;
            JVM INSTR monitorexit ;
            return this;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean commit()
        {
            Object obj;
            boolean flag;
            flag = false;
            obj = new MemoryCommitResult();
            TestSharedPreferences testsharedpreferences = TestSharedPreferences.this;
            testsharedpreferences;
            JVM INSTR monitorenter ;
            if (!listeners.isEmpty())
            {
                flag = true;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            obj.keysModified = new ArrayList();
            obj.listeners = new HashSet(listeners.keySet());
            this;
            JVM INSTR monitorenter ;
            Iterator iterator;
            if (clear)
            {
                if (!map.isEmpty())
                {
                    obj.changesMade = true;
                    map.clear();
                }
                clear = false;
            }
            iterator = modified.entrySet().iterator();
_L6:
            if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            String s;
            Object obj1;
            obj1 = (java.util.Map.Entry)iterator.next();
            s = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = ((java.util.Map.Entry) (obj1)).getValue();
            if (obj1 != this && obj1 != null) goto _L4; else goto _L3
_L3:
            if (!map.containsKey(s)) goto _L6; else goto _L5
_L5:
            map.remove(s);
_L9:
            obj.changesMade = true;
            if (!flag) goto _L6; else goto _L7
_L7:
            ((MemoryCommitResult) (obj)).keysModified.add(s);
              goto _L6
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            testsharedpreferences;
            JVM INSTR monitorexit ;
            throw obj;
_L4:
            if (obj1.equals(map.get(s))) goto _L6; else goto _L8
_L8:
            map.put(s, obj1);
              goto _L9
_L2:
            modified.clear();
            this;
            JVM INSTR monitorexit ;
            testsharedpreferences;
            JVM INSTR monitorexit ;
            notifyListeners(((MemoryCommitResult) (obj)));
            return true;
              goto _L6
        }

        protected final void notifyListeners(MemoryCommitResult memorycommitresult)
        {
            if (memorycommitresult.listeners != null && memorycommitresult.keysModified != null && !memorycommitresult.keysModified.isEmpty())
            {
                if (Looper.getMainLooper() == Looper.myLooper())
                {
                    int i = memorycommitresult.keysModified.size() - 1;
                    while (i >= 0) 
                    {
                        String s = (String)memorycommitresult.keysModified.get(i);
                        Iterator iterator = memorycommitresult.listeners.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener = (android.content.SharedPreferences.OnSharedPreferenceChangeListener)iterator.next();
                            if (onsharedpreferencechangelistener != null)
                            {
                                onsharedpreferencechangelistener.onSharedPreferenceChanged(TestSharedPreferences.this, s);
                            }
                        } while (true);
                        i--;
                    }
                } else
                {
                    throw new RuntimeException("Post to main thread not supported!");
                }
            }
        }

        public android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, Boolean.valueOf(flag));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor putFloat(String s, float f)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, Float.valueOf(f));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor putInt(String s, int i)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, Integer.valueOf(i));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor putLong(String s, long l)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, Long.valueOf(l));
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, s1);
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            this;
            JVM INSTR monitorenter ;
            Map map1 = modified;
            if (set == null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            set = new HashSet(set);
_L1:
            map1.put(s, set);
            this;
            JVM INSTR monitorexit ;
            return this;
            set = null;
              goto _L1
            s;
            throw s;
        }

        public android.content.SharedPreferences.Editor remove(String s)
        {
            this;
            JVM INSTR monitorenter ;
            modified.put(s, this);
            this;
            JVM INSTR monitorexit ;
            return this;
            s;
            throw s;
        }

        private EditorImpl()
        {
            this$0 = TestSharedPreferences.this;
            super();
            modified = new HashMap();
        }

    }

    private static class MemoryCommitResult
    {

        public boolean changesMade;
        public List keysModified;
        public Set listeners;

        private MemoryCommitResult()
        {
        }

    }


    protected final Object dummyContent = new Object();
    protected final WeakHashMap listeners = new WeakHashMap();
    protected final Map map = new HashMap();

    public TestSharedPreferences()
    {
    }

    public boolean contains(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = map.containsKey(s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public android.content.SharedPreferences.Editor edit()
    {
        return new EditorImpl();
    }

    public Map getAll()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = new HashMap(map);
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getBoolean(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Boolean)map.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        flag = s.booleanValue();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public float getFloat(String s, float f)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Float)map.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        f = s.floatValue();
        this;
        JVM INSTR monitorexit ;
        return f;
        s;
        throw s;
    }

    public int getInt(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Integer)map.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        i = s.intValue();
        this;
        JVM INSTR monitorexit ;
        return i;
        s;
        throw s;
    }

    public long getLong(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Long)map.get(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = s.longValue();
        this;
        JVM INSTR monitorexit ;
        return l;
        s;
        throw s;
    }

    public String getString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String)map.get(s);
        if (s == null)
        {
            s = s1;
        }
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public Set getStringSet(String s, Set set)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Set)map.get(s);
        if (s == null)
        {
            s = set;
        }
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.put(onsharedpreferencechangelistener, dummyContent);
        this;
        JVM INSTR monitorexit ;
        return;
        onsharedpreferencechangelistener;
        throw onsharedpreferencechangelistener;
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.remove(onsharedpreferencechangelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        onsharedpreferencechangelistener;
        throw onsharedpreferencechangelistener;
    }
}
