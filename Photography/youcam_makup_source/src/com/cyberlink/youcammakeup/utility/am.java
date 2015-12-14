// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class am
{

    private List a;

    public am()
    {
        a = new ArrayList();
    }

    public int a()
    {
        return a.size();
    }

    public void a(PanelDataCenter.Mask mask, List list)
    {
        a.add(Pair.create(mask, list));
    }

    public boolean a(int i)
    {
        return i >= 0 && i < a();
    }

    public PanelDataCenter.Mask b(int i)
    {
        if (!a(i))
        {
            return null;
        } else
        {
            return (PanelDataCenter.Mask)((Pair)a.get(i)).first;
        }
    }

    public void b()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((List)((Pair)iterator.next()).second).clear()) { }
        a.clear();
    }

    public List c(int i)
    {
        if (!a(i))
        {
            return null;
        } else
        {
            return (List)((Pair)a.get(i)).second;
        }
    }
}
