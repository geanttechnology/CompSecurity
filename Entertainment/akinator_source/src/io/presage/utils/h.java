// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class h
    implements Set
{

    private Context a;
    private String b;

    public h(Context context, String s)
    {
        a = context;
        b = s;
    }

    public final boolean a(String s)
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("PERSISTED_SETS", 0);
        Set set = sharedpreferences.getStringSet(b, null);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet();
        }
        ((Set) (obj)).add(s);
        s = sharedpreferences.edit();
        s.putStringSet(b, ((Set) (obj)));
        s.commit();
        return true;
    }

    public final boolean add(Object obj)
    {
        return a((String)obj);
    }

    public final boolean addAll(Collection collection)
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("PERSISTED_SETS", 0);
        Set set = sharedpreferences.getStringSet(b, null);
        Object obj = set;
        if (set == null)
        {
            obj = new HashSet();
        }
        ((Set) (obj)).addAll(collection);
        collection = sharedpreferences.edit();
        collection.putStringSet(b, ((Set) (obj)));
        collection.commit();
        return true;
    }

    public final void clear()
    {
        android.content.SharedPreferences.Editor editor = a.getSharedPreferences("PERSISTED_SETS", 0).edit();
        editor.putStringSet(b, null);
        editor.commit();
    }

    public final boolean contains(Object obj)
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return false;
        } else
        {
            return set.contains(obj);
        }
    }

    public final boolean containsAll(Collection collection)
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return false;
        } else
        {
            return set.containsAll(collection);
        }
    }

    public final boolean isEmpty()
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return true;
        } else
        {
            return set.isEmpty();
        }
    }

    public final Iterator iterator()
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return null;
        } else
        {
            return set.iterator();
        }
    }

    public final boolean remove(Object obj)
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("PERSISTED_SETS", 0);
        Set set;
        for (set = sharedpreferences.getStringSet(b, null); set == null || !set.remove(obj);)
        {
            return false;
        }

        obj = sharedpreferences.edit();
        ((android.content.SharedPreferences.Editor) (obj)).putStringSet(b, set);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        return true;
    }

    public final boolean removeAll(Collection collection)
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("PERSISTED_SETS", 0);
        Set set;
        for (set = sharedpreferences.getStringSet(b, null); set == null || !set.removeAll(collection);)
        {
            return false;
        }

        collection = sharedpreferences.edit();
        collection.putStringSet(b, set);
        collection.commit();
        return true;
    }

    public final boolean retainAll(Collection collection)
    {
        SharedPreferences sharedpreferences = a.getSharedPreferences("PERSISTED_SETS", 0);
        Set set;
        for (set = sharedpreferences.getStringSet(b, null); set == null || !set.retainAll(collection);)
        {
            return false;
        }

        collection = sharedpreferences.edit();
        collection.putStringSet(b, set);
        collection.commit();
        return true;
    }

    public final int size()
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return 0;
        } else
        {
            return set.size();
        }
    }

    public final Object[] toArray()
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return new Object[0];
        } else
        {
            return set.toArray();
        }
    }

    public final Object[] toArray(Object aobj[])
    {
        Set set = a.getSharedPreferences("PERSISTED_SETS", 0).getStringSet(b, null);
        if (set == null)
        {
            return null;
        } else
        {
            return set.toArray(aobj);
        }
    }
}
