// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class asa
{

    public final CopyOnWriteArraySet a = new CopyOnWriteArraySet();

    public asa()
    {
    }

    public void a(int i, long l, long l1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((cmz)iterator.next()).a(i, l, l1)) { }
    }

    public void a(cmz cmz1)
    {
        a.add(cmz1);
    }

    public void b(cmz cmz1)
    {
        a.remove(cmz1);
    }
}
