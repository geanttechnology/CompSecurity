// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.util:
//            ArraySharedPreferences, ObjectMapperWrapper

public class delegate
    implements android.content.
{

    private android.content.e _flddelegate;
    final ArraySharedPreferences this$0;

    public delegate appendUniqueToList(String s, String s1)
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
        _flddelegate.();
    }

    public volatile android.content. clear()
    {
        return clear();
    }

    public clear clear()
    {
        _flddelegate.();
        return this;
    }

    public boolean commit()
    {
        return _flddelegate.t();
    }

    public volatile android.content. putBoolean(String s, boolean flag)
    {
        return putBoolean(s, flag);
    }

    public putBoolean putBoolean(String s, boolean flag)
    {
        _flddelegate.olean(s, flag);
        return this;
    }

    public volatile android.content. putFloat(String s, float f)
    {
        return putFloat(s, f);
    }

    public putFloat putFloat(String s, float f)
    {
        _flddelegate.oat(s, f);
        return this;
    }

    public volatile android.content. putInt(String s, int i)
    {
        return putInt(s, i);
    }

    public putInt putInt(String s, int i)
    {
        _flddelegate.t(s, i);
        return this;
    }

    public  putListObject(String s, Class class1, List list)
        throws IOException
    {
        putString(s, ArraySharedPreferences.access$000(ArraySharedPreferences.this).writeValueAsString(list));
        return this;
    }

    public AsString putListString(String s, List list)
        throws IOException
    {
        putString(s, ArraySharedPreferences.access$000(ArraySharedPreferences.this).writeValueAsString(list));
        return this;
    }

    public volatile android.content. putLong(String s, long l)
    {
        return putLong(s, l);
    }

    public putLong putLong(String s, long l)
    {
        _flddelegate.ng(s, l);
        return this;
    }

    public volatile android.content. putString(String s, String s1)
    {
        return putString(s, s1);
    }

    public putString putString(String s, String s1)
    {
        _flddelegate.ring(s, s1);
        return this;
    }

    public android.content. putStringSet(String s, Set set)
    {
        _flddelegate.ringSet(s, set);
        return this;
    }

    public volatile android.content. remove(String s)
    {
        return remove(s);
    }

    public remove remove(String s)
    {
        _flddelegate.e(s);
        return this;
    }

    public (android.content. )
    {
        this$0 = ArraySharedPreferences.this;
        super();
        _flddelegate = ;
    }
}
