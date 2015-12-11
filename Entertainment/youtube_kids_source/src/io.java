// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.ArrayList;

public final class io
{

    private final Bundle a = new Bundle();
    private ArrayList b;

    public io()
    {
    }

    public final in a()
    {
        if (b != null)
        {
            int j = b.size();
            ArrayList arraylist = new ArrayList(j);
            for (int i = 0; i < j; i++)
            {
                arraylist.add(((if)b.get(i)).a);
            }

            a.putParcelableArrayList("routes", arraylist);
        }
        return new in(a, b);
    }

    public final io a(if if1)
    {
        if (if1 == null)
        {
            throw new IllegalArgumentException("route must not be null");
        }
        if (b == null)
        {
            b = new ArrayList();
        } else
        if (b.contains(if1))
        {
            throw new IllegalArgumentException("route descriptor already added");
        }
        b.add(if1);
        return this;
    }
}
