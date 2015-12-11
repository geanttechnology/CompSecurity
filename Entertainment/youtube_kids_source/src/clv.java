// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class clv
    implements clx
{

    public final CopyOnWriteArraySet a = new CopyOnWriteArraySet();

    public clv()
    {
    }

    public final void a(boolean flag, boolean flag1, boolean flag2)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((clx)iterator.next()).a(flag, flag1, flag2)) { }
    }
}
