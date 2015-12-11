// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class cyg
    implements Serializable
{

    public transient List a;
    private final List b;

    cyg(List list)
    {
        b = Collections.unmodifiableList(list);
        a();
    }

    private void a()
    {
        TreeSet treeset = new TreeSet();
        for (int i = 0; i < b.size(); i++)
        {
            cxw cxw1 = (cxw)b.get(i);
            treeset.addAll(cxw1.a.a);
            treeset.addAll(cxw1.a.b);
            treeset.addAll(cxw1.b.a);
        }

        a = Collections.unmodifiableList(new ArrayList(treeset));
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        objectinputstream.defaultReadObject();
        a();
    }

    public final List a(int i)
    {
        LinkedList linkedlist = new LinkedList();
        for (int j = 0; j < b.size(); j++)
        {
            linkedlist.add(((cxw)b.get(j)).a(i));
        }

        return linkedlist;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < b.size(); i++)
        {
            stringbuilder.append("[").append(((cxw)b.get(i)).toString()).append("]");
        }

        return stringbuilder.toString();
    }
}
