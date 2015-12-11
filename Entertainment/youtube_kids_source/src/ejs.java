// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class ejs extends ell
{

    ejs(Iterator iterator)
    {
        super(iterator);
    }

    final Object a(Object obj)
    {
        return ((java.util.Map.Entry)obj).getKey();
    }
}
