// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.SharedPreferences;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

// Referenced classes of package com.groupon.util:
//            ObjectMapperWrapper

public class ArraySharedPreferences
    implements SharedPreferences
{
    public class Editor
        implements android.content.SharedPreferences.Editor
    {

        private android.content.SharedPreferences.Editor _flddelegate;
        final ArraySharedPreferences this$0;

        public Editor appendUniqueToList(String s, String s1)
            throws IOException
        {
            com/groupon/util/ArraySharedPreferences;
            JVM INSTR monitorenter ;
            List list = getListString(s, new ArrayList());
            if (!list.contains(s1))
            {
                list.add(s1);
            }
            putListString(s, list);
            com/groupon/util/ArraySharedPreferences;
            JVM INSTR monitorexit ;
            return this;
            s;
            com/groupon/util/ArraySharedPreferences;
            JVM INSTR monitorexit ;
            throw s;
        }

        public void apply()
        {
            _flddelegate.apply();
        }

        public volatile android.content.SharedPreferences.Editor clear()
        {
            return clear();
        }

        public Editor clear()
        {
            _flddelegate.clear();
            return this;
        }

        public boolean commit()
        {
            return _flddelegate.commit();
        }

        public volatile android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            return putBoolean(s, flag);
        }

        public Editor putBoolean(String s, boolean flag)
        {
            _flddelegate.putBoolean(s, flag);
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putFloat(String s, float f)
        {
            return putFloat(s, f);
        }

        public Editor putFloat(String s, float f)
        {
            _flddelegate.putFloat(s, f);
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putInt(String s, int i)
        {
            return putInt(s, i);
        }

        public Editor putInt(String s, int i)
        {
            _flddelegate.putInt(s, i);
            return this;
        }

        public Editor putListObject(String s, Class class1, List list)
            throws IOException
        {
            putString(s, objectMapper.writeValueAsString(list));
            return this;
        }

        public Editor putListString(String s, List list)
            throws IOException
        {
            putString(s, objectMapper.writeValueAsString(list));
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putLong(String s, long l)
        {
            return putLong(s, l);
        }

        public Editor putLong(String s, long l)
        {
            _flddelegate.putLong(s, l);
            return this;
        }

        public volatile android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            return putString(s, s1);
        }

        public Editor putString(String s, String s1)
        {
            _flddelegate.putString(s, s1);
            return this;
        }

        public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            _flddelegate.putStringSet(s, set);
            return this;
        }

        public volatile android.content.SharedPreferences.Editor remove(String s)
        {
            return remove(s);
        }

        public Editor remove(String s)
        {
            _flddelegate.remove(s);
            return this;
        }

        public Editor(android.content.SharedPreferences.Editor editor)
        {
            this$0 = ArraySharedPreferences.this;
            super();
            _flddelegate = editor;
        }
    }


    private SharedPreferences _flddelegate;
    private ObjectMapperWrapper objectMapper;

    public ArraySharedPreferences(SharedPreferences sharedpreferences)
    {
        _flddelegate = sharedpreferences;
    }

    public boolean contains(String s)
    {
        return _flddelegate.contains(s);
    }

    public volatile android.content.SharedPreferences.Editor edit()
    {
        return edit();
    }

    public Editor edit()
    {
        return new Editor(_flddelegate.edit());
    }

    public Map getAll()
    {
        return _flddelegate.getAll();
    }

    public boolean getBoolean(String s, boolean flag)
    {
        return _flddelegate.getBoolean(s, flag);
    }

    public float getFloat(String s, float f)
    {
        return _flddelegate.getFloat(s, f);
    }

    public int getInt(String s, int i)
    {
        return _flddelegate.getInt(s, i);
    }

    public List getListObject(String s, Class class1, List list)
        throws IOException
    {
        if (!contains(s))
        {
            return list;
        } else
        {
            class1 = objectMapper.getTypeFactory().constructCollectionType(java/util/List, class1);
            return (List)objectMapper.readValue(getString(s, null), class1);
        }
    }

    public List getListString(String s, List list)
        throws IOException
    {
        if (!contains(s))
        {
            return list;
        } else
        {
            return (List)objectMapper.readValue(getString(s, null), new TypeReference() {

                final ArraySharedPreferences this$0;

            
            {
                this$0 = ArraySharedPreferences.this;
                super();
            }
            });
        }
    }

    public long getLong(String s, long l)
    {
        return _flddelegate.getLong(s, l);
    }

    public String getString(String s, String s1)
    {
        return _flddelegate.getString(s, s1);
    }

    public Set getStringSet(String s, Set set)
    {
        return _flddelegate.getStringSet(s, set);
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        _flddelegate.registerOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
        _flddelegate.unregisterOnSharedPreferenceChangeListener(onsharedpreferencechangelistener);
    }

}
