// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaAction

public final class MoaActionList
    implements Serializable, Cloneable, List
{

    private static final long serialVersionUID = 0x13fe502bec0bc3bfL;
    protected List actions;

    protected MoaActionList()
    {
        actions = Collections.synchronizedList(new LinkedList());
    }

    protected MoaActionList(MoaAction moaaction)
    {
        this();
        add(moaaction);
    }

    public void add(int i, MoaAction moaaction)
    {
        actions.add(i, moaaction);
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (MoaAction)obj);
    }

    public boolean add(MoaAction moaaction)
    {
        return actions.add(moaaction);
    }

    public volatile boolean add(Object obj)
    {
        return add((MoaAction)obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        return actions.addAll(i, collection);
    }

    public boolean addAll(Collection collection)
    {
        return actions.addAll(collection);
    }

    public void clear()
    {
        actions.clear();
    }

    public Object clone()
    {
        Object obj = new MoaActionList();
        List list = actions;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator1 = actions.iterator();
_L1:
        boolean flag = iterator1.hasNext();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ((MoaActionList) (obj)).add((MoaAction)((MoaAction)iterator1.next()).clone());
          goto _L1
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        clonenotsupportedexception.printStackTrace();
          goto _L1
        obj;
        list;
        JVM INSTR monitorexit ;
        throw obj;
        list;
        JVM INSTR monitorexit ;
        return obj;
    }

    public boolean contains(Object obj)
    {
        return actions.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        return actions.containsAll(collection);
    }

    public MoaAction get(int i)
    {
        return (MoaAction)actions.get(i);
    }

    public MoaAction get(String s)
    {
label0:
        {
            MoaAction moaaction;
            synchronized (actions)
            {
                Iterator iterator1 = actions.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break label0;
                    }
                    moaaction = (MoaAction)iterator1.next();
                } while (!s.equals(moaaction.getName()));
            }
            return moaaction;
        }
        list;
        JVM INSTR monitorexit ;
        return null;
        s;
        list;
        JVM INSTR monitorexit ;
        throw s;
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public MoaAction[] getActions()
    {
        return (MoaAction[])toArray(new MoaAction[size()]);
    }

    public int indexOf(MoaAction moaaction)
    {
        return actions.indexOf(moaaction);
    }

    public int indexOf(Object obj)
    {
        return actions.indexOf(obj);
    }

    public boolean isEmpty()
    {
        return actions.isEmpty();
    }

    public Iterator iterator()
    {
        return actions.iterator();
    }

    public int lastIndexOf(Object obj)
    {
        return actions.lastIndexOf(obj);
    }

    public ListIterator listIterator()
    {
        return actions.listIterator();
    }

    public ListIterator listIterator(int i)
    {
        return actions.listIterator(i);
    }

    public MoaAction remove(int i)
    {
        return (MoaAction)actions.remove(i);
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public boolean remove(Object obj)
    {
        return actions.remove(obj);
    }

    public boolean removeAll(Collection collection)
    {
        return actions.removeAll(collection);
    }

    public boolean retainAll(Collection collection)
    {
        return false;
    }

    public MoaAction set(int i, MoaAction moaaction)
    {
        return (MoaAction)actions.set(i, moaaction);
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (MoaAction)obj);
    }

    public int size()
    {
        return actions.size();
    }

    public List subList(int i, int j)
    {
        return actions.subList(i, j);
    }

    public Object[] toArray()
    {
        return actions.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return actions.toArray(aobj);
    }
}
