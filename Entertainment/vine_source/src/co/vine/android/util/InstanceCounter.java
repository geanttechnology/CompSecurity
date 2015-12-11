// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import com.edisonwang.android.slog.SLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class InstanceCounter
{

    private final int mLimit;
    private final HashSet sInstanceCounter = new HashSet();

    public InstanceCounter(int i)
    {
        mLimit = i;
    }

    public static InstanceCounter get(int i)
    {
        return new InstanceCounter(i);
    }

    public int onCreate(Object obj)
    {
        System.gc();
        if (sInstanceCounter.size() > mLimit + 100)
        {
            sInstanceCounter.clear();
        }
        sInstanceCounter.add(new WeakReference(obj));
        obj = new ArrayList();
        Iterator iterator = sInstanceCounter.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            if (weakreference.get() == null)
            {
                ((ArrayList) (obj)).add(weakreference);
            }
        } while (true);
        sInstanceCounter.removeAll(((java.util.Collection) (obj)));
        if (SLog.sLogsOn && sInstanceCounter.size() >= mLimit)
        {
            throw new RuntimeException("Limit has reached for this object type.");
        } else
        {
            return sInstanceCounter.size();
        }
    }
}
