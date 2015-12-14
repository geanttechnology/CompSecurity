// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class i
    implements android.content.or
{

    private ContentResolver i;
    private Map l;
    private Set m;
    private boolean n;

    public void apply()
    {
    }

    public android.content.or clear()
    {
        n = true;
        return this;
    }

    public boolean commit()
    {
        ContentValues contentvalues = new ContentValues();
        if (n)
        {
            i.delete(com.tencent.mm.sdk.plugin.aredPref.CONTENT_URI, null, null);
            n = false;
        }
        String s;
        for (Iterator iterator = m.iterator(); iterator.hasNext(); i.delete(com.tencent.mm.sdk.plugin.aredPref.CONTENT_URI, "key = ?", new String[] {
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
            java.util..REditor reditor = (java.util..REditor.l)iterator1.next();
            if (com.tencent.mm.sdk.plugin.solver.unresolveObj(contentvalues, reditor.olveObj()))
            {
                i.update(com.tencent.mm.sdk.plugin.aredPref.CONTENT_URI, contentvalues, "key = ?", new String[] {
                    (String)reditor.TENT_URI()
                });
            }
        } while (true);
        return true;
    }

    public android.content.or putBoolean(String s, boolean flag)
    {
        l.put(s, Boolean.valueOf(flag));
        m.remove(s);
        return this;
    }

    public android.content.or putFloat(String s, float f)
    {
        l.put(s, Float.valueOf(f));
        m.remove(s);
        return this;
    }

    public android.content.or putInt(String s, int j)
    {
        l.put(s, Integer.valueOf(j));
        m.remove(s);
        return this;
    }

    public android.content.or putLong(String s, long l1)
    {
        l.put(s, Long.valueOf(l1));
        m.remove(s);
        return this;
    }

    public android.content.or putString(String s, String s1)
    {
        l.put(s, s1);
        m.remove(s);
        return this;
    }

    public android.content.or putStringSet(String s, Set set)
    {
        return null;
    }

    public android.content.or remove(String s)
    {
        m.add(s);
        return this;
    }

    public ants.Resolver(ContentResolver contentresolver)
    {
        l = new HashMap();
        m = new HashSet();
        n = false;
        i = contentresolver;
    }
}
