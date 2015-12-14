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

public final class a
    implements SharedPreferences
{

    private final ContentResolver a;
    private final String b[] = {
        "_id", "key", "type", "value"
    };
    private final HashMap c = new HashMap();
    private a d;

    public a(Context context)
    {
        d = null;
        a = context.getContentResolver();
    }

    private Object getValue(String s)
    {
        Cursor cursor;
        int i;
        int j;
        try
        {
            cursor = a.query(com.tencent.mm.sdk.c.b.CONTENT_URI, b, "key = ?", new String[] {
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
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = ((String) (com.tencent.mm.sdk.c.a.a(cursor.getInt(i), cursor.getString(j))));
_L1:
        cursor.close();
        return s;
        s = null;
          goto _L1
    }

    public final boolean contains(String s)
    {
        return getValue(s) != null;
    }

    public final android.content.SharedPreferences.Editor edit()
    {
        if (d == null)
        {
            d = new a(a);
        }
        return d;
    }

    public final Map getAll()
    {
        Object obj;
        Object obj1;
        int i;
        int j;
        int k;
        try
        {
            obj = a.query(com.tencent.mm.sdk.c.b.CONTENT_URI, b, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return c;
        }
        if (obj == null)
        {
            return null;
        }
        i = ((Cursor) (obj)).getColumnIndex("key");
        j = ((Cursor) (obj)).getColumnIndex("type");
        k = ((Cursor) (obj)).getColumnIndex("value");
        for (; ((Cursor) (obj)).moveToNext(); c.put(((Cursor) (obj)).getString(i), obj1))
        {
            obj1 = com.tencent.mm.sdk.c.a.a(((Cursor) (obj)).getInt(j), ((Cursor) (obj)).getString(k));
        }

        ((Cursor) (obj)).close();
        obj = c;
        return ((Map) (obj));
    }

    public final boolean getBoolean(String s, boolean flag)
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

    public final float getFloat(String s, float f)
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

    public final int getInt(String s, int i)
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

    public final long getLong(String s, long l)
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

    public final String getString(String s, String s1)
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

    public final Set getStringSet(String s, Set set)
    {
        return null;
    }

    public final void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }

    public final void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }

    private class a
        implements android.content.SharedPreferences.Editor
    {

        private ContentResolver a;
        private Map e;
        private Set f;
        private boolean g;

        public final void apply()
        {
        }

        public final android.content.SharedPreferences.Editor clear()
        {
            g = true;
            return this;
        }

        public final boolean commit()
        {
            ContentValues contentvalues = new ContentValues();
            if (g)
            {
                a.delete(com.tencent.mm.sdk.c.b.CONTENT_URI, null, null);
                g = false;
            }
            String s;
            for (Iterator iterator = f.iterator(); iterator.hasNext(); a.delete(com.tencent.mm.sdk.c.b.CONTENT_URI, "key = ?", new String[] {
        s
    }))
            {
                s = (String)iterator.next();
            }

            Iterator iterator1 = e.entrySet().iterator();
            do
            {
                if (iterator1.hasNext())
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    Object obj = entry.getValue();
                    byte byte0;
                    if (obj == null)
                    {
                        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                        byte0 = 0;
                    } else
                    if (obj instanceof Integer)
                    {
                        byte0 = 1;
                    } else
                    if (obj instanceof Long)
                    {
                        byte0 = 2;
                    } else
                    if (obj instanceof String)
                    {
                        byte0 = 3;
                    } else
                    if (obj instanceof Boolean)
                    {
                        byte0 = 4;
                    } else
                    if (obj instanceof Float)
                    {
                        byte0 = 5;
                    } else
                    if (obj instanceof Double)
                    {
                        byte0 = 6;
                    } else
                    {
                        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", (new StringBuilder("unresolve failed, unknown type=")).append(obj.getClass().toString()).toString());
                        byte0 = 0;
                    }
                    if (byte0 == 0)
                    {
                        byte0 = 0;
                    } else
                    {
                        contentvalues.put("type", Integer.valueOf(byte0));
                        contentvalues.put("value", obj.toString());
                        byte0 = 1;
                    }
                    if (byte0 != 0)
                    {
                        a.update(com.tencent.mm.sdk.c.b.CONTENT_URI, contentvalues, "key = ?", new String[] {
                            (String)entry.getKey()
                        });
                    }
                } else
                {
                    return true;
                }
            } while (true);
        }

        public final android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
        {
            e.put(s, Boolean.valueOf(flag));
            f.remove(s);
            return this;
        }

        public final android.content.SharedPreferences.Editor putFloat(String s, float f1)
        {
            e.put(s, Float.valueOf(f1));
            f.remove(s);
            return this;
        }

        public final android.content.SharedPreferences.Editor putInt(String s, int i)
        {
            e.put(s, Integer.valueOf(i));
            f.remove(s);
            return this;
        }

        public final android.content.SharedPreferences.Editor putLong(String s, long l)
        {
            e.put(s, Long.valueOf(l));
            f.remove(s);
            return this;
        }

        public final android.content.SharedPreferences.Editor putString(String s, String s1)
        {
            e.put(s, s1);
            f.remove(s);
            return this;
        }

        public final android.content.SharedPreferences.Editor putStringSet(String s, Set set)
        {
            return null;
        }

        public final android.content.SharedPreferences.Editor remove(String s)
        {
            f.add(s);
            return this;
        }

        public a(ContentResolver contentresolver)
        {
            e = new HashMap();
            f = new HashSet();
            g = false;
            a = contentresolver;
        }
    }

}
