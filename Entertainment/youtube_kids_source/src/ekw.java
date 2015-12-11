// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.AbstractSet;
import java.util.Collection;

abstract class ekw extends AbstractSet
{

    ekw()
    {
    }

    public boolean removeAll(Collection collection)
    {
        return a.a(this, collection);
    }

    public boolean retainAll(Collection collection)
    {
        return super.retainAll((Collection)f.b(collection));
    }
}
