// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.util.SparseArray;
import java.lang.ref.SoftReference;
import myobfuscated.cd.a;

public final class b
{

    private SparseArray a;

    public b()
    {
        a = new SparseArray();
    }

    public final a a(int i)
    {
        SoftReference softreference = (SoftReference)a.get(i);
        if (softreference != null && softreference.get() != null)
        {
            return (a)softreference.get();
        } else
        {
            return null;
        }
    }

    public final void a(int i, a a1)
    {
        a1 = new SoftReference(a1);
        a.put(i, a1);
    }
}
