// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import java.util.Comparator;

// Referenced classes of package dagger.internal.codegen:
//            GraphVisualizer

private static class <init>
    implements Comparator
{

    private String getStringForBinding(Binding binding)
    {
        if (binding == null)
        {
            return "";
        } else
        {
            return binding.toString();
        }
    }

    public int compare(Binding binding, Binding binding1)
    {
        return getStringForBinding(binding).compareTo(getStringForBinding(binding1));
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Binding)obj, (Binding)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
