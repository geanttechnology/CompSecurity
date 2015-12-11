// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public class IntentionalObjectCounter
{

    private static final int LOCK[] = new int[0];
    public static final String RECORDER_INSTANCE_COUNT = "recorder";
    private static final HashMap sInstances = new HashMap();
    private final WeakReference mItem;
    public final String mKey;

    public IntentionalObjectCounter(String s, Object obj)
    {
        mKey = s;
        mItem = new WeakReference(obj);
    }

    public static void add(String s, WeakReference weakreference)
    {
        HashSet hashset = getCounter(s);
        synchronized (LOCK)
        {
            hashset.add(weakreference);
        }
        return;
        weakreference;
        s;
        JVM INSTR monitorexit ;
        throw weakreference;
    }

    public static int getCount(String s)
    {
        HashSet hashset = getCounter(s);
        int i;
        synchronized (LOCK)
        {
            i = hashset.size();
        }
        return i;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static HashSet getCounter(String s)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        HashSet hashset1 = (HashSet)sInstances.get(s);
        HashSet hashset;
        hashset = hashset1;
        if (hashset1 != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        hashset = new HashSet();
        sInstances.put(s, hashset);
        ai;
        JVM INSTR monitorexit ;
        return hashset;
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void release(String s, WeakReference weakreference)
    {
        HashSet hashset = getCounter(s);
        synchronized (LOCK)
        {
            hashset.remove(weakreference);
        }
        return;
        weakreference;
        s;
        JVM INSTR monitorexit ;
        throw weakreference;
    }

    public void add()
    {
        add(mKey, mItem);
    }

    public int getCount()
    {
        return getCount(mKey);
    }

    public void release()
    {
        release(mKey, mItem);
    }

}
