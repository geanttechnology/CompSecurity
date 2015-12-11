// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MMSharedPreferences
    implements SharedPreferences
{
    private static class REditor
        implements android.content.SharedPreferences.Editor
    {

        private boolean clear;
        private ContentResolver cr;
        private Set remove;
        private Map values;

        public void apply()
        {
        }

        public android.content.SharedPreferences.Editor clear()
        {
            clear = true;
            return this;
        }

        public boolean commit()
        {
            ContentValues contentvalues = new ContentValues();
            if (clear)
            {
                cr.delete(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, null, null);
                clear = false;
            }
            String s;
            for (Iterator iterator = remove.iterator(); iterator.hasNext(); cr.delete(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, "key = ?", new String[] {
        s
    }))
            {
                s = (String)iterator.next();
            }

            Iterator iterator1 = values.entrySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                if (com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.unresolveObj(contentvalues, entry.getValue()))
                {
                    cr.update(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, contentvalues, "key = ?", new String[] {
                        (String)entry.getKey()
                    });
                }
            } while (true);
            return true;
        }

        public android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            values.put(s, Boolean.valueOf(flag));
            remove.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putFloat(String s, float f)
        {
            values.put(s, Float.valueOf(f));
            remove.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putInt(String s, int i)
        {
            values.put(s, Integer.valueOf(i));
            remove.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putLong(String s, long l)
        {
            values.put(s, Long.valueOf(l));
            remove.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            values.put(s, s1);
            remove.remove(s);
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            return null;
        }

        public android.content.SharedPreferences.Editor remove(String s)
        {
            remove.add(s);
            return this;
        }

        public REditor(ContentResolver contentresolver)
        {
            values = new HashMap();
            remove = new HashSet();
            clear = false;
            cr = contentresolver;
        }
    }


    private final String columns[] = {
        "_id", "key", "type", "value"
    };
    private final ContentResolver cr;
    private REditor editor;
    private final HashMap values = new HashMap();

    public MMSharedPreferences(Context context)
    {
        editor = null;
        cr = context.getContentResolver();
    }

    private Object getValue(String s)
    {
        Cursor cursor;
        int i;
        int j;
        try
        {
            cursor = cr.query(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, columns, "key = ?", new String[] {
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
        i = cursor.getColumnIndex("type");
        j = cursor.getColumnIndex("value");
        s = null;
        if (cursor.moveToFirst())
        {
            s = ((String) (com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.resolveObj(cursor.getInt(i), cursor.getString(j))));
        }
        cursor.close();
        return s;
    }

    public boolean contains(String s)
    {
        return getValue(s) != null;
    }

    public android.content.SharedPreferences.Editor edit()
    {
        if (editor == null)
        {
            editor = new REditor(cr);
        }
        return editor;
    }

    public Map getAll()
    {
        Object obj;
        Object obj1;
        int i;
        int j;
        int k;
        try
        {
            obj = cr.query(com.tencent.mm.sdk.plugin.MMPluginProviderConstants.SharedPref.CONTENT_URI, columns, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return values;
        }
        if (obj == null)
        {
            return null;
        }
        i = ((Cursor) (obj)).getColumnIndex("key");
        j = ((Cursor) (obj)).getColumnIndex("type");
        k = ((Cursor) (obj)).getColumnIndex("value");
        for (; ((Cursor) (obj)).moveToNext(); values.put(((Cursor) (obj)).getString(i), obj1))
        {
            obj1 = com.tencent.mm.sdk.plugin.MMPluginProviderConstants.Resolver.resolveObj(((Cursor) (obj)).getInt(j), ((Cursor) (obj)).getString(k));
        }

        ((Cursor) (obj)).close();
        obj = values;
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

    public int getInt(String s, int i)
    {
        s = ((String) (getValue(s)));
        int j = i;
        if (s != null)
        {
            j = i;
            if (s instanceof Integer)
            {
                j = ((Integer)s).intValue();
            }
        }
        return j;
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
}
