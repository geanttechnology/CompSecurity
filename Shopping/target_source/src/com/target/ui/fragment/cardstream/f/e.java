// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.f;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.ui.fragment.cardstream.f:
//            c

public class e
{

    private final Map mViewtagens;

    private e(Map map)
    {
        mViewtagens = map;
    }

    public static c.a a(int i)
    {
        return (new e(new HashMap())).b(i);
    }

    public e a(e e1)
    {
        e e2 = b();
        c c1;
        for (e1 = e1.mViewtagens.values().iterator(); e1.hasNext(); e2.b(c1.mViewToModify).a(c1.mMutations).a())
        {
            c1 = (c)e1.next();
        }

        return e2;
    }

    public Map a()
    {
        return mViewtagens;
    }

    void a(c c1)
    {
        mViewtagens.put(Integer.valueOf(c1.mViewToModify), c1);
    }

    public c.a b(int i)
    {
        c c1 = (c)mViewtagens.get(Integer.valueOf(i));
        if (c1 != null)
        {
            return c1.a(this);
        } else
        {
            return new c.a(this, i, null);
        }
    }

    public e b()
    {
        return new e(new HashMap(mViewtagens));
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (e)obj;
        if (mViewtagens == null) goto _L4; else goto _L3
_L3:
        if (mViewtagens.equals(((e) (obj)).mViewtagens)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((e) (obj)).mViewtagens == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        if (mViewtagens != null)
        {
            return mViewtagens.hashCode();
        } else
        {
            return 0;
        }
    }
}
