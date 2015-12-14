// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LRUMap
{

    private Map c;
    private int d;
    private int e;
    private PreRemoveCallback f;

    public LRUMap(int i)
    {
        this(i, null);
    }

    public LRUMap(int i, PreRemoveCallback preremovecallback)
    {
        c = null;
        f = null;
        d = i;
        e = 0;
        f = preremovecallback;
        c = new HashMap();
    }

    public boolean check(Object obj)
    {
        return c.containsKey(obj);
    }

    public boolean checkAndUpTime(Object obj)
    {
        if (c.containsKey(obj))
        {
            ((TimeVal)c.get(obj)).UpTime();
            return true;
        } else
        {
            return false;
        }
    }

    public void clear()
    {
        c.clear();
    }

    public void clear(OnClearListener onclearlistener)
    {
        if (c != null)
        {
            if (onclearlistener != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); onclearlistener.onClear(entry.getKey(), ((TimeVal)entry.getValue()).obj))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            c.clear();
        }
    }

    public Object get(Object obj)
    {
        obj = (TimeVal)c.get(obj);
        if (obj == null)
        {
            return null;
        } else
        {
            return ((TimeVal) (obj)).obj;
        }
    }

    public Object getAndUptime(Object obj)
    {
        TimeVal timeval = (TimeVal)c.get(obj);
        if (timeval == null)
        {
            return null;
        } else
        {
            ((TimeVal)c.get(obj)).UpTime();
            return timeval.obj;
        }
    }

    public void remove(Object obj)
    {
        if (!c.containsKey(obj))
        {
            return;
        }
        if (f != null)
        {
            f.preRemoveCallback(obj, ((TimeVal)c.get(obj)).obj);
        }
        c.remove(obj);
    }

    public void setMaxSize(int i)
    {
        if (i > 0)
        {
            d = i;
        }
    }

    public void setPerDeleteSize(int i)
    {
        if (i > 0)
        {
            e = i;
        }
    }

    public int size()
    {
        return c.size();
    }

    public void update(Object obj, Object obj1)
    {
        if ((TimeVal)c.get(obj) == null)
        {
            obj1 = new TimeVal(obj1);
            c.put(obj, obj1);
            if (c.size() > d)
            {
                obj = new ArrayList(c.entrySet());
                Collections.sort(((java.util.List) (obj)), new _cls1());
                int i;
                if (e <= 0)
                {
                    int j = d / 10;
                    i = j;
                    if (j <= 0)
                    {
                        i = 1;
                    }
                } else
                {
                    i = e;
                }
                obj = ((ArrayList) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    remove(((java.util.Map.Entry)((Iterator) (obj)).next()).getKey());
                    i--;
                } while (i > 0);
            }
            return;
        } else
        {
            ((TimeVal)c.get(obj)).UpTime();
            ((TimeVal)c.get(obj)).obj = obj1;
            return;
        }
    }

    private class TimeVal
    {

        final LRUMap g;
        public Object obj;
        public Long t;

        public void UpTime()
        {
            t = Long.valueOf(System.currentTimeMillis());
        }

        public TimeVal(Object obj1)
        {
            g = LRUMap.this;
            super();
            obj = obj1;
            UpTime();
        }
    }


    private class OnClearListener
    {

        public abstract void onClear(Object obj, Object obj1);
    }


    private class PreRemoveCallback
    {

        public abstract void preRemoveCallback(Object obj, Object obj1);
    }


    private class _cls1
        implements Comparator
    {

        final LRUMap g;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((java.util.Map.Entry)obj, (java.util.Map.Entry)obj1);
        }

        public int compare(java.util.Map.Entry entry, java.util.Map.Entry entry1)
        {
            return ((TimeVal)entry.getValue()).t.compareTo(((TimeVal)entry1.getValue()).t);
        }

        _cls1()
        {
            g = LRUMap.this;
            super();
        }
    }

}
