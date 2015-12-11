// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.a.a;
import com.gimbal.internal.proximity.core.b.b;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.gimbal.internal.proximity.core.f:
//            e

public final class f
    implements e
{

    private String a;
    private SharedPreferences b;
    private Lock c;

    public f(String s)
    {
        a = s;
        b = a.b.a.getSharedPreferences(a, 0);
        c = new ReentrantLock();
    }

    private static Object a(Class class1, String s)
    {
        if (class1 == java/lang/String)
        {
            return s;
        }
        if (class1 == java/lang/Long)
        {
            try
            {
                return new Long(Long.parseLong(s));
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                throw new b(com.gimbal.internal.proximity.core.b.a.b);
            }
        }
        if (class1 != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        return new Double(Double.parseDouble(s));
        if (class1 != java/lang/Boolean)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        return new Boolean(Boolean.parseBoolean(s));
        if (class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        return new Integer(Integer.parseInt(s));
        class1 = ((Class) (com.gimbal.internal.c.c.a(s, class1)));
        return class1;
    }

    public final Object a(String s, Class class1)
    {
        c.lock();
        s = b.getString(s, "does_not_exist");
        c.unlock();
        if ("does_not_exist".equals(s))
        {
            return null;
        } else
        {
            return a(class1, s);
        }
    }

    public final void a()
    {
        c.lock();
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.clear();
        editor.commit();
        c.unlock();
    }

    public final void a(String s)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.remove(s);
        editor.commit();
    }

    public final void a(String s, Object obj)
    {
        c.lock();
        android.content.SharedPreferences.Editor editor = b.edit();
        if (obj.getClass() != java/lang/String && obj.getClass() != java/lang/Long && obj.getClass() != java/lang/Double && obj.getClass() != java/lang/Boolean && obj.getClass() != java/lang/Integer) goto _L2; else goto _L1
_L1:
        editor.putString(s, obj.toString());
_L3:
        editor.commit();
_L4:
        c.unlock();
        return;
_L2:
        editor.putString(s, com.gimbal.internal.c.c.a(obj));
          goto _L3
        s;
          goto _L4
    }

    public final int b()
    {
        return b.getAll().size();
    }
}
