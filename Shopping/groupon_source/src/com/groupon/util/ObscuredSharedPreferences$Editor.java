// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.SharedPreferences;
import java.util.Set;

// Referenced classes of package com.groupon.util:
//            ObscuredSharedPreferences

public class _cls000
    implements android.content.
{

    private android.content..delegate _flddelegate;
    final ObscuredSharedPreferences this$0;

    public void apply()
    {
        _flddelegate._mthdelegate();
    }

    public volatile android.content. clear()
    {
        return clear();
    }

    public clear clear()
    {
        _flddelegate._mthdelegate();
        return this;
    }

    public boolean commit()
    {
        _flddelegate._mthdelegate();
        return true;
    }

    public volatile android.content. putBoolean(String s, boolean flag)
    {
        return putBoolean(s, flag);
    }

    public putBoolean putBoolean(String s, boolean flag)
    {
        _flddelegate.g(s, encrypt(Boolean.toString(flag)));
        return this;
    }

    public volatile android.content. putFloat(String s, float f)
    {
        return putFloat(s, f);
    }

    public putFloat putFloat(String s, float f)
    {
        _flddelegate.g(s, encrypt(Float.toString(f)));
        return this;
    }

    public volatile android.content. putInt(String s, int i)
    {
        return putInt(s, i);
    }

    public putInt putInt(String s, int i)
    {
        _flddelegate.g(s, encrypt(Integer.toString(i)));
        return this;
    }

    public volatile android.content. putLong(String s, long l)
    {
        return putLong(s, l);
    }

    public putLong putLong(String s, long l)
    {
        _flddelegate.g(s, encrypt(Long.toString(l)));
        return this;
    }

    public volatile android.content. putString(String s, String s1)
    {
        return putString(s, s1);
    }

    public putString putString(String s, String s1)
    {
        _flddelegate.g(s, encrypt(s1));
        return this;
    }

    public android.content. putStringSet(String s, Set set)
    {
        _flddelegate.gSet(s, set);
        return this;
    }

    public volatile android.content. remove(String s)
    {
        return remove(s);
    }

    public remove remove(String s)
    {
        _flddelegate._mthdelegate(s);
        return this;
    }

    public ()
    {
        this$0 = ObscuredSharedPreferences.this;
        super();
        _flddelegate = ObscuredSharedPreferences.access$000(ObscuredSharedPreferences.this).edit();
    }
}
