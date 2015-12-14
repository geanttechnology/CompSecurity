// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package dagger.internal:
//            Binding, Linker

public final class SetBinding extends Binding
{

    private final Set contributors = new LinkedHashSet();

    public SetBinding(String s)
    {
        super(s, null, false, null);
    }

    public static void add(Map map, String s, Binding binding)
    {
        SetBinding setbinding1 = (SetBinding)map.get(s);
        SetBinding setbinding = setbinding1;
        if (setbinding1 == null)
        {
            setbinding = new SetBinding(s);
            map.put(setbinding.provideKey, setbinding);
        }
        setbinding.contributors.add(Linker.scope(binding));
    }

    public void attach(Linker linker)
    {
        for (Iterator iterator = contributors.iterator(); iterator.hasNext(); ((Binding)iterator.next()).attach(linker)) { }
    }

    public volatile Object get()
    {
        return get();
    }

    public Set get()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet(contributors.size());
        for (Iterator iterator = contributors.iterator(); iterator.hasNext(); linkedhashset.add(((Binding)iterator.next()).get())) { }
        return Collections.unmodifiableSet(linkedhashset);
    }

    public String toString()
    {
        return (new StringBuilder()).append("SetBinding").append(contributors).toString();
    }
}
