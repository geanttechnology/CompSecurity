// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import com.google.a.a.e;
import com.target.a.a.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c
    implements a.a
{

    private static final String LOG_TAG = "DataSourceLoadedMultiListener";
    private final boolean mIsDebug;
    private final List mListeners;

    public c()
    {
        this(false);
    }

    public c(boolean flag)
    {
        mListeners = new CopyOnWriteArrayList();
        mIsDebug = flag;
    }

    public void a(e e)
    {
        if (!mListeners.isEmpty())
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((a.a)iterator.next()).a(e)) { }
        } else
        {
            b.a("DataSourceLoadedMultiListener", "Data source has loaded, but no listeners have been added!");
        }
    }

    public void a(a.a a1)
    {
        mListeners.add(a1);
    }
}
