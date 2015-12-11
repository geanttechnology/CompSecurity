// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

protected static class <init> extends Symbol
    implements Iterable
{

    public <init> flatten(Map map, Map map1)
    {
        <init> <init>2 = (<init>)map.get(this);
        <init> <init>1 = <init>2;
        if (<init>2 == null)
        {
            <init>1 = new <init>(new Symbol[flattenedSize()]);
            map.put(this, <init>1);
            Object obj = new ArrayList();
            map1.put(<init>1, obj);
            flatten(production, 0, <init>1.production, 0, map, map1);
            for (map = ((List) (obj)).iterator(); map.hasNext(); System.arraycopy(<init>1.production, 0, ((production) (obj)).bols, ((bols) (obj))., <init>1.production.length))
            {
                obj = (production)map.next();
            }

            map1.remove(<init>1);
        }
        return <init>1;
    }

    public volatile Symbol flatten(Map map, Map map1)
    {
        return flatten(map, map1);
    }

    public final int flattenedSize()
    {
        return flattenedSize(production, 0);
    }

    public Symbol get(int i)
    {
        return production[i];
    }

    public Iterator iterator()
    {
        return new Iterator() {

            private int pos;
            final Symbol.Sequence this$0;

            public boolean hasNext()
            {
                return pos > 0;
            }

            public Symbol next()
            {
                if (pos > 0)
                {
                    Symbol asymbol[] = production;
                    int i = pos - 1;
                    pos = i;
                    return asymbol[i];
                } else
                {
                    throw new NoSuchElementException();
                }
            }

            public volatile Object next()
            {
                return next();
            }

            public void remove()
            {
                throw new UnsupportedOperationException();
            }

            
            {
                this$0 = Symbol.Sequence.this;
                super();
                pos = production.length;
            }
        };
    }

    public int size()
    {
        return production.length;
    }

    private production(Symbol asymbol[])
    {
        super(ENCE, asymbol);
    }

    ENCE(Symbol asymbol[], ENCE ence)
    {
        this(asymbol);
    }
}
