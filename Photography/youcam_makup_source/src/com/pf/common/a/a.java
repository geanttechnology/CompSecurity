// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.util.LruCache;
import com.pf.common.utility.m;
import com.pf.common.utility.n;
import com.pf.common.utility.q;

public class a extends LruCache
    implements q
{

    private final String a;
    private final n b = new n(this);

    public a(int i, String s)
    {
        super(i);
        a = s;
    }

    private void b(int i)
    {
        int j = n.a(maxSize(), i);
        m.a(a, (new StringBuilder()).append("onTrimMemory@").append(i).append(" trimToSize:").append(j).toString());
        trimToSize(j);
    }

    public void a(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            b(i);
        } else
        if (i >= 80)
        {
            evictAll();
            return;
        }
    }
}
