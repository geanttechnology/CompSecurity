// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MMSharedPreferences
    implements SharedPreferences
{

    private final String columns[] = {
        "_id", "key", "type", "value"
    };
    private final ContentResolver i;
    private final HashMap j = new HashMap();
    private REditor k;

    public MMSharedPreferences(Context context)
    {
        k = null;
        i = context.getContentResolver();
    }

    private Object getValue(String s)
    {
        Cursor cursor;
        int l;
        int i1;
        try
        {
            cursor = i.query(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, columns, "key = ?", new String[] {
                s
            }, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        if (cursor == null)
        {
            return null;
        }
        l = cursor.getColumnIndex("type");
        i1 = cursor.getColumnIndex("value");
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = ((String) (com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.resolveObj(cursor.getInt(l), cursor.getString(i1))));
_L1:
        cursor.close();
        return s;
        s = null;
          goto _L1
    }

    public boolean contains(String s)
    {
        return getValue(s) != null;
    }

    public android.content.SharedPreferences.Editor edit()
    {
        if (k == null)
        {
            k = new REditor(i);
        }
        return k;
    }

    public Map getAll()
    {
        Object obj;
        Object obj1;
        int l;
        int i1;
        int j1;
        try
        {
            obj = i.query(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, columns, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return j;
        }
        if (obj == null)
        {
            return null;
        }
        l = ((Cursor) (obj)).getColumnIndex("key");
        i1 = ((Cursor) (obj)).getColumnIndex("type");
        j1 = ((Cursor) (obj)).getColumnIndex("value");
        for (; ((Cursor) (obj)).moveToNext(); j.put(((Cursor) (obj)).getString(l), obj1))
        {
            obj1 = com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.resolveObj(((Cursor) (obj)).getInt(i1), ((Cursor) (obj)).getString(j1));
        }

        ((Cursor) (obj)).close();
        obj = j;
        return ((Map) (obj));
    }

    public boolean getBoolean(String s, boolean flag)
    {
        s = ((String) (getValue(s)));
        boolean flag1 = flag;
        if (s != null)
        {
            flag1 = flag;
            if (s instanceof Boolean)
            {
                flag1 = ((Boolean)s).booleanValue();
            }
        }
        return flag1;
    }

    public float getFloat(String s, float f)
    {
        s = ((String) (getValue(s)));
        float f1 = f;
        if (s != null)
        {
            f1 = f;
            if (s instanceof Float)
            {
                f1 = ((Float)s).floatValue();
            }
        }
        return f1;
    }

    public int getInt(String s, int l)
    {
        s = ((String) (getValue(s)));
        int i1 = l;
        if (s != null)
        {
            i1 = l;
            if (s instanceof Integer)
            {
                i1 = ((Integer)s).intValue();
            }
        }
        return i1;
    }

    public long getLong(String s, long l)
    {
        s = ((String) (getValue(s)));
        long l1 = l;
        if (s != null)
        {
            l1 = l;
            if (s instanceof Long)
            {
                l1 = ((Long)s).longValue();
            }
        }
        return l1;
    }

    public String getString(String s, String s1)
    {
        s = ((String) (getValue(s)));
        if (s != null && (s instanceof String))
        {
            return (String)s;
        } else
        {
            return s1;
        }
    }

    public Set getStringSet(String s, Set set)
    {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }

    private class REditor
        implements android.content.SharedPreferences.Editor
    {

        private ContentResolver i;
        private Map l;
        private Set m;
        private boolean n;

        public void apply()
        {
        }

        public android.content.SharedPreferences.Editor clear()
        {
            n = true;
            return this;
        }

        public boolean commit()
        {
            ContentValues contentvalues = new ContentValues();
            if (n)
            {
                i.delete(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
                n = false;
            }
            String s;
            for (Iterator iterator = m.iterator(); iterator.hasNext(); i.delete(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[] {
        s
    }))
            {
                s = (String)iterator.next();
            }

            Iterator iterator1 = l.entrySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                if (com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.unresolveObj(contentvalues, entry.getValue()))
                {
                    i.update(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, contentvalues, "key = ?", new String[] {
                        (String)entry.getKey()
                    });
                }
            } while (true);
            return true;
        }

        public android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            l.put(s, Boolean.valueOf(flag));
            m.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putFloat(String s, float f)
        {
            l.put(s, Float.valueOf(f));
            m.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String s, int i1)
        {
            l.put(s, Integer.valueOf(i1));
            m.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String s, long l1)
        {
            l.put(s, Long.valueOf(l1));
            m.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            l.put(s, s1);
            m.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            return null;
        }

        public android.content.SharedPreferences.Editor remove(String s)
        {
            m.add(s);
            return this;
        }

        public REditor(ContentResolver contentresolver)
        {
            l = new HashMap();
            m = new HashSet();
            n = false;
            i = contentresolver;
        }
    }

}
