// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Provider;
import org.roboguice.shaded.goole.common.base.Objects;

// Referenced classes of package com.google.inject.util:
//            Providers

private static class <init>
    implements Provider
{

    protected final javax.inject.Provider _flddelegate;

    public boolean equals(Object obj)
    {
        return (obj instanceof <init>) && Objects.equal(_flddelegate, ((delegate)obj)._flddelegate);
    }

    public Object get()
    {
        return _flddelegate.get();
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            _flddelegate
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("guicified(").append(_flddelegate).append(")").toString();
    }

    private (javax.inject.Provider provider)
    {
        _flddelegate = provider;
    }

    delegate(javax.inject.Provider provider, delegate delegate1)
    {
        this(provider);
    }
}
