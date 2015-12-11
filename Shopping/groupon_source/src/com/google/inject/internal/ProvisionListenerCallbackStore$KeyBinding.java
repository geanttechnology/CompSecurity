// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.Key;

// Referenced classes of package com.google.inject.internal:
//            ProvisionListenerCallbackStore

private static class binding
{

    final Binding binding;
    final Key key;

    public boolean equals(Object obj)
    {
        return (obj instanceof binding) && key.equals(((key)obj).key);
    }

    public int hashCode()
    {
        return key.hashCode();
    }

    (Key key1, Binding binding1)
    {
        key = key1;
        binding = binding1;
    }
}
