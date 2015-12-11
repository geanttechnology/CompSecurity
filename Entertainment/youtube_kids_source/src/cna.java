// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class cna
    implements asx
{

    public final CopyOnWriteArraySet a = new CopyOnWriteArraySet();

    public cna()
    {
    }

    public final void a(long l, long l1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((asx)iterator.next()).a(l, l1)) { }
    }
}
