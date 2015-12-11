// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class chc
    implements Runnable
{

    private Collection a;
    private cha b;

    chc(cha cha1, Collection collection)
    {
        b = cha1;
        a = collection;
        super();
    }

    public final void run()
    {
        for (Iterator iterator = cha.a(b).a(a).entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Boolean)entry.getValue()).booleanValue())
            {
                cha.b(b).add(entry.getKey());
            } else
            {
                cha.b(b).remove(entry.getKey());
            }
        }

        cha.a();
        String s = String.valueOf(cha.b(b).toString());
        if (s.length() != 0)
        {
            "Connected screens from fallback ScreenAvailabilityRetriever: ".concat(s);
            return;
        } else
        {
            new String("Connected screens from fallback ScreenAvailabilityRetriever: ");
            return;
        }
    }
}
