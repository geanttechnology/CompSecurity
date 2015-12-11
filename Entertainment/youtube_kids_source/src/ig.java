// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ig
{

    public final Bundle a;
    private ArrayList b;

    public ig(if if1)
    {
        if (if1 == null)
        {
            throw new IllegalArgumentException("descriptor must not be null");
        }
        a = new Bundle(if1.a);
        if1.g();
        if (!if1.b.isEmpty())
        {
            b = new ArrayList(if1.b);
        }
    }

    public ig(String s, String s1)
    {
        a = new Bundle();
        a.putString("id", s);
        a.putString("name", s1);
    }

    public final if a()
    {
        if (b != null)
        {
            a.putParcelableArrayList("controlFilters", b);
        }
        return new if(a, b);
    }

    public final ig a(int i)
    {
        a.putInt("playbackType", i);
        return this;
    }

    public final ig a(IntentFilter intentfilter)
    {
        if (intentfilter == null)
        {
            throw new IllegalArgumentException("filter must not be null");
        }
        if (b == null)
        {
            b = new ArrayList();
        }
        if (!b.contains(intentfilter))
        {
            b.add(intentfilter);
        }
        return this;
    }

    public final ig a(String s)
    {
        a.putString("status", s);
        return this;
    }

    public final ig a(Collection collection)
    {
        if (collection == null)
        {
            throw new IllegalArgumentException("filters must not be null");
        }
        if (!collection.isEmpty())
        {
            for (collection = collection.iterator(); collection.hasNext(); a((IntentFilter)collection.next())) { }
        }
        return this;
    }

    public final ig a(boolean flag)
    {
        a.putBoolean("enabled", flag);
        return this;
    }

    public final ig b(int i)
    {
        a.putInt("playbackStream", i);
        return this;
    }

    public final ig c(int i)
    {
        a.putInt("volume", i);
        return this;
    }

    public final ig d(int i)
    {
        a.putInt("volumeMax", i);
        return this;
    }

    public final ig e(int i)
    {
        a.putInt("volumeHandling", i);
        return this;
    }

    public final ig f(int i)
    {
        a.putInt("presentationDisplayId", i);
        return this;
    }
}
